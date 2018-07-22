package com.nextgen.core.template;

import io.vertx.core.*;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// verticle for Template
public class TemplateVerticle extends AbstractVerticle {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateVerticle.class);

	protected GraphDatabaseService db;

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		log.info("starting TemplateVerticle");

		vertx.executeBlocking(future -> {

			try {

				final String path = config().getString("path");
				log.info("Starting db at " + path);

				if (path == null || path.length() == 0)
				throw new IllegalArgumentException("missing 'path' config parameter");

				db = new GraphDatabaseFactory().
					newEmbeddedDatabaseBuilder(new File(path)).
					setConfig(GraphDatabaseSettings.allow_upgrade, "true").
					newGraphDatabase();

				try (Transaction tx = db.beginTx()) {
					try {
						onDatabaseStarted(tx, config());
						tx.success();
						future.complete();
					} catch (Exception e) {
						log.error(deploymentID() + " exception onDatabaseStarted " + e.getMessage(), e);
						tx.failure();
						future.fail(e);
					}
				}

			} catch (Throwable throwable) {
				log.error("executeBlocking exception : " + throwable.getMessage(), throwable);
				future.fail(throwable);
			}

		}, res -> {

			if (res.failed()) {
				log.error("failed to start TemplateVerticle : ", res.cause());
				startFuture.fail(res.cause());

			} else {
				log.info("started TemplateVerticle successfully ");
				vertx.eventBus().consumer(deploymentID(), this::handleInstanceMessage);

				vertx.eventBus().consumer("template.new.sTGroup", new TransactionMessageHandler("new.sTGroup", onNewSTGroup()));
				vertx.eventBus().consumer("template.update.sTGroup", new TransactionMessageHandler("update.sTGroup", onUpdateSTGroup()));
				vertx.eventBus().consumer("template.get.sTGroup", new TransactionMessageHandler("get.sTGroup", onGetSTGroup()));
				vertx.eventBus().consumer("template.delete.sTGroup", new TransactionMessageHandler("delete.sTGroup", onDeleteSTGroup()));
				vertx.eventBus().consumer("template.get.all.sTGroup", new TransactionMessageHandler("getAll.sTGroup", onGetAllSTGroup()));

				vertx.eventBus().consumer("template.new.sTTemplate", new TransactionMessageHandler("new.sTTemplate", onNewSTTemplate()));
				vertx.eventBus().consumer("template.update.sTTemplate", new TransactionMessageHandler("update.sTTemplate", onUpdateSTTemplate()));
				vertx.eventBus().consumer("template.get.sTTemplate", new TransactionMessageHandler("get.sTTemplate", onGetSTTemplate()));
				vertx.eventBus().consumer("template.delete.sTTemplate", new TransactionMessageHandler("delete.sTTemplate", onDeleteSTTemplate()));
				vertx.eventBus().consumer("template.get.all.sTTemplate", new TransactionMessageHandler("getAll.sTTemplate", onGetAllSTTemplate()));

				vertx.eventBus().consumer("template.new.sTTemplateParameter", new TransactionMessageHandler("new.sTTemplateParameter", onNewSTTemplateParameter()));
				vertx.eventBus().consumer("template.update.sTTemplateParameter", new TransactionMessageHandler("update.sTTemplateParameter", onUpdateSTTemplateParameter()));
				vertx.eventBus().consumer("template.get.sTTemplateParameter", new TransactionMessageHandler("get.sTTemplateParameter", onGetSTTemplateParameter()));
				vertx.eventBus().consumer("template.delete.sTTemplateParameter", new TransactionMessageHandler("delete.sTTemplateParameter", onDeleteSTTemplateParameter()));
				vertx.eventBus().consumer("template.get.all.sTTemplateParameter", new TransactionMessageHandler("getAll.sTTemplateParameter", onGetAllSTTemplateParameter()));

				vertx.eventBus().consumer("template.new.sTKeyValue", new TransactionMessageHandler("new.sTKeyValue", onNewSTKeyValue()));
				vertx.eventBus().consumer("template.update.sTKeyValue", new TransactionMessageHandler("update.sTKeyValue", onUpdateSTKeyValue()));
				vertx.eventBus().consumer("template.get.sTKeyValue", new TransactionMessageHandler("get.sTKeyValue", onGetSTKeyValue()));
				vertx.eventBus().consumer("template.delete.sTKeyValue", new TransactionMessageHandler("delete.sTKeyValue", onDeleteSTKeyValue()));
				vertx.eventBus().consumer("template.get.all.sTKeyValue", new TransactionMessageHandler("getAll.sTKeyValue", onGetAllSTKeyValue()));

				vertx.eventBus().consumer("template.new.value", new TransactionMessageHandler("new.value", onNewValue()));
				vertx.eventBus().consumer("template.update.value", new TransactionMessageHandler("update.value", onUpdateValue()));
				vertx.eventBus().consumer("template.get.value", new TransactionMessageHandler("get.value", onGetValue()));
				vertx.eventBus().consumer("template.delete.value", new TransactionMessageHandler("delete.value", onDeleteValue()));
				vertx.eventBus().consumer("template.get.all.value", new TransactionMessageHandler("getAll.value", onGetAllValue()));

				vertx.eventBus().consumer("template.new.sTInstance", new TransactionMessageHandler("new.sTInstance", onNewSTInstance()));
				vertx.eventBus().consumer("template.update.sTInstance", new TransactionMessageHandler("update.sTInstance", onUpdateSTInstance()));
				vertx.eventBus().consumer("template.get.sTInstance", new TransactionMessageHandler("get.sTInstance", onGetSTInstance()));
				vertx.eventBus().consumer("template.delete.sTInstance", new TransactionMessageHandler("delete.sTInstance", onDeleteSTInstance()));
				vertx.eventBus().consumer("template.get.all.sTInstance", new TransactionMessageHandler("getAll.sTInstance", onGetAllSTInstance()));

				vertx.eventBus().consumer("template.new.renderer", new TransactionMessageHandler("new.renderer", onNewRenderer()));
				vertx.eventBus().consumer("template.update.renderer", new TransactionMessageHandler("update.renderer", onUpdateRenderer()));
				vertx.eventBus().consumer("template.get.renderer", new TransactionMessageHandler("get.renderer", onGetRenderer()));
				vertx.eventBus().consumer("template.delete.renderer", new TransactionMessageHandler("delete.renderer", onDeleteRenderer()));
				vertx.eventBus().consumer("template.get.all.renderer", new TransactionMessageHandler("getAll.renderer", onGetAllRenderer()));

				vertx.eventBus().consumer("template.new.groupRenderer", new TransactionMessageHandler("new.groupRenderer", onNewGroupRenderer()));
				vertx.eventBus().consumer("template.update.groupRenderer", new TransactionMessageHandler("update.groupRenderer", onUpdateGroupRenderer()));
				vertx.eventBus().consumer("template.get.groupRenderer", new TransactionMessageHandler("get.groupRenderer", onGetGroupRenderer()));
				vertx.eventBus().consumer("template.delete.groupRenderer", new TransactionMessageHandler("delete.groupRenderer", onDeleteGroupRenderer()));
				vertx.eventBus().consumer("template.get.all.groupRenderer", new TransactionMessageHandler("getAll.groupRenderer", onGetAllGroupRenderer()));

				vertx.eventBus().consumer("template.relate.sTGroup.TEMPLATE.sTTemplate", new TransactionMessageHandler("template.relate.sTGroup.TEMPLATE.sTTemplate", onRelate_STGroup_TEMPLATE_STTemplate()));
				vertx.eventBus().consumer("template.get.sTGroup.TEMPLATE.sTTemplate", new TransactionMessageHandler("template.get.sTGroup.TEMPLATE.sTTemplate", onGet_STGroup_TEMPLATE_FOR_STTemplate()));
				vertx.eventBus().consumer("template.get.sTTemplate.TEMPLATE.sTGroup", new TransactionMessageHandler("template.get.sTTemplate.TEMPLATE.sTGroup", onGet_STTemplate_TEMPLATE_FOR_STGroup()));
				vertx.eventBus().consumer("template.update.TEMPLATE", new TransactionMessageHandler("template.update.TEMPLATE", onUpdate_TEMPLATE()));

				vertx.eventBus().consumer("template.relate.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", new TransactionMessageHandler("template.relate.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", onRelate_SrcSTTemplate_CHILD_TEMPLATE_STTemplate()));
				vertx.eventBus().consumer("template.get.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", new TransactionMessageHandler("template.get.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", onGet_SrcSTTemplate_CHILD_TEMPLATE_FOR_STTemplate()));
				vertx.eventBus().consumer("template.get.sTTemplate.CHILD_TEMPLATE.srcSTTemplate", new TransactionMessageHandler("template.get.sTTemplate.CHILD_TEMPLATE.srcSTTemplate", onGet_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate()));
				vertx.eventBus().consumer("template.update.CHILD_TEMPLATE", new TransactionMessageHandler("template.update.CHILD_TEMPLATE", onUpdate_CHILD_TEMPLATE()));

				vertx.eventBus().consumer("template.relate.sTTemplate.PARAMETER.sTTemplateParameter", new TransactionMessageHandler("template.relate.sTTemplate.PARAMETER.sTTemplateParameter", onRelate_STTemplate_PARAMETER_STTemplateParameter()));
				vertx.eventBus().consumer("template.get.sTTemplate.PARAMETER.sTTemplateParameter", new TransactionMessageHandler("template.get.sTTemplate.PARAMETER.sTTemplateParameter", onGet_STTemplate_PARAMETER_FOR_STTemplateParameter()));
				vertx.eventBus().consumer("template.get.sTTemplateParameter.PARAMETER.sTTemplate", new TransactionMessageHandler("template.get.sTTemplateParameter.PARAMETER.sTTemplate", onGet_STTemplateParameter_PARAMETER_FOR_STTemplate()));
				vertx.eventBus().consumer("template.update.PARAMETER", new TransactionMessageHandler("template.update.PARAMETER", onUpdate_PARAMETER()));

				vertx.eventBus().consumer("template.relate.sTTemplateParameter.KEY_VALUE.sTKeyValue", new TransactionMessageHandler("template.relate.sTTemplateParameter.KEY_VALUE.sTKeyValue", onRelate_STTemplateParameter_KEY_VALUE_STKeyValue()));
				vertx.eventBus().consumer("template.get.sTTemplateParameter.KEY_VALUE.sTKeyValue", new TransactionMessageHandler("template.get.sTTemplateParameter.KEY_VALUE.sTKeyValue", onGet_STTemplateParameter_KEY_VALUE_FOR_STKeyValue()));
				vertx.eventBus().consumer("template.get.sTKeyValue.KEY_VALUE.sTTemplateParameter", new TransactionMessageHandler("template.get.sTKeyValue.KEY_VALUE.sTTemplateParameter", onGet_STKeyValue_KEY_VALUE_FOR_STTemplateParameter()));
				vertx.eventBus().consumer("template.update.KEY_VALUE", new TransactionMessageHandler("template.update.KEY_VALUE", onUpdate_KEY_VALUE()));

				vertx.eventBus().consumer("template.relate.value.KEY_REFERENCE.sTKeyValue", new TransactionMessageHandler("template.relate.value.KEY_REFERENCE.sTKeyValue", onRelate_Value_KEY_REFERENCE_STKeyValue()));
				vertx.eventBus().consumer("template.get.value.KEY_REFERENCE.sTKeyValue", new TransactionMessageHandler("template.get.value.KEY_REFERENCE.sTKeyValue", onGet_Value_KEY_REFERENCE_FOR_STKeyValue()));
				vertx.eventBus().consumer("template.get.sTKeyValue.KEY_REFERENCE.value", new TransactionMessageHandler("template.get.sTKeyValue.KEY_REFERENCE.value", onGet_STKeyValue_KEY_REFERENCE_FOR_Value()));
				vertx.eventBus().consumer("template.update.KEY_REFERENCE", new TransactionMessageHandler("template.update.KEY_REFERENCE", onUpdate_KEY_REFERENCE()));

				vertx.eventBus().consumer("template.relate.value.PARAMETER_REFERENCE.sTTemplateParameter", new TransactionMessageHandler("template.relate.value.PARAMETER_REFERENCE.sTTemplateParameter", onRelate_Value_PARAMETER_REFERENCE_STTemplateParameter()));
				vertx.eventBus().consumer("template.get.value.PARAMETER_REFERENCE.sTTemplateParameter", new TransactionMessageHandler("template.get.value.PARAMETER_REFERENCE.sTTemplateParameter", onGet_Value_PARAMETER_REFERENCE_FOR_STTemplateParameter()));
				vertx.eventBus().consumer("template.get.sTTemplateParameter.PARAMETER_REFERENCE.value", new TransactionMessageHandler("template.get.sTTemplateParameter.PARAMETER_REFERENCE.value", onGet_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value()));
				vertx.eventBus().consumer("template.update.PARAMETER_REFERENCE", new TransactionMessageHandler("template.update.PARAMETER_REFERENCE", onUpdate_PARAMETER_REFERENCE()));

				vertx.eventBus().consumer("template.relate.srcValue.KV_VALUES.value", new TransactionMessageHandler("template.relate.srcValue.KV_VALUES.value", onRelate_SrcValue_KV_VALUES_Value()));
				vertx.eventBus().consumer("template.get.srcValue.KV_VALUES.value", new TransactionMessageHandler("template.get.srcValue.KV_VALUES.value", onGet_SrcValue_KV_VALUES_FOR_Value()));
				vertx.eventBus().consumer("template.get.value.KV_VALUES.srcValue", new TransactionMessageHandler("template.get.value.KV_VALUES.srcValue", onGet_Value_KV_VALUES_FOR_SrcValue()));
				vertx.eventBus().consumer("template.update.KV_VALUES", new TransactionMessageHandler("template.update.KV_VALUES", onUpdate_KV_VALUES()));

				vertx.eventBus().consumer("template.relate.value.INSTANCE_REFERENCE.sTInstance", new TransactionMessageHandler("template.relate.value.INSTANCE_REFERENCE.sTInstance", onRelate_Value_INSTANCE_REFERENCE_STInstance()));
				vertx.eventBus().consumer("template.get.value.INSTANCE_REFERENCE.sTInstance", new TransactionMessageHandler("template.get.value.INSTANCE_REFERENCE.sTInstance", onGet_Value_INSTANCE_REFERENCE_FOR_STInstance()));
				vertx.eventBus().consumer("template.get.sTInstance.INSTANCE_REFERENCE.value", new TransactionMessageHandler("template.get.sTInstance.INSTANCE_REFERENCE.value", onGet_STInstance_INSTANCE_REFERENCE_FOR_Value()));
				vertx.eventBus().consumer("template.update.INSTANCE_REFERENCE", new TransactionMessageHandler("template.update.INSTANCE_REFERENCE", onUpdate_INSTANCE_REFERENCE()));

				vertx.eventBus().consumer("template.relate.sTInstance.VALUES.value", new TransactionMessageHandler("template.relate.sTInstance.VALUES.value", onRelate_STInstance_VALUES_Value()));
				vertx.eventBus().consumer("template.get.sTInstance.VALUES.value", new TransactionMessageHandler("template.get.sTInstance.VALUES.value", onGet_STInstance_VALUES_FOR_Value()));
				vertx.eventBus().consumer("template.get.value.VALUES.sTInstance", new TransactionMessageHandler("template.get.value.VALUES.sTInstance", onGet_Value_VALUES_FOR_STInstance()));
				vertx.eventBus().consumer("template.update.VALUES", new TransactionMessageHandler("template.update.VALUES", onUpdate_VALUES()));

				vertx.eventBus().consumer("template.relate.sTInstance.RENDERER.renderer", new TransactionMessageHandler("template.relate.sTInstance.RENDERER.renderer", onRelate_STInstance_RENDERER_Renderer()));
				vertx.eventBus().consumer("template.get.sTInstance.RENDERER.renderer", new TransactionMessageHandler("template.get.sTInstance.RENDERER.renderer", onGet_STInstance_RENDERER_FOR_Renderer()));
				vertx.eventBus().consumer("template.get.renderer.RENDERER.sTInstance", new TransactionMessageHandler("template.get.renderer.RENDERER.sTInstance", onGet_Renderer_RENDERER_FOR_STInstance()));
				vertx.eventBus().consumer("template.update.RENDERER", new TransactionMessageHandler("template.update.RENDERER", onUpdate_RENDERER()));

				vertx.eventBus().consumer("template.relate.sTInstance.INSTANCE.sTTemplate", new TransactionMessageHandler("template.relate.sTInstance.INSTANCE.sTTemplate", onRelate_STInstance_INSTANCE_STTemplate()));
				vertx.eventBus().consumer("template.get.sTInstance.INSTANCE.sTTemplate", new TransactionMessageHandler("template.get.sTInstance.INSTANCE.sTTemplate", onGet_STInstance_INSTANCE_FOR_STTemplate()));
				vertx.eventBus().consumer("template.get.sTTemplate.INSTANCE.sTInstance", new TransactionMessageHandler("template.get.sTTemplate.INSTANCE.sTInstance", onGet_STTemplate_INSTANCE_FOR_STInstance()));
				vertx.eventBus().consumer("template.update.INSTANCE", new TransactionMessageHandler("template.update.INSTANCE", onUpdate_INSTANCE()));

				vertx.eventBus().consumer("template.relate.groupRenderer.GROUP_RENDERER.sTGroup", new TransactionMessageHandler("template.relate.groupRenderer.GROUP_RENDERER.sTGroup", onRelate_GroupRenderer_GROUP_RENDERER_STGroup()));
				vertx.eventBus().consumer("template.get.groupRenderer.GROUP_RENDERER.sTGroup", new TransactionMessageHandler("template.get.groupRenderer.GROUP_RENDERER.sTGroup", onGet_GroupRenderer_GROUP_RENDERER_FOR_STGroup()));
				vertx.eventBus().consumer("template.get.sTGroup.GROUP_RENDERER.groupRenderer", new TransactionMessageHandler("template.get.sTGroup.GROUP_RENDERER.groupRenderer", onGet_STGroup_GROUP_RENDERER_FOR_GroupRenderer()));
				vertx.eventBus().consumer("template.update.GROUP_RENDERER", new TransactionMessageHandler("template.update.GROUP_RENDERER", onUpdate_GROUP_RENDERER()));

				vertx.eventBus().consumer("template.renderSTGroup", new TransactionMessageHandler("renderSTGroup", onRenderSTGroup()));

				vertx.eventBus().consumer("template.importGroup", new TransactionMessageHandler("importGroup", onImportGroup()));

				vertx.eventBus().consumer("template.exportGroup", new TransactionMessageHandler("exportGroup", onExportGroup()));


				startFuture.complete();
			}
		});
	}

	@Override
	public void stop(Future<Void> stopFuture) throws Exception {
		if (db != null) {
			log.info("shutting down db");
			db.shutdown();
		}
		super.stop(stopFuture);
	}

	protected interface TransactionalMessageHandler {
		void handle(Transaction tx, Message<JsonObject> message) throws Exception;
	}

	protected final class TransactionMessageHandler implements Handler<Message<JsonObject>> {

		private final String messageName;
		private final TransactionalMessageHandler handler;

		TransactionMessageHandler(String messageName, TransactionalMessageHandler handler) {
			this.messageName = messageName;
			this.handler = handler;
		}

		@Override
		public void handle(Message<JsonObject> message) {
			log.info(deploymentID() + " on " + messageName + " " + message.body().encode());

			try (Transaction tx = db.beginTx()) {
				try {
					handler.handle(tx, message);
					tx.success();
				} catch (Exception e) {
					log.error(deploymentID() + " exception on " + messageName + " " + message.body().encode() + " " + e.getMessage(), e);
					tx.failure();
					message.reply(newException(e));
				}
			}
		}
	}

	// STGroup

	private TransactionalMessageHandler onNewSTGroup() {
		return (tx, message) -> {
			final JsonArray errors = new JsonArray();
			final Node node = newSTGroup(message.body().getJsonObject("STGroup"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			message.reply(newSuccess(mapNode(node, Template.Entities.STGroup)));
		};
	}

	private Node newSTGroup(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("delimiter") == null) errors.add("missing delimiter");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.STGroup);
		mapString(jsonObject, node, "delimiter");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateSTGroup() {
		return (tx, message) -> {
			final Node node = Template.findSTGroupBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STGroup not found"));
				return;
			}
			mapString(message.body().getJsonObject("STGroup"), node, "delimiter");
			mapString(message.body().getJsonObject("STGroup"), node, "name");

			message.reply(newSuccess(mapNode(node, Template.Entities.STGroup)));
		};
	}

	private TransactionalMessageHandler onDeleteSTGroup() {
		return (tx, message) -> {
			final Node node = Template.findSTGroupBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STGroup " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetSTGroup() {
		return (tx, message) -> {
			final Node node = Template.findSTGroupBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STGroup " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.STGroup)));
		};
	}

	private TransactionalMessageHandler onGetAllSTGroup() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllSTGroup(db, node -> {
				result.add(mapNode(node, Template.Entities.STGroup));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// STTemplate

	private TransactionalMessageHandler onNewSTTemplate() {
		return (tx, message) -> {
			final Node src = Template.findSTTemplateBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STGroup " + message.body().getString("STGroup") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newSTTemplate(message.body().getJsonObject("STTemplate"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("TEMPLATE"));
			message.reply(newSuccess(new JsonObject().put("TEMPLATE", mapRelation(relation)).put("STTemplate", mapNode(node, Template.Entities.STTemplate))));
		};
	}
	private Node newSTTemplate(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("text") == null) errors.add("missing text");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.STTemplate);
		mapString(jsonObject, node, "text");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateSTTemplate() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplate not found"));
				return;
			}
			mapString(message.body().getJsonObject("STTemplate"), node, "text");
			mapString(message.body().getJsonObject("STTemplate"), node, "name");

			message.reply(newSuccess(mapNode(node, Template.Entities.STTemplate)));
		};
	}

	private TransactionalMessageHandler onDeleteSTTemplate() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplate " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetSTTemplate() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplate " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.STTemplate)));
		};
	}

	private TransactionalMessageHandler onGetAllSTTemplate() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllSTTemplate(db, node -> {
				result.add(mapNode(node, Template.Entities.STTemplate));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// STTemplateParameter

	private TransactionalMessageHandler onNewSTTemplateParameter() {
		return (tx, message) -> {
			final Node src = Template.findSTTemplateParameterBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STTemplate " + message.body().getString("STTemplate") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newSTTemplateParameter(message.body().getJsonObject("STTemplateParameter"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("PARAMETER"));
			message.reply(newSuccess(new JsonObject().put("PARAMETER", mapRelation(relation)).put("STTemplateParameter", mapNode(node, Template.Entities.STTemplateParameter))));
		};
	}
	private Node newSTTemplateParameter(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("ParameterType") == null) errors.add("missing ParameterType");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.STTemplateParameter);
		mapString(jsonObject, node, "ParameterType");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateSTTemplateParameter() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplateParameter not found"));
				return;
			}
			mapString(message.body().getJsonObject("STTemplateParameter"), node, "ParameterType");
			mapString(message.body().getJsonObject("STTemplateParameter"), node, "name");

			message.reply(newSuccess(mapNode(node, Template.Entities.STTemplateParameter)));
		};
	}

	private TransactionalMessageHandler onDeleteSTTemplateParameter() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplateParameter " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetSTTemplateParameter() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STTemplateParameter " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.STTemplateParameter)));
		};
	}

	private TransactionalMessageHandler onGetAllSTTemplateParameter() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllSTTemplateParameter(db, node -> {
				result.add(mapNode(node, Template.Entities.STTemplateParameter));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// STKeyValue

	private TransactionalMessageHandler onNewSTKeyValue() {
		return (tx, message) -> {
			final Node src = Template.findSTKeyValueBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STTemplateParameter " + message.body().getString("STTemplateParameter") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newSTKeyValue(message.body().getJsonObject("STKeyValue"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("KEY_VALUE"));
			message.reply(newSuccess(new JsonObject().put("KEY_VALUE", mapRelation(relation)).put("STKeyValue", mapNode(node, Template.Entities.STKeyValue))));
		};
	}
	private Node newSTKeyValue(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.STKeyValue);
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateSTKeyValue() {
		return (tx, message) -> {
			final Node node = Template.findSTKeyValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STKeyValue not found"));
				return;
			}
			mapString(message.body().getJsonObject("STKeyValue"), node, "name");

			message.reply(newSuccess(mapNode(node, Template.Entities.STKeyValue)));
		};
	}

	private TransactionalMessageHandler onDeleteSTKeyValue() {
		return (tx, message) -> {
			final Node node = Template.findSTKeyValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STKeyValue " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetSTKeyValue() {
		return (tx, message) -> {
			final Node node = Template.findSTKeyValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STKeyValue " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.STKeyValue)));
		};
	}

	private TransactionalMessageHandler onGetAllSTKeyValue() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllSTKeyValue(db, node -> {
				result.add(mapNode(node, Template.Entities.STKeyValue));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// Value

	private TransactionalMessageHandler onNewValue() {
		return (tx, message) -> {
			final Node src = Template.findValueBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STKeyValue " + message.body().getString("STKeyValue") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newValue(message.body().getJsonObject("Value"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("KEY_REFERENCE"));
			message.reply(newSuccess(new JsonObject().put("KEY_REFERENCE", mapRelation(relation)).put("Value", mapNode(node, Template.Entities.Value))));
		};
	}
	private Node newValue(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("value") == null) errors.add("missing value");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.Value);
		mapString(jsonObject, node, "value");
		return node;
	}

	private TransactionalMessageHandler onUpdateValue() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Value not found"));
				return;
			}
			mapString(message.body().getJsonObject("Value"), node, "value");

			message.reply(newSuccess(mapNode(node, Template.Entities.Value)));
		};
	}

	private TransactionalMessageHandler onDeleteValue() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Value " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetValue() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Value " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.Value)));
		};
	}

	private TransactionalMessageHandler onGetAllValue() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllValue(db, node -> {
				result.add(mapNode(node, Template.Entities.Value));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// STInstance

	private TransactionalMessageHandler onNewSTInstance() {
		return (tx, message) -> {
			final Node src = Template.findSTInstanceBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("Value") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newSTInstance(message.body().getJsonObject("STInstance"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("INSTANCE_REFERENCE"));
			message.reply(newSuccess(new JsonObject().put("INSTANCE_REFERENCE", mapRelation(relation)).put("STInstance", mapNode(node, Template.Entities.STInstance))));
		};
	}
	private Node newSTInstance(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.STInstance);
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateSTInstance() {
		return (tx, message) -> {
			final Node node = Template.findSTInstanceBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STInstance not found"));
				return;
			}
			mapString(message.body().getJsonObject("STInstance"), node, "name");

			message.reply(newSuccess(mapNode(node, Template.Entities.STInstance)));
		};
	}

	private TransactionalMessageHandler onDeleteSTInstance() {
		return (tx, message) -> {
			final Node node = Template.findSTInstanceBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STInstance " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetSTInstance() {
		return (tx, message) -> {
			final Node node = Template.findSTInstanceBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("STInstance " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.STInstance)));
		};
	}

	private TransactionalMessageHandler onGetAllSTInstance() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllSTInstance(db, node -> {
				result.add(mapNode(node, Template.Entities.STInstance));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// Renderer

	private TransactionalMessageHandler onNewRenderer() {
		return (tx, message) -> {
			final Node src = Template.findRendererBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("STInstance") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newRenderer(message.body().getJsonObject("Renderer"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("RENDERER"));
			message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relation)).put("Renderer", mapNode(node, Template.Entities.Renderer))));
		};
	}
	private Node newRenderer(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("RenderType") == null) errors.add("missing RenderType");
		if (jsonObject.getString("path") == null) errors.add("missing path");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.Renderer);
		mapString(jsonObject, node, "RenderType");
		mapString(jsonObject, node, "path");
		return node;
	}

	private TransactionalMessageHandler onUpdateRenderer() {
		return (tx, message) -> {
			final Node node = Template.findRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Renderer not found"));
				return;
			}
			mapString(message.body().getJsonObject("Renderer"), node, "RenderType");
			mapString(message.body().getJsonObject("Renderer"), node, "path");

			message.reply(newSuccess(mapNode(node, Template.Entities.Renderer)));
		};
	}

	private TransactionalMessageHandler onDeleteRenderer() {
		return (tx, message) -> {
			final Node node = Template.findRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Renderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetRenderer() {
		return (tx, message) -> {
			final Node node = Template.findRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("Renderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.Renderer)));
		};
	}

	private TransactionalMessageHandler onGetAllRenderer() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllRenderer(db, node -> {
				result.add(mapNode(node, Template.Entities.Renderer));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// GroupRenderer

	private TransactionalMessageHandler onNewGroupRenderer() {
		return (tx, message) -> {
			final Node src = Template.findGroupRendererBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("STGroup " + message.body().getString("STGroup") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newGroupRenderer(message.body().getJsonObject("GroupRenderer"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("GROUP_RENDERER"));
			message.reply(newSuccess(new JsonObject().put("GROUP_RENDERER", mapRelation(relation)).put("GroupRenderer", mapNode(node, Template.Entities.GroupRenderer))));
		};
	}
	private Node newGroupRenderer(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("packageName") == null) errors.add("missing packageName");
		if (jsonObject.getString("root") == null) errors.add("missing root");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, Template.Entities.GroupRenderer);
		mapString(jsonObject, node, "packageName");
		mapString(jsonObject, node, "root");
		return node;
	}

	private TransactionalMessageHandler onUpdateGroupRenderer() {
		return (tx, message) -> {
			final Node node = Template.findGroupRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("GroupRenderer not found"));
				return;
			}
			mapString(message.body().getJsonObject("GroupRenderer"), node, "packageName");
			mapString(message.body().getJsonObject("GroupRenderer"), node, "root");

			message.reply(newSuccess(mapNode(node, Template.Entities.GroupRenderer)));
		};
	}

	private TransactionalMessageHandler onDeleteGroupRenderer() {
		return (tx, message) -> {
			final Node node = Template.findGroupRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("GroupRenderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetGroupRenderer() {
		return (tx, message) -> {
			final Node node = Template.findGroupRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("GroupRenderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, Template.Entities.GroupRenderer)));
		};
	}

	private TransactionalMessageHandler onGetAllGroupRenderer() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.findAllGroupRenderer(db, node -> {
				result.add(mapNode(node, Template.Entities.GroupRenderer));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// ONE 'STGroup' -> TEMPLATE -> MANY 'STTemplate'

	private TransactionalMessageHandler onRelate_STGroup_TEMPLATE_STTemplate() {
		return (tx, message) -> {

			final Node src = Template.findSTGroupBy_UUID(db, UUID.fromString(message.body().getString("STGroup")));
			if (src == null) {
				message.reply(newFail("STGroup " + message.body().getString("STGroup") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTTemplate(message.body().getJsonObject("STTemplate"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STGroup_TEMPLATE_STTemplate(src, dst);

			message.reply(newSuccess(new JsonObject().put("TEMPLATE", mapRelation(relation)).put("STTemplate", mapNode(dst, Template.Entities.STTemplate))));
		};
	}

	private TransactionalMessageHandler onUpdate_TEMPLATE() {
		return (tx, message) -> {

			final Node src = Template.findSTGroupBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STGroup " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("TEMPLATE");
			if (relation == null) {
				message.reply(newFail("TEMPLATE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_STTemplate_TEMPLATE_for_STGroup(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("TEMPLATE", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("TEMPLATE " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_STTemplate_TEMPLATE_FOR_STGroup() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_STTemplate_TEMPLATE_for_STGroup(Template.findSTGroupBy_UUID(db, UUID.fromString(message.body().getString("STGroup"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.TEMPLATE.name(), mapRelation(relationship)).put("STTemplate", mapNode(other, Template.Entities.STTemplate)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_STGroup_TEMPLATE_FOR_STTemplate() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("STTemplate")));
			final Relationship relation = Template.get_STGroup_TEMPLATE_Relation_for_STTemplate(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.TEMPLATE.name(), mapRelation(relation)).put("STGroup", mapNode(relation.getOtherNode(node), Template.Entities.STGroup))));
		};
	}



	// ONE 'srcSTTemplate' -> CHILD_TEMPLATE -> MANY 'STTemplate'

	private TransactionalMessageHandler onRelate_SrcSTTemplate_CHILD_TEMPLATE_STTemplate() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("SrcSTTemplate")));
			if (src == null) {
				message.reply(newFail("STTemplate " + message.body().getString("SrcSTTemplate") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTTemplate(message.body().getJsonObject("STTemplate"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_SrcSTTemplate_CHILD_TEMPLATE_STTemplate(src, dst);

			message.reply(newSuccess(new JsonObject().put("CHILD_TEMPLATE", mapRelation(relation)).put("STTemplate", mapNode(dst, Template.Entities.STTemplate))));
		};
	}

	private TransactionalMessageHandler onUpdate_CHILD_TEMPLATE() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("SrcSTTemplate " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("CHILD_TEMPLATE");
			if (relation == null) {
				message.reply(newFail("CHILD_TEMPLATE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_STTemplate_CHILD_TEMPLATE_for_SrcSTTemplate(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("CHILD_TEMPLATE", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("CHILD_TEMPLATE " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_STTemplate_CHILD_TEMPLATE_for_SrcSTTemplate(Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("SrcSTTemplate"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.CHILD_TEMPLATE.name(), mapRelation(relationship)).put("STTemplate", mapNode(other, Template.Entities.STTemplate)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_SrcSTTemplate_CHILD_TEMPLATE_FOR_STTemplate() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("STTemplate")));
			final Relationship relation = Template.get_SrcSTTemplate_CHILD_TEMPLATE_Relation_for_STTemplate(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.CHILD_TEMPLATE.name(), mapRelation(relation)).put("SrcSTTemplate", mapNode(relation.getOtherNode(node), Template.Entities.STTemplate))));
		};
	}



	// ONE 'STTemplate' -> PARAMETER -> MANY 'STTemplateParameter'

	private TransactionalMessageHandler onRelate_STTemplate_PARAMETER_STTemplateParameter() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("STTemplate")));
			if (src == null) {
				message.reply(newFail("STTemplate " + message.body().getString("STTemplate") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTTemplateParameter(message.body().getJsonObject("STTemplateParameter"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STTemplate_PARAMETER_STTemplateParameter(src, dst);

			message.reply(newSuccess(new JsonObject().put("PARAMETER", mapRelation(relation)).put("STTemplateParameter", mapNode(dst, Template.Entities.STTemplateParameter))));
		};
	}

	private TransactionalMessageHandler onUpdate_PARAMETER() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STTemplate " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("PARAMETER");
			if (relation == null) {
				message.reply(newFail("PARAMETER missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_STTemplateParameter_PARAMETER_for_STTemplate(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("PARAMETER", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("PARAMETER " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_STTemplateParameter_PARAMETER_FOR_STTemplate() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_STTemplateParameter_PARAMETER_for_STTemplate(Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("STTemplate"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.PARAMETER.name(), mapRelation(relationship)).put("STTemplateParameter", mapNode(other, Template.Entities.STTemplateParameter)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_STTemplate_PARAMETER_FOR_STTemplateParameter() {
		return (tx, message) -> {
			final Node node = Template.findSTTemplateParameterBy_UUID(db, UUID.fromString(message.body().getString("STTemplateParameter")));
			final Relationship relation = Template.get_STTemplate_PARAMETER_Relation_for_STTemplateParameter(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.PARAMETER.name(), mapRelation(relation)).put("STTemplate", mapNode(relation.getOtherNode(node), Template.Entities.STTemplate))));
		};
	}



	// ONE 'STTemplateParameter' -> KEY_VALUE -> MANY 'STKeyValue'

	private TransactionalMessageHandler onRelate_STTemplateParameter_KEY_VALUE_STKeyValue() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateParameterBy_UUID(db, UUID.fromString(message.body().getString("STTemplateParameter")));
			if (src == null) {
				message.reply(newFail("STTemplateParameter " + message.body().getString("STTemplateParameter") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTKeyValue(message.body().getJsonObject("STKeyValue"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STTemplateParameter_KEY_VALUE_STKeyValue(src, dst);

			message.reply(newSuccess(new JsonObject().put("KEY_VALUE", mapRelation(relation)).put("STKeyValue", mapNode(dst, Template.Entities.STKeyValue))));
		};
	}

	private TransactionalMessageHandler onUpdate_KEY_VALUE() {
		return (tx, message) -> {

			final Node src = Template.findSTTemplateParameterBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STTemplateParameter " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("KEY_VALUE");
			if (relation == null) {
				message.reply(newFail("KEY_VALUE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_STKeyValue_KEY_VALUE_for_STTemplateParameter(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("KEY_VALUE", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("KEY_VALUE " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_STKeyValue_KEY_VALUE_FOR_STTemplateParameter() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_STKeyValue_KEY_VALUE_for_STTemplateParameter(Template.findSTTemplateParameterBy_UUID(db, UUID.fromString(message.body().getString("STTemplateParameter"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.KEY_VALUE.name(), mapRelation(relationship)).put("STKeyValue", mapNode(other, Template.Entities.STKeyValue)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_STTemplateParameter_KEY_VALUE_FOR_STKeyValue() {
		return (tx, message) -> {
			final Node node = Template.findSTKeyValueBy_UUID(db, UUID.fromString(message.body().getString("STKeyValue")));
			final Relationship relation = Template.get_STTemplateParameter_KEY_VALUE_Relation_for_STKeyValue(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.KEY_VALUE.name(), mapRelation(relation)).put("STTemplateParameter", mapNode(relation.getOtherNode(node), Template.Entities.STTemplateParameter))));
		};
	}



	// MANY 'Value' -> KEY_REFERENCE -> ONE 'STKeyValue'

	private TransactionalMessageHandler onRelate_Value_KEY_REFERENCE_STKeyValue() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("Value") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTKeyValue(message.body().getJsonObject("STKeyValue"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_Value_KEY_REFERENCE_STKeyValue(src, dst);

			message.reply(newSuccess(new JsonObject().put("KEY_REFERENCE", mapRelation(relation)).put("STKeyValue", mapNode(dst, Template.Entities.STKeyValue))));
		};
	}

	private TransactionalMessageHandler onUpdate_KEY_REFERENCE() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("KEY_REFERENCE");
			if (relation == null) {
				message.reply(newFail("KEY_REFERENCE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final Relationship relationship = Template.get_STKeyValue_KEY_REFERENCE_Relation_for_Value(src);
			if (!relationUUID.equals(Template.getUUID(relationship))) {
				message.reply(newFail("KEY_REFERENCE " + relationUUID + " not found"));
				return;
			}

			message.reply(newSuccess(new JsonObject().put("KEY_REFERENCE", mapRelation(relationship))));
		};
	}


	// many-to-one
	private TransactionalMessageHandler onGet_STKeyValue_KEY_REFERENCE_FOR_Value() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			final Relationship relation = Template.get_STKeyValue_KEY_REFERENCE_Relation_for_Value(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.KEY_REFERENCE.name(), mapRelation(relation)).put("STKeyValue", mapNode(relation.getOtherNode(node), Template.Entities.STKeyValue))));
		};
	}

	private TransactionalMessageHandler onGet_Value_KEY_REFERENCE_FOR_STKeyValue() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Value_KEY_REFERENCE_for_STKeyValue(Template.findSTKeyValueBy_UUID(db, UUID.fromString(message.body().getString("STKeyValue"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.KEY_REFERENCE.name(), mapRelation(relationship)).put("Value", mapNode(other, Template.Entities.Value)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}



	// MANY 'Value' -> PARAMETER_REFERENCE -> ONE 'STTemplateParameter'

	private TransactionalMessageHandler onRelate_Value_PARAMETER_REFERENCE_STTemplateParameter() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("Value") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTTemplateParameter(message.body().getJsonObject("STTemplateParameter"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_Value_PARAMETER_REFERENCE_STTemplateParameter(src, dst);

			message.reply(newSuccess(new JsonObject().put("PARAMETER_REFERENCE", mapRelation(relation)).put("STTemplateParameter", mapNode(dst, Template.Entities.STTemplateParameter))));
		};
	}

	private TransactionalMessageHandler onUpdate_PARAMETER_REFERENCE() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("PARAMETER_REFERENCE");
			if (relation == null) {
				message.reply(newFail("PARAMETER_REFERENCE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final Relationship relationship = Template.get_STTemplateParameter_PARAMETER_REFERENCE_Relation_for_Value(src);
			if (!relationUUID.equals(Template.getUUID(relationship))) {
				message.reply(newFail("PARAMETER_REFERENCE " + relationUUID + " not found"));
				return;
			}

			message.reply(newSuccess(new JsonObject().put("PARAMETER_REFERENCE", mapRelation(relationship))));
		};
	}


	// many-to-one
	private TransactionalMessageHandler onGet_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			final Relationship relation = Template.get_STTemplateParameter_PARAMETER_REFERENCE_Relation_for_Value(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.PARAMETER_REFERENCE.name(), mapRelation(relation)).put("STTemplateParameter", mapNode(relation.getOtherNode(node), Template.Entities.STTemplateParameter))));
		};
	}

	private TransactionalMessageHandler onGet_Value_PARAMETER_REFERENCE_FOR_STTemplateParameter() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Value_PARAMETER_REFERENCE_for_STTemplateParameter(Template.findSTTemplateParameterBy_UUID(db, UUID.fromString(message.body().getString("STTemplateParameter"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.PARAMETER_REFERENCE.name(), mapRelation(relationship)).put("Value", mapNode(other, Template.Entities.Value)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}



	// ONE 'srcValue' -> KV_VALUES -> MANY 'Value'

	private TransactionalMessageHandler onRelate_SrcValue_KV_VALUES_Value() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("SrcValue")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("SrcValue") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newValue(message.body().getJsonObject("Value"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_SrcValue_KV_VALUES_Value(src, dst);

			message.reply(newSuccess(new JsonObject().put("KV_VALUES", mapRelation(relation)).put("Value", mapNode(dst, Template.Entities.Value))));
		};
	}

	private TransactionalMessageHandler onUpdate_KV_VALUES() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("SrcValue " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("KV_VALUES");
			if (relation == null) {
				message.reply(newFail("KV_VALUES missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_Value_KV_VALUES_for_SrcValue(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("KV_VALUES", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("KV_VALUES " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_Value_KV_VALUES_FOR_SrcValue() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Value_KV_VALUES_for_SrcValue(Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("SrcValue"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.KV_VALUES.name(), mapRelation(relationship)).put("Value", mapNode(other, Template.Entities.Value)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_SrcValue_KV_VALUES_FOR_Value() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			final Relationship relation = Template.get_SrcValue_KV_VALUES_Relation_for_Value(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.KV_VALUES.name(), mapRelation(relation)).put("SrcValue", mapNode(relation.getOtherNode(node), Template.Entities.Value))));
		};
	}



	// MANY 'Value' -> INSTANCE_REFERENCE -> ONE 'STInstance'

	private TransactionalMessageHandler onRelate_Value_INSTANCE_REFERENCE_STInstance() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("Value") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTInstance(message.body().getJsonObject("STInstance"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_Value_INSTANCE_REFERENCE_STInstance(src, dst);

			message.reply(newSuccess(new JsonObject().put("INSTANCE_REFERENCE", mapRelation(relation)).put("STInstance", mapNode(dst, Template.Entities.STInstance))));
		};
	}

	private TransactionalMessageHandler onUpdate_INSTANCE_REFERENCE() {
		return (tx, message) -> {

			final Node src = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("Value " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("INSTANCE_REFERENCE");
			if (relation == null) {
				message.reply(newFail("INSTANCE_REFERENCE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final Relationship relationship = Template.get_STInstance_INSTANCE_REFERENCE_Relation_for_Value(src);
			if (!relationUUID.equals(Template.getUUID(relationship))) {
				message.reply(newFail("INSTANCE_REFERENCE " + relationUUID + " not found"));
				return;
			}

			message.reply(newSuccess(new JsonObject().put("INSTANCE_REFERENCE", mapRelation(relationship))));
		};
	}


	// many-to-one
	private TransactionalMessageHandler onGet_STInstance_INSTANCE_REFERENCE_FOR_Value() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			final Relationship relation = Template.get_STInstance_INSTANCE_REFERENCE_Relation_for_Value(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.INSTANCE_REFERENCE.name(), mapRelation(relation)).put("STInstance", mapNode(relation.getOtherNode(node), Template.Entities.STInstance))));
		};
	}

	private TransactionalMessageHandler onGet_Value_INSTANCE_REFERENCE_FOR_STInstance() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Value_INSTANCE_REFERENCE_for_STInstance(Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.INSTANCE_REFERENCE.name(), mapRelation(relationship)).put("Value", mapNode(other, Template.Entities.Value)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}



	// ONE 'STInstance' -> VALUES -> MANY 'Value'

	private TransactionalMessageHandler onRelate_STInstance_VALUES_Value() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("STInstance") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newValue(message.body().getJsonObject("Value"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STInstance_VALUES_Value(src, dst);

			message.reply(newSuccess(new JsonObject().put("VALUES", mapRelation(relation)).put("Value", mapNode(dst, Template.Entities.Value))));
		};
	}

	private TransactionalMessageHandler onUpdate_VALUES() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("VALUES");
			if (relation == null) {
				message.reply(newFail("VALUES missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_Value_VALUES_for_STInstance(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("VALUES", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("VALUES " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_Value_VALUES_FOR_STInstance() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Value_VALUES_for_STInstance(Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.VALUES.name(), mapRelation(relationship)).put("Value", mapNode(other, Template.Entities.Value)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_STInstance_VALUES_FOR_Value() {
		return (tx, message) -> {
			final Node node = Template.findValueBy_UUID(db, UUID.fromString(message.body().getString("Value")));
			final Relationship relation = Template.get_STInstance_VALUES_Relation_for_Value(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.VALUES.name(), mapRelation(relation)).put("STInstance", mapNode(relation.getOtherNode(node), Template.Entities.STInstance))));
		};
	}



	// ONE 'STInstance' -> RENDERER -> MANY 'Renderer'

	private TransactionalMessageHandler onRelate_STInstance_RENDERER_Renderer() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("STInstance") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newRenderer(message.body().getJsonObject("Renderer"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STInstance_RENDERER_Renderer(src, dst);

			message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relation)).put("Renderer", mapNode(dst, Template.Entities.Renderer))));
		};
	}

	private TransactionalMessageHandler onUpdate_RENDERER() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("RENDERER");
			if (relation == null) {
				message.reply(newFail("RENDERER missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			Template.get_Renderer_RENDERER_for_STInstance(src, (relationship, other) -> {
				if (!relationUUID.equals(Template.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("RENDERER " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_Renderer_RENDERER_FOR_STInstance() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_Renderer_RENDERER_for_STInstance(Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.RENDERER.name(), mapRelation(relationship)).put("Renderer", mapNode(other, Template.Entities.Renderer)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_STInstance_RENDERER_FOR_Renderer() {
		return (tx, message) -> {
			final Node node = Template.findRendererBy_UUID(db, UUID.fromString(message.body().getString("Renderer")));
			final Relationship relation = Template.get_STInstance_RENDERER_Relation_for_Renderer(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.RENDERER.name(), mapRelation(relation)).put("STInstance", mapNode(relation.getOtherNode(node), Template.Entities.STInstance))));
		};
	}



	// MANY 'STInstance' -> INSTANCE -> ONE 'STTemplate'

	private TransactionalMessageHandler onRelate_STInstance_INSTANCE_STTemplate() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("STInstance") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTTemplate(message.body().getJsonObject("STTemplate"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_STInstance_INSTANCE_STTemplate(src, dst);

			message.reply(newSuccess(new JsonObject().put("INSTANCE", mapRelation(relation)).put("STTemplate", mapNode(dst, Template.Entities.STTemplate))));
		};
	}

	private TransactionalMessageHandler onUpdate_INSTANCE() {
		return (tx, message) -> {

			final Node src = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("STInstance " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("INSTANCE");
			if (relation == null) {
				message.reply(newFail("INSTANCE missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final Relationship relationship = Template.get_STTemplate_INSTANCE_Relation_for_STInstance(src);
			if (!relationUUID.equals(Template.getUUID(relationship))) {
				message.reply(newFail("INSTANCE " + relationUUID + " not found"));
				return;
			}

			message.reply(newSuccess(new JsonObject().put("INSTANCE", mapRelation(relationship))));
		};
	}


	// many-to-one
	private TransactionalMessageHandler onGet_STTemplate_INSTANCE_FOR_STInstance() {
		return (tx, message) -> {
			final Node node = Template.findSTInstanceBy_UUID(db, UUID.fromString(message.body().getString("STInstance")));
			final Relationship relation = Template.get_STTemplate_INSTANCE_Relation_for_STInstance(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.INSTANCE.name(), mapRelation(relation)).put("STTemplate", mapNode(relation.getOtherNode(node), Template.Entities.STTemplate))));
		};
	}

	private TransactionalMessageHandler onGet_STInstance_INSTANCE_FOR_STTemplate() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_STInstance_INSTANCE_for_STTemplate(Template.findSTTemplateBy_UUID(db, UUID.fromString(message.body().getString("STTemplate"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.INSTANCE.name(), mapRelation(relationship)).put("STInstance", mapNode(other, Template.Entities.STInstance)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}



	// MANY 'GroupRenderer' -> GROUP_RENDERER -> ONE 'STGroup'

	private TransactionalMessageHandler onRelate_GroupRenderer_GROUP_RENDERER_STGroup() {
		return (tx, message) -> {

			final Node src = Template.findGroupRendererBy_UUID(db, UUID.fromString(message.body().getString("GroupRenderer")));
			if (src == null) {
				message.reply(newFail("GroupRenderer " + message.body().getString("GroupRenderer") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newSTGroup(message.body().getJsonObject("STGroup"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = Template.relate_GroupRenderer_GROUP_RENDERER_STGroup(src, dst);

			message.reply(newSuccess(new JsonObject().put("GROUP_RENDERER", mapRelation(relation)).put("STGroup", mapNode(dst, Template.Entities.STGroup))));
		};
	}

	private TransactionalMessageHandler onUpdate_GROUP_RENDERER() {
		return (tx, message) -> {

			final Node src = Template.findGroupRendererBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("GroupRenderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("GROUP_RENDERER");
			if (relation == null) {
				message.reply(newFail("GROUP_RENDERER missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final Relationship relationship = Template.get_STGroup_GROUP_RENDERER_Relation_for_GroupRenderer(src);
			if (!relationUUID.equals(Template.getUUID(relationship))) {
				message.reply(newFail("GROUP_RENDERER " + relationUUID + " not found"));
				return;
			}

			message.reply(newSuccess(new JsonObject().put("GROUP_RENDERER", mapRelation(relationship))));
		};
	}


	// many-to-one
	private TransactionalMessageHandler onGet_STGroup_GROUP_RENDERER_FOR_GroupRenderer() {
		return (tx, message) -> {
			final Node node = Template.findGroupRendererBy_UUID(db, UUID.fromString(message.body().getString("GroupRenderer")));
			final Relationship relation = Template.get_STGroup_GROUP_RENDERER_Relation_for_GroupRenderer(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(Template.Relations.GROUP_RENDERER.name(), mapRelation(relation)).put("STGroup", mapNode(relation.getOtherNode(node), Template.Entities.STGroup))));
		};
	}

	private TransactionalMessageHandler onGet_GroupRenderer_GROUP_RENDERER_FOR_STGroup() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			Template.get_GroupRenderer_GROUP_RENDERER_for_STGroup(Template.findSTGroupBy_UUID(db, UUID.fromString(message.body().getString("STGroup"))), (relationship, other) -> {
				result.add(new JsonObject().put(Template.Relations.GROUP_RENDERER.name(), mapRelation(relationship)).put("GroupRenderer", mapNode(other, Template.Entities.GroupRenderer)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}



	private final TransactionalMessageHandler onRenderSTGroup() {
		return (tx, message) -> {
			renderSTGroup(message.body().getString("packageName"),message.body().getString("nodeUUID"), message);
		};
	}

	protected void renderSTGroup(String packageName,String nodeUUID, Message<JsonObject> message) {
		log.warn("RenderSTGroup not implemented. Ignored parameters : " + message.body().encode());
	}

	private final TransactionalMessageHandler onImportGroup() {
		return (tx, message) -> {
			importGroup(message.body().getJsonArray("relations"),message.body().getJsonArray("nodes"), message);
		};
	}

	protected void importGroup(JsonArray relations,JsonArray nodes, Message<JsonObject> message) {
		log.warn("ImportGroup not implemented. Ignored parameters : " + message.body().encode());
	}

	private final TransactionalMessageHandler onExportGroup() {
		return (tx, message) -> {
			exportGroup(message);
		};
	}

	protected void exportGroup(Message<JsonObject> message) {
		log.warn("ExportGroup not implemented.");
	}


	private void handleInstanceMessage(Message<JsonObject> message) { log.info("unhandled Template " + deploymentID() + " message " + message.body().toString()); }

	private void onDatabaseStarted(Transaction tx, JsonObject config) throws Exception {
	}

	private enum ResponseStatus {
		SUCCESS,
		FAIL
	}

	private enum PayloadType {
		STRING,
		JSONOBJECT,
		JSONARRAY,
		EXCEPTION
	}

	protected static JsonObject newSuccess(String payload) {
		final JsonObject response = new JsonObject().
			put("status", ResponseStatus.SUCCESS).
			put("payloadType", PayloadType.STRING).
			put("payload", payload);
		log.info(response.encode());
		return response;
	}

	protected static JsonObject newSuccess(JsonObject payload) {
		final JsonObject response = new JsonObject().
			put("status", ResponseStatus.SUCCESS).
			put("payloadType", PayloadType.JSONOBJECT).
			put("payload", payload);
		log.info(response.encode());
		return response;
	}

	protected static JsonObject newSuccess(JsonArray payload) {
		final JsonObject response =  new JsonObject().
			put("status", ResponseStatus.SUCCESS).
			put("payloadType", PayloadType.JSONARRAY).
			put("payload", payload);
		log.info(response.encode());
		return response;
	}

	protected static JsonObject newFail(String payload) {
		final JsonObject response =  new JsonObject().
			put("status", ResponseStatus.FAIL).
			put("payloadType", PayloadType.STRING).
			put("payload", payload);
		log.info(response.encode());
		return response;
	}

	protected static JsonObject newFail(JsonArray payload) {
		final JsonObject response =  new JsonObject().
			put("status", ResponseStatus.FAIL).
			put("payloadType", PayloadType.JSONARRAY).
			put("payload", payload);
		log.info(response.encode());
		return response;
	}

	protected static JsonObject newException(Throwable e) {

		final JsonArray stacktrace = new JsonArray();
		for (StackTraceElement stackTraceElement : e.getStackTrace())
			stacktrace.add(new JsonObject().
				put("declaringClass", stackTraceElement.getClassName()).
				put("methodName", stackTraceElement.getMethodName()).
				put("fileName", stackTraceElement.getFileName()).
				put("lineNumber", stackTraceElement.getLineNumber()));

		final JsonObject response =  new JsonObject().
				put("status", ResponseStatus.FAIL).
				put("payloadType", PayloadType.EXCEPTION).
				put("payload", new JsonObject().
					put("message", e.getMessage() == null ? "null" : e.getMessage()).
					put("stackTrace", stacktrace));
		log.info(response.encode());
		return response;
	}

	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {

		// if already related, merge properties:
		for (Object o : outgoing(source, relationshipType)) {
			final Relationship relationship = (Relationship) o;
			if (target.equals(other(source, relationship))) {
				for (int i = 0; i < properties.length; i += 2)
					relationship.setProperty(properties[i].toString(), properties[i + 1]);
				return relationship;
			}
		}

		final Relationship relationship = source.createRelationshipTo(target, relationshipType);
		relationship.setProperty("_uuid", UUID.randomUUID().toString());
		for (int i = 0; i < properties.length; i += 2)
			relationship.setProperty(properties[i].toString(), properties[i + 1]);

		return relationship;
	}

	private JsonObject mapRelation(Relationship relation) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.put("uuid", relation.getProperty("_uuid"));
		jsonObject.put("type", relation.getType().name());
		for (Map.Entry<String, Object> entry : relation.getAllProperties().entrySet()) {
			if ("_uuid".equals(entry.getKey())) continue;
			jsonObject.put(entry.getKey(), entry.getValue().toString());
		}
		return jsonObject;
	}

	private JsonObject mapNode(Node relation, Label label) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.put("uuid", relation.getProperty("_uuid"));
		jsonObject.put("label", label.name());
		for (Map.Entry<String, Object> entry : relation.getAllProperties().entrySet()) {
			if ("_uuid".equals(entry.getKey())) continue;
			jsonObject.put(entry.getKey(), entry.getValue().toString());
		}
		return jsonObject;
	}

	private UUID getUuid(JsonObject jsonObject) {
		return UUID.fromString(jsonObject.getString("uuid"));
	}

	private static void mapString(JsonObject jsonObject, PropertyContainer container, String name) {
		if (jsonObject.getString(name) != null) container.setProperty(name, jsonObject.getString(name));
	}

	private static void mapInteger(JsonObject jsonObject, PropertyContainer container, String name) {
		if (jsonObject.getInteger(name) != null) container.setProperty(name, jsonObject.getInteger(name));
	}

	private static void mapLong(JsonObject jsonObject, PropertyContainer container, String name) {
		if (jsonObject.getLong(name) != null) container.setProperty(name, jsonObject.getLong(name));
	}

	private static void mapBoolean(JsonObject jsonObject, PropertyContainer container, String name) {
		if (jsonObject.getBoolean(name) != null) container.setProperty(name, jsonObject.getBoolean(name));
	}

	private static void map(String name, JsonObject jsonObject, PropertyContainer container) {
		if (container.hasProperty(name)) jsonObject.put(name, container.getProperty(name));
	}

	private static Node newNode(GraphDatabaseService db, Label label) {
		final Node node = db.createNode(label);
		node.setProperty("_deleted", Boolean.FALSE);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		return node;
	}

	private static String deleteNode(Node node) {
		node.setProperty("_deleted", Boolean.TRUE);
		return node.getProperty("_uuid").toString();
	}

	private static boolean isDeleted(Node node) {
		return !((Boolean) node.getProperty("_deleted"));
	}

	private static Iterable<?> outgoing(Node node, RelationshipType type) {
		return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);
	}

	private static Node other(Node node, Relationship relationship) {
		return relationship == null ? null : relationship.getOtherNode(node);
	}

	public static void deploy(String path, Vertx vertx, Handler<String> handler) {
		vertx.deployVerticle(TemplateVerticleImpl.class, new DeploymentOptions().setConfig(new JsonObject().put("path", path)), result -> {
			if (result.failed())
				result.cause().printStackTrace();
			else
				handler.handle(result.result());
		});
	}

	public static void runServer(Vertx vertx, int port, String dbPath, Handler<String> deployHandler) {

		deploy(dbPath, vertx, deploymentID -> {

			final io.vertx.ext.web.Router router = io.vertx.ext.web.Router.router(vertx);
			router.route().handler(io.vertx.ext.web.handler.BodyHandler.create());

			final io.vertx.ext.web.handler.sockjs.BridgeOptions options = new io.vertx.ext.web.handler.sockjs.BridgeOptions().
					addInboundPermitted(new io.vertx.ext.bridge.PermittedOptions().setAddressRegex(".*")).
					addOutboundPermitted(new io.vertx.ext.bridge.PermittedOptions().setAddressRegex(".*"));

			router.route("/eventbus/*").handler(io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx).bridge(options, event -> {
				switch (event.type()) {
					case SOCKET_CREATED:
						log.debug("socket created remoteAddress=" + event.socket().remoteAddress());
						break;
					case SOCKET_CLOSED:
						log.debug("socket closed  remoteAddress=" + event.socket().remoteAddress());
						break;
					case SOCKET_IDLE:
						break;
					case SOCKET_PING:
						break;
					case SEND:
						break;
					case PUBLISH:
						break;
					case RECEIVE:
						break;
					case REGISTER:
						break;
					case UNREGISTER:
						break;
				}
				event.complete(true);
			}));

			vertx.createHttpServer(new io.vertx.core.http.HttpServerOptions()).
				requestHandler(router::accept).
				listen(port);

			deployHandler.handle(deploymentID);
		});
	}
}