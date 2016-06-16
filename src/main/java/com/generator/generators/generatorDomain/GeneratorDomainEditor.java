package com.generator.generators.generatorDomain;


import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaRelation;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.editors.graph.d2.ShortestPathGraphRelation;
import com.generator.generators.knockout.KnockoutGroup;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Meta-domain to describe meta-domain
 */
public class GeneratorDomainEditor extends GraphEditor2D<GeneratorDomain.ENTITIES, GeneratorDomain.RELATIONS, GraphNode2D<GeneratorDomain.ENTITIES>> {

	public GeneratorDomainEditor(MetaDomain<GeneratorDomain.ENTITIES, GeneratorDomain.RELATIONS> domain) {
		super(domain);
	}

	@Override
	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newGraphRelation(MetaRelation<GeneratorDomain.ENTITIES, GeneratorDomain.RELATIONS> metaRelation, Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {

		if (metaRelation == null) return null;

		switch (GeneratorDomain.RELATIONS.valueOf(metaRelation.getName().name())) {
			case CONSTRAINT:
				return newCONSTRAINTRelation(relationship, source, target);
			case FEATURE:
				return newFEATURERelation(relationship, source, target);
			case TERM:
				return newTERMRelation(relationship, source, target);
			case SOURCES:
				return newSOURCESRelation(relationship, source, target);
			case DESTINATIONS:
				return newDESTINATIONSRelation(relationship, source, target);
			case STATEMENTS:
				return newSTATEMENTSRelation(relationship, source, target);
			case PARAMETERS:
				return newPARAMETERSRelation(relationship, source, target);
			case STGROUP:
				return newSTGROUPRelation(relationship, source, target);

			default:
				return null;
		}
	}

	@Override
	protected GraphNode2D<GeneratorDomain.ENTITIES> newGraphNodeFor(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node) {

		if (metaNode == null) return null;

		final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
		final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

		switch (metaNode.getLabel()) {
			case ENTITY:
				return newENTITYGraphNode(metaNode, node, x, y);
			case DOMAIN:
				return newDOMAINGraphNode(metaNode, node, x, y);
			case RELATION:
				return newRELATIONGraphNode(metaNode, node, x, y);
			case PROPERTY:
				return newPROPERTYGraphNode(metaNode, node, x, y);
			case STATEMENTPARAMETER:
				return newSTATEMENTPARAMETERGraphNode(metaNode, node, x, y);
			case TEMPLATEGROUP:
				return newTEMPLATEGROUPGraphNode(metaNode, node, x, y);
			case STATEMENT:
				return newSTATEMENTGraphNode(metaNode, node, x, y);

			default:
				return null;
		}
	}

	@Override
	public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
		super.rightClickSelect(mouseEvent, popupMenu, targetNode);

		final MetaNode<GeneratorDomain.ENTITIES> metaNode = targetNode.getMetaNode();
		if (metaNode == null) return;   // targetNode not recognized by GeneratorDomain

		switch (metaNode.getLabel()) {
			case ENTITY:
				rightClickENTITY(mouseEvent, popupMenu, targetNode);
				break;
			case DOMAIN:
				rightClickDOMAIN(mouseEvent, popupMenu, targetNode);
				break;
			case RELATION:
				rightClickRELATION(mouseEvent, popupMenu, targetNode);
				break;
			case PROPERTY:
				rightClickPROPERTY(mouseEvent, popupMenu, targetNode);
				break;
			case STATEMENTPARAMETER:
				rightClickSTATEMENTPARAMETER(mouseEvent, popupMenu, targetNode);
				break;
			case TEMPLATEGROUP:
				rightClickTEMPLATEGROUP(mouseEvent, popupMenu, targetNode);
				break;
			case STATEMENT:
				rightClickSTATEMENT(mouseEvent, popupMenu, targetNode);
				break;
		}
	}

	protected void rightClickENTITY(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {

		popupMenu.add(new GraphEditorAction("Knockout", this) {
			@Override
			public void doAction(Transaction tx) throws Throwable {
				domain.commit(new MetaDomain.Committer() {
					@Override
					public void doAction(Transaction tx) throws Throwable {
						final Node node = targetNode.node();

						final KnockoutGroup group = new KnockoutGroup();

						System.out.println(group.newobservable().
							setInit(node.getProperty("name")).
							setReference(node.getProperty("name")));

						System.out.println(group.newviewModel().
							setReference("reference").
							addObservablesValue(group.newobservable().setReference("obsOne")).
							addObservablesValue(group.newobservable().setReference("obsTwo"))
						);
					}

					@Override
					public void exception(Throwable throwable) {

					}
				});
			}
		});
	}

	protected void rightClickDOMAIN(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}

	protected void rightClickRELATION(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}

	protected void rightClickPROPERTY(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}

	protected void rightClickSTATEMENTPARAMETER(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}

	protected void rightClickTEMPLATEGROUP(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}

	protected void rightClickSTATEMENT(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {
	}


	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newCONSTRAINTRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newFEATURERelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newTERMRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newSOURCESRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newDESTINATIONSRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newSTATEMENTSRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newPARAMETERSRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newSTGROUPRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newENTITYGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 30, 20, Color.decode("#d53e4f"), Color.decode("#e6f598"), Color.decode("#000000"), Color.decode("#d53e4f"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newDOMAINGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 20, 30, Color.decode("#3288bd"), Color.decode("#e6f598"), Color.decode("#000000"), Color.decode("#fee08b"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newRELATIONGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 20, 30, Color.decode("#fc8d59"), Color.decode("#99d594"), Color.decode("#000000"), Color.decode("#fc8d59"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newPROPERTYGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 20, 30, Color.decode("#fc8d59"), Color.decode("#99d594"), Color.decode("#000000"), Color.decode("#fc8d59"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newSTATEMENTPARAMETERGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newTEMPLATEGROUPGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
	}

	protected GraphNode2D<GeneratorDomain.ENTITIES> newSTATEMENTGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
		return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
	}
}