package com.generator.generators.raml;

import com.generator.generators.loopsi.LoopsiGroup;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

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
public class APIGenerator extends Domain {

	public static void main(String[] args) throws IOException {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		new APIGenerator().generateRamlFile(args[0] + "/web/api/loopsi/loopsi.raml");
		new APIGenerator().generateAdminUI(args[0]);
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

			final LoopsiGroup.GridEditorHtmlST editorHtmlST = loopsiGroup.newGridEditorHtml().
				setTitle(title);

			for (String key : properties.keySet()) {
				final ItemProperty itemProperty = properties.get(key).asHtml(editorHtmlST);

			}

			return editorHtmlST;
		}

		Object asGridEditorJS() {

			final LoopsiGroup.GridEditorST editorST = loopsiGroup.newGridEditor().
				setName(plural()).
				setLabel(label);

			for (String key : properties.keySet()) {
				final ItemProperty itemProperty = properties.get(key);

				editorST.addPropertiesValue(itemProperty.defaultValue, key);

				if (itemProperty instanceof EnumProperty) {
					editorST.addEnumDeclarationsValue(((EnumProperty) itemProperty).asJSDeclaration());
					//;
				}

			}

			return editorST;
		}
	}

	class ItemProperty {

		final String name;
		final String type;
		String defaultValue;

		ItemProperty(String name, String type) {
			this.name = name;
			this.type = type;
		}

		public Object asHtmlComponent() {
			return "<input class='form-control' data-bind='value: " + name + "' />";
		}

		public ItemProperty asHtml(LoopsiGroup.GridEditorHtmlST editorHtmlST) {
			editorHtmlST.addPropertiesValue(asHtmlComponent(), name);
			return this;
		}
	}

	class StringProperty extends ItemProperty {

		StringProperty(String name) {
			super(name, "String");
		}

		public Object asHtmlComponent() {
			return "<input class='form-control' data-bind='value: " + name + "' />";
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

		@Override
		public Object asHtmlComponent() {
			return "<select class=\"form-control\" data-bind='options: $root." + name + "Options, value: " + name + "'></select>";
		}

		public Object asJSDeclaration() {
			final StringBuilder out = new StringBuilder();
			boolean first = true;
			for (String item : values) {
				if (!first) out.append(", ");
				first = false;
				out.append("\"").append(item).append("\"");
			}

			return "self." + name + "Options =[" + out + "];";
		}
	}

	class DateProperty extends ItemProperty {

		DateProperty(String name) {
			super(name, "Enum");
			this.defaultValue = LocalDate.now().toString();
		}
	}


	public void generateAdminUI(String root) throws IOException {

		// todo: turn this into a visitor
		String webRoot = new File(root, "/web/admin/app/").getAbsolutePath();
		String srcRoot = new File(root, "/java/").getAbsolutePath();

		final LoopsiGroup.apiST newapi = loopsiGroup.newapi().
			setName("AdminAPI").
			setPackageName("com.udc.loopsi.api").
			addMessagesValue(getAllLabels(), "GetAllLabels").
			addMessagesValue(GetAllRelationships(), "GetAllRelationships").
			addMessagesValue(GetNodesByLabel(), "GetNodesByLabel").
			addMessagesValue(FindNodesWithProperties(), "FindNodesWithProperties").
			addMessagesValue(SaveNode(), "SaveNode").
			addMessagesValue(DeleteNode(), "DeleteNode").
			addMessagesValue(AddRelationship(), "AddRelationship").
			addMessagesValue(RemoveRelationship(), "RemoveRelationship");

		FileUtil.writeFile(newapi, GeneratedFile.newJavaFile(srcRoot, "com.udc.loopsi.api", "AdminAPI").getFile());

		final APIEntity[] apiEntities = new APIEntity[]{

			new APIEntity("Badge", "Badges", "Badges").
				addProperty(new StringProperty("title")).
				addProperty(new StringProperty("description")),

			new APIEntity("CinemaGroup", "CinemaGroups", "Cinema Groups").
				addProperty(new StringProperty("cinemaGroupName")),

			new APIEntity("Cinema", "Cinemas", "Cinemas").
				addProperty(new StringProperty("name")).
				addProperty(new StringProperty("location")).
				addProperty(new StringProperty("address")).
				addProperty(new StringProperty("country")).
				addProperty(new LatitudeProperty("latitude")).
				addProperty(new LongitudeProperty("longitude")).
				addProperty(new StringProperty("country")),

			//todo currency - analyse


			// filmId, title, releaseDate, studio, certification, country, language, description, bannerImage, directors, actors, filmExtId, imdbId,
			new APIEntity("Film", "Films", "Films").
				addProperty(new StringProperty("title")).
				addProperty(new DateProperty("releaseDate")).
				addProperty(new StringProperty("studio")).
				addProperty(new StringProperty("certification")).
				addProperty(new StringProperty("country")).
				addProperty(new StringProperty("language")).
				addProperty(new StringProperty("des")).
				addProperty(new StringProperty("username")),

			new APIEntity("EngagementCategory", "EngagementCategories", "Engagement Categories").
				addProperty(new EnumProperty("achievementRule", "ONCE", "ONCE_PER_DAY", "ONCE_PER_ENTITY", "UNLIMITED")).
				addProperty(new StringProperty("title")).
				addProperty(new IntegerProperty("value")).
				addProperty(new EnumProperty("activityType", "NA", "FILM", "TRAILER", "GAME")),

			new APIEntity("Game", "Games", "Games").
				addProperty(new DateProperty("startDate")).
				addProperty(new DateProperty("endDate")).
				addProperty(new StringProperty("description")).
				addProperty(new StringProperty("templateId")),

			new APIEntity("Redemption", "Redemptions", "Redemptions").
				addProperty(new DateProperty("expiryDate")).
				addProperty(new IntegerProperty("currency")).
				addProperty(new IntegerProperty("available")).
				addProperty(new StringProperty("type")).
				addProperty(new StringProperty("description")).
				addProperty(new StringProperty("supplier")),   // TODO. define relation to this entity

			new APIEntity("Supplier", "Suppliers", "Suppliers").
				addProperty(new StringProperty("name")).
				addProperty(new StringProperty("town")).
				addProperty(new StringProperty("city")).
				addProperty(new StringProperty("country")).
				addProperty(new StringProperty("category")),

			new APIEntity("User", "Users", "Users").
				addProperty(new StringProperty("deviceId")).
				addProperty(new StringProperty("username")).
				addProperty(new StringProperty("password")).
				addProperty(new StringProperty("firstName")).
				addProperty(new StringProperty("lastName")).
				addProperty(new StringProperty("email")).
				addProperty(new DateProperty("dob")).
				addProperty(new EnumProperty("sex", "male", "female")).
				addProperty(new StringProperty("location")).
				addProperty(new StringProperty("country")).
				addProperty(new BooleanProperty("optInMarketing")),

			new APIEntity("Version", "Versions", "Versions").
				addProperty(new StringProperty("name")).
				addProperty(new DateProperty("releaseDate")).
				addProperty(new StringProperty("name")).
				addProperty(new StringProperty("version"))
		};

		final LoopsiGroup.shellST shellST = loopsiGroup.newshell().
			addRoutesValue("api/nodesMenu", "true", "'', 'login'", "Nodes").
			addRoutesValue("api/relationsMenu", "true", "'relations'", "Relations");

		final LoopsiGroup.mainMenuST nodesMenu = loopsiGroup.newmainMenu();
		final LoopsiGroup.mainMenuST relationsMenu = loopsiGroup.newmainMenu();

		for (APIEntity entity : apiEntities) {
			final String routingName = StringUtil.lowFirst(entity.plural());
			FileUtil.writeFile(entity.asGridEditorHtml(), new File(webRoot, "api/" + routingName + ".html"));
			FileUtil.writeFile(entity.asGridEditorJS(), new File(webRoot, "api/" + routingName + ".js"));

			shellST.addRoutesValue("api/" + routingName, null, "'" + routingName + "'", entity.title);
			nodesMenu.addItemsValue("Manage " + entity.title, entity.title, routingName);
		}

		FileUtil.writeFile(shellST, new File(webRoot, "shell.js"));

		FileUtil.writeFile(nodesMenu, new File(webRoot, "api/nodesMenu.js"));
		FileUtil.writeFile(loopsiGroup.newmainMenuHtml(), new File(webRoot, "api/nodesMenu.html"));

		FileUtil.writeFile(relationsMenu, new File(webRoot, "api/relationsMenu.js"));
		FileUtil.writeFile(loopsiGroup.newmainMenuHtml(), new File(webRoot, "api/relationsMenu.html"));

		// todo: test-cases
		// todo: routing ?
	}

	private Object getAllLabels() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final JsonArray list = new JsonArray();\n" +
				"for (Label item : model.getAllLabels())\n" +
				"\tlist.add(newJsonObject(\"name\", item.name()));\n" +
				"success(result, newJsonObject(\"list\",list));");
	}

	// getAllRelationshipTypes

	private Object GetAllRelationships() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final JsonArray list = new JsonArray();\n" +
				"for (RelationshipType item : model.getAllRelationshipTypes())\n" +
				"\tlist.add(newJsonObject(\"name\", item.name()));\n" +
				"success(result, newJsonObject(\"list\",list));");
	}

	private Object GetNodesByLabel() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final JsonArray list = new JsonArray();\n" +
				"for (Node item : model.allByLabel(parameters.getString(\"label\"))) {\n" +
				"\tfinal JsonObject jsonNode = newJsonObject();\n" +
				"\tfor (String property : item.getPropertyKeys())\n" +
				"\t\tnodeToParams(item, jsonNode, property);\n" +
				"\tlist.add(jsonNode);\n" +
				"}\n" +
				"success(result, newJsonObject(\"list\", list));");
	}

	private Object FindNodesWithProperties() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl(loopsiGroup.newconvertProperties() +
				"\n" +
				"final JsonArray list = new JsonArray();\n" +
				"for (Node item : model.matchNodesByProperties(parameters.getString(\"label\"), properties)) {\n" +
				"\tfinal JsonObject jsonNode = newJsonObject();\n" +
				"\tfor (String property : item.getPropertyKeys())\n" +
				"\t\tnodeToParams(item, jsonNode, property);\n" +
				"\tlist.add(jsonNode);\n" +
				"}\n" +
				"success(result, newJsonObject(\"list\", list));");
	}

	private Object SaveNode() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final String uuid = parameters.getString(\"uuid\");\n" +
				"final Node node = uuid.length() == 0 ? model.newNode(parameters.getString(\"label\")) : model.getNode(parameters.getString(\"label\"), UUID.fromString(uuid));\n" +
				"if (uuid.length() == 0) node.setProperty(\"createdTime\", LocalDateTime.now().toString());\n" +
				"node.setProperty(\"lastUpdateTime\", LocalDateTime.now().toString());\n" +
				"final JsonObject properties = parameters.getJsonObject(\"properties\");\n" +
				"for (String key : properties.fieldNames())\n" +
				"\tparamsToNode(properties, node, key);\n" +
				"success(result, newJsonObject(\"uuid\", NeoModel.uuidOf(node)));");
	}

	private Object DeleteNode() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("model.remove(UUID.fromString(parameters.getString(\"uuid\")));\n" +
				"success(result, newJsonObject(\"uuid\", parameters.getString(\"uuid\")));");
	}

	private Object AddRelationship() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final Node source = model.getNode(parameters.getString(\"srcLabel\"), UUID.fromString(parameters.getString(\"srcUuid\")));\n" +
				"final Node destination = model.getNode(parameters.getString(\"dstLabel\"), UUID.fromString(parameters.getString(\"dstUuid\")));\n" +
				"\n" +
				"final Relationship relationship = source.createRelationshipTo(destination, RelationshipType.withName(parameters.getString(\"relationship\")));\n" +
				"for (Object k : parameters.getJsonArray(\"properties\")) {\n" +
				"\tfinal String key = (String) k;\n" +
				"\tparamsToRelationship(parameters.getJsonObject(key), relationship, key);\n" +
				"}\n" +
				"\n" +
				"success(result, newJsonObject());");
	}

	private Object RemoveRelationship() {
		return loopsiGroup.newbaseDomainVisitor().
			setImpl("final Node source = model.getNode(parameters.getString(\"srcLabel\"), UUID.fromString(parameters.getString(\"srcUuid\")));\n" +
				"final Node destination = model.getNode(parameters.getString(\"dstLabel\"), UUID.fromString(parameters.getString(\"dstUuid\")));\n" +
				"\n" +
				"for (Relationship relationship : outgoing(source, RelationshipType.withName(parameters.getString(\"relationship\")))) {\n" +
				"\tif (other(source, relationship).equals(destination))\n" +
				"\t\trelationship.delete();\n" +
				"}\n" +
				"\n" +
				"success(result, newJsonObject());");
	}


	public void generateRamlFile(String outputFile) {

		final RamlGroup.fileST loopsi = newRamlTemplate();

		new APIBuilder().
			setName("VersionAPI").
			addEndpoint(new Endpoint("/admin/version").
				addAction(new GetAction("list of version entries", true).
					addResponseValue(new JsonResponse("list of version entries",
						new JsonResponseProperty("list", "array", true)))).
				addAction(new DeleteAction("remove version entry", true).
					addQueryParam(new UUIDParam("versionId", "version id", true, UUID.fromString("84711675-af11-477b-abef-70556ae130dc"))).
					addResponseValue(new JsonResponse("Version deletion confirmation",
						new JsonResponseProperty("versionId", "string", true)))).
				addAction(new PostAction("add a version item", true).
					addFormParam(new DateParam("releaseDate", "release date", true)).
					addFormParam(new StringParam("title", "title", true, "thetitle")).
					addFormParam(new StringParam("description", "description", true, "thedescription")).
					addFormParam(new StringParam("version", "version", true, "0.8")).
					addResponseValue(new JsonResponse("Added version confirmation",
						new JsonResponseProperty("versionId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("UserAPI").
			addEndpoint(new Endpoint("/admin/user").
				addAction(new PostAction("update user data", true).
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
				addAction(new GetAction("list of user entries", true).addResponseValue(new JsonResponse("list of user entries",
					new JsonResponseProperty("list", "array", true)))).
				addAction(new DeleteAction("remove user entry", true).addQueryParam(new UserIdParam(true)).addResponseValue(new JsonResponse("User deletion confirmation",
					new JsonResponseProperty("userId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("CurrencyAPI").
			addEndpoint(new Endpoint("/admin/currency").
				addAction(new GetAction("list of virtual currency entries", true).
					addResponseValue(new JsonResponse("list of currency entries",
						new JsonResponseProperty("list", "array", true)))).
				addAction(new DeleteAction("remove virtual currency entry", true).
					addQueryParam(new UUIDParam("currencyId", "currency id", true)).
					addResponseValue(new JsonResponse("Currency deletion confirmation",
						new JsonResponseProperty("currencyId", "string", true)))).
				addAction(new PostAction("add a virtual currency item", true).
					addFormParam(new UUIDParam("engagementId", "engagement id", true)).
					addFormParam(new IntegerParam("currencyValue", "integer", true)).
					addFormParam(new StringParam("transactionType", "to be determined", false, "thetype")).
					addFormParam(new UUIDParam("gameId", "game id", true, UUID.fromString("ab121aec-cf92-4f59-a154-ee924db700af"))).
					addResponseValue(new JsonResponse("Added currency confirmation",
						new JsonResponseProperty("currencyId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("BadgeAPI").
			addEndpoint(new Endpoint("/admin/badge").
				addAction(new GetAction("list of badge entries", true).
					addResponseValue(new JsonResponse("list of badge entries",
						new JsonResponseProperty("list", "array", true)))).
				addAction(new DeleteAction("remove badge entry", true).
					addQueryParam(new UUIDParam("badgeId", "badge id", true)).
					addResponseValue(new JsonResponse("Badge deletion confirmation",
						new JsonResponseProperty("badgeId", "string", true)))).
				addAction(new PostAction("add a badge item", true).
					setMultipart(true).
					addFormParam(new UUIDParam("gameId", "game id", true)).
					addFormParam(new StringParam("title", "title", true, "badge title")).
					addFormParam(new StringParam("description", "description", true, "badge description")).
					addFormParam(new FileParam("avatar", "user avatar", false)).
					addResponseValue(new JsonResponse("Added badge confirmation",
						new JsonResponseProperty("badgeId", "string", true))))).addToRAML(loopsi);


		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/admin/redemption").

			addAction(new GetAction("list of redemption entries", true).
				addResponseValue(new JsonResponse("list of redemption entries",
					new JsonResponseProperty("list", "array", true)))).

			addAction(new DeleteAction("remove redemption entry", true).
				addQueryParam(new UUIDParam("redemptionId", "redemption id", true)).
				addResponseValue(new JsonResponse("Redemption deletion confirmation",
					new JsonResponseProperty("redemptionId", "string", true)))).

			addAction(new PostAction("add an redemption item", true).
				setMultipart(true).
				addFormParam(new UUIDParam("supplierId", "supplier id", true)).
				addFormParam(new DateParam("earnedFrom", "earned from date", true)).
				addFormParam(new DateParam("earnedTo", "earned to date", true)).
				addFormParam(new DateParam("expiryDate", "expiry date", true)).
				addFormParam(new IntegerParam("limit", "limit", true)).
				addFormParam(new StringParam("type", "type", true, "thetype")).
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
			addAction(new GetAction("list of engagement entries", true).
				addResponseValue(new JsonResponse("list of engagement entries",
					new JsonResponseProperty("list", "array", true)))).
			addAction(new DeleteAction("remove engagement entry", true).
				addQueryParam(new UUIDParam("engagementId", "engagement id", true)).
				addResponseValue(new JsonResponse("Engagement deletion confirmation",
					new JsonResponseProperty("engagementId", "string", true)))).
			addAction(new PostAction("add an engagement item", true).
				addFormParam(new StringParam("title", "title", true, "thetitle")).
				addFormParam(new StringParam("logic", "to be determined", true, "thelogic")).
				addFormParam(new IntegerParam("value", "value", true)).
				addFormParam(new StringParam("type", "to be determined", true, "thetype")).
				addFormParam(new DateParam("earnedFrom", "earned from date", true)).
				addFormParam(new DateParam("earnedTo", "earned to date", true)).
				addFormParam(new DateParam("expiryDate", "expiry date", true)).
				addResponseValue(new JsonResponse("Added engagement confirmation",
					new JsonResponseProperty("engagementId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/admin/game").
			addAction(new GetAction("list games", true).
				addResponseValue(new JsonResponse("list of game entries",
					new JsonResponseProperty("games", "array", true)))).
			addAction(new DeleteAction("remove game entry", true).
				addQueryParam(new UUIDParam("gameId", "game id", true)).
				addResponseValue(new JsonResponse("Game deletion confirmation",
					new JsonResponseProperty("gameId", "string", true)))).
			addAction(new PostAction("add a game item", true).
				addFormParam(new DateParam("startDate", "start date", true)).
				addFormParam(new DateParam("endDate", "end date", true)).
				addFormParam(new StringParam("description", "description", true, "thedescription")).
				addFormParam(new IntegerParam("templateId", "template identifier", true)).
				addResponseValue(new JsonResponse("Added game confirmation",
					new JsonResponseProperty("gameId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/game").
				addAction(new GetAction("list games", true).
					addResponseValue(new JsonResponse("list of game entries",
						new JsonResponseProperty("games", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/admin/supplier").
			addAction(new GetAction("list of supplier entries", true).
				addResponseValue(new JsonResponse("list of supplier entries",
					new JsonResponseProperty("list", "array", true)))).
			addAction(new DeleteAction("remove supplier entry", true).
				addQueryParam(new UUIDParam("supplierId", "supplier id", true)).
				addResponseValue(new JsonResponse("Supplier deletion confirmation",
					new JsonResponseProperty("supplierId", "string", true)))).
			addAction(new PostAction("add a supplier item", true).
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
			addAction(new PostAction("force import international showtimes", true).
				addResponseValue(new JsonResponse("Import job start confirmation",
					new JsonResponseProperty("jobstart", "boolean", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/admin/film/statistics").
			addAction(new GetAction("film data statistics", true).
				addResponseValue(new JsonResponse("Film data statistics",
					new JsonResponseProperty("statistics", "object", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/oauth2/login").
			addAction(new PostAction("client login", true).
				addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "", 0, 254)).
				addFormParam(new StringParam("client_id", "OAuth2 client id - REQUIRED if not using Authorization header", false, 0, 254)).
				addFormParam(new StringParam("client_secret", "OAuth2 client secret - REQUIRED if not using Authorization header", false, 0, 254)).
				setErrorCodes("400", "401").
				addResponseValue(new JsonResponse("OAuth2 token response",
					new JsonResponseProperty("access_token", "string", true),
					new JsonResponseProperty("expires_in", "integer", true),
					new JsonResponseProperty("token_type", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/oauth2/token").
			addAction(new GetAction("verifies client access token", false).
				addQueryParam(new StringParam("access_token", "client access token", true)).
				addResponseValue(new JsonResponse("Access token verification",
					new JsonResponseProperty("verified", "boolean", true),
					new JsonResponseProperty("oa2clientId", "string", false),
					new JsonResponseProperty("client_id", "string", false),
					new JsonResponseProperty("expires_in", "integer", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/version").
			addAction(new GetAction("returns current APP version.", true).
				addResponseValue(new JsonResponse("Versions response",
					new JsonResponseProperty("version", "string", true),
					new JsonResponseProperty("description", "string", true),
					new JsonResponseProperty("releaseDate", "string", true)))).
			addAction(new PostAction("receives APP version from client and returns whether it matches the current version.", true).
				addFormParam(new StringParam("version", "APP version.", true, "0.8.1", 5, 8)).
				addResponseValue(new JsonResponse("Version response",
					new JsonResponseProperty("success", "boolean", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/user/login").
			addAction(new PostAction("user login", false).
				addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "password", 0, 254)).
				addFormParam(new StringParam("client_id", "OAuth2 client id - REQUIRED if not using Authorization header", false, 0, 254)).
				addFormParam(new StringParam("client_secret", "OAuth2 client secret - REQUIRED if not using Authorization header", false, 0, 254)).
				addFormParam(new StringParam("username", "the username", true, "theusername", 3, 10)).
				addFormParam(new StringParam("password", "the password, MD5 encoded", true, "b25bc8c9efabdd0837bb7d9deace1308", 8, Integer.MAX_VALUE)).
				addHeaderValue(new HttpHeader("Authorization", "OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters", false, "Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")).
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
				addAction(new PostAction("register facebook user", false).
					addFormParam(new StringParam("deviceId", "user device id", true, "thedeviceid", 1, Integer.MAX_VALUE)).
					addFormParam(new StringParam("fbToken", "facebook access_token", true, 1, Integer.MAX_VALUE)).
					addHeaderValue(new HttpHeader("Authorization", "OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters", false, "Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")).
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
				addAction(new PostAction("send email to reset password for user", false).
					addFormParam(new UUIDParam("userId", "the user id", false)).
					addFormParam(new StringParam("username", "the username", false, "theusername", 0, 254)).
					setErrorCodes("400", "401").
					addResponseValue(new JsonResponse("User forgot password email sent confirmation",
						new JsonResponseProperty("success", "boolean", true),
						new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/user/forgotPasswordForm").
				addAction(new PostAction("process user forgot password", false).
					addFormParam(new StringParam("password", "the password", true, "newpassword", 0, 254)).
					addFormParam(new StringParam("confirmPassword", "the confirm password", true, "newpassword", 0, 254)).
					addFormParam(new UUIDParam("forgotPasswordToken", "the reset-token", true)).
					setErrorCodes("400", "401").
					addResponseValue(new JsonResponse("User forgot password email sent confirmation",
						new JsonResponseProperty("success", "boolean", true),
						new JsonResponseProperty("dummy", "boolean", false)))).

				addAction(new GetAction("get user forgot password form", false).
					addQueryParam(new UUIDParam("forgotPasswordToken", "the reset-token", true)).
					setErrorCodes("400").
					addResponseValue(new HtmlResponse("form for resetting password")))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/user/logout").
				addAction(new GetAction("user logout", true).
					addQueryParam(new StringParam("access_token", "access token", true)).
					setErrorCodes("400").
					addResponseValue(new JsonResponse("User logout confirmation",
						new JsonResponseProperty("logout", "boolean", true),
						new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/user/token").
				addAction(new GetAction("verifies user access token", true).
					addQueryParam(new StringParam("access_token", "access token", true)).
					setErrorCodes("400", "401").
					addResponseValue(new JsonResponse("Access token verification",
						new JsonResponseProperty("verified", "boolean", true),
						new JsonResponseProperty("userId", "string", false),
						new JsonResponseProperty("expires_in", "integer", false)))).
				addAction(new PostAction("refresh user access token", true).
					addFormParam(new StringParam("grant_type", "OAuth2 grant type", true, "refresh_token", 0, 254)).
					addFormParam(new StringParam("refresh_token", "refresh token", true, 0, 254)).
					setErrorCodes("400", "401"))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/user").
			addAction(new GetAction("register and log in a temporary user", false).
				addQueryParam(new StringParam("deviceId", "user device id", true, 1, MAX_VALUE)).
				addHeaderValue(new HttpHeader("Authorization", "OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters", false, "Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")).
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
				addAction(new GetAction("query if a username, email or deviceId is registered", true).
					addQueryParam(new StringParam("deviceId", "user device id", false, 1, MAX_VALUE)).
					addQueryParam(new StringParam("username", "the username", false, "theusername", 0, 254)).
					addQueryParam(new EmailParam("email", "user email", false)).
					setErrorCodes("400").
					addResponseValue(new JsonResponse("Query response",
						new JsonResponseProperty("found", "boolean", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/user/profile").
			addAction(new GetAction("get user object", true).
				addResponseValue(new JsonResponse("User object confirmation", new JsonResponseProperty("user", "object", true)))).
			addAction(new PostAction("register new user", false).
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
				addHeaderValue(new HttpHeader("Authorization", "OAuth2 client credentials - REQUIRED if not using client_id and client_secret parameters", false, "Basic bDAwcHMxOmIzOWFlMjVlZDkwYTI5N2JmZmUzMzk4MjdhM2I5NWM3")).
				addErrorCode("409").
				addResponseValue(new JsonResponse("OAuth2 token response",
					new JsonResponseProperty("access_token", "string", true),
					new JsonResponseProperty("expires_in", "integer", true),
					new JsonResponseProperty("token_type", "string", true),
					new JsonResponseProperty("refresh_token", "string", true),
					new JsonResponseProperty("userId", "string", false),
					new JsonResponseProperty("currency", "integer", false)))).

			addAction(new DeleteAction("delete user", true).
				addErrorCode("409").
				addResponseValue(new JsonResponse("User delete confirmation",
					new JsonResponseProperty("userId", "string", true)))).

			addAction(new PutAction("update user", true).
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
			setName("").addEndpoint(new Endpoint("/currency").
			addAction(new GetAction("returns user currency value.", true).
				setErrorCodes("400", "401", "404").
				addResponseValue(new JsonResponse("Currency response",
					new JsonResponseProperty("currentValue", "integer", true)))).
			addAction(new PostAction("add currency activity to user's ledger", true).
				addFormParam(new UUIDParam("currencyId", "currency id", true)).
				addFormParam(new UUIDParam("cinemaId", "cinema id", true)).
				addFormParam(new UUIDParam("redemptionId", "redemtion id", true)).
				addFormParam(new UUIDParam("engagementId", "engagement id", true)).
				addFormParam(new IntegerParam("currencyEarned", "earned value", true, 250)).
				addFormParam(new IntegerParam("currencyRedeemed", "redeemed value", true, 500)).
				addFormParam(new LatitudeParam(false)).
				addFormParam(new LongitudeParam(false)).
				addResponseValue(new JsonResponse("Added currency activity confirmation",
					new JsonResponseProperty("currencyActivityId", "string", true)))).

			addAction(new DeleteAction("deletes a currency activity entry. *FOR MAINTENANCE/TESTING PURPOSES*", true).
				addQueryParam(new UUIDParam("currencyActivityId", "currency activity id", true)).
				setErrorCodes("400", "401", "404").
				addResponseValue(new JsonResponse("Deleted currency activity confirmation",
					new JsonResponseProperty("currencyActivityId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/currency/ledger").
				addAction(new GetAction("returns user currency ledger.", true).setErrorCodes("400", "401", "404").
					addResponseValue(new JsonResponse("Currency ledger (activities)",
						new JsonResponseProperty("list", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/badge").
				addAction(new PostAction("add badge activity to user's ledger", true).
					addFormParam(new UUIDParam("badgeId", "badge id", true)).
					addFormParam(new IntegerParam("completionPercent", "competion percentage", true, 42)).
					addResponseValue(new JsonResponse("Added badge activity confirmation",
						new JsonResponseProperty("userBadgeId", "string", true)))).
				addAction(new PutAction("update badge activity in user's ledger", true).
					addFormParam(new UUIDParam("userBadgeId", "user badge id", true)).
					addFormParam(new IntegerParam("completionPercent", "competion percentage", true, 42)).
					addResponseValue(new JsonResponse("Updated badge activity confirmation",
						new JsonResponseProperty("userBadgeId", "string", true)))).
				addAction(new DeleteAction("deletes a badge activity entry. *FOR MAINTENANCE/TESTING PURPOSES*", true).
					addQueryParam(new UUIDParam("userBadgeId", "badge activity id", true)).
					setErrorCodes("400", "401", "404").
					addResponseValue(new JsonResponse("Deleted badge activity confirmation",
						new JsonResponseProperty("userBadgeId", "string", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/badge/earned").
			addAction(new GetAction("returns user badges earned.", true).
				addResponseValue(new JsonResponse("Badges response",
					new JsonResponseProperty("badges", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/badge/available").
			addAction(new GetAction("returns badges available.", true).
				addQueryParam(new UUIDParam("gameId", "game id", true)).
				addResponseValue(new JsonResponse("Badges response",
					new JsonResponseProperty("badges", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/leaderboard/gamescoresfb").
			addAction(new GetAction("returns fb friends gamescores for game", true).
				addQueryParam(new UUIDParam("userId", "user id", true)).
				addQueryParam(new UUIDParam("gameId", "game id", true)).
				addResponseValue(new JsonResponse("scores",
					new JsonResponseProperty("scores", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/leaderboard/gamescores").
				addAction(new PostAction("post gamescore",
					true).
					addFormParam(new UUIDParam("gameId", "game id", true)).
					addFormParam(new IntegerParam("score", "game score", 0, Integer.MAX_VALUE, true)).
					addFormParam(new LatitudeParam(false)).
					addFormParam(new LongitudeParam(false)).
					addFormParam(new UUIDParam("userId", "user id", true)).
					addResponseValue(new JsonResponse("game score posted",
						new JsonResponseProperty("success", "boolean", true)))).

				addAction(new GetAction("returns global gamescores for game", true).
					addQueryParam(new UUIDParam("gameId", "game id", true)).
					addResponseValue(new JsonResponse("scores",
						new JsonResponseProperty("scores", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/films/watchlist").
			addAction(new PostAction("add film to watchlist", true).
				addFormParam(new UUIDParam("filmId", "film id", true)).
				addResponseValue(new JsonResponse("film added to watchlist",
					new JsonResponseProperty("success", "boolean", true)))).
			addAction(new GetAction("get watchlist for friends", true).
				addQueryParam(new UUIDParam("filmId", "film id", true)).
				addResponseValue(new JsonResponse("watchlist of friends",
					new JsonResponseProperty("watchlist", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/showtimes").
			addAction(new GetAction("get showtimes for film or cinema", true).
				addQueryParam(new UUIDParam("cinemaId", "cinema id", false)).
				addQueryParam(new UUIDParam("filmId", "film id", false)).
				addResponseValue(new JsonResponse("showtimes",
					new JsonResponseProperty("showtimes", "object", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/redemption").
			addAction(new GetAction("returns relevant redemption offers.", true).
				addResponseValue(new JsonResponse("Redemptions response", new JsonResponseProperty("redemptions", "array", true)))).
			addAction(new PostAction("Redeem redemption", true).
				addFormParam(new UUIDParam("redemptionId", "redemption id", true)).
				addResponseValue(new JsonResponse("Redeemed redemption confirmation",
					new JsonResponseProperty("redemptionActivityId", "string", true),
					new JsonResponseProperty("redemptionId", "string", true),
					new JsonResponseProperty("type", "string", true),
					new JsonResponseProperty("description", "string", true),
					new JsonResponseProperty("value", "integer", true),
					new JsonResponseProperty("currency", "long", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/redemption/ledger").
			addAction(new GetAction("returns user redemption ledger.", true).
				addResponseValue(new JsonResponse("Redemption ledger (activities)",
					new JsonResponseProperty("redemptions", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/engagement").
			addAction(new GetAction("returns user engagement activities.", true).
				setErrorCodes("400", "404").
				addResponseValue(new JsonResponse("Engagements response",
					new JsonResponseProperty("available", "array", true),
					new JsonResponseProperty("lastEngagements", "array", true)))).

			addAction(new PostAction("POST Did Engagement Activities", true).
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
			setName("").addEndpoint(new Endpoint("/films/latest").
			addAction(new GetAction("returns film listings by cinema.", true).
				setErrorCodes("400", "404").
				addResponseValue(new JsonResponse("Films response",
					new JsonResponseProperty("films", "array", true),
					new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/cinema/listing").
			addAction(new GetAction("returns cinema listing.", true).
				addQueryParam(new UUIDParam("filmId", "film id", false)).
				addQueryParam(new LatitudeParam(true)).
				addQueryParam(new LongitudeParam(true)).
				addResponseValue(new JsonResponse("Cinemas response",
					new JsonResponseProperty("cinemas", "array", true),
					new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/cinema/nearby").
			addAction(new GetAction("returns nearby cinemas.", true).
				addQueryParam(new LatitudeParam(true)).
				addQueryParam(new LongitudeParam(true)).
				addQueryParam(new IntegerParam("radius", "radius", 0, 3185000, true)).
				addResponseValue(new JsonResponse("Cinemas response",
					new JsonResponseProperty("cinemas", "array", true))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/trailers").
			addAction(new GetAction("returns trailers and ratings.", true).
				addResponseValue(new JsonResponse("Trailers response",
					new JsonResponseProperty("trailers", "array", true),
					new JsonResponseProperty("dummy", "boolean", false))))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/images/films/").
			addAction(new URIParameterAction("imageId", "the film image id").
				addAction(new GetAction("returns images for films", true)).
				addResponseValue(new ImageResponse("the image")))).addToRAML(loopsi);


		new APIBuilder().
			setName("").
			addEndpoint(new Endpoint("/images/trailers/").
				addAction(new URIParameterAction("imageId", "the trailer image id").
					addAction(new GetAction("returns images for trailers", true)).
					addResponseValue(new ImageResponse("the image")))).addToRAML(loopsi);

		new APIBuilder().
			setName("").addEndpoint(new Endpoint("/images/redemptions/").
			addAction(new URIParameterAction("imageId", "the redemption image id").
				addAction(new GetAction("returns images for redemptions", true)).
				addResponseValue(new ImageResponse("the redemption image")))).addToRAML(loopsi);

		new APIBuilder().
			setName("badgeImageAPI").
			addEndpoint(new Endpoint("/images/badges/").
				addAction(new URIParameterAction("imageId", "the badge image id").
					addAction(new GetAction("returns images for films", true).
						addResponseValue(new ImageResponse("badge image"))).
					setErrorCodes("400", "404"))).addToRAML(loopsi);

		new APIBuilder().
			setName("gameImageAPI").
			addEndpoint(new Endpoint("/images/games/").
				addAction(new URIParameterAction("gameId", "the game image id").
					addAction(new GetAction("returns images for games", true).
						addResponseValue(new ImageResponse("game image"))).
					setErrorCodes("400", "404"))).addToRAML(loopsi);

		FileUtil.write(loopsi, new File(outputFile));
	}
}