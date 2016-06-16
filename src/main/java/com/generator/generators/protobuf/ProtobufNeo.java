 package com.generator.generators.protobuf;

 import com.generator.editors.domain.NeoModel;
 import org.neo4j.graphdb.Node;
 import org.neo4j.graphdb.Relationship;

 import java.util.UUID;

 import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'Protobuf.stg' file <br/>	Protobuf
 */
public final class ProtobufNeo {

	private static final ProtobufGroup group = new ProtobufGroup();

	private final NeoModel model;

   public ProtobufNeo(final NeoModel model) {
 		this.model = model;
	}

    public enumNode newenum() {
   	return new enumNode(model, NeoModel.uuidOf(model.newNode("enum", UUID.randomUUID())));
   }

   public enumNode getenum(UUID uuid) {
   	return new enumNode(model, uuid);
   } 

    public extendNode newextend() {
   	return new extendNode(model, NeoModel.uuidOf(model.newNode("extend", UUID.randomUUID())));
   }

   public extendNode getextend(UUID uuid) {
   	return new extendNode(model, uuid);
   } 

    public extensionsNode newextensions() {
   	return new extensionsNode(model, NeoModel.uuidOf(model.newNode("extensions", UUID.randomUUID())));
   }

   public extensionsNode getextensions(UUID uuid) {
   	return new extensionsNode(model, uuid);
   } 

    public groupMessagesModelNode newgroupMessagesModel() {
   	return new groupMessagesModelNode(model, NeoModel.uuidOf(model.newNode("groupMessagesModel", UUID.randomUUID())));
   }

   public groupMessagesModelNode getgroupMessagesModel(UUID uuid) {
   	return new groupMessagesModelNode(model, uuid);
   } 

    public messageNode newmessage() {
   	return new messageNode(model, NeoModel.uuidOf(model.newNode("message", UUID.randomUUID())));
   }

   public messageNode getmessage(UUID uuid) {
   	return new messageNode(model, uuid);
   } 

    public messageFieldNode newmessageField() {
   	return new messageFieldNode(model, NeoModel.uuidOf(model.newNode("messageField", UUID.randomUUID())));
   }

   public messageFieldNode getmessageField(UUID uuid) {
   	return new messageFieldNode(model, uuid);
   } 

    public protobufPackageNode newprotobufPackage() {
   	return new protobufPackageNode(model, NeoModel.uuidOf(model.newNode("protobufPackage", UUID.randomUUID())));
   }

   public protobufPackageNode getprotobufPackage(UUID uuid) {
   	return new protobufPackageNode(model, uuid);
   } 

