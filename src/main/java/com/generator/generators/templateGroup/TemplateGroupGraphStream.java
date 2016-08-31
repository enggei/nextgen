package com.generator.generators.templateGroup;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.generators.templateGroup.TemplateGroupGraphStream.Attributes.*;
import static com.generator.generators.templateGroup.TemplateGroupGraphStream.TemplateGroupGraphStreamLabels.*;

/**
 * Wraps GraphStream methods based on 'TemplateGroup.stg' file <br/>
 * 
 */
public final class TemplateGroupGraphStream {

	private final Graph graph;

	public enum TemplateGroupGraphStreamLabels {
		TemplateGroupGraphStreamLabels,   	
		TemplateGroup_AttributeRendererDeclaration,
		TemplateGroup_GroupClassDeclaration,
		TemplateGroup_NewGroupInstance,
		TemplateGroup_NewStatementDeclaration,
		TemplateGroup_NewStatementInstance,
		TemplateGroup_StatementKeyValueListPropertySetter,
		TemplateGroup_StatementListPropertySetter,
		TemplateGroup_StatementStringPropertySetter,
		TemplateGroup_bugfix,
		StringNode
	}

	public enum Attributes {
		Label, Value
	}

   public TemplateGroupGraphStream(final Graph graph) {
 		this.graph = graph;

		graph.addAttribute("ui.stylesheet", "" +
			"graph { fill-color: rgb(245,245,245); } " +
			"edge { fill-color: grey; }" +
			"node:clicked { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node:selected { fill-color: rgb(223, 194, 125); stroke-color: rgb(191, 129, 45); } " +
			"node.StringNode { text-background-mode: plain; text-background-color: rgb(245,245,245); stroke-color: rgb(53, 151, 143); } " +
			"node.TemplateGroup_AttributeRendererDeclaration { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_GroupClassDeclaration { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_NewGroupInstance { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_NewStatementDeclaration { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_NewStatementInstance { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_StatementKeyValueListPropertySetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_StatementListPropertySetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_StatementStringPropertySetter { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } " + 
			"node.TemplateGroup_bugfix { size: 20px, 25px; shape: box; text-background-mode: plain; text-background-color: rgb(245,245,245); fill-color: rgb(199, 234, 229); stroke-mode: plain; stroke-color: rgb(53, 151, 143); } ");
	}

