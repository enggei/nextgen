package nextgen.swing.table;

import nextgen.model.STValue;

import java.awt.*;
import java.util.function.Consumer;
public class STValueTable extends javax.swing.JTable {

/*
	0 value	String	
*/
	private Consumer<STValue> selectionListener;

	public STValueTable() {
		super(new ResultsTableModel());
		setIntercellSpacing(new java.awt.Dimension(0, 5));
		setShowGrid(false);
		setRowMargin(0);
		setRowHeight(150);
	}

	public void setSelectionListener(Consumer<STValue> selectionListener) {
		this.selectionListener = selectionListener;
	}

	public void setContent(java.util.Collection<nextgen.model.STValue> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});

		getColumn("value").setCellRenderer(new CellRenderer());
		getColumn("value").setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public void refresh() {
		tableModel().fireTableDataChanged();
	}

	public void clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STValue model;
		private String value;

		protected RowElement(nextgen.model.STValue model) {
			this.model = model;
			value = model.getValue();
		}

		String getValue() { return value; }

		public void setValue(Object value) { this.value = (String)value; }
	}

	static final class CellEditor extends javax.swing.AbstractCellEditor implements javax.swing.table.TableCellEditor {

		final javax.swing.JTextField component = new javax.swing.JTextField();

		CellEditor() {
		}

		@Override
		public Object getCellEditorValue() {
			return component.getText();
		}

		@Override
		public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
			component.setText(value.toString());
			component.setCaretPosition(0);
			return component;
		}
	}

	static private final class CellRenderer extends javax.swing.JTextField implements javax.swing.table.TableCellRenderer {

		CellRenderer() {
			super("");
			setBackground(Color.RED);
		}

		@Override
		public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setText(((RowElement) value).toString());
			return this;
		}
	}

	static final class ResultsTableModel extends javax.swing.table.AbstractTableModel {

		final java.util.List<RowElement> content = new java.util.ArrayList<>();

		ResultsTableModel() {
		}

		ResultsTableModel(java.util.Collection<nextgen.model.STValue> data) {
			for (nextgen.model.STValue row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return false;
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
				case 0: return "value";
			}
			return "";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch(columnIndex) {
				case 0: return String.class;
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
				case "value": return 0;
			}
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
			switch(columnIndex) {
				case 0: return content.get(rowIndex).getValue();
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: break;
			}
		}

		private nextgen.model.STValue getValueAt(int row) {
			return content.get(row).model;
		}
	}
}