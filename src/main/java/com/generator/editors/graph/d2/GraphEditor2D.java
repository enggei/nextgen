package com.generator.editors.graph.d2;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaRelation;
import com.generator.editors.domain.actions.*;
import com.generator.editors.domain.actions.d2.*;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphRelation;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
 * goe on 5/12/15.
 */
public class GraphEditor2D<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>> extends GraphEditor<E, R, G> {

	public GraphEditor2D(final MetaDomain<E, R> domain) {
		super(domain);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addComponentListener(this);
		this.addFocusListener(this);
	}

	@Override
	protected G newGraphNodeFor(MetaNode<E> metaNode, Node node) {

		final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
		final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

		return (G) new GraphNode2D<>(node, metaNode).
			setCenterX(x).
			setCenterY(y);
	}

	@Override
	protected GraphRelation<G, G, E> newGraphRelation(MetaRelation<E, R> metaRelation, Relationship relationship, G source, G target) {
		return new ShortestPathGraphRelation(relationship, source, target);
	}

	private final AtomicLong repaints = new AtomicLong(0);

	@Override
	protected void paintComponent(Graphics g) {
		final Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(getBackground());
		g2.fillRect(0, 0, getWidth(), getHeight());

		// gridlines

		g2.setColor(Color.LIGHT_GRAY);
		for (int y = 0; y < getHeight(); y += 10)
			g2.drawLine(0, y, getWidth(), y);
		for (int x = 0; x < getWidth(); x += 10)
			g2.drawLine(x, 0, x, getHeight());

		g2.setColor(Color.DARK_GRAY);
		final AtomicLong relations = new AtomicLong(0);
		for (GraphNode2D<E> node : visibleNodes()) {
			final boolean selected = isSelected(node.uuid());
			for (GraphRelation relation : node.getOutgoing()) {
				relation.paint(g2, selected);
				relations.incrementAndGet();
			}
		}

		for (GraphNode2D<E> node : visibleNodes())
			node.paint(g2, getWidth(), getHeight(), isSelected(node.uuid()), false);

		if (ctrlPressed && hasSelectedNodes() && last != null) {
			g2.setColor(Color.BLUE);
			for (UUID selectedNode : selectedNodes()) {
				final GraphNode2D node = getNode(selectedNode);
				g2.drawLine(node.centerX(), node.centerY(), last.getX(), last.getY());
			}
		}

		g.setColor(Color.BLACK);
		g.drawString("frame #" + (repaints.incrementAndGet()), 20, 20);
		g.drawString("nodes " + (visibleNodes().size()), 20, 40);
		g.drawString("relations " + (relations.get()), 20, 60);
	}

