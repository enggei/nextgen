package com.generator.generators.raml;

import com.generator.ProjectConstants;
import com.generator.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;

/**
 * goe on 6/30/16.
 */
public class Loopsi extends Domain {

   public static void main(String[] args) throws IOException {

      new Loopsi().generateRamlFile(ProjectConstants.TEST_ROOT + "/com/generator/raml/loopsi.raml");
   }

   final class APIEntity {

      final String title;
      final String label;
      final String plural;
      final Map<String, ItemProperty> properties = new LinkedHashMap<>();

      APIEntity(String label, String plural, String title) {
         this.label = label;
         this.plural = plural;
         this.title = title;
      }

      String plural() {
         return plural;
      }

      APIEntity addProperty(ItemProperty property) {
         this.properties.put(property.name, property);
         return this;
      }

      Object asGridEditorHtml() {

         return null;
      }

      Object asGridEditorJS() {

         return null;
      }
   }

   class ItemProperty {

      final String name;
      final String type;
      String defaultValue = "\"\"";

      ItemProperty(String name, String type) {
         this.name = name;
         this.type = type;
      }

//      public Object asHtmlComponent() {
//         return "<input class='form-control' data-bind='value: " + name + "' />";
//      }


   }

   class StringProperty extends ItemProperty {

      StringProperty(String name) {
         super(name, "String");
      }

      public Object asHtmlComponent() {
         return "<input class='form-control' data-bind='value: " + name + "' />";
      }
   }

   class SingleReferenceProperty extends ItemProperty {

      private final String referenceLabel;
      private final String optionsText;

      SingleReferenceProperty(String name, String referenceLabel, String optionsText) {
         super(name, "SingleReference");
         this.referenceLabel = referenceLabel;
         this.optionsText = optionsText;
      }

      public Object asHtmlComponent() {
         return "<select class=\"form-control\" data-bind='options: $root." + name + "Options, value: " + name + ", optionsValue: \"uuid\", optionsText: \"" + optionsText + "\"'></select>";
      }


   }

   class BooleanProperty extends ItemProperty {

      BooleanProperty(String name) {
         super(name, "Boolean");
      }

      public Object asHtmlComponent() {
         return "<input class='form-control' type=\"checkbox\" data-bind='checked: " + name + "' />";
      }
   }

   class LatitudeProperty extends ItemProperty {

      LatitudeProperty(String name) {
         super(name, "Latitude");
      }

      public Object asHtmlComponent() {
         return "<input class='form-control' data-bind='value: " + name + "' />";
      }
   }

   class LongitudeProperty extends ItemProperty {

      LongitudeProperty(String name) {
         super(name, "Longitude");
      }

      public Object asHtmlComponent() {
         return "<input class='form-control' data-bind='value: " + name + "' />";
      }
   }

   class IntegerProperty extends ItemProperty {

      IntegerProperty(String name) {
         super(name, "Integer");
      }

      public Object asHtmlComponent() {
         // todo: create input-verification
         return "<input class='form-control' data-bind='value: " + name + "' />";
      }
   }

   class EnumProperty extends ItemProperty {

      final String[] values;

      EnumProperty(String name, String... values) {
         super(name, "Enum");
         this.values = values;
         this.defaultValue = values[0];
      }

//      @Override
//      public Object asHtmlComponent() {
//         return "<select class=\"form-control\" data-bind='options: $root." + name + "Options, value: " + name + "'></select>";
//      }


   }

   class DateProperty extends ItemProperty {

      DateProperty(String name) {
         super(name, "Enum");
         this.defaultValue = "\"" + LocalDate.now().toString() + "\"";
      }
   }


