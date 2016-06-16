package com.generator.editors.graph;

import com.generator.editors.domain.*;
import com.generator.editors.domain.editors.NodeEditor;
import com.generator.editors.domain.editors.NodePropertiesEditorPanel;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
 * goe on 5/15/15.
 */
public abstract class GraphEditor<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>> extends JPanel implements KeyListener, MouseListener, MouseMotionListener, ComponentListener, FocusListener, ActionListener {

	protected static final Random random = new Random();

	protected MetaDomain<E, R> domain;
	protected final Map<UUID, G> visibleNodes = new LinkedHashMap<>();
	protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
	protected boolean ctrlPressed = false;
	protected MouseEvent last = null;

//    protected final Timer animationTimer = new Timer(50, this);
//    protected final AtomicLong frameCount = new AtomicLong(0);

	protected final AtomicBoolean ignoreKeys = new AtomicBoolean(false);

	public GraphEditor(MetaDomain<E, R> domain) {
		this.domain = domain;
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));

//        animationTimer.start();
	}

	public abstract G newGraphNode(Node node, MouseEvent mouseEvent);

	public abstract void updateRelationships(G graphNode);

	protected abstract G newGraphNodeFor(MetaNode<E> metaNode, Node node);

	protected abstract GraphRelation<G, G, E> newGraphRelation(MetaRelation<E, R> metaRelation, Relationship relationship, G source, G target);

	@Override
	public void actionPerformed(ActionEvent e) {
		requestRepaint();
	}

	public G getOrAdd(Node node) {

		G graphNode = getNode(uuidOf(node));
		if (graphNode != null) {
			selectNode(graphNode.uuid());
			return graphNode;
		}

		final MetaNode<E> metaNode = domain.getMetaNode(node);
		add(graphNode = newGraphNodeFor(metaNode, node));
		updateRelationships(graphNode);

		return graphNode;
	}

	public void add(G graphNode) {

		if (graphNode == null) return; // ignore if graphNode is null

		visibleNodes.put(graphNode.uuid(), graphNode);
		selectNode(graphNode.uuid());
	}

	public Set<MetaNode<E>> getMetaNodes(Set<G> graphNodes) {
		final Set<Node> nodes = new LinkedHashSet<>();
		for (G node : graphNodes)
			nodes.add(node.node());
		return getDomain().getMetaNodes(nodes);
	}

	public Set<G> getSelectedGraphNodes() {
		final Set<G> graphNodes = new LinkedHashSet<>();
		for (UUID node : selectedNodes) {
			final G graphNode = visibleNodes.get(node);
			if (graphNode == null) {
				System.out.println("WTF");
				continue;
			}
			graphNodes.add(graphNode);
		}
		return graphNodes;
	}

	public Set<Node> getSelectedNodes() {
		final Set<Node> graphNodes = new LinkedHashSet<>();
		for (UUID node : selectedNodes) {
			final Node graphNode = visibleNodes.get(node).node;
			if (graphNode == null) {
				System.out.println("WTF");
				continue;
			}
			graphNodes.add(graphNode);
		}
		return graphNodes;
	}

	public MetaDomain<E, R> getDomain() {
		return domain;
	}

	public NeoModel getModel() {
		return domain.getModel();
	}

	public GraphEditor removeNode(UUID uuid) {

		final G graphNode = visibleNodes.remove(uuid);
		if (graphNode == null) return this;

		selectedNodes.remove(uuid);
		graphNode.remove();
		return this;
	}

	public void selectAllVisibleNodes() {
		selectedNodes.addAll(visibleNodes.keySet());
	}

	public void retainSelected() {
		final Set<UUID> visible = new LinkedHashSet<>(visibleNodes.keySet());
		visible.removeAll(selectedNodes);
		for (UUID uuid : visible)
			removeNode(uuid);
	}

	public void selectNode(UUID uuid) {
		if (!visibleNodes.containsKey(uuid)) return;
		selectedNodes.add(uuid);
	}

	public void removeSelected() {
		UUID node = selectedNodes.isEmpty() ? null : selectedNodes.iterator().next();
		while (node != null) {
			removeNode(node);
			node = selectedNodes.isEmpty() ? null : selectedNodes.iterator().next();
		}
	}

	public GraphEditor removeNode(Node node) {
		if (!NeoModel.hasUUID(node)) return this;
		return removeNode(NeoModel.uuidOf(node));
	}

	public void clearSelection() {
		selectedNodes.clear();
	}

	protected boolean isSelected(UUID uuid) {
		return selectedNodes.contains(uuid);
	}

	protected boolean hasSelectedNodes() {
		return !selectedNodes.isEmpty();
	}

	public void requestRepaint() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				repaint();
			}
		});
	}

	public void clearButtonsPressed() {
		ctrlPressed = false;
	}

//    protected final boolean isType(GraphNode<E> targetNode, E flow) {
//        final MetaNode<E> metaNode = domain.getMetaNode(targetNode.node());
//        return (metaNode != null) && metaNode.getLabel().equals(flow);
//    }

	public G getNode(UUID node) {
		return visibleNodes.get(node);
	}

	public Collection<G> visibleNodes() {
		return visibleNodes.values();
	}

	@Override
	public String toString() {
		return domain.toString();
	}

	protected String showStringEditorFor(G targetNode, MetaProperty metaProperty) {
		return SwingUtil.showInputDialog("Set " + metaProperty.getName(), this, metaProperty.valueIn(targetNode.node()) + "");
	}

	@Override
	public void componentResized(ComponentEvent e) {

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (ignoreKeys.get()) return;
		System.out.println("WTF Typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (ignoreKeys.get()) return;
		System.out.println("WTF Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (ignoreKeys.get()) return;
		System.out.println("WTF Released");
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		last = e;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		last = e;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		last = e;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		last = e;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		last = e;
	}

	@SuppressWarnings("unchecked")
	public NodeEditor getNodeEditor(MetaNode<E> metaNode, G node, final GraphEditor editor) {
		return new NodeEditor(editor, metaNode.getLabel(), new NodePropertiesEditorPanel(editor, metaNode, node));
	}

	public void disableKeyEvents() {
		this.ignoreKeys.set(true);
	}

	public void enableKeyEvents() {
		this.ignoreKeys.set(false);
	}
}