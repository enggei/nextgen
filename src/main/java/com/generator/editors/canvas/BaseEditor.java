package com.generator.editors.canvas;

import org.neo4j.graphdb.Label;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * goe on 10/14/16.
 */
public abstract class BaseEditor<N extends BasePNode, R extends RelationPath<N, N>> extends PBasicInputEventHandler implements PropertyChangeListener {

	public final PSwingCanvas canvas = new PSwingCanvas();

	protected PLayer nodeLayer;
	protected final Map<UUID, N> layerNodes = new LinkedHashMap<>();
	protected final Map<String, Set<UUID>> nodesByLabel = new ConcurrentHashMap<>();

	protected PLayer relationLayer;
	protected final Map<UUID, R> layerRelations = new LinkedHashMap<>();
	protected final AtomicBoolean showRelationLabels = new AtomicBoolean(false);

	// interaction
	final MousePositionNode mousePositionNode = new MousePositionNode();
	protected final Map<UUID, N> selectedNodes = new LinkedHashMap<>();

	protected final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public BaseEditor() {

		nodeLayer = canvas.getLayer();
		relationLayer = new PLayer();
		canvas.getCamera().addLayer(0, relationLayer);
		canvas.removeInputEventListener(canvas.getPanEventHandler());
		canvas.removeInputEventListener(canvas.getZoomEventHandler());
		canvas.addInputEventListener(this);
		canvas.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		canvas.setPreferredSize(new Dimension(800, 640));
		canvas.setBackground(Color.LIGHT_GRAY);

		getEventFilter().setMarksAcceptedEventsAsHandled(true);
	}

	public abstract N show(UUID uuid, String nodetype);

	public PSwingCanvas getCanvas() {
		return canvas;
	}

	public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		changeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public void removeNodeFromCanvas(UUID uuid) {
		selectedNodes.remove(uuid);

		final N node = layerNodes.remove(uuid);

		if (node != null) {
			final Set<UUID> set = nodesByLabel.get(node.getNodeType());
			if (set != null) set.remove(uuid);

			nodeLayer.removeChild(node.pNode);
		}
	}

	public void addRelationToCanvas(R relationshipPPath) {

		if (layerRelations.containsKey(relationshipPPath.uuid))
			return;

		layerRelations.put(relationshipPPath.uuid, relationshipPPath);

		relationshipPPath.addPropertyChangeListener(this);
		relationLayer.addChild(relationshipPPath.path);

		relationshipPPath.path.repaint();
		canvas.repaint();
	}

	protected void removeRelationFromCanvas(R relation) {
		relation.removePropertyChangeListener(this);
		layerRelations.remove(relation.uuid);
		relationLayer.removeChild(relation.path);
	}

	public void visitRelations(Consumer<? super R> consumer) {
		this.layerRelations.values().forEach(consumer);
	}

	public final Collection<N> getSelectedNodes() {
		return selectedNodes.values();
	}

	public final Collection<N> getAllNodes() {
		return layerNodes.values();
	}

