package nextgen.swing;

import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.*;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.awt.event.KeyEvent.*;


public class STCanvas extends PCanvas implements PInputEventListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STCanvas.class);

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<String, BaseCanvasNode<?>> nodeMap = new ConcurrentHashMap<>();
	final Map<String, BaseCanvasRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();
	final CanvasZoomHandler canvasZoomHandler = new CanvasZoomHandler();


	public STCanvas() {
		this(UIManager.getColor("Panel.background"), new Dimension(1024, 1024));
	}

	public STCanvas(Color background, Dimension preferredSize) {
		super();


		setBackground(background);
		setPreferredSize(preferredSize);
		nodeLayer = getLayer();
		getCamera().addLayer(0, relationLayer);

		removeInputEventListener(getZoomEventHandler());
		addInputEventListener(canvasZoomHandler);
		addInputEventListener(canvasInputEventsHandler);
	}

	public STCanvas thisCanvas() {
		return this;
	}


	@Override
	public void processEvent(PInputEvent pInputEvent, int i) {
		canvasInputEventsHandler.processEvent(pInputEvent, i);
	}

	public Point getCenterPosition() {
		final java.awt.geom.Point2D center2D = getCamera().getViewBounds().getCenter2D();
		return new Point((int) center2D.getX(), (int) center2D.getY());
	}

	public Point getCurrentMousePosition() {
		final Point mousePosition = getMousePosition();
		if (mousePosition == null) return getCenterPosition();
		final java.awt.geom.Point2D localToView = getCamera().localToView(mousePosition);
		return new Point((int) localToView.getX(), (int) localToView.getY());
	}

	public void centerNode(BaseCanvasNode<?> node) {
		SwingUtilities.invokeLater(() -> getCamera().animateViewToCenterBounds(node.getGlobalFullBounds(), false, 500));
	}

	@SuppressWarnings("unchecked")
	public Stream<BaseCanvasNode<?>> getAllNodes() {
		return nodeLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof BaseCanvasNode);
	}

	public Stream<BaseCanvasNode<?>> getSelectedNodes() {
		return getAllNodes().filter(BaseCanvasNode::isSelected);
	}

	public Stream<BaseCanvasNode<?>> getUnselectedNodes() {
		return getAllNodes().filter(stNode -> !stNode.isSelected());
	}

	@SuppressWarnings("unchecked")
	public <R extends BaseCanvasRelation> Stream<R> getAllRelations() {
		return relationLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof BaseCanvasRelation);
	}

	public <R extends BaseCanvasRelation> Stream<R> getSelectedRelations() {
		return (Stream<R>) getAllRelations().filter(BaseCanvasRelation::isSelected);
	}

	public <N extends BaseCanvasNode<?>> N addNode(N node) {
		return addNode(node.getUuid(), () -> node);
	}

	public <N extends BaseCanvasNode<?>> N addNode(String uuid, java.util.function.Supplier<N> supplier) {
		return addNode(uuid, supplier, true);
	}

	public <N extends BaseCanvasNode<?>> N addNode(String uuid, java.util.function.Supplier<N> supplier, boolean centerNode) {

		final N existing = getNode(uuid);
		if (existing != null) {
			log.debug("N-" + uuid + " exists in canvas");
			existing.refresh();
			existing.select();
			return existing;
		}
		log.debug("N-" + uuid + " added to canvas");

		final N node= supplier.get();
		node.select();
		node.setOffset(getCenterPosition());
		nodeMap.put(node.getUuid(), node);
		nodeLayer.addChild(node);

		//nextgen.st.STAppEvents.postNodeAddedToCanvas(this, node);

		node.addedToCanvas();

		getAllNodes()
				.filter(stNode -> !stNode.getUuid().equals(node.getUuid()))
				.forEach(stNode -> stNode.newNodeAdded(node));

		SwingUtilities.invokeLater(() -> {
			node.refresh();
			if(centerNode) centerNode(node);
		});

		return node;
	}

	public <N extends BaseCanvasNode<?>> N getNode(String uuid) {
		return (N) nodeMap.get(uuid);
	}

	<N extends BaseCanvasNode<?>> N removeNode(String uuid) {
		final BaseCanvasNode remove = nodeMap.remove(uuid);
		final N old = (N) nodeLayer.removeChild(remove);
		log.debug("\tN-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (N) remove;
	}

	public <R extends BaseCanvasRelation> R addRelation(String uuid, java.util.function.Supplier<R> supplier) {

		final R existing = getRelation(uuid);
		if (existing != null) {
			log.debug("R-"+ uuid + " exists in canvas");
			return existing;
		}
		log.debug("R-"+ uuid + " added to canvas");

		final R relation = supplier.get();
		relationMap.put(relation.getUuid(), relation);
		relationLayer.addChild(relation);
		return relation;
	}

	<R extends BaseCanvasRelation> R removeRelation(String uuid) {
		final BaseCanvasRelation remove = relationMap.remove(uuid);
		if (remove == null) return null;

		remove.close();
		final R old = (R) relationLayer.removeChild(remove);
		log.debug("\tR-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (R) remove;
	}

	public <R extends BaseCanvasRelation> R getRelation(String uuid) {
		return (R) relationMap.get(uuid);
	}

	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {


		pop.addSeparator();
		pop.add(new SelectAllNodes(event));
		pop.add(new UnselectAllNodes(event));
		pop.add(new RetainSelectedNodes(event));
		pop.add(new CloseSelectedNodes(event));
		pop.add(new CloseAllAction(event));
		pop.addSeparator();
		pop.add(new LayoutVerticallyAction(event, getCurrentMousePosition(), 20));
	}

	protected void onCanvasLeftClick(PInputEvent event) {
		SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::unselect));
	}

	protected void onCanvasKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case VK_A:
				new SelectAllNodes(event).actionPerformed(null);
				break;

			case VK_ESCAPE:
				new UnselectAllNodes(event).actionPerformed(null);
				break;

			case VK_R:
				new RetainSelectedNodes(event).actionPerformed(null);
				break;

			case VK_C:
				if (event.isControlDown())
					new CloseAllAction(event).actionPerformed(null);
				else
					new CloseSelectedNodes(event).actionPerformed(null);
				break;

			case VK_1:
				new LayoutVerticallyAction(event, getCurrentMousePosition(), 20).actionPerformed(null);
				break;

			case VK_SPACE:
				new PopupAction(event).actionPerformed(null);
				break;
		}
	}

	private final class CanvasInputEventsHandler extends PBasicInputEventHandler {

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
			removeInputEventListener(selectEventHandler);
			if (!this.equals(event.getInputManager().getKeyboardFocus())) event.getInputManager().setKeyboardFocus(this);
			if (event.isRightMouseButton()) {
				SwingUtilities.invokeLater(() -> {
					final JPopupMenu pop = new JPopupMenu();
					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					onCanvasRightClick(pop, event);
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
				});
			} else if (event.isLeftMouseButton()) SwingUtilities.invokeLater(() -> onCanvasLeftClick(event));
		}

		@Override
		public void keyPressed(PInputEvent event) {
			if (event.isControlDown()) {
				removeInputEventListener(selectEventHandler);
				addInputEventListener(selectEventHandler.init(event));
			} else {
				onCanvasKeyPressed(event);
			}
		}

		@Override
		public void keyReleased(PInputEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_CONTROL) removeInputEventListener(selectEventHandler.end());
		}

		@Override
		public void mouseMoved(PInputEvent event) {
			if (!event.isControlDown()) removeInputEventListener(selectEventHandler.end());
			invalidate();
			repaint();
		}
	}  

	private final class SelectEventsHandler extends PBasicInputEventHandler {

		private PPath selectionRectangle;
		private boolean isDragging = true;
		private double startX;
		private double startY;

		PInputEventListener init(PInputEvent event) {
			isDragging = event.isControlDown();
			if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);
			startX = getCamera().localToView(event.getCanvasPosition()).getX();
			startY = getCamera().localToView(event.getCanvasPosition()).getY();
			selectionRectangle = PPath.createRectangle(startX, startY, 1, 1);
			selectionRectangle.setTransparency(.5f);
			nodeLayer.addChild(selectionRectangle);
			return this;
		}

		@Override
		public void mouseMoved(PInputEvent event) {
			if (isDragging) {
				final double eventX = getCamera().localToView(event.getCanvasPosition()).getX();
				final double eventY = getCamera().localToView(event.getCanvasPosition()).getY();
				final boolean left = eventX < startX;
				selectionRectangle.setX(left ? eventX : startX);
				selectionRectangle.setWidth(left ? (startX - eventX) : (eventX - startX));
				final boolean top = eventY < startY;
				selectionRectangle.setY(top ? eventY : startY);
				selectionRectangle.setHeight(top ? (startY - eventY) : (eventY - startY));
				final PBounds fullBounds = selectionRectangle.getFullBounds();
				SwingUtilities.invokeLater(() -> getAllNodes()
					.filter(node -> !node.isSelected())
					.forEach(node -> {
						if (fullBounds.contains(node.getFullBounds())) node.select();
					}));
			}
		}

		public PInputEventListener end() {
			isDragging = false;
			if (selectionRectangle != null) nodeLayer.removeChild(selectionRectangle);
			return this;
		}
	}  

	private static class CanvasZoomHandler extends PBasicInputEventHandler {

		final private static double maxZoomScale = 2.0d;
		final private static double minZomScale = 0.025d;
		private double scaleFactor = 0.05d;

		CanvasZoomHandler() {
			super();
			final PInputEventFilter eventFilter = new PInputEventFilter();
			eventFilter.rejectAllEventTypes();
			eventFilter.setAcceptsMouseWheelRotated(true);
			setEventFilter(eventFilter);
		}

		public void mouseWheelRotated(final PInputEvent event) {
			final PCamera camera = event.getCamera();
			if ((camera.getViewScale() < minZomScale && event.getWheelRotation() < 0) || (camera.getViewScale() > maxZoomScale && event.getWheelRotation() > 0)) return;
			final double scale = 1.0d + event.getWheelRotation() * scaleFactor;
			final java.awt.geom.Point2D viewAboutPoint = event.getPosition();
			camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());
		}
	}  

	abstract class CanvasAction extends AbstractAction {

		final PInputEvent event;

		CanvasAction(String name, PInputEvent event) {
			super(name);
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			actionPerformed(event, e);
		}

		abstract void actionPerformed(PInputEvent event, ActionEvent e);
	}

	protected class BaseCanvasNode<T> extends PNode {

		protected PText child;
		protected final Set<String> outgoing = new LinkedHashSet<>();
		protected final Set<String> incoming = new LinkedHashSet<>();

		private PPath rectangle;

		public BaseCanvasNode(T model, String uuid, String label) {
			this.addAttribute("_defaultColor", UIManager.getColor("TextField.foreground"));
			this.addAttribute("_selectedColor", Color.decode("#2b8cbe"));
			this.addAttribute("_highlightedColor", Color.decode("#e66101"));
			this.addAttribute("_rectangleColor", new Color(253, 141, 60, 50));
			this.addAttribute("_model", model);
			this.addAttribute("_uuid", uuid);
			this.addAttribute("_text", label);
			this.child = new PText(getText() == null ? getUuid() : getText());
			this.addChild(this.child);

			final NodeInputEventHandler nodeInputEventHandler = new NodeInputEventHandler();
			nodeInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);
			addInputEventListener(nodeInputEventHandler);
			addInputEventListener(canvasZoomHandler);

			//org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		protected BaseCanvasNode<T> thisNode() {
			return this;
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getAttribute("_model");
		}

		public void addedToCanvas() {

		}

		public void newNodeAdded(BaseCanvasNode<?> node) {

		}

		@Override
		public double getHeight() {
			return child.getHeight();
		}

		@Override
		public double getWidth() {
			return child.getWidth();
		}

		@Override
		public String toString() {
			return getUuid() + " " + getText();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			BaseCanvasNode<?> other = (BaseCanvasNode<?>) o;

			return getUuid().equals(other.getUuid());
		}

		@Override
		public int hashCode() {
			return getUuid().hashCode();
		}

		public String getUuid() {
			return (String) getAttribute("_uuid");
		}

		public String getText() {
			return (String) getAttribute("_text");
		}

		public void setText(String text) {
			addAttribute("_text", text == null || text.trim().length() == 0 ? getUuid().toString() : text);
			child.setText(getText());
			refresh();
		}

		public void refresh() {
			SwingUtilities.invokeLater(() -> {
				setPaintInvalid(true);
				repaint();
			});
		}

		public void addOutgoingRelation(String relation) {
			this.outgoing.add(relation);
		}

		public void addIncomingRelation(String relation) {
			this.incoming.add(relation);
		}

		public java.util.stream.Stream<String> outgoing() {
			return this.outgoing.stream();
		}

		public java.util.stream.Stream<String> incoming() {
			return this.incoming.stream();
		}

		public void unselect() {
			addAttribute("_selected", Boolean.FALSE);
			SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute("_defaultColor")));
		}

		public void select() {
			addAttribute("_selected", Boolean.TRUE);
			SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute("_selectedColor")));
		}

		public boolean isSelected() {
			return getBooleanAttribute("_selected", false);
		}

		public void unhighlight() {
			addAttribute("_highlight", Boolean.FALSE);
			SwingUtilities.invokeLater(() -> {
				child.setTextPaint(isSelected() ? (Color) getAttribute("_selectedColor") : (Color) getAttribute("_defaultColor"));
				if (rectangle != null) BaseCanvasNode.this.removeChild(rectangle);	
			});
		}

		public void highlight() {
			addAttribute("_highlight", Boolean.TRUE);
			SwingUtilities.invokeLater(() -> {
				final PBounds fullBounds = child.getFullBoundsReference();
				rectangle = PPath.createRectangle(fullBounds.getX(), fullBounds.getY(), fullBounds.getWidth(), fullBounds.getHeight());
				rectangle.setPaint((Color) getAttribute("_rectangleColor"));
				rectangle.setStroke(new BasicStroke());
				BaseCanvasNode.this.addChild(rectangle);

				child.setTextPaint((Color) getAttribute("_highlightedColor"));
			});
		}

		public void close() {
			SwingUtilities.invokeLater(() -> {
				for (String uuid : incoming) removeRelation(uuid);
				for (String uuid : outgoing) removeRelation(uuid);
				org.greenrobot.eventbus.EventBus.getDefault().unregister(BaseCanvasNode.this);
				removeNode(getUuid());			
			});
		}

		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_1:
					new LayoutTreeAction(BaseCanvasNode.this, event).actionPerformed(null);
					break;

				case VK_2:
					new LayoutCircleAction(BaseCanvasNode.this, event).actionPerformed(null);
					break;

				case VK_C:
					new CloseNode(event).actionPerformed(null);
					break;

				case VK_R:
					new RetainNode(event).actionPerformed(null);
					break;

				case VK_F:
					new PopupAction(event).actionPerformed(null);
					break;

				case VK_B:
					new DebugAction(event).actionPerformed(null);
					break;

			}
		}

		protected void onNodeLeftClick(PInputEvent event) {
			if (isSelected()) unselect();
			else select();
		}

		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {

			pop.add(new LayoutTreeAction(BaseCanvasNode.this, event));
			pop.add(new LayoutCircleAction(BaseCanvasNode.this, event));
			pop.add(new RetainNode(event));
			pop.add(new CloseNode(event));
			pop.add(new DebugAction(event));

		}

		private final class NodeInputEventHandler extends PDragSequenceEventHandler {

			@Override
			final protected void startDrag(PInputEvent event) {
				super.startDrag(event);
			}

			@Override
			final protected void drag(PInputEvent event) {
				super.drag(event);
				translate(event.getDelta().width, event.getDelta().height);
			}

			@Override
			final protected void endDrag(PInputEvent event) {
				super.endDrag(event);
			}

			@Override
			final protected boolean shouldStartDragInteraction(PInputEvent event) {
				return super.shouldStartDragInteraction(event);
			}

			@Override
			public void mouseEntered(PInputEvent event) {
				if (!event.isControlDown()) 
					event.getInputManager().setKeyboardFocus(this);
				highlight();
			}

			@Override
			public void mouseExited(PInputEvent event) {
				unhighlight();
				if (!event.isControlDown()) 
					event.getInputManager().setKeyboardFocus(thisCanvas());
			}

			@Override
			public void mouseClicked(PInputEvent event) {
				if (event.isRightMouseButton()) {
					final JPopupMenu pop = new JPopupMenu();
					thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					onNodeRightClick(event, pop);
					thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
				} else if (event.isLeftMouseButton()) {
					SwingUtilities.invokeLater(() -> onNodeLeftClick(event));
				}
			}

			@Override
			public void keyPressed(PInputEvent event) {
				onNodeKeyPressed(event);
			}
		}  	

		abstract class NodeAction extends AbstractAction {

			final PInputEvent event;

			NodeAction(String name, PInputEvent event) {
				super(name);
				this.event = event;
			}

			protected void setName(String name) {
				putValue(Action.NAME, name);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformed(event, e);
			}

			abstract void actionPerformed(PInputEvent event, ActionEvent e);

		}

		protected final class LayoutTreeAction extends NodeAction {

			private final Map<String, BaseCanvasNode<?>> parentsMap = new LinkedHashMap<>();
			private final Map<String, java.util.List<BaseCanvasNode<?>>> childrensMap = new LinkedHashMap<>();
			private final org.abego.treelayout.util.DefaultConfiguration<BaseCanvasNode<?>> configuration;

			protected LayoutTreeAction(BaseCanvasNode<?> root, PInputEvent event) {
				this(root, event, org.abego.treelayout.Configuration.Location.Left, org.abego.treelayout.Configuration.AlignmentInLevel.TowardsRoot);
			}

			protected LayoutTreeAction(BaseCanvasNode<?> root, PInputEvent event, org.abego.treelayout.Configuration.Location location, org.abego.treelayout.Configuration.AlignmentInLevel alignmentInLevel) {
				super("Layout Tree", event);
				this.configuration = new org.abego.treelayout.util.DefaultConfiguration<>(100, 15, location, alignmentInLevel);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {

				new Thread(() -> {

					findChildren(BaseCanvasNode.this);

					final org.abego.treelayout.TreeForTreeLayout<BaseCanvasNode<?>> tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<BaseCanvasNode<?>>(BaseCanvasNode.this) {
						@Override
						public BaseCanvasNode<?> getParent(BaseCanvasNode<?> node) {
							return parentsMap.get(node.getUuid());
						}

						@Override
						public java.util.List<BaseCanvasNode<?>> getChildrenList(BaseCanvasNode<?> node) {
							if (node == null) return Collections.emptyList();
							return childrensMap.get(node.getUuid());
						}
					};

					final org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>> nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>>() {
						@Override
						public double getWidth(BaseCanvasNode<?> node) {
							return node.getFullBounds().getWidth();
						}

						@Override
						public double getHeight(BaseCanvasNode<?> node) {
							return node.getFullBounds().getHeight();
						}
					};

					final org.abego.treelayout.TreeLayout<BaseCanvasNode<?>> layout = new org.abego.treelayout.TreeLayout<>(tree, nodeExtendProvider, configuration);

					// apply coordinate transforms in relation to root-node
					final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(BaseCanvasNode.this);
					final double deltaX = getFullBounds().getX() - rootBounds.getX();
					final double deltaY = getFullBounds().getY() - rootBounds.getY();

					SwingUtilities.invokeLater(() -> {
						for (Map.Entry<BaseCanvasNode<?>, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds().entrySet()) {
							if (nodeBound.getKey().equals(BaseCanvasNode.this)) continue;	// root-node is transformation-root
							nodeBound.getKey().setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);
						}
					});

				}).start();
			}

			private void findChildren(BaseCanvasNode<?> node) {

				if (childrensMap.containsKey(node.getUuid())) return;

				childrensMap.put(node.getUuid(), new ArrayList<>());

				node.outgoing()
						.filter(thisCanvas().relationMap::containsKey)
						.map(uuid -> thisCanvas().relationMap.get(uuid).getDst())
						.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))
						.forEach(abstractNode -> {
								childrensMap.get(node.getUuid()).add(abstractNode);
								parentsMap.put(abstractNode.getUuid(), node);
						});

				childrensMap.get(node.getUuid()).forEach(this::findChildren);
			}
		}

		protected final class LayoutCircleAction extends NodeAction {

			private final Map<String, BaseCanvasNode<?>> parentsMap = new LinkedHashMap<>();
			private final Map<String, java.util.List<BaseCanvasNode<?>>> childrensMap = new LinkedHashMap<>();

			protected LayoutCircleAction(BaseCanvasNode<?> root, PInputEvent event) {
				super("Layout Circle", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {

				new Thread(() -> {

					findChildren(BaseCanvasNode.this);

					final org.abego.treelayout.TreeForTreeLayout<BaseCanvasNode<?>> tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<BaseCanvasNode<?>>(BaseCanvasNode.this) {
						@Override
						public BaseCanvasNode<?> getParent(BaseCanvasNode<?> node) {
							return parentsMap.get(node.getUuid());
						}

						@Override
						public java.util.List<BaseCanvasNode<?>> getChildrenList(BaseCanvasNode<?> node) {
							if (node == null) return Collections.emptyList();
							return childrensMap.get(node.getUuid());
						}
					};

					final org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>> nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<BaseCanvasNode<?>>() {
						@Override
						public double getWidth(BaseCanvasNode<?> node) {
							return node.getFullBounds().getWidth();
						}

						@Override
						public double getHeight(BaseCanvasNode<?> node) {
							return node.getFullBounds().getHeight();
						}
					};

					final CircleLayout<BaseCanvasNode<?>> layout = new CircleLayout<>(tree, nodeExtendProvider);

					// apply coordinate transforms in relation to root-node
					final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(BaseCanvasNode.this);
					final double deltaX = getFullBounds().getX() - rootBounds.getX();
					final double deltaY = getFullBounds().getY() - rootBounds.getY();

					SwingUtilities.invokeLater(() -> {
						for (Map.Entry<BaseCanvasNode<?>, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds()
																																		.entrySet()) {
							if (nodeBound.getKey().equals(BaseCanvasNode.this)) continue;	// root-node is transformation-root
							nodeBound.getKey()
										.setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);
						}
					});

				}).start();
			}

			private void findChildren(BaseCanvasNode<?> node) {

				if (childrensMap.containsKey(node.getUuid())) return;

				childrensMap.put(node.getUuid(), new ArrayList<>());

				node.outgoing()
					.filter(thisCanvas().relationMap::containsKey)
					.map(uuid -> thisCanvas().relationMap.get(uuid).getDst())
					.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))
					.forEach(abstractNode -> {
						childrensMap.get(node.getUuid()).add(abstractNode);
						parentsMap.put(abstractNode.getUuid(), node);
					});

				childrensMap.get(node.getUuid()).forEach(this::findChildren);
			}

			private class CircleLayout<T> {

			   private final Map<T, java.awt.geom.Rectangle2D.Double> nodeBounds = new LinkedHashMap<>();

			   public CircleLayout(org.abego.treelayout.TreeForTreeLayout<T> tree, org.abego.treelayout.NodeExtentProvider<T> nodeExtendProvider) {

			      final int centerX = 0;
			      final int centerY = 0;
			      final int radiusPerLevel = 1200;

			      final T root = tree.getRoot();
			      nodeBounds.put(root, new Rectangle2D.Double(centerX, centerY, nodeExtendProvider.getWidth(root), nodeExtendProvider.getHeight(root)));

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

			         nodeBounds.put(child, new Rectangle2D.Double(x, y, nodeExtendProvider.getWidth(child), nodeExtendProvider
			               .getHeight(child)));

			         layout(child, centerX, centerY, radius + (radius / level), currentArc, childRadians, level + 1, tree, nodeExtendProvider);

			         currentArc += childRadians;
			      }
			   }

			   private List<T> children(T node, org.abego.treelayout.TreeForTreeLayout<T> tree) {
			      return StreamSupport
			            .stream(tree.getChildren(node).spliterator(), false)
			            .collect(Collectors.toList());
			   }

			   public Map<T, java.awt.geom.Rectangle2D.Double> getNodeBounds() {
			      return nodeBounds;
			   }
			}
		}

		private final class RetainNode extends NodeAction {

			RetainNode(PInputEvent event) {
				super("Retain", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(() -> {
					thisCanvas().getAllRelations().forEach(relation -> thisCanvas().removeRelation(relation.getUuid()));
					thisCanvas().relationLayer.removeAllChildren();
					thisCanvas().getAllNodes().filter(canvasNode -> !canvasNode.getUuid().equals(getUuid())).forEach(BaseCanvasNode::close);
				});
			}
		}

		private final class CloseNode extends NodeAction {

			CloseNode(PInputEvent event) {
				super("Close", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(() -> thisNode().close());
			}
		}

		private final class PopupAction extends NodeAction {

			PopupAction(PInputEvent event) {
				super("Popup", event);
			}

			@Override
			void actionPerformed( PInputEvent event, ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(() -> {
					final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
					setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
					onNodeRightClick(event, pop);
					setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
					pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
				});
			}
		}

		private final class DebugAction extends NodeAction {

			DebugAction(PInputEvent event) {
				super("Debug", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(() -> {
					final PBounds fullBounds = getFullBoundsReference();
					log.info(getUuid() + " : " + getText());
					log.info(fullBounds.getX() + "," + fullBounds.getY() + ", [" + fullBounds.getWidth() + "," + fullBounds.getHeight() + "]");
					outgoing().forEach(uuid -> log.info(" -> " + uuid));
					incoming().forEach(uuid -> log.info(" <- " + uuid));
				});
			}
		}
	}  

	protected class BaseCanvasRelation extends PPath.Double implements Comparator<BaseCanvasRelation> {

		final protected PText child;
		private final PNodeChangeListener nodeChangeListener = new PNodeChangeListener();

		public BaseCanvasRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid, String type) {
			this.addAttribute("_defaultColor", Color.decode("#bababa"));
			this.addAttribute("_selectedColor", Color.decode("#b2182b"));
			this.addAttribute("_highlightedColor", Color.decode("#f4a582"));
			this.addAttribute("_uuid", uuid);
			this.addAttribute("_type", type);
			this.addAttribute("_src", src);
			this.addAttribute("_dst", dst);

			src.addOutgoingRelation(getUuid());
			dst.addIncomingRelation(getUuid());

			this.child = new PText(type);

			setPaint((Color) getAttribute("_defaultColor"));
			child.setTextPaint((Color) getAttribute("_defaultColor"));

			final RelationInputEventHandler relationInputEventHandler = new RelationInputEventHandler();
			relationInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);
			addInputEventListener(relationInputEventHandler);
			addInputEventListener(canvasZoomHandler);

			src.addPropertyChangeListener(nodeChangeListener);
			dst.addPropertyChangeListener(nodeChangeListener);
			addChild(this.child);

			SwingUtilities.invokeLater(() -> updatePath((getSrc()), getDst()));
		}

		@Override
		public String toString() {
			return getUuid() + " " + getSrc() + " -> " + getType() + " -> " + getDst();
		}

		public void close() {
			SwingUtilities.invokeLater(() -> {
				log.info("R-" + getUuid() + " closed");
				getSrc().outgoing.remove(getUuid());
				getDst().incoming.remove(getUuid());
				getSrc().removePropertyChangeListener(nodeChangeListener);
				getDst().removePropertyChangeListener(nodeChangeListener);
			});
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			BaseCanvasRelation other = (BaseCanvasRelation) o;

			return getUuid().equals(other.getUuid());
		}

		@Override
		public int hashCode() {
			return getUuid().hashCode();
		}

		public String getUuid() {
			return (String) getAttribute("_uuid");
		}

		public String getType() {
			return (String) getAttribute("_type");
		}

		public void unselect() {
			addAttribute("_selected", Boolean.FALSE);
			SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute("_defaultColor")));
		}

		public void select() {
			addAttribute("_selected", Boolean.TRUE);
			SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute("_selectedColor")));
		}

		public boolean isSelected() {
			return getBooleanAttribute("_selected", false);
		}

		protected void unhighlight() {
			addAttribute("_highlight", Boolean.FALSE);
			SwingUtilities.invokeLater(() -> updatePath(isSelected() ? (Color) getAttribute("_selectedColor") : (Color) getAttribute("_defaultColor")));
		}

		protected void highlight() {
			addAttribute("_highlight", Boolean.TRUE);
			SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute("_highlightedColor")));
		}

		protected BaseCanvasNode<?> getSrc() {
			return (BaseCanvasNode<?>) getAttribute("_src");
		}

		protected BaseCanvasNode<?> getDst() {
			return (BaseCanvasNode<?>) getAttribute("_dst");
		}

		public Long getOrder() {
			return (Long) getAttribute("_order");
		}

		private void updatePath(Color color) {
			child.setTextPaint(color);
			setPaint(color);
			setStrokePaint(color);
			setPaintInvalid(true);
			validateFullPaint();
		}

		private void updatePath(BaseCanvasNode<?> source, BaseCanvasNode<?> target) {
			//log.info(getUuid() + " updatePath");
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
					if (!horizontalOverlap) {
						drawStraightPath(startRightCenter, endRightCenter);
					} else {
						drawStraightPath(startCenterBottom, endCenterTop);
					}
				} else {
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
					if (!horizontalOverlap) {
						drawStraightPath(startLeftCenter, endLeftCenter);
					} else {
						drawStraightPath(startCenterBottom, endCenterTop);
					}
				} else {
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
			setStrokePaint(child.getTextPaint());
			moveTo(start.getX(), start.getY());
			lineTo(end.getX(), end.getY());
			child.setOffset(getBounds().getCenter2D());
			final int ARR_SIZE = 4;
			final double dx = end.getX() - start.getX();
			final double dy = end.getY() - start.getY();
			final double angle = Math.atan2(dy, dx);
			final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
			final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());
			at.concatenate(AffineTransform.getRotateInstance(angle));
			append(new Polygon(new int[]{len,
						len - ARR_SIZE,
						len - ARR_SIZE,
						len}, new int[]{0,
						-ARR_SIZE,
						ARR_SIZE,
						0}, 4).getPathIterator(at), false);
			setPaintInvalid(true);
			validateFullPaint();
		}

		@Override
		public int compare(BaseCanvasRelation o1, BaseCanvasRelation o2) {
			return o1.getOrder().compareTo(o2.getOrder());
		}

		private final class PNodeChangeListener implements PropertyChangeListener {

			private final java.util.UUID uuid = java.util.UUID.randomUUID();

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				PNodeChangeListener that = (PNodeChangeListener) o;
				return uuid.equals(that.uuid);
			}

			@Override
			public int hashCode() {
				return java.util.Objects.hash(uuid);
			}

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
					case PNode.PROPERTY_FULL_BOUNDS:
						break;
					case PNode.PROPERTY_TRANSFORM:
						SwingUtilities.invokeLater(() -> updatePath((getSrc()), getDst()));
						break;
					case PNode.PROPERTY_PARENT:
						break;
				}
			}
		}  

		private final class RelationInputEventHandler extends PBasicInputEventHandler {

			@Override
			public void mouseEntered(PInputEvent event) {
				event.getInputManager().setKeyboardFocus(this);
				highlight();
			}

			@Override
			public void mouseExited(PInputEvent event) {
				unhighlight();
				event.getInputManager().setKeyboardFocus(thisCanvas());
			}

			@Override
			public void mouseClicked(PInputEvent event) {
				if (event.isRightMouseButton()) {
					final JPopupMenu pop = new JPopupMenu();
					thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					onRelationRightClick(event, pop);
					thisCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
				} else if (event.isLeftMouseButton()) {
					SwingUtilities.invokeLater(() -> onRelationLeftClick(event));
				}
			}

			@Override
			public void keyPressed(PInputEvent event) {
				onRelationKeyPressed(event);
			}
		}  

		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {
		}

		protected void onRelationLeftClick(PInputEvent event) {
			if (isSelected()) unselect();
			else select();
		}

		protected void onRelationKeyPressed(PInputEvent event) {
		}

		abstract class RelationAction extends AbstractAction {

			final PInputEvent event;

			RelationAction(String name, PInputEvent event) {
				super(name);
				this.event = event;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformed(event, e);
			}

			abstract void actionPerformed(PInputEvent event, ActionEvent e);
		}
	}  

	final class PopupAction extends CanvasAction {

		PopupAction(PInputEvent event) {
			super("Popup", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> { 
				final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
				onCanvasRightClick(pop, event);
				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
				pop.show(thisCanvas(), (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
			});
		}
	}

	final class SelectAllNodes extends CanvasAction {

		SelectAllNodes(PInputEvent event) {
			super("Select all nodes", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> getAllNodes().forEach(BaseCanvasNode::select));
		}
	}

	final class RetainSelectedNodes extends CanvasAction {

		RetainSelectedNodes(PInputEvent event) {
			super("Retain selected nodes", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> getUnselectedNodes().forEach(BaseCanvasNode::close));
		}
	}

	final class UnselectAllNodes extends CanvasAction {

		UnselectAllNodes(PInputEvent event) {
			super("Unselect all nodes", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::unselect));
		}
	}

	final class CloseSelectedNodes extends CanvasAction {

		CloseSelectedNodes(PInputEvent event) {
			super("Close selected nodes", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(BaseCanvasNode::close));
		}
	}

	final class CloseAllAction extends CanvasAction {

		CloseAllAction(PInputEvent event) {
			super("Close all", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			getAllRelations().forEach(relation -> removeRelation(relation.getUuid()));
			getAllNodes().forEach(node -> removeNode(node.getUuid()));
			relationLayer.removeAllChildren();
			SwingUtilities.invokeLater(() -> {
				invalidate();
				repaint();
			});
		}
	}

	final class LayoutVerticallyAction extends CanvasAction {

		private java.awt.Point position;
		private int heightPadding;

		LayoutVerticallyAction(PInputEvent event, java.awt.Point position,int heightPadding) {
			super("Layout selected nodes vertically", event);
			this.position = position;
			this.heightPadding = heightPadding;
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(new Consumer<BaseCanvasNode>() {

				double x = position.getX();
				double y = position.getY();
				double height = -1d;

				@Override
				public void accept(BaseCanvasNode abstractNode) {
					if (height == -1) {
						abstractNode.setOffset(x, y);
						height = abstractNode.getHeight();
					} else {
						y += height + heightPadding;
						abstractNode.setOffset(x, y);
						height = abstractNode.getHeight();
					}
				}
			}));
		}
	}

	final class STProjectNode extends BaseCanvasNode<nextgen.model.STProject> {


		public STProjectNode(nextgen.model.STProject model) {
			super(model, model.getUuid(), model.getName());
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addSTProjectNode(nextgen.model.STProject model) {
		addNode(model.getUuid(), newSTProjectNode(model));
	}

	public java.util.function.Supplier<STProjectNode> newSTProjectNode(nextgen.model.STProject model) {
		return () -> new STProjectNode(model);
	}

	public Stream<STProjectNode> getAllSTProjectNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof STProjectNode)
					.map(baseCanvasNode -> (STProjectNode) baseCanvasNode);
	}

	public void forEachSTProjectNode(java.util.function.Consumer<STProjectNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof STProjectNode)
				.map(baseCanvasNode -> (STProjectNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<STProjectNode> isInstanceOfSTProjectNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof STProjectNode) ? (STProjectNode) canvasNode : null);
	}

}