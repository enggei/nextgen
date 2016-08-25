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
		new APIGenerator().generateRamlFile(args[0]);
		System.out.println("completed");
		System.exit(0);
	}

	private final RamlGroup group = new RamlGroup();


	public void generateRamlFile(String outputFile) {

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
				setUri("/admin/version").

				addActionsValue(newGET("list of version entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of version entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove version entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("versionId").setDescription("version id").setRequired(true).setExample("84711675-af11-477b-abef-70556ae130dc")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Version deletion confirmation",
							newResponseProperty("versionId", "string", true)))
				).

				addActionsValue(newPOST("add a version item",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("releaseDate").setDescription("release date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$")).
						addFormParamsValue(group.newstringParam().setName("title").setDescription("title").setRequired(true).setExample("thetitle")).
						addFormParamsValue(group.newstringParam().setName("description").setDescription("description").setRequired(true).setExample("thedescription")).
						addFormParamsValue(group.newstringParam().setName("version").setDescription("version").setRequired(true).setExample("0.8")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added version confirmation",
						newResponseProperty("versionId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/user").

				addActionsValue(newGET("list of user entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of user entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove user entry",
					group.newqueryParams().
						addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("User deletion confirmation",
						newResponseProperty("userId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/currency").

				addActionsValue(newGET("list of virtual currency entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of currency entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove virtual currency entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("currencyId").setDescription("currency id").setRequired(true).setExample("")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Currency deletion confirmation",
							newResponseProperty("currencyId", "string", true)))
				).

				addActionsValue(newPOST("add a virtual currency item",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true).setExample("")).
						addFormParamsValue(group.newintegerParam().setName("currencyValue").setDescription("integer").setRequired(true).setExample("350")).
						addFormParamsValue(group.newstringParam().setName("transactionType").setDescription("to be determined").setRequired(false).setExample("thetype")).
						addFormParamsValue(newUUIDParam().setName("gameId").setDescription("uuid").setRequired(true).setExample("ab121aec-cf92-4f59-a154-ee924db700af")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added currency confirmation",
						newResponseProperty("currencyId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/badge").

				addActionsValue(newGET("list of badge entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of badge entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove badge entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("badgeId").setDescription("badge id").setRequired(true).setExample("f04ddca4-05e0-49b7-9093-a14ae5c95e51")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Badge deletion confirmation",
							newResponseProperty("badgeId", "string", true)))
				).

				addActionsValue(newPOST("add a badge item",
					group.newformBody().
						setMultipart(true).
						addFormParamsValue(newUUIDParam().setName("gameId").setDescription("game id").setRequired(true).setExample("ab121aec-cf92-4f59-a154-ee924db700af")).
						addFormParamsValue(group.newstringParam().setName("achievementType").setDescription("to be determined").setRequired(true).setExample("thetype")).
						addFormParamsValue(group.newstringParam().setName("achievementPeriod").setDescription("expiration date").setRequired(true).setExample("2016-12-31")).
						addFormParamsValue(group.newfileParam().setName("avatar").setDescription("user avatar").setRequired(false)),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added badge confirmation",
						newResponseProperty("badgeId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/redemption").

				addActionsValue(newGET("list of redemption entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of redemption entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove redemption entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("redemptionId").setDescription("redemption id").setRequired(true).setExample("")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Redemption deletion confirmation",
							newResponseProperty("redemptionId", "string", true)))
				).

				addActionsValue(newPOST("add an redemption item",
					group.newformBody().
						setMultipart(true).
						addFormParamsValue(newUUIDParam().setName("supplierId").setDescription("supplier id").setRequired(true).setExample("")).
						addFormParamsValue(group.newstringParam().setName("earnedFrom").setDescription("earned from date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("earnedTo").setDescription("earned to date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("expiryDate").setDescription("expiry date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newintegerParam().setName("limit").setDescription("limit").setRequired(true).setExample("10")).
						addFormParamsValue(group.newstringParam().setName("type").setDescription("type").setRequired(true).setExample("thetype")).
						addFormParamsValue(group.newstringParam().setName("code").setDescription("code").setRequired(true).setExample("thecode")).
						addFormParamsValue(group.newstringParam().setName("description").setDescription("description").setRequired(true).setExample("thedescription")).
						addFormParamsValue(group.newstringParam().setName("address").setDescription("address").setRequired(true).setExample("theaddress")).
						addFormParamsValue(group.newstringParam().setName("town").setDescription("town").setRequired(true).setExample("thetown")).
						addFormParamsValue(group.newstringParam().setName("city").setDescription("city").setRequired(true).setExample("thecity")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("country").setRequired(true).setExample("United Kingdom")).
						addFormParamsValue(group.newintegerParam().setName("currencyValue").setDescription("currency value").setRequired(true).setExample("150")).
						addFormParamsValue(group.newfileParam().setName("image").setDescription("image").setRequired(false)),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added redemption confirmation",
						newResponseProperty("redemptionId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/engagement").

				addActionsValue(newGET("list of engagement entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of engagement entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove engagement entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true).setExample("")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Engagement deletion confirmation",
							newResponseProperty("engagementId", "string", true)))
				).

				addActionsValue(newPOST("add an engagement item",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("title").setDescription("title").setRequired(true).setExample("thetitle")).
						addFormParamsValue(group.newstringParam().setName("logic").setDescription("to be determined").setRequired(true).setExample("thelogic")).
						addFormParamsValue(group.newintegerParam().setName("value").setDescription("value").setRequired(true).setExample("250")).
						addFormParamsValue(group.newstringParam().setName("type").setDescription("to be determined").setRequired(true).setExample("thetype")).
						addFormParamsValue(group.newstringParam().setName("earnedFrom").setDescription("earned from date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("earnedTo").setDescription("earned to date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")).
						addFormParamsValue(group.newstringParam().setName("expiryDate").setDescription("expiry date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$").setExample("2014-08-18")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added engagement confirmation",
						newResponseProperty("engagementId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/game").

				addActionsValue(newGET("list of game entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of game entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove game entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("gameId").setDescription("game id").setRequired(true).setExample("ab121aec-cf92-4f59-a154-ee924db700af")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Game deletion confirmation",
							newResponseProperty("gameId", "string", true)))
				).

				addActionsValue(newPOST("add a game item",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("startDate").setDescription("start date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$")).
						addFormParamsValue(group.newstringParam().setName("endDate").setDescription("end date").setRequired(true).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$")).
						addFormParamsValue(group.newstringParam().setName("description").setDescription("description").setRequired(true).setExample("thedescription")).
						addFormParamsValue(group.newintegerParam().setName("templateId").setDescription("template identifier").setRequired(true).setExample("1")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added game confirmation",
						newResponseProperty("gameId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/admin/supplier").

				addActionsValue(newGET("list of supplier entries",
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("list of supplier entries",
							newResponseProperty("list", "array", true)))
				).

				addActionsValue(newDELETE("remove supplier entry",
						group.newqueryParams().
							addQueryParamsValue(newUUIDParam().setName("supplierId").setDescription("supplier id").setRequired(true).setExample("")),
						"400", "401", "404", "500").
						addResponsesValue(newjsonResponse("Supplier deletion confirmation",
							newResponseProperty("supplierId", "string", true)))
				).

				addActionsValue(newPOST("add a supplier item",
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("name").setDescription("name").setRequired(true).setExample("thename")).
						addFormParamsValue(group.newstringParam().setName("town").setDescription("town").setRequired(true).setExample("thetown")).
						addFormParamsValue(group.newstringParam().setName("city").setDescription("city").setRequired(true).setExample("thecity")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("country").setRequired(true).setExample("United Kingdom")).
						addFormParamsValue(newUUIDParam().setName("cinemaId").setDescription("cinema id").setRequired(true).setExample("")).
						addFormParamsValue(group.newintegerParam().setName("category").setDescription("category identifier").setRequired(true).setExample("1")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added supplier confirmation",
						newResponseProperty("supplierId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/oauth2/login").

			addActionsValue(newPOST("client login",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters").setRequired(false).setExample("Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")),
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("grant_type").setDescription("OAuth2 grant type").setRequired(true).setMaxLength(254).setMinLength(0).setExample("client_credentials")).
					addFormParamsValue(group.newstringParam().setName("client_id").setDescription("OAuth2 client id - REQUIRED if not using Authorization header").setRequired(false).setMaxLength(254).setMinLength(0)).
					addFormParamsValue(group.newstringParam().setName("client_secret").setDescription("OAuth2 client secret - REQUIRED if not using Authorization header").setRequired(false).setMaxLength(254).setMinLength(0)),
				"400", "401").
				addResponsesValue(newjsonResponse("OAuth2 token response",
					newResponseProperty("access_token", "string", true),
					newResponseProperty("expires_in", "integer", true),
					newResponseProperty("token_type", "string", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/oauth2/token").

			addActionsValue(newGET("verifies client access token",
				group.newqueryParams().
					addQueryParamsValue(group.newstringParam().setName("access_token").setDescription("access token").setRequired(true)),
				"400", "401").
				addResponsesValue(newjsonResponse("Access token verification",
					newResponseProperty("verified", "boolean", true),
					newResponseProperty("oa2clientId", "string", false),
					newResponseProperty("client_id", "string", false),
					newResponseProperty("expires_in", "integer", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/version").

			addActionsValue(newGET("returns current APP version.",
				"400", "404").
				addResponsesValue(newjsonResponse("Versions response",
					newResponseProperty("version", "string", true),
					newResponseProperty("description", "string", true),
					newResponseProperty("releaseDate", "string", true)))).

			addActionsValue(newPOST(
				"receives APP version from client and returns whether it matches the current version.",
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("version").setDescription("APP version.").setRequired(true).setMaxLength(40).setMinLength(0).setExample("0.8")),
				"400", "404", "500").
				addResponsesValue(newjsonResponse("Version response",
					newResponseProperty("success", "boolean", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/login").

			addActionsValue(newPOST("user login",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters").setRequired(false).setExample("Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")),
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("grant_type").setDescription("OAuth2 grant type").setRequired(true).setMaxLength(254).setMinLength(0).setExample("password")).
					addFormParamsValue(group.newstringParam().setName("client_id").setDescription("OAuth2 client id - REQUIRED if not using Authorization header").setRequired(false).setMaxLength(254).setMinLength(0)).
					addFormParamsValue(group.newstringParam().setName("client_secret").setDescription("OAuth2 client secret - REQUIRED if not using Authorization header").setRequired(false).setMaxLength(254).setMinLength(0)).
					addFormParamsValue(group.newstringParam().setName("username").setDescription("the username").setRequired(true).setMaxLength(254).setMinLength(0).setExample("theusername")).
					addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")),
				"400", "401").
				addResponsesValue(newjsonResponse("OAuth2 token response",
					newResponseProperty("access_token", "string", true),
					newResponseProperty("expires_in", "integer", true),
					newResponseProperty("token_type", "string", true),
					newResponseProperty("refresh_token", "string", true),
					newResponseProperty("currencyTotal", "integer", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user/login/fb").addActionsValue(newPOST("register facebook user",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters").setRequired(false).setExample("Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")),
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")).
					addFormParamsValue(group.newstringParam().setName("fbToken").setDescription("facebook access_token").setRequired(true).setMaxLength(MAX_VALUE).setMinLength(1)),
				"400", "401", "404", "409", "500").
				addResponsesValue(newjsonResponse("OAuth2 token response",
					newResponseProperty("access_token", "string", true),
					newResponseProperty("expires_in", "integer", true),
					newResponseProperty("token_type", "string", true),
					newResponseProperty("refresh_token", "string", true),
					newResponseProperty("currencyTotal", "integer", false))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/forgotpassword").

			addActionsValue(newPOST("send email to reset password for user",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 CLIENT access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("userid").setDescription("the username").setRequired(true).setMaxLength(254).setMinLength(0).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "401").
				addResponsesValue(newjsonResponse("User forgot password email sent confirmation",
					newResponseProperty("success", "boolean", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/forgotPasswordForm").

			addActionsValue(newPOST("process user forgot password",
				group.newformBody().
					addFormParamsValue(group.newstringParam().setName("password").setDescription("the password").setRequired(true).setMaxLength(254).setMinLength(0).setExample("newpassword")).
					addFormParamsValue(group.newstringParam().setName("confirmPassword").setDescription("the confirm password").setRequired(true).setMaxLength(254).setMinLength(0).setExample("newpassword")).
					addFormParamsValue(group.newstringParam().setName("forgotPasswordToken").setDescription("the reset-token").setRequired(true).setMaxLength(254).setMinLength(0).setExample("1F43b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "401").
				addResponsesValue(newjsonResponse("User forgot password email sent confirmation",
					newResponseProperty("success", "boolean", true),
					newResponseProperty("dummy", "boolean", false)))).

			addActionsValue(newGET("get user forgot password form",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("forgotPasswordToken").setDescription("the reset-token").setRequired(true).setExample("1F43b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400").
				addResponsesValue(group.newbinaryResponse().setContentType("text/html"))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/logout").

			addActionsValue(newGET("user logout",
				group.newqueryParams().
					addQueryParamsValue(group.newstringParam().setName("access_token").setDescription("access token").setRequired(true)),
				"400").
				addResponsesValue(newjsonResponse("User logout confirmation",
					newResponseProperty("logout", "boolean", true),
					newResponseProperty("dummy", "boolean", false)))));

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user/token").

				addActionsValue(newGET("verifies user access token",
					group.newqueryParams().
						addQueryParamsValue(group.newstringParam().setName("access_token").setDescription("access token").setRequired(true)),
					"400", "401").
					addResponsesValue(newjsonResponse("Access token verification",
						newResponseProperty("verified", "boolean", true),
						newResponseProperty("userId", "string", false),
						newResponseProperty("expires_in", "integer", false)))).

				addActionsValue(newPOST("refresh user access token",
					group.newheaderParams().
						addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters").setRequired(false).setExample("Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")),
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("grant_type").setDescription("OAuth2 grant type").setRequired(true).setMaxLength(254).setMinLength(0).setExample("refresh_token")).
						addFormParamsValue(group.newstringParam().setName("refresh_token").setDescription("refresh token").setRequired(true).setExample("")),
					"400", "401"
				))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user").

				addActionsValue(newPOST("register new user",
					group.newheaderParams().
						addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters").setRequired(false).setExample("Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")),
					group.newformBody().
						addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(false).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")).
						addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
						addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
						addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$")).
						addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
						addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
						addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
						addFormParamsValue(group.newbooleanParam().setName("optInMarketing").setDescription("user opt in for marketing").setRequired(false).setDefaultValue(false)).
						addFormParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")),
					"400", "401", "404", "409", "500").
					addResponsesValue(newjsonResponse("OAuth2 token response",
						newResponseProperty("access_token", "string", true),
						newResponseProperty("expires_in", "integer", true),
						newResponseProperty("token_type", "string", true),
						newResponseProperty("refresh_token", "string", true),
						newResponseProperty("currencyTotal", "integer", false)))).

				addActionsValue(newGET("register a temporary user",
					group.newheaderParams().
						addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 CLIENT access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
					group.newqueryParams().
						addQueryParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE)),
					"400").
					addResponsesValue(newjsonResponse("Temporary userId",
						newResponseProperty("userId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/user/query").

				addActionsValue(newGET("query if a username, email or deviceId is registered",
					group.newheaderParams().
						addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 CLIENT access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
					group.newqueryParams().
						addQueryParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(false).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")).
						addQueryParamsValue(group.newstringParam().setName("username").setDescription("the username").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
						addQueryParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")),
					"400").
					addResponsesValue(newjsonResponse("Query response",
						newResponseProperty("found", "boolean", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/user/profile").

			addActionsValue(newGET("get user object",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 USER access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
				"400", "401", "404", "409", "500").
				addResponsesValue(newjsonResponse("User object confirmation",
					newResponseProperty("user", "object", true)))).

			addActionsValue(newDELETE("delete user",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 USER access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
				"400", "401", "404", "409", "500").
				addResponsesValue(newjsonResponse("User delete confirmation",
					newResponseProperty("userId", "string", true)))).

			addActionsValue(newPUT("update user",
				group.newheaderParams().
					addHeaderParamsValue(group.newheader().setName("Authorization").setDescription("OAuth2 USER access_token - REQUIRED if not using access_token parameter").setRequired(false).setExample("Bearer 4oe2Xr+yyLegIb4aubmQzu")),
				group.newformBody().
					setMultipart(true).
					addFormParamsValue(group.newstringParam().setName("username").setDescription("the username, either facebook-username or custom").setRequired(false).setMaxLength(254).setMinLength(0).setExample("theusername")).
					addFormParamsValue(group.newstringParam().setName("password").setDescription("the password, MD5 encoded").setRequired(false).setMaxLength(MAX_VALUE).setMinLength(8).setExample("b25bc8c9efabdd0837bb7d9deace1308")).
					addFormParamsValue(group.newstringParam().setName("firstName").setDescription("user first name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("theusername")).
					addFormParamsValue(group.newstringParam().setName("lastName").setDescription("user last name").setRequired(false).setMinLength(2).setMaxLength(30).setExample("thelastname")).
					addFormParamsValue(group.newstringParam().setName("email").setDescription("user email").setRequired(false).setMinLength(5).setMaxLength(254).setExample("the@email.com")).
					addFormParamsValue(group.newstringParam().setName("dob").setDescription("user date of birth").setRequired(false).setMinLength(10).setMaxLength(10).setPattern("^\\d{4}-\\d{2}-\\d{2}$")).
					addFormParamsValue(group.newstringParam().setName("sex").setDescription("sex").setRequired(false).addEnumsValue("male").addEnumsValue("female").setExample("the@email.com")).
					addFormParamsValue(group.newstringParam().setName("location").setDescription("user location").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thelocation")).
					addFormParamsValue(group.newstringParam().setName("country").setDescription("user country").setRequired(false).setMinLength(0).setMaxLength(MAX_VALUE).setExample("thecountry")).
					addFormParamsValue(group.newfileParam().setName("avatar").setDescription("user avatar").setRequired(false)).
					addFormParamsValue(group.newbooleanParam().setName("optInMarketing").setDescription("user opt in for marketing").setRequired(false).setDefaultValue(false)).
					addFormParamsValue(group.newstringParam().setName("deviceId").setDescription("user device id").setRequired(true).setMinLength(1).setMaxLength(MAX_VALUE).setExample("thedeviceid")),
				"400", "401", "404", "409", "500").
				addResponsesValue(newjsonResponse("User confirmation",
					newResponseProperty("userId", "string", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/currency").

				addActionsValue(newGET("returns user currency value.",
					group.newqueryParams().
						addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
					"400", "401", "404").
					addResponsesValue(newjsonResponse("Currency response",
						newResponseProperty("currentValue", "integer", true)))).

				addActionsValue(newPOST("add currency activity to user's ledger",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
						addFormParamsValue(newUUIDParam().setName("currencyId").setDescription("currency id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("cinemaId").setDescription("cinema id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("redemptionId").setDescription("redemtion id").setRequired(true)).
						addFormParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true)).
						addFormParamsValue(group.newintegerParam().setName("currencyEarned").setDescription("earned value").setRequired(true).setExample("250")).
						addFormParamsValue(group.newintegerParam().setName("currencyRedeemed").setDescription("redeemed value").setRequired(true).setExample("250")).
						addFormParamsValue(group.newstringParam().setName("latitude").setDescription("latitude").setRequired(false)).
						addFormParamsValue(group.newstringParam().setName("longitude").setDescription("longitude").setRequired(false)),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added currency activity confirmation",
						newResponseProperty("currencyActivityId", "string", true)))).

				addActionsValue(newDELETE("deletes a currency activity entry. *FOR MAINTENANCE/TESTING PURPOSES*",
					group.newqueryParams().
						addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
						addQueryParamsValue(newUUIDParam().setName("currencyActivityId").setDescription("currency activity id").setRequired(true)),
					"400", "401", "404").
					addResponsesValue(newjsonResponse("Deleted currency activity confirmation",
						newResponseProperty("currencyActivityId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/currency/ledger").

				addActionsValue(newGET("returns user currency ledger.",
					group.newqueryParams().
						addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
					"400", "401", "404").
					addResponsesValue(newjsonResponse("Currency ledger (activities)",
						newResponseProperty("list", "array", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
				setUri("/badge").

				addActionsValue(newPOST("add badge activity to user's ledger",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
						addFormParamsValue(newUUIDParam().setName("badgeId").setDescription("badge id").setRequired(true).setExample("f04ddca4-05e0-49b7-9093-a14ae5c95e51")).
						addFormParamsValue(group.newintegerParam().setName("completionPercent").setDescription("competion percentage").setRequired(true).setExample("42")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Added badge activity confirmation",
						newResponseProperty("userBadgeId", "string", true)))).

				addActionsValue(newPUT("update badge activity in user's ledger",
					group.newformBody().
						addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
						addFormParamsValue(newUUIDParam().setName("userBadgeId").setDescription("user badge id").setRequired(true)).
						addFormParamsValue(group.newintegerParam().setName("completionPercent").setDescription("competion percentage").setRequired(true).setExample("42")),
					"400", "401", "404", "500").
					addResponsesValue(newjsonResponse("Updated badge activity confirmation",
						newResponseProperty("userBadgeId", "string", true)))).

				addActionsValue(newDELETE("deletes a badge activity entry. *FOR MAINTENANCE/TESTING PURPOSES*",
					group.newqueryParams().
						addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("")).
						addQueryParamsValue(newUUIDParam().setName("userBadgeId").setDescription("badge activity id").setRequired(true)),
					"400", "401", "404").
					addResponsesValue(newjsonResponse("Deleted badge activity confirmation",
						newResponseProperty("userBadgeId", "string", true))))
		);

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/badge/earned").

			addActionsValue(newGET("returns user badges earned.",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "404").
				addResponsesValue(newjsonResponse("Badges response",
					newResponseProperty("badges", "array", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/badge/available").

			addActionsValue(newGET("returns badges available.",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
					addQueryParamsValue(newUUIDParam().setName("gameId").setDescription("game id").setRequired(true).setExample("ab121aec-cf92-4f59-a154-ee924db700af")),
				"400", "404").
				addResponsesValue(newjsonResponse("Badges response",
					newResponseProperty("badges", "array", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/redemption").

			addActionsValue(newGET("returns relevant redemption offers.",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "404").
				addResponsesValue(newjsonResponse("Redemptions response",
					newResponseProperty("redemptions", "array", true)))).

			addActionsValue(newPOST("Redeem redemption",
				group.newformBody().
					addFormParamsValue(newUUIDParam().setName("redemptionId").setDescription("redemption id").setRequired(true).setExample("a4fce7b1-1226-4466-994d-84a89d05df85")).
					addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "401", "404", "500").
				addResponsesValue(newjsonResponse("Redeemed redemption confirmation",
					newResponseProperty("redemptionActivityId", "string", true),
					newResponseProperty("redemptionId", "string", true),
					newResponseProperty("type", "string", true),
					newResponseProperty("description", "string", true),
					newResponseProperty("value", "integer", true),
					newResponseProperty("newBalance", "long", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/redemption/ledger").

			addActionsValue(newGET("returns user redemption ledger.",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "404").
				addResponsesValue(newjsonResponse("Redemption ledger (activities)",
					newResponseProperty("redemptions", "array", true)))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/engagement").

			addActionsValue(newGET("returns user engagement activities.",
				group.newqueryParams().
					addQueryParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")),
				"400", "404").
				addResponsesValue(newjsonResponse("Engagements response",
					newResponseProperty("engagements", "array", true),
					newResponseProperty("dummy", "boolean", false)))).

			addActionsValue(newPOST("POST Did Engagement Activities",
				group.newformBody().
					addFormParamsValue(newUUIDParam().setName("engagementId").setDescription("engagement id").setRequired(true).setExample("58a41ad8-7b0a-441f-9187-a573c5ee90ea")).
					addFormParamsValue(newUUIDParam().setName("userId").setDescription("user id").setRequired(true).setExample("1143b1b2-c06e-4d4b-8bb6-4403b7ad1ea6")).
					addFormParamsValue(group.newstringParam().setName("engagementdatetime").setDescription("date and time").setRequired(true).setExample("2016-12-31 18:05:00")),
				"400", "401", "404", "500").
				addResponsesValue(newjsonResponse("Post engagement balance",
					newResponseProperty("engagementCategory", "string", true),
					newResponseProperty("type", "string", true),
					newResponseProperty("id", "long", true),
					newResponseProperty("latitude", "long", true),
					newResponseProperty("longitude", "long", true)))));

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

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/images/films/").

			addActionsValue(group.newuriParameter().
				setName("imageId").
				addActionsValue(newGET("returns images for films",
					"400", "404").
					addResponsesValue(group.newbinaryResponse().setContentType("image/png")))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/images/trailers/").

			addActionsValue(group.newuriParameter().
				setName("imageId").
				addActionsValue(newGET("returns images for films",
					"400", "404").
					addResponsesValue(group.newbinaryResponse().setContentType("image/png")))));

		loopsi.addEndpointsValue(group.newendpoint().
			setUri("/images/badges/").

			addActionsValue(group.newuriParameter().
				setName("imageId").
				addActionsValue(newGET("returns images for films",
					"400", "404").
					addResponsesValue(group.newbinaryResponse().setContentType("image/png")))));

		FileUtil.write(loopsi, new File(outputFile));
	}

	private RamlGroup.stringParamST newUUIDParam() {
		return group.newstringParam().
			setMaxLength(36).
			setMinLength(36).
			setPattern(REGEX_UUID);
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.postActionST actionST = group.newpostAction().
			setDescription(description).
			setHeaders(headers).
			setBody(body).
			setQuery(query);
		for (String errorCode : errorCodes)
			actionST.addResponsesValue(error(errorCode, getErrorDescription(errorCode)));
		return actionST;
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		return newPOST(description, null, query, body, errorCodes);
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.headerParamsST headers, RamlGroup.formBodyST body, String... errorCodes) {
		return newPOST(description, headers, null, body, errorCodes);
	}

	private RamlGroup.postActionST newPOST(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		return newPOST(description, null, null, body, errorCodes);
	}

	private RamlGroup.getActionST newGET(String description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.getActionST actionST = group.newgetAction().
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

	private RamlGroup.getActionST newGET(String description, RamlGroup.queryParamsST query, String... errorCodes) {
		return newGET(description, null, query, errorCodes);
	}

	private RamlGroup.getActionST newGET(String description, String... errorCodes) {
		return newGET(description, null, null, errorCodes);
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		final RamlGroup.putActionST actionST = group.newputAction().
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

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.queryParamsST query, RamlGroup.formBodyST body, String... errorCodes) {
		return newPUT(description, null, query, body, errorCodes);
	}

	private RamlGroup.putActionST newPUT(Object description, RamlGroup.formBodyST body, String... errorCodes) {
		return newPUT(description, null, null, body, errorCodes);
	}

	private RamlGroup.deleteActionST newDELETE(String description, RamlGroup.headerParamsST headers, RamlGroup.queryParamsST query, String... errorCodes) {
		final RamlGroup.deleteActionST actionST = group.newdeleteAction().
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

	private RamlGroup.deleteActionST newDELETE(String description, RamlGroup.queryParamsST query, String... errorCodes) {
		return newDELETE(description, null, query, errorCodes);
	}

	private RamlGroup.deleteActionST newDELETE(String description, String... errorCodes) {
		return newDELETE(description, null, null, errorCodes);
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