    public static final class enumNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   COMMENTS, NAME, PROPERTIES
   	}

      private enumNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.enumST fill(ProtobufGroup.enumST statement) {
   		fillComments(statement);
   		fillName(statement);
   		fillProperties(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newenum()).toString();
   	}
       // comments
      public enumNode setComments(String value) {
      	if (has(getNode(), "comments")) getNode().removeProperty("comments");
      	if (value!=null) getNode().setProperty("comments", value);
         return this;
      }

      private enumNode fillComments(ProtobufGroup.enumST statement) {
      	if (has(getNode(), "comments")) statement.setComments(get(getNode(), "comments"));
      	return this;
      } 

       // name
      public enumNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private enumNode fillName(ProtobufGroup.enumST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // properties
      public enumNode addPropertiesValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("enum_properties", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.PROPERTIES);
      	}
         return this;
      }

      private enumNode fillProperties(ProtobufGroup.enumST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.PROPERTIES))
      		statement.addPropertiesValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class extendNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   COMMENTS, NAME, PROPERTIES
   	}

      private extendNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.extendST fill(ProtobufGroup.extendST statement) {
   		fillComments(statement);
   		fillName(statement);
   		fillProperties(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newextend()).toString();
   	}
       // comments
      public extendNode setComments(String value) {
      	if (has(getNode(), "comments")) getNode().removeProperty("comments");
      	if (value!=null) getNode().setProperty("comments", value);
         return this;
      }

      private extendNode fillComments(ProtobufGroup.extendST statement) {
      	if (has(getNode(), "comments")) statement.setComments(get(getNode(), "comments"));
      	return this;
      } 

       // name
      public extendNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private extendNode fillName(ProtobufGroup.extendST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // properties
      public extendNode addPropertiesValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("extend_properties", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.PROPERTIES);
      	}
         return this;
      }

      private extendNode fillProperties(ProtobufGroup.extendST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.PROPERTIES))
      		statement.addPropertiesValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class extensionsNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   MAX, MIN
   	}

      private extensionsNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.extensionsST fill(ProtobufGroup.extensionsST statement) {
   		fillMax(statement);
   		fillMin(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newextensions()).toString();
   	}
       // max
      public extensionsNode setMax(String value) {
      	if (has(getNode(), "max")) getNode().removeProperty("max");
      	if (value!=null) getNode().setProperty("max", value);
         return this;
      }

      private extensionsNode fillMax(ProtobufGroup.extensionsST statement) {
      	if (has(getNode(), "max")) statement.setMax(get(getNode(), "max"));
      	return this;
      } 

       // min
      public extensionsNode setMin(String value) {
      	if (has(getNode(), "min")) getNode().removeProperty("min");
      	if (value!=null) getNode().setProperty("min", value);
         return this;
      }

      private extensionsNode fillMin(ProtobufGroup.extensionsST statement) {
      	if (has(getNode(), "min")) statement.setMin(get(getNode(), "min"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class groupMessagesModelNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   GROUPNAME, MESSAGES, PACKAGENAME
   	}

      private groupMessagesModelNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.groupMessagesModelST fill(ProtobufGroup.groupMessagesModelST statement) {
   		fillGroupName(statement);
   		fillMessages(statement);
   		fillPackageName(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newgroupMessagesModel()).toString();
   	}
       // groupName
      public groupMessagesModelNode setGroupName(String value) {
      	if (has(getNode(), "groupName")) getNode().removeProperty("groupName");
      	if (value!=null) getNode().setProperty("groupName", value);
         return this;
      }

      private groupMessagesModelNode fillGroupName(ProtobufGroup.groupMessagesModelST statement) {
      	if (has(getNode(), "groupName")) statement.setGroupName(get(getNode(), "groupName"));
      	return this;
      } 

       // messages
      public groupMessagesModelNode addMessagesValue(String name_) {
      	final Node newNode = model.newNode("groupMessagesModel_messages", UUID.randomUUID());
      	getNode().createRelationshipTo(newNode, PARAMS.MESSAGES);
      	if (name_ != null) newNode.setProperty("name", name_);    
      	return this;
      }

      private groupMessagesModelNode fillMessages(ProtobufGroup.groupMessagesModelST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.MESSAGES)) {
      		final Node node = other(getNode(), relationship);
      		statement.addMessagesValue(node.hasProperty("name") ? node.getProperty("name") : null);
      	}
      	return this;
      } 

       // packageName
      public groupMessagesModelNode setPackageName(String value) {
      	if (has(getNode(), "packageName")) getNode().removeProperty("packageName");
      	if (value!=null) getNode().setProperty("packageName", value);
         return this;
      }

      private groupMessagesModelNode fillPackageName(ProtobufGroup.groupMessagesModelST statement) {
      	if (has(getNode(), "packageName")) statement.setPackageName(get(getNode(), "packageName"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class messageNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   COMMENTS, NAME, PROPERTIES
   	}

      private messageNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.messageST fill(ProtobufGroup.messageST statement) {
   		fillComments(statement);
   		fillName(statement);
   		fillProperties(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newmessage()).toString();
   	}
       // comments
      public messageNode setComments(String value) {
      	if (has(getNode(), "comments")) getNode().removeProperty("comments");
      	if (value!=null) getNode().setProperty("comments", value);
         return this;
      }

      private messageNode fillComments(ProtobufGroup.messageST statement) {
      	if (has(getNode(), "comments")) statement.setComments(get(getNode(), "comments"));
      	return this;
      } 

       // name
      public messageNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private messageNode fillName(ProtobufGroup.messageST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // properties
      public messageNode addPropertiesValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("message_properties", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.PROPERTIES);
      	}
         return this;
      }

      private messageNode fillProperties(ProtobufGroup.messageST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.PROPERTIES))
      		statement.addPropertiesValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class messageFieldNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   COMMENTS, DEFAULTVALUE, FIELDCONSTRAINT, NAME, ORDINAL, TYPE
   	}

      private messageFieldNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.messageFieldST fill(ProtobufGroup.messageFieldST statement) {
   		fillComments(statement);
   		fillDefaultValue(statement);
   		fillFieldConstraint(statement);
   		fillName(statement);
   		fillOrdinal(statement);
   		fillType(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newmessageField()).toString();
   	}
       // comments
      public messageFieldNode setComments(String value) {
      	if (has(getNode(), "comments")) getNode().removeProperty("comments");
      	if (value!=null) getNode().setProperty("comments", value);
         return this;
      }

      private messageFieldNode fillComments(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "comments")) statement.setComments(get(getNode(), "comments"));
      	return this;
      } 

       // defaultValue
      public messageFieldNode setDefaultValue(String value) {
      	if (has(getNode(), "defaultValue")) getNode().removeProperty("defaultValue");
      	if (value!=null) getNode().setProperty("defaultValue", value);
         return this;
      }

      private messageFieldNode fillDefaultValue(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "defaultValue")) statement.setDefaultValue(get(getNode(), "defaultValue"));
      	return this;
      } 

       // fieldConstraint
      public messageFieldNode setFieldConstraint(String value) {
      	if (has(getNode(), "fieldConstraint")) getNode().removeProperty("fieldConstraint");
      	if (value!=null) getNode().setProperty("fieldConstraint", value);
         return this;
      }

      private messageFieldNode fillFieldConstraint(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "fieldConstraint")) statement.setFieldConstraint(get(getNode(), "fieldConstraint"));
      	return this;
      } 

       // name
      public messageFieldNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private messageFieldNode fillName(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // ordinal
      public messageFieldNode setOrdinal(String value) {
      	if (has(getNode(), "ordinal")) getNode().removeProperty("ordinal");
      	if (value!=null) getNode().setProperty("ordinal", value);
         return this;
      }

      private messageFieldNode fillOrdinal(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "ordinal")) statement.setOrdinal(get(getNode(), "ordinal"));
      	return this;
      } 

       // type
      public messageFieldNode setType(String value) {
      	if (has(getNode(), "type")) getNode().removeProperty("type");
      	if (value!=null) getNode().setProperty("type", value);
         return this;
      }

      private messageFieldNode fillType(ProtobufGroup.messageFieldST statement) {
      	if (has(getNode(), "type")) statement.setType(get(getNode(), "type"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class protobufPackageNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   DELIVERABLES, IMPORTS, OPTIONS, PACKAGE
   	}

      private protobufPackageNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public ProtobufGroup.protobufPackageST fill(ProtobufGroup.protobufPackageST statement) {
   		fillDeliverables(statement);
   		fillImports(statement);
   		fillOptions(statement);
   		fillPackage(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newprotobufPackage()).toString();
   	}
       // deliverables
      public protobufPackageNode addDeliverablesValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("protobufPackage_deliverables", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.DELIVERABLES);
      	}
         return this;
      }

      private protobufPackageNode fillDeliverables(ProtobufGroup.protobufPackageST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.DELIVERABLES))
      		statement.addDeliverablesValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

       // imports
      public protobufPackageNode addImportsValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("protobufPackage_imports", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.IMPORTS);
      	}
         return this;
      }

      private protobufPackageNode fillImports(ProtobufGroup.protobufPackageST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.IMPORTS))
      		statement.addImportsValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

       // options
      public protobufPackageNode addOptionsValue(String name_, String value_) {
      	final Node newNode = model.newNode("protobufPackage_options", UUID.randomUUID());
      	getNode().createRelationshipTo(newNode, PARAMS.OPTIONS);
      	if (name_ != null) newNode.setProperty("name", name_); 
      	if (value_ != null) newNode.setProperty("value", value_);    
      	return this;
      }

      private protobufPackageNode fillOptions(ProtobufGroup.protobufPackageST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.OPTIONS)) {
      		final Node node = other(getNode(), relationship);
      		statement.addOptionsValue(node.hasProperty("name") ? node.getProperty("name") : null, node.hasProperty("value") ? node.getProperty("value") : null);
      	}
      	return this;
      } 

       // package
      public protobufPackageNode setPackage(String value) {
      	if (has(getNode(), "package")) getNode().removeProperty("package");
      	if (value!=null) getNode().setProperty("package", value);
         return this;
      }

      private protobufPackageNode fillPackage(ProtobufGroup.protobufPackageST statement) {
      	if (has(getNode(), "package")) statement.setPackage(get(getNode(), "package"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 
} 