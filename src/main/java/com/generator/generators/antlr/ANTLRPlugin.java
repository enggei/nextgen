package com.generator.generators.antlr;

import com.generator.app.App;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.antlr.bnf.AntlrGrammarModel;
import com.generator.generators.antlr.bnf.AntlrGrammarPanel;
import com.generator.generators.antlr.bnf.AntlrGrammarSymbol;
import com.generator.generators.antlr.parser.*;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Set;

import static com.generator.util.NeoUtil.hasLabel;

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

      menu.add(new App.TransactionAction("New Grammar", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final AntlrGrammarPanel grammarPanel = new AntlrGrammarPanel(new AntlrGrammarModel());
            SwingUtil.showDialog(grammarPanel, app, "Grammar Panel", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  final ANTLRv4ParserDomain.GrammarSpec grammarSpec = grammarPanel.getGrammarSpec();
                  if(grammarSpec==null) return;

                  fireNodesLoaded(visit(grammarSpec));
               }

               Node visit(AntlrGrammarSymbol symbol) {
                  final Node newNode = getGraph().newNode(Label.label(symbol.type()), "text", symbol.getText(), "startToken", symbol.getStartToken(), "endtoken", symbol.getEndToken());
                  for (AntlrGrammarSymbol child : symbol.symbols)
                     newNode.createRelationshipTo(visit(child), RelationshipType.withName("child"));
                  return newNode;
               }
            });
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      if (hasLabel(neoNode.getNode(), Entities.GrammarSpec)) {
         pop.add(new App.TransactionAction("Edit", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               AntlrGrammarModel grammarModel = new AntlrGrammarModel();
               final ANTLRv4ParserGrammarVisitor visitor =new ANTLRv4ParserGrammarVisitor(grammarModel) {

                  @Override
                  public void visitGrammarSpec(Node node) {
                     final ANTLRv4ParserDomain.GrammarSpec symbol = grammarModel.newGrammarSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
                     if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
                     grammarModel.symbolStack.push(symbol);
                     symbolStack.push(symbol);
                     super.visitGrammarSpec(node);
                     if (symbolStack.size() > 1) symbolStack.pop();
                  }

                  @Override
                  public void visitEbnfSuffix(Node node) {

                     if (symbolStack.peek() instanceof ANTLRv4ParserDomain.BlockSuffix) {
                        final AntlrGrammarSymbol blockSuffix = symbolStack.pop();
                        symbolStack.peek().ebnf = NeoUtil.getString(node, "startToken");
                        symbolStack.push(blockSuffix);
                     } else {
                        symbolStack.peek().ebnf = NeoUtil.getString(node, "startToken");
                     }

                     super.visitEbnfSuffix(node);
                  }

                  @Override
                  public void visitParserRuleSpec(Node node) {
                     final ANTLRv4ParserDomain.ParserRuleSpec symbol = grammarModel.newParserRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
                     if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
                     symbolStack.push(symbol);
                     grammarModel.ruleSpecs.put(symbol.label, symbol);
                     super.visitParserRuleSpec(node);
                     if (symbolStack.size() > 1) symbolStack.pop();
                  }

                  @Override
                  public void visitLexerRuleSpec(Node node) {
                     final ANTLRv4ParserDomain.LexerRuleSpec symbol = grammarModel.newLexerRuleSpec(NeoUtil.getString(node, "text"), NeoUtil.getString(node, "startToken"), NeoUtil.getString(node, "endToken"));
                     if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
                     symbolStack.push(symbol);
                     grammarModel.ruleSpecs.put(symbol.label, symbol);
                     super.visitLexerRuleSpec(node);
                     if (symbolStack.size() > 1) symbolStack.pop();
                  }
               };
               visitor.visit(neoNode.getNode());

               final AntlrGrammarPanel grammarPanel = new AntlrGrammarPanel(grammarModel);

               SwingUtil.showDialog(grammarPanel, app, "Grammar Panel", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     System.out.println();
                  }
               });
            }
         });
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      if (hasLabel(neoNode.getNode(), Entities.GrammarSpec))
         return new GrammarEditor(neoNode);
      return null;
   }

   private final class GrammarEditor extends JPanel {
      GrammarEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final AntlrGroup antlrGroup = new AntlrGroup();
         final AntlrGroup.grammarST grammarST = antlrGroup.newgrammar();

         txtEditor.setText(grammarST.toString());
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }
}