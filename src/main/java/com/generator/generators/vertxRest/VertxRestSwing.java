package com.generator.generators.vertxRest;

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
 * Swing methods for VertxRest (Swing UI for neo, group and vertx)
 */
public class VertxRestSwing {

	private final VertxRestNeo db;

	public VertxRestSwing(VertxRestNeo db) {
		this.db = db;
	}

	public static abstract class VertxRestCanvasListener extends VertxRestNeoListener {

		final VertxRestNeo db;
		final PSwingCanvas canvas;
		final Map<UUID,PNode> layerNodes = new LinkedHashMap<>();
		final JTextArea txtOutput;

		public VertxRestCanvasListener(VertxRestNeo db, PSwingCanvas canvas, JTextArea txtOutput) {
			this.db = db;
			this.canvas = canvas;
			this.txtOutput = txtOutput;
		}

		@Override
		public void newAPI(VertxRestNeo.APINode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("API");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new VertxRestCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newAPINodeVisitor()).toString());
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
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setComments(db.newStringNode(value));
										txtOutput.setText(node.visit(newAPINodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Add Endpoints") {
						@Override
						public void actionPerformed(ActionEvent e) {
							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										// testing:
										//final ResourceIterator<Node> allWriteFile = db.findAllWriteFile();
										//while(allWriteFile.hasNext()) {
										//	node.addTasksValue(allWriteFile.next());
										//}

										txtOutput.setText(node.visit(newAPINodeVisitor()).toString());
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
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setName(db.newStringNode(value));
										txtOutput.setText(node.visit(newAPINodeVisitor()).toString());
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
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setPackageName(db.newStringNode(value));
										txtOutput.setText(node.visit(newAPINodeVisitor()).toString());
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
		public void allAPI(ResourceIterator < VertxRestNeo.APINode > nodes){
			while (nodes.hasNext()) newAPI(nodes.next());
		}

		protected abstract VertxRestNeo.APINode.APINodeVisitor newAPINodeVisitor(); 

		@Override
		public void newEndMethodFix(VertxRestNeo.endMethodFixNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("endMethodFix");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new VertxRestCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newEndMethodFixNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
				}
			});

			layerNodes.put(node.getUuid(), instanceNode);
			canvas.getLayer().addChild(instanceNode);
		}

		@Override
		public void allEndMethodFix(ResourceIterator < VertxRestNeo.endMethodFixNode > nodes){
			while (nodes.hasNext()) newEndMethodFix(nodes.next());
		}

		protected abstract VertxRestNeo.endMethodFixNode.endMethodFixNodeVisitor newEndMethodFixNodeVisitor(); 

