package com.generator.generators.stardog;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain StardogDomainPlugin
 */
public abstract class StardogDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StardogDomainPlugin.class);

	public enum Entities implements Label {
      Database, Namespace, Graph
   }

   public enum Relations implements RelationshipType {
      DATABASE, NAMESPACE, GRAPH
   }

   public enum Properties {
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   StardogDomainPlugin(App app) {
      super(app, "Stardog");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Stardog");
		entitiesNodeMap.put(Entities.Database, DomainMotif.newDomainEntity(getGraph(), Entities.Database, domainNode));
		entitiesNodeMap.put(Entities.Namespace, DomainMotif.newDomainEntity(getGraph(), Entities.Namespace, domainNode));
		entitiesNodeMap.put(Entities.Graph, DomainMotif.newDomainEntity(getGraph(), Entities.Graph, domainNode));


		relate(domainNode, entitiesNodeMap.get(Entities.Database), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Database), Relations.NAMESPACE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Namespace));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Namespace), Relations.GRAPH.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Graph));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isDatabase(neoNode.getNode())) handleDatabase(pop, neoNode, selectedNodes);
		if (isNamespace(neoNode.getNode())) handleNamespace(pop, neoNode, selectedNodes);
		if (isGraph(neoNode.getNode())) handleGraph(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isDatabase(neoNode.getNode())) return newDatabaseEditor(neoNode);
		if (isNamespace(neoNode.getNode())) return newNamespaceEditor(neoNode);
		if (isGraph(neoNode.getNode())) return newGraphEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleDatabase(JPopupMenu pop, NeoNode databaseNode, Set<NeoNode> selectedNodes) { }
	protected void handleNamespace(JPopupMenu pop, NeoNode namespaceNode, Set<NeoNode> selectedNodes) { }
	protected void handleGraph(JPopupMenu pop, NeoNode graphNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newDatabaseEditor(NeoNode databaseNode) { return null; }
	protected JComponent newNamespaceEditor(NeoNode namespaceNode) { return null; }
	protected JComponent newGraphEditor(NeoNode graphNode) { return null; }

	public static boolean isDatabase(Node node) { return hasLabel(node, Entities.Database); }
	public static boolean isNamespace(Node node) { return hasLabel(node, Entities.Namespace); }
	public static boolean isGraph(Node node) { return hasLabel(node, Entities.Graph); }

	protected Node newDatabase() { return newDatabase(getGraph()); }
	public static Node newDatabase(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Database)); }

	protected Node newNamespace() { return newNamespace(getGraph()); }
	public static Node newNamespace(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Namespace)); }

	protected Node newGraph() { return newGraph(getGraph()); }
	public static Node newGraph(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Graph)); }


	public static void outgoingDATABASE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDATABASE(Node src) { return other(src, singleOutgoing(src, Relations.DATABASE)); }
	public static void incomingDATABASE(Node src, RelationConsumer consumer) { incoming(src, Relations.DATABASE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDATABASE(Node src) { return other(src, singleIncoming(src, Relations.DATABASE)); }

	public static void outgoingNAMESPACE(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAMESPACE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAMESPACE(Node src) { return other(src, singleOutgoing(src, Relations.NAMESPACE)); }
	public static void incomingNAMESPACE(Node src, RelationConsumer consumer) { incoming(src, Relations.NAMESPACE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAMESPACE(Node src) { return other(src, singleIncoming(src, Relations.NAMESPACE)); }

	public static void outgoingGRAPH(Node src, RelationConsumer consumer) { outgoing(src, Relations.GRAPH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGRAPH(Node src) { return other(src, singleOutgoing(src, Relations.GRAPH)); }
	public static void incomingGRAPH(Node src, RelationConsumer consumer) { incoming(src, Relations.GRAPH).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGRAPH(Node src) { return other(src, singleIncoming(src, Relations.GRAPH)); }


	public static Relationship relateDATABASE(Node src, Node dst) { return relate(src, dst, Relations.DATABASE); }
	public static Relationship relateNAMESPACE(Node src, Node dst) { return relate(src, dst, Relations.NAMESPACE); }
	public static Relationship relateGRAPH(Node src, Node dst) { return relate(src, dst, Relations.GRAPH); }

}