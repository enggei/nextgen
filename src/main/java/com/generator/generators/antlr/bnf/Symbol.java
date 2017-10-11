package com.generator.generators.antlr.bnf;

import com.generator.generators.antlr.AntlrGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created 09.10.17.
 */
public class Symbol {

   private final UUID uuid = UUID.randomUUID();
   protected String type;

   public Symbol parent;
   public String label;
   public String ebnf = "";
   public String text;
   public String startToken;
   public String endToken;

   public final List<Symbol> symbols = new ArrayList<>();

   public Symbol(String type, String label, String value, String startToken, String endToken) {
      this.type = type;
      this.label = label;
      this.text = value;
      this.startToken = startToken;
      this.endToken = endToken;
   }

   public String getText() {
      return text;
   }

   public String getStartToken() {
      return startToken;
   }

   public String getEndToken() {
      return endToken;
   }

   public String type() {
      return type;
   }

   public Symbol setChild(Symbol symbol) {
      symbols.clear();
      symbols.add(symbol);
      symbol.parent = this;
      //visit(this, "");
      return this;
   }

   public Symbol addChild(Symbol symbol) {
      symbols.add(symbol);
      symbol.parent = this;
      //visit(this, "");
      return this;
   }

   protected void visit(Symbol symbol, String delim) {
      System.out.println(delim + symbol);
      for (Symbol child : symbol.symbols) {
         visit(child, delim + "\t");
      }
   }

   public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, Rectangle2D> shapeMap) {
//      final Rectangle2D.Double bounds = drawName(type + " (" + name + ")", Color.BLUE, startX, startY, g, shapeMap);
//      return paintChildren(g, bounds, shapeMap);
      return paintChildren(g, new Rectangle2D.Double(startX, startY, 0, 0), shapeMap);
   }

   public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<Symbol, Rectangle2D> shapeMap) {

      double startX = bounds.getX();
      double startY = bounds.getY();

      double x = startX + bounds.getWidth();
      for (Symbol symbol : symbols) {
         final Rectangle.Double rectangle = symbol.paint(x, startY, g, shapeMap);
         x += rectangle.getWidth();
         // calculate bounds of this.shape:
         double minX = Math.min(startX, rectangle.getX());
         double maxX = Math.max(bounds.getX() + bounds.getWidth(), rectangle.getX() + rectangle.getWidth());
         double minY = Math.min(startY, rectangle.getY());
         double maxY = Math.max(bounds.getY() + bounds.getHeight(), rectangle.getY() + rectangle.getHeight());
         int height = (int) (maxY - minY);
         bounds = new Rectangle.Double((int) minX, (int) minY, (int) (maxX - minX), height);
      }

      return paintEbnf(startX, startY, bounds, g);
   }

   private Rectangle2D.Double paintEbnf(double startX, double startY, Rectangle2D.Double children, Graphics2D g) {

      if ("*".equals(ebnf)) {
         g.setColor(Color.BLUE);
         g.drawLine((int) startX, (int) startY + 10, (int) startX, (int) startY - 5);
         g.drawLine((int) startX, (int) startY - 5, (int) (startX + children.width), (int) startY - 5);
         g.drawLine((int) (startX + children.width), (int) startY - 5, (int) (startX + children.width), (int) startY + 10);
         return children;

      } else if ("?".equals(ebnf)) {
         g.setColor(Color.BLUE);
         g.drawLine((int) startX, (int) startY + 10, (int) startX, (int) startY + 30);
         g.drawLine((int) startX, (int) startY + 30, (int) (startX + children.width), (int) startY + 30);
         g.drawLine((int) (startX + children.width), (int) startY + 30, (int) (startX + children.width), (int) startY + 10);
         return children;

      } else if ("+".equals(ebnf)) {
         g.setColor(Color.BLUE);
         g.drawLine((int) startX, (int) startY + 10, (int) startX, (int) startY - 5);
         g.drawLine((int) startX, (int) startY - 5, (int) (startX + children.width), (int) startY - 5);
         g.drawLine((int) (startX + children.width), (int) startY - 5, (int) (startX + children.width), (int) startY + 10);
         return children;
      }

      return children;
   }

   public Rectangle.Double drawName(String content, Color color, double x, double y, Graphics2D g, java.util.Map<Symbol, Rectangle2D> shapeMap) {
      if (content == null) return new Rectangle2D.Double(x, y, 0, 0);
      final int w = g.getFontMetrics().stringWidth(content);
      final int h = g.getFontMetrics().getHeight();
      final int margin = 5;
      final int offset = 10;
      final Rectangle.Double rectangle = new Rectangle.Double(x + offset, y, w + (margin * 2), h + (margin * 2));
      g.setColor(color);
      g.draw(rectangle);
      g.drawString(content, (int) x + margin + offset, (int) y + (margin * 2) + (h / 2));

      // lines / io
      g.drawLine((int) x, (int) y + offset, (int) x + offset, (int) y + offset);
      g.drawLine((int) (x + offset + rectangle.width), (int) y + offset, (int) (x + offset + rectangle.width + offset), (int) y + offset);

      final Rectangle2D.Double shape = new Rectangle.Double(x, y, rectangle.width + 20, rectangle.height);
      shapeMap.put(this, shape);
      return shape;
   }

   @Override
   public String toString() {
      return type;
   }

   public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
      menu.add(new AbstractAction("Remove " + (label == null ? type : label)) {
         @Override
         public void actionPerformed(ActionEvent e) {
            parent.symbols.remove(Symbol.this);
            modelChangeSupport.firePropertyChange(label == null ? type : label, "remove", Symbol.this);
         }
      });
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Symbol symbol = (Symbol) o;

      return uuid.equals(symbol.uuid);
   }

   @Override
   public int hashCode() {
      return uuid.hashCode();
   }

   public Object toGrammar(AntlrGroup antlrGroup) {
      final StringBuilder out = new StringBuilder();
      for (Symbol symbol : symbols) {
         final Object grammar = symbol.toGrammar(antlrGroup);
         if (grammar == null) continue;
         out.append(grammar);
      }
      return out.length() == 0 ? null : out.toString();
   }
}
