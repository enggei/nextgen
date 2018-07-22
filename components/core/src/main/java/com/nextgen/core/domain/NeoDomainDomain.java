package com.nextgen.core.domain;

import org.neo4j.graphdb.*;
import java.util.UUID;

public class NeoDomainDomain {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoDomainDomain.class);

	public enum Entities implements Label {
		NeoDomain, NeoVisitor, VisitorParameter, NeoEntity, NeoRelation, NeoProperty, NeoDomainRenderer
	}

	public enum Relations implements RelationshipType {
		_VERSION, DOMAIN_VISITORS, VISITOR_PARAMETERS, ENTITY_VISITORS, ENTITY_RELATION, RELATION_PROPERTIES, ENTITY_PROPERTIES, RELATION_ENTITY, ENTITIES, RENDERER
	}

	public enum Properties {
		_uuid, _deleted, _timestamp, cardinality, valueType, defaultColor, enumValues, highlightedColor, label, name, packageName, root, selectedColor, type
	}

	public enum Cardinality {
		ONE_TO_MANY, MANY_TO_ONE, ONE_TO_ONE, MANY_TO_MANY
	}

	public enum ValueType {
		String, Double, Integer, Boolean, Enum
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
	public static Node newNeoProperty(GraphDatabaseService db, String enumValues, ValueType valueType, String name) {
		return newNeoProperty(db, UUID.randomUUID(), enumValues, valueType, name);
	}

	public static Node newNeoProperty(GraphDatabaseService db, UUID uuid, String enumValues, ValueType valueType, String name) {
		final Node node = db.createNode(Entities.NeoProperty);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (enumValues != null) node.setProperty(Properties.enumValues.name(), enumValues);
		if (valueType != null) node.setProperty(Properties.valueType.name(), valueType.name());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
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
	public static Node newNeoDomainRenderer(GraphDatabaseService db, String packageName, String root) {
		return newNeoDomainRenderer(db, UUID.randomUUID(), packageName, root);
	}

	public static Node newNeoDomainRenderer(GraphDatabaseService db, UUID uuid, String packageName, String root) {
		final Node node = db.createNode(Entities.NeoDomainRenderer);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (packageName != null) node.setProperty(Properties.packageName.name(), packageName);
		if (root != null) node.setProperty(Properties.root.name(), root);

		return node;
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

	public static Node findNeoDomainRendererByPackageName(GraphDatabaseService db, String packageName) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.packageName.name(), packageName);
	}

	public static Node findNeoDomainRendererByRoot(GraphDatabaseService db, String root) {
		return db.findNode(Entities.NeoDomainRenderer, Properties.root.name(), root);
	}


	// RELATIONS ----------------------------------------------------------------------------

	// ONE 'NeoDomain' -> DOMAIN_VISITORS -> MANY 'NeoVisitor'

	public static Relationship relate_NeoDomain_DOMAIN_VISITORS_NeoVisitor(Node neoDomain, Node neoVisitor) {
		final Relationship relation = relate(neoDomain, neoVisitor, Relations.DOMAIN_VISITORS);
		return relation;
	}

	// one-to-many
	public static void get_NeoVisitor_DOMAIN_VISITORS_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.DOMAIN_VISITORS);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoDomain);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoDomain_DOMAIN_VISITORS_for_NeoVisitor(Node neoVisitor) {
		final Relationship relationship = neoVisitor.getSingleRelationship(Relations.DOMAIN_VISITORS, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoVisitor);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoDomain_DOMAIN_VISITORS_Relation_for_NeoVisitor(Node neoVisitor) {
		return neoVisitor.getSingleRelationship(Relations.DOMAIN_VISITORS, Direction.INCOMING);
	}


	// ONE 'NeoVisitor' -> VISITOR_PARAMETERS -> MANY 'VisitorParameter'

	public static Relationship relate_NeoVisitor_VISITOR_PARAMETERS_VisitorParameter(Node neoVisitor, Node visitorParameter) {
		final Relationship relation = relate(neoVisitor, visitorParameter, Relations.VISITOR_PARAMETERS);
		return relation;
	}

	// one-to-many
	public static void get_VisitorParameter_VISITOR_PARAMETERS_for_NeoVisitor(Node neoVisitor, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoVisitor.getRelationships(Direction.OUTGOING, Relations.VISITOR_PARAMETERS);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoVisitor);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoVisitor_VISITOR_PARAMETERS_for_VisitorParameter(Node visitorParameter) {
		final Relationship relationship = visitorParameter.getSingleRelationship(Relations.VISITOR_PARAMETERS, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(visitorParameter);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoVisitor_VISITOR_PARAMETERS_Relation_for_VisitorParameter(Node visitorParameter) {
		return visitorParameter.getSingleRelationship(Relations.VISITOR_PARAMETERS, Direction.INCOMING);
	}


	// ONE 'NeoEntity' -> ENTITY_VISITORS -> MANY 'NeoVisitor'

	public static Relationship relate_NeoEntity_ENTITY_VISITORS_NeoVisitor(Node neoEntity, Node neoVisitor) {
		final Relationship relation = relate(neoEntity, neoVisitor, Relations.ENTITY_VISITORS);
		return relation;
	}

	// one-to-many
	public static void get_NeoVisitor_ENTITY_VISITORS_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_VISITORS);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoEntity);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoEntity_ENTITY_VISITORS_for_NeoVisitor(Node neoVisitor) {
		final Relationship relationship = neoVisitor.getSingleRelationship(Relations.ENTITY_VISITORS, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoVisitor);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoEntity_ENTITY_VISITORS_Relation_for_NeoVisitor(Node neoVisitor) {
		return neoVisitor.getSingleRelationship(Relations.ENTITY_VISITORS, Direction.INCOMING);
	}


	// MANY 'NeoEntity' -> ENTITY_RELATION -> MANY 'NeoRelation'

	public static Relationship relate_NeoEntity_ENTITY_RELATION_NeoRelation(Node neoEntity, Node neoRelation) {
		final Relationship relation = relate(neoEntity, neoRelation, Relations.ENTITY_RELATION);
		return relation;
	}

	// many-to-many
	public static void get_NeoRelation_ENTITY_RELATION_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_RELATION);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoEntity);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static void get_NeoEntity_ENTITY_RELATION_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.INCOMING, Relations.ENTITY_RELATION);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoRelation);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}


	// ONE 'NeoRelation' -> RELATION_PROPERTIES -> MANY 'NeoProperty'

	public static Relationship relate_NeoRelation_RELATION_PROPERTIES_NeoProperty(Node neoRelation, Node neoProperty) {
		final Relationship relation = relate(neoRelation, neoProperty, Relations.RELATION_PROPERTIES);
		return relation;
	}

	// one-to-many
	public static void get_NeoProperty_RELATION_PROPERTIES_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.OUTGOING, Relations.RELATION_PROPERTIES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoRelation);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoRelation_RELATION_PROPERTIES_for_NeoProperty(Node neoProperty) {
		final Relationship relationship = neoProperty.getSingleRelationship(Relations.RELATION_PROPERTIES, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoProperty);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoRelation_RELATION_PROPERTIES_Relation_for_NeoProperty(Node neoProperty) {
		return neoProperty.getSingleRelationship(Relations.RELATION_PROPERTIES, Direction.INCOMING);
	}


	// ONE 'NeoEntity' -> ENTITY_PROPERTIES -> MANY 'NeoProperty'

	public static Relationship relate_NeoEntity_ENTITY_PROPERTIES_NeoProperty(Node neoEntity, Node neoProperty) {
		final Relationship relation = relate(neoEntity, neoProperty, Relations.ENTITY_PROPERTIES);
		return relation;
	}

	// one-to-many
	public static void get_NeoProperty_ENTITY_PROPERTIES_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.OUTGOING, Relations.ENTITY_PROPERTIES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoEntity);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoEntity_ENTITY_PROPERTIES_for_NeoProperty(Node neoProperty) {
		final Relationship relationship = neoProperty.getSingleRelationship(Relations.ENTITY_PROPERTIES, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoProperty);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoEntity_ENTITY_PROPERTIES_Relation_for_NeoProperty(Node neoProperty) {
		return neoProperty.getSingleRelationship(Relations.ENTITY_PROPERTIES, Direction.INCOMING);
	}


	// MANY 'NeoRelation' -> RELATION_ENTITY -> MANY 'NeoEntity'

	public static Relationship relate_NeoRelation_RELATION_ENTITY_NeoEntity(Node neoRelation, Node neoEntity) {
		final Relationship relation = relate(neoRelation, neoEntity, Relations.RELATION_ENTITY);
		return relation;
	}

	// many-to-many
	public static void get_NeoEntity_RELATION_ENTITY_for_NeoRelation(Node neoRelation, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoRelation.getRelationships(Direction.OUTGOING, Relations.RELATION_ENTITY);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoRelation);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static void get_NeoRelation_RELATION_ENTITY_for_NeoEntity(Node neoEntity, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoEntity.getRelationships(Direction.INCOMING, Relations.RELATION_ENTITY);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoEntity);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}


	// ONE 'NeoDomain' -> ENTITIES -> MANY 'NeoEntity'

	public static Relationship relate_NeoDomain_ENTITIES_NeoEntity(Node neoDomain, Node neoEntity) {
		final Relationship relation = relate(neoDomain, neoEntity, Relations.ENTITIES);
		return relation;
	}

	// one-to-many
	public static void get_NeoEntity_ENTITIES_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.ENTITIES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoDomain);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoDomain_ENTITIES_for_NeoEntity(Node neoEntity) {
		final Relationship relationship = neoEntity.getSingleRelationship(Relations.ENTITIES, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoEntity);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_NeoDomain_ENTITIES_Relation_for_NeoEntity(Node neoEntity) {
		return neoEntity.getSingleRelationship(Relations.ENTITIES, Direction.INCOMING);
	}


	// ONE 'NeoDomain' -> RENDERER -> MANY 'NeoDomainRenderer'

	public static Relationship relate_NeoDomain_RENDERER_NeoDomainRenderer(Node neoDomain, Node neoDomainRenderer) {
		final Relationship relation = relate(neoDomain, neoDomainRenderer, Relations.RENDERER);
		return relation;
	}

	// one-to-many
	public static void get_NeoDomainRenderer_RENDERER_for_NeoDomain(Node neoDomain, RelationConsumer consumer) {
		final Iterable<Relationship> relations = neoDomain.getRelationships(Direction.OUTGOING, Relations.RENDERER);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(neoDomain);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_NeoDomain_RENDERER_for_NeoDomainRenderer(Node neoDomainRenderer) {
		final Relationship relationship = neoDomainRenderer.getSingleRelationship(Relations.RENDERER, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(neoDomainRenderer);
		return node == null || isDeleted(node) ? null : node;
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


	public static String getDefaultColor(PropertyContainer container) {
		return getDefaultColor(container, null);
	}

	public static String getDefaultColor(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.defaultColor.name()) ? defaultValue : (String) container.getProperty(Properties.defaultColor.name());
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
		return container == null || !container.hasProperty(Properties.enumValues.name()) ? defaultValue : (String) container.getProperty(Properties.enumValues.name());
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
		return container == null || !container.hasProperty(Properties.highlightedColor.name()) ? defaultValue : (String) container.getProperty(Properties.highlightedColor.name());
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


	public static String getLabel(PropertyContainer container) {
		return getLabel(container, null);
	}

	public static String getLabel(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.label.name()) ? defaultValue : (String) container.getProperty(Properties.label.name());
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
		return container == null || !container.hasProperty(Properties.name.name()) ? defaultValue : (String) container.getProperty(Properties.name.name());
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
		return container == null || !container.hasProperty(Properties.packageName.name()) ? defaultValue : (String) container.getProperty(Properties.packageName.name());
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


	public static String getRoot(PropertyContainer container) {
		return getRoot(container, null);
	}

	public static String getRoot(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.root.name()) ? defaultValue : (String) container.getProperty(Properties.root.name());
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
		return container == null || !container.hasProperty(Properties.selectedColor.name()) ? defaultValue : (String) container.getProperty(Properties.selectedColor.name());
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
		return container == null || !container.hasProperty(Properties.type.name()) ? defaultValue : (String) container.getProperty(Properties.type.name());
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


	// SUPPORT METHODS ----------------------------------------------------------------------

	public interface NodeConsumer {
		boolean handle(Node node);
	}

	public interface RelationConsumer {
		boolean handle(Relationship relationship, Node other);
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

	private static Iterable<?> outgoing(Node node, RelationshipType type) {
		return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);
	}

	private static Node other(Node node, Relationship relationship) {
		return relationship == null ? null : relationship.getOtherNode(node);
	}

	// DOMAIN METHODS -----------------------------------------------------------------------

	public static UUID getUUID(PropertyContainer container) {
		return container.hasProperty(Properties._uuid.name()) ? UUID.fromString(container.getProperty(Properties._uuid.name()).toString()) : null;
	}

	public static void deleteNode(Node node) {
		node.setProperty(Properties._deleted.name(), true);
		node.setProperty(Properties._timestamp.name(), System.currentTimeMillis());
	}

	private static boolean isDeleted(Node node) {
		return node==null ? true : (Boolean) node.getProperty(Properties._deleted.name(), false);
	}

	public static void newVersion(Node oldNode, Node newNode) {
		final Relationship versionRelation = newNode.createRelationshipTo(oldNode, Relations._VERSION);
		versionRelation.setProperty(Properties._timestamp.name(), System.currentTimeMillis());
	}

	public static void getAllVersionsOf(Node node, NodeConsumer consumer) {
		final Relationship versionRelation = node.getSingleRelationship(Relations._VERSION, Direction.OUTGOING);
		if (versionRelation == null) return;

		final Node oldVersion = versionRelation.getOtherNode(node);
		consumer.handle(oldVersion);

		getAllVersionsOf(oldVersion, consumer);
	}
}