package com.nextgen.core;

import org.neo4j.graphdb.*;

import java.util.UUID;

public class _Layout {

	public enum Entities implements Label {
		_LayoutRelation, _Layout
	}

	public enum Relations implements RelationshipType {
		_VERSION, _RELATIONS, _NODES
	}

	public enum Properties {
		_uuid, _deleted, _timestamp, _src, _highlightedColor, _label, _dst, _defaultColor, _selectedColor, _content, _relationUUID, _y, _x, name
	}


	// ENTITIES -----------------------------------------------------------------------------

	// _LayoutRelation
	public static Node new_LayoutRelation(GraphDatabaseService db, String _relationUUID, Object _content, String _highlightedColor, String _selectedColor, String _defaultColor, String _dst, String _src, String _label) {
		return new_LayoutRelation(db, UUID.randomUUID(), _relationUUID, _content, _highlightedColor, _selectedColor, _defaultColor, _dst, _src, _label);
	}

	public static Node new_LayoutRelation(GraphDatabaseService db, UUID uuid, String _relationUUID, Object _content, String _highlightedColor, String _selectedColor, String _defaultColor, String _dst, String _src, String _label) {
		final Node node = db.createNode(Entities._LayoutRelation);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (_relationUUID != null) node.setProperty(Properties._relationUUID.name(), _relationUUID);
		if (_content != null) node.setProperty(Properties._content.name(), _content);
		if (_highlightedColor != null) node.setProperty(Properties._highlightedColor.name(), _highlightedColor);
		if (_selectedColor != null) node.setProperty(Properties._selectedColor.name(), _selectedColor);
		if (_defaultColor != null) node.setProperty(Properties._defaultColor.name(), _defaultColor);
		if (_dst != null) node.setProperty(Properties._dst.name(), _dst);
		if (_src != null) node.setProperty(Properties._src.name(), _src);
		if (_label != null) node.setProperty(Properties._label.name(), _label);

		return node;
	}

