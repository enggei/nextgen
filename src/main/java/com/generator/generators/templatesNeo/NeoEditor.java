package com.generator.generators.templatesNeo;

import com.generator.editors.domain.NeoModel;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import com.jgoodies.forms.layout.CellConstraints;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.nodes.PComposite;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

/**
 * goe on 9/12/16.
 */
public class NeoEditor extends JPanel {

	private static final Random random = new Random();

	public NeoEditor(Dimension preferredSize) {
		super(new BorderLayout(), true);

		final NeoCanvas canvas = new NeoCanvas(preferredSize);
		add(canvas, BorderLayout.CENTER);
		add(createCommandPanel(canvas), BorderLayout.NORTH);
	}

	private final class NeoCanvas extends PSwingCanvas {

		// add "add layer" action which creates new layers
		final PLayer nodeLayer;
		final PLayer edgeLayer;

		public NeoCanvas(Dimension preferredSize) {
			super();
			setPreferredSize(preferredSize);

			// Initialize, and create a layer for the edges (always underneath the nodes)
			nodeLayer = getLayer();
			edgeLayer = new PLayer();
			getCamera().addLayer(0, edgeLayer);

			removeInputEventListener(getPanEventHandler());
			addInputEventListener(new PDragEventHandler());
		}
	}

	private JPanel createCommandPanel(NeoCanvas canvas) {

		final JPanel commandPanel = new JPanel(new FlowLayout());

		commandPanel.add(new JButton(new AbstractAction("Open Graph") {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					final File testDB = Files.createTempDirectory("testDB").toFile();

					final GraphDatabaseService testGraph = new GraphDatabaseFactory().
						newEmbeddedDatabaseBuilder(testDB).
						newGraphDatabase();

					new NeoModel(testGraph, mod -> FileUtil.removeFilesUnderIncluding(testDB.getAbsolutePath()));

					canvas.nodeLayer.addChild(new GraphDatabaseNode(testGraph, canvas));

				} catch (IOException e1) {
					SwingUtil.showException(canvas, e1);
				}
			}
		}));

		return commandPanel;
	}

	private final class GraphDatabaseNode extends PNode {

		public GraphDatabaseNode(GraphDatabaseService graphDatabaseService, NeoCanvas canvas) {
			super();

			setBounds(canvas.getWidth() / 2, canvas.getHeight() / 2, 100, 80);
			setPaint(Color.RED);

			addInputEventListener(new BaseNodeInputHandler(this, canvas) {
				@Override
				protected void addPopupActions(JPopupMenu pop) {

					pop.add(new GraphTransactionAction(graphDatabaseService, canvas, "Add Node") {
						@Override
						public void doAction(Transaction tx) throws Throwable {

							final AddNodePanel addNodePanel = new AddNodePanel();
							SwingUtil.showApplyCloseDialog(addNodePanel, canvas, "Add Node", () -> {

								final String label = addNodePanel.txtLabels.getText().trim();
								if (label.length() == 0)
									throw new IllegalStateException("Node must have at least a label");

								doInTransaction(new SwingCommitter(canvas) {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										canvas.nodeLayer.addChild(newGraphNode(graphDatabaseService.createNode(Label.label(label)), canvas, GraphDatabaseNode.this));
									}
								}, graphDatabaseService);
							});
						}
					});

					pop.add(new GraphTransactionAction(graphDatabaseService, canvas, "Show all labels") {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							for (Label label : graphDatabaseService.getAllLabels()) {
								// there is no state here, so labels will be attached multiple times. Avoid this by wrapping a method in canvas (which tracks some nodes by maps etc.)
								canvas.nodeLayer.addChild(new PText(label.name()));
							}
						}
					});
				}

				private PComposite newGraphNode(Node neoNode, NeoCanvas canvas, PNode parent) {

					final PComposite graphNode = new PComposite();
					graphNode.addAttribute("neo.node", neoNode);

					final PBounds nodeBounds = parent.getBounds();
					final PNode rectangle = PPath.createRectangle(nodeBounds.x - 40, nodeBounds.y - 40, 50, 50);
					graphNode.addChild(rectangle);
					for (Label label : neoNode.getLabels()) {
						final PNode text = new PText(label.name());
						text.setBounds(rectangle.getBounds());
						graphNode.addChild(text);
					}

					graphNode.addInputEventListener(new BaseNodeInputHandler(graphNode, canvas) {
						@Override
						protected void addPopupActions(JPopupMenu pop) {
							pop.add(new GraphTransactionAction(graphDatabaseService, canvas, "Edit") {

								@Override
								public void doAction(Transaction tx) throws Throwable {
									final EditNodePanel addNodePanel = new EditNodePanel(neoNode);
									SwingUtil.showApplyCloseDialog(addNodePanel, canvas, "Edit Node", () -> {
										doInTransaction(new SwingCommitter(canvas) {
											@Override
											public void doAction(Transaction tx) throws Throwable {
												addNodePanel.commit(neoNode);
												invalidatePaint();   // invalidate node, and re-render
											}
										}, graphDatabaseService);
									});
								}
							});

							pop.add(new GraphTransactionAction(graphDatabaseService, canvas, "Expand All") {
								@Override
								public void doAction(Transaction tx) throws Throwable {

									for (Relationship relationship : neoNode.getRelationships(Direction.OUTGOING)) {

									}
								}
							});
						}
					});
					return graphNode;
				}
			});
		}
	}

	// add node panel:
	final class AddNodePanel extends SwingUtil.DebugFormPanel {

		final JTextField txtLabels = new JTextField();

		public AddNodePanel() {
			super("100dlu, 4dlu, 150dlu", "pref");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			addLabel("Labels", 1, row);
			add(txtLabels, 3, row);
		}
	}

	final class EditNodePanel extends SwingUtil.DebugFormPanel {

		final JTextField txtLabels = new JTextField();
		final JTable tblProperties = new JTable();
		final List<String> keys = new ArrayList<>();
		final Map<String, Object> values = new LinkedHashMap<>();

		EditNodePanel(Node node) {
			super("100dlu, 4dlu, 20dlu, 4dlu, 20dlu, 4dlu, 100dlu:grow", "pref, 4dlu, pref, 4dlu, 150dlu:grow");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			addLabel("Labels", 1, row);
			add(txtLabels, 3, row, 5, 1);

			row += 2;
			addLabel("Properties", 1, row, 7, 1, CellConstraints.LEFT, CellConstraints.CENTER);
			add(newAddPropertyButton(tblProperties), 3, row);
			add(newDelPropertyButton(tblProperties), 5, row);

			row += 2;
			addScrollPane(tblProperties, 1, row, 7, 1);

			setNode(node);
		}

		private JButton newAddPropertyButton(JTable tblProperties) {
			return newButton(new AbstractAction("+") {
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(() -> {
						final String key = "";
						keys.add(key);
						values.put(key, "");
						((AbstractTableModel) tblProperties.getModel()).fireTableRowsInserted(tblProperties.getRowCount(), tblProperties.getRowCount());
					});
				}
			});
		}

		private JButton newDelPropertyButton(JTable tblProperties) {
			return newButton(new AbstractAction("-") {
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(() -> {

						final int selectedRow = tblProperties.getSelectedRow();
						if (selectedRow == -1) return;

						final AbstractTableModel tableModel = (AbstractTableModel) tblProperties.getModel();
						values.remove(keys.remove(selectedRow));
						tableModel.fireTableRowsDeleted(selectedRow, selectedRow);
					});
				}
			});
		}

		private JButton newButton(AbstractAction action) {
			final JButton btn = new JButton(action);
			btn.setPreferredSize(new Dimension(30, 30));
			btn.setBorder(null);
			btn.setMargin(new Insets(0, 0, 0, 0));
			return btn;
		}

		private void setNode(Node node) {

			// update models
			keys.clear();
			values.clear();
			for (String key : node.getPropertyKeys()) {
				keys.add(key);
				values.put(key, node.getProperty(key));
			}

			final StringBuilder nodeLabels = new StringBuilder();
			boolean first = true;
			for (Label label : node.getLabels()) {
				if (!first) nodeLabels.append(", ");
				nodeLabels.append(label.name());
				first = false;
			}

			// model-to-views:
			txtLabels.setText(nodeLabels.toString());

			tblProperties.setModel(new AbstractTableModel() {
				@Override
				public int getRowCount() {
					return keys.size();
				}

				@Override
				public int getColumnCount() {
					return 2;
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					switch (columnIndex) {
						case 0:
							return keys.get(0);
						case 1:
							return values.get(keys.get(0));
					}
					throw new IllegalArgumentException("Illegal column: " + columnIndex);
				}

				@Override
				public String getColumnName(int column) {
					return column == 0 ? "Key" : "Value";
				}

				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return true;
				}

				@Override
				public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
					switch (columnIndex) {
						case 0:
							keys.set(rowIndex, aValue.toString());
							break;
						case 1:
							values.put(keys.get(rowIndex), aValue.toString());
							break;
					}
					fireTableCellUpdated(rowIndex, columnIndex);
				}

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return columnIndex == 0 ? String.class : String.class;   // todo: change if needed
				}
			});
		}

		public void commit(Node node) throws Exception {

			final String label = txtLabels.getText().trim();
			if (label.length() == 0)
				throw new IllegalStateException("Node must have at least a label");

			for (Label lbl : node.getLabels())
				node.removeLabel(lbl);

			for (String lbl : txtLabels.getText().trim().split(","))
				node.addLabel(Label.label(lbl));

			for (String key : keys)
				node.setProperty(key, values.get(key));
		}
	}

	//convenience classes and methods

	// base node-input handler
	abstract class BaseNodeInputHandler extends PBasicInputEventHandler {

		private final PNode node;
		private final PSwingCanvas canvas;
		protected boolean fIsPressed = false;

		BaseNodeInputHandler(PNode node, PSwingCanvas canvas) {
			this.node = node;
			this.canvas = canvas;
		}

		@Override
		public void keyPressed(PInputEvent event) {
			super.keyPressed(event);
			System.out.println("keypressed");
		}

		@Override
		public void keyReleased(PInputEvent event) {
			super.mousePressed(event);
			fIsPressed = false;
			node.invalidatePaint(); // this tells the framework that the node
			// needs to be redisplayed.
		}

		@Override
		public void keyTyped(PInputEvent event) {
			super.keyTyped(event);
			System.out.println("keytyped");
		}

		@Override
		public void mouseClicked(PInputEvent event) {
			super.mouseClicked(event);
			System.out.println("clicked");
		}

		@Override
		public void mousePressed(PInputEvent event) {
			super.mousePressed(event);

			if (event.isRightMouseButton()) {
				SwingUtilities.invokeLater(() -> {
					final JPopupMenu pop = new JPopupMenu();
					addPopupActions(pop);

					// transform coordinates:
					final Point2D canvasPosition = event.getCanvasPosition();
					pop.show(canvas, (int) canvasPosition.getX(), (int) canvasPosition.getY());
				});

			} else if (event.isLeftMouseButton()) {
				fIsPressed = true;
				node.invalidatePaint(); // this tells the framework that the node needs to be redisplayed.
			}
		}

		protected abstract void addPopupActions(JPopupMenu pop);

		@Override
		public void mouseDragged(PInputEvent event) {
			super.mouseDragged(event);
		}

		@Override
		public void mouseEntered(PInputEvent event) {
			super.mouseEntered(event);
			System.out.println("entered");
		}

		@Override
		public void mouseExited(PInputEvent event) {
			super.mouseExited(event);
			System.out.println("exited");
		}

		@Override
		public void mouseMoved(PInputEvent event) {
			super.mouseMoved(event);
		}

		@Override
		public void mouseReleased(PInputEvent event) {
			super.mouseReleased(event);
			System.out.println("released");
		}

		@Override
		public void mouseWheelRotated(PInputEvent event) {
			super.mouseWheelRotated(event);
			System.out.println("rotated");
		}

		@Override
		public void mouseWheelRotatedByBlock(PInputEvent event) {
			super.mouseWheelRotatedByBlock(event);
			System.out.println("rotatedByBlock");
		}

		@Override
		public void keyboardFocusGained(PInputEvent event) {
			super.keyboardFocusGained(event);
			System.out.println("focusGainedKeyboard");
		}

		@Override
		public void keyboardFocusLost(PInputEvent event) {
			super.keyboardFocusLost(event);
			System.out.print("focusGainedKeyboard");
		}
	}

	// action executed in a graph-transaction
	abstract class GraphTransactionAction extends AbstractAction implements Committer {

		private final GraphDatabaseService databaseService;
		private final Component parent;

		GraphTransactionAction(GraphDatabaseService databaseService, Component parent, String name) {
			super(name);
			this.databaseService = databaseService;
			this.parent = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			doInTransaction(this, databaseService);
		}

		@Override
		public void exception(Throwable throwable) {
			SwingUtil.showException(parent, throwable);
		}
	}

	// convenience class which shows exception as dialog over the component
	abstract static class SwingCommitter implements Committer {

		final Component component;

		SwingCommitter(Component component) {
			this.component = component;
		}

		@Override
		public void exception(Throwable throwable) {
			SwingUtil.showException(throwable, component);
		}
	}

	interface Committer {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	static void doInTransaction(Committer committer, GraphDatabaseService graphDatabaseService) {
		try (Transaction tx = graphDatabaseService.beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	public static void main(String[] args) {
		SwingUtil.showPanel(new NeoEditor(new Dimension(1024, 768)));
	}
}