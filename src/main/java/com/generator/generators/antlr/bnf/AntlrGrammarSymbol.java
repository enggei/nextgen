package com.generator.generators.antlr.bnf;

import com.generator.generators.antlr.parser.AntlrGrammarNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeSupport;

/**
 * Created 09.10.17.
 */
public class AntlrGrammarSymbol extends AntlrGrammarNode {

   // rectangle-offset
   private final int offset = 10;
   private final int margin = 5;

   AntlrGrammarSymbol(String type, String label, String value, String startToken, String endToken) {
      super(type, label, value, startToken, endToken);
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

   public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {
//      final Rectangle2D.Double bounds = drawName(type + " (" + name + ")", Color.BLUE, startX, startY, g, shapeMap);
//      return paintChildren(g, bounds, shapeMap);
      return paintChildren(g, new Rectangle2D.Double(startX, startY, 0, 0), shapeMap, level);
   }

   public Rectangle.Double paintChildren(Graphics2D g, Rectangle.Double bounds, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap, int level) {

      double startX = bounds.getX();
      double startY = bounds.getY();

      double x = startX + bounds.getWidth();
      for (AntlrGrammarNode child : children) {
         final AntlrGrammarSymbol symbol = (AntlrGrammarSymbol)child;

         final Rectangle.Double rectangle = symbol.paint(x, startY, g, shapeMap, level);
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

      if ("*".equals(ebnf) || "*?".equals(ebnf)) {
         g.setColor(Color.decode("#2b8cbe"));
         g.drawLine((int) startX, (int) startY + offset, (int) startX, (int) startY - margin);
         g.drawLine((int) startX, (int) startY - margin, (int) (startX + children.width), (int) startY - margin);
         g.drawLine((int) (startX + children.width), (int) startY - margin, (int) (startX + children.width), (int) startY + offset);

         g.setColor(Color.decode("#2b8cbe"));
         g.drawLine((int) startX, (int) startY + offset, (int) startX, (int) startY + (margin * 2 + offset * 2));
         g.drawLine((int) startX, (int) startY + (margin * 2 + offset * 2), (int) (startX + children.width), (int) startY + (margin * 2 + offset * 2));
         g.drawLine((int) (startX + children.width), (int) startY + (margin * 2 + offset * 2), (int) (startX + children.width), (int) startY + offset);

         return children;

      } else if ("?".equals(ebnf)) {
         g.setColor(Color.decode("#2b8cbe"));
         g.drawLine((int) startX, (int) startY + offset, (int) startX, (int) startY + (margin * 2 + offset * 2));
         g.drawLine((int) startX, (int) startY + (margin * 2 + offset * 2), (int) (startX + children.width), (int) startY + (margin * 2 + offset * 2));
         g.drawLine((int) (startX + children.width), (int) startY + (margin * 2 + offset * 2), (int) (startX + children.width), (int) startY + offset);
         return children;

      } else if ("+".equals(ebnf)) {
         g.setColor(Color.decode("#2b8cbe"));
         g.drawLine((int) startX, (int) startY + offset, (int) startX, (int) startY - margin);
         g.drawLine((int) startX, (int) startY - margin, (int) (startX + children.width), (int) startY - margin);
         g.drawLine((int) (startX + children.width), (int) startY - margin, (int) (startX + children.width), (int) startY + offset);
         return children;
      }

      return children;
   }

   Rectangle.Double drawName(String content, Color color, double x, double y, Graphics2D g, java.util.Map<AntlrGrammarSymbol, Rectangle2D> shapeMap) {

      if (content == null) return new Rectangle2D.Double(x, y, 0, 0);

      final int w = g.getFontMetrics().stringWidth(content);
      final int h = g.getFontMetrics().getHeight();

      final Rectangle.Double rectangle = new Rectangle.Double(x + offset, y, w + (margin * 2), h + (margin * 2));
      g.setColor(color);
      g.draw(rectangle);
      g.drawString(content, (int) x + margin + offset, (int) y + (margin * 2) + (h / 2));

      // lines / io
      g.drawLine((int) x, (int) y + offset, (int) x + offset, (int) y + offset);
      g.drawLine((int) (x + offset + rectangle.width), (int) y + offset, (int) (x + offset + rectangle.width + offset), (int) y + offset);

      final Rectangle2D.Double shape = new Rectangle.Double(x, y, rectangle.width + (offset * 2), rectangle.height);
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
            parent.children.remove(AntlrGrammarSymbol.this);
            modelChangeSupport.firePropertyChange(label == null ? type : label, "remove", AntlrGrammarSymbol.this);
         }
      });
   }
}