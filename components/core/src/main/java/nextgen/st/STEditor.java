package nextgen.st;

import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Optional;
import java.util.function.Consumer;

import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STEditor extends JPanel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEditor.class);

    private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 60);
    private final STEditorCommandPanel commandPanel = new STEditorCommandPanel();
    private final STEditorInfoPanel infoPanel;

    private final Color uneditedColor = UIManager.getColor("Panel.background");
    private final Color editedColor = UIManager.getColor("Panel.background").brighter();
    private final Color errorColor = Color.decode("#e66101");
    private final Border defaultBorder = txtEditor.getBorder();

    nextgen.st.model.STGroupModel stGroupModel;
    private nextgen.st.model.STTemplate stTemplate;

    private String startText;

    public STEditor(nextgen.st.model.STGroupModel stGroupModel) {
        super(new BorderLayout());

        this.stGroupModel = stGroupModel;
        this.infoPanel = new STEditorInfoPanel();
        final JPopupMenu pop = this.txtEditor.getPopupMenu();
        pop.addSeparator();
        pop.add(newAction("Insert Single", actionEvent -> insertSingle()));
        pop.add(newAction("Insert Single Capitalized", actionEvent -> insertCapitalized()));
        pop.add(newAction("Insert List", actionEvent -> insertList()));
        pop.add(newAction("Insert If", actionEvent -> insertIf()));
        pop.add(newAction("Insert If-else", actionEvent -> insertIfElse()));
        pop.add(newAction("Replace text and insert Single", actionEvent -> replaceAndInsertSingle()));
        pop.add(newAction("Replace text", actionEvent -> replace()));
        pop.add(newAction("Save", actionEvent -> commit()));
        pop.add(newAction("Generate", actionEvent -> generate()));
        pop.add(newAction("Debug Template", actionEvent -> debug()));
        pop.addSeparator();
        pop.add(newAction("Add Java method", actionEvent -> addJavaMethod()));

        this.txtEditor.setTabSize(3);
        this.txtEditor.setCodeFoldingEnabled(true);
        this.txtEditor.addKeyListener(new STTemplateEditorKeyListener());

        this.startText = STGenerator.toStg(stGroupModel).trim();

        this.txtEditor.setText(startText);
        this.txtEditor.setEditable(false);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.discardAllEdits();

        this.commandPanel.setEditable(false);

        add(SwingUtil.newRTextScrollPane(txtEditor), BorderLayout.CENTER);
        add(commandPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(800, 600));
    }

    private STAppPresentationModel appModel() {
        return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
    }

    public nextgen.st.model.STGroupModel getModel() {
        return stGroupModel;
    }

    public void clear() {
        stTemplate = null;
        reset(STGenerator.toStg(stGroupModel).trim());
    }

    public void setSTEnum(nextgen.st.model.STEnum stEnum) {
        stTemplate = null;
        final StringBuilder text = new StringBuilder();
        text.append(stEnum.getName());
        stEnum.getValues().forEach(stEnumValue -> text.append("\n\t").append(stEnumValue.getName()).append(stEnumValue.getLexical() == null ? "" : (" -> \"" + stEnumValue.getLexical() + "\"")));
        reset(text.toString());
    }

    public void setSTInterface(nextgen.st.model.STInterface stInterface) {
        stTemplate = null;
        reset(stInterface.getName());
    }

    public void setSTTemplate(nextgen.st.model.STTemplate stTemplate) {
        this.stTemplate = stTemplate;
        this.startText = stTemplate == null ?
                this.startText = STGenerator.toStg(stGroupModel).trim() :
                stTemplate.getText().trim();

        reset(startText);
        this.txtEditor.requestFocusInWindow();
    }

    public void reset(String string) {

        this.startText = string.trim();

        this.txtEditor.setText(startText);
        this.txtEditor.setCaretPosition(0);
        this.txtEditor.setEditable(stTemplate != null);
        this.commandPanel.setEditable(stTemplate != null);

        this.txtEditor.discardAllEdits();
        this.txtEditor.setBackground(uneditedColor);
        this.infoPanel.clear();
    }

    private void generate() {
        commit();
        appModel().generateSTGroup(stGroupModel,false);
    }

    private Action newAction(String name, Consumer<ActionEvent> consumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                consumer.accept(e);
            }
        };
    }

    public Optional<nextgen.st.model.STTemplate> getSTTemplate() {
        return Optional.ofNullable(stTemplate);
    }

    private class STTemplateEditorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if (stTemplate == null) return;

            SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));

            if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_L) {
                insertList();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_I) {
                insertIf();
            } else if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_E) {
                insertIfElse();
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

        if (stTemplate == null) {
            log.warn("issue: stTemplate is null");
            return;
        }

        appModel().doLaterInTransaction(transaction -> {
            txtEditor.setBorder(defaultBorder);

            final String text = txtEditor.getText().trim();

            final nextgen.st.parser.ParseResult parseResult = STParser.parseTemplate(text);

            if (parseResult.getErrors().isEmpty()) {
                STParser.mergeTemplate(parseResult.getParsed().getTemplates().stream().findFirst().get(), stTemplate);
                startText = text.trim();
                appModel().save(stGroupModel);
                txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
                infoPanel.clear();

            } else {

                txtEditor.setBorder(BorderFactory.createLineBorder(errorColor));
                infoPanel.showParseErrors(parseResult.getErrors());
            }
        });
    }

    private void debug() {
        SwingUtilities.invokeLater(() -> STParser.asST(txtEditor.getText().trim()).inspect());
    }

    private void insertCapitalized() {
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            txtEditor.insert(delim(";format=\"capitalize\""), caretPosition);
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
            final String pre = name + ":{it|";
            final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
            final String list = pre + "}" + sep;
            txtEditor.insert(delim(list), caretPosition);
            txtEditor.setCaretPosition(caretPosition + pre.length() + 1);
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
            final String pre = delim("if(" + name + ")");
            final String list = pre + delim("endif");
            txtEditor.insert(list, caretPosition);
            txtEditor.setCaretPosition(caretPosition + pre.length());
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }

    private void insertIfElse() {
        final String input = SwingUtil.showInputDialog("condition", txtEditor);
        if (input == null) return;
        final String name = input.trim();
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            final String pre = delim("if(" + name + ")");
            final String list = pre + delim("else") + delim("endif");
            txtEditor.insert(list, caretPosition);
            txtEditor.setCaretPosition(caretPosition + pre.length());
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }

    private void insertSingle() {
        SwingUtilities.invokeLater(() -> {
            removeSelectedTextIfAny();
            final int caretPosition = txtEditor.getCaretPosition();
            txtEditor.insert(delim(""), caretPosition);
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
            final String replacement = delim(propertyName);
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

    private void replace() {
        final String selected = txtEditor.getSelectedText();
        if (selected == null || selected.length() < 1) return;
        final String replaceWith = SwingUtil.showInputDialog("value", txtEditor);
        if (replaceWith == null || replaceWith.trim().length() == 0) return;

        SwingUtilities.invokeLater(() -> {
            final SearchContext context = new SearchContext();
            context.setSearchFor(selected);
            context.setReplaceWith(replaceWith);
            context.setMatchCase(true);
            context.setSearchForward(true);
            context.setWholeWord(true);
            SearchEngine.replaceAll(txtEditor, context);
            txtEditor.setBackground(startText.trim().equals(txtEditor.getText().trim()) ? uneditedColor : editedColor);
        });
    }

    private void format(JTextArea txtEditor) {
        SwingUtil.format(txtEditor);
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
            final String str = "\tpublic void " + stGroupModel.getDelimiter() + "name;format=\"capitalize\"" + stGroupModel.getDelimiter() + "() {\n\t}";
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
            add(new JButton(newAction("Insert If-else", actionEvent -> {
                insertIfElse();
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

            add(new JButton(newAction("Generate", actionEvent -> {
                generate();
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

            this.textArea.setTabSize(3);
            this.textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            add(new JScrollPane(textArea), BorderLayout.CENTER);
            setPreferredSize(new Dimension(800, 200));
        }

        public void clear() {
            SwingUtilities.invokeLater(() -> {
                textArea.setText("");
                textArea.setToolTipText("");
            });
        }

        public void showParseErrors(java.util.List<nextgen.st.parser.ParserError> errors) {

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

            textArea.setText(info.toString().trim());
            textArea.setCaretPosition(0);
        }
    }

    private String delim(String expression) {
        return stGroupModel.getDelimiter() + expression + stGroupModel.getDelimiter();
    }
}