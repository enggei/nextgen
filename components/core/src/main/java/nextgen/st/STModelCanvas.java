package nextgen.st;

import nextgen.utils.SwingUtil;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.awt.event.KeyEvent.*;

public class STModelCanvas extends PCanvas implements PInputEventListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelCanvas.class);

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<String, BaseCanvasNode<?>> nodeMap = new ConcurrentHashMap<>();
	final Map<String, BaseCanvasRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();
	final CanvasZoomHandler canvasZoomHandler = new CanvasZoomHandler();

	private nextgen.st.STAppPresentationModel presentationModel;

	public STModelCanvas(Color background, Dimension preferredSize, nextgen.st.STAppPresentationModel presentationModel) {
		super();

		this.presentationModel = presentationModel;

		setBackground(background);
		setPreferredSize(preferredSize);
		nodeLayer = getLayer();
		getCamera().addLayer(0, relationLayer);

		removeInputEventListener(getZoomEventHandler());
		addInputEventListener(canvasZoomHandler);
		addInputEventListener(canvasInputEventsHandler);
		javax.swing.SwingUtilities.invokeLater(() -> new LoadLastLayoutAction(null).actionPerformed(null));
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public STModelCanvas thisCanvas() {
		return this;
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenScript(nextgen.st.STAppEvents.OpenScript event) {
		presentationModel.doLaterInTransaction(transaction -> addScriptNode(event.script));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewMetaDomain(nextgen.st.STAppEvents.NewMetaDomain event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaDomainNode(event.metaDomain));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewMetaEntity(nextgen.st.STAppEvents.NewMetaEntity event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaEntityNode(event.metaEntity));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewMetaRelation(nextgen.st.STAppEvents.NewMetaRelation event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaRelationNode(event.metaRelation));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewMetaProperty(nextgen.st.STAppEvents.NewMetaProperty event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaPropertyNode(event.metaProperty));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewDomainEntity(nextgen.st.STAppEvents.NewDomainEntity event) {
		presentationModel.doLaterInTransaction(transaction -> addDomainEntityNode(event.domainEntity));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenMetaDomain(nextgen.st.STAppEvents.OpenMetaDomain event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaDomainNode(event.metaDomain));
		presentationModel.getWorkspace().showCanvas();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenMetaEntity(nextgen.st.STAppEvents.OpenMetaEntity event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaEntityNode(event.metaEntity));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenMetaProperty(nextgen.st.STAppEvents.OpenMetaProperty event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaPropertyNode(event.metaProperty));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenMetaRelation(nextgen.st.STAppEvents.OpenMetaRelation event) {
		presentationModel.doLaterInTransaction(transaction -> addMetaRelationNode(event.metaRelation));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewDomainVisitor(nextgen.st.STAppEvents.NewDomainVisitor event) {
		presentationModel.doLaterInTransaction(transaction -> addDomainVisitorNode(event.domainVisitor));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenDomainVisitor(nextgen.st.STAppEvents.OpenDomainVisitor event) {
		presentationModel.doLaterInTransaction(transaction -> addDomainVisitorNode(event.domainVisitor));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTModel(nextgen.st.STAppEvents.NewSTModel event) {
		presentationModel.doLaterInTransaction(transaction -> addSTModelNode(event.sTModel, presentationModel.findSTTemplateByUuid(event.sTModel.getStTemplate())));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onOpenSTModel(nextgen.st.STAppEvents.OpenSTModel event) {
		presentationModel.doLaterInTransaction(transaction -> addSTModelNode(event.sTModel, presentationModel.findSTTemplateByUuid(event.sTModel.getStTemplate())));
		presentationModel.getWorkspace().showCanvas();
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
			centerNode(node);
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


		pop.add(new NewDomainAction(event));
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
			this.addAttribute("_defaultColor", Color.decode("#000000"));
			this.addAttribute("_selectedColor", new Color(174, 1, 126));
			this.addAttribute("_highlightedColor", new Color(240, 59, 32));
			this.addAttribute("_rectangleColor", new Color(67, 162, 202, 50));
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

	final class NewDomainAction extends CanvasAction {

		NewDomainAction(PInputEvent event) {
			super("New Domain", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), "", s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
				presentationModel.metaDb.newMetaDomain(s);
			}));
		}
	}

	final class SaveLastLayoutAction extends CanvasAction {

		SaveLastLayoutAction(PInputEvent event) {
			super("Save last layout", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			presentationModel.doLaterInTransaction(tx -> {
					final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(presentationModel.db.getDatabaseService());
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
						} else if (stNode instanceof ScriptNode) {
							final org.neo4j.graphdb.Node node = ((ScriptNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof STFileNode) {
							final org.neo4j.graphdb.Node node = ((STFileNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof MetaDomainNode) {
							final org.neo4j.graphdb.Node node = ((MetaDomainNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof MetaEntityNode) {
							final org.neo4j.graphdb.Node node = ((MetaEntityNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof MetaRelationNode) {
							final org.neo4j.graphdb.Node node = ((MetaRelationNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof MetaPropertyNode) {
							final org.neo4j.graphdb.Node node = ((MetaPropertyNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof DomainEntityNode) {
							final org.neo4j.graphdb.Node node = ((DomainEntityNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						} else if (stNode instanceof DomainVisitorNode) {
							final org.neo4j.graphdb.Node node = ((DomainVisitorNode) stNode).getModel().getNode();
							layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
						}
						last.addNodes(layoutNode);
					});
				});
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

	final class LoadLastLayoutAction extends CanvasAction {

		LoadLastLayoutAction(PInputEvent event) {
			super("Load last layout", event);
		}

		@Override
		void actionPerformed(PInputEvent event, ActionEvent e) {
			presentationModel.doLaterInTransaction(tx -> {

				final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(presentationModel.db.getDatabaseService());
				final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findLayoutByName("last");
				if (last == null) return;

				final java.util.concurrent.atomic.AtomicReference<BaseCanvasNode<?>> centerNodeRef = new java.util.concurrent.atomic.AtomicReference<>();
				last.getNodesSorted().forEach(layoutNode -> {
					final org.neo4j.graphdb.Node node = layoutNode.getNode();
					node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("ref")).forEach(relationship -> {
							final org.neo4j.graphdb.Node stNode = relationship.getOtherNode(node);
							if (nextgen.st.model.STModelNeoFactory.isSTModel(stNode)) {
								final nextgen.st.model.STModel stModel = presentationModel.newSTModel(stNode);
								addNode(stModel.getUuid(), () -> new STModelNode(stModel, presentationModel.findSTTemplateByUuid(stModel.getStTemplate())));
								getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stModel.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isSTValue(stNode)) {
								final nextgen.st.model.STValue stValue = presentationModel.newSTValue(stNode);
								addNode(stValue.getUuid(), () -> new STValueNode(stValue));
								getNode(stValue.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stValue.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isScript(stNode)) {
								final nextgen.st.model.Script script = presentationModel.newScript(stNode);
								addNode(script.getUuid(), () -> new ScriptNode(script));
								getNode(script.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(script.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isProject(stNode)) {
								final nextgen.st.model.Project project = presentationModel.newProject(stNode);
								addNode(project.getUuid(), () -> new ProjectNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.st.model.STModelNeoFactory.isSTFile(stNode)) {
								final nextgen.st.model.STFile stFile = presentationModel.newSTFile(stNode);
								stFile.getIncomingFiles().findFirst().ifPresent(stModel -> {
									addNode(stFile.getUuid(), () -> new STFileNode(stFile, stModel));
									getNode(stFile.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
									if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stFile.getUuid()));
								});
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isMetaDomain(stNode)) {
								final nextgen.domains.meta.MetaDomain project = presentationModel.newMetaDomain(stNode);
								addNode(project.getUuid(), () -> new MetaDomainNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isMetaEntity(stNode)) {
								final nextgen.domains.meta.MetaEntity project = presentationModel.newMetaEntity(stNode);
								addNode(project.getUuid(), () -> new MetaEntityNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isMetaRelation(stNode)) {
								final nextgen.domains.meta.MetaRelation project = presentationModel.newMetaRelation(stNode);
								addNode(project.getUuid(), () -> new MetaRelationNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isMetaProperty(stNode)) {
								final nextgen.domains.meta.MetaProperty project = presentationModel.newMetaProperty(stNode);
								addNode(project.getUuid(), () -> new MetaPropertyNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isDomainEntity(stNode)) {
								final nextgen.domains.meta.DomainEntity project = presentationModel.newDomainEntity(stNode);
								addNode(project.getUuid(), () -> new DomainEntityNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							} else if (nextgen.domains.meta.MetaDomainNeoFactory.isDomainVisitor(stNode)) {
								final nextgen.domains.meta.DomainVisitor project = presentationModel.newDomainVisitor(stNode);
								addNode(project.getUuid(), () -> new DomainVisitorNode(project));
								getNode(project.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(getNode(project.getUuid()));
							}
					});
				});

				if (centerNodeRef.get() != null) centerNode(centerNodeRef.get());
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

	final class MetaEntityNode extends BaseCanvasNode<nextgen.domains.meta.MetaEntity> {


		public MetaEntityNode(nextgen.domains.meta.MetaEntity model) {
			super(model, model.getUuid(), model.getName());
		}

		@Override
		public void addedToCanvas() {
			getAllMetaPropertyNode()
					.filter(metaPropertyNode -> getModel().getProperties().anyMatch(metaProperty -> metaProperty.getUuid().equals(metaPropertyNode.getUuid())))
					.forEach(metaPropertyNode -> addMetaEntityPropertyRelation(thisNode(), metaPropertyNode));

			getAllMetaRelationNode()
					.filter(metaRelationNode -> metaRelationNode.getModel().getDst().anyMatch(metaEntity -> metaEntity.getUuid().equals(getUuid())))
					.forEach(metaRelationNode -> addMetaEntityDstRelation(metaRelationNode, thisNode()));

			getAllMetaRelationNode()
					.filter(metaRelationNode -> getModel().getRelations().anyMatch(metaRelation -> metaRelation.getUuid().equals(metaRelationNode.getUuid())))
					.forEach(metaRelationNode -> addMetaEntitySrcRelation(thisNode(), metaRelationNode));

			getAllMetaDomainNode()
					.filter(metaDomainNode -> metaDomainNode.getModel().getRoots().anyMatch(metaEntity -> metaEntity.getUuid().equals(getUuid())))
					.forEach(metaDomainNode -> addMetaDomainEntityRelation(metaDomainNode, thisNode()));
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			isInstanceOfMetaPropertyNode(node)
					.ifPresent(metaPropertyNode -> getModel().getProperties().filter(metaProperty -> metaProperty.getUuid().equals(metaPropertyNode.getUuid())).forEach(metaProperty -> addMetaEntityPropertyRelation(thisNode(), metaPropertyNode)));
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new NewMetaRelation(event));
			pop.add(new NewMetaProperty(event));
			pop.add(new NewInstance(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new ExpandAction(event).actionPerformed(null);
					break;

				case VK_D:
					new Delete(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class NewMetaRelation extends NodeAction {


			NewMetaRelation(PInputEvent event) {
				super("New Relation", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> presentationModel.newMetaRelation(thisCanvas(), getModel()));
			}
		}

		final class NewMetaProperty extends NodeAction {


			NewMetaProperty(PInputEvent event) {
				super("New Property", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.newMetaProperty(thisCanvas(), metaProperty -> {
						getModel().addProperties(metaProperty);
						STAppEvents.postNewMetaProperty(metaProperty);
					});
				});
			}
		}

		final class NewInstance extends NodeAction {


			NewInstance(PInputEvent event) {
				super("New Instance", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> presentationModel.newDomainEntity(getModel()));
			}
		}

		final class ExpandAction extends NodeAction {


			ExpandAction(PInputEvent event) {
				super("Expand", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					getModel().getProperties().forEach(STAppEvents::postOpenMetaProperty);
					getModel().getRelations().forEach(STAppEvents::postOpenMetaRelation);
				});
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete entity ?")
					.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
						close();
						thisCanvas().presentationModel.metaDb.remove(getModel());
					}));
			}
		}

	}

	private void addMetaEntityNode(nextgen.domains.meta.MetaEntity model) {
		addNode(model.getUuid(), newMetaEntityNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.MetaEntityNode> newMetaEntityNode(nextgen.domains.meta.MetaEntity model) {
		return () -> new STModelCanvas.MetaEntityNode(model);
	}

	public Stream<MetaEntityNode> getAllMetaEntityNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof MetaEntityNode)
					.map(baseCanvasNode -> (MetaEntityNode) baseCanvasNode);
	}

	public void forEachMetaEntityNode(java.util.function.Consumer<MetaEntityNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof MetaEntityNode)
				.map(baseCanvasNode -> (MetaEntityNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<MetaEntityNode> isInstanceOfMetaEntityNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof MetaEntityNode) ? (MetaEntityNode) canvasNode : null);
	}

	final class MetaRelationNode extends BaseCanvasNode<nextgen.domains.meta.MetaRelation> {


		public MetaRelationNode(nextgen.domains.meta.MetaRelation model) {
			super(model, model.getUuid(), model.getName());
		}

		@Override
		public void addedToCanvas() {
			thisCanvas().forEachMetaPropertyNode(metaPropertyNode -> getModel().getProperties()
					.filter(metaProperty -> metaProperty.getUuid().equals(metaPropertyNode.getUuid()))
					.forEach(metaEntity -> addMetaRelationPropertyRelation(thisNode(), metaPropertyNode)));

			thisCanvas().forEachMetaEntityNode(metaEntityNode -> {

				metaEntityNode.getModel().getRelations()
							.filter(metaRelation -> metaRelation.equals(getModel()))
							.forEach(metaRelation -> addMetaEntitySrcRelation(metaEntityNode, thisNode()));

				getModel().getDst()
							.filter(dstEntity -> dstEntity.equals(metaEntityNode.getModel()))
							.forEach(dstEntity -> addMetaEntityDstRelation(thisNode(), metaEntityNode));
			});
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			getModel().getProperties()
					.filter(metaProperty -> metaProperty.getUuid().equals(node.getUuid()))
					.forEach(metaEntity -> addMetaRelationPropertyRelation(thisNode(), node));

			presentationModel.isInstanceOf(node, MetaEntityNode.class)
					.ifPresent(metaEntityNode -> {
							metaEntityNode.getModel().getRelations()
									.filter(metaRelation -> metaRelation.equals(getModel()))
									.forEach(metaRelation -> addMetaEntitySrcRelation(metaEntityNode, thisNode()));

							getModel().getDst()
									.filter(dstEntity -> dstEntity.equals(metaEntityNode.getModel()))
									.forEach(dstEntity -> addMetaEntityDstRelation(thisNode(), metaEntityNode));
					});
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new Edit(event));
			pop.add(new NewMetaProperty(event));
			pop.add(new AddDstAction(event));
			pop.add(new Delete(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new ExpandAction(event).actionPerformed(null);
					break;

				case VK_D:
					new Delete(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class Edit extends NodeAction {


			Edit(PInputEvent event) {
				super("Edit", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), getModel().getName(), s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
						getModel().setName(s);
						thisNode().setText(getModel().getName());
					}));
				});
			}
		}

		final class NewMetaProperty extends NodeAction {


			NewMetaProperty(PInputEvent event) {
				super("New Property", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.newMetaProperty(thisCanvas(), metaProperty -> {
						getModel().addProperties(metaProperty);
						STAppEvents.postNewMetaProperty(metaProperty);
					});
				});
			}
		}

		final class AddDstAction extends NodeAction {


			AddDstAction(PInputEvent event) {
				super("Add Entity", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), "", s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.metaDb.newMetaEntity(getModel(), s);
				}));
			}
		}

		final class ExpandAction extends NodeAction {


			ExpandAction(PInputEvent event) {
				super("Expand", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					getModel().getProperties().forEach(STAppEvents::postOpenMetaProperty);
					getModel().getDst().forEach(STAppEvents::postNewMetaEntity);
				});
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete relation ?")
					.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
						close();
						thisCanvas().presentationModel.metaDb.remove(getModel());
					}));
			}
		}

	}

	private void addMetaRelationNode(nextgen.domains.meta.MetaRelation model) {
		addNode(model.getUuid(), newMetaRelationNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.MetaRelationNode> newMetaRelationNode(nextgen.domains.meta.MetaRelation model) {
		return () -> new STModelCanvas.MetaRelationNode(model);
	}

	public Stream<MetaRelationNode> getAllMetaRelationNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof MetaRelationNode)
					.map(baseCanvasNode -> (MetaRelationNode) baseCanvasNode);
	}

	public void forEachMetaRelationNode(java.util.function.Consumer<MetaRelationNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof MetaRelationNode)
				.map(baseCanvasNode -> (MetaRelationNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<MetaRelationNode> isInstanceOfMetaRelationNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof MetaRelationNode) ? (MetaRelationNode) canvasNode : null);
	}

	final class MetaPropertyNode extends BaseCanvasNode<nextgen.domains.meta.MetaProperty> {


		public MetaPropertyNode(nextgen.domains.meta.MetaProperty model) {
			super(model, model.getUuid(), model.getName());
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new Delete(event));
			pop.add(new Edit(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_D:
					new Delete(event).actionPerformed(null);
					break;

				case VK_E:
					new Edit(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete property ?")
					.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
						close();
						thisCanvas().presentationModel.metaDb.remove(getModel());
					}));
			}
		}

		final class Edit extends NodeAction {


			Edit(PInputEvent event) {
				super("Edit", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.edit(thisCanvas(), getModel(), metaProperty -> setText(metaProperty.getName()));
				});
			}
		}

	}

	private void addMetaPropertyNode(nextgen.domains.meta.MetaProperty model) {
		addNode(model.getUuid(), newMetaPropertyNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.MetaPropertyNode> newMetaPropertyNode(nextgen.domains.meta.MetaProperty model) {
		return () -> new STModelCanvas.MetaPropertyNode(model);
	}

	public Stream<MetaPropertyNode> getAllMetaPropertyNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof MetaPropertyNode)
					.map(baseCanvasNode -> (MetaPropertyNode) baseCanvasNode);
	}

	public void forEachMetaPropertyNode(java.util.function.Consumer<MetaPropertyNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof MetaPropertyNode)
				.map(baseCanvasNode -> (MetaPropertyNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<MetaPropertyNode> isInstanceOfMetaPropertyNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof MetaPropertyNode) ? (MetaPropertyNode) canvasNode : null);
	}

	final class MetaDomainNode extends BaseCanvasNode<nextgen.domains.meta.MetaDomain> {


		public MetaDomainNode(nextgen.domains.meta.MetaDomain model) {
			super(model, model.getUuid(), model.getName());
		}

		@Override
		public void addedToCanvas() {
			getAllMetaEntityNode()
					.filter(metaEntityNode -> getModel().getRoots().anyMatch(metaEntity -> metaEntity.getUuid().equals(metaEntity.getUuid())))
					.forEach(metaEntityNode -> addMetaDomainEntityRelation(thisNode(), metaEntityNode));
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			getModel().getRoots()
					.filter(metaEntity -> metaEntity.getUuid().equals(node.getUuid()))
					.forEach(metaEntity -> addMetaDomainEntityRelation(thisNode(), node));

			getModel().getVisitors()
					.filter(domainVisitor -> domainVisitor.getUuid().equals(node.getUuid()))
					.forEach(domainVisitor -> addDomainVisitorRelation(thisNode(), node));
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new NewEntityAction(event));
			pop.add(new AddVisitor(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new ExpandAction(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class NewEntityAction extends NodeAction {


			NewEntityAction(PInputEvent event) {
				super("New Entity", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), "", s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.metaDb.newMetaEntity(getModel(), s);
				}));
			}
		}

		final class ExpandAction extends NodeAction {


			ExpandAction(PInputEvent event) {
				super("Expand", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					getModel().getRoots().forEach(STAppEvents::postOpenMetaEntity);
					getModel().getVisitors().forEach(STAppEvents::postOpenDomainVisitor);
				});
			}
		}

		final class AddVisitor extends NodeAction {


			AddVisitor(PInputEvent event) {
				super("Add Visitor", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), getModel().getName(), s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							presentationModel.newDomainVisitor(getModel(), s);
						}));
				});
			}
		}

	}

	private void addMetaDomainNode(nextgen.domains.meta.MetaDomain model) {
		addNode(model.getUuid(), newMetaDomainNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.MetaDomainNode> newMetaDomainNode(nextgen.domains.meta.MetaDomain model) {
		return () -> new STModelCanvas.MetaDomainNode(model);
	}

	public Stream<MetaDomainNode> getAllMetaDomainNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof MetaDomainNode)
					.map(baseCanvasNode -> (MetaDomainNode) baseCanvasNode);
	}

	public void forEachMetaDomainNode(java.util.function.Consumer<MetaDomainNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof MetaDomainNode)
				.map(baseCanvasNode -> (MetaDomainNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<MetaDomainNode> isInstanceOfMetaDomainNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof MetaDomainNode) ? (MetaDomainNode) canvasNode : null);
	}

	final class DomainEntityNode extends BaseCanvasNode<nextgen.domains.meta.DomainEntity> {


		public DomainEntityNode(nextgen.domains.meta.DomainEntity model) {
			super(model, model.getUuid(), presentationModel.render(model));
		}

		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			isInstanceOfDomainEntityNode(node)
					.ifPresent(domainEntityNode -> {
						final org.neo4j.graphdb.Node endNode = ((DomainEntityNode) node).getModel().getNode();
						getModel().getNode()
								.getRelationships(org.neo4j.graphdb.Direction.OUTGOING)
								.forEach(relationship -> {
									if (relationship.getEndNode().equals(endNode))
										addDomainRelation(thisNode(), node, relationship);
								});
					});
		}

		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			presentationModel.doInTransaction(transaction -> {

				final JMenu runMenu = new JMenu("Run");
				getModel().get_meta().getIncomingRootsMetaDomain().forEach(metaDomain -> metaDomain.getVisitors().forEach(domainVisitor -> runMenu.add(new RunAction(event, getModel(), domainVisitor))));
				if (runMenu.getMenuComponentCount() != 0) pop.add(runMenu);

				getModel().get_meta().getRelations().forEach(metaRelation -> metaRelation.getDst().forEach(dst -> pop.add(new AddRelationAction(event, metaRelation, dst))));
				getModel().get_meta().getProperties().forEach(metaProperty -> pop.add(new SetPropertyAction(event, metaProperty)));
			});
			pop.add(new Expand(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeLeftClick(PInputEvent event) {
			super.onNodeLeftClick(event);
			presentationModel.doLaterInTransaction(tx -> setText(presentationModel.render(getModel())));
		}


		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new Expand(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class SetPropertyAction extends NodeAction {

			private nextgen.domains.meta.MetaProperty metaProperty;

			SetPropertyAction(PInputEvent event, nextgen.domains.meta.MetaProperty metaProperty) {
				super("Set " + metaProperty.getName(), event);
				this.metaProperty = metaProperty;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.setEntityProperty(thisCanvas(), getModel(), metaProperty, value -> {
						getModel().getNode().setProperty(metaProperty.getName(), value);
						setText(presentationModel.render(getModel()));
					});
				});
			}
		}

		final class AddRelationAction extends NodeAction {

			private nextgen.domains.meta.MetaRelation metaRelation;
			private nextgen.domains.meta.MetaEntity metaEntity;

			AddRelationAction(PInputEvent event, nextgen.domains.meta.MetaRelation metaRelation, nextgen.domains.meta.MetaEntity metaEntity) {
				super("Add " + metaRelation.getName(), event);
				this.metaRelation = metaRelation;
				this.metaEntity = metaEntity;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> presentationModel.addEntityRelation(getModel(), metaRelation, metaEntity));
			}
		}

		final class RunAction extends NodeAction {

			private nextgen.domains.meta.DomainEntity domainEntity;
			private nextgen.domains.meta.DomainVisitor domainVisitor;

			RunAction(PInputEvent event, nextgen.domains.meta.DomainEntity domainEntity, nextgen.domains.meta.DomainVisitor domainVisitor) {
				super("Run " + domainVisitor.getName(), event);
				this.domainEntity = domainEntity;
				this.domainVisitor = domainVisitor;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.runVisitor(thisCanvas(), domainEntity, domainVisitor);
			}
		}

		final class Expand extends NodeAction {


			Expand(PInputEvent event) {
				super("Expand", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					getModel().get_meta().getRelations().forEach(metaRelation -> metaRelation.getDst().forEach(dst -> {
						getModel().getNode().getRelationships(org.neo4j.graphdb.RelationshipType.withName(metaRelation.getName())).forEach(relationship -> addDomainEntityNode(new nextgen.domains.meta.DomainEntity(relationship.getEndNode())));
					}));
				});
			}
		}

	}

	private void addDomainEntityNode(nextgen.domains.meta.DomainEntity model) {
		addNode(model.getUuid(), newDomainEntityNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.DomainEntityNode> newDomainEntityNode(nextgen.domains.meta.DomainEntity model) {
		return () -> new STModelCanvas.DomainEntityNode(model);
	}

	public Stream<DomainEntityNode> getAllDomainEntityNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof DomainEntityNode)
					.map(baseCanvasNode -> (DomainEntityNode) baseCanvasNode);
	}

	public void forEachDomainEntityNode(java.util.function.Consumer<DomainEntityNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof DomainEntityNode)
				.map(baseCanvasNode -> (DomainEntityNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<DomainEntityNode> isInstanceOfDomainEntityNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof DomainEntityNode) ? (DomainEntityNode) canvasNode : null);
	}

	final class DomainVisitorNode extends BaseCanvasNode<nextgen.domains.meta.DomainVisitor> {


		public DomainVisitorNode(nextgen.domains.meta.DomainVisitor model) {
			super(model, model.getUuid(), model.getName());
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			pop.add(new EditAction(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new EditAction(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class EditAction extends NodeAction {


			EditAction(PInputEvent event) {
				super("Edit", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.edit(getModel());
				});
			}
		}

	}

	private void addDomainVisitorNode(nextgen.domains.meta.DomainVisitor model) {
		addNode(model.getUuid(), newDomainVisitorNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.DomainVisitorNode> newDomainVisitorNode(nextgen.domains.meta.DomainVisitor model) {
		return () -> new STModelCanvas.DomainVisitorNode(model);
	}

	public Stream<DomainVisitorNode> getAllDomainVisitorNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof DomainVisitorNode)
					.map(baseCanvasNode -> (DomainVisitorNode) baseCanvasNode);
	}

	public void forEachDomainVisitorNode(java.util.function.Consumer<DomainVisitorNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof DomainVisitorNode)
				.map(baseCanvasNode -> (DomainVisitorNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<DomainVisitorNode> isInstanceOfDomainVisitorNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof DomainVisitorNode) ? (DomainVisitorNode) canvasNode : null);
	}

	final class ProjectNode extends BaseCanvasNode<nextgen.st.model.Project> {


		public ProjectNode(nextgen.st.model.Project model) {
			super(model, model.getUuid(), model.getName());
		}
		@Override
		protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
			super.onNodeRightClick(event, pop);
		}


	}

	private void addProjectNode(nextgen.st.model.Project model) {
		addNode(model.getUuid(), newProjectNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.ProjectNode> newProjectNode(nextgen.st.model.Project model) {
		return () -> new STModelCanvas.ProjectNode(model);
	}

	public Stream<ProjectNode> getAllProjectNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof ProjectNode)
					.map(baseCanvasNode -> (ProjectNode) baseCanvasNode);
	}

	public void forEachProjectNode(java.util.function.Consumer<ProjectNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof ProjectNode)
				.map(baseCanvasNode -> (ProjectNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<ProjectNode> isInstanceOfProjectNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof ProjectNode) ? (ProjectNode) canvasNode : null);
	}

	final class ScriptNode extends BaseCanvasNode<nextgen.st.model.Script> {


		public ScriptNode(nextgen.st.model.Script model) {
			super(model, model.getUuid(), model.getName());
		}

		@Override
		public void addedToCanvas() {
			if (getModel().getScript() == null) return;
			thisCanvas().getAllNodes().filter(stNode -> stNode instanceof STValueNode)
					.map(stNode -> (STValueNode) stNode)
					.filter(stValueNode -> stValueNode.getUuid().toString().equals(getModel().getScript().getUuid()))
					.findFirst()
					.ifPresent(stValueNode -> {
							thisCanvas().addRelation(getModel().getUuid(), () -> new ScriptRelation(ScriptNode.this, stValueNode));
					});
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			if (getModel().getScript() == null || !getUuid().toString().equals(getModel().getScript().getUuid()))
				return;
			thisCanvas().addRelation(getModel().getUuid(), () -> new ScriptRelation(ScriptNode.this, node));
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
			presentationModel.doInTransaction(tx -> {
					stModelNodes.forEach(stNode -> pop.add(new SetScriptModelAction(event, stNode)));
					stValueNodes.forEach(stNode -> pop.add(new SetScriptValueAction(event, stNode)));
				});
			pop.add(new OpenScript(event));
			pop.add(new Run(event));
			pop.add(new SetName(event));
			pop.add(new Delete(event));
			super.onNodeRightClick(event, pop);
		}

		@Override
		protected void onNodeKeyPressed(PInputEvent event) {
			switch (event.getKeyCode()) {
				case VK_E:
					new OpenScript(event).actionPerformed(null);
					break;

			}
			super.onNodeKeyPressed(event);
		}


		final class OpenScript extends NodeAction {


			OpenScript(PInputEvent event) {
				super("Open Script", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doInTransaction(transaction -> {
						final nextgen.st.model.STValue stValue = getModel().getScript();
						if (stValue == null) return;
						thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
					});
			}
		}

		final class Run extends NodeAction {


			Run(PInputEvent event) {
				super("Run", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
						try {

								final nextgen.st.STAppPresentationModel.CompilationResult compilationResult = thisCanvas().presentationModel.generateScriptCode(getModel());

								if (compilationResult.aClass == null) {
									JOptionPane.showMessageDialog(thisCanvas(), compilationResult.compilerOutput, "Compilation Exception", JOptionPane.ERROR_MESSAGE);
									return;
								}

								((Runnable) compilationResult.aClass
										.getConstructor(nextgen.st.model.STModelDB.class, nextgen.st.STRenderer.class)
										.newInstance(thisCanvas().presentationModel.db, thisCanvas().presentationModel.stRenderer))
										.run();

							} catch (Throwable ex) {
									nextgen.utils.SwingUtil.showException(thisCanvas(), ex);
							}
						});
			}
		}

		final class SetName extends NodeAction {


			SetName(PInputEvent event) {
				super("Set Name", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doInTransaction(transaction -> {
					nextgen.utils.SwingUtil.showInputDialog("Name", thisCanvas(), getModel().getName(), s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							getModel().setName(s);
							setText(getModel().getName());
						}));
					});
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				if (!nextgen.utils.SwingUtil.showConfirmDialog(thisCanvas(), "Delete script ?")) return;
						thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							close();
							thisCanvas().presentationModel.db.remove(getModel());
						});
			}
		}

		final class SetScriptValueAction extends NodeAction {

			private STValueNode model;

			SetScriptValueAction(PInputEvent event, STValueNode model) {
				super("Set Script to " + presentationModel.cut(model.getText()), event);
				this.model = model;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
						getModel().setScript(model.getModel());
						thisCanvas().removeRelation(getUuid());
						thisCanvas().addRelation(getUuid(), () -> new ScriptRelation(thisNode(), model));
					});
			}
		}

		final class SetScriptModelAction extends NodeAction {

			private STModelNode stModelNode;

			SetScriptModelAction(PInputEvent event, STModelNode stModelNode) {
				super("Set Script to " + presentationModel.cut(stModelNode.getText()), event);
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> {
						final nextgen.st.model.STValue dst = thisCanvas().presentationModel.newSTValue(stModelNode.getModel());
						getModel().setScript(dst);
						thisCanvas().removeRelation(getUuid());
						final STValueNode stValueNode = thisCanvas().addNode(dst.getUuid(), () -> new STValueNode(dst));
						thisCanvas().addRelation(getUuid(), () -> new ScriptRelation(thisNode(), stValueNode));
					});
			}
		}

	}

	private void addScriptNode(nextgen.st.model.Script model) {
		addNode(model.getUuid(), newScriptNode(model));
	}

	public java.util.function.Supplier<STModelCanvas.ScriptNode> newScriptNode(nextgen.st.model.Script model) {
		return () -> new STModelCanvas.ScriptNode(model);
	}

	public Stream<ScriptNode> getAllScriptNode() {
		return getAllNodes()
					.filter(baseCanvasNode -> baseCanvasNode instanceof ScriptNode)
					.map(baseCanvasNode -> (ScriptNode) baseCanvasNode);
	}

	public void forEachScriptNode(java.util.function.Consumer<ScriptNode> consumer) {
		getAllNodes()
				.filter(baseCanvasNode -> baseCanvasNode instanceof ScriptNode)
				.map(baseCanvasNode -> (ScriptNode) baseCanvasNode)
				.forEach(consumer);
	}

	public Optional<ScriptNode> isInstanceOfScriptNode(BaseCanvasNode<?> canvasNode) {
		return Optional.ofNullable((canvasNode instanceof ScriptNode) ? (ScriptNode) canvasNode : null);
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
			presentationModel.doInTransaction(tx -> {
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
			thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					if (getModel() == null || getModel().getPath() == null) return;
					nextgen.st.STGenerator.writeToFile(thisCanvas().presentationModel.render(stModel), getModel().getPackageName().getValue(), getModel().getName().getValue(), getModel().getType().getValue(), new java.io.File(getModel().getPath().getValue()));
				});
		}


		final class EditFileSink extends NodeAction {


			EditFileSink(PInputEvent event) {
				super("Edit File Sink", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doInTransaction(tx -> {
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
									thisCanvas().presentationModel.doLaterInTransaction(tx -> {

										if (getModel().getName() == null || (getModel().getName().getValue() == null || !getModel().getName().getValue().equals(name)))
											getModel().setName(thisCanvas().presentationModel.newSTValue(name));

										if (getModel().getType() == null || (getModel().getType().getValue() == null || !getModel().getType().getValue().equals(type)))
											getModel().setType(thisCanvas().presentationModel.newSTValue(type));

										if (getModel().getPath() == null || (getModel().getPath().getValue() == null || !getModel().getPath().getValue().equals(path)))
											getModel().setPath(thisCanvas().presentationModel.newSTValue(path));

										if (getModel().getPackageName() == null || (getModel().getPackageName().getValue() == null || !getModel().getPackageName().getValue().equals(packageName)))
											getModel().setPackageName(thisCanvas().presentationModel.newSTValue(packageName));

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
				presentationModel.doLaterInTransaction(tx -> {
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
				presentationModel.doLaterInTransaction(tx -> {
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
				presentationModel.doLaterInTransaction(transaction -> {
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
				presentationModel.doLaterInTransaction(transaction -> {
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
				presentationModel.doLaterInTransaction(transaction -> {
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
				presentationModel.doLaterInTransaction(transaction -> {
						getModel().setPackageName(model);
						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());
					});
			}
		}

	}

	private void addSTFileNode(nextgen.st.model.STFile model, nextgen.st.model.STModel stModel) {
		addNode(model.getUuid(), newSTFileNode(model, stModel));
	}

	public java.util.function.Supplier<STModelCanvas.STFileNode> newSTFileNode(nextgen.st.model.STFile model, nextgen.st.model.STModel stModel) {
		return () -> new STModelCanvas.STFileNode(model, stModel);
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
			presentationModel.doInTransaction(tx -> {
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
				presentationModel.doLaterInTransaction(tx -> {
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
							thisCanvas().presentationModel.doLaterInTransaction(tx -> {
								final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.db.newSTValue(s);
								presentationModel.removeArgument(getModel(), stParameterKey);
								final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
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
				super(presentationModel.cut(stValueNode.getText(), 30), event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							presentationModel.removeArgument(getModel(), stParameterKey);
							final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().presentationModel.db.newSTArgumentKV(stParameterKey, stValueNode.getModel());
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
				super(presentationModel.cut(stModelNode.getText(), 30), event);
				this.stParameterKey = stParameterKey;
				this.stArgument = stArgument;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
							presentationModel.removeArgument(getModel(), stParameterKey);
							final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.db.newSTValue(stModelNode.getModel());
							final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
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
				super(presentationModel.cut(thisCanvas().presentationModel.render(stArgument.getValue())), event);
				this.stArgument = stArgument;
				this.stParameterKey = stParameterKey;
				this.stArgumentKV = stArgumentKV;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
							final nextgen.st.model.STValue stValue = stArgumentKV.getValue();
							switch (stValue.getType()) {
								case STMODEL:
									thisCanvas().addNode(stValue.getStModel().getUuid(), () -> new STModelNode(stValue.getStModel(), presentationModel.findSTTemplateByUuid(stValue.getStModel().getStTemplate())));
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
				super(presentationModel.cut(thisCanvas().presentationModel.render(stArgument.getValue())), event);
				this.stArgument = stArgument;
				this.stArgumentKV = stArgumentKV;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
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
				presentationModel.doLaterInTransaction(tx -> {
						final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
						presentationModel.removeArgument(getModel(), stParameterKey);
						final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
						stArgument.addKeyValues(stArgumentKV);
						thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameterKey, stArgumentKV));
					});
			}
		}

	}

	private void addSTKVNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
		addNode(model.getUuid(), newSTKVNode(model, stParameter));
	}

	public java.util.function.Supplier<STModelCanvas.STKVNode> newSTKVNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
		return () -> new STModelCanvas.STKVNode(model, stParameter);
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
			super(model, model.getUuid(), stTemplate.getName() + " :\n" + presentationModel.render(model));
			this.stTemplate = stTemplate;
		}

		@Override
		public void addedToCanvas() {
			thisCanvas().getAllNodes().forEach(this::newNodeAdded);
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			presentationModel.forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {
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
			thisCanvas().presentationModel.doInTransaction(tx -> {

				final String clipboardValue = presentationModel.cut(nextgen.utils.SwingUtil.fromClipboard());
				
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
							addstParameterMenu.add(new SetInputValueArgumentAction(event, stParameter));
							addstParameterMenu.add(new SetBooleanValue(event, stParameter));
							addstParameterMenu.add(new SetClipboardValueArgumentAction(event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);

							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(event, stParameter, stArgument));
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
							addstParameterMenu.add(new AddInputValueArgumentAction(event, stParameter));
							addstParameterMenu.add(new AddClipboardValueArgumentAction(event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf(event, stParameter));

							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(event, stParameter, stArgument));
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
								openstParameterMenu.add(new OpenArgument(event, stParameter, stArgument));
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
			presentationModel.doLaterInTransaction(tx -> setText(stTemplate.getName() + " : \n" + presentationModel.render(getModel())));
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
				presentationModel.writeToFile(getModel());
			}
		}

		final class OpenIncoming extends NodeAction {


			OpenIncoming(PInputEvent event) {
				super("Open Incoming", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(transaction -> {

					thisCanvas().presentationModel.getIncomingSTArguments(getModel())
								.forEach(stArgument -> {
									stArgument.getIncomingArguments().forEach(stModel -> {
											final nextgen.st.domain.STTemplate stTemplateByUuid = thisCanvas().presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
											if (stTemplateByUuid == null) return;
											stTemplateByUuid.getParameters()
													.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
													.findFirst()
													.ifPresent(stParameter -> {
															final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, presentationModel.findSTTemplateByUuid(stModel.getStTemplate())));
															thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));
													});
									});
								});

					thisCanvas().presentationModel.getIncomingSTArgumentKVs(getModel())
								.forEach(stArgumentKV -> {
									stArgumentKV.getIncomingKeyValues().forEach(stArgument -> {
											stArgument.getIncomingArguments().forEach(stModel -> {
												final nextgen.st.domain.STTemplate stTemplateByUuid = thisCanvas().presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
												if (stTemplateByUuid == null) return;
												stTemplateByUuid.getParameters()
															.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
															.findFirst()
															.ifPresent(stParameter -> stParameter.getKeys()
																	.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
																	.findFirst()
																	.ifPresent(stParameterKey -> {
																			final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, presentationModel.findSTTemplateByUuid(stModel.getStTemplate())));
																			final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));
																			thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));
																			thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));
																	}));
											});
									});
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
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> new OpenArgument(event, stParameter, stArgument).actionPerformed(null));
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
				presentationModel.doLaterInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(thisCanvas().presentationModel.render(getModel())));
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete model ?")
						.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							close();
							thisCanvas().presentationModel.db.remove(getModel());
						}));
			}
		}

		final class Clone extends NodeAction {


			Clone(PInputEvent event) {
				super("Clone", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> thisCanvas().addNode(new STModelNode(thisCanvas().presentationModel.db.clone(getModel()), stTemplate)));
			}
		}

		final class AddFileSink extends NodeAction {


			AddFileSink(PInputEvent event) {
				super("Add File Sink", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {

					final java.util.concurrent.atomic.AtomicInteger typeIndex = new java.util.concurrent.atomic.AtomicInteger(0);
					final String[] fileTypes = new String[]{"html", "java", "js", "xml"};

					final java.util.concurrent.atomic.AtomicInteger pathIndex = new java.util.concurrent.atomic.AtomicInteger(0);
					final String[] pathTypes = thisCanvas().presentationModel.db.findAllSTFile()
								.filter(stFile -> stFile.getPath() != null)
								.filter(stFile -> stFile.getPath().getValue() != null)
								.map(stFile -> stFile.getPath().getValue())
								.distinct()
								.toArray(String[]::new);

					final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
					fieldMap.put("name", SwingUtil.newTextField(thisCanvas().presentationModel.getSTModelName(getModel(), ""), 15));
					fieldMap.put("type", SwingUtil.newTextField(15));
					fieldMap.put("path", SwingUtil.newTextField(15));
					fieldMap.put("package", SwingUtil.newTextField(thisCanvas().presentationModel.getSTModelPackage(getModel(), ""), 15));
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
								thisCanvas().presentationModel.doLaterInTransaction(tx -> {
									final nextgen.st.model.STFile stFile = thisCanvas().presentationModel.newSTFile(name, type, path, packageName);
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
				thisCanvas().presentationModel.doLaterInTransaction(tx ->
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
				super(presentationModel.cut(stValueNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
					if (presentationModel.sameArgumentValue(getModel(), stParameter, stValueNode.getModel())) return;
					presentationModel.removeArgument(getModel(), stParameter);
					final nextgen.st.model.STArgument stArgument = presentationModel.newSTArgument(stParameter, stValueNode.getModel());
					getModel().addArguments(stArgument);
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
					setText(presentationModel.render(getModel()));
				});
			}
		}

		final class SetSTModelArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			SetSTModelArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super(presentationModel.cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.newSTValue(stModelNode.getModel());
					final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stModelNode, stArgument, stParameter));
					setText(thisCanvas().presentationModel.render(getModel()));
				});
			}
		}

		final class SetToSameAsArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			SetToSameAsArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super("Same as " + presentationModel.cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doInTransaction(transaction -> stModelNode.getModel().getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.filter(stArgument -> stArgument.getValue() != null)
						.findFirst()
						.ifPresent(sourceArgument -> {
								presentationModel.removeArgument(getModel(), stParameter);
								final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, sourceArgument.getValue());
								getModel().addArguments(stArgument);
								final STValueNode stValueNode = thisCanvas().addNode(sourceArgument.getValue().getUuid(), () -> new STValueNode(sourceArgument.getValue()));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
								setText(thisCanvas().presentationModel.render(getModel()));
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
					thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							final nextgen.st.model.STValue stValue = presentationModel.newSTValue(s);
							presentationModel.removeArgument(getModel(), stParameter);
							final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
							getModel().addArguments(stArgument);
							final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
							thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
							setText(thisCanvas().presentationModel.render(getModel()));
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
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.db.newSTValue("true");
					final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.db.newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					setText(thisCanvas().presentationModel.render(getModel()));
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
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					presentationModel.removeArgument(getModel(), stParameter);
					final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameter));
					setText(thisCanvas().presentationModel.render(getModel()));
				});
			}
		}

		final class OpenArgument extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private nextgen.st.model.STArgument stArgument;

			OpenArgument(PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
				super(presentationModel.cut(presentationModel.render(stArgument), 30), event);
				this.stParameter = stParameter;
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(tx -> {
					if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {
						thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter)), stArgument, stParameter));
					} else {
						final nextgen.st.model.STValue stValue = stArgument.getValue();
						switch (stValue.getType()) {
							case STMODEL: {
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getStModel().getUuid(), () -> new STModelNode(stValue.getStModel(), presentationModel.findSTTemplateByUuid(stValue.getStModel().getStTemplate()))), stArgument, stParameter));
								break;
							}
							case PRIMITIVE: {
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameter));
								break;
							}
							case ENUM: {
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameter));
								break;
							}
						}
					}
					new LayoutTreeAction(thisNode(), event).actionPerformed(null);
				});
			}
		}

		final class RemoveArgument extends NodeAction {

			private nextgen.st.model.STArgument stArgument;

			RemoveArgument(PInputEvent event, nextgen.st.model.STArgument stArgument) {
				super(presentationModel.cut(presentationModel.render(stArgument), 30), event);
				this.stArgument = stArgument;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Remove argument ?")
						.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							thisCanvas().removeRelation(stArgument.getUuid());
							getModel().removeArguments(stArgument);
							setText(thisCanvas().presentationModel.render(getModel()));
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
				presentationModel.doLaterInTransaction(tx -> {
						presentationModel.forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {
								if (this.stParameter.equals(stParameter))
									new OpenArgument(event, stParameter, stArgument).actionPerformed(null);
						});
						new LayoutTreeAction(thisNode(), event).actionPerformed(null);
					});
			}
		}

		final class AddSTValueArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STValueNode stValueNode;

			AddSTValueArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STValueNode stValueNode) {
				super(presentationModel.cut(stValueNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stValueNode = stValueNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
						final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValueNode.getModel());
						getModel().addArguments(stArgument);
						thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
						setText(thisCanvas().presentationModel.render(getModel()));
					});
			}
		}

		final class AddSTModelArgumentAction extends NodeAction {

			private nextgen.st.domain.STParameter stParameter;
			private STModelNode stModelNode;

			AddSTModelArgumentAction(PInputEvent event, nextgen.st.domain.STParameter stParameter, STModelNode stModelNode) {
				super(presentationModel.cut(stModelNode.getText(), 30), event);
				this.stParameter = stParameter;
				this.stModelNode = stModelNode;
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(tx -> {
						final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.newSTValue(stModelNode.getModel());
						final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
						getModel().addArguments(stArgument);
						thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stModelNode, stArgument, stParameter));
						setText(thisCanvas().presentationModel.render(getModel()));
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
						presentationModel.doLaterInTransaction(tx -> {
								final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.newSTValue(s.trim());
								final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
								getModel().addArguments(stArgument);
								final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
								setText(thisCanvas().presentationModel.render(getModel()));
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
				presentationModel.doLaterInTransaction(tx -> {
					final nextgen.st.model.STValue stValue = thisCanvas().presentationModel.newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = thisCanvas().presentationModel.newSTArgument(stParameter, stValue);
					getModel().addArguments(stArgument);
					final STValueNode stValueNode = thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));
					thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stValueNode, stArgument, stParameter));
					setText(thisCanvas().presentationModel.render(getModel()));
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
				presentationModel.doLaterInTransaction(tx -> {
						presentationModel.addKVArgument(getModel(), stParameter, thisCanvas(), stArgument -> {
								final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));
								thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(thisNode(), stkvNode, stArgument, stParameter));
								setText(thisCanvas().presentationModel.render(getModel()));
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
				presentationModel.doLaterInTransaction(transaction -> presentationModel.setMultiple(thisCanvas(), getModel(), stTemplate, stModel -> {
					setText(presentationModel.render(getModel()));
				}));
			}
		}

		final class OpenTemplate extends NodeAction {


			OpenTemplate(PInputEvent event) {
				super("Open Template", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				presentationModel.doLaterInTransaction(transaction -> nextgen.st.STAppEvents.postOpenSTTemplate(stTemplate));
			}
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

	public java.util.function.Supplier<STModelCanvas.STModelNode> newSTModelNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate) {
		return () -> new STModelCanvas.STModelNode(model, stTemplate);
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
			super(model, model.getUuid(), presentationModel.render(model));
		}

		@Override
		public void addedToCanvas() {
			presentationModel.getSTModel(getModel())
					.filter(stModel -> thisCanvas().getNode(stModel.getUuid()) != null)
					.map(stModel -> (STModelNode) thisCanvas().getNode(stModel.getUuid()))
					.ifPresent(stModelNode -> thisCanvas().addRelation(stModelNode.getUuid(), () -> new STValueModelRelation(STValueNode.this, stModelNode)));
		}


		@Override
		public void newNodeAdded(BaseCanvasNode<?> node) {
			presentationModel.getSTModel(getModel())
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
				nextgen.utils.SwingUtil.showInputDialog("Edit", thisCanvas(), thisCanvas().presentationModel.db.get(() -> getModel().getValue()), s -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
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
				presentationModel.doInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(presentationModel.render(getModel())));
			}
		}

		final class Delete extends NodeAction {


			Delete(PInputEvent event) {
				super("Delete", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete value ?")
						.ifPresent(confirm -> thisCanvas().presentationModel.doLaterInTransaction(tx -> {
							close();
							presentationModel.db.remove(getModel());
						}));
			}
		}

		final class OpenIncoming extends NodeAction {


			OpenIncoming(PInputEvent event) {
				super("Open Incoming", event);
			}

			@Override
			void actionPerformed(PInputEvent event, ActionEvent e) {
				thisCanvas().presentationModel.doLaterInTransaction(transaction -> {

					thisCanvas().presentationModel.getIncomingSTArguments(getModel())
							.forEach(stArgument -> stArgument.getIncomingArguments()
									.forEach(stModel -> {
										final nextgen.st.domain.STTemplate stTemplateByUuid = thisCanvas().presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
										if (stTemplateByUuid == null) return;
										stTemplateByUuid.getParameters()
												.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
												.findFirst()
												.ifPresent(stParameter -> {
													final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, presentationModel.findSTTemplateByUuid(stModel.getStTemplate())));
													thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));
												});
									}));

					thisCanvas().presentationModel.getIncomingSTArgumentKVs(getModel())
							.forEach(stArgumentKV -> {
								stArgumentKV.getIncomingKeyValues()
										.forEach(stArgument -> stArgument.getIncomingArguments().forEach(stModel -> {
											final nextgen.st.domain.STTemplate stTemplateByUuid = thisCanvas().presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
											if (stTemplateByUuid == null) return;
											stTemplateByUuid.getParameters()
													.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))
													.findFirst()
													.ifPresent(stParameter -> stParameter.getKeys()
															.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
															.findFirst()
															.ifPresent(stParameterKey -> {
																final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, presentationModel.findSTTemplateByUuid(stModel.getStTemplate())));
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

	public java.util.function.Supplier<STModelCanvas.STValueNode> newSTValueNode(nextgen.st.model.STValue model) {
		return () -> new STModelCanvas.STValueNode(model);
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

	public java.util.function.Supplier<STModelCanvas.MetaDomainEntityRelation> newMetaDomainEntityRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
		return () -> new STModelCanvas.MetaDomainEntityRelation(src, dst, uuid);
	}

	public void addMetaDomainEntityRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid() + dst.getUuid(), newMetaDomainEntityRelation(src, dst, src.getUuid() + dst.getUuid()));
	}

	final class MetaDomainEntityRelation extends BaseCanvasRelation {


		public MetaDomainEntityRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
			super(src, dst, uuid, "ROOT");
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
				nextgen.utils.SwingUtil.confirm(thisCanvas(), "Delete " + getType() + " ?")
					.ifPresent(confirm -> presentationModel.doLaterInTransaction(tx -> {
						final MetaDomainNode src = (MetaDomainNode) getSrc();
						final MetaEntityNode dst = (MetaEntityNode) getDst();
						removeRelation(getUuid());
						src.getModel().removeRoots(dst.getModel());
					}));
			}
		}
	}

	public java.util.function.Supplier<STModelCanvas.MetaEntityDstRelation> newMetaEntityDstRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.MetaEntityDstRelation(src, dst);
	}

	public void addMetaEntityDstRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid() + dst.getUuid(), newMetaEntityDstRelation(src, dst));
	}

	final class MetaEntityDstRelation extends BaseCanvasRelation {


		public MetaEntityDstRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, src.getUuid() + dst.getUuid(), "DST");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.MetaEntitySrcRelation> newMetaEntitySrcRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.MetaEntitySrcRelation(src, dst);
	}

	public void addMetaEntitySrcRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid()+dst.getUuid(), newMetaEntitySrcRelation(src, dst));
	}

	final class MetaEntitySrcRelation extends BaseCanvasRelation {


		public MetaEntitySrcRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, src.getUuid()+dst.getUuid(), "SRC");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.MetaEntityPropertyRelation> newMetaEntityPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
		return () -> new STModelCanvas.MetaEntityPropertyRelation(src, dst, uuid);
	}

	public void addMetaEntityPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid() + dst.getUuid(), newMetaEntityPropertyRelation(src, dst, src.getUuid() + dst.getUuid()));
	}

	final class MetaEntityPropertyRelation extends BaseCanvasRelation {


		public MetaEntityPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
			super(src, dst, uuid, "Property");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.MetaRelationPropertyRelation> newMetaRelationPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		return () -> new STModelCanvas.MetaRelationPropertyRelation(src, dst);
	}

	public void addMetaRelationPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid() + dst.getUuid(), newMetaRelationPropertyRelation(src, dst));
	}

	final class MetaRelationPropertyRelation extends BaseCanvasRelation {


		public MetaRelationPropertyRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
			super(src, dst, src.getUuid() + dst.getUuid(), "PROPERTY");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.DomainRelation> newDomainRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, org.neo4j.graphdb.Relationship relationship) {
		return () -> new STModelCanvas.DomainRelation(src, dst, relationship);
	}

	public void addDomainRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, org.neo4j.graphdb.Relationship relationship) {
		addRelation(relationship.getProperty("_uuid").toString(), newDomainRelation(src, dst, relationship));
	}

	final class DomainRelation extends BaseCanvasRelation {

		private org.neo4j.graphdb.Relationship relationship;

		public DomainRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, org.neo4j.graphdb.Relationship relationship) {
			super(src, dst, relationship.getProperty("_uuid").toString(), relationship.getType().name());
			this.relationship = relationship;
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
	}

	public java.util.function.Supplier<STModelCanvas.DomainVisitorRelation> newDomainVisitorRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
		return () -> new STModelCanvas.DomainVisitorRelation(src, dst, uuid);
	}

	public void addDomainVisitorRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst) {
		addRelation(src.getUuid() + dst.getUuid(), newDomainVisitorRelation(src, dst, src.getUuid() + dst.getUuid()));
	}

	final class DomainVisitorRelation extends BaseCanvasRelation {


		public DomainVisitorRelation(BaseCanvasNode<?> src, BaseCanvasNode<?> dst, String uuid) {
			super(src, dst, uuid, "VISITOR");
		}

		@Override
		protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {

		}
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
						.ifPresent(confirm -> presentationModel.doLaterInTransaction(tx -> {
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