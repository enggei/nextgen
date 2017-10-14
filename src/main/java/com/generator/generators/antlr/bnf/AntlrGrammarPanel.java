package com.generator.generators.antlr.bnf;

import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserDomain;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created 09.10.17.
 */
public class AntlrGrammarPanel extends JPanel {

   private AntlrGrammarModel model;
   private final Map<AntlrGrammarSymbol, Rectangle2D> shapeMap = new ConcurrentHashMap<>();

   private final PropertyChangeSupport modelChangeSupport = new PropertyChangeSupport(this);
   private Dimension grammarSpecSize = new Dimension(1200, 640);

   // rendering-level
   private int level = 0;

   public AntlrGrammarPanel() {
      this(null);
   }

   public AntlrGrammarPanel(AntlrGrammarModel grammarModel) {
      super(new BorderLayout());

      this.model = grammarModel;

      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      for (int i = 0; i < 10; i++) {
         final int lvl = i;
         commandPanel.add(new JButton(new AbstractAction(""+lvl) {
            @Override
            public void actionPerformed(ActionEvent e) {
               level = lvl;
               requestRepaint();
            }
         }));
      }
      add(commandPanel, BorderLayout.NORTH);

      final BNFPanel bnfPanel = new BNFPanel();
      final JScrollPane scrollPane = new JScrollPane(bnfPanel);
      scrollPane.getVerticalScrollBar().setBlockIncrement(20);
      add(scrollPane, BorderLayout.CENTER);


      modelChangeSupport.addPropertyChangeListener(evt -> requestRepaint());

      bnfPanel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {

               final JPopupMenu pop = new JPopupMenu();

               for (Map.Entry<AntlrGrammarSymbol, Rectangle2D> entry : shapeMap.entrySet()) {
                  if (!entry.getValue().contains(e.getX(), e.getY())) continue;
                  final JMenu symbolMenu = new JMenu(entry.getKey().label == null ? entry.getKey().type : entry.getKey().label);
                  entry.getKey().addActionsTo(symbolMenu, modelChangeSupport);
                  pop.add(symbolMenu);
               }

               if (model != null) {
                  if (pop.getComponentCount() != 0) pop.addSeparator();

                  pop.add(new AbstractAction("Add Rule") {
                     @Override
                     public void actionPerformed(ActionEvent e) {

                        final String name = SwingUtil.showInputDialog("Name", AntlrGrammarPanel.this);
                        if (name == null || name.length() == 0) return;

                        final ANTLRv4ParserDomain.RuleSpec newRuleSpec = model.newRuleSpec(name, "", "");

                        for (AntlrGrammarSymbol symbol : model.getGrammarSpec().symbols) {
                           if (symbol instanceof ANTLRv4ParserDomain.Rules) {
                              ((ANTLRv4ParserDomain.Rules) symbol).addRuleSpec(newRuleSpec);
                              requestRepaint();
                              return;
                           }
                        }

                        final ANTLRv4ParserDomain.Rules rules = model.newRules(name, "", "");
                        model.getGrammarSpec().addRules(rules);
                        rules.addRuleSpec(newRuleSpec);
                        requestRepaint();
                     }
                  });

                  pop.add(new AbstractAction("Show Grammar") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        System.out.println(model.getGrammarSpec().toString());
                     }
                  });
               }

               if (pop.getComponentCount() != 0) pop.addSeparator();

               pop.add(new AbstractAction("New Model") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     setModel(new AntlrGrammarModel());
                  }
               });

               pop.add(new AbstractAction("Set Model") {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                     final File file = SwingUtil.showOpenFile(AntlrGrammarPanel.this, "/home/goe/projects/nextgen/src/main/java/com/generator/generators/json/parser/JSON.g4");
                     if (file == null || !file.getName().endsWith(".g4")) return;

                     setModel(parseAntlrFile(file, AntlrGrammarPanel.this));
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(bnfPanel, e.getX(), e.getY()));
            }
         }
      });
   }

   public ANTLRv4ParserDomain.GrammarSpec getGrammarSpec() {
      return model.getGrammarSpec();
   }

   public void setModel(AntlrGrammarModel model) {
      this.model = model;
      requestRepaint();
   }

   private void requestRepaint() {
      SwingUtilities.invokeLater(() -> {
         shapeMap.clear();
         repaint();
      });
   }

   private static AntlrGrammarModel parseAntlrFile(File file, JComponent parent) {
      final File[] grammarFiles = FileUtil.list(file.getParent(), ".g4");

      final AntlrGrammarModel listener = new AntlrGrammarModel();
      for (File grammarFile : grammarFiles) {
         try {
            new ParseTreeWalker().walk(listener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath())))).grammarSpec());
         } catch (IOException e1) {
            SwingUtil.showException("Could not parse " + grammarFile.getAbsolutePath(), e1, parent);
         }
      }

      listener.showDistinct();
      return listener;
   }

   private final class BNFPanel extends JPanel {

      BNFPanel() {
         super(null);
         setPreferredSize(grammarSpecSize);
      }

      @Override
      protected void paintComponent(Graphics g) {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());

         if (model == null) return;

         final ANTLRv4ParserDomain.GrammarSpec grammarSpec = model.getGrammarSpec();
         final Rectangle2D.Double shape = grammarSpec.paint(10, 10, (Graphics2D) g, shapeMap, level);
         if (shape != null) {
            shapeMap.put(grammarSpec, shape);

            if (grammarSpecSize != null && ((int) grammarSpecSize.getWidth() == (int) (shape.width + 50)) && ((int) grammarSpecSize.getHeight() == (int) (shape.height + 50)))
               return;

            System.out.println("paint grammarSpecSize " + grammarSpecSize);
            grammarSpecSize = new Dimension((int) shape.width + 50, (int) shape.height + 50);
            setSize(grammarSpecSize);
            setMinimumSize(grammarSpecSize);
            setMaximumSize(grammarSpecSize);
            setPreferredSize(grammarSpecSize);
         }
      }
   }

   public static void main(String[] args) {
      SwingUtil.showPanel(new AntlrGrammarPanel());
   }
}