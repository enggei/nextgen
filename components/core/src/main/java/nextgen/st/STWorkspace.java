package nextgen.st;

import nextgen.st.canvas.STCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class STWorkspace extends JTabbedPane {

    public STWorkspace(STAppPresentationModel presentationModel) {
        addTab("Canvas", new nextgen.st.canvas.STCanvas(presentationModel));
        setPreferredSize(new Dimension(800, 600));
    }

    public Optional<STCanvas> findCanvas() {
        for (int i = 0; i < getTabCount(); i++) {
            final Component tabComponentAt = getComponentAt(i);
            if (tabComponentAt instanceof STCanvas)
                return Optional.of((STCanvas) tabComponentAt);
        }
        return Optional.empty();
    }
}