	protected void handleKeyPressed(JComponent editor,  KeyEvent e, boolean ctrlPressed, MouseEvent last) {

		// ignore keypressed if required here

		if (KeyEvent.VK_A == e.getKeyCode() && ctrlPressed) {
			new SelectAllAction(this).actionPerformed(null);
		} else if (KeyEvent.VK_A == e.getKeyCode() && this.getSelectedGraphNodes().size() == 1) {
			new SingleActionAction(this).actionPerformed(null);
		} else if (KeyEvent.VK_C == e.getKeyCode()) {
			new HideSelected(this).actionPerformed(null);
		} else if (KeyEvent.VK_Z == e.getKeyCode()) {
			new EditNodes<>(this).actionPerformed(null);
		} else if (KeyEvent.VK_O == e.getKeyCode()) {
			new HideOthers(this).actionPerformed(null);
		} else if (KeyEvent.VK_S == e.getKeyCode() && ctrlPressed) {
			new SaveLayout(this).actionPerformed(null);
		} else if (KeyEvent.VK_S == e.getKeyCode()) {   // select all visible of same labels
			new SelectAllWithSameLabel(this).actionPerformed(null);
		} else if (KeyEvent.VK_E == e.getKeyCode()) {
			new ExpandNodes(this).actionPerformed(null);
		} else if (KeyEvent.VK_I == e.getKeyCode()) {
			new ShowIncoming(this).actionPerformed(null);
		} else if (KeyEvent.VK_N == e.getKeyCode()) {
			new AddNode<>(null, this).actionPerformed(null);
		} else if (KeyEvent.VK_F == e.getKeyCode()) {
			new FindNode<>(null, this).actionPerformed(null);
		} else if (KeyEvent.VK_P == e.getKeyCode() && ctrlPressed) {
			new UnpinAction<>(this).actionPerformed(null);
		} else if (KeyEvent.VK_P == e.getKeyCode()) {
			new PinAction<>(this).actionPerformed(null);
		} else if (KeyEvent.VK_1 == e.getKeyCode() && ctrlPressed) {
			new LayoutInCircle(false, this, true).actionPerformed(null);
		} else if (KeyEvent.VK_1 == e.getKeyCode()) {
			new LayoutInCircle(true, this, true).actionPerformed(null);
		} else if (KeyEvent.VK_2 == e.getKeyCode() && ctrlPressed) {
			new LayoutInCircle(false, this, false).actionPerformed(null);
		} else if (KeyEvent.VK_2 == e.getKeyCode()) {
			new LayoutInCircle(true, this, false).actionPerformed(null);
		} else if (KeyEvent.VK_3 == e.getKeyCode() && ctrlPressed) {
			new LayoutInGrid(this, last, false).actionPerformed(null);
		} else if (KeyEvent.VK_3 == e.getKeyCode()) {
			new LayoutInGrid(this, last, true).actionPerformed(null);
		} else if (KeyEvent.VK_4 == e.getKeyCode() && ctrlPressed) {
			new LayoutDiagonally(this, last, false).actionPerformed(null);
		} else if (KeyEvent.VK_4 == e.getKeyCode()) {
			new LayoutDiagonally(this, last, true).actionPerformed(null);
		}
	}

	protected void rightClickTarget(Set<G> selectedNodes, G targetNode) {
		new AddRelation(selectedNodes, targetNode, this).actionPerformed(null);
	}

	protected void rightClickSelect(MouseEvent e, JPopupMenu popupMenu, G targetNode) {
		popupMenu.add(new EditNodes<>(this));

//        newPropertiesMenu(targetNode, popupMenu);

		newAddFromDomainMenu(e, targetNode.node(), popupMenu);

		newDeleteRelationsMenu(targetNode, getSelectedGraphNodes(), popupMenu);

		try (Transaction tx = getModel().beginTx()) {
			final Set<MetaNode<E>> sourceMetaNodes = getDomain().getMetaNodes(getSelectedNodes());
			final Set<MetaNode<E>> targetMetaNodes = getDomain().getMetaNodes(Collections.singleton(targetNode.node()));
			final Set<MetaRelation<E, R>> relations = getDomain().getMetaRelations(sourceMetaNodes, targetMetaNodes);

			if (relations.size() != 0)
				popupMenu.add(new AddRelation<>(getSelectedGraphNodes(), targetNode, this));
			tx.success();
		}

		popupMenu.add(new GetAllBySameLabel<>(this));
		popupMenu.add(new DeleteNodes<>(this));
		popupMenu.add(new CloneNodes<>(getSelectedGraphNodes(), e, this));
		popupMenu.add(new PinAction<>(this));
		popupMenu.add(new UnpinAction<>(this));

		popupMenu.add(new RelationMatrix(this));
		popupMenu.add(new ExportCypher<>(this, Collections.singleton(targetNode.node())));
	}

	protected void rightClickNoSelect(MouseEvent e, JPopupMenu popupMenu) {

		newAddFromDomainMenu(e, null, popupMenu);

		popupMenu.add(new ShowQueryEditor(this));
		popupMenu.add(newLayoutMenu());
		popupMenu.add(newShowDomainMenu());
		popupMenu.add(new ExportCypher<>(this));
		popupMenu.add(new ImportFromCypher<>(this));
	}

