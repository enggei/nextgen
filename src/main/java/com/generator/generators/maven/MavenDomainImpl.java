package com.generator.generators.maven;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.outgoing;
import static com.generator.editors.NeoModel.uuidOf;

/**
 * Created 24.03.17.
 */
public class MavenDomainImpl extends MavenDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.Pom, "name", event));
   }

   @Override
   protected NeoPNode newPomPNode(Node node, NeoEditor editor) {
      return new PomPNode(node, editor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Render", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {


                  final String out = new PomGenerator(new MavenGroup()).visit(node);

                  for (Relationship relationship : node.getRelationships(Direction.INCOMING)) {
                     if (relationship.getType().name().equals("FILE")) {

                     }
                  }

                  System.out.println(out);
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add Dependency", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JTextArea textArea = new JTextArea(50, 80);

                  SwingUtil.showTextInput("Maven dependency", textArea, editor.getCanvas(), new SwingUtil.OnSave() {
                     @Override
                     public void verifyAndSave() throws Exception {

                        final String text = textArea.getText();

                        final String groupId = text.substring(text.indexOf("<groupId>") + 9, text.indexOf("</groupId>"));
                        final String artifactId = text.substring(text.indexOf("<artifactId>") + 12, text.indexOf("</artifactId>"));
                        final String version = text.substring(text.indexOf("<version>") + 9, text.indexOf("</version>"));

                        if (groupId.length() == 0 || artifactId.length() == 0 || version.length() == 0) {
                           SwingUtil.showMessage("cannot understand " + text, editor.getCanvas());
                           return;
                        }

                        graph.doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {

                              final Node newNode = graph.newNode(Entities.Library);
                              newNode.setProperty(Properties.groupId.name(), groupId);
                              newNode.setProperty(Properties.artifactId.name(), artifactId);
                              newNode.setProperty(Properties.version.name(), version);
                              node.createRelationshipTo(newNode, Relations.DEPENDENCY);

                              editor.show(uuidOf(newNode), Entities.Library.name()).setOffset(event);
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showMessage("Error " + throwable.getMessage(), editor.getCanvas());
                           }
                        });
                     }
                  });
               }
            });

            super.showNodeActions(pop, event);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.DEPENDENCY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Library));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }
}
