package nextgen.st;

import nextgen.st.model.STModel;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STRenderPanel extends JPanel {

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
    private final STAppPresentationModel presentationModel;
    private STModel stModel;

    public STRenderPanel(STAppPresentationModel presentationModel) {
        super(new BorderLayout());
        this.presentationModel = presentationModel;
        txtEditor.setEditable(false);
        addActionsToPopup();
        RTextScrollPane scrollPane = new RTextScrollPane(txtEditor);
        add(scrollPane, BorderLayout.CENTER);
    }

    STRenderPanel setText(STModel stModel) {
        txtEditor.setText(presentationModel.render(stModel));
        txtEditor.setCaretPosition(0);
        this.stModel = stModel;
        return this;
    }

    public void addActionsToPopup() {
        final JPopupMenu pop = txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Edit", actionEvent -> presentationModel.doLaterInTransaction(transaction -> {
            final STWorkspace workspace = presentationModel.getWorkspace();
            final STModelEditor modelEditor = workspace.getModelEditor(presentationModel.db.findSTTemplateByUuid(stModel.getStTemplate()), stModel);
            workspace.setSelectedComponent(modelEditor);
        })));
        pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(txtEditor.getText().trim())));
        pop.add(newAction("Write to File", actionEvent -> presentationModel.writeToFile(stModel)));
    }
}