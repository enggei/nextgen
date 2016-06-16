package com.generator.editors.graph.d2;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Node;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * goe on 10/10/14.
 * <p>
 * 2D representation of a GraphNode
 */
public class GraphNode2D<E extends Enum<E>> extends GraphNode<E> {

	protected int squareX = Integer.MIN_VALUE;
	protected int squareY = Integer.MIN_VALUE;
	protected int squareW = 0;
	protected int squareH = 0;
	protected Color bg = new Color(255, 255, 255);
	protected Color selBg = new Color(0, 0, 0);
	protected Color lblColor = new Color(0, 0, 0);
	protected Color sellblColor = new Color(255, 255, 255);
	protected String label = null;
	protected boolean pinned = false;

	public GraphNode2D(Node node, MetaNode metaNode, int squareX, int squareY, int squareW, int squareH, Color bg, Color selBg, Color lblColor, Color sellblColor, String label, boolean pinned) {
		super(node, metaNode);
		this.squareX = squareX;
		this.squareY = squareY;
		this.squareW = squareW;
		this.squareH = squareH;
		this.bg = bg;
		this.selBg = selBg;
		this.lblColor = lblColor;
		this.sellblColor = sellblColor;
		this.label = label;
		this.pinned = pinned;
	}

	public GraphNode2D(Node node, MetaNode<E> metaNode) {
		super(node, metaNode);
		setLabel(NeoModel.getNameOrLabelFrom(node));
	}

	@Override
	public void updated(String property, String value) {
		if ("name".equals(property)) setLabel(value);
	}

	// renders to a 2D graphics plane
	public Shape paint(Graphics2D g, int width, int height, boolean selected, boolean isTarget) {

		if (squareX + squareW < 0 || squareX > width) return new Rectangle(squareX, squareY, 0, 0);
		if (squareY + squareH < 0 || squareY > height) return new Rectangle(squareX, squareY, 0, 0);

		final int stringWidth = g.getFontMetrics().stringWidth(label);
		if (squareW != stringWidth) squareW = stringWidth + 4;

		final int stringHeight = g.getFontMetrics().getHeight();
		if (squareH != stringHeight) squareH = stringHeight;

		g.setColor(selected ? selBg : bg);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(selected ? (isTarget ? Color.RED : bg) : (isTarget ? Color.RED : Color.BLACK));
		g.drawRect(squareX, squareY, squareW, squareH);

		if (label != null) {
			g.setColor(selected ? sellblColor : lblColor);
			g.drawString(label, centerX() - (int) (stringWidth / 2d), squareY + stringHeight - 2);
		}

		return new Rectangle(squareX, squareY, squareW, squareH);
	}

	public int centerX() {
		return (int) (squareX + (squareW / 2d));
	}

	public int centerY() {
		return (int) (squareY + (squareH / 2d));
	}

	public boolean contains(MouseEvent e) {
		return e.getX() >= squareX && e.getX() <= (squareX + squareW) && e.getY() >= squareY && e.getY() <= (squareY + squareH);
	}

	public GraphNode2D setCenterX(int x) {
		if (pinned) return this;
		this.squareX = x - (squareW / 2);
		return this;
	}

	public GraphNode2D setCenterY(int y) {
		if (pinned) return this;
		this.squareY = y - (squareH / 2);
		return this;
	}

	public GraphNode2D setWidth(int width) {
		this.squareW = width;
		return this;
	}

	public int width() {
		return this.squareW;
	}

	public GraphNode2D setHeight(int height) {
		this.squareH = height;
		return this;
	}

	public int height() {
		return this.squareH;
	}

	public GraphNode2D move(int deltaX, int deltaY) {
		if (pinned) return this;

		this.squareX += deltaX;
		this.squareY += deltaY;
		return this;
	}


	public GraphNode2D setLabel(String label) {
		this.label = label == null || label.length() == 0 ? "[]" : label;
		return this;
	}

	public String getLabel() {
		return label;
	}

	public GraphNode2D pin(boolean pin) {
		this.pinned = pin;
		return this;
	}

	@Override
	public String toString() {
		return (incoming.size() + " -> " + getLabel() + "(" + uuid + ")" + " -> " + outgoing.size());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GraphNode2D graphNode = (GraphNode2D) o;

		return !(uuid != null ? !uuid.equals(graphNode.uuid) : graphNode.uuid != null);
	}

	@Override
	public int hashCode() {
		return uuid != null ? uuid.hashCode() : 0;
	}
}