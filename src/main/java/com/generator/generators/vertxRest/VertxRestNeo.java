package com.generator.generators.vertxRest;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'VertxRest.stg' file <br/>
 * 
 */
public final class VertxRestNeo {

	private final GraphDatabaseService graph;

	public enum VertxRestLabels implements Label {
   	VertxRest_API, VertxRest_endMethodFix, VertxRest_validatingNeoHandler, VertxRest, StringNode
	}

   public VertxRestNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isAPI(Node node) {
   	return node != null && node.hasLabel(VertxRestLabels.VertxRest_API);
   }

   public APINode newAPI() {
   	return new APINode(graph);
   }

   public APINode newAPI(Node node) {
   	return new APINode(graph, node);
   }

   public void forEachAPINodes(Consumer<APINode> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_API).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new APINode(graph, node));
   			}
   		});
   }

   public void visitAPINodes(Consumer<Node> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_API).
   		forEachRemaining(consumer);
   } 

   public static boolean isEndMethodFix(Node node) {
   	return node != null && node.hasLabel(VertxRestLabels.VertxRest_endMethodFix);
   }

   public endMethodFixNode newEndMethodFix() {
   	return new endMethodFixNode(graph);
   }

   public endMethodFixNode newEndMethodFix(Node node) {
   	return new endMethodFixNode(graph, node);
   }

   public void forEachEndMethodFixNodes(Consumer<endMethodFixNode> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_endMethodFix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new endMethodFixNode(graph, node));
   			}
   		});
   }

   public void visitEndMethodFixNodes(Consumer<Node> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_endMethodFix).
   		forEachRemaining(consumer);
   } 

   public static boolean isValidatingNeoHandler(Node node) {
   	return node != null && node.hasLabel(VertxRestLabels.VertxRest_validatingNeoHandler);
   }

   public validatingNeoHandlerNode newValidatingNeoHandler() {
   	return new validatingNeoHandlerNode(graph);
   }

   public validatingNeoHandlerNode newValidatingNeoHandler(Node node) {
   	return new validatingNeoHandlerNode(graph, node);
   }

   public void forEachValidatingNeoHandlerNodes(Consumer<validatingNeoHandlerNode> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_validatingNeoHandler).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new validatingNeoHandlerNode(graph, node));
   			}
   		});
   }

   public void visitValidatingNeoHandlerNodes(Consumer<Node> consumer) {
   	graph.findNodes(VertxRestLabels.VertxRest_validatingNeoHandler).
   		forEachRemaining(consumer);
   } 

	public static final class APINode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, endpoints_param, entities_param, name_param, packageName_param, properties_param, visitors_param
		}

		private APINode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(VertxRestLabels.VertxRest_API);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private APINode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("APINode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			APINode that = (APINode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "VertxRest_API " + uuid;
		}

	   // comments
	   public APINode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // endpoints
	   public APINode addEndpointsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.endpoints_param);
	      return this;
	   }

	   public void forEachEndpoints(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.endpoints_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // entities
	   public APINode addEntitiesValue(Node nameTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.entities_param);
	   	return this;
	   }

	   public APINode addEntitiesValue(EntitiesKeyValue keyValue) {
	      return addEntitiesValue(keyValue.getNameValue());
	   }

	   public interface EntitiesKeyValue {

	   	public Node getNameValue();   
	   }

	   public void forEachEntitiesValue(Consumer<EntitiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.entities_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new EntitiesKeyValue() {

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "API_entities_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 

	   // name
	   public APINode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // packageName
	   public APINode setPackageName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.packageName_param))
	   		singleOutgoing(node, Parameters.packageName_param).delete();
	   	node.createRelationshipTo(target, Parameters.packageName_param);
	      return this;
	   }

	   public Node getPackageName() {
	   	if (!hasOutgoing(node, Parameters.packageName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.packageName_param);
	   	return other(node, relationship);
	   }

	   public void removePackageName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.packageName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // properties
	   public APINode addPropertiesValue(Node nameTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.properties_param);
	   	return this;
	   }

	   public APINode addPropertiesValue(PropertiesKeyValue keyValue) {
	      return addPropertiesValue(keyValue.getNameValue());
	   }

	   public interface PropertiesKeyValue {

	   	public Node getNameValue();   
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new PropertiesKeyValue() {

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "API_properties_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 

	   // visitors
	   public APINode addVisitorsValue(Node implTarget, Node nameTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (implTarget != null) 
	   		keyValueNode.createRelationshipTo(implTarget, RelationshipType.withName("impl"));

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.visitors_param);
	   	return this;
	   }

	   public APINode addVisitorsValue(VisitorsKeyValue keyValue) {
	      return addVisitorsValue(keyValue.getImplValue(), keyValue.getNameValue());
	   }

	   public interface VisitorsKeyValue {

	   	public Node getImplValue();

	   	public Node getNameValue();   
	   }

	   public void forEachVisitorsValue(Consumer<VisitorsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.visitors_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new VisitorsKeyValue() {

	   			@Override
	   			public Node getImplValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("impl"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("impl")));
	   			 } 

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "API_visitors_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class endMethodFixNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private endMethodFixNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(VertxRestLabels.VertxRest_endMethodFix);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private endMethodFixNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("endMethodFixNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			endMethodFixNode that = (endMethodFixNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "VertxRest_endMethodFix " + uuid;
		}

	} 

	public static final class validatingNeoHandlerNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			action_param, apiName_param, uri_param, validations_param, visitor_param
		}

		private validatingNeoHandlerNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(VertxRestLabels.VertxRest_validatingNeoHandler);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private validatingNeoHandlerNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("validatingNeoHandlerNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			validatingNeoHandlerNode that = (validatingNeoHandlerNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "VertxRest_validatingNeoHandler " + uuid;
		}

	   // action
	   public validatingNeoHandlerNode setAction(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.action_param))
	   		singleOutgoing(node, Parameters.action_param).delete();
	   	node.createRelationshipTo(target, Parameters.action_param);
	      return this;
	   }

	   public Node getAction() {
	   	if (!hasOutgoing(node, Parameters.action_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.action_param);
	   	return other(node, relationship);
	   }

	   public void removeAction() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.action_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // apiName
	   public validatingNeoHandlerNode setApiName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.apiName_param))
	   		singleOutgoing(node, Parameters.apiName_param).delete();
	   	node.createRelationshipTo(target, Parameters.apiName_param);
	      return this;
	   }

	   public Node getApiName() {
	   	if (!hasOutgoing(node, Parameters.apiName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.apiName_param);
	   	return other(node, relationship);
	   }

	   public void removeApiName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.apiName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // uri
	   public validatingNeoHandlerNode setUri(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.uri_param))
	   		singleOutgoing(node, Parameters.uri_param).delete();
	   	node.createRelationshipTo(target, Parameters.uri_param);
	      return this;
	   }

	   public Node getUri() {
	   	if (!hasOutgoing(node, Parameters.uri_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.uri_param);
	   	return other(node, relationship);
	   }

	   public void removeUri() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.uri_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // validations
	   public validatingNeoHandlerNode addValidationsValue(Node propertyTarget, Node validationTypeTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (propertyTarget != null) 
	   		keyValueNode.createRelationshipTo(propertyTarget, RelationshipType.withName("property"));

	   	if (validationTypeTarget != null) 
	   		keyValueNode.createRelationshipTo(validationTypeTarget, RelationshipType.withName("validationType"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.validations_param);
	   	return this;
	   }

	   public validatingNeoHandlerNode addValidationsValue(ValidationsKeyValue keyValue) {
	      return addValidationsValue(keyValue.getPropertyValue(), keyValue.getValidationTypeValue());
	   }

	   public interface ValidationsKeyValue {

	   	public Node getPropertyValue();

	   	public Node getValidationTypeValue();   
	   }

	   public void forEachValidationsValue(Consumer<ValidationsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.validations_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new ValidationsKeyValue() {

	   			@Override
	   			public Node getPropertyValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("property"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("property")));
	   			 } 

	   			@Override
	   			public Node getValidationTypeValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("validationType"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("validationType")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "validatingNeoHandler_validations_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 

	   // visitor
	   public validatingNeoHandlerNode setVisitor(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.visitor_param))
	   		singleOutgoing(node, Parameters.visitor_param).delete();
	   	node.createRelationshipTo(target, Parameters.visitor_param);
	      return this;
	   }

	   public Node getVisitor() {
	   	if (!hasOutgoing(node, Parameters.visitor_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.visitor_param);
	   	return other(node, relationship);
	   }

	   public void removeVisitor() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.visitor_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(VertxRestLabels.StringNode);
	}

	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");
		return new StringNode(graph).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node == null) return null;
		return new StringNode(node);
	}

	// todo turn this into an interface, like KeyValues ?
	public static final class StringNode {

		private final Node node;
		private final UUID uuid;

		public StringNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(VertxRestLabels.StringNode);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public StringNode(final Node node) {
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			StringNode that = (StringNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getValue();
		}

		// propertyName
		public StringNode setValue(String value) {
			if (node == null) return this;
			node.setProperty("value", value);
			return this;
		}

		public String getValue() {
			return getString(node, "value");
		}
	} 
} 