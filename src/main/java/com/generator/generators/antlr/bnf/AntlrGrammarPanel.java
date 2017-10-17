package com.generator.generators.antlr.bnf;

import com.generator.app.AppMotif;
import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.parser.*;
import com.generator.util.FileUtil;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Node;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created 09.10.17.
 */
public class AntlrGrammarPanel extends JPanel {

   private ANTLRv4ParserRenderer model;

   private final Map<String, AntlrGrammarSymbol> ruleSpecs = new ConcurrentHashMap<>();
   private final Map<AntlrGrammarSymbol, Rectangle2D> shapeMap = new ConcurrentHashMap<>();
   private final PropertyChangeSupport modelChangeSupport = new PropertyChangeSupport(this);
   private Dimension grammarSpecSize = new Dimension(400, 600);
   private final JTextArea textArea = new JTextArea();
   private final GrammarTreePanel grammarTree = new GrammarTreePanel(textArea);

   // rendering-level
   private int level = 0;

   public AntlrGrammarPanel() {
      super(new BorderLayout());

      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      for (int i = 0; i < 10; i++) {
         final int lvl = i;
         commandPanel.add(new JButton(new AbstractAction("" + lvl) {
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
      scrollPane.getVerticalScrollBar().setBlockIncrement(50);

      //      add(scrollPane, BorderLayout.CENTER);
      add(grammarTree, BorderLayout.WEST);

      final JScrollPane jScrollPane = new JScrollPane(textArea);
      jScrollPane.setPreferredSize(new Dimension(400,600));
      add(jScrollPane, BorderLayout.EAST);

      final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, jScrollPane);
      add(split, BorderLayout.CENTER);

      modelChangeSupport.addPropertyChangeListener(evt -> requestRepaint());

      bnfPanel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {

               final JPopupMenu pop = new JPopupMenu();

               for (Map.Entry<AntlrGrammarSymbol, Rectangle2D> entry : shapeMap.entrySet()) {
                  if (!entry.getValue().contains(e.getX(), e.getY())) continue;
                  final JMenu symbolMenu = new JMenu(entry.getKey().label == null ? entry.getKey().type() : entry.getKey().label);
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

                        final ANTLRv4ParserRenderer.RuleSpec newRuleSpec = model.newRuleSpec(name, "", "");

                        for (AntlrGrammarNode child : model.getGrammarSpec().children) {
                           AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;
                           if (symbol instanceof ANTLRv4ParserRenderer.Rules) {
                              ((ANTLRv4ParserRenderer.Rules) symbol).addRuleSpec(newRuleSpec);
                              requestRepaint();
                              return;
                           }
                        }

                        final ANTLRv4ParserRenderer.Rules rules = model.newRules(name, "", "");
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
                     model = new ANTLRv4ParserRenderer();
                     requestRepaint();
                  }
               });

               pop.add(new AbstractAction("Set Model") {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                     final File file = SwingUtil.showOpenFile(AntlrGrammarPanel.this, "/home/goe/projects/nextgen/src/main/java/com/generator/generators/csv/parser");
                     if (file == null || !file.getName().endsWith(".g4")) return;

                     try {
                        setModel(file);
                     } catch (IOException e1) {
                        SwingUtil.showException(AntlrGrammarPanel.this, e1);
                     }
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(bnfPanel, e.getX(), e.getY()));
            }
         }
      });
   }

   public ANTLRv4ParserRenderer.GrammarSpec getGrammarSpec() {
      return model.getGrammarSpec();
   }

   private void requestRepaint() {
      if (isVisible())
         SwingUtilities.invokeLater(() -> {
            shapeMap.clear();
            repaint();
         });
   }

   public void setModel( AntlrGrammarModel model) {

   }

   public AntlrGrammarPanel setModel(File file) throws IOException {

      final File[] grammarFiles = FileUtil.list(file.getParent(), ".g4");

      final GrammarTreePanel.GrammarTreeParserNodeListener grammarTreeParserNodeListener = grammarTree.newParserNodeListener(file.getName());
      final ANTLRv4ParserRenderer grammarModel = newParserRenderer();

      for (File grammarFile : grammarFiles) {
         new ParseTreeWalker().walk(grammarModel.getParserListener(), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath())))).grammarSpec());
         new ParseTreeWalker().walk(grammarTreeParserNodeListener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath())))).grammarSpec());
      }

      grammarTree.setModel(grammarTreeParserNodeListener);

      this.model = grammarModel;
      requestRepaint();

      return this;
   }

   public AntlrGrammarPanel setModel(Node node) {

      ruleSpecs.clear();

      final GrammarTreePanel.GrammarTreeParserDomainVisitor grammarTreeParserDomainVisitor = grammarTree.newParserDomainVisitor();
      final ANTLRv4ParserRenderer grammarModel = newParserRenderer();

      grammarModel.getDomainVisitor().visit(node);
      grammarTreeParserDomainVisitor.visit(node);

      this.model = grammarModel;
      requestRepaint();

      return this;
   }

   @NotNull
   private ANTLRv4ParserRenderer newParserRenderer() {
      return new ANTLRv4ParserRenderer() {

         @Override
         public EbnfSuffix newEbnfSuffix(String text, String startToken, String endToken) {
            final EbnfSuffix ebnfSuffix = super.newEbnfSuffix(text, startToken, endToken);
            if (symbolStack.peek() instanceof BlockSuffix) {
               final AntlrGrammarSymbol blockSuffix = symbolStack.pop();
               symbolStack.peek().ebnf = ebnfSuffix.getStartToken();
               symbolStack.push(blockSuffix);
            } else {
               symbolStack.peek().ebnf = ebnfSuffix.getStartToken();
            }
            return ebnfSuffix;
         }

         @Override
         public ParserRuleSpec newParserRuleSpec(String text, String startToken, String endToken) {
            final ParserRuleSpec parserRuleSpec = super.newParserRuleSpec(text, startToken, endToken);
            ruleSpecs.put(parserRuleSpec.label, parserRuleSpec);
            return parserRuleSpec;
         }

         @Override
         public LexerRuleSpec newLexerRuleSpec(String text, String startToken, String endToken) {
            final LexerRuleSpec lexerRuleSpec = super.newLexerRuleSpec(text, startToken, endToken);
            ruleSpecs.put(lexerRuleSpec.label, lexerRuleSpec);
            return lexerRuleSpec;
         }

         @Override
         public GrammarSpec newGrammarSpec(String value, String startToken, String endToken) {
            return new GrammarSpec(value, startToken, endToken) {
               @Override
               public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

                  double startX = bounds.getX();
                  double startY = bounds.getY();

                  double x = startX + bounds.getWidth();
                  double y = startY;
                  for (AntlrGrammarNode child : children) {
                     AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;

                     final Rectangle.Double rectangle = symbol.paint(x, y, g, shapeMap, level);

                     y += rectangle.getHeight() + 15;

                     double minX = Math.min(startX, rectangle.getX());
                     double maxX = Math.max(bounds.getX() + bounds.getWidth(), rectangle.getX() + rectangle.getWidth());
                     double minY = Math.min(startY, rectangle.getY());
                     double maxY = Math.max(bounds.getY() + bounds.getHeight(), rectangle.getY() + rectangle.getHeight());
                     bounds = new Rectangle.Double((int) minX, (int) minY, (int) (maxX - minX), (int) (maxY - minY));
                  }

                  return bounds;
               }

               @Override
               public Object toGrammar(AntlrGroup antlrGroup) {
                  final AntlrGroup.grammarST grammarST = antlrGroup.newgrammar().
                        setName(label);

                  for (AntlrGrammarNode ruleSpec : children) {
                     grammarST.addRulesValue(ruleSpec.toGrammar(antlrGroup));
                  }
                  return grammarST.toString();
               }
            };
         }

         @Override
         public Identifier newIdentifier(String text, String startToken, String endToken) {
            return new Identifier(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  return drawName(label, Color.BLUE, startX, startY, g, shapeMap);
               }
            };
         }

         @Override
         public Rules newRules(String value, String startToken, String endToken) {
            return new Rules(value, startToken, endToken) {
               @Override
               public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

                  double startX = bounds.getX();
                  double startY = bounds.getY();

                  double x = startX + bounds.getWidth();
                  double y = startY;
                  for (AntlrGrammarNode child : children) {
                     AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;
                     final Rectangle.Double rectangle = symbol.paint(x, y, g, shapeMap, level);

                     y += rectangle.getHeight() + 15;

                     double minX = Math.min(startX, rectangle.getX());
                     double maxX = Math.max(bounds.getX() + bounds.getWidth(), rectangle.getX() + rectangle.getWidth());
                     double minY = Math.min(startY, rectangle.getY());
                     double maxY = Math.max(bounds.getY() + bounds.getHeight(), rectangle.getY() + rectangle.getHeight());
                     bounds = new Rectangle.Double((int) minX, (int) minY, (int) (maxX - minX), (int) (maxY - minY));
                  }

                  return bounds;
               }
            };
         }

         @Override
         public RuleSpec newRuleSpec(String value, String startToken, String endToken) {

            final RuleSpec ruleSpec = new RuleSpec(value, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  return paintChildren(g, drawName(label, Color.decode("#e34a33"), startX, startY, g, shapeMap), shapeMap, level);
               }

               @Override
               public Object toGrammar(AntlrGroup antlrGroup) {
                  final AntlrGroup.grammarParserRuleSpecST ruleSpecST = antlrGroup.newgrammarParserRuleSpec().
                        setName(label);

                  for (AntlrGrammarNode child : children)
                     ruleSpecST.addAlternativesValue(child.toGrammar(antlrGroup));
                  return ruleSpecST;
               }
            };

            if (ruleSpec.getStartToken().equals("fragment"))
               ruleSpec.label = ruleSpec.getStartToken() + " " + ruleSpec.text.substring("fragment".length(), ruleSpec.text.indexOf(":"));

            return ruleSpec;
         }

         @Override
         public Ruleref newRuleref(String text, String startToken, String endToken) {
            return new Ruleref(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  final AntlrGrammarSymbol referenceSymbol = ruleSpecs.get(label);
                  if (level > 0 && referenceSymbol != null)
                     return referenceSymbol.paint(startX, startY, g, shapeMap, level - 1);
                  return paintChildren(g, drawName(label, Color.decode("#e34a33"), startX, startY, g, shapeMap), shapeMap, level);
               }
            };
         }

         @Override
         public Terminal newTerminal(String text, String startToken, String endToken) {
            return new Terminal(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  final AntlrGrammarSymbol referenceSymbol = ruleSpecs.get(label);
                  if (level > 0 && referenceSymbol != null)
                     return referenceSymbol.paint(startX, startY, g, shapeMap, level - 1);
                  return paintChildren(g, drawName(label, Color.decode("#33a02c"), startX, startY, g, shapeMap), shapeMap, level);
               }
            };
         }

         @Override
         public LexerAtom newLexerAtom(String text, String startToken, String endToken) {
            return new LexerAtom(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

                  for (AntlrGrammarNode child : children) {
                     AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;
                     if (symbol instanceof Terminal)
                        return drawName(label, Color.decode("#33a02c"), startX, startY, g, shapeMap);
//                     tokenValues.add("Terminal " + label);
                  }

                  return paintChildren(g, new Rectangle2D.Double(startX, startY, 0, 0), shapeMap, level);
               }
            };
         }

         @Override
         public CharacterRange newCharacterRange(String text, String startToken, String endToken) {
            return new CharacterRange(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  return paintChildren(g, drawName(text, Color.decode("#33a02c"), startX, startY, g, shapeMap), shapeMap, level);
               }
            };
         }

         @Override
         public NotSet newNotSet(String text, String startToken, String endToken) {
            return new NotSet(text, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  return paintChildren(g, drawName(label, Color.decode("#33a02c"), startX, startY, g, shapeMap), shapeMap, level);
               }
            };
         }

         @Override
         public SetElement newSetElement(String value, String startToken, String endToken) {
            return new SetElement(value, startToken, endToken) {
               @Override
               public Rectangle.Double paint(double startX, double startY, Graphics2D g, Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
                  final Rectangle.Double nameBox = drawName(label, Color.decode("#33a02c"), startX, startY, g, shapeMap);
                  return paintChildren(g, nameBox, shapeMap, level);
               }
            };
         }

         @Override
         public RuleAltList newRuleAltList(String value, String startToken, String endToken) {
            return new RuleAltList(value, startToken, endToken) {
               @Override
               public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

                  double startX = bounds.getX();
                  double startY = bounds.getY();

                  double lineStart = startX + bounds.getWidth();

                  double x = startX + bounds.getWidth();
                  double y = startY;

                  final Set<Rectangle2D.Double> childRect = new LinkedHashSet<>();
                  for (AntlrGrammarNode child : children) {
                     AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;
                     final Rectangle.Double rectangle = symbol.paint(x, y, g, shapeMap, level);
                     childRect.add(rectangle);
                     y += rectangle.getHeight() + 15;

                     double minX = Math.min(startX, rectangle.getX());
                     double maxX = Math.max(bounds.getX() + bounds.getWidth(), rectangle.getX() + rectangle.getWidth());
                     double minY = Math.min(startY, rectangle.getY());
                     double maxY = Math.max(bounds.getY() + bounds.getHeight(), rectangle.getY() + rectangle.getHeight());
                     bounds = new Rectangle.Double((int) minX, (int) minY, (int) (maxX - minX), (int) (maxY - minY));
                  }

                  if (childRect.size() > 1) {
                     g.setColor(Color.decode("#2b8cbe"));
                     g.drawLine((int) lineStart, (int) bounds.getY() + 10, (int) lineStart, (int) (startY + bounds.getHeight() - 15));
                     g.drawLine((int) (bounds.getX() + bounds.getWidth()), (int) (startY + bounds.getHeight() - 15), (int) (bounds.getX() + bounds.getWidth()), (int) bounds.getY() + 10);
                     // for each symbol- extend the line to (bounds.getX() + bounds.getWidth())
                     final int offset = 10;
                     for (Rectangle2D.Double rectangle : childRect)
                        g.drawLine((int) (rectangle.getX() + rectangle.getWidth()), (int) rectangle.getY() + offset, (int) (bounds.getX() + bounds.getWidth()), (int) rectangle.getY() + offset);
                  }
                  return bounds;
               }
            };
         }

         @Override
         public LexerAltList newLexerAltList(String value, String startToken, String endToken) {
            return new LexerAltList(value, startToken, endToken) {
               @Override
               public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

                  double startX = bounds.getX();
                  double startY = bounds.getY();

                  double lineStart = startX + bounds.getWidth();

                  double x = startX + bounds.getWidth();
                  double y = startY;

                  final Set<Rectangle2D.Double> childRect = new LinkedHashSet<>();
                  for (AntlrGrammarNode child : children) {
                     AntlrGrammarSymbol symbol = (AntlrGrammarSymbol) child;
                     final Rectangle.Double rectangle = symbol.paint(x, y, g, shapeMap, level);
                     childRect.add(rectangle);
                     y += rectangle.getHeight() + 15;

                     double minX = Math.min(startX, rectangle.getX());
                     double maxX = Math.max(bounds.getX() + bounds.getWidth(), rectangle.getX() + rectangle.getWidth());
                     double minY = Math.min(startY, rectangle.getY());
                     double maxY = Math.max(bounds.getY() + bounds.getHeight(), rectangle.getY() + rectangle.getHeight());
                     bounds = new Rectangle.Double((int) minX, (int) minY, (int) (maxX - minX), (int) (maxY - minY));
                  }
                  if (childRect.size() > 1) {
                     g.setColor(Color.decode("#2b8cbe"));
                     g.drawLine((int) lineStart, (int) bounds.getY() + 10, (int) lineStart, (int) (startY + bounds.getHeight() - 15));
                     g.drawLine((int) (bounds.getX() + bounds.getWidth()), (int) (startY + bounds.getHeight() - 15), (int) (bounds.getX() + bounds.getWidth()), (int) bounds.getY() + 10);
                     // for each symbol- extend the line to (bounds.getX() + bounds.getWidth())
                     final int offset = 10;
                     for (Rectangle2D.Double rectangle : childRect)
                        g.drawLine((int) (rectangle.getX() + rectangle.getWidth()), (int) rectangle.getY() + offset, (int) (bounds.getX() + bounds.getWidth()), (int) rectangle.getY() + offset);
                  }
                  return bounds;
               }
            };
         }
      };
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

         if (model == null || model.getGrammarSpec() == null) return;

         final ANTLRv4ParserRenderer.GrammarSpec grammarSpec = model.getGrammarSpec();
         final Rectangle2D.Double shape = grammarSpec.paint(10, 10, (Graphics2D) g, shapeMap, level);
         if (shape != null) {
            shapeMap.put(grammarSpec, shape);

            if (grammarSpecSize != null && ((int) grammarSpecSize.getWidth() == (int) (shape.width + 50)) && ((int) grammarSpecSize.getHeight() == (int) (shape.height + 50)))
               return;

            grammarSpecSize = new Dimension((int) shape.width + 50, (int) shape.height + 50);
            setSize(grammarSpecSize);
            setMinimumSize(grammarSpecSize);
            setMaximumSize(grammarSpecSize);
            setPreferredSize(grammarSpecSize);
         }
      }
   }

   private static final class GrammarTreePanel extends JPanel {

      private final JTree informationTree;

      GrammarTreePanel(JTextArea textArea) {
         super(new BorderLayout());

         informationTree = new JTree(new InformationNode()) {{

            setRootVisible(true);

            setCellRenderer(new DefaultTreeCellRenderer() {
               @Override
               public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                  final InformationNode nodeEntry = (InformationNode) value;
                  return super.getTreeCellRendererComponent(tree, nodeEntry.label(), sel, expanded, leaf, row, hasFocus);
               }
            });

            addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  final TreePath selectionPath = ((JTree) e.getSource()).getSelectionPath();
                  if (selectionPath == null) {
                     if (SwingUtilities.isRightMouseButton(e)) {
                        final JPopupMenu pop = new JPopupMenu();

//                        for (String name : relationMap.keySet()) {
//                           pop.add(new AbstractAction("Visit all " + name) {
//                              @Override
//                              public void actionPerformed(ActionEvent e) {
//                                 final InformationNode root = (InformationNode) informationTree.getModel().getRoot();
//                                 final StringBuilder output = new StringBuilder();
//                                 root.visit(getDebugVisitor(output));
//                                 textArea.setText(output.toString());
//                                 textArea.setCaretPosition(0);
//                              }
//
//                              @NotNull
//                              TreeNodeVisitor getDebugVisitor(StringBuilder output) {
//                                 return new TreeNodeVisitor() {
//                                    @Override
//                                    public void visitNode(InformationNode node) {
//                                       if (node != null && node.label.equals(name)) {
//                                          output.append("\n").append(node.label);
//                                          node.visit(new TreeNodeVisitor() {
//                                             @Override
//                                             public void visitNode(InformationNode node) {
//                                                if (node.label != null) {
//                                                   output.append("\n\t").append(node.label).append(" ").append(node.node.value);
//                                                }
//                                                super.visitNode(node);
//                                             }
//                                          });
//                                       }
//
//                                       super.visitNode(node);
//                                    }
//                                 };
//                              }
//                           });
//                        }

                        if (pop.getComponentCount() == 0) return;
                        SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
                     }
                     return;
                  }
                  final InformationNode selectedNode = (InformationNode) selectionPath.getLastPathComponent();
                  if (selectedNode == null) return;
                  if (SwingUtilities.isRightMouseButton(e)) {
                     final JPopupMenu pop = new JPopupMenu();
                     selectedNode.addRightClickActions(pop, selectionPath, ((JTree) e.getSource()));
                     if (pop.getComponentCount() == 0) return;
                     SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
                  }
               }
            });
         }};
         add(new JScrollPane(informationTree), BorderLayout.CENTER);

         setPreferredSize(new Dimension(400, 600));
      }

      public GrammarTreeParserDomainVisitor newParserDomainVisitor() {
         return new GrammarTreePanel.GrammarTreeParserDomainVisitor();
      }

      public GrammarTreeParserNodeListener newParserNodeListener(String file) {
         return new GrammarTreePanel.GrammarTreeParserNodeListener(file);
      }

      private class InformationNode extends DefaultMutableTreeNode {

         private ANTLRv4ParserNodeListener.Node node;
         private Node neoNode;

         protected String label = "";

         public InformationNode() {
            label = "";
         }

         public InformationNode(ANTLRv4ParserNodeListener.Node node) {
            label = node == null ? "" : node.name;
            this.node = node;
         }

         public InformationNode(Node node) {
            label = NeoUtil.getString(node, AppMotif.Properties.name.name());
            this.neoNode = node;
         }

         public String label() {
            return label;
         }

         @Override
         public String toString() {
            return label;
         }

         void visit(TreeNodeVisitor visitor) {
            visitor.visitNode(this);
         }

         void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
            pop.add(new AbstractAction("Expand") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  expandNodes(source, 0, source.getRowCount());
               }
            });

            pop.add(new AbstractAction("Visit") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  InformationNode currentNode = (InformationNode) selectionPath.getLastPathComponent();

                  currentNode.visit(new TreeNodeVisitor() {
                     @Override
                     public void visitNode(InformationNode node) {
                        System.out.println(node == null ? "null" : node.label);
                        super.visitNode(node);
                     }
                  });
               }
            });
         }
      }

      public void setModel(GrammarTreeParserNodeListener listener) throws IOException {
         SwingUtilities.invokeLater(() -> {
            informationTree.setModel(new DefaultTreeModel(listener.getInformationNode()));
            expandNodes(informationTree, 0, informationTree.getRowCount());
         });
      }

      public class GrammarTreeParserDomainVisitor extends ANTLRv4ParserDomainVisitor {

         final Stack<InformationNode> treeNodeStack = new Stack<>();

         GrammarTreeParserDomainVisitor() {
            treeNodeStack.push(new InformationNode());
         }

         @Override
         public void visit(Node node) {
            super.visit(node);

            final InformationNode treeNode = new InformationNode(node);
            treeNodeStack.peek().add(treeNode);
            treeNodeStack.push(treeNode);
         }

//      @Override
//      protected void onExit() {
//         super.onExit();
//         if (treeNodeStack.isEmpty()) return;
//         treeNodeStack.pop();
//      }

         TreeNode getInformationNode() {
            return treeNodeStack.peek();
         }
      }

      public class GrammarTreeParserNodeListener extends ANTLRv4ParserNodeListener {

         final Stack<InformationNode> treeNodeStack = new Stack<>();

         GrammarTreeParserNodeListener(String name) {
            treeNodeStack.push(new InformationNode());
         }

         @Override
         protected void onEnter(Node node) {
            final InformationNode treeNode = new InformationNode(node);
            treeNodeStack.peek().add(treeNode);
            treeNodeStack.push(treeNode);
            super.onEnter(node);
         }

         @Override
         protected void onExit() {
            super.onExit();
            if (treeNodeStack.isEmpty()) return;
            treeNodeStack.pop();
         }

         TreeNode getInformationNode() {
            return treeNodeStack.peek();
         }
      }

      private static void expandNodes(JTree tree, int startingIndex, int rowCount) {

         for (int i = startingIndex; i < rowCount; ++i)
            tree.expandRow(i);

         if (tree.getRowCount() != rowCount)
            expandNodes(tree, rowCount, tree.getRowCount());
      }

      public static class TreeNodeVisitor {

         public void visitNode(InformationNode node) {
            visitChildren(node);
         }

         protected void visitChildren(InformationNode node) {
            if (node.getChildCount() >= 0)
               for (Enumeration e = node.children(); e.hasMoreElements(); )
                  visitNode((InformationNode) e.nextElement());
         }
      }
   }

   public static void main(String[] args) {
      SwingUtil.showPanel(new AntlrGrammarPanel());
   }
}