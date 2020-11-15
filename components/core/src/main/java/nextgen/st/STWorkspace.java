package nextgen.st;

import nextgen.st.model.STGroupModel;
import nextgen.st.model.STTemplate;
import nextgen.st.model.STModel;

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
		findCanvas();
		appModel().doInTransaction(transaction -> {
					templateNavigator = new STTemplateNavigator(this);
					modelNavigator = new STModelNavigator(this);
				});
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public STTemplateNavigator getTemplateNavigator() {
			return templateNavigator;
		}


	public STModelNavigator getModelNavigator() {
			return modelNavigator;
		}


	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTFileTreeNodeClicked(nextgen.events.ModelNavigatorSTFileTreeNodeClicked event) {
		getSTFileEditor(event.stFile);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTModelTreeNodeClicked(nextgen.events.ModelNavigatorSTModelTreeNodeClicked event) {
		getModelEditor(event.stTemplate, event.stModel);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTGroupTreeNodeClicked(nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked event) {
		getSTEditor(event.stGroup);
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
	public void onModelNavigatorSTProjectTreeNodeClicked(nextgen.events.ModelNavigatorSTProjectTreeNodeClicked event) {
		getValueGrid();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onTemplateNavigatorSTInterfaceTreeNodeClicked(nextgen.events.TemplateNavigatorSTInterfaceTreeNodeClicked event) {
		getSTEditor(event.stGroup).setSTInterface(event.stInterface);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelDeleted(nextgen.events.STModelDeleted event) {
		SwingUtilities.invokeLater(() -> removeModelEditor(event.uuid));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTValueTreeNodeClicked(nextgen.events.ModelNavigatorSTValueTreeNodeClicked event) {
		final nextgen.st.STValueEditor stValueEditor = getSTValueEditor();
		stValueEditor.setSTValue(event.stValue);
		SwingUtilities.invokeLater(() -> setSelectedComponent(stValueEditor));
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	public STRenderPanel findRenderer() {
		return (STRenderPanel) find(component -> component instanceof STRenderPanel)
				.orElseGet(() -> {
					final STRenderPanel stRenderPanel = new STRenderPanel();
					addPane("Renderer", stRenderPanel);
					return stRenderPanel;
				});
	}

	public <T extends Component> Optional<T> find(Predicate<Component> predicate) {
		for (int i = 0; i < getTabCount(); i++)
			if (predicate.test(getComponentAt(i)))
				return Optional.of((T) getComponentAt(i));
		return Optional.empty();
	}

	public STModelCanvas findCanvas() {
		return (STModelCanvas) find(component -> component instanceof STModelCanvas)
				.orElseGet(() -> {
					final STModelCanvas stModelCanvas = new STModelCanvas(UIManager.getColor("Panel.background"), new Dimension(800, 600));
					addPane("Canvas", stModelCanvas);
					return stModelCanvas;
				});
	}

	public STModelGrid getModelGrid(STTemplate stTemplate) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STModelGrid) {
					if (((STModelGrid) tabComponentAt).getModel().equals(stTemplate))
						return (STModelGrid) tabComponentAt;
				}
		}

		final STModelGrid stModelGrid = new STModelGrid(stTemplate);
		addPane(stTemplate.getName() + "-Models", stModelGrid);
		return stModelGrid;
	}

	public STModelEditor findModelEditor(STModel stModel, java.util.function.Supplier<STTemplate> stTemplateSupplier) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STModelEditor) {
					if (((STModelEditor) tabComponentAt).getModel().equals(stModel))
						return (STModelEditor) tabComponentAt;
				}
		}

		final STModelEditor component = new STModelEditor(stModel);
		addPane(appModel().tryToFindArgument(stModel, "name", () -> stTemplateSupplier.get().getName() + "Model"), component);
		return component;
	}

	public void removeModelEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STModelEditor) {
				if (((STModelEditor) tabComponentAt).getUuid().equals(uuid)) {
					remove(i);
				}
			}
		}
	}

	public STModelEditor getModelEditor(STTemplate stTemplate, STModel stModel) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STModelEditor) {
					if (((STModelEditor) tabComponentAt).getModel().equals(stModel)) {
						final nextgen.st.STModelEditor editor = (nextgen.st.STModelEditor) tabComponentAt;
						setSelectedComponent(editor);
						return editor;
					}
				}
		}

		final STModelEditor component = new STModelEditor(stModel);
		addPane(appModel().tryToFindArgument(stModel, "name", () -> stTemplate.getName() + "Model"), component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTEditor(STGroupModel stGroup) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STEditor) {
					if (((STEditor) tabComponentAt).getModel().equals(stGroup)) {
						remove(i);
					}
				}
		}
	}

	public STEditor getSTEditor(STGroupModel stGroup) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STEditor) {
					if (((STEditor) tabComponentAt).getModel().equals(stGroup)) {
						final STEditor stEditor = (STEditor) tabComponentAt;
						stEditor.setSTTemplate(null);
						setSelectedComponent(stEditor);
						return stEditor;
					}
				}
		}

		final STEditor component = new STEditor(stGroup);
		component.setSTTemplate(null);
		addPane(stGroup.getName(), component);
		setSelectedComponent(component);
		return component;
	}

	private nextgen.st.STFileEditor getSTFileEditor(nextgen.st.model.STFile stFile) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STFileEditor) {
				if (((STFileEditor) tabComponentAt).getSTFile().equals(stFile)) {
					final nextgen.st.STFileEditor editor = (nextgen.st.STFileEditor) tabComponentAt;
					setSelectedComponent(editor);
					return editor;
				}
			}
		}

		final STFileEditor component = new STFileEditor(stFile);
		addPane("FileSink", component);
		setSelectedComponent(component);
		return component;
	}

	public void removeSTValueEditor(String uuid) {
		for (int i = 0; i < getTabCount(); i++) {
			final Component tabComponentAt = getComponentAt(i);
			if (tabComponentAt instanceof STValueEditor) {
				if (((STValueEditor) tabComponentAt).getUuid().equals(uuid)) {
					remove(i);
				}
			}
		}
	}

	public STValueEditor getSTValueEditor() {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STValueEditor) {
					return (STValueEditor) tabComponentAt;
				}
		}

		final STValueEditor component = new STValueEditor();
		addPane("STValue", component);
		setSelectedComponent(component);
		return component;
	}

	public STValueGrid getValueGrid() {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STValueGrid)
					return (STValueGrid) tabComponentAt;
		}

		final STValueGrid component = new STValueGrid();
		addPane("Values", component);
		return component;
	}

	private void addPane(String title, JComponent component) {
		addTab(title, component);
		setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this, title, component));
	}

	public void showCanvas() {
		SwingUtilities.invokeLater(() -> setSelectedComponent(findCanvas()));
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
									appModel().getWorkspace().closeAllExcept(component);
								}
							});

							pop.add(new AbstractAction("Close All") {
								@Override
								public void actionPerformed(ActionEvent actionEvent) {
									appModel().getWorkspace().closeAll();
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