package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STGroupActionTable extends javax.swing.JTable {

/*
	0 name	String	
*/
	private Consumer<nextgen.model.STGroupAction> selectionListener;

	public STGroupActionTable() {
		super(new ResultsTableModel());
	}

	public STGroupActionTable setSelectionListener(Consumer<nextgen.model.STGroupAction> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STGroupActionTable setContent(java.util.stream.Stream<nextgen.model.STGroupAction> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STGroupActionTable setContent(java.util.Collection<nextgen.model.STGroupAction> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});

		getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(0).setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public java.util.List<nextgen.model.STGroupAction> getSelectedValues() {
		java.util.List<nextgen.model.STGroupAction> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public STGroupActionTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STGroupActionTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STGroupAction model;
		private String _name;

		protected RowElement(nextgen.model.STGroupAction model) {
			this.model = model;
			_name = model.getName();
		}

		String getName() { return _name; }

		public void setName(Object value) { this._name = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.STGroupAction> data) {
			for (nextgen.model.STGroupAction row : data) content.add(new RowElement(row));
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
				case 0: return "name";
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
				case "name": return 0;
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
				case 0: return content.get(rowIndex).getName();
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: break;
			}
		}

		private nextgen.model.STGroupAction getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  