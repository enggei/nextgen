package com.generator.generators.protobuf;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Swing methods for Protobuf (Swing UI for neo, group and vertx)
 */
public class ProtobufSwing {

	private final ProtobufNeo db;

	public ProtobufSwing(ProtobufNeo db) {
		this.db = db;
	}

	public static abstract class ProtobufCanvasListener extends ProtobufNeoListener {

		final ProtobufNeo db;
		final PSwingCanvas canvas;
		final Map<UUID,PNode> layerNodes = new LinkedHashMap<>();
		final JTextArea txtOutput;

		public ProtobufCanvasListener(ProtobufNeo db, PSwingCanvas canvas, JTextArea txtOutput) {
			this.db = db;
			this.canvas = canvas;
			this.txtOutput = txtOutput;
		}

		@Override
		public void newEnum(ProtobufNeo.enumNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("enum");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newEnumNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comments", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value));
										txtOutput.setText(node.visit(newEnumNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value));
										txtOutput.setText(node.visit(newEnumNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Properties") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newEnumNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allEnum(ResourceIterator < ProtobufNeo.enumNode > nodes){
			while (nodes.hasNext()) newEnum(nodes.next());
		}

		protected abstract ProtobufNeo.enumNode.enumNodeVisitor newEnumNodeVisitor(); 

		@Override
		public void newExtend(ProtobufNeo.extendNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("extend");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newExtendNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comments", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value));
										txtOutput.setText(node.visit(newExtendNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value));
										txtOutput.setText(node.visit(newExtendNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Properties") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newExtendNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allExtend(ResourceIterator < ProtobufNeo.extendNode > nodes){
			while (nodes.hasNext()) newExtend(nodes.next());
		}

		protected abstract ProtobufNeo.extendNode.extendNodeVisitor newExtendNodeVisitor(); 

		@Override
		public void newExtensions(ProtobufNeo.extensionsNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("extensions");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newExtensionsNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Max") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Max", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setMax(db.newStringNode(value));
										txtOutput.setText(node.visit(newExtensionsNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Min") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Min", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setMin(db.newStringNode(value));
										txtOutput.setText(node.visit(newExtensionsNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allExtensions(ResourceIterator < ProtobufNeo.extensionsNode > nodes){
			while (nodes.hasNext()) newExtensions(nodes.next());
		}

		protected abstract ProtobufNeo.extensionsNode.extensionsNodeVisitor newExtensionsNodeVisitor(); 

		@Override
		public void newGroupMessagesModel(ProtobufNeo.groupMessagesModelNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("groupMessagesModel");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newGroupMessagesModelNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set GroupName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("GroupName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setGroupName(db.newStringNode(value));
										txtOutput.setText(node.visit(newGroupMessagesModelNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value));
										txtOutput.setText(node.visit(newGroupMessagesModelNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allGroupMessagesModel(ResourceIterator < ProtobufNeo.groupMessagesModelNode > nodes){
			while (nodes.hasNext()) newGroupMessagesModel(nodes.next());
		}

		protected abstract ProtobufNeo.groupMessagesModelNode.groupMessagesModelNodeVisitor newGroupMessagesModelNodeVisitor(); 

		@Override
		public void newMessage(ProtobufNeo.messageNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("message");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newMessageNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comments", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Properties") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newMessageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allMessage(ResourceIterator < ProtobufNeo.messageNode > nodes){
			while (nodes.hasNext()) newMessage(nodes.next());
		}

		protected abstract ProtobufNeo.messageNode.messageNodeVisitor newMessageNodeVisitor(); 

		@Override
		public void newMessageField(ProtobufNeo.messageFieldNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("messageField");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Comments") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Comments", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set DefaultValue") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("DefaultValue", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setDefaultValue(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set FieldConstraint") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("FieldConstraint", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setFieldConstraint(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Ordinal") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Ordinal", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setOrdinal(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set PackedValue") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("PackedValue", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackedValue(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Type") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Type", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setType(db.newStringNode(value));
										txtOutput.setText(node.visit(newMessageFieldNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allMessageField(ResourceIterator < ProtobufNeo.messageFieldNode > nodes){
			while (nodes.hasNext()) newMessageField(nodes.next());
		}

		protected abstract ProtobufNeo.messageFieldNode.messageFieldNodeVisitor newMessageFieldNodeVisitor(); 

		@Override
		public void newProtobufPackage(ProtobufNeo.protobufPackageNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("protobufPackage");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new ProtobufCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newProtobufPackageNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Add Deliverables") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newProtobufPackageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newProtobufPackageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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
								db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackage(db.newStringNode(value));
										txtOutput.setText(node.visit(newProtobufPackageNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
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

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allProtobufPackage(ResourceIterator < ProtobufNeo.protobufPackageNode > nodes){
			while (nodes.hasNext()) newProtobufPackage(nodes.next());
		}

		protected abstract ProtobufNeo.protobufPackageNode.protobufPackageNodeVisitor newProtobufPackageNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class ProtobufCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
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

		abstract class VisitorAction implements ProtobufNeo.ProtobufNeoAction {
			@Override
			public void exception(Throwable throwable) {
				onException("Visitor", throwable);
			}
		}
	} 

	public static abstract class ProtobufNeoListener {

		public void newEnum(ProtobufNeo.enumNode node) {
			System.out.println("newEnumNode : " + node.getUuid());
		} 

		public void allEnum(ResourceIterator<ProtobufNeo.enumNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newExtend(ProtobufNeo.extendNode node) {
			System.out.println("newExtendNode : " + node.getUuid());
		} 

		public void allExtend(ResourceIterator<ProtobufNeo.extendNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newExtensions(ProtobufNeo.extensionsNode node) {
			System.out.println("newExtensionsNode : " + node.getUuid());
		} 

		public void allExtensions(ResourceIterator<ProtobufNeo.extensionsNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newGroupMessagesModel(ProtobufNeo.groupMessagesModelNode node) {
			System.out.println("newGroupMessagesModelNode : " + node.getUuid());
		} 

		public void allGroupMessagesModel(ResourceIterator<ProtobufNeo.groupMessagesModelNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newMessage(ProtobufNeo.messageNode node) {
			System.out.println("newMessageNode : " + node.getUuid());
		} 

		public void allMessage(ResourceIterator<ProtobufNeo.messageNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newMessageField(ProtobufNeo.messageFieldNode node) {
			System.out.println("newMessageFieldNode : " + node.getUuid());
		} 

		public void allMessageField(ResourceIterator<ProtobufNeo.messageFieldNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newProtobufPackage(ProtobufNeo.protobufPackageNode node) {
			System.out.println("newProtobufPackageNode : " + node.getUuid());
		} 

		public void allProtobufPackage(ResourceIterator<ProtobufNeo.protobufPackageNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(ProtobufNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newEnumAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new Enum") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newEnum(db.newEnum());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newenum", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allEnumAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all Enum") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allEnum(db.findAllEnum().<ProtobufNeo.enumNode>map(ProtobufNeo::newEnum));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newenum", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newExtendAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new Extend") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newExtend(db.newExtend());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newextend", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allExtendAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all Extend") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allExtend(db.findAllExtend().<ProtobufNeo.extendNode>map(ProtobufNeo::newExtend));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newextend", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newExtensionsAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new Extensions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newExtensions(db.newExtensions());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newextensions", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allExtensionsAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all Extensions") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allExtensions(db.findAllExtensions().<ProtobufNeo.extensionsNode>map(ProtobufNeo::newExtensions));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newextensions", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newGroupMessagesModelAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new GroupMessagesModel") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newGroupMessagesModel(db.newGroupMessagesModel());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newgroupMessagesModel", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allGroupMessagesModelAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all GroupMessagesModel") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allGroupMessagesModel(db.findAllGroupMessagesModel().<ProtobufNeo.groupMessagesModelNode>map(ProtobufNeo::newGroupMessagesModel));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newgroupMessagesModel", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newMessageAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new Message") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newMessage(db.newMessage());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmessage", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allMessageAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all Message") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allMessage(db.findAllMessage().<ProtobufNeo.messageNode>map(ProtobufNeo::newMessage));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmessage", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newMessageFieldAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new MessageField") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newMessageField(db.newMessageField());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmessageField", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allMessageFieldAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all MessageField") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allMessageField(db.findAllMessageField().<ProtobufNeo.messageFieldNode>map(ProtobufNeo::newMessageField));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newmessageField", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newProtobufPackageAction(ProtobufNeoListener listener) {
   	return new AbstractAction("new ProtobufPackage") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newProtobufPackage(db.newProtobufPackage());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newprotobufPackage", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allProtobufPackageAction(ProtobufNeoListener listener) {
   	return new AbstractAction("all ProtobufPackage") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new ProtobufNeo.ProtobufNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allProtobufPackage(db.findAllProtobufPackage().<ProtobufNeo.protobufPackageNode>map(ProtobufNeo::newProtobufPackage));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newprotobufPackage", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(ProtobufSwing neoSwing, ProtobufNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("Enum", 1, row);
			this.add(newJButton(neoSwing.newEnumAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allEnumAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Extend", 1, row);
			this.add(newJButton(neoSwing.newExtendAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allExtendAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Extensions", 1, row);
			this.add(newJButton(neoSwing.newExtensionsAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allExtensionsAction(delegate)), 5, row);

			row += 2;
			this.addLabel("GroupMessagesModel", 1, row);
			this.add(newJButton(neoSwing.newGroupMessagesModelAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allGroupMessagesModelAction(delegate)), 5, row);

			row += 2;
			this.addLabel("Message", 1, row);
			this.add(newJButton(neoSwing.newMessageAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allMessageAction(delegate)), 5, row);

			row += 2;
			this.addLabel("MessageField", 1, row);
			this.add(newJButton(neoSwing.newMessageFieldAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allMessageFieldAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ProtobufPackage", 1, row);
			this.add(newJButton(neoSwing.newProtobufPackageAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allProtobufPackageAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final ProtobufSwing templatesNeoSwing = new ProtobufSwing(new ProtobufNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new ProtobufNeoListener() {
			@Override
			public void newEnum(ProtobufNeo.enumNode node) {
				super.newEnum(node);
			} 

			@Override
			public void newExtend(ProtobufNeo.extendNode node) {
				super.newExtend(node);
			} 

			@Override
			public void newExtensions(ProtobufNeo.extensionsNode node) {
				super.newExtensions(node);
			} 

			@Override
			public void newGroupMessagesModel(ProtobufNeo.groupMessagesModelNode node) {
				super.newGroupMessagesModel(node);
			} 

			@Override
			public void newMessage(ProtobufNeo.messageNode node) {
				super.newMessage(node);
			} 

			@Override
			public void newMessageField(ProtobufNeo.messageFieldNode node) {
				super.newMessageField(node);
			} 

			@Override
			public void newProtobufPackage(ProtobufNeo.protobufPackageNode node) {
				super.newProtobufPackage(node);
			} 

		}));
	}
} 