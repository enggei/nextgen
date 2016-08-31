package com.generator.generators.templatesSwing;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.generators.templatesSwing.TemplatesSwingGraphStream.Attributes.*;
import static com.generator.generators.templatesSwing.TemplatesSwingGraphStream.TemplatesSwingGraphStreamLabels.*;

/**
 * Wraps GraphStream methods based on 'TemplatesSwing.stg' file <br/>
 * 
 */
public final class TemplatesSwingGraphStream {

	private final Graph graph;

	public enum TemplatesSwingGraphStreamLabels {
		TemplatesSwingGraphStreamLabels,   	
		TemplatesSwing_TemplatesSwing,
		TemplatesSwing_addVerticleAction,
		TemplatesSwing_bugfix,
		TemplatesSwing_newAction,
		TemplatesSwing_stringPropertyEditor,
		StringNode
	}

	public enum Attributes {
		Label, Value
	}

   public TemplatesSwingGraphStream(final Graph graph) {
 		this.graph = graph;

		graph.addAttribute("ui.stylesheet", "" +
			"graph { fill-color: rgb(245,245,245); } " +
			"edge { fill-color: grey; }" +
			"node:clicked { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node:selected { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node.StringNode { text-background-mode: plain; text-background-color: rgb(245,245,245); stroke-color: rgb(53, 151, 143); } " +
			"node.TemplatesSwing_TemplatesSwing { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesSwing_addVerticleAction { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesSwing_bugfix { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesSwing_newAction { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplatesSwing_stringPropertyEditor { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } ");
	}

