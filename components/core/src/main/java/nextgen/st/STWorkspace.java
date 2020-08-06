package nextgen.st;

import nextgen.st.canvas.STCanvas;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

public class STWorkspace extends JTabbedPane {

    private final STAppPresentationModel presentationModel;

    public STWorkspace(STAppPresentationModel presentationModel) {
        this.presentationModel = presentationModel;
        setPreferredSize(new Dimension(800, 600));
        findCanvas();
    }

    public Optional<STCanvas> findCanvas() {
        for (int i = 0; i < getTabCount(); i++) {
            final Component tabComponentAt = getComponentAt(i);
            if (tabComponentAt instanceof STCanvas)
                return Optional.of((STCanvas) tabComponentAt);
        }

        final STCanvas stCanvas = new STCanvas(presentationModel);
        addTab("Canvas", stCanvas);
        return Optional.of(stCanvas);
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
        addTab(stTemplate.getName() + "-Models", stModelGrid);
        setTabComponentAt(indexOfComponent(stModelGrid), new ButtonTabComponent(this));
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
        addTab(stTemplate.getName() + "Model", component);
        setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this));
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
        addTab(stGroup.getName(), component);
        setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this));
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
        addTab("Values", component);
        setTabComponentAt(indexOfComponent(component), new ButtonTabComponent(this));
        return component;
    }

    static class ButtonTabComponent extends JPanel {

        public ButtonTabComponent(final JTabbedPane pane) {
            super(new FlowLayout(FlowLayout.LEFT, 0, 0));

            final JLabel label = new JLabel() {
                public String getText() {
                    int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                    if (i != -1) return pane.getTitleAt(i);
                    return null;
                }
            };
            label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

            add(label);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        SwingUtilities.invokeLater(() -> {
                            final JPopupMenu pop = new JPopupMenu();
                            pop.add(new AbstractAction("Close") {
                                @Override
                                public void actionPerformed(ActionEvent e1) {
                                    SwingUtilities.invokeLater(() -> {
                                        int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                                        if (i != -1) pane.remove(i);
                                    });

                                }
                            });
                            SwingUtil.showPopup(pop, pane, e);
                        });
                    } else {
                        pane.setSelectedIndex(pane.indexOfTabComponent(ButtonTabComponent.this));
                    }
                }
            });

            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        }
    }
}