	public static void create_LayoutRelationIndexOn_relationUUID(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_relationUUID)");
	}

	public static void create_LayoutRelationIndexOn_content(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_content)");
	}

	public static void create_LayoutRelationIndexOn_highlightedColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_highlightedColor)");
	}

	public static void create_LayoutRelationIndexOn_selectedColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_selectedColor)");
	}

	public static void create_LayoutRelationIndexOn_defaultColor(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_defaultColor)");
	}

	public static void create_LayoutRelationIndexOn_dst(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_dst)");
	}

	public static void create_LayoutRelationIndexOn_src(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_src)");
	}

	public static void create_LayoutRelationIndexOn_label(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _LayoutRelation (_label)");
	}

	public static void findAll_LayoutRelation(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities._LayoutRelation);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node find_LayoutRelationBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities._LayoutRelation, Properties._uuid.name(), uuid.toString());
	}

	public static Node find_LayoutRelationBy_relationUUID(GraphDatabaseService db, String _relationUUID) {
		return db.findNode(Entities._LayoutRelation, Properties._relationUUID.name(), _relationUUID);
	}

	public static Node find_LayoutRelationBy_content(GraphDatabaseService db, Object _content) {
		return db.findNode(Entities._LayoutRelation, Properties._content.name(), _content);
	}

	public static Node find_LayoutRelationBy_highlightedColor(GraphDatabaseService db, String _highlightedColor) {
		return db.findNode(Entities._LayoutRelation, Properties._highlightedColor.name(), _highlightedColor);
	}

	public static Node find_LayoutRelationBy_selectedColor(GraphDatabaseService db, String _selectedColor) {
		return db.findNode(Entities._LayoutRelation, Properties._selectedColor.name(), _selectedColor);
	}

	public static Node find_LayoutRelationBy_defaultColor(GraphDatabaseService db, String _defaultColor) {
		return db.findNode(Entities._LayoutRelation, Properties._defaultColor.name(), _defaultColor);
	}

	public static Node find_LayoutRelationBy_dst(GraphDatabaseService db, String _dst) {
		return db.findNode(Entities._LayoutRelation, Properties._dst.name(), _dst);
	}

	public static Node find_LayoutRelationBy_src(GraphDatabaseService db, String _src) {
		return db.findNode(Entities._LayoutRelation, Properties._src.name(), _src);
	}

	public static Node find_LayoutRelationBy_label(GraphDatabaseService db, String _label) {
		return db.findNode(Entities._LayoutRelation, Properties._label.name(), _label);
	} 

	// _Layout
	public static Node new_Layout(GraphDatabaseService db, String name) {
		return new_Layout(db, UUID.randomUUID(), name);
	}

	public static Node new_Layout(GraphDatabaseService db, UUID uuid, String name) {
		final Node node = db.createNode(Entities._Layout);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void create_LayoutIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : _Layout (name)");
	}

	public static void findAll_Layout(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities._Layout);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node find_LayoutBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities._Layout, Properties._uuid.name(), uuid.toString());
	}

	public static Node find_LayoutByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities._Layout, Properties.name.name(), name);
	} 


	// RELATIONS ----------------------------------------------------------------------------

	// ONE 'Layout' -> _RELATIONS -> MANY 'LayoutRelation'

	public static Relationship relate_Layout__RELATIONS_LayoutRelation(Node layout, Node layoutRelation) {
		final Relationship relation = relate(layout, layoutRelation, Relations._RELATIONS);
		return relation;
	}

	// one-to-many
	public static void get_LayoutRelation__RELATIONS_for_Layout(Node layout, RelationConsumer consumer) {
		final Iterable<Relationship> relations = layout.getRelationships(Direction.OUTGOING, Relations._RELATIONS);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(layout);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_Layout__RELATIONS_for_LayoutRelation(Node layoutRelation) {
		final Relationship relationship = layoutRelation.getSingleRelationship(Relations._RELATIONS, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(layoutRelation);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_Layout__RELATIONS_Relation_for_LayoutRelation(Node layoutRelation) {
		return layoutRelation.getSingleRelationship(Relations._RELATIONS, Direction.INCOMING);
	}
	 

	// MANY 'Layout' -> _NODES -> MANY 'NodePNode'

	public static Relationship relate_Layout__NODES_NodePNode(Node layout, Node nodePNode, Double _y, Double _x) {
		final Relationship relation = relate(layout, nodePNode, Relations._NODES);
		relation.setProperty(Properties._y.name(), _y);
		relation.setProperty(Properties._x.name(), _x);
		return relation;
	}

	// many-to-many
	public static void get_NodePNode__NODES_for_Layout(Node layout, RelationConsumer consumer) {
		final Iterable<Relationship> relations = layout.getRelationships(Direction.OUTGOING, Relations._NODES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(layout);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static void get_Layout__NODES_for_NodePNode(Node nodePNode, RelationConsumer consumer) {
		final Iterable<Relationship> relations = nodePNode.getRelationships(Direction.INCOMING, Relations._NODES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(nodePNode);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}
	 


	// PROPERTIES ---------------------------------------------------------------------------

	public static String get_src(PropertyContainer container) {
		return get_src(container, null);
	}

	public static String get_src(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._src.name()) ? defaultValue : (String) container.getProperty(Properties._src.name());
	}

	public static void set_src(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_src(container);
			return;
		}

		container.setProperty(Properties._src.name(), value);
	}

	public static void delete_src(PropertyContainer container) {
		if (container.hasProperty(Properties._src.name())) container.removeProperty(Properties._src.name());
	}


	public static String get_highlightedColor(PropertyContainer container) {
		return get_highlightedColor(container, null);
	}

	public static String get_highlightedColor(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._highlightedColor.name()) ? defaultValue : (String) container.getProperty(Properties._highlightedColor.name());
	}

	public static void set_highlightedColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_highlightedColor(container);
			return;
		}

		container.setProperty(Properties._highlightedColor.name(), value);
	}

	public static void delete_highlightedColor(PropertyContainer container) {
		if (container.hasProperty(Properties._highlightedColor.name())) container.removeProperty(Properties._highlightedColor.name());
	}


	public static String get_label(PropertyContainer container) {
		return get_label(container, null);
	}

	public static String get_label(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._label.name()) ? defaultValue : (String) container.getProperty(Properties._label.name());
	}

	public static void set_label(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_label(container);
			return;
		}

		container.setProperty(Properties._label.name(), value);
	}

	public static void delete_label(PropertyContainer container) {
		if (container.hasProperty(Properties._label.name())) container.removeProperty(Properties._label.name());
	}


	public static String get_dst(PropertyContainer container) {
		return get_dst(container, null);
	}

	public static String get_dst(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._dst.name()) ? defaultValue : (String) container.getProperty(Properties._dst.name());
	}

	public static void set_dst(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_dst(container);
			return;
		}

		container.setProperty(Properties._dst.name(), value);
	}

	public static void delete_dst(PropertyContainer container) {
		if (container.hasProperty(Properties._dst.name())) container.removeProperty(Properties._dst.name());
	}


	public static String get_defaultColor(PropertyContainer container) {
		return get_defaultColor(container, null);
	}

	public static String get_defaultColor(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._defaultColor.name()) ? defaultValue : (String) container.getProperty(Properties._defaultColor.name());
	}

	public static void set_defaultColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_defaultColor(container);
			return;
		}

		container.setProperty(Properties._defaultColor.name(), value);
	}

	public static void delete_defaultColor(PropertyContainer container) {
		if (container.hasProperty(Properties._defaultColor.name())) container.removeProperty(Properties._defaultColor.name());
	}


	public static String get_selectedColor(PropertyContainer container) {
		return get_selectedColor(container, null);
	}

	public static String get_selectedColor(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._selectedColor.name()) ? defaultValue : (String) container.getProperty(Properties._selectedColor.name());
	}

	public static void set_selectedColor(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_selectedColor(container);
			return;
		}

		container.setProperty(Properties._selectedColor.name(), value);
	}

	public static void delete_selectedColor(PropertyContainer container) {
		if (container.hasProperty(Properties._selectedColor.name())) container.removeProperty(Properties._selectedColor.name());
	}


	public static Object get_content(PropertyContainer container) {
		return get_content(container, null);
	}

	public static Object get_content(PropertyContainer container, Object defaultValue) {
		return container == null || !container.hasProperty(Properties._content.name()) ? defaultValue : (Object) container.getProperty(Properties._content.name());
	}

	public static void set_content(PropertyContainer container, Object value) {
		if (container == null) return;

		if (value == null) {
			delete_content(container);
			return;
		}

		container.setProperty(Properties._content.name(), value);
	}

	public static void delete_content(PropertyContainer container) {
		if (container.hasProperty(Properties._content.name())) container.removeProperty(Properties._content.name());
	}


	public static String get_relationUUID(PropertyContainer container) {
		return get_relationUUID(container, null);
	}

	public static String get_relationUUID(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties._relationUUID.name()) ? defaultValue : (String) container.getProperty(Properties._relationUUID.name());
	}

	public static void set_relationUUID(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			delete_relationUUID(container);
			return;
		}

		container.setProperty(Properties._relationUUID.name(), value);
	}

	public static void delete_relationUUID(PropertyContainer container) {
		if (container.hasProperty(Properties._relationUUID.name())) container.removeProperty(Properties._relationUUID.name());
	}


	public static Double get_y(PropertyContainer container) {
		return get_y(container, null);
	}

	public static Double get_y(PropertyContainer container, Double defaultValue) {
		return container == null || !container.hasProperty(Properties._y.name()) ? defaultValue : (Double) container.getProperty(Properties._y.name());
	}

	public static void set_y(PropertyContainer container, Double value) {
		if (container == null) return;

		if (value == null) {
			delete_y(container);
			return;
		}

		container.setProperty(Properties._y.name(), value);
	}

	public static void delete_y(PropertyContainer container) {
		if (container.hasProperty(Properties._y.name())) container.removeProperty(Properties._y.name());
	}


	public static Double get_x(PropertyContainer container) {
		return get_x(container, null);
	}

	public static Double get_x(PropertyContainer container, Double defaultValue) {
		return container == null || !container.hasProperty(Properties._x.name()) ? defaultValue : (Double) container.getProperty(Properties._x.name());
	}

	public static void set_x(PropertyContainer container, Double value) {
		if (container == null) return;

		if (value == null) {
			delete_x(container);
			return;
		}

		container.setProperty(Properties._x.name(), value);
	}

	public static void delete_x(PropertyContainer container) {
		if (container.hasProperty(Properties._x.name())) container.removeProperty(Properties._x.name());
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