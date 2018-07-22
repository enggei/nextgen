package com.nextgen.core;

import com.github.difflib.DiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.Chunk;
import com.github.difflib.patch.Delta;
import com.github.difflib.patch.Patch;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import org.abego.treelayout.Configuration;
import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.AbstractTreeForTreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.awt.event.KeyEvent.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public abstract class NodeCanvas extends PCanvas {

    protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NodeCanvas.class);

    private final PropertyChangeSupport canvasChangeSupport = new PropertyChangeSupport(this);
    private final PBasicInputEventHandler canvasInputListener;

    private final PLayer relationLayer = new PLayer();
    private final PLayer nodeLayer;

    NodeCanvas(Dimension preferredSize, Color background) {
        super();

        setPreferredSize(preferredSize);
        setBackground(background);

        nodeLayer = getLayer();
        getCamera().addLayer(0, relationLayer);

        removeInputEventListener(getZoomEventHandler());
        addInputEventListener(new CanvasZoomHandler());

        canvasInputListener = new PBasicInputEventHandler() {

            @Override
            public void mouseEntered(PInputEvent event) {
                if (!this.equals(event.getInputManager().getKeyboardFocus())) {
                    event.getInputManager().setKeyboardFocus(this);
                    requestFocusInWindow();
                }
            }

            @Override
            public void mouseExited(PInputEvent event) {
                event.getInputManager().setKeyboardFocus(null);
            }

            @Override
            public void mouseClicked(PInputEvent event) {

                if (!this.equals(event.getInputManager().getKeyboardFocus()))
                    event.getInputManager().setKeyboardFocus(this);

                if (event.isRightMouseButton()) {
                    final JPopupMenu pop = new JPopupMenu();
                    SwingUtilities.invokeLater(() -> {
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        addContextMenuActions(event, pop, getSelectedNodes(), getCurrentMousePosition(), NodeCanvas.this);
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        pop.show(NodeCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
                    });
                } else if (event.isLeftMouseButton()) {
                    unselectAll();
                }
            }

            @Override
            public void keyPressed(PInputEvent event) {
                onKeyPressed(event);
            }

            @Override
            public void mouseMoved(PInputEvent event) {
                invalidate();
                repaint();
            }
        };

        addInputEventListener(canvasInputListener);
    }

    protected PropertyChangeSupport getCanvasChangeSupport() {
        return canvasChangeSupport;
    }

    private Point getCurrentMousePosition() {
        final Point2D localToView = getCamera().localToView(getMousePosition());
        return new Point((int) localToView.getX(), (int) localToView.getY());
    }

    public Point getCenterPosition() {
        final Point2D center2D = getCamera().getViewBounds().getCenter2D();
        return new Point((int) center2D.getX(), (int) center2D.getY());
    }

    protected void onKeyPressed(PInputEvent event) {

        switch (event.getKeyCode()) {

            case VK_A:
                if (event.isControlDown())
                    invertSelection();
                else
                    selectAllNodes();
                break;

            case VK_C:
                closeNodes(getSelectedNodes());
                break;

            case VK_R:
                retainNodes(getSelectedNodes());
                break;

            case VK_E:
                getSelectedNodes().forEach(BasePNode::selectOutgoing);
                break;

            case VK_I:
                getSelectedNodes().forEach(BasePNode::selectIncoming);
                break;

            case VK_1:
                SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Left).layoutNodes(getSelectedNodes()));
                break;
            case VK_3:
                SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Right).layoutNodes(getSelectedNodes()));
                break;
            case VK_4:
                SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Top).layoutNodes(getSelectedNodes()));
                break;
            case VK_2:
                SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Bottom).layoutNodes(getSelectedNodes()));
                break;
        }
    }

    protected void addContextMenuActions(PInputEvent event, JPopupMenu pop, Set<BasePNode> selectedNodes, Point mousePosition, NodeCanvas canvas) {

        if (selectedNodes.size() > 0) {
            pop.add(new JMenuItem(new SwingAction("Close " + selectedNodes.size() + " selected node" + (selectedNodes.size() > 1 ? "s" : "")) {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    closeNodes(selectedNodes);
                }
            }));

            pop.add(new JMenuItem(new SwingAction("Retain " + selectedNodes.size() + " selected node" + (selectedNodes.size() > 1 ? "s" : "")) {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    retainNodes(getSelectedNodes());
                }
            }));
        }

        final Set<BasePNode> allNodes = getAllNodes();
        if (allNodes.size() > 1) {
            pop.add(new JMenuItem(new SwingAction("Close all " + allNodes.size() + " nodes") {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    closeNodes(allNodes);
                }
            }));
        }
    }

    public void addNode(BasePNode node, Layout layout) {
        addNodes(Collections.singleton(node), layout);
    }

    public void addNodes(Collection<BasePNode> nodes, Layout layout) {
        SwingUtilities.invokeLater(() -> {

            // do not allow duplicate nodes, makes no practical sense
            try {
                nodes.removeAll(getAllNodes());
            } catch (UnsupportedOperationException e) {
                // happens if Collections.singleton(node) is used as parameter, and the node already exists. Ignore.
                log.debug("redundant node");
                return;
            }

            for (BasePNode pNode : nodes) {
                pNode.setNodeChangeSupport(canvasChangeSupport);

                pNode.canvas = this;
                pNode.setInputEventListener(canvasInputListener);
            }

            if (layout != null)
                layout.layoutNodes(nodes);

            for (BasePNode node : nodes)
                nodeLayer.addChild(node);
        });
    }

    public void addRelation(Relation relation) {
        addRelations(Collections.singleton(relation));
    }

    public void addRelations(Collection<Relation> relations) {

        // do not allow duplicate relationships, makes no practical sense
        try {
            relations.removeAll(getAllRelations());
        } catch (UnsupportedOperationException e) {
            // happens if Collections.singleton(relation) is used as parameter, and the relation already exists. Ignore.
            log.debug("redundant relation");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            for (Relation relation : relations) {

                // get src and dst node from canvas:
                for (Object o : nodeLayer.getAllNodes()) {
                    if (!(o instanceof BasePNode)) continue;
                    BasePNode node = (BasePNode) o;
                    if (node.equals(relation.getSrc())) relation.setSrc(node);
                    if (node.equals(relation.getDst())) relation.setDst(node);
                }

                relation.changeSupport = canvasChangeSupport;
                relation.canvas = this;
                relation.setInputEventListener(canvasInputListener);

                relationLayer.addChild(relation);
            }

            invalidate();
            repaint();
        });
    }

    protected void addNodeAndRelation(BasePNode node, Relation relation, Layout layout) {
        addNode(node, layout);
        addRelation(relation);
    }

    protected void addNodesAndRelations(Set<BasePNode> nodes, Set<Relation> relations, Layout layout) {
        addNodes(nodes, layout);
        addRelations(relations);
    }

    private void closeNodes(Set<BasePNode> nodes) {
        SwingUtilities.invokeLater(() -> {
            for (BasePNode node : nodes) node.removeFromCanvas();
        });
    }

    public Set<BasePNode> getSelectedNodes() {
        return (Set<BasePNode>) nodeLayer.getAllNodes().stream().filter(o -> (o instanceof BasePNode) && ((BasePNode) o).getBooleanAttribute("selected", false)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    Set<BasePNode> getAllNodes() {
        return (Set<BasePNode>) nodeLayer.getAllNodes().stream().filter(o -> (o instanceof BasePNode)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    protected Set<Relation> getAllRelations() {
        return (Set<Relation>) relationLayer.getAllNodes().stream().filter(o -> (o instanceof Relation)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void unselectAll() {
        SwingUtilities.invokeLater(() -> {
            getAllNodes().forEach(BasePNode::unselect);
            getAllRelations().forEach(Relation::unselect);
        });
    }

    private void selectAllNodes() {
        SwingUtilities.invokeLater(() -> getAllNodes().forEach(BasePNode::select));
    }

    private void invertSelection() {
        SwingUtilities.invokeLater(() -> getAllNodes().forEach(BasePNode::toggleSelect));
    }

    private void retainNodes(Set<BasePNode> nodes) {
        final Set<BasePNode> nodesToClose = new LinkedHashSet<>(getAllNodes());
        nodesToClose.removeAll(nodes);
        closeNodes(nodesToClose);
    }

    BasePNode getNode(UUID uuid) {
        for (BasePNode basePNode : getAllNodes()) {
            if (uuid.equals(basePNode.getUUID())) return basePNode;
        }
        return null;
    }

    protected interface Layout {

        void layoutNodes(Collection<BasePNode> nodes);

    }

    public static class LayoutAtPosition implements Layout {

        private final Point2D position;

        public LayoutAtPosition(Point2D position) {
            this.position = position;
        }

        @Override
        public void layoutNodes(Collection<BasePNode> nodes) {
            for (BasePNode node : nodes)
                node.setOffset(position);
        }
    }

    public static class LayoutCircular implements Layout {

        private final Point2D center;
        private final int radius;

        public LayoutCircular(Point2D center, int radius) {
            this.center = center;
            this.radius = radius;
        }

//        public LayoutCircular(BasePNode centerNode) {
//            this.center = centerNode.getCenter();
//            this.radius = Math.max(200, (int) (2 * centerNode.getFullBounds().getWidth()));
//        }

        @Override
        public void layoutNodes(Collection<BasePNode> nodes) {

            if (nodes.size() == 1) {
                nodes.iterator().next().setOffset(center);
                return;
            }

            double currentArc = 2 * Math.PI;
            double arcLength = 2 * Math.PI;

            for (BasePNode node : nodes) {
                final double childProportion = 1d / (double) nodes.size();
                double childRadians = (arcLength * childProportion);
                final double sin = Math.sin(currentArc + (childRadians / 2));
                final double cos = Math.cos(currentArc + (childRadians / 2));
                double x = center.getX() + (int) (radius * sin);
                double y = center.getY() + (int) (radius * cos);
                node.setOffset(x, y);
                currentArc += childRadians;
            }
        }
    }

    public static class LayoutCircularTree implements Layout {

        private final int constantRadius;

        LayoutCircularTree(int constantRadius) {
            this.constantRadius = constantRadius;
        }

        LayoutCircularTree() {
            this(200);
        }

        @Override
        public void layoutNodes(Collection<BasePNode> nodes) {

            for (BasePNode root : nodes) {
                double currentArc = 2 * Math.PI;
                double arcLength = 2 * Math.PI;

                final Visitor<Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>>> visitor = new VisitBreadthFirst();
                final Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>> tuple = visitor.visit(root);

                layoutNode(root.getCenter(), constantRadius, root, tuple.getSecond(), currentArc, arcLength);
            }
        }

        private void layoutNode(Point2D center, int radius, BasePNode node, Map<BasePNode, List<BasePNode>> childrenMap, double startAngle, double arcLength) {

            final List<BasePNode> children = childrenMap.getOrDefault(node, Collections.emptyList());

            int totalChildren = 0;
            for (BasePNode child : children)
                totalChildren += childrenMap.getOrDefault(child, Collections.emptyList()).size() + 1;

            double currentArc = startAngle;
            for (final BasePNode child : children) {
                final double childProportion = (double) (childrenMap.getOrDefault(child, Collections.emptyList()).size() + 1) / (double) totalChildren;
                double childRadians = (arcLength * childProportion);
                final double sin = Math.sin(currentArc + (childRadians / 2));
                final double cos = Math.cos(currentArc + (childRadians / 2));
                double x = center.getX() + (int) (radius * sin);
                double y = center.getY() + (int) (radius * cos);
                child.setOffset(x, y);
                layoutNode(center, radius + constantRadius, child, childrenMap, currentArc, childRadians);
                currentArc += childRadians;
            }
        }
    }

    public static class LayoutRelativeTo extends LayoutTree implements Layout {

        private final BasePNode node;

        public LayoutRelativeTo(BasePNode node) {
            super(Configuration.Location.Left);
            this.node = node;
        }

        public LayoutRelativeTo(Point2D position) {
            super(Configuration.Location.Left);

            // create dummy-node at position
            this.node = new BasePNode(UUID.randomUUID(), null) {
                @Override
                public JComponent getEditor() {
                    return null;
                }
            };
            this.node.setOffset(position);
        }

        @Override
        public void layoutNodes(Collection<BasePNode> nodes) {

            final Map<BasePNode, BasePNode> parentMap = new LinkedHashMap<>();
            final Map<BasePNode, List<BasePNode>> childrenMap = new LinkedHashMap<>();

            for (BasePNode basePNode : nodes) {
                parentMap.put(basePNode, node);
                childrenMap.put(basePNode, Collections.emptyList());
            }

            childrenMap.put(node, new ArrayList<>(nodes));

            layoutTree(node, new Tuple<>(parentMap, childrenMap));
        }
    }

    public static class LayoutTree implements Layout {

        static int gapBetweenLevels = 200;
        static int gapBetweenNodes = 50;

        final Configuration<BasePNode> configuration;

        LayoutTree(Configuration.Location location) {
            this.configuration = new DefaultConfiguration<>(LayoutTree.gapBetweenLevels, LayoutTree.gapBetweenNodes, location);
        }

        @Override
        public void layoutNodes(Collection<BasePNode> nodes) {
            for (BasePNode root : nodes)
                layoutTree(root, new VisitBreadthFirst().visit(root));
        }

        void layoutTree(BasePNode root, Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>> tuple) {

            final TreeLayout<BasePNode> layout = new TreeLayout<>(createTree(root, tuple.getFirst(), tuple.getSecond()), getNodeExtendProvider(), configuration);

            final Point2D rootLocation = root.getOffset();
            final Map<BasePNode, Rectangle2D.Double> nodeBounds = layout.getNodeBounds();
            final Rectangle2D.Double rootBounds = nodeBounds.get(root);
            final double dX = rootLocation.getX() - rootBounds.getCenterX();
            final double dY = rootLocation.getY() - rootBounds.getCenterY();
            for (Map.Entry<BasePNode, Rectangle2D.Double> nodeBound : nodeBounds.entrySet()) {
                final double centerX = nodeBound.getValue().getCenterX() + dX;
                final double centerY = nodeBound.getValue().getCenterY() + dY;
                nodeBound.getKey().setOffset(centerX, centerY);
            }
        }

        TreeForTreeLayout<BasePNode> createTree(BasePNode root, Map<BasePNode, BasePNode> nodeParent, Map<BasePNode, List<BasePNode>> nodeChildren) {
            return new AbstractTreeForTreeLayout<BasePNode>(root) {
                @Override
                public BasePNode getParent(BasePNode node) {
                    return nodeParent.get(node);
                }

                @Override
                public List<BasePNode> getChildrenList(BasePNode node) {
                    return nodeChildren.get(node);
                }
            };
        }

        NodeExtentProvider<BasePNode> getNodeExtendProvider() {
            return new NodeExtentProvider<BasePNode>() {
                @Override
                public double getWidth(BasePNode node) {
                    return node.getFullBounds().getWidth();
                }

                @Override
                public double getHeight(BasePNode node) {
                    return node.getFullBounds().getHeight();
                }
            };
        }
    }

    public interface Visitor<T> {

        T visit(BasePNode node);

    }

    protected static final class VisitBreadthFirst implements Visitor<Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>>> {

        @Override
        public Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>> visit(BasePNode root) {
            final Map<BasePNode, BasePNode> nodeParent = new HashMap<>();
            final Map<BasePNode, List<BasePNode>> nodeChildren = new HashMap<>();
            final LinkedHashSet<BasePNode> visitedNodes = new LinkedHashSet<>();

            visitBreadthFirst(root, nodeParent, nodeChildren, visitedNodes);

            return new Tuple<>(nodeParent, nodeChildren);
        }

        private void visitBreadthFirst(BasePNode root, Map<BasePNode, BasePNode> nodeParent, Map<BasePNode, List<BasePNode>> nodeChildren, LinkedHashSet<BasePNode> visitedNodes) {

            if (visitedNodes.contains(root)) return;
            visitedNodes.add(root);

            nodeChildren.put(root, new ArrayList<>());
            final Set<BasePNode> childrenToVisit = new LinkedHashSet<>();
            for (Relation relation : root.outgoing) {
                final BasePNode child = relation.getDst();

                if (child.equals(root)) continue;
                if (visitedNodes.contains(child)) continue;
                if (nodeParent.containsKey(child)) continue;

                childrenToVisit.add(child);
                nodeParent.put(child, root);
                nodeChildren.get(root).add(child);
            }

            for (BasePNode childNode : childrenToVisit)
                visitBreadthFirst(childNode, nodeParent, nodeChildren, visitedNodes);
        }
    }

    protected static final class DepthFirstVisitor implements Visitor<Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>>> {

        @Override
        public Tuple<Map<BasePNode, BasePNode>, Map<BasePNode, List<BasePNode>>> visit(BasePNode root) {
            final Map<BasePNode, BasePNode> nodeParent = new HashMap<>();
            final Map<BasePNode, List<BasePNode>> nodeChildren = new HashMap<>();
            final LinkedHashSet<BasePNode> visitedNodes = new LinkedHashSet<>();

            visitDepthFirst(root, nodeParent, nodeChildren, visitedNodes);

            return new Tuple<>(nodeParent, nodeChildren);
        }

        private void visitDepthFirst(BasePNode root, Map<BasePNode, BasePNode> nodeParent, Map<BasePNode, List<BasePNode>> nodeChildren, LinkedHashSet<BasePNode> visitedNodes) {

            if (visitedNodes.contains(root)) return;
            visitedNodes.add(root);

            nodeChildren.put(root, new ArrayList<>());
            for (Relation relation : root.outgoing) {
                final BasePNode child = relation.getDst();

                if (child.equals(root)) continue;
                if (visitedNodes.contains(child)) continue;
                if (nodeParent.containsKey(child)) continue;

                nodeParent.put(child, root);
                nodeChildren.get(root).add(child);
                visitDepthFirst(child, nodeParent, nodeChildren, visitedNodes);
            }
        }
    }

    private static final class CanvasZoomHandler extends PBasicInputEventHandler {

        private double scaleFactor = 0.1d;
        private static final double minZomScale = 0.5d;
        private static final double maxZoomScale = 2.8d;

        CanvasZoomHandler() {
            super();
            final PInputEventFilter eventFilter = new PInputEventFilter();
            eventFilter.rejectAllEventTypes();
            eventFilter.setAcceptsMouseWheelRotated(true);
            setEventFilter(eventFilter);
        }

        public void mouseWheelRotated(final PInputEvent event) {

            final PCamera camera = event.getCamera();

            // max scale min and max:
            if ((camera.getViewScale() < minZomScale && event.getWheelRotation() < 0) || (camera.getViewScale() > maxZoomScale && event.getWheelRotation() > 0))
                return;

            double scale = 1.0d + event.getWheelRotation() * scaleFactor;
            final Point2D viewAboutPoint = event.getPosition();
            camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());
        }
    }

    public static abstract class BasePNode extends PNode {

        final Set<Relation> outgoing = Collections.synchronizedSet(new LinkedHashSet<>());
        final Set<Relation> incoming = Collections.synchronizedSet(new LinkedHashSet<>());

        protected NodeCanvas canvas;
        protected PropertyChangeSupport nodeChangeSupport;

        BasePNode(UUID id, Object content) {
            super();
            addAttribute("id", id);
            addAttribute("content", content);
        }

        private void setInputEventListener(PBasicInputEventHandler canvasInputHandler) {

            final PBasicInputEventHandler nodeEventListener = new PDragSequenceEventHandler() {

                @Override
                protected final void startDrag(PInputEvent event) {
                    super.startDrag(event);
                }

                @Override
                protected final void drag(PInputEvent event) {
                    super.drag(event);
                    translate(event.getDelta().width, event.getDelta().height);
                }

                @Override
                protected final void endDrag(PInputEvent event) {
                    super.endDrag(event);
                }

                @Override
                protected final boolean shouldStartDragInteraction(PInputEvent event) {
                    return super.shouldStartDragInteraction(event);
                }

                @Override
                public void mouseEntered(PInputEvent event) {
                    event.getInputManager().setKeyboardFocus(this);
                    highlight();
                }

                @Override
                public void mouseExited(PInputEvent event) {
                    event.getInputManager().setKeyboardFocus(canvasInputHandler);
                    unhighlight();
                }

                @Override
                public void mouseClicked(PInputEvent event) {
                    if (event.isRightMouseButton()) {
                        final JPopupMenu pop = new JPopupMenu();
                        SwingUtilities.invokeLater(() -> {
                            canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            onRightClick(event, pop, canvas, canvas.getMousePosition());
                            canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
                        });
                    } else if (event.isLeftMouseButton()) {
                        SwingUtilities.invokeLater(() -> toggleSelect());
                    }
                }

                @Override
                public void keyPressed(PInputEvent event) {
                    onKeyPressed(event, canvas);
                }
            };

            nodeEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
            addInputEventListener(nodeEventListener);
        }

        protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {
            switch (event.getKeyCode()) {
                case VK_C:
                    this.canvas.closeNodes(Collections.singleton(this));
                    break;
                case VK_R:
                    this.canvas.retainNodes(Collections.singleton(this));
                    break;
                case VK_E:
                    selectOutgoing();
                    break;
                case VK_I:
                    selectIncoming();
                    break;
                case VK_1:
                    SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Left).layoutNodes(Collections.singleton(BasePNode.this)));
                    break;
                case VK_3:
                    SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Right).layoutNodes(Collections.singleton(BasePNode.this)));
                    break;
                case VK_4:
                    SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Top).layoutNodes(Collections.singleton(BasePNode.this)));
                    break;
                case VK_2:
                    SwingUtilities.invokeLater(() -> new LayoutTree(Configuration.Location.Bottom).layoutNodes(Collections.singleton(BasePNode.this)));
                    break;
                case VK_5:
                    SwingUtilities.invokeLater(() -> new LayoutCircularTree().layoutNodes(Collections.singleton(BasePNode.this)));
                    break;
            }
        }

        protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

            pop.add(new SwingAction("Retain") {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    canvas.retainNodes(Collections.singleton(BasePNode.this));
                }
            });

            pop.add(new SwingAction("Close") {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    canvas.closeNodes(Collections.singleton(BasePNode.this));
                }
            });
        }

        protected String nodeEvent(String s) {
            return "node." + getUUID() + "." + s;
        }

        <T> T getContent() {
            return (T) getAttribute("content");
        }

        protected <T extends BasePNode> T getThis() {
            return (T) this;
        }

        protected void removeFromCanvas() {
            nodeChangeSupport.firePropertyChange(nodeEvent("closed"), Boolean.FALSE, Boolean.TRUE);
            canvas.nodeLayer.removeChild(this);
        }

        public void setContent(Object content) {
            if (getAttribute("content", "").equals(content)) return;
            final Object old = getAttribute("content");
            addAttribute("content", content);
            nodeChangeSupport.firePropertyChange(nodeEvent("content"), old, content);
        }

        public void highlight() {
            if (getBooleanAttribute("highlighted", Boolean.FALSE)) return;
            addAttribute("highlighted", Boolean.TRUE);
            nodeChangeSupport.firePropertyChange(nodeEvent("highlighted"), Boolean.FALSE, Boolean.TRUE);
        }

        public void unhighlight() {
            if (!getBooleanAttribute("highlighted", Boolean.FALSE)) return;
            addAttribute("highlighted", Boolean.FALSE);
            nodeChangeSupport.firePropertyChange(nodeEvent("highlighted"), Boolean.TRUE, Boolean.FALSE);
        }

        void toggleSelect() {
            if (getBooleanAttribute("selected", false))
                unselect();
            else
                select();
        }

        public void select() {
            if (getBooleanAttribute("selected", Boolean.FALSE)) return;
            addAttribute("selected", Boolean.TRUE);
            nodeChangeSupport.firePropertyChange(nodeEvent("selected"), this, Boolean.TRUE);
        }

        public void unselect() {
            if (!getBooleanAttribute("selected", Boolean.FALSE)) return;
            addAttribute("selected", Boolean.FALSE);
            nodeChangeSupport.firePropertyChange(nodeEvent("selected"), this, Boolean.FALSE);
        }

        public UUID getUUID() {
            return UUID.fromString(getAttribute("id").toString());
        }

        void selectOutgoing() {
            for (Relation relation : outgoing) {
                relation.select();
                relation.getDst().select();
            }
        }

        protected Set<BasePNode> outgoingNodes() {
            final Set<BasePNode> nodes = new LinkedHashSet<>();
            for (Relation relation : outgoing)
                nodes.add(relation.getDst());
            return nodes;
        }

        public Set<BasePNode> incomingNodes() {
            final Set<BasePNode> nodes = new LinkedHashSet<>();
            for (Relation relation : incoming)
                nodes.add(relation.getSrc());
            return nodes;
        }

        void selectIncoming() {
            for (Relation relation : incoming) {
                relation.select();
                relation.getSrc().select();
            }
        }

        Point2D getCenter() {
            return getFullBounds().getCenter2D();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BasePNode basePNode = (BasePNode) o;
            return Objects.equals(getAttribute("id"), basePNode.getAttribute("id"));
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAttribute("id"));
        }

        @Override
        public String toString() {
            return getAttribute("id") + " " + getAttribute("content");
        }

        public abstract JComponent getEditor();

        public void setNodeChangeSupport(PropertyChangeSupport canvasChangeSupport) {
            nodeChangeSupport = canvasChangeSupport;
        }
    }

    protected static JTextArea newTextArea() {
        final JTextArea txtEditor = new JTextArea(50, 80);
        txtEditor.setFont(new Font("Hack", Font.PLAIN, 12));
        txtEditor.setTabSize(3);
        txtEditor.setCaretPosition(0);
        return txtEditor;
    }

    public static class Relation extends PPath.Double implements PropertyChangeListener {

        private NodeCanvas canvas;
        private PropertyChangeSupport changeSupport;

        private final PText pText;
        private final Color selectedColor;
        private final Color defaultColor;
        private final Color highlightedNodeColor;

        private Color currentPaint;

        Relation(UUID uuid, Object content, String label, BasePNode src, BasePNode dst, Color defaultColor, Color selectedColor, Color highlightedNodeColor) {
            super(new java.awt.geom.Line2D.Double(src.getFullBoundsReference().getCenter2D().getX(), src.getFullBoundsReference().getCenter2D().getY(), dst.getFullBoundsReference().getCenter2D().getX(), dst.getFullBoundsReference().getCenter2D().getY()));

            addAttribute("label", label);
            addAttribute("content", content);
            addAttribute("id", uuid);
            addAttribute("src", src);
            addAttribute("dst", dst);

            this.defaultColor = defaultColor;
            this.selectedColor = selectedColor;
            this.highlightedNodeColor = highlightedNodeColor;
            this.currentPaint = defaultColor;
            setStrokePaint(currentPaint);

            pText = new PText();
            pText.setText(label);
            addChild(pText);

            src.addPropertyChangeListener(this);
            src.outgoing.add(this);

            dst.addPropertyChangeListener(this);
            dst.incoming.add(this);

            updatePath(src, dst);
        }

        UUID getUUID() {
            return UUID.fromString(getAttribute("id").toString());
        }

        public <T> T getContent() {
            return (T) getAttribute("content");
        }

        public void setContent(Object content) {
            if (getAttribute("content", "").equals(content)) return;
            final Object old = getAttribute("content");
            addAttribute("content", content);
            changeSupport.firePropertyChange(relationEvent("content"), this, content);
        }

        void setSrc(BasePNode src) {

            final BasePNode existing = (BasePNode) getAttribute("src");
            existing.removePropertyChangeListener(this);
            existing.outgoing.remove(this);

            addAttribute("src", src);
            src.addPropertyChangeListener(this);
            src.outgoing.add(this);

            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
        }

        void setDst(BasePNode dst) {

            final BasePNode existing = (BasePNode) getAttribute("dst");
            existing.removePropertyChangeListener(this);
            existing.outgoing.remove(this);

            addAttribute("dst", dst);
            dst.addPropertyChangeListener(this);
            dst.outgoing.add(this);

            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
        }

        void setInputEventListener(PBasicInputEventHandler canvasInputHandler) {

            final PBasicInputEventHandler relationEventListener = new PBasicInputEventHandler() {
                @Override
                public void mouseEntered(PInputEvent event) {
                    currentPaint = highlightedNodeColor;
                    SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
                }

                @Override
                public void mouseExited(PInputEvent event) {
                    currentPaint = getBooleanAttribute("selected", false) ? selectedColor : defaultColor;
                    event.getInputManager().setKeyboardFocus(canvasInputHandler);
                    SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
                }

                @Override
                public void mouseClicked(PInputEvent event) {
                    if (event.isRightMouseButton()) {
                        final JPopupMenu pop = new JPopupMenu();
                        SwingUtilities.invokeLater(() -> {
                            canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            onRightClick(pop, canvas);
                            canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
                        });
                    } else if (event.isLeftMouseButton()) {
                        SwingUtilities.invokeLater(() -> toggleSelect());
                    }
                }
            };

            relationEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
            addInputEventListener(relationEventListener);
        }

        protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

            pop.add(new SwingAction("Reverse direction") {
                @Override
                public void onActionPerformed(ActionEvent e) {

                    final BasePNode src = (BasePNode) getAttribute("src");
                    final BasePNode dst = (BasePNode) getAttribute("dst");

                    addAttribute("src", dst);
                    addAttribute("dst", src);

                    SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
                    changeSupport.firePropertyChange(relationEvent("reverse"), dst, src);
                }
            });

            pop.add(new SwingAction("Remove") {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    changeSupport.firePropertyChange(relationEvent("remove"), null, Relation.this);
                    SwingUtilities.invokeLater(Relation.this::removeFromCanvas);
                }
            });
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            switch (evt.getPropertyName()) {
                case PNode.PROPERTY_FULL_BOUNDS:
                case PNode.PROPERTY_TRANSFORM:
                    SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
                    break;

                case PNode.PROPERTY_PARENT:
                    if (evt.getOldValue() != null) SwingUtilities.invokeLater(this::removeFromCanvas);
                    break;
            }
        }

        String relationEvent(String s) {
            return "relation." + getAttribute("id") + "." + s;
        }

        public void highlight() {
            if (getBooleanAttribute("highlighted", Boolean.FALSE)) return;
            addAttribute("highlighted", Boolean.TRUE);
            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
            changeSupport.firePropertyChange(relationEvent("highlighted"), Boolean.FALSE, Boolean.TRUE);
        }

        public void unhighlight() {
            if (!getBooleanAttribute("highlighted", Boolean.FALSE)) return;
            addAttribute("highlighted", Boolean.FALSE);
            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
            changeSupport.firePropertyChange(relationEvent("highlighted"), Boolean.TRUE, Boolean.FALSE);
        }

        void select() {
            if (getBooleanAttribute("selected", Boolean.FALSE)) return;
            addAttribute("selected", Boolean.TRUE);
            currentPaint = selectedColor;
            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
            changeSupport.firePropertyChange(relationEvent("selected"), this, Boolean.TRUE);
        }

        void unselect() {
            if (!getBooleanAttribute("selected", Boolean.FALSE)) return;
            addAttribute("selected", Boolean.FALSE);
            currentPaint = defaultColor;
            SwingUtilities.invokeLater(() -> updatePath(((BasePNode) getAttribute("src")), (BasePNode) getAttribute("dst")));
            changeSupport.firePropertyChange(relationEvent("selected"), this, Boolean.FALSE);
        }

        void toggleSelect() {
            if (getBooleanAttribute("selected", false))
                unselect();
            else
                select();
        }

        public void removeFromCanvas() {

            ((BasePNode) getAttribute("src")).removePropertyChangeListener(Relation.this);
            ((BasePNode) getAttribute("src")).outgoing.remove(Relation.this);

            ((BasePNode) getAttribute("dst")).removePropertyChangeListener(Relation.this);
            ((BasePNode) getAttribute("dst")).incoming.remove(Relation.this);

            try {
                canvas.relationLayer.removeChild(this);
            } catch (Throwable t) {
                log.error("bug: fix", t);
            }
        }

        void updatePath(BasePNode source, BasePNode target) {
            final PBounds src = source.getFullBoundsReference();
            final PBounds dst = target.getFullBoundsReference();

            final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());

            final Point2D.Double startCenterBottom = new Point2D.Double(src.getCenterX(), src.getMaxY());
            final Point2D.Double endCenterTop = new Point2D.Double(dst.getCenterX(), dst.getMinY());

            final Point2D.Double startCenterTop = new Point2D.Double(src.getCenterX(), src.getMinY());
            final Point2D.Double endCenterBottom = new Point2D.Double(dst.getCenterX(), dst.getMaxY());

            if (src.getCenterX() < dst.getCenterX()) {

                final Point2D.Double startRightCenter = new Point2D.Double(src.getMaxX(), src.getCenterY());
                final Point2D.Double endRightCenter = new Point2D.Double(dst.getMinX(), dst.getCenterY());

                if (src.getCenterY() < dst.getCenterY()) {
                    // top-left
                    if (!horizontalOverlap) {
                        drawStraightPath(startRightCenter, endRightCenter);
                    } else {
                        drawStraightPath(startCenterBottom, endCenterTop);
                    }
                } else {
                    // bottom-left
                    if (!horizontalOverlap) {
                        drawStraightPath(startRightCenter, endRightCenter);
                    } else {
                        drawStraightPath(startCenterTop, endCenterBottom);
                    }
                }

            } else {

                final Point2D.Double startLeftCenter = new Point2D.Double(src.getMinX(), src.getCenterY());
                final Point2D.Double endLeftCenter = new Point2D.Double(dst.getMaxX(), dst.getCenterY());

                if (src.getCenterY() < dst.getCenterY()) {
                    // top-right
                    if (!horizontalOverlap) {
                        drawStraightPath(startLeftCenter, endLeftCenter);
                    } else {
                        drawStraightPath(startCenterBottom, endCenterTop);
                    }
                } else {
                    // bottom-right
                    if (!horizontalOverlap) {
                        drawStraightPath(startLeftCenter, endLeftCenter);
                    } else {
                        drawStraightPath(startCenterTop, endCenterBottom);
                    }
                }
            }
        }

        private void drawStraightPath(Point2D start, Point2D end) {
            reset();
            setStrokePaint(currentPaint);

            moveTo(start.getX(), start.getY());
            lineTo(end.getX(), end.getY());
            pText.setTextPaint(currentPaint);
            pText.setOffset(getBounds().getCenter2D());

            // arrow
            final int ARR_SIZE = 4;
            final double dx = end.getX() - start.getX();
            final double dy = end.getY() - start.getY();
            final double angle = Math.atan2(dy, dx);
            final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
            final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());
            at.concatenate(AffineTransform.getRotateInstance(angle));
            append(new Polygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4).getPathIterator(at), false);

            setPaintInvalid(true);
            validateFullPaint();
        }

        protected BasePNode getSrc() {
            return (BasePNode) getAttribute("src");
        }

        protected BasePNode getDst() {
            return (BasePNode) getAttribute("dst");
        }

        protected String getLabel() {
            return (String) getAttribute("label");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Relation relation = (Relation) o;
            return Objects.equals(getSrc(), relation.getSrc()) &&
                    Objects.equals(getDst(), relation.getDst());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSrc(), getDst(), getLabel());
        }

        Color getDefaultColor() {
            return defaultColor;
        }

        Color getSelectedColor() {
            return selectedColor;
        }

        Color getHighlightedNodeColor() {
            return highlightedNodeColor;
        }

        public JComponent getEditor() {
            final JTextArea textArea = newTextArea();
            textArea.setText(getContent().toString());
            return textArea;
        }
    }

    protected class PropertyComponent {

        // todo support numbers, Colors, File, etc.
        final JComponent component;

        public PropertyComponent(String type) {
            if ("Boolean".equals(type))
                component = new JCheckBox();
            else
                component = new JTextField();
        }

        public PropertyComponent(Object[] enums) {
            this.component = new JComboBox<>(enums);
        }

        public Component getComponent() {
            return component;
        }

        public void setValue(Object value) {
            if (value == null) return;
            if (component instanceof JTextField)
                ((JTextField) component).setText(value.toString());
            else if (component instanceof JCheckBox)
                ((JCheckBox) component).setSelected(Boolean.valueOf(value.toString()));
            else if (component instanceof JComboBox)
                ((JComboBox) component).setSelectedItem(value);
        }

        public <T> T getValue() {
            if (component instanceof JTextField) {
                final String value = ((JTextField) component).getText().trim();
                return value.length() == 0 ? null : (T) value;
            } else if (component instanceof JComboBox) {
                return (T) ((JComboBox) component).getSelectedItem();
            } else if (component instanceof JCheckBox) {
                final JCheckBox checkBox = (JCheckBox) this.component;
                return (T) Boolean.valueOf(checkBox.isSelected());
            }
            return null;
        }

        public void setEnabled(boolean enabled) {
            if (component instanceof JTextField)
                ((JTextField) component).setEditable(enabled);
            else if (component instanceof JCheckBox)
                component.setEnabled(enabled);
            else if (component instanceof JComboBox)
                component.setEnabled(enabled);
        }
    }

    public static abstract class SwingAction extends AbstractAction {

        protected SwingAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> onActionPerformed(e));
        }

        protected abstract void onActionPerformed(ActionEvent e);
    }

    protected static class Tuple<F, S> {

        private F first;
        private S second;

        Tuple(F first, S second) {
            this.first = first;
            this.second = second;
        }

        F getFirst() {
            return first;
        }

        S getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple<?, ?> tuple = (Tuple<?, ?>) o;

            return first.equals(tuple.first) && second.equals(tuple.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "[" + first + "," + second + "]";
        }
    }

    static void showException(String message, Throwable throwable, Component component) {

        final String stacktrace = printStackTrace(throwable);

        if (component != null) {
            final JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel(message + " : "), BorderLayout.NORTH);
            final JScrollPane content = new JScrollPane(new JTextArea(stacktrace));
            content.setMaximumSize(new Dimension(800, 600));
            content.setPreferredSize(new Dimension(800, 600));
            content.setMinimumSize(new Dimension(800, 600));
            content.setSize(new Dimension(800, 600));
            panel.add(content, BorderLayout.CENTER);
            JOptionPane.showMessageDialog(component, panel, "Exception", JOptionPane.ERROR_MESSAGE);
        } else {
            log.info(stacktrace);
        }
    }

    private static String printStackTrace(Throwable throwable) {
        final StringWriter stacktrace = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stacktrace));
        return stacktrace.toString();
    }

    public static String showInputDialog(String message, Component owner) {
        return JOptionPane.showInputDialog(owner, message);
    }

    public static String showInputDialog(String message, Component owner, String defaultValue) {
        final String newValue = JOptionPane.showInputDialog(owner, message, defaultValue);
        return newValue == null ? defaultValue : newValue;
    }

    static void showException(Component parent, Throwable t) {
        t.printStackTrace();
        JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
    }

    protected static void showExceptionNoStack(Component parent, Throwable t) {
        JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
    }

    public static void showMessage(String message, Component component) {
        JOptionPane.showMessageDialog(component, message);
    }

    protected static class FormPanel extends JPanel {

        private FormBuilder builder;
        private final CellConstraints cc;
        private final CellConstraints.Alignment colAlign;
        private final CellConstraints.Alignment rowAlign;

        public FormPanel(String columns, String rows) {
            this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);
        }

        public JPanel build() {
            return builder.getPanel();
        }

        FormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
            this.cc = new CellConstraints();
            this.builder = FormBuilder.create().columns(columns).rows(rows);
            this.colAlign = colAlign;
            this.rowAlign = rowAlign;
        }

        public void add(Component component, int column, int row) {
            this.add(component, column, row, 1, 1);
        }

        public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
            this.add(component, column, row, 1, 1, colAlign, rowAlign);
        }

        public void add(Component component, int column, int row, int colSpan, int rowSpan) {
            this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
        }

        public JLabel addLabel(String text, int column, int row) {
            return this.addLabel(text, column, row, this.colAlign, this.rowAlign);
        }

        public JLabel addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
            return this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);
        }

        JLabel addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
            final JLabel label = new JLabel(text);
            this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);
            return label;
        }

        public void addScrollPane(Component component, int column, int row, int colSpan, int rowSpan) {
            this.add(new JScrollPane(component), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
        }

        public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {
            this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));
        }

        public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
            this.builder.add(component).at(this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));
        }
    }

    public static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave) {
        showDialog(content, owner, title, onSave, true);
    }

    private static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave, boolean modal) {
        final JDialog dialog = new JDialog(getFrame(owner), title, modal);
        final Component component = content instanceof FormPanel ? ((FormPanel) content).build() : content;

        if (component instanceof JComponent)
            ((JComponent) component).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        dialog.add(component, BorderLayout.CENTER);
        final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        if (onSave != null) {
            JButton btnSave;
            commandPanel.add(btnSave = new JButton(new SwingAction(onSave.getConfirmTitle()) {
                @Override
                public void onActionPerformed(ActionEvent e) {
                    try {
                        onSave.verifyAndCommit();
                        dialog.dispose();
                    } catch (Exception e1) {
                        showExceptionNoStack(content, e1);
                    }
                }
            }));
            dialog.getRootPane().setDefaultButton(btnSave);
        }

        commandPanel.add(new JButton(new SwingAction(onSave == null ? "Close" : onSave.getCancelTitle()) {
            @Override
            public void onActionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(dialog::dispose);
            }
        }));
        dialog.add(commandPanel, BorderLayout.SOUTH);

        showDialog(dialog, owner);
    }

    private static void showDialog(final JDialog dialog, final Component owner) {
        SwingUtilities.invokeLater(() -> {
            dialog.pack();
            dialog.setLocationRelativeTo(owner);
            dialog.setVisible(true);
        });
    }

    public static abstract class ConfirmAction {

        private final String confirmTitle;
        private final String cancelTitle;

        protected ConfirmAction() {
            this("Save", "Cancel");
        }

        ConfirmAction(String confirmTitle, String cancelTitle) {
            this.confirmTitle = confirmTitle;
            this.cancelTitle = cancelTitle;
        }

        public abstract void verifyAndCommit() throws Exception;

        String getConfirmTitle() {
            return confirmTitle;
        }

        String getCancelTitle() {
            return cancelTitle;
        }
    }

    private static JFrame getFrame(Component child) {
        return (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, child);
    }

    public static File showOpenFile(Component parent, String dir) {
        final JFileChooser fc = dir == null ? new JFileChooser() : new JFileChooser(new File(dir).isDirectory() ? new File(dir) : new File(dir).getParentFile());
        final int result = fc.showOpenDialog(parent);
        return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
    }

    public static File showOpenDir(Component parent, String dir) {
        final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        final int result = fc.showOpenDialog(parent);
        return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T showSelectDialog(Component parent, Collection<T> list) {
        if (list == null || list.size() == 0) return null;

        final T[] available = (T[]) list.toArray();
        return (T) JOptionPane.showInputDialog(parent, "Available: ", "Select", QUESTION_MESSAGE, null, available, available.length == 0 ? null : available[0]);
    }

    public static void toClipboard(String content) {
        StringSelection stringSelection = new StringSelection(content);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, (clipboard1, contents) -> {
            // don't care ?
        });
    }

    public static String fromClipboard() {
        final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        final Transferable contents = clipboard.getContents(null);
        if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                return (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
        return "";
    }

    public static void showTextInput(String title, JTextArea textArea, Component component, ConfirmAction onSave) {
        final JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(title + " : "), BorderLayout.NORTH);
        final JScrollPane content = new JScrollPane(textArea);
        content.setMaximumSize(new Dimension(800, 600));
        content.setPreferredSize(new Dimension(800, 600));
        content.setMinimumSize(new Dimension(800, 600));
        content.setSize(new Dimension(800, 600));
        panel.add(content, BorderLayout.CENTER);

        showDialog(panel, component, title, onSave);
    }

    public static void showTextResult(String title, String text, Component parentComponent, Dimension defaultSize, boolean modal) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(title + " : "), BorderLayout.NORTH);

        final JTextArea txtEditor = newTextArea();
        txtEditor.setText(text);
        txtEditor.setEditable(false);

        final JScrollPane content = new JScrollPane(txtEditor);
        if (defaultSize != null) {
            content.setMaximumSize(defaultSize);
            content.setPreferredSize(defaultSize);
            content.setMinimumSize(defaultSize);
            content.setSize(defaultSize);
        }
        panel.add(content, BorderLayout.CENTER);

        showDialog(content, parentComponent, title, null, modal);
    }

    protected static File tryToCreateDirIfNotExists(File f) {

        if (f == null) throw new RuntimeException("File cannot be null");

        if (!f.exists()) {
            if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())
                throw new RuntimeException("Could not create parent dirs for " + f.getAbsolutePath());
            if (!f.mkdir()) throw new RuntimeException("Could not create directory " + f.getName());
        }
        return f;
    }

    protected static void setLookAndFeel() {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    System.err.println("Could not set look and feel '" + "Nimbus" + "': " + e.getMessage());
                }
            }
        }
    }

    protected final class TextProcessingPanel extends JPanel {
        private final JTextArea txtInput = newTextArea();
        private final String lineSeparator = System.getProperty("line.separator");

        private final Stack<String> inputStack = new Stack<>();
        private final JTextField txtPattern = new JTextField("");
        private final JTextField txtInsert = new JTextField("");
        private final JTextArea txtOutput = newTextArea();

        private final JRadioButton radReplace = new JRadioButton("replace", true);
        private final JRadioButton radInsertAfter = new JRadioButton("insert after");
        private final JRadioButton radInsertLineAfter = new JRadioButton("insert line after");
        private final JRadioButton radInsertBefore = new JRadioButton("insert before");
        private final JRadioButton radInsertLineBefore = new JRadioButton("insert line before");
        private final JRadioButton radRemove = new JRadioButton("remove");
        private final JRadioButton radRemoveLine = new JRadioButton("remove line");
        private final JRadioButton radRemoveLineBefore = new JRadioButton("remove line before");
        private final JRadioButton radRemoveLineAfter = new JRadioButton("remove line after");
        private final JCheckBox chkTrimEmptyLines = new JCheckBox("Compress lines", true);
        private final JCheckBox chkShowDifference = new JCheckBox("Show Difference", false);
        private final JCheckBox chkKeepMatches = new JCheckBox("keep only matches", false);

        public TextProcessingPanel(String inputText, Set<String> patterns) {
            super(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            final JButton btnSetAsInput = new JButton(" <- ");
            btnSetAsInput.setToolTipText("Set output-text to inputText (for further processing)");

            final ButtonGroup group = new ButtonGroup();
            group.add(radReplace);
            group.add(radInsertAfter);
            group.add(radInsertLineAfter);
            group.add(radInsertBefore);
            group.add(radInsertLineBefore);
            group.add(radRemove);
            group.add(radRemoveLine);
            group.add(radRemoveLineBefore);
            group.add(radRemoveLineAfter);

            txtPattern.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent event) {
                    switch (event.getKeyCode()) {
                        case KeyEvent.VK_SPACE:
                            if (!event.isControlDown()) return;
                            SwingUtilities.invokeLater(() -> showHelp());
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    filter();
                }
            });

            if (patterns.size() == 1) txtPattern.setText(patterns.iterator().next());

            btnSetAsInput.addActionListener(e -> {
                inputStack.push(txtInput.getText());
                txtInput.setText(txtOutput.getText());
                txtInput.setCaretPosition(0);
                filter();
            });

            txtPattern.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if (SwingUtilities.isRightMouseButton(e)) {
                        final JPopupMenu pop = new JPopupMenu();

                        for (String pattern : patterns) {
                            pop.add(new AbstractAction(pattern) {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    txtPattern.setText(pattern);
                                    filter();
                                }
                            });
                        }

                        pop.add(new AbstractAction("Help") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showHelp();
                            }
                        });

                        SwingUtilities.invokeLater(() -> pop.show(txtPattern, e.getX(), e.getY()));
                    }
                }
            });

            InputMap im = txtInput.getInputMap();
            KeyStroke tab = KeyStroke.getKeyStroke("TAB");
            txtInput.getActionMap().put(im.get(tab), new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    log.info("TAB");

                    int startCaret = txtInput.getCaretPosition();
                    int caretPosition = txtInput.getCaretPosition();
                    final int selectionStart = txtInput.getSelectionStart();
                    final int selectionEnd = txtInput.getSelectionEnd();

                    final String text = txtInput.getText();
                    String selectedText = txtInput.getSelectedText();

                    final StringBuilder replace = new StringBuilder();
                    if (selectedText == null) {
                        replace.append(text.substring(0, selectionStart));
                        replace.append("\t");
                        replace.append(text.substring(selectionStart));
                        caretPosition += txtInput.getTabSize();
                    } else {

                        replace.append(text.substring(0, selectionStart));

                        final String[] split = selectedText.split("\n");
                        for (int i = 0; i < split.length; i++) {
                            String s = (i == 0 ? "" : "\n") + "\t" + split[i];
                            replace.append(s);
                            caretPosition += txtInput.getTabSize();
                        }
                        replace.append(text.substring(selectionEnd));
                    }
                    txtInput.setText(replace.toString());
                    txtInput.setCaretPosition(startCaret);
                    txtInput.setSelectionStart(startCaret);
                    txtInput.setSelectionEnd(caretPosition);
                }
            });
            KeyStroke shiftTab = KeyStroke.getKeyStroke("shift TAB");
            im.put(shiftTab, shiftTab);
            txtInput.getActionMap().put(im.get(shiftTab), new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    log.info("SHIFT TAB");


                }
            });

            txtInput.setText(inputText);
            txtInput.setCaretPosition(0);
            txtInput.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        final JPopupMenu pop = new JPopupMenu();

                        if (inputStack.size() > 0) {
                            pop.add(new AbstractAction("Undo") {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    txtInput.setText(inputStack.pop());
                                    txtInput.setCaretPosition(0);
                                    filter();
                                }
                            });
                        }

                        pop.add(new AbstractAction("Set from clipboard") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                txtInput.setText(fromClipboard());
                                txtInput.setCaretPosition(0);
                                filter();
                            }
                        });

                        SwingUtilities.invokeLater(() -> pop.show(txtInput, e.getX(), e.getY()));
                    }
                }
            });

            txtInput.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    SwingUtilities.invokeLater(() -> txtInput.setCaretPosition(0));
                }
            });

            txtPattern.addActionListener(e12 -> filter());
            txtInsert.setToolTipText("Use $1,$2 ... to reference group-value");
            txtInsert.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    filter();
                }
            });
            radReplace.addActionListener(e -> filter());
            radInsertAfter.addActionListener(e -> filter());
            radInsertLineAfter.addActionListener(e -> filter());
            radInsertBefore.addActionListener(e -> filter());
            radInsertLineBefore.addActionListener(e -> filter());
            radRemove.addActionListener(e -> filter());
            radRemoveLine.addActionListener(e -> filter());
            radRemoveLineBefore.addActionListener(e -> filter());
            radRemoveLineAfter.addActionListener(e -> filter());
            chkKeepMatches.addActionListener(e -> filter());

            chkTrimEmptyLines.setToolTipText("Check to compress 2 or more empty lines into 1");
            chkTrimEmptyLines.addActionListener(e -> filter());
            chkShowDifference.addActionListener(e -> filter());

            final FormPanel editor = new FormPanel("350dlu:grow,4dlu,100dlu,4dlu,350dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,50dlu:grow");
            int row = 1;
            editor.add(new JScrollPane(txtInput), 1, row, 1, 37);
            editor.addLabel("Pattern", 3, row += 2);
            editor.add(txtPattern, 3, row += 2);
            editor.addLabel("Insert", 3, row += 2);
            editor.add(txtInsert, 3, row += 2);
            editor.add(radReplace, 3, row += 2);
            editor.add(radInsertAfter, 3, row += 2);
            editor.add(radInsertLineAfter, 3, row += 2);
            editor.add(radInsertBefore, 3, row += 2);
            editor.add(radInsertLineBefore, 3, row += 2);
            editor.add(radRemove, 3, row += 2);
            editor.add(radRemoveLine, 3, row += 2);
            editor.add(radRemoveLineBefore, 3, row += 2);
            editor.add(radRemoveLineAfter, 3, row += 2);
            editor.add(chkTrimEmptyLines, 3, row += 2);
            editor.add(chkShowDifference, 3, row += 2);
            editor.add(chkKeepMatches, 3, row += 2);
            editor.add(btnSetAsInput, 3, row += 2);
            editor.add(new JScrollPane(txtOutput), 5, 1, 1, 37);

            txtOutput.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e))
                        toClipboard(txtOutput.getText().trim());
                    else if (SwingUtilities.isRightMouseButton(e)) {
                        final JPopupMenu pop = new JPopupMenu();

                        pop.add(new AbstractAction("Set this text as input") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                inputStack.push(txtInput.getText());
                                txtInput.setText(txtOutput.getText());
                                txtInput.setCaretPosition(0);
                                filter();
                            }
                        });

                        pop.add(new AbstractAction("Add to clipboard") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                toClipboard(txtOutput.getText().trim());
                            }
                        });

                        SwingUtilities.invokeLater(() -> pop.show(txtOutput, e.getX(), e.getY()));
                    }
                }
            });
            txtOutput.setToolTipText("Left-click to add content to clipboard.\nRight-click for options.");

            filter();

            add(editor.build(), BorderLayout.CENTER);

            txtPattern.requestFocusInWindow();
        }

        private void showDifference() throws DiffException {
            final String src = txtInput.getText().trim();
            final String dst = txtOutput.getText().trim();

            final String[] srcLines = src.split("\n");
            final String[] dstLines = dst.split("\n");

            final Patch<String> patch = DiffUtils.diff(Arrays.asList(srcLines), Arrays.asList(dstLines));

            txtInput.getHighlighter().removeAllHighlights();
            txtOutput.getHighlighter().removeAllHighlights();
            for (Delta<String> delta : patch.getDeltas()) {
                highlightChunk(src, delta.getOriginal(), txtInput, Color.decode("#f16913"));
                highlightChunk(dst, delta.getRevised(), txtOutput, Color.decode("#f16913"));
            }
        }

        private void highlightChunk(String src, Chunk<String> original, JTextArea txtInput, Color highlightColor) {
            for (String line : original.getLines()) {
                final int startIndex = src.indexOf(line);
                final int endIndex = startIndex + line.length();
                try {
                    txtInput.getHighlighter().addHighlight(startIndex, endIndex, new DefaultHighlighter.DefaultHighlightPainter(highlightColor));
                } catch (BadLocationException e1) {
                    log.info(printStackTrace(e1));
                }
            }
        }

        public String getOutputText() {
            return txtOutput.getText();
        }

        private void showHelp() {
            final StringBuilder out = new StringBuilder("");

            out.append("[abc] a, b, or c (simple class)\n" +
                    "[^abc] Any character except a, b, or c (negation)\n" +
                    "[a-zA-Z] a through z, or A through Z, inclusive (range)\n" +
                    "[a-d[m-p]] a through d, or m through p: [a-dm-p] (union)\n" +
                    "[a-z&&[def]] d, e, or f (intersection)\n" +
                    "[a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)\n" +
                    "[a-z&&[^m-p]] a through z, and not m through p: [a-lq-z] (subtraction)");

            out.append("\n\nAny character\n" +
                    "\\d A digit: [0-9]\n" +
                    "\\D A non-digit: [\\^0-9]\n" +
                    "\\s A whitespace character: [ \\t\\n\\x0B\\f\\r]\n" +
                    "\\S A non-whitespace character: [\\^\\s]\n" +
                    "\\w A word character: [a-zA-Z_0-9]\n" +
                    "\\W A non-word character: [\\^\\w]");

            out.append("\n\n^ The beginning of a line.\n" +
                    "$ The end of a line.\n" +
                    "\\b A word boundary.\n" +
                    "\\B A non-word boundary.\n" +
                    "\\A The beginning of the input.\n" +
                    "\\G The end of the previous match.\n" +
                    "\\Z The end of the input but for the final terminator, if any.\n" +
                    "\\z The end of the input.");

            out.append("\n\n" +
                    "X? X?? X?+ X, once or not at all\n" +
                    "X* X*? X*+ X, zero or more times\n" +
                    "X+ X+? X++ X, one or more times\n" +
                    "X{n} X{n}? X{n}+ X, exactly n times\n" +
                    "X{n,} X{n,}? X{n,}+ X, at least n times\n" +
                    "X{n,m} X{n,m}? X{n,m}+ X, at least n but not more than\n" +
                    "m times");


            showTextResult("Regexp", out.toString(), txtPattern);
        }

        private void filter() {

            txtInput.getHighlighter().removeAllHighlights();
            txtInsert.setEnabled(radReplace.isSelected() || radInsertAfter.isSelected() || radInsertLineAfter.isSelected() || radInsertBefore.isSelected() || radInsertLineBefore.isSelected());

            try {
                txtPattern.setBackground(UIManager.getColor("TextField.background"));
                txtOutput.setText("");

                if (txtPattern.getText().trim().length() == 0) return;

                final String inputText = txtInput.getText();
                final Pattern pattern = Pattern.compile(txtPattern.getText());
                final Matcher matcher = pattern.matcher(inputText);
                final String replacement = txtInsert.getText();

                final StringBuilder filteredText = new StringBuilder();
                final char[] input = inputText.toCharArray();
                int currentIndex = 0;
                final Map<Integer, Integer> outputHighlights = new LinkedHashMap<>();
                while (matcher.find()) {
                    final int start = matcher.start();
                    final int end = matcher.end();

                    txtInput.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.decode("#91bfdb")));

                    if (replacement.length() > 0) {

                        String newLine = replacement;
                        for (int i = 0; i < matcher.groupCount(); i++)
                            newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));

                        if (chkKeepMatches.isSelected()) {
                            filteredText.append(newLine).append(lineSeparator);
                            currentIndex = inputText.length();
                        } else {
                            if (radReplace.isSelected()) {
                                filteredText.append(inputText.substring(currentIndex, start));
                                int newStart = filteredText.length();
                                filteredText.append(newLine);
                                outputHighlights.put(newStart, filteredText.length());
                                currentIndex = end;
                            } else if (radInsertAfter.isSelected()) {
                                filteredText.append(inputText.substring(currentIndex, end));
                                int newStart = filteredText.length();
                                filteredText.append(newLine);
                                outputHighlights.put(newStart, filteredText.length());
                                currentIndex = end;
                            } else if (radInsertBefore.isSelected()) {
                                filteredText.append(inputText.substring(currentIndex, start));
                                int newStart = filteredText.length();
                                filteredText.append(newLine);
                                outputHighlights.put(newStart, filteredText.length());
                                filteredText.append(inputText.substring(start, end));
                                currentIndex = end;
                            } else if (radInsertLineBefore.isSelected()) {
                                filteredText.append(inputText.substring(currentIndex, start));
                                int newStart = filteredText.length();
                                filteredText.append(newLine);
                                outputHighlights.put(newStart, filteredText.length());
                                filteredText.append(lineSeparator);
                                filteredText.append(inputText.substring(start, end));
                                currentIndex = end;
                            }
                        }
                    }

                    if (radRemove.isSelected()) {
                        filteredText.append(inputText.substring(currentIndex, start));
                        currentIndex = end;

                    } else if (radRemoveLine.isSelected()) {

                        // if there are multiple matches on a line, the first match removes the entire line.
                        // Therefore, just ignore the rest of the matches on this (removed) line.
                        if (start >= currentIndex) {
                            int startOfLine = start;
                            while (startOfLine > 0) {
                                if (lineSeparator.equals(("" + input[startOfLine])))
                                    break;
                                startOfLine--;
                            }

                            int endOfLine = end;
                            while (endOfLine < input.length) {
                                if (lineSeparator.equals(("" + input[endOfLine])))
                                    break;
                                endOfLine++;
                            }

                            filteredText.append(inputText.substring(currentIndex, startOfLine));
                            currentIndex = endOfLine;
                        }

                    } else if (radRemoveLineBefore.isSelected()) {

                        int startOfLine = start;
                        int endOfLine = 0;
                        while (startOfLine > 0) {
                            if (lineSeparator.equals(("" + input[startOfLine]))) {
                                if (endOfLine == 0) {
                                    endOfLine = startOfLine;
                                } else
                                    break;
                            }
                            startOfLine--;
                        }

                        if (startOfLine >= currentIndex) {
                            filteredText.append(inputText.substring(currentIndex, startOfLine));
                            currentIndex = endOfLine;
                        }

                    } else if (radRemoveLineAfter.isSelected()) {

                        if (start >= currentIndex) {
                            int endOfLine = end;
                            int startOfLine = -1;
                            while (endOfLine < input.length - 1) {
                                if (lineSeparator.equals(("" + input[endOfLine]))) {
                                    if (startOfLine == -1) {
                                        startOfLine = endOfLine;
                                    } else
                                        break;
                                }
                                endOfLine++;
                            }
                            filteredText.append(inputText.substring(currentIndex, startOfLine == -1 ? end : startOfLine));
                            currentIndex = endOfLine;
                        }

                    } else if (radInsertLineAfter.isSelected()) {

                        String newLine = "";
                        if (replacement.length() > 0) {
                            newLine = replacement;
                            for (int i = 0; i < matcher.groupCount(); i++)
                                newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
                        }

                        filteredText.append(inputText.substring(currentIndex, end));
                        filteredText.append(lineSeparator);
                        int newStart = filteredText.length();
                        filteredText.append(newLine);
                        outputHighlights.put(newStart, filteredText.length());
                        currentIndex = end;

                    } else if (chkKeepMatches.isSelected()) {
                        filteredText.append(inputText.substring(start, end)).append(lineSeparator);
                        currentIndex = inputText.length();
                    }
                }

                if (currentIndex < inputText.length())
                    filteredText.append(inputText.substring(currentIndex, inputText.length()));

                final StringBuilder outputText = new StringBuilder();
                if (chkTrimEmptyLines.isSelected()) {
                    final String[] lines = filteredText.toString().split(lineSeparator);
                    String previous = null;
                    for (int i = 0; i < lines.length; i++) {
                        String line = lines[i];
                        if (line.trim().length() == 0 && previous != null && previous.trim().length() == 0)
                            continue;
                        outputText.append(line).append(lineSeparator);
                        previous = line;
                    }

                } else {
                    outputText.append(filteredText.toString());
                }

                txtOutput.setText(outputText.toString().trim());
                txtOutput.setCaretPosition(0);

                if (chkShowDifference.isSelected()) showDifference();

                for (Map.Entry<Integer, Integer> entry : outputHighlights.entrySet())
                    txtOutput.getHighlighter().addHighlight(entry.getKey(), entry.getValue(), new DefaultHighlighter.DefaultHighlightPainter(Color.decode("#99d594")));

            } catch (Throwable e) {
                txtPattern.setToolTipText(e.getMessage());
                txtPattern.setBackground(Color.decode("#fc8d59"));
                txtOutput.setText(e.getMessage());
                txtOutput.setCaretPosition(0);
            }
        }

        public String getPattern() {
            return txtPattern.getText().trim();
        }


        public void showTextResult(String title, String text, Component parentComponent) {
            showTextResult(title, text, parentComponent, true);
        }

        public void showTextResult(String title, String text, Component parentComponent, boolean modal) {
            showTextResult(title, text, parentComponent, new Dimension(800, 600), modal);
        }

        public void showTextResult(String title, String text, Component parentComponent, Dimension defaultSize, boolean modal) {
            final JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel(title + " : "), BorderLayout.NORTH);

            final JTextArea txtEditor = newTextArea();
            txtEditor.setText(text);

            final JScrollPane content = new JScrollPane(txtEditor);
            if (defaultSize != null) {
                content.setMaximumSize(defaultSize);
                content.setPreferredSize(defaultSize);
                content.setMinimumSize(defaultSize);
                content.setSize(defaultSize);
            }
            panel.add(content, BorderLayout.CENTER);

            if (modal)
                showDialog(content, parentComponent, "Text", null, true);
            else
                JOptionPane.showMessageDialog(parentComponent, panel, "Text", INFORMATION_MESSAGE);
        }
    }

    public static String encode(Color colour) throws NullPointerException {
        String hexColour = Integer.toHexString(colour.getRGB() & 0xffffff);
        if (hexColour.length() < 6) {
            hexColour = "000000".substring(0, 6 - hexColour.length()) + hexColour;
        }
        return "#" + hexColour;
    }

    protected class ColorBrewerSelector extends JPanel {

        private final JTextField txtColor = new JTextField(30);
        private Color selectedColor;

        public ColorBrewerSelector() {
            super(new BorderLayout());

            final JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            final JLabel lblColor = new JLabel("Selected color");
            northPanel.add(lblColor);
            northPanel.add(txtColor);
            add(northPanel, BorderLayout.NORTH);

            final JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.add("Sequential", new PalettePanel(ColorBrewer.getSequentialColorPalettes()));
            tabbedPane.add("Diverging", new PalettePanel(ColorBrewer.getDivergingColorPalettes()));
            tabbedPane.add("Qualitative", new PalettePanel(ColorBrewer.getQualitativeColorPalettes()));
            tabbedPane.add("Custom", new PalettePanel(ColorBrewer.getCustomColorPalettes()));
            add(tabbedPane, BorderLayout.CENTER);
        }

        public void show(NodeCanvas canvas, ConfirmAction confirmAction) {
            showDialog(this, canvas, "Color", confirmAction);
        }

        private final class PalettePanel extends JPanel {

            PalettePanel(ColorBrewer[] palettes) {
                super(new BorderLayout());

                final JPanel palettesPanel = new JPanel(null);
                final BoxLayout layout = new BoxLayout(palettesPanel, BoxLayout.PAGE_AXIS);
                palettesPanel.setLayout(layout);

                for (ColorBrewer palette : palettes) {
                    final StringBuilder columns = new StringBuilder("100dlu");
                    final Color[] colorPalette = palette.getColorPalette(7);
                    final JButton[] btnColor = new JButton[colorPalette.length];
                    for (int i = 0; i < colorPalette.length; i++) {
                        columns.append(", 2dlu, 15dlu");
                        final Color color = colorPalette[i];
                        btnColor[i] = new JButton(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                selectedColor = color;
                                txtColor.setText(String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()));
                            }
                        });
                        btnColor[i].setBackground(color);
                    }

                    final FormPanel paletteForm = new FormPanel(columns.toString(), "15dlu");
                    paletteForm.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
                    int col = 1;
                    paletteForm.addLabel(palette.getPaletteDescription(), col, 1);
                    col += 2;
                    for (final JButton button : btnColor) {
                        paletteForm.add(button, col, 1);
                        col += 2;
                    }

                    palettesPanel.add(paletteForm.build());
                }

                final Dimension preferredSize = new Dimension(500, 400);
                setPreferredSize(preferredSize);
                setMinimumSize(preferredSize);
                setSize(preferredSize);

                add(new JScrollPane(palettesPanel), BorderLayout.CENTER);
            }
        }

        public Color getSelectedColor() {
            return selectedColor;
        }

    }

    /**
     * The data values were extracted from the RColorBrewer R package.
     * See http://www.datavis.ca/sas/macros/color/brewer.sas
     *
     * @author Peter Rose
     */
    public enum ColorBrewer {
        Custom(4, "Custom", true, new int[][]{
                {0xffffff},
                {0xffffff, 0x000000}
        }),
        BrBG(1, "Brown-Blue-Green", true, new int[][]{
                {0xD8B365},
                {0xD8B365, 0x5AB4AC},
                {0xD8B365, 0xF5F5F5, 0x5AB4AC},
                {0xA6611A, 0xDFC27D, 0x80CDC1, 0x018571},
                {0xA6611A, 0xDFC27D, 0xF5F5F5, 0x80CDC1, 0x018571},
                {0x8C510A, 0xD8B365, 0xF6E8C3, 0xC7EAE5, 0x5AB4AC, 0x01665E},
                {0x8C510A, 0xD8B365, 0xF6E8C3, 0xF5F5F5, 0xC7EAE5, 0x5AB4AC, 0x01665E},
                {0x8C510A, 0xBF812D, 0xDFC27D, 0xF6E8C3, 0xC7EAE5, 0x80CDC1, 0x35978F, 0x01665E},
                {0x8C510A, 0xBF812D, 0xDFC27D, 0xF6E8C3, 0xF5F5F5, 0xC7EAE5, 0x80CDC1, 0x35978F, 0x01665E},
                {0x543005, 0x8C510A, 0xBF812D, 0xDFC27D, 0xF6E8C3, 0xC7EAE5, 0x80CDC1, 0x35978F, 0x01665E, 0x003C30},
                {0x543005, 0x8C510A, 0xBF812D, 0xDFC27D, 0xF6E8C3, 0xF5F5F5, 0xC7EAE5, 0x80CDC1, 0x35978F, 0x01665E, 0x003C30}
        }),
        PiYG(1, "Magenta-Yellow-Green", true, new int[][]{
                {0xE9A3C9},
                {0xE9A3C9, 0xA1D76A},
                {0xE9A3C9, 0xF7F7F7, 0xA1D76A},
                {0xD01C8B, 0xF1B6DA, 0xB8E186, 0x4DAC26},
                {0xD01C8B, 0xF1B6DA, 0xF7F7F7, 0xB8E186, 0x4DAC26},
                {0xC51B7D, 0xE9A3C9, 0xFDE0EF, 0xE6F5D0, 0xA1D76A, 0x4D9221},
                {0xC51B7D, 0xE9A3C9, 0xFDE0EF, 0xF7F7F7, 0xE6F5D0, 0xA1D76A, 0x4D9221},
                {0xC51B7D, 0xDE77AE, 0xF1B6DA, 0xFDE0EF, 0xE6F5D0, 0xB8E186, 0x7FBC41, 0x4D9221},
                {0xC51B7D, 0xDE77AE, 0xF1B6DA, 0xFDE0EF, 0xF7F7F7, 0xE6F5D0, 0xB8E186, 0x7FBC41, 0x4D9221},
                {0x8E0152, 0xC51B7D, 0xDE77AE, 0xF1B6DA, 0xFDE0EF, 0xE6F5D0, 0xB8E186, 0x7FBC41, 0x4D9221, 0x276419},
                {0x8E0152, 0xC51B7D, 0xDE77AE, 0xF1B6DA, 0xFDE0EF, 0xF7F7F7, 0xE6F5D0, 0xB8E186, 0x7FBC41, 0x4D9221, 0x276419}
        }),
        PRGn(1, "Purple-Red-Green", true, new int[][]{
                {0xAF8DC3},
                {0xAF8DC3, 0x7FBF7B},
                {0xAF8DC3, 0xF7F7F7, 0x7FBF7B},
                {0x7B3294, 0xC2A5CF, 0xA6DBA0, 0x008837},
                {0x7B3294, 0xC2A5CF, 0xF7F7F7, 0xA6DBA0, 0x008837},
                {0x762A83, 0xAF8DC3, 0xE7D4E8, 0xD9F0D3, 0x7FBF7B, 0x1B7837},
                {0x762A83, 0xAF8DC3, 0xE7D4E8, 0xF7F7F7, 0xD9F0D3, 0x7FBF7B, 0x1B7837},
                {0x762A83, 0x9970AB, 0xC2A5CF, 0xE7D4E8, 0xD9F0D3, 0xA6DBA0, 0x5AAE61, 0x1B7837},
                {0x762A83, 0x9970AB, 0xC2A5CF, 0xE7D4E8, 0xF7F7F7, 0xD9F0D3, 0xA6DBA0, 0x5AAE61, 0x1B7837},
                {0x40004B, 0x762A83, 0x9970AB, 0xC2A5CF, 0xE7D4E8, 0xD9F0D3, 0xA6DBA0, 0x5AAE61, 0x1B7837, 0x00441B},
                {0x40004B, 0x762A83, 0x9970AB, 0xC2A5CF, 0xE7D4E8, 0xF7F7F7, 0xD9F0D3, 0xA6DBA0, 0x5AAE61, 0x1B7837, 0x00441B}
        }),
        PuOr(1, "Purple-Orange", true, new int[][]{
                {0xF1A340},
                {0xF1A340, 0x998EC3},
                {0xF1A340, 0xF7F7F7, 0x998EC3},
                {0xE66101, 0xFDB863, 0xB2ABD2, 0x5E3C99},
                {0xE66101, 0xFDB863, 0xF7F7F7, 0xB2ABD2, 0x5E3C99},
                {0xB35806, 0xF1A340, 0xFEE0B6, 0xD8DAEB, 0x998EC3, 0x542788},
                {0xB35806, 0xF1A340, 0xFEE0B6, 0xF7F7F7, 0xD8DAEB, 0x998EC3, 0x542788},
                {0xB35806, 0xE08214, 0xFDB863, 0xFEE0B6, 0xD8DAEB, 0xB2ABD2, 0x8073AC, 0x542788},
                {0xB35806, 0xE08214, 0xFDB863, 0xFEE0B6, 0xF7F7F7, 0xD8DAEB, 0xB2ABD2, 0x8073AC, 0x542788},
                {0x7F3B08, 0xB35806, 0xE08214, 0xFDB863, 0xFEE0B6, 0xD8DAEB, 0xB2ABD2, 0x8073AC, 0x542788, 0x2D004B},
                {0x7F3B08, 0xB35806, 0xE08214, 0xFDB863, 0xFEE0B6, 0xF7F7F7, 0xD8DAEB, 0xB2ABD2, 0x8073AC, 0x542788, 0x2D004B}
        }),
        RdBu(1, "Red-Blue", true, new int[][]{
                {0xEF8A62},
                {0xEF8A62, 0x67A9CF},
                {0xEF8A62, 0xF7F7F7, 0x67A9CF},
                {0xCA0020, 0xF4A582, 0x92C5DE, 0x0571B0},
                {0xCA0020, 0xF4A582, 0xF7F7F7, 0x92C5DE, 0x0571B0},
                {0xB2182B, 0xEF8A62, 0xFDDBC7, 0xD1E5F0, 0x67A9CF, 0x2166AC},
                {0xB2182B, 0xEF8A62, 0xFDDBC7, 0xF7F7F7, 0xD1E5F0, 0x67A9CF, 0x2166AC},
                {0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xD1E5F0, 0x92C5DE, 0x4393C3, 0x2166AC},
                {0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xF7F7F7, 0xD1E5F0, 0x92C5DE, 0x4393C3, 0x2166AC},
                {0x67001F, 0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xD1E5F0, 0x92C5DE, 0x4393C3, 0x2166AC, 0x053061},
                {0x67001F, 0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xF7F7F7, 0xD1E5F0, 0x92C5DE, 0x4393C3, 0x2166AC, 0x053061}
        }),
        RdGy(1, "Red-Grey", false, new int[][]{
                {0xEF8A62},
                {0xEF8A62, 0x999999},
                {0xEF8A62, 0xFFFFFF, 0x999999},
                {0xCA0020, 0xF4A582, 0xBABABA, 0x404040},
                {0xCA0020, 0xF4A582, 0xFFFFFF, 0xBABABA, 0x404040},
                {0xB2182B, 0xEF8A62, 0xFDDBC7, 0xE0E0E0, 0x999999, 0x4D4D4D},
                {0xB2182B, 0xEF8A62, 0xFDDBC7, 0xFFFFFF, 0xE0E0E0, 0x999999, 0x4D4D4D},
                {0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xE0E0E0, 0xBABABA, 0x878787, 0x4D4D4D},
                {0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xFFFFFF, 0xE0E0E0, 0xBABABA, 0x878787, 0x4D4D4D},
                {0x67001F, 0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xE0E0E0, 0xBABABA, 0x878787, 0x4D4D4D, 0x1A1A1A},
                {0x67001F, 0xB2182B, 0xD6604D, 0xF4A582, 0xFDDBC7, 0xFFFFFF, 0xE0E0E0, 0xBABABA, 0x878787, 0x4D4D4D, 0x1A1A1A}
        }),
        RdYlBu(1, "Red-Yellow-Blue", true, new int[][]{
                {0xFC8D59},
                {0xFC8D59, 0x91BFDB},
                {0xFC8D59, 0xFFFFBF, 0x91BFDB},
                {0xD7191C, 0xFDAE61, 0xABD9E9, 0x2C7BB6},
                {0xD7191C, 0xFDAE61, 0xFFFFBF, 0xABD9E9, 0x2C7BB6},
                {0xD73027, 0xFC8D59, 0xFEE090, 0xE0F3F8, 0x91BFDB, 0x4575B4},
                {0xD73027, 0xFC8D59, 0xFEE090, 0xFFFFBF, 0xE0F3F8, 0x91BFDB, 0x4575B4},
                {0xD73027, 0xF46D43, 0xFDAE61, 0xFEE090, 0xE0F3F8, 0xABD9E9, 0x74ADD1, 0x4575B4},
                {0xD73027, 0xF46D43, 0xFDAE61, 0xFEE090, 0xFFFFBF, 0xE0F3F8, 0xABD9E9, 0x74ADD1, 0x4575B4},
                {0xA50026, 0xD73027, 0xF46D43, 0xFDAE61, 0xFEE090, 0xE0F3F8, 0xABD9E9, 0x74ADD1, 0x4575B4, 0x313695},
                {0xA50026, 0xD73027, 0xF46D43, 0xFDAE61, 0xFEE090, 0xFFFFBF, 0xE0F3F8, 0xABD9E9, 0x74ADD1, 0x4575B4, 0x313695}
        }),
        RdYlGn(1, "Red-Yellow-Green", false, new int[][]{
                {0xFC8D59},
                {0xFC8D59, 0x91CF60},
                {0xFC8D59, 0xFFFFBF, 0x91CF60},
                {0xD7191C, 0xFDAE61, 0xA6D96A, 0x1A9641},
                {0xD7191C, 0xFDAE61, 0xFFFFBF, 0xA6D96A, 0x1A9641},
                {0xD73027, 0xFC8D59, 0xFEE08B, 0xD9EF8B, 0x91CF60, 0x1A9850},
                {0xD73027, 0xFC8D59, 0xFEE08B, 0xFFFFBF, 0xD9EF8B, 0x91CF60, 0x1A9850},
                {0xD73027, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xD9EF8B, 0xA6D96A, 0x66BD63, 0x1A9850},
                {0xD73027, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xFFFFBF, 0xD9EF8B, 0xA6D96A, 0x66BD63, 0x1A9850},
                {0xA50026, 0xD73027, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xD9EF8B, 0xA6D96A, 0x66BD63, 0x1A9850, 0x006837},
                {0xA50026, 0xD73027, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xFFFFBF, 0xD9EF8B, 0xA6D96A, 0x66BD63, 0x1A9850, 0x006837}
        }),
        Spectral(1, "Spectral colors", false, new int[][]{
                {0xFC8D59},
                {0xFC8D59, 0x99D594},
                {0xFC8D59, 0xFFFFBF, 0x99D594},
                {0xD7191C, 0xFDAE61, 0xABDDA4, 0x2B83BA},
                {0xD7191C, 0xFDAE61, 0xFFFFBF, 0xABDDA4, 0x2B83BA},
                {0xD53E4F, 0xFC8D59, 0xFEE08B, 0xE6F598, 0x99D594, 0x3288BD},
                {0xD53E4F, 0xFC8D59, 0xFEE08B, 0xFFFFBF, 0xE6F598, 0x99D594, 0x3288BD},
                {0xD53E4F, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xE6F598, 0xABDDA4, 0x66C2A5, 0x3288BD},
                {0xD53E4F, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xFFFFBF, 0xE6F598, 0xABDDA4, 0x66C2A5, 0x3288BD},
                {0x9E0142, 0xD53E4F, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xE6F598, 0xABDDA4, 0x66C2A5, 0x3288BD, 0x5E4FA2},
                {0x9E0142, 0xD53E4F, 0xF46D43, 0xFDAE61, 0xFEE08B, 0xFFFFBF, 0xE6F598, 0xABDDA4, 0x66C2A5, 0x3288BD, 0x5E4FA2}
        }),
        /* qualitative colors */
        Accent(2, "Accents", false, new int[][]{
                {0x7FC97F},
                {0x7FC97F, 0xFDC086},
                {0x7FC97F, 0xBEAED4, 0xFDC086},
                {0x7FC97F, 0xBEAED4, 0xFDC086, 0xFFFF99},
                {0x7FC97F, 0xBEAED4, 0xFDC086, 0xFFFF99, 0x386CB0},
                {0x7FC97F, 0xBEAED4, 0xFDC086, 0xFFFF99, 0x386CB0, 0xF0027F},
                {0x7FC97F, 0xBEAED4, 0xFDC086, 0xFFFF99, 0x386CB0, 0xF0027F, 0xBF5B17},
                {0x7FC97F, 0xBEAED4, 0xFDC086, 0xFFFF99, 0x386CB0, 0xF0027F, 0xBF5B17, 0x666666}
        }),
        Dark2(2, "Dark colors", false, new int[][]{
                {0x1B9E77},
                {0x1B9E77, 0x7570B3},
                {0x1B9E77, 0xD95F02, 0x7570B3},
                {0x1B9E77, 0xD95F02, 0x7570B3, 0xE7298A},
                {0x1B9E77, 0xD95F02, 0x7570B3, 0xE7298A, 0x66A61E},
                {0x1B9E77, 0xD95F02, 0x7570B3, 0xE7298A, 0x66A61E, 0xE6AB02},
                {0x1B9E77, 0xD95F02, 0x7570B3, 0xE7298A, 0x66A61E, 0xE6AB02, 0xA6761D},
                {0x1B9E77, 0xD95F02, 0x7570B3, 0xE7298A, 0x66A61E, 0xE6AB02, 0xA6761D, 0x666666}
        }),
        Paired(2, "Paired colors", true, new int[][]{
                {0xA6CEE3},
                {0xA6CEE3, 0xB2DF8A},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C, 0xFDBF6F},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C, 0xFDBF6F, 0xFF7F00},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C, 0xFDBF6F, 0xFF7F00, 0xCAB2D6},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C, 0xFDBF6F, 0xFF7F00, 0xCAB2D6, 0x6A3D9A},
                {0xA6CEE3, 0x1F78B4, 0xB2DF8A, 0x33A02C, 0xFB9A99, 0xE31A1C, 0xFDBF6F, 0xFF7F00, 0xCAB2D6, 0x6A3D9A, 0xFFFF99}
        }),
        Pastel1(2, "Pastel1 colors", false, new int[][]{
                {0xFBB4AE},
                {0xFBB4AE, 0xCCEBC5},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4, 0xFED9A6},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4, 0xFED9A6, 0xFFFFCC},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4, 0xFED9A6, 0xFFFFCC, 0xE5D8BD},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4, 0xFED9A6, 0xFFFFCC, 0xE5D8BD, 0xFDDAEC},
                {0xFBB4AE, 0xB3CDE3, 0xCCEBC5, 0xDECBE4, 0xFED9A6, 0xFFFFCC, 0xE5D8BD, 0xFDDAEC, 0xF2F2F2}
        }),
        Pastel2(2, "Pastel2 colors", false, new int[][]{
                {0xB3E2CD},
                {0xB3E2CD, 0xCBD5E8},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8, 0xF4CAE4},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8, 0xF4CAE4, 0xE6F5C9},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8, 0xF4CAE4, 0xE6F5C9, 0xFFF2AE},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8, 0xF4CAE4, 0xE6F5C9, 0xFFF2AE, 0xF1E2CC},
                {0xB3E2CD, 0xFDCDAC, 0xCBD5E8, 0xF4CAE4, 0xE6F5C9, 0xFFF2AE, 0xF1E2CC, 0xCCCCCC}
        }),
        Set1(2, "Set1 colors", false, new int[][]{
                {0xE41A1C},
                {0xE41A1C, 0x4DAF4A},
                {0xE41A1C, 0x377EB8, 0x4DAF4A},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3, 0xFF7F00},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3, 0xFF7F00, 0xFFFF33},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3, 0xFF7F00, 0xFFFF33, 0xA65628},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3, 0xFF7F00, 0xFFFF33, 0xA65628, 0xF781BF},
                {0xE41A1C, 0x377EB8, 0x4DAF4A, 0x984EA3, 0xFF7F00, 0xFFFF33, 0xA65628, 0xF781BF, 0x999999}
        }),
        Set2(2, "Set2 colors", false, new int[][]{
                {0x66C2A5},
                {0x66C2A5, 0x8DA0CB},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB, 0xE78AC3},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB, 0xE78AC3, 0xA6D854},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB, 0xE78AC3, 0xA6D854, 0xFFD92F},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB, 0xE78AC3, 0xA6D854, 0xFFD92F, 0xE5C494},
                {0x66C2A5, 0xFC8D62, 0x8DA0CB, 0xE78AC3, 0xA6D854, 0xFFD92F, 0xE5C494, 0xB3B3B}
        }),
        Set3(2, "Set3 colors", false, new int[][]{
                {0x8DD3C7},
                {0x8DD3C7, 0xBEBADA},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462, 0xB3DE69},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462, 0xB3DE69, 0xFCCDE5},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462, 0xB3DE69, 0xFCCDE5, 0xD9D9D9},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462, 0xB3DE69, 0xFCCDE5, 0xD9D9D9, 0xBC80BD},
                {0x8DD3C7, 0xFFFFB3, 0xBEBADA, 0xFB8072, 0x80B1D3, 0xFDB462, 0xB3DE69, 0xFCCDE5, 0xD9D9D9, 0xBC80BD, 0xCCEBC5}
        }),
        /* sequential colors */
        Blues(3, "Blue shades", true, new int[][]{
                {0xDEEBF7},
                {0xDEEBF7, 0x3182BD},
                {0xDEEBF7, 0x9ECAE1, 0x3182BD},
                {0xEFF3FF, 0xBDD7E7, 0x6BAED6, 0x2171B5},
                {0xEFF3FF, 0xBDD7E7, 0x6BAED6, 0x3182BD, 0x08519C},
                {0xEFF3FF, 0xC6DBEF, 0x9ECAE1, 0x6BAED6, 0x3182BD, 0x08519C},
                {0xEFF3FF, 0xC6DBEF, 0x9ECAE1, 0x6BAED6, 0x4292C6, 0x2171B5, 0x084594},
                {0xF7FBFF, 0xDEEBF7, 0xC6DBEF, 0x9ECAE1, 0x6BAED6, 0x4292C6, 0x2171B5, 0x084594},
                {0xF7FBFF, 0xDEEBF7, 0xC6DBEF, 0x9ECAE1, 0x6BAED6, 0x4292C6, 0x2171B5, 0x08519C, 0x08306B}
        }),
        BuGn(3, "Blue-Green shades", true, new int[][]{
                {0xE5F5F9},
                {0xE5F5F9, 0x2CA25F},
                {0xE5F5F9, 0x99D8C9, 0x2CA25F},
                {0xEDF8FB, 0xB2E2E2, 0x66C2A4, 0x238B45},
                {0xEDF8FB, 0xB2E2E2, 0x66C2A4, 0x2CA25F, 0x006D2C},
                {0xEDF8FB, 0xCCECE6, 0x99D8C9, 0x66C2A4, 0x2CA25F, 0x006D2C},
                {0xEDF8FB, 0xCCECE6, 0x99D8C9, 0x66C2A4, 0x41AE76, 0x238B45, 0x005824},
                {0xF7FCFD, 0xE5F5F9, 0xCCECE6, 0x99D8C9, 0x66C2A4, 0x41AE76, 0x238B45, 0x005824},
                {0xF7FCFD, 0xE5F5F9, 0xCCECE6, 0x99D8C9, 0x66C2A4, 0x41AE76, 0x238B45, 0x006D2C, 0x00441B}
        }),
        BuPu(3, "Blue-Purple shades", true, new int[][]{
                {0xE0ECF4},
                {0xE0ECF4, 0x8856A7},
                {0xE0ECF4, 0x9EBCDA, 0x8856A7},
                {0xEDF8FB, 0xB3CDE3, 0x8C96C6, 0x88419D},
                {0xEDF8FB, 0xB3CDE3, 0x8C96C6, 0x8856A7, 0x810F7C},
                {0xEDF8FB, 0xBFD3E6, 0x9EBCDA, 0x8C96C6, 0x8856A7, 0x810F7C},
                {0xEDF8FB, 0xBFD3E6, 0x9EBCDA, 0x8C96C6, 0x8C6BB1, 0x88419D, 0x6E016B},
                {0xF7FCFD, 0xE0ECF4, 0xBFD3E6, 0x9EBCDA, 0x8C96C6, 0x8C6BB1, 0x88419D, 0x6E016B},
                {0xF7FCFD, 0xE0ECF4, 0xBFD3E6, 0x9EBCDA, 0x8C96C6, 0x8C6BB1, 0x88419D, 0x810F7C, 0x4D004B}
        }),
        GnBu(3, "Green-Blue shades", true, new int[][]{
                {0xE0F3DB},
                {0xE0F3DB, 0x43A2CA},
                {0xE0F3DB, 0xA8DDB5, 0x43A2CA},
                {0xF0F9E8, 0xBAE4BC, 0x7BCCC4, 0x2B8CBE},
                {0xF0F9E8, 0xBAE4BC, 0x7BCCC4, 0x43A2CA, 0x0868AC},
                {0xF0F9E8, 0xCCEBC5, 0xA8DDB5, 0x7BCCC4, 0x43A2CA, 0x0868AC},
                {0xF0F9E8, 0xCCEBC5, 0xA8DDB5, 0x7BCCC4, 0x4EB3D3, 0x2B8CBE, 0x08589E},
                {0xF7FCF0, 0xE0F3DB, 0xCCEBC5, 0xA8DDB5, 0x7BCCC4, 0x4EB3D3, 0x2B8CBE, 0x08589E},
                {0xF7FCF0, 0xE0F3DB, 0xCCEBC5, 0xA8DDB5, 0x7BCCC4, 0x4EB3D3, 0x2B8CBE, 0x0868AC, 0x084081}
        }),
        Greens(3, "Green shades", true, new int[][]{
                {0xE5F5E0},
                {0xE5F5E0, 0x31A354},
                {0xE5F5E0, 0xA1D99B, 0x31A354},
                {0xEDF8E9, 0xBAE4B3, 0x74C476, 0x238B45},
                {0xEDF8E9, 0xBAE4B3, 0x74C476, 0x31A354, 0x006D2C},
                {0xEDF8E9, 0xC7E9C0, 0xA1D99B, 0x74C476, 0x31A354, 0x006D2C},
                {0xEDF8E9, 0xC7E9C0, 0xA1D99B, 0x74C476, 0x41AB5D, 0x238B45, 0x005A32},
                {0xF7FCF5, 0xE5F5E0, 0xC7E9C0, 0xA1D99B, 0x74C476, 0x41AB5D, 0x238B45, 0x005A32},
                {0xF7FCF5, 0xE5F5E0, 0xC7E9C0, 0xA1D99B, 0x74C476, 0x41AB5D, 0x238B45, 0x006D2C, 0x00441B}
        }),
        Greys(3, "Grey shades", true, new int[][]{
                {0xF0F0F0},
                {0xF0F0F0, 0x636363},
                {0xF0F0F0, 0xBDBDBD, 0x636363},
                {0xF7F7F7, 0xCCCCCC, 0x969696, 0x525252},
                {0xF7F7F7, 0xCCCCCC, 0x969696, 0x636363, 0x252525},
                {0xF7F7F7, 0xD9D9D9, 0xBDBDBD, 0x969696, 0x636363, 0x252525},
                {0xF7F7F7, 0xD9D9D9, 0xBDBDBD, 0x969696, 0x737373, 0x525252, 0x252525},
                {0xFFFFFF, 0xF0F0F0, 0xD9D9D9, 0xBDBDBD, 0x969696, 0x737373, 0x525252, 0x252525},
                {0xFFFFFF, 0xF0F0F0, 0xD9D9D9, 0xBDBDBD, 0x969696, 0x737373, 0x525252, 0x252525, 0x000000}
        }),
        Oranges(3, "Orange shades", true, new int[][]{
                {0xFEE6CE},
                {0xFEE6CE, 0xE6550D},
                {0xFEE6CE, 0xFDAE6B, 0xE6550D},
                {0xFEEDDE, 0xFDBE85, 0xFD8D3C, 0xD94701},
                {0xFEEDDE, 0xFDBE85, 0xFD8D3C, 0xE6550D, 0xA63603},
                {0xFEEDDE, 0xFDD0A2, 0xFDAE6B, 0xFD8D3C, 0xE6550D, 0xA63603},
                {0xFEEDDE, 0xFDD0A2, 0xFDAE6B, 0xFD8D3C, 0xF16913, 0xD94801, 0x8C2D04},
                {0xFFF5EB, 0xFEE6CE, 0xFDD0A2, 0xFDAE6B, 0xFD8D3C, 0xF16913, 0xD94801, 0x8C2D04},
                {0xFFF5EB, 0xFEE6CE, 0xFDD0A2, 0xFDAE6B, 0xFD8D3C, 0xF16913, 0xD94801, 0xA63603, 0x7F2704}
        }),
        OrRd(3, "Orange-Red shades", true, new int[][]{
                {0xFEE8C8},
                {0xFEE8C8, 0xE34A33},
                {0xFEE8C8, 0xFDBB84, 0xE34A33},
                {0xFEF0D9, 0xFDCC8A, 0xFC8D59, 0xD7301F},
                {0xFEF0D9, 0xFDCC8A, 0xFC8D59, 0xE34A33, 0xB30000},
                {0xFEF0D9, 0xFDD49E, 0xFDBB84, 0xFC8D59, 0xE34A33, 0xB30000},
                {0xFEF0D9, 0xFDD49E, 0xFDBB84, 0xFC8D59, 0xEF6548, 0xD7301F, 0x990000},
                {0xFFF7EC, 0xFEE8C8, 0xFDD49E, 0xFDBB84, 0xFC8D59, 0xEF6548, 0xD7301F, 0x990000},
                {0xFFF7EC, 0xFEE8C8, 0xFDD49E, 0xFDBB84, 0xFC8D59, 0xEF6548, 0xD7301F, 0xB30000, 0x7F0000}
        }),
        PuBu(3, "Purple-Blue shades", true, new int[][]{
                {0xECE7F2},
                {0xECE7F2, 0x2B8CBE},
                {0xECE7F2, 0xA6BDDB, 0x2B8CBE},
                {0xF1EEF6, 0xBDC9E1, 0x74A9CF, 0x0570B0},
                {0xF1EEF6, 0xBDC9E1, 0x74A9CF, 0x2B8CBE, 0x045A8D},
                {0xF1EEF6, 0xD0D1E6, 0xA6BDDB, 0x74A9CF, 0x2B8CBE, 0x045A8D},
                {0xF1EEF6, 0xD0D1E6, 0xA6BDDB, 0x74A9CF, 0x3690C0, 0x0570B0, 0x034E7B},
                {0xFFF7FB, 0xECE7F2, 0xD0D1E6, 0xA6BDDB, 0x74A9CF, 0x3690C0, 0x0570B0, 0x034E7B},
                {0xFFF7FB, 0xECE7F2, 0xD0D1E6, 0xA6BDDB, 0x74A9CF, 0x3690C0, 0x0570B0, 0x045A8D, 0x023858}
        }),
        PuBuGn(3, "Purple-Blue-Green shades", true, new int[][]{
                {0xECE2F0},
                {0xECE2F0, 0x1C9099},
                {0xECE2F0, 0xA6BDDB, 0x1C9099},
                {0xF6EFF7, 0xBDC9E1, 0x67A9CF, 0x02818A},
                {0xF6EFF7, 0xBDC9E1, 0x67A9CF, 0x1C9099, 0x016C59},
                {0xF6EFF7, 0xD0D1E6, 0xA6BDDB, 0x67A9CF, 0x1C9099, 0x016C59},
                {0xF6EFF7, 0xD0D1E6, 0xA6BDDB, 0x67A9CF, 0x3690C0, 0x02818A, 0x016450},
                {0xFFF7FB, 0xECE2F0, 0xD0D1E6, 0xA6BDDB, 0x67A9CF, 0x3690C0, 0x02818A, 0x016450},
                {0xFFF7FB, 0xECE2F0, 0xD0D1E6, 0xA6BDDB, 0x67A9CF, 0x3690C0, 0x02818A, 0x016C59, 0x014636}
        }),
        PuRd(3, "Purple-Red shades", true, new int[][]{
                {0xE7E1EF},
                {0xE7E1EF, 0xDD1C77},
                {0xE7E1EF, 0xC994C7, 0xDD1C77},
                {0xF1EEF6, 0xD7B5D8, 0xDF65B0, 0xCE1256},
                {0xF1EEF6, 0xD7B5D8, 0xDF65B0, 0xDD1C77, 0x980043},
                {0xF1EEF6, 0xD4B9DA, 0xC994C7, 0xDF65B0, 0xDD1C77, 0x980043},
                {0xF1EEF6, 0xD4B9DA, 0xC994C7, 0xDF65B0, 0xE7298A, 0xCE1256, 0x91003F},
                {0xF7F4F9, 0xE7E1EF, 0xD4B9DA, 0xC994C7, 0xDF65B0, 0xE7298A, 0xCE1256, 0x91003F},
                {0xF7F4F9, 0xE7E1EF, 0xD4B9DA, 0xC994C7, 0xDF65B0, 0xE7298A, 0xCE1256, 0x980043, 0x67001F}
        }),
        Purples(3, "Purple shades", true, new int[][]{
                {0xEFEDF5},
                {0xEFEDF5, 0x756BB1},
                {0xEFEDF5, 0xBCBDDC, 0x756BB1},
                {0xF2F0F7, 0xCBC9E2, 0x9E9AC8, 0x6A51A3},
                {0xF2F0F7, 0xCBC9E2, 0x9E9AC8, 0x756BB1, 0x54278F},
                {0xF2F0F7, 0xDADAEB, 0xBCBDDC, 0x9E9AC8, 0x756BB1, 0x54278F},
                {0xF2F0F7, 0xDADAEB, 0xBCBDDC, 0x9E9AC8, 0x807DBA, 0x6A51A3, 0x4A1486},
                {0xFCFBFD, 0xEFEDF5, 0xDADAEB, 0xBCBDDC, 0x9E9AC8, 0x807DBA, 0x6A51A3, 0x4A1486},
                {0xFCFBFD, 0xEFEDF5, 0xDADAEB, 0xBCBDDC, 0x9E9AC8, 0x807DBA, 0x6A51A3, 0x54278F, 0x3F007D},
        }),
        RdPu(3, "Red-Purple shades", true, new int[][]{
                {0xFDE0DD},
                {0xFDE0DD, 0xC51B8A},
                {0xFDE0DD, 0xFA9FB5, 0xC51B8A},
                {0xFEEBE2, 0xFBB4B9, 0xF768A1, 0xAE017E},
                {0xFEEBE2, 0xFBB4B9, 0xF768A1, 0xC51B8A, 0x7A0177},
                {0xFEEBE2, 0xFCC5C0, 0xFA9FB5, 0xF768A1, 0xC51B8A, 0x7A0177},
                {0xFEEBE2, 0xFCC5C0, 0xFA9FB5, 0xF768A1, 0xDD3497, 0xAE017E, 0x7A0177},
                {0xFFF7F3, 0xFDE0DD, 0xFCC5C0, 0xFA9FB5, 0xF768A1, 0xDD3497, 0xAE017E, 0x7A0177},
                {0xFFF7F3, 0xFDE0DD, 0xFCC5C0, 0xFA9FB5, 0xF768A1, 0xDD3497, 0xAE017E, 0x7A0177, 0x49006A}
        }),
        Reds(3, "Red shades", true, new int[][]{
                {0xFEE0D2},
                {0xFEE0D2, 0xDE2D26},
                {0xFEE0D2, 0xFC9272, 0xDE2D26},
                {0xFEE5D9, 0xFCAE91, 0xFB6A4A, 0xCB181D},
                {0xFEE5D9, 0xFCAE91, 0xFB6A4A, 0xDE2D26, 0xA50F15},
                {0xFEE5D9, 0xFCBBA1, 0xFC9272, 0xFB6A4A, 0xDE2D26, 0xA50F15},
                {0xFEE5D9, 0xFCBBA1, 0xFC9272, 0xFB6A4A, 0xEF3B2C, 0xCB181D, 0x99000D},
                {0xFFF5F0, 0xFEE0D2, 0xFCBBA1, 0xFC9272, 0xFB6A4A, 0xEF3B2C, 0xCB181D, 0x99000D},
                {0xFFF5F0, 0xFEE0D2, 0xFCBBA1, 0xFC9272, 0xFB6A4A, 0xEF3B2C, 0xCB181D, 0xA50F15, 0x67000D}
        }),
        YlGn(3, "Yellow-Green shades", true, new int[][]{
                {0xF7FCB9},
                {0xF7FCB9, 0x31A354},
                {0xF7FCB9, 0xADDD8E, 0x31A354},
                {0xFFFFCC, 0xC2E699, 0x78C679, 0x238443},
                {0xFFFFCC, 0xC2E699, 0x78C679, 0x31A354, 0x006837},
                {0xFFFFCC, 0xD9F0A3, 0xADDD8E, 0x78C679, 0x31A354, 0x006837},
                {0xFFFFCC, 0xD9F0A3, 0xADDD8E, 0x78C679, 0x41AB5D, 0x238443, 0x005A32},
                {0xFFFFE5, 0xF7FCB9, 0xD9F0A3, 0xADDD8E, 0x78C679, 0x41AB5D, 0x238443, 0x005A32},
                {0xFFFFE5, 0xF7FCB9, 0xD9F0A3, 0xADDD8E, 0x78C679, 0x41AB5D, 0x238443, 0x006837, 0x004529}
        }),
        YlGnBu(3, "Yellow-Green-Blue shades", true, new int[][]{
                {0xEDF8B1},
                {0xEDF8B1, 0x2C7FB8},
                {0xEDF8B1, 0x7FCDBB, 0x2C7FB8},
                {0xFFFFCC, 0xA1DAB4, 0x41B6C4, 0x225EA8},
                {0xFFFFCC, 0xA1DAB4, 0x41B6C4, 0x2C7FB8, 0x253494},
                {0xFFFFCC, 0xC7E9B4, 0x7FCDBB, 0x41B6C4, 0x2C7FB8, 0x253494},
                {0xFFFFCC, 0xC7E9B4, 0x7FCDBB, 0x41B6C4, 0x1D91C0, 0x225EA8, 0x0C2C84},
                {0xFFFFD9, 0xEDF8B1, 0xC7E9B4, 0x7FCDBB, 0x41B6C4, 0x1D91C0, 0x225EA8, 0x0C2C84},
                {0xFFFFD9, 0xEDF8B1, 0xC7E9B4, 0x7FCDBB, 0x41B6C4, 0x1D91C0, 0x225EA8, 0x253494, 0x081D58}
        }),
        YlOrBr(3, "Yellow-Orange-Brown shades", true, new int[][]{
                {0xFFF7BC},
                {0xFFF7BC, 0xD95F0E},
                {0xFFF7BC, 0xFEC44F, 0xD95F0E},
                {0xFFFFD4, 0xFED98E, 0xFE9929, 0xCC4C02},
                {0xFFFFD4, 0xFED98E, 0xFE9929, 0xD95F0E, 0x993404},
                {0xFFFFD4, 0xFEE391, 0xFEC44F, 0xFE9929, 0xD95F0E, 0x993404},
                {0xFFFFD4, 0xFEE391, 0xFEC44F, 0xFE9929, 0xEC7014, 0xCC4C02, 0x8C2D04},
                {0xFFFFE5, 0xFFF7BC, 0xFEE391, 0xFEC44F, 0xFE9929, 0xEC7014, 0xCC4C02, 0x8C2D04},
                {0xFFFFE5, 0xFFF7BC, 0xFEE391, 0xFEC44F, 0xFE9929, 0xEC7014, 0xCC4C02, 0x993404, 0x662506}
        }),
        YlOrRd(3, "Yellow-Orange-Red shades", true, new int[][]{
                {0xFFEDA0},
                {0xFFEDA0, 0xF03B20},
                {0xFFEDA0, 0xFEB24C, 0xF03B20},
                {0xFFFFB2, 0xFECC5C, 0xFD8D3C, 0xE31A1C},
                {0xFFFFB2, 0xFECC5C, 0xFD8D3C, 0xF03B20, 0xBD0026},
                {0xFFFFB2, 0xFED976, 0xFEB24C, 0xFD8D3C, 0xF03B20, 0xBD0026},
                {0xFFFFB2, 0xFED976, 0xFEB24C, 0xFD8D3C, 0xFC4E2A, 0xE31A1C, 0xB10026},
                {0xFFFFCC, 0xFFEDA0, 0xFED976, 0xFEB24C, 0xFD8D3C, 0xFC4E2A, 0xE31A1C, 0xB10026},
                {0xFFFFCC, 0xFFEDA0, 0xFED976, 0xFEB24C, 0xFD8D3C, 0xFC4E2A, 0xE31A1C, 0xBD0026, 0x800026}
        }),
        hsvRdBl(1, "HSV Red-Blue", true, new int[][]{
                {0xFF0000},
                {0xFF0000, 0x0000FF},
                {0xFF0000, 0xFFFFFF, 0x0000FF},
                {0xFF0000, 0xFFAAAA, 0xAAAAFF, 0x0000FF},
                {0xFF0000, 0xFF8080, 0xFFFFFF, 0x8080FF, 0x0000FF},
                {0xFF0000, 0xFF6666, 0xFFCCCC, 0xCCCCFF, 0x6666FF, 0x0000FF},
                {0xFF0000, 0xFF5555, 0xFFAAAA, 0xFFFFFF, 0xAAAAFF, 0x5555FF, 0x0000FF},
                {0xFF0000, 0xFF4949, 0xFF9292, 0xFFDBDB, 0xDBDBFF, 0x9292FF, 0x4949FF, 0x0000FF},
                {0xFF0000, 0xFF4040, 0xFF8080, 0xFFBFBF, 0xFFFFFF, 0xBFBFFF, 0x8080FF, 0x4040FF, 0x0000FF},
                {0xFF0000, 0xFF3939, 0xFF7171, 0xFFAAAA, 0xFFE3E3, 0xE3E3FF, 0xAAAAFF, 0x7171FF, 0x3939FF, 0x0000FF},
                {0xFF0000, 0xFF3333, 0xFF6666, 0xFF9999, 0xFFCCCC, 0xFFFFFF, 0xCCCCFF, 0x9999FF, 0x6666FF, 0x3333FF, 0x0000FF}
        }),
        hsvCyMg(1, "HSV Cy-Mg", true, new int[][]{
                {0x00FFFF},
                {0x00FFFF, 0xFF00FF},
                {0x00FFFF, 0xFFFFFF, 0xFF00FF},
                {0x00FFFF, 0xAAFFFF, 0xFFAAFF, 0xFF00FF},
                {0x00FFFF, 0x80FFFF, 0xFFFFFF, 0xFF80FF, 0xFF00FF},
                {0x00FFFF, 0x66FFFF, 0xCCFFFF, 0xFFCCFF, 0xFF66FF, 0xFF00FF},
                {0x00FFFF, 0x55FFFF, 0xAAFFFF, 0xFFFFFF, 0xFFAAFF, 0xFF55FF, 0xFF00FF},
                {0x00FFFF, 0x49FFFF, 0x92FFFF, 0xDBFFFF, 0xFFDBFF, 0xFF92FF, 0xFF49FF, 0xFF00FF},
                {0x00FFFF, 0x40FFFF, 0x80FFFF, 0xBFFFFF, 0xFFFFFF, 0xFFBFFF, 0xFF80FF, 0xFF40FF, 0xFF00FF},
                {0x00FFFF, 0x39FFFF, 0x71FFFF, 0xAAFFFF, 0xE3FFFF, 0xFFE3FF, 0xFFAAFF, 0xFF71FF, 0xFF39FF, 0xFF00FF},
                {0x00FFFF, 0x33FFFF, 0x66FFFF, 0x99FFFF, 0xCCFFFF, 0xFFFFFF, 0xFFCCFF, 0xFF99FF, 0xFF66FF, 0xFF33FF, 0xFF00FF}
        });

        private final int paletteType;
        private final String paletteDescription;
        private final int[][] hexColors;

        ColorBrewer(int paletteType, String paletteDescription, boolean colorBlindSave, int[][] hexColors) {
            this.paletteType = paletteType;
            this.paletteDescription = paletteDescription;
            this.hexColors = hexColors;
        }

        public String getPaletteDescription() {
            return paletteDescription;
        }

        public int getMaximumColorCount() {
            return hexColors.length;
        }

        public Color[] getColorPalette(int colorCount) {
            if (colorCount < getMaximumColorCount()) {
                return toColor(colorCount);
            } else {
                // if the color count exceeds the number of a
                // available in a palette, interpolate between
                // colors to create an extended color palette
                return interpolatedColors(colorCount);
            }
        }

        public static ColorBrewer[] getDivergingColorPalettes() {
            return getPalettes(1);
        }

        public static ColorBrewer[] getQualitativeColorPalettes() {
            return getPalettes(2);
        }

        public static ColorBrewer[] getSequentialColorPalettes() {
            return getPalettes(3);
        }

        public static ColorBrewer[] getCustomColorPalettes() {
            return getPalettes(4);
        }

        private static ColorBrewer[] getPalettes(int paletteType) {
            List<ColorBrewer> palettes = new ArrayList<ColorBrewer>();

            for (ColorBrewer palette : values()) {
                if (palette.paletteType == paletteType) {
                    palettes.add(palette);
                }
            }

            return palettes.toArray(new ColorBrewer[palettes.size()]);
        }

        private Color[] interpolatedColors(int colorCount) {
            Color[] colors = new Color[colorCount];
            int maxIndex = getMaximumColorCount() - 1;
            float scale = maxIndex / (float) (colorCount - 1);
            //	 log.info("scale: " + scale);

            for (int i = 0; i < colorCount; i++) {
                float value = scale * i;
                int index = (int) Math.floor(value);

                Color c1 = new Color(hexColors[maxIndex][index]);
                float remainder = 0.0f;
                Color c2;
                if (index + 1 < hexColors.length) {
                    c2 = new Color(hexColors[maxIndex][index + 1]);
                    remainder = value - index;
                } else {
                    c2 = new Color(hexColors[maxIndex][index]);
                }
                //		 log.info("value: " + value + " index: " + index + " remainder: " + remainder);
                int red = Math.round((1 - remainder) * c1.getRed() + (remainder) * c2.getRed());
                int green = Math.round((1 - remainder) * c1.getGreen() + (remainder) * c2.getGreen());
                int blue = Math.round((1 - remainder) * c1.getBlue() + (remainder) * c2.getBlue());

                colors[i] = new Color(red, green, blue);
            }
            return colors;
        }

        private Color[] toColor(int numberOfColors) {
            Color[] colors = new Color[numberOfColors];
            for (int i = 0; i < numberOfColors; i++) {
                colors[i] = new Color(hexColors[numberOfColors - 1][i]);
            }
            return colors;
        }
    }
}