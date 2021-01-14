package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STArgumentKVTable extends javax.swing.JTable {

/*
*/
	private Consumer<nextgen.model.STArgumentKV> selectionListener;

	public STArgumentKVTable() {
		super(new ResultsTableModel());
	}

	public STArgumentKVTable setSelectionListener(Consumer<nextgen.model.STArgumentKV> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STArgumentKVTable setContent(java.util.stream.Stream<nextgen.model.STArgumentKV> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STArgumentKVTable setContent(java.util.Collection<nextgen.model.STArgumentKV> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});


		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public java.util.List<nextgen.model.STArgumentKV> getSelectedValues() {
		java.util.List<nextgen.model.STArgumentKV> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public STArgumentKVTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STArgumentKVTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STArgumentKV model;

		protected RowElement(nextgen.model.STArgumentKV model) {
			this.model = model;
		}


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

		ResultsTableModel(java.util.Collection<nextgen.model.STArgumentKV> data) {
			for (nextgen.model.STArgumentKV row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
			}
			return "";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch(columnIndex) {
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
			}
			return 0;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public int getColumnCount() {
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
			}
		}

		private nextgen.model.STArgumentKV getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  