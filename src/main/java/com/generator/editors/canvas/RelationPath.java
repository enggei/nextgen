package com.generator.editors.canvas;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * goe on 11/16/16.
 */
public class RelationPath<S extends BasePNode, T extends BasePNode> implements PropertyChangeListener, Comparable<RelationPath<S, T>> {

	final UUID uuid;
	public final S source;
	public final T target;
	final PPath path;

	PText pText;
	protected final AtomicBoolean showLabel = new AtomicBoolean(false);
	private final String label;
	final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	static final String RELATION_REMOVED = "relationRemoved";

	public RelationPath(UUID uuid, S source, T target, String label) {
		this.uuid = uuid;
		this.source = source;
		this.target = target;

		this.label = label;

		final Point2D src = source.pNode.getFullBoundsReference().getCenter2D();
		final Point2D dst = target.pNode.getFullBoundsReference().getCenter2D();
		this.path = PPath.createCubicCurve(src.getX(), src.getY(), (src.getX() - dst.getX()), (src.getY() - dst.getY()), (dst.getX() - src.getX()), (dst.getY() - src.getY()), dst.getX(), dst.getY());
		this.path.setPaint(Color.LIGHT_GRAY);

		source.pNode.addPropertyChangeListener(this);
		target.pNode.addPropertyChangeListener(this);

		updatePath(source, target);
	}

	public UUID uuid() {
		return uuid;
	}

	public PPath path() {
		return path;
	}

	public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		changeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		changeSupport.removePropertyChangeListener(propertyChangeListener);
	}

	private void updatePath(S source, T target) {

		final PBounds src = source.pNode.getFullBoundsReference();
		final PBounds dst = target.pNode.getFullBoundsReference();

		updateLink(src, dst);

		if (pText != null) pText.setOffset(path.getBounds().getCenter2D());
	}

	public void updateLink(Rectangle2D.Double src, Rectangle2D.Double dst) {

		final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());
		final Point2D.Double startRightCenter = p(src.getMaxX(), src.getCenterY());
		final Point2D.Double endRightCenter = p(dst.getMinX(), dst.getCenterY());

		final Point2D.Double startLeftCenter = p(src.getMinX(), src.getCenterY());
		final Point2D.Double endLeftCenter = p(dst.getMaxX(), dst.getCenterY());

		final Point2D.Double startCenterBottom = p(src.getCenterX(), src.getMaxY());
		final Point2D.Double endCenterTop = p(dst.getCenterX(), dst.getMinY());

		final Point2D.Double startCenterTop = p(src.getCenterX(), src.getMinY());
		final Point2D.Double endCenterBottom = p(dst.getCenterX(), dst.getMaxY());

		if (src.getCenterX() < dst.getCenterX()) {
			if (src.getCenterY() < dst.getCenterY()) {
				// top-left
				if (!horizontalOverlap) {
					drawPath(startRightCenter, null, null, endRightCenter);
				} else {
					drawPath(startCenterBottom,  null, null, endCenterTop);
				}
			} else {
				// bottom-left
				if (!horizontalOverlap) {
					drawPath(startRightCenter, null, null, endRightCenter);
				} else {
					drawPath(startCenterTop,  null, null, endCenterBottom);
				}
			}

		} else {
			if (src.getCenterY() < dst.getCenterY()) {
				// top-right
				if (!horizontalOverlap) {
					drawPath(startLeftCenter, null, null, endLeftCenter);
				} else {
					drawPath(startCenterBottom,  null, null, endCenterTop);
				}
			} else {
				// bottom-right
				if (!horizontalOverlap) {
					drawPath(startLeftCenter, null, null, endLeftCenter);
				} else {
					drawPath(startCenterTop,  null, null, endCenterBottom);
				}
			}
		}
	}

	private static Point2D.Double p(double x, double y) {
		return new Point2D.Double(x, y);
	}

	private void drawPath(Point2D start, Point2D ctr1, Point2D ctr2, Point2D end) {
		path.reset();
		path.moveTo(start.getX(), start.getY());

		if (ctr1 != null) {
			path.lineTo(ctr1.getX(), ctr1.getY());
			path.moveTo(ctr1.getX(), ctr1.getY());
		}

		if (ctr2 != null) {
			path.lineTo(ctr2.getX(), ctr2.getY());
			path.moveTo(ctr2.getX(), ctr2.getY());
		}

		path.lineTo(end.getX(), end.getY());

		final int ARR_SIZE = 4;
		final double dx = end.getX() - start.getX();
		final double dy = end.getY() - start.getY();
		final double angle = Math.atan2(dy, dx);
		final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
		final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());

		at.concatenate(AffineTransform.getRotateInstance(angle));
//		path.transformBy(at);
		path.append(new Polygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4).getPathIterator(at),false);
//		path.drawLine(0, 0, len, 0);

	}

	public final void showLabel() {
		if (showLabel.get()) return;
		showLabel.set(true);

		pText = new PText(label);
		pText.setOffset(this.path.getFullBounds().getCenter2D());
		path.addChild(this.pText);
	}

	public final void hideLabel() {
		if (!showLabel.get()) return;
		showLabel.set(false);
		path.removeChild(pText);
	}

	void removePath() {
		source.removePropertyChangeListener(this);
		target.removePropertyChangeListener(this);
		changeSupport.firePropertyChange(RELATION_REMOVED, true, false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		switch (evt.getPropertyName()) {

			case PNode.PROPERTY_FULL_BOUNDS:
				SwingUtilities.invokeLater(() -> updatePath(source, target));
				break;

			case PNode.PROPERTY_PARENT:
				if (evt.getOldValue() != null) SwingUtilities.invokeLater(this::removePath);
				break;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("gc.relation.uuid = " + uuid);
		super.finalize();
	}

	@Override
	public int compareTo(RelationPath<S, T> o) {
		return this.uuid.compareTo(o.uuid);
	}

}