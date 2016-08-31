package com.generator.generators.templatesGraphStream;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Swing methods for TemplatesGraphStream (Swing UI for neo, group and vertx)
 */
public class TemplatesGraphStreamSwing {

	private final TemplatesGraphStreamNeo db;

	public TemplatesGraphStreamSwing(GraphDatabaseService db) {
		this.db = new TemplatesGraphStreamNeo(db);
	}

	public static abstract class TemplatesGraphStreamNeoListener {

		public void newGroupClassDeclaration(TemplatesGraphStreamNeo.GroupClassDeclarationNode node) {
			System.out.println("newGroupClassDeclarationNode : " + node.getUuid());
		} 

		public void newBugfix2(TemplatesGraphStreamNeo.bugfix2Node node) {
			System.out.println("newBugfix2Node : " + node.getUuid());
		} 

		public void newDeclaration(TemplatesGraphStreamNeo.declarationNode node) {
			System.out.println("newDeclarationNode : " + node.getUuid());
		} 

		public void newDefaultNodeTypes(TemplatesGraphStreamNeo.defaultNodeTypesNode node) {
			System.out.println("newDefaultNodeTypesNode : " + node.getUuid());
		} 

		public void newKeyValueListSetter(TemplatesGraphStreamNeo.keyValueListSetterNode node) {
			System.out.println("newKeyValueListSetterNode : " + node.getUuid());
		} 

		public void newKeyValueRelationships(TemplatesGraphStreamNeo.keyValueRelationshipsNode node) {
			System.out.println("newKeyValueRelationshipsNode : " + node.getUuid());
		} 

		public void newListSetter(TemplatesGraphStreamNeo.listSetterNode node) {
			System.out.println("newListSetterNode : " + node.getUuid());
		} 

		public void newNewInstance(TemplatesGraphStreamNeo.newInstanceNode node) {
			System.out.println("newNewInstanceNode : " + node.getUuid());
		} 

		public void newStringSetter(TemplatesGraphStreamNeo.stringSetterNode node) {
			System.out.println("newStringSetterNode : " + node.getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplatesGraphStreamNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

	public Action newGroupClassDeclarationAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new GroupClassDeclaration") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newGroupClassDeclaration(db.newGroupClassDeclaration());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newGroupClassDeclaration", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newBugfix2Action(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new Bugfix2") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newDeclarationAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new Declaration") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newDefaultNodeTypesAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new DefaultNodeTypes") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newKeyValueListSetterAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new KeyValueListSetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newKeyValueRelationshipsAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new KeyValueRelationships") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newListSetterAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new ListSetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newNewInstanceAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new NewInstance") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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

	public Action newStringSetterAction(TemplatesGraphStreamNeoListener listener) {
		return new AbstractAction("new StringSetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesGraphStreamNeo.TemplatesGraphStreamNeoAction() {
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


	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesGraphStreamSwing neoSwing, TemplatesGraphStreamNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 3, 1);

			row += 2;
			this.addLabel("New GroupClassDeclaration", 1, row);
			this.add(newJButton(neoSwing.newGroupClassDeclarationAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Bugfix2", 1, row);
			this.add(newJButton(neoSwing.newBugfix2Action(delegate)), 3, row);

			row += 2;
			this.addLabel("New Declaration", 1, row);
			this.add(newJButton(neoSwing.newDeclarationAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New DefaultNodeTypes", 1, row);
			this.add(newJButton(neoSwing.newDefaultNodeTypesAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New KeyValueListSetter", 1, row);
			this.add(newJButton(neoSwing.newKeyValueListSetterAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New KeyValueRelationships", 1, row);
			this.add(newJButton(neoSwing.newKeyValueRelationshipsAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New ListSetter", 1, row);
			this.add(newJButton(neoSwing.newListSetterAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New NewInstance", 1, row);
			this.add(newJButton(neoSwing.newNewInstanceAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New StringSetter", 1, row);
			this.add(newJButton(neoSwing.newStringSetterAction(delegate)), 3, row);

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
		final TemplatesGraphStreamSwing templatesNeoSwing = new TemplatesGraphStreamSwing(db);

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesGraphStreamNeoListener() {
			@Override
			public void newGroupClassDeclaration(TemplatesGraphStreamNeo.GroupClassDeclarationNode node) {
				super.newGroupClassDeclaration(node);
			} 

			@Override
			public void newBugfix2(TemplatesGraphStreamNeo.bugfix2Node node) {
				super.newBugfix2(node);
			} 

			@Override
			public void newDeclaration(TemplatesGraphStreamNeo.declarationNode node) {
				super.newDeclaration(node);
			} 

			@Override
			public void newDefaultNodeTypes(TemplatesGraphStreamNeo.defaultNodeTypesNode node) {
				super.newDefaultNodeTypes(node);
			} 

			@Override
			public void newKeyValueListSetter(TemplatesGraphStreamNeo.keyValueListSetterNode node) {
				super.newKeyValueListSetter(node);
			} 

			@Override
			public void newKeyValueRelationships(TemplatesGraphStreamNeo.keyValueRelationshipsNode node) {
				super.newKeyValueRelationships(node);
			} 

			@Override
			public void newListSetter(TemplatesGraphStreamNeo.listSetterNode node) {
				super.newListSetter(node);
			} 

			@Override
			public void newNewInstance(TemplatesGraphStreamNeo.newInstanceNode node) {
				super.newNewInstance(node);
			} 

			@Override
			public void newStringSetter(TemplatesGraphStreamNeo.stringSetterNode node) {
				super.newStringSetter(node);
			} 

		}));
	}
} 