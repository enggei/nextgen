package nextgen.st.canvas.layout;

import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;

import java.awt.geom.Rectangle2D;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CircleLayout<T> {

   private final Map<T, java.awt.geom.Rectangle2D.Double> nodeBounds = new LinkedHashMap<>();

   public CircleLayout(TreeForTreeLayout<T> tree, NodeExtentProvider<T> nodeExtendProvider) {

      final int centerX = 0;
      final int centerY = 0;
      final int radiusPerLevel = 1200;

      final T root = tree.getRoot();
      nodeBounds.put(root, new Rectangle2D.Double(centerX, centerY, nodeExtendProvider.getWidth(root), nodeExtendProvider.getHeight(root)));

      layout(root, centerX, centerY, radiusPerLevel, 2 * Math.PI, 2 * Math.PI, 1, tree, nodeExtendProvider);
   }

   private void layout(T node, int centerX, int centerY, int radius, double startAngle, double arcLength, int level, TreeForTreeLayout<T> tree, NodeExtentProvider<T> nodeExtendProvider) {

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

         nodeBounds.put(child, new Rectangle2D.Double(x, y, nodeExtendProvider.getWidth(child), nodeExtendProvider
               .getHeight(child)));

         layout(child, centerX, centerY, radius + (radius / level), currentArc, childRadians, level + 1, tree, nodeExtendProvider);

         currentArc += childRadians;
      }
   }

   private List<T> children(T node, TreeForTreeLayout<T> tree) {
      return StreamSupport
            .stream(tree.getChildren(node).spliterator(), false)
            .collect(Collectors.toList());
   }

   public Map<T, java.awt.geom.Rectangle2D.Double> getNodeBounds() {
      return nodeBounds;
   }
}