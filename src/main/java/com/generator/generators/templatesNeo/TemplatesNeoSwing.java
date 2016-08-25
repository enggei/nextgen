package com.generator.generators.templatesNeo;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Swing methods for TemplatesNeo (Swing UI for neo, group and vertx)
 */
public class TemplatesNeoSwing {

	private final TemplatesNeoNeo db;

	public TemplatesNeoSwing(GraphDatabaseService db) {
		this.db = new TemplatesNeoNeo(db);
	}

	public static abstract class TemplatesNeoNeoListener {

		public void newNeoGroupClassDeclaration(TemplatesNeoNeo.NeoGroupClassDeclarationNode node) {
			System.out.println("newNeoGroupClassDeclarationNode : " + node.getUuid());
		} 

		public void newBugfix2(TemplatesNeoNeo.bugfix2Node node) {
			System.out.println("newBugfix2Node : " + node.getUuid());
		} 

		public void newDeclaration(TemplatesNeoNeo.declarationNode node) {
			System.out.println("newDeclarationNode : " + node.getUuid());
		} 

		public void newDefaultNodeTypes(TemplatesNeoNeo.defaultNodeTypesNode node) {
			System.out.println("newDefaultNodeTypesNode : " + node.getUuid());
		} 

		public void newKeyValueListSetter(TemplatesNeoNeo.keyValueListSetterNode node) {
			System.out.println("newKeyValueListSetterNode : " + node.getUuid());
		} 

		public void newListSetter(TemplatesNeoNeo.listSetterNode node) {
			System.out.println("newListSetterNode : " + node.getUuid());
		} 

		public void newNewInstance(TemplatesNeoNeo.newInstanceNode node) {
			System.out.println("newNewInstanceNode : " + node.getUuid());
		} 

		public void newStringSetter(TemplatesNeoNeo.stringSetterNode node) {
			System.out.println("newStringSetterNode : " + node.getUuid());
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


	public static void main(String[] args) {
		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final TemplatesNeoSwing templatesNeoSwing = new TemplatesNeoSwing(db);

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesNeoNeoListener() {
			@Override
			public void newNeoGroupClassDeclaration(TemplatesNeoNeo.NeoGroupClassDeclarationNode node) {
				super.newNeoGroupClassDeclaration(node);
			} 

			@Override
			public void newBugfix2(TemplatesNeoNeo.bugfix2Node node) {
				super.newBugfix2(node);
			} 

			@Override
			public void newDeclaration(TemplatesNeoNeo.declarationNode node) {
				super.newDeclaration(node);
			} 

			@Override
			public void newDefaultNodeTypes(TemplatesNeoNeo.defaultNodeTypesNode node) {
				super.newDefaultNodeTypes(node);
			} 

			@Override
			public void newKeyValueListSetter(TemplatesNeoNeo.keyValueListSetterNode node) {
				super.newKeyValueListSetter(node);
			} 

			@Override
			public void newListSetter(TemplatesNeoNeo.listSetterNode node) {
				super.newListSetter(node);
			} 

			@Override
			public void newNewInstance(TemplatesNeoNeo.newInstanceNode node) {
				super.newNewInstance(node);
			} 

			@Override
			public void newStringSetter(TemplatesNeoNeo.stringSetterNode node) {
				super.newStringSetter(node);
			} 

		}));
	}

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesNeoSwing neoSwing, TemplatesNeoNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow, 4dlu, 50dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 5, 1);

			row += 2;
			this.addLabel("New NeoGroupClassDeclaration", 1, row);
			this.add(newJButton(neoSwing.newNeoGroupClassDeclarationAction(delegate)), 3, row);

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
} 