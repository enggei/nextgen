package com.generator.generators.templates;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Swing methods for Templates (Swing UI for neo, group and vertx)
 */
public class TemplatesSwing {

	private final TemplatesNeo db;

	public TemplatesSwing(TemplatesNeo db) {
		this.db = db;
	}

	public static abstract class TemplatesCanvasListener extends TemplatesNeoListener {

		protected final TemplatesNeo db;

		protected final PSwingCanvas canvas;
		protected final PLayer nodeLayer;
		protected final PLayer edgeLayer;
		protected final Map<UUID, PNode> layerNodes = new LinkedHashMap<>();

		protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
		protected final AtomicBoolean ctrlPressed = new AtomicBoolean(false);

		public TemplatesCanvasListener(TemplatesNeo db, PSwingCanvas canvas) {
			this.db = db;

			this.canvas = canvas;
			this.nodeLayer = canvas.getLayer();
			this.edgeLayer = new PLayer();
			this.canvas.getCamera().addLayer(0, edgeLayer);

			// Key handling
			final KeyListener keyAdapter = getKeyAdapter();
			canvas.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					canvas.addKeyListener(keyAdapter);
				}

				@Override
				public void focusLost(FocusEvent e) {
					canvas.removeKeyListener(keyAdapter);
				}
			});
		}

		protected abstract KeyListener getKeyAdapter();

		@Override
		public PNode newBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("BooleanTemplateParameter");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newBooleanTemplateParameterNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newBooleanTemplateParameterNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newBooleanTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allBooleanTemplateParameter(ResourceIterator<TemplatesNeo.BooleanTemplateParameterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newBooleanTemplateParameter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.BooleanTemplateParameterNode.BooleanTemplateParameterNodeVisitor newBooleanTemplateParameterNodeVisitor(); 

		@Override
		public PNode newKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("KeyValueListTemplateParameter");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newKeyValueListTemplateParameterNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newKeyValueListTemplateParameterNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Add KvNames") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// KeyValueListTemplateParameter

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newKeyValueListTemplateParameterNodeVisitor()).toString());
													//txtOutput.setCaretPosition(0);
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});
										});
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newKeyValueListTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allKeyValueListTemplateParameter(ResourceIterator<TemplatesNeo.KeyValueListTemplateParameterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newKeyValueListTemplateParameter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.KeyValueListTemplateParameterNode.KeyValueListTemplateParameterNodeVisitor newKeyValueListTemplateParameterNodeVisitor(); 

		@Override
		public PNode newListTemplateParameter(TemplatesNeo.ListTemplateParameterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("ListTemplateParameter");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newListTemplateParameterNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newListTemplateParameterNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newListTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allListTemplateParameter(ResourceIterator<TemplatesNeo.ListTemplateParameterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newListTemplateParameter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.ListTemplateParameterNode.ListTemplateParameterNodeVisitor newListTemplateParameterNodeVisitor(); 

		@Override
		public PNode newStatement(TemplatesNeo.StatementNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("Statement");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStatementNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStatementNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set TemplateStatement") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("TemplateStatement", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setTemplateStatement(db.newStringNode(value)).
											visit(newStatementNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allStatement(ResourceIterator<TemplatesNeo.StatementNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStatement(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.StatementNode.StatementNodeVisitor newStatementNodeVisitor(); 

		@Override
		public PNode newStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("StatementTemplateParameter");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStatementTemplateParameterNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStatementTemplateParameterNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStatementTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allStatementTemplateParameter(ResourceIterator<TemplatesNeo.StatementTemplateParameterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStatementTemplateParameter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.StatementTemplateParameterNode.StatementTemplateParameterNodeVisitor newStatementTemplateParameterNodeVisitor(); 

		@Override
		public PNode newStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("StringTemplateParameter");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringTemplateParameterNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringTemplateParameterNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStringTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Value") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Value", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setValue(db.newStringNode(value)).
											visit(newStringTemplateParameterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allStringTemplateParameter(ResourceIterator<TemplatesNeo.StringTemplateParameterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringTemplateParameter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.StringTemplateParameterNode.StringTemplateParameterNodeVisitor newStringTemplateParameterNodeVisitor(); 

		@Override
		public PNode newTemplateGroup(TemplatesNeo.TemplateGroupNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateGroup");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateGroupNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateGroupNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Delimiter") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Delimiter", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setDelimiter(db.newStringNode(value)).
											visit(newTemplateGroupNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Imports") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// TemplateGroup

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTemplateGroupNodeVisitor()).toString());
													//txtOutput.setCaretPosition(0);
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});
										});
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateGroupNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Package") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Package", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackage(db.newStringNode(value)).
											visit(newTemplateGroupNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add TemplateStatements") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// TemplateGroup

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTemplateGroupNodeVisitor()).toString());
													//txtOutput.setCaretPosition(0);
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});
										});
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allTemplateGroup(ResourceIterator<TemplatesNeo.TemplateGroupNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateGroup(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.TemplateGroupNode.TemplateGroupNodeVisitor newTemplateGroupNodeVisitor(); 

		@Override
		public PNode newTemplateGroupVisitor(TemplatesNeo.TemplateGroupVisitorNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateGroupVisitor");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateGroupVisitorNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateGroupVisitorNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateGroupVisitorNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set PackageName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("PackageName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newTemplateGroupVisitorNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set ReturnProperty") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("ReturnProperty", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setReturnProperty(db.newStringNode(value)).
											visit(newTemplateGroupVisitorNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set ReturnType") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("ReturnType", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setReturnType(db.newStringNode(value)).
											visit(newTemplateGroupVisitorNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allTemplateGroupVisitor(ResourceIterator<TemplatesNeo.TemplateGroupVisitorNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateGroupVisitor(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.TemplateGroupVisitorNode.TemplateGroupVisitorNodeVisitor newTemplateGroupVisitorNodeVisitor(); 

		@Override
		public PNode newTemplateImport(TemplatesNeo.TemplateImportNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateImport");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateImportNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateImportNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateImportNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allTemplateImport(ResourceIterator<TemplatesNeo.TemplateImportNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateImport(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.TemplateImportNode.TemplateImportNodeVisitor newTemplateImportNodeVisitor(); 

		@Override
		public PNode newTemplateStatement(TemplatesNeo.TemplateStatementNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateStatement");
			instanceNode.addInputEventListener(new TemplatesCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateStatementNodeVisitor());

					if (!ctrlPressed.get())
						selectedNodes.clear();
					selectedNodes.add(uuid);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {

					pop.add(new AbstractAction("Write to File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateStatementNodeVisitor()), new File(node.node().getProperty("file").toString()));
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set File") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
										if (file == null) return;

										node.node().setProperty("file", file.getAbsolutePath());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					});

					pop.add(new AbstractAction("Set Name") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Name", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateStatementNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add TemplateParameters") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// TemplateStatement

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTemplateStatementNodeVisitor()).toString());
													//txtOutput.setCaretPosition(0);
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});
										});
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Text") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Text", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setText(db.newStringNode(value)).
											visit(newTemplateStatementNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allTemplateStatement(ResourceIterator<TemplatesNeo.TemplateStatementNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateStatement(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeo.TemplateStatementNode.TemplateStatementNodeVisitor newTemplateStatementNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class TemplatesCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
							@Override
							public void doAction(Transaction tx) throws Throwable {
								addActionsTo(pop);
							}

							@Override
							public void exception(Throwable throwable) {
								SwingUtil.showException(canvas, throwable);
							}
						});

						final Point2D canvasPosition = event.getCanvasPosition();
						pop.show(canvas, (int) canvasPosition.getX(), (int) canvasPosition.getY());

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					});

				} else if (event.isLeftMouseButton()) {

					SwingUtilities.invokeLater(() -> db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							leftClick();
						}

						@Override
						public void exception(Throwable throwable) {
							SwingUtil.showException(canvas, throwable);
						}
					}));
				}
			}

			protected abstract void leftClick();

			protected abstract void addActionsTo(JPopupMenu pop);
		}

		private static void layoutCircle(Collection<PNode> pNodes, Point2D centerPoint, double radius) {

			double currentArc = Math.PI;
			double childRadians = (Math.PI * 2 / pNodes.size());

			for (PNode pNode : pNodes) {
				final double sin = Math.sin(currentArc + (childRadians / 2));
				final double cos = Math.cos(currentArc + (childRadians / 2));
				pNode.setOffset(new Point2D.Double(centerPoint.getX() + (radius * sin), centerPoint.getY() + (radius * cos)));
				currentArc += childRadians;
			}
		}

		private PNode addNodeToCanvas(UUID uuid, PNode instanceNode) {
			final Point2D.Double canvasCenterPoint = new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d);
			instanceNode.setOffset(canvasCenterPoint);
			layerNodes.put(uuid, instanceNode);
			nodeLayer.addChild(instanceNode);
			return instanceNode;
		}

		private void addLink(PNode parent, PNode child) {

			final PPath link = PPath.createLine(parent.getX(), parent.getY(), child.getX(), child.getY());
			link.setPickable(false);
			edgeLayer.addChild(link);

			parent.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, arg0 -> updateLink(parent, child, link));
			child.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, arg0 -> updateLink(parent, child, link));

			// todo: make the coordinates correct (this is not drawing them properly)
			updateLink(parent, child, link);
		}

		private void updateLink(PNode node1, PNode node2, PPath link) {
			final Point2D p1 = node1.getFullBoundsReference().getCenter2D();
			final Point2D p2 = node2.getFullBoundsReference().getCenter2D();
			final Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			link.reset();
			link.append(line, false);
			link.closePath();
		}
	} 

	public static class TemplatesNeoListener {

		public PNode newBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode node) {
			System.out.println("newBooleanTemplateParameterNode : " + node.getUuid());
			return new PText("BooleanTemplateParameter");
		} 

		public void allBooleanTemplateParameter(ResourceIterator<TemplatesNeo.BooleanTemplateParameterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode node) {
			System.out.println("newKeyValueListTemplateParameterNode : " + node.getUuid());
			return new PText("KeyValueListTemplateParameter");
		} 

		public void allKeyValueListTemplateParameter(ResourceIterator<TemplatesNeo.KeyValueListTemplateParameterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newListTemplateParameter(TemplatesNeo.ListTemplateParameterNode node) {
			System.out.println("newListTemplateParameterNode : " + node.getUuid());
			return new PText("ListTemplateParameter");
		} 

		public void allListTemplateParameter(ResourceIterator<TemplatesNeo.ListTemplateParameterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStatement(TemplatesNeo.StatementNode node) {
			System.out.println("newStatementNode : " + node.getUuid());
			return new PText("Statement");
		} 

		public void allStatement(ResourceIterator<TemplatesNeo.StatementNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode node) {
			System.out.println("newStatementTemplateParameterNode : " + node.getUuid());
			return new PText("StatementTemplateParameter");
		} 

		public void allStatementTemplateParameter(ResourceIterator<TemplatesNeo.StatementTemplateParameterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode node) {
			System.out.println("newStringTemplateParameterNode : " + node.getUuid());
			return new PText("StringTemplateParameter");
		} 

		public void allStringTemplateParameter(ResourceIterator<TemplatesNeo.StringTemplateParameterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateGroup(TemplatesNeo.TemplateGroupNode node) {
			System.out.println("newTemplateGroupNode : " + node.getUuid());
			return new PText("TemplateGroup");
		} 

		public void allTemplateGroup(ResourceIterator<TemplatesNeo.TemplateGroupNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateGroupVisitor(TemplatesNeo.TemplateGroupVisitorNode node) {
			System.out.println("newTemplateGroupVisitorNode : " + node.getUuid());
			return new PText("TemplateGroupVisitor");
		} 

		public void allTemplateGroupVisitor(ResourceIterator<TemplatesNeo.TemplateGroupVisitorNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateImport(TemplatesNeo.TemplateImportNode node) {
			System.out.println("newTemplateImportNode : " + node.getUuid());
			return new PText("TemplateImport");
		} 

		public void allTemplateImport(ResourceIterator<TemplatesNeo.TemplateImportNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateStatement(TemplatesNeo.TemplateStatementNode node) {
			System.out.println("newTemplateStatementNode : " + node.getUuid());
			return new PText("TemplateStatement");
		} 

		public void allTemplateStatement(ResourceIterator<TemplatesNeo.TemplateStatementNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplatesNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newBooleanTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new BooleanTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newBooleanTemplateParameter(db.newBooleanTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newBooleanTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allBooleanTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all BooleanTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allBooleanTemplateParameter(db.findAllBooleanTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newBooleanTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newKeyValueListTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new KeyValueListTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newKeyValueListTemplateParameter(db.newKeyValueListTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newKeyValueListTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allKeyValueListTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all KeyValueListTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allKeyValueListTemplateParameter(db.findAllKeyValueListTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newKeyValueListTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newListTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new ListTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newListTemplateParameter(db.newListTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newListTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allListTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all ListTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allListTemplateParameter(db.findAllListTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newListTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStatementAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new Statement") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStatement(db.newStatement());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStatement", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStatementAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all Statement") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStatement(db.findAllStatement());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStatement", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStatementTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new StatementTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStatementTemplateParameter(db.newStatementTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStatementTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStatementTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all StatementTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStatementTemplateParameter(db.findAllStatementTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStatementTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new StringTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringTemplateParameter(db.newStringTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStringTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringTemplateParameterAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all StringTemplateParameter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringTemplateParameter(db.findAllStringTemplateParameter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newStringTemplateParameter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateGroupAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new TemplateGroup") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateGroup(db.newTemplateGroup());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroup", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateGroupAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all TemplateGroup") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateGroup(db.findAllTemplateGroup());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroup", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateGroupVisitorAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new TemplateGroupVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateGroupVisitor(db.newTemplateGroupVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroupVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateGroupVisitorAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all TemplateGroupVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateGroupVisitor(db.findAllTemplateGroupVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroupVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateImportAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new TemplateImport") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateImport(db.newTemplateImport());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateImport", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateImportAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all TemplateImport") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateImport(db.findAllTemplateImport());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateImport", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateStatementAction(TemplatesNeoListener listener) {
   	return new AbstractAction("new TemplateStatement") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateStatement(db.newTemplateStatement());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateStatement", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateStatementAction(TemplatesNeoListener listener) {
   	return new AbstractAction("all TemplateStatement") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeo.TemplatesNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateStatement(db.findAllTemplateStatement());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateStatement", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesSwing neoSwing, TemplatesNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("BooleanTemplateParameter", 1, row);
			this.add(newJButton(neoSwing.newBooleanTemplateParameterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allBooleanTemplateParameterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("KeyValueListTemplateParameter", 1, row);
			this.add(newJButton(neoSwing.newKeyValueListTemplateParameterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allKeyValueListTemplateParameterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ListTemplateParameter", 1, row);
			this.add(newJButton(neoSwing.newListTemplateParameterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allListTemplateParameterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Statement", 1, row);
			this.add(newJButton(neoSwing.newStatementAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStatementAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StatementTemplateParameter", 1, row);
			this.add(newJButton(neoSwing.newStatementTemplateParameterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStatementTemplateParameterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringTemplateParameter", 1, row);
			this.add(newJButton(neoSwing.newStringTemplateParameterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringTemplateParameterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateGroup", 1, row);
			this.add(newJButton(neoSwing.newTemplateGroupAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateGroupAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateGroupVisitor", 1, row);
			this.add(newJButton(neoSwing.newTemplateGroupVisitorAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateGroupVisitorAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateImport", 1, row);
			this.add(newJButton(neoSwing.newTemplateImportAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateImportAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateStatement", 1, row);
			this.add(newJButton(neoSwing.newTemplateStatementAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateStatementAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final TemplatesSwing templatesNeoSwing = new TemplatesSwing(new TemplatesNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));
		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesNeoListener()));
	}
} 