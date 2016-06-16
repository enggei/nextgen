package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.generators.cypher.CypherGroup;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * goe on 3/4/15.
 * exports all outgoing ?
 */
public class ExportCypher<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E, R, G>> extends GraphEditorAction<E, R, G, D> {

	private final CypherGroup cypherGroup;
	final Set<Node> rootNodes = new LinkedHashSet<>();

	public ExportCypher(D editor) {
		super("Export", editor);

		cypherGroup = new CypherGroup();

		final MetaNode<E> rootNode = editor.getDomain().getRootNode();
		rootNodes.addAll(editor.getModel().getAll(rootNode.getLabel().name()));
	}

	public ExportCypher(D editor, final Set<Node> rootNodes) {
		super("Export", editor);

		cypherGroup = new CypherGroup();

		this.rootNodes.addAll(rootNodes);
	}

	@Override
	public void doAction(Transaction tx) {

		final CypherGroup.createNodesST createNodesST = cypherGroup.newcreateNodes();

		final LinkedHashSet<Relationship> relationships = new LinkedHashSet<>();
		for (Node node : rootNodes) {
			exportNode(createNodesST, cypherGroup, node, new LinkedHashSet<Node>(), relationships);
		}

		// add relations at end, using node-uuids:
		final CypherGroup.createRelationshipsST createRelationshipsST = cypherGroup.newcreateRelationships();
		for (Relationship relationship : relationships) {
			final CypherGroup.createRelationshipST createRelationshipST = cypherGroup.newcreateRelationship().
				setSrc(relationship.getStartNode().getProperty(NeoModel.TAG_UUID)).
				setType(relationship.getType().name()).
				setDst(relationship.getEndNode().getProperty(NeoModel.TAG_UUID));

			for (String key : relationship.getPropertyKeys()) {
				createRelationshipST.addPropertiesValue(cypherGroup.newstringProperty().setName(key).setValue(relationship.getProperty(key)));
			}

			createRelationshipsST.addRelationshipsValue(createRelationshipST.toString());
		}

		editor.disableKeyEvents();
		SwingUtil.showTextResult("Export", createNodesST + "\n" + createRelationshipsST, editor);
		editor.disableKeyEvents();
	}

	// todo consider creating a clone version of this
	public static void exportNode(CypherGroup.createNodesST export, CypherGroup neoGroup, Node node, Set<Node> visitedNodes, Set<Relationship> relationships) {

		if (visitedNodes.contains(node)) return;
		visitedNodes.add(node);

		final CypherGroup.createNodeST createNodeST = neoGroup.newcreateNode().
			setId(node.getProperty(NeoModel.TAG_UUID));
		for (Label label : node.getLabels()) createNodeST.addLabelsValue(label);

		for (String key : node.getPropertyKeys())
			createNodeST.addPropertiesValue(neoGroup.newstringProperty().setName(key).setValue(node.getProperty(key)));
		export.addNodesValue(createNodeST.toString());

		final Set<Node> unvisitedNodes = new LinkedHashSet<>();
		for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
			if (relationships.contains(relationship)) continue;
			relationships.add(relationship);

			final Node endNode = relationship.getEndNode();
			if (!visitedNodes.contains(endNode)) unvisitedNodes.add(endNode);
		}

		for (Node unvisitedNode : unvisitedNodes) {
			if (visitedNodes.contains(unvisitedNode)) continue;
			exportNode(export, neoGroup, unvisitedNode, visitedNodes, relationships);
		}
	}
}
