package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.function.Predicate;

public class STWorkspace extends JTabbedPane {

	public STWorkspace() {
		setPreferredSize(new Dimension(1200, 1024));
		findCanvas();
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelTreeNodeClicked(STAppEvents.STModelTreeNodeClicked event) {
		setSelectedComponent(findModelEditor(event.stModel, () -> appModel().findSTTemplateByUuid(event.stModel.getStTemplate())));
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
		addPane(stTemplateSupplier.get().getName() + "Model", component);
		return component;
	}

	public STModelEditor getModelEditor(STTemplate stTemplate, STModel stModel) {
		for (int i = 0; i < getTabCount(); i++) {
				final Component tabComponentAt = getComponentAt(i);
				if (tabComponentAt instanceof STModelEditor) {
					if (((STModelEditor) tabComponentAt).getModel().equals(stModel))
						return (STModelEditor) tabComponentAt;
				}
		}

		final STModelEditor component = new STModelEditor(stModel);
		addPane(stTemplate.getName() + "Model", component);
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