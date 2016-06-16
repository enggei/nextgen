package com.generator.generators.protobuf.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

/**
 * GENERATED
 */
public class ProtobufEntitiesGraph extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ComponentListener, PropertyChangeListener {



   private ProtobufEntitiesModel presentationModel;
   private final Color backgroundColor = Color.LIGHT_GRAY;
   private final Map<UUID,Node> allNodes = new LinkedHashMap<>();
   private final Map<UUID,Node> selNodes = new LinkedHashMap<>();
   private final Map<UUID, Relation> relations = new LinkedHashMap<>();
   private final Random random = new Random(System.currentTimeMillis());
   private MouseEvent last = null;
   private MouseEvent previous = null;
   private boolean ctrlPressed = false;

   public ProtobufEntitiesGraph(ProtobufEntitiesModel presentationModel) {
      super(null, true);
      setPreferredSize(new Dimension(1024, 768));
      setBorder(BorderFactory.createLineBorder(Color.black));

      this.presentationModel = presentationModel;

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addComponentListener(this);
   }

   @Override
   public void componentResized(ComponentEvent e) {
      requestRepaint();
   }

   @Override
   public void componentMoved(ComponentEvent e) {

   }

   @Override
   public void componentShown(ComponentEvent e) {
      addKeyListener(this);
      requestFocusInWindow();
   }

   @Override
   public void componentHidden(ComponentEvent e) {
      removeKeyListener(this);
      ctrlPressed = false;
   }

