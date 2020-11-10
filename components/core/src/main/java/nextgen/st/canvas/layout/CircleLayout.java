package nextgen.st.canvas.layout;

public class CircleLayout<T> {

   private final java.util.Map<T, java.awt.geom.Rectangle2D.Double> nodeBounds = new java.util.LinkedHashMap<>();

   public CircleLayout(org.abego.treelayout.TreeForTreeLayout<T> tree, org.abego.treelayout.NodeExtentProvider<T> nodeExtendProvider) {

      final int centerX = 0;
      final int centerY = 0;
      final int radiusPerLevel = 1200;

      final T root = tree.getRoot();
      nodeBounds.put(root, new java.awt.geom.Rectangle2D.Double(centerX, centerY, nodeExtendProvider.getWidth(root), nodeExtendProvider.getHeight(root)));

      layout(root, centerX, centerY, radiusPerLevel, 2 * Math.PI, 2 * Math.PI, 1, tree, nodeExtendProvider);
   }

   private void layout(T node, int centerX, int centerY, int radius, double startAngle, double arcLength, int level, org.abego.treelayout.TreeForTreeLayout<T> tree, org.abego.treelayout.NodeExtentProvider<T> nodeExtendProvider) {

      int totalChildren = 0;
      for (int i = 0; i < children(node, tree).size(); i++)
         totalChildren += children(children(node, tree).get(i), tree).size() + 1;

      double currentArc = startAngle;
      for (int i = 0; i < children(node, tree).size(); i++) {
         final T child = children(node, tree).get(i);
         final double childProportion = (double) (children(child,tree).size() + 1) / (double) totalChildren;
         double childRadians = (arcLength * childProportion);
         final double sin = Math.sin(currentArc + (childRadians / 2));
         final double cos = Math.cos(currentArc + (childRadians / 2));

         double x = centerX + (int) (radius * sin);
         double y = centerY + (int) (radius * cos);

         nodeBounds.put(child, new java.awt.geom.Rectangle2D.Double(x, y, nodeExtendProvider.getWidth(child), nodeExtendProvider
               .getHeight(child)));

         layout(child, centerX, centerY, radius + (radius / level), currentArc, childRadians, level + 1, tree, nodeExtendProvider);

         currentArc += childRadians;
      }
   }

   private java.util.List<T> children(T node, org.abego.treelayout.TreeForTreeLayout<T> tree) {
      return java.util.stream.StreamSupport
            .stream(tree.getChildren(node).spliterator(), false)
            .collect(java.util.stream.Collectors.toList());
   }

   public java.util.Map<T, java.awt.geom.Rectangle2D.Double> getNodeBounds() {
      return nodeBounds;
   }
}