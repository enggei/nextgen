package nextgen.st.canvas;

import nextgen.st.STAppPresentationModel;
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
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.awt.event.KeyEvent.*;

public class STCanvas extends PCanvas implements PInputEventListener {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STCanvas.class);

	private final PLayer nodeLayer;
	private final PLayer relationLayer = new PLayer();

	final Map<UUID, nextgen.st.canvas.STNode> nodeMap = new ConcurrentHashMap<>();
	final Map<UUID, nextgen.st.canvas.STRelation> relationMap = new ConcurrentHashMap<>();

	private final SelectEventsHandler selectEventHandler = new SelectEventsHandler();
	private final CanvasInputEventsHandler canvasInputEventsHandler = new CanvasInputEventsHandler();
	final CanvasZoomHandler canvasZoomHandler = new CanvasZoomHandler();
	
	final STAppPresentationModel presentationModel;

	public STCanvas(STAppPresentationModel presentationModel) {
		this(presentationModel, Color.WHITE, new Dimension(1024, 1024));
	}

	public STCanvas(STAppPresentationModel presentationModel, Color background, Dimension preferredSize) {
		super();
		
		this.presentationModel = presentationModel;
		
		setBackground(background);
		setPreferredSize(preferredSize);
		nodeLayer = getLayer();
		getCamera().addLayer(0, relationLayer);

		removeInputEventListener(getZoomEventHandler());
		addInputEventListener(canvasZoomHandler);
		addInputEventListener(canvasInputEventsHandler);
		javax.swing.SwingUtilities.invokeLater(() -> new LoadLastLayoutAction(this, null).actionPerformed(null));
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

	public <N extends nextgen.st.canvas.STNode> void centerNode(N node) {
		SwingUtilities.invokeLater(() -> getCamera().animateViewToCenterBounds(node.getGlobalFullBounds(), false, 500));
	}

	@SuppressWarnings("unchecked")
	public <N extends nextgen.st.canvas.STNode> Stream<N> getAllNodes() {
		return nodeLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof nextgen.st.canvas.STNode);
	}

	public <N extends nextgen.st.canvas.STNode> Stream<N> getSelectedNodes() {
		return (Stream<N>) getAllNodes().filter(nextgen.st.canvas.STNode::isSelected);
	}

	public <N extends STNode> Stream<N> getUnselectedNodes() {
		return (Stream<N>) getAllNodes().filter(stNode -> !stNode.isSelected());
	}

	@SuppressWarnings("unchecked")
	public <R extends nextgen.st.canvas.STRelation> Stream<R> getAllRelations() {
		return relationLayer.getAllNodes().stream().filter((Predicate<PNode>) node -> node instanceof nextgen.st.canvas.STRelation);
	}

	public <R extends nextgen.st.canvas.STRelation> Stream<R> getSelectedRelations() {
		return (Stream<R>) getAllRelations().filter(nextgen.st.canvas.STRelation::isSelected);
	}

	public <N extends nextgen.st.canvas.STNode> N addNode(String uuid, java.util.function.Supplier<N> supplier) {
		return addNode(java.util.UUID.fromString(uuid), supplier);
	}

	public <N extends nextgen.st.canvas.STNode> N addNode(N node) {
		return addNode(node.getUuid(), () -> node);
	}

	public <N extends nextgen.st.canvas.STNode> N addNode(java.util.UUID uuid, java.util.function.Supplier<N> supplier) {

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

		nextgen.st.STAppEvents.postNodeAdded(this, node);

		node.addedToCanvas();

		getAllNodes()
				.filter(stNode -> !stNode.getUuid().equals(node.getUuid()))
				.forEach(stNode -> stNode.newNodeAdded(node));

		return node;
	}

	public <N extends nextgen.st.canvas.STNode> N getNode(String uuid) {
		return getNode(java.util.UUID.fromString(uuid));
	}

	public <N extends nextgen.st.canvas.STNode> N getNode(UUID uuid) {
		return (N) nodeMap.get(uuid);
	}

	<N extends nextgen.st.canvas.STNode> N removeNode(UUID uuid) {
		final nextgen.st.canvas.STNode remove = nodeMap.remove(uuid);
		final N old = (N) nodeLayer.removeChild(remove);
		log.debug("\tN-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (N) remove;
	}

	public <R extends nextgen.st.canvas.STRelation> R addRelation(String uuid, java.util.function.Supplier<R> supplier) {
		return addRelation(java.util.UUID.fromString(uuid), supplier);
	}

	public <R extends nextgen.st.canvas.STRelation> R addRelation(java.util.UUID uuid, java.util.function.Supplier<R> supplier) {

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

	<R extends nextgen.st.canvas.STRelation> R removeRelation(UUID uuid) {
		final nextgen.st.canvas.STRelation remove = relationMap.remove(uuid);
		if (remove == null) return null;

		remove.close();
		final R old = (R) relationLayer.removeChild(remove);
		log.debug("\tR-"+ uuid + " removed from canvas : " + (old == null ? "null" : old.getUuid()));
		return (R) remove;
	}

	public <R extends nextgen.st.canvas.STRelation> R getRelation(UUID uuid) {
		return (R) relationMap.get(uuid);
	}

	protected void onCanvasRightClick(JPopupMenu pop, PInputEvent event) {
		pop.add(new NewScript(this, event));
		pop.add(new CloseAll(this, event));
		pop.add(new NewSTValueNode(this, event));
		pop.add(new NewSTValueFromClipboard(this, event));
		pop.add(new SaveLastLayoutAction(this, event));
		pop.add(new LoadLastLayoutAction(this, event));
		pop.add(new SelectAllNodes(this, event));
		pop.add(new UnselectAllNodes(this, event));
		pop.add(new CloseSelectedNodes(this, event));
		pop.add(new RetainSelectedNodes(this, event));
		pop.add(new LayoutVerticallyAction(this, event));
	}

	protected void onCanvasLeftClick(PInputEvent event) {
		SwingUtilities.invokeLater(() -> getSelectedNodes().forEach(nextgen.st.canvas.STNode::unselect));
	}

	protected void onCanvasKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case VK_W:
				new CloseAll(this, event).actionPerformed(null);
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

			case VK_R:
				new RetainSelectedNodes(this, event).actionPerformed(null);
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
			javax.swing.SwingUtilities.invokeLater(() -> canvas.presentationModel.db.doInTransaction(consumer, (throwable) -> com.generator.util.SwingUtil.showException(canvas, throwable)));
		}
	}

	private static final class NewScript extends CanvasAction {


		NewScript(STCanvas canvas, PInputEvent event) {
			super("New Script", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			com.generator.util.SwingUtil.showInputDialog("Name", canvas,s -> doLaterInTransaction(tx -> canvas.addNode(new ScriptNode(canvas, canvas.presentationModel.db.newScript(s), canvas.presentationModel.stRenderer))));
		}
	}

	private static final class NewSTValueNode extends CanvasAction {


		NewSTValueNode(STCanvas canvas, PInputEvent event) {
			super("New Value", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			com.generator.util.SwingUtil.showInputDialog("Value", canvas, s -> doLaterInTransaction(tx -> canvas.addNode(new STValueNode(canvas, canvas.presentationModel.db.newSTValue(s), canvas.presentationModel.stRenderer))));
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
			doLaterInTransaction(tx -> canvas.addNode(canvas.newSTNode(canvas.presentationModel.db.newSTValue(s)).get()));
		}
	}

	private static final class SaveLastLayoutAction extends CanvasAction {


		SaveLastLayoutAction(STCanvas canvas, PInputEvent event) {
			super("Save last layout", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(canvas.presentationModel.db.getDatabaseService());
				final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findOrCreateLayoutByName("last");

				last.getNodes().forEach(layoutNode -> {
					layoutNode.getNode().getRelationships().forEach(org.neo4j.graphdb.Relationship::delete);
					layoutNode.getNode().delete();
				});

				canvas.getAllNodes().forEach(stNode -> {
					final nextgen.st.canvas.layout.LayoutNode layoutNode = layoutNeoFactory.newLayoutNode();
					layoutNode.setX(stNode.getOffset().getX());
					layoutNode.setY(stNode.getOffset().getY());

					if (stNode instanceof STModelNode) {
						final org.neo4j.graphdb.Node node = ((STModelNode) stNode).stModel.getNode();
						layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
					} else if (stNode instanceof STValueNode) {
						final org.neo4j.graphdb.Node node = ((STValueNode) stNode).stValue.getNode();
						layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
					} else if (stNode instanceof ScriptNode) {
						final org.neo4j.graphdb.Node node = ((ScriptNode) stNode).script.getNode();
						layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
					} else if (stNode instanceof STFileNode) {
						final org.neo4j.graphdb.Node node = ((STFileNode) stNode).stFile.getNode();
						layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName("ref"));
					}

					last.addNodes(layoutNode);
				});
			});
		}
	}

	private static final class UnselectAllNodes extends CanvasAction {


		UnselectAllNodes(STCanvas canvas, PInputEvent event) {
			super("Unselect all nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(nextgen.st.canvas.STNode::unselect));
		}
	}

	private static final class CloseSelectedNodes extends CanvasAction {


		CloseSelectedNodes(STCanvas canvas, PInputEvent event) {
			super("Close selected nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(nextgen.st.canvas.STNode::close));
		}
	}

	private static final class LoadLastLayoutAction extends CanvasAction {


		LoadLastLayoutAction(STCanvas canvas, PInputEvent event) {
			super("Load last layout", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {

				final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(canvas.presentationModel.db.getDatabaseService());
				final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findLayoutByName("last");
				if (last == null) return;

				final java.util.concurrent.atomic.AtomicReference<STNode> centerNodeRef = new java.util.concurrent.atomic.AtomicReference<>();
				last.getNodesSorted().forEach(layoutNode -> {
					final org.neo4j.graphdb.Node node = layoutNode.getNode();
					node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("ref")).forEach(relationship -> {
						final org.neo4j.graphdb.Node stNode = relationship.getOtherNode(node);
						if (stNode.hasLabel(org.neo4j.graphdb.Label.label("STModel"))) {
							final nextgen.st.model.STModel stModel = canvas.presentationModel.db.newSTModel(stNode);
							canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
							canvas.getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
							if (centerNodeRef.get() == null) centerNodeRef.set(canvas.getNode(stModel.getUuid()));
						} else if (stNode.hasLabel(org.neo4j.graphdb.Label.label("STValue"))) {
							final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(stNode);
							canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
							canvas.getNode(stValue.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
							if (centerNodeRef.get() == null) centerNodeRef.set(canvas.getNode(stValue.getUuid()));
						} else if (stNode.hasLabel(org.neo4j.graphdb.Label.label("Script"))) {
							final nextgen.st.script.Script script = canvas.presentationModel.db.newScript(stNode);
							canvas.addNode(script.getUuid(), canvas.newScriptNode(script, canvas.presentationModel.stRenderer));
							canvas.getNode(script.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
							if (centerNodeRef.get() == null) centerNodeRef.set(canvas.getNode(script.getUuid()));
						} else if (stNode.hasLabel(org.neo4j.graphdb.Label.label("STFile"))) {
							final nextgen.st.model.STFile stFile = canvas.presentationModel.db.newSTFile(stNode);
							stFile.getIncomingFiles().findFirst().ifPresent(stModel -> {
								canvas.addNode(stFile.getUuid(), canvas.newSTNode(stFile, stModel));
								canvas.getNode(stFile.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());
								if (centerNodeRef.get() == null) centerNodeRef.set(canvas.getNode(stFile.getUuid()));	 
							});
						}
					});
				});

				if (centerNodeRef.get() != null) canvas.centerNode(centerNodeRef.get());
			});
		}
	}

	private static final class SelectAllNodes extends CanvasAction {


		SelectAllNodes(STCanvas canvas, PInputEvent event) {
			super("Select all nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getAllNodes().forEach(nextgen.st.canvas.STNode::select));
		}
	}

	private static final class RetainSelectedNodes extends CanvasAction {


		RetainSelectedNodes(STCanvas canvas, PInputEvent event) {
			super("Retain selected nodes", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.getUnselectedNodes().forEach(STNode::close));
		}
	}

	private static final class LayoutVerticallyAction extends CanvasAction {

		private java.awt.Point position;
		private int heightPadding;

		LayoutVerticallyAction(STCanvas canvas, PInputEvent event) {
			super("Layout selected nodes vertically", canvas, event);
			this.position = canvas.getCurrentMousePosition();
			this.heightPadding = 20;
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			SwingUtilities.invokeLater(() -> canvas.getSelectedNodes().forEach(new Consumer<nextgen.st.canvas.STNode>() {

				double x = position.getX();
				double y = position.getY();
				double height = -1d;

				@Override
				public void accept(nextgen.st.canvas.STNode abstractNode) {
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
			javax.swing.SwingUtilities.invokeLater(() -> { 
				final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
				canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
				canvas.onCanvasRightClick(pop, event);
				canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
				pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
			});
		}
	}

	private static final class CloseAll extends CanvasAction {


		CloseAll(STCanvas canvas, PInputEvent event) {
			super("Close all", canvas, event);
		}

		@Override
		void actionPerformed(STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.getAllRelations().forEach(relation -> canvas.removeRelation(relation.getUuid()));
			canvas.getAllNodes().forEach(node -> canvas.removeNode(node.getUuid()));
		}
	}

	java.util.function.Supplier<nextgen.st.canvas.ScriptNode> newScriptNode(nextgen.st.script.Script script, nextgen.st.STRenderer stRenderer){ 
		return () -> new nextgen.st.canvas.ScriptNode(this, script, stRenderer);
	}

	public final javax.swing.JTextField newTextField(int columns){ 
		return newTextField("", columns);
	}

	public final javax.swing.JTextField newTextField(String content, int columns){ 
		javax.swing.JTextField textField = new javax.swing.JTextField(content, columns);
		textField.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (javax.swing.SwingUtilities.isRightMouseButton(e))
					javax.swing.SwingUtilities.invokeLater(() -> {
							final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
							pop.add(new AbstractAction("Set from clipboard") {
								@Override
								public void actionPerformed(ActionEvent e) {
									textField.setText(com.generator.util.SwingUtil.fromClipboard());
								}
							});
							pop.show(textField, e.getX(), e.getY());
					});
			}
		});
		textField.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusGained(java.awt.event.FocusEvent evt) {
				javax.swing.SwingUtilities.invokeLater(() -> ((javax.swing.JTextField) evt.getSource()).selectAll());
			}

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				javax.swing.SwingUtilities.invokeLater(() -> {
					((javax.swing.JTextField) evt.getSource()).setSelectionStart(0);
					((javax.swing.JTextField) evt.getSource()).setSelectionEnd(0);
				});
			}
		});
		return textField;
	}

	java.util.function.Supplier<nextgen.st.canvas.ScriptRelation> newScriptRelation(nextgen.st.canvas.ScriptNode src, nextgen.st.canvas.STNode dst){ 
		return () -> new ScriptRelation(this, src, dst);
	}

	java.util.function.Supplier<nextgen.st.canvas.STArgumentRelation> newSTArgumentRelation(nextgen.st.canvas.STModelNode src, nextgen.st.canvas.STNode dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter){ 
		return () -> new STArgumentRelation(this, src, dst, stArgument, stParameter);
	}

	java.util.function.Supplier<nextgen.st.canvas.STSinkRelation> newSinkRelation(nextgen.st.canvas.STModelNode src, nextgen.st.canvas.STFileNode stFileNode){ 
		return () ->  new STSinkRelation(this, src, stFileNode);
	}

	java.util.function.Supplier<nextgen.st.canvas.STKVArgumentRelation> newSTKVArgumentRelation(nextgen.st.canvas.STKVNode src, nextgen.st.canvas.STNode dst, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV){ 
		return () -> new STKVArgumentRelation(this, src, dst, stArgument, stParameterKey, stArgumentKV);
	}

	java.util.function.Supplier<nextgen.st.canvas.STValueModelRelation> newSTValueModelRelation(nextgen.st.canvas.STValueNode src, nextgen.st.canvas.STModelNode dst){ 
		return () -> new STValueModelRelation(this, src, dst);
	}

	java.util.function.Supplier<nextgen.st.canvas.STValueNode> newSTNode(nextgen.st.model.STValue stValue){ 
		return () -> new STValueNode(this, stValue, presentationModel.stRenderer);
	}

	java.util.function.Supplier<nextgen.st.canvas.STKVNode> newSTNode(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument){ 
		return () -> new STKVNode(this, stParameter, stArgument, presentationModel.stRenderer);
	}

	java.util.function.Supplier<nextgen.st.canvas.STFileNode> newSTNode(nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel){ 
		return () -> new STFileNode(this, stFile, stModel, presentationModel.stRenderer);
	}

	java.util.function.Supplier<nextgen.st.canvas.STModelNode> newSTNode(nextgen.st.model.STModel stModel){ 
		return () -> new nextgen.st.canvas.STModelNode(this, presentationModel.db.findSTTemplateByUuid(stModel.getStTemplate()), stModel, presentationModel.stRenderer);
	}
}