   public static boolean isTemplatesSwing(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_TemplatesSwing.name());
   }

   public TemplatesSwingNode newTemplatesSwing() {
   	return new TemplatesSwingNode(graph);
   }

   public TemplatesSwingNode newTemplatesSwing(Node node) {
   	return new TemplatesSwingNode(graph, node);
   }

   /*
   todo:
   public void forEachTemplatesSwingNodes(Consumer<TemplatesSwingNode> consumer) {
   	graph.findNodes(TemplatesSwing_TemplatesSwing).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new TemplatesSwingNode(graph, node));
   			}
   		});
   }

   public void visitTemplatesSwingNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_TemplatesSwing).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isAddVerticleAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_addVerticleAction.name());
   }

   public addVerticleActionNode newAddVerticleAction() {
   	return new addVerticleActionNode(graph);
   }

   public addVerticleActionNode newAddVerticleAction(Node node) {
   	return new addVerticleActionNode(graph, node);
   }

   /*
   todo:
   public void forEachAddVerticleActionNodes(Consumer<addVerticleActionNode> consumer) {
   	graph.findNodes(TemplatesSwing_addVerticleAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new addVerticleActionNode(graph, node));
   			}
   		});
   }

   public void visitAddVerticleActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_addVerticleAction).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_bugfix.name());
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public bugfixNode newBugfix(Node node) {
   	return new bugfixNode(graph, node);
   }

   /*
   todo:
   public void forEachBugfixNodes(Consumer<bugfixNode> consumer) {
   	graph.findNodes(TemplatesSwing_bugfix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfixNode(graph, node));
   			}
   		});
   }

   public void visitBugfixNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_bugfix).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isNewAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_newAction.name());
   }

   public newActionNode newNewAction() {
   	return new newActionNode(graph);
   }

   public newActionNode newNewAction(Node node) {
   	return new newActionNode(graph, node);
   }

   /*
   todo:
   public void forEachNewActionNodes(Consumer<newActionNode> consumer) {
   	graph.findNodes(TemplatesSwing_newAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newActionNode(graph, node));
   			}
   		});
   }

   public void visitNewActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_newAction).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isStringPropertyEditor(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_stringPropertyEditor.name());
   }

   public stringPropertyEditorNode newStringPropertyEditor() {
   	return new stringPropertyEditorNode(graph);
   }

   public stringPropertyEditorNode newStringPropertyEditor(Node node) {
   	return new stringPropertyEditorNode(graph, node);
   }

   /*
   todo:
   public void forEachStringPropertyEditorNodes(Consumer<stringPropertyEditorNode> consumer) {
   	graph.findNodes(TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringPropertyEditorNode(graph, node));
   			}
   		});
   }

   public void visitStringPropertyEditorNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(consumer);
   }
   */ 

	public static final class TemplatesSwingNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		
		private Node groupNameNode;
		private Node packageNameNode;
		private Node statementsNode;

		private enum Parameters {
			groupName_param, packageName_param, statements_param
		}

		private enum StatementsRelationships {
			name, newAction
		} 

		private enum KeyValueLabels  {
			Statements, 
		}

		private TemplatesSwingNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesSwing_TemplatesSwing.name());
			node.addAttribute("ui.label", "TemplatesSwing");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesSwing_TemplatesSwing);
		}

		private TemplatesSwingNode(final Graph graph, final Node node) {
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
			TemplatesSwingNode that = (TemplatesSwingNode) o;
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
	   public TemplatesSwingNode setGroupName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("groupName_" + UUID.randomUUID(), this.node, target);
	   	this.groupNameNode = node;
	   	return this;
	   }

	   public Node getGroupName() {
	   	if (this.groupNameNode != null) return this.groupNameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("groupName_" + uuid)) {
	   			this.groupNameNode = edge.getOpposite(this.node);
	   			return this.groupNameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeGroupName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.groupNameNode = null;
	     			break;
	   		}
	   	}
	   } 

	   // packageName
	   public TemplatesSwingNode setPackageName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("packageName_" + UUID.randomUUID(), this.node, target);
	   	this.packageNameNode = node;
	   	return this;
	   }

	   public Node getPackageName() {
	   	if (this.packageNameNode != null) return this.packageNameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("packageName_" + uuid)) {
	   			this.packageNameNode = edge.getOpposite(this.node);
	   			return this.packageNameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removePackageName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.packageNameNode = null;
	     			break;
	   		}
	   	}
	   } 

	   public interface StatementsKeyValue {

	   	public Node getNameValue();

	   	public Node getNewActionValue();

	   	public StatementsKeyValue setNameValue(Node value);

	   	public StatementsKeyValue setNewActionValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplatesSwingNode addStatementsValue(StatementsKeyValue target) {
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
	   		public Node getNewActionValue() {
	   			for (Edge edge : node)
	   		  		if (edge.getId().startsWith("newAction_" + uuid)) 
	   		  			return edge.getOpposite(node);
	   			return null;
	   		 } 

	   		@Override
	   		public StatementsKeyValue setNewActionValue(Node target) {
	   			for (Edge edge : node) 
	   				if (edge.getId().startsWith("newAction_" + uuid)) { 
	   					graph.removeEdge(edge);
	   					break;
	   				 } 

	   			if (target==null) return this;

	   			graph.addEdge("newAction_" + UUID.randomUUID(), node, target);
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

	public static final class addVerticleActionNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		
		private Node nameNode;
		private Node packageNameNode;

		private enum Parameters {
			name_param, packageName_param
		}


		private enum KeyValueLabels  {
		}

		private addVerticleActionNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesSwing_addVerticleAction.name());
			node.addAttribute("ui.label", "addVerticleAction");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesSwing_addVerticleAction);
		}

		private addVerticleActionNode(final Graph graph, final Node node) {
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
			addVerticleActionNode that = (addVerticleActionNode) o;
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
	   public addVerticleActionNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.nameNode = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.nameNode != null) return this.nameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.nameNode = edge.getOpposite(this.node);
	   			return this.nameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.nameNode = null;
	     			break;
	   		}
	   	}
	   } 

	   // packageName
	   public addVerticleActionNode setPackageName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("packageName_" + UUID.randomUUID(), this.node, target);
	   	this.packageNameNode = node;
	   	return this;
	   }

	   public Node getPackageName() {
	   	if (this.packageNameNode != null) return this.packageNameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("packageName_" + uuid)) {
	   			this.packageNameNode = edge.getOpposite(this.node);
	   			return this.packageNameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removePackageName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("packageName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.packageNameNode = null;
	     			break;
	   		}
	   	}
	   } 
	} 

	public static final class bugfixNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		private bugfixNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesSwing_bugfix.name());
			node.addAttribute("ui.label", "bugfix");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesSwing_bugfix);
		}

		private bugfixNode(final Graph graph, final Node node) {
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
			bugfixNode that = (bugfixNode) o;
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

	public static final class newActionNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		
		private Node groupNameNode;
		private Node nameNode;

		private enum Parameters {
			groupName_param, name_param
		}


		private enum KeyValueLabels  {
		}

		private newActionNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesSwing_newAction.name());
			node.addAttribute("ui.label", "newAction");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesSwing_newAction);
		}

		private newActionNode(final Graph graph, final Node node) {
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
			newActionNode that = (newActionNode) o;
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
	   public newActionNode setGroupName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("groupName_" + UUID.randomUUID(), this.node, target);
	   	this.groupNameNode = node;
	   	return this;
	   }

	   public Node getGroupName() {
	   	if (this.groupNameNode != null) return this.groupNameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("groupName_" + uuid)) {
	   			this.groupNameNode = edge.getOpposite(this.node);
	   			return this.groupNameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeGroupName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.groupNameNode = null;
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public newActionNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.nameNode = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.nameNode != null) return this.nameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.nameNode = edge.getOpposite(this.node);
	   			return this.nameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.nameNode = null;
	     			break;
	   		}
	   	}
	   } 
	} 

	public static final class stringPropertyEditorNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		
		private Node groupNameNode;
		private Node nameNode;

		private enum Parameters {
			groupName_param, name_param
		}


		private enum KeyValueLabels  {
		}

		private stringPropertyEditorNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplatesSwing_stringPropertyEditor.name());
			node.addAttribute("ui.label", "stringPropertyEditor");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplatesSwing_stringPropertyEditor);
		}

		private stringPropertyEditorNode(final Graph graph, final Node node) {
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
			stringPropertyEditorNode that = (stringPropertyEditorNode) o;
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
	   public stringPropertyEditorNode setGroupName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("groupName_" + UUID.randomUUID(), this.node, target);
	   	this.groupNameNode = node;
	   	return this;
	   }

	   public Node getGroupName() {
	   	if (this.groupNameNode != null) return this.groupNameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("groupName_" + uuid)) {
	   			this.groupNameNode = edge.getOpposite(this.node);
	   			return this.groupNameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeGroupName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("groupName_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.groupNameNode = null;
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public stringPropertyEditorNode setName(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("name_" + UUID.randomUUID(), this.node, target);
	   	this.nameNode = node;
	   	return this;
	   }

	   public Node getName() {
	   	if (this.nameNode != null) return this.nameNode;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("name_" + uuid)) {
	   			this.nameNode = edge.getOpposite(this.node);
	   			return this.nameNode;
	   		}
	   	}

	   	return null;
	   }

	   public void removeName() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("name_" + uuid)) {
	   			graph.removeEdge(edge);
	   			this.nameNode = null;
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