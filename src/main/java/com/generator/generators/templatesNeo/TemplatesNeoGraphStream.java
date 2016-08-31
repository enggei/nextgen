package com.generator.generators.templatesNeo;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.generators.templatesNeo.TemplatesNeoGraphStream.Attributes.*;
import static com.generator.generators.templatesNeo.TemplatesNeoGraphStream.TemplatesNeoGraphStreamLabels.*;

/**
 * Wraps GraphStream methods based on 'TemplatesNeo.stg' file <br/>
 * 
 */
public final class TemplatesNeoGraphStream {

	private final Graph graph;

	public enum TemplatesNeoGraphStreamLabels {
		TemplatesNeoGraphStreamLabels,   	
		TemplatesNeo_NeoGroupClassDeclaration,
		TemplatesNeo_bugfix2,
		TemplatesNeo_declaration,
		TemplatesNeo_defaultNodeTypes,
		TemplatesNeo_keyValueListSetter,
		TemplatesNeo_keyValueRelationships,
		TemplatesNeo_listSetter,
		TemplatesNeo_newInstance,
		TemplatesNeo_stringSetter,
		StringNode
	}

	public enum Attributes {
		Label, Value
	}

   public TemplatesNeoGraphStream(final Graph graph) {
 		this.graph = graph;

		graph.addAttribute("ui.stylesheet", "" +
			"graph { fill-color: rgb(245,245,245); } " +
			"edge { fill-color: grey; }" +
			"node:clicked { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node:selected { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node.StringNode { text-background-mode: plain; text-background-color: rgb(245,245,245); stroke-color: rgb(53, 151, 143); } " +
			"node.TemplatesNeo_NeoGroupClassDeclaration { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_bugfix2 { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_declaration { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_defaultNodeTypes { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_keyValueListSetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_keyValueRelationships { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_listSetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_newInstance { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesNeo_stringSetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } ");
	}

