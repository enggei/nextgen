package com.generator.generators.raml;

import com.generator.util.FileUtil;

import java.io.File;

import static java.lang.Integer.MAX_VALUE;

/**
 * goe on 6/30/16.
 */
public class APIGenerator {

	public static final String REGEX_UUID = "^[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}$";

	public static void main(String[] args) {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		new APIGenerator().generateRamlFile();
		System.out.println("completed");
		System.exit(0);
	}

	private final RamlGroup group = new RamlGroup();


	public void generateRamlFile() {

		// http://raml.org/developers/raml-100-tutorial#enter-uri-parameters
		// https://github.com/raml-org/raml-spec/blob/master/versions/raml-08/raml-08.md
		// http://www.baeldung.com/raml-restful-api-modeling-language-tutorial  see 6. RAML tools

		final RamlGroup.fileST loopsi = group.newfile().
			setTitle("Loopsi REST API").
			setBaseUri("https://localhost:8080/api").
			setHttp(false).
			setHttps(true).
			setVersion("v1");

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/version").

			addActionsValue(newGET("returns current APP version.",
				"400", "404").
				addResponsesValue(newjsonResponse("Versions response",
					newResponseProperty("versionId", "string", true),
					newResponseProperty("description", "string", true),
					newResponseProperty("releaseDate", "string", true)))).

			addActionsValue(newPOST(
				"receives APP version ID from client and returns whether it matches the current version.",
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("versionId").setDescription("APP version.").setRequired(true).setMaxLength(40).setMinLength(0).setExample("0.8")),
				"400", "404", "500").
				addResponsesValue(newjsonResponse("Version response",
					newResponseProperty("success", "boolean", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/login").

			addActionsValue(newPOST("user login",
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
					addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(false).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")),
				"400", "401").
				addResponsesValue(newjsonResponse("User logon confirmation",
					newResponseProperty("loginToken", "string", true),
					newResponseProperty("currencyTotal", "integer", true),
					newResponseProperty("loginTokenExpiry", "integer", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user").

				addActionsValue(newPOST("register new user",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(false).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")).
						addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
						addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
						addFormParamsValue(group.newstringParam().setName("fbToken").setDescription("user facebook token").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thesocialtoken")).
						addFormParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")),
					"400", "403", "404", "409", "500").
					addResponsesValue(newjsonResponse("User confirmation",
						newResponseProperty("userId", "string", false),
						newResponseProperty("username", "string", true)))).

				addActionsValue(newGET("register a temporary user",
					group.newqueryParams().
						addQueryParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE)),
					"400").
					addResponsesValue(newjsonResponse("Temporary userId",
						newResponseProperty("userId", "string", true)))).

				addActionsValue(group.newuriParameter().
					setName("userId").

					addActionsValue(newDELETE("delete user",
						"400", "403", "404", "409", "500").
						addResponsesValue(newjsonResponse("User delete confirmation",
							newResponseProperty("userId", "string", true)))).

					addActionsValue(newPUT("update user",
						group.newformBody().setMultipart(true).
							addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
							addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(false).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")).
							addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
							addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
							addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
							addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))?)?$").setExample("2014-08-18")).
							addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
							addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
							addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
							addFormParamsValue(group.newfileParam().setName("avatar").setDescription("user avatar").setRequired(false)).
							addFormParamsValue(group.newstringParam().setName("fbToken").setDescription("user facebook token").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thesocialtoken")).
							addFormParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")),
						"400", "403", "404", "409", "500").
						addResponsesValue(newjsonResponse("User confirmation",
							newResponseProperty("userId", "string", true)))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/currency").

				addActionsValue(newGET("list of virtual currency entries",
					"400", "403", "404", "500").
						addResponsesValue(newjsonResponse("list of currency entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newPOST("add a virtual currency item",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true)).
						addFormParamsValue(group.newintegerParam().setName("currencyValue").setDescription("integer").setRequired(true).setExample("350")).
						addFormParamsValue(group.newstringParam().setName("transactionType").setDescription("to be determined").setRequired(false).setExample("thetype")).
						addFormParamsValue(newUUIDParam().setName("gameId").setDescription("uuid").setRequired(true)),
					"400", "403", "404", "500").
					addResponsesValue(newjsonResponse("Added currency confirmation",
						newResponseProperty("currencyId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/currency").

			addActionsValue(newGET("returns user currency value.",
				"400", "404").
				addResponsesValue(newjsonResponse("Currency response",
					newResponseProperty("currentValue", "integer", true),
					newResponseProperty("dummy", "boolean", false)))).

			addActionsValue(newPOST("add currency activity to user's ledger",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("currencyId").setDescription("currency id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("cinemaId").setDescription("cinema id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("redemtionId").setDescription("redemtion id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true)).
						addFormParamsValue(group.newstringParam().setName("latitude").setDescription("latitude").setRequired(false)).
						addFormParamsValue(group.newstringParam().setName("longitude").setDescription("longitude").setRequired(false)),
					"400", "403", "404", "500").
					addResponsesValue(newjsonResponse("Added currency activity confirmation",
						newResponseProperty("activityId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/badges/earned").

			addActionsValue(newGET("returns user badges earned.",
				"400", "404").
				addResponsesValue(newjsonResponse("Badges response",
					newResponseProperty("badges", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/badges/available").

			addActionsValue(newGET("returns user badges available.",
				"400", "404").
				addResponsesValue(newjsonResponse("Badges response",
					newResponseProperty("badges", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/redemption").

			addActionsValue(newGET("returns relevant redemption offers.",
				"400", "404").
				addResponsesValue(newjsonResponse("Redemptions response",
					newResponseProperty("redemptions", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/engagement").

			addActionsValue(newGET("returns user engagement activities.",
				"400", "404").
				addResponsesValue(newjsonResponse("Engagements response",
					newResponseProperty("engagements", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/films/latest").

			addActionsValue(newGET("returns film listings by cinema.",
				group.newqueryParams().
					addQueryParamsValue(group.newstringParam().setName("cinemaId").setRequired(true).setDescription("UUID").setExample("55b4e376-9bf7-429c-92b9-5b5db922ea25")),
				"400", "404").
				addResponsesValue(newjsonResponse("Films response",
					newResponseProperty("films", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/cinema/listing").

			addActionsValue(newGET("returns cinema listing.",
				"400", "404").
				addResponsesValue(newjsonResponse("Cinemas response",
					newResponseProperty("cinemas", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/trailers").

			addActionsValue(newGET("returns trailers and ratings.",
				"400", "404").
				addResponsesValue(newjsonResponse("Trailers response",
					newResponseProperty("trailers", "array", true),
					newResponseProperty("dummy", "boolean", false)))));

		FileUtil.write(loopsi, new File("/home/sogern/projects/unique/loopsi/src/main/web/api/loopsi/loopsi.raml"));
	}

	private RamlGroup.stringParamST newUUIDParam() {
		return group.newstringParam().
			setMaxLength(36).
			setMinLength(36).
			setPattern(REGEX_UUID).
			setExample("8aab2fa7-0280-4571-a410-15b7cd21dee7");
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.postActionST actionST = group.newpostAction().
			setDescription(description).
			setBody(body).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		return newPOST(description, null, body, errorCodes);
	}

	private RamlGroup.getActionST newGET(String description, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.getActionST actionST = group.newgetAction().
			setDescription(description).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.getActionST newGET(String description, String... errorCodes) {
		return newGET(description, null, errorCodes);
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.putActionST actionST = group.newputAction().
			setDescription(description).
			setBody(body).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		return newPUT(description, null, body, errorCodes);
	}

	private RamlGroup.deleteActionST newDELETE(String description, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.deleteActionST actionST = group.newdeleteAction().
			setDescription(description).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.deleteActionST newDELETE(String description, String... errorCodes) {
		return newDELETE(description, null, errorCodes);
	}

	private RamlGroup.errorResponseST error(String code, String description) {
		return group.newerrorResponse().
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

	private RamlGroup.jsonResponseST newjsonResponse(String schemaDescription, ResponseProperty... properties) {
		final RamlGroup.jsonResponseST jsonResponseST = group.newjsonResponse().
			setSchemaDescription(schemaDescription);
		for (ResponseProperty property : properties) {
			jsonResponseST.addPropertiesValue(property.name, property.type);
			if (property.required) jsonResponseST.addRequiredValue(property.name);
		}
		return jsonResponseST;
	}

	private RamlGroup.integerParamST newIntegerParam(String name, String description, int minimum, int maximum) {
		return group.newintegerParam().
			setName(name).
			setDescription(description).
			setMinimum(minimum == Integer.MIN_VALUE ? null : minimum).
			setMaximum(maximum == Integer.MAX_VALUE ? null : maximum);
	}

	private RamlGroup.booleanParamST newbooleanParam(String name, String description, boolean required) {
		return group.newbooleanParam().
			setName(name).
			setDescription(description).
			setRequired(required);
	}

	private ResponseProperty newResponseProperty(String name, String type, boolean required) {
		return new ResponseProperty(name, type, required);
	}

	private final class ResponseProperty {
		final String name;
		final String type;
		final boolean required;

		ResponseProperty(String name, String type, boolean required) {
			this.name = name;
			this.type = type;
			this.required = required;
		}
	}
}
