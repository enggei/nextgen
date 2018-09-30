package com.nextgen.core.domain;

import org.neo4j.graphdb.*;
import java.util.UUID;

public class NeoDomainDomain {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoDomainDomain.class);

	public enum Entities implements Label {
		NeoDomain, NeoVisitor, VisitorReturnValue, VisitorParameter, NeoEntity, NeoRelation, NeoProperty, NeoDomainRenderer
	}

	public enum Relations implements RelationshipType {
		_VERSION, DOMAIN_VISITORS, VISITOR_RETURNVALUES, VISITOR_PARAMETERS, ENTITY_VISITORS, ENTITY_RELATION, RELATION_PROPERTIES, ENTITY_PROPERTIES, RELATION_ENTITY, ENTITIES, RENDERER
	}

	public enum Properties {
		_uuid, cardinality, defaultColor, enumValues, highlightedColor, isRequired, label, name, packageName, renderCanvas, renderDomain, renderRemoteCanvas, renderServerMethod, renderVerticle, root, selectedColor, type, valueType
	}

	public enum Cardinality {
		ONE_TO_MANY, MANY_TO_ONE, ONE_TO_ONE, MANY_TO_MANY
	}

	public enum ValueType {
		String, Double, Integer, Boolean, Enum, Long, Character
	}


	public static GraphDatabaseService connect(String path) {
		return new org.neo4j.graphdb.factory.GraphDatabaseFactory().
					newEmbeddedDatabaseBuilder(new java.io.File(path)).
					setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").
					newGraphDatabase();
	}

	public interface TransactionHandler {

		void execute() throws Exception;

		void handleException(Exception e);

		void onSuccess();
	}

	public static void doInTransaction(GraphDatabaseService db, TransactionHandler transactionHandler) {
		try (Transaction tx = db.beginTx()) {
			transactionHandler.execute();
			tx.success();
		} catch (Exception e) {
			transactionHandler.handleException(e);
			return;
		}
		transactionHandler.onSuccess();
	}

	// ENTITIES -----------------------------------------------------------------------------

	// NeoDomain
	public static Node newNeoDomain(GraphDatabaseService db, String name) {
		return newNeoDomain(db, UUID.randomUUID(), name);
	}

	public static Node newNeoDomain(GraphDatabaseService db, UUID uuid, String name) {
		final Node node = db.createNode(Entities.NeoDomain);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteNeoDomain(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoDomainBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoDomainIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomain (name)");
	}

	public static void findAllNeoDomain(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoDomain);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoDomainBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoDomain, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoDomainByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.NeoDomain, Properties.name.name(), name);
	}

	// NeoVisitor
	public static Node newNeoVisitor(GraphDatabaseService db, String name) {
		return newNeoVisitor(db, UUID.randomUUID(), name);
	}

	public static Node newNeoVisitor(GraphDatabaseService db, UUID uuid, String name) {
		final Node node = db.createNode(Entities.NeoVisitor);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteNeoVisitor(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoVisitorBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoVisitorIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoVisitor (name)");
	}

	public static void findAllNeoVisitor(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoVisitor);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoVisitorBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoVisitor, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoVisitorByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.NeoVisitor, Properties.name.name(), name);
	}

	// VisitorReturnValue
	public static Node newVisitorReturnValue(GraphDatabaseService db, String type, String name) {
		return newVisitorReturnValue(db, UUID.randomUUID(), type, name);
	}

	public static Node newVisitorReturnValue(GraphDatabaseService db, UUID uuid, String type, String name) {
		final Node node = db.createNode(Entities.VisitorReturnValue);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (type != null) node.setProperty(Properties.type.name(), type);
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteVisitorReturnValue(GraphDatabaseService db, UUID uuid) {
		final Node node = findVisitorReturnValueBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createVisitorReturnValueIndexOnType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : VisitorReturnValue (type)");
	}

	public static void createVisitorReturnValueIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : VisitorReturnValue (name)");
	}

	public static void findAllVisitorReturnValue(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.VisitorReturnValue);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findVisitorReturnValueBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.VisitorReturnValue, Properties._uuid.name(), uuid.toString());
	}

	public static Node findVisitorReturnValueByType(GraphDatabaseService db, String type) {
		return db.findNode(Entities.VisitorReturnValue, Properties.type.name(), type);
	}

	public static Node findVisitorReturnValueByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.VisitorReturnValue, Properties.name.name(), name);
	}

	// VisitorParameter
	public static Node newVisitorParameter(GraphDatabaseService db, String type, String name) {
		return newVisitorParameter(db, UUID.randomUUID(), type, name);
	}

	public static Node newVisitorParameter(GraphDatabaseService db, UUID uuid, String type, String name) {
		final Node node = db.createNode(Entities.VisitorParameter);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (type != null) node.setProperty(Properties.type.name(), type);
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteVisitorParameter(GraphDatabaseService db, UUID uuid) {
		final Node node = findVisitorParameterBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createVisitorParameterIndexOnType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : VisitorParameter (type)");
	}

	public static void createVisitorParameterIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : VisitorParameter (name)");
	}

	public static void findAllVisitorParameter(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.VisitorParameter);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findVisitorParameterBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.VisitorParameter, Properties._uuid.name(), uuid.toString());
	}

	public static Node findVisitorParameterByType(GraphDatabaseService db, String type) {
		return db.findNode(Entities.VisitorParameter, Properties.type.name(), type);
	}

	public static Node findVisitorParameterByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.VisitorParameter, Properties.name.name(), name);
	}

	// NeoEntity
	public static Node newNeoEntity(GraphDatabaseService db, String highlightedColor, String selectedColor, String defaultColor, String label, String name) {
		return newNeoEntity(db, UUID.randomUUID(), highlightedColor, selectedColor, defaultColor, label, name);
	}

	public static Node newNeoEntity(GraphDatabaseService db, UUID uuid, String highlightedColor, String selectedColor, String defaultColor, String label, String name) {
		final Node node = db.createNode(Entities.NeoEntity);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (highlightedColor != null) node.setProperty(Properties.highlightedColor.name(), highlightedColor);
		if (selectedColor != null) node.setProperty(Properties.selectedColor.name(), selectedColor);
		if (defaultColor != null) node.setProperty(Properties.defaultColor.name(), defaultColor);
		if (label != null) node.setProperty(Properties.label.name(), label);
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteNeoEntity(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoEntityBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoEntityIndexOnHighlightedColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoEntity (highlightedColor)");
	}

	public static void createNeoEntityIndexOnSelectedColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoEntity (selectedColor)");
	}

	public static void createNeoEntityIndexOnDefaultColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoEntity (defaultColor)");
	}

	public static void createNeoEntityIndexOnLabel(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoEntity (label)");
	}

	public static void createNeoEntityIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoEntity (name)");
	}

	public static void findAllNeoEntity(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoEntity);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoEntityBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoEntity, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoEntityByHighlightedColor(GraphDatabaseService db, String highlightedColor) {
		return db.findNode(Entities.NeoEntity, Properties.highlightedColor.name(), highlightedColor);
	}

	public static Node findNeoEntityBySelectedColor(GraphDatabaseService db, String selectedColor) {
		return db.findNode(Entities.NeoEntity, Properties.selectedColor.name(), selectedColor);
	}

	public static Node findNeoEntityByDefaultColor(GraphDatabaseService db, String defaultColor) {
		return db.findNode(Entities.NeoEntity, Properties.defaultColor.name(), defaultColor);
	}

	public static Node findNeoEntityByLabel(GraphDatabaseService db, String label) {
		return db.findNode(Entities.NeoEntity, Properties.label.name(), label);
	}

	public static Node findNeoEntityByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.NeoEntity, Properties.name.name(), name);
	}

	// NeoRelation
	public static Node newNeoRelation(GraphDatabaseService db, Cardinality cardinality, String name) {
		return newNeoRelation(db, UUID.randomUUID(), cardinality, name);
	}

	public static Node newNeoRelation(GraphDatabaseService db, UUID uuid, Cardinality cardinality, String name) {
		final Node node = db.createNode(Entities.NeoRelation);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (cardinality != null) node.setProperty(Properties.cardinality.name(), cardinality.name());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteNeoRelation(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoRelationBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoRelationIndexOnCardinality(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoRelation (cardinality)");
	}

	public static void createNeoRelationIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoRelation (name)");
	}

	public static void findAllNeoRelation(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoRelation);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoRelationBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoRelation, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoRelationByCardinality(GraphDatabaseService db, Cardinality cardinality) {
		return db.findNode(Entities.NeoRelation, Properties.cardinality.name(), cardinality.name());
	}

	public static Node findNeoRelationByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.NeoRelation, Properties.name.name(), name);
	}

	// NeoProperty
	public static Node newNeoProperty(GraphDatabaseService db, Boolean isRequired, String enumValues, ValueType valueType, String name) {
		return newNeoProperty(db, UUID.randomUUID(), isRequired, enumValues, valueType, name);
	}

	public static Node newNeoProperty(GraphDatabaseService db, UUID uuid, Boolean isRequired, String enumValues, ValueType valueType, String name) {
		final Node node = db.createNode(Entities.NeoProperty);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (isRequired != null) node.setProperty(Properties.isRequired.name(), isRequired);
		if (enumValues != null) node.setProperty(Properties.enumValues.name(), enumValues);
		if (valueType != null) node.setProperty(Properties.valueType.name(), valueType.name());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void deleteNeoProperty(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoPropertyBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoPropertyIndexOnIsRequired(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoProperty (isRequired)");
	}

	public static void createNeoPropertyIndexOnEnumValues(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoProperty (enumValues)");
	}

	public static void createNeoPropertyIndexOnValueType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoProperty (valueType)");
	}

	public static void createNeoPropertyIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoProperty (name)");
	}

	public static void findAllNeoProperty(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoProperty);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoPropertyBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoProperty, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoPropertyByIsRequired(GraphDatabaseService db, Boolean isRequired) {
		return db.findNode(Entities.NeoProperty, Properties.isRequired.name(), isRequired);
	}

	public static Node findNeoPropertyByEnumValues(GraphDatabaseService db, String enumValues) {
		return db.findNode(Entities.NeoProperty, Properties.enumValues.name(), enumValues);
	}

	public static Node findNeoPropertyByValueType(GraphDatabaseService db, ValueType valueType) {
		return db.findNode(Entities.NeoProperty, Properties.valueType.name(), valueType.name());
	}

	public static Node findNeoPropertyByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.NeoProperty, Properties.name.name(), name);
	}

	// NeoDomainRenderer
	public static Node newNeoDomainRenderer(GraphDatabaseService db, Boolean renderServerMethod, Boolean renderRemoteCanvas, Boolean renderCanvas, Boolean renderDomain, Boolean renderVerticle, String packageName, String root) {
		return newNeoDomainRenderer(db, UUID.randomUUID(), renderServerMethod, renderRemoteCanvas, renderCanvas, renderDomain, renderVerticle, packageName, root);
	}

	public static Node newNeoDomainRenderer(GraphDatabaseService db, UUID uuid, Boolean renderServerMethod, Boolean renderRemoteCanvas, Boolean renderCanvas, Boolean renderDomain, Boolean renderVerticle, String packageName, String root) {
		final Node node = db.createNode(Entities.NeoDomainRenderer);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (renderServerMethod != null) node.setProperty(Properties.renderServerMethod.name(), renderServerMethod);
		if (renderRemoteCanvas != null) node.setProperty(Properties.renderRemoteCanvas.name(), renderRemoteCanvas);
		if (renderCanvas != null) node.setProperty(Properties.renderCanvas.name(), renderCanvas);
		if (renderDomain != null) node.setProperty(Properties.renderDomain.name(), renderDomain);
		if (renderVerticle != null) node.setProperty(Properties.renderVerticle.name(), renderVerticle);
		if (packageName != null) node.setProperty(Properties.packageName.name(), packageName);
		if (root != null) node.setProperty(Properties.root.name(), root);

		return node;
	}

	public static void deleteNeoDomainRenderer(GraphDatabaseService db, UUID uuid) {
		final Node node = findNeoDomainRendererBy_UUID(db, uuid);
		if (node == null) return;
		node.delete();
	}

	public static void createNeoDomainRendererIndexOnRenderServerMethod(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (renderServerMethod)");
	}

	public static void createNeoDomainRendererIndexOnRenderRemoteCanvas(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (renderRemoteCanvas)");
	}

	public static void createNeoDomainRendererIndexOnRenderCanvas(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (renderCanvas)");
	}

	public static void createNeoDomainRendererIndexOnRenderDomain(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (renderDomain)");
	}

	public static void createNeoDomainRendererIndexOnRenderVerticle(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (renderVerticle)");
	}

	public static void createNeoDomainRendererIndexOnPackageName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (packageName)");
	}

	public static void createNeoDomainRendererIndexOnRoot(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : NeoDomainRenderer (root)");
	}

	public static void findAllNeoDomainRenderer(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.NeoDomainRenderer);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findNeoDomainRendererBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.NeoDomainRenderer, Properties._uuid.name(), uuid.toString());
	}

	public static Node findNeoDomainRendererByRenderServerMethod(GraphDatabaseService db, Boolean renderServerMethod) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.renderServerMethod.name(), renderServerMethod);
	}

	public static Node findNeoDomainRendererByRenderRemoteCanvas(GraphDatabaseService db, Boolean renderRemoteCanvas) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.renderRemoteCanvas.name(), renderRemoteCanvas);
	}

	public static Node findNeoDomainRendererByRenderCanvas(GraphDatabaseService db, Boolean renderCanvas) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.renderCanvas.name(), renderCanvas);
	}

	public static Node findNeoDomainRendererByRenderDomain(GraphDatabaseService db, Boolean renderDomain) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.renderDomain.name(), renderDomain);
	}

	public static Node findNeoDomainRendererByRenderVerticle(GraphDatabaseService db, Boolean renderVerticle) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.renderVerticle.name(), renderVerticle);
	}

	public static Node findNeoDomainRendererByPackageName(GraphDatabaseService db, String packageName) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.packageName.name(), packageName);
	}

	public static Node findNeoDomainRendererByRoot(GraphDatabaseService db, String root) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.root.name(), root);
	}


	// RELATIONS ----------------------------------------------------------------------------

	// ONE 'NeoDomain' -> DOMAIN_VISITORS -> MANY 'NeoVisitor'

	public static Relationship relate_NeoDomain_DOMAIN_VISITORS_NeoVisitor(Node neoDomain, Node neoVisitor) {
		return relate(neoDomain, neoVisitor, Relations.DOMAIN_VISITORS);
	}

	public static void unrelate_NeoDomain_DOMAIN_VISITORS_NeoVisitor(Node neoDomain, Node neoVisitor) {
		unrelate(neoDomain, neoVisitor, Relations.DOMAIN_VISITORS);
	}

	// one-to-many
	public static void get_NeoVisitor_DOMAIN_VISITORS_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.DOMAIN_VISITORS);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoDomain))) break;
	}

	public static Node get_NeoDomain_DOMAIN_VISITORS_for_NeoVisitor(Node neoVisitor) {
		final Relationship relationship = neoVisitor.getSingleRelationship(Relations.DOMAIN_VISITORS, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoVisitor);
	}

	public static Relationship get_NeoDomain_DOMAIN_VISITORS_Relation_for_NeoVisitor(Node neoVisitor) {
		return neoVisitor.getSingleRelationship(Relations.DOMAIN_VISITORS, Direction.INCOMING);
	}


	// ONE 'NeoVisitor' -> VISITOR_RETURNVALUES -> MANY 'VisitorReturnValue'

	public static Relationship relate_NeoVisitor_VISITOR_RETURNVALUES_VisitorReturnValue(Node neoVisitor, Node visitorReturnValue) {
		return relate(neoVisitor, visitorReturnValue, Relations.VISITOR_RETURNVALUES);
	}

	public static void unrelate_NeoVisitor_VISITOR_RETURNVALUES_VisitorReturnValue(Node neoVisitor, Node visitorReturnValue) {
		unrelate(neoVisitor, visitorReturnValue, Relations.VISITOR_RETURNVALUES);
	}

	// one-to-many
	public static void get_VisitorReturnValue_VISITOR_RETURNVALUES_for_NeoVisitor(Node neoVisitor, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoVisitor.getRelationships(Direction.OUTGOING, Relations.VISITOR_RETURNVALUES);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoVisitor))) break;
	}

	public static Node get_NeoVisitor_VISITOR_RETURNVALUES_for_VisitorReturnValue(Node visitorReturnValue) {
		final Relationship relationship = visitorReturnValue.getSingleRelationship(Relations.VISITOR_RETURNVALUES, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(visitorReturnValue);
	}

	public static Relationship get_NeoVisitor_VISITOR_RETURNVALUES_Relation_for_VisitorReturnValue(Node visitorReturnValue) {
		return visitorReturnValue.getSingleRelationship(Relations.VISITOR_RETURNVALUES, Direction.INCOMING);
	}


	// ONE 'NeoVisitor' -> VISITOR_PARAMETERS -> MANY 'VisitorParameter'

	public static Relationship relate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter(Node neoVisitor, Node visitorParameter) {
		return relate(neoVisitor, visitorParameter, Relations.VISITOR_PARAMETERS);
	}

	public static void unrelate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter(Node neoVisitor, Node visitorParameter) {
		unrelate(neoVisitor, visitorParameter, Relations.VISITOR_PARAMETERS);
	}

	// one-to-many
	public static void get_VisitorParameter_VISITOR_PARAMETERS_for_NeoVisitor(Node neoVisitor, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoVisitor.getRelationships(Direction.OUTGOING, Relations.VISITOR_PARAMETERS);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoVisitor))) break;
	}

	public static Node get_NeoVisitor_VISITOR_PARAMETERS_for_VisitorParameter(Node visitorParameter) {
		final Relationship relationship = visitorParameter.getSingleRelationship(Relations.VISITOR_PARAMETERS, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(visitorParameter);
	}

	public static Relationship get_NeoVisitor_VISITOR_PARAMETERS_Relation_for_VisitorParameter(Node visitorParameter) {
		return visitorParameter.getSingleRelationship(Relations.VISITOR_PARAMETERS, Direction.INCOMING);
	}


	// ONE 'NeoEntity' -> ENTITY_VISITORS -> MANY 'NeoVisitor'

	public static Relationship relate_NeoEntity_ENTITY_VISITORS_NeoVisitor(Node neoEntity, Node neoVisitor) {
		return relate(neoEntity, neoVisitor, Relations.ENTITY_VISITORS);
	}

	public static void unrelate_NeoEntity_ENTITY_VISITORS_NeoVisitor(Node neoEntity, Node neoVisitor) {
		unrelate(neoEntity, neoVisitor, Relations.ENTITY_VISITORS);
	}

	// one-to-many
	public static void get_NeoVisitor_ENTITY_VISITORS_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_VISITORS);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoEntity))) break;
	}

	public static Node get_NeoEntity_ENTITY_VISITORS_for_NeoVisitor(Node neoVisitor) {
		final Relationship relationship = neoVisitor.getSingleRelationship(Relations.ENTITY_VISITORS, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoVisitor);
	}

	public static Relationship get_NeoEntity_ENTITY_VISITORS_Relation_for_NeoVisitor(Node neoVisitor) {
		return neoVisitor.getSingleRelationship(Relations.ENTITY_VISITORS, Direction.INCOMING);
	}


	// MANY 'NeoEntity' -> ENTITY_RELATION -> MANY 'NeoRelation'

	public static Relationship relate_NeoEntity_ENTITY_RELATION_NeoRelation(Node neoEntity, Node neoRelation) {
		return relate(neoEntity, neoRelation, Relations.ENTITY_RELATION);
	}

	public static void unrelate_NeoEntity_ENTITY_RELATION_NeoRelation(Node neoEntity, Node neoRelation) {
		unrelate(neoEntity, neoRelation, Relations.ENTITY_RELATION);
	}

	// many-to-many
	public static void get_NeoRelation_ENTITY_RELATION_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_RELATION);
		for (Relationship relationship : relations) {
			if (consumer.handle(relationship, relationship.getOtherNode(neoEntity))) break;
		}
	}

	public static void get_NeoEntity_ENTITY_RELATION_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.INCOMING, Relations.ENTITY_RELATION);
		for (Relationship relationship : relations) {
			if (consumer.handle(relationship, relationship.getOtherNode(neoRelation))) break;
		}
	}


	// ONE 'NeoRelation' -> RELATION_PROPERTIES -> MANY 'NeoProperty'

	public static Relationship relate_NeoRelation_RELATION_PROPERTIES_NeoProperty(Node neoRelation, Node neoProperty) {
		return relate(neoRelation, neoProperty, Relations.RELATION_PROPERTIES);
	}

	public static void unrelate_NeoRelation_RELATION_PROPERTIES_NeoProperty(Node neoRelation, Node neoProperty) {
		unrelate(neoRelation, neoProperty, Relations.RELATION_PROPERTIES);
	}

	// one-to-many
	public static void get_NeoProperty_RELATION_PROPERTIES_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.OUTGOING, Relations.RELATION_PROPERTIES);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoRelation))) break;
	}

	public static Node get_NeoRelation_RELATION_PROPERTIES_for_NeoProperty(Node neoProperty) {
		final Relationship relationship = neoProperty.getSingleRelationship(Relations.RELATION_PROPERTIES, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoProperty);
	}

	public static Relationship get_NeoRelation_RELATION_PROPERTIES_Relation_for_NeoProperty(Node neoProperty) {
		return neoProperty.getSingleRelationship(Relations.RELATION_PROPERTIES, Direction.INCOMING);
	}


	// ONE 'NeoEntity' -> ENTITY_PROPERTIES -> MANY 'NeoProperty'

	public static Relationship relate_NeoEntity_ENTITY_PROPERTIES_NeoProperty(Node neoEntity, Node neoProperty) {
		return relate(neoEntity, neoProperty, Relations.ENTITY_PROPERTIES);
	}

	public static void unrelate_NeoEntity_ENTITY_PROPERTIES_NeoProperty(Node neoEntity, Node neoProperty) {
		unrelate(neoEntity, neoProperty, Relations.ENTITY_PROPERTIES);
	}

	// one-to-many
	public static void get_NeoProperty_ENTITY_PROPERTIES_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_PROPERTIES);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoEntity))) break;
	}

	public static Node get_NeoEntity_ENTITY_PROPERTIES_for_NeoProperty(Node neoProperty) {
		final Relationship relationship = neoProperty.getSingleRelationship(Relations.ENTITY_PROPERTIES, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoProperty);
	}

	public static Relationship get_NeoEntity_ENTITY_PROPERTIES_Relation_for_NeoProperty(Node neoProperty) {
		return neoProperty.getSingleRelationship(Relations.ENTITY_PROPERTIES, Direction.INCOMING);
	}


	// MANY 'NeoRelation' -> RELATION_ENTITY -> MANY 'NeoEntity'

	public static Relationship relate_NeoRelation_RELATION_ENTITY_NeoEntity(Node neoRelation, Node neoEntity) {
		return relate(neoRelation, neoEntity, Relations.RELATION_ENTITY);
	}

	public static void unrelate_NeoRelation_RELATION_ENTITY_NeoEntity(Node neoRelation, Node neoEntity) {
		unrelate(neoRelation, neoEntity, Relations.RELATION_ENTITY);
	}

	// many-to-many
	public static void get_NeoEntity_RELATION_ENTITY_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.OUTGOING, Relations.RELATION_ENTITY);
		for (Relationship relationship : relations) {
			if (consumer.handle(relationship, relationship.getOtherNode(neoRelation))) break;
		}
	}

	public static void get_NeoRelation_RELATION_ENTITY_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.INCOMING, Relations.RELATION_ENTITY);
		for (Relationship relationship : relations) {
			if (consumer.handle(relationship, relationship.getOtherNode(neoEntity))) break;
		}
	}


	// ONE 'NeoDomain' -> ENTITIES -> MANY 'NeoEntity'

	public static Relationship relate_NeoDomain_ENTITIES_NeoEntity(Node neoDomain, Node neoEntity) {
		return relate(neoDomain, neoEntity, Relations.ENTITIES);
	}

	public static void unrelate_NeoDomain_ENTITIES_NeoEntity(Node neoDomain, Node neoEntity) {
		unrelate(neoDomain, neoEntity, Relations.ENTITIES);
	}

	// one-to-many
	public static void get_NeoEntity_ENTITIES_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.ENTITIES);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoDomain))) break;
	}

	public static Node get_NeoDomain_ENTITIES_for_NeoEntity(Node neoEntity) {
		final Relationship relationship = neoEntity.getSingleRelationship(Relations.ENTITIES, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoEntity);
	}

	public static Relationship get_NeoDomain_ENTITIES_Relation_for_NeoEntity(Node neoEntity) {
		return neoEntity.getSingleRelationship(Relations.ENTITIES, Direction.INCOMING);
	}


	// ONE 'NeoDomain' -> RENDERER -> MANY 'NeoDomainRenderer'

	public static Relationship relate_NeoDomain_RENDERER_NeoDomainRenderer(Node neoDomain, Node neoDomainRenderer) {
		return relate(neoDomain, neoDomainRenderer, Relations.RENDERER);
	}

	public static void unrelate_NeoDomain_RENDERER_NeoDomainRenderer(Node neoDomain, Node neoDomainRenderer) {
		unrelate(neoDomain, neoDomainRenderer, Relations.RENDERER);
	}

	// one-to-many
	public static void get_NeoDomainRenderer_RENDERER_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.RENDERER);
		for (Relationship relationship : relations) 
			if (consumer.handle(relationship, relationship.getOtherNode(neoDomain))) break;
	}

	public static Node get_NeoDomain_RENDERER_for_NeoDomainRenderer(Node neoDomainRenderer) {
		final Relationship relationship = neoDomainRenderer.getSingleRelationship(Relations.RENDERER, Direction.INCOMING);
		if (relationship == null) return null;
		return relationship.getOtherNode(neoDomainRenderer);
	}

	public static Relationship get_NeoDomain_RENDERER_Relation_for_NeoDomainRenderer(Node neoDomainRenderer) {
		return neoDomainRenderer.getSingleRelationship(Relations.RENDERER, Direction.INCOMING);
	}



	// PROPERTIES ---------------------------------------------------------------------------

	public static Cardinality getCardinality(PropertyContainer container) {
		return getCardinality(container, null);
	}

	public static Cardinality getCardinality(PropertyContainer container, Cardinality defaultValue) {
		return container == null || !container.hasProperty(Properties.cardinality.name()) ? defaultValue : Cardinality.valueOf(container.getProperty(Properties.cardinality.name()).toString());
	}

	public static void setCardinality(PropertyContainer container, Cardinality value) {
		if (container == null) return;

		if (value == null) {
			deleteCardinality(container);
			return;
		}

		container.setProperty(Properties.cardinality.name(), value.name());
	}

	public static void deleteCardinality(PropertyContainer container) {
		if (container.hasProperty(Properties.cardinality.name())) container.removeProperty(Properties.cardinality.name());
	}


	public static String getDefaultColor(PropertyContainer container) {
		return getDefaultColor(container, null);
	}

	public static String getDefaultColor(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.defaultColor.name(), defaultValue);
	}

	public static void setDefaultColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteDefaultColor(container);
			return;
		}

		container.setProperty(Properties.defaultColor.name(), value);
	}

	public static void deleteDefaultColor(PropertyContainer container) {
		if (container.hasProperty(Properties.defaultColor.name())) container.removeProperty(Properties.defaultColor.name());
	}


	public static String getEnumValues(PropertyContainer container) {
		return getEnumValues(container, null);
	}

	public static String getEnumValues(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.enumValues.name(), defaultValue);
	}

	public static void setEnumValues(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteEnumValues(container);
			return;
		}

		container.setProperty(Properties.enumValues.name(), value);
	}

	public static void deleteEnumValues(PropertyContainer container) {
		if (container.hasProperty(Properties.enumValues.name())) container.removeProperty(Properties.enumValues.name());
	}


	public static String getHighlightedColor(PropertyContainer container) {
		return getHighlightedColor(container, null);
	}

	public static String getHighlightedColor(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.highlightedColor.name(), defaultValue);
	}

	public static void setHighlightedColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteHighlightedColor(container);
			return;
		}

		container.setProperty(Properties.highlightedColor.name(), value);
	}

	public static void deleteHighlightedColor(PropertyContainer container) {
		if (container.hasProperty(Properties.highlightedColor.name())) container.removeProperty(Properties.highlightedColor.name());
	}


	public static Boolean getIsRequired(PropertyContainer container) {
		return getIsRequired(container, null);
	}

	public static Boolean getIsRequired(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.isRequired.name(), defaultValue);
	}

	public static void setIsRequired(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteIsRequired(container);
			return;
		}

		container.setProperty(Properties.isRequired.name(), value);
	}

	public static void deleteIsRequired(PropertyContainer container) {
		if (container.hasProperty(Properties.isRequired.name())) container.removeProperty(Properties.isRequired.name());
	}


	public static String getLabel(PropertyContainer container) {
		return getLabel(container, null);
	}

	public static String getLabel(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.label.name(), defaultValue);
	}

	public static void setLabel(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteLabel(container);
			return;
		}

		container.setProperty(Properties.label.name(), value);
	}

	public static void deleteLabel(PropertyContainer container) {
		if (container.hasProperty(Properties.label.name())) container.removeProperty(Properties.label.name());
	}


	public static String getName(PropertyContainer container) {
		return getName(container, null);
	}

	public static String getName(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.name.name(), defaultValue);
	}

	public static void setName(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteName(container);
			return;
		}

		container.setProperty(Properties.name.name(), value);
	}

	public static void deleteName(PropertyContainer container) {
		if (container.hasProperty(Properties.name.name())) container.removeProperty(Properties.name.name());
	}


	public static String getPackageName(PropertyContainer container) {
		return getPackageName(container, null);
	}

	public static String getPackageName(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.packageName.name(), defaultValue);
	}

	public static void setPackageName(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deletePackageName(container);
			return;
		}

		container.setProperty(Properties.packageName.name(), value);
	}

	public static void deletePackageName(PropertyContainer container) {
		if (container.hasProperty(Properties.packageName.name())) container.removeProperty(Properties.packageName.name());
	}


	public static Boolean getRenderCanvas(PropertyContainer container) {
		return getRenderCanvas(container, null);
	}

	public static Boolean getRenderCanvas(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.renderCanvas.name(), defaultValue);
	}

	public static void setRenderCanvas(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderCanvas(container);
			return;
		}

		container.setProperty(Properties.renderCanvas.name(), value);
	}

	public static void deleteRenderCanvas(PropertyContainer container) {
		if (container.hasProperty(Properties.renderCanvas.name())) container.removeProperty(Properties.renderCanvas.name());
	}


	public static Boolean getRenderDomain(PropertyContainer container) {
		return getRenderDomain(container, null);
	}

	public static Boolean getRenderDomain(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.renderDomain.name(), defaultValue);
	}

	public static void setRenderDomain(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderDomain(container);
			return;
		}

		container.setProperty(Properties.renderDomain.name(), value);
	}

	public static void deleteRenderDomain(PropertyContainer container) {
		if (container.hasProperty(Properties.renderDomain.name())) container.removeProperty(Properties.renderDomain.name());
	}


	public static Boolean getRenderRemoteCanvas(PropertyContainer container) {
		return getRenderRemoteCanvas(container, null);
	}

	public static Boolean getRenderRemoteCanvas(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.renderRemoteCanvas.name(), defaultValue);
	}

	public static void setRenderRemoteCanvas(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderRemoteCanvas(container);
			return;
		}

		container.setProperty(Properties.renderRemoteCanvas.name(), value);
	}

	public static void deleteRenderRemoteCanvas(PropertyContainer container) {
		if (container.hasProperty(Properties.renderRemoteCanvas.name())) container.removeProperty(Properties.renderRemoteCanvas.name());
	}


	public static Boolean getRenderServerMethod(PropertyContainer container) {
		return getRenderServerMethod(container, null);
	}

	public static Boolean getRenderServerMethod(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.renderServerMethod.name(), defaultValue);
	}

	public static void setRenderServerMethod(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderServerMethod(container);
			return;
		}

		container.setProperty(Properties.renderServerMethod.name(), value);
	}

	public static void deleteRenderServerMethod(PropertyContainer container) {
		if (container.hasProperty(Properties.renderServerMethod.name())) container.removeProperty(Properties.renderServerMethod.name());
	}


	public static Boolean getRenderVerticle(PropertyContainer container) {
		return getRenderVerticle(container, null);
	}

	public static Boolean getRenderVerticle(PropertyContainer container, Boolean defaultValue) {
		return getBoolean(container, Properties.renderVerticle.name(), defaultValue);
	}

	public static void setRenderVerticle(PropertyContainer container, Boolean value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderVerticle(container);
			return;
		}

		container.setProperty(Properties.renderVerticle.name(), value);
	}

	public static void deleteRenderVerticle(PropertyContainer container) {
		if (container.hasProperty(Properties.renderVerticle.name())) container.removeProperty(Properties.renderVerticle.name());
	}


	public static String getRoot(PropertyContainer container) {
		return getRoot(container, null);
	}

	public static String getRoot(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.root.name(), defaultValue);
	}

	public static void setRoot(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteRoot(container);
			return;
		}

		container.setProperty(Properties.root.name(), value);
	}

	public static void deleteRoot(PropertyContainer container) {
		if (container.hasProperty(Properties.root.name())) container.removeProperty(Properties.root.name());
	}


	public static String getSelectedColor(PropertyContainer container) {
		return getSelectedColor(container, null);
	}

	public static String getSelectedColor(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.selectedColor.name(), defaultValue);
	}

	public static void setSelectedColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteSelectedColor(container);
			return;
		}

		container.setProperty(Properties.selectedColor.name(), value);
	}

	public static void deleteSelectedColor(PropertyContainer container) {
		if (container.hasProperty(Properties.selectedColor.name())) container.removeProperty(Properties.selectedColor.name());
	}


	public static String getType(PropertyContainer container) {
		return getType(container, null);
	}

	public static String getType(PropertyContainer container, String defaultValue) {
		return getString(container, Properties.type.name(), defaultValue);
	}

	public static void setType(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteType(container);
			return;
		}

		container.setProperty(Properties.type.name(), value);
	}

	public static void deleteType(PropertyContainer container) {
		if (container.hasProperty(Properties.type.name())) container.removeProperty(Properties.type.name());
	}


	public static ValueType getValueType(PropertyContainer container) {
		return getValueType(container, null);
	}

	public static ValueType getValueType(PropertyContainer container, ValueType defaultValue) {
		return container == null || !container.hasProperty(Properties.valueType.name()) ? defaultValue : ValueType.valueOf(container.getProperty(Properties.valueType.name()).toString());
	}

	public static void setValueType(PropertyContainer container, ValueType value) {
		if (container == null) return;

		if (value == null) {
			deleteValueType(container);
			return;
		}

		container.setProperty(Properties.valueType.name(), value.name());
	}

	public static void deleteValueType(PropertyContainer container) {
		if (container.hasProperty(Properties.valueType.name())) container.removeProperty(Properties.valueType.name());
	}


	// SUPPORT METHODS ----------------------------------------------------------------------

	public interface NodeConsumer {
		boolean handle(Node node);
	}

	public interface RelationConsumer {
		boolean handle(Relationship relationship, Node other);
	}

	public static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {

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

	public static void unrelate(Node source, Node target, RelationshipType relationshipType) {
		for (Object o : outgoing(source, relationshipType)) {
				final Relationship relationship = (Relationship) o;
				if (target.equals(other(source, relationship))) 
					relationship.delete();
		}
	}

	public static boolean isRelated(Node source, Node target, RelationshipType relationshipType) {
		for (Object o : outgoing(source, relationshipType)) {
				final Relationship relationship = (Relationship) o;
				if (target.equals(other(source, relationship)))
					return true;
		}
		return false;
	}

	public static Iterable<?> outgoing(Node node, RelationshipType type) {
		return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);
	}

	public static Node other(Node node, Relationship relationship) {
		return relationship == null ? null : relationship.getOtherNode(node);
	}

	// DOMAIN METHODS -----------------------------------------------------------------------

	public static Boolean getBoolean(PropertyContainer container, String name, Boolean defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : Boolean.valueOf(container.getProperty(name).toString());
	}

	public static String getString(PropertyContainer container, String name, String defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : container.getProperty(name).toString();
	}

	public static Double getDouble(PropertyContainer container, String name, Double defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : Double.valueOf(container.getProperty(name).toString());
	}

	public static Long getLong(PropertyContainer container, String name, Long defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : Long.valueOf(container.getProperty(name).toString());
	}

	public static Integer getInteger(PropertyContainer container, String name, Integer defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : Integer.valueOf(container.getProperty(name).toString());
	}

	public static Character getCharacter(PropertyContainer container, String name, Character defaultValue) {
		return container == null || !container.hasProperty(name) ? defaultValue : (Character)(container.getProperty(name));
	}

	public static UUID getUUID(PropertyContainer container) {
		return container.hasProperty(Properties._uuid.name()) ? UUID.fromString(container.getProperty(Properties._uuid.name()).toString()) : null;
	}
}