	public Point2D.Double canvasCenterPoint() {
		return new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d);
	}

	public void selectOutgoing(BasePNode node) {
		layerRelations.values().stream().filter(r -> r.source.uuid.equals(node.uuid)).forEach(r -> r.target.select());
	}

	public void reset() {

		relationLayer.removeAllChildren();
		nodeLayer.removeAllChildren();
		for (Map.Entry<String, Set<UUID>> entry : nodesByLabel.entrySet())
			entry.getValue().clear();

		layerNodes.clear();
		layerRelations.clear();
		selectedNodes.clear();

		canvas.requestFocusInWindow();
	}

	protected Action retainSelected() {
		return new AbstractAction("Retain") {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LinkedHashSet<>(layerNodes.keySet()).forEach(new Consumer<UUID>() {
					@Override
					public void accept(UUID uuid) {
						if (selectedNodes.containsKey(uuid)) return;
						removeNodeFromCanvas(uuid);
					}
				});
			}
		};
	}

	protected Action hideSelected() {
		return new AbstractAction("Hide") {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LinkedHashSet<>(selectedNodes.keySet()).forEach(new Consumer<UUID>() {
					@Override
					public void accept(UUID uuid) {
						removeNodeFromCanvas(uuid);
					}
				});

				selectedNodes.clear();
			}
		};
	}

	protected Action unselectAll() {
		return new AbstractAction("Unselect") {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LinkedHashSet<>(layerNodes.keySet()).forEach(new Consumer<UUID>() {
					@Override
					public void accept(UUID uuid) {
						layerNodes.get(uuid).unselect();
					}
				});

				selectedNodes.clear();
			}
		};
	}

	protected Action selectAll() {
		return new AbstractAction("Select ALL") {
			@Override
			public void actionPerformed(ActionEvent e) {
				layerNodes.keySet().forEach(uuid -> layerNodes.get(uuid).select());
			}
		};
	}

	protected Action cleanCanvas() {
		return new AbstractAction("Clean") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					reset();
					canvas.repaint();
				});
			}
		};
	}

	@Override
	public void mouseEntered(PInputEvent event) {
		event.getInputManager().setKeyboardFocus(this);
		mousePositionNode.setOffset(event.getCanvasPosition());
	}

	@Override
	public void mouseMoved(PInputEvent event) {
		mousePositionNode.setOffset(event.getCanvasPosition());
	}

	@Override
	public void mouseClicked(PInputEvent event) {

		event.getInputManager().setKeyboardFocus(this);

		if (event.isMiddleMouseButton()) {
			SwingUtilities.invokeLater(mousePositionNode::toggle);
		}

	}

	protected void addToMenu(JPopupMenu pop, PInputEvent event) {

		if (!selectedNodes.isEmpty()) {
			pop.add(retainSelected());
			pop.add(hideSelected());
			pop.add(unselectAll());
		}

		if (!layerNodes.isEmpty()) {
			pop.add(cleanCanvas());
		}
	}

	@Override
	public void mouseExited(PInputEvent event) {
	}

	@Override
	public void keyboardFocusGained(PInputEvent event) {
		SwingUtilities.invokeLater(() -> canvas.setBorder(BorderFactory.createLineBorder(Color.RED)));
	}

	@Override
	public void keyboardFocusLost(PInputEvent event) {
		SwingUtilities.invokeLater(() -> canvas.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)));
	}

	public void clearMousePosition() {
		mousePositionNode.clear();
	}

	@Override
	public void keyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {

			case KeyEvent.VK_F:
				SwingUtilities.invokeLater(mousePositionNode::toggle);
				break;

			case KeyEvent.VK_R:

				SwingUtilities.invokeLater(() -> new LinkedHashSet<>(layerNodes.keySet()).forEach(new Consumer<UUID>() {
					@Override
					public void accept(UUID uuid) {
						if (selectedNodes.containsKey(uuid)) return;
						removeNodeFromCanvas(uuid);
					}
				}));
				break;

			case KeyEvent.VK_C:

				SwingUtilities.invokeLater(() -> {
					new ArrayList<>(selectedNodes.values()).forEach(new Consumer<N>() {
						@Override
						public void accept(N n) {
							removeNodeFromCanvas(n.uuid);
						}
					});
					event.getInputManager().setKeyboardFocus(this);
				});
				break;

			case KeyEvent.VK_A:

				if (selectedNodes.isEmpty()) {
					SwingUtilities.invokeLater(() -> layerNodes.keySet().forEach(uuid -> layerNodes.get(uuid).select()));

				} else {
					SwingUtilities.invokeLater(() -> {
						new ArrayList<>(selectedNodes.values()).forEach(N::unselect);
						event.getInputManager().setKeyboardFocus(this);
					});
				}

				break;

			case KeyEvent.VK_V:
				SwingUtilities.invokeLater(this::toggleRelationLabels);
				break;
		}
	}

	@Override
	public void keyReleased(PInputEvent event) {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

		switch (propertyChangeEvent.getPropertyName()) {

			case BasePNode.NODE_SELECTED: {
				selectNode((N) propertyChangeEvent.getSource());
				changeSupport.firePropertyChange(BasePNode.NODE_SELECTED, null, propertyChangeEvent.getSource());
				break;
			}

			case BasePNode.NODE_UNSELECTED: {
				unselectNode((N) propertyChangeEvent.getSource());
				changeSupport.firePropertyChange(BasePNode.NODE_UNSELECTED, null, propertyChangeEvent.getSource());
				break;
			}

			case BasePNode.NODE_UNHIGHLIGHTED: {
				changeSupport.firePropertyChange(BasePNode.NODE_UNHIGHLIGHTED, null, propertyChangeEvent.getSource());
				break;
			}

			case BasePNode.NODE_HIGHLIGHTED: {
				changeSupport.firePropertyChange(BasePNode.NODE_HIGHLIGHTED, null, propertyChangeEvent.getSource());
				break;
			}

			case BasePNode.NODE_ADDED: {
				nodeAdded((N) propertyChangeEvent.getSource());
				changeSupport.firePropertyChange(BasePNode.NODE_ADDED, null, propertyChangeEvent.getSource());
				break;
			}
			case BasePNode.NODE_REMOVED: {
				nodeRemoved((N) propertyChangeEvent.getSource());
				changeSupport.firePropertyChange(BasePNode.NODE_REMOVED, null, propertyChangeEvent.getSource());
				break;
			}

			case RelationPath.RELATION_REMOVED: {
				removeRelationFromCanvas((R) propertyChangeEvent.getSource());
				changeSupport.firePropertyChange(RelationPath.RELATION_REMOVED, null, propertyChangeEvent.getSource());
				break;
			}
		}
	}

	protected void selectNode(N instanceNode) {
		selectedNodes.put(instanceNode.uuid, instanceNode);
		mousePositionNode.nodeSelected(instanceNode.uuid);
	}

	protected void unselectNode(N instanceNode) {
		selectedNodes.remove(instanceNode.uuid);
		mousePositionNode.nodeUnselected(instanceNode.uuid);
//		System.out.println("unselected " + instanceNode.uuid + " left: " + selectedNodes.size());
	}

	public void retain(UUID... uuids) {

		final Set<UUID> retainSet = new LinkedHashSet<>(Arrays.asList(uuids));

		for (UUID nodeUUID : new LinkedHashSet<>(layerNodes.keySet())) {
			if (retainSet.contains(nodeUUID)) continue;
			removeNodeFromCanvas(nodeUUID);
		}
	}

	protected void nodeRemoved(N instanceNode) {
		instanceNode.removePropertyChangeListener(this);
		selectedNodes.remove(instanceNode.uuid);
	}

	protected void nodeAdded(N instanceNode) {
		if (instanceNode.selected.get()) selectedNodes.put(instanceNode.uuid, instanceNode);
	}

	public void showAndLayout(Map<UUID, org.neo4j.graphdb.Label> pNodes, Point2D centerPoint) {
		layoutColumn(pNodes, new Rectangle2D.Double(centerPoint.getX(), centerPoint.getY(), 1, 1));
	}

	public void showAndLayout(Map<UUID, org.neo4j.graphdb.Label> pNodes, PNode source) {
		layoutColumn(pNodes, source.getFullBoundsReference());
	}

	private void layoutColumn(Map<UUID, Label> pNodes, Rectangle2D.Double boundsReference) {
		final Point2D currentPoint = new Point.Double(boundsReference.getX(), boundsReference.getY());
		currentPoint.setLocation(boundsReference.getMaxX() + 20, boundsReference.getMaxY() + 20);
		for (UUID uuid : pNodes.keySet()) {
			// do not relayout visible nodes, but select it:
			if (layerNodes.containsKey(uuid)) {
				layerNodes.get(uuid).select();
				continue;
			}

			final N pNode = show(uuid, pNodes.get(uuid).name());
			final double x = currentPoint.getX();
			final double y = currentPoint.getY() + pNode.pNode.getHeight() + 15;
			pNode.setOffset(new Point2D.Double(x, y));
			currentPoint.setLocation(x, y);
		}

		//segment kinematic
//		var angle:Number = rotation * Math.PI / 180;
//		var xPos:Number = x + Math.cos(angle) * segmentWidth;
//		var yPos:Number = y + Math.sin(angle) * segmentWidth;
//		return new Point(xPos, yPos);


		SwingUtilities.invokeLater(canvas::repaint);
	}

	public void nodeMoved(UUID uuid) {

	}

	protected void toggleRelationLabels() {
		showRelationLabels.set(!showRelationLabels.get());

		layerRelations.values().forEach(neoRelationshipPath -> {
			if (showRelationLabels.get())
				neoRelationshipPath.showLabel();
			else
				neoRelationshipPath.hideLabel();
		});

		SwingUtilities.invokeLater(canvas::repaint);
	}

	public boolean isMouseShowing() {
		return mousePositionNode.isShowing.get();
	}

	public boolean hasLayerNodes() {
		return layerNodes.size() > 1;
	}

	public boolean singleNodeSelected(UUID uuid) {
		return selectedNodes.size() == 1 && !selectedNodes.keySet().iterator().next().equals(uuid);
	}

	class MousePositionNode extends PDragSequenceEventHandler implements PropertyChangeListener {

		final AtomicBoolean isShowing = new AtomicBoolean(false);

		private final MousePointPNode mousePointNode = new MousePointPNode();
		private final Map<UUID, RelationPath<MousePointPNode, N>> lines = new ConcurrentHashMap<>();

		@Override
		protected final void startDrag(PInputEvent event) {
			super.startDrag(event);
			setOffset(event.getCanvasPosition());
		}

		@Override
		protected final void drag(PInputEvent event) {
			super.drag(event);
			mousePointNode.pNode.translate(event.getDelta().width, event.getDelta().height);
			lines.values().forEach(new Consumer<RelationPath>() {
				@Override
				public void accept(RelationPath mouseRelationPath) {
					mouseRelationPath.target.pNode.translate(event.getDelta().width, event.getDelta().height);
				}
			});
		}

		@Override
		protected final void endDrag(PInputEvent event) {
			super.endDrag(event);
			setOffset(event.getCanvasPosition());
		}

		@Override
		protected final boolean shouldStartDragInteraction(PInputEvent event) {
			return super.shouldStartDragInteraction(event);
		}

		@Override
		protected final void dragActivityFirstStep(PInputEvent event) {

		}

		@Override
		protected final void dragActivityStep(PInputEvent event) {

		}

		@Override
		protected final void dragActivityFinalStep(PInputEvent event) {

		}

		@Override
		@SuppressWarnings("unchecked")
		public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
			switch (propertyChangeEvent.getPropertyName()) {
				case RelationPath.RELATION_REMOVED: {
					final R relation = (R) propertyChangeEvent.getSource();
					relationLayer.removeChild(relation.path);
					break;
				}
			}
		}

		public void toggle() {
			if (isShowing.get()) hide();
			else show();
		}

		public void nodeSelected(UUID uuid) {
			if (!isShowing.get()) return;

			addRelationToNode(selectedNodes.get(uuid));
		}

		public void nodeUnselected(UUID uuid) {
			if (!isShowing.get()) return;

			final RelationPath mouseRelationPath = lines.get(uuid);
			if (mouseRelationPath == null) return;

			mouseRelationPath.removePath();
		}

		private void addRelationToNode(N basePNode) {

			if (lines.containsKey(basePNode.uuid)) return;

			final RelationPath<MousePointPNode, N> relationshipPPath = new RelationPath<>(UUID.randomUUID(), mousePointNode, basePNode, "");
			lines.put(basePNode.uuid, relationshipPPath);

			relationshipPPath.addPropertyChangeListener(this);

			relationLayer.addChild(relationshipPPath.path);
			relationshipPPath.path.repaint();
			canvas.repaint();
		}

		private void show() {

			if (isShowing.get()) return;
			isShowing.set(true);

			nodeLayer.addChild(mousePointNode.pNode);
			selectedNodes.values().forEach(this::addRelationToNode);
			canvas.addInputEventListener(this);
		}

		private void hide() {

			if (!isShowing.get()) return;
			isShowing.set(false);

			// this will notify lines, and remove them
			nodeLayer.removeChild(mousePointNode.pNode);
			lines.clear();

			canvas.removeInputEventListener(this);
		}

		public final void setOffset(Point2D point) {
			mousePointNode.setOffset(point);
			mousePointNode.pNode.setPickable(false);
		}

		public void clear() {
			if (isShowing.get()) hide();
		}

		private class MousePointPNode extends BasePNode<PText> {

			MousePointPNode() {
				super(UUID.randomUUID(), new PText("X"), "Mouse", BaseEditor.this);
			}

			@Override
			public void onSelect() {

			}

			@Override
			public void onUnselect() {

			}

			@Override
			public void onStartHighlight() {

			}

			@Override
			public void onEndHighlight() {

			}

			@Override
			public void showNodeActions(JPopupMenu pop, PInputEvent event) {

			}

			@Override
			public void showTargetActions(JPopupMenu pop, PInputEvent event) {

			}

			@Override
			public void expand() {

			}

			@Override
			public void showDependents() {

			}
		}
	}
}