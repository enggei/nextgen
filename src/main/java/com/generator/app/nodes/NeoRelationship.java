package com.generator.app.nodes;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Workspace;
import com.generator.neo.NeoModel;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.app.AppEvents.NODE_CHANGED;
import static com.generator.app.AppEvents.RELATIONS_SELECTED;
import static com.generator.app.AppEvents.RELATION_HIGHLIGHTED;
import static com.generator.util.NeoUtil.getNameOrTypeFrom;
import static com.generator.util.NeoUtil.getString;
import static com.generator.util.NeoUtil.propertiesFor;

/**
 * Created 01.10.17.
 */
public class NeoRelationship implements PropertyChangeListener {

   private Workspace workspace;
   private Workspace.NodeCanvas nodeCanvas;
   public final PPath path;
   private Paint defaultColor = Color.decode("#252525");
   private Paint currentPaint = defaultColor;
   private PText pText;

   public NeoRelationship(Workspace workspace, Workspace.NodeCanvas nodeCanvas, Relationship relationship, NeoNode source, NeoNode target) {
      this.workspace = workspace;
      this.nodeCanvas = nodeCanvas;
      pText = new PText();
      path = PPath.createLine(source.getFullBoundsReference().getCenter2D().getX(), source.getFullBoundsReference().getCenter2D().getY(), target.getFullBoundsReference().getCenter2D().getX(), target.getFullBoundsReference().getCenter2D().getY());

      final Node colorNode = workspace.app.model.graph().findNode(AppMotif.Entities._Color, "relation", relationship.getType().name());
      if (colorNode != null)
         defaultColor = Color.decode(getString(colorNode, AppMotif.Properties._color.name()));
      path.setStrokePaint(defaultColor);
      path.addAttribute("id", relationship.getId());
      path.addAttribute("relationship", relationship);
      path.addAttribute("source", source);
      path.addAttribute("target", target);
      source.addPropertyChangeListener(this);
      target.addPropertyChangeListener(this);

      switch (nodeCanvas.relationPaintStrategy) {
         case showLinesAndLabels:
            this.pText.setText(relationship.getType().name());
            path.addChild(this.pText);
            break;
         case showLinesAndProperties:
            this.pText.setText(propertiesFor(relationship));
            path.addChild(this.pText);
            break;
      }

      updatePath(source, target);


      final PBasicInputEventHandler relationEventListener = new PBasicInputEventHandler() {
         @Override
         public void mouseEntered(PInputEvent event) {
            currentPaint = nodeCanvas.highlightedNodeColor;
            repaintRelation();
            workspace.app.events.firePropertyChange(RELATION_HIGHLIGHTED, NeoRelationship.this);
         }

         @Override
         public void mouseExited(PInputEvent event) {
            currentPaint = path.getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultColor;
            repaintRelation();
         }

         @Override
         public void mouseClicked(PInputEvent event) {
            if (event.isRightMouseButton()) {
               SwingUtilities.invokeLater(() -> onRightClick(event));
            } else if (event.isLeftMouseButton()) {
               SwingUtilities.invokeLater(() -> onLeftClick());
            }
         }

         private void onRightClick(PInputEvent event) {
            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {

                  final JPopupMenu pop = new JPopupMenu();

                  pop.add(new App.TransactionAction("Change Type", workspace.app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String existingType = relationship.getType().name();

                        final Set<String> relationships = new LinkedHashSet<>();
                        workspace.app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
                        final JComboBox<String> cboRelationships = new JComboBox<>(relationships.toArray(new String[relationships.size()]));
                        cboRelationships.setSelectedItem(existingType);

                        final JRadioButton radOneToMany = new JRadioButton();
                        final JRadioButton radManyToOne = new JRadioButton("", true);
                        final ButtonGroup group = new ButtonGroup();
                        group.add(radOneToMany);
                        group.add(radManyToOne);

                        final JTextField txtSearch = new JTextField();
                        txtSearch.addKeyListener(new KeyAdapter() {
                           @Override
                           public void keyReleased(KeyEvent e) {
                              SwingUtilities.invokeLater(() -> {
                                 final String s = txtSearch.getText().trim().toLowerCase();
                                 for (String lbl : relationships) {
                                    if (lbl.toLowerCase().startsWith(s)) {
                                       cboRelationships.setSelectedItem(lbl);
                                    }
                                 }
                              });
                           }
                        });

                        final JTextField txtNew = new JTextField();

                        final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref");
                        editor.addLabel("Relationship", 1, 1);
                        editor.add(cboRelationships, 3, 1);
                        editor.addLabel("Search", 1, 3);
                        editor.add(txtSearch, 3, 3);
                        editor.addLabel("New", 1, 5);
                        editor.add(txtNew, 3, 5);
                        editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                        SwingUtil.showDialog(editor, workspace.app, "Change type", () -> {

                           final String newType = txtNew.getText().trim().length() == 0 ? (String) cboRelationships.getSelectedItem() : txtNew.getText().trim().toUpperCase();

                           workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx1) throws Throwable {
                                 final Relationship newRelationship = relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newType));
                                 for (String key : relationship.getPropertyKeys())
                                    newRelationship.setProperty(key, relationship.getProperty(key));
                                 relationship.delete();
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showExceptionNoStack(workspace.app, throwable);
                              }
                           });
                        });
                     }
                  });

                  pop.add(new App.TransactionAction("Reverse Direction", workspace.app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final Relationship newRelationship = relationship.getEndNode().createRelationshipTo(relationship.getStartNode(), relationship.getType());
                        for (String key : relationship.getPropertyKeys())
                           newRelationship.setProperty(key, relationship.getProperty(key));
                        relationship.delete();
                     }
                  });

                  pop.add(new App.TransactionAction("Set Property", workspace.app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String propertyValue = SwingUtil.showInputDialog("Property Name and value", nodeCanvas);
                        if (propertyValue == null || propertyValue.trim().length() == 0 || propertyValue.trim().split("[ ]").length != 2)
                           return;

                        relationship.setProperty(propertyValue.trim().split("[ ]")[0], propertyValue.trim().split("[ ]")[1]);
                     }
                  });

                  pop.add(new App.TransactionAction("Delete", workspace.app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final Long startNode = relationship.getStartNode().getId();
                        final Long endNode = relationship.getEndNode().getId();
                        if (SwingUtil.showConfirmDialog(workspace.app, "Delete " + getNameOrTypeFrom(relationship) + " ?")) {
                           final NeoRelationship remove = workspace.layerRelations.remove(relationship.getId());
                           if (remove != null) nodeCanvas.relationLayer.removeChild(path);
                           workspace.app.model.deleteRelations(Collections.singleton(relationship));
                        }
                        workspace.app.events.firePropertyChange(NODE_CHANGED + startNode);
                        workspace.app.events.firePropertyChange(NODE_CHANGED + endNode);
                     }
                  });

                  pop.show(nodeCanvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(nodeCanvas, throwable);
               }
            }));
         }

         private void onLeftClick() {
            toggleSelect();
            workspace.app.events.firePropertyChange(RELATIONS_SELECTED, nodeCanvas.getSelectedRelations());
         }
      };
      relationEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
      path.addInputEventListener(relationEventListener);
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {

      switch (evt.getPropertyName()) {
         case PNode.PROPERTY_FULL_BOUNDS:
         case PNode.PROPERTY_TRANSFORM:
            SwingUtilities.invokeLater(() -> updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target")));
            break;

         case PNode.PROPERTY_PARENT:
            if (evt.getOldValue() != null) SwingUtilities.invokeLater(this::removeFromCanvas);
            break;
      }
   }

   public Long id() {
      return Long.valueOf(path.getAttribute("id").toString());
   }

   public void highlight() {
      path.addAttribute("highlighted", Boolean.TRUE);
      currentPaint = nodeCanvas.highlightedNodeColor;
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   public void unhighlight() {
      path.addAttribute("highlighted", Boolean.FALSE);
      currentPaint = path.getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultColor;
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   void toggleSelect() {
      path.addAttribute("selected", !path.getBooleanAttribute("selected", false));
      currentPaint = path.getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultColor;
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   public void select() {
      path.addAttribute("selected", Boolean.TRUE);
      currentPaint = nodeCanvas.selectedNodeColor;
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   public void unselect() {
      path.addAttribute("selected", Boolean.FALSE);
      currentPaint = defaultColor;
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }


   public boolean isSelected() {
      return path.getBooleanAttribute("selected", false);
   }

   public Relationship getRelationship() {
      return (Relationship) path.getAttribute("relationship");
   }

   private void updatePath(NeoNode source, NeoNode target) {
      final PBounds src = source.getFullBoundsReference();
      final PBounds dst = target.getFullBoundsReference();

      final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());

      final Point2D.Double startCenterBottom = p(src.getCenterX(), src.getMaxY());
      final Point2D.Double endCenterTop = p(dst.getCenterX(), dst.getMinY());

      final Point2D.Double startCenterTop = p(src.getCenterX(), src.getMinY());
      final Point2D.Double endCenterBottom = p(dst.getCenterX(), dst.getMaxY());

      if (src.getCenterX() < dst.getCenterX()) {

         final Point2D.Double startRightCenter = p(src.getMaxX(), src.getCenterY());
         final Point2D.Double endRightCenter = p(dst.getMinX(), dst.getCenterY());

         if (src.getCenterY() < dst.getCenterY()) {
            // top-left
            if (!horizontalOverlap) {
               Point2D.Double ctrl1 = new Point2D.Double(startRightCenter.getX() + ((endRightCenter.getX() - startRightCenter.getX()) / 2), startRightCenter.getY());
               Point2D.Double ctrl2 = new Point2D.Double(endRightCenter.getX() + ((startRightCenter.getX() - endRightCenter.getX()) / 2), endRightCenter.getY());
               drawPath(startRightCenter, endRightCenter, ctrl1, ctrl2);
            } else {
               Point2D.Double ctrl1 = new Point2D.Double(startCenterBottom.getX(), startCenterBottom.getY() + ((endCenterTop.getY() - startCenterBottom.getY()) / 2));
               Point2D.Double ctrl2 = new Point2D.Double(endCenterTop.getX(), endCenterTop.getY() + ((startCenterBottom.getY() - endCenterTop.getY()) / 2));
               drawPath(startCenterBottom, endCenterTop, ctrl1, ctrl2);
            }
         } else {
            // bottom-left
            if (!horizontalOverlap) {
               Point2D.Double ctrl1 = new Point2D.Double(startRightCenter.getX() + ((endRightCenter.getX() - startRightCenter.getX()) / 2), startRightCenter.getY());
               Point2D.Double ctrl2 = new Point2D.Double(endRightCenter.getX() + ((startRightCenter.getX() - endRightCenter.getX()) / 2), endRightCenter.getY());
               drawPath(startRightCenter, endRightCenter, ctrl1, ctrl2);
            } else {
               Point2D.Double ctrl1 = new Point2D.Double(startCenterTop.getX(), startCenterTop.getY() - ((startCenterTop.getY() - endCenterBottom.getY()) / 2));
               Point2D.Double ctrl2 = new Point2D.Double(endCenterBottom.getX(), endCenterBottom.getY() - ((endCenterBottom.getY() - startCenterTop.getY()) / 2));
               drawPath(startCenterTop, endCenterBottom, ctrl1, ctrl2);
            }
         }

      } else {

         final Point2D.Double startLeftCenter = p(src.getMinX(), src.getCenterY());
         final Point2D.Double endLeftCenter = p(dst.getMaxX(), dst.getCenterY());

         if (src.getCenterY() < dst.getCenterY()) {
            // top-right
            if (!horizontalOverlap) {
               Point2D.Double ctrl1 = new Point2D.Double(startLeftCenter.getX() - ((startLeftCenter.getX() - endLeftCenter.getX()) / 2), startLeftCenter.getY());
               Point2D.Double ctrl2 = new Point2D.Double(endLeftCenter.getX() - ((endLeftCenter.getX() - startLeftCenter.getX()) / 2), endLeftCenter.getY());
               drawPath(startLeftCenter, endLeftCenter, ctrl1, ctrl2);
            } else {
               Point2D.Double ctrl1 = new Point2D.Double(startCenterBottom.getX(), startCenterBottom.getY() + ((endCenterTop.getY() - startCenterBottom.getY()) / 2));
               Point2D.Double ctrl2 = new Point2D.Double(endCenterTop.getX(), endCenterTop.getY() + ((startCenterBottom.getY() - endCenterTop.getY()) / 2));
               drawPath(startCenterBottom, endCenterTop, ctrl1, ctrl2);
            }
         } else {
            // bottom-right
            if (!horizontalOverlap) {
               Point2D.Double ctrl1 = new Point2D.Double(startLeftCenter.getX() - ((startLeftCenter.getX() - endLeftCenter.getX()) / 2), startLeftCenter.getY());
               Point2D.Double ctrl2 = new Point2D.Double(endLeftCenter.getX() - ((endLeftCenter.getX() - startLeftCenter.getX()) / 2), endLeftCenter.getY());
               drawPath(startLeftCenter, endLeftCenter, ctrl1, ctrl2);
            } else {
               Point2D.Double ctrl1 = new Point2D.Double(startCenterTop.getX(), startCenterTop.getY() - ((startCenterTop.getY() - endCenterBottom.getY()) / 2));
               Point2D.Double ctrl2 = new Point2D.Double(endCenterBottom.getX(), endCenterBottom.getY() - ((endCenterBottom.getY() - startCenterTop.getY()) / 2));
               drawPath(startCenterTop, endCenterBottom, ctrl1, ctrl2);
            }
         }
      }
   }

   private Point2D.Double p(double x, double y) {
      return new Point2D.Double(x, y);
   }

   private void drawPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {
      switch (nodeCanvas.relationPathStrategy) {
         case straightLines:
            drawStraightPath(start, end);
            break;
         case rectangularLines:
            drawRectangularLinesPath(start, end, ctrl1, ctrl2);
            break;
         case bezierLines:
            drawBezierPath(start, end, ctrl1, ctrl2);
            break;
         case quadLines:
            drawQuad(start, end, ctrl1, ctrl2);
            break;
      }
   }

   private void drawStraightPath(Point2D start, Point2D end) {
      path.reset();
      if (!AppMotif.RelationPaintStrategy.showNothing.equals(nodeCanvas.relationPaintStrategy)) {
         path.setStrokePaint(currentPaint);

         path.moveTo(start.getX(), start.getY());
         path.lineTo(end.getX(), end.getY());
         pText.setTextPaint(currentPaint);
         pText.setOffset(path.getBounds().getCenter2D());

         // arrow
         final int ARR_SIZE = 4;
         final double dx = end.getX() - start.getX();
         final double dy = end.getY() - start.getY();
         final double angle = Math.atan2(dy, dx);
         final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
         final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());
         at.concatenate(AffineTransform.getRotateInstance(angle));
         path.append(new Polygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4).getPathIterator(at), false);
      }

      repaintRelation();
   }

   private void drawRectangularLinesPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

      path.reset();
      if (!AppMotif.RelationPaintStrategy.showNothing.equals(nodeCanvas.relationPaintStrategy)) {
         path.setStrokePaint(currentPaint);

         path.moveTo(start.getX(), start.getY());
         path.lineTo(ctrl1.getX(), ctrl1.getY());
         path.moveTo(ctrl1.getX(), ctrl1.getY());
         path.lineTo(ctrl2.getX(), ctrl2.getY());
         path.moveTo(ctrl2.getX(), ctrl2.getY());
         path.lineTo(end.getX(), end.getY());

         pText.setTextPaint(currentPaint);
         pText.setOffset(path.getBounds().getCenter2D());
      }

      repaintRelation();
   }

   private void drawBezierPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

      path.reset();
      if (!AppMotif.RelationPaintStrategy.showNothing.equals(nodeCanvas.relationPaintStrategy)) {
         path.setStrokePaint(currentPaint);

         path.moveTo(start.getX(), start.getY());
         path.curveTo(ctrl1.getX(), ctrl1.getY(), ctrl2.getX(), ctrl2.getY(), end.getX(), end.getY());
         path.moveTo(end.getX(), end.getY());
         path.closePath();

         pText.setTextPaint(currentPaint);
         pText.setOffset(path.getBounds().getCenter2D());
      }

      repaintRelation();
   }

   private void drawQuad(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

      path.reset();
      if (!AppMotif.RelationPaintStrategy.showNothing.equals(nodeCanvas.relationPaintStrategy)) {
         path.setStrokePaint(currentPaint);

         path.moveTo(start.getX(), start.getY());
         path.quadTo(ctrl1.getX(), ctrl1.getY(), end.getX(), end.getY());
         path.moveTo(end.getX(), end.getY());
         path.closePath();

         pText.setTextPaint(currentPaint);
         pText.setOffset(path.getBounds().getCenter2D());
      }

      repaintRelation();
   }

   private void repaintRelation() {
      SwingUtilities.invokeLater(() -> {
         path.setPaintInvalid(true);
         path.validateFullPaint();
      });
   }

   public void setRelationPaintStrategy(AppMotif.RelationPaintStrategy type) {
      switch (type) {
         case showLines:
            path.removeChild(pText);
            break;
         case showLinesAndLabels:
            path.removeChild(pText);
            this.pText.setText(getRelationship().getType().name());
            path.addChild(this.pText);
            break;
         case showNothing:
            path.removeChild(pText);
            break;
         case showLinesAndProperties:
            path.removeChild(pText);
            this.pText.setText(propertiesFor(getRelationship()));
            path.addChild(this.pText);
            break;
      }

      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   public void setRelationPathStrategy() {
      updatePath(((NeoNode) path.getAttribute("source")), (NeoNode) path.getAttribute("target"));
   }

   public void removeFromCanvas() {
      ((NeoNode) path.getAttribute("source")).removePropertyChangeListener(NeoRelationship.this);
      ((NeoNode) path.getAttribute("target")).removePropertyChangeListener(NeoRelationship.this);
      workspace.layerRelations.remove(Long.valueOf(path.getAttribute("id").toString()));
      nodeCanvas.relationLayer.removeChild(path);
   }
}
