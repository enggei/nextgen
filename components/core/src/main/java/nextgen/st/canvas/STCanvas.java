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

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<UUID, STNode> nodeMap = new ConcurrentHashMap<>();
	final Map<UUID, STRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();

	nextgen.st.STRenderer stRenderer;
	nextgen.st.model.STModelDB modelDb;

	public STCanvas(nextgen.st.STRenderer stRenderer,nextgen.st.model.STModelDB modelDb) {
		this(stRenderer, modelDb, Color.WHITE, new Dimension(1024, 768));
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

	public <N extends STNode> N addNode(N node) {
		return addNode(node, getCenterPosition());
	}

	public <N extends STNode> N addNode(N node, Point2D offset) {
		final N existing = getNode(node.getUuid());
		if (existing != null) {
			existing.refresh();
			return existing;
		}
		if (offset != null) node.setOffset(offset);
		node.select();
		nodeMap.put(node.getUuid(), node);
		SwingUtilities.invokeLater(() -> nodeLayer.addChild(node));
		return node;
	}

	public <N extends STNode> N getNode(UUID uuid) {
		return (N) nodeMap.get(uuid);
	}

	public <N extends STNode> N removeNode(UUID uuid) {
		final STNode remove = nodeMap.remove(uuid);
		nodeLayer.removeChild(remove);
		return (N) remove;
	}

	public <R extends STRelation> R addRelation(R relation) {
		relationMap.put(relation.getUuid(), relation);
		relationLayer.addChild(relation);
		return relation;
	}
		public <R extends STRelation> R removeRelation(UUID uuid) {
		final STRelation remove = relationMap.remove(uuid);
		relationLayer.removeChild(remove);
		return (R) remove;
	}

	public <R extends STRelation> R getRelation(UUID uuid) {
		return (R) relationMap.get(uuid);
	}

	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {
		pop.add(new NewSTValueNode(this, event));
		pop.add(new LoadAllModels(this, event));
		pop.add(new NewSTValueFromClipboard(this, event));
		pop.add(new NewSTFileNode(this, event));
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
			case VK_1:
				new LayoutVerticallyAction(this, event).actionPerformed(null);
				break;

			case VK_A:
				new SelectAllNodes(this, event).actionPerformed(null);
				break;

			case VK_C:
				new CloseSelectedNodes(this, event).actionPerformed(null);
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
	}

	private static final class NewSTValueNode extends CanvasAction {

		NewSTValueNode(STCanvas canvas, PInputEvent event) {
			super("New Value", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.showInputDialog("Value", canvas);
			if (s == null || s.trim().length() == 0) return;
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.addNode(new STValueNode(canvas, canvas.modelDb.newSTValue(s), canvas.stRenderer));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class LoadAllModels extends CanvasAction {

		LoadAllModels(STCanvas canvas, PInputEvent event) {
			super("Load All Models", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.findAllSTModel().forEach(stModel -> 
					canvas.addNode(new STModelNode(canvas, canvas.modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, canvas.stRenderer))
				);
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
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
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s);
				canvas.addNode(new STValueNode(canvas, stValue, canvas.stRenderer));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class NewSTFileNode extends CanvasAction {

		NewSTFileNode(STCanvas canvas, PInputEvent event) {
			super("New Sink", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();
			fieldMap.put("name", new JTextField(15));
			fieldMap.put("type", new JTextField(15));
			fieldMap.put("path", new JTextField(15));
			fieldMap.put("package", new JTextField(15));
			final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
			inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
			for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
				inputPanel.add(new JLabel(fieldEntry.getKey()));
				inputPanel.add(fieldEntry.getValue());
			}
			com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "New sink", new com.generator.util.SwingUtil.ConfirmAction() {
				@Override
				public void verifyAndCommit() throws Exception {
					final String name = fieldMap.get("name").getText().trim();
					final String type = fieldMap.get("type").getText().trim();
					final String path = fieldMap.get("path").getText().trim();
					final String packageName = fieldMap.get("package").getText().trim();
					javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
						final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);
						canvas.addNode(new STFileNode(canvas, stFile, null, null));
					}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
				}
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
}