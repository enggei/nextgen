package nextgen.st;

import nextgen.st.model.STValue;
import nextgen.st.model.STValueType;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static nextgen.st.STAppPresentationModel.newAction;

public class STValueGrid extends JPanel {

    private final ResultsTableModel resultsModel;

    public STValueGrid() {
        super(new BorderLayout());

        this.resultsModel = new ResultsTableModel();

        setBackground(UIManager.getColor("Panel.background"));

        final JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final JTextField txtSearch = new JTextField(30);
        final JButton btnSearch = new JButton(getSearchAction(txtSearch));
        searchPanel.setBackground(UIManager.getColor("Panel.background"));
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        txtSearch.addMouseListener(getSearchFieldMouseListener(txtSearch));

        final JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final JTextField txtReplace = new JTextField(30);
        final JButton btnReplace = new JButton(getReplaceAction(txtSearch, txtReplace));
        replacePanel.setBackground(UIManager.getColor("Panel.background"));
        replacePanel.add(new JLabel("Replace with"));
        replacePanel.add(txtReplace);
        replacePanel.add(btnReplace);
        txtReplace.addMouseListener(getSearchFieldMouseListener(txtReplace));

        final JPanel north = new JPanel(new GridLayout(2, 1));
        north.add(searchPanel);
        north.add(replacePanel);
        add(north, BorderLayout.NORTH);

        final JTable results = new JTable(resultsModel);
        results.setIntercellSpacing(new Dimension(0, 5));
        results.setShowGrid(false);
        results.setRowMargin(0);
        results.setRowHeight(150);
        results.getColumn("Result").setCellRenderer(new STValueElementRenderer());
        results.getColumn("Result").setCellEditor(new STValueElementEditor());

        final JScrollPane jScrollPane = new JScrollPane(results);
        jScrollPane.setBackground(UIManager.getColor("Panel.background"));
        jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
        add(jScrollPane, BorderLayout.CENTER);
    }

    private STAppPresentationModel appModel() {
        return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
    }
    
    private MouseListener getSearchFieldMouseListener(JTextField txtSearch) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    final JPopupMenu pop = new JPopupMenu();
                    pop.add(new AbstractAction("From clipboard") {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            txtSearch.setText(SwingUtil.fromClipboard().trim());
                        }
                    });
                    SwingUtil.showPopup(pop, txtSearch, e);
                }
            }
        };
    }

    private Action getSearchAction(JTextField txtSearch) {
        return new AbstractAction("Search") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    resultsModel.clear();
                    appModel().doInTransaction(transaction ->
                            resultsModel.setResult(appModel().findAllSTValue()
                                    .filter(stValue -> stValue.getType() != null)
                                    .filter(stValue -> stValue.getType().equals(STValueType.PRIMITIVE))
                                    .filter(STValue::hasValue)
                                    .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                                    .map(STValueElement::new)
                                    .collect(Collectors.toList())));
                });
            }
        };
    }

    private Action getReplaceAction(JTextField txtSearch, JTextField txtReplace) {
        return new AbstractAction("Replace") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> {
                    resultsModel.content.forEach(stValueElement -> {
                        final String replaceAll = stValueElement.text.replace(txtSearch.getText(), txtReplace.getText());
                        stValueElement.stValue.setValue(replaceAll);
                        stValueElement.text = appModel().render(stValueElement.stValue);
                    });
                    resultsModel.fireTableDataChanged();
                }));
            }
        };
    }

    private final class STValueElement {

        private final STValue stValue;
        private String text;

        private STValueElement(STValue stValue) {
            this.stValue = stValue;
            this.text = appModel().render(stValue);
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private class ResultsTableModel extends AbstractTableModel {

        private final List<STValueElement> content = new ArrayList<>();

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return !content.isEmpty();
        }

        @Override
        public String getColumnName(int column) {
            return "Result";
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return STValueElement.class;
        }

        @Override
        public int findColumn(String columnName) {
            return 0;
        }

        @Override
        public int getRowCount() {
            return content.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return content.get(rowIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            appModel().doInTransaction(transaction -> {
                final STValueElement stValueElement = content.get(rowIndex);
                stValueElement.text = aValue.toString().trim();
                stValueElement.stValue.setValue(stValueElement.text);
                fireTableCellUpdated(rowIndex, columnIndex);
            });
        }

        private void clear() {
            content.clear();
            fireTableDataChanged();
        }

        private void setResult(List<STValueElement> result) {
            content.addAll(result);
            fireTableDataChanged();
        }
    }

    private final class STValueElementEditor extends AbstractCellEditor implements TableCellEditor {

        private final RSyntaxTextArea component;
        private final RTextScrollPane scrollPane;
        private STValueElement element;

        STValueElementEditor() {
            this.component = SwingUtil.newRSyntaxTextArea(5, 40);
            this.component.addKeyListener(getEditorKeyListener());
            this.scrollPane = new RTextScrollPane(component);
            for (MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
                scrollPane.removeMouseWheelListener(mouseWheelListener);

            final JPopupMenu pop = component.getPopupMenu();
            pop.addSeparator();
            pop.add(newAction("Save", actionEvent -> tryToSave()));
            pop.add(newAction("Append From Clipboard", actionEvent -> {
                if (!component.isEditable()) return;
                component.append(SwingUtil.fromClipboard().trim());
                component.setCaretPosition(0);
                tryToSave();
            }));
            pop.add(newAction("Prepend From Clipboard", actionEvent -> {
                if (!component.isEditable()) return;
                component.setText(SwingUtil.fromClipboard().trim() + component.getText());
                component.setCaretPosition(0);
                tryToSave();
            }));
            pop.addSeparator();
            pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(component.getText().trim())));
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

        private void tryToSave() {
            if (element != null) {
                System.out.println("tryToSave : ");
                appModel().doInTransaction(transaction -> element.stValue.setValue(component.getText()));
            }
        }

        @Override
        public Object getCellEditorValue() {
            return component.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.element = (STValueElement) value;
            this.component.setText(element.text);
            this.component.setCaretPosition(0);
            return scrollPane;
        }
    }

    private final class STValueElementRenderer extends RSyntaxTextArea implements TableCellRenderer {

        STValueElementRenderer() {
            super(5, 40);
            SwingUtil.decorate(this);
            setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(((STValueElement) value).text);
            setCaretPosition(0);
            return this;
        }
    }
}