package com.generator.generators.templates.editor;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.templates.domain.*;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.SwingUtil;
import com.jgoodies.forms.layout.CellConstraints;
import org.neo4j.graphdb.*;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PPickPath;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.debugNode;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 12/29/16.
 */
final class TemplateDomainCanvas extends NeoEditor {

    TemplateDomainCanvas() {

        canvas.setBackground(new Color(Integer.valueOf(getColor(0)[0]), Integer.valueOf(getColor(0)[1]), Integer.valueOf(getColor(0)[2])));

        for (TemplateDomain.TemplateLabels label : TemplateDomain.TemplateLabels.values())
            nodesByLabel.put(label.name(), new LinkedHashSet<>());
    }

    @Override
    public NeoPNode newNode(Node node, String nodetype) {

        if (nodetype == null || nodesByLabel.get(nodetype) == null) return super.newNode(node, null);

        nodesByLabel.get(nodetype).add(uuidOf(node));

        final String[] colorOne = getColor(2);
        final String[] colorTwo = getColor(3);
        final String[] colorThree = getColor(4);
        final String[] colorFour = getColor(5);
        final String[] colorFive = getColor(6);
        final String[] colorSix = getColor(7);
        final String[] colorSeven = getColor(8);

        switch (TemplateDomain.TemplateLabels.valueOf(nodetype)) {

            case TemplateGroup:
                return new TemplateGroupPNode(node, colorOne, TemplateDomainCanvas.this);
            case TemplateStatement:
                return new TemplateStatementPNode(node, colorTwo, TemplateDomainCanvas.this);
            case SingleTemplateParameter:
                return new TemplateParameterPNode(node, SingleTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
            case ListTemplateParameter:
                return new TemplateParameterPNode(node, ListTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
            case KeyValueTemplateParameter:
                return new TemplateParameterPNode(node, KeyValueTemplateParameter, TemplateDomain.TemplateProperties.name.name(), colorThree, TemplateDomainCanvas.this);
            case Statement:
                return new StatementPNode(node, other(node, singleOutgoing(node, TEMPLATE_STATEMENT)), colorFive, TemplateDomainCanvas.this);
            case SingleValue:
                return new SingleValuePNode(node, colorFour, TemplateDomainCanvas.this);
            case KeyValueSet:
                return new KeyValueSetPNode(node, new CompositePText(), colorSix, TemplateDomainCanvas.this, other(node, singleOutgoing(node, TEMPLATE_PARAMETER)));
            case Project:
                return new ProjectPNode(node, colorSeven, TemplateDomainCanvas.this);
            case Directory:
                return new DirectoryPNode(node, colorSeven, TemplateDomainCanvas.this);
        }

        throw new IllegalArgumentException("unsupported nodetype: " + nodetype);
    }

    @Override
    protected void addToMenu(JPopupMenu pop, PInputEvent event) {

        final JMenu newMenu = new JMenu("New");
        newMenu.add(new NewProject(event));
        newMenu.add(new NewTestGroup(event));
        newMenu.add(new NewTemplateGroup(event));
        newMenu.add(new ParseTemplateGroup(event));
        pop.add(newMenu);

        final JMenu showMenu = new JMenu("Show");
        graph.getAllLabelsInUse().forEach(label -> showMenu.add(showAllNodesByLabel(label, event)));
        pop.add(showMenu);

        final JMenu hideMenu = new JMenu("Hide");
        for (Map.Entry<String, Set<UUID>> entry : nodesByLabel.entrySet()) {
            if (entry.getValue().isEmpty()) continue;
            hideMenu.add(new HideByLabels(TemplateDomain.TemplateLabels.valueOf(entry.getKey())));
        }
        if (hideMenu.getMenuComponentCount() > 0) pop.add(hideMenu);

        super.addToMenu(pop, event);
    }

    @Override
    public void deleteNode(Node node) throws ReferenceException {
        TemplateDomain.deleteNode(node);
    }

    private NeoPNode parseTemplateGroupFile(File file, PInputEvent event) {
        final TemplateFile templateFile = new TemplateFileParser().parse(file);

        // create new or use existing node with same name as templategroup:
        final String name = templateFile.getName().replaceAll(".stg", "");
        final Iterator<Node> iterator = getGraph().getAll(TemplateGroup.name(), TemplateDomain.TemplateProperties.name.name(), name).iterator();
        if (iterator.hasNext()) {
            final NeoPNode newTemplateGroupNode = show(uuidOf(iterator.next()), TemplateGroup.name());
            newTemplateGroupNode.setOffset(event);
            return newTemplateGroupNode;
        }

        final Node templateGroup = TemplateDomain.newTemplateGroup(graph, name, templateFile.getDelimiter() + "");

        for (TemplateImport templateImport : templateFile.getImports()) {
            final File templateFileImport = new File(file.getParentFile(), templateImport.getName() + ".stg");
            final NeoPNode imported = parseTemplateGroupFile(templateFileImport, event);
            templateGroup.createRelationshipTo(imported.node, IMPORT);
            show(uuidOf(imported.node), TemplateGroup.name());
        }

        for (com.generator.generators.templates.domain.TemplateStatement templateStatement : templateFile.getStatements())
            TemplateDomain.importTemplateStatement(templateGroup, templateStatement, this);

        final NeoPNode newTemplateGroupNode = show(uuidOf(templateGroup), TemplateGroup.name());
        newTemplateGroupNode.setOffset(event);
        return newTemplateGroupNode;
    }

    private static class CompositePText extends PText {

        @Override
        public void layoutChildren() {
            layoutHorizontal();
        }

        private void layoutHorizontal() {
            double xOffset = 0;
            final double yOffset = 0;

            final Iterator i = getChildrenIterator();
            while (i.hasNext()) {
                final PNode each = (PNode) i.next();
                each.setOffset(xOffset, yOffset);
                xOffset += each.getWidth() + 5;
            }
        }

        @Override
        public boolean fullPick(PPickPath pickPath) {
            if (super.fullPick(pickPath)) {
                PNode picked = pickPath.getPickedNode();
                // this code won't work with internal cameras, because it doesn't
                // pop the cameras view transform.
                while (picked != this) {
                    pickPath.popTransform(picked.getTransformReference(false));
                    pickPath.popNode(picked);
                    picked = pickPath.getPickedNode();
                }
                return true;
            }
            return false;
        }
    }

    private class NewProject extends TransactionAction {

        private final PInputEvent event;

        NewProject(PInputEvent event) {
            super("New Project", graph, canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", canvas);
            if (name == null) return;

            show(uuidOf(TemplateDomain.newProject(graph, name)), Project.name()).
                    setOffset(event);
        }
    }

    private class NewTestGroup extends TransactionAction {

        private final PInputEvent event;

        NewTestGroup(PInputEvent event) {
            super("New Testgroup", graph, canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Node templateGroup = TemplateDomain.newTemplateGroup(graph, "TestGroup", "~");

            // create first templateStatement
            final Node templateStatement1 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_1", "Testing single value: [~singleValue~]");
            TemplateDomain.newSingleTemplateParameter(graph, templateStatement1, "singleValue");

            // create second templatestatement
            final Node templateStatement2 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_2", "Testing list: [~elements:{it|~it~};separator=\",\"~]");
            TemplateDomain.newListTemplateParameter(graph, templateStatement2, "elements");

            // create third templatestatement
            final Node templateStatement3 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_3", "Testing keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]");
            TemplateDomain.newKeyValueListTemplateParameter(graph, templateStatement3, "keyValues", "name value".split(" "));

            final Node templateStatement4 = TemplateDomain.newTemplateStatement(graph, templateGroup, "TEMPLATE_STATEMENT_4", "keyvalues: [~keyValues:{it|~it.name~=~it.value~};separator=\",\"~]\nlist: [~elements:{it|~it~};separator=\",\"~]\nsingle: [~singleValue~]");
            TemplateDomain.newSingleTemplateParameter(graph, templateStatement4, "singleValue");
            TemplateDomain.newListTemplateParameter(graph, templateStatement4, "elements");
            TemplateDomain.newKeyValueListTemplateParameter(graph, templateStatement4, "keyValues", "name value".split(" "));

            final NeoPNode pNode = show(uuidOf(templateGroup), TemplateGroup.name());
            pNode.setOffset(event);
            pNode.expand();
        }
    }

    private class NewTemplateGroup extends TransactionAction {
        private final PInputEvent event;

        NewTemplateGroup(PInputEvent event) {
            super("New TemplateGroup", graph, canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name and delimiter", canvas);
            if (name == null) return;

            if (!name.contains(" ")) {
                SwingUtil.showMessage("Please use [name] [delimiter]\n E.g. java ~", canvas);
                return;
            }

            show(uuidOf(TemplateDomain.newTemplateGroup(graph, name.split(" ")[0], name.split(" ")[1])), TemplateGroup.name()).
                    setOffset(event);
        }
    }

    private class ParseTemplateGroup extends TransactionAction {
        private final PInputEvent event;

        ParseTemplateGroup(PInputEvent event) {
            super("Parse TemplateGroup", graph, canvas);
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File file = SwingUtil.showOpenFile(canvas, "/media/storage/nextgen/src/test/java/com/generator/generators/templates");
            if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

            parseTemplateGroupFile(file, event).expand();
        }
    }

    private class HideByLabels extends TransactionAction {
        private final org.neo4j.graphdb.Label label;

        HideByLabels(org.neo4j.graphdb.Label label) {
            super("Hide " + label, graph, canvas);
            this.label = label;
        }

        @Override
        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Set<UUID> hide = new LinkedHashSet<>();
            layerNodes.values().forEach(pNode -> {
                if (pNode.node.hasLabel(label)) hide.add(pNode.uuid);
            });
            hide.forEach(TemplateDomainCanvas.this::removeNodeFromCanvas);
        }
    }

    static class TemplateEditor extends SwingUtil.FormPanel {

        final JTextField txtStatementName = new JTextField();
        final JTextArea txtEditor = new JTextArea();
        final Border defaultBorder = txtEditor.getBorder();
        final JTable tblParameters = new JTable();
        final JButton btnSetStatementLabel = new JButton();
        final java.util.List<TemplateParameter> parameters = new ArrayList<>();

        private String statementLabel;

        TemplateEditor(String delimiter, String name, String text, String initLabel) {
            super("50dlu, 4dlu, 350dlu:grow", "pref, 4dlu, 225dlu:grow, 4dlu, 66dlu, 4dlu, pref");

            int row = 1;
            addLabel("Name", 1, row);
            add(txtStatementName, 3, row);

            row += 2;
            addLabel("Text", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
            addScrollPane(txtEditor, 3, row, 1, 1);

            row += 2;
            addLabel("Parameters", 1, row, CellConstraints.LEFT, CellConstraints.TOP);
            addScrollPane(tblParameters, 3, row, 1, 1);

            row += 2;
            addLabel("Label", 1, row).setToolTipText("Which Parameter-value to use as label for statements based on this template");
            add(btnSetStatementLabel, 3, row);

            txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
            txtEditor.setTabSize(3);
            txtStatementName.setText(name);
            txtEditor.setText(text);
            txtEditor.setCaretPosition(0);

            this.statementLabel = initLabel;
            btnSetStatementLabel.setText(this.statementLabel == null ? "NOT SET" : this.statementLabel);
            btnSetStatementLabel.setToolTipText("Select Parameter to use as label for statement based on this template");

            final DefaultHighlighter.DefaultHighlightPainter paramsHighlighter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 127, 0));

            txtEditor.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {

                    if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        try {
                            parseAndValidate(delimiter);
                        } catch (Exception e) {
                            SwingUtil.showException(txtEditor, e);
                        }

                    } else if (ke.getKeyCode() == KeyEvent.VK_L && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        insertListProperty();

                    } else if (ke.getKeyCode() == KeyEvent.VK_I && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        insertIf();

                    } else if (ke.getKeyCode() == KeyEvent.VK_SPACE && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        insertSimpleProperty();

                    } else if (ke.getKeyCode() == KeyEvent.VK_R && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        replaceAndInsertProperty();

                    } else if (ke.getKeyCode() == KeyEvent.VK_M && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                        makeMethod();

                    } else if (ke.getKeyCode() == KeyEvent.VK_DELETE && ke.getModifiers() == KeyEvent.SHIFT_MASK) {
                        deleteCurrentLine();
                    }
                }

                private void makeMethod() {
                    final String selected = txtEditor.getSelectedText();
                    if (selected == null || selected.length() < 1) return;
                    System.out.println(selected);
                }

                private void replaceAndInsertProperty() {
                    final String selected = txtEditor.getSelectedText();
                    if (selected == null || selected.length() < 1) return;

                    final String propertyName = SwingUtil.showInputDialog("propertyName", txtEditor);
                    if (propertyName == null) return;

                    final String replacement = delimiter + propertyName + delimiter;
                    txtEditor.setText(txtEditor.getText().replaceAll(selected, (delimiter.equals("$") ? replacement.replaceAll("\\$", "\\\\\\$") : replacement)));
                    SwingUtil.tryToHighlight(txtEditor, Collections.singletonList(replacement), paramsHighlighter);
                }

                private void insertSimpleProperty() {
                    SwingUtilities.invokeLater(() -> {

                        removeSelectedTextIfAny();

                        final int caretPosition = txtEditor.getCaretPosition();
                        txtEditor.insert(delimiter + "" + delimiter, caretPosition);
                        txtEditor.setCaretPosition(caretPosition + 1);
                    });
                }

                private void insertListProperty() {

                    final String input = SwingUtil.showInputDialog(TemplateDomain.TemplateProperties.name.name(), txtEditor);
                    if (input == null) return;

                    final String name = input.contains(" ") ? input.split(" ")[0] : input.trim();
                    final String separator = input.contains(" ") ? input.split(" ")[1] : null;

                    SwingUtilities.invokeLater(() -> {

                        removeSelectedTextIfAny();

                        final int caretPosition = txtEditor.getCaretPosition();
                        final String pre = delimiter + name + ":{it|";
                        final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
                        final String list = pre + "}" + sep + delimiter;
                        txtEditor.insert(list, caretPosition);
                        txtEditor.setCaretPosition(caretPosition + pre.length());
                    });
                }

                private void removeSelectedTextIfAny() {
                    if (txtEditor.getSelectedText() != null) {
                        final int selectionStart = txtEditor.getSelectionStart();
                        txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
                        txtEditor.setCaretPosition(selectionStart);
                    }
                }

                private void insertIf() {

                    final String input = SwingUtil.showInputDialog("condition", txtEditor);
                    if (input == null) return;

                    final String name = input.trim();

                    SwingUtilities.invokeLater(() -> {

                        removeSelectedTextIfAny();

                        final int caretPosition = txtEditor.getCaretPosition();
                        final String pre = delimiter + "if(" + name + ")" + delimiter;
                        final String list = pre + delimiter + "endif" + delimiter;
                        txtEditor.insert(list, caretPosition);
                        txtEditor.setCaretPosition(caretPosition + pre.length());
                    });
                }

                private void deleteCurrentLine() {
                    final String txt = txtEditor.getText();
                    int startOfLine = txtEditor.getCaretPosition();
                    while (startOfLine > 0) {

                        startOfLine--;

                        if (startOfLine < 0) {
                            startOfLine++;
                            break;
                        }

                        if (txt.charAt(startOfLine) == '\n') {
                            startOfLine++;
                            break;
                        }
                    }

                    int endOfLine = startOfLine;
                    while (endOfLine < txt.length()) {

                        if (endOfLine >= txt.length()) {
                            endOfLine = txt.length() - 1;
                            break;
                        }

                        if (txt.charAt(endOfLine) == '\n') {
                            break;
                        }

                        endOfLine++;
                    }

                    if (endOfLine == startOfLine) {
                        endOfLine++;
                        if (endOfLine >= txt.length())
                            endOfLine = txt.length() - 1;
                    }

                    if (endOfLine <= startOfLine) return;

                    txtEditor.replaceRange("", startOfLine, endOfLine);
                }
            });

            tblParameters.setModel(new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    return parameters.size();
                }

                @Override
                public int getColumnCount() {
                    return 2;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    final TemplateParameter templateParameter = parameters.get(rowIndex);
                    switch (columnIndex) {
                        case 0:
                            return parameters.get(rowIndex).getPropertyName();
                        case 1:
                            return parameters.get(rowIndex).getDomainEntityType();
                    }

                    return templateParameter;
                }

                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "Name";
                        case 1:
                            return "Type";
                    }
                    throw new IllegalArgumentException("Illegal column " + column);
                }
            });

            tblParameters.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    final int selectedRow = tblParameters.getSelectedRow();
                    if (selectedRow == -1) return;

                    final TemplateParameter templateParameter = parameters.get(selectedRow);

                    final String name = templateParameter.getPropertyName();
                    final String simple = delimiter + name + delimiter;
                    final String formatted = delimiter + name + ";";
                    final String list = delimiter + name + ":";
                    final String methodCall = delimiter + name + "(";
                    final String methodParam = "=" + name;
                    final String ifName = delimiter + "if(" + name + ")" + delimiter;
                    SwingUtil.tryToHighlight(txtEditor, Arrays.asList(simple, formatted, list, methodCall, methodParam, ifName), paramsHighlighter);
                }
            });

            btnSetStatementLabel.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                final Set<String> legalParameters = parameters.stream().filter(parameter -> TemplateEntities.STRINGPROPERTY.equals(parameter.getDomainEntityType())).map(TemplateParameter::getPropertyName).collect(Collectors.toCollection(TreeSet::new));
                final String s = SwingUtil.showSelectDialog(txtEditor, "Select parameter to use as label:", "Parameter label", legalParameters);
                if (s == null) return;
                statementLabel = s;
                btnSetStatementLabel.setText(statementLabel = s);
            }));

            // try to parse if default text:
            if (text.length() > 0) {
                try {
                    parseAndValidate(delimiter);
                } catch (Exception e) {
                    txtEditor.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        }

        String getStatementLabel() {
            return statementLabel;
        }

        TemplateStatement parseAndValidate(String delimiter) throws Exception {

            final int oldCaret = txtEditor.getCaretPosition();
            txtEditor.setBorder(defaultBorder);

            final String text = txtEditor.getText();

            System.out.println("todo ST-bugfixes here (escape } inside anonymous key-value templates, and >> inside statement");
            // 2 bugfixes: } inside anonymous key-value list
            // and >> inside statement

            final TemplateStatement parsed = new TemplateFileParser().parse(delimiter, txtStatementName.getText().trim(), text);
            if (parsed == null)
                throw new Exception("Unparseable template. Check properties and try again.");

            SwingUtilities.invokeLater(() -> {

                parameters.clear();
                parameters.addAll(parsed.getParameters().stream().collect(Collectors.toList()));

                ((AbstractTableModel) tblParameters.getModel()).fireTableDataChanged();

                txtEditor.setText(parsed.getText().trim());
                txtEditor.setCaretPosition(Math.min(text.length(), Math.max(0, oldCaret)));
            });

            return parsed;
        }
    }

    private static String[] getColor(int index) {
        return new String[][]{
                "247, 247, 247".split(", "),
                "64, 64, 64".split(", "),
                "64, 64, 64".split(", "),
                "64, 64, 64".split(", "),
                "64, 64, 64".split(", "),
                "0, 109, 44".split(", "),
                "5, 112, 176".split(", "),
                "0, 68, 27".split(", "),
                "153, 52, 4".split(", ")
        }[index];
    }

    public static void main(String[] args) {

        SwingUtil.setLookAndFeel_Nimbus();

        final JFrame frame = new JFrame();
        final TemplateDomainCanvas contentPanel = new TemplateDomainCanvas();
        final RenderPanel renderPanel = new RenderPanel(contentPanel);
        contentPanel.addPropertyChangeListener(renderPanel);

        frame.getContentPane().add(contentPanel.getCanvas(), BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(renderPanel), BorderLayout.EAST);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                contentPanel.getCanvas().requestFocusInWindow();
            }
        });

        SwingUtil.show(frame);
    }
}