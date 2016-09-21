package com.generator.generators.raml;

import com.generator.generators.loopsi.LoopsiGroup;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * goe on 9/10/16.
 */
public class Domain {

	public static final String REGEX_UUID = "^[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}$";
	public static final String REGEX_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String REGEX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";

	protected final RamlGroup ramlGroup = new RamlGroup();
	protected final LoopsiGroup loopsiGroup = new LoopsiGroup();



	RamlGroup.fileST newRamlTemplate() {
		return ramlGroup.newfile().
			setTitle("Loopsi REST API").
			setBaseUri("https://localhost:8080/api").
			setHttp(false).
			setHttps(true).
			setVersion("v1");
	}

	abstract class Param {

		final String name;
		final boolean isRequired;
		final String description;

		String exampleValue;

		Param(String name, boolean isRequired, String description, String exampleValue) {
			this.name = name;
			this.isRequired = isRequired;
			this.description = description;
			this.exampleValue = exampleValue;
		}

		// convenience method
		RamlGroup.stringParamST asStringParam() {
			final RamlGroup.stringParamST stringParamST = ramlGroup.newstringParam().
				setName(name).
				setDescription(description).
				setRequired(isRequired);

			if (exampleValue != null && exampleValue.length() > 0)
				stringParamST.setExample(exampleValue);

			return stringParamST;
		}

		abstract RamlGroup.RamlGroupTemplate asRaml();
	}

	class UUIDParam extends Param {

		UUIDParam(String name, String description, boolean isRequired, UUID exampleValue) {
			super(name, isRequired, description, exampleValue.toString());
		}

		UUIDParam(String name, String description, boolean isRequired) {
			this(name, description, isRequired, UUID.randomUUID());   // example-value is random by default, but can be changed by "setExample(String exampleValue)"
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return asStringParam().
				setMaxLength(36).
				setMinLength(36).
				setPattern(REGEX_UUID);
		}
	}

	class UserIdParam extends UUIDParam {

		UserIdParam(boolean isRequired) {
			super("userId", "the user id", isRequired, UUID.randomUUID());
		}
	}

	class EmailParam extends Param {

		EmailParam(String name, String description, boolean isRequired, String exampleValue) {
			super(name, isRequired, description, exampleValue);
		}

		EmailParam(String name, String description, boolean isRequired) {
			this(name, description, isRequired, "email@domain.com");
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return asStringParam().
				setMaxLength(100).
				setMinLength(6).
				setPattern(REGEX_EMAIL);
		}
	}

	class EnumParam extends Param {

		final String[] enumValues;

		EnumParam(String name, String description, boolean isRequired, String... enumValues) {
			super(name, isRequired, description, enumValues[0]);
			this.enumValues = enumValues;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			final RamlGroup.stringParamST stringParamST = asStringParam();
			for (String enumValue : enumValues)
				stringParamST.addEnumsValue(enumValue);
			return stringParamST;
		}
	}

	class DateParam extends Param {

		DateParam(String name, String description, boolean isRequired, String exampleValue) {
			super(name, isRequired, description, exampleValue);
		}

		DateParam(String name, String description, boolean isRequired) {
			this(name, description, isRequired, "2016-09-05");
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return asStringParam().
				setMinLength(10).
				setMaxLength(10).
				setPattern(REGEX_DATE);
		}
	}

	class FileParam extends Param {

		FileParam(String name, String description, boolean isRequired) {
			super(name, isRequired, description, null);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newfileParam().
				setName(name).
				setDescription(description).
				setRequired(isRequired);
		}
	}

	class BooleanParam extends Param {

		final boolean defaultValue;

		BooleanParam(String name, String description, boolean isRequired, boolean defaultValue) {
			super(name, isRequired, description, Boolean.TRUE.toString());
			this.defaultValue = defaultValue;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newbooleanParam().
				setName(name).
				setDescription(description).
				setDefaultValue(defaultValue).
				setRequired(isRequired);
		}
	}

	class StringParam extends Param {

