package com.generator.generators.generatorDomain;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.editors.graph.d2.ShortestPathGraphRelation;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.util.UUID;

/**
 * goe on 3/26/15.
 */
public class Generator {

	public static GeneratorDomainEditor newGeneratorDomainEditor(final GeneratorDomain domain) {
		return new GeneratorDomainEditor(domain) {

			@Override
			protected void handleKeyPressed(JComponent parent, KeyEvent e, boolean ctrlPressed, MouseEvent last) {

				if (KeyEvent.VK_E == e.getKeyCode() && ctrlPressed) {
					domain.commit(new MetaDomain.Committer() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							newGraphNode(domain.newNode(GeneratorDomain.ENTITIES.ENTITY, UUID.randomUUID()), last);
						}

						@Override
						public void exception(Throwable throwable) {
							SwingUtil.showException(parent, throwable);
						}
					});

				} else if (KeyEvent.VK_R == e.getKeyCode() && ctrlPressed) {
					domain.commit(new MetaDomain.Committer() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							final Node newNode = domain.newNode(GeneratorDomain.ENTITIES.ENTITY, UUID.randomUUID());
							newGraphNode(newNode, last);
						}

						@Override
						public void exception(Throwable throwable) {
							SwingUtil.showException(parent, throwable);
						}
					});

				} else
					super.handleKeyPressed(parent, e, ctrlPressed, last);
			}

			@Override
			protected void rightClickDOMAIN(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<GeneratorDomain.ENTITIES> targetNode) {

				popupMenu.add(new AbstractAction("Set root") {
					@Override
					public void actionPerformed(ActionEvent e) {

						final String root = SwingUtil.showInputDialog("Set root", popupMenu, System.getProperty("generator.root"));
						if (root == null || root.length() == 0) return;

						domain.commit(new MetaDomain.Committer() {
							@Override
							public void doAction(Transaction tx) throws Throwable {
								targetNode.node().setProperty("root", root);
							}

							@Override
							public void exception(Throwable throwable) {
								SwingUtil.showException(popupMenu, throwable);
							}
						});
					}
				});

				addVisitor(popupMenu, targetNode, new DomainVisitorGenerator(this));
				addVisitor(popupMenu, targetNode, new DomainGeneratorGenerator(this));
				addVisitor(popupMenu, targetNode, new DomainEditorGenerator(this));
			}

			@Override
			protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newTERMRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
				return null;
			}

			@Override
			protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newCONSTRAINTRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
				return null;
			}

			@Override
			protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newSOURCESRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
				return new ShortestPathGraphRelation<GeneratorDomain.ENTITIES>(relationship, source, target) {
					@Override
					public void paint(Graphics2D g1, boolean selected) {
						final GraphNode2D source = getSource();
						final GraphNode2D target = getTarget();

						if (source.uuid().equals(target.uuid())) {
							Point2D.Double ctrl1 = new Point2D.Double(source.centerX() - 50, source.centerY());
							Point2D.Double ctrl2 = new Point2D.Double(source.centerX(), source.centerY() + 50);
							CubicCurve2D.Double cubicCurve = new CubicCurve2D.Double(source.centerX(), source.centerY(), ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, source.centerX(), source.centerY());

							g1.setColor(selected ? Color.RED : Color.BLACK);
							g1.draw(cubicCurve);

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
						}
					}
				};
			}

			@Override
			protected GraphRelation<GraphNode2D<GeneratorDomain.ENTITIES>, GraphNode2D<GeneratorDomain.ENTITIES>, GeneratorDomain.ENTITIES> newDESTINATIONSRelation(Relationship relationship, GraphNode2D<GeneratorDomain.ENTITIES> source, GraphNode2D<GeneratorDomain.ENTITIES> target) {
				return new ShortestPathGraphRelation<GeneratorDomain.ENTITIES>(relationship, source, target) {
					@Override
					public void paint(Graphics2D g1, boolean selected) {
						final GraphNode2D source = getSource();
						final GraphNode2D target = getTarget();

						if (source.uuid().equals(target.uuid())) {
							Point2D.Double ctrl1 = new Point2D.Double(source.centerX() - 50, source.centerY());
							Point2D.Double ctrl2 = new Point2D.Double(source.centerX(), source.centerY() + 50);
							CubicCurve2D.Double cubicCurve = new CubicCurve2D.Double(source.centerX(), source.centerY(), ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, source.centerX(), source.centerY());

							g1.setColor(selected ? Color.RED : Color.BLACK);
							g1.draw(cubicCurve);

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
						}
					}
				};
			}

			@Override
			protected GraphNode2D<GeneratorDomain.ENTITIES> newRELATIONGraphNode(MetaNode<GeneratorDomain.ENTITIES> metaNode, Node node, int x, int y) {
				return new GraphNode2D<GeneratorDomain.ENTITIES>(node, metaNode, x, y, 20, 30, Color.decode("#fc8d59"), Color.decode("#99d594"), Color.decode("#000000"), Color.decode("#fc8d59"), NeoModel.getNameOrLabelFrom(node), false) {
					@Override
					public Shape paint(Graphics2D g, int width, int height, boolean selected, boolean isTarget) {

						if (squareX + squareW < 0 || squareX > width) return new Rectangle(squareX, squareY, 0, 0);
						if (squareY + squareH < 0 || squareY > height) return new Rectangle(squareX, squareY, 0, 0);

//                        g.setColor(selected ? selBg : bg);
//                        g.fillRect(squareX, squareY, squareW, squareH);
//                        g.setColor(selected ? (isTarget ? Color.RED : bg) : (isTarget ? Color.RED : Color.BLACK));
//                        g.drawRect(squareX, squareY, squareW, squareH);

						if (label != null) {
							g.setColor(selected ? sellblColor : lblColor);
							g.drawString(label, centerX() - (g.getFontMetrics().stringWidth(label) / 2), centerY() + (g.getFontMetrics().getHeight() / 4));
						}

						return new Rectangle(squareX, squareY, squareW, squareH);
					}
				};
			}
		};
	}
}