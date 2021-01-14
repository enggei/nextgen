package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STEnumValueTable extends javax.swing.JTable {

/*
	0 name	String	
	1 lexical	String	
*/
	private Consumer<nextgen.model.STEnumValue> selectionListener;

	public STEnumValueTable() {
		super(new ResultsTableModel());
	}

	public STEnumValueTable setSelectionListener(Consumer<nextgen.model.STEnumValue> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STEnumValueTable setContent(java.util.stream.Stream<nextgen.model.STEnumValue> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STEnumValueTable setContent(java.util.Collection<nextgen.model.STEnumValue> content) {

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

	public java.util.List<nextgen.model.STEnumValue> getSelectedValues() {
		java.util.List<nextgen.model.STEnumValue> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public STEnumValueTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STEnumValueTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STEnumValue model;
		private String _name;
		private String _lexical;

		protected RowElement(nextgen.model.STEnumValue model) {
			this.model = model;
			_name = model.getName();
			_lexical = model.getLexical();
		}

		String getName() { return _name; }

		String getLexical() { return _lexical; }

		public void setName(Object value) { this._name = (String)value; }

		public void setLexical(Object value) { this._lexical = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.STEnumValue> data) {
			for (nextgen.model.STEnumValue row : data) content.add(new RowElement(row));
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
				case 1: return "lexical";
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
				case "lexical": return 1;
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
				case 1: return content.get(rowIndex).getLexical();
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

		private nextgen.model.STEnumValue getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  