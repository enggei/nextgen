package com.generator.app.plugins;

import com.generator.app.App;
import com.generator.app.Workspace;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4NeoListener;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Set;

/**
 * Created 25.08.17.
 */
public class ANTLRPlugin extends DomainPlugin {

   public ANTLRPlugin(App app) {
      super(app, "ANTLR");
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      menu.add(new App.TransactionAction("Import grammar", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File grammarFile = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
            if (grammarFile == null || !grammarFile.getName().toLowerCase().endsWith(".g4")) return;

            final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath()))));

            final ANTLRv4NeoListener listener = new ANTLRv4NeoListener(getGraph());
            new ParseTreeWalker().walk(listener, parser.grammarSpec());

            final Node root = listener.getRoot();
            if(root==null) return;

            fireNodesLoaded(root);
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

   }
}
