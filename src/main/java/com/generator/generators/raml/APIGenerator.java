package com.generator.generators.raml;

import com.generator.util.FileUtil;

import java.io.File;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;

/**
 * goe on 6/30/16.
 */
public class APIGenerator {

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
			setBaseUri("http://localhost:8080/api").
			setHttp(true).
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
				setUri("/user").
				addActionsValue(newPOST("create new user",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(true).setMaxLength(254).setMinLength(0).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, B64encoded").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(8).setExample("thepassword")).
						addFormParamsValue(group.newbooleanParam().setName("TempUser").setDescription("if user is temporary, no userinfo required").setRequired(true).setDefaultValue("true")).
						addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
						addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))?)?$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("options").setDescription("sex").setRequired(false).addEnumsValue("optionA").addEnumsValue("optionB").addEnumsValue("optionC").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
						addFormParamsValue(group.newstringParam().setName("avatar").setDescription("user avatar").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("theavatar")).
						addFormParamsValue(group.newstringParam().setName("FBSocialToken").setDescription("user FBSocialToken").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thesocialtoken")),
					"400", "404", "409", "500").
					addResponsesValue(newjsonResponse("User confirmation",
						newResponseProperty("userId", "string", false),
						newResponseProperty("username", "string", true)))).
				addActionsValue(newPUT("update user",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(true).setMaxLength(254).setMinLength(0).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, B64encoded").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(8).setExample("thepassword")).
						addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
						addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))?)?$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("options").setDescription("sex").setRequired(false).addEnumsValue("optionA").addEnumsValue("optionB").addEnumsValue("optionC").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
						addFormParamsValue(group.newstringParam().setName("avatar").setDescription("user avatar").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("theavatar")).
						addFormParamsValue(group.newstringParam().setName("FBSocialToken").setDescription("user FBSocialToken").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thesocialtoken")),
					"400", "404", "409", "500").
					addResponsesValue(newjsonResponse("User confirmation",
						newResponseProperty("userId", "string", true)))).
				addActionsValue(group.newuriParameter().
					setName("username").
					addActionsValue(newDELETE("delete user",
						"400", "404", "409", "500").
						addResponsesValue(newjsonResponse("User delete confirmation",
							newResponseProperty("username", "string", true))))).
				addActionsValue(group.newuriParameter().
					setName("userId").
					addActionsValue(newGET("get user based on userId",
						"400", "404", "409", "500").
						addResponsesValue(newjsonResponse("User information",
							newResponseProperty("userId", "string", true)))))
		);

		FileUtil.write(loopsi, new File("src/main/web/api/loopsi/loopsi.raml"));
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.postActionST actionST = group.newpostAction().
			setDescription(description).
			setBody(body);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.getActionST newGET(String description, String... errorCodes) {
		final RamlGroup.getActionST actionST = group.newgetAction().
			setDescription(description);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.putActionST actionST = group.newputAction().
			setDescription(description).
			setBody(body);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.deleteActionST newDELETE(String description, String... errorCodes) {
		final RamlGroup.deleteActionST actionST = group.newdeleteAction().
			setDescription(description);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
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
