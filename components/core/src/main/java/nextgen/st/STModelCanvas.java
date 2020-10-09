package nextgen.st;

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

import nextgen.utils.SwingUtil;

public class STModelCanvas extends PCanvas implements PInputEventListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelCanvas.class);

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<String, BaseCanvasNode<?>> nodeMap = new ConcurrentHashMap<>();
	final Map<String, BaseCanvasRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();
	final CanvasZoomHandler canvasZoomHandler = new CanvasZoomHandler();


	public STModelCanvas() {
		this(UIManager.getColor("Panel.background"), new Dimension(1024, 1024));
	}

	public STModelCanvas(Color background, Dimension preferredSize) {
		super();


		setBackground(background);
		setPreferredSize(preferredSize);
		nodeLayer = getLayer();
		getCamera().addLayer(0, relationLayer);

		removeInputEventListener(getZoomEventHandler());
		addInputEventListener(canvasZoomHandler);
		addInputEventListener(canvasInputEventsHandler);
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
		javax.swing.SwingUtilities.invokeLater(() -> new LoadLastLayoutAction(null).actionPerformed(null));
	}

	public STModelCanvas thisCanvas() {
		return this;
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTModel(nextgen.st.STAppEvents.NewSTModel event) {
		addSTModelNode(event.sTModel, appModel().findSTTemplateByUuid(event.sTModel.getStTemplate()));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenSTModel(nextgen.st.STAppEvents.OpenSTModel event) {
		addSTModelNode(event.sTModel, appModel().findSTTemplateByUuid(event.sTModel.getStTemplate()));
		appModel().getWorkspace().showCanvas();
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


		pop.add(new Debug(event));
		pop.add(new SaveLastLayoutAction(event));
		pop.add(new LoadLastLayoutAction(event));
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

	final class Debug extends CanvasAction {

		Debug(PInputEvent event) {
			super("Debug", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			appModel().doLaterInTransaction(transaction -> {
				System.out.println("Node layer");
				nodeLayer.getAllNodes().stream().forEach(o -> System.out.println(o));

				System.out.println("Relation layer");
				relationLayer.getAllNodes().forEach(o -> System.out.println(o));

				System.out.println("All nodes");
				getAllNodes().forEach(baseCanvasNode -> System.out.println(baseCanvasNode));

				System.out.println("All relations");
				getAllRelations().forEach(baseCanvasRelation -> System.out.println(baseCanvasRelation));

				int nodeLayerSize = nodeLayer.getAllNodes().size();
				int relationLayerSize = relationLayer.getAllNodes().size();
				long allNodesSize = getAllNodes().count();
				long allRelationsSize = getAllRelations().count();

				System.out.println("nodeLayerSize " + nodeLayerSize);
				System.out.println("relationLayerSize " + relationLayerSize);
				System.out.println("allNodesSize " + allNodesSize);
				System.out.println("allRelationsSize " + allRelationsSize);

			});
		}
	}

	final class AddSequentialFlow extends CanvasAction {

		AddSequentialFlow(PInputEvent event) {
			super("Add Sequential Flow", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
		}
	}

	final class AddWork extends CanvasAction {

		AddWork(PInputEvent event) {
			super("Add Work", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
		}
	}

	final class SaveLastLayoutAction extends CanvasAction {

		SaveLastLayoutAction(PInputEvent event) {
			super("Save last layout", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			appModel().doLaterInTransaction(tx -> {
					final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(appModel().db.getDatabaseService());
					final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findOrCreateLayoutByName("last");

					last.getNodes().forEach(layoutNode -> {
						layoutNode.getNode().getRelationships().forEach(org.neo4j.graphdb.Relationship::delete);
						layoutNode.getNode().delete();
					});

					getAllNodes().forEach(stNode -> {
						final nextgen.st.canvas.layout.LayoutNode layoutNode = layoutNeoFactory.newLayoutNode();
						layoutNode.setX(stNode.getOffset().getX());
						layoutNode.setY(stNode.getOffset().getY());
						if (stNode instanceof STModelNode) {
							final org.neo4j.graphdb.Node node = ((STModelNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof STValueNode) {
							final org.neo4j.graphdb.Node node = ((STValueNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof STFileNode) {
							final org.neo4j.graphdb.Node node = ((STFileNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} 
						last.addNodes(layoutNode);
					});
				});
		}
	}

	final class LoadLastLayoutAction extends CanvasAction {

		LoadLastLayoutAction(PInputEvent event) {
			super("Load last layout", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			appModel().doLaterInTransaction(tx -> {

				final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(appModel().db.getDatabaseService());
				final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findLayoutByName("last");
				if (last == null) return;

				final java.util.concurrent.atomic.AtomicReference<BaseCanvasNode<?>> centerNodeRef = new java.util.concurrent.atomic.AtomicReference<>();
				last.getNodesSorted().forEach(layoutNode -> {
					final org.neo4j.graphdb.Node node = layoutNode.getNode();
					node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("ref")).forEach(relationship -> {
							final org.neo4j.graphdb.Node stNode = relationship.getOtherNode(node);
							if (nextgen.st.model.STModelNeoFactory.isSTModel(stNode)) {
								final nextgen.st.model.STModel stModel = appModel().newSTModel(stNode);
								addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));
								getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stModel.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isSTValue(stNode)) {
								final nextgen.st.model.STValue stValue = appModel().newSTValue(stNode);
								addNode(stValue.getUuid(), () -> new STValueNode(stValue));
								getNode(stValue.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stValue.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isSTFile(stNode)) {
								final nextgen.st.model.STFile stFile = appModel().newSTFile(stNode);
								stFile.getIncomingFilesSTModel().findFirst().ifPresent(stModel -> {
									addNode(stFile.getUuid(), () -> new STFileNode(stFile, stModel));
									getNode(stFile.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
									if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stFile.getUuid()));
								});
							} 
					});
				});

				if (centerNodeRef.get() != null) centerNode(centerNodeRef.get());
			});
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

	final class SequentialFlowNode extends BaseCanvasNode<nextgen.workflow.SequentialFlow> {


		public SequentialFlowNode(nextgen.workflow.SequentialFlow model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addSequentialFlowNode(nextgen.workflow.SequentialFlow model, String uuid, String label) {
		addNode(uuid, newSequentialFlowNode(model, uuid, label));
	}

	public java.util.function.Supplier<SequentialFlowNode> newSequentialFlowNode(nextgen.workflow.SequentialFlow model, String uuid, String label) {
		return () -> new SequentialFlowNode(model, uuid, label);
	}

	public Stream<SequentialFlowNode> getAllSequentialFlowNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof SequentialFlowNode)
					.map(baseCanvasNode -> (SequentialFlowNode) baseCanvasNode);
	}

	public void forEachSequentialFlowNode(java.util.function.Consumer<SequentialFlowNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof SequentialFlowNode)
				.map(baseCanvasNode -> (SequentialFlowNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<SequentialFlowNode> isInstanceOfSequentialFlowNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof SequentialFlowNode) ? (SequentialFlowNode) canvasNode : null);
	}

	final class WorkNode extends BaseCanvasNode<nextgen.workflow.Work> {


		public WorkNode(nextgen.workflow.Work model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}

		final class RunWork extends NodeAction {


			RunWork(PInputEvent event) {
				super("Run", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
			}
		}

	}

	private void addWorkNode(nextgen.workflow.Work model, String uuid, String label) {
		addNode(uuid, newWorkNode(model, uuid, label));
	}

	public java.util.function.Supplier<WorkNode> newWorkNode(nextgen.workflow.Work model, String uuid, String label) {
		return () -> new WorkNode(model, uuid, label);
	}

	public Stream<WorkNode> getAllWorkNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof WorkNode)
					.map(baseCanvasNode -> (WorkNode) baseCanvasNode);
	}

	public void forEachWorkNode(java.util.function.Consumer<WorkNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof WorkNode)
				.map(baseCanvasNode -> (WorkNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<WorkNode> isInstanceOfWorkNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof WorkNode) ? (WorkNode) canvasNode : null);
	}

	final class SequentialFlow extends BaseCanvasNode<nextgen.workflow.SequentialFlow> {


		public SequentialFlow(nextgen.workflow.SequentialFlow model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addSequentialFlow(nextgen.workflow.SequentialFlow model, String uuid, String label) {
		addNode(uuid, newSequentialFlow(model, uuid, label));
	}

	public java.util.function.Supplier<SequentialFlow> newSequentialFlow(nextgen.workflow.SequentialFlow model, String uuid, String label) {
		return () -> new SequentialFlow(model, uuid, label);
	}

	public Stream<SequentialFlow> getAllSequentialFlow() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof SequentialFlow)
					.map(baseCanvasNode -> (SequentialFlow) baseCanvasNode);
	}

	public void forEachSequentialFlow(java.util.function.Consumer<SequentialFlow> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof SequentialFlow)
				.map(baseCanvasNode -> (SequentialFlow) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<SequentialFlow> isInstanceOfSequentialFlow(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof SequentialFlow) ? (SequentialFlow) canvasNode : null);
	}

	final class ParallelFlowNode extends BaseCanvasNode<nextgen.workflow.ParallelFlow> {


		public ParallelFlowNode(nextgen.workflow.ParallelFlow model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addParallelFlowNode(nextgen.workflow.ParallelFlow model, String uuid, String label) {
		addNode(uuid, newParallelFlowNode(model, uuid, label));
	}

	public java.util.function.Supplier<ParallelFlowNode> newParallelFlowNode(nextgen.workflow.ParallelFlow model, String uuid, String label) {
		return () -> new ParallelFlowNode(model, uuid, label);
	}

	public Stream<ParallelFlowNode> getAllParallelFlowNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof ParallelFlowNode)
					.map(baseCanvasNode -> (ParallelFlowNode) baseCanvasNode);
	}

	public void forEachParallelFlowNode(java.util.function.Consumer<ParallelFlowNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof ParallelFlowNode)
				.map(baseCanvasNode -> (ParallelFlowNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<ParallelFlowNode> isInstanceOfParallelFlowNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof ParallelFlowNode) ? (ParallelFlowNode) canvasNode : null);
	}

	final class ConditionalFlowNode extends BaseCanvasNode<nextgen.workflow.ConditionalFlow> {


		public ConditionalFlowNode(nextgen.workflow.ConditionalFlow model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addConditionalFlowNode(nextgen.workflow.ConditionalFlow model, String uuid, String label) {
		addNode(uuid, newConditionalFlowNode(model, uuid, label));
	}

	public java.util.function.Supplier<ConditionalFlowNode> newConditionalFlowNode(nextgen.workflow.ConditionalFlow model, String uuid, String label) {
		return () -> new ConditionalFlowNode(model, uuid, label);
	}

	public Stream<ConditionalFlowNode> getAllConditionalFlowNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof ConditionalFlowNode)
					.map(baseCanvasNode -> (ConditionalFlowNode) baseCanvasNode);
	}

	public void forEachConditionalFlowNode(java.util.function.Consumer<ConditionalFlowNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof ConditionalFlowNode)
				.map(baseCanvasNode -> (ConditionalFlowNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<ConditionalFlowNode> isInstanceOfConditionalFlowNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof ConditionalFlowNode) ? (ConditionalFlowNode) canvasNode : null);
	}

	final class RepeatFlowNode extends BaseCanvasNode<nextgen.workflow.RepeatFlow> {


		public RepeatFlowNode(nextgen.workflow.RepeatFlow model, String uuid, String label) {
			super(model, uuid, label);
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addRepeatFlowNode(nextgen.workflow.RepeatFlow model, String uuid, String label) {
		addNode(uuid, newRepeatFlowNode(model, uuid, label));
	}

	public java.util.function.Supplier<RepeatFlowNode> newRepeatFlowNode(nextgen.workflow.RepeatFlow model, String uuid, String label) {
		return () -> new RepeatFlowNode(model, uuid, label);
	}

	public Stream<RepeatFlowNode> getAllRepeatFlowNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof RepeatFlowNode)
					.map(baseCanvasNode -> (RepeatFlowNode) baseCanvasNode);
	}

	public void forEachRepeatFlowNode(java.util.function.Consumer<RepeatFlowNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof RepeatFlowNode)
				.map(baseCanvasNode -> (RepeatFlowNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<RepeatFlowNode> isInstanceOfRepeatFlowNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof RepeatFlowNode) ? (RepeatFlowNode) canvasNode : null);
	}

	final class STFileNode extends BaseCanvasNode<nextgen.st.model.STFile> {

		private nextgen.st.model.STModel stModel;

		public STFileNode(nextgen.st.model.STFile model, nextgen.st.model.STModel stModel) {
			super(model, model.getUuid(), model.getPath().getValue());
			this.stModel = stModel;
		}

		@Override
		public void addedToCanvas() {
			thisCanvas().getAllNodes()
					.filter(stNode -> stNode instanceof STModelNode)
					.map(stNode -> (STModelNode) stNode)
					.filter(stModelNode -> stModelNode.getModel().getUuid().equals(getUuid().toString()))
					.findAny()
					.ifPresent(stModelNode -> thisCanvas().addRelation(getUuid(), () -> new STSinkRelation(stModelNode, STFileNode.this)));
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()
							.filter(stNode -> stNode instanceof STModelNode)
							.filter(stNode -> !stNode.getUuid().equals(getUuid()))
							.map(stNode -> (STModelNode) stNode)
							.collect(java.util.stream.Collectors.toList());
					final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()
							.filter(stNode -> stNode instanceof STValueNode)
							.filter(stNode -> !stNode.getUuid().equals(getUuid()))
							.map(stNode -> (STValueNode) stNode)
							.collect(java.util.stream.Collectors.toList());
			appModel().doInTransaction(tx -> {
					final JMenu sourceMenu = new JMenu("STModels");
					stModelNodes.forEach(stModelNode -> {
						final int end = Math.min(stModelNode.getText().length(), 50);
						sourceMenu.add(new SetSource(event, stModelNode));
					});
					if (!stModelNodes.isEmpty())
						pop.add(sourceMenu);

					final JMenu setNameMenu = new JMenu("Set Name");
					final JMenu setPathMenu = new JMenu("Set Path");
					final JMenu setTypeMenu = new JMenu("Set Type");
					final JMenu setPackageName = new JMenu("Set Package name");
					stValueNodes.stream().filter(stNode -> stNode.getModel().getType().equals(nextgen.st.model.STValueType.PRIMITIVE)).forEach(stValueNode -> {
						setPathMenu.add(new SetPathTo(event, stValueNode.getModel()));
						setNameMenu.add(new SetNameTo(event, stValueNode.getModel()));
						setPackageName.add(new SetPackageNameTo(event, stValueNode.getModel()));
						setTypeMenu.add(new SetTypeTo(event, stValueNode.getModel()));
					});
					if (setNameMenu.getMenuComponentCount() != 0) {
						pop.add(setNameMenu);
						pop.add(setPathMenu);
						pop.add(setTypeMenu);
						pop.add(setPackageName);
					}
				});
			pop.add(new EditFileSink(event));
			pop.add(new OpenFile(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeLeftClick(PInputEvent event) {
			super.onNodeLeftClick(event);
			thisCanvas().appModel().doLaterInTransaction(tx -> {
					if (getModel() == null || getModel().getPath() == null) return;
					nextgen.st.STGenerator.writeToFile(thisCanvas().appModel().render(stModel), getModel().getPackageName().getValue(), getModel().getName().getValue(), getModel().getType().getValue(), new java.io.File(getModel().getPath().getValue()));
				});
		}


		final class EditFileSink extends NodeAction {


			EditFileSink(PInputEvent event) {
				super("Edit File Sink", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doInTransaction(tx -> {
						final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
						fieldMap.put("name", SwingUtil.newTextField(getModel().getName() == null ? "" : getModel().getName().getValue(), 15));
						fieldMap.put("type", SwingUtil.newTextField(getModel().getType() == null ? "" : getModel().getType().getValue(), 15));
						fieldMap.put("path", SwingUtil.newTextField(getModel().getPath() == null ? "" : getModel().getPath().getValue(), 15));
						fieldMap.put("package", SwingUtil.newTextField(getModel().getPackageName() == null ? "" : getModel().getPackageName().getValue(), 15));
						final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
						inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
						for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
								inputPanel.add(new JLabel(fieldEntry.getKey()));
								inputPanel.add(fieldEntry.getValue());
						}
						nextgen.utils.SwingUtil.showDialog(inputPanel, thisCanvas(), "Edit", new nextgen.utils.SwingUtil.ConfirmAction() {
								@Override
								public void verifyAndCommit() throws Exception {
									final String name = fieldMap.get("name").getText().trim();
									final String type = fieldMap.get("type").getText().trim();
									final String path = fieldMap.get("path").getText().trim();
									final String packageName = fieldMap.get("package").getText().trim();
									thisCanvas().appModel().doLaterInTransaction(tx -> {

										if (getModel().getName() == null || (getModel().getName().getValue() == null || !getModel().getName().getValue().equals(name)))
											getModel().setName(thisCanvas().appModel().newSTValue(name));

										if (getModel().getType() == null || (getModel().getType().getValue() == null || !getModel().getType().getValue().equals(type)))
											getModel().setType(thisCanvas().appModel().newSTValue(type));

										if (getModel().getPath() == null || (getModel().getPath().getValue() == null || !getModel().getPath().getValue().equals(path)))
											getModel().setPath(thisCanvas().appModel().newSTValue(path));

										if (getModel().getPackageName() == null || (getModel().getPackageName().getValue() == null || !getModel().getPackageName().getValue().equals(packageName)))
											getModel().setPackageName(thisCanvas().appModel().newSTValue(packageName));

										setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
									});
								}
						});
					});
			}
		}

		final class OpenFile extends NodeAction {


			OpenFile(PInputEvent event) {
				super("Open File", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						try {
							java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(getModel()));
						} catch (Exception ex) {
							nextgen.utils.SwingUtil.showException(thisCanvas(), ex);
						}
					});
			}
		}

		final class SetSource extends NodeAction {

			private STModelNode stModelNode;

			SetSource(PInputEvent event, STModelNode stModelNode) {
				super("Set Source", event);
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						if (stModel != null) thisCanvas().removeRelation(getUuid());
						stModel = stModelNode.getModel();
						stModel.addFiles(getModel());
						thisCanvas().addRelation(getUuid(), () -> new STSinkRelation(stModelNode, thisNode()));
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

		final class SetPathTo extends NodeAction {

			private nextgen.st.model.STValue model;

			SetPathTo(PInputEvent event, nextgen.st.model.STValue model) {
				super(model.getValue(), event);
				this.model = model;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {
						getModel().setPath(model);
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

		final class SetNameTo extends NodeAction {

			private nextgen.st.model.STValue model;

			SetNameTo(PInputEvent event, nextgen.st.model.STValue model) {
				super(model.getValue(), event);
				this.model = model;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {
						getModel().setName(model);
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

		final class SetTypeTo extends NodeAction {

			private nextgen.st.model.STValue model;

			SetTypeTo(PInputEvent event, nextgen.st.model.STValue model) {
				super(model.getValue(), event);
				this.model = model;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {
						getModel().setType(model);
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

		final class SetPackageNameTo extends NodeAction {

			private nextgen.st.model.STValue model;

			SetPackageNameTo(PInputEvent event, nextgen.st.model.STValue model) {
				super(model.getValue(), event);
				this.model = model;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {
						getModel().setPackageName(model);
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

	}

	private void addSTFileNode(nextgen.st.model.STFile model, nextgen.st.model.STModel stModel) {
		addNode(model.getUuid(), newSTFileNode(model, stModel));
	}

	public java.util.function.Supplier<STFileNode> newSTFileNode(nextgen.st.model.STFile model, nextgen.st.model.STModel stModel) {
		return () -> new STFileNode(model, stModel);
	}

	public Stream<STFileNode> getAllSTFileNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof STFileNode)
					.map(baseCanvasNode -> (STFileNode) baseCanvasNode);
	}

	public void forEachSTFileNode(java.util.function.Consumer<STFileNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof STFileNode)
				.map(baseCanvasNode -> (STFileNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<STFileNode> isInstanceOfSTFileNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof STFileNode) ? (STFileNode) canvasNode : null);
	}

	final class STKVNode extends BaseCanvasNode<nextgen.st.model.STArgument> {

		private nextgen.st.domain.STParameter stParameter;

		public STKVNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
			super(model, model.getUuid(), stParameter.getName());
			this.stParameter = stParameter;
		}

		@Override
		public void addedToCanvas() {
			thisCanvas().getAllNodes().forEach(this::newNodeAdded);
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			stParameter.getKeys()
				.forEach(stParameterKey -> getModel().getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
						.filter(stArgumentKV -> stArgumentKV.getValue() != null)
						.forEach(stArgumentKV -> {
							final nextgen.st.model.STValue value = stArgumentKV.getValue();
							switch (value.getType()) {
								case STMODEL:
									if (getUuid().equals(value.getStModel().getUuid()))
										thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));
									break;
								case PRIMITIVE:
									if (getUuid().equals(value.getUuid()))
										thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));
									break;
								case ENUM:
									if (getUuid().equals(value.getUuid()))
										thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));
									break;
							}
						}));
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()
							.filter(stNode -> stNode instanceof STValueNode)
							.filter(stNode -> !stNode.getUuid().equals(getUuid()))
							.map(stNode -> (STValueNode) stNode)
							.collect(java.util.stream.Collectors.toList());
					final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()
							.filter(stNode -> stNode instanceof STModelNode)
							.filter(stNode -> !stNode.getUuid().equals(getUuid()))
							.map(stNode -> (STModelNode) stNode)
							.collect(java.util.stream.Collectors.toList());
			appModel().doInTransaction(tx -> {
					stParameter.getKeys().forEach(stParameterKey -> {
						final JMenu stParameterMenu = new JMenu(stParameterKey.getName());
						stValueNodes.forEach(stNode -> stParameterMenu.add(new SetSTValueArgumentAction(event, stParameterKey, getModel(), stNode)));
						stModelNodes.forEach(stNode -> stParameterMenu.add(new SetSTModelArgumentAction(event, stParameterKey, getModel(), stNode)));
						stParameterMenu.add(new SetInputValueArgumentAction(event, stParameterKey, getModel()));
						stParameterMenu.add(new SetClipboardValueArgumentAction(event, stParameterKey, getModel()));
						getModel().getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid())).filter(stArgumentKV -> stArgumentKV.getValue() != null).forEach(stArgumentKV -> {
								stParameterMenu.add(new OpenArgument(event, getModel(), stParameterKey, stArgumentKV));
								stParameterMenu.add(new RemoveArgument(event, getModel(), stArgumentKV));
						});
						if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);
					});
					if (pop.getComponents().length != 0) pop.addSeparator();
				});
			pop.add(new OpenAllArguments(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new OpenAllArguments(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class OpenAllArguments extends NodeAction {


			OpenAllArguments(PInputEvent event) {
				super("Open All", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						stParameter.getKeys()
								.forEach(stParameterKey -> getModel().getKeyValues()
										.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
										.filter(stArgumentKV -> stArgumentKV.getValue() != null)
										.findFirst()
										.ifPresent(stArgumentKV -> new OpenArgument(event, getModel(), stParameterKey, stArgumentKV).actionPerformed(null)));
						new LayoutTreeAction(thisNode(), event).actionPerformed(null);
					});
			}
		}

		final class SetInputValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameterKey stParameterKey;
			private nextgen.st.model.STArgument stArgument;

			SetInputValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument) {
				super("From input", event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog(stParameterKey.getName(), thisCanvas(), s -> {
							thisCanvas().appModel().doLaterInTransaction(tx -> {
								final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue(s);
								appModel().removeArgument(getModel(), stParameterKey);
								final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValue);
								stArgument.addKeyValues(stArgumentKV);
								thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameterKey, stArgumentKV));
							});
						});
			}
		}

		final class SetSTValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameterKey stParameterKey;
			private nextgen.st.model.STArgument stArgument;
			private STValueNode stValueNode;

			SetSTValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument, STValueNode stValueNode) {
				super(appModel().cut(stValueNode.getText(), 30), event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doLaterInTransaction(tx -> {
							appModel().removeArgument(getModel(), stParameterKey);
							final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValueNode.getModel());
							stArgument.addKeyValues(stArgumentKV);
							thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), stValueNode, stArgument, stParameterKey, stArgumentKV));
						});
			}
		}

		final class SetSTModelArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameterKey stParameterKey;
			private nextgen.st.model.STArgument stArgument;
			private STModelNode stModelNode;

			SetSTModelArgumentAction(PInputEvent event, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument, STModelNode stModelNode) {
				super(appModel().cut(stModelNode.getText(), 30), event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
							appModel().removeArgument(getModel(), stParameterKey);
							final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue(stModelNode.getModel());
							final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValue);
							stArgument.addKeyValues(stArgumentKV);
							thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), stModelNode, stArgument, stParameterKey, stArgumentKV));
						});
			}
		}

		final class OpenArgument extends NodeAction {

			private nextgen.st.model.STArgument stArgument;
			private nextgen.st.domain.STParameterKey stParameterKey;
			private nextgen.st.model.STArgumentKV stArgumentKV;

			OpenArgument(PInputEvent event, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
				super(appModel().cut(thisCanvas().appModel().render(stArgument.getValue())), event);
				this.stArgument = stArgument;
				this.stParameterKey = stParameterKey;
				this.stArgumentKV = stArgumentKV;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
							final nextgen.st.model.STValue stValue = stArgumentKV.getValue();
							switch (stValue.getType()) {
								case STMODEL:
									thisCanvas().addNode(stValue.getStModel().getUuid(), () -> new STModelNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate())));
									thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getStModel().getUuid()), stArgument, stParameterKey, stArgumentKV));
									break;
								case PRIMITIVE:
									thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
									thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameterKey, stArgumentKV));
									break;
								case ENUM:
									thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
									thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameterKey, stArgumentKV));
									break;
							}
							new LayoutTreeAction(thisNode(), event).actionPerformed(null);
						});
			}
		}

		final class RemoveArgument extends NodeAction {

			private nextgen.st.model.STArgument stArgument;
			private nextgen.st.model.STArgumentKV stArgumentKV;

			RemoveArgument(PInputEvent event, nextgen.st.model.STArgument stArgument, nextgen.st.model.STArgumentKV stArgumentKV) {
				super(appModel().cut(thisCanvas().appModel().render(stArgument.getValue())), event);
				this.stArgument = stArgument;
				this.stArgumentKV = stArgumentKV;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						stArgument.removeKeyValues(stArgumentKV);
						thisCanvas().removeRelation(stArgumentKV.getUuid());
					});
			}
		}

		final class SetClipboardValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameterKey stParameterKey;
			private nextgen.st.model.STArgument stArgument;

			SetClipboardValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument) {
				super("From Clipboard", event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
						appModel().removeArgument(getModel(), stParameterKey);
						final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValue);
						stArgument.addKeyValues(stArgumentKV);
						thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameterKey, stArgumentKV));
					});
			}
		}

	}

	private void addSTKVNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
		addNode(model.getUuid(), newSTKVNode(model, stParameter));
	}

	public java.util.function.Supplier<STKVNode> newSTKVNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
		return () -> new STKVNode(model, stParameter);
	}

	public Stream<STKVNode> getAllSTKVNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof STKVNode)
					.map(baseCanvasNode -> (STKVNode) baseCanvasNode);
	}

	public void forEachSTKVNode(java.util.function.Consumer<STKVNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof STKVNode)
				.map(baseCanvasNode -> (STKVNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<STKVNode> isInstanceOfSTKVNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof STKVNode) ? (STKVNode) canvasNode : null);
	}

	final class STModelNode extends BaseCanvasNode<nextgen.st.model.STModel> {

		private nextgen.st.domain.STTemplate stTemplate;

		public STModelNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate) {
			super(model, model.getUuid(), stTemplate.getName() + " :\n" + appModel().render(model, 1500));
			this.stTemplate = stTemplate;
		}

		@Override
		public void addedToCanvas() {
			thisCanvas().getAllNodes().forEach(this::newNodeAdded);
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {
				if (refersTo(stArgument, stParameter, node))
					addRelation(stArgument.getUuid(), () -> new STArgumentRelation(STModelNode.this, node, stArgument, stParameter));
			});
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()
					.filter(stNode -> stNode instanceof STValueNode)
					.filter(stNode -> !stNode.getUuid().equals(getUuid()))
					.map(stNode -> (STValueNode) stNode)
					.collect(java.util.stream.Collectors.toList());
			final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()
					.filter(stNode -> stNode instanceof STModelNode)
					.filter(stNode -> !stNode.getUuid().equals(getUuid()))
					.map(stNode -> (STModelNode) stNode)
					.collect(java.util.stream.Collectors.toList());
			final java.util.List<STModelNode> sameModelNodes = thisCanvas().getSelectedNodes()
					.filter(stNode -> stNode instanceof STModelNode)
					.filter(stNode -> !stNode.getUuid().equals(getUuid()))
					.map(stNode -> (STModelNode) stNode)
					.filter(stModelNode -> stModelNode.stTemplate.equals(STModelNode.this.stTemplate))
					.collect(java.util.stream.Collectors.toList());
			thisCanvas().appModel().doInTransaction(tx -> {

				final String clipboardValue = appModel().cut(nextgen.utils.SwingUtil.fromClipboard());
				
				final JMenu parametersMenu = new JMenu("Parameters");
				pop.add(parametersMenu);
				final Map<String, nextgen.st.model.STValue> existingSelections = new LinkedHashMap<>();

				stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {

					final JMenu stParameterMenu = new JMenu(stParameter.getName());
					parametersMenu.add(stParameterMenu);

					switch (stParameter.getType()) {
						case SINGLE: {
							final JMenu addstParameterMenu = new JMenu("Set");
							stParameterMenu.add(addstParameterMenu);
							stValueNodes.forEach(stNode -> addstParameterMenu.add(new SetSTValueArgumentAction(event, stParameter, stNode)));
							stModelNodes.forEach(stNode -> addstParameterMenu.add(new SetSTModelArgumentAction(event, stParameter, stNode)));
							sameModelNodes.forEach(stNode -> addstParameterMenu.add(new SetToSameAsArgumentAction(event, stParameter, stNode)));
							addstParameterMenu.add(new SetParameterTypeAction(event, stParameter));
							addstParameterMenu.add(new SetInputValueArgumentAction(event, stParameter));
							addstParameterMenu.add(new SetBooleanValue(event, stParameter));
							addstParameterMenu.add(new SetClipboardValueArgumentAction(event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);

							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(event, stArgument));
								existingSelections.put(stParameter.getUuid(), stArgument.getValue());
							});
							if (openstParameterMenu.getMenuComponentCount() > 1)
								openstParameterMenu.add(new OpenAllOf(event, stParameter));

							
							break;
						}
						case LIST: {
							final JMenu addstParameterMenu = new JMenu("Add");
							stParameterMenu.add(addstParameterMenu);
							stValueNodes.forEach(stNode -> addstParameterMenu.add(new AddSTValueArgumentAction(event, stParameter, stNode)));
							stModelNodes.forEach(stNode -> addstParameterMenu.add(new AddSTModelArgumentAction(event, stParameter, stNode)));
							addstParameterMenu.add(new AddParameterTypeAction(event, stParameter));
							addstParameterMenu.add(new AddInputValueArgumentAction(event, stParameter));
							addstParameterMenu.add(new AddClipboardValueArgumentAction(event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf(event, stParameter));

							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(event, stArgument));
							});
							break;
						}
						case KVLIST: {
							final JMenu addstParameterMenu = new JMenu("Add");
							stParameterMenu.add(addstParameterMenu);
							addstParameterMenu.add(new AddKVInputValueArgumentAction(event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf(event, stParameter));

							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(event, stArgument));
							});
							break;
						}
					}
				});

				pop.add(new SetMultipleFields(event));

			});
			pop.add(new ToClipboard(event));
			pop.add(new Delete(event));
			pop.add(new Clone(event));
			pop.add(new AddFileSink(event));
			pop.add(new OpenFileSink(event));
			pop.add(new OpenTemplate(event));
			pop.add(new WriteToFile(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeLeftClick(PInputEvent event) {
			super.onNodeLeftClick(event);
			appModel().doLaterInTransaction(tx -> setText(stTemplate.getName() + " : \n" + appModel().render(getModel())));
			nextgen.st.STAppEvents.postCanvasSTModelClicked(getModel());
		}


		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_D:
					new Delete(event).actionPerformed(null);
					break;

				case VK_W:
					new WriteToFile(event).actionPerformed(null);
					break;

				case VK_I:
					new OpenIncoming(event).actionPerformed(null);
					break;

				case VK_T:
					new OpenTemplate(event).actionPerformed(null);
					break;

				case VK_E:
					new OpenAllArguments(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class AddParameterTypeAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			AddParameterTypeAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("Add", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().addList(stParameter, getModel(), thisCanvas(), objects -> {
						setText(thisCanvas().appModel().render(getModel()));						
					});
			}
		}

		final class SetParameterTypeAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			SetParameterTypeAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("Set", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().setParameter(stParameter, getModel(), thisCanvas(), objects -> {
						setText(thisCanvas().appModel().render(getModel()));						
					});
			}
		}

		final class OpenUsages extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			OpenUsages(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super("Open Usages", event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
			}
		}

		final class WriteToFile extends NodeAction {


			WriteToFile(PInputEvent event) {
				super("Write To File", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().writeToFile(getModel());
			}
		}

		final class OpenIncoming extends NodeAction {


			OpenIncoming(PInputEvent event) {
				super("Open Incoming", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {

					appModel().getIncomingSTArguments(getModel())
							.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel()
									.forEach(stModel -> {
										final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());
										if (stTemplateByUuid == null) return;
										stTemplateByUuid.getParameters()
												.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
												.findFirst()
												.ifPresent(stParameter -> {
													final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));
													thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));
												});
									}));

					appModel().getIncomingSTArgumentKVs(getModel())
							.forEach(stArgumentKV -> {
								stArgumentKV.getIncomingKeyValuesSTArgument()
										.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> {
											final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());
											if (stTemplateByUuid == null) return;
											stTemplateByUuid.getParameters()
													.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
													.findFirst()
													.ifPresent(stParameter -> stParameter.getKeys()
															.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
															.findFirst()
															.ifPresent(stParameterKey -> {
																final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));
																final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));
																thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));
																thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));
															}));
										}));
							});
				});
			}
		}

		final class OpenAllArguments extends NodeAction {


			OpenAllArguments(PInputEvent event) {
				super("Open All", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
					appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> new OpenArgument(event, false, stParameter, stArgument).actionPerformed(null));
					new LayoutTreeAction(thisNode(), event).actionPerformed(null);
				});
			}
		}

		final class ToClipboard extends NodeAction {


			ToClipboard(PInputEvent event) {
				super("To Clipboard", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(thisCanvas().appModel().render(getModel())));
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete model ?")
						.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {
							close();
							thisCanvas().appModel().db.remove(getModel());
						}));
			}
		}

		final class Clone extends NodeAction {


			Clone(PInputEvent event) {
				super("Clone", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> thisCanvas().addNode(new STModelNode(thisCanvas().appModel().db.clone(getModel()), stTemplate)));
			}
		}

		final class AddFileSink extends NodeAction {


			AddFileSink(PInputEvent event) {
				super("Add File Sink", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doLaterInTransaction(tx -> {

					final java.util.concurrent.atomic.AtomicInteger typeIndex = new java.util.concurrent.atomic.AtomicInteger(0);
					final String[] fileTypes = new String[]{"html", "java", "js", "xml"};

					final java.util.concurrent.atomic.AtomicInteger pathIndex = new java.util.concurrent.atomic.AtomicInteger(0);
					final String[] pathTypes = thisCanvas().appModel().db.findAllSTFile()
								.filter(stFile -> stFile.getPath() != null)
								.filter(stFile -> stFile.getPath().getValue() != null)
								.map(stFile -> stFile.getPath().getValue())
								.distinct()
								.toArray(String[]::new);

					final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
					fieldMap.put("name", SwingUtil.newTextField(thisCanvas().appModel().getSTModelName(getModel(), ""), 15));
					fieldMap.put("type", SwingUtil.newTextField(15));
					fieldMap.put("path", SwingUtil.newTextField(15));
					fieldMap.put("package", SwingUtil.newTextField(thisCanvas().appModel().getSTModelPackage(getModel(), ""), 15));
					final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
					inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
					for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
							inputPanel.add(new JLabel(fieldEntry.getKey()));
							inputPanel.add(fieldEntry.getValue());

							if (fieldEntry.getKey().equals("type")) {
								fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {
									@Override
									public void mouseClicked(java.awt.event.MouseEvent e) {
											fieldEntry.getValue().setText(fileTypes[typeIndex.incrementAndGet() % fileTypes.length]);
									}
								});
							} else if (fieldEntry.getKey().equals("path")) {
								fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {
									@Override
									public void mouseClicked(java.awt.event.MouseEvent e) {
											fieldEntry.getValue().setText(pathTypes[pathIndex.incrementAndGet() % pathTypes.length]);
									}
								});
							}
					}

					nextgen.utils.SwingUtil.showDialog(inputPanel, thisCanvas(), "New File sink", new nextgen.utils.SwingUtil.ConfirmAction() {
							@Override
							public void verifyAndCommit() throws Exception {
								final String name = fieldMap.get("name").getText().trim();
								final String type = fieldMap.get("type").getText().trim();
								final String path = fieldMap.get("path").getText().trim();
								final String packageName = fieldMap.get("package").getText().trim();
								thisCanvas().appModel().doLaterInTransaction(tx -> {
									final nextgen.st.model.STFile stFile = thisCanvas().appModel().newSTFile(name, type, path, packageName);
									getModel().addFiles(stFile);
									final STFileNode dstNode = thisCanvas().addNode(new STFileNode(stFile, getModel()));
									thisCanvas().addRelation(dstNode.getUuid(), () -> new STSinkRelation(thisNode(), dstNode));
								});
							}
					});
				});
			}
		}

		final class OpenFileSink extends NodeAction {


			OpenFileSink(PInputEvent event) {
				super("Open File Sink", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doLaterInTransaction(tx ->
							getModel().getFiles().forEach(stFile -> {
								final STFileNode dstNode = thisCanvas().addNode(stFile.getUuid(), () -> new STFileNode(stFile, getModel()));
								thisCanvas().addRelation(dstNode.getUuid(), () -> new STSinkRelation(thisNode(), dstNode));
								new LayoutTreeAction(thisNode(), event).actionPerformed(null);
							})
				);
			}
		}

		final class SetSTValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STValueNode stValueNode;

			SetSTValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STValueNode stValueNode) {
				super(appModel().cut(stValueNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
					if (appModel().sameArgumentValue(getModel(), stParameter, stValueNode.getModel())) return;
					appModel().removeArgument(getModel(), stParameter);
					final nextgen.st.model.STArgument stArgument = appModel().newSTArgument(stParameter, stValueNode.getModel());
					getModel().addArguments(stArgument);
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
					setText(appModel().render(getModel()));
				});
			}
		}

		final class SetSTModelArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			SetSTModelArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super(appModel().cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doLaterInTransaction(tx -> {
					appModel().removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().appModel().newSTValue(stModelNode.getModel());
					final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stModelNode, stArgument, stParameter));
					setText(thisCanvas().appModel().render(getModel()));
				});
			}
		}

		final class SetToSameAsArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			SetToSameAsArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super("Same as " + appModel().cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doInTransaction(transaction -> stModelNode.getModel().getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.filter(stArgument -> stArgument.getValue() != null)
						.findFirst()
						.ifPresent(sourceArgument -> {
								appModel().removeArgument(getModel(), stParameter);
								final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, sourceArgument.getValue());
								getModel().addArguments(stArgument);
								final STValueNode stValueNode = thisCanvas().addNode(sourceArgument.getValue().getUuid(), () -> new STValueNode(sourceArgument.getValue()));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
								setText(thisCanvas().appModel().render(getModel()));
						}));
			}
		}

		final class SetInputValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			SetInputValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("From input", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), thisCanvas(), s -> {
					thisCanvas().appModel().doLaterInTransaction(tx -> {
							final nextgen.st.model.STValue stValue = appModel().newSTValue(s);
							appModel().removeArgument(getModel(), stParameter);
							final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
							getModel().addArguments(stArgument);
							final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
							thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
							setText(thisCanvas().appModel().render(getModel()));
					});
				});
			}
		}

		final class SetBooleanValue extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			SetBooleanValue(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("Set TRUE", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().appModel().doLaterInTransaction(tx -> {
					appModel().removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue("true");
					final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().db.newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					setText(thisCanvas().appModel().render(getModel()));
				});
			}
		}

		final class SetClipboardValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			SetClipboardValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("From Clipboard", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				final String s = nextgen.utils.SwingUtil.fromClipboard();
				if (s == null || s.trim().length() == 0) return;
				thisCanvas().appModel().doLaterInTransaction(tx -> {
					appModel().removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().appModel().newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameter));
					setText(thisCanvas().appModel().render(getModel()));
				});
			}
		}

		final class OpenArgument extends NodeAction {

			private boolean layoutAfter;
			private nextgen.st.domain.STParameter stParameter;
			private nextgen.st.model.STArgument stArgument;

			OpenArgument(PInputEvent event, boolean layoutAfter, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
				super(appModel().cut(appModel().render(stArgument), 30), event);
				this.layoutAfter = layoutAfter;
				this.stParameter = stParameter;
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
					if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {
						addSTKVNode(stArgument, stParameter);
					} else {
						final nextgen.st.model.STValue stValue = stArgument.getValue();
						switch (stValue.getType()) {
							case STMODEL: {
								final nextgen.st.model.STModel stModel = stValue.getStModel();
								addSTModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate()));
								break;
							}
							case PRIMITIVE: {
								addSTValueNode(stValue);
								break;
							}
							case ENUM: {
								addSTValueNode(stValue);
								break;
							}
						}
					}

					if (layoutAfter)
						new LayoutTreeAction(thisNode(), event).actionPerformed(null);
				});
			}
		}

		final class RemoveArgument extends NodeAction {

			private nextgen.st.model.STArgument stArgument;

			RemoveArgument(PInputEvent event, nextgen.st.model.STArgument stArgument) {
				super(appModel().cut(appModel().render(stArgument), 30), event);
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Remove argument ?")
						.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {
							thisCanvas().removeRelation(stArgument.getUuid());
							getModel().removeArguments(stArgument);
							setText(thisCanvas().appModel().render(getModel()));
						}));
			}
		}

		final class OpenAllOf extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			OpenAllOf(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("Open All", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {
								if (this.stParameter.equals(stParameter))
									new OpenArgument(event, false, stParameter, stArgument).actionPerformed(null);
						});
						new LayoutTreeAction(thisNode(), event).actionPerformed(null);
					});
			}
		}

		final class AddSTValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STValueNode stValueNode;

			AddSTValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STValueNode stValueNode) {
				super(appModel().cut(stValueNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValueNode.getModel());
						getModel().addArguments(stArgument);
						thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
						setText(thisCanvas().appModel().render(getModel()));
					});
			}
		}

		final class AddSTModelArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			AddSTModelArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super(appModel().cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						final nextgen.st.model.STValue stValue = thisCanvas().appModel().newSTValue(stModelNode.getModel());
						final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
						getModel().addArguments(stArgument);
						thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stModelNode, stArgument, stParameter));
						setText(thisCanvas().appModel().render(getModel()));
					});
			}
		}

		final class AddInputValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			AddInputValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("From input", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), thisCanvas(), s -> {
						appModel().doLaterInTransaction(tx -> {
								final nextgen.st.model.STValue stValue = thisCanvas().appModel().newSTValue(s.trim());
								final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
								getModel().addArguments(stArgument);
								final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
								setText(thisCanvas().appModel().render(getModel()));
						});
					});
			}
		}

		final class AddClipboardValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			AddClipboardValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("From Clipboard", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				final String s = nextgen.utils.SwingUtil.fromClipboard();
				if (s == null || s.trim().length() == 0) return;
				appModel().doLaterInTransaction(tx -> {
					final nextgen.st.model.STValue stValue = thisCanvas().appModel().newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = thisCanvas().appModel().newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
					setText(thisCanvas().appModel().render(getModel()));
				});
			}
		}

		final class AddKVInputValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;

			AddKVInputValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter) {
				super("From input", event);
				this.stParameter = stParameter;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(tx -> {
						appModel().addKVArgument(getModel(), stParameter, thisCanvas(), stArgument -> {
								final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stkvNode, stArgument, stParameter));
								setText(thisCanvas().appModel().render(getModel()));
						});
					});
			}
		}

		final class SetMultipleFields extends NodeAction {


			SetMultipleFields(PInputEvent event) {
				super("Set Multiple", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> appModel().setMultiple(thisCanvas(), getModel(), stTemplate));
			}
		}

		final class OpenTemplate extends NodeAction {


			OpenTemplate(PInputEvent event) {
				super("Open Template", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> nextgen.st.STAppEvents.postOpenSTTemplate(stTemplate));
			}
		}

		@Override
		public void setText(String text) {
			super.setText(text.substring(0, Math.min(text.length(), 2000)));
		}

		public boolean refersTo(nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter, BaseCanvasNode<?> node) {
			if (stArgument == null || stParameter == null || node == null) return false;
			switch (stParameter.getType()) {
				case SINGLE: {
					final nextgen.st.model.STValue value = stArgument.getValue();
					if (value != null)
						return value.getUuid().equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && value.getStModel().getUuid().equals(node.getUuid()));
					break;
				}
				case LIST: {
					final nextgen.st.model.STValue value = stArgument.getValue();
					if (value != null)
						return value.getUuid().equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && value.getStModel().getUuid().equals(node.getUuid()));
					break;
				}
				case KVLIST: {
					if (stArgument.getUuid().equals(node.getUuid())) return true;
					break;
				}
			}
			return false;
		}
	}

	private void addSTModelNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate) {
		addNode(model.getUuid(), newSTModelNode(model, stTemplate));
	}

	public java.util.function.Supplier<STModelNode> newSTModelNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate) {
		return () -> new STModelNode(model, stTemplate);
	}

	public Stream<STModelNode> getAllSTModelNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof STModelNode)
					.map(baseCanvasNode -> (STModelNode) baseCanvasNode);
	}

	public void forEachSTModelNode(java.util.function.Consumer<STModelNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof STModelNode)
				.map(baseCanvasNode -> (STModelNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<STModelNode> isInstanceOfSTModelNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof STModelNode) ? (STModelNode) canvasNode : null);
	}

	final class STValueNode extends BaseCanvasNode<nextgen.st.model.STValue> {


		public STValueNode(nextgen.st.model.STValue model) {
			super(model, model.getUuid(), appModel().render(model));
		}

		@Override
		public void addedToCanvas() {
			appModel().getSTModel(getModel())
					.filter(stModel -> thisCanvas().getNode(stModel.getUuid()) != null)
					.map(stModel -> (STModelNode) thisCanvas().getNode(stModel.getUuid()))
					.ifPresent(stModelNode -> thisCanvas().addRelation(stModelNode.getUuid(), () -> new STValueModelRelation(STValueNode.this, stModelNode)));
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			appModel().getSTModel(getModel())
					.map(stModel -> stModel.getUuid())
					.filter(uuid -> uuid.equals(node.getUuid()))
					.ifPresent(uuid -> thisCanvas().addRelation(node.getUuid(), () -> new STValueModelRelation(STValueNode.this, node)));
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new EditSTValue(event));
			pop.add(new ToClipboard(event));
			pop.add(new Delete(event));
			pop.add(new OpenIncoming(event));
			super.onNodeRightClick(event, pop);
		}

		final class EditSTValue extends NodeAction {


			EditSTValue(PInputEvent event) {
				super("Edit", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog("Edit", thisCanvas(), thisCanvas().appModel().db.get(() -> getModel().getValue()), s -> thisCanvas().appModel().doLaterInTransaction(tx -> {
						getModel().setValue(s);
						setText(getModel().getValue());
					}));
			}
		}

		final class ToClipboard extends NodeAction {


			ToClipboard(PInputEvent event) {
				super("To Clipboard", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(appModel().render(getModel())));
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete value ?")
						.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {
							close();
							appModel().db.remove(getModel());
						}));
			}
		}

		final class OpenIncoming extends NodeAction {


			OpenIncoming(PInputEvent event) {
				super("Open Incoming", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				appModel().doLaterInTransaction(transaction -> {

					appModel().getIncomingSTArguments(getModel())
							.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel()
									.forEach(stModel -> {
										final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());
										if (stTemplateByUuid == null) return;
										stTemplateByUuid.getParameters()
												.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
												.findFirst()
												.ifPresent(stParameter -> {
													final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));
													thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));
												});
									}));

					appModel().getIncomingSTArgumentKVs(getModel())
							.forEach(stArgumentKV -> {
								stArgumentKV.getIncomingKeyValuesSTArgument()
										.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> {
											final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());
											if (stTemplateByUuid == null) return;
											stTemplateByUuid.getParameters()
													.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
													.findFirst()
													.ifPresent(stParameter -> stParameter.getKeys()
															.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
															.findFirst()
															.ifPresent(stParameterKey -> {
																final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));
																final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));
																thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));
																thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));
															}));
										}));
							});
				});
			}
		}

	}

	private void addSTValueNode(nextgen.st.model.STValue model) {
		addNode(model.getUuid(), newSTValueNode(model));
	}

	public java.util.function.Supplier<STValueNode> newSTValueNode(nextgen.st.model.STValue model) {
		return () -> new STValueNode(model);
	}

	public Stream<STValueNode> getAllSTValueNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof STValueNode)
					.map(baseCanvasNode -> (STValueNode) baseCanvasNode);
	}

	public void forEachSTValueNode(java.util.function.Consumer<STValueNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof STValueNode)
				.map(baseCanvasNode -> (STValueNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<STValueNode> isInstanceOfSTValueNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof STValueNode) ? (STValueNode) canvasNode : null);
	}

	public java.util.function.Supplier<STModelCanvas.ScriptRelation> newScriptRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.ScriptRelation(src, dst);
	}

	public void addScriptRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid(), newScriptRelation(src, dst));
	}

	final class ScriptRelation extends BaseCanvasRelation {


		public ScriptRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, src.getUuid(), "SCRIPT");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.STArgumentRelation> newSTArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter) {
		return () -> new STModelCanvas.STArgumentRelation(src, dst, stArgument, stParameter);
	}

	public void addSTArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter) {
		addRelation(stArgument.getUuid(), newSTArgumentRelation(src, dst, stArgument, stParameter));
	}

	final class STArgumentRelation extends BaseCanvasRelation {

		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.domain.STParameter stParameter;

		public STArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter) {
			super(src, dst, stArgument.getUuid(), stParameter.getName());
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

			pop.add(new Delete(event));
		}

		@Override
		protected void onRelationKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_D:
					new Delete(event).actionPerformed(null);
					break;

			}
			super.onRelationKeyPressed(event);
		}

		final class Delete extends RelationAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete " + stParameter.getName() + " ?")
						.ifPresent(confirm -> appModel().doLaterInTransaction(tx -> {
							final STModelNode src = (STModelNode) getSrc();
							src.getModel().removeArguments(stArgument);
							removeRelation(getUuid());
						}));
			}
		}
	}

	public java.util.function.Supplier<STModelCanvas.STKVArgumentRelation> newSTKVArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
		return () -> new STModelCanvas.STKVArgumentRelation(src, dst, stArgument, stParameterKey, stArgumentKV);
	}

	public void addSTKVArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
		addRelation(stArgumentKV.getUuid(), newSTKVArgumentRelation(src, dst, stArgument, stParameterKey, stArgumentKV));
	}

	final class STKVArgumentRelation extends BaseCanvasRelation {

		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.domain.STParameterKey stParameterKey;
		private nextgen.st.model.STArgumentKV stArgumentKV;

		public STKVArgumentRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
			super(src, dst, stArgumentKV.getUuid(), stParameterKey.getName());
			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.stArgumentKV = stArgumentKV;
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.STSinkRelation> newSTSinkRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.STSinkRelation(src, dst);
	}

	public void addSTSinkRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(dst.getUuid(), newSTSinkRelation(src, dst));
	}

	final class STSinkRelation extends BaseCanvasRelation {


		public STSinkRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, dst.getUuid(), "SINK");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.STValueModelRelation> newSTValueModelRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.STValueModelRelation(src, dst);
	}

	public void addSTValueModelRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(dst.getUuid(), newSTValueModelRelation(src, dst));
	}

	final class STValueModelRelation extends BaseCanvasRelation {


		public STValueModelRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, dst.getUuid(), "Value");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}
}