package nextgen.st;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STGError;
import nextgen.st.domain.STGParseResult;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class STEditor extends JPanel {

    private final RSyntaxTextArea txtEditor = new RSyntaxTextArea(20, 60);
    private final STEditorCommandPanel commandPanel = new STEditorCommandPanel();
    private final STEditorInfoPanel infoPanel = new STEditorInfoPanel();

    private final Color uneditedColor = txtEditor.getBackground();
    private final Color editedColor = Color.decode("#f0f0f0");
    private final Color errorColor = Color.decode("#fbb4ae");
    private final Border defaultBorder = txtEditor.getBorder();

    private final STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode;

    private String startText;
    private STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode.STTemplateTreeNode stTemplateTreeNode;

    public STEditor(STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode stGroupTreeNode) {
        super(new BorderLayout());

        this.stGroupTreeNode = stGroupTreeNode;

        final JPopupMenu pop = this.txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Insert Single", actionEvent -> insertSingle()));
        pop.add(newAction("Insert Single Capitalized", actionEvent -> insertCapitalized()));
        pop.add(newAction("Insert List", actionEvent -> insertList()));
        pop.add(newAction("Insert If", actionEvent -> insertIf()));
        pop.add(newAction("Replace text and insert Single", actionEvent -> replaceAndInsertSingle()));
        pop.add(newAction("Save", actionEvent -> commit()));
        pop.add(newAction("Debug Template", actionEvent -> debug()));
        pop.addSeparator();
        pop.add(newAction("Add Java method", actionEvent -> addJavaMethod()));

        this.txtEditor.setFont(getPreferredFont());
        this.txtEditor.setTabSize(3);
        this.txtEditor.setCodeFoldingEnabled(true);
        this.txtEditor.addKeyListener(new STTemplateEditorKeyListener());

        this.startText = STGenerator.toStg(stGroupTreeNode.getModel()).trim();
        this.txtEditor.setText(startText);
        this.txtEditor.setEditable(false);
        this.commandPanel.setEditable(false);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.discardAllEdits();

        add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(commandPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(800, 600));
    }

    public STNavigator.RootNode.STGDirectoryTreeNode.STGroupTreeNode getStGroupTreeNode() {
        return stGroupTreeNode;
    }

    public void setSTEnum(String text) {

        this.stTemplateTreeNode = null;

        this.startText = text;

        this.txtEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        this.txtEditor.setText(startText);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.setEditable(false);
        this.commandPanel.setEditable(false);

        this.txtEditor.discardAllEdits();
        this.txtEditor.setBackground(uneditedColor);
        this.infoPanel.clear();
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
        this.txtEditor.discardAllEdits();
        this.txtEditor.setBackground(uneditedColor);

        this.commandPanel.setEditable(stTemplateTreeNode != null);
        this.infoPanel.clear();

        this.txtEditor.requestFocusInWindow();
    }

    private Font getPreferredFont() {
        final Set<String> fonts = new HashSet<>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
        return Stream
                .of("Hack", "Fira Code", "Source Code Pro", "Monospaced")
                .filter(fonts::contains)
                .findFirst().map(s -> new Font(s, Font.PLAIN, 12))
                .orElse(null);
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
                insertList();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_I) {
                insertIf();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_1) {
                insertCapitalized();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_P) {
                insertSingle();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_R) {
                replaceAndInsertSingle();
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

    private void commit() {
        SwingUtilities.invokeLater(() -> {

            txtEditor.setBorder(defaultBorder);

            final String text = txtEditor.getText().trim();

            final STGParseResult parseResult = STParser.parseTemplate(text);

            if (parseResult.getErrors().count() == 0) {
                parseResult.getParsed().getTemplates().findFirst().ifPresent(stTemplate -> {
                    stTemplateTreeNode.getModel().setText(stTemplate.getText());

                    // add existing argument-types to parameter, if applicable:
                    stTemplate.getParameters().forEach(newParameter -> stTemplateTreeNode.getModel().getParameters()
                            .filter(oldParameter -> oldParameter.getName().equals(newParameter.getName()))
                            .findFirst()
                            .ifPresent(oldParameter -> {

                                if (oldParameter.getType().equals(newParameter.getType())) {

                                    switch (newParameter.getType()) {

                                        case SINGLE:
                                        case LIST:
                                            newParameter.setArgumentType(getArgumentType(oldParameter.getArgumentType()));
                                            break;
                                        case KVLIST:
                                            newParameter.getKeys().forEach(newKey -> {
                                                oldParameter.getKeys()
                                                        .filter(oldKey -> oldKey.getName().equals(newKey.getName()))
                                                        .findFirst()
                                                        .ifPresent(oldKey -> newKey.setArgumentType(getArgumentType(oldKey.getArgumentType())));
                                            });
                                            break;
                                    }
                                }
                            }));
                    stTemplateTreeNode.getModel().clearParameters();
                    stTemplate.getParameters().forEach(stTemplateTreeNode.getModel()::addParameters);
                });

                startText = text.trim();
                stGroupTreeNode.save();

                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
                infoPanel.clear();

            } else {

                txtEditor.setBorder(BorderFactory.createLineBorder(errorColor));
                infoPanel.showParseErrors(parseResult.getErrors());
            }
        });
    }

    private String getArgumentType(Object argumentType) {
        return argumentType == null || argumentType.toString().trim().length() == 0 ? "Object" : argumentType.toString().trim();
    }

    private void debug() {
        SwingUtilities.invokeLater(() -> {
            STParser.asST(txtEditor.getText().trim()).inspect();
        });
    }

    private void insertCapitalized() {
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            txtEditor.insert(stGroupTreeNode.getModel().getDelimiter() + ";format=\"capitalize\"" + stGroupTreeNode.getModel().getDelimiter(), caretPosition);
            txtEditor.setCaretPosition(caretPosition + 1);
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }

    private void insertList() {
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

    private void insertSingle() {
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            txtEditor.insert(stGroupTreeNode.getModel().getDelimiter() + "" + stGroupTreeNode.getModel().getDelimiter(), caretPosition);
            txtEditor.setCaretPosition(caretPosition + 1);
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }

    private void replaceAndInsertSingle() {
        final String selected = txtEditor.getSelectedText();
        if (selected == null || selected.length() < 1) return;
        final String propertyName = SwingUtil.showInputDialog("name", txtEditor);
        if (propertyName == null || propertyName.trim().length() == 0) return;

        SwingUtilities.invokeLater(() -> {
            final String replacement = stGroupTreeNode.getModel().getDelimiter() + propertyName + stGroupTreeNode.getModel().getDelimiter();
            final SearchContext context = new SearchContext();
            context.setSearchFor(selected);
            context.setReplaceWith(replacement);
            context.setMatchCase(true);
            context.setSearchForward(true);
            context.setWholeWord(false);
            SearchEngine.replaceAll(txtEditor, context);
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
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

    private class STEditorCommandPanel extends JPanel {

        public STEditorCommandPanel() {
            super(new FlowLayout(FlowLayout.LEFT));

            add(new JButton(newAction("Insert Single", actionEvent -> {
                insertSingle();
                txtEditor.requestFocusInWindow();
            })));

            add(new JButton(newAction("Insert Single Capitalized", actionEvent -> {
                insertCapitalized();
                txtEditor.requestFocusInWindow();
            })));
            add(new JButton(newAction("Insert List", actionEvent -> {
                insertList();
                txtEditor.requestFocusInWindow();
            })));
            add(new JButton(newAction("Insert If", actionEvent -> {
                insertIf();
                txtEditor.requestFocusInWindow();
            })));
            add(new JButton(newAction("Replace text and insert Single", actionEvent -> {
                replaceAndInsertSingle();
                txtEditor.requestFocusInWindow();
            })));
            add(new JButton(newAction("Save", actionEvent -> {
                commit();
                txtEditor.requestFocusInWindow();
            })));
        }

        void setEditable(boolean editabe) {
            for (Component component : getComponents()) {
                if (component instanceof JButton) {
                    component.setEnabled(editabe);
                }
            }
        }
    }

    private class STEditorInfoPanel extends JPanel {

        private final JTextArea textArea = new JTextArea();

        public STEditorInfoPanel() {
            super(new BorderLayout());

            this.textArea.setFont(getPreferredFont());
            this.textArea.setTabSize(3);
            this.textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            add(new JScrollPane(textArea), BorderLayout.CENTER);
            setPreferredSize(new Dimension(800, 200));
        }

        public void clear() {
            SwingUtilities.invokeLater(() -> {
                textArea.setText("");
                textArea.setBackground(uneditedColor);
                textArea.setToolTipText("");
            });
        }

        public void showParseErrors(Stream<STGError> errors) {

            final StringBuilder info = new StringBuilder("Parsing errors:");

            errors.forEach(stgError -> {

                info.append("\n").append(stgError.getType());

                switch (stgError.getType()) {
                    case COMPILE: {
                        info.append("\n\tline               ").append(stgError.getLine());
                        info.append("\n\tpos                ").append(stgError.getCharPosition());
                        info.append("\n\tmessage            ").append(stgError.getMessage());

                        if (stgError.getMessage().contains("expecting RDELIM")) {
                            info.append("\n\tpossible cause     ").append("This is probably a '}' being interpreted as end-of a kv-iteration.");
                            info.append("\n\tpossible solution  ").append("Try escaping the previous '}' (i.e from '}' to '\\}')");
                        } else if (stgError.getMessage().contains("invalid character '>'")) {
                            info.append("\n\tpossible cause     ").append("This is probably a '>' being interpreted as end-of template.");
                            info.append("\n\tpossible solution  ").append("Try changing the last '>' to '" + STGenerator.DELIMITERCHAR + "gt()" + STGenerator.DELIMITERCHAR + "'");
                        }
                        break;
                    }

                    case RUNTIME:
                        break;

                    case IO:
                        break;

                    case INTERNAL:
                        break;
                }
            });

            textArea.setBackground(errorColor);
            textArea.setText(info.toString().trim());
            textArea.setCaretPosition(0);
        }
    }


}