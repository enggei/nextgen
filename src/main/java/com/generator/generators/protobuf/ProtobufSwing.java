package com.generator.generators.protobuf;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Swing methods for Protobuf (Swing UI for neo, group and vertx)
 */
public class ProtobufSwing {

	private final ProtobufNeo db;

	public ProtobufSwing(GraphDatabaseService db) {
		this.db = new ProtobufNeo(db);
	}

	public static abstract class ProtobufNeoListener {

		public void newEnum(ProtobufNeo.enumNode node) {
			System.out.println("newEnumNode : " + node.getUuid());
		} 

		public void newExtend(ProtobufNeo.extendNode node) {
			System.out.println("newExtendNode : " + node.getUuid());
		} 

		public void newExtensions(ProtobufNeo.extensionsNode node) {
			System.out.println("newExtensionsNode : " + node.getUuid());
		} 

		public void newGroupMessagesModel(ProtobufNeo.groupMessagesModelNode node) {
			System.out.println("newGroupMessagesModelNode : " + node.getUuid());
		} 

		public void newMessage(ProtobufNeo.messageNode node) {
			System.out.println("newMessageNode : " + node.getUuid());
		} 

		public void newMessageField(ProtobufNeo.messageFieldNode node) {
			System.out.println("newMessageFieldNode : " + node.getUuid());
		} 

		public void newProtobufPackage(ProtobufNeo.protobufPackageNode node) {
			System.out.println("newProtobufPackageNode : " + node.getUuid());
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


	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(ProtobufSwing neoSwing, ProtobufNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 3, 1);

			row += 2;
			this.addLabel("New Enum", 1, row);
			this.add(newJButton(neoSwing.newEnumAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Extend", 1, row);
			this.add(newJButton(neoSwing.newExtendAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Extensions", 1, row);
			this.add(newJButton(neoSwing.newExtensionsAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New GroupMessagesModel", 1, row);
			this.add(newJButton(neoSwing.newGroupMessagesModelAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Message", 1, row);
			this.add(newJButton(neoSwing.newMessageAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New MessageField", 1, row);
			this.add(newJButton(neoSwing.newMessageFieldAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New ProtobufPackage", 1, row);
			this.add(newJButton(neoSwing.newProtobufPackageAction(delegate)), 3, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}

	public static void main(String[] args) {
		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final ProtobufSwing templatesNeoSwing = new ProtobufSwing(db);

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