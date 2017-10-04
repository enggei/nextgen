package com.generator.generators.maven;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Created 03.08.17.
 */
public class MavenPlugin extends Plugin {

   public enum Entities implements Label {
      Pom, Dependency
   }

   public enum Relations implements RelationshipType {
      POM
   }

   public enum Properties {
   }

   public MavenPlugin(App app) {
      super(app, "Maven");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Pom);

      menu.add(new AbstractAction("Import from Maven") {
         @Override
         public void actionPerformed(ActionEvent e) {

            final JTextArea txtXml = new JTextArea(30, 30);

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("200dlu:grow", "100:grow");
            editor.add(new JScrollPane(txtXml), 1, 1);

            SwingUtil.showDialog(editor, app, "Paste any element from pom", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        fireNodesLoaded(traverse(parseXml(txtXml.getText().trim()), null));
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Pom)) {

         final Node directoryNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), ProjectPlugin.Relations.RENDERER));
         if (directoryNode != null) {

            final File directory = ProjectPlugin.getFile(directoryNode);
            if (directory != null && directory.exists()) {
               pop.add(new App.TransactionAction("Run Lifecycle", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String lifecycle = SwingUtil.showSelectDialog(app, new String[]{"clean", "validate", "compile", "test", "package", "verify", "install", "site", "deploy"});
                     if (lifecycle == null) return;

                     new ProcessExecutor().
                           directory(directory).
                           command("mvn", lifecycle)
                           .redirectOutput(new LogOutputStream() {
                              @Override
                              protected void processLine(String line) {
                                 System.out.println(line);
                              }
                           }).execute();
                  }
               });
            }
         }

//         pop.add(new App.TransactionAction("Add dependency", app) {
//            @Override
//            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//            }
//         });
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      return null;
   }

   private Element parseXml(String xml) throws ParserConfigurationException, SAXException, IOException {
      final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      final InputSource is = new InputSource();
      is.setCharacterStream(new StringReader(xml));
      return db.parse(is).getDocumentElement();
   }

   private Node traverse(org.w3c.dom.Node node, Node parentNode) {
      switch (node.getNodeType()) {

         case org.w3c.dom.Node.ELEMENT_NODE: {
            final Element element = (Element) node;

            final Node newNode = getGraph().newNode(Label.label(element.getTagName()), AppMotif.Properties.name.name(), element.getTagName());
            if (parentNode != null) relate(parentNode, newNode, RelationshipType.withName(element.getTagName()));

            final NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++)
               traverse(childNodes.item(i), newNode);
            return newNode;
         }

         case org.w3c.dom.Node.TEXT_NODE: {
            final Text text = (Text) node;
            if (text.getWholeText().trim().length() == 0) break;

            final Node valueNode = getGraph().newNode(DomainPlugin.Entities.Value, AppMotif.Properties.name.name(), text.getWholeText());
            relate(parentNode, valueNode, RelationshipType.withName(getString(parentNode, AppMotif.Properties.name.name())));
            return valueNode;
         }
      }

      return null;
   }
}
