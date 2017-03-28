package com.generator.util;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.generator.util.JsonUtil.*;
import static com.generator.util.JsonUtil.KEYS.DETAILS;
import static com.generator.util.JsonUtil.KEYS.STATUS;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

/**
 * goe on 6/16/16.
 */
public class VertxWebUtil {

	public static final DateTimeFormatter isoDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final String IF_MODIFIED_SINCE = "If-Modified-Since";

	// cache regexp-patterns (Pattern is immutable and thread-safe)
	private static final Map<String, Pattern> compiledPatterns = new ConcurrentHashMap<>();
	private static final String[] EMPTY_STRING_ARRAY = new String[0];

	public static void handleFail(RoutingContext routingContext) {
		Object message;
		switch (routingContext.statusCode()) {
			case 404:
				message = routingContext.get(NOT_FOUND.reasonPhrase());
				newErrorResponse(routingContext, NOT_FOUND,
					message != null && message instanceof String ? (String) message : routingContext.request().path());
				break;
			case 400:
				message = routingContext.get(BAD_REQUEST.reasonPhrase());
				newErrorResponse(routingContext, BAD_REQUEST,
					message != null && message instanceof String ? (String) message : routingContext.request().path(),
					routingContext.get(DETAILS.name()));
				break;
			case 401:
				message = routingContext.get(UNAUTHORIZED.reasonPhrase());
				newErrorResponse(routingContext, UNAUTHORIZED,
					message != null && message instanceof String ? (String) message : routingContext.request().path(),
					routingContext.get(DETAILS.name()));
				break;
			case 403:
				message = routingContext.get(FORBIDDEN.reasonPhrase());
				newErrorResponse(routingContext, FORBIDDEN,
					message != null && message instanceof String ? (String) message : routingContext.request().path(),
					routingContext.get(DETAILS.name()));
				break;
			case 409:
				message = routingContext.get(CONFLICT.reasonPhrase());
				newErrorResponse(routingContext, CONFLICT,
					message != null && message instanceof String ? (String) message : routingContext.request().path(),
					routingContext.get(DETAILS.name()));
				break;
			case 422:
				message = routingContext.get(UNPROCESSABLE_ENTITY.reasonPhrase());
				newErrorResponse(routingContext, UNPROCESSABLE_ENTITY,
					message != null && message instanceof String ? (String) message : routingContext.request().path(),
					routingContext.get(DETAILS.name()));
				break;
			case -1:
			case 500:
				final Throwable t = routingContext.failure();
				final String m = t != null ? t.getMessage() : null;
				newErrorResponse(routingContext, INTERNAL_SERVER_ERROR,
					(m != null ? m : t.getClass().getSimpleName()));
				break;
			default:
				routingContext.next();
				break;
		}
	}

	public static String debug(RoutingContext request) {
		final StringBuilder out = new StringBuilder();
		for (Map.Entry<String, String> param : request.request().params())
			out.append(param.getKey()).append("=").append(param.getValue()).append("\n");
		return request.request().uri() + " " + out.toString().trim();
	}

	public static void logRequest(Logger log, RoutingContext routingContext) {

		final StringBuilder headers = new StringBuilder();
		for (Map.Entry<String, String> headerEntry : routingContext.request().headers())
			headers.append(headerEntry.getKey()).append(":").append(headerEntry.getValue()).append("\n");

		log.info(routingContext.request().method() + " : " + routingContext.request().uri() + " headers " + headers);
	}

	public static boolean verifyRequiredFormAttribute(JsonObject data, String attributeName, RoutingContext routingContext, JsonArray errors) {
		if (tryToGetFormAttribute(data, attributeName, routingContext)) return true;
		errors.add(newRequiredField(attributeName));
		return false;
	}

	public static boolean verifyRequiredLongParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		if (!verifyLong(paramValue, errors)) return false;