   public static boolean isAttributeRendererDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_AttributeRendererDeclaration.name());
   }

   public AttributeRendererDeclarationNode newAttributeRendererDeclaration() {
   	return new AttributeRendererDeclarationNode(graph);
   }

   public AttributeRendererDeclarationNode newAttributeRendererDeclaration(Node node) {
   	return new AttributeRendererDeclarationNode(graph, node);
   }

   /*
   todo:
   public void forEachAttributeRendererDeclarationNodes(Consumer<AttributeRendererDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_AttributeRendererDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new AttributeRendererDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitAttributeRendererDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_AttributeRendererDeclaration).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_GroupClassDeclaration.name());
   }

   public GroupClassDeclarationNode newGroupClassDeclaration() {
   	return new GroupClassDeclarationNode(graph);
   }

   public GroupClassDeclarationNode newGroupClassDeclaration(Node node) {
   	return new GroupClassDeclarationNode(graph, node);
   }

   /*
   todo:
   public void forEachGroupClassDeclarationNodes(Consumer<GroupClassDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_GroupClassDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new GroupClassDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitGroupClassDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_GroupClassDeclaration).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isNewGroupInstance(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewGroupInstance.name());
   }

   public NewGroupInstanceNode newNewGroupInstance() {
   	return new NewGroupInstanceNode(graph);
   }

   public NewGroupInstanceNode newNewGroupInstance(Node node) {
   	return new NewGroupInstanceNode(graph, node);
   }

   /*
   todo:
   public void forEachNewGroupInstanceNodes(Consumer<NewGroupInstanceNode> consumer) {
   	graph.findNodes(TemplateGroup_NewGroupInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewGroupInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewGroupInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewGroupInstance).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isNewStatementDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewStatementDeclaration.name());
   }

   public NewStatementDeclarationNode newNewStatementDeclaration() {
   	return new NewStatementDeclarationNode(graph);
   }

   public NewStatementDeclarationNode newNewStatementDeclaration(Node node) {
   	return new NewStatementDeclarationNode(graph, node);
   }

   /*
   todo:
   public void forEachNewStatementDeclarationNodes(Consumer<NewStatementDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewStatementDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitNewStatementDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementDeclaration).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isNewStatementInstance(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewStatementInstance.name());
   }

   public NewStatementInstanceNode newNewStatementInstance() {
   	return new NewStatementInstanceNode(graph);
   }

   public NewStatementInstanceNode newNewStatementInstance(Node node) {
   	return new NewStatementInstanceNode(graph, node);
   }

   /*
   todo:
   public void forEachNewStatementInstanceNodes(Consumer<NewStatementInstanceNode> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewStatementInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewStatementInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementInstance).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isStatementKeyValueListPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementKeyValueListPropertySetter.name());
   }

   public StatementKeyValueListPropertySetterNode newStatementKeyValueListPropertySetter() {
   	return new StatementKeyValueListPropertySetterNode(graph);
   }

   public StatementKeyValueListPropertySetterNode newStatementKeyValueListPropertySetter(Node node) {
   	return new StatementKeyValueListPropertySetterNode(graph, node);
   }

   /*
   todo:
   public void forEachStatementKeyValueListPropertySetterNodes(Consumer<StatementKeyValueListPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementKeyValueListPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementKeyValueListPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementKeyValueListPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementKeyValueListPropertySetter).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isStatementListPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementListPropertySetter.name());
   }

   public StatementListPropertySetterNode newStatementListPropertySetter() {
   	return new StatementListPropertySetterNode(graph);
   }

   public StatementListPropertySetterNode newStatementListPropertySetter(Node node) {
   	return new StatementListPropertySetterNode(graph, node);
   }

   /*
   todo:
   public void forEachStatementListPropertySetterNodes(Consumer<StatementListPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementListPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementListPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementListPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementListPropertySetter).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isStatementStringPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementStringPropertySetter.name());
   }

   public StatementStringPropertySetterNode newStatementStringPropertySetter() {
   	return new StatementStringPropertySetterNode(graph);
   }

   public StatementStringPropertySetterNode newStatementStringPropertySetter(Node node) {
   	return new StatementStringPropertySetterNode(graph, node);
   }

   /*
   todo:
   public void forEachStatementStringPropertySetterNodes(Consumer<StatementStringPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementStringPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementStringPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementStringPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementStringPropertySetter).
   		forEachRemaining(consumer);
   }
   */ 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_bugfix.name());
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
   	graph.findNodes(TemplateGroup_bugfix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfixNode(graph, node));
   			}
   		});
   }

   public void visitBugfixNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_bugfix).
   		forEachRemaining(consumer);
   }
   */ 

	public static final class AttributeRendererDeclarationNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		private AttributeRendererDeclarationNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_AttributeRendererDeclaration.name());
			node.addAttribute("ui.label", "AttributeRendererDeclaration");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_AttributeRendererDeclaration);
		}

		private AttributeRendererDeclarationNode(final Graph graph, final Node node) {
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
			AttributeRendererDeclarationNode that = (AttributeRendererDeclarationNode) o;
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

	public static final class GroupClassDeclarationNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node domain;
		private Node name;
		private Node packageName;
		private Node statements;

	private enum Parameters {
			domain_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships {
			declaration, newInstance
		} 

		private enum KeyValueLabels  {
			Statements, 
		}

		private GroupClassDeclarationNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_GroupClassDeclaration.name());
			node.addAttribute("ui.label", "GroupClassDeclaration");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_GroupClassDeclaration);
		}

		private GroupClassDeclarationNode(final Graph graph, final Node node) {
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
			GroupClassDeclarationNode that = (GroupClassDeclarationNode) o;
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

	   // domain
	   public GroupClassDeclarationNode setDomain(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("domain_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("domain_" + UUID.randomUUID(), this.node, target);
	   	this.domain = node;
	   	return this;
	   }

	   public Node getDomain() {
	   	if (this.domain != null) return this.domain;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("domain_" + uuid)) {
	   			this.domain = edge.getOpposite(this.node);
	   			return this.domain;
	   		}
	   	}

	   	return null;
	   }

	   public void removeDomain() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("domain_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public GroupClassDeclarationNode setName(Node target) {
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
	   public GroupClassDeclarationNode setPackageName(Node target) {
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

	   	public Node getNewInstanceValue();

	   	public StatementsKeyValue setDeclarationValue(Node value);

	   	public StatementsKeyValue setNewInstanceValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public GroupClassDeclarationNode addStatementsValue(StatementsKeyValue target) {
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

	public static final class NewGroupInstanceNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node filename;
		private Node name;

	private enum Parameters {
			filename_param, name_param
		}


		private enum KeyValueLabels  {
		}

		private NewGroupInstanceNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_NewGroupInstance.name());
			node.addAttribute("ui.label", "NewGroupInstance");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_NewGroupInstance);
		}

		private NewGroupInstanceNode(final Graph graph, final Node node) {
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
			NewGroupInstanceNode that = (NewGroupInstanceNode) o;
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

	   // filename
	   public NewGroupInstanceNode setFilename(Node target) {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("filename_" + uuid)) {
	   			graph.removeEdge(edge);
	   			break;
	   		}
	   	}

	   	if (target==null) return this;

	   	graph.addEdge("filename_" + UUID.randomUUID(), this.node, target);
	   	this.filename = node;
	   	return this;
	   }

	   public Node getFilename() {
	   	if (this.filename != null) return this.filename;

	   	for (Edge edge : this.node) {
	   		if (edge.getId().startsWith("filename_" + uuid)) {
	   			this.filename = edge.getOpposite(this.node);
	   			return this.filename;
	   		}
	   	}

	   	return null;
	   }

	   public void removeFilename() {
	   	for (Edge edge : this.node) {
	   		if (edge.getId().equals("filename_" + uuid)) {
	   			graph.removeEdge(edge);
	     			break;
	   		}
	   	}
	   } 

	   // name
	   public NewGroupInstanceNode setName(Node target) {
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

	public static final class NewStatementDeclarationNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node name;
		private Node properties;

	private enum Parameters {
			name_param, properties_param
		}

		private enum PropertiesRelationships {
			name, setter
		} 

		private enum KeyValueLabels  {
			Properties, 
		}

		private NewStatementDeclarationNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_NewStatementDeclaration.name());
			node.addAttribute("ui.label", "NewStatementDeclaration");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_NewStatementDeclaration);
		}

		private NewStatementDeclarationNode(final Graph graph, final Node node) {
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
			NewStatementDeclarationNode that = (NewStatementDeclarationNode) o;
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
	   public NewStatementDeclarationNode setName(Node target) {
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

	   	public Node getSetterValue();

	   	public PropertiesKeyValue setNameValue(Node value);

	   	public PropertiesKeyValue setSetterValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public NewStatementDeclarationNode addPropertiesValue(PropertiesKeyValue target) {
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

	public static final class NewStatementInstanceNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		

		private Node name;

	private enum Parameters {
			name_param
		}


		private enum KeyValueLabels  {
		}

		private NewStatementInstanceNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_NewStatementInstance.name());
			node.addAttribute("ui.label", "NewStatementInstance");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_NewStatementInstance);
		}

		private NewStatementInstanceNode(final Graph graph, final Node node) {
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
			NewStatementInstanceNode that = (NewStatementInstanceNode) o;
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
	   public NewStatementInstanceNode setName(Node target) {
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

	public static final class StatementKeyValueListPropertySetterNode {

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

		private StatementKeyValueListPropertySetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_StatementKeyValueListPropertySetter.name());
			node.addAttribute("ui.label", "StatementKeyValueListPropertySetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_StatementKeyValueListPropertySetter);
		}

		private StatementKeyValueListPropertySetterNode(final Graph graph, final Node node) {
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
			StatementKeyValueListPropertySetterNode that = (StatementKeyValueListPropertySetterNode) o;
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
	   public StatementKeyValueListPropertySetterNode addKvNamesValue(Node target) {
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
	   public StatementKeyValueListPropertySetterNode setPropertyName(Node target) {
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
	   public StatementKeyValueListPropertySetterNode setStatementName(Node target) {
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

	public static final class StatementListPropertySetterNode {

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

		private StatementListPropertySetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_StatementListPropertySetter.name());
			node.addAttribute("ui.label", "StatementListPropertySetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_StatementListPropertySetter);
		}

		private StatementListPropertySetterNode(final Graph graph, final Node node) {
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
			StatementListPropertySetterNode that = (StatementListPropertySetterNode) o;
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
	   public StatementListPropertySetterNode setPropertyName(Node target) {
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
	   public StatementListPropertySetterNode setStatementName(Node target) {
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

	public static final class StatementStringPropertySetterNode {

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

		private StatementStringPropertySetterNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_StatementStringPropertySetter.name());
			node.addAttribute("ui.label", "StatementStringPropertySetter");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_StatementStringPropertySetter);
		}

		private StatementStringPropertySetterNode(final Graph graph, final Node node) {
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
			StatementStringPropertySetterNode that = (StatementStringPropertySetterNode) o;
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
	   public StatementStringPropertySetterNode setPropertyName(Node target) {
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
	   public StatementStringPropertySetterNode setStatementName(Node target) {
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

	public static final class bugfixNode {

		private final Graph graph;
		private final UUID uuid;
		private final Node node;
		private bugfixNode(final Graph graph) {
			this.graph = graph;
			this.uuid = UUID.randomUUID();
			this.node = graph.addNode(this.uuid.toString());
			node.addAttribute("ui.class", TemplateGroup_bugfix.name());
			node.addAttribute("ui.label", "bugfix");
			node.setAttribute("uuid", this.uuid);
			node.setAttribute(Label.name(), TemplateGroup_bugfix);
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