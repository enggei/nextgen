package com.nextgen.core.domain;

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

// verticle for NeoDomainDomain
public class NeoDomainDomainVerticle extends AbstractVerticle {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoDomainDomainVerticle.class);

	protected GraphDatabaseService db;

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		log.info("starting NeoDomainDomainVerticle");

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
				log.error("failed to start NeoDomainDomainVerticle : ", res.cause());
				startFuture.fail(res.cause());

			} else {
				log.info("started NeoDomainDomainVerticle successfully ");
				vertx.eventBus().consumer(deploymentID(), this::handleInstanceMessage);

				vertx.eventBus().consumer("neoDomainDomain.new.neoDomain", new TransactionMessageHandler("new.neoDomain", onNewNeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoDomain", new TransactionMessageHandler("update.neoDomain", onUpdateNeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomain", new TransactionMessageHandler("get.neoDomain", onGetNeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoDomain", new TransactionMessageHandler("delete.neoDomain", onDeleteNeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoDomain", new TransactionMessageHandler("getAll.neoDomain", onGetAllNeoDomain()));

				vertx.eventBus().consumer("neoDomainDomain.new.neoVisitor", new TransactionMessageHandler("new.neoVisitor", onNewNeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoVisitor", new TransactionMessageHandler("update.neoVisitor", onUpdateNeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoVisitor", new TransactionMessageHandler("get.neoVisitor", onGetNeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoVisitor", new TransactionMessageHandler("delete.neoVisitor", onDeleteNeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoVisitor", new TransactionMessageHandler("getAll.neoVisitor", onGetAllNeoVisitor()));

				vertx.eventBus().consumer("neoDomainDomain.new.visitorParameter", new TransactionMessageHandler("new.visitorParameter", onNewVisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.update.visitorParameter", new TransactionMessageHandler("update.visitorParameter", onUpdateVisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.get.visitorParameter", new TransactionMessageHandler("get.visitorParameter", onGetVisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.delete.visitorParameter", new TransactionMessageHandler("delete.visitorParameter", onDeleteVisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.visitorParameter", new TransactionMessageHandler("getAll.visitorParameter", onGetAllVisitorParameter()));

				vertx.eventBus().consumer("neoDomainDomain.new.neoEntity", new TransactionMessageHandler("new.neoEntity", onNewNeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoEntity", new TransactionMessageHandler("update.neoEntity", onUpdateNeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity", new TransactionMessageHandler("get.neoEntity", onGetNeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoEntity", new TransactionMessageHandler("delete.neoEntity", onDeleteNeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoEntity", new TransactionMessageHandler("getAll.neoEntity", onGetAllNeoEntity()));

				vertx.eventBus().consumer("neoDomainDomain.new.neoRelation", new TransactionMessageHandler("new.neoRelation", onNewNeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoRelation", new TransactionMessageHandler("update.neoRelation", onUpdateNeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoRelation", new TransactionMessageHandler("get.neoRelation", onGetNeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoRelation", new TransactionMessageHandler("delete.neoRelation", onDeleteNeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoRelation", new TransactionMessageHandler("getAll.neoRelation", onGetAllNeoRelation()));

				vertx.eventBus().consumer("neoDomainDomain.new.neoProperty", new TransactionMessageHandler("new.neoProperty", onNewNeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoProperty", new TransactionMessageHandler("update.neoProperty", onUpdateNeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoProperty", new TransactionMessageHandler("get.neoProperty", onGetNeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoProperty", new TransactionMessageHandler("delete.neoProperty", onDeleteNeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoProperty", new TransactionMessageHandler("getAll.neoProperty", onGetAllNeoProperty()));

				vertx.eventBus().consumer("neoDomainDomain.new.neoDomainRenderer", new TransactionMessageHandler("new.neoDomainRenderer", onNewNeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.update.neoDomainRenderer", new TransactionMessageHandler("update.neoDomainRenderer", onUpdateNeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomainRenderer", new TransactionMessageHandler("get.neoDomainRenderer", onGetNeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.delete.neoDomainRenderer", new TransactionMessageHandler("delete.neoDomainRenderer", onDeleteNeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.get.all.neoDomainRenderer", new TransactionMessageHandler("getAll.neoDomainRenderer", onGetAllNeoDomainRenderer()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoDomain.DOMAIN_VISITORS.neoVisitor", new TransactionMessageHandler("neoDomainDomain.relate.neoDomain.DOMAIN_VISITORS.neoVisitor", onRelate_NeoDomain_DOMAIN_VISITORS_NeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomain.DOMAIN_VISITORS.neoVisitor", new TransactionMessageHandler("neoDomainDomain.get.neoDomain.DOMAIN_VISITORS.neoVisitor", onGet_NeoDomain_DOMAIN_VISITORS_FOR_NeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoVisitor.DOMAIN_VISITORS.neoDomain", new TransactionMessageHandler("neoDomainDomain.get.neoVisitor.DOMAIN_VISITORS.neoDomain", onGet_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.update.DOMAIN_VISITORS", new TransactionMessageHandler("neoDomainDomain.update.DOMAIN_VISITORS", onUpdate_DOMAIN_VISITORS()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoVisitor.VISITOR_PARAMETERS.visitorParameter", new TransactionMessageHandler("neoDomainDomain.relate.neoVisitor.VISITOR_PARAMETERS.visitorParameter", onRelate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoVisitor.VISITOR_PARAMETERS.visitorParameter", new TransactionMessageHandler("neoDomainDomain.get.neoVisitor.VISITOR_PARAMETERS.visitorParameter", onGet_NeoVisitor_VISITOR_PARAMETERS_FOR_VisitorParameter()));
				vertx.eventBus().consumer("neoDomainDomain.get.visitorParameter.VISITOR_PARAMETERS.neoVisitor", new TransactionMessageHandler("neoDomainDomain.get.visitorParameter.VISITOR_PARAMETERS.neoVisitor", onGet_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.update.VISITOR_PARAMETERS", new TransactionMessageHandler("neoDomainDomain.update.VISITOR_PARAMETERS", onUpdate_VISITOR_PARAMETERS()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoEntity.ENTITY_VISITORS.neoVisitor", new TransactionMessageHandler("neoDomainDomain.relate.neoEntity.ENTITY_VISITORS.neoVisitor", onRelate_NeoEntity_ENTITY_VISITORS_NeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity.ENTITY_VISITORS.neoVisitor", new TransactionMessageHandler("neoDomainDomain.get.neoEntity.ENTITY_VISITORS.neoVisitor", onGet_NeoEntity_ENTITY_VISITORS_FOR_NeoVisitor()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoVisitor.ENTITY_VISITORS.neoEntity", new TransactionMessageHandler("neoDomainDomain.get.neoVisitor.ENTITY_VISITORS.neoEntity", onGet_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.update.ENTITY_VISITORS", new TransactionMessageHandler("neoDomainDomain.update.ENTITY_VISITORS", onUpdate_ENTITY_VISITORS()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoEntity.ENTITY_RELATION.neoRelation", new TransactionMessageHandler("neoDomainDomain.relate.neoEntity.ENTITY_RELATION.neoRelation", onRelate_NeoEntity_ENTITY_RELATION_NeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity.ENTITY_RELATION.neoRelation", new TransactionMessageHandler("neoDomainDomain.get.neoEntity.ENTITY_RELATION.neoRelation", onGet_NeoEntity_ENTITY_RELATION_FOR_NeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoRelation.ENTITY_RELATION.neoEntity", new TransactionMessageHandler("neoDomainDomain.get.neoRelation.ENTITY_RELATION.neoEntity", onGet_NeoRelation_ENTITY_RELATION_FOR_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.update.ENTITY_RELATION", new TransactionMessageHandler("neoDomainDomain.update.ENTITY_RELATION", onUpdate_ENTITY_RELATION()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoRelation.RELATION_PROPERTIES.neoProperty", new TransactionMessageHandler("neoDomainDomain.relate.neoRelation.RELATION_PROPERTIES.neoProperty", onRelate_NeoRelation_RELATION_PROPERTIES_NeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoRelation.RELATION_PROPERTIES.neoProperty", new TransactionMessageHandler("neoDomainDomain.get.neoRelation.RELATION_PROPERTIES.neoProperty", onGet_NeoRelation_RELATION_PROPERTIES_FOR_NeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoProperty.RELATION_PROPERTIES.neoRelation", new TransactionMessageHandler("neoDomainDomain.get.neoProperty.RELATION_PROPERTIES.neoRelation", onGet_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.update.RELATION_PROPERTIES", new TransactionMessageHandler("neoDomainDomain.update.RELATION_PROPERTIES", onUpdate_RELATION_PROPERTIES()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoEntity.ENTITY_PROPERTIES.neoProperty", new TransactionMessageHandler("neoDomainDomain.relate.neoEntity.ENTITY_PROPERTIES.neoProperty", onRelate_NeoEntity_ENTITY_PROPERTIES_NeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity.ENTITY_PROPERTIES.neoProperty", new TransactionMessageHandler("neoDomainDomain.get.neoEntity.ENTITY_PROPERTIES.neoProperty", onGet_NeoEntity_ENTITY_PROPERTIES_FOR_NeoProperty()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoProperty.ENTITY_PROPERTIES.neoEntity", new TransactionMessageHandler("neoDomainDomain.get.neoProperty.ENTITY_PROPERTIES.neoEntity", onGet_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.update.ENTITY_PROPERTIES", new TransactionMessageHandler("neoDomainDomain.update.ENTITY_PROPERTIES", onUpdate_ENTITY_PROPERTIES()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoRelation.RELATION_ENTITY.neoEntity", new TransactionMessageHandler("neoDomainDomain.relate.neoRelation.RELATION_ENTITY.neoEntity", onRelate_NeoRelation_RELATION_ENTITY_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoRelation.RELATION_ENTITY.neoEntity", new TransactionMessageHandler("neoDomainDomain.get.neoRelation.RELATION_ENTITY.neoEntity", onGet_NeoRelation_RELATION_ENTITY_FOR_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity.RELATION_ENTITY.neoRelation", new TransactionMessageHandler("neoDomainDomain.get.neoEntity.RELATION_ENTITY.neoRelation", onGet_NeoEntity_RELATION_ENTITY_FOR_NeoRelation()));
				vertx.eventBus().consumer("neoDomainDomain.update.RELATION_ENTITY", new TransactionMessageHandler("neoDomainDomain.update.RELATION_ENTITY", onUpdate_RELATION_ENTITY()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoDomain.ENTITIES.neoEntity", new TransactionMessageHandler("neoDomainDomain.relate.neoDomain.ENTITIES.neoEntity", onRelate_NeoDomain_ENTITIES_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomain.ENTITIES.neoEntity", new TransactionMessageHandler("neoDomainDomain.get.neoDomain.ENTITIES.neoEntity", onGet_NeoDomain_ENTITIES_FOR_NeoEntity()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoEntity.ENTITIES.neoDomain", new TransactionMessageHandler("neoDomainDomain.get.neoEntity.ENTITIES.neoDomain", onGet_NeoEntity_ENTITIES_FOR_NeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.update.ENTITIES", new TransactionMessageHandler("neoDomainDomain.update.ENTITIES", onUpdate_ENTITIES()));

				vertx.eventBus().consumer("neoDomainDomain.relate.neoDomain.RENDERER.neoDomainRenderer", new TransactionMessageHandler("neoDomainDomain.relate.neoDomain.RENDERER.neoDomainRenderer", onRelate_NeoDomain_RENDERER_NeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomain.RENDERER.neoDomainRenderer", new TransactionMessageHandler("neoDomainDomain.get.neoDomain.RENDERER.neoDomainRenderer", onGet_NeoDomain_RENDERER_FOR_NeoDomainRenderer()));
				vertx.eventBus().consumer("neoDomainDomain.get.neoDomainRenderer.RENDERER.neoDomain", new TransactionMessageHandler("neoDomainDomain.get.neoDomainRenderer.RENDERER.neoDomain", onGet_NeoDomainRenderer_RENDERER_FOR_NeoDomain()));
				vertx.eventBus().consumer("neoDomainDomain.update.RENDERER", new TransactionMessageHandler("neoDomainDomain.update.RENDERER", onUpdate_RENDERER()));

				vertx.eventBus().consumer("neoDomainDomain.renderDomain", new TransactionMessageHandler("renderDomain", onRenderDomain()));


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

	// NeoDomain

	private TransactionalMessageHandler onNewNeoDomain() {
		return (tx, message) -> {
			final JsonArray errors = new JsonArray();
			final Node node = newNeoDomain(message.body().getJsonObject("NeoDomain"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoDomain)));
		};
	}

	private Node newNeoDomain(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoDomain);
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoDomain() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomain not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoDomain"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoDomain)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoDomain() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoDomain() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoDomain)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoDomain() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoDomain(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoDomain));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// NeoVisitor

	private TransactionalMessageHandler onNewNeoVisitor() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findNeoVisitorBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("NeoDomain") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newNeoVisitor(message.body().getJsonObject("NeoVisitor"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("DOMAIN_VISITORS"));
			message.reply(newSuccess(new JsonObject().put("DOMAIN_VISITORS", mapRelation(relation)).put("NeoVisitor", mapNode(node, NeoDomainDomain.Entities.NeoVisitor))));
		};
	}
	private Node newNeoVisitor(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoVisitor);
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoVisitor() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoVisitorBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoVisitor not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoVisitor"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoVisitor)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoVisitor() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoVisitorBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoVisitor() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoVisitorBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoVisitor)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoVisitor() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoVisitor(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoVisitor));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// VisitorParameter

	private TransactionalMessageHandler onNewVisitorParameter() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findVisitorParameterBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("NeoVisitor") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newVisitorParameter(message.body().getJsonObject("VisitorParameter"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("VISITOR_PARAMETERS"));
			message.reply(newSuccess(new JsonObject().put("VISITOR_PARAMETERS", mapRelation(relation)).put("VisitorParameter", mapNode(node, NeoDomainDomain.Entities.VisitorParameter))));
		};
	}
	private Node newVisitorParameter(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("type") == null) errors.add("missing type");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.VisitorParameter);
		mapString(jsonObject, node, "type");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateVisitorParameter() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findVisitorParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("VisitorParameter not found"));
				return;
			}
			mapString(message.body().getJsonObject("VisitorParameter"), node, "type");
			mapString(message.body().getJsonObject("VisitorParameter"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.VisitorParameter)));
		};
	}

	private TransactionalMessageHandler onDeleteVisitorParameter() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findVisitorParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("VisitorParameter " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetVisitorParameter() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findVisitorParameterBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("VisitorParameter " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.VisitorParameter)));
		};
	}

	private TransactionalMessageHandler onGetAllVisitorParameter() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllVisitorParameter(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.VisitorParameter));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// NeoEntity

	private TransactionalMessageHandler onNewNeoEntity() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("NeoVisitor") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newNeoEntity(message.body().getJsonObject("NeoEntity"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("ENTITY_VISITORS"));
			message.reply(newSuccess(new JsonObject().put("ENTITY_VISITORS", mapRelation(relation)).put("NeoEntity", mapNode(node, NeoDomainDomain.Entities.NeoEntity))));
		};
	}
	private Node newNeoEntity(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("highlightedColor") == null) errors.add("missing highlightedColor");
		if (jsonObject.getString("selectedColor") == null) errors.add("missing selectedColor");
		if (jsonObject.getString("defaultColor") == null) errors.add("missing defaultColor");
		if (jsonObject.getString("label") == null) errors.add("missing label");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoEntity);
		mapString(jsonObject, node, "highlightedColor");
		mapString(jsonObject, node, "selectedColor");
		mapString(jsonObject, node, "defaultColor");
		mapString(jsonObject, node, "label");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoEntity() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoEntityBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoEntity not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoEntity"), node, "highlightedColor");
			mapString(message.body().getJsonObject("NeoEntity"), node, "selectedColor");
			mapString(message.body().getJsonObject("NeoEntity"), node, "defaultColor");
			mapString(message.body().getJsonObject("NeoEntity"), node, "label");
			mapString(message.body().getJsonObject("NeoEntity"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoEntity)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoEntity() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoEntityBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoEntity() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoEntityBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoEntity)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoEntity() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoEntity(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoEntity));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// NeoRelation

	private TransactionalMessageHandler onNewNeoRelation() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findNeoRelationBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("NeoEntity") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newNeoRelation(message.body().getJsonObject("NeoRelation"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("ENTITY_RELATION"));
			message.reply(newSuccess(new JsonObject().put("ENTITY_RELATION", mapRelation(relation)).put("NeoRelation", mapNode(node, NeoDomainDomain.Entities.NeoRelation))));
		};
	}
	private Node newNeoRelation(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("Cardinality") == null) errors.add("missing Cardinality");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoRelation);
		mapString(jsonObject, node, "Cardinality");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoRelation() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoRelationBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoRelation not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoRelation"), node, "Cardinality");
			mapString(message.body().getJsonObject("NeoRelation"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoRelation)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoRelation() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoRelationBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoRelation() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoRelationBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoRelation)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoRelation() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoRelation(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoRelation));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// NeoProperty

	private TransactionalMessageHandler onNewNeoProperty() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findNeoPropertyBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("NeoRelation") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newNeoProperty(message.body().getJsonObject("NeoProperty"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("RELATION_PROPERTIES"));
			message.reply(newSuccess(new JsonObject().put("RELATION_PROPERTIES", mapRelation(relation)).put("NeoProperty", mapNode(node, NeoDomainDomain.Entities.NeoProperty))));
		};
	}
	private Node newNeoProperty(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("enumValues") == null) errors.add("missing enumValues");
		if (jsonObject.getString("ValueType") == null) errors.add("missing ValueType");
		if (jsonObject.getString("name") == null) errors.add("missing name");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoProperty);
		mapString(jsonObject, node, "enumValues");
		mapString(jsonObject, node, "ValueType");
		mapString(jsonObject, node, "name");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoProperty() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoPropertyBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoProperty not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoProperty"), node, "enumValues");
			mapString(message.body().getJsonObject("NeoProperty"), node, "ValueType");
			mapString(message.body().getJsonObject("NeoProperty"), node, "name");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoProperty)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoProperty() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoPropertyBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoProperty " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoProperty() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoPropertyBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoProperty " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoProperty)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoProperty() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoProperty(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoProperty));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// NeoDomainRenderer

	private TransactionalMessageHandler onNewNeoDomainRenderer() {
		return (tx, message) -> {
			final Node src = NeoDomainDomain.findNeoDomainRendererBy_UUID(db, getUuid(message.body()));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("NeoDomain") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node node = newNeoDomainRenderer(message.body().getJsonObject("NeoDomainRenderer"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}
			final Relationship relation = relate(src, node, RelationshipType.withName("RENDERER"));
			message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relation)).put("NeoDomainRenderer", mapNode(node, NeoDomainDomain.Entities.NeoDomainRenderer))));
		};
	}
	private Node newNeoDomainRenderer(JsonObject jsonObject, JsonArray errors) {
		if (jsonObject.getString("packageName") == null) errors.add("missing packageName");
		if (jsonObject.getString("root") == null) errors.add("missing root");
		if (!errors.isEmpty()) return null;
		final Node node = newNode(db, NeoDomainDomain.Entities.NeoDomainRenderer);
		mapString(jsonObject, node, "packageName");
		mapString(jsonObject, node, "root");
		return node;
	}

	private TransactionalMessageHandler onUpdateNeoDomainRenderer() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomainRenderer not found"));
				return;
			}
			mapString(message.body().getJsonObject("NeoDomainRenderer"), node, "packageName");
			mapString(message.body().getJsonObject("NeoDomainRenderer"), node, "root");

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoDomainRenderer)));
		};
	}

	private TransactionalMessageHandler onDeleteNeoDomainRenderer() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomainRenderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			final String uuid = deleteNode(node);
			message.reply(newSuccess(uuid));
		};
	}

	private TransactionalMessageHandler onGetNeoDomainRenderer() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainRendererBy_UUID(db, getUuid(message.body()));
			if (node == null) {
				message.reply(newFail("NeoDomainRenderer " + message.body().getString("uuid") + " not found"));
				return;
			}

			message.reply(newSuccess(mapNode(node, NeoDomainDomain.Entities.NeoDomainRenderer)));
		};
	}

	private TransactionalMessageHandler onGetAllNeoDomainRenderer() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.findAllNeoDomainRenderer(db, node -> {
				result.add(mapNode(node, NeoDomainDomain.Entities.NeoDomainRenderer));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	// ONE 'NeoDomain' -> DOMAIN_VISITORS -> MANY 'NeoVisitor'

	private TransactionalMessageHandler onRelate_NeoDomain_DOMAIN_VISITORS_NeoVisitor() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("NeoDomain") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoVisitor(message.body().getJsonObject("NeoVisitor"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoDomain_DOMAIN_VISITORS_NeoVisitor(src, dst);

			message.reply(newSuccess(new JsonObject().put("DOMAIN_VISITORS", mapRelation(relation)).put("NeoVisitor", mapNode(dst, NeoDomainDomain.Entities.NeoVisitor))));
		};
	}

	private TransactionalMessageHandler onUpdate_DOMAIN_VISITORS() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("DOMAIN_VISITORS");
			if (relation == null) {
				message.reply(newFail("DOMAIN_VISITORS missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoVisitor_DOMAIN_VISITORS_for_NeoDomain(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("DOMAIN_VISITORS", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("DOMAIN_VISITORS " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoVisitor_DOMAIN_VISITORS_for_NeoDomain(NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.DOMAIN_VISITORS.name(), mapRelation(relationship)).put("NeoVisitor", mapNode(other, NeoDomainDomain.Entities.NeoVisitor)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoDomain_DOMAIN_VISITORS_FOR_NeoVisitor() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoVisitorBy_UUID(db, UUID.fromString(message.body().getString("NeoVisitor")));
			final Relationship relation = NeoDomainDomain.get_NeoDomain_DOMAIN_VISITORS_Relation_for_NeoVisitor(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.DOMAIN_VISITORS.name(), mapRelation(relation)).put("NeoDomain", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoDomain))));
		};
	}



	// ONE 'NeoVisitor' -> VISITOR_PARAMETERS -> MANY 'VisitorParameter'

	private TransactionalMessageHandler onRelate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoVisitorBy_UUID(db, UUID.fromString(message.body().getString("NeoVisitor")));
			if (src == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("NeoVisitor") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newVisitorParameter(message.body().getJsonObject("VisitorParameter"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter(src, dst);

			message.reply(newSuccess(new JsonObject().put("VISITOR_PARAMETERS", mapRelation(relation)).put("VisitorParameter", mapNode(dst, NeoDomainDomain.Entities.VisitorParameter))));
		};
	}

	private TransactionalMessageHandler onUpdate_VISITOR_PARAMETERS() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoVisitorBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoVisitor " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("VISITOR_PARAMETERS");
			if (relation == null) {
				message.reply(newFail("VISITOR_PARAMETERS missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_VisitorParameter_VISITOR_PARAMETERS_for_NeoVisitor(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("VISITOR_PARAMETERS", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("VISITOR_PARAMETERS " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_VisitorParameter_VISITOR_PARAMETERS_for_NeoVisitor(NeoDomainDomain.findNeoVisitorBy_UUID(db, UUID.fromString(message.body().getString("NeoVisitor"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.VISITOR_PARAMETERS.name(), mapRelation(relationship)).put("VisitorParameter", mapNode(other, NeoDomainDomain.Entities.VisitorParameter)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoVisitor_VISITOR_PARAMETERS_FOR_VisitorParameter() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findVisitorParameterBy_UUID(db, UUID.fromString(message.body().getString("VisitorParameter")));
			final Relationship relation = NeoDomainDomain.get_NeoVisitor_VISITOR_PARAMETERS_Relation_for_VisitorParameter(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.VISITOR_PARAMETERS.name(), mapRelation(relation)).put("NeoVisitor", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoVisitor))));
		};
	}



	// ONE 'NeoEntity' -> ENTITY_VISITORS -> MANY 'NeoVisitor'

	private TransactionalMessageHandler onRelate_NeoEntity_ENTITY_VISITORS_NeoVisitor() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("NeoEntity") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoVisitor(message.body().getJsonObject("NeoVisitor"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoEntity_ENTITY_VISITORS_NeoVisitor(src, dst);

			message.reply(newSuccess(new JsonObject().put("ENTITY_VISITORS", mapRelation(relation)).put("NeoVisitor", mapNode(dst, NeoDomainDomain.Entities.NeoVisitor))));
		};
	}

	private TransactionalMessageHandler onUpdate_ENTITY_VISITORS() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("ENTITY_VISITORS");
			if (relation == null) {
				message.reply(newFail("ENTITY_VISITORS missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoVisitor_ENTITY_VISITORS_for_NeoEntity(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("ENTITY_VISITORS", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("ENTITY_VISITORS " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoVisitor_ENTITY_VISITORS_for_NeoEntity(NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_VISITORS.name(), mapRelation(relationship)).put("NeoVisitor", mapNode(other, NeoDomainDomain.Entities.NeoVisitor)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoEntity_ENTITY_VISITORS_FOR_NeoVisitor() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoVisitorBy_UUID(db, UUID.fromString(message.body().getString("NeoVisitor")));
			final Relationship relation = NeoDomainDomain.get_NeoEntity_ENTITY_VISITORS_Relation_for_NeoVisitor(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_VISITORS.name(), mapRelation(relation)).put("NeoEntity", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoEntity))));
		};
	}



	// MANY 'NeoEntity' -> ENTITY_RELATION -> MANY 'NeoRelation'

	private TransactionalMessageHandler onRelate_NeoEntity_ENTITY_RELATION_NeoRelation() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("NeoEntity") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoRelation(message.body().getJsonObject("NeoRelation"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoEntity_ENTITY_RELATION_NeoRelation(src, dst);

			message.reply(newSuccess(new JsonObject().put("ENTITY_RELATION", mapRelation(relation)).put("NeoRelation", mapNode(dst, NeoDomainDomain.Entities.NeoRelation))));
		};
	}

	private TransactionalMessageHandler onUpdate_ENTITY_RELATION() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("ENTITY_RELATION");
			if (relation == null) {
				message.reply(newFail("ENTITY_RELATION missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoRelation_ENTITY_RELATION_for_NeoEntity(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("ENTITY_RELATION", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("ENTITY_RELATION " + relationUUID + " not found"));
		};
	}


	// many-to-many
	private TransactionalMessageHandler onGet_NeoRelation_ENTITY_RELATION_FOR_NeoEntity() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoRelation_ENTITY_RELATION_for_NeoEntity(NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_RELATION.name(), mapRelation(relationship)).put("NeoRelation", mapNode(other, NeoDomainDomain.Entities.NeoRelation)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoEntity_ENTITY_RELATION_FOR_NeoRelation() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoEntity_ENTITY_RELATION_for_NeoRelation(NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("NeoRelation"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_RELATION.name(), mapRelation(relationship)).put("NeoEntity", mapNode(other, NeoDomainDomain.Entities.NeoEntity)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}


	// ONE 'NeoRelation' -> RELATION_PROPERTIES -> MANY 'NeoProperty'

	private TransactionalMessageHandler onRelate_NeoRelation_RELATION_PROPERTIES_NeoProperty() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("NeoRelation")));
			if (src == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("NeoRelation") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoProperty(message.body().getJsonObject("NeoProperty"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoRelation_RELATION_PROPERTIES_NeoProperty(src, dst);

			message.reply(newSuccess(new JsonObject().put("RELATION_PROPERTIES", mapRelation(relation)).put("NeoProperty", mapNode(dst, NeoDomainDomain.Entities.NeoProperty))));
		};
	}

	private TransactionalMessageHandler onUpdate_RELATION_PROPERTIES() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("RELATION_PROPERTIES");
			if (relation == null) {
				message.reply(newFail("RELATION_PROPERTIES missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoProperty_RELATION_PROPERTIES_for_NeoRelation(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("RELATION_PROPERTIES", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("RELATION_PROPERTIES " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoProperty_RELATION_PROPERTIES_for_NeoRelation(NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("NeoRelation"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.RELATION_PROPERTIES.name(), mapRelation(relationship)).put("NeoProperty", mapNode(other, NeoDomainDomain.Entities.NeoProperty)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoRelation_RELATION_PROPERTIES_FOR_NeoProperty() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoPropertyBy_UUID(db, UUID.fromString(message.body().getString("NeoProperty")));
			final Relationship relation = NeoDomainDomain.get_NeoRelation_RELATION_PROPERTIES_Relation_for_NeoProperty(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.RELATION_PROPERTIES.name(), mapRelation(relation)).put("NeoRelation", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoRelation))));
		};
	}



	// ONE 'NeoEntity' -> ENTITY_PROPERTIES -> MANY 'NeoProperty'

	private TransactionalMessageHandler onRelate_NeoEntity_ENTITY_PROPERTIES_NeoProperty() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("NeoEntity") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoProperty(message.body().getJsonObject("NeoProperty"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoEntity_ENTITY_PROPERTIES_NeoProperty(src, dst);

			message.reply(newSuccess(new JsonObject().put("ENTITY_PROPERTIES", mapRelation(relation)).put("NeoProperty", mapNode(dst, NeoDomainDomain.Entities.NeoProperty))));
		};
	}

	private TransactionalMessageHandler onUpdate_ENTITY_PROPERTIES() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoEntity " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("ENTITY_PROPERTIES");
			if (relation == null) {
				message.reply(newFail("ENTITY_PROPERTIES missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoProperty_ENTITY_PROPERTIES_for_NeoEntity(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("ENTITY_PROPERTIES", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("ENTITY_PROPERTIES " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoProperty_ENTITY_PROPERTIES_for_NeoEntity(NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_PROPERTIES.name(), mapRelation(relationship)).put("NeoProperty", mapNode(other, NeoDomainDomain.Entities.NeoProperty)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoEntity_ENTITY_PROPERTIES_FOR_NeoProperty() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoPropertyBy_UUID(db, UUID.fromString(message.body().getString("NeoProperty")));
			final Relationship relation = NeoDomainDomain.get_NeoEntity_ENTITY_PROPERTIES_Relation_for_NeoProperty(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.ENTITY_PROPERTIES.name(), mapRelation(relation)).put("NeoEntity", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoEntity))));
		};
	}



	// MANY 'NeoRelation' -> RELATION_ENTITY -> MANY 'NeoEntity'

	private TransactionalMessageHandler onRelate_NeoRelation_RELATION_ENTITY_NeoEntity() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("NeoRelation")));
			if (src == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("NeoRelation") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoEntity(message.body().getJsonObject("NeoEntity"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoRelation_RELATION_ENTITY_NeoEntity(src, dst);

			message.reply(newSuccess(new JsonObject().put("RELATION_ENTITY", mapRelation(relation)).put("NeoEntity", mapNode(dst, NeoDomainDomain.Entities.NeoEntity))));
		};
	}

	private TransactionalMessageHandler onUpdate_RELATION_ENTITY() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoRelation " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("RELATION_ENTITY");
			if (relation == null) {
				message.reply(newFail("RELATION_ENTITY missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoEntity_RELATION_ENTITY_for_NeoRelation(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("RELATION_ENTITY", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("RELATION_ENTITY " + relationUUID + " not found"));
		};
	}


	// many-to-many
	private TransactionalMessageHandler onGet_NeoEntity_RELATION_ENTITY_FOR_NeoRelation() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoEntity_RELATION_ENTITY_for_NeoRelation(NeoDomainDomain.findNeoRelationBy_UUID(db, UUID.fromString(message.body().getString("NeoRelation"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.RELATION_ENTITY.name(), mapRelation(relationship)).put("NeoEntity", mapNode(other, NeoDomainDomain.Entities.NeoEntity)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoRelation_RELATION_ENTITY_FOR_NeoEntity() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoRelation_RELATION_ENTITY_for_NeoEntity(NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.RELATION_ENTITY.name(), mapRelation(relationship)).put("NeoRelation", mapNode(other, NeoDomainDomain.Entities.NeoRelation)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}


	// ONE 'NeoDomain' -> ENTITIES -> MANY 'NeoEntity'

	private TransactionalMessageHandler onRelate_NeoDomain_ENTITIES_NeoEntity() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("NeoDomain") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoEntity(message.body().getJsonObject("NeoEntity"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoDomain_ENTITIES_NeoEntity(src, dst);

			message.reply(newSuccess(new JsonObject().put("ENTITIES", mapRelation(relation)).put("NeoEntity", mapNode(dst, NeoDomainDomain.Entities.NeoEntity))));
		};
	}

	private TransactionalMessageHandler onUpdate_ENTITIES() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("ENTITIES");
			if (relation == null) {
				message.reply(newFail("ENTITIES missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoEntity_ENTITIES_for_NeoDomain(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("ENTITIES", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("ENTITIES " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoEntity_ENTITIES_FOR_NeoDomain() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoEntity_ENTITIES_for_NeoDomain(NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.ENTITIES.name(), mapRelation(relationship)).put("NeoEntity", mapNode(other, NeoDomainDomain.Entities.NeoEntity)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoDomain_ENTITIES_FOR_NeoEntity() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoEntityBy_UUID(db, UUID.fromString(message.body().getString("NeoEntity")));
			final Relationship relation = NeoDomainDomain.get_NeoDomain_ENTITIES_Relation_for_NeoEntity(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.ENTITIES.name(), mapRelation(relation)).put("NeoDomain", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoDomain))));
		};
	}



	// ONE 'NeoDomain' -> RENDERER -> MANY 'NeoDomainRenderer'

	private TransactionalMessageHandler onRelate_NeoDomain_RENDERER_NeoDomainRenderer() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("NeoDomain") + " not found"));
				return;
			}
			final JsonArray errors = new JsonArray();
			final Node dst = newNeoDomainRenderer(message.body().getJsonObject("NeoDomainRenderer"), errors);
			if (!errors.isEmpty()) {
				message.reply(newFail(errors));
				return;
			}

			final Relationship relation = NeoDomainDomain.relate_NeoDomain_RENDERER_NeoDomainRenderer(src, dst);

			message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relation)).put("NeoDomainRenderer", mapNode(dst, NeoDomainDomain.Entities.NeoDomainRenderer))));
		};
	}

	private TransactionalMessageHandler onUpdate_RENDERER() {
		return (tx, message) -> {

			final Node src = NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("uuid")));
			if (src == null) {
				message.reply(newFail("NeoDomain " + message.body().getString("uuid") + " not found"));
				return;
			}

			final JsonObject relation = message.body().getJsonObject("RENDERER");
			if (relation == null) {
				message.reply(newFail("RENDERER missing"));
				return;
			}

			final UUID relationUUID = getUuid(relation);
			final AtomicBoolean found = new AtomicBoolean(false);
			NeoDomainDomain.get_NeoDomainRenderer_RENDERER_for_NeoDomain(src, (relationship, other) -> {
				if (!relationUUID.equals(NeoDomainDomain.getUUID(relationship))) return false;
				message.reply(newSuccess(new JsonObject().put("RENDERER", mapRelation(relationship))));
				found.set(true);
				return true;
			});

			if (!found.get())
				message.reply(newFail("RENDERER " + relationUUID + " not found"));
		};
	}


	// one-to-many
	private TransactionalMessageHandler onGet_NeoDomainRenderer_RENDERER_FOR_NeoDomain() {
		return (tx, message) -> {
			final JsonArray result = new JsonArray();
			NeoDomainDomain.get_NeoDomainRenderer_RENDERER_for_NeoDomain(NeoDomainDomain.findNeoDomainBy_UUID(db, UUID.fromString(message.body().getString("NeoDomain"))), (relationship, other) -> {
				result.add(new JsonObject().put(NeoDomainDomain.Relations.RENDERER.name(), mapRelation(relationship)).put("NeoDomainRenderer", mapNode(other, NeoDomainDomain.Entities.NeoDomainRenderer)));
				return false;
			});
			message.reply(newSuccess(result));
		};
	}

	private TransactionalMessageHandler onGet_NeoDomain_RENDERER_FOR_NeoDomainRenderer() {
		return (tx, message) -> {
			final Node node = NeoDomainDomain.findNeoDomainRendererBy_UUID(db, UUID.fromString(message.body().getString("NeoDomainRenderer")));
			final Relationship relation = NeoDomainDomain.get_NeoDomain_RENDERER_Relation_for_NeoDomainRenderer(node);
			if (relation == null) message.reply(newSuccess(new JsonObject()));
			else message.reply(newSuccess(new JsonObject().put(NeoDomainDomain.Relations.RENDERER.name(), mapRelation(relation)).put("NeoDomain", mapNode(relation.getOtherNode(node), NeoDomainDomain.Entities.NeoDomain))));
		};
	}



	private final TransactionalMessageHandler onRenderDomain() {
		return (tx, message) -> {
			renderDomain(message.body().getString("uuid"), message);
		};
	}

	protected void renderDomain(String uuid, Message<JsonObject> message) {
		log.warn("RenderDomain not implemented. Ignored parameters : " + message.body().encode());
	}


	private void handleInstanceMessage(Message<JsonObject> message) { log.info("unhandled NeoDomainDomain " + deploymentID() + " message " + message.body().toString()); }

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
		vertx.deployVerticle(NeoDomainDomainVerticleImpl.class, new DeploymentOptions().setConfig(new JsonObject().put("path", path)), result -> {
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