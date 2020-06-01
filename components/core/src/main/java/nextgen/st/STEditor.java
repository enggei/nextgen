package nextgen.st;

import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import nextgen.st.domain.STGParseResult;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.st.domain.STFactory.newSTGroupModel;
import static nextgen.st.domain.STFactory.newSTTemplate;

public class STEditor extends JPanel {

    private final RSyntaxTextArea txtEditor = new RSyntaxTextArea(20, 60);
    private final Color uneditedColor = txtEditor.getBackground();
    private final Color errorColor = Color.RED;
    private final Border defaultBorder = txtEditor.getBorder();

    private final STNavigator.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode;

    private String startText;
    private STNavigator.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode;

    public STEditor(STNavigator.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {
        super(new BorderLayout());

        this.stGroupTreeNode = stGroupTreeNode;

        this.txtEditor.setFont(new Font("Hack", Font.PLAIN, 12));
        this.txtEditor.setTabSize(3);
        this.txtEditor.setCodeFoldingEnabled(true);
        this.txtEditor.addKeyListener(new STTemplateEditorKeyListener());

        this.startText = STGenerator.toStg(stGroupTreeNode.getModel());
        this.txtEditor.setText(startText);
        this.txtEditor.setEditable(false);
        this.txtEditor.setCaretPosition(0);

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        setPreferredSize(new Dimension(800, 600));
    }

    public STNavigator.STGDirectoryTreeNode.STGroupTreeNode getStGroupTreeNode() {
        return stGroupTreeNode;
    }

    public void setSTTemplate(STNavigator.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode) {

        this.stTemplateTreeNode = stTemplateTreeNode;

        this.startText = stTemplateTreeNode == null ?
                this.startText = STGenerator.toStg(stGroupTreeNode.getModel()) :
                stTemplateTreeNode.getModel().getText();

        this.txtEditor.setText(startText);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.setEditable(stTemplateTreeNode != null);
    }

    private void commit() {

        this.txtEditor.setBorder(defaultBorder);

        final String text = txtEditor.getText().trim();

        final STGroupModel originalGroup = stGroupTreeNode.getModel();
        final STTemplate originalTemplate = stTemplateTreeNode.getModel();

        final STGParseResult parseResult = STParser.parse(toSTGroup(newSTGroupModel()
                .setDelimiter(originalGroup.getDelimiter())
                .setName(originalGroup.getName())
                .addTemplates(newSTTemplate()
                        .setName(originalTemplate.getName())
                        .setText(text))));

        if (parseResult.getErrors().isEmpty()) {

            originalTemplate.setText(text);
            startText = text;
            txtEditor.setBackground(uneditedColor);

            final STNavigator.STGDirectoryTreeNode stgDirectoryTreeNode = (STNavigator.STGDirectoryTreeNode) stGroupTreeNode.getParent();
            FileUtil.write(STGenerator.toStg(originalGroup), FileUtil.tryToCreateFileIfNotExists(new File(stgDirectoryTreeNode.getModel().getPath(), originalGroup.getName() + ".stg")));

        } else {
            this.txtEditor.setBorder(BorderFactory.createLineBorder(errorColor));
            parseResult.getErrors().forEach(stgError -> System.out.println(stgError.getType() + " " + stgError.getMessage()));
        }
    }

    private class STTemplateEditorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if (stTemplateTreeNode == null) return;

            if (keyEvent.getKeyCode() == KeyEvent.VK_L && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                insertListProperty();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_I && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                insertIf();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                insertSimpleProperty();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_R && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                replaceAndInsertProperty();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_F && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                format(txtEditor);
            } else if ((keyEvent.getKeyCode() == KeyEvent.VK_ENTER || keyEvent.getKeyCode() == KeyEvent.VK_S) && keyEvent.getModifiers() == KeyEvent.CTRL_MASK) {
                commit();
            }
        }

        private void insertListProperty() {
            final String input = SwingUtil.showInputDialog("name", txtEditor);
            if (input == null) return;
            final String name = input.contains(" ") ? input.split(" ")[0] : input;
            final String separator = input.contains(" ") ? input.split(" ")[1] : null;
            SwingUtilities.invokeLater(() -> {
                removeSelectedTextIfAny();
                final int caretPosition = txtEditor.getCaretPosition();
                final String pre = stGroupTreeNode.getModel().getDelimiter() + name + ":{it|";
                final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
                final String list = pre + "}" + sep + stGroupTreeNode.getModel().getDelimiter();
                txtEditor.insert(list, caretPosition);
                txtEditor.setCaretPosition(caretPosition + pre.length());
            });
        }

        private void insertIf() {
            final String input = SwingUtil.showInputDialog("condition", txtEditor);
            if (input == null) return;
            final String name = input.trim();
            SwingUtilities.invokeLater(() -> {
                removeSelectedTextIfAny();
                final int caretPosition = txtEditor.getCaretPosition();
                final String pre = stGroupTreeNode.getModel().getDelimiter() + "if(" + name + ")" + stGroupTreeNode.getModel().getDelimiter();
                final String list = pre + stGroupTreeNode.getModel().getDelimiter() + "endif" + stGroupTreeNode.getModel().getDelimiter();
                txtEditor.insert(list, caretPosition);
                txtEditor.setCaretPosition(caretPosition + pre.length());
            });
        }

        private void insertSimpleProperty() {
            SwingUtilities.invokeLater(() -> {
                removeSelectedTextIfAny();
                final int caretPosition = txtEditor.getCaretPosition();
                txtEditor.insert(stGroupTreeNode.getModel().getDelimiter() + "" + stGroupTreeNode.getModel().getDelimiter(), caretPosition);
                txtEditor.setCaretPosition(caretPosition + 1);
            });
        }

        private void replaceAndInsertProperty() {
            final String selected = txtEditor.getSelectedText();
            if (selected == null || selected.length() < 1) return;
            final String propertyName = SwingUtil.showInputDialog("name", txtEditor);
            if (propertyName == null) return;
            final String replacement = stGroupTreeNode.getModel().getDelimiter() + propertyName + stGroupTreeNode.getModel().getDelimiter();
            txtEditor.setText(txtEditor.getText().replaceAll(selected, replacement));
            txtEditor.setCaretPosition(0);
        }

        private void format(JTextArea txtEditor) {
            final int caretPosition = txtEditor.getCaretPosition();
            final StringBuilder spaces = new StringBuilder();
            for (int i = 0; i < txtEditor.getTabSize(); i++) spaces.append(" ");

            String[] split = txtEditor.getText().split("\n");
            final StringBuilder formatted = new StringBuilder();
            for (String s : split) formatted.append(s.replace(spaces, "\t")).append("\n");
            split = formatted.toString().split("\n");

            final StringBuilder formatted2 = new StringBuilder();
            for (String s : split) {
                final char[] c = s.toCharArray();
                if (c.length == 0) formatted2.append("\n");
                for (int i = 0; i < c.length; i++) {
                    if (c[i] == '\t') {
                        formatted2.append(c[i]);
                        continue;
                    }
                    if (c[i] == ' ') continue;
                    formatted2.append(s.substring(i)).append("\n");
                    break;
                }
            }

            txtEditor.setText(formatted2.toString().trim());
            txtEditor.setCaretPosition(Math.min(formatted2.toString().trim().length(), caretPosition));
        }

        private void removeSelectedTextIfAny() {
            if (txtEditor.getSelectedText() != null) {
                final int selectionStart = txtEditor.getSelectionStart();
                txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
                txtEditor.setCaretPosition(selectionStart);
            }
        }
    }
}