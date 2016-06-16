 package com.generator.generators.templatesNeo;

 import com.generator.editors.domain.NeoModel;
 import org.neo4j.graphdb.Node;
 import org.neo4j.graphdb.Relationship;

 import java.util.UUID;

 import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'TemplatesNeo.stg' file <br/>	TemplatesNeo
 */
public final class TemplatesNeoNeo {

	private static final TemplatesNeoGroup group = new TemplatesNeoGroup();

	private final NeoModel model;

   public TemplatesNeoNeo(final NeoModel model) {
 		this.model = model;
	}

    public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration() {
   	return new NeoGroupClassDeclarationNode(model, NeoModel.uuidOf(model.newNode("NeoGroupClassDeclaration", UUID.randomUUID())));
   }

   public NeoGroupClassDeclarationNode getNeoGroupClassDeclaration(UUID uuid) {
   	return new NeoGroupClassDeclarationNode(model, uuid);
   } 

    public bugfix2Node newbugfix2() {
   	return new bugfix2Node(model, NeoModel.uuidOf(model.newNode("bugfix2", UUID.randomUUID())));
   }

   public bugfix2Node getbugfix2(UUID uuid) {
   	return new bugfix2Node(model, uuid);
   } 

    public declarationNode newdeclaration() {
   	return new declarationNode(model, NeoModel.uuidOf(model.newNode("declaration", UUID.randomUUID())));
   }

   public declarationNode getdeclaration(UUID uuid) {
   	return new declarationNode(model, uuid);
   } 

    public endParensNode newendParens() {
   	return new endParensNode(model, NeoModel.uuidOf(model.newNode("endParens", UUID.randomUUID())));
   }

   public endParensNode getendParens(UUID uuid) {
   	return new endParensNode(model, uuid);
   } 

    public keyValueListSetterNode newkeyValueListSetter() {
   	return new keyValueListSetterNode(model, NeoModel.uuidOf(model.newNode("keyValueListSetter", UUID.randomUUID())));
   }

   public keyValueListSetterNode getkeyValueListSetter(UUID uuid) {
   	return new keyValueListSetterNode(model, uuid);
   } 

    public listSetterNode newlistSetter() {
   	return new listSetterNode(model, NeoModel.uuidOf(model.newNode("listSetter", UUID.randomUUID())));
   }

   public listSetterNode getlistSetter(UUID uuid) {
   	return new listSetterNode(model, uuid);
   } 

    public newInstanceNode newnewInstance() {
   	return new newInstanceNode(model, NeoModel.uuidOf(model.newNode("newInstance", UUID.randomUUID())));
   }

   public newInstanceNode getnewInstance(UUID uuid) {
   	return new newInstanceNode(model, uuid);
   } 

    public stringSetterNode newstringSetter() {
   	return new stringSetterNode(model, NeoModel.uuidOf(model.newNode("stringSetter", UUID.randomUUID())));
   }

   public stringSetterNode getstringSetter(UUID uuid) {
   	return new stringSetterNode(model, uuid);
   } 

    public static final class NeoGroupClassDeclarationNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   DOMAIN, NAME, PACKAGENAME, STATEMENTS
   	}

      private NeoGroupClassDeclarationNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.NeoGroupClassDeclarationST fill(TemplatesNeoGroup.NeoGroupClassDeclarationST statement) {
   		fillDomain(statement);
   		fillName(statement);
   		fillPackageName(statement);
   		fillStatements(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newNeoGroupClassDeclaration()).toString();
   	}
       // domain
      public NeoGroupClassDeclarationNode setDomain(String value) {
      	if (has(getNode(), "domain")) getNode().removeProperty("domain");
      	if (value!=null) getNode().setProperty("domain", value);
         return this;
      }

      private NeoGroupClassDeclarationNode fillDomain(TemplatesNeoGroup.NeoGroupClassDeclarationST statement) {
      	if (has(getNode(), "domain")) statement.setDomain(get(getNode(), "domain"));
      	return this;
      } 

       // name
      public NeoGroupClassDeclarationNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private NeoGroupClassDeclarationNode fillName(TemplatesNeoGroup.NeoGroupClassDeclarationST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // packageName
      public NeoGroupClassDeclarationNode setPackageName(String value) {
      	if (has(getNode(), "packageName")) getNode().removeProperty("packageName");
      	if (value!=null) getNode().setProperty("packageName", value);
         return this;
      }

      private NeoGroupClassDeclarationNode fillPackageName(TemplatesNeoGroup.NeoGroupClassDeclarationST statement) {
      	if (has(getNode(), "packageName")) statement.setPackageName(get(getNode(), "packageName"));
      	return this;
      } 

       // statements
      public NeoGroupClassDeclarationNode addStatementsValue(String declaration_, String newInstance_) {
      	final Node newNode = model.newNode("NeoGroupClassDeclaration_statements", UUID.randomUUID());
      	getNode().createRelationshipTo(newNode, PARAMS.STATEMENTS);
      	if (declaration_ != null) newNode.setProperty("declaration", declaration_); 
      	if (newInstance_ != null) newNode.setProperty("newInstance", newInstance_);    
      	return this;
      }

      private NeoGroupClassDeclarationNode fillStatements(TemplatesNeoGroup.NeoGroupClassDeclarationST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.STATEMENTS)) {
      		final Node node = other(getNode(), relationship);
      		statement.addStatementsValue(node.hasProperty("declaration") ? node.getProperty("declaration") : null, node.hasProperty("newInstance") ? node.getProperty("newInstance") : null);
      	}
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class bugfix2Node {

      private final NeoModel model;
   	private final UUID uuid;

      private bugfix2Node(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.bugfix2ST fill(TemplatesNeoGroup.bugfix2ST statement) {
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newbugfix2()).toString();
   	}

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class declarationNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   GROUPNAME, NAME, PROPERTIES
   	}

      private declarationNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.declarationST fill(TemplatesNeoGroup.declarationST statement) {
   		fillGroupName(statement);
   		fillName(statement);
   		fillProperties(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newdeclaration()).toString();
   	}
       // groupName
      public declarationNode setGroupName(String value) {
      	if (has(getNode(), "groupName")) getNode().removeProperty("groupName");
      	if (value!=null) getNode().setProperty("groupName", value);
         return this;
      }

      private declarationNode fillGroupName(TemplatesNeoGroup.declarationST statement) {
      	if (has(getNode(), "groupName")) statement.setGroupName(get(getNode(), "groupName"));
      	return this;
      } 

       // name
      public declarationNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private declarationNode fillName(TemplatesNeoGroup.declarationST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

       // properties
      public declarationNode addPropertiesValue(String name_, String setter_) {
      	final Node newNode = model.newNode("declaration_properties", UUID.randomUUID());
      	getNode().createRelationshipTo(newNode, PARAMS.PROPERTIES);
      	if (name_ != null) newNode.setProperty("name", name_); 
      	if (setter_ != null) newNode.setProperty("setter", setter_);    
      	return this;
      }

      private declarationNode fillProperties(TemplatesNeoGroup.declarationST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.PROPERTIES)) {
      		final Node node = other(getNode(), relationship);
      		statement.addPropertiesValue(node.hasProperty("name") ? node.getProperty("name") : null, node.hasProperty("setter") ? node.getProperty("setter") : null);
      	}
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class endParensNode {

      private final NeoModel model;
   	private final UUID uuid;

      private endParensNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.endParensST fill(TemplatesNeoGroup.endParensST statement) {
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newendParens()).toString();
   	}

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class keyValueListSetterNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   GROUPNAME, KVNAMES, PROPERTYNAME, STATEMENTNAME
   	}

      private keyValueListSetterNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.keyValueListSetterST fill(TemplatesNeoGroup.keyValueListSetterST statement) {
   		fillGroupName(statement);
   		fillKvNames(statement);
   		fillPropertyName(statement);
   		fillStatementName(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newkeyValueListSetter()).toString();
   	}
       // groupName
      public keyValueListSetterNode setGroupName(String value) {
      	if (has(getNode(), "groupName")) getNode().removeProperty("groupName");
      	if (value!=null) getNode().setProperty("groupName", value);
         return this;
      }

      private keyValueListSetterNode fillGroupName(TemplatesNeoGroup.keyValueListSetterST statement) {
      	if (has(getNode(), "groupName")) statement.setGroupName(get(getNode(), "groupName"));
      	return this;
      } 

       // kvNames
      public keyValueListSetterNode addKvNamesValue(String value) {
      	if (value != null) {
      		final Node newNode = model.newNode("keyValueListSetter_kvNames", UUID.randomUUID());
      		newNode.setProperty("value", value);
      		getNode().createRelationshipTo(newNode, PARAMS.KVNAMES);
      	}
         return this;
      }

      private keyValueListSetterNode fillKvNames(TemplatesNeoGroup.keyValueListSetterST statement) {
      	for (Relationship relationship : outgoing(getNode(), PARAMS.KVNAMES))
      		statement.addKvNamesValue(getOtherProperty(getNode(), relationship, "value"));
      	return this;
      } 

       // propertyName
      public keyValueListSetterNode setPropertyName(String value) {
      	if (has(getNode(), "propertyName")) getNode().removeProperty("propertyName");
      	if (value!=null) getNode().setProperty("propertyName", value);
         return this;
      }

      private keyValueListSetterNode fillPropertyName(TemplatesNeoGroup.keyValueListSetterST statement) {
      	if (has(getNode(), "propertyName")) statement.setPropertyName(get(getNode(), "propertyName"));
      	return this;
      } 

       // statementName
      public keyValueListSetterNode setStatementName(String value) {
      	if (has(getNode(), "statementName")) getNode().removeProperty("statementName");
      	if (value!=null) getNode().setProperty("statementName", value);
         return this;
      }

      private keyValueListSetterNode fillStatementName(TemplatesNeoGroup.keyValueListSetterST statement) {
      	if (has(getNode(), "statementName")) statement.setStatementName(get(getNode(), "statementName"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class listSetterNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   GROUPNAME, PROPERTYNAME, STATEMENTNAME
   	}

      private listSetterNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.listSetterST fill(TemplatesNeoGroup.listSetterST statement) {
   		fillGroupName(statement);
   		fillPropertyName(statement);
   		fillStatementName(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newlistSetter()).toString();
   	}
       // groupName
      public listSetterNode setGroupName(String value) {
      	if (has(getNode(), "groupName")) getNode().removeProperty("groupName");
      	if (value!=null) getNode().setProperty("groupName", value);
         return this;
      }

      private listSetterNode fillGroupName(TemplatesNeoGroup.listSetterST statement) {
      	if (has(getNode(), "groupName")) statement.setGroupName(get(getNode(), "groupName"));
      	return this;
      } 

       // propertyName
      public listSetterNode setPropertyName(String value) {
      	if (has(getNode(), "propertyName")) getNode().removeProperty("propertyName");
      	if (value!=null) getNode().setProperty("propertyName", value);
         return this;
      }

      private listSetterNode fillPropertyName(TemplatesNeoGroup.listSetterST statement) {
      	if (has(getNode(), "propertyName")) statement.setPropertyName(get(getNode(), "propertyName"));
      	return this;
      } 

       // statementName
      public listSetterNode setStatementName(String value) {
      	if (has(getNode(), "statementName")) getNode().removeProperty("statementName");
      	if (value!=null) getNode().setProperty("statementName", value);
         return this;
      }

      private listSetterNode fillStatementName(TemplatesNeoGroup.listSetterST statement) {
      	if (has(getNode(), "statementName")) statement.setStatementName(get(getNode(), "statementName"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class newInstanceNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   NAME
   	}

      private newInstanceNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.newInstanceST fill(TemplatesNeoGroup.newInstanceST statement) {
   		fillName(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newnewInstance()).toString();
   	}
       // name
      public newInstanceNode setName(String value) {
      	if (has(getNode(), "name")) getNode().removeProperty("name");
      	if (value!=null) getNode().setProperty("name", value);
         return this;
      }

      private newInstanceNode fillName(TemplatesNeoGroup.newInstanceST statement) {
      	if (has(getNode(), "name")) statement.setName(get(getNode(), "name"));
      	return this;
      } 

   	public UUID getUUID() {
   		return uuid;
   	}

   	public Node getNode() {
   		return model.getNode(uuid);
   	}
   } 

    public static final class stringSetterNode {

      private final NeoModel model;
   	private final UUID uuid;

   	private enum PARAMS implements org.neo4j.graphdb.RelationshipType {
   	   GROUPNAME, PROPERTYNAME, STATEMENTNAME
   	}

      private stringSetterNode(final NeoModel model, UUID uuid) {
   		this.model = model;
   		this.uuid = uuid;
   	}

   	public TemplatesNeoGroup.stringSetterST fill(TemplatesNeoGroup.stringSetterST statement) {
   		fillGroupName(statement);
   		fillPropertyName(statement);
   		fillStatementName(statement);
   		return statement;
   	}

   	@Override
   	public String toString() {
   		return fill(group.newstringSetter()).toString();
   	}
       // groupName
      public stringSetterNode setGroupName(String value) {
      	if (has(getNode(), "groupName")) getNode().removeProperty("groupName");
      	if (value!=null) getNode().setProperty("groupName", value);
         return this;
      }

      private stringSetterNode fillGroupName(TemplatesNeoGroup.stringSetterST statement) {
      	if (has(getNode(), "groupName")) statement.setGroupName(get(getNode(), "groupName"));
      	return this;
      } 

       // propertyName
      public stringSetterNode setPropertyName(String value) {
      	if (has(getNode(), "propertyName")) getNode().removeProperty("propertyName");
      	if (value!=null) getNode().setProperty("propertyName", value);
         return this;
      }

      private stringSetterNode fillPropertyName(TemplatesNeoGroup.stringSetterST statement) {
      	if (has(getNode(), "propertyName")) statement.setPropertyName(get(getNode(), "propertyName"));
      	return this;
      } 

       // statementName
      public stringSetterNode setStatementName(String value) {
      	if (has(getNode(), "statementName")) getNode().removeProperty("statementName");
      	if (value!=null) getNode().setProperty("statementName", value);
         return this;
      }

      private stringSetterNode fillStatementName(TemplatesNeoGroup.stringSetterST statement) {
      	if (has(getNode(), "statementName")) statement.setStatementName(get(getNode(), "statementName"));
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