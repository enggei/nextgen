package nextgen.st;

import com.generator.util.SwingUtil;
import nextgen.st.domain.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.stringtemplate.v4.misc.STMessage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.st.domain.STJsonFactory.newSTGroupModel;
import static nextgen.st.domain.STJsonFactory.newSTTemplate;

public class STEditor extends JPanel {

    private final RSyntaxTextArea txtEditor = new RSyntaxTextArea(20, 60);
    private final Color uneditedColor = txtEditor.getBackground();
    private final Color editedColor = Color.decode("#fee8c8");
    private final Color errorColor = Color.RED;
    private final Border defaultBorder = txtEditor.getBorder();

    private final STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode;

    private String startText;
    private STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode;

    public STEditor(STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {
        super(new BorderLayout());

        this.stGroupTreeNode = stGroupTreeNode;

        final JPopupMenu pop = this.txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Insert Single", actionEvent -> insertSimpleProperty()));
        pop.add(newAction("Insert Single Capitalized", actionEvent -> capitalize()));
        pop.add(newAction("Insert List", actionEvent -> insertListProperty()));
        pop.add(newAction("Insert If", actionEvent -> insertIf()));
        pop.add(newAction("Replace text and insert Single", actionEvent -> replaceAndInsertProperty()));
        pop.add(newAction("Save", actionEvent -> commit()));
        pop.addSeparator();
        pop.add(newAction("Add Java method", actionEvent -> addJavaMethod()));

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

    public STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode getStGroupTreeNode() {
        return stGroupTreeNode;
    }

    public void setSTTemplate(STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode) {

        this.stTemplateTreeNode = stTemplateTreeNode;

        this.startText = stTemplateTreeNode == null ?
                this.startText = STGenerator.toStg(stGroupTreeNode.getModel()).trim() :
                stTemplateTreeNode.getModel().getText().trim();

        this.txtEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        this.txtEditor.setText(startText);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.setEditable(stTemplateTreeNode != null);
        txtEditor.setBackground(uneditedColor);
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
            parseResult.getParsed().getTemplates().findFirst().ifPresent(stTemplate -> {
                originalTemplate.setText(stTemplate.getText());

                // add existing argument-types to parameter, if applicable:
                stTemplate.getParameters().forEach(newParameter -> {
                    originalTemplate.getParameters()
                            .filter(oldParameter -> oldParameter.getName().equals(newParameter.getName()))
                            .findFirst()
                            .ifPresent(oldParameter -> {

                                if (oldParameter.getType().equals(newParameter.getType())) {

                                    switch (newParameter.getType()) {

                                        case SINGLE:
                                        case LIST:
                                            newParameter.setArgumentType(oldParameter.getArgumentType());
                                            break;
                                        case KVLIST:
                                            newParameter.getKeys().forEach(newKey -> {
                                                oldParameter.getKeys()
                                                        .filter(oldKey -> oldKey.getName().equals(newKey.getName()))
                                                        .findFirst()
                                                        .ifPresent(oldKey -> newKey.setArgumentType(oldKey.getArgumentType()));
                                            });
                                            break;
                                    }
                                }
                            });
                });
                originalTemplate.clearParameters();
                stTemplate.getParameters().forEach(originalTemplate::addParameters);
            });

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

    private void generate() {
        commit();
        stGroupTreeNode.generate();
    }

    private Action newAction(String name, Consumer<ActionEvent> consumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                consumer.accept(e);
            }
        };
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
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_P) {
                insertSimpleProperty();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_R) {
                replaceAndInsertProperty();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_F) {
                format(txtEditor);
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {
                commit();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_G) {
                generate();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                showPopup();
            }
        }
    }

    private void showPopup() {
        SwingUtilities.invokeLater(() -> {
            try {
                final Rectangle rectangle = txtEditor.modelToView(txtEditor.getCaretPosition());
                Point p = rectangle.getLocation();
                p.y += rectangle.height;
                final JPopupMenu popupMenu = txtEditor.getPopupMenu();
                popupMenu.show(txtEditor, p.x, p.y);
            } catch (BadLocationException ignore) {

            }
        });
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

    private void addJavaMethod() {
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            final String str = "\tpublic void " + stGroupTreeNode.getModel().getDelimiter() + "name;format=\"capitalize\"" + stGroupTreeNode.getModel().getDelimiter() + "() {\n\t}";
            txtEditor.insert(str, caretPosition);
            txtEditor.setCaretPosition(caretPosition + str.length() - 1);
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }
}