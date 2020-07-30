package nextgen.st;

import nextgen.st.canvas.STCanvas;
import nextgen.st.domain.STTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class STWorkspace extends JTabbedPane {

    private final STAppPresentationModel presentationModel;

    public STWorkspace(STAppPresentationModel presentationModel) {
        this.presentationModel = presentationModel;
        setPreferredSize(new Dimension(800, 600));
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
        return stModelGrid;
    }
}