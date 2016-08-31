package com.generator.generators.templateGroup;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Swing methods for TemplateGroup (Swing UI for neo, group and vertx)
 */
public class TemplateGroupSwing {

	private final TemplateGroupNeo db;

	public TemplateGroupSwing(GraphDatabaseService db) {
		this.db = new TemplateGroupNeo(db);
	}

	public static abstract class TemplateGroupNeoListener {

		public void newAttributeRendererDeclaration(TemplateGroupNeo.AttributeRendererDeclarationNode node) {
			System.out.println("newAttributeRendererDeclarationNode : " + node.getUuid());
		} 

		public void newGroupClassDeclaration(TemplateGroupNeo.GroupClassDeclarationNode node) {
			System.out.println("newGroupClassDeclarationNode : " + node.getUuid());
		} 

		public void newNewGroupInstance(TemplateGroupNeo.NewGroupInstanceNode node) {
			System.out.println("newNewGroupInstanceNode : " + node.getUuid());
		} 

		public void newNewStatementDeclaration(TemplateGroupNeo.NewStatementDeclarationNode node) {
			System.out.println("newNewStatementDeclarationNode : " + node.getUuid());
		} 

		public void newNewStatementInstance(TemplateGroupNeo.NewStatementInstanceNode node) {
			System.out.println("newNewStatementInstanceNode : " + node.getUuid());
		} 

		public void newStatementKeyValueListPropertySetter(TemplateGroupNeo.StatementKeyValueListPropertySetterNode node) {
			System.out.println("newStatementKeyValueListPropertySetterNode : " + node.getUuid());
		} 

		public void newStatementListPropertySetter(TemplateGroupNeo.StatementListPropertySetterNode node) {
			System.out.println("newStatementListPropertySetterNode : " + node.getUuid());
		} 

		public void newStatementStringPropertySetter(TemplateGroupNeo.StatementStringPropertySetterNode node) {
			System.out.println("newStatementStringPropertySetterNode : " + node.getUuid());
		} 

		public void newBugfix(TemplateGroupNeo.bugfixNode node) {
			System.out.println("newBugfixNode : " + node.getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplateGroupNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

	public Action newAttributeRendererDeclarationAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new AttributeRendererDeclaration") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newAttributeRendererDeclaration(db.newAttributeRendererDeclaration());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newAttributeRendererDeclaration", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newGroupClassDeclarationAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new GroupClassDeclaration") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
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

	public Action newNewGroupInstanceAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new NewGroupInstance") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newNewGroupInstance(db.newNewGroupInstance());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newNewGroupInstance", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newNewStatementDeclarationAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new NewStatementDeclaration") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newNewStatementDeclaration(db.newNewStatementDeclaration());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newNewStatementDeclaration", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newNewStatementInstanceAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new NewStatementInstance") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newNewStatementInstance(db.newNewStatementInstance());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newNewStatementInstance", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newStatementKeyValueListPropertySetterAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new StatementKeyValueListPropertySetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newStatementKeyValueListPropertySetter(db.newStatementKeyValueListPropertySetter());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newStatementKeyValueListPropertySetter", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newStatementListPropertySetterAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new StatementListPropertySetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newStatementListPropertySetter(db.newStatementListPropertySetter());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newStatementListPropertySetter", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newStatementStringPropertySetterAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new StatementStringPropertySetter") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newStatementStringPropertySetter(db.newStatementStringPropertySetter());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newStatementStringPropertySetter", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newBugfixAction(TemplateGroupNeoListener listener) {
		return new AbstractAction("new Bugfix") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplateGroupNeo.TemplateGroupNeoAction() {
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


	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplateGroupSwing neoSwing, TemplateGroupNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 3, 1);

			row += 2;
			this.addLabel("New AttributeRendererDeclaration", 1, row);
			this.add(newJButton(neoSwing.newAttributeRendererDeclarationAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New GroupClassDeclaration", 1, row);
			this.add(newJButton(neoSwing.newGroupClassDeclarationAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New NewGroupInstance", 1, row);
			this.add(newJButton(neoSwing.newNewGroupInstanceAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New NewStatementDeclaration", 1, row);
			this.add(newJButton(neoSwing.newNewStatementDeclarationAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New NewStatementInstance", 1, row);
			this.add(newJButton(neoSwing.newNewStatementInstanceAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New StatementKeyValueListPropertySetter", 1, row);
			this.add(newJButton(neoSwing.newStatementKeyValueListPropertySetterAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New StatementListPropertySetter", 1, row);
			this.add(newJButton(neoSwing.newStatementListPropertySetterAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New StatementStringPropertySetter", 1, row);
			this.add(newJButton(neoSwing.newStatementStringPropertySetterAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Bugfix", 1, row);
			this.add(newJButton(neoSwing.newBugfixAction(delegate)), 3, row);

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
		final TemplateGroupSwing templatesNeoSwing = new TemplateGroupSwing(db);

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplateGroupNeoListener() {
			@Override
			public void newAttributeRendererDeclaration(TemplateGroupNeo.AttributeRendererDeclarationNode node) {
				super.newAttributeRendererDeclaration(node);
			} 

			@Override
			public void newGroupClassDeclaration(TemplateGroupNeo.GroupClassDeclarationNode node) {
				super.newGroupClassDeclaration(node);
			} 

			@Override
			public void newNewGroupInstance(TemplateGroupNeo.NewGroupInstanceNode node) {
				super.newNewGroupInstance(node);
			} 

			@Override
			public void newNewStatementDeclaration(TemplateGroupNeo.NewStatementDeclarationNode node) {
				super.newNewStatementDeclaration(node);
			} 

			@Override
			public void newNewStatementInstance(TemplateGroupNeo.NewStatementInstanceNode node) {
				super.newNewStatementInstance(node);
			} 

			@Override
			public void newStatementKeyValueListPropertySetter(TemplateGroupNeo.StatementKeyValueListPropertySetterNode node) {
				super.newStatementKeyValueListPropertySetter(node);
			} 

			@Override
			public void newStatementListPropertySetter(TemplateGroupNeo.StatementListPropertySetterNode node) {
				super.newStatementListPropertySetter(node);
			} 

			@Override
			public void newStatementStringPropertySetter(TemplateGroupNeo.StatementStringPropertySetterNode node) {
				super.newStatementStringPropertySetter(node);
			} 

			@Override
			public void newBugfix(TemplateGroupNeo.bugfixNode node) {
				super.newBugfix(node);
			} 

		}));
	}
} 