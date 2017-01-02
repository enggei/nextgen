package com.generator.generators.vertxRest;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.vertxRest.VertxRestNeo.VertxRestLabels.*;

/**
 * Wraps Neo4j methods based on 'VertxRest.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class VertxRestNeo {

	private final GraphDatabaseService graph;

	public enum VertxRestLabels implements Label {
		VertxRest,   	
		VertxRest_API,
		VertxRest_endMethodFix,
		VertxRest_validatingNeoHandler, 
		StringNode
	}

   public VertxRestNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isAPI(Node node) {
   	return node != null && node.hasLabel(VertxRest_API);
   }

   public static APINode newAPI(Node node) {
   	return new APINode(node);
   }

   public APINode newAPI() {
   	return new APINode(graph);
   }

   public ResourceIterator<Node> findAllAPI() { return graph.findNodes(VertxRest_API); } 

   public static boolean isEndMethodFix(Node node) {
   	return node != null && node.hasLabel(VertxRest_endMethodFix);
   }

   public static endMethodFixNode newEndMethodFix(Node node) {
   	return new endMethodFixNode(node);
   }

   public endMethodFixNode newEndMethodFix() {
   	return new endMethodFixNode(graph);
   }

   public ResourceIterator<Node> findAllEndMethodFix() { return graph.findNodes(VertxRest_endMethodFix); } 

   public static boolean isValidatingNeoHandler(Node node) {
   	return node != null && node.hasLabel(VertxRest_validatingNeoHandler);
   }

   public static validatingNeoHandlerNode newValidatingNeoHandler(Node node) {
   	return new validatingNeoHandlerNode(node);
   }

   public validatingNeoHandlerNode newValidatingNeoHandler() {
   	return new validatingNeoHandlerNode(graph);
   }

   public ResourceIterator<Node> findAllValidatingNeoHandler() { return graph.findNodes(VertxRest_validatingNeoHandler); } 

	public static final class APINode {

		// VertxRest
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, endpoints_param, entities_param, name_param, packageName_param, properties_param, visitors_param
		}

		private enum EntitiesRelationships implements RelationshipType {
			name
		} 
		private enum PropertiesRelationships implements RelationshipType {
			name
		} 
		private enum VisitorsRelationships implements RelationshipType {
			impl, name
		} 

		private enum KeyValueLabels implements Label {
			Entities, Properties, Visitors, 
		}

		private APINode(final GraphDatabaseService graph) {
			this.node = graph.createNode(VertxRest_API);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private APINode(final Node node) {
			// assuming node has label VertxRest_API
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return getClass().getName() + "  " + uuid;
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
	   	if (isAlreadyRelated(node, target, Parameters.endpoints_param)) return this;
	   	node.createRelationshipTo(target, Parameters.endpoints_param);
	      return this;
	   }

	   public void forEachEndpoints(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.endpoints_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   public interface EntitiesKeyValue {

	   	public Node getNameValue();

	   	public EntitiesKeyValue setNameValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public APINode addEntitiesValue(EntitiesKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.entities_param);
	      return this;
	   }

	   public EntitiesKeyValue newEntitiesKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Entities);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newEntitiesKeyValue(node);
	   }

	   public static EntitiesKeyValue newEntitiesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newEntitiesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new EntitiesKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, EntitiesRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, EntitiesRelationships.name));
	   		} 

	   		@Override
	   		public EntitiesKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, EntitiesRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, EntitiesRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, EntitiesRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachEntitiesValue(Consumer<EntitiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.entities_param)) {
	   		consumer.accept(newEntitiesKeyValue(other(node, relationship)));
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

	   public interface PropertiesKeyValue {

	   	public Node getNameValue();

	   	public PropertiesKeyValue setNameValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public APINode addPropertiesValue(PropertiesKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.properties_param);
	      return this;
	   }

	   public PropertiesKeyValue newPropertiesKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Properties);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newPropertiesKeyValue(node);
	   }

	   public static PropertiesKeyValue newPropertiesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newPropertiesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new PropertiesKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, PropertiesRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, PropertiesRelationships.name));
	   		} 

	   		@Override
	   		public PropertiesKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, PropertiesRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, PropertiesRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, PropertiesRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		consumer.accept(newPropertiesKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface VisitorsKeyValue {

	   	public Node getImplValue();

	   	public Node getNameValue();

	   	public VisitorsKeyValue setImplValue(Node value);

	   	public VisitorsKeyValue setNameValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public APINode addVisitorsValue(VisitorsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.visitors_param);
	      return this;
	   }

	   public VisitorsKeyValue newVisitorsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Visitors);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newVisitorsKeyValue(node);
	   }

	   public static VisitorsKeyValue newVisitorsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newVisitorsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new VisitorsKeyValue() {

	   		@Override
	   		public Node getImplValue() {
	   			if (!hasOutgoing(node, VisitorsRelationships.impl)) return null;
	   			return other(node, singleOutgoing(node, VisitorsRelationships.impl));
	   		} 

	   		@Override
	   		public VisitorsKeyValue setImplValue(Node value) {
	   			if (hasOutgoing(node, VisitorsRelationships.impl)) {
	   				final Relationship outgoing = singleOutgoing(node, VisitorsRelationships.impl);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, VisitorsRelationships.impl);

	   			return this;
	   		} 

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, VisitorsRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, VisitorsRelationships.name));
	   		} 

	   		@Override
	   		public VisitorsKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, VisitorsRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, VisitorsRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, VisitorsRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachVisitorsValue(Consumer<VisitorsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.visitors_param)) {
	   		consumer.accept(newVisitorsKeyValue(other(node, relationship)));
	   	}
	   } 

		public interface APINodeVisitor<T> {

			void visitComments(Node node); 

			void visitEndpoints(Node node); 

			void visitEntities(EntitiesKeyValue node); 

			void visitName(Node node); 

			void visitPackageName(Node node); 

			void visitProperties(PropertiesKeyValue node); 

			void visitVisitors(VisitorsKeyValue node); 	

			T done();	
		}

		public <T> T visit(APINodeVisitor<T> visitor) {

			// consider adding relationship as parameter, to query the node ?

			if (hasOutgoing(node, Parameters.comments_param))
				visitor.visitComments(other(node, singleOutgoing(node, Parameters.comments_param))); 

			for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.endpoints_param)) 
				visitor.visitEndpoints(other(node, relationship)); 

			for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.entities_param)) 
				visitor.visitEntities(newEntitiesKeyValue(other(node, relationship))); 

			if (hasOutgoing(node, Parameters.name_param))
				visitor.visitName(other(node, singleOutgoing(node, Parameters.name_param))); 

			if (hasOutgoing(node, Parameters.packageName_param))
				visitor.visitPackageName(other(node, singleOutgoing(node, Parameters.packageName_param))); 

			for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) 
				visitor.visitProperties(newPropertiesKeyValue(other(node, relationship))); 

			for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.visitors_param)) 
				visitor.visitVisitors(newVisitorsKeyValue(other(node, relationship))); 

			return visitor.done();
		}
	} 

	public static final class endMethodFixNode {

		// VertxRest
	   private final Node node;
		private final UUID uuid;

		private endMethodFixNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(VertxRest_endMethodFix);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private endMethodFixNode(final Node node) {
			// assuming node has label VertxRest_endMethodFix
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return getClass().getName() + "  " + uuid;
		}


		public interface endMethodFixNodeVisitor<T> {

		

			T done();	
		}

		public <T> T visit(endMethodFixNodeVisitor<T> visitor) {

			// consider adding relationship as parameter, to query the node ?


			return visitor.done();
		}
	} 

	public static final class validatingNeoHandlerNode {

		// VertxRest
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			action_param, apiName_param, uri_param, validations_param, visitor_param
		}

		private enum ValidationsRelationships implements RelationshipType {
			property, validationType
		} 

		private enum KeyValueLabels implements Label {
			Validations, 
		}

		private validatingNeoHandlerNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(VertxRest_validatingNeoHandler);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private validatingNeoHandlerNode(final Node node) {
			// assuming node has label VertxRest_validatingNeoHandler
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return getClass().getName() + "  " + uuid;
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

	   public interface ValidationsKeyValue {

	   	public Node getPropertyValue();

	   	public Node getValidationTypeValue();

	   	public ValidationsKeyValue setPropertyValue(Node value);

	   	public ValidationsKeyValue setValidationTypeValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public validatingNeoHandlerNode addValidationsValue(ValidationsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.validations_param);
	      return this;
	   }

	   public ValidationsKeyValue newValidationsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Validations);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newValidationsKeyValue(node);
	   }

	   public static ValidationsKeyValue newValidationsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newValidationsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new ValidationsKeyValue() {

	   		@Override
	   		public Node getPropertyValue() {
	   			if (!hasOutgoing(node, ValidationsRelationships.property)) return null;
	   			return other(node, singleOutgoing(node, ValidationsRelationships.property));
	   		} 

	   		@Override
	   		public ValidationsKeyValue setPropertyValue(Node value) {
	   			if (hasOutgoing(node, ValidationsRelationships.property)) {
	   				final Relationship outgoing = singleOutgoing(node, ValidationsRelationships.property);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, ValidationsRelationships.property);

	   			return this;
	   		} 

	   		@Override
	   		public Node getValidationTypeValue() {
	   			if (!hasOutgoing(node, ValidationsRelationships.validationType)) return null;
	   			return other(node, singleOutgoing(node, ValidationsRelationships.validationType));
	   		} 

	   		@Override
	   		public ValidationsKeyValue setValidationTypeValue(Node value) {
	   			if (hasOutgoing(node, ValidationsRelationships.validationType)) {
	   				final Relationship outgoing = singleOutgoing(node, ValidationsRelationships.validationType);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, ValidationsRelationships.validationType);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachValidationsValue(Consumer<ValidationsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.validations_param)) {
	   		consumer.accept(newValidationsKeyValue(other(node, relationship)));
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

		public interface validatingNeoHandlerNodeVisitor<T> {

			void visitAction(Node node); 

			void visitApiName(Node node); 

			void visitUri(Node node); 

			void visitValidations(ValidationsKeyValue node); 

			void visitVisitor(Node node); 	

			T done();	
		}

		public <T> T visit(validatingNeoHandlerNodeVisitor<T> visitor) {

			// consider adding relationship as parameter, to query the node ?

			if (hasOutgoing(node, Parameters.action_param))
				visitor.visitAction(other(node, singleOutgoing(node, Parameters.action_param))); 

			if (hasOutgoing(node, Parameters.apiName_param))
				visitor.visitApiName(other(node, singleOutgoing(node, Parameters.apiName_param))); 

			if (hasOutgoing(node, Parameters.uri_param))
				visitor.visitUri(other(node, singleOutgoing(node, Parameters.uri_param))); 

			for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.validations_param)) 
				visitor.visitValidations(newValidationsKeyValue(other(node, relationship))); 

			if (hasOutgoing(node, Parameters.visitor_param))
				visitor.visitVisitor(other(node, singleOutgoing(node, Parameters.visitor_param))); 

			return visitor.done();
		}
	} 

	public interface VertxRestNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(VertxRestNeoAction committer) {
		try (Transaction tx = graph.beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(StringNode);
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final Node node = graph.createNode(StringNode);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node==null) throw new IllegalArgumentException("node for newStringNode cannot be null");

		final UUID uuid = UUID.fromString(getString(node, "_uuid"));

		return new StringNode() {
			@Override
			public StringNode setValue(String value) {
				node.setProperty("value", value);
				return this;
			}

			@Override
			public String getValue() {
				return getString(node, "value");
			}

			@Override
			public Node node() {
				return node;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				StringNode that = (StringNode) o;
				return uuid.equals(that.getUuid());
			}

			@Override
			public int hashCode() {
				return uuid.hashCode();
			}

			@Override
			public String toString() {
				return getValue();
			}	
		};
	}

	public interface StringNode {

		public StringNode setValue(String value);

		public String getValue();

		public Node node();

		public UUID getUuid();
	} 
} 