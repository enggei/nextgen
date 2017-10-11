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
   private final Map<AntlrSymbol, Rectangle2D> shapeMap = new ConcurrentHashMap<>();

   private final PropertyChangeSupport modelChangeSupport = new PropertyChangeSupport(this);
   private Dimension grammarSpecSize = new Dimension(1200, 640);

   public AntlrGrammarPanel() {
      super(null);
      setPreferredSize(grammarSpecSize);

      modelChangeSupport.addPropertyChangeListener(evt -> requestRepaint());

      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {

               final JPopupMenu pop = new JPopupMenu();

               for (Map.Entry<AntlrSymbol, Rectangle2D> entry : shapeMap.entrySet()) {
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

                        for (AntlrSymbol symbol : model.getGrammarSpec().symbols) {
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

               SwingUtilities.invokeLater(() -> pop.show(AntlrGrammarPanel.this, e.getX(), e.getY()));
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

   public static AntlrGrammarModel parseAntlrFile(File file, JComponent parent) {
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

   @Override
   protected void paintComponent(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, getWidth(), getHeight());

      if (model == null) return;

      final ANTLRv4ParserDomain.GrammarSpec grammarSpec = model.getGrammarSpec();
      final Rectangle2D.Double shape = grammarSpec.paint(10, 10, (Graphics2D) g, shapeMap);
      if (shape != null) {
         shapeMap.put(grammarSpec, shape);
         grammarSpecSize = new Dimension((int) shape.width + 50, (int) shape.height + 50);
         setSize(grammarSpecSize);
         setMinimumSize(grammarSpecSize);
         setMaximumSize(grammarSpecSize);
         setPreferredSize(grammarSpecSize);
      }
   }

   public static void main(String[] args) {
      final AntlrGrammarPanel component = new AntlrGrammarPanel();
      final JScrollPane scrollPane = new JScrollPane(component);
      SwingUtil.showPanel(scrollPane);
   }
}