		Integer minLength = null;
		Integer maxLength = null;

		StringParam(String name, String description, boolean isRequired, String exampleValue, Integer minLength, Integer maxLength) {
			super(name, isRequired, description, exampleValue);
			this.minLength = minLength;
			this.maxLength = maxLength;
		}

		StringParam(String name, String description, boolean isRequired, Integer minLength, Integer maxLength, String exampleValue) {
			super(name, isRequired, description, exampleValue);
			this.minLength = minLength;
			this.maxLength = maxLength;
		}

		StringParam(String name, String description, boolean isRequired, Integer minLength, Integer maxLength) {
			super(name, isRequired, description, "exampleValue");
			this.minLength = minLength;
			this.maxLength = maxLength;
		}

		StringParam(String name, String description, boolean isRequired, String exampleValue) {
			super(name, isRequired, description, exampleValue);
		}

		StringParam(String name, String description, boolean isRequired) {
			this(name, description, isRequired, "exampleValue");
		}

		StringParam setMaxLength(Integer value) {
			this.maxLength = value;
			return this;
		}

		StringParam setMinLength(Integer value) {
			this.minLength = value;
			return this;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return asStringParam().
				setMinLength(minLength).
				setMaxLength(maxLength);
		}
	}

	class IntegerParam extends Param {

		Integer minimum = MIN_VALUE;
		Integer maximum = MAX_VALUE;

		IntegerParam(String name, String description, Integer minimum, Integer maximum, boolean isRequired) {
			super(name, isRequired, description, minimum + "");
			this.minimum = minimum;
			this.maximum = maximum;
		}

		IntegerParam(String name, String description, boolean isRequired, Integer exampleValue) {
			super(name, isRequired, description, exampleValue + "");
		}

		IntegerParam(String name, String description, boolean isRequired) {
			super(name, isRequired, description, "350");
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newintegerParam().
				setName(name).
				setExample(exampleValue).
				setRequired(isRequired).
				setDescription(description).
				setMinimum(minimum == Integer.MIN_VALUE ? null : minimum).
				setMaximum(maximum == Integer.MAX_VALUE ? null : maximum);
		}
	}

	class NumberParam extends Param {

		Integer minimum = MIN_VALUE;
		Integer maximum = MAX_VALUE;

		NumberParam(String name, String description, Integer minimum, Integer maximum, boolean isRequired, Number example) {
			super(name, isRequired, description, example + "");
			this.minimum = minimum;
			this.maximum = maximum;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newnumberParam().
				setName(name).
				setExample(exampleValue).
				setRequired(isRequired).
				setDescription(description).
				setMinimum(minimum == Integer.MIN_VALUE ? null : minimum).
				setMaximum(maximum == Integer.MAX_VALUE ? null : maximum);
		}
	}

	class LatitudeParam extends NumberParam {

		LatitudeParam(boolean isRequired) {
			super("latitude", "latitude", -90, 90, isRequired, 53.482133d);
		}
	}

	class LongitudeParam extends NumberParam {

		LongitudeParam(boolean isRequired) {
			super("longitude", "longitude", -180, 180, isRequired, -2.242445d);
		}
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.postActionST actionST = ramlGroup.newpostAction().
			setDescription(description).
			setHeaders(headers).
			setBody(body).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.headerParamsST headers, RamlGroup.formBodyST body, String... errorCodes) {
		return newPOST(description, headers, null, body, errorCodes);
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.headerParamsST headers, String... errorCodes) {
		return newPOST(description, headers, null, null, errorCodes);
	}

