package nextgen.st.canvas;

import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.event.PInputEventListener;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.awt.event.KeyEvent.*;

public class STCanvas extends PCanvas implements PInputEventListener {

	static boolean debug = true;

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<UUID, STNode> nodeMap = new ConcurrentHashMap<>();
	final Map<UUID, STRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();

	nextgen.st.STRenderer stRenderer;
	nextgen.st.model.STModelDB modelDb;

	public STCanvas(nextgen.st.STRenderer stRenderer,nextgen.st.model.STModelDB modelDb) {
		this(stRenderer, modelDb, Color.WHITE, new Dimension(1024, 1024));
	}

	public STCanvas(nextgen.st.STRenderer stRenderer, nextgen.st.model.STModelDB modelDb, Color background, Dimension preferredSize) {
		super();
		setBackground(background);
		setPreferredSize(preferredSize);
		nodeLayer = getLayer();
		getCamera().addLayer(0, relationLayer);

		removeInputEventListener(getZoomEventHandler());
		addInputEventListener(new CanvasZoomHandler());
		addInputEventListener(canvasInputEventsHandler);
		this.stRenderer = stRenderer;
		this.modelDb = modelDb;

		//org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	@Override
	public void processEvent(PInputEvent pInputEvent, int i) {
		canvasInputEventsHandler.processEvent(pInputEvent, i);
	}

	public Point getCenterPosition() {
		final Point2D center2D = getCamera().getViewBounds().getCenter2D();
		return new Point((int) center2D.getX(), (int) center2D.getY());
	}

	public Point getCurrentMousePosition() {
		final Point mousePosition = getMousePosition();
		if (mousePosition == null) return getCenterPosition();
		final Point2D localToView = getCamera().localToView(mousePosition);
		return new Point((int) localToView.getX(), (int) localToView.getY());
	}

	@SuppressWarnings("unchecked")
	public <N extends STNode> Stream<N> getAllNodes() {
		return nodeLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof STNode);
	}

	public <N extends STNode> Stream<N> getSelectedNodes() {
		return (Stream<N>) getAllNodes().filter(STNode::isSelected);
	}

