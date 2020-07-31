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
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class STValueGrid extends JPanel {

    private final STAppPresentationModel presentationModel;
    private final ResultsTableModel resultsModel;

    public STValueGrid(STAppPresentationModel presentationModel) {
        super(new BorderLayout());
        this.presentationModel = presentationModel;
        setBackground(Color.WHITE);

        final JPanel north = new JPanel(new GridLayout(2, 1));

        final JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.add(new JLabel("Search"));
        final JTextField txtSearch = new JTextField(30);
        txtSearch.setText("com.generator.util.SwingUtil");
        searchPanel.add(txtSearch);
        final JButton btnSearch = new JButton(getSearchAction(txtSearch));
        searchPanel.add(btnSearch);
        north.add(searchPanel);

        final JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        replacePanel.setBackground(Color.WHITE);
        replacePanel.add(new JLabel("Replace with"));
        final JTextField txtReplace = new JTextField(30);
        replacePanel.add(txtReplace);
        final JButton btnReplace = new JButton(getReplaceAction(txtSearch, txtReplace));
        replacePanel.add(btnReplace);
        north.add(replacePanel);

        add(north, BorderLayout.NORTH);

        this.resultsModel = new ResultsTableModel();
        final JTable results = new JTable(resultsModel);
        results.setIntercellSpacing(new Dimension(0, 5));
        results.setShowGrid(false);
        results.setRowMargin(0);
        results.setRowHeight(150);
        results.getColumn("Result").setCellRenderer(new STValueElementRenderer());
        results.getColumn("Result").setCellEditor(new STValueElementEditor());

        final JScrollPane jScrollPane = new JScrollPane(results);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
        add(jScrollPane, BorderLayout.CENTER);
    }

    public AbstractAction getSearchAction(JTextField txtSearch) {
        return new AbstractAction("Search") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {

                    resultsModel.clear();

                    presentationModel.db.doInTransaction(transaction ->
                            resultsModel.setResult(presentationModel.db.findAllSTValue()
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

    public AbstractAction getReplaceAction(JTextField txtSearch, JTextField txtReplace) {
        return new AbstractAction("Replace") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
                    resultsModel.content.forEach(stValueElement -> {
                        final String replaceAll = stValueElement.text.replaceAll(txtSearch.getText(), txtReplace.getText());
                        stValueElement.text = replaceAll;
                        stValueElement.stValue.setValue(replaceAll);
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
            this.text = presentationModel.render(stValue);
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
            final STValueElement stValueElement = content.get(rowIndex);
            presentationModel.db.doInTransaction(transaction -> {
                stValueElement.text = aValue.toString().trim();
                stValueElement.stValue.setValue(stValueElement.text);
                fireTableCellUpdated(rowIndex, columnIndex);
            });
        }

        public void clear() {
            content.clear();
            fireTableDataChanged();
        }

        public void setResult(List<STValueElement> result) {
            this.content.addAll(result);
            fireTableDataChanged();
        }
    }

    private final class STValueElementEditor extends AbstractCellEditor implements TableCellEditor {

        private final RSyntaxTextArea component;
        private final RTextScrollPane scrollPane;

        STValueElementEditor() {
            this.component = SwingUtil.newRSyntaxTextArea(5, 40);
            this.scrollPane = new RTextScrollPane(component);
            for (MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
                scrollPane.removeMouseWheelListener(mouseWheelListener);
        }

        @Override
        public Object getCellEditorValue() {
            return component.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            final STValueElement element = (STValueElement) value;
            this.component.setText(element.text);
            this.component.setCaretPosition(0);
            return scrollPane;
        }
    }

    private final class STValueElementRenderer extends RSyntaxTextArea implements TableCellRenderer {

        STValueElementRenderer() {
            super(5, 40);
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