		final Long value = Long.valueOf(paramValue);
		data.put(paramName, value);
		return true;
	}

	public static boolean verifyRequiredIntegerParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		if (!verifyInteger(paramValue, errors)) return false;

		final Integer value = Integer.valueOf(paramValue);
		data.put(paramName, value);
		return true;
	}

	public static boolean verifyRequiredDoubleParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		if (!verifyDouble(paramValue, errors)) return false;

		final Double value = Double.valueOf(paramValue);
		data.put(paramName, value);
		return true;
	}

	public static boolean verifyRequiredFloatParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		if (!verifyFloat(paramValue, errors)) return false;

		final Float value = Float.valueOf(paramValue);
		data.put(paramName, value);
		return true;
	}

	public static boolean verifyRequiredBooleanParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		if (!verifyBoolean(paramValue, errors)) return false;

		final Boolean value = Boolean.valueOf(paramValue);
		data.put(paramName, value);
		return true;
	}

	public static boolean verifyRequiredStringParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredParam(paramName, routingContext, errors)) return false;

		final String paramValue = routingContext.request().getParam(paramName);
		data.put(paramName, paramValue);
		return true;
	}

	public static boolean verifyRequiredStringHeader(JsonObject data, String headerName, RoutingContext routingContext, JsonArray errors) {
		if (!verifyRequiredHeader(headerName, routingContext, errors)) return false;

		final String headerValue = routingContext.request().getHeader(headerName);
		data.put(headerName, headerValue);
		return true;
	}

	public static boolean verifyRequiredParam(String paramName, RoutingContext routingContext, JsonArray errors) {
		if (!routingContext.request().params().contains(paramName)) {
			errors.add(newRequiredField(paramName));
			return false;
		}

		return true;
	}

	public static boolean verifyRequiredHeader(String headerName, RoutingContext routingContext, JsonArray errors) {
		if (!routingContext.request().headers().contains(headerName)) {
			errors.add(newRequiredHeader(headerName));
			return false;
		}

		return true;
	}

	public static boolean verifyRequiredUUIDParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		return verifyRequiredStringParam(data, paramName, routingContext, errors) && verifyUUID(data.getString(paramName), errors);
	}

	public static boolean verifyRequiredEmailParam(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		return verifyRequiredStringParam(data, paramName, routingContext, errors) && verifyEmail(data.getString(paramName), errors);
	}

	public static boolean verifyIsoDate(String date, JsonArray errors) {

		if (date == null) {
			errors.add(newError("missing date"));
			return false;
		}

		try {
			isoDateFormat.parse(date);
			return true;
		} catch (DateTimeParseException e) {
			errors.add(newError("illegal date format").
				put("expected", isoDateFormat.toString()).
				put("actual", date));
			return false;
		}
	}

	// todo: should this not contain JsonArray errors in ?
	public static boolean tryToGetContextObject(JsonObject data, String paramName, RoutingContext routingContext) {
		Object object = routingContext.get(paramName);
		if (object == null)
			return false;

		data.put(paramName, object);
		return true;
	}

	public static boolean verifyRequiredContextObject(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		Object object = routingContext.get(paramName);
		if (object == null) {
			errors.add(newRequiredContext(paramName));
			return false;
		}

		data.put(paramName, object);
		return true;
	}

	public static boolean verifyRequiredContextUUIDObject(JsonObject data, String paramName, RoutingContext routingContext, JsonArray errors) {
		return verifyRequiredContextObject(data, paramName, routingContext, errors) && verifyUUID(data.getString(paramName), errors);
	}

	public static LocalDate tryToParse(String date) {
		return LocalDate.parse(date, isoDateFormat);
	}

	public static boolean verifyDouble(String content, JsonArray errors) {
		return verifyFloat(content, errors);
	}

	public static boolean verifyFloat(String content, JsonArray errors) {
		if (!matchFloat(content)) {
			errors.add(newError("not a valid float " + content));
			return false;
		}

		return true;
	}

	public static boolean verifyBoolean(String content, JsonArray errors) {
		if (!matchBoolean(content)) {
			errors.add(newError("not a valid boolean " + content));
			return false;
		}

		return true;
	}

	public static boolean verifyLong(String content, JsonArray errors) {
		return verifyInteger(content, errors);
	}

	public static boolean verifyInteger(String content, JsonArray errors) {
		if (!matchInteger(content)) {
			errors.add(newError("not a valid integer " + content));
			return false;
		}

		return true;
	}

	public static boolean verifyUUID(String content, JsonArray errors) {
		if (!matchUUID(content)) {
			errors.add(newError("not a valid uuid '" + content + "'"));
			return false;
		}
		return true;
	}

	public static boolean verifyEmail(String content, JsonArray errors) {
		if (!matchEmail(content)) {
			errors.add(newError("not a valid email '" + content + "'"));
			return false;
		}
		return true;
	}

	public static boolean matchUUID(String content) {
		return match("\\A[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}\\Z", content, null).length == 1;
	}

	public static boolean matchEmail(String content) {
		return match("\\A[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})\\Z", content, null).length == 1;
	}

	public static boolean matchFloat(String content) {
		return match("\\A(-?)(\\d*[.])?\\d+\\Z", content, null).length == 1;
	}

	public static boolean matchBoolean(String content) {
		return match("\\A(true|false|1|0)\\Z", content, null).length == 1;
	}

	public static boolean matchInteger(String content) {
		return match("\\A(-?)\\d+\\Z", content, null).length == 1;
	}

	private static String[] match(String regexp, String content, Integer group) {

		if (content == null) return EMPTY_STRING_ARRAY;

		final Matcher matcher = getPattern(regexp).matcher(content);
		final List<String> matches = new LinkedList<>();
		while (matcher.find())
			matches.add(group == null ? matcher.group() : matcher.group(group));
		return matches.toArray(new String[matches.size()]);
	}

	private static Pattern getPattern(String regexp) {
		if (compiledPatterns.containsKey(regexp)) return compiledPatterns.get(regexp);
		compiledPatterns.put(regexp, Pattern.compile(regexp));
		return getPattern(regexp);
	}

	public static boolean verifyStringLength(String string, String attributeName, int minLength, int maxLength, JsonArray errors) {

		if (string == null) {
			errors.add(newError(attributeName + " is null"));
			return false;
		}

		if (minLength != Integer.MIN_VALUE && string.length() < minLength) {
			errors.add(newError(attributeName + " too short").
				put("min", minLength).
				put("actual", string.length()));
			return false;
		}

		if (maxLength != Integer.MAX_VALUE && string.length() > maxLength) {
			errors.add(newError(attributeName + " too long").
				put("max", maxLength).
				put("actual", string.length()));
			return false;
		}

		return true;
	}

	public static boolean tryToGetFormAttribute(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (routingContext.request().formAttributes().contains(attributeName)) {
			final String formAttribute = routingContext.request().getFormAttribute(attributeName);
			data.put(attributeName, formAttribute);
			return true;
		}
		return false;
	}

	public static boolean tryToGetBooleanFormAttribute(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (routingContext.request().formAttributes().contains(attributeName)) {
			final String formAttribute = routingContext.request().getFormAttribute(attributeName);
			if (matchBoolean(formAttribute)) {
				data.put(attributeName, Boolean.valueOf(formAttribute));
				return true;
			}
		}
		return false;
	}

	public static boolean tryToGetIntegerFormAttribute(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (routingContext.request().formAttributes().contains(attributeName)) {
			final String formAttribute = routingContext.request().getFormAttribute(attributeName);
			if (matchInteger(formAttribute)) {
				data.put(attributeName, Integer.valueOf(formAttribute));
				return true;
			}
		}
		return false;
	}

	public static boolean tryToGetParam(JsonObject data, Enum attributeName, RoutingContext routingContext) {
		return tryToGetParam(data, attributeName.name(), routingContext);
	}

	public static boolean tryToGetParam(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (routingContext.request().params().contains(attributeName)) {
			final String param = routingContext.request().getParam(attributeName);
			data.put(attributeName, param);
			return true;
		}
		return false;
	}

	public static boolean tryToGetDoubleParam(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (!routingContext.request().params().contains(attributeName))
			return false;

		final String paramValue = routingContext.request().getParam(attributeName);
		if (!matchFloat(paramValue)) return false;

		final Double value = Double.valueOf(paramValue);
		data.put(attributeName, value);

		return true;
	}

	public static boolean tryToGetBooleanParam(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (!routingContext.request().params().contains(attributeName))
			return false;

		final String paramValue = routingContext.request().getParam(attributeName);
		if (!matchBoolean(paramValue)) return false;

		final Boolean value = Boolean.valueOf(paramValue);
		data.put(attributeName, value);

		return true;
	}

	public static boolean tryToGetIntegerParam(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (!routingContext.request().params().contains(attributeName))
			return false;

		final String paramValue = routingContext.request().getParam(attributeName);
		if (!matchInteger(paramValue)) return false;

		final Integer value = Integer.valueOf(paramValue);
		data.put(attributeName, value);

		return true;
	}

	public static boolean tryToGetLongParam(JsonObject data, String attributeName, RoutingContext routingContext) {
		if (!routingContext.request().params().contains(attributeName))
			return false;

		final String paramValue = routingContext.request().getParam(attributeName);
		try {
			final Long value = Long.valueOf(paramValue);
			data.put(attributeName, value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	public static boolean tryToGetHeader(JsonObject data, String headerName, RoutingContext routingContext) {
		if (routingContext.request().headers().contains(headerName)) {
			final String header = routingContext.request().getHeader(headerName);
			data.put(headerName, header);
			return true;
		}
		return false;
	}

	public static void httpRedirectTemporary(RoutingContext context, String redirectURI) {
		context.response()
			.setStatusCode(303)
			.putHeader("Location", redirectURI)
			.putHeader("Content-Type", "application/x-www-form-urlencoded")
			.end();
	}

	public static String buildPathParams(Map<String, String> map) {
		String path = map.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
		if (path != null && !path.isEmpty()) {
			return "?" + path;
		} else {
			return "";
		}
	}


	public static HttpServerResponse newJsonResponse(RoutingContext routingContext, HttpResponseStatus status, JsonObject content) {
		final HttpServerResponse response = routingContext.response();

		final Buffer buffer = Buffer.buffer(content.encode());

		response.setStatusCode(status.code()).
			putHeader("Content-Length", Integer.toString(buffer.length())).
			putHeader("Content-Type", "application/json; charset=utf-8").
			write(buffer).
			end();

		return response;
	}

	public static HttpServerResponse newHtmlResponse(RoutingContext routingContext, HttpResponseStatus status, String content) {
		final HttpServerResponse response = routingContext.response();

		try {
			final Buffer buffer = Buffer.buffer(content.getBytes("UTF-8"));

			response.setStatusCode(status.code()).
				putHeader("Content-Length", Integer.toString(buffer.length())).
				putHeader("Content-Type", "text/html; charset=utf-8").
				write(buffer).
				end();

		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("never happens: " + e.getMessage(), e);
		}

		return response;
	}

	public static Integer getStatus(JsonObject result) {
		final Integer status = result.getInteger(STATUS.name());
		if (status == null)
			throw new IllegalStateException(STATUS + " not contained in result: " + result.encode());
		return status;
	}

	public static void newErrorIllegalMethodResponse(RoutingContext routingContext) {
		newErrorResponse(routingContext, HttpResponseStatus.BAD_REQUEST, "Illegal method " + routingContext.request().method().toString());
	}

	public static void newErrorResponse(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, final String message) {
		newErrorResponse(routingContext, httpResponseStatus, message, null);
	}

	public static void newErrorResponse(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, final String message, final JsonArray details) {
		newJsonResponse(routingContext, httpResponseStatus, newJsonError(httpResponseStatus.code(), httpResponseStatus.reasonPhrase(), message, details)).
			setStatusCode(httpResponseStatus.code());
	}

	public static boolean tryToGetCacheHeader(JsonObject data, RoutingContext routingContext, JsonArray errors) {
		if (!tryToGetHeader(data, IF_MODIFIED_SINCE, routingContext))
			return false;

		try {
			ZonedDateTime ifModifiedSince = FormatUtil.parseHTTPDateTime(data.getString(IF_MODIFIED_SINCE));
			routingContext.put(IF_MODIFIED_SINCE, ifModifiedSince);
			return true;

		} catch (DateTimeParseException e) {
			errors.add(newError("not a valid rfc 1123 date/time '" + e.getMessage() + "'"));
		}

		return false;
	}
}