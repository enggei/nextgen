package com.generator.generators.templates.debug;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * User: goe
 * Date: 20.02.14
 */
public class DebugPanel extends JPanel {

   private final Stack<Node> nodes = new Stack<>();
   private int depth = -1;

   public DebugPanel(String file) throws IOException {

      nodes.push(new Node(-1, -1, file));

      FileUtil.readString(file, new FileUtil.LineHandler() {

			@Override
			public boolean handleLine(String line) {
				if (line.length() == 0) {
					while (nodes.size() > 2) nodes.pop();
					return false;
				}

				final String[] t = line.split("[|]");
				try {
					final Node newNode = new Node(getLevel(t[0], depth == -1), Integer.valueOf(t[1]), t[2]);

					if (depth < newNode.level) depth = newNode.level;

					int deltaLevel = newNode.level - nodes.peek().level;

					if (deltaLevel > 0) // child
						nodes.peek().add(newNode);
					else if (deltaLevel < 0) {// end of branch
						for (int i = 0; i < Math.abs(deltaLevel); i++)
							nodes.pop();
						nodes.pop();
						nodes.peek().add(newNode);
					} else {// peers
						nodes.pop();
						nodes.peek().add(newNode);
					}

					nodes.push(newNode);

				} catch (Exception e) {
					System.out.println(line);
				}
				return false;
			}

			private int getLevel(String s, boolean isFirst) {
				int level = 0;
				for (char c : s.toCharArray())
					if ('\t' == c) level++;
				return isFirst ? 1 : level;
			}
		});

      while (nodes.size() > 1) nodes.pop();

      for (String s : nodes.peek().getPaths(new StringBuilder(""))) {
         System.out.println(s);
      }

      setPreferredSize(new Dimension(1024, 768));
   }

   private final class Node {

      private final int level;
      private final int type;
      private final String value;
      private final List<Node> children = new ArrayList<>();

      private int x;
      private int y;

      private Node(int level, int type, String value) {
         this.level = level;
         this.type = type;
         this.value = value;
      }

      Set<String> getPaths(StringBuilder path) {

         if (this.type != -1)
            path.append(path.length()==0 ? "" :  "->").append(this.type);

         final Set<String> paths = new TreeSet<>();
         if (children.isEmpty())
            return Collections.singleton(path.toString());

         for (Node child : children) {
            paths.addAll(child.getPaths(new StringBuilder(path.toString())));
         }
         return paths;
      }

      Node add(Node child) {
         this.children.add(child);
         return this;
      }

      public void paint(Graphics g) {
         //todo set color by type
         g.setColor(type == 22 ? Color.WHITE : Color.BLACK);
         g.fillOval(x, y, 16, 16);
         g.drawString(value + "", (int) getCenterX(), (int) getCenterY());
      }

      @Override
      public String toString() {
         final StringBuilder out = new StringBuilder();
         for (int i = 0; i < level; i++) out.append("\t");
         return out.append("|").append(type).append("|").append(value).toString();
      }

      public double getCenterX() {
         return x + 8;
      }

      public double getCenterY() {
         return y + 8;
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, getWidth(), getHeight());

      final int centerX = getWidth() / 2;
      final int centerY = getHeight() / 2;
      final int maxRadius = 1000;
      final int radiusPerLevel = maxRadius / (depth + 1);

      final Node root = nodes.peek();

      root.x = centerX;
      root.y = centerY;

      paint(root, g, (int) root.getCenterX(), (int) root.getCenterY(), radiusPerLevel, 2 * Math.PI, 2 * Math.PI, 1);
   }

   private void paint(Node node, Graphics g, int centerX, int centerY, int radius, double startAngle, double arcLength, int level) {
      node.paint(g);

      int totalChildren = 0;
      for (int i = 0; i < node.children.size(); i++)
         totalChildren += (node.children.get(i).children.size() + 1);

      double currentArc = startAngle;
      for (int i = 0; i < node.children.size(); i++) {
         final Node child = node.children.get(i);
         final double childProportion = (double) (child.children.size() + 1) / (double) totalChildren;
         double childRadians = (arcLength * childProportion);
         final double sin = Math.sin(currentArc + (childRadians / 2));
         final double cos = Math.cos(currentArc + (childRadians / 2));

         child.x = centerX + (int) (radius * sin);
         child.y = centerY + (int) (radius * cos);
         paint(child, g, centerX, centerY, radius + (radius / level), currentArc, childRadians, level + 1);

         currentArc += childRadians;
      }

      g.setColor(Color.BLUE);
      for (int i = 0; i < node.children.size(); i++) {
         Node destination = i == (node.children.size() - 1) ? node.children.get(0) : node.children.get(i + 1);
         Point2D.Double sourceLocation = new Point2D.Double(node.getCenterX(), node.getCenterY());
         Point2D.Double destinationLocation = new Point2D.Double(destination.getCenterX(), destination.getCenterY());
         g.drawLine((int) sourceLocation.getX(), (int) sourceLocation.getY(), (int) destinationLocation.getX(), (int) destinationLocation.getY());
      }
   }

   public static void main(String[] args) throws IOException {

      final DebugPanel projectionPanel = new DebugPanel("src/com/generator/generators/templates/debug/parsed_debug.txt");

      final JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(projectionPanel, BorderLayout.CENTER);
      SwingUtil.show(frame);
   }
}