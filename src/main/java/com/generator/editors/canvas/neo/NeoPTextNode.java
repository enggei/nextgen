package com.generator.editors.canvas.neo;

import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.piccolo2d.nodes.PText;

import java.awt.*;
import java.awt.geom.Point2D;

import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.uuidOf;

/**
 * goe on 11/16/16.
 */
public class NeoPTextNode extends NeoPNode<PText> {

	public NeoPTextNode(Node node, NeoEditor editor) {
		super(node, new PText(NeoModel.getNameOrLabelFrom(node)), "Text", editor);
	}

	public NeoPTextNode(Node node, String value, NeoEditor editor) {
		super(node, new PText(value), "Text", editor);
	}

	@Override
	public void expand() {

		final Point2D centerPosition = getCenterPosition();
		double currentX = centerPosition.getX() + pNode.getWidth() + 10;
		double currentY = centerPosition.getY() + (pNode.getHeight() / 2) + 10;

		for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {

			final Node otherNode = other(node, relationship);

			// no need to expand a node to itself (if relationship is to self)
			if (NeoModel.uuidOf(node).equals(NeoModel.uuidOf(otherNode))) return;

			final NeoPNode otherPNode = (NeoPNode) editor.show(uuidOf(otherNode), null).setOffset(new Point2D.Double(currentX, currentY));
			currentY += otherPNode.pNode.getHeight();
		}
	}

	@Override
	public void showDependents() {

	}

	@Override
	public void updateView() {
		pNode.setText(NeoModel.getNameOrLabelFrom(node));
	}

	@Override
	public void onSelect() {
		pNode.setTextPaint(Color.RED);
	}

	@Override
	public void onUnselect() {
		pNode.setTextPaint(Color.BLACK);
	}

	@Override
	public void onStartHighlight() {
		pNode.setTextPaint(Color.ORANGE);
	}

	@Override
	public void onEndHighlight() {
		pNode.setTextPaint(selected.get() ? Color.RED : Color.BLACK);
	}
}