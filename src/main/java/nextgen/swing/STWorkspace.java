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

	private final nextgen.swing.STApp stApp;

	private final java.util.Map<java.awt.Component, nextgen.swing.STWorkspace.ButtonTabComponent> tabComponents = new java.util.LinkedHashMap<>();
	private final STTemplateNavigator templateNavigator;
	private final STModelNavigator modelNavigator;

	public STWorkspace(nextgen.swing.STApp stApp) {
		this.stApp = stApp;
		setPreferredSize(new Dimension(600, 600));
		setMinimumSize(new Dimension(100, 100));
		setMaximumSize(new Dimension(1200, 1200));
		getCanvas();
		getTextProcessor();
		templateNavigator = new STTemplateNavigator();
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
	public void onDomainVisitorTreeNodeClicked(DomainVisitorTreeNodeClicked event) {
		getDomainVisitorEditor(event.domainVisitor);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainRelationTreeNodeClicked(nextgen.events.DomainRelationTreeNodeClicked event) {
		getDomainRelationEditor(event.domainRelation);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainTreeNodeClicked(nextgen.events.DomainTreeNodeClicked event) {
		getDomainEditor(event.domain);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainEntityTreeNodeClicked(nextgen.events.DomainEntityTreeNodeClicked event) {
		getDomainEntityEditor(event.domainEntity);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTActionTreeNodeClicked(STGroupActionTreeNodeClicked event) {
		getSTGroupActionEditor(event.action);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTFileTreeNodeClicked(STFileTreeNodeClicked event) {
		getSTFileEditor(event.stFile);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTProjectTreeNodeClicked(STProjectTreeNodeClicked event) {
		getSTProjectEditor(event.stProject);
	}

	public java.util.stream.Stream<STTemplate> getSelectedSTTemplates() {
		return getTemplateNavigator().getSelectedSTTemplates();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTTemplateTreeNodeClicked(STTemplateTreeNodeClicked event) {
		getSTTemplateEditor(event.stTemplate);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTParameterTreeNodeClicked(STParameterTreeNodeClicked event) {
		getSTParameterEditor(event.parameter, event.model);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelTreeNodeClicked(STModelTreeNodeClicked event) {
		getSTModelEditor(event.stModel);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupTreeNodeClicked(STGroupTreeNodeClicked event) {
		getSTGroupModelEditor(event.stGroup);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumTreeNodeClicked(STEnumTreeNodeClicked event) {
		getSTEnumEditor(event.stEnum);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTInterfaceTreeNodeClicked(STInterfaceTreeNodeClicked event) {
		getSTInterfaceEditor(event.stInterface);
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
	public void onSTValueTreeNodeClicked(STValueTreeNodeClicked event) {
		final nextgen.swing.editors.STValueEditor stValueEditor = getSTValueEditor();
		stValueEditor.setModel(event.stValue);
		SwingUtilities.invokeLater(() -> setSelectedComponent(stValueEditor));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelChanged(STModelChanged event) {
		find(tabComponentAt -> tabComponentAt instanceof STModelEditor && (((STModelEditor) tabComponentAt).getModel().equals(event.sTModel)))
		      .ifPresent(component -> {
		         final STWorkspace.ButtonTabComponent buttonTabComponent = tabComponents.get(component);
		         if (buttonTabComponent != null) buttonTabComponent.setTitle(appModel().getLabel(event.sTModel));
		      });
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileClicked(STGroupFileClicked event) {
		getSTGroupFileEditor(event.stGroupFile);
	}

	// components

	public nextgen.swing.editors.DomainVisitorEditor getDomainVisitorEditor(nextgen.model.DomainVisitor model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.DomainVisitorEditor && (((nextgen.swing.editors.DomainVisitorEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.DomainVisitorEditor component = (nextgen.swing.editors.DomainVisitorEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.DomainVisitorEditor component = new nextgen.swing.editors.DomainVisitorEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeDomainVisitorEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.DomainVisitorEditor && (((nextgen.swing.editors.DomainVisitorEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.STGroupModelEditor getSTGroupModelEditor(STGroupModel model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.STGroupModelEditor && (((nextgen.swing.editors.STGroupModelEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.STGroupModelEditor component = (nextgen.swing.editors.STGroupModelEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.STGroupModelEditor component = new nextgen.swing.editors.STGroupModelEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTGroupModelEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.STGroupModelEditor && (((nextgen.swing.editors.STGroupModelEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.STEnumEditor getSTEnumEditor(STEnum model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.STEnumEditor && (((nextgen.swing.editors.STEnumEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.STEnumEditor component = (nextgen.swing.editors.STEnumEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.STEnumEditor component = new nextgen.swing.editors.STEnumEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTEnumEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.STEnumEditor && (((nextgen.swing.editors.STEnumEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.STInterfaceEditor getSTInterfaceEditor(STInterface model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.STInterfaceEditor && (((nextgen.swing.editors.STInterfaceEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.STInterfaceEditor component = (nextgen.swing.editors.STInterfaceEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.STInterfaceEditor component = new nextgen.swing.editors.STInterfaceEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTInterfaceEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.STInterfaceEditor && (((nextgen.swing.editors.STInterfaceEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.DomainEntityEditor getDomainEntityEditor(nextgen.model.DomainEntity model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.DomainEntityEditor && (((nextgen.swing.editors.DomainEntityEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.DomainEntityEditor component = (nextgen.swing.editors.DomainEntityEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.DomainEntityEditor component = new nextgen.swing.editors.DomainEntityEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeDomainEntityEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.DomainEntityEditor && (((nextgen.swing.editors.DomainEntityEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.DomainRelationEditor getDomainRelationEditor(DomainRelation model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.DomainRelationEditor && (((nextgen.swing.editors.DomainRelationEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.DomainRelationEditor component = (nextgen.swing.editors.DomainRelationEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.DomainRelationEditor component = new nextgen.swing.editors.DomainRelationEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeDomainRelationEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.DomainRelationEditor && (((nextgen.swing.editors.DomainRelationEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

	public nextgen.swing.editors.DomainEditor getDomainEditor(nextgen.model.Domain model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.DomainEditor && (((nextgen.swing.editors.DomainEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.DomainEditor component = (nextgen.swing.editors.DomainEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.DomainEditor component = new nextgen.swing.editors.DomainEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeDomainEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.DomainEditor && (((nextgen.swing.editors.DomainEditor) getComponentAt(i)).getUuid().equals(uuid))) {
		      int componentIndex = i;
		      SwingUtilities.invokeLater(() -> remove(componentIndex));
		   }
		}
	}

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

	public STModelEditor getSTModelEditor(STModel model) {
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

	public nextgen.swing.editors.STTemplateEditor getSTTemplateEditor(STTemplate model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.STTemplateEditor && (((nextgen.swing.editors.STTemplateEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.STTemplateEditor component = (nextgen.swing.editors.STTemplateEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.STTemplateEditor component = new nextgen.swing.editors.STTemplateEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTTemplateEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.STTemplateEditor && (((nextgen.swing.editors.STTemplateEditor) getComponentAt(i)).getUuid().equals(uuid))) {
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

	public nextgen.swing.editors.STValueEditor getSTValueEditor() {
		return (nextgen.swing.editors.STValueEditor) find(component -> component instanceof nextgen.swing.editors.STValueEditor)
				.orElseGet(() -> {
					final nextgen.swing.editors.STValueEditor component = new nextgen.swing.editors.STValueEditor();
					addPane("STValue", component);
					return component;
				});
	}

	public void removeSTValueEditor() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof nextgen.swing.editors.STValueEditor) {
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

	public nextgen.swing.editors.STProjectEditor getSTProjectEditor(STProject model) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof nextgen.swing.editors.STProjectEditor && (((nextgen.swing.editors.STProjectEditor) tabComponentAt).getModel().equals(model))) {
				final nextgen.swing.editors.STProjectEditor component = (nextgen.swing.editors.STProjectEditor) tabComponentAt;
				setSelectedComponent(component);
				return component;
			}
		}

		final nextgen.swing.editors.STProjectEditor component = new nextgen.swing.editors.STProjectEditor(model);
		addPane(model.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTProjectEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
		   if (getComponentAt(i) instanceof nextgen.swing.editors.STProjectEditor && (((nextgen.swing.editors.STProjectEditor) getComponentAt(i)).getUuid().equals(uuid))) {
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

	public TextProcessingPanel getTextProcessor() {
		return (TextProcessingPanel) find(component -> component instanceof TextProcessingPanel)
				.orElseGet(() -> {
					final TextProcessingPanel component = new TextProcessingPanel();
					addPane("TextProcessor", component);
					return component;
				});
	}

	public void removeTextProcessor() {
	   for (int i = 0; i < getTabCount(); i++) {
	      final Component tabComponentAt = getComponentAt(i);
	      if (tabComponentAt instanceof TextProcessingPanel) {
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

pop.addSeparator();

pop.add(new AbstractAction("Maximize") {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		stApp.maximizeCenter();
	}
});

pop.add(new AbstractAction("Normalize") {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		stApp.normalizeSplits();
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