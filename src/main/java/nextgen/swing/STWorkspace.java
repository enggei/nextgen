package nextgen.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.function.Predicate;

public class STWorkspace extends JTabbedPane {

	private STTemplateNavigator templateNavigator;
	private STModelNavigator modelNavigator;

	public STWorkspace() {
		setPreferredSize(new Dimension(1200, 1024));
		setMinimumSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(1200, 1024));
		setMinimumSize(new Dimension(100, 100));
		getCanvas();
		templateNavigator = new STTemplateNavigator(this);
		modelNavigator = new STModelNavigator(this);
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public STTemplateNavigator getTemplateNavigator() {
		return templateNavigator;
	}

	public STModelNavigator getModelNavigator() {
		return modelNavigator;
	}


	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTActionTreeNodeClicked(nextgen.events.TemplateNavigatorSTGroupActionTreeNodeClicked event) {
		getSTGroupActionEditor(event.action);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTFileTreeNodeClicked(nextgen.events.ModelNavigatorSTFileTreeNodeClicked event) {
		getSTFileEditor(event.stFile);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTProjectTreeNodeClicked(nextgen.events.ModelNavigatorSTProjectTreeNodeClicked event) {
		getSTProjectEditorGrid(event.stProject);
	}

	public java.util.stream.Stream<nextgen.model.STTemplate> getSelectedSTTemplates() {
		return getTemplateNavigator().getSelectedSTTemplates();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTTemplateTreeNodeClicked(nextgen.events.ModelNavigatorSTTemplateTreeNodeClicked event) {
		getSTTemplatesEditorGrid(event.stTemplate);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTParameterTreeNodeClicked(nextgen.events.ModelNavigatorSTParameterTreeNodeClicked event) {
		getSTParameterEditorGrid(event.stParameter);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTModelTreeNodeClicked(nextgen.events.ModelNavigatorSTModelTreeNodeClicked event) {
		getModelEditor(event.stModel);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTGroupTreeNodeClicked(nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked event) {
		getSTEditor(event.stGroup).clear();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTTemplateTreeNodeClicked(nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked event) {
		getSTEditor(event.stGroup).setSTTemplate(event.stTemplate);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTEnumTreeNodeClicked(nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked event) {
		getSTEditor(event.stGroup).setSTEnum(event.stEnum);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTInterfaceTreeNodeClicked(nextgen.events.TemplateNavigatorSTInterfaceTreeNodeClicked event) {
		getSTEditor(event.stGroup).setSTInterface(event.stInterface);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelDeleted(nextgen.events.STModelDeleted event) {
		removeModelEditor(event.uuid);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTValueTreeNodeClicked(nextgen.events.ModelNavigatorSTValueTreeNodeClicked event) {
		final nextgen.swing.STValueEditor stValueEditor = getSTValueEditor();
		stValueEditor.setSTValue(event.stValue);
		SwingUtilities.invokeLater(() -> setSelectedComponent(stValueEditor));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTGroupFileClicked(nextgen.events.TemplateNavigatorSTGroupFileClicked event) {
		getSTGroupFileEditor(event.stGroupFile);
	}

	// components

	public nextgen.swing.STGroupActionEditor getSTGroupActionEditor(nextgen.model.STGroupAction model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STGroupActionEditor && (((nextgen.swing.STGroupActionEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STGroupActionEditor component = (nextgen.swing.STGroupActionEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STGroupActionEditor component = new nextgen.swing.STGroupActionEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTGroupActionEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STGroupActionEditor && (((nextgen.swing.STGroupActionEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STCanvas getCanvas() {
		return (STCanvas) find(component -> component instanceof STCanvas)
				.orElseGet(() -> {
					final STCanvas component = new STCanvas(UIManager.getColor("Panel.background"), new Dimension(800, 600));
					addPane("Canvas", component);
					return component;
				});
	}

	public void removeCanvas() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof STCanvas) {
	      	int componentIndex = i;
				SwingUtilities.invokeLater(() -> remove(componentIndex));
			}
	   }
	}

	public nextgen.swing.STModelEditor getModelEditor(nextgen.model.STModel model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STModelEditor && (((nextgen.swing.STModelEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STModelEditor component = (nextgen.swing.STModelEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STModelEditor component = new nextgen.swing.STModelEditor(model);
		addPane(appModel().getLabel(model), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeModelEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STModelEditor && (((nextgen.swing.STModelEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STEditor getSTEditor(nextgen.model.STGroupModel model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STEditor && (((STEditor) tabComponentAt).getModel().equals(model))) {
				final STEditor component = (STEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STEditor component = new STEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STEditor && (((STEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.STFileEditor getSTFileEditor(nextgen.model.STFile model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STFileEditor && (((nextgen.swing.STFileEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STFileEditor component = (nextgen.swing.STFileEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STFileEditor component = new nextgen.swing.STFileEditor(model);
		addPane("FileSink", component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTFileEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STFileEditor && (((nextgen.swing.STFileEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STValueEditor getSTValueEditor() {
		return (STValueEditor) find(component -> component instanceof STValueEditor)
				.orElseGet(() -> {
					final STValueEditor component = new STValueEditor();
					addPane("STValue", component);
					return component;
				});
	}

	public void removeSTValueEditor() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof STValueEditor) {
	      	int componentIndex = i;
				SwingUtilities.invokeLater(() -> remove(componentIndex));
			}
	   }
	}

	public nextgen.swing.STGroupFileEditor getSTGroupFileEditor(nextgen.model.STGroupFile model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STGroupFileEditor && (((nextgen.swing.STGroupFileEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STGroupFileEditor component = (nextgen.swing.STGroupFileEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STGroupFileEditor component = new nextgen.swing.STGroupFileEditor(model);
		addPane("GroupFile", component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTGroupFileEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STGroupFileEditor && (((nextgen.swing.STGroupFileEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STValueGrid getValueGrid() {
		return (STValueGrid) find(component -> component instanceof STValueGrid)
				.orElseGet(() -> {
					final STValueGrid component = new STValueGrid();
					addPane("ValueGrid", component);
					return component;
				});
	}

	public void removeValueGrid() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof STValueGrid) {
	      	int componentIndex = i;
				SwingUtilities.invokeLater(() -> remove(componentIndex));
			}
	   }
	}

	public nextgen.swing.STProjectEditorGrid getSTProjectEditorGrid(nextgen.model.STProject model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STProjectEditorGrid && (((nextgen.swing.STProjectEditorGrid) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STProjectEditorGrid component = (nextgen.swing.STProjectEditorGrid) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STProjectEditorGrid component = new nextgen.swing.STProjectEditorGrid(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTProjectEditorGrid(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STProjectEditorGrid && (((nextgen.swing.STProjectEditorGrid) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.STTemplatesEditorGrid getSTTemplatesEditorGrid(nextgen.model.STTemplate model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STTemplatesEditorGrid && (((nextgen.swing.STTemplatesEditorGrid) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STTemplatesEditorGrid component = (nextgen.swing.STTemplatesEditorGrid) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STTemplatesEditorGrid component = new nextgen.swing.STTemplatesEditorGrid(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTTemplatesEditorGrid(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STTemplatesEditorGrid && (((nextgen.swing.STTemplatesEditorGrid) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.STParameterEditorGrid getSTParameterEditorGrid(nextgen.model.STParameter model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.STParameterEditorGrid && (((nextgen.swing.STParameterEditorGrid) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.STParameterEditorGrid component = (nextgen.swing.STParameterEditorGrid) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.STParameterEditorGrid component = new nextgen.swing.STParameterEditorGrid(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTParameterEditorGrid(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.STParameterEditorGrid && (((nextgen.swing.STParameterEditorGrid) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	private nextgen.swing.STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	public <T extends Component> Optional<T> find(Predicate<Component> predicate) {
		for (int i = 0; i < getTabCount(); i++)
			if (predicate.test(getComponentAt(i)))
				return Optional.of((T) getComponentAt(i));
		return Optional.empty();
	}

	private void addPane(String title, JComponent component) {
		addTab(title, component);
		setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this, title, component));
	}

	class ButtonTabComponent extends JPanel {

		ButtonTabComponent(final JTabbedPane pane, String title, JComponent component) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setOpaque(false);

			final JLabel label = new JLabel(title);
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
			add(label);

			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e))
						SwingUtilities.invokeLater(() -> {
							final JPopupMenu pop = new JPopupMenu();

							pop.add(new AbstractAction("Close") {
								@Override
								public void actionPerformed(ActionEvent actionEvent) {
									pane.remove(component);
								}
							});

							pop.add(new AbstractAction("Close Others") {
								@Override
								public void actionPerformed(ActionEvent actionEvent) {
									closeAllExcept(component);
								}
							});

							pop.add(new AbstractAction("Close All") {
								@Override
								public void actionPerformed(ActionEvent actionEvent) {
									closeAll();
								}
							});

							pop.show(ButtonTabComponent.this, e.getX(), e.getY());
						});
					else {
						SwingUtilities.invokeLater(() -> pane.setSelectedComponent(component));
					}
				}
			});
		}
	}

	private void closeAllExcept(JComponent component) {
		SwingUtilities.invokeLater(() -> {
			for (int i = getTabCount() - 1; i >= 0; i--) {
				final Component componentAt = getComponentAt(i);
				if (componentAt.equals(component)) continue;
				remove(i);
			}
		});
	}

	private void closeAll() {
		SwingUtilities.invokeLater(() -> {
			for (int i = getTabCount() - 1; i >= 0; i--) {
				remove(i);
			}
		});
	}
}