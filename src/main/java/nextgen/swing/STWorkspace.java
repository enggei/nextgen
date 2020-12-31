package nextgen.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.function.Predicate;
import nextgen.events.*;
import nextgen.model.*;

public class STWorkspace extends JTabbedPane {

	private final java.util.Map<java.awt.Component, nextgen.swing.STWorkspace.ButtonTabComponent> tabComponents = new java.util.LinkedHashMap<>();
	private STTemplateNavigator templateNavigator;
	private STModelNavigator modelNavigator;

	public STWorkspace() {
		setPreferredSize(new Dimension(600, 600));
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
	public void onTemplateNavigatorSTActionTreeNodeClicked(TemplateNavigatorSTGroupActionTreeNodeClicked event) {
		getSTGroupActionEditor(event.action);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTFileTreeNodeClicked(ModelNavigatorSTFileTreeNodeClicked event) {
		getSTFileEditor(event.stFile);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTProjectTreeNodeClicked(ModelNavigatorSTProjectTreeNodeClicked event) {
		getSTProjectEditor(event.stProject);
	}

	public java.util.stream.Stream<STTemplate> getSelectedSTTemplates() {
		return getTemplateNavigator().getSelectedSTTemplates();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTTemplateTreeNodeClicked(ModelNavigatorSTTemplateTreeNodeClicked event) {
		getSTTemplatesEditor(event.stTemplate);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTParameterTreeNodeClicked(ModelNavigatorSTParameterTreeNodeClicked event) {
		getSTParameterEditor(event.parameter, event.model);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTModelTreeNodeClicked(ModelNavigatorSTModelTreeNodeClicked event) {
		getModelEditor(event.stModel);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTGroupTreeNodeClicked(TemplateNavigatorSTGroupTreeNodeClicked event) {
		getSTTemplateEditor(event.stGroup).clear();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTTemplateTreeNodeClicked(TemplateNavigatorSTTemplateTreeNodeClicked event) {
		getSTTemplateEditor(event.stGroup).setSTTemplate(event.stTemplate);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTEnumTreeNodeClicked(TemplateNavigatorSTEnumTreeNodeClicked event) {
		getSTTemplateEditor(event.stGroup).setSTEnum(event.stEnum);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTInterfaceTreeNodeClicked(TemplateNavigatorSTInterfaceTreeNodeClicked event) {
		getSTTemplateEditor(event.stGroup).setSTInterface(event.stInterface);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelDeleted(STModelDeleted event) {
		removeModelEditor(event.uuid);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onShowSTModelInCanvas(ShowSTModelInCanvas event) {
		getCanvas().addSTModelNode(event.stModel);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onShowSTProjectInCanvas(ShowSTProjectInCanvas event) {
		getCanvas().addSTProjectNode(event.stProject);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTValueTreeNodeClicked(ModelNavigatorSTValueTreeNodeClicked event) {
		final STValueEditor stValueEditor = getSTValueEditor();
		stValueEditor.setSTValue(event.stValue);
		SwingUtilities.invokeLater(() -> setSelectedComponent(stValueEditor));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelChanged(STModelChanged event) {
		find(tabComponentAt -> tabComponentAt instanceof STModelEditor && (((STModelEditor) tabComponentAt).getModel().equals(event.model)))
		      .ifPresent(component -> {
		         final STWorkspace.ButtonTabComponent buttonTabComponent = tabComponents.get(component);
		         if (buttonTabComponent != null) buttonTabComponent.setTitle(appModel().getLabel(event.model));
		      });
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTGroupFileClicked(TemplateNavigatorSTGroupFileClicked event) {
		getSTGroupFileEditor(event.stGroupFile);
	}

	// components

	public STGroupActionEditor getSTGroupActionEditor(STGroupAction model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STGroupActionEditor && (((STGroupActionEditor) tabComponentAt).getModel().equals(model))) {
				final STGroupActionEditor component = (STGroupActionEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STGroupActionEditor component = new STGroupActionEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTGroupActionEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STGroupActionEditor && (((STGroupActionEditor) getComponentAt(i)).getUuid().equals(uuid))) {
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

	public STModelEditor getModelEditor(STModel model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STModelEditor && (((STModelEditor) tabComponentAt).getModel().equals(model))) {
				final STModelEditor component = (STModelEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STModelEditor component = new STModelEditor(model);
		addPane(appModel().getLabel(model), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeModelEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STModelEditor && (((STModelEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STTemplateEditor getSTTemplateEditor(STGroupModel model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STTemplateEditor && (((STTemplateEditor) tabComponentAt).getModel().equals(model))) {
				final STTemplateEditor component = (STTemplateEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STTemplateEditor component = new STTemplateEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTTemplateEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STTemplateEditor && (((STTemplateEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STFileEditor getSTFileEditor(STFile model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STFileEditor && (((STFileEditor) tabComponentAt).getModel().equals(model))) {
				final STFileEditor component = (STFileEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STFileEditor component = new STFileEditor(model);
		addPane("FileSink", component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTFileEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STFileEditor && (((STFileEditor) getComponentAt(i)).getUuid().equals(uuid))) {
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

	public STGroupFileEditor getSTGroupFileEditor(STGroupFile model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STGroupFileEditor && (((STGroupFileEditor) tabComponentAt).getModel().equals(model))) {
				final STGroupFileEditor component = (STGroupFileEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STGroupFileEditor component = new STGroupFileEditor(model);
		addPane("GroupFile", component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTGroupFileEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STGroupFileEditor && (((STGroupFileEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STValuesEditor getValueGrid() {
		return (STValuesEditor) find(component -> component instanceof STValuesEditor)
				.orElseGet(() -> {
					final STValuesEditor component = new STValuesEditor();
					addPane("ValueGrid", component);
					return component;
				});
	}

	public void removeValueGrid() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof STValuesEditor) {
	      	int componentIndex = i;
				SwingUtilities.invokeLater(() -> remove(componentIndex));
			}
	   }
	}

	public STProjectEditor getSTProjectEditor(STProject model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STProjectEditor && (((STProjectEditor) tabComponentAt).getModel().equals(model))) {
				final STProjectEditor component = (STProjectEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STProjectEditor component = new STProjectEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTProjectEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STProjectEditor && (((STProjectEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STTemplatesEditor getSTTemplatesEditor(STTemplate model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STTemplatesEditor && (((STTemplatesEditor) tabComponentAt).getModel().equals(model))) {
				final STTemplatesEditor component = (STTemplatesEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STTemplatesEditor component = new STTemplatesEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTTemplatesEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STTemplatesEditor && (((STTemplatesEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public STParameterEditor getSTParameterEditor(STParameter model,STModel stModel) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STParameterEditor && (((STParameterEditor) tabComponentAt).getModel().equals(model))) {
				final STParameterEditor component = (STParameterEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final STParameterEditor component = new STParameterEditor(model,stModel);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTParameterEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof STParameterEditor && (((STParameterEditor) getComponentAt(i)).getUuid().equals(uuid))) {
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
		final nextgen.swing.STWorkspace.ButtonTabComponent tabComponent = new nextgen.swing.STWorkspace.ButtonTabComponent(this, title, component);
		tabComponents.put(component, tabComponent);
		setTabComponentAt(indexOfComponent(component), tabComponent);
	}

	class ButtonTabComponent extends JPanel {

		private final javax.swing.JLabel label;

		ButtonTabComponent(final JTabbedPane pane, String title, JComponent component) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setOpaque(false);

			this.label = nextgen.swing.ComponentFactory.newJLabel(title);
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
									close(component);
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

		void setTitle(String title) {
			SwingUtilities.invokeLater(() -> label.setText(title));
		}
	}

	private void close(JComponent component) {
		SwingUtilities.invokeLater(() -> remove(component));
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