	private RamlGroup.getActionST newGET(String description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.getActionST actionST = ramlGroup.newgetAction().
			setDescription(description).
			setHeaders(headers).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.getActionST newGET(String description, RamlGroup.headerParamsST headers, String... errorCodes) {
		return newGET(description, headers, null, errorCodes);
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.putActionST actionST = ramlGroup.newputAction().
			setDescription(description).
			setHeaders(headers).
			setBody(body).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.headerParamsST headers, RamlGroup.formBodyST body, String... errorCodes) {
		return newPUT(description, headers, null, body, errorCodes);
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.headerParamsST headers, String... errorCodes) {
		return newPUT(description, headers, null, null, errorCodes);
	}

	private RamlGroup.deleteActionST newDELETE(String description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.deleteActionST actionST = ramlGroup.newdeleteAction().
			setDescription(description).
			setHeaders(headers).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.deleteActionST newDELETE(String description, RamlGroup.headerParamsST headers, String... errorCodes) {
		return newDELETE(description, headers, null, errorCodes);
	}

	private RamlGroup.errorResponseST error(String code, String description) {
		return ramlGroup.newerrorResponse().
			setCode(code).
			setDescription(description);
	}

	private String getErrorDescription(String errorCode) {
		switch (errorCode) {
			case "400":
				return "Bad Request";
			case "401":
				return "Unauthorized";
			case "403":
				return "Forbidden";
			case "404":
				return "Not Found";
			case "409":
				return "Conflict";
			case "422":
				return "Unprocessable Entity";
			case "500":
				return "Internal Server Error";
			default:
				throw new IllegalArgumentException("unsupported error code: " + errorCode);
		}
	}

	private RamlGroup.jsonResponseST newJsonResponse(String schemaDescription, JsonResponseProperty... properties) {
		final RamlGroup.jsonResponseST jsonResponseST = ramlGroup.newjsonResponse().
			setSchemaDescription(schemaDescription);
		for (JsonResponseProperty property : properties) {
			jsonResponseST.addPropertiesValue(property.name, property.type);
			if (property.required) jsonResponseST.addRequiredValue(property.name);
		}
		return jsonResponseST;
	}

	// test api definition: (this defines more than endpoints, but visitors, admin-modules(js and html) etc.

	final class APIBuilder {

		String name;
		final Set<Endpoint> endpoints = new LinkedHashSet<>();

		APIBuilder setName(String name) {
			this.name = name;
			return this;
		}

		APIBuilder addEndpoint(Endpoint endpoint) {
			this.endpoints.add(endpoint);
			return this;
		}

		APIBuilder addToRAML(RamlGroup.fileST loopsi) {
			for (Endpoint endpoint : endpoints)
				loopsi.addEndpointsValue(endpoint.asRaml());
			return this;
		}
	}

	final class Endpoint {

		final String uri;
		final Set<HttpAction> actions = new LinkedHashSet<>();

		Endpoint(String uri) {
			this.uri = uri;
		}

		RamlGroup.RamlGroupTemplate asRaml() {

			final RamlGroup.endpointST endpointST = ramlGroup.newendpoint().
				setUri(uri);

			for (HttpAction action : actions)
				endpointST.addActionsValue(action.asRaml());

			return endpointST;
		}

		Endpoint addAction(HttpAction action) {
			this.actions.add(action);
			return this;
		}
	}

	final class URIParameterAction extends HttpAction {

		final String name;
		final Set<HttpAction> actions = new LinkedHashSet<>();

		URIParameterAction(String name, String description) {
			super(description);
			this.name = name;
		}

		URIParameterAction addAction(HttpAction action) {
			this.actions.add(action);
			return this;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {

			final RamlGroup.uriParameterST uriParameterST = ramlGroup.newuriParameter().
				setName(name);

			for (HttpAction action : actions)
				uriParameterST.addActionsValue(action.asRaml());

			return uriParameterST;
		}
	}

	enum AuthType {
		NO_AUTHORIZATION, OAUTH2_CLIENT_CREDENTIALS, OAUTH2_CLIENT_ACCESS_TOKEN, OAUTH2_USER_ACCESS_TOKEN
	}

	abstract class HttpAction {

		public static final String AUTHORIZATION = "Authorization";

		final String description;
		final Set<String> errorCodes = new LinkedHashSet<String>() {{
			add("400");
			add("401");
			add("404");
			add("500");
		}};

		final Set<Response> responseValues = new LinkedHashSet<>();
		final Set<HttpHeader> headerValues = new LinkedHashSet<>();
		final Set<Param> params = new LinkedHashSet<>();

		HttpAction(String description) {
			this(description, AuthType.NO_AUTHORIZATION);
		}

		HttpAction(String description, AuthType authType) {
			this.description = description;

			switch (authType) {
				case OAUTH2_CLIENT_CREDENTIALS:
					headerValues.add(new HttpHeader(AUTHORIZATION, "OAuth2 client credentials", true, "Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3"));
					break;
				case OAUTH2_CLIENT_ACCESS_TOKEN:
					headerValues.add(new HttpHeader(AUTHORIZATION, "OAuth2 CLIENT access_token", true, "Bearer 4oe2Xr+yyLegIb4aubmQzu"));
					break;
				case OAUTH2_USER_ACCESS_TOKEN:
					headerValues.add(new HttpHeader(AUTHORIZATION, "OAuth2 USER access_token", true, "Bearer GtDkhank!OLQoep2ThB857"));
					break;
				default:
					break;
			}
		}

		HttpAction addErrorCode(String errorCode) {
			this.errorCodes.add(errorCode);
			return this;
		}

		HttpAction setErrorCodes(String... errorCodes) {
			this.errorCodes.clear();
			this.errorCodes.addAll(Arrays.asList(errorCodes));
			return this;
		}

		HttpAction addResponseValue(Response response) {
			responseValues.add(response);
			return this;
		}

		HttpAction addHeaderValue(HttpHeader httpHeader) {
			headerValues.add(httpHeader);
			return this;
		}

		HttpAction addQueryParam(Param param) {
			this.params.add(param);
			return this;
		}

		// convenience method
		String[] errorCodes() {
			return errorCodes.toArray(new String[errorCodes.size()]);
		}

		// convenience method
		RamlGroup.headerParamsST getHeaderParamsST() {
			if (headerValues.isEmpty()) return null;
			final RamlGroup.headerParamsST headerParamsST = ramlGroup.newheaderParams();
			for (HttpHeader headerValue : headerValues)
				headerParamsST.addHeaderParamsValue(headerValue.asRaml());
			return headerParamsST;
		}

		// convenience method
		RamlGroup.queryParamsST getQueryParamsST() {
			if (params.isEmpty()) return null;
			final RamlGroup.queryParamsST queryParamsST = ramlGroup.newqueryParams();
			for (Param param : params)
				queryParamsST.addQueryParamsValue(param.asRaml());
			return queryParamsST;
		}

		abstract RamlGroup.RamlGroupTemplate asRaml();
	}

	class GetAction extends HttpAction {

		GetAction(String description) {
			super(description, AuthType.NO_AUTHORIZATION);
		}

		GetAction(String description, AuthType authType) {
			super(description, authType);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			final RamlGroup.headerParamsST headerParamsST = getHeaderParamsST();
			final RamlGroup.queryParamsST queryParamsST = getQueryParamsST();
			final RamlGroup.getActionST actionST = queryParamsST == null ? newGET(description, headerParamsST, errorCodes()) : newGET(description, headerParamsST, queryParamsST, errorCodes());
			for (Response responseValue : responseValues)
				actionST.addResponsesValue(responseValue.asRaml());
			return actionST;
		}
	}

	class DeleteAction extends HttpAction {

		DeleteAction(String description) {
			super(description, AuthType.NO_AUTHORIZATION);
		}

		DeleteAction(String description, AuthType authType) {
			super(description, authType);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			final RamlGroup.headerParamsST headerParamsST = getHeaderParamsST();
			final RamlGroup.queryParamsST queryParamsST = getQueryParamsST();
			final RamlGroup.deleteActionST actionST = queryParamsST == null ? newDELETE(description, headerParamsST, errorCodes()) : newDELETE(description, headerParamsST, queryParamsST, errorCodes());
			for (Response responseValue : responseValues)
				actionST.addResponsesValue(responseValue.asRaml());
			return actionST;
		}
	}

	class PutAction extends PostAction {

		PutAction(String description) {
			super(description, AuthType.NO_AUTHORIZATION);
		}

		PutAction(String description, AuthType authType) {
			super(description, authType);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			final RamlGroup.headerParamsST headerParamsST = getHeaderParamsST();
			final RamlGroup.queryParamsST queryParamsST = getQueryParamsST();
			final RamlGroup.formBodyST formParamST = getFormBodyST();
			final RamlGroup.putActionST actionST = queryParamsST == null ? (formParamST == null ? newPUT(description, headerParamsST, errorCodes()) : newPUT(description, headerParamsST, formParamST, errorCodes())) : newPUT(description, headerParamsST, queryParamsST, formParamST, errorCodes());
			for (Response responseValue : responseValues)
				actionST.addResponsesValue(responseValue.asRaml());
			return actionST;
		}
	}

	class PostAction extends HttpAction {

		final Set<Param> formParam = new LinkedHashSet<>();
		boolean isMultipart = false;

		PostAction(String description) {
			super(description, AuthType.NO_AUTHORIZATION);
		}

		PostAction(String description, AuthType authType) {
			super(description, authType);
		}

		PostAction addFormParam(Param param) {
			this.formParam.add(param);
			return this;
		}

		RamlGroup.formBodyST getFormBodyST() {
			if (formParam.isEmpty()) return null;

			final RamlGroup.formBodyST formParamST = ramlGroup.newformBody().
				setMultipart(isMultipart);

			for (Param param : formParam)
				formParamST.addFormParamsValue(param.asRaml());
			return formParamST;
		}

		PostAction setMultipart(boolean isMultipart) {
			this.isMultipart = isMultipart;
			return this;
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			final RamlGroup.headerParamsST headerParamsST = getHeaderParamsST();
			final RamlGroup.queryParamsST queryParamsST = getQueryParamsST();
			final RamlGroup.formBodyST formParamST = getFormBodyST();
			final RamlGroup.postActionST actionST = queryParamsST == null ? (formParamST == null ? newPOST(description, headerParamsST, errorCodes()) : newPOST(description, headerParamsST, formParamST, errorCodes())) : newPOST(description, headerParamsST, queryParamsST, formParamST, errorCodes());
			for (Response responseValue : responseValues)
				actionST.addResponsesValue(responseValue.asRaml());
			return actionST;
		}
	}

	class HttpHeader {

		final String name;
		final String description;
		final boolean required;
		final String example;

		HttpHeader(String name, String description, boolean required, String example) {
			this.name = name;
			this.description = description;
			this.required = required;
			this.example = example;
		}

		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newheader().
				setName(name).
				setDescription(description).
				setRequired(required).
				setExample(example);
		}
	}

	abstract class Response {

		final String description;

		Response(String description) {
			this.description = description;
		}

		abstract RamlGroup.RamlGroupTemplate asRaml();
	}

	class HtmlResponse extends Response {

		HtmlResponse(String description) {
			super(description);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newbinaryResponse().
				setContentType("text/html");
		}
	}

	class ImageResponse extends Response {

		ImageResponse(String description) {
			super(description);
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return ramlGroup.newbinaryResponse().
				setContentType("image/png");
		}
	}

	class JsonResponse extends Response {

		final Set<JsonResponseProperty> responseProperties = new LinkedHashSet<>();

		JsonResponse(String description, JsonResponseProperty... responseproperties) {
			super(description);
			this.responseProperties.addAll(Arrays.asList(responseproperties));
		}

		@Override
		RamlGroup.RamlGroupTemplate asRaml() {
			return newJsonResponse(description, responseProperties.toArray(new JsonResponseProperty[responseProperties.size()]));
		}
	}

	final class JsonResponseProperty {
		final String name;
		final String type;
		final boolean required;

		JsonResponseProperty(String name, String type, boolean required) {
			this.name = name;
			this.type = type;
			this.required = required;
		}
	}
}