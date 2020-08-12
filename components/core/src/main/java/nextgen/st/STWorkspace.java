package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class STWorkspace extends JTabbedPane {

    private final STAppPresentationModel presentationModel;

    public STWorkspace(STAppPresentationModel presentationModel) {
        this.presentationModel = presentationModel;
        setPreferredSize(new Dimension(800, 600));
        findCanvas();
    }

    public Optional<STModelCanvas> findCanvas() {
        for (int i = 0; i < getTabCount(); i++) {
            final Component tabComponentAt = getComponentAt(i);
            if (tabComponentAt instanceof STModelCanvas)
                return Optional.of((STModelCanvas) tabComponentAt);
        }

        final STModelCanvas stModelCanvas = new STModelCanvas(Color.WHITE, new Dimension(800,600),presentationModel);
        addPane("Canvas", stModelCanvas);
        return Optional.of(stModelCanvas);
    }

    public STModelGrid getModelGrid(STTemplate stTemplate) {
        for (int i = 0; i < getTabCount(); i++) {
            final Component tabComponentAt = getComponentAt(i);
            if (tabComponentAt instanceof STModelGrid) {
                if (((STModelGrid) tabComponentAt).getModel().equals(stTemplate))
                    return (STModelGrid) tabComponentAt;
            }
        }

        final STModelGrid stModelGrid = new STModelGrid(presentationModel, stTemplate);
        addPane(stTemplate.getName() + "-Models", stModelGrid);
        return stModelGrid;
    }

    public STModelEditor getModelEditor(STTemplate stTemplate, STModel stModel) {
        for (int i = 0; i < getTabCount(); i++) {
            final Component tabComponentAt = getComponentAt(i);
            if (tabComponentAt instanceof STModelEditor) {
                if (((STModelEditor) tabComponentAt).getModel().equals(stModel))
                    return (STModelEditor) tabComponentAt;
            }
        }

        final STModelEditor component = new STModelEditor(presentationModel, stModel);
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

        final STEditor component = new STEditor(stGroup, presentationModel);
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

        final STValueGrid component = new STValueGrid(presentationModel);
        addPane("Values", component);
        return component;
    }

    private void addPane(String title, JComponent component) {
        addTab(title, component);
        setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this, title, component));
    }

    public void showCanvas() {
        findCanvas().ifPresent(stModelCanvas -> SwingUtilities.invokeLater(() -> setSelectedComponent(stModelCanvas)));
    }

    class ButtonTabComponent extends JPanel {

        ButtonTabComponent(final JTabbedPane pane, String title, JComponent component) {
            super(new FlowLayout(FlowLayout.LEFT, 0, 0));
            setOpaque(false);

            final JLabel label = new JLabel(title);
            label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
            add(label);

            final JButton btnClose = new JButton(presentationModel.loadIcon("close", "12x12"));
            final Dimension dimension = new Dimension(12, 16);
            btnClose.setMaximumSize(dimension);
            btnClose.setPreferredSize(dimension);
            btnClose.setMinimumSize(dimension);
            btnClose.setOpaque(false);
            btnClose.setContentAreaFilled(false);
            btnClose.setBorderPainted(false);
            btnClose.addActionListener(e -> SwingUtilities.invokeLater(() -> pane.remove(component)));
            add(btnClose);
        }
    }
}