   @Override
   protected void paintComponent(Graphics g) {
      final Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      g2.setColor(presentationModel == null ? getBackground() : backgroundColor);
      g2.fillRect(0, 0, getWidth(), getHeight());

      // gridlines
      g2.setColor(new Color(255, 255, 255, 50));
      for (int y = 0; y < getHeight(); y += 10)
         g2.drawLine(0, y, getWidth(), y);
      for (int x = 0; x < getWidth(); x += 10)
         g2.drawLine(x, 0, x, getHeight());

      for (Relation relation : relations.values())
         relation.paint(g2, selNodes.keySet().contains(relation.src));

      for (Node node : allNodes.values())
         node.paint(g2, getWidth(), getHeight(), selNodes.keySet().contains(node.getUUID()));

      if (ctrlPressed && previous != null) {
         g2.setColor(Color.BLUE);
         for (Node selectedNode : selNodes.values()) {
            g2.drawLine(previous.getX(), previous.getY(), (int) selectedNode.centerX(), (int) selectedNode.centerY());
         }
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {

   }

   @Override
   public void keyPressed(KeyEvent e) {

      switch (e.getKeyCode()) {
         case KeyEvent.VK_CONTROL:
            ctrlPressed = true;
            break;

         case KeyEvent.VK_A: {

            if (ctrlPressed) {
               selNodes.putAll(allNodes);
               requestRepaint();
            } else {
               final Map<String, Set<Action>> actions = new TreeMap<>();
               if (selNodes.isEmpty()) {
                  final Action action = new AbstractAction("New ProtobufPackage") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        newProtobufPackageNode(presentationModel.newProtobufPackage(), random.nextInt(getWidth()), random.nextInt(getHeight()));
                        requestRepaint();
                     }
                  };

                  Set<Action> set = actions.get(action.getValue(Action.NAME).toString());
                  if (set == null) actions.put(action.getValue(Action.NAME).toString(), set = new LinkedHashSet<>());
                  set.add(action);

               } else {
                  for (Node node : selNodes.values()) addNodeAction(actions, node.newActions());
               }

               showActions(actions);
            }
         } break;

         case KeyEvent.VK_D: {
            if (selNodes.isEmpty()) return;
            final Map<String, Set<Action>> actions = new TreeMap<>();
            for (Node node : selNodes.values()) addNodeAction(actions, node.delActions());
            showActions(actions);
         }
         break;

         case KeyEvent.VK_E: {

            if (selNodes.isEmpty()) {
               // root entities:
               for (ProtobufPackage rootElement : presentationModel.getProtobufPackage()) {
                  allNodes.put(rootElement.getUuid(), newProtobufPackageNode(rootElement, random.nextInt(getWidth()), random.nextInt(getHeight())));
               }
               requestRepaint();

            } else {
               final Map<String, Set<Action>> actions = new TreeMap<>();
               for (Node node : selNodes.values()) addNodeAction(actions, node.expandActions());
               showActions(actions);
            }
         } break;

         case KeyEvent.VK_S: {

            if (selNodes.isEmpty())
               return;

            final Map<String, Set<Action>> actions = new TreeMap<>();
            for (Node node : selNodes.values()) addNodeAction(actions, node.sameActions());
            showActions(actions);
         }
         break;

         case KeyEvent.VK_C:

            if (allNodes.isEmpty()) return;
            if (selNodes.isEmpty()) return;

            for (Node node : new ArrayList<>(selNodes.values()))
               removeRelations(node);
            requestRepaint();
         break;
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      if (KeyEvent.VK_CONTROL == e.getKeyCode())
         ctrlPressed = false;
   }

   @Override
   public void mouseClicked(final MouseEvent mouseEvent) {
      if (mouseEvent.getClickCount() == 2) {


      } else if (SwingUtilities.isRightMouseButton(mouseEvent)) {

         final Map<String, Set<Action>> actions = new TreeMap<>();
         for (Node node : selNodes.values()) addNodeAction(actions, node.rightClickActions());

         actions.put("Show only selected", Collections.<Action>singleton(new AbstractAction("Show only selected") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final Set<Relation> retainedRelations = new LinkedHashSet<>();
               for (Node node : selNodes.values()) {
                  for (Relation relation : node.incoming) if (selNodes.containsValue(relation.src)) retainedRelations.add(relation);
                  for (Relation relation : node.outgoing) if (selNodes.containsValue(relation.dst)) retainedRelations.add(relation);
               }
               allNodes.values().retainAll(selNodes.values());
               relations.values().retainAll(retainedRelations);
               requestRepaint();
            }
         }));

         if (ctrlPressed) {
            actions.put("Center here", Collections.<Action>singleton(new AbstractAction("Center here") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  final Iterator<Point2D> satellites = satellites(selNodes.size(), mouseEvent.getX(), mouseEvent.getY()).iterator();
                  for (Node node : selNodes.values()) {
                     final Point2D next = satellites.next();
                     node.setCenterX((int) next.getX()).setCenterY((int) next.getY());
                  }
                  requestRepaint();
               }
            }));
         }

         showActions(actions);

      } else {

      }
   }

   @Override
   public void mousePressed(MouseEvent e) {
      if (SwingUtilities.isRightMouseButton(e)) {

      } else {
         if (!ctrlPressed) selNodes.clear();
         Node selectedNode = getNodeAt(e);
         if (selectedNode==null) return;

         if (ctrlPressed && selNodes.values().contains(selectedNode))
            selNodes.remove(selectedNode.getUUID());
         else
            selNodes.put(selectedNode.getUUID(), selectedNode);

         requestRepaint();
      }

      last = e;
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }

   @Override
   public void mouseDragged(MouseEvent e) {

      if (last != null) {
         for (Node selectedNode : selNodes.values())
            selectedNode.move((e.getX() - last.getX()), (e.getY() - last.getY()));
         requestRepaint();
      }

      last = e;
   }

   @Override
   public void mouseMoved(MouseEvent e) {
      previous = e;
      requestRepaint();
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      requestRepaint();
   }

   protected List<Point2D> satellites(int count, double centerX, double centerY) {
      final List<Point2D> satellites = new ArrayList<>(count);

      final double arcLength = 2 * Math.PI;
      final double radius = 50d;
      final double childProportion = (double) (count + 1) / (double) count;
      double currentArc = random.nextDouble() * Math.PI;

      for (int i = 0; i < count; i++) {
         double childRadians = (arcLength * childProportion);
         final double sin = Math.sin(currentArc + (childRadians / 2));
         final double cos = Math.cos(currentArc + (childRadians / 2));
         final double x = centerX + (int) (radius * sin);
         final double y = centerY + (int) (radius * cos);
         satellites.add(new Point2D.Double(x, y));
         currentArc += childRadians;
      }

      return satellites;
   }

   private Node getNodeAt(MouseEvent e) {
      for (Node node : allNodes.values())
         if (node.contains(e))
            return node;
      return null;
   }

   protected void requestRepaint() {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            repaint();
         }
      });
   }

   protected void addRelation(Node dst, Node src) {
      if (dst == null) return;

      final Relation relation = new Relation(src, dst, Color.RED);
      relations.put(relation.getUuid(), relation);

      src.outgoing.add(relation);
      dst.incoming.add(relation);
   }

   private void removeRelations(Node node) {

      if (node == null) return;

      final UUID uuid = node.getUUID();
      for (Relation relation : node.outgoing) {
         relations.remove(relation.getUuid());

         final Node dst = allNodes.get(relation.dst.getUUID());
         if(dst == null) continue;

         dst.incoming.remove(relation);
         if (!dst.incoming.isEmpty()) continue;
         removeRelations(dst);
      }

      for (Relation relation : node.incoming) {
         relations.remove(relation.getUuid());

         final Node src = allNodes.get(relation.src.getUUID());
         if (src == null) continue;
         src.outgoing.remove(relation);

         String property = null;
         for (Map.Entry<String, Node> propertyEntry : src.properties.entrySet()) {
            if (propertyEntry.getValue().getUUID().equals(node.getUUID())) {
               property = propertyEntry.getKey();
               break;
            }
         }
         if (property != null) src.properties.remove(property);
      }

      node.properties.clear();
      allNodes.remove(uuid);
      selNodes.remove(uuid);
   }

   protected static TreeSet<Action> newActionMap() {
      return new TreeSet<>(new Comparator<Action>() {
         @Override
         public int compare(Action o1, Action o2) {
            return o1.getValue(Action.NAME).toString().compareTo(o2.getValue(Action.NAME).toString());
         }
      });
   }

   private void addNodeAction(Map<String, Set<Action>> actions, Set<Action> nodeActions) {
      for (Action action : nodeActions) {
         Set<Action> set = actions.get(action.getValue(Action.NAME).toString());
         if (set == null) actions.put(action.getValue(Action.NAME).toString(), set = new LinkedHashSet<>());
         set.add(action);
      }
   }

   protected void showActions(Map<String, Set<Action>> actions) {
      final JPopupMenu pop = new JPopupMenu();
      for (final Map.Entry<String, Set<Action>> action : actions.entrySet()) {
         pop.add(new AbstractAction(action.getKey()) {
            @Override
            public void actionPerformed(ActionEvent e) {
               for (Action actionSet : action.getValue()) {
                  actionSet.actionPerformed(e);
               }
            }
         });
      }
      pop.show(ProtobufEntitiesGraph.this, last == null ? getWidth() / 2 : last.getX(), last == null ? getHeight() / 2 : last.getY());
   }

   private void showError(String s) {
      JOptionPane.showMessageDialog(ProtobufEntitiesGraph.this, s, "Restricted", JOptionPane.OK_OPTION);
   }


   protected Node newProtobufEnumNode(final ProtobufEnum entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(84, 102, 70)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufEnumExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufEnumNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufEnumSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufEnumDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufEnumRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufEnumExpandActionMap(final Node self, final ProtobufEnum entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Comment") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Comment");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getComment(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Comment") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Comment", last.getComponent(), entity.getComment());
                           if (value == null || value.length() == 0 || value.equals(entity.getComment())) return;

                           entity.setComment(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Comment", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Values") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final List<ProtobufEnumValue> list = entity.getValues();
            final List<Point2D> satellites = satellites(list.size(), self.centerX(), self.centerY());
            for (int i = 0; i < satellites.size(); i++) {
               Point2D d = satellites.get(i);
               addRelation(newProtobufEnumValueNode(list.get(i), (int) d.getX(), (int) d.getY()), self);
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumNewActionMap(final Node self, final ProtobufEnum entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("New Values") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufEnumValue newProtobufEnumValue = presentationModel.newProtobufEnumValue();
            entity.addValues(newProtobufEnumValue);
            final Node dst = newProtobufEnumValueNode(newProtobufEnumValue, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });


      return actions;
   }

   protected Set<Action> getProtobufEnumSameActionMap(final Node self, final ProtobufEnum entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufEnum") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufEnum entity : presentationModel.getProtobufEnumSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufEnumNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumDelActionMap(final Node self, final ProtobufEnum entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumRightClickActionMap(final Node self, final ProtobufEnum entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufEnumValueNode(final ProtobufEnumValue entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(134, 152, 120)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufEnumValueExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufEnumValueNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufEnumValueSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufEnumValueDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufEnumValueRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufEnumValueExpandActionMap(final Node self, final ProtobufEnumValue entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumValueNewActionMap(final Node self, final ProtobufEnumValue entity) {
      final Set<Action> actions = newActionMap();


      return actions;
   }

   protected Set<Action> getProtobufEnumValueSameActionMap(final Node self, final ProtobufEnumValue entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufEnumValue") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufEnumValue entity : presentationModel.getProtobufEnumValueSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufEnumValueNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumValueDelActionMap(final Node self, final ProtobufEnumValue entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufEnumValueRightClickActionMap(final Node self, final ProtobufEnumValue entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufFieldConstraintNode(final ProtobufFieldConstraint entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(34, 52, 20)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufFieldConstraintExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufFieldConstraintNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufFieldConstraintSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufFieldConstraintDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufFieldConstraintRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufFieldConstraintExpandActionMap(final Node self, final ProtobufFieldConstraint entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldConstraintNewActionMap(final Node self, final ProtobufFieldConstraint entity) {
      final Set<Action> actions = newActionMap();


      return actions;
   }

   protected Set<Action> getProtobufFieldConstraintSameActionMap(final Node self, final ProtobufFieldConstraint entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufFieldConstraint") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufFieldConstraint entity : presentationModel.getProtobufFieldConstraintSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufFieldConstraintNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldConstraintDelActionMap(final Node self, final ProtobufFieldConstraint entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldConstraintRightClickActionMap(final Node self, final ProtobufFieldConstraint entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufFieldTypeNode(final ProtobufFieldType entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(204, 242, 230)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufFieldTypeExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufFieldTypeNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufFieldTypeSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufFieldTypeDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufFieldTypeRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufFieldTypeExpandActionMap(final Node self, final ProtobufFieldType entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldTypeNewActionMap(final Node self, final ProtobufFieldType entity) {
      final Set<Action> actions = newActionMap();


      return actions;
   }

   protected Set<Action> getProtobufFieldTypeSameActionMap(final Node self, final ProtobufFieldType entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufFieldType") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufFieldType entity : presentationModel.getProtobufFieldTypeSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufFieldTypeNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldTypeDelActionMap(final Node self, final ProtobufFieldType entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufFieldTypeRightClickActionMap(final Node self, final ProtobufFieldType entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufMessageNode(final ProtobufMessage entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(134, 152, 170)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufMessageExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufMessageNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufMessageSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufMessageDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufMessageRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufMessageExpandActionMap(final Node self, final ProtobufMessage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Comment") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Comment");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getComment(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Comment") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Comment", last.getComponent(), entity.getComment());
                           if (value == null || value.length() == 0 || value.equals(entity.getComment())) return;

                           entity.setComment(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Comment", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

//      actions.add(new AbstractAction("Expand Parent") {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
//            addRelation(newProtobufMessageNode(entity.getParent(), (int) d.getX(), (int) d.getY()), self);
//         }
//      });

      actions.add(new AbstractAction("Expand Properties") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final List<ProtobufMessageField> list = entity.getProperties();
            final List<Point2D> satellites = satellites(list.size(), self.centerX(), self.centerY());
            for (int i = 0; i < satellites.size(); i++) {
               Point2D d = satellites.get(i);
               addRelation(newProtobufMessageFieldNode(list.get(i), (int) d.getX(), (int) d.getY()), self);
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageNewActionMap(final Node self, final ProtobufMessage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("New Properties") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufMessageField newProtobufMessageField = presentationModel.newProtobufMessageField();
            entity.addProperties(newProtobufMessageField);
            final Node dst = newProtobufMessageFieldNode(newProtobufMessageField, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });


      return actions;
   }

   protected Set<Action> getProtobufMessageSameActionMap(final Node self, final ProtobufMessage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufMessage") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufMessage entity : presentationModel.getProtobufMessageSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufMessageNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageDelActionMap(final Node self, final ProtobufMessage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageRightClickActionMap(final Node self, final ProtobufMessage entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufMessageFieldNode(final ProtobufMessageField entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(104, 142, 130)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufMessageFieldExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufMessageFieldNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufMessageFieldSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufMessageFieldDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufMessageFieldRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufMessageFieldExpandActionMap(final Node self, final ProtobufMessageField entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand FieldConstraint") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            addRelation(newProtobufFieldConstraintNode(entity.getFieldConstraint(), (int) d.getX(), (int) d.getY()), self);
         }
      });

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Type") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            addRelation(newProtobufFieldTypeNode(entity.getType(), (int) d.getX(), (int) d.getY()), self);
         }
      });

      actions.add(new AbstractAction("Expand Comment") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Comment");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getComment(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Comment") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Comment", last.getComponent(), entity.getComment());
                           if (value == null || value.length() == 0 || value.equals(entity.getComment())) return;

                           entity.setComment(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Comment", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand DefaultValue") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("DefaultValue");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getDefaultValue(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set DefaultValue") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("DefaultValue", last.getComponent(), entity.getDefaultValue());
                           if (value == null || value.length() == 0 || value.equals(entity.getDefaultValue())) return;

                           entity.setDefaultValue(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("DefaultValue", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageFieldNewActionMap(final Node self, final ProtobufMessageField entity) {
      final Set<Action> actions = newActionMap();


      return actions;
   }

   protected Set<Action> getProtobufMessageFieldSameActionMap(final Node self, final ProtobufMessageField entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufMessageField") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufMessageField entity : presentationModel.getProtobufMessageFieldSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufMessageFieldNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageFieldDelActionMap(final Node self, final ProtobufMessageField entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufMessageFieldRightClickActionMap(final Node self, final ProtobufMessageField entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufPackageNode(final ProtobufPackage entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getPackageName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(204, 132, 100)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufPackageExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufPackageNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufPackageSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufPackageDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufPackageRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufPackageExpandActionMap(final Node self, final ProtobufPackage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand PackageName") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("PackageName");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getPackageName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set PackageName") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("PackageName", last.getComponent(), entity.getPackageName());
                           if (value == null || value.length() == 0 || value.equals(entity.getPackageName())) return;

                           entity.setPackageName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("PackageName", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Options") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final List<ProtobufPackageOption> list = entity.getOptions();
            final List<Point2D> satellites = satellites(list.size(), self.centerX(), self.centerY());
            for (int i = 0; i < satellites.size(); i++) {
               Point2D d = satellites.get(i);
               addRelation(newProtobufPackageOptionNode(list.get(i), (int) d.getX(), (int) d.getY()), self);
            }
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Imports") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final List<ProtobufPackage> list = entity.getImports();
            final List<Point2D> satellites = satellites(list.size(), self.centerX(), self.centerY());
            for (int i = 0; i < satellites.size(); i++) {
               Point2D d = satellites.get(i);
               addRelation(newProtobufPackageNode(list.get(i), (int) d.getX(), (int) d.getY()), self);
            }
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Deliverables") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final List<ProtobufDeliverable> list = entity.getDeliverables();
            final List<Point2D> satellites = satellites(list.size(), self.centerX(), self.centerY());
            for (int i = 0; i < satellites.size(); i++) {
               Point2D d = satellites.get(i);
               switch (list.get(i).getDomainType()) {
                  case ProtobufEnum:
                     addRelation(newProtobufEnumNode((ProtobufEnum)list.get(i), (int) d.getX(), (int) d.getY()), self);
                     break; 
                  case ProtobufMessage:
                     addRelation(newProtobufMessageNode((ProtobufMessage)list.get(i), (int) d.getX(), (int) d.getY()), self);
                     break; 
               }}
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageNewActionMap(final Node self, final ProtobufPackage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("New Options") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufPackageOption newProtobufPackageOption = presentationModel.newProtobufPackageOption();
            entity.addOptions(newProtobufPackageOption);
            final Node dst = newProtobufPackageOptionNode(newProtobufPackageOption, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });


      actions.add(new AbstractAction("New Imports") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufPackage newProtobufPackage = presentationModel.newProtobufPackage();
            entity.addImports(newProtobufPackage);
            final Node dst = newProtobufPackageNode(newProtobufPackage, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });


      actions.add(new AbstractAction("New ProtobufEnum") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufEnum newProtobufEnum = presentationModel.newProtobufEnum();
            entity.addProtobufEnum(newProtobufEnum);
            final Node dst = newProtobufEnumNode(newProtobufEnum, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("New ProtobufMessage") {
         @Override
         public void actionPerformed(ActionEvent e) {
            final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
            final ProtobufMessage newProtobufMessage = presentationModel.newProtobufMessage();
            entity.addProtobufMessage(newProtobufMessage);
            final Node dst = newProtobufMessageNode(newProtobufMessage, (int) d.getX(), (int) d.getY());
            addRelation(dst, self);
            requestRepaint();
         }
      });


      return actions;
   }

   protected Set<Action> getProtobufPackageSameActionMap(final Node self, final ProtobufPackage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufPackage") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufPackage entity : presentationModel.getProtobufPackageSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufPackageNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageDelActionMap(final Node self, final ProtobufPackage entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageRightClickActionMap(final Node self, final ProtobufPackage entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   protected Node newProtobufPackageOptionNode(final ProtobufPackageOption entity, int x, int y) {
      if(entity==null) return null;

      Node node = allNodes.get(entity.getUuid());

      if (node == null) {
         allNodes.put(entity.getUuid(), node = new Node(entity.getUuid(), entity.getName(), Integer.MIN_VALUE != x ? x : (random.nextInt(getWidth())-25), Integer.MIN_VALUE != y ? y : (random.nextInt(getHeight())-25), 25, 25, new Color(244, 92, 60)) {
            @Override
            Set<Action> expandActions() {
               return getProtobufPackageOptionExpandActionMap(this, entity);
            }

            @Override
            Set<Action> newActions() {
               return getProtobufPackageOptionNewActionMap(this, entity);
            }

            @Override
            Set<Action> sameActions() {
               return getProtobufPackageOptionSameActionMap(this, entity);
            }

            @Override
            Set<Action> delActions() {
               return getProtobufPackageOptionDelActionMap(this, entity);
            }

            @Override
            Set<Action> rightClickActions() {
               return getProtobufPackageOptionRightClickActionMap(this, entity);
            }
         });
      }

      if (Integer.MIN_VALUE != x) node.setCenterX(x);
      if (Integer.MIN_VALUE != y) node.setCenterY(y);
      selNodes.put(node.getUUID(), node);
      requestRepaint();

      return node;
   }

   protected Set<Action> getProtobufPackageOptionExpandActionMap(final Node self, final ProtobufPackageOption entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Expand Name") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Name");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getName(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Name") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Name", last.getComponent(), entity.getName());
                           if (value == null || value.length() == 0 || value.equals(entity.getName())) return;

                           entity.setName(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Name", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      actions.add(new AbstractAction("Expand Value") {
         @Override
         public void actionPerformed(ActionEvent e) {
            Node node = self.properties.get("Value");
            if (node == null) {
               final Point2D d = satellites(1, self.centerX(), self.centerY()).iterator().next();
               final UUID uuid = UUID.randomUUID();
               final int w = 10;
               node = new Node(uuid, entity.getValue(), (int) d.getX(), (int) d.getY(), w, w, new Color(184, 2, 170)) {
                  @Override
                  Set<Action> expandActions() {
                     return Collections.<Action>singleton(new AbstractAction("Set Value") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String value = com.generator.util.SwingUtil.showInputDialog("Value", last.getComponent(), entity.getValue());
                           if (value == null || value.length() == 0 || value.equals(entity.getValue())) return;

                           entity.setValue(value);
                           requestRepaint();
                        }
                     });
                  }

                  @Override
                  Set<Action> newActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> delActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> sameActions() {
                     return Collections.emptySet();
                  }

                  @Override
                  Set<Action> rightClickActions() {
                     return Collections.emptySet();
                  }
               };

               self.properties.put("Value", node);
               self.outgoing.add(new Relation(self, node, Color.BLACK));
               addRelation(node, self);
               allNodes.put(uuid, node);
            }

            selNodes.put(node.getUUID(), node);
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageOptionNewActionMap(final Node self, final ProtobufPackageOption entity) {
      final Set<Action> actions = newActionMap();


      return actions;
   }

   protected Set<Action> getProtobufPackageOptionSameActionMap(final Node self, final ProtobufPackageOption entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("All ProtobufPackageOption") {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (ProtobufPackageOption entity : presentationModel.getProtobufPackageOptionSet()) {
               final Node n = allNodes.get(entity.getUuid());
               if (n == null) allNodes.put(entity.getUuid(), newProtobufPackageOptionNode(entity, random.nextInt(getWidth()), random.nextInt(getHeight())));
            }
            requestRepaint();
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageOptionDelActionMap(final Node self, final ProtobufPackageOption entity) {
      final Set<Action> actions = newActionMap();

      actions.add(new AbstractAction("Delete " + self.label) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               presentationModel.delete(self.getUUID());
            } catch (Exception e1) {
               showError("Cannot delete " + self.label + ".It has dependencies!");
            }
         }
      });

      return actions;
   }

   protected Set<Action> getProtobufPackageOptionRightClickActionMap(final Node self, final ProtobufPackageOption entity) {
      final Set<Action> actions = newActionMap();
      return actions;
   }

   abstract class Node {

      private final UUID uuid;
      private int squareX;
      private int squareY;
      private int squareW;
      private int squareH;
      private Color bg;
      private final Set<Relation> incoming = new LinkedHashSet<>();
      private final Set<Relation> outgoing = new LinkedHashSet<>();
      private final Map<String,Node> properties = new TreeMap<>();

      private String label;

      protected Node(UUID uuid, String label, int squareX, int squareY, int squareW, int squareH, Color bg) {
         this.uuid = uuid;
         this.squareX = squareX;
         this.squareY = squareY;
         this.squareW = squareW;
         this.squareH = squareH;
         this.bg = bg;
         this.label = label;
      }

      void paint(Graphics2D g, int width, int height, boolean selected) {
         if (squareX + squareW < 0 || squareX > width) return;
         if (squareY + squareH < 0 || squareY > height) return;

         g.setColor(selected ? Color.BLACK : bg);
         g.fillRect(squareX, squareY, squareW, squareH);
         g.setColor(selected ? bg : Color.BLACK);
         g.drawRect(squareX, squareY, squareW, squareH);
         if (label != null)
            g.drawString(label, (int) (centerX() - (g.getFontMetrics().stringWidth(label) / 2)), (int) (centerY() + (g.getFontMetrics().getHeight() / 4)));
      }

      Node move(int deltaX, int deltaY) {
         this.squareX += deltaX;
         this.squareY += deltaY;
         return this;
      }

      double centerX() {
         return squareX + (squareW / 2);
      }

      double centerY() {
         return squareY + (squareH / 2);
      }

      boolean contains(MouseEvent e) {
         return e.getX() >= squareX && e.getX() <= (squareX + squareW) && e.getY() >= squareY && e.getY() <= (squareY + squareH);
      }

      Node setCenterX(int x) {
         this.squareX = x - (squareW / 2);
         return this;
      }

      Node setCenterY(int y) {
         this.squareY = y - (squareH / 2);
         return this;
      }

      Node setLabel(String label) {
         this.label = label;
         return this;
      }

      UUID getUUID() {
         return uuid;
      }

      @Override
      public String toString() {
         return incoming.size() + " -> " + getUUID() + " -> " + outgoing.size();
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Node relation = (Node) o;

         return getUUID().equals(relation.getUUID());
      }

      @Override
      public int hashCode() {
         return getUUID().hashCode();
      }

      abstract Set<Action> expandActions();

      abstract Set<Action> newActions();

      abstract Set<Action> delActions();   // moves this tree to 'deleted' node under root, with timestamp-property. Then one can recover or select insert again...

      abstract Set<Action> sameActions();

      abstract Set<Action> rightClickActions();

   }

   private class Relation {

      private final UUID uuid = UUID.randomUUID();
      private final Node src;
      private final Node dst;
      protected String label;
      protected Color color;

      protected Relation(Node src, Node dst, Color color) {
         this.src = src;
         this.dst = dst;
         this.color = color;
      }

      public UUID getUuid() {
         return uuid;
      }

      public void paint(Graphics2D g, boolean selected) {
         g.setColor(selected ? Color.BLACK : color);
         g.drawLine((int) src.centerX(), (int) src.centerY(), (int) dst.centerX(), (int) dst.centerY());
         if (label != null) {
            int labelX = (int) (src.centerX() > dst.centerX() ? (src.centerX() - ((src.centerX() - dst.centerX()) / 2)) : ((dst.centerX() - ((dst.centerX() - src.centerX()) / 2))));
            int labelY = (int) (src.centerY() > dst.centerY() ? (src.centerY() - ((src.centerY() - dst.centerY()) / 2)) : ((dst.centerY() - ((dst.centerY() - src.centerY()) / 2))));
            g.drawString(label, labelX - (g.getFontMetrics().stringWidth(label) / 2), labelY + (g.getFontMetrics().getHeight() / 4));
         }
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Relation relation = (Relation) o;

         return uuid.equals(relation.uuid);
      }

      @Override
      public String toString() {
         return src + " -> " + dst;
      }

      @Override
      public int hashCode() {
         return uuid.hashCode();
      }
   }
}