	public void updateRelationships(G graphNode) {

		if (graphNode == null) return;

		try (Transaction tx = getModel().beginTx()) {

			for (Relationship relationship : graphNode.node().getRelationships(Direction.OUTGOING)) {
				if (getNode(uuidOf(relationship.getOtherNode(graphNode.node()))) == null) continue;
				newGraphRelation(domain.getMetaRelation(relationship), relationship, graphNode, getNode(uuidOf(relationship.getOtherNode(graphNode.node()))));
			}

			for (Relationship relationship : graphNode.node().getRelationships(Direction.INCOMING)) {
				final UUID otherUUID = uuidOf(relationship.getOtherNode(graphNode.node()));
				if (getNode(otherUUID) == null) continue;
				newGraphRelation(domain.getMetaRelation(relationship), relationship, getNode(otherUUID), graphNode);
			}

			tx.success();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (ignoreKeys.get()) return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (ignoreKeys.get()) return;

		if (KeyEvent.VK_CONTROL == e.getKeyCode()) {
			ctrlPressed = true;
			requestRepaint();
			return;
		}

		handleKeyPressed(this, e, ctrlPressed, last);

		requestRepaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if (ignoreKeys.get()) return;

		if (KeyEvent.VK_CONTROL == e.getKeyCode())
			ctrlPressed = false;

		requestRepaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {

			if (getNodeAt(e) == null) {
				clearSelection();
				requestRepaint();
			}

		} else if (SwingUtilities.isRightMouseButton(e)) {
			last = e;

			final JPopupMenu popupMenu = new JPopupMenu();
			if (!hasSelectedNodes()) {

				rightClickNoSelect(e, popupMenu);

			} else {
				final G targetNode = getNodeAt(e);

				if (targetNode == null) {
					clearSelection();
					requestRepaint();
				} else {

					if (isSelected(targetNode.uuid())) {
						rightClickSelect(e, popupMenu, targetNode);

					} else {
						if (MouseEvent.MOUSE_RELEASED == e.getID() || MouseEvent.MOUSE_CLICKED == e.getID()) {
							rightClickTarget(getSelectedGraphNodes(), targetNode);
							return;
						}
					}
				}
				ctrlPressed = false;
			}

			popupMenu.show(GraphEditor2D.this, e.getX(), e.getY());
		}

		super.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (!ctrlPressed) clearSelection();
			final G selectedNode = getNodeAt(e);
			if (selectedNode != null) {
				if (isSelected(selectedNode.uuid()) && ctrlPressed) selectedNodes.remove(selectedNode.uuid());
				else selectNode(selectedNode.uuid());
			}
			requestRepaint();

		} else if (SwingUtilities.isRightMouseButton(e)) {
			requestRepaint();
		}

		super.mousePressed(e);
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if (last != null) {
			for (UUID selectedNode : selectedNodes())
				getNode(selectedNode).move((e.getX() - last.getX()), (e.getY() - last.getY()));
		}
		requestRepaint();
		super.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);

		for (G node : visibleNodes())
			if (node.contains(e)) break;

