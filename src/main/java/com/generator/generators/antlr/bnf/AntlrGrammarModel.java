package com.generator.generators.antlr.bnf;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserDomain;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created 09.10.17.
 * BNF model for Antlr-grammar
 */
public class AntlrGrammarModel extends ANTLRv4ParserDomain {

   private final Map<String, Set<String>> distinctMap = new LinkedHashMap<>();

   // put RuleSpecs in map, to allow lookup:
   public Map<String, AntlrGrammarSymbol> ruleSpecs = new ConcurrentHashMap<>();

   public AntlrGrammarModel() {
      super(true);
   }

   public void showDistinct() {
      for (Map.Entry<String, Set<String>> entry : distinctMap.entrySet()) {
         System.out.println(entry.getKey());
         for (String s : entry.getValue()) {
            System.out.println("\t" + s);
         }
      }
   }

   @Override
   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) {
         final Set<String> children = distinctMap.computeIfAbsent(nodeStack.peek().name, k -> new LinkedHashSet<>());
         children.add(node.name);
      }
      super.onEnter(node);
   }

   @Override
   public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
      super.enterRuleSpec(arg);

      if (arg.getStart().getText().equals("fragment"))
         symbolStack.peek().label = arg.getStart().getText() + " " + arg.getText().substring("fragment".length(), arg.getText().indexOf(":"));
   }

   @Override
   public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
      super.enterParserRuleSpec(arg);
      ruleSpecs.put(symbolStack.peek().label, symbolStack.peek());
   }

   @Override
   public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
      super.enterLexerRuleSpec(arg);
      ruleSpecs.put(symbolStack.peek().label, symbolStack.peek());
   }

   @Override
   public void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
      if (symbolStack.peek() instanceof BlockSuffix) {
         final AntlrGrammarSymbol blockSuffix = symbolStack.pop();
         symbolStack.peek().ebnf = arg.getStart().getText();
         symbolStack.push(blockSuffix);
      } else {
         symbolStack.peek().ebnf = arg.getStart().getText();
      }

      super.enterEbnfSuffix(arg);
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
            for (AntlrGrammarSymbol symbol : symbols) {
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

            for (AntlrGrammarSymbol ruleSpec : symbols) {
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
            for (AntlrGrammarSymbol symbol : symbols) {
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
      return new RuleSpec(value, startToken, endToken) {
         @Override
         public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
            return paintChildren(g, drawName(label, Color.decode("#e34a33"), startX, startY, g, shapeMap), shapeMap, level);
         }

         @Override
         public Object toGrammar(AntlrGroup antlrGroup) {
            final AntlrGroup.grammarParserRuleSpecST ruleSpecST = antlrGroup.newgrammarParserRuleSpec().
                  setName(label);

            for (AntlrGrammarSymbol symbol : symbols)
               ruleSpecST.addAlternativesValue(symbol.toGrammar(antlrGroup));
            return ruleSpecST;
         }
      };
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
   public LexerAtom newLexerAtom(String value, String startToken, String endToken) {
      return new LexerAtom(value, startToken, endToken) {
         @Override
         public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
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
            for (AntlrGrammarSymbol symbol : symbols) {
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
            for (AntlrGrammarSymbol symbol : symbols) {
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
}