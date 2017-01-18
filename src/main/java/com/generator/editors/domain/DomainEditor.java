package com.generator.editors.domain;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.NeoModel.uuidOf;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DomainEditor extends NeoEditor {

	public enum Labels implements Label {
		DomainNode,
		DomainRelation
	}

	public enum Properties implements Label {
		name
	}

	public enum Relations implements RelationshipType {
	}

	public DomainEditor() {

		canvas.setBackground(Color.WHITE);

		for (Labels label : Labels.values())
			nodesByLabel.put(label.name(), new LinkedHashSet<>());
	}

	@Override
	public NeoPNode newNode(Node node, String nodetype) {

		if (nodetype == null || nodesByLabel.get(nodetype) == null) return super.newNode(node, null);
		nodesByLabel.get(nodetype).add(uuidOf(node));

		switch (Labels.valueOf(nodetype)) {
			case DomainNode:
				return newDomainNodePNode(node, DomainEditor.this);
			case DomainRelation:
				return newDomainRelationPNode(node, DomainEditor.this);			
		}
		throw new IllegalArgumentException("unsupported nodetype: " + nodetype);
	}

	protected NeoPNode newDomainNodePNode(Node node, DomainEditor editor) {
		return new DomainNodePNode(node, editor);
	}

	protected Node newDomainNode(NeoModel db, String name) {
		final Node node = db.newNode(Labels.DomainNode);
		node.setProperty("name",name);
		return node;
	}

	protected NeoPNode newDomainRelationPNode(Node node, DomainEditor editor) {
		return new DomainRelationPNode(node, editor);
	}

	protected Node newDomainRelation(NeoModel db, String name) {
		final Node node = db.newNode(Labels.DomainRelation);
		node.setProperty("name",name);
		return node;
	}

	@Override
	protected void addToMenu(JPopupMenu pop, PInputEvent event) {
		final JMenu newMenu = new JMenu("New");

		newMenu.add(new TransactionAction("DomainNode", getGraph(), canvas) {
			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				onNewDomainNode(e, tx, graph, event);
			}
		});

		newMenu.add(new TransactionAction("DomainRelation", getGraph(), canvas) {
			@Override
			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
				onNewDomainRelation(e, tx, graph, event);
			}
		});


		final JMenu showMenu = new JMenu("Show");
		graph.getAllLabelsInUse().forEach(new Consumer<org.neo4j.graphdb.Label>() {
			@Override
			public void accept(org.neo4j.graphdb.Label label) {
				for (Labels labels : Labels.values())
					if (label.name().equals(labels.name())) showMenu.add(showAllNodesByLabel(label, event));
			}
		});

		pop.add(newMenu);
		pop.add(showMenu);
		super.addToMenu(pop, event);
	}

	protected void onNewDomainNode(ActionEvent e, Transaction tx, NeoModel graph, PInputEvent event) throws Exception {
	}

	protected void onNewDomainRelation(ActionEvent e, Transaction tx, NeoModel graph, PInputEvent event) throws Exception {
	}

	public void deleteNode(Node node) throws NeoEditor.ReferenceException {
	}

	protected static class DomainNodePNode extends BasePNode {

		public DomainNodePNode(Node node, DomainEditor editor) {
			super(node, Labels.DomainNode, Properties.name.name(), editor);
		}
	}

	protected static class DomainRelationPNode extends BasePNode {

		public DomainRelationPNode(Node node, DomainEditor editor) {
			super(node, Labels.DomainRelation, Properties.name.name(), editor);
		}
	}


	static class BasePNode extends NeoPNode<PText> {

		protected final Color selectedColor = Color.RED;
		protected final Color defaultColor;
		private String property;
		final Labels nodeType;

		protected BasePNode(Node node, PText representation, Labels nodeType, DomainEditor editor) {
			super(node, representation, nodeType.name(), editor);
			this.defaultColor = new Color(200,50,125);
			this.property = null;
			this.nodeType = nodeType;
			pNode.setTextPaint(this.defaultColor);
			pNode.setFont(new Font("Hack", Font.PLAIN, 12));
		}

		protected BasePNode(Node node, Labels nodeType, String property, DomainEditor editor) {
			this(node, new PText(node.getProperty(property).toString()), nodeType, editor);
			this.property = property;
		}

		@Override
		public String getNodeType() {
			return nodeType.name();
		}

		@Override
		public void expand() {

		}

		@Override
		public void showDependents() {

		}

		@Override
		public void keyPressed(PInputEvent event) {
			super.keyPressed(event);
		}

		@Override
		public void updateView() {
			if (property == null) System.out.println("override updateView: property not set");
			pNode.setText(property == null ? "?" : node.getProperty(property).toString());
		}

		@Override
		public void onSelect() {
			pNode.setTextPaint(selectedColor);
		}

		@Override
		public void onUnselect() {
			pNode.setTextPaint(defaultColor);
		}

		@Override
		public void onStartHighlight() {
			pNode.setTextPaint(Color.ORANGE);
		}

		@Override
		public void onEndHighlight() {
			pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
		}

		@Override
		public void showNodeActions(JPopupMenu pop, PInputEvent event) {

			pop.add(new TransactionAction("Select all " + nodeType, editor.getGraph(), editor.canvas) {
				@Override
				public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
					editor.getAllNodes().forEach(new Consumer<NeoPNode>() {
						@Override
						public void accept(NeoPNode neoPNode) {
							if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
								neoPNode.select();
						}
					});
				}
			});
			pop.add(new TransactionAction("Hide all " + nodeType, editor.getGraph(), editor.canvas) {
				@Override
				public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
					final Set<UUID> hide = new LinkedHashSet<>();
					editor.getAllNodes().forEach(new Consumer<NeoPNode>() {
						@Override
						public void accept(NeoPNode pNode) {
							if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
						}
					});
					hide.forEach(editor::removeNodeFromCanvas);
				}
			});

			pop.add(retainNode());
			pop.add(hideNode());
			pop.add(new TransactionAction("Delete", editor.getGraph(), editor.canvas) {
				@Override
				public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
					if (SwingUtil.showConfirmDialog(editor.canvas, "Delete " + NeoModel.getNameOrLabelFrom(node) + " ?"))
						editor.deleteNode(node);
				}
			});
		}
	}

	public static class DomainEditorRenderPanel extends JPanel implements PropertyChangeListener {

		protected final JTextArea txtEditor = new JTextArea(25, 110);

		public DomainEditorRenderPanel() {
			super(new BorderLayout());
			txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
			txtEditor.setTabSize(3);
			txtEditor.setEditable(false);
			add(new JScrollPane(txtEditor), BorderLayout.CENTER);
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			switch (evt.getPropertyName()) {

				case BasePNode.NODE_HIGHLIGHTED: {

					final NeoEditor editor = (NeoEditor) evt.getSource();
					final BasePNode pNode = (BasePNode) evt.getNewValue();

					if (pNode instanceof BasePNode) {
						final BasePNode domainNode = (BasePNode) evt.getNewValue();
						switch (Labels.valueOf(domainNode.getNodeType())) {
							case DomainNode:
								editor.doInTransaction(tx -> renderDomainNode(domainNode));
									break;

							case DomainRelation:
								editor.doInTransaction(tx -> renderDomainRelation(domainNode));
									break;

						}

					} else {
						renderNonDomainNode(pNode);
					}
					break;
				}
			}
		}

		protected void renderDomainNode(BasePNode node) {
		}

		protected void renderDomainRelation(BasePNode node) {
		}

		protected void renderNonDomainNode(BasePNode basePNode) {
		}
	}

	public static void showEditor(DomainEditor editor) {
		showEditor(editor, new DomainEditorRenderPanel());
	}

	public static void showEditor(DomainEditor editor, DomainEditorRenderPanel renderPanel) {

		SwingUtil.setLookAndFeel_Nimbus();

		final JFrame frame = new JFrame();
		editor.addPropertyChangeListener(renderPanel);

		frame.getContentPane().add(editor.getCanvas(), BorderLayout.CENTER);
		frame.getContentPane().add(new JScrollPane(renderPanel), BorderLayout.EAST);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowGainedFocus(WindowEvent e) {
				editor.getCanvas().requestFocusInWindow();
			}
		});

		SwingUtil.show(frame);
	}
}