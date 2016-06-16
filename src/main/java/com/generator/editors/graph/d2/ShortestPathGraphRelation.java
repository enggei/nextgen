package com.generator.editors.graph.d2;

import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

/**
 * goe on 10/10/14.
 */
public class ShortestPathGraphRelation<E extends Enum<E>> extends GraphRelation<GraphNode2D<E>, GraphNode2D<E>, E> {

    public ShortestPathGraphRelation(Relationship relationship, GraphNode2D source, GraphNode2D target) {
        super(relationship, source, target);
        this.type = relationship.getType().name();
        this.label = relationship.hasProperty("name") ? relationship.getProperty("name").toString() : null;
        source.addOutgoing(this);
        target.addIncoming(this);
    }

    @Override
    public void paint(Graphics2D g1, boolean selected) {

        final GraphNode2D source = getSource();
        final GraphNode2D target = getTarget();
        final String type = label == null ? getType() : label;

        if (source.uuid().equals(target.uuid())) {
            Point2D.Double ctrl1 = new Point2D.Double(source.centerX() - 50, source.centerY());
            Point2D.Double ctrl2 = new Point2D.Double(source.centerX(), source.centerY() + 50);
            CubicCurve2D.Double cubicCurve = new CubicCurve2D.Double(source.centerX(), source.centerY(), ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, source.centerX(), source.centerY());

            g1.setColor(selected ? Color.RED : Color.BLACK);
            g1.draw(cubicCurve);
            g1.drawString(type, source.centerX() - 30, source.centerY() + 35);

        } else {

            final int ARR_SIZE = 4;
            final Graphics2D g = (Graphics2D) g1.create();
            final double dx = target.centerX() - source.centerX();
            final double dy = target.centerY() - source.centerY();
            final double angle = Math.atan2(dy, dx);
            final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 15);
            final AffineTransform at = AffineTransform.getTranslateInstance(source.centerX(), source.centerY());

            at.concatenate(AffineTransform.getRotateInstance(angle));
            g.transform(at);

            g.setColor(selected ? Color.RED : Color.BLACK);
            g.drawLine(0, 0, len, 0);
            g.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            g.drawString(type, len - g.getFontMetrics().stringWidth(type) - (len / 3), -4);
        }
    }
}