		@Override
		public void newValidatingNeoHandler(VertxRestNeo.validatingNeoHandlerNode node){

			if (layerNodes.containsKey(node.getUuid())) return;

			final PNode instanceNode = new PText("validatingNeoHandler");
			instanceNode.addAttribute("neo", node.getUuid());
			instanceNode.addInputEventListener(new VertxRestCanvasInputEventListener() {

				@Override
				protected void leftClick() {
					instanceNode.invalidatePaint();
					txtOutput.setText(node.visit(newValidatingNeoHandlerNodeVisitor()).toString());
					txtOutput.setCaretPosition(0);
				}

				@Override
				protected void addActionsTo(JPopupMenu pop) {
					pop.add(new AbstractAction("Set Action") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Action", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setAction(db.newStringNode(value));
										txtOutput.setText(node.visit(newValidatingNeoHandlerNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set ApiName") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("ApiName", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setApiName(db.newStringNode(value));
										txtOutput.setText(node.visit(newValidatingNeoHandlerNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Uri") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Uri", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setUri(db.newStringNode(value));
										txtOutput.setText(node.visit(newValidatingNeoHandlerNodeVisitor()).toString());
										txtOutput.setCaretPosition(0);
									}

									@Override
									public void exception(Throwable throwable) {
										SwingUtil.showException(canvas, throwable);
									}
								}));
						}
					} );
					pop.add(new AbstractAction("Set Visitor") {
						@Override
						public void actionPerformed(ActionEvent e) {

							final String value = SwingUtil.showInputDialog("Visitor", canvas);
							if (value == null) return;

							SwingUtilities.invokeLater(() ->
								db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
									@Override
									public void doAction(Transaction tx) throws Throwable {
										node.setVisitor(db.newStringNode(value));
										txtOutput.setText(node.visit(newValidatingNeoHandlerNodeVisitor()).toString());
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
		public void allValidatingNeoHandler(ResourceIterator < VertxRestNeo.validatingNeoHandlerNode > nodes){
			while (nodes.hasNext()) newValidatingNeoHandler(nodes.next());
		}

		protected abstract VertxRestNeo.validatingNeoHandlerNode.validatingNeoHandlerNodeVisitor newValidatingNeoHandlerNodeVisitor(); 

		@Override
		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}

		protected abstract class VertxRestCanvasInputEventListener extends PBasicInputEventHandler {
			@Override
			public void mousePressed(PInputEvent event) {

				if (event.isRightMouseButton()) {
					SwingUtilities.invokeLater(() -> {

						canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						final JPopupMenu pop = new JPopupMenu();

						db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
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

					SwingUtilities.invokeLater(() -> db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
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

		abstract class VisitorAction implements VertxRestNeo.VertxRestNeoAction {
			@Override
			public void exception(Throwable throwable) {
				onException("Visitor", throwable);
			}
		}
	} 

	public static abstract class VertxRestNeoListener {

		public void newAPI(VertxRestNeo.APINode node) {
			System.out.println("newAPINode : " + node.getUuid());
		} 

		public void allAPI(ResourceIterator<VertxRestNeo.APINode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newEndMethodFix(VertxRestNeo.endMethodFixNode node) {
			System.out.println("newEndMethodFixNode : " + node.getUuid());
		} 

		public void allEndMethodFix(ResourceIterator<VertxRestNeo.endMethodFixNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void newValidatingNeoHandler(VertxRestNeo.validatingNeoHandlerNode node) {
			System.out.println("newValidatingNeoHandlerNode : " + node.getUuid());
		} 

		public void allValidatingNeoHandler(ResourceIterator<VertxRestNeo.validatingNeoHandlerNode> nodes) {
			while(nodes.hasNext()) System.out.println(nodes.next().getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(VertxRestNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

   public Action newAPIAction(VertxRestNeoListener listener) {
   	return new AbstractAction("new API") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newAPI(db.newAPI());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newAPI", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allAPIAction(VertxRestNeoListener listener) {
   	return new AbstractAction("all API") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allAPI(db.findAllAPI().<VertxRestNeo.APINode>map(VertxRestNeo::newAPI));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newAPI", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newEndMethodFixAction(VertxRestNeoListener listener) {
   	return new AbstractAction("new EndMethodFix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newEndMethodFix(db.newEndMethodFix());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newendMethodFix", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allEndMethodFixAction(VertxRestNeoListener listener) {
   	return new AbstractAction("all EndMethodFix") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allEndMethodFix(db.findAllEndMethodFix().<VertxRestNeo.endMethodFixNode>map(VertxRestNeo::newEndMethodFix));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newendMethodFix", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

   public Action newValidatingNeoHandlerAction(VertxRestNeoListener listener) {
   	return new AbstractAction("new ValidatingNeoHandler") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.newValidatingNeoHandler(db.newValidatingNeoHandler());
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newvalidatingNeoHandler", throwable);
   					}
   				});
   			});
   		}
   	};
   }

   public Action allValidatingNeoHandlerAction(VertxRestNeoListener listener) {
   	return new AbstractAction("all ValidatingNeoHandler") {
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			SwingUtilities.invokeLater(() -> {
   				db.doInTransaction(new VertxRestNeo.VertxRestNeoAction() {
   					@Override
   					public void doAction(Transaction tx) throws Throwable {
   						listener.allValidatingNeoHandler(db.findAllValidatingNeoHandler().<VertxRestNeo.validatingNeoHandlerNode>map(VertxRestNeo::newValidatingNeoHandler));
   					}

   					@Override
   					public void exception(Throwable throwable) {
   						listener.onException("newvalidatingNeoHandler", throwable);
   					}
   				});
   			});
   		}
   	};
   } 

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(VertxRestSwing neoSwing, VertxRestNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("API", 1, row);
			this.add(newJButton(neoSwing.newAPIAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allAPIAction(delegate)), 5, row);

			row += 2;
			this.addLabel("EndMethodFix", 1, row);
			this.add(newJButton(neoSwing.newEndMethodFixAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allEndMethodFixAction(delegate)), 5, row);

			row += 2;
			this.addLabel("ValidatingNeoHandler", 1, row);
			this.add(newJButton(neoSwing.newValidatingNeoHandlerAction(delegate)), 3, row);
			this.add(newJButton(neoSwing.allValidatingNeoHandlerAction(delegate)), 5, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final VertxRestSwing templatesNeoSwing = new VertxRestSwing(new VertxRestNeo(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"))));

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new VertxRestNeoListener() {
			@Override
			public void newAPI(VertxRestNeo.APINode node) {
				super.newAPI(node);
			} 

			@Override
			public void newEndMethodFix(VertxRestNeo.endMethodFixNode node) {
				super.newEndMethodFix(node);
			} 

			@Override
			public void newValidatingNeoHandler(VertxRestNeo.validatingNeoHandlerNode node) {
				super.newValidatingNeoHandler(node);
			} 

		}));
	}
} 