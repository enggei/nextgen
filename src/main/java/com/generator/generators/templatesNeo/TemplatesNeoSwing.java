package com.generator.generators.templatesNeo;

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
 * Swing methods for TemplatesNeo (Swing UI for neo, group and vertx)
 */
public class TemplatesNeoSwing {

	private final TemplatesNeoNeo db;

	public TemplatesNeoSwing(TemplatesNeoNeo db) {
		this.db = db;
	}

	public static abstract class TemplatesNeoCanvasListener extends TemplatesNeoNeoListener {

		protected final TemplatesNeoNeo db;

		protected final PSwingCanvas canvas;
		protected final PLayer nodeLayer;
		protected final PLayer edgeLayer;
		protected final Map<UUID, PNode> layerNodes = new LinkedHashMap<>();

		protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
		protected final AtomicBoolean ctrlPressed = new AtomicBoolean(false);

		public TemplatesNeoCanvasListener(TemplatesNeoNeo db, PSwingCanvas canvas) {
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
		public PNode newNeoGroupClassDeclaration(TemplatesNeoNeo.NeoGroupClassDeclarationNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("NeoGroupClassDeclaration");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newNeoGroupClassDeclarationNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newNeoGroupClassDeclarationNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					pop.add(new AbstractAction("Add Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// NeoGroupClassDeclaration

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeoNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeoNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newNeoGroupClassDeclarationNodeVisitor()).toString());
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newNeoGroupClassDeclarationNodeVisitor());
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newNeoGroupClassDeclarationNodeVisitor());
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
		public void allNeoGroupClassDeclaration(ResourceIterator<TemplatesNeoNeo.NeoGroupClassDeclarationNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newNeoGroupClassDeclaration(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.NeoGroupClassDeclarationNode.NeoGroupClassDeclarationNodeVisitor newNeoGroupClassDeclarationNodeVisitor(); 

		@Override
		public PNode newBugfix2(TemplatesNeoNeo.bugfix2Node node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("bugfix2");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newBugfix2NodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newBugfix2NodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allBugfix2(ResourceIterator<TemplatesNeoNeo.bugfix2Node> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newBugfix2(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.bugfix2Node.bugfix2NodeVisitor newBugfix2NodeVisitor(); 

		@Override
		public PNode newDeclaration(TemplatesNeoNeo.declarationNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("declaration");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newDeclarationNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newDeclarationNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					pop.add(new AbstractAction("Set GroupName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("GroupName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newDeclarationNodeVisitor());
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newDeclarationNodeVisitor());
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
		public void allDeclaration(ResourceIterator<TemplatesNeoNeo.declarationNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newDeclaration(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.declarationNode.declarationNodeVisitor newDeclarationNodeVisitor(); 

		@Override
		public PNode newDefaultNodeTypes(TemplatesNeoNeo.defaultNodeTypesNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("defaultNodeTypes");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newDefaultNodeTypesNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newDefaultNodeTypesNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

				}
			});

			return addNodeToCanvas(uuid, instanceNode);
		}

		@Override
		public void allDefaultNodeTypes(ResourceIterator<TemplatesNeoNeo.defaultNodeTypesNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newDefaultNodeTypes(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.defaultNodeTypesNode.defaultNodeTypesNodeVisitor newDefaultNodeTypesNodeVisitor(); 

		@Override
		public PNode newKeyValueListInterfaceDecl(TemplatesNeoNeo.keyValueListInterfaceDeclNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("keyValueListInterfaceDecl");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newKeyValueListInterfaceDeclNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newKeyValueListInterfaceDeclNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newKeyValueListInterfaceDeclNodeVisitor());
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
		public void allKeyValueListInterfaceDecl(ResourceIterator<TemplatesNeoNeo.keyValueListInterfaceDeclNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newKeyValueListInterfaceDecl(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.keyValueListInterfaceDeclNode.keyValueListInterfaceDeclNodeVisitor newKeyValueListInterfaceDeclNodeVisitor(); 

		@Override
		public PNode newKeyValueListSetter(TemplatesNeoNeo.keyValueListSetterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("keyValueListSetter");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newKeyValueListSetterNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newKeyValueListSetterNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// keyValueListSetter

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeoNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeoNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newKeyValueListSetterNodeVisitor()).toString());
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
					pop.add(new AbstractAction("Set PropertyName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("PropertyName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPropertyName(db.newStringNode(value)).
											visit(newKeyValueListSetterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set StatementName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("StatementName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setStatementName(db.newStringNode(value)).
											visit(newKeyValueListSetterNodeVisitor());
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
		public void allKeyValueListSetter(ResourceIterator<TemplatesNeoNeo.keyValueListSetterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newKeyValueListSetter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.keyValueListSetterNode.keyValueListSetterNodeVisitor newKeyValueListSetterNodeVisitor(); 

		@Override
		public PNode newKeyValueRelationships(TemplatesNeoNeo.keyValueRelationshipsNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("keyValueRelationships");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newKeyValueRelationshipsNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newKeyValueRelationshipsNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newKeyValueRelationshipsNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Types") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// keyValueRelationships

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesNeoNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesNeoNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newKeyValueRelationshipsNodeVisitor()).toString());
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
		public void allKeyValueRelationships(ResourceIterator<TemplatesNeoNeo.keyValueRelationshipsNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newKeyValueRelationships(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.keyValueRelationshipsNode.keyValueRelationshipsNodeVisitor newKeyValueRelationshipsNodeVisitor(); 

		@Override
		public PNode newKeyValueVisitor(TemplatesNeoNeo.keyValueVisitorNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("keyValueVisitor");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newKeyValueVisitorNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newKeyValueVisitorNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newKeyValueVisitorNodeVisitor());
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
		public void allKeyValueVisitor(ResourceIterator<TemplatesNeoNeo.keyValueVisitorNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newKeyValueVisitor(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.keyValueVisitorNode.keyValueVisitorNodeVisitor newKeyValueVisitorNodeVisitor(); 

		@Override
		public PNode newListInterfaceDecl(TemplatesNeoNeo.listInterfaceDeclNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("listInterfaceDecl");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newListInterfaceDeclNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newListInterfaceDeclNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newListInterfaceDeclNodeVisitor());
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
		public void allListInterfaceDecl(ResourceIterator<TemplatesNeoNeo.listInterfaceDeclNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newListInterfaceDecl(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.listInterfaceDeclNode.listInterfaceDeclNodeVisitor newListInterfaceDeclNodeVisitor(); 

		@Override
		public PNode newListSetter(TemplatesNeoNeo.listSetterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("listSetter");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newListSetterNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newListSetterNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					pop.add(new AbstractAction("Set PropertyName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("PropertyName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPropertyName(db.newStringNode(value)).
											visit(newListSetterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set StatementName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("StatementName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setStatementName(db.newStringNode(value)).
											visit(newListSetterNodeVisitor());
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
		public void allListSetter(ResourceIterator<TemplatesNeoNeo.listSetterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newListSetter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.listSetterNode.listSetterNodeVisitor newListSetterNodeVisitor(); 

		@Override
		public PNode newListVisitor(TemplatesNeoNeo.listVisitorNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("listVisitor");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newListVisitorNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newListVisitorNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newListVisitorNodeVisitor());
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
		public void allListVisitor(ResourceIterator<TemplatesNeoNeo.listVisitorNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newListVisitor(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.listVisitorNode.listVisitorNodeVisitor newListVisitorNodeVisitor(); 

		@Override
		public PNode newNewInstance(TemplatesNeoNeo.newInstanceNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("newInstance");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newNewInstanceNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newNewInstanceNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					pop.add(new AbstractAction("Set GroupName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("GroupName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newNewInstanceNodeVisitor());
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newNewInstanceNodeVisitor());
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
		public void allNewInstance(ResourceIterator<TemplatesNeoNeo.newInstanceNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newNewInstance(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.newInstanceNode.newInstanceNodeVisitor newNewInstanceNodeVisitor(); 

		@Override
		public PNode newStringInterfaceDecl(TemplatesNeoNeo.stringInterfaceDeclNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("stringInterfaceDecl");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringInterfaceDeclNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringInterfaceDeclNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStringInterfaceDeclNodeVisitor());
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
		public void allStringInterfaceDecl(ResourceIterator<TemplatesNeoNeo.stringInterfaceDeclNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringInterfaceDecl(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.stringInterfaceDeclNode.stringInterfaceDeclNodeVisitor newStringInterfaceDeclNodeVisitor(); 

		@Override
		public PNode newStringSetter(TemplatesNeoNeo.stringSetterNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("stringSetter");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringSetterNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringSetterNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					pop.add(new AbstractAction("Set PropertyName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("PropertyName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPropertyName(db.newStringNode(value)).
											visit(newStringSetterNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set StatementName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("StatementName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setStatementName(db.newStringNode(value)).
											visit(newStringSetterNodeVisitor());
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
		public void allStringSetter(ResourceIterator<TemplatesNeoNeo.stringSetterNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringSetter(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.stringSetterNode.stringSetterNodeVisitor newStringSetterNodeVisitor(); 

		@Override
		public PNode newStringVisitor(TemplatesNeoNeo.stringVisitorNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("stringVisitor");
			instanceNode.addInputEventListener(new TemplatesNeoCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringVisitorNodeVisitor());

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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringVisitorNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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
								db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStringVisitorNodeVisitor());
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
		public void allStringVisitor(ResourceIterator<TemplatesNeoNeo.stringVisitorNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringVisitor(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesNeoNeo.stringVisitorNode.stringVisitorNodeVisitor newStringVisitorNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class TemplatesNeoCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
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

	public static class TemplatesNeoNeoListener {

		public PNode newNeoGroupClassDeclaration(TemplatesNeoNeo.NeoGroupClassDeclarationNode node) {
			System.out.println("newNeoGroupClassDeclarationNode : " + node.getUuid());
			return new PText("NeoGroupClassDeclaration");
		} 

		public void allNeoGroupClassDeclaration(ResourceIterator<TemplatesNeoNeo.NeoGroupClassDeclarationNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newBugfix2(TemplatesNeoNeo.bugfix2Node node) {
			System.out.println("newBugfix2Node : " + node.getUuid());
			return new PText("bugfix2");
		} 

		public void allBugfix2(ResourceIterator<TemplatesNeoNeo.bugfix2Node> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newDeclaration(TemplatesNeoNeo.declarationNode node) {
			System.out.println("newDeclarationNode : " + node.getUuid());
			return new PText("declaration");
		} 

		public void allDeclaration(ResourceIterator<TemplatesNeoNeo.declarationNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newDefaultNodeTypes(TemplatesNeoNeo.defaultNodeTypesNode node) {
			System.out.println("newDefaultNodeTypesNode : " + node.getUuid());
			return new PText("defaultNodeTypes");
		} 

		public void allDefaultNodeTypes(ResourceIterator<TemplatesNeoNeo.defaultNodeTypesNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newKeyValueListInterfaceDecl(TemplatesNeoNeo.keyValueListInterfaceDeclNode node) {
			System.out.println("newKeyValueListInterfaceDeclNode : " + node.getUuid());
			return new PText("keyValueListInterfaceDecl");
		} 

		public void allKeyValueListInterfaceDecl(ResourceIterator<TemplatesNeoNeo.keyValueListInterfaceDeclNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newKeyValueListSetter(TemplatesNeoNeo.keyValueListSetterNode node) {
			System.out.println("newKeyValueListSetterNode : " + node.getUuid());
			return new PText("keyValueListSetter");
		} 

		public void allKeyValueListSetter(ResourceIterator<TemplatesNeoNeo.keyValueListSetterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newKeyValueRelationships(TemplatesNeoNeo.keyValueRelationshipsNode node) {
			System.out.println("newKeyValueRelationshipsNode : " + node.getUuid());
			return new PText("keyValueRelationships");
		} 

		public void allKeyValueRelationships(ResourceIterator<TemplatesNeoNeo.keyValueRelationshipsNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newKeyValueVisitor(TemplatesNeoNeo.keyValueVisitorNode node) {
			System.out.println("newKeyValueVisitorNode : " + node.getUuid());
			return new PText("keyValueVisitor");
		} 

		public void allKeyValueVisitor(ResourceIterator<TemplatesNeoNeo.keyValueVisitorNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newListInterfaceDecl(TemplatesNeoNeo.listInterfaceDeclNode node) {
			System.out.println("newListInterfaceDeclNode : " + node.getUuid());
			return new PText("listInterfaceDecl");
		} 

		public void allListInterfaceDecl(ResourceIterator<TemplatesNeoNeo.listInterfaceDeclNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newListSetter(TemplatesNeoNeo.listSetterNode node) {
			System.out.println("newListSetterNode : " + node.getUuid());
			return new PText("listSetter");
		} 

		public void allListSetter(ResourceIterator<TemplatesNeoNeo.listSetterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newListVisitor(TemplatesNeoNeo.listVisitorNode node) {
			System.out.println("newListVisitorNode : " + node.getUuid());
			return new PText("listVisitor");
		} 

		public void allListVisitor(ResourceIterator<TemplatesNeoNeo.listVisitorNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newNewInstance(TemplatesNeoNeo.newInstanceNode node) {
			System.out.println("newNewInstanceNode : " + node.getUuid());
			return new PText("newInstance");
		} 

		public void allNewInstance(ResourceIterator<TemplatesNeoNeo.newInstanceNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringInterfaceDecl(TemplatesNeoNeo.stringInterfaceDeclNode node) {
			System.out.println("newStringInterfaceDeclNode : " + node.getUuid());
			return new PText("stringInterfaceDecl");
		} 

		public void allStringInterfaceDecl(ResourceIterator<TemplatesNeoNeo.stringInterfaceDeclNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringSetter(TemplatesNeoNeo.stringSetterNode node) {
			System.out.println("newStringSetterNode : " + node.getUuid());
			return new PText("stringSetter");
		} 

		public void allStringSetter(ResourceIterator<TemplatesNeoNeo.stringSetterNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringVisitor(TemplatesNeoNeo.stringVisitorNode node) {
			System.out.println("newStringVisitorNode : " + node.getUuid());
			return new PText("stringVisitor");
		} 

		public void allStringVisitor(ResourceIterator<TemplatesNeoNeo.stringVisitorNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplatesNeoNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newNeoGroupClassDeclarationAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new NeoGroupClassDeclaration") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newNeoGroupClassDeclaration(db.newNeoGroupClassDeclaration());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newNeoGroupClassDeclaration", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allNeoGroupClassDeclarationAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all NeoGroupClassDeclaration") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allNeoGroupClassDeclaration(db.findAllNeoGroupClassDeclaration());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newNeoGroupClassDeclaration", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newBugfix2Action(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new Bugfix2") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newBugfix2(db.newBugfix2());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newbugfix2", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allBugfix2Action(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all Bugfix2") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allBugfix2(db.findAllBugfix2());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newbugfix2", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newDeclarationAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new Declaration") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newDeclaration(db.newDeclaration());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newdeclaration", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allDeclarationAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all Declaration") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allDeclaration(db.findAllDeclaration());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newdeclaration", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newDefaultNodeTypesAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new DefaultNodeTypes") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newDefaultNodeTypes(db.newDefaultNodeTypes());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newdefaultNodeTypes", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allDefaultNodeTypesAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all DefaultNodeTypes") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allDefaultNodeTypes(db.findAllDefaultNodeTypes());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newdefaultNodeTypes", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newKeyValueListInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new KeyValueListInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newKeyValueListInterfaceDecl(db.newKeyValueListInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueListInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allKeyValueListInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all KeyValueListInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allKeyValueListInterfaceDecl(db.findAllKeyValueListInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueListInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newKeyValueListSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new KeyValueListSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newKeyValueListSetter(db.newKeyValueListSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueListSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allKeyValueListSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all KeyValueListSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allKeyValueListSetter(db.findAllKeyValueListSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueListSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newKeyValueRelationshipsAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new KeyValueRelationships") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newKeyValueRelationships(db.newKeyValueRelationships());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueRelationships", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allKeyValueRelationshipsAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all KeyValueRelationships") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allKeyValueRelationships(db.findAllKeyValueRelationships());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueRelationships", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newKeyValueVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new KeyValueVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newKeyValueVisitor(db.newKeyValueVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allKeyValueVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all KeyValueVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allKeyValueVisitor(db.findAllKeyValueVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newkeyValueVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newListInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new ListInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newListInterfaceDecl(db.newListInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allListInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all ListInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allListInterfaceDecl(db.findAllListInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newListSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new ListSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newListSetter(db.newListSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allListSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all ListSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allListSetter(db.findAllListSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newListVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new ListVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newListVisitor(db.newListVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allListVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all ListVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allListVisitor(db.findAllListVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newlistVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newNewInstanceAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new NewInstance") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newNewInstance(db.newNewInstance());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newnewInstance", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allNewInstanceAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all NewInstance") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allNewInstance(db.findAllNewInstance());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newnewInstance", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new StringInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringInterfaceDecl(db.newStringInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringInterfaceDeclAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all StringInterfaceDecl") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringInterfaceDecl(db.findAllStringInterfaceDecl());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringInterfaceDecl", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new StringSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringSetter(db.newStringSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringSetterAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all StringSetter") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringSetter(db.findAllStringSetter());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringSetter", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("new StringVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringVisitor(db.newStringVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringVisitorAction(TemplatesNeoNeoListener listener) {
   	return new AbstractAction("all StringVisitor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesNeoNeo.TemplatesNeoNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringVisitor(db.findAllStringVisitor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringVisitor", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesNeoSwing neoSwing, TemplatesNeoNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("NeoGroupClassDeclaration", 1, row);
			this.add(newJButton(neoSwing.newNeoGroupClassDeclarationAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allNeoGroupClassDeclarationAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Bugfix2", 1, row);
			this.add(newJButton(neoSwing.newBugfix2Action(delegate)), 3, row);
			this.add(newJButton(neoSwing.allBugfix2Action(delegate)), 5, row);

			row += 2;
			this.addLabel("Declaration", 1, row);
			this.add(newJButton(neoSwing.newDeclarationAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allDeclarationAction(delegate)), 5, row);

			row += 2;
			this.addLabel("DefaultNodeTypes", 1, row);
			this.add(newJButton(neoSwing.newDefaultNodeTypesAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allDefaultNodeTypesAction(delegate)), 5, row);

			row += 2;
			this.addLabel("KeyValueListInterfaceDecl", 1, row);
			this.add(newJButton(neoSwing.newKeyValueListInterfaceDeclAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allKeyValueListInterfaceDeclAction(delegate)), 5, row);

			row += 2;
			this.addLabel("KeyValueListSetter", 1, row);
			this.add(newJButton(neoSwing.newKeyValueListSetterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allKeyValueListSetterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("KeyValueRelationships", 1, row);
			this.add(newJButton(neoSwing.newKeyValueRelationshipsAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allKeyValueRelationshipsAction(delegate)), 5, row);

			row += 2;
			this.addLabel("KeyValueVisitor", 1, row);
			this.add(newJButton(neoSwing.newKeyValueVisitorAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allKeyValueVisitorAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ListInterfaceDecl", 1, row);
			this.add(newJButton(neoSwing.newListInterfaceDeclAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allListInterfaceDeclAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ListSetter", 1, row);
			this.add(newJButton(neoSwing.newListSetterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allListSetterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ListVisitor", 1, row);
			this.add(newJButton(neoSwing.newListVisitorAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allListVisitorAction(delegate)), 5, row);

			row += 2;
			this.addLabel("NewInstance", 1, row);
			this.add(newJButton(neoSwing.newNewInstanceAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allNewInstanceAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringInterfaceDecl", 1, row);
			this.add(newJButton(neoSwing.newStringInterfaceDeclAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringInterfaceDeclAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringSetter", 1, row);
			this.add(newJButton(neoSwing.newStringSetterAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringSetterAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringVisitor", 1, row);
			this.add(newJButton(neoSwing.newStringVisitorAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringVisitorAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final TemplatesNeoSwing templatesNeoSwing = new TemplatesNeoSwing(new TemplatesNeoNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));
		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesNeoNeoListener()));
	}
} 