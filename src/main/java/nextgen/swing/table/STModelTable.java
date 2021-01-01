package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class STModelTable extends javax.swing.JTable {

/*
	1 stTemplate	String	
	0 stGroup	String	
	2 name	String	
*/
	private Consumer<nextgen.model.STModel> selectionListener;

	public STModelTable() {
		super(new ResultsTableModel());
	}

	public STModelTable setSelectionListener(Consumer<nextgen.model.STModel> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public STModelTable setContent(java.util.stream.Stream<nextgen.model.STModel> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public STModelTable setContent(java.util.Collection<nextgen.model.STModel> content) {

		final ResultsTableModel tableModel = new ResultsTableModel(content);
		setModel(tableModel);

		getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting()) return;
			if (getSelectedRow() != -1 && selectionListener != null) selectionListener.accept(tableModel().getValueAt(getSelectedRow()));
		});

		getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(1).setCellEditor(new CellEditor());
		getColumnModel().getColumn(0).setCellEditor(new CellEditor());
		getColumnModel().getColumn(2).setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public STModelTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public STModelTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.STModel model;
		private String stTemplate;
		private String stGroup;
		private String name;

		protected RowElement(nextgen.model.STModel model) {
			this.model = model;
			stTemplate = model.getStTemplate().getName();
			stGroup = nextgen.swing.STAppPresentationModel.getSTGroup(model.getStTemplate()).getName();
			name = nextgen.swing.STAppPresentationModel.getSTModelName(model, "[no name]");
		}

		String getStTemplate() { return stTemplate; }

		String getStGroup() { return stGroup; }

		String getName() { return name; }

		public void setStTemplate(Object value) { this.stTemplate = (String)value; }

		public void setStGroup(Object value) { this.stGroup = (String)value; }

		public void setName(Object value) { this.name = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.STModel> data) {
			for (nextgen.model.STModel row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 1: return false;
				case 0: return false;
				case 2: return false;
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
				case 1: return "stTemplate";
				case 0: return "stGroup";
				case 2: return "name";
			}
			return "";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch(columnIndex) {
				case 1: return String.class;
				case 0: return String.class;
				case 2: return String.class;
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
				case "stTemplate": return 1;
				case "stGroup": return 0;
				case "name": return 2;
			}
			return 0;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 1: return content.get(rowIndex).getStTemplate();
				case 0: return content.get(rowIndex).getStGroup();
				case 2: return content.get(rowIndex).getName();
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 1: break;
				case 0: break;
				case 2: break;
			}
		}

		private nextgen.model.STModel getValueAt(int row) {
			return content.get(row).model;
		}
	}
}