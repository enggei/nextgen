package com.generator.generators.raml;

import com.generator.util.FileUtil;

import java.io.File;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

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
					addFormParamsValue(group.newstringParam().setName("versionId").setDescription("APP version ID. To be determined. UUID?").setRequired(true).setMaxLength(40).setMinLength(MIN_VALUE).setExample(UUID.randomUUID())),
				"400", "404", "500").
				addResponsesValue(newjsonResponse("Version response",
					newResponseProperty("success", "boolean", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user").
				addActionsValue(newPOST("create new user",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(true).setMaxLength(254).setMinLength(MIN_VALUE).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, B64encoded").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(8).setExample("thepassword")).
						addFormParamsValue(group.newstringParam().setName("userToken").setDescription("the user token").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(8).setExample("theToken")).
						addFormParamsValue(group.newbooleanParam().setName("TempUser").setDescription("if user is temporary, no userinfo required").setRequired(true).setDefaultValue("true")).
						addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
						addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$").setExample("01.11.2000")).
						addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("options").setDescription("sex").setRequired(false).addEnumsValue("optionA").addEnumsValue("optionB").addEnumsValue("optionC").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(MIN_VALUE).setMaxLength(MAX_VALUE).setExample("thelocation")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(MIN_VALUE).setMaxLength(MAX_VALUE).setExample("thecountry")).
						addFormParamsValue(group.newstringParam().setName("avatar").setDescription("user avatar").setRequired(false).setMinLength(MIN_VALUE).setMaxLength(MAX_VALUE).setExample("theavatar")).
						addFormParamsValue(group.newstringParam().setName("FBSocialToken").setDescription("user FBSocialToken").setRequired(false).setMinLength(MIN_VALUE).setMaxLength(MAX_VALUE).setExample("theavatar")),
					"400", "404", "500").
					addResponsesValue(newjsonResponse("User confirmation",
						newResponseProperty("userToken", "string", true)))).
				addActionsValue(group.newuriParameter().
					setName("userToken").
					addActionsValue(newGET("get user based on userToken",
						"400", "404", "500").
						addResponsesValue(newjsonResponse("User information",
							newResponseProperty("userToken", "string", true)))))
		);

		FileUtil.write(loopsi, new File("/media/storage/ucs/loopsi/src/main/web/api/loopsi/loopsi.raml"));
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.postActionST postActionST = group.newpostAction().
			setDescription(description).
			setBody(body);
		for (String errorCode : errorCodes)
			postActionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return postActionST;
	}

	private RamlGroup.getActionST newGET(String description, String... errorCodes) {
		final RamlGroup.getActionST getActionST = group.newgetAction().
			setDescription(description);
		for (String errorCode : errorCodes)
			getActionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return getActionST;
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
