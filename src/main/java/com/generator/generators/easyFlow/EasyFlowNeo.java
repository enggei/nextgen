package com.generator.generators.easyFlow;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'EasyFlow.stg' file <br/>
 * 
 */
public final class EasyFlowNeo {

	private final GraphDatabaseService graph;

	public enum EasyFlowLabels implements Label {
   	EasyFlow_declaration, EasyFlow_easyFlow, EasyFlow_events, EasyFlow_impl, EasyFlow_mvn, EasyFlow_stateDeclaration, EasyFlow_statefulContext, EasyFlow_states, EasyFlow_transit, EasyFlow, StringNode
	}

   public EasyFlowNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isDeclaration(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_declaration);
   }

   public declarationNode newDeclaration() {
   	return new declarationNode(graph);
   }

   public declarationNode newDeclaration(Node node) {
   	return new declarationNode(graph, node);
   }

   public void forEachDeclarationNodes(Consumer<declarationNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_declaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new declarationNode(graph, node));
   			}
   		});
   }

   public void visitDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_declaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isEasyFlow(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_easyFlow);
   }

   public easyFlowNode newEasyFlow() {
   	return new easyFlowNode(graph);
   }

   public easyFlowNode newEasyFlow(Node node) {
   	return new easyFlowNode(graph, node);
   }

   public void forEachEasyFlowNodes(Consumer<easyFlowNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_easyFlow).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new easyFlowNode(graph, node));
   			}
   		});
   }

   public void visitEasyFlowNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_easyFlow).
   		forEachRemaining(consumer);
   } 

   public static boolean isEvents(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_events);
   }

   public eventsNode newEvents() {
   	return new eventsNode(graph);
   }

   public eventsNode newEvents(Node node) {
   	return new eventsNode(graph, node);
   }

   public void forEachEventsNodes(Consumer<eventsNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_events).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new eventsNode(graph, node));
   			}
   		});
   }

   public void visitEventsNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_events).
   		forEachRemaining(consumer);
   } 

   public static boolean isImpl(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_impl);
   }

   public implNode newImpl() {
   	return new implNode(graph);
   }

   public implNode newImpl(Node node) {
   	return new implNode(graph, node);
   }

   public void forEachImplNodes(Consumer<implNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_impl).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new implNode(graph, node));
   			}
   		});
   }

   public void visitImplNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_impl).
   		forEachRemaining(consumer);
   } 

   public static boolean isMvn(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_mvn);
   }

   public mvnNode newMvn() {
   	return new mvnNode(graph);
   }

   public mvnNode newMvn(Node node) {
   	return new mvnNode(graph, node);
   }

   public void forEachMvnNodes(Consumer<mvnNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_mvn).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new mvnNode(graph, node));
   			}
   		});
   }

   public void visitMvnNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_mvn).
   		forEachRemaining(consumer);
   } 

   public static boolean isStateDeclaration(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_stateDeclaration);
   }

   public stateDeclarationNode newStateDeclaration() {
   	return new stateDeclarationNode(graph);
   }

   public stateDeclarationNode newStateDeclaration(Node node) {
   	return new stateDeclarationNode(graph, node);
   }

   public void forEachStateDeclarationNodes(Consumer<stateDeclarationNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_stateDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stateDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitStateDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_stateDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isStatefulContext(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_statefulContext);
   }

   public statefulContextNode newStatefulContext() {
   	return new statefulContextNode(graph);
   }

   public statefulContextNode newStatefulContext(Node node) {
   	return new statefulContextNode(graph, node);
   }

   public void forEachStatefulContextNodes(Consumer<statefulContextNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_statefulContext).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new statefulContextNode(graph, node));
   			}
   		});
   }

   public void visitStatefulContextNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_statefulContext).
   		forEachRemaining(consumer);
   } 

   public static boolean isStates(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_states);
   }

   public statesNode newStates() {
   	return new statesNode(graph);
   }

   public statesNode newStates(Node node) {
   	return new statesNode(graph, node);
   }

   public void forEachStatesNodes(Consumer<statesNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_states).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new statesNode(graph, node));
   			}
   		});
   }

   public void visitStatesNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_states).
   		forEachRemaining(consumer);
   } 

   public static boolean isTransit(Node node) {
   	return node != null && node.hasLabel(EasyFlowLabels.EasyFlow_transit);
   }

   public transitNode newTransit() {
   	return new transitNode(graph);
   }

   public transitNode newTransit(Node node) {
   	return new transitNode(graph, node);
   }

   public void forEachTransitNodes(Consumer<transitNode> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_transit).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new transitNode(graph, node));
   			}
   		});
   }

   public void visitTransitNodes(Consumer<Node> consumer) {
   	graph.findNodes(EasyFlowLabels.EasyFlow_transit).
   		forEachRemaining(consumer);
   } 

	public static final class declarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, state_param
		}

		private declarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_declaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private declarationNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("declarationNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			declarationNode that = (declarationNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_declaration " + uuid;
		}

	   // name
	   public declarationNode setName(Node target) {
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

	   // state
	   public declarationNode setState(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.state_param))
	   		singleOutgoing(node, Parameters.state_param).delete();
	   	node.createRelationshipTo(target, Parameters.state_param);
	      return this;
	   }

	   public Node getState() {
	   	if (!hasOutgoing(node, Parameters.state_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.state_param);
	   	return other(node, relationship);
	   }

	   public void removeState() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.state_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class easyFlowNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			bindings_param, context_param, events_param, extends_param, name_param, package_param, states_param, superParams_param, transit_param
		}

		private easyFlowNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_easyFlow);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private easyFlowNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("easyFlowNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			easyFlowNode that = (easyFlowNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_easyFlow " + uuid;
		}

	   // bindings
	   public easyFlowNode addBindingsValue(Node declarationTarget, Node implTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (declarationTarget != null) 
	   		keyValueNode.createRelationshipTo(declarationTarget, RelationshipType.withName("declaration"));

	   	if (implTarget != null) 
	   		keyValueNode.createRelationshipTo(implTarget, RelationshipType.withName("impl"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.bindings_param);
	   	return this;
	   }

	   public easyFlowNode addBindingsValue(BindingsKeyValue keyValue) {
	      return addBindingsValue(keyValue.getDeclarationValue(), keyValue.getImplValue());
	   }

	   public interface BindingsKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getImplValue();   
	   }

	   public void forEachBindingsValue(Consumer<BindingsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.bindings_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new BindingsKeyValue() {

	   			@Override
	   			public Node getDeclarationValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("declaration"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("declaration")));
	   			 } 

	   			@Override
	   			public Node getImplValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("impl"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("impl")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "easyFlow_bindings_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 

	   // context
	   public easyFlowNode setContext(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.context_param))
	   		singleOutgoing(node, Parameters.context_param).delete();
	   	node.createRelationshipTo(target, Parameters.context_param);
	      return this;
	   }

	   public Node getContext() {
	   	if (!hasOutgoing(node, Parameters.context_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.context_param);
	   	return other(node, relationship);
	   }

	   public void removeContext() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.context_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // events
	   public easyFlowNode setEvents(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.events_param))
	   		singleOutgoing(node, Parameters.events_param).delete();
	   	node.createRelationshipTo(target, Parameters.events_param);
	      return this;
	   }

	   public Node getEvents() {
	   	if (!hasOutgoing(node, Parameters.events_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.events_param);
	   	return other(node, relationship);
	   }

	   public void removeEvents() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.events_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // extends
	   public easyFlowNode setExtends(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.extends_param))
	   		singleOutgoing(node, Parameters.extends_param).delete();
	   	node.createRelationshipTo(target, Parameters.extends_param);
	      return this;
	   }

	   public Node getExtends() {
	   	if (!hasOutgoing(node, Parameters.extends_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.extends_param);
	   	return other(node, relationship);
	   }

	   public void removeExtends() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.extends_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public easyFlowNode setName(Node target) {
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

	   // package
	   public easyFlowNode setPackage(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.package_param))
	   		singleOutgoing(node, Parameters.package_param).delete();
	   	node.createRelationshipTo(target, Parameters.package_param);
	      return this;
	   }

	   public Node getPackage() {
	   	if (!hasOutgoing(node, Parameters.package_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.package_param);
	   	return other(node, relationship);
	   }

	   public void removePackage() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.package_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // states
	   public easyFlowNode setStates(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.states_param))
	   		singleOutgoing(node, Parameters.states_param).delete();
	   	node.createRelationshipTo(target, Parameters.states_param);
	      return this;
	   }

	   public Node getStates() {
	   	if (!hasOutgoing(node, Parameters.states_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.states_param);
	   	return other(node, relationship);
	   }

	   public void removeStates() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.states_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // superParams
	   public easyFlowNode addSuperParamsValue(Node nameTarget, Node typeTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));

	   	if (typeTarget != null) 
	   		keyValueNode.createRelationshipTo(typeTarget, RelationshipType.withName("type"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.superParams_param);
	   	return this;
	   }

	   public easyFlowNode addSuperParamsValue(SuperParamsKeyValue keyValue) {
	      return addSuperParamsValue(keyValue.getNameValue(), keyValue.getTypeValue());
	   }

	   public interface SuperParamsKeyValue {

	   	public Node getNameValue();

	   	public Node getTypeValue();   
	   }

	   public void forEachSuperParamsValue(Consumer<SuperParamsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.superParams_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new SuperParamsKeyValue() {

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   			@Override
	   			public Node getTypeValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("type"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("type")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "easyFlow_superParams_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 

	   // transit
	   public easyFlowNode setTransit(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.transit_param))
	   		singleOutgoing(node, Parameters.transit_param).delete();
	   	node.createRelationshipTo(target, Parameters.transit_param);
	      return this;
	   }

	   public Node getTransit() {
	   	if (!hasOutgoing(node, Parameters.transit_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.transit_param);
	   	return other(node, relationship);
	   }

	   public void removeTransit() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.transit_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class eventsNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			events_param
		}

		private eventsNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_events);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private eventsNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("eventsNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			eventsNode that = (eventsNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_events " + uuid;
		}

	   // events
	   public eventsNode addEventsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.events_param);
	      return this;
	   }

	   public void forEachEvents(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.events_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class implNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, state_param
		}

		private implNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_impl);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private implNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("implNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			implNode that = (implNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_impl " + uuid;
		}

	   // name
	   public implNode setName(Node target) {
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

	   // state
	   public implNode setState(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.state_param))
	   		singleOutgoing(node, Parameters.state_param).delete();
	   	node.createRelationshipTo(target, Parameters.state_param);
	      return this;
	   }

	   public Node getState() {
	   	if (!hasOutgoing(node, Parameters.state_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.state_param);
	   	return other(node, relationship);
	   }

	   public void removeState() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.state_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class mvnNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private mvnNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_mvn);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private mvnNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("mvnNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			mvnNode that = (mvnNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_mvn " + uuid;
		}

	} 

	public static final class stateDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comment_param, name_param
		}

		private stateDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_stateDeclaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private stateDeclarationNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("stateDeclarationNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			stateDeclarationNode that = (stateDeclarationNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_stateDeclaration " + uuid;
		}

	   // comment
	   public stateDeclarationNode setComment(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comment_param))
	   		singleOutgoing(node, Parameters.comment_param).delete();
	   	node.createRelationshipTo(target, Parameters.comment_param);
	      return this;
	   }

	   public Node getComment() {
	   	if (!hasOutgoing(node, Parameters.comment_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comment_param);
	   	return other(node, relationship);
	   }

	   public void removeComment() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comment_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public stateDeclarationNode setName(Node target) {
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
	} 

	public static final class statefulContextNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			contextGeneric_param, name_param, properties_param
		}

		private statefulContextNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_statefulContext);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private statefulContextNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("statefulContextNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			statefulContextNode that = (statefulContextNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_statefulContext " + uuid;
		}

	   // contextGeneric
	   public statefulContextNode setContextGeneric(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.contextGeneric_param))
	   		singleOutgoing(node, Parameters.contextGeneric_param).delete();
	   	node.createRelationshipTo(target, Parameters.contextGeneric_param);
	      return this;
	   }

	   public Node getContextGeneric() {
	   	if (!hasOutgoing(node, Parameters.contextGeneric_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.contextGeneric_param);
	   	return other(node, relationship);
	   }

	   public void removeContextGeneric() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.contextGeneric_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public statefulContextNode setName(Node target) {
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

	   // properties
	   public statefulContextNode addPropertiesValue(Node commentTarget, Node modifierTarget, Node nameTarget, Node typeTarget, Node valueTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (commentTarget != null) 
	   		keyValueNode.createRelationshipTo(commentTarget, RelationshipType.withName("comment"));

	   	if (modifierTarget != null) 
	   		keyValueNode.createRelationshipTo(modifierTarget, RelationshipType.withName("modifier"));

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));

	   	if (typeTarget != null) 
	   		keyValueNode.createRelationshipTo(typeTarget, RelationshipType.withName("type"));

	   	if (valueTarget != null) 
	   		keyValueNode.createRelationshipTo(valueTarget, RelationshipType.withName("value"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.properties_param);
	   	return this;
	   }

	   public statefulContextNode addPropertiesValue(PropertiesKeyValue keyValue) {
	      return addPropertiesValue(keyValue.getCommentValue(), keyValue.getModifierValue(), keyValue.getNameValue(), keyValue.getTypeValue(), keyValue.getValueValue());
	   }

	   public interface PropertiesKeyValue {

	   	public Node getCommentValue();

	   	public Node getModifierValue();

	   	public Node getNameValue();

	   	public Node getTypeValue();

	   	public Node getValueValue();   
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new PropertiesKeyValue() {

	   			@Override
	   			public Node getCommentValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("comment"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("comment")));
	   			 } 

	   			@Override
	   			public Node getModifierValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("modifier"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("modifier")));
	   			 } 

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   			@Override
	   			public Node getTypeValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("type"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("type")));
	   			 } 

	   			@Override
	   			public Node getValueValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("value"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("value")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "statefulContext_properties_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class statesNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			states_param
		}

		private statesNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_states);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private statesNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("statesNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			statesNode that = (statesNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_states " + uuid;
		}

	   // states
	   public statesNode addStatesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.states_param);
	      return this;
	   }

	   public void forEachStates(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.states_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class transitNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			event_param, isFinish_param, isInit_param, state_param, transits_param
		}

		private transitNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(EasyFlowLabels.EasyFlow_transit);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private transitNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("transitNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			transitNode that = (transitNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "EasyFlow_transit " + uuid;
		}

	   // event
	   public transitNode setEvent(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.event_param))
	   		singleOutgoing(node, Parameters.event_param).delete();
	   	node.createRelationshipTo(target, Parameters.event_param);
	      return this;
	   }

	   public Node getEvent() {
	   	if (!hasOutgoing(node, Parameters.event_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.event_param);
	   	return other(node, relationship);
	   }

	   public void removeEvent() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.event_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // isFinish
	   public transitNode setIsFinish(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.isFinish_param))
	   		singleOutgoing(node, Parameters.isFinish_param).delete();
	   	node.createRelationshipTo(target, Parameters.isFinish_param);
	      return this;
	   }

	   public Node getIsFinish() {
	   	if (!hasOutgoing(node, Parameters.isFinish_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.isFinish_param);
	   	return other(node, relationship);
	   }

	   public void removeIsFinish() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.isFinish_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // isInit
	   public transitNode setIsInit(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.isInit_param))
	   		singleOutgoing(node, Parameters.isInit_param).delete();
	   	node.createRelationshipTo(target, Parameters.isInit_param);
	      return this;
	   }

	   public Node getIsInit() {
	   	if (!hasOutgoing(node, Parameters.isInit_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.isInit_param);
	   	return other(node, relationship);
	   }

	   public void removeIsInit() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.isInit_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // state
	   public transitNode setState(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.state_param))
	   		singleOutgoing(node, Parameters.state_param).delete();
	   	node.createRelationshipTo(target, Parameters.state_param);
	      return this;
	   }

	   public Node getState() {
	   	if (!hasOutgoing(node, Parameters.state_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.state_param);
	   	return other(node, relationship);
	   }

	   public void removeState() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.state_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // transits
	   public transitNode addTransitsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.transits_param);
	      return this;
	   }

	   public void forEachTransits(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.transits_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(EasyFlowLabels.StringNode);
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
			this.node = graph.createNode(EasyFlowLabels.StringNode);
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