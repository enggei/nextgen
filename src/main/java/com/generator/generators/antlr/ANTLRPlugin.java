package com.generator.generators.antlr;

import com.generator.app.App;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserDomainVisitor;
import com.generator.generators.antlr.parser.ANTLRv4ParserNeoVisitor;
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
import java.util.Stack;

import static com.generator.util.NeoUtil.*;

/**
 * Created 25.08.17.
 */
public class ANTLRPlugin extends Plugin {

   enum Entities implements Label {
      GrammarSpec
   }

   enum Properties {
      text, startToken
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
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

   }

   @Override
   public void showEditorFor(NeoNode neoNode, JTabbedPane tabbedPane) {
      if (hasLabel(neoNode.getNode(), Entities.GrammarSpec))
         tabbedPane.add(getNameOrLabelFrom(neoNode.getNode()), new GrammarEditor(neoNode));
   }

   private final class GrammarEditor extends JPanel {
      GrammarEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);

         final AntlrGroup antlrGroup = new AntlrGroup();
         final AntlrGroup.grammarST grammarST = antlrGroup.newgrammar();

         new ANTLRv4ParserDomainVisitor() {

            final Stack<AntlrGroup.ruleST> ruleSTStack = new Stack<>();
            final Stack<AntlrGroup.blockST> blockSTStack = new Stack<>();

            @Override
            public void visitIdentifier(Node node) {
               grammarST.setName(getString(node, Properties.startToken.name()));
               super.visitIdentifier(node);
            }

            @Override
            public void visitRuleSpec(Node node) {
               final AntlrGroup.ruleST ruleST = antlrGroup.newrule().setName(getString(node, Properties.startToken.name()));
               ruleSTStack.push(ruleST);
               System.out.println("ruleST = " + ruleST);
               super.visitRuleSpec(node);
               grammarST.addRulesValue(ruleSTStack.pop());
            }

            @Override
            public void visitBlock(Node node) {
               final AntlrGroup.blockST blockST = antlrGroup.newblock();
               blockSTStack.push(blockST);
               super.visitBlock(node);
               ruleSTStack.peek().addAlternativesValue(blockST);
            }
         }.visit(node.getNode());

         txtEditor.setText(grammarST.toString());
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }
}