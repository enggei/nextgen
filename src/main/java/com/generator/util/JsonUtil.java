package com.generator.util;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.Map;

import static com.generator.util.JsonUtil.KEYS.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * goe on 7/3/16.
 */
public class JsonUtil {

	public enum KEYS {
		STATUS, DETAILS, CONTENT, VISITOR, PARAMS, API, MESSAGE, TYPE, FIELD, CONTEXT, HEADER, REQUIRED, ILLEGAL, MALFORMED, ERROR, REASON
	}

	public static boolean isTrue(JsonObject data, String key) {
		return data.getString(key) != null && Boolean.valueOf(data.getString(key));
	}

	public static boolean isFalse(JsonObject data, String key) {
		return data.getString(key) == null || !Boolean.valueOf(data.getString(key));
	}

	public static JsonObject newApiRequest(Class api, String visitor, JsonObject params) {
		return new JsonObject().put(API.name(), api.getName()).put(VISITOR.name(), visitor).put(PARAMS.name(), params);
	}

	public static String getMessage(JsonObject body) {
		return body.containsKey(MESSAGE.name()) ? body.getString(MESSAGE.name()) : null;
	}

	public static JsonObject newJsonObject(Object... kv) {
		final JsonObject content = new JsonObject();
		if (kv.length % 2 != 0)
			throw new IllegalArgumentException("Expecting key value PAIRS");

		for (int i = 0; i < kv.length; i += 2)
			content.put(kv[i].toString(), kv[i + 1]);

		return content;
	}

	public static JsonObject newFromMap(Map<String, Object> data) {
		JsonObject result = new JsonObject();
		data.entrySet().stream()
				.filter(e -> e.getValue() != null)
				.forEach(e -> result.put(e.getKey(), e.getValue()));

		return result;
	}

	public static JsonArray newJsonArray(Object... values) {
		final JsonArray array = new JsonArray();
		for (Object v : values)
			array.add(v);
		return array;
	}

	public static JsonObject success(JsonObject result, JsonObject content) {
		return result.
			put(STATUS.name(), OK.code()).
			put(TYPE.name(), OK.reasonPhrase()).
			put(CONTENT.name(), content);
	}

	public static JsonObject fail(JsonObject result, HttpResponseStatus status, final Throwable throwable) {
		return fail(result, status, newError(throwable.getMessage()));
	}

	public static JsonObject fail(JsonObject result, HttpResponseStatus status, JsonObject... cause) {

		result.
			put(STATUS.name(), status.code()).
			put(TYPE.name(), status.reasonPhrase());

		JsonArray details = new JsonArray();
		for (JsonObject aCause : cause) details.add(aCause);

		if (!details.isEmpty())
			result.put(DETAILS.name(), details);

		return result;
	}

	public static JsonObject newRequiredContext(String attributeName) {
		return new JsonObject().
			put(CONTEXT.name(), attributeName).
			put(REQUIRED.name(), true);
	}

	public static JsonObject newRequiredField(String attributeName) {
		return new JsonObject().
			put(FIELD.name(), attributeName).
			put(REQUIRED.name(), true);
	}

	public static JsonObject newIllegalParameter(String attributeName) {
		return new JsonObject().
			put(FIELD.name(), attributeName).
			put(ILLEGAL.name(), true);
	}

	public static JsonObject newRequiredHeader(String attributeName) {
		return new JsonObject().
			put(HEADER.name(), attributeName).
			put(REQUIRED.name(), true);
	}

	public static JsonObject newMalformedHeader(String attributeName) {
		return new JsonObject().
			put(HEADER.name(), attributeName).
			put(MALFORMED.name(), true);
	}

	public static JsonObject newReason(String reason) {
		return new JsonObject().
			put(REASON.name(), reason);
	}

	public static JsonObject newError(String error) {
		return new JsonObject().
			put(ERROR.name(), error);
	}

	public static JsonObject newJsonError(final int status, String type, final String message, final JsonArray details) {

		final JsonObject response = new JsonObject().
			put(STATUS.name(), status).
			put(TYPE.name(), type);

		if (message != null) {
			response.put(MESSAGE.name(), message);
		}

		if (details != null)
			response.put(DETAILS.name(), details);

		return response;
	}

	public static JsonObject error(JsonObject result, String error) {
		return result.put(ERROR.name(), error);
	}
}