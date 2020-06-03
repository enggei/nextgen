package nextgen.st;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STGParseResult;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.stringtemplate.v4.misc.STMessage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.st.domain.STJsonFactory.newSTGroupModel;
import static nextgen.st.domain.STJsonFactory.newSTTemplate;

public class STEditor extends JPanel {

    private final RSyntaxTextArea txtEditor = new RSyntaxTextArea(20, 60);
    private final Color uneditedColor = txtEditor.getBackground();
    private final Color editedColor = Color.decode("#fee8c8");
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

        this.startText = STGenerator.toStg(stGroupTreeNode.getModel()).trim();
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
                this.startText = STGenerator.toStg(stGroupTreeNode.getModel()).trim() :
                stTemplateTreeNode.getModel().getText().trim();

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

        if (parseResult.getErrors().count() == 0) {

            originalTemplate.setText(text);
            originalTemplate.clearParameters();
            parseResult.getParsed().getTemplates().findFirst().ifPresent(stTemplate -> stTemplate.getParameters().forEach(originalTemplate::addParameters));

            startText = text.trim();
            stGroupTreeNode.save();

            SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));

        } else {

            this.txtEditor.setBorder(BorderFactory.createLineBorder(errorColor));

            parseResult.getErrors().forEach(stgError -> {

                System.out.println(stgError.getType());
                final STMessage message = stgError.getMessage();

                switch (stgError.getType()) {

                    case COMPILE:

                        break;
                    case RUNTIME:
                        break;
                    case IO:
                        break;
                    case INTERNAL:
                        break;
                }

            });
        }
    }

    private class STTemplateEditorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if (stTemplateTreeNode == null) return;

            SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));

            if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_L) {
                insertListProperty();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_I) {
                insertIf();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_1) {
                capitalize();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                insertSimpleProperty();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_R) {
                replaceAndInsertProperty();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_F) {
                format(txtEditor);
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && (keyEvent.getKeyCode() == KeyEvent.VK_ENTER || keyEvent.getKeyCode() == KeyEvent.VK_S)) {
                commit();
            }
        }

        private void capitalize() {
            SwingUtilities.invokeLater(() -> {
                removeSelectedTextIfAny();
                final int caretPosition = txtEditor.getCaretPosition();
                txtEditor.insert(stGroupTreeNode.getModel().getDelimiter() + ";format=\"capitalize\"" + stGroupTreeNode.getModel().getDelimiter(), caretPosition);
                txtEditor.setCaretPosition(caretPosition + 1);
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
            });
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
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
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
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
            });
        }

        private void insertSimpleProperty() {
            SwingUtilities.invokeLater(() -> {
                removeSelectedTextIfAny();
                final int caretPosition = txtEditor.getCaretPosition();
                txtEditor.insert(stGroupTreeNode.getModel().getDelimiter() + "" + stGroupTreeNode.getModel().getDelimiter(), caretPosition);
                txtEditor.setCaretPosition(caretPosition + 1);
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
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
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
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
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        }

        private void removeSelectedTextIfAny() {
            if (txtEditor.getSelectedText() != null) {
                final int selectionStart = txtEditor.getSelectionStart();
                txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
                txtEditor.setCaretPosition(selectionStart);
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
            }
        }
    }
}