		if (ctrlPressed)
			requestRepaint();
	}

	@Override
	public void componentResized(ComponentEvent e) {
		requestRepaint();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
		addKeyListener(GraphEditor2D.this);
		requestFocusInWindow();
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		removeKeyListener(GraphEditor2D.this);
		ctrlPressed = false;
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	public G newGraphNode(Node node, MouseEvent mouseEvent) {
		int x = mouseEvent == null ? (last == null ? random.nextInt(getWidth() - 20) + 35 : (last.getX() + (random.nextInt(50) * (random.nextBoolean() ? 1 : -1)))) : mouseEvent.getX();
		int y = mouseEvent == null ? (last == null ? random.nextInt(getHeight() - 20) + 35 : (last.getY() + (random.nextInt(50) * (random.nextBoolean() ? 1 : -1)))) : mouseEvent.getY();
		return (G) getOrAdd(node).setCenterX(x).setCenterY(y);
	}

	public G newGraphNode(Node node, int x, int y) {
		return (G) getOrAdd(node).setCenterX(x).setCenterY(y);
	}

	protected G getNodeAt(MouseEvent e) {
		for (G node : visibleNodes())
			if (node.contains(e)) return node;
		return null;
	}

	protected Set<UUID> selectedNodes() {
		return new LinkedHashSet<>(selectedNodes);
	}

	public MouseEvent getLast() {
		return last;
	}

	protected void newAddFromDomainMenu(final MouseEvent mouseEvent, final Node node, JPopupMenu popupMenu) {
		try (Transaction tx = getModel().beginTx()) {

			if (node == null) {
				// todo: remove root-node and allow to create any domain-node.
				final MetaNode<E> rootNode = domain.getRootNode();
				if (rootNode == null) return;
				popupMenu.add(new AddNodeWithLabel(rootNode, mouseEvent, this));
			} else {

				for (GraphEditorAction allowedAddAction : getAllowedAddActions(mouseEvent.getX(), mouseEvent.getY(), node))
					popupMenu.add(allowedAddAction);
			}
			tx.success();
		}
	}

	public void addVisitor(JPopupMenu popupMenu, G targetNode, final BaseDomainVisitor<E> visitor) {
		popupMenu.add(new VisitorAction<>(visitor.getName(), this, targetNode, visitor, domain));
	}

	public Set<GraphEditorAction> getAllowedAddActions(final int x, final int y, final Node node) {
		final Set<GraphEditorAction> allowedAddActions = new LinkedHashSet<>();

		try (Transaction tx = getModel().beginTx()) {
			final MetaNode<E> metaNode = domain.getMetaNode(node);
			for (final MetaRelation<E, R> metaRelation : getTargetRelationsFor(metaNode)) {
				for (final E target : metaRelation.targets()) {

					// constraint one-to-one here
					if (metaRelation.getCardinality().equals(MetaRelation.Cardinality.OneToOne) && node.hasRelationship(Direction.OUTGOING, metaRelation.getType()))
						continue;

					final GraphEditorAction addRelationAction = new GraphEditorAction("Add " + target.name() + " (" + metaRelation.getName() + ") ", this) {
						@Override
						public void doAction(Transaction tx) {
							final Node newNode = domain.newNode(target, UUID.randomUUID());
							final Relationship relationship = node.createRelationshipTo(newNode, domain.type(metaRelation.getName()));
							relationship.setProperty("type", target.name());
							clearSelection();
							newGraphNode(newNode, Math.max(0, Math.min(x + random.nextInt(40) + 10, editor.getWidth())), Math.max(0, Math.min(y + random.nextInt(40) + 10, editor.getHeight())));
						}
					};
					allowedAddActions.add(addRelationAction);
				}
			}
			tx.success();
		}
		return allowedAddActions;
	}

	protected JMenu newLayoutMenu() {

		final JMenu layoutMenu = new JMenu("Layouts...");
		final JMenu saveMenu = new JMenu("Save");
		final boolean showSaveMenu = !visibleNodes().isEmpty();

		try (Transaction tx = getModel().beginTx()) {

			if (showSaveMenu) {
				layoutMenu.add(saveMenu);
				saveMenu.add(new SaveLayout(this)); // new save
			}

			final JMenu deleteLayoutMenu = new JMenu("Delete...");

			// todo: delete this, this is old:
			boolean isDone = true; // when this is system-out'ed, delete this functionality
			for (final Node node : getModel().getAll(MetaDomain.MetaLabels.LAYOUT.name())) {
				final String layoutName = node.hasProperty("name") ? (node.getProperty("name") + "") : "?";
				layoutMenu.add(new LoadLayout(node, this));
				deleteLayoutMenu.add(new DeleteLayout(node, this));
				saveMenu.add(new SaveLayout(this, layoutName)); // save as...
				isDone = false;
			}
			if (isDone) System.out.println(" delete old Layout");

			// todo: keep this,this is per-domain-layout
			for (final Node node : getModel().getAll(domain.layoutKey())) {
				final String layoutName = node.hasProperty("name") ? (node.getProperty("name") + "") : "?";

				layoutMenu.add(new LoadLayout(node, this));
				deleteLayoutMenu.add(new DeleteLayout(node, this));
				saveMenu.add(new SaveLayout(this, layoutName)); // save as...
			}
			layoutMenu.add(deleteLayoutMenu);

			tx.success();
		}

		return layoutMenu;
	}

	protected JMenu newShowDomainMenu() {
		final JMenu labelMenu = new JMenu("Show...");
		try (Transaction tx = getModel().beginTx()) {
			for (final MetaNode<E> node : domain.getAllNodes()) {
				labelMenu.add(new GetAllByLabel(node.getLabel().name(), this));
			}
			tx.success();
		}
		return labelMenu;
	}

	protected void newDeleteRelationsMenu(final G node, Set<G> selectedNodes, JPopupMenu popupMenu) {

		final JMenu delMenu = new JMenu("Del...");
		boolean hasDeleteRelations = false;
		if (selectedNodes.size() == 1) {

			// if only 1 node selected, show only outgoing relations with options to delete
			try (Transaction tx = getModel().beginTx()) {
				for (final Relationship relationship : node.node().getRelationships(Direction.OUTGOING)) {
					final MetaRelation<E, R> metaRelation = getDomain().getMetaRelation(relationship);
					if (metaRelation == null) continue; // if relationship is not part of this domain, ignore it

					final Node otherNode = relationship.getOtherNode(node.node());
					final MetaNode<E> metaNode = getDomain().getMetaNode(otherNode);
					if (metaNode == null) {
						// valid relationship, but unknown meta-node, ignore it (should not happen)
						System.err.println("Illegal state: " + metaRelation.getName() + " has unknown target-node (" + domain.listLabelsFor(otherNode) + ")");
						continue;
					}

					delMenu.add(new DeleteRelation(node, relationship, otherNode, this));
					hasDeleteRelations = true;
				}
				tx.success();
			}
			popupMenu.add(delMenu);
		}

		// multiple nodes selected, only show outgoing relations from node to the other selected nodes
		final Set<Node> otherNodes = new LinkedHashSet<>();
		for (G selectedNode : selectedNodes) otherNodes.add(selectedNode.node());

		try (Transaction tx = getModel().beginTx()) {
			for (final Relationship relationship : node.node().getRelationships(Direction.OUTGOING)) {
				final MetaRelation<E, R> metaRelation = getDomain().getMetaRelation(relationship);
				if (metaRelation == null) continue; // if relationship is not part of this domain, ignore it

				final Node otherNode = relationship.getOtherNode(node.node());
				final MetaNode<E> metaNode = getDomain().getMetaNode(otherNode);
				if (metaNode == null) {
					// valid relationship, but unknown meta-node, ignore it (should not happen)
					System.err.println("Illegal state: " + metaRelation.getName() + " has unknown target-node (" + domain.listLabelsFor(otherNode) + ")");
					continue;
				}

				if (otherNodes.contains(otherNode)) {
					delMenu.add(new DeleteRelation(node, relationship, otherNode, this));
					hasDeleteRelations = true;
				}
			}
			tx.success();
		}

		if (hasDeleteRelations) popupMenu.add(delMenu);
	}

	private Set<MetaRelation<E, R>> getTargetRelationsFor(MetaNode<E> metaNode) {
		final Set<MetaRelation<E, R>> set = new LinkedHashSet<>();
		if (metaNode == null) return set;
		for (MetaRelation<E, R> metaRelation : domain.getAllRelations()) {
			if (metaRelation.isSource(metaNode)) set.add(metaRelation);
		}
		return set;
	}
}