   public static boolean isNeoGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_NeoGroupClassDeclaration.name());
   }

   public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration() {
   	return new NeoGroupClassDeclarationNode(graph);
   }

   public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration(Node node) {
   	return new NeoGroupClassDeclarationNode(graph, node);
   }

   /*
   todo:
   public void forEachNeoGroupClassDeclarationNodes(Consumer<NeoGroupClassDeclarationNode> consumer) {
   	graph.findNodes(TemplatesNeo_NeoGroupClassDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NeoGroupClassDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitNeoGroupClassDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_NeoGroupClassDeclaration).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isBugfix2(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_bugfix2.name());
   }

   public bugfix2Node newBugfix2() {
   	return new bugfix2Node(graph);
   }

   public bugfix2Node newBugfix2(Node node) {
   	return new bugfix2Node(graph, node);
   }

   /*
   todo:
   public void forEachBugfix2Nodes(Consumer<bugfix2Node> consumer) {
   	graph.findNodes(TemplatesNeo_bugfix2).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfix2Node(graph, node));
   			}
   		});
   }

   public void visitBugfix2Nodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_bugfix2).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_declaration.name());
   }

   public declarationNode newDeclaration() {
   	return new declarationNode(graph);
   }

   public declarationNode newDeclaration(Node node) {
   	return new declarationNode(graph, node);
   }

   /*
   todo:
   public void forEachDeclarationNodes(Consumer<declarationNode> consumer) {
   	graph.findNodes(TemplatesNeo_declaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new declarationNode(graph, node));
   			}
   		});
   }

   public void visitDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_declaration).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isDefaultNodeTypes(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_defaultNodeTypes.name());
   }

   public defaultNodeTypesNode newDefaultNodeTypes() {
   	return new defaultNodeTypesNode(graph);
   }

   public defaultNodeTypesNode newDefaultNodeTypes(Node node) {
   	return new defaultNodeTypesNode(graph, node);
   }

   /*
   todo:
   public void forEachDefaultNodeTypesNodes(Consumer<defaultNodeTypesNode> consumer) {
   	graph.findNodes(TemplatesNeo_defaultNodeTypes).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new defaultNodeTypesNode(graph, node));
   			}
   		});
   }

   public void visitDefaultNodeTypesNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_defaultNodeTypes).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isKeyValueListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueListSetter.name());
   }

   public keyValueListSetterNode newKeyValueListSetter() {
   	return new keyValueListSetterNode(graph);
   }

   public keyValueListSetterNode newKeyValueListSetter(Node node) {
   	return new keyValueListSetterNode(graph, node);
   }

   /*
   todo:
   public void forEachKeyValueListSetterNodes(Consumer<keyValueListSetterNode> consumer) {
   	graph.findNodes(TemplatesNeo_keyValueListSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new keyValueListSetterNode(graph, node));
   			}
   		});
   }

   public void visitKeyValueListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_keyValueListSetter).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isKeyValueRelationships(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueRelationships.name());
   }

   public keyValueRelationshipsNode newKeyValueRelationships() {
   	return new keyValueRelationshipsNode(graph);
   }

   public keyValueRelationshipsNode newKeyValueRelationships(Node node) {
   	return new keyValueRelationshipsNode(graph, node);
   }

   /*
   todo:
   public void forEachKeyValueRelationshipsNodes(Consumer<keyValueRelationshipsNode> consumer) {
   	graph.findNodes(TemplatesNeo_keyValueRelationships).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new keyValueRelationshipsNode(graph, node));
   			}
   		});
   }

   public void visitKeyValueRelationshipsNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_keyValueRelationships).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_listSetter.name());
   }

   public listSetterNode newListSetter() {
   	return new listSetterNode(graph);
   }

   public listSetterNode newListSetter(Node node) {
   	return new listSetterNode(graph, node);
   }

   /*
   todo:
   public void forEachListSetterNodes(Consumer<listSetterNode> consumer) {
   	graph.findNodes(TemplatesNeo_listSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new listSetterNode(graph, node));
   			}
   		});
   }

   public void visitListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_listSetter).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isNewInstance(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_newInstance.name());
   }

   public newInstanceNode newNewInstance() {
   	return new newInstanceNode(graph);
   }

   public newInstanceNode newNewInstance(Node node) {
   	return new newInstanceNode(graph, node);
   }

   /*
   todo:
   public void forEachNewInstanceNodes(Consumer<newInstanceNode> consumer) {
   	graph.findNodes(TemplatesNeo_newInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_newInstance).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isStringSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_stringSetter.name());
   }

   public stringSetterNode newStringSetter() {
   	return new stringSetterNode(graph);
   }

   public stringSetterNode newStringSetter(Node node) {
   	return new stringSetterNode(graph, node);
   }

   /*
   todo:
   public void forEachStringSetterNodes(Consumer<stringSetterNode> consumer) {
   	graph.findNodes(TemplatesNeo_stringSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringSetterNode(graph, node));
   			}
   		});
   }

   public void visitStringSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeo_stringSetter).
   		forEachRemaining(consumer);
   }
   */ 

	public static final class NeoGroupClassDeclarationNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node comments;
		private Node name;
		private Node packageName;
		private Node statements;

	private enum Parameters {
			comments_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships {
			declaration, name, newInstance
		} 

		private enum KeyValueLabels  {
			Statements, 
		}

		private NeoGroupClassDeclarationNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_NeoGroupClassDeclaration.name());
			node.addAttribute("ui.label", "NeoGroupClassDeclaration");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_NeoGroupClassDeclaration);
		}

		private NeoGroupClassDeclarationNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			NeoGroupClassDeclarationNode that = (NeoGroupClassDeclarationNode) o;
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
	   public NeoGroupClassDeclarationNode addCommentsValue(Node target) {
	   	if (node == null) return this;
	   	graph.addEdge("comments_" + UUID.randomUUID().toString(), this.node, target);
	      return this;
	   }

	   public void forEachComments(Consumer<Node> consumer) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("comments_")) {
	   			consumer.accept(edge.getOpposite(this.node));
	   		}
	   	}
	   } 

	   // name
	   public NeoGroupClassDeclarationNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.name = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.name != null) return this.name;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.name = edge.getOpposite(this.node);
	   			return this.name;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // packageName
	   public NeoGroupClassDeclarationNode setPackageName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("packageName_" + UUID.randomUUID(), this.node, target);
	   	this.packageName = node;
	   	return this;
	   }

	   public Node getPackageName() {
	   	if (this.packageName != null) return this.packageName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("packageName_" + uuid)) {
	   			this.packageName = edge.getOpposite(this.node);
	   			return this.packageName;
	   		}
	   	}

	   	return null;
	   }

	   public void removePackageName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   public interface StatementsKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getNameValue();

	   	public Node getNewInstanceValue();

	   	public StatementsKeyValue setDeclarationValue(Node value);

	   	public StatementsKeyValue setNameValue(Node value);

	   	public StatementsKeyValue setNewInstanceValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public NeoGroupClassDeclarationNode addStatementsValue(StatementsKeyValue target) {
	   	if (node == null) return this;
	   	graph.addEdge("statements_" + UUID.randomUUID().toString(), this.node, target.node());
	      return this;
	   }

	   public StatementsKeyValue newStatementsKeyValue() {
	   	final UUID uuid = UUID.randomUUID();
	   	final Node node = graph.addNode(uuid.toString());
	   	node.setAttribute("uuid", uuid.toString());
	   	node.setAttribute(Label.name(), "StatementsKeyValue");
	   	return newStatementsKeyValue(node);
	   }

	   public StatementsKeyValue newStatementsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newStatementsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(node.getAttribute("uuid"));

	   	return new StatementsKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("declaration_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public StatementsKeyValue setDeclarationValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("declaration_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("declaration_" + UUID.randomUUID(), node, target);
	   			return this;
	   		 } 

	   		@Override
	   		public Node getNameValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("name_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public StatementsKeyValue setNameValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("name_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("name_" + UUID.randomUUID(), node, target);
	   			return this;
	   		 } 

	   		@Override
	   		public Node getNewInstanceValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("newInstance_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public StatementsKeyValue setNewInstanceValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("newInstance_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("newInstance_" + UUID.randomUUID(), node, target);
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

	   public void forEachStatementsValue(Consumer<StatementsKeyValue> consumer) {
	   	for (Edge edge : node) {
	   		if (edge.getId().startsWith("StatementsKeyValue_")) {
	   			consumer.accept(newStatementsKeyValue(edge.getOpposite(this.node)));
	   		}
	   	}
	   } 
	} 

	public static final class bugfix2Node {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		private bugfix2Node(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_bugfix2.name());
			node.addAttribute("ui.label", "bugfix2");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_bugfix2);
		}

		private bugfix2Node(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			bugfix2Node that = (bugfix2Node) o;
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

	} 

	public static final class declarationNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node groupName;
		private Node name;
		private Node properties;

	private enum Parameters {
			groupName_param, name_param, properties_param
		}

		private enum PropertiesRelationships {
			name, relationships, setter
		} 

		private enum KeyValueLabels  {
			Properties, 
		}

		private declarationNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_declaration.name());
			node.addAttribute("ui.label", "declaration");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_declaration);
		}

		private declarationNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			return getClass().getName() + "  " + uuid;
		}

	   // groupName
	   public declarationNode setGroupName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("groupName_" + UUID.randomUUID(), this.node, target);
	   	this.groupName = node;
	   	return this;
	   }

	   public Node getGroupName() {
	   	if (this.groupName != null) return this.groupName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("groupName_" + uuid)) {
	   			this.groupName = edge.getOpposite(this.node);
	   			return this.groupName;
	   		}
	   	}

	   	return null;
	   }

	   public void removeGroupName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public declarationNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.name = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.name != null) return this.name;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.name = edge.getOpposite(this.node);
	   			return this.name;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   public interface PropertiesKeyValue {

	   	public Node getNameValue();

	   	public Node getRelationshipsValue();

	   	public Node getSetterValue();

	   	public PropertiesKeyValue setNameValue(Node value);

	   	public PropertiesKeyValue setRelationshipsValue(Node value);

	   	public PropertiesKeyValue setSetterValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public declarationNode addPropertiesValue(PropertiesKeyValue target) {
	   	if (node == null) return this;
	   	graph.addEdge("properties_" + UUID.randomUUID().toString(), this.node, target.node());
	      return this;
	   }

	   public PropertiesKeyValue newPropertiesKeyValue() {
	   	final UUID uuid = UUID.randomUUID();
	   	final Node node = graph.addNode(uuid.toString());
	   	node.setAttribute("uuid", uuid.toString());
	   	node.setAttribute(Label.name(), "PropertiesKeyValue");
	   	return newPropertiesKeyValue(node);
	   }

	   public PropertiesKeyValue newPropertiesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newPropertiesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(node.getAttribute("uuid"));

	   	return new PropertiesKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("name_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public PropertiesKeyValue setNameValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("name_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("name_" + UUID.randomUUID(), node, target);
	   			return this;
	   		 } 

	   		@Override
	   		public Node getRelationshipsValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("relationships_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public PropertiesKeyValue setRelationshipsValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("relationships_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("relationships_" + UUID.randomUUID(), node, target);
	   			return this;
	   		 } 

	   		@Override
	   		public Node getSetterValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("setter_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public PropertiesKeyValue setSetterValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("setter_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("setter_" + UUID.randomUUID(), node, target);
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
	   	for (Edge edge : node) {
	   		if (edge.getId().startsWith("PropertiesKeyValue_")) {
	   			consumer.accept(newPropertiesKeyValue(edge.getOpposite(this.node)));
	   		}
	   	}
	   } 
	} 

	public static final class defaultNodeTypesNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		private defaultNodeTypesNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_defaultNodeTypes.name());
			node.addAttribute("ui.label", "defaultNodeTypes");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_defaultNodeTypes);
		}

		private defaultNodeTypesNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			defaultNodeTypesNode that = (defaultNodeTypesNode) o;
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

	} 

	public static final class keyValueListSetterNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node kvNames;
		private Node propertyName;
		private Node statementName;

	private enum Parameters {
			kvNames_param, propertyName_param, statementName_param
		}


		private enum KeyValueLabels  {
		}

		private keyValueListSetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_keyValueListSetter.name());
			node.addAttribute("ui.label", "keyValueListSetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_keyValueListSetter);
		}

		private keyValueListSetterNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			keyValueListSetterNode that = (keyValueListSetterNode) o;
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

	   // kvNames
	   public keyValueListSetterNode addKvNamesValue(Node target) {
	   	if (node == null) return this;
	   	graph.addEdge("kvNames_" + UUID.randomUUID().toString(), this.node, target);
	      return this;
	   }

	   public void forEachKvNames(Consumer<Node> consumer) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("kvNames_")) {
	   			consumer.accept(edge.getOpposite(this.node));
	   		}
	   	}
	   } 

	   // propertyName
	   public keyValueListSetterNode setPropertyName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("propertyName_" + UUID.randomUUID(), this.node, target);
	   	this.propertyName = node;
	   	return this;
	   }

	   public Node getPropertyName() {
	   	if (this.propertyName != null) return this.propertyName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("propertyName_" + uuid)) {
	   			this.propertyName = edge.getOpposite(this.node);
	   			return this.propertyName;
	   		}
	   	}

	   	return null;
	   }

	   public void removePropertyName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // statementName
	   public keyValueListSetterNode setStatementName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("statementName_" + UUID.randomUUID(), this.node, target);
	   	this.statementName = node;
	   	return this;
	   }

	   public Node getStatementName() {
	   	if (this.statementName != null) return this.statementName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("statementName_" + uuid)) {
	   			this.statementName = edge.getOpposite(this.node);
	   			return this.statementName;
	   		}
	   	}

	   	return null;
	   }

	   public void removeStatementName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 
	} 

	public static final class keyValueRelationshipsNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node name;
		private Node types;

	private enum Parameters {
			name_param, types_param
		}


		private enum KeyValueLabels  {
		}

		private keyValueRelationshipsNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_keyValueRelationships.name());
			node.addAttribute("ui.label", "keyValueRelationships");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_keyValueRelationships);
		}

		private keyValueRelationshipsNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			keyValueRelationshipsNode that = (keyValueRelationshipsNode) o;
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

	   // name
	   public keyValueRelationshipsNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.name = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.name != null) return this.name;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.name = edge.getOpposite(this.node);
	   			return this.name;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // types
	   public keyValueRelationshipsNode addTypesValue(Node target) {
	   	if (node == null) return this;
	   	graph.addEdge("types_" + UUID.randomUUID().toString(), this.node, target);
	      return this;
	   }

	   public void forEachTypes(Consumer<Node> consumer) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("types_")) {
	   			consumer.accept(edge.getOpposite(this.node));
	   		}
	   	}
	   } 
	} 

	public static final class listSetterNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node propertyName;
		private Node statementName;

	private enum Parameters {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels  {
		}

		private listSetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_listSetter.name());
			node.addAttribute("ui.label", "listSetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_listSetter);
		}

		private listSetterNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			listSetterNode that = (listSetterNode) o;
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

	   // propertyName
	   public listSetterNode setPropertyName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("propertyName_" + UUID.randomUUID(), this.node, target);
	   	this.propertyName = node;
	   	return this;
	   }

	   public Node getPropertyName() {
	   	if (this.propertyName != null) return this.propertyName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("propertyName_" + uuid)) {
	   			this.propertyName = edge.getOpposite(this.node);
	   			return this.propertyName;
	   		}
	   	}

	   	return null;
	   }

	   public void removePropertyName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // statementName
	   public listSetterNode setStatementName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("statementName_" + UUID.randomUUID(), this.node, target);
	   	this.statementName = node;
	   	return this;
	   }

	   public Node getStatementName() {
	   	if (this.statementName != null) return this.statementName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("statementName_" + uuid)) {
	   			this.statementName = edge.getOpposite(this.node);
	   			return this.statementName;
	   		}
	   	}

	   	return null;
	   }

	   public void removeStatementName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 
	} 

	public static final class newInstanceNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node groupName;
		private Node name;

	private enum Parameters {
			groupName_param, name_param
		}


		private enum KeyValueLabels  {
		}

		private newInstanceNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_newInstance.name());
			node.addAttribute("ui.label", "newInstance");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_newInstance);
		}

		private newInstanceNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			newInstanceNode that = (newInstanceNode) o;
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

	   // groupName
	   public newInstanceNode setGroupName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("groupName_" + UUID.randomUUID(), this.node, target);
	   	this.groupName = node;
	   	return this;
	   }

	   public Node getGroupName() {
	   	if (this.groupName != null) return this.groupName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("groupName_" + uuid)) {
	   			this.groupName = edge.getOpposite(this.node);
	   			return this.groupName;
	   		}
	   	}

	   	return null;
	   }

	   public void removeGroupName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public newInstanceNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.name = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.name != null) return this.name;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.name = edge.getOpposite(this.node);
	   			return this.name;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 
	} 

	public static final class stringSetterNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node propertyName;
		private Node statementName;

	private enum Parameters {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels  {
		}

		private stringSetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesNeo_stringSetter.name());
			node.addAttribute("ui.label", "stringSetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesNeo_stringSetter);
		}

		private stringSetterNode(final Graph graph, final Node node) {
			debugNode(node);
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(node.getAttribute("uuid"));
		}
	/*
		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	
	*/
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
			stringSetterNode that = (stringSetterNode) o;
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

	   // propertyName
	   public stringSetterNode setPropertyName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("propertyName_" + UUID.randomUUID(), this.node, target);
	   	this.propertyName = node;
	   	return this;
	   }

	   public Node getPropertyName() {
	   	if (this.propertyName != null) return this.propertyName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("propertyName_" + uuid)) {
	   			this.propertyName = edge.getOpposite(this.node);
	   			return this.propertyName;
	   		}
	   	}

	   	return null;
	   }

	   public void removePropertyName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("propertyName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // statementName
	   public stringSetterNode setStatementName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("statementName_" + UUID.randomUUID(), this.node, target);
	   	this.statementName = node;
	   	return this;
	   }

	   public Node getStatementName() {
	   	if (this.statementName != null) return this.statementName;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("statementName_" + uuid)) {
	   			this.statementName = edge.getOpposite(this.node);
	   			return this.statementName;
	   		}
	   	}

	   	return null;
	   }

	   public void removeStatementName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("statementName_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 
	} 

	public interface StringNode {

		public StringNode setValue(String value);

		public String getValue();

		public Node node();

		public UUID getUuid();
	}

	public static boolean isStringNode(Node node) {
		return node != null && StringNode.name().equals(node.getAttribute(Label.name()));
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final UUID uuid = UUID.randomUUID();
		final Node node = graph.addNode(uuid.toString());
		node.setAttribute("uuid", uuid.toString());
		node.setAttribute(Label.name(), StringNode);
		node.addAttribute("ui.class", StringNode.name());
		node.addAttribute("ui.label", value);

		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node==null) throw new IllegalArgumentException("node for newStringNode cannot be null");

		final UUID uuid = UUID.fromString(node.getAttribute("uuid"));

		return new StringNode() {
			@Override
			public StringNode setValue(String value) {
				node.setAttribute(Value.name(), value);
				return this;
			}

			@Override
			public String getValue() {
				return node.getAttribute(Value.name());
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

	private static void debugNode(Node node) {
		for (String attribute : node.getAttributeKeySet()) {
			System.out.println(attribute + " : " + node.getAttribute(attribute));
		}
	}
} 