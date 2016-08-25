package com.generator.generators.templatesSwing;

import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Swing methods for TemplatesSwing (Swing UI for neo, group and vertx)
 */
public class TemplatesSwingSwing {

	private final TemplatesSwingNeo db;

	public TemplatesSwingSwing(GraphDatabaseService db) {
		this.db = new TemplatesSwingNeo(db);
	}

	public static abstract class TemplatesSwingNeoListener {

		public void newGroupPanel(TemplatesSwingNeo.GroupPanelNode node) {
			System.out.println("newGroupPanelNode : " + node.getUuid());
		} 

		public void newTemplatePanel(TemplatesSwingNeo.TemplatePanelNode node) {
			System.out.println("newTemplatePanelNode : " + node.getUuid());
		} 

		public void newTemplatesSwing(TemplatesSwingNeo.TemplatesSwingNode node) {
			System.out.println("newTemplatesSwingNode : " + node.getUuid());
		} 

		public void newAddVerticleAction(TemplatesSwingNeo.addVerticleActionNode node) {
			System.out.println("newAddVerticleActionNode : " + node.getUuid());
		} 

		public void newBugfix(TemplatesSwingNeo.bugfixNode node) {
			System.out.println("newBugfixNode : " + node.getUuid());
		} 

		public void newNewAction(TemplatesSwingNeo.newActionNode node) {
			System.out.println("newNewActionNode : " + node.getUuid());
		} 

		public void newStringPropertyEditor(TemplatesSwingNeo.stringPropertyEditorNode node) {
			System.out.println("newStringPropertyEditorNode : " + node.getUuid());
		} 

		public void onException(String action, Throwable throwable) {
			System.out.println("Could not " + action + " : " + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

	public JPanel newNewInstancesPanel(TemplatesSwingNeoListener delegate) {
		return new NewInstancesPanel(this, delegate);
	}

	public Action newGroupPanelAction(TemplatesSwingNeoListener listener) {
		return new AbstractAction("new GroupPanel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newGroupPanel(db.newGroupPanel());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newGroupPanel", throwable);
						}
					});
				});
			}
		};
	} 

	public Action newTemplatePanelAction(TemplatesSwingNeoListener listener) {
		return new AbstractAction("new TemplatePanel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					db.doInTransaction(new TemplatesSwingNeo.TemplatesSwingNeoAction() {
						@Override
						public void doAction(Transaction tx) throws Throwable {
							listener.newTemplatePanel(db.newTemplatePanel());
						}

						@Override
						public void exception(Throwable throwable) {
							listener.onException("newTemplatePanel", throwable);
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


	public static void main(String[] args) {
		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final TemplatesSwingSwing templatesNeoSwing = new TemplatesSwingSwing(db);

		SwingUtil.showPanel(templatesNeoSwing.newNewInstancesPanel(new TemplatesSwingNeoListener() {
			@Override
			public void newGroupPanel(TemplatesSwingNeo.GroupPanelNode node) {
				super.newGroupPanel(node);
			} 

			@Override
			public void newTemplatePanel(TemplatesSwingNeo.TemplatePanelNode node) {
				super.newTemplatePanel(node);
			} 

			@Override
			public void newTemplatesSwing(TemplatesSwingNeo.TemplatesSwingNode node) {
				super.newTemplatesSwing(node);
			} 

			@Override
			public void newAddVerticleAction(TemplatesSwingNeo.addVerticleActionNode node) {
				super.newAddVerticleAction(node);
			} 

			@Override
			public void newBugfix(TemplatesSwingNeo.bugfixNode node) {
				super.newBugfix(node);
			} 

			@Override
			public void newNewAction(TemplatesSwingNeo.newActionNode node) {
				super.newNewAction(node);
			} 

			@Override
			public void newStringPropertyEditor(TemplatesSwingNeo.stringPropertyEditorNode node) {
				super.newStringPropertyEditor(node);
			} 

		}));
	}

	private final class NewInstancesPanel extends SwingUtil.FormPanel {

		public NewInstancesPanel(TemplatesSwingSwing neoSwing, TemplatesSwingNeoListener delegate) {
			super("150dlu, 4dlu, 150dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			int row = 1;
			this.addSeparator("New instances", 1, row, 3, 1);

			row += 2;
			this.addLabel("New GroupPanel", 1, row);
			this.add(newJButton(neoSwing.newGroupPanelAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New TemplatePanel", 1, row);
			this.add(newJButton(neoSwing.newTemplatePanelAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New TemplatesSwing", 1, row);
			this.add(newJButton(neoSwing.newTemplatesSwingAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New AddVerticleAction", 1, row);
			this.add(newJButton(neoSwing.newAddVerticleActionAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New Bugfix", 1, row);
			this.add(newJButton(neoSwing.newBugfixAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New NewAction", 1, row);
			this.add(newJButton(neoSwing.newNewActionAction(delegate)), 3, row);

			row += 2;
			this.addLabel("New StringPropertyEditor", 1, row);
			this.add(newJButton(neoSwing.newStringPropertyEditorAction(delegate)), 3, row);

		}

		private JButton newJButton(Action action) {
			final JButton button = new JButton(action);
			button.setMargin(new Insets(1,1,1,1));
			button.setFocusPainted(false);
			return button;
		}
	}
} 