	@SuppressWarnings("unchecked")
	public <R extends STRelation> Stream<R> getAllRelations() {
		return relationLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof STRelation);
	}

	public <R extends STRelation> Stream<R> getSelectedRelations() {
		return (Stream<R>) getAllRelations().filter(STRelation::isSelected);
	}

	public <N extends STNode> N addNode(String uuid, java.util.function.Supplier<N> supplier) {
		return addNode(java.util.UUID.fromString(uuid), supplier);
	}

	public <N extends STNode> N addNode(N node) {
		return addNode(node.getUuid(), () -> node);
	}

	public <N extends STNode> N addNode(java.util.UUID uuid, java.util.function.Supplier<N> supplier) {

		final N existing = getNode(uuid);
		if (existing != null) {
			if (debug) System.out.println("N-" + uuid + " exists in canvas");
			existing.refresh();
			existing.select();
			return existing;
		}
		if (debug) System.out.println("N-" + uuid + " added to canvas");

		final N node= supplier.get();
		node.select();
		nodeMap.put(node.getUuid(), node);
		nodeLayer.addChild(node);

		node.addedToCanvas();

		//org.greenrobot.eventbus.EventBus.getDefault().post(new NodeAdded(this, node));

		getAllNodes()
				.filter(stNode -> !stNode.getUuid().equals(node.getUuid()))
				.forEach(stNode -> stNode.newNodeAdded(node));

		return node;
	}

	public <N extends STNode> N getNode(String uuid) {
		return getNode(java.util.UUID.fromString(uuid));
	}

	public <N extends STNode> N getNode(UUID uuid) {
		return (N) nodeMap.get(uuid);
	}

	<N extends STNode> N removeNode(UUID uuid) {
		final STNode remove = nodeMap.remove(uuid);
		final N old = (N) nodeLayer.removeChild(remove);
		if (debug) System.out.println("\tN-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (N) remove;
	}

	public <R extends STRelation> R addRelation(R relation) {
		return addRelation(relation.getUuid(), () -> relation);
	}

	public <R extends STRelation> R addRelation(String uuid, java.util.function.Supplier<R> supplier) {
		return addRelation(java.util.UUID.fromString(uuid), supplier);
	}

	public <R extends STRelation> R addRelation(java.util.UUID uuid, java.util.function.Supplier<R> supplier) {

		final R existing = getRelation(uuid);
		if (existing != null) {
			if (debug) System.out.println("R-"+ uuid + " exists in canvas");
			return existing;
		}
		if (debug) System.out.println("R-"+ uuid + " added to canvas");

		final R relation = supplier.get();
		relationMap.put(relation.getUuid(), relation);
		relationLayer.addChild(relation);
		return relation;
	}

	<R extends STRelation> R removeRelation(UUID uuid) {
		final STRelation remove = relationMap.remove(uuid);
		final R old = (R) relationLayer.removeChild(remove);
		if (debug) System.out.println("\tR-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (R) remove;
	}

	public <R extends STRelation> R getRelation(UUID uuid) {
		return (R) relationMap.get(uuid);
	}

	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {
		pop.add(new NewSTValueNode(this, event));
		pop.add(new NewSTValueFromClipboard(this, event));
		pop.add(new LoadAllModels(this, event));
		pop.add(new SelectAllNodes(this, event));
		pop.add(new UnselectAllNodes(this, event));
		pop.add(new CloseSelectedNodes(this, event));
		pop.add(new LayoutVerticallyAction(this, event));
	}

	protected void onCanvasLeftClick(PInputEvent event) {
		SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(STNode::unselect));
	}

	protected void onCanvasKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case VK_M:
				new LoadAllModels(this, event).actionPerformed(null);
				break;

			case VK_1:
				new LayoutVerticallyAction(this, event).actionPerformed(null);
				break;

			case VK_A:
				new SelectAllNodes(this, event).actionPerformed(null);
				break;

			case VK_C:
				new CloseSelectedNodes(this, event).actionPerformed(null);
				break;

			case VK_F:
				new PopupAction(this, event).actionPerformed(null);
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
					STCanvas.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					onCanvasRightClick(pop, event);
					STCanvas.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pop.show(STCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
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
					.filter(STNode::isSelected)
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

		final private static double maxZoomScale = 2.5d;
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
			final Point2D viewAboutPoint = event.getPosition();
			camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());
		}
	} 

	static abstract class CanvasAction extends AbstractAction {

		final STCanvas canvas;
		final PInputEvent event;

		CanvasAction(String name, STCanvas canvas, PInputEvent event) {
			super(name);
			this.canvas = canvas;
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			actionPerformed(canvas, event, e);
		}

		abstract void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e);

		protected void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer){ 
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));
		}
	}

	private static final class NewSTValueNode extends CanvasAction {

		NewSTValueNode(STCanvas canvas, PInputEvent event) {
			super("New Value", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.showInputDialog("Value", canvas);
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				canvas.addNode(new STValueNode(canvas, canvas.modelDb.newSTValue(s), canvas.stRenderer));
			});
		}
	}

	private static final class NewSTValueFromClipboard extends CanvasAction {

		NewSTValueFromClipboard(STCanvas canvas, PInputEvent event) {
			super("New Value from Clipboard", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.fromClipboard();
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				canvas.addNode(canvas.newSTNode(canvas.modelDb.newSTValue(s)).get());
			});
		}
	}

	private static final class LoadAllModels extends CanvasAction {

		LoadAllModels(STCanvas canvas, PInputEvent event) {
			super("Load All Models", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				canvas.modelDb.findAllSTModel().forEach(stModel -> 
					canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel))
				);
			});
		}
	}

	private static final class SelectAllNodes extends CanvasAction {

		SelectAllNodes(STCanvas canvas, PInputEvent event) {
			super("Select all nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getAllNodes().forEach(STNode::select));
		}
	}

	private static final class UnselectAllNodes extends CanvasAction {

		UnselectAllNodes(STCanvas canvas, PInputEvent event) {
			super("Unselect all nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(STNode::unselect));
		}
	}

	private static final class CloseSelectedNodes extends CanvasAction {

		CloseSelectedNodes(STCanvas canvas, PInputEvent event) {
			super("Close selected nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(STNode::close));
		}
	}

	private static final class LayoutVerticallyAction extends CanvasAction {

		private final Point position;
		private final int heightPadding = 20;

		LayoutVerticallyAction(STCanvas canvas, PInputEvent event) {
			super("Layout selected nodes vertically", canvas, event);
			this.position = canvas.getCurrentMousePosition();
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {

			SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(new Consumer<STNode>() {

				double x = position.getX();
				double y = position.getY();
				double height = -1d;

				@Override
				public void accept(STNode abstractNode) {
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

	private static final class PopupAction extends CanvasAction {

		PopupAction(STCanvas canvas, PInputEvent event) {
			super("Popup", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() ->  {
				final JPopupMenu pop = new JPopupMenu();
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				canvas.onCanvasRightClick(pop, event);
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());	
			});
		}
	}

	java.util.function.Supplier<STNode> newSTNode(nextgen.st.model.STModel stModel){ 
		return () -> new STModelNode(this, modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, stRenderer);
	}

	java.util.function.Supplier<STNode> newSTNode(nextgen.st.model.STValue stValue){ 
		return () -> new STValueNode(this, stValue, stRenderer);
	}

	java.util.function.Supplier<STNode> newSTNode(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument){ 
		return () -> new STKVNode(this, stParameter, stArgument, stRenderer);
	}

	java.util.function.Supplier<STNode> newSTNode(nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel){ 
		return () -> new STFileNode(this, stFile, stModel, stRenderer);
	}

	public static final class NodeAdded {

		public STCanvas canvas;
		public STNode node;

		public NodeAdded(STCanvas canvas, STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	}

	public static final class NodeClosed {

		public STCanvas canvas;
		public STNode node;

		public NodeClosed(STCanvas canvas, STNode node) {
			this.canvas = canvas;
			this.node = node;
		}
	} 
}