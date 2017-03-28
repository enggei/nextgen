package com.generator.generators.json;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.util.*;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.json.JsonDomain.Entities.*;
import static com.generator.generators.json.JsonDomain.Entities.Object;

/**
 * Created 28.03.17.
 */
public class JsonDomainImpl extends JsonDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

      domainMenu.add(new NeoEditor.TransactionAction("New Document", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", canvas);
            if (name == null) return;

            final Node node = graph.newNode(Document);
            node.setProperty(JsonDomain.Properties.name.name(), name);

            editor.show(NeoModel.uuidOf(node), Document.name()).setOffset(event);
         }
      });
   }

   @Override
   protected NeoPNode newDocumentPNode(Node node, NeoEditor editor) {
      return new DocumentPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new NeoEditor.TransactionAction("Add Object", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node newNode = graph.newNode(Entities.Object);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.MEMBER);
                  member.setProperty(Properties.type.name(), Entities.Object.name());

                  editor.show(NeoModel.uuidOf(newNode), JsonDomain.Entities.Object.name()).setOffset(event);
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add Array", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node newNode = graph.newNode(Array);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.MEMBER);
                  member.setProperty(Properties.type.name(), Array.name());

                  editor.show(NeoModel.uuidOf(newNode), Array.name()).setOffset(event);
               }
            });
            super.showNodeActions(pop, event);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.MEMBER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.valueOf(getString(relationship, Properties.type.name()))));
            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void renderTo(JTextComponent textArea) {

            final JsonGroup group = new JsonGroup();

            editor.getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  new JsonDomainVisitor() {

                     JsonGroup.documentST document;
                     final Stack<JsonGroup.objectST> currentObject = new Stack<>();

                     @Override
                     <T> T visitDocument(Node node) {

                        document = group.newdocument();

                        outgoing(node, Relations.MEMBER).forEach(relationship -> {
                           switch (Entities.valueOf(getString(relationship, Properties.type.name()))) {
                              case Object:
                                 visitObject(other(node, relationship));
                                 break;
                              case Array:
                                 visitObject(other(node, relationship));
                                 break;
                           }
                        });

                        textArea.setText(document.toString());
                        textArea.setCaretPosition(0);

                        return super.visitDocument(node);
                     }

                     @Override
                     <T> T visitObject(Node node) {
                        currentObject.push(group.newobject());

                        outgoing(node, Relations.PAIR).forEach(relationship -> {
                           visitPair(other(node, relationship));
                        });

                        document.addContentValue(currentObject.pop());

                        return super.visitObject(node);
                     }

                     @Override
                     <T> T visitPair(Node node) {

                        final Object value = visit(other(node, singleOutgoing(node, Relations.VALUE)));
                        currentObject.peek().addPairsValue(getString(node, Properties.name.name()), value);

                        return super.visitPair(node);
                     }

                     @Override
                     <T> T visitArray(Node node) {
                        // todo visit array:
                        return null;
                     }

                     @Override
                     <T> T visitValue(Node node) {
                        return node.hasProperty(Properties.value.name()) ? get(node, Properties.value.name()) : null;
                     }
                  }.visitDocument(node);
               }

               @Override
               public void exception(Throwable throwable) {
                  textArea.setText(throwable.getMessage());
               }
            });
         }
      };
   }

   @Override
   protected NeoPNode newObjectPNode(Node node, NeoEditor editor) {
      return new DocumentPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Add Pair", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node newNode = graph.newNode(Pair);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.PAIR);
//                  member.setProperty(Properties.type.name(), Pair.name());

                  editor.show(NeoModel.uuidOf(newNode), Pair.name()).setOffset(event);
               }
            });
            super.showNodeActions(pop, event);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.PAIR).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Pair));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newValuePNode(Node node, NeoEditor editor) {
      return new ValuePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            editor.newSetNodePropertyAction(Properties.value.name(), this);

            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newArrayPNode(Node node, NeoEditor editor) {
      return new ArrayPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Add String value", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  // todo add string-input dialog here and set to value

                  final Node newNode = graph.newNode(Value);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.ELEMENT);
                  member.setProperty(Properties.type.name(), Value.name());

                  editor.show(NeoModel.uuidOf(newNode), Value.name()).setOffset(event);
               }
            });
            super.showNodeActions(pop, event);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.ELEMENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.valueOf(getString(relationship, Properties.type.name()))));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newPairPNode(Node node, NeoEditor editor) {
      return new PairPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Set key", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String name = SwingUtil.showInputDialog("Key", canvas);
                  if (name == null) return;

                  node.setProperty(JsonDomain.Properties.name.name(), name);

                  updateView();
               }
            });

            pop.add(new NeoEditor.TransactionAction("Set String-value", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String value = SwingUtil.showInputDialog("Value", canvas);
                  if (value == null) return;

                  final Node newNode = graph.newNode(Value);
                  newNode.setProperty(JsonDomain.Properties.value.name(), value);

                  final Relationship member = node.createRelationshipTo(newNode, Relations.VALUE);
                  member.setProperty(Properties.type.name(), Entities.Value.name());

                  editor.show(NeoModel.uuidOf(newNode), Entities.Value.name()).setOffset(event);

               }
            });

            pop.add(new NeoEditor.TransactionAction("Set Object-value", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node newNode = graph.newNode(Object);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.VALUE);
                  member.setProperty(Properties.type.name(), Entities.Object.name());

                  editor.show(NeoModel.uuidOf(newNode), JsonDomain.Entities.Object.name()).setOffset(event);
               }
            });

            pop.add(new NeoEditor.TransactionAction("Set Array-value", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node newNode = graph.newNode(Array);
                  final Relationship member = node.createRelationshipTo(newNode, Relations.VALUE);
                  member.setProperty(Properties.type.name(), Entities.Array.name());

                  editor.show(NeoModel.uuidOf(newNode), JsonDomain.Entities.Array.name()).setOffset(event);
               }
            });

            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

            if (selectedNodes.size() != 1) return;

            final Node selectedNode = selectedNodes.iterator().next().node;
            if (!(selectedNode.hasLabel(Object) || selectedNode.hasLabel(Array) || selectedNode.hasLabel(Value))) return;

            pop.add(new NeoEditor.TransactionAction("Set value", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Relationship newRelation = node.createRelationshipTo(selectedNode, Relations.VALUE);
                  newRelation.setProperty(Properties.type.name(), selectedNode.hasLabel(Object) ? Object.name() : (selectedNode.hasLabel(Array) ? Array.name() : Value.name()));
                  editor.addRelation(newRelation);

                  updateView();
               }
            });
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.VALUE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.valueOf(getString(relationship, Properties.type.name()))));
            editor.showAndLayout(pNodes, pNode);
         }

         @Override
         public void updateView() {
            // todo: add value-rendered either from outgoing or property-value
            pNode.setText(getString(node, Properties.name.name()));
         }
      };
   }

   @Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {
      super.deleteNode(node);
   }
}