   public void generateRamlFile(String outputFile) {

      final RamlGroup.fileST loopsi = newRamlTemplate("Loopsi REST API", "https://localhost:8080/api", true, "v1");

      new APIBuilder().
            setName("VersionAPI").
            addEndpoint(new Endpoint("/admin/version").
                  addAction(new GetAction("list of version entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addResponseValue(new JsonResponse("list of version entries",
                              new JsonResponseProperty("list", "array", true)))).
                  addAction(new DeleteAction("remove version entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addQueryParam(new UUIDParam("versionId", "version id", true, UUID.fromString("84711675-af11-477b-abef-70556ae130dc"))).
                        addResponseValue(new JsonResponse("Version deletion confirmation",
                              new JsonResponseProperty("versionId", "string", true)))).
                  addAction(new PostAction("add a version item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addFormParam(new DateParam("releaseDate", "release date", true)).
                        addFormParam(new StringParam("title", "title", true, "thetitle")).
                        addFormParam(new StringParam("description", "description", true, "thedescription")).
                        addFormParam(new StringParam("version", "version", true, "0.8")).
                        addResponseValue(new JsonResponse("Added version confirmation",
                              new JsonResponseProperty("versionId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("UserAPI").
            addEndpoint(new Endpoint("/admin/user").
                  addAction(new PostAction("update user data", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addFormParam(new UserIdParam(true)).
                        addFormParam(new StringParam("username", "the username, either facebook-username or custom", false, "username", 0, 254)).
                        addFormParam(new StringParam("password", "the password, MD5 encoded", false).setMaxLength(MAX_VALUE).setMinLength(8)).
                        addFormParam(new StringParam("firstName", "user first name", false).setMinLength(2).setMaxLength(30)).
                        addFormParam(new StringParam("lastName", "user last name", false).setMinLength(2).setMaxLength(30)).
                        addFormParam(new EmailParam("email", "user email", false)).
                        addFormParam(new DateParam("dob", "user date of birth", false)).
                        addFormParam(new EnumParam("sex", "sex", false, "male", "female")).
                        addFormParam(new StringParam("location", "user location", false).setMinLength(0).setMaxLength(MAX_VALUE)).
                        addFormParam(new StringParam("country", "user country", false).setMinLength(0).setMaxLength(MAX_VALUE)).
                        addFormParam(new FileParam("avatar", "user avatar", false)).
                        addFormParam(new BooleanParam("optInMarketing", "user opt in for marketing", false, false)).
                        addFormParam(new IntegerParam("balance", "user currency", 0, Integer.MAX_VALUE, false)).
                        addResponseValue(new JsonResponse("the updated user object",
                              new JsonResponseProperty("user", "object", true)))).
                  addAction(new GetAction("list of user entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).addResponseValue(new JsonResponse("list of user entries",
                        new JsonResponseProperty("list", "array", true)))).
                  addAction(new DeleteAction("remove user entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).addQueryParam(new UserIdParam(true)).addResponseValue(new JsonResponse("User deletion confirmation",
                        new JsonResponseProperty("userId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("BadgeAPI").
            addEndpoint(new Endpoint("/admin/badge").
                  addAction(new GetAction("list of badge entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addResponseValue(new JsonResponse("list of badge entries",
                              new JsonResponseProperty("list", "array", true)))).
                  addAction(new DeleteAction("remove badge entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addQueryParam(new UUIDParam("badgeId", "badge id", true)).
                        addResponseValue(new JsonResponse("Badge deletion confirmation",
                              new JsonResponseProperty("badgeId", "string", true)))).
                  addAction(new PostAction("add a badge item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        setMultipart(true).
                        addFormParam(new UUIDParam("gameId", "game id", true)).
                        addFormParam(new StringParam("title", "title", true, "badge title")).
                        addFormParam(new StringParam("description", "description", true, "badge description")).
                        addFormParam(new FileParam("avatar", "user avatar", false)).
                        addResponseValue(new JsonResponse("Added badge confirmation",
                              new JsonResponseProperty("badgeId", "string", true))))).addToRAML(loopsi);


      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/redemption").

            addAction(new GetAction("list of redemption entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("list of redemption entries",
                        new JsonResponseProperty("list", "array", true)))).

            addAction(new DeleteAction("remove redemption entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("redemptionId", "redemption id", true)).
                  addResponseValue(new JsonResponse("Redemption deletion confirmation",
                        new JsonResponseProperty("redemptionId", "string", true)))).

            addAction(new PostAction("add an redemption item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  setMultipart(true).
                  addFormParam(new UUIDParam("supplierId", "supplier id", true)).
                  addFormParam(new DateParam("earnedFrom", "earned from date", true)).
                  addFormParam(new DateParam("earnedTo", "earned to date", true)).
                  addFormParam(new DateParam("expiryDate", "expiry date", true)).
                  addFormParam(new IntegerParam("limit", "limit", true)).
                  addFormParam(new StringParam("title", "title", true, "thetitle")).
                  addFormParam(new StringParam("code", "code", true, "thecode")).
                  addFormParam(new StringParam("description", "description", true, "thedescription")).
                  addFormParam(new StringParam("address", "address", true, "theaddress")).
                  addFormParam(new StringParam("town", "town", true, "thetown")).
                  addFormParam(new StringParam("city", "city", true, "thecity")).
                  addFormParam(new StringParam("country", "country", true, "United Kingdom")).
                  addFormParam(new IntegerParam("currencyValue", "currency value", true)).
                  addFormParam(new FileParam("image", "image", false)).
                  addResponseValue(new JsonResponse("Added redemption confirmation",
                        new JsonResponseProperty("redemptionId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/engagement").
            addAction(new GetAction("list of engagement entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("list of engagement entries",
                        new JsonResponseProperty("list", "array", true)))).
            addAction(new DeleteAction("remove engagement entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("engagementId", "engagement id", true)).
                  addResponseValue(new JsonResponse("Engagement deletion confirmation",
                        new JsonResponseProperty("engagementId", "string", true)))).
            addAction(new PostAction("add an engagement item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addFormParam(new StringParam("title", "title", true, "thetitle")).
                  addFormParam(new IntegerParam("value", "value", true)).
                  addFormParam(new DateParam("expiryDate", "expiry date", true)).
                  addResponseValue(new JsonResponse("Added engagement confirmation",
                        new JsonResponseProperty("engagementId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/game").
            addAction(new GetAction("list games", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("list of game entries",
                        new JsonResponseProperty("games", "array", true)))).
            addAction(new DeleteAction("remove game entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("gameId", "game id", true)).
                  addResponseValue(new JsonResponse("Game deletion confirmation",
                        new JsonResponseProperty("gameId", "string", true)))).
            addAction(new PostAction("add a game item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addFormParam(new DateParam("startDate", "start date", true)).
                  addFormParam(new DateParam("endDate", "end date", true)).
                  addFormParam(new StringParam("title", "title", true, "thetitle")).
                  addFormParam(new StringParam("description", "description", true, "thedescription")).
                  addFormParam(new IntegerParam("templateId", "template identifier", true)).
                  addResponseValue(new JsonResponse("Added game confirmation",
                        new JsonResponseProperty("gameId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/game").
                  addAction(new GetAction("list games", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addResponseValue(new JsonResponse("list of game entries",
                              new JsonResponseProperty("games", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/supplier").
            addAction(new GetAction("list of supplier entries", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("list of supplier entries",
                        new JsonResponseProperty("list", "array", true)))).
            addAction(new DeleteAction("remove supplier entry", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("supplierId", "supplier id", true)).
                  addResponseValue(new JsonResponse("Supplier deletion confirmation",
                        new JsonResponseProperty("supplierId", "string", true)))).
            addAction(new PostAction("add a supplier item", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addFormParam(new StringParam("name", "name", true, "thename")).
                  addFormParam(new StringParam("town", "town", true, "thetown")).
                  addFormParam(new StringParam("city", "city", true, "thecity")).
                  addFormParam(new StringParam("country", "country", true, "United Kingdom")).
                  addFormParam(new UUIDParam("cinemaId", "cinema id", true)).
                  addFormParam(new IntegerParam("category", "category identifier", true)).
                  addResponseValue(new JsonResponse("Added supplier confirmation",
                        new JsonResponseProperty("supplierId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/import/intshowtimes").
            addAction(new PostAction("force import international showtimes", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Import job start confirmation",
                        new JsonResponseProperty("jobstart", "boolean", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/admin/film/statistics").
            addAction(new GetAction("film data statistics", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Film data statistics",
                        new JsonResponseProperty("statistics", "object", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/oauth2/login").
            addAction(new PostAction("client login", AuthType.OAUTH2_CLIENT_CREDENTIALS).
                  addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "client_credentials", 0, 254)).
                  addFormParam(new StringParam("client_id", "OAuth2 client id - REQUIRED if not using Authorization header", false, "l00ps1", 0, 254)).
                  addFormParam(new StringParam("client_secret", "OAuth2 client secret - REQUIRED if not using Authorization header", false, "b39ae25ed90a297bffe339827a3b95c7", 0, 254)).
                  setErrorCodes("400", "401").
                  addResponseValue(new JsonResponse("OAuth2 token response",
                        new JsonResponseProperty("access_token", "string", true),
                        new JsonResponseProperty("expires_in", "integer", true),
                        new JsonResponseProperty("token_type", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/oauth2/token").
            addAction(new GetAction("verifies client access token").
                  addQueryParam(new StringParam("access_token", "client access token", true)).
                  addResponseValue(new JsonResponse("Access token verification",
                        new JsonResponseProperty("verified", "boolean", true),
                        new JsonResponseProperty("oa2clientId", "string", false),
                        new JsonResponseProperty("client_id", "string", false),
                        new JsonResponseProperty("expires_in", "integer", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/version").
            addAction(new GetAction("returns current APP version.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Versions response",
                        new JsonResponseProperty("version", "string", true),
                        new JsonResponseProperty("description", "string", true),
                        new JsonResponseProperty("releaseDate", "string", true)))).
            addAction(new PostAction("receives APP version from client and returns whether it matches the current version.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addFormParam(new StringParam("version", "APP version.", true, "0.8.1", 5, 8)).
                  addResponseValue(new JsonResponse("Version response",
                        new JsonResponseProperty("success", "boolean", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/user/login").
            addAction(new PostAction("user login", AuthType.OAUTH2_CLIENT_CREDENTIALS).
                  addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "password", 0, 254)).
                  addFormParam(new StringParam("client_id", "OAuth2 client id - REQUIRED if not using Authorization header", false, 0, 254)).
                  addFormParam(new StringParam("client_secret", "OAuth2 client secret - REQUIRED if not using Authorization header", false, 0, 254)).
                  addFormParam(new StringParam("username", "the username", true, "theusername", 3, 10)).
                  addFormParam(new StringParam("password", "the password, MD5 encoded", true, "b25bc8c9efabdd0837bb7d9deace1308", 8, Integer.MAX_VALUE)).
                  addResponseValue(new JsonResponse("OAuth2 token response",
                        new JsonResponseProperty("access_token", "string", true),
                        new JsonResponseProperty("expires_in", "integer", true),
                        new JsonResponseProperty("token_type", "string", true),
                        new JsonResponseProperty("refresh_token", "string", true),
                        new JsonResponseProperty("userId", "string", false),
                        new JsonResponseProperty("currencyTotal", "integer", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/login/fb").
                  addAction(new PostAction("register facebook user", AuthType.OAUTH2_CLIENT_CREDENTIALS).
                        addFormParam(new StringParam("deviceId", "user device id", true, "thedeviceid", 1, Integer.MAX_VALUE)).
                        addFormParam(new StringParam("fbToken", "facebook access_token", true, 1, Integer.MAX_VALUE)).
                        addErrorCode("409").
                        addResponseValue(new JsonResponse("OAuth2 token response",
                              new JsonResponseProperty("access_token", "string", true),
                              new JsonResponseProperty("expires_in", "integer", true),
                              new JsonResponseProperty("token_type", "string", true),
                              new JsonResponseProperty("refresh_token", "string", true),
                              new JsonResponseProperty("userId", "string", false),
                              new JsonResponseProperty("currencyTotal", "integer", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/forgotpassword").
                  addAction(new PostAction("send email to reset password for user", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addFormParam(new UUIDParam("userId", "the user id", false)).
                        addFormParam(new StringParam("username", "the username", false, "theusername", 0, 254)).
                        setErrorCodes("400", "401").
                        addResponseValue(new JsonResponse("User forgot password email sent confirmation",
                              new JsonResponseProperty("success", "boolean", true),
                              new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/forgotPasswordForm").
                  addAction(new PostAction("process user forgot password", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addFormParam(new StringParam("password", "the password", true, "newpassword", 0, 254)).
                        addFormParam(new StringParam("confirmPassword", "the confirm password", true, "newpassword", 0, 254)).
                        addFormParam(new UUIDParam("forgotPasswordToken", "the reset-token", true)).
                        setErrorCodes("400", "401").
                        addResponseValue(new JsonResponse("User forgot password email sent confirmation",
                              new JsonResponseProperty("success", "boolean", true),
                              new JsonResponseProperty("dummy", "boolean", false)))).

                  addAction(new GetAction("get user forgot password form", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addQueryParam(new UUIDParam("forgotPasswordToken", "the reset-token", true)).
                        setErrorCodes("400").
                        addResponseValue(new HtmlResponse("form for resetting password")))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/logout").
                  addAction(new GetAction("user logout").
                        addQueryParam(new StringParam("access_token", "access token", true)).
                        setErrorCodes("400").
                        addResponseValue(new JsonResponse("User logout confirmation",
                              new JsonResponseProperty("logout", "boolean", true),
                              new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/token").
                  addAction(new GetAction("verifies user access token").
                        addQueryParam(new StringParam("access_token", "access token", true)).
                        setErrorCodes("400", "401").
                        addResponseValue(new JsonResponse("Access token verification",
                              new JsonResponseProperty("verified", "boolean", true),
                              new JsonResponseProperty("userId", "string", false),
                              new JsonResponseProperty("expires_in", "integer", false)))).
                  addAction(new PostAction("refresh user access token").
                        addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "refresh_token", 0, 254)).
                        addFormParam(new StringParam("refresh_token", "refresh token", true, 0, 254)).
                        setErrorCodes("400", "401"))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/user").
            addAction(new GetAction("register and log in a temporary user", AuthType.OAUTH2_CLIENT_CREDENTIALS).
                  addQueryParam(new StringParam("deviceId", "user device id", true, 1, MAX_VALUE)).
                  setErrorCodes("400").
                  addResponseValue(new JsonResponse("OAuth2 token response",
                        new JsonResponseProperty("access_token", "string", true),
                        new JsonResponseProperty("expires_in", "integer", true),
                        new JsonResponseProperty("token_type", "string", true),
                        new JsonResponseProperty("refresh_token", "string", true),
                        new JsonResponseProperty("userId", "string", false),
                        new JsonResponseProperty("currency", "integer", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/user/query").
                  addAction(new GetAction("query if a username, email or deviceId is registered", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addQueryParam(new StringParam("deviceId", "user device id", false, 1, MAX_VALUE)).
                        addQueryParam(new StringParam("username", "the username", false, "theusername", 0, 254)).
                        addQueryParam(new EmailParam("email", "user email", false)).
                        setErrorCodes("400").
                        addResponseValue(new JsonResponse("Query response",
                              new JsonResponseProperty("found", "boolean", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/user/profile").
            addAction(new GetAction("get user object", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("User object confirmation", new JsonResponseProperty("user", "object", true)))).
            addAction(new PostAction("register new user", AuthType.OAUTH2_CLIENT_CREDENTIALS).
                  addFormParam(new StringParam("username", "the username, either facebook-username or custom", true, "theusername", 0, 254)).
                  addFormParam(new StringParam("password", "the password, MD5 encoded", true, 8, MAX_VALUE, "b25bc8c9efabdd0837bb7d9deace1308")).
                  addFormParam(new StringParam("firstName", "user first name", true, 2, 30, "theusername")).
                  addFormParam(new StringParam("lastName", "user last name", true, 2, 30, "thelastname")).
                  addFormParam(new EmailParam("email", "user email", true)).
                  addFormParam(new DateParam("dob", "user date of birth", true)).
                  addFormParam(new EnumParam("sex", "sex", true, "male", "female")).
                  addFormParam(new StringParam("location", "user location", false, 0, MAX_VALUE, "thelocation")).
                  addFormParam(new StringParam("country", "user country", true, 0, MAX_VALUE, "thecountry")).
                  addFormParam(new BooleanParam("optInMarketing", "user opt in for marketing", true, false)).
                  addFormParam(new StringParam("deviceId", "user device id", true, 1, MAX_VALUE, "thedeviceid")).
                  addErrorCode("409").
                  addResponseValue(new JsonResponse("OAuth2 token response",
                        new JsonResponseProperty("access_token", "string", true),
                        new JsonResponseProperty("expires_in", "integer", true),
                        new JsonResponseProperty("token_type", "string", true),
                        new JsonResponseProperty("refresh_token", "string", true),
                        new JsonResponseProperty("userId", "string", false),
                        new JsonResponseProperty("currency", "integer", false)))).

            addAction(new DeleteAction("delete user", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addErrorCode("409").
                  addResponseValue(new JsonResponse("User delete confirmation",
                        new JsonResponseProperty("userId", "string", true)))).

            addAction(new PutAction("update user", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  setMultipart(true).
                  addFormParam(new StringParam("username", "the username, either facebook-username or custom", false, "theusername", 0, 254)).
                  addFormParam(new StringParam("password", "the password, MD5 encoded", false, 8, MAX_VALUE, "b25bc8c9efabdd0837bb7d9deace1308")).
                  addFormParam(new StringParam("firstName", "user first name", false, 2, 30, "theusername")).
                  addFormParam(new StringParam("lastName", "user last name", false, 2, 30, "thelastname")).
                  addFormParam(new EmailParam("email", "user email", false)).
                  addFormParam(new DateParam("dob", "user date of birth", false)).
                  addFormParam(new EnumParam("sex", "sex", false, "male", "female")).
                  addFormParam(new StringParam("location", "user location", false, 0, MAX_VALUE, "thelocation")).
                  addFormParam(new StringParam("country", "user country", false, 0, MAX_VALUE, "thecountry")).
                  addFormParam(new FileParam("avatar", "user avatar", false)).
                  addFormParam(new BooleanParam("optInMarketing", "user opt in for marketing", false, false)).
                  addErrorCode("409").
                  addResponseValue(new JsonResponse("User confirmation",
                        new JsonResponseProperty("userId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/badge").
                  addAction(new PostAction("add badge activity to user's ledger", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                        addFormParam(new UUIDParam("badgeId", "badge id", true)).
                        addFormParam(new IntegerParam("completionPercent", "competion percentage", true, 42)).
                        addResponseValue(new JsonResponse("Added badge activity confirmation",
                              new JsonResponseProperty("userBadgeId", "string", true)))).
                  addAction(new PutAction("update badge activity in user's ledger", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                        addFormParam(new UUIDParam("userBadgeId", "user badge id", true)).
                        addFormParam(new IntegerParam("completionPercent", "competion percentage", true, 42)).
                        addResponseValue(new JsonResponse("Updated badge activity confirmation",
                              new JsonResponseProperty("userBadgeId", "string", true)))).
                  addAction(new DeleteAction("deletes a badge activity entry. *FOR MAINTENANCE/TESTING PURPOSES*", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                        addQueryParam(new UUIDParam("userBadgeId", "badge activity id", true)).
                        setErrorCodes("400", "401", "404").
                        addResponseValue(new JsonResponse("Deleted badge activity confirmation",
                              new JsonResponseProperty("userBadgeId", "string", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/badge/earned").
            addAction(new GetAction("returns user badges earned.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Badges response",
                        new JsonResponseProperty("badges", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/badge/available").
            addAction(new GetAction("returns badges available.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("gameId", "game id", false)).
                  addResponseValue(new JsonResponse("Badges response",
                        new JsonResponseProperty("badges", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/leaderboard/gamescoresfb").
            addAction(new GetAction("returns fb friends gamescores for game", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("gameId", "game id", true)).
                  addQueryParam(new IntegerParam("top", "top results", 1, Integer.MAX_VALUE, false)).
                  addResponseValue(new JsonResponse("scores",
                        new JsonResponseProperty("scores", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/leaderboard/gamescores").
                  addAction(new PostAction("post gamescore", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                        addFormParam(new UUIDParam("gameId", "game id", true)).
                        addFormParam(new IntegerParam("score", "game score", 0, Integer.MAX_VALUE, true)).
                        addFormParam(new LatitudeParam(false)).
                        addFormParam(new LongitudeParam(false)).
                        addResponseValue(new JsonResponse("game score posted",
                              new JsonResponseProperty("success", "boolean", true)))).

                  addAction(new GetAction("returns global gamescores for game", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addQueryParam(new UUIDParam("gameId", "game id", true)).
                        addQueryParam(new IntegerParam("top", "top results", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new JsonResponse("scores",
                              new JsonResponseProperty("scores", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/films/watchlist").
            addAction(new PostAction("add film to watchlist", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addFormParam(new UUIDParam("filmId", "film id", true)).
                  addResponseValue(new JsonResponse("confirmation of added to watchlist",
                        new JsonResponseProperty("success", "boolean", true)))).
            addAction(new DeleteAction("remove film from watchlist", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("filmId", "film id", true)).
                  addResponseValue(new JsonResponse("users edited watchlist",
                        new JsonResponseProperty("watchlist", "array", true)))).
            addAction(new GetAction("current watchlist for user", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("watchlist",
                        new JsonResponseProperty("watchlist", "array", true))))).addToRAML(loopsi);
      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/films/watchlist/friends").
            addAction(new GetAction("get friends who has this film on their watchlist", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("filmId", "film id", true)).
                  addQueryParam(new IntegerParam("count", "no elements", true, 10)).
                  addResponseValue(new JsonResponse("watchlist of friends",
                        new JsonResponseProperty("watchlist", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/showtimes").
            addAction(new GetAction("get showtimes for film or cinema", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("cinemaId", "cinema id", false)).
                  addQueryParam(new UUIDParam("filmId", "film id", false)).
                  addQueryParam(new DateParam("fromDate", "filter by dates", false)).
                  addQueryParam(new DateParam("toDate", "filter by dates - not needed if filtering a single date", false)).
                  addResponseValue(new JsonResponse("showtimes",
                        new JsonResponseProperty("showtimes", "object", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/redemption").
            addAction(new GetAction("returns relevant redemption offers.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Redemptions response", new JsonResponseProperty("redemptions", "array", true)))).
            addAction(new PostAction("Redeem redemption", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addFormParam(new UUIDParam("redemptionId", "redemption id", true)).
                  addResponseValue(new JsonResponse("Redeemed redemption confirmation",
                        new JsonResponseProperty("redemptionActivityId", "string", true),
                        new JsonResponseProperty("redemptionId", "string", true),
                        new JsonResponseProperty("title", "string", true),
                        new JsonResponseProperty("description", "string", true),
                        new JsonResponseProperty("code", "string", true),
                        new JsonResponseProperty("value", "integer", true),
                        new JsonResponseProperty("currency", "long", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/redemption/ledger").
            addAction(new GetAction("returns user redemption ledger.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Redemption ledger (activities)",
                        new JsonResponseProperty("redemptions", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/engagement").
            addAction(new GetAction("returns user engagement activities.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  setErrorCodes("400", "404").
                  addResponseValue(new JsonResponse("Engagements response",
                        new JsonResponseProperty("available", "array", true),
                        new JsonResponseProperty("lastEngagements", "array", true)))).

            addAction(new PostAction("POST Did Engagement Activities", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addFormParam(new UUIDParam("engagementId", "engagement id", true)).
                  addFormParam(new UUIDParam("gameId", "optional game id", false)).
                  addFormParam(new StringParam("engagementdatetime", "date and time", true, "2016-12-31 18:05:00")).
                  addFormParam(new UUIDParam("filmId", "film id", false)).
                  addFormParam(new UUIDParam("trailerId", "trailer id", false)).
                  addFormParam(new IntegerParam("rating", "film/trailer rating", 0, 10, false)).
                  addFormParam(new LatitudeParam(false)).
                  addFormParam(new LongitudeParam(false)).
                  addResponseValue(new JsonResponse("Post engagement balance",
                        new JsonResponseProperty("engagementCategory", "string", true),
                        new JsonResponseProperty("type", "string", true),
                        new JsonResponseProperty("currency", "integer", true),
                        new JsonResponseProperty("id", "string", true),
                        new JsonResponseProperty("latitude", "long", false),
                        new JsonResponseProperty("longitude", "long", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/engagement/ledger").
            addAction(new GetAction("returns user engagement ledger.", AuthType.OAUTH2_USER_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Engagement ledger (activities)",
                        new JsonResponseProperty("engagements", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/films/latest").
            addAction(new GetAction("returns film listings by cinema.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UserIdParam(false)).
                  setErrorCodes("400", "404").
                  addResponseValue(new JsonResponse("Films response",
                        new JsonResponseProperty("films", "array", true),
                        new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/cinema/listing").
            addAction(new GetAction("returns cinema listing.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new UUIDParam("filmId", "film id", false)).
                  addQueryParam(new LatitudeParam(true)).
                  addQueryParam(new LongitudeParam(true)).
                  addQueryParam(new IntegerParam("radius", "radius in metres", 1, 3185000, false, 5000)).
                  addResponseValue(new JsonResponse("Cinemas response",
                        new JsonResponseProperty("cinemas", "array", true),
                        new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/cinema/nearby").
            addAction(new GetAction("returns nearby cinemas.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addQueryParam(new LatitudeParam(true)).
                  addQueryParam(new LongitudeParam(true)).
                  addQueryParam(new IntegerParam("radius", "radius in metres", 1, 3185000, false, 5000)).
                  addResponseValue(new JsonResponse("Cinemas response",
                        new JsonResponseProperty("cinemas", "array", true))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").addEndpoint(new Endpoint("/trailers").
            addAction(new GetAction("returns trailers and ratings.", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                  addResponseValue(new JsonResponse("Trailers response",
                        new JsonResponseProperty("trailers", "array", true),
                        new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/images/films").
                  addUriParam(new UUIDParam("imageId", "the film image id")).
                  addAction(new GetAction("returns images for films", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addHeader(new HttpHeaderIfModifiedSince()).
                        addQueryParam(new IntegerParam("width", "resize width", 1, Integer.MAX_VALUE, false)).
                        addQueryParam(new IntegerParam("height", "resize height", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new ImageResponse("the image")).
                        setErrorCodes("400", "401", "404"))).addToRAML(loopsi);


      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/images/trailers").
                  addUriParam(new UUIDParam("imageId", "the trailer image id")).
                  addAction(new GetAction("returns images for trailers", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addHeader(new HttpHeaderIfModifiedSince()).
                        addQueryParam(new IntegerParam("width", "resize width", 1, Integer.MAX_VALUE, false)).
                        addQueryParam(new IntegerParam("height", "resize height", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new ImageResponse("the image")).
                        setErrorCodes("400", "401", "404"))).addToRAML(loopsi);

      new APIBuilder().
            setName("").
            addEndpoint(new Endpoint("/images/redemptions").
                  addUriParam(new UUIDParam("imageId", "the redemption image id")).
                  addAction(new GetAction("returns images for redemptions", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addHeader(new HttpHeaderIfModifiedSince()).
                        addQueryParam(new IntegerParam("width", "resize width", 1, Integer.MAX_VALUE, false)).
                        addQueryParam(new IntegerParam("height", "resize height", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new ImageResponse("the redemption image")).
                        setErrorCodes("400", "401", "404"))).addToRAML(loopsi);

      new APIBuilder().
            setName("badgeImageAPI").
            addEndpoint(new Endpoint("/images/badges").
                  addUriParam(new UUIDParam("imageId", "the badge image id")).
                  addAction(new GetAction("returns images for films", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addHeader(new HttpHeaderIfModifiedSince()).
                        addQueryParam(new IntegerParam("width", "resize width", 1, Integer.MAX_VALUE, false)).
                        addQueryParam(new IntegerParam("height", "resize height", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new ImageResponse("badge image")).
                        setErrorCodes("400", "401", "404"))).addToRAML(loopsi);

      new APIBuilder().
            setName("gameImageAPI").
            addEndpoint(new Endpoint("/images/games").
                  addUriParam(new UUIDParam("imageId", "the game image id")).
                  addAction(new GetAction("returns images for games", AuthType.OAUTH2_CLIENT_ACCESS_TOKEN).
                        addHeader(new HttpHeaderIfModifiedSince()).
                        addQueryParam(new IntegerParam("width", "resize width", 1, Integer.MAX_VALUE, false)).
                        addQueryParam(new IntegerParam("height", "resize height", 1, Integer.MAX_VALUE, false)).
                        addResponseValue(new ImageResponse("game image")).
                        setErrorCodes("400", "401", "404"))).addToRAML(loopsi);

      FileUtil.write(loopsi, new File(outputFile));
   }
}