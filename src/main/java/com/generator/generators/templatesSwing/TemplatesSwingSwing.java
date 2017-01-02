package com.generator.generators.templatesSwing;

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
 * Swing methods for TemplatesSwing (Swing UI for neo, group and vertx)
 */
public class TemplatesSwingSwing {

	private final TemplatesSwingNeo db;

	public TemplatesSwingSwing(TemplatesSwingNeo db) {
		this.db = db;
	}

	public static abstract class TemplatesSwingCanvasListener extends TemplatesSwingNeoListener {

		protected final TemplatesSwingNeo db;

		protected final PSwingCanvas canvas;
		protected final PLayer nodeLayer;
		protected final PLayer edgeLayer;
		protected final Map<UUID, PNode> layerNodes = new LinkedHashMap<>();

		protected final Set<UUID> selectedNodes = new LinkedHashSet<>();
		protected final AtomicBoolean ctrlPressed = new AtomicBoolean(false);

		public TemplatesSwingCanvasListener(TemplatesSwingNeo db, PSwingCanvas canvas) {
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
		public PNode newCanvasActionStringProperty(TemplatesSwingNeo.CanvasActionStringPropertyNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("CanvasActionStringProperty");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newCanvasActionStringPropertyNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newCanvasActionStringPropertyNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newCanvasActionStringPropertyNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newCanvasActionStringPropertyNodeVisitor());
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
		public void allCanvasActionStringProperty(ResourceIterator<TemplatesSwingNeo.CanvasActionStringPropertyNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newCanvasActionStringProperty(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.CanvasActionStringPropertyNode.CanvasActionStringPropertyNodeVisitor newCanvasActionStringPropertyNodeVisitor(); 

		@Override
		public PNode newCanvasListener(TemplatesSwingNeo.CanvasListenerNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("CanvasListener");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newCanvasListenerNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newCanvasListenerNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newCanvasListenerNodeVisitor());
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
		public void allCanvasListener(ResourceIterator<TemplatesSwingNeo.CanvasListenerNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newCanvasListener(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.CanvasListenerNode.CanvasListenerNodeVisitor newCanvasListenerNodeVisitor(); 

		@Override
		public PNode newTemplateCanvas(TemplatesSwingNeo.TemplateCanvasNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateCanvas");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateCanvasNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateCanvasNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newTemplateCanvasNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateCanvasNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newTemplateCanvasNodeVisitor());
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
		public void allTemplateCanvas(ResourceIterator<TemplatesSwingNeo.TemplateCanvasNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateCanvas(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.TemplateCanvasNode.TemplateCanvasNodeVisitor newTemplateCanvasNodeVisitor(); 

		@Override
		public PNode newTemplateGroupActions(TemplatesSwingNeo.TemplateGroupActionsNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplateGroupActions");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplateGroupActionsNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplateGroupActionsNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newTemplateGroupActionsNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newTemplateGroupActionsNodeVisitor());
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
		public void allTemplateGroupActions(ResourceIterator<TemplatesSwingNeo.TemplateGroupActionsNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplateGroupActions(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.TemplateGroupActionsNode.TemplateGroupActionsNodeVisitor newTemplateGroupActionsNodeVisitor(); 

		@Override
		public PNode newTemplatesSwing(TemplatesSwingNeo.TemplatesSwingNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("TemplatesSwing");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newTemplatesSwingNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newTemplatesSwingNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

					pop.add(new AbstractAction("Set CanvasListener") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("CanvasListener", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setCanvasListener(db.newStringNode(value)).
											visit(newTemplatesSwingNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set GroupName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("GroupName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newTemplatesSwingNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newTemplatesSwingNodeVisitor());
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
		public void allTemplatesSwing(ResourceIterator<TemplatesSwingNeo.TemplatesSwingNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newTemplatesSwing(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.TemplatesSwingNode.TemplatesSwingNodeVisitor newTemplatesSwingNodeVisitor(); 

		@Override
		public PNode newAddListAction(TemplatesSwingNeo.addListActionNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("addListAction");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newAddListActionNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newAddListActionNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newAddListActionNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newAddListActionNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Statement") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Statement", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setStatement(db.newStringNode(value)).
											visit(newAddListActionNodeVisitor());
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
		public void allAddListAction(ResourceIterator<TemplatesSwingNeo.addListActionNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newAddListAction(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.addListActionNode.addListActionNodeVisitor newAddListActionNodeVisitor(); 

		@Override
		public PNode newAddVerticleAction(TemplatesSwingNeo.addVerticleActionNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("addVerticleAction");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newAddVerticleActionNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newAddVerticleActionNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newAddVerticleActionNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value)).
											visit(newAddVerticleActionNodeVisitor());
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
		public void allAddVerticleAction(ResourceIterator<TemplatesSwingNeo.addVerticleActionNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newAddVerticleAction(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.addVerticleActionNode.addVerticleActionNodeVisitor newAddVerticleActionNodeVisitor(); 

		@Override
		public PNode newBugfix(TemplatesSwingNeo.bugfixNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("bugfix");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
		public void allBugfix(ResourceIterator<TemplatesSwingNeo.bugfixNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newBugfix(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.bugfixNode.bugfixNodeVisitor newBugfixNodeVisitor(); 

		@Override
		public PNode newGenericFix(TemplatesSwingNeo.genericFixNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("genericFix");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newGenericFixNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newGenericFixNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
		public void allGenericFix(ResourceIterator<TemplatesSwingNeo.genericFixNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newGenericFix(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.genericFixNode.genericFixNodeVisitor newGenericFixNodeVisitor(); 

		@Override
		public PNode newNewAction(TemplatesSwingNeo.newActionNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("newAction");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newNewActionNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newNewActionNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newNewActionNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newNewActionNodeVisitor());
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
		public void allNewAction(ResourceIterator<TemplatesSwingNeo.newActionNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newNewAction(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.newActionNode.newActionNodeVisitor newNewActionNodeVisitor(); 

		@Override
		public PNode newSetStringAction(TemplatesSwingNeo.setStringActionNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("setStringAction");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newSetStringActionNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newSetStringActionNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newSetStringActionNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newSetStringActionNodeVisitor());
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Statement") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Statement", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setStatement(db.newStringNode(value)).
											visit(newSetStringActionNodeVisitor());
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
		public void allSetStringAction(ResourceIterator<TemplatesSwingNeo.setStringActionNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newSetStringAction(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.setStringActionNode.setStringActionNodeVisitor newSetStringActionNodeVisitor(); 

		@Override
		public PNode newStatementActions(TemplatesSwingNeo.statementActionsNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("statementActions");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStatementActionsNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStatementActionsNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

					pop.add(new AbstractAction("Add Actions") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {

										// statementActions

										SwingUtilities.invokeLater(() -> {

											db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//final ResourceIterator<TemplatesSwingNeo.writeFileNode> allWriteFile = db.findAllWriteFile();
													//while (allWriteFile.hasNext()) {
														//final TemplatesSwingNeo.writeFileNode next = allWriteFile.next();
														//node.addTasksValue(next.node());
														//addLink(instanceNode, layerNodes.get(next.getUuid()));
													//}
												}

												@Override
												public void exception(Throwable throwable) {
													SwingUtil.showException(canvas, throwable);
												}
											});

											db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
												@Override
												public void doAction(Transaction tx) throws Throwable {
													//txtOutput.setText(node.visit(newStatementActionsNodeVisitor()).toString());
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
					pop.add(new AbstractAction("Set GroupName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("GroupName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newStatementActionsNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStatementActionsNodeVisitor());
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
		public void allStatementActions(ResourceIterator<TemplatesSwingNeo.statementActionsNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStatementActions(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.statementActionsNode.statementActionsNodeVisitor newStatementActionsNodeVisitor(); 

		@Override
		public PNode newStringPropertyEditor(TemplatesSwingNeo.stringPropertyEditorNode node){

			if (layerNodes.containsKey(node.getUuid())) return layerNodes.get(node.getUuid());

			final UUID uuid = node.getUuid();

			final PNode instanceNode = new PText("stringPropertyEditor");
			instanceNode.addInputEventListener(new TemplatesSwingCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();

					node.visit(newStringPropertyEditorNodeVisitor());

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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										if (!node.node().hasProperty("file")) {
											final File file = SwingUtil.showSaveFile(canvas, node.node().hasProperty("file") ? (new File(node.node().getProperty("file").toString()).getParent()) : System.getProperty("user.home"));
												if (file == null) return;
												node.node().setProperty("file", file.getAbsolutePath());
										}

										FileUtil.write(node.visit(newStringPropertyEditorNodeVisitor()), new File(node.node().getProperty("file").toString()));
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value)).
											visit(newStringPropertyEditorNodeVisitor());
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
								db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value)).
											visit(newStringPropertyEditorNodeVisitor());
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
		public void allStringPropertyEditor(ResourceIterator<TemplatesSwingNeo.stringPropertyEditorNode> nodes){
			final Collection<PNode> pNodes = new ArrayList<>();
			while (nodes.hasNext()) pNodes.add(newStringPropertyEditor(nodes.next()));
			layoutCircle(pNodes, new Point2D.Double(canvas.getWidth() / 2d, canvas.getHeight() / 2d), 100);
		}

		protected abstract TemplatesSwingNeo.stringPropertyEditorNode.stringPropertyEditorNodeVisitor newStringPropertyEditorNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class TemplatesSwingCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

	public static class TemplatesSwingNeoListener {

		public PNode newCanvasActionStringProperty(TemplatesSwingNeo.CanvasActionStringPropertyNode node) {
			System.out.println("newCanvasActionStringPropertyNode : " + node.getUuid());
			return new PText("CanvasActionStringProperty");
		} 

		public void allCanvasActionStringProperty(ResourceIterator<TemplatesSwingNeo.CanvasActionStringPropertyNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newCanvasListener(TemplatesSwingNeo.CanvasListenerNode node) {
			System.out.println("newCanvasListenerNode : " + node.getUuid());
			return new PText("CanvasListener");
		} 

		public void allCanvasListener(ResourceIterator<TemplatesSwingNeo.CanvasListenerNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateCanvas(TemplatesSwingNeo.TemplateCanvasNode node) {
			System.out.println("newTemplateCanvasNode : " + node.getUuid());
			return new PText("TemplateCanvas");
		} 

		public void allTemplateCanvas(ResourceIterator<TemplatesSwingNeo.TemplateCanvasNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplateGroupActions(TemplatesSwingNeo.TemplateGroupActionsNode node) {
			System.out.println("newTemplateGroupActionsNode : " + node.getUuid());
			return new PText("TemplateGroupActions");
		} 

		public void allTemplateGroupActions(ResourceIterator<TemplatesSwingNeo.TemplateGroupActionsNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newTemplatesSwing(TemplatesSwingNeo.TemplatesSwingNode node) {
			System.out.println("newTemplatesSwingNode : " + node.getUuid());
			return new PText("TemplatesSwing");
		} 

		public void allTemplatesSwing(ResourceIterator<TemplatesSwingNeo.TemplatesSwingNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newAddListAction(TemplatesSwingNeo.addListActionNode node) {
			System.out.println("newAddListActionNode : " + node.getUuid());
			return new PText("addListAction");
		} 

		public void allAddListAction(ResourceIterator<TemplatesSwingNeo.addListActionNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newAddVerticleAction(TemplatesSwingNeo.addVerticleActionNode node) {
			System.out.println("newAddVerticleActionNode : " + node.getUuid());
			return new PText("addVerticleAction");
		} 

		public void allAddVerticleAction(ResourceIterator<TemplatesSwingNeo.addVerticleActionNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newBugfix(TemplatesSwingNeo.bugfixNode node) {
			System.out.println("newBugfixNode : " + node.getUuid());
			return new PText("bugfix");
		} 

		public void allBugfix(ResourceIterator<TemplatesSwingNeo.bugfixNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newGenericFix(TemplatesSwingNeo.genericFixNode node) {
			System.out.println("newGenericFixNode : " + node.getUuid());
			return new PText("genericFix");
		} 

		public void allGenericFix(ResourceIterator<TemplatesSwingNeo.genericFixNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newNewAction(TemplatesSwingNeo.newActionNode node) {
			System.out.println("newNewActionNode : " + node.getUuid());
			return new PText("newAction");
		} 

		public void allNewAction(ResourceIterator<TemplatesSwingNeo.newActionNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newSetStringAction(TemplatesSwingNeo.setStringActionNode node) {
			System.out.println("newSetStringActionNode : " + node.getUuid());
			return new PText("setStringAction");
		} 

		public void allSetStringAction(ResourceIterator<TemplatesSwingNeo.setStringActionNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStatementActions(TemplatesSwingNeo.statementActionsNode node) {
			System.out.println("newStatementActionsNode : " + node.getUuid());
			return new PText("statementActions");
		} 

		public void allStatementActions(ResourceIterator<TemplatesSwingNeo.statementActionsNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public PNode newStringPropertyEditor(TemplatesSwingNeo.stringPropertyEditorNode node) {
			System.out.println("newStringPropertyEditorNode : " + node.getUuid());
			return new PText("stringPropertyEditor");
		} 

		public void allStringPropertyEditor(ResourceIterator<TemplatesSwingNeo.stringPropertyEditorNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplatesSwingNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newCanvasActionStringPropertyAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new CanvasActionStringProperty") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newCanvasActionStringProperty(db.newCanvasActionStringProperty());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newCanvasActionStringProperty", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allCanvasActionStringPropertyAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all CanvasActionStringProperty") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allCanvasActionStringProperty(db.findAllCanvasActionStringProperty());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newCanvasActionStringProperty", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newCanvasListenerAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new CanvasListener") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newCanvasListener(db.newCanvasListener());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newCanvasListener", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allCanvasListenerAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all CanvasListener") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allCanvasListener(db.findAllCanvasListener());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newCanvasListener", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateCanvasAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new TemplateCanvas") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateCanvas(db.newTemplateCanvas());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateCanvas", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateCanvasAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all TemplateCanvas") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateCanvas(db.findAllTemplateCanvas());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateCanvas", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplateGroupActionsAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new TemplateGroupActions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplateGroupActions(db.newTemplateGroupActions());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroupActions", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplateGroupActionsAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all TemplateGroupActions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplateGroupActions(db.findAllTemplateGroupActions());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplateGroupActions", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newTemplatesSwingAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new TemplatesSwing") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newTemplatesSwing(db.newTemplatesSwing());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplatesSwing", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allTemplatesSwingAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all TemplatesSwing") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allTemplatesSwing(db.findAllTemplatesSwing());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newTemplatesSwing", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newAddListActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new AddListAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newAddListAction(db.newAddListAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaddListAction", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allAddListActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all AddListAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allAddListAction(db.findAllAddListAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaddListAction", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newAddVerticleActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new AddVerticleAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newAddVerticleAction(db.newAddVerticleAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaddVerticleAction", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allAddVerticleActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all AddVerticleAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allAddVerticleAction(db.findAllAddVerticleAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newaddVerticleAction", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newBugfixAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new Bugfix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

   public Action allBugfixAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all Bugfix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
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

   public Action newGenericFixAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new GenericFix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newGenericFix(db.newGenericFix());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newgenericFix", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allGenericFixAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all GenericFix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allGenericFix(db.findAllGenericFix());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newgenericFix", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newNewActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new NewAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newNewAction(db.newNewAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newnewAction", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allNewActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all NewAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allNewAction(db.findAllNewAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newnewAction", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newSetStringActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new SetStringAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newSetStringAction(db.newSetStringAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newsetStringAction", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allSetStringActionAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all SetStringAction") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allSetStringAction(db.findAllSetStringAction());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newsetStringAction", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStatementActionsAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new StatementActions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStatementActions(db.newStatementActions());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstatementActions", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStatementActionsAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all StatementActions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStatementActions(db.findAllStatementActions());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstatementActions", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newStringPropertyEditorAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("new StringPropertyEditor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newStringPropertyEditor(db.newStringPropertyEditor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringPropertyEditor", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allStringPropertyEditorAction(TemplatesSwingNeoListener listener) {
   	return new AbstractAction("all StringPropertyEditor") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allStringPropertyEditor(db.findAllStringPropertyEditor());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newstringPropertyEditor", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesSwingSwing neoSwing, TemplatesSwingNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("CanvasActionStringProperty", 1, row);
			this.add(newJButton(neoSwing.newCanvasActionStringPropertyAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allCanvasActionStringPropertyAction(delegate)), 5, row);

			row += 2;
			this.addLabel("CanvasListener", 1, row);
			this.add(newJButton(neoSwing.newCanvasListenerAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allCanvasListenerAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateCanvas", 1, row);
			this.add(newJButton(neoSwing.newTemplateCanvasAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateCanvasAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplateGroupActions", 1, row);
			this.add(newJButton(neoSwing.newTemplateGroupActionsAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplateGroupActionsAction(delegate)), 5, row);

			row += 2;
			this.addLabel("TemplatesSwing", 1, row);
			this.add(newJButton(neoSwing.newTemplatesSwingAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allTemplatesSwingAction(delegate)), 5, row);

			row += 2;
			this.addLabel("AddListAction", 1, row);
			this.add(newJButton(neoSwing.newAddListActionAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allAddListActionAction(delegate)), 5, row);

			row += 2;
			this.addLabel("AddVerticleAction", 1, row);
			this.add(newJButton(neoSwing.newAddVerticleActionAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allAddVerticleActionAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Bugfix", 1, row);
			this.add(newJButton(neoSwing.newBugfixAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allBugfixAction(delegate)), 5, row);

			row += 2;
			this.addLabel("GenericFix", 1, row);
			this.add(newJButton(neoSwing.newGenericFixAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allGenericFixAction(delegate)), 5, row);

			row += 2;
			this.addLabel("NewAction", 1, row);
			this.add(newJButton(neoSwing.newNewActionAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allNewActionAction(delegate)), 5, row);

			row += 2;
			this.addLabel("SetStringAction", 1, row);
			this.add(newJButton(neoSwing.newSetStringActionAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allSetStringActionAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StatementActions", 1, row);
			this.add(newJButton(neoSwing.newStatementActionsAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStatementActionsAction(delegate)), 5, row);

			row += 2;
			this.addLabel("StringPropertyEditor", 1, row);
			this.add(newJButton(neoSwing.newStringPropertyEditorAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allStringPropertyEditorAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final TemplatesSwingSwing templatesNeoSwing = new TemplatesSwingSwing(new TemplatesSwingNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));
		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesSwingNeoListener()));
	}
} 