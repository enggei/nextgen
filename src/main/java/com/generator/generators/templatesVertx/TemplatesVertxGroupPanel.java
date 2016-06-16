
 package com.generator.generators.templatesVertx;

import com.generator.util.VertxUtil;
import com.generator.generators.templatesVertx.vertx.*;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.CompileUtil;
import com.generator.util.SwingUtil;
import com.generator.util.FileUtil;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.UUID;

/**
 * from wrapped STGroupFile
 */
public final class TemplatesVertxGroupPanel extends JPanel {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TemplatesVertxGroupPanel.class);

	public static void main(String[] args) {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final Vertx vertx = Vertx.vertx();
		final JPanel owner = new JPanel(new BorderLayout());
		final JTabbedPane declarationsPanel = new JTabbedPane();
		owner.add(new TemplatesVertxGroupPanel(vertx, declarationsPanel, new JTextField("/media/storage/nextgen/src/main/java")), BorderLayout.NORTH);
		owner.add(declarationsPanel, BorderLayout.CENTER);
		SwingUtil.showPanel(owner);
	}

	public TemplatesVertxGroupPanel(Vertx vertx, final JTabbedPane declarationsPanel, final JTextField txtRoot) {
		super(new FlowLayout(FlowLayout.LEFT));


		 // com.generator.generators.templatesVertx.vertx.AddMessage
		 final String addMessage = "com.generator.generators.templatesVertx.vertxAddMessage";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "AddMessageVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					AddMessageVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("AddMessageInstance", new GroupAddMessagePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.ConsumeKeyValueListMessage
		 final String consumeKeyValueListMessage = "com.generator.generators.templatesVertx.vertxConsumeKeyValueListMessage";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "ConsumeKeyValueListMessageVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					ConsumeKeyValueListMessageVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("ConsumeKeyValueListMessageInstance", new GroupConsumeKeyValueListMessagePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.ConsumeListMessage
		 final String consumeListMessage = "com.generator.generators.templatesVertx.vertxConsumeListMessage";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "ConsumeListMessageVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					ConsumeListMessageVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("ConsumeListMessageInstance", new GroupConsumeListMessagePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.ConsumeStringMessage
		 final String consumeStringMessage = "com.generator.generators.templatesVertx.vertxConsumeStringMessage";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "ConsumeStringMessageVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					ConsumeStringMessageVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("ConsumeStringMessageInstance", new GroupConsumeStringMessagePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.GroupVerticle
		 final String groupVerticle = "com.generator.generators.templatesVertx.vertxGroupVerticle";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "GroupVerticleVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					GroupVerticleVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("GroupVerticleInstance", new GroupGroupVerticlePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.SendMessage
		 final String sendMessage = "com.generator.generators.templatesVertx.vertxSendMessage";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "SendMessageVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					SendMessageVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("SendMessageInstance", new GroupSendMessagePanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

		 // com.generator.generators.templatesVertx.vertx.bugfix
		 final String bugfix = "com.generator.generators.templatesVertx.vertxbugfix";
		add(deployVerticleAction(vertx, txtRoot, "com.generator.generators.templatesVertx.vertx", "bugfixVerticle", new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String result) {
				SwingUtilities.invokeLater(() -> {
					final UUID instanceID = UUID.randomUUID();
					bugfixVerticle.sendInstanceMessage(vertx, instanceID, s ->
						SwingUtilities.invokeLater(() -> {
							declarationsPanel.add("bugfixInstance", new GroupbugfixPanel(vertx));
						}));
				});
			}

			@Override
			public void onFail(Throwable t) {

			}
		}));  

	}

	private static JButton deployVerticleAction(final Vertx vertx, final JTextField txtRoot, final String packageName, final String name, final VertxUtil.SuccessHandler<String> handler) {
		return new JButton(new AbstractAction("new " + name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					final File file = new File(txtRoot.getText(), GeneratedFile.packageToPath(packageName, name + ".java"));
					log.info("deploying from file " + file.getAbsolutePath() + "");
					try {
						VertxUtil.deploy(vertx, (Verticle) CompileUtil.compileAndLoad(packageName + "." + name, FileUtil.readIntact(file)), log, handler);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
			}
		});
	}




	 private static final class GroupAddMessagePanel extends JPanel {

			public GroupAddMessagePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						AddMessageVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupAddMessageInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						AddMessageVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						AddMessageVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupConsumeKeyValueListMessagePanel extends JPanel {

			public GroupConsumeKeyValueListMessagePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						ConsumeKeyValueListMessageVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupConsumeKeyValueListMessageInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						ConsumeKeyValueListMessageVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						ConsumeKeyValueListMessageVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupConsumeListMessagePanel extends JPanel {

			public GroupConsumeListMessagePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						ConsumeListMessageVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupConsumeListMessageInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						ConsumeListMessageVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						ConsumeListMessageVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupConsumeStringMessagePanel extends JPanel {

			public GroupConsumeStringMessagePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						ConsumeStringMessageVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupConsumeStringMessageInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						ConsumeStringMessageVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						ConsumeStringMessageVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupGroupVerticlePanel extends JPanel {

			public GroupGroupVerticlePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						GroupVerticleVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupGroupVerticleInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("groupName "));
				final JTextField txtgroupName = new JTextField(10);
				actionPanel.add(txtgroupName);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						GroupVerticleVerticle.sendGroupNameMessage(vertx, instanceID, txtgroupName.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 
				 actionPanel.add(new JLabel("groupPackage "));
				final JTextField txtgroupPackage = new JTextField(10);
				actionPanel.add(txtgroupPackage);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						GroupVerticleVerticle.sendGroupPackageMessage(vertx, instanceID, txtgroupPackage.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						GroupVerticleVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 
				 actionPanel.add(new JLabel("package "));
				final JTextField txtpackage = new JTextField(10);
				actionPanel.add(txtpackage);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						GroupVerticleVerticle.sendPackageMessage(vertx, instanceID, txtpackage.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						GroupVerticleVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupSendMessagePanel extends JPanel {

			public GroupSendMessagePanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						SendMessageVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupSendMessageInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui
				 actionPanel.add(new JLabel("name "));
				final JTextField txtname = new JTextField(10);
				actionPanel.add(txtname);
				actionPanel.add(new JButton(new AbstractAction("set") {
					@Override
					public void actionPerformed(ActionEvent e) {
						// DomainBooleanPropertySetterVerticle.sendPropertyNameMessage
						SendMessageVerticle.sendNameMessage(vertx, instanceID, txtname.getText(), s -> SwingUtilities.invokeLater(() -> {
							((JButton) e.getSource()).setEnabled(false);
						}));
					}
				})); 

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						SendMessageVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    



	 private static final class GroupbugfixPanel extends JPanel {

			public GroupbugfixPanel(Vertx vertx) {
				super(new BorderLayout());

				final JTabbedPane instancesPanel = new JTabbedPane();

				final JButton btnDeploy = new JButton(new AbstractAction("newInstance") {
					@Override
					public void actionPerformed(ActionEvent e) {
						final UUID instanceID = UUID.randomUUID();
						bugfixVerticle.sendInstanceMessage(vertx, instanceID, s -> {
							instancesPanel.add(instanceID.toString(), actionPanel(vertx, instanceID));
						});
					}
				});
				add(btnDeploy, BorderLayout.NORTH);
				add(instancesPanel, BorderLayout.CENTER);
			}

			private JPanel actionPanel(Vertx vertx, UUID instanceID) {


				final JPanel actionPanel = new JPanel(new GridLayout(3, 3));

				actionPanel.add(new JLabel("GroupbugfixInstance "));
				actionPanel.add(new JLabel(instanceID.toString()));
				actionPanel.add(new JLabel());

				// todo all properties here, with their proper ui

				final JPanel container = new JPanel(new BorderLayout());
				container.add(actionPanel, BorderLayout.NORTH);			

				actionPanel.add(new JLabel("Output "));
				final JTextField txtToString = new JTextField(10);
				actionPanel.add(txtToString);
				actionPanel.add(new JButton(new AbstractAction("toString") {
					@Override
					public void actionPerformed(ActionEvent e) {
						bugfixVerticle.sendToStringMessage(vertx, instanceID, s -> SwingUtilities.invokeLater(() -> {
							txtToString.setText(s);
						}));
					}
				}));

				return actionPanel;
			}
		}    
}  