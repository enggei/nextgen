package nextgen.st;

import nextgen.domains.meta.DomainVisitor;
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

public class DomainVisitorEditor extends JPanel {

    private final STAppPresentationModel presentationModel;

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
    private final DomainVisitor model;

    private CurrentSelectedNode currentSelectedNode;

    public DomainVisitorEditor(STAppPresentationModel presentationModel, DomainVisitor model) {
        super(new BorderLayout());

        this.model = model;
        this.presentationModel = presentationModel;
        setBackground(UIManager.getColor("Panel.background"));

        txtEditor.setEditable(false);
        txtEditor.addKeyListener(getEditorKeyListener());
        addActionsToPopup();

        final DomainVisitorEditorNavigator stModelNavigator = new DomainVisitorEditorNavigator(presentationModel, model, this);

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(stModelNavigator, BorderLayout.EAST);

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
        if (currentSelectedNode == null) return;
        presentationModel.doLaterInTransaction(transaction -> {
            currentSelectedNode.save(txtEditor.getText().trim());
            currentSelectedNode.nodeChanged();
        });
    }

    public DomainVisitor getModel() {
        return model;
    }

    public void setSelected(DomainVisitorEditorNavigator.BaseTreeNode<?> component) {

        this.currentSelectedNode = new CurrentSelectedNode(component);

        txtEditor.setText(currentSelectedNode.render());
        txtEditor.setCaretPosition(0);
        txtEditor.setEditable(currentSelectedNode.isEditable());
    }

    private final class CurrentSelectedNode {

        private final DomainVisitorEditorNavigator.BaseTreeNode<?> node;

        private CurrentSelectedNode(DomainVisitorEditorNavigator.BaseTreeNode<?> node) {
            this.node = node;
        }

        public String render() {
            return presentationModel.getInTransaction(transaction -> {
                if (node instanceof DomainVisitorEditorNavigator.DomainVisitorTreeNode)
                    return presentationModel.render(((DomainVisitorEditorNavigator.DomainVisitorTreeNode) node).getModel());
                else if (node instanceof DomainVisitorEditorNavigator.EntityVisitorTreeNode)
                    return presentationModel.render(((DomainVisitorEditorNavigator.EntityVisitorTreeNode) node).getModel());
                else if (node instanceof DomainVisitorEditorNavigator.RelationVisitorTreeNode)
                    return presentationModel.render(((DomainVisitorEditorNavigator.RelationVisitorTreeNode) node).getModel());
                else if (node instanceof DomainVisitorEditorNavigator.InitStatementsTreeNode)
                    return ((DomainVisitorEditorNavigator.InitStatementsTreeNode) node).getModel();
                else if (node instanceof DomainVisitorEditorNavigator.EndStatementsTreeNode)
                    return ((DomainVisitorEditorNavigator.EndStatementsTreeNode) node).getModel();
                return "";
            });
        }

        public void save(String statements) {
            if (node instanceof DomainVisitorEditorNavigator.EntityVisitorTreeNode)
                presentationModel.doInTransaction(transaction -> ((DomainVisitorEditorNavigator.EntityVisitorTreeNode) node).getModel().setStatements(statements));
            else if (node instanceof DomainVisitorEditorNavigator.RelationVisitorTreeNode)
                presentationModel.doInTransaction(transaction -> ((DomainVisitorEditorNavigator.RelationVisitorTreeNode) node).getModel().setStatements(statements));
            else if (node instanceof DomainVisitorEditorNavigator.InitStatementsTreeNode)
                presentationModel.doInTransaction(transaction -> getModel().setInitStatements(statements));
            else if (node instanceof DomainVisitorEditorNavigator.EndStatementsTreeNode)
                presentationModel.doInTransaction(transaction -> getModel().setEndStatements(statements));
        }

        public void nodeChanged() {
            node.nodeChanged();
        }

        public boolean isEditable() {
            return (node instanceof DomainVisitorEditorNavigator.RelationVisitorTreeNode)
                    || (node instanceof DomainVisitorEditorNavigator.EntityVisitorTreeNode)
                    || (node instanceof DomainVisitorEditorNavigator.InitStatementsTreeNode)
                    || (node instanceof DomainVisitorEditorNavigator.EndStatementsTreeNode);
        }
    }
}