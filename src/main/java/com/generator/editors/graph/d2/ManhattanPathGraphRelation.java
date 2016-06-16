package com.generator.editors.graph.d2;

import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

/**
 * goe on 5/12/15.
 */
public class ManhattanPathGraphRelation<E extends Enum<E>> extends GraphRelation<GraphNode2D<E>, GraphNode2D<E>, E> {

    public ManhattanPathGraphRelation(Relationship relationship, GraphNode2D<E> source, GraphNode2D<E> target) {
        super(relationship, source, target);
    }

    @Override
    public void paint(Graphics2D g1, boolean selected) {
        final GraphNode2D source = getSource();
        final GraphNode2D target = getTarget();
        final String type = getType();

        if (source.uuid().equals(target.uuid())) {

            Point2D.Double ctrl1 = new Point2D.Double(source.centerX() - 50, source.centerY());
            Point2D.Double ctrl2 = new Point2D.Double(source.centerX(), source.centerY() + 50);
            CubicCurve2D.Double cubicCurve = new CubicCurve2D.Double(source.centerX(), source.centerY(), ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, source.centerX(), source.centerY());

            g1.setColor(selected ? Color.RED : Color.BLACK);
            g1.draw(cubicCurve);
            g1.drawString(type, source.centerX() - 30, source.centerY() + 35);

        } else {

            final Graphics2D g = (Graphics2D) g1.create();
            g.setColor(selected ? Color.RED : Color.BLACK);
            int midX = (int) (source.centerX() < target.centerX() ? (source.centerX() + ((target.centerX() - source.centerX()) / 2d)) : (target.centerX() + ((source.centerX() - target.centerX()) / 2d)));
            int midY = (int) (source.centerY() < target.centerY() ? (source.centerY() + ((target.centerY() - source.centerY()) / 2d)) : (target.centerY() + ((source.centerY() - target.centerY()) / 2d)));
            g.drawLine(source.centerX(), source.centerY(), midX, source.centerY()); // from source
            g.drawLine(midX, source.centerY(), midX, target.centerY()); // mid points
            g.drawString(type, midX - (int) (g.getFontMetrics().stringWidth(type) / 2d), midY);
            g.drawLine(midX, target.centerY(), target.centerX(), target.centerY()); // to target
        }
    }
}