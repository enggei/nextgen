package nextgen.st;

import nextgen.st.model.STModel;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditor extends JPanel {

    private final STAppPresentationModel presentationModel;

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
    private final STModel stModel;

    private STModelEditorNavigator.STValueTreeNode currentTreeNode;

    public STModelEditor(STAppPresentationModel presentationModel, STModel stModel) {
        super(new BorderLayout());

        this.stModel = stModel;
        this.presentationModel = presentationModel;
        setBackground(UIManager.getColor("Panel.background"));

        txtEditor.setEditable(false);
        txtEditor.addKeyListener(getEditorKeyListener());
        addActionsToPopup();

        final STModelEditorNavigator stModelNavigator = new STModelEditorNavigator(presentationModel, stModel, this);

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(stModelNavigator, BorderLayout.EAST);

        setText(presentationModel.render(stModel), null);
    }

    public void addActionsToPopup() {
        final JPopupMenu pop = txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Save", actionEvent -> tryToSave()));
        pop.add(newAction("Append From Clipboard", actionEvent -> {
            if (!txtEditor.isEditable()) return;
            txtEditor.append(SwingUtil.fromClipboard().trim());
            txtEditor.setCaretPosition(0);
            tryToSave();
        }));
        pop.add(newAction("Prepend From Clipboard", actionEvent -> {
            if (!txtEditor.isEditable()) return;
            txtEditor.setText(SwingUtil.fromClipboard().trim() + txtEditor.getText());
            txtEditor.setCaretPosition(0);
            tryToSave();
        }));
        pop.addSeparator();
        pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(txtEditor.getText().trim())));
    }

    private KeyListener getEditorKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {
                    tryToSave();
                }
            }
        };
    }

    void tryToSave() {
        if (currentTreeNode == null) return;
        presentationModel.doLaterInTransaction(transaction -> {
            currentTreeNode.getModel().setValue(txtEditor.getText().trim());
            currentTreeNode.nodeChanged();
        });
    }

    void setText(String text, STModelEditorNavigator.STValueTreeNode selectedTreeNode) {
        txtEditor.setText(text);
        txtEditor.setCaretPosition(0);
        txtEditor.setEditable(selectedTreeNode != null);
        this.currentTreeNode = selectedTreeNode;
    }

    public STModel getModel() {
        return stModel;
    }
}