package com.nextgen.core.template;

import org.neo4j.graphdb.*;
import java.util.UUID;

public class Template {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Template.class);

	public enum Entities implements Label {
		STGroup, STTemplate, STTemplateParameter, STKeyValue, Value, STInstance, Renderer, GroupRenderer
	}

	public enum Relations implements RelationshipType {
		_VERSION, TEMPLATE, CHILD_TEMPLATE, PARAMETER, KEY_VALUE, KEY_REFERENCE, PARAMETER_REFERENCE, KV_VALUES, INSTANCE_REFERENCE, VALUES, RENDERER, INSTANCE, GROUP_RENDERER
	}

	public enum Properties {
		_uuid, _deleted, _timestamp, parameterType, renderType, delimiter, name, packageName, path, root, text, value
	}

	public enum ParameterType {
		KEYVALUELISTPROPERTY, LISTPROPERTY, STRINGPROPERTY
	}

	public enum RenderType {
		JAVA_FILE, PLAIN_FILE
	}


	// ENTITIES -----------------------------------------------------------------------------

	// STGroup
	public static Node newSTGroup(GraphDatabaseService db, String delimiter, String name) {
		return newSTGroup(db, UUID.randomUUID(), delimiter, name);
	}

	public static Node newSTGroup(GraphDatabaseService db, UUID uuid, String delimiter, String name) {
		final Node node = db.createNode(Entities.STGroup);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (delimiter != null) node.setProperty(Properties.delimiter.name(), delimiter);
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void createSTGroupIndexOnDelimiter(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STGroup (delimiter)");
	}

	public static void createSTGroupIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STGroup (name)");
	}

	public static void findAllSTGroup(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.STGroup);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findSTGroupBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.STGroup, Properties._uuid.name(), uuid.toString());
	}

	public static Node findSTGroupByDelimiter(GraphDatabaseService db, String delimiter) {
		return db.findNode(Entities.STGroup, Properties.delimiter.name(), delimiter);
	}

	public static Node findSTGroupByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.STGroup, Properties.name.name(), name);
	}

	// STTemplate
	public static Node newSTTemplate(GraphDatabaseService db, String text, String name) {
		return newSTTemplate(db, UUID.randomUUID(), text, name);
	}

	public static Node newSTTemplate(GraphDatabaseService db, UUID uuid, String text, String name) {
		final Node node = db.createNode(Entities.STTemplate);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (text != null) node.setProperty(Properties.text.name(), text);
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void createSTTemplateIndexOnText(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STTemplate (text)");
	}

	public static void createSTTemplateIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STTemplate (name)");
	}

	public static void findAllSTTemplate(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.STTemplate);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findSTTemplateBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.STTemplate, Properties._uuid.name(), uuid.toString());
	}

	public static Node findSTTemplateByText(GraphDatabaseService db, String text) {
		return db.findNode(Entities.STTemplate, Properties.text.name(), text);
	}

	public static Node findSTTemplateByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.STTemplate, Properties.name.name(), name);
	}

	// STTemplateParameter
	public static Node newSTTemplateParameter(GraphDatabaseService db, ParameterType parameterType, String name) {
		return newSTTemplateParameter(db, UUID.randomUUID(), parameterType, name);
	}

	public static Node newSTTemplateParameter(GraphDatabaseService db, UUID uuid, ParameterType parameterType, String name) {
		final Node node = db.createNode(Entities.STTemplateParameter);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (parameterType != null) node.setProperty(Properties.parameterType.name(), parameterType.name());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void createSTTemplateParameterIndexOnParameterType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STTemplateParameter (parameterType)");
	}

	public static void createSTTemplateParameterIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STTemplateParameter (name)");
	}

	public static void findAllSTTemplateParameter(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.STTemplateParameter);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findSTTemplateParameterBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.STTemplateParameter, Properties._uuid.name(), uuid.toString());
	}

	public static Node findSTTemplateParameterByParameterType(GraphDatabaseService db, ParameterType parameterType) {
		return db.findNode(Entities.STTemplateParameter, Properties.parameterType.name(), parameterType.name());
	}

	public static Node findSTTemplateParameterByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.STTemplateParameter, Properties.name.name(), name);
	}

	// STKeyValue
	public static Node newSTKeyValue(GraphDatabaseService db, String name) {
		return newSTKeyValue(db, UUID.randomUUID(), name);
	}

	public static Node newSTKeyValue(GraphDatabaseService db, UUID uuid, String name) {
		final Node node = db.createNode(Entities.STKeyValue);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void createSTKeyValueIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STKeyValue (name)");
	}

	public static void findAllSTKeyValue(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.STKeyValue);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findSTKeyValueBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.STKeyValue, Properties._uuid.name(), uuid.toString());
	}

	public static Node findSTKeyValueByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.STKeyValue, Properties.name.name(), name);
	}

	// Value
	public static Node newValue(GraphDatabaseService db, String value) {
		return newValue(db, UUID.randomUUID(), value);
	}

	public static Node newValue(GraphDatabaseService db, UUID uuid, String value) {
		final Node node = db.createNode(Entities.Value);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (value != null) node.setProperty(Properties.value.name(), value);

		return node;
	}

	public static void createValueIndexOnValue(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Value (value)");
	}

	public static void findAllValue(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Value);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findValueBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.Value, Properties._uuid.name(), uuid.toString());
	}

	public static Node findValueByValue(GraphDatabaseService db, String value) {
		return db.findNode(Entities.Value, Properties.value.name(), value);
	}

	// STInstance
	public static Node newSTInstance(GraphDatabaseService db, String name) {
		return newSTInstance(db, UUID.randomUUID(), name);
	}

	public static Node newSTInstance(GraphDatabaseService db, UUID uuid, String name) {
		final Node node = db.createNode(Entities.STInstance);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (name != null) node.setProperty(Properties.name.name(), name);

		return node;
	}

	public static void createSTInstanceIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : STInstance (name)");
	}

	public static void findAllSTInstance(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.STInstance);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findSTInstanceBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.STInstance, Properties._uuid.name(), uuid.toString());
	}

	public static Node findSTInstanceByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.STInstance, Properties.name.name(), name);
	}

	// Renderer
	public static Node newRenderer(GraphDatabaseService db, RenderType renderType, String path) {
		return newRenderer(db, UUID.randomUUID(), renderType, path);
	}

	public static Node newRenderer(GraphDatabaseService db, UUID uuid, RenderType renderType, String path) {
		final Node node = db.createNode(Entities.Renderer);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (renderType != null) node.setProperty(Properties.renderType.name(), renderType.name());
		if (path != null) node.setProperty(Properties.path.name(), path);

		return node;
	}

	public static void createRendererIndexOnRenderType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Renderer (renderType)");
	}

	public static void createRendererIndexOnPath(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Renderer (path)");
	}

	public static void findAllRenderer(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Renderer);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findRendererBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.Renderer, Properties._uuid.name(), uuid.toString());
	}

	public static Node findRendererByRenderType(GraphDatabaseService db, RenderType renderType) {
		return db.findNode(Entities.Renderer, Properties.renderType.name(), renderType.name());
	}

	public static Node findRendererByPath(GraphDatabaseService db, String path) {
		return db.findNode(Entities.Renderer, Properties.path.name(), path);
	}

	// GroupRenderer
	public static Node newGroupRenderer(GraphDatabaseService db, String packageName, String root) {
		return newGroupRenderer(db, UUID.randomUUID(), packageName, root);
	}

	public static Node newGroupRenderer(GraphDatabaseService db, UUID uuid, String packageName, String root) {
		final Node node = db.createNode(Entities.GroupRenderer);
		node.setProperty(Properties._uuid.name(), uuid.toString());
		if (packageName != null) node.setProperty(Properties.packageName.name(), packageName);
		if (root != null) node.setProperty(Properties.root.name(), root);

		return node;
	}

	public static void createGroupRendererIndexOnPackageName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : GroupRenderer (packageName)");
	}

	public static void createGroupRendererIndexOnRoot(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : GroupRenderer (root)");
	}

	public static void findAllGroupRenderer(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.GroupRenderer);
		while (nodes.hasNext()) {
			if (consumer.handle(nodes.next())) {
				nodes.close();
				return;
			}
		}
		nodes.close();
	}

	public static Node findGroupRendererBy_UUID(GraphDatabaseService db, UUID uuid) {
		return db.findNode(Entities.GroupRenderer, Properties._uuid.name(), uuid.toString());
	}

	public static Node findGroupRendererByPackageName(GraphDatabaseService db, String packageName) {
		return db.findNode(Entities.GroupRenderer, Properties.packageName.name(), packageName);
	}

	public static Node findGroupRendererByRoot(GraphDatabaseService db, String root) {
		return db.findNode(Entities.GroupRenderer, Properties.root.name(), root);
	}


	// RELATIONS ----------------------------------------------------------------------------

	// ONE 'STGroup' -> TEMPLATE -> MANY 'STTemplate'

	public static Relationship relate_STGroup_TEMPLATE_STTemplate(Node sTGroup, Node sTTemplate) {
		final Relationship relation = relate(sTGroup, sTTemplate, Relations.TEMPLATE);
		return relation;
	}

	// one-to-many
	public static void get_STTemplate_TEMPLATE_for_STGroup(Node sTGroup, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTGroup.getRelationships(Direction.OUTGOING, Relations.TEMPLATE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTGroup);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STGroup_TEMPLATE_for_STTemplate(Node sTTemplate) {
		final Relationship relationship = sTTemplate.getSingleRelationship(Relations.TEMPLATE, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(sTTemplate);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STGroup_TEMPLATE_Relation_for_STTemplate(Node sTTemplate) {
		return sTTemplate.getSingleRelationship(Relations.TEMPLATE, Direction.INCOMING);
	}


	// ONE 'srcSTTemplate' -> CHILD_TEMPLATE -> MANY 'STTemplate'

	public static Relationship relate_SrcSTTemplate_CHILD_TEMPLATE_STTemplate(Node srcSTTemplate, Node sTTemplate) {
		final Relationship relation = relate(srcSTTemplate, sTTemplate, Relations.CHILD_TEMPLATE);
		return relation;
	}

	// one-to-many
	public static void get_STTemplate_CHILD_TEMPLATE_for_SrcSTTemplate(Node srcSTTemplate, RelationConsumer consumer) {
		final Iterable<Relationship> relations = srcSTTemplate.getRelationships(Direction.OUTGOING, Relations.CHILD_TEMPLATE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(srcSTTemplate);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_SrcSTTemplate_CHILD_TEMPLATE_for_STTemplate(Node sTTemplate) {
		final Relationship relationship = sTTemplate.getSingleRelationship(Relations.CHILD_TEMPLATE, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(sTTemplate);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_SrcSTTemplate_CHILD_TEMPLATE_Relation_for_STTemplate(Node sTTemplate) {
		return sTTemplate.getSingleRelationship(Relations.CHILD_TEMPLATE, Direction.INCOMING);
	}


	// ONE 'STTemplate' -> PARAMETER -> MANY 'STTemplateParameter'

	public static Relationship relate_STTemplate_PARAMETER_STTemplateParameter(Node sTTemplate, Node sTTemplateParameter) {
		final Relationship relation = relate(sTTemplate, sTTemplateParameter, Relations.PARAMETER);
		return relation;
	}

	// one-to-many
	public static void get_STTemplateParameter_PARAMETER_for_STTemplate(Node sTTemplate, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTTemplate.getRelationships(Direction.OUTGOING, Relations.PARAMETER);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTTemplate);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STTemplate_PARAMETER_for_STTemplateParameter(Node sTTemplateParameter) {
		final Relationship relationship = sTTemplateParameter.getSingleRelationship(Relations.PARAMETER, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(sTTemplateParameter);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STTemplate_PARAMETER_Relation_for_STTemplateParameter(Node sTTemplateParameter) {
		return sTTemplateParameter.getSingleRelationship(Relations.PARAMETER, Direction.INCOMING);
	}


	// ONE 'STTemplateParameter' -> KEY_VALUE -> MANY 'STKeyValue'

	public static Relationship relate_STTemplateParameter_KEY_VALUE_STKeyValue(Node sTTemplateParameter, Node sTKeyValue) {
		final Relationship relation = relate(sTTemplateParameter, sTKeyValue, Relations.KEY_VALUE);
		return relation;
	}

	// one-to-many
	public static void get_STKeyValue_KEY_VALUE_for_STTemplateParameter(Node sTTemplateParameter, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTTemplateParameter.getRelationships(Direction.OUTGOING, Relations.KEY_VALUE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTTemplateParameter);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STTemplateParameter_KEY_VALUE_for_STKeyValue(Node sTKeyValue) {
		final Relationship relationship = sTKeyValue.getSingleRelationship(Relations.KEY_VALUE, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(sTKeyValue);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STTemplateParameter_KEY_VALUE_Relation_for_STKeyValue(Node sTKeyValue) {
		return sTKeyValue.getSingleRelationship(Relations.KEY_VALUE, Direction.INCOMING);
	}


	// MANY 'Value' -> KEY_REFERENCE -> ONE 'STKeyValue'

	public static Relationship relate_Value_KEY_REFERENCE_STKeyValue(Node value, Node sTKeyValue) {
		final Relationship relation = relate(value, sTKeyValue, Relations.KEY_REFERENCE);
		return relation;
	}

	// many-to-one
	public static void get_Value_KEY_REFERENCE_for_STKeyValue(Node sTKeyValue, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTKeyValue.getRelationships(Direction.INCOMING, Relations.KEY_REFERENCE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTKeyValue);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STKeyValue_KEY_REFERENCE_for_Value(Node value) {
		final Relationship relationship = value.getSingleRelationship(Relations.KEY_REFERENCE, Direction.OUTGOING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(value);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STKeyValue_KEY_REFERENCE_Relation_for_Value(Node value) {
		return value.getSingleRelationship(Relations.KEY_REFERENCE, Direction.OUTGOING);
	}


	// MANY 'Value' -> PARAMETER_REFERENCE -> ONE 'STTemplateParameter'

	public static Relationship relate_Value_PARAMETER_REFERENCE_STTemplateParameter(Node value, Node sTTemplateParameter) {
		final Relationship relation = relate(value, sTTemplateParameter, Relations.PARAMETER_REFERENCE);
		return relation;
	}

	// many-to-one
	public static void get_Value_PARAMETER_REFERENCE_for_STTemplateParameter(Node sTTemplateParameter, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTTemplateParameter.getRelationships(Direction.INCOMING, Relations.PARAMETER_REFERENCE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTTemplateParameter);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STTemplateParameter_PARAMETER_REFERENCE_for_Value(Node value) {
		final Relationship relationship = value.getSingleRelationship(Relations.PARAMETER_REFERENCE, Direction.OUTGOING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(value);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STTemplateParameter_PARAMETER_REFERENCE_Relation_for_Value(Node value) {
		return value.getSingleRelationship(Relations.PARAMETER_REFERENCE, Direction.OUTGOING);
	}


	// ONE 'srcValue' -> KV_VALUES -> MANY 'Value'

	public static Relationship relate_SrcValue_KV_VALUES_Value(Node srcValue, Node value) {
		final Relationship relation = relate(srcValue, value, Relations.KV_VALUES);
		return relation;
	}

	// one-to-many
	public static void get_Value_KV_VALUES_for_SrcValue(Node srcValue, RelationConsumer consumer) {
		final Iterable<Relationship> relations = srcValue.getRelationships(Direction.OUTGOING, Relations.KV_VALUES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(srcValue);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_SrcValue_KV_VALUES_for_Value(Node value) {
		final Relationship relationship = value.getSingleRelationship(Relations.KV_VALUES, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(value);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_SrcValue_KV_VALUES_Relation_for_Value(Node value) {
		return value.getSingleRelationship(Relations.KV_VALUES, Direction.INCOMING);
	}


	// MANY 'Value' -> INSTANCE_REFERENCE -> ONE 'STInstance'

	public static Relationship relate_Value_INSTANCE_REFERENCE_STInstance(Node value, Node sTInstance) {
		final Relationship relation = relate(value, sTInstance, Relations.INSTANCE_REFERENCE);
		return relation;
	}

	// many-to-one
	public static void get_Value_INSTANCE_REFERENCE_for_STInstance(Node sTInstance, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTInstance.getRelationships(Direction.INCOMING, Relations.INSTANCE_REFERENCE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTInstance);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STInstance_INSTANCE_REFERENCE_for_Value(Node value) {
		final Relationship relationship = value.getSingleRelationship(Relations.INSTANCE_REFERENCE, Direction.OUTGOING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(value);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STInstance_INSTANCE_REFERENCE_Relation_for_Value(Node value) {
		return value.getSingleRelationship(Relations.INSTANCE_REFERENCE, Direction.OUTGOING);
	}


	// ONE 'STInstance' -> VALUES -> MANY 'Value'

	public static Relationship relate_STInstance_VALUES_Value(Node sTInstance, Node value) {
		final Relationship relation = relate(sTInstance, value, Relations.VALUES);
		return relation;
	}

	// one-to-many
	public static void get_Value_VALUES_for_STInstance(Node sTInstance, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTInstance.getRelationships(Direction.OUTGOING, Relations.VALUES);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTInstance);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STInstance_VALUES_for_Value(Node value) {
		final Relationship relationship = value.getSingleRelationship(Relations.VALUES, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(value);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STInstance_VALUES_Relation_for_Value(Node value) {
		return value.getSingleRelationship(Relations.VALUES, Direction.INCOMING);
	}


	// ONE 'STInstance' -> RENDERER -> MANY 'Renderer'

	public static Relationship relate_STInstance_RENDERER_Renderer(Node sTInstance, Node renderer) {
		final Relationship relation = relate(sTInstance, renderer, Relations.RENDERER);
		return relation;
	}

	// one-to-many
	public static void get_Renderer_RENDERER_for_STInstance(Node sTInstance, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTInstance.getRelationships(Direction.OUTGOING, Relations.RENDERER);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTInstance);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STInstance_RENDERER_for_Renderer(Node renderer) {
		final Relationship relationship = renderer.getSingleRelationship(Relations.RENDERER, Direction.INCOMING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(renderer);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STInstance_RENDERER_Relation_for_Renderer(Node renderer) {
		return renderer.getSingleRelationship(Relations.RENDERER, Direction.INCOMING);
	}


	// MANY 'STInstance' -> INSTANCE -> ONE 'STTemplate'

	public static Relationship relate_STInstance_INSTANCE_STTemplate(Node sTInstance, Node sTTemplate) {
		final Relationship relation = relate(sTInstance, sTTemplate, Relations.INSTANCE);
		return relation;
	}

	// many-to-one
	public static void get_STInstance_INSTANCE_for_STTemplate(Node sTTemplate, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTTemplate.getRelationships(Direction.INCOMING, Relations.INSTANCE);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTTemplate);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STTemplate_INSTANCE_for_STInstance(Node sTInstance) {
		final Relationship relationship = sTInstance.getSingleRelationship(Relations.INSTANCE, Direction.OUTGOING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(sTInstance);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STTemplate_INSTANCE_Relation_for_STInstance(Node sTInstance) {
		return sTInstance.getSingleRelationship(Relations.INSTANCE, Direction.OUTGOING);
	}


	// MANY 'GroupRenderer' -> GROUP_RENDERER -> ONE 'STGroup'

	public static Relationship relate_GroupRenderer_GROUP_RENDERER_STGroup(Node groupRenderer, Node sTGroup) {
		final Relationship relation = relate(groupRenderer, sTGroup, Relations.GROUP_RENDERER);
		return relation;
	}

	// many-to-one
	public static void get_GroupRenderer_GROUP_RENDERER_for_STGroup(Node sTGroup, RelationConsumer consumer) {
		final Iterable<Relationship> relations = sTGroup.getRelationships(Direction.INCOMING, Relations.GROUP_RENDERER);
		for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(sTGroup);
			if (isDeleted(other)) continue;
			if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_STGroup_GROUP_RENDERER_for_GroupRenderer(Node groupRenderer) {
		final Relationship relationship = groupRenderer.getSingleRelationship(Relations.GROUP_RENDERER, Direction.OUTGOING);
		if (relationship == null) return null;
		final Node node = relationship.getOtherNode(groupRenderer);
		return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship get_STGroup_GROUP_RENDERER_Relation_for_GroupRenderer(Node groupRenderer) {
		return groupRenderer.getSingleRelationship(Relations.GROUP_RENDERER, Direction.OUTGOING);
	}



	// PROPERTIES ---------------------------------------------------------------------------

	public static ParameterType getParameterType(PropertyContainer container) {
		return getParameterType(container, null);
	}

	public static ParameterType getParameterType(PropertyContainer container, ParameterType defaultValue) {
		return container == null || !container.hasProperty(Properties.parameterType.name()) ? defaultValue : ParameterType.valueOf(container.getProperty(Properties.parameterType.name()).toString());
	}

	public static void setParameterType(PropertyContainer container, ParameterType value) {
		if (container == null) return;

		if (value == null) {
			deleteParameterType(container);
			return;
		}

		container.setProperty(Properties.parameterType.name(), value.name());
	}

	public static void deleteParameterType(PropertyContainer container) {
		if (container.hasProperty(Properties.parameterType.name())) container.removeProperty(Properties.parameterType.name());
	}


	public static RenderType getRenderType(PropertyContainer container) {
		return getRenderType(container, null);
	}

	public static RenderType getRenderType(PropertyContainer container, RenderType defaultValue) {
		return container == null || !container.hasProperty(Properties.renderType.name()) ? defaultValue : RenderType.valueOf(container.getProperty(Properties.renderType.name()).toString());
	}

	public static void setRenderType(PropertyContainer container, RenderType value) {
		if (container == null) return;

		if (value == null) {
			deleteRenderType(container);
			return;
		}

		container.setProperty(Properties.renderType.name(), value.name());
	}

	public static void deleteRenderType(PropertyContainer container) {
		if (container.hasProperty(Properties.renderType.name())) container.removeProperty(Properties.renderType.name());
	}


	public static String getDelimiter(PropertyContainer container) {
		return getDelimiter(container, null);
	}

	public static String getDelimiter(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.delimiter.name()) ? defaultValue : (String) container.getProperty(Properties.delimiter.name());
	}

	public static void setDelimiter(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteDelimiter(container);
			return;
		}

		container.setProperty(Properties.delimiter.name(), value);
	}

	public static void deleteDelimiter(PropertyContainer container) {
		if (container.hasProperty(Properties.delimiter.name())) container.removeProperty(Properties.delimiter.name());
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


	public static String getPath(PropertyContainer container) {
		return getPath(container, null);
	}

	public static String getPath(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.path.name()) ? defaultValue : (String) container.getProperty(Properties.path.name());
	}

	public static void setPath(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deletePath(container);
			return;
		}

		container.setProperty(Properties.path.name(), value);
	}

	public static void deletePath(PropertyContainer container) {
		if (container.hasProperty(Properties.path.name())) container.removeProperty(Properties.path.name());
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


	public static String getText(PropertyContainer container) {
		return getText(container, null);
	}

	public static String getText(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.text.name()) ? defaultValue : (String) container.getProperty(Properties.text.name());
	}

	public static void setText(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteText(container);
			return;
		}

		container.setProperty(Properties.text.name(), value);
	}

	public static void deleteText(PropertyContainer container) {
		if (container.hasProperty(Properties.text.name())) container.removeProperty(Properties.text.name());
	}


	public static String getValue(PropertyContainer container) {
		return getValue(container, null);
	}

	public static String getValue(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.value.name()) ? defaultValue : (String) container.getProperty(Properties.value.name());
	}

	public static void setValue(PropertyContainer container, String value) {
		if (container == null) return;

		if (value == null) {
			deleteValue(container);
			return;
		}

		container.setProperty(Properties.value.name(), value);
	}

	public static void deleteValue(PropertyContainer container) {
		if (container.hasProperty(Properties.value.name())) container.removeProperty(Properties.value.name());
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