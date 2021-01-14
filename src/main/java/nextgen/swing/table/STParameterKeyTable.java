package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STParameterKeyTable extends javax.swing.JTable {

/*
	0 name	String	
	1 argumentType	String	
*/
	private Consumer<nextgen.model.STParameterKey> selectionListener;

	public STParameterKeyTable() {
		super(new ResultsTableModel());
	}

	public STParameterKeyTable setSelectionListener(Consumer<nextgen.model.STParameterKey> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STParameterKeyTable setContent(java.util.stream.Stream<nextgen.model.STParameterKey> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STParameterKeyTable setContent(java.util.Collection<nextgen.model.STParameterKey> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});

		getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(0).setCellEditor(new CellEditor());
		getColumnModel().getColumn(1).setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public java.util.List<nextgen.model.STParameterKey> getSelectedValues() {
		java.util.List<nextgen.model.STParameterKey> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public STParameterKeyTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STParameterKeyTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STParameterKey model;
		private String _name;
		private String _argumentType;

		protected RowElement(nextgen.model.STParameterKey model) {
			this.model = model;
			_name = model.getName();
			_argumentType = model.getArgumentType();
		}

		String getName() { return _name; }

		String getArgumentType() { return _argumentType; }

		public void setName(Object value) { this._name = (String)value; }

		public void setArgumentType(Object value) { this._argumentType = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.STParameterKey> data) {
			for (nextgen.model.STParameterKey row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return false;
				case 1: return false;
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
				case 0: return "name";
				case 1: return "argumentType";
			}
			return "";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch(columnIndex) {
				case 0: return String.class;
				case 1: return String.class;
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
				case "name": return 0;
				case "argumentType": return 1;
			}
			return 0;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return content.get(rowIndex).getName();
				case 1: return content.get(rowIndex).getArgumentType();
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: break;
				case 1: break;
			}
		}

		private nextgen.model.STParameterKey getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  