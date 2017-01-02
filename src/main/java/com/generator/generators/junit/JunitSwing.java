package com.generator.generators.junit;

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
 * Swing methods for Junit (Swing UI for neo, group and vertx)
 */
public class JunitSwing {

	private final JunitNeo db;

	public JunitSwing(JunitNeo db) {
		this.db = db;
	}

	public static abstract class JunitCanvasListener extends JunitNeoListener {

		protected final JunitNeo db;

		protected final PSwingCanvas canvas;
		protected final PLayer nodeLayer;
		protected final PLayer edgeLayer;
		protected final Map<UUID, PNode> layerNodes = new LinkedHashMap<>();

		protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
		protected final AtomicBoolean ctrlPressed = new AtomicBoolean(false);

		public JunitCanvasListener(JunitNeo db, PSwingCanvas canvas) {
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
		public PNode newMvn(JunitNeo.mvnNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("mvn");
			instanceNode.addInputEventListener(new JunitCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newMvnNodeVisitor());

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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newMvnNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
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
		public void allMvn(ResourceIterator<JunitNeo.mvnNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newMvn(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract JunitNeo.mvnNode.mvnNodeVisitor newMvnNodeVisitor(); 

		@Override
		public PNode newTemplateGroupTest(JunitNeo.templateGroupTestNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("templateGroupTest");
			instanceNode.addInputEventListener(new JunitCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateGroupTestNodeVisitor());

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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateGroupTestNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newTemplateGroupTestNodeVisitor());
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateGroupTestNodeVisitor());
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
		public void allTemplateGroupTest(ResourceIterator<JunitNeo.templateGroupTestNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateGroupTest(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract JunitNeo.templateGroupTestNode.templateGroupTestNodeVisitor newTemplateGroupTestNodeVisitor(); 

		@Override
		public PNode newTemplateNeoTest(JunitNeo.templateNeoTestNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("templateNeoTest");
			instanceNode.addInputEventListener(new JunitCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateNeoTestNodeVisitor());

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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateNeoTestNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
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

					pop.add(new AbstractAction("Set DbPath") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("DbPath", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setDbPath(db.newStringNode(value)).
											visit(newTemplateNeoTestNodeVisitor());
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateNeoTestNodeVisitor());
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
		public void allTemplateNeoTest(ResourceIterator<JunitNeo.templateNeoTestNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateNeoTest(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract JunitNeo.templateNeoTestNode.templateNeoTestNodeVisitor newTemplateNeoTestNodeVisitor(); 

		@Override
		public PNode newTest(JunitNeo.testNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("test");
			instanceNode.addInputEventListener(new JunitCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTestNodeVisitor());

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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTestNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTestNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Statements") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// test

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<JunitNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final JunitNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTestNodeVisitor()).toString());
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
		public void allTest(ResourceIterator<JunitNeo.testNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTest(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract JunitNeo.testNode.testNodeVisitor newTestNodeVisitor(); 

		@Override
		public PNode newTests(JunitNeo.testsNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("tests");
			instanceNode.addInputEventListener(new JunitCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTestsNodeVisitor());

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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTestsNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
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

					pop.add(new AbstractAction("Add Imports") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// tests

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<JunitNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final JunitNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTestsNodeVisitor()).toString());
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTestsNodeVisitor());
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackage(db.newStringNode(value)).
											visit(newTestsNodeVisitor());
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
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newTestsNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Tests") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new JunitNeo.JunitNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// tests

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<JunitNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final JunitNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new JunitNeo.JunitNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newTestsNodeVisitor()).toString());
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
		public void allTests(ResourceIterator<JunitNeo.testsNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTests(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract JunitNeo.testsNode.testsNodeVisitor newTestsNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class JunitCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new JunitNeo.JunitNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new JunitNeo.JunitNeoAction() {
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

	public static class JunitNeoListener {

		public PNode newMvn(JunitNeo.mvnNode node) {
			System.out.println("newMvnNode : " + node.getUuid());
			return new PText("mvn");
		} 

		public void allMvn(ResourceIterator<JunitNeo.mvnNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateGroupTest(JunitNeo.templateGroupTestNode node) {
			System.out.println("newTemplateGroupTestNode : " + node.getUuid());
			return new PText("templateGroupTest");
		} 

		public void allTemplateGroupTest(ResourceIterator<JunitNeo.templateGroupTestNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateNeoTest(JunitNeo.templateNeoTestNode node) {
			System.out.println("newTemplateNeoTestNode : " + node.getUuid());
			return new PText("templateNeoTest");
		} 

		public void allTemplateNeoTest(ResourceIterator<JunitNeo.templateNeoTestNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTest(JunitNeo.testNode node) {
			System.out.println("newTestNode : " + node.getUuid());
			return new PText("test");
		} 

		public void allTest(ResourceIterator<JunitNeo.testNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTests(JunitNeo.testsNode node) {
			System.out.println("newTestsNode : " + node.getUuid());
			return new PText("tests");
		} 

		public void allTests(ResourceIterator<JunitNeo.testsNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(JunitNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newMvnAction(JunitNeoListener listener) {
   	return new AbstractAction("new Mvn") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newMvn(db.newMvn());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmvn", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allMvnAction(JunitNeoListener listener) {
   	return new AbstractAction("all Mvn") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allMvn(db.findAllMvn());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmvn", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateGroupTestAction(JunitNeoListener listener) {
   	return new AbstractAction("new TemplateGroupTest") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateGroupTest(db.newTemplateGroupTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtemplateGroupTest", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateGroupTestAction(JunitNeoListener listener) {
   	return new AbstractAction("all TemplateGroupTest") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateGroupTest(db.findAllTemplateGroupTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtemplateGroupTest", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateNeoTestAction(JunitNeoListener listener) {
   	return new AbstractAction("new TemplateNeoTest") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateNeoTest(db.newTemplateNeoTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtemplateNeoTest", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateNeoTestAction(JunitNeoListener listener) {
   	return new AbstractAction("all TemplateNeoTest") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateNeoTest(db.findAllTemplateNeoTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtemplateNeoTest", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTestAction(JunitNeoListener listener) {
   	return new AbstractAction("new Test") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTest(db.newTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtest", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTestAction(JunitNeoListener listener) {
   	return new AbstractAction("all Test") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTest(db.findAllTest());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtest", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTestsAction(JunitNeoListener listener) {
   	return new AbstractAction("new Tests") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTests(db.newTests());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtests", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTestsAction(JunitNeoListener listener) {
   	return new AbstractAction("all Tests") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new JunitNeo.JunitNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTests(db.findAllTests());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newtests", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(JunitSwing neoSwing, JunitNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("Mvn", 1, row);
			this.add(newJButton(neoSwing.newMvnAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allMvnAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateGroupTest", 1, row);
			this.add(newJButton(neoSwing.newTemplateGroupTestAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateGroupTestAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateNeoTest", 1, row);
			this.add(newJButton(neoSwing.newTemplateNeoTestAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateNeoTestAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Test", 1, row);
			this.add(newJButton(neoSwing.newTestAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTestAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Tests", 1, row);
			this.add(newJButton(neoSwing.newTestsAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTestsAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final JunitSwing templatesNeoSwing = new JunitSwing(new JunitNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));
		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new JunitNeoListener()));
	}
} 