package com.generator.generators.project;

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
 * Swing methods for Project (Swing UI for neo, group and vertx)
 */
public class ProjectSwing {

	private final ProjectNeo db;

	public ProjectSwing(ProjectNeo db) {
		this.db = db;
	}

	public static abstract class ProjectCanvasListener extends ProjectNeoListener {

		protected final ProjectNeo db;

		protected final PSwingCanvas canvas;
		protected final PLayer nodeLayer;
		protected final PLayer edgeLayer;
		protected final Map<UUID, PNode> layerNodes = new LinkedHashMap<>();

		protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
		protected final AtomicBoolean ctrlPressed = new AtomicBoolean(false);

		public ProjectCanvasListener(ProjectNeo db, PSwingCanvas canvas) {
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
		public PNode newAspect(ProjectNeo.aspectNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("aspect");
			instanceNode.addInputEventListener(new ProjectCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newAspectNodeVisitor());

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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newAspectNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newAspectNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Tasks") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// aspect

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<ProjectNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final ProjectNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newAspectNodeVisitor()).toString());
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
		public void allAspect(ResourceIterator<ProjectNeo.aspectNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newAspect(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract ProjectNeo.aspectNode.aspectNodeVisitor newAspectNodeVisitor(); 

		@Override
		public PNode newBugfix(ProjectNeo.bugfixNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("bugfix");
			instanceNode.addInputEventListener(new ProjectCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newBugfixNodeVisitor());

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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newBugfixNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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
		public void allBugfix(ResourceIterator<ProjectNeo.bugfixNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newBugfix(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract ProjectNeo.bugfixNode.bugfixNodeVisitor newBugfixNodeVisitor(); 

		@Override
		public PNode newProject(ProjectNeo.projectNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("project");
			instanceNode.addInputEventListener(new ProjectCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newProjectNodeVisitor());

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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newProjectNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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

					pop.add(new AbstractAction("Add Aspects") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// project

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<ProjectNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final ProjectNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newProjectNodeVisitor()).toString());
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
					pop.add(new AbstractAction("Set Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comments", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value)).
											visit(newProjectNodeVisitor());
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newProjectNodeVisitor());
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newProjectNodeVisitor());
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
		public void allProject(ResourceIterator<ProjectNeo.projectNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newProject(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract ProjectNeo.projectNode.projectNodeVisitor newProjectNodeVisitor(); 

		@Override
		public PNode newStringValue(ProjectNeo.stringValueNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("stringValue");
			instanceNode.addInputEventListener(new ProjectCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringValueNodeVisitor());

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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringValueNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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

					pop.add(new AbstractAction("Set Value") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Value", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setValue(db.newStringNode(value)).
											visit(newStringValueNodeVisitor());
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
		public void allStringValue(ResourceIterator<ProjectNeo.stringValueNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringValue(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract ProjectNeo.stringValueNode.stringValueNodeVisitor newStringValueNodeVisitor(); 

		@Override
		public PNode newWriteFile(ProjectNeo.writeFileNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("writeFile");
			instanceNode.addInputEventListener(new ProjectCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newWriteFileNodeVisitor());

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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newWriteFileNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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

					pop.add(new AbstractAction("Set Comment") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comment", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComment(db.newStringNode(value)).
											visit(newWriteFileNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Content") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Content", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setContent(db.newStringNode(value)).
											visit(newWriteFileNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Dir") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Dir", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setDir(db.newStringNode(value)).
											visit(newWriteFileNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Filetype") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Filetype", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setFiletype(db.newStringNode(value)).
											visit(newWriteFileNodeVisitor());
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
								db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newWriteFileNodeVisitor());
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
		public void allWriteFile(ResourceIterator<ProjectNeo.writeFileNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newWriteFile(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract ProjectNeo.writeFileNode.writeFileNodeVisitor newWriteFileNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class ProjectCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
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

	public static class ProjectNeoListener {

		public PNode newAspect(ProjectNeo.aspectNode node) {
			System.out.println("newAspectNode : " + node.getUuid());
			return new PText("aspect");
		} 

		public void allAspect(ResourceIterator<ProjectNeo.aspectNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newBugfix(ProjectNeo.bugfixNode node) {
			System.out.println("newBugfixNode : " + node.getUuid());
			return new PText("bugfix");
		} 

		public void allBugfix(ResourceIterator<ProjectNeo.bugfixNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newProject(ProjectNeo.projectNode node) {
			System.out.println("newProjectNode : " + node.getUuid());
			return new PText("project");
		} 

		public void allProject(ResourceIterator<ProjectNeo.projectNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringValue(ProjectNeo.stringValueNode node) {
			System.out.println("newStringValueNode : " + node.getUuid());
			return new PText("stringValue");
		} 

		public void allStringValue(ResourceIterator<ProjectNeo.stringValueNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newWriteFile(ProjectNeo.writeFileNode node) {
			System.out.println("newWriteFileNode : " + node.getUuid());
			return new PText("writeFile");
		} 

		public void allWriteFile(ResourceIterator<ProjectNeo.writeFileNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(ProjectNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newAspectAction(ProjectNeoListener listener) {
   	return new AbstractAction("new Aspect") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newAspect(db.newAspect());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaspect", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allAspectAction(ProjectNeoListener listener) {
   	return new AbstractAction("all Aspect") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allAspect(db.findAllAspect());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaspect", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newBugfixAction(ProjectNeoListener listener) {
   	return new AbstractAction("new Bugfix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newBugfix(db.newBugfix());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newbugfix", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allBugfixAction(ProjectNeoListener listener) {
   	return new AbstractAction("all Bugfix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allBugfix(db.findAllBugfix());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newbugfix", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newProjectAction(ProjectNeoListener listener) {
   	return new AbstractAction("new Project") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newProject(db.newProject());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newproject", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allProjectAction(ProjectNeoListener listener) {
   	return new AbstractAction("all Project") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allProject(db.findAllProject());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newproject", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringValueAction(ProjectNeoListener listener) {
   	return new AbstractAction("new StringValue") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringValue(db.newStringValue());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringValue", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringValueAction(ProjectNeoListener listener) {
   	return new AbstractAction("all StringValue") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringValue(db.findAllStringValue());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringValue", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newWriteFileAction(ProjectNeoListener listener) {
   	return new AbstractAction("new WriteFile") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newWriteFile(db.newWriteFile());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newwriteFile", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allWriteFileAction(ProjectNeoListener listener) {
   	return new AbstractAction("all WriteFile") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProjectNeo.ProjectNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allWriteFile(db.findAllWriteFile());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newwriteFile", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(ProjectSwing neoSwing, ProjectNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("Aspect", 1, row);
			this.add(newJButton(neoSwing.newAspectAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allAspectAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Bugfix", 1, row);
			this.add(newJButton(neoSwing.newBugfixAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allBugfixAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Project", 1, row);
			this.add(newJButton(neoSwing.newProjectAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allProjectAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringValue", 1, row);
			this.add(newJButton(neoSwing.newStringValueAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringValueAction(delegate)), 5, row);

			row += 2;
			this.addLabel("WriteFile", 1, row);
			this.add(newJButton(neoSwing.newWriteFileAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allWriteFileAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final ProjectSwing templatesNeoSwing = new ProjectSwing(new ProjectNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));
		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new ProjectNeoListener()));
	}
} 