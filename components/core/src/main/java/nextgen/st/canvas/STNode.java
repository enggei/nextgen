package nextgen.st.canvas;

import org.piccolo2d.PNode;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

import static java.awt.event.KeyEvent.*;

public class STNode extends PNode implements PropertyChangeListener {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STNode.class);

	protected enum Attributes {
		_defaultColor, _selectedColor, _highlightedColor, _uuid, _text, _selected, _highlight
	}

	protected final STCanvas canvas;
	protected final PText child;

	private PPath rectangle;

	protected final Set<UUID> outgoing = new LinkedHashSet<>();
	protected final Set<UUID> incoming = new LinkedHashSet<>();

	public STNode(STCanvas canvas, String text) {
		this(canvas, text, UUID.randomUUID());
	}

	public STNode(STCanvas canvas, String text, UUID uuid) {
		this.canvas = canvas;

		this.addAttribute(Attributes._defaultColor, Color.decode("#000000"));
		this.addAttribute(Attributes._selectedColor, Color.decode("#ca0020"));
		this.addAttribute(Attributes._highlightedColor, Color.decode("#000000"));
		this.addAttribute(Attributes._uuid, uuid);
		this.addAttribute(Attributes._text, text);
		this.child = new PText(text == null || text.trim().length() == 0 ? getUuid().toString() : text);

		final NodeInputEventHandler nodeInputEventHandler = new NodeInputEventHandler();
		nodeInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);
		addInputEventListener(nodeInputEventHandler);
		addInputEventListener(canvas.canvasZoomHandler);

		this.addChild(this.child);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public void addedToCanvas() {

	}

	public void newNodeAdded(STNode node) {

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

		STNode other = (STNode) o;

		return getUuid().equals(other.getUuid());
	}

	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}

	public UUID getUuid() {
		return (UUID) getAttribute(Attributes._uuid);
	}

	public String getText() {
		return (String) getAttribute(Attributes._text);
	}

	public void setText(String text) {
		addAttribute(Attributes._text, text == null || text.trim().length() == 0 ? getUuid().toString() : text);
		child.setText(getText());
		refresh();
	}

	public void refresh() {
		SwingUtilities.invokeLater(() -> {
			setPaintInvalid(true);
			repaint();
		});
	}

	public void addOutgoingRelation(UUID relation) {
		this.outgoing.add(relation);
	}

	public void addIncomingRelation(UUID relation) {
		this.incoming.add(relation);
	}

	public java.util.stream.Stream<UUID> outgoing() {
		return this.outgoing.stream();
	}

	public java.util.stream.Stream<UUID> incoming() {
		return this.incoming.stream();
	}

	public void unselect() {
		addAttribute(Attributes._selected, Boolean.FALSE);
		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(Attributes._defaultColor)));
	}

	public void select() {
		addAttribute(Attributes._selected, Boolean.TRUE);
		SwingUtilities.invokeLater(() -> child.setTextPaint((Color) getAttribute(Attributes._selectedColor)));
	}

	public boolean isSelected() {
		return getBooleanAttribute(Attributes._selected, false);
	}

	public void unhighlight() {
		addAttribute(Attributes._highlight, Boolean.FALSE);
		SwingUtilities.invokeLater(() -> {
			child.setTextPaint(isSelected() ? (Color) getAttribute(Attributes._selectedColor) : (Color) getAttribute(Attributes._defaultColor));
			if (rectangle != null) STNode.this.removeChild(rectangle);	
		});
	}

	public void highlight() {
		addAttribute(Attributes._highlight, Boolean.TRUE);
		SwingUtilities.invokeLater(() -> {
			final PBounds fullBounds = child.getFullBoundsReference();
			rectangle = PPath.createRectangle(fullBounds.getX(), fullBounds.getY(), fullBounds.getWidth(), fullBounds.getHeight());
			final Color green = new Color(0, 255, 0, 50);
			rectangle.setPaint(green);
			rectangle.setStroke(new BasicStroke());
			STNode.this.addChild(rectangle);

			child.setTextPaint((Color) getAttribute(Attributes._highlightedColor));
		});
	}

	public void close() {
		SwingUtilities.invokeLater(() -> {
			for (UUID uuid : incoming) canvas.removeRelation(uuid);
			for (UUID uuid : outgoing) canvas.removeRelation(uuid);
			org.greenrobot.eventbus.EventBus.getDefault().unregister(STNode.this);
			canvas.removeNode(getUuid());			
		});
	}

	protected void onNodeKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case VK_1:
				new LayoutTreeAction(this, canvas, event).actionPerformed(null);
				break;

			case VK_C:
				new CloseNode(this, canvas, event).actionPerformed(null);
				break;

			case VK_R:
				new RetainNode(this, canvas, event).actionPerformed(null);
				break;

			case VK_F:
				new PopupAction(this, canvas, event).actionPerformed(null);
				break;

			case VK_B:
				new DebugAction(this, canvas, event).actionPerformed(null);
				break;

		}
	}

	protected void onNodeLeftClick(PInputEvent event) {
		if (isSelected()) unselect();
		else select();
	}

	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {

		pop.add(new LayoutTreeAction(this, canvas, event));
		pop.add(new RetainNode(this, canvas, event));
		pop.add(new CloseNode(this, canvas, event));

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

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
				event.getInputManager().setKeyboardFocus(canvas);
		}

		@Override
		public void mouseClicked(PInputEvent event) {
			if (event.isRightMouseButton()) {
				final JPopupMenu pop = new JPopupMenu();
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				onNodeRightClick(event, pop);
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
			} else if (event.isLeftMouseButton()) {
				SwingUtilities.invokeLater(() -> onNodeLeftClick(event));
			}
		}

		@Override
		public void keyPressed(PInputEvent event) {
			onNodeKeyPressed(event);
		}
	}  	

	static abstract class NodeAction<N extends STNode> extends AbstractAction {

		final N node;
		final STCanvas canvas;
		final PInputEvent event;

		NodeAction(String name, N node, STCanvas canvas, PInputEvent event) {
			super(name);
			this.node = node;
			this.canvas = canvas;
			this.event = event;
		}

		protected void setName(String name) {
			putValue(Action.NAME, name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			actionPerformed(node, canvas, event, e);
		}

		abstract void actionPerformed(N node, STCanvas canvas, PInputEvent event, ActionEvent e);

		protected void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer){ 
			node.doLaterInTransaction(consumer);
		}
	}

	protected static final class LayoutTreeAction extends NodeAction<STNode> {

		private final Map<UUID, STNode> parentsMap = new LinkedHashMap<>();
		private final Map<UUID, java.util.List<STNode>> childrensMap = new LinkedHashMap<>();
		private final org.abego.treelayout.util.DefaultConfiguration<STNode> configuration;

		protected LayoutTreeAction(STNode root, STCanvas canvas, PInputEvent event) {
			this(root, canvas, event, org.abego.treelayout.Configuration.Location.Left, org.abego.treelayout.Configuration.AlignmentInLevel.TowardsRoot);
		}

		protected LayoutTreeAction(STNode root, STCanvas canvas, PInputEvent event, org.abego.treelayout.Configuration.Location location, org.abego.treelayout.Configuration.AlignmentInLevel alignmentInLevel) {
			super("Layout Tree", root, canvas, event);
			this.configuration = new org.abego.treelayout.util.DefaultConfiguration<>(100, 15, location, alignmentInLevel);
		}

		@Override
		void actionPerformed(STNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {

			new Thread(() -> {

				findChildren(node);

				final org.abego.treelayout.TreeForTreeLayout<STNode> tree = new org.abego.treelayout.util.AbstractTreeForTreeLayout<STNode>(node) {
					@Override
					public STNode getParent(STNode node) {
						return parentsMap.get(node.getUuid());
					}

					@Override
					public java.util.List<STNode> getChildrenList(STNode node) {
						if (node == null) return Collections.emptyList();
						return childrensMap.get(node.getUuid());
					}
				};

				final org.abego.treelayout.NodeExtentProvider<STNode> nodeExtendProvider = new org.abego.treelayout.NodeExtentProvider<STNode>() {
					@Override
					public double getWidth(STNode node) {
						return node.getFullBounds().getWidth();
					}

					@Override
					public double getHeight(STNode node) {
						return node.getFullBounds().getHeight();
					}
				};

				final org.abego.treelayout.TreeLayout<STNode> layout = new org.abego.treelayout.TreeLayout<>(tree, nodeExtendProvider, configuration);

				// apply coordinate transforms in relation to root-node
				final java.awt.geom.Rectangle2D.Double rootBounds = layout.getNodeBounds().get(node);
				final double deltaX = node.getFullBounds().getX() - rootBounds.getX();
				final double deltaY = node.getFullBounds().getY() - rootBounds.getY();

				SwingUtilities.invokeLater(() -> {
					for (Map.Entry<STNode, java.awt.geom.Rectangle2D.Double> nodeBound : layout.getNodeBounds().entrySet()) {
						if (nodeBound.getKey().equals(node)) continue;	// root-node is transformation-root
						nodeBound.getKey().setOffset(nodeBound.getValue().getX() + deltaX, nodeBound.getValue().getY() + deltaY);
					}
				});

			}).start();
		}

		private void findChildren(STNode node) {

			if (childrensMap.containsKey(node.getUuid())) return;

			childrensMap.put(node.getUuid(), new ArrayList<>());

			node.outgoing()
					.filter(canvas.relationMap::containsKey)
					.map(uuid -> canvas.relationMap.get(uuid).getDst())
					.filter(abstractNode -> !childrensMap.containsKey(abstractNode.getUuid()))
					.forEach(abstractNode -> {
							childrensMap.get(node.getUuid()).add(abstractNode);
							parentsMap.put(abstractNode.getUuid(), node);
					});

			childrensMap.get(node.getUuid()).forEach(this::findChildren);
		}
	}

	private static final class RetainNode extends NodeAction<STNode> {


		RetainNode(STNode node, STCanvas canvas, PInputEvent event) {
			super("Retain", node, canvas, event);
		}

		@Override
		void actionPerformed(STNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> {
				canvas.getAllNodes().filter(canvasNode -> !canvasNode.getUuid().equals(node.getUuid())).forEach(STNode::close);
				canvas.getAllRelations().forEach(relation -> canvas.removeRelation(relation.getUuid()));
			});
		}
	}

	private static final class CloseNode extends NodeAction<STNode> {


		CloseNode(STNode node, STCanvas canvas, PInputEvent event) {
			super("Close", node, canvas, event);
		}

		@Override
		void actionPerformed(STNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(node::close);
		}
	}

	private static final class PopupAction extends NodeAction<STNode> {


		PopupAction(STNode node, STCanvas canvas, PInputEvent event) {
			super("Popup", node, canvas, event);
		}

		@Override
		void actionPerformed(STNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> {
				final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
				canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
				node.onNodeRightClick(event, pop);
				canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
				pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
			});
		}
	}

	private static final class DebugAction extends NodeAction<STNode> {


		DebugAction(STNode node, STCanvas canvas, PInputEvent event) {
			super("Debug", node, canvas, event);
		}

		@Override
		void actionPerformed(STNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> {
				final PBounds fullBounds = node.getFullBoundsReference();
				log.info(node.getUuid() + " : " + node.getText());
				log.info(fullBounds.getX() + "," + fullBounds.getY() + ", [" + fullBounds.getWidth() + "," + fullBounds.getHeight() + "]");
				node.outgoing().forEach(uuid -> log.info(" -> " + uuid));
				node.incoming().forEach(uuid -> log.info(" <- " + uuid));
			});
		}
	}



	public static String cut(String text){ 
		return text.substring(0, Math.min(text.length(), 80));
	}

	protected void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer){ 
		javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNodeAdded(nextgen.st.STAppEvents.NodeAdded event) {
		log.debug(getUuid() + " : node added " + event.node.getUuid());
	}
}