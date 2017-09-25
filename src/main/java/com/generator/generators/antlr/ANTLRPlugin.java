package com.generator.generators.antlr;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.Workspace;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNeoVisitor;
import com.generator.generators.domain.DomainPlugin;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Created 25.08.17.
 */
public class ANTLRPlugin extends Plugin {

   enum Entities implements Label {
      GrammarSpec
   }

   public ANTLRPlugin(App app) {
      super(app, "ANTLR");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.GrammarSpec);

      menu.add(new App.TransactionAction("Import grammar", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File grammarFile = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
            if (grammarFile == null || !grammarFile.getName().toLowerCase().endsWith(".g4")) return;

            final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath()))));
            final ANTLRv4ParserNeoVisitor visitor = new ANTLRv4ParserNeoVisitor(getGraph());
            visitor.visit(parser.grammarSpec());
            if (visitor.getRoot() != null) fireNodesLoaded(visitor.getRoot());
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

   }

   @Override
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {
      incoming(neoNode.getNode(), DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {
         final Node instanceNode = other(neoNode.getNode(), instanceRelation);
         if (hasLabel(instanceNode, Entities.GrammarSpec)) {
            tabbedPane.add(getString(neoNode.getNode(), AppMotif.Properties.name.name()), new GrammarEditor(neoNode));
         }
      });
   }

   private final class GrammarEditor extends JPanel {
      GrammarEditor(Workspace.NodeCanvas.NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setCaretPosition(0);

         final StringBuilder out = new StringBuilder();

         // render grammar

         txtEditor.setText(out.toString().trim());

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }
}