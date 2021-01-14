package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STGroupModelTable extends javax.swing.JTable {

/*
	0 language	String	
	1 name	String	
	2 delimiter	String	
	3 icon	String	
*/
	private Consumer<nextgen.model.STGroupModel> selectionListener;

	public STGroupModelTable() {
		super(new ResultsTableModel());
	}

	public STGroupModelTable setSelectionListener(Consumer<nextgen.model.STGroupModel> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STGroupModelTable setContent(java.util.stream.Stream<nextgen.model.STGroupModel> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STGroupModelTable setContent(java.util.Collection<nextgen.model.STGroupModel> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});

		getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(0).setCellEditor(new CellEditor());
		getColumnModel().getColumn(1).setCellEditor(new CellEditor());
		getColumnModel().getColumn(2).setCellEditor(new CellEditor());
		getColumnModel().getColumn(3).setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public java.util.List<nextgen.model.STGroupModel> getSelectedValues() {
		java.util.List<nextgen.model.STGroupModel> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public STGroupModelTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STGroupModelTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STGroupModel model;
		private String _language;
		private String _name;
		private String _delimiter;
		private String _icon;

		protected RowElement(nextgen.model.STGroupModel model) {
			this.model = model;
			_language = model.getLanguage();
			_name = model.getName();
			_delimiter = model.getDelimiter();
			_icon = model.getIcon();
		}

		String getLanguage() { return _language; }

		String getName() { return _name; }

		String getDelimiter() { return _delimiter; }

		String getIcon() { return _icon; }

		public void setLanguage(Object value) { this._language = (String)value; }

		public void setName(Object value) { this._name = (String)value; }

		public void setDelimiter(Object value) { this._delimiter = (String)value; }

		public void setIcon(Object value) { this._icon = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.STGroupModel> data) {
			for (nextgen.model.STGroupModel row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return false;
				case 1: return false;
				case 2: return false;
				case 3: return false;
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
				case 0: return "language";
				case 1: return "name";
				case 2: return "delimiter";
				case 3: return "icon";
			}
			return "";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch(columnIndex) {
				case 0: return String.class;
				case 1: return String.class;
				case 2: return String.class;
				case 3: return String.class;
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
				case "language": return 0;
				case "name": return 1;
				case "delimiter": return 2;
				case "icon": return 3;
			}
			return 0;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return content.get(rowIndex).getLanguage();
				case 1: return content.get(rowIndex).getName();
				case 2: return content.get(rowIndex).getDelimiter();
				case 3: return content.get(rowIndex).getIcon();
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: break;
				case 1: break;
				case 2: break;
				case 3: break;
			}
		}

		private nextgen.model.STGroupModel getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  