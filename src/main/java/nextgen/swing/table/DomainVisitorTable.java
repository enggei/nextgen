package nextgen.swing.table;

import java.awt.*;
import java.util.function.Consumer;

public class DomainVisitorTable extends javax.swing.JTable {

/*
	0 name	String	
	1 onDomain	String	
	2 onEntity	String	
	3 onRelation	String	
	4 onComplete	String	
	5 onEntityEntity	String	
	6 onEnumEntity	String	
	7 onPrimitiveEntity	String	
	8 onOneEntityRelation	String	
	9 onOneEnumRelation	String	
	10 onOnePrimitiveRelation	String	
	11 onManyEntityRelation	String	
	12 onManyEnumRelation	String	
	13 onManyPrimitiveRelation	String	
	14 onOptionalEntityRelation	String	
	15 onOptionalEnumRelation	String	
	16 onOptionalPrimitiveRelation	String	
*/
	private Consumer<nextgen.model.DomainVisitor> selectionListener;

	public DomainVisitorTable() {
		super(new ResultsTableModel());
	}

	public DomainVisitorTable setSelectionListener(Consumer<nextgen.model.DomainVisitor> selectionListener) {
		this.selectionListener = selectionListener;
		return this;
	}

	public DomainVisitorTable setContent(java.util.stream.Stream<nextgen.model.DomainVisitor> content) {
		return setContent(content.collect(java.util.stream.Collectors.toList()));
	}

	public DomainVisitorTable setContent(java.util.Collection<nextgen.model.DomainVisitor> content) {

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
		getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(5).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(6).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(7).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(8).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(9).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(10).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(11).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(12).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(13).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(14).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(15).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(16).setCellRenderer(new CellRenderer());
		getColumnModel().getColumn(0).setCellEditor(new CellEditor());
		getColumnModel().getColumn(1).setCellEditor(new CellEditor());
		getColumnModel().getColumn(2).setCellEditor(new CellEditor());
		getColumnModel().getColumn(3).setCellEditor(new CellEditor());
		getColumnModel().getColumn(4).setCellEditor(new CellEditor());
		getColumnModel().getColumn(5).setCellEditor(new CellEditor());
		getColumnModel().getColumn(6).setCellEditor(new CellEditor());
		getColumnModel().getColumn(7).setCellEditor(new CellEditor());
		getColumnModel().getColumn(8).setCellEditor(new CellEditor());
		getColumnModel().getColumn(9).setCellEditor(new CellEditor());
		getColumnModel().getColumn(10).setCellEditor(new CellEditor());
		getColumnModel().getColumn(11).setCellEditor(new CellEditor());
		getColumnModel().getColumn(12).setCellEditor(new CellEditor());
		getColumnModel().getColumn(13).setCellEditor(new CellEditor());
		getColumnModel().getColumn(14).setCellEditor(new CellEditor());
		getColumnModel().getColumn(15).setCellEditor(new CellEditor());
		getColumnModel().getColumn(16).setCellEditor(new CellEditor());

		tableModel.fireTableStructureChanged();

		return this;
	}

	public java.util.stream.Stream<RowElement> getContent() {
		return tableModel().content.stream();
	}

	public java.util.List<nextgen.model.DomainVisitor> getSelectedValues() {
		java.util.List<nextgen.model.DomainVisitor> values = new java.util.ArrayList<>();
		for (int selectedRow : getSelectedRows()) values.add(tableModel().content.get(selectedRow).model);
		return values;
	}

	public DomainVisitorTable refresh() {
		tableModel().fireTableDataChanged();
		return this;
	}

	public DomainVisitorTable clear() {
		tableModel().content.clear();
		tableModel().fireTableDataChanged();
		return this;
	}

	private ResultsTableModel tableModel() {
		return (ResultsTableModel) getModel();
	}

	public static final class RowElement {

		public final nextgen.model.DomainVisitor model;
		private String _name;
		private String _onDomain;
		private String _onEntity;
		private String _onRelation;
		private String _onComplete;
		private String _onEntityEntity;
		private String _onEnumEntity;
		private String _onPrimitiveEntity;
		private String _onOneEntityRelation;
		private String _onOneEnumRelation;
		private String _onOnePrimitiveRelation;
		private String _onManyEntityRelation;
		private String _onManyEnumRelation;
		private String _onManyPrimitiveRelation;
		private String _onOptionalEntityRelation;
		private String _onOptionalEnumRelation;
		private String _onOptionalPrimitiveRelation;

		protected RowElement(nextgen.model.DomainVisitor model) {
			this.model = model;
			_name = model.getName();
			_onDomain = model.getOnDomain();
			_onEntity = model.getOnEntity();
			_onRelation = model.getOnRelation();
			_onComplete = model.getOnComplete();
			_onEntityEntity = model.getOnEntityEntity();
			_onEnumEntity = model.getOnEnumEntity();
			_onPrimitiveEntity = model.getOnPrimitiveEntity();
			_onOneEntityRelation = model.getOnOneEntityRelation();
			_onOneEnumRelation = model.getOnOneEnumRelation();
			_onOnePrimitiveRelation = model.getOnOnePrimitiveRelation();
			_onManyEntityRelation = model.getOnManyEntityRelation();
			_onManyEnumRelation = model.getOnManyEnumRelation();
			_onManyPrimitiveRelation = model.getOnManyPrimitiveRelation();
			_onOptionalEntityRelation = model.getOnOptionalEntityRelation();
			_onOptionalEnumRelation = model.getOnOptionalEnumRelation();
			_onOptionalPrimitiveRelation = model.getOnOptionalPrimitiveRelation();
		}

		String getName() { return _name; }

		String getOnDomain() { return _onDomain; }

		String getOnEntity() { return _onEntity; }

		String getOnRelation() { return _onRelation; }

		String getOnComplete() { return _onComplete; }

		String getOnEntityEntity() { return _onEntityEntity; }

		String getOnEnumEntity() { return _onEnumEntity; }

		String getOnPrimitiveEntity() { return _onPrimitiveEntity; }

		String getOnOneEntityRelation() { return _onOneEntityRelation; }

		String getOnOneEnumRelation() { return _onOneEnumRelation; }

		String getOnOnePrimitiveRelation() { return _onOnePrimitiveRelation; }

		String getOnManyEntityRelation() { return _onManyEntityRelation; }

		String getOnManyEnumRelation() { return _onManyEnumRelation; }

		String getOnManyPrimitiveRelation() { return _onManyPrimitiveRelation; }

		String getOnOptionalEntityRelation() { return _onOptionalEntityRelation; }

		String getOnOptionalEnumRelation() { return _onOptionalEnumRelation; }

		String getOnOptionalPrimitiveRelation() { return _onOptionalPrimitiveRelation; }

		public void setName(Object value) { this._name = (String)value; }

		public void setOnDomain(Object value) { this._onDomain = (String)value; }

		public void setOnEntity(Object value) { this._onEntity = (String)value; }

		public void setOnRelation(Object value) { this._onRelation = (String)value; }

		public void setOnComplete(Object value) { this._onComplete = (String)value; }

		public void setOnEntityEntity(Object value) { this._onEntityEntity = (String)value; }

		public void setOnEnumEntity(Object value) { this._onEnumEntity = (String)value; }

		public void setOnPrimitiveEntity(Object value) { this._onPrimitiveEntity = (String)value; }

		public void setOnOneEntityRelation(Object value) { this._onOneEntityRelation = (String)value; }

		public void setOnOneEnumRelation(Object value) { this._onOneEnumRelation = (String)value; }

		public void setOnOnePrimitiveRelation(Object value) { this._onOnePrimitiveRelation = (String)value; }

		public void setOnManyEntityRelation(Object value) { this._onManyEntityRelation = (String)value; }

		public void setOnManyEnumRelation(Object value) { this._onManyEnumRelation = (String)value; }

		public void setOnManyPrimitiveRelation(Object value) { this._onManyPrimitiveRelation = (String)value; }

		public void setOnOptionalEntityRelation(Object value) { this._onOptionalEntityRelation = (String)value; }

		public void setOnOptionalEnumRelation(Object value) { this._onOptionalEnumRelation = (String)value; }

		public void setOnOptionalPrimitiveRelation(Object value) { this._onOptionalPrimitiveRelation = (String)value; }
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

		ResultsTableModel(java.util.Collection<nextgen.model.DomainVisitor> data) {
			for (nextgen.model.DomainVisitor row : data) content.add(new RowElement(row));
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return false;
				case 1: return false;
				case 2: return false;
				case 3: return false;
				case 4: return false;
				case 5: return false;
				case 6: return false;
				case 7: return false;
				case 8: return false;
				case 9: return false;
				case 10: return false;
				case 11: return false;
				case 12: return false;
				case 13: return false;
				case 14: return false;
				case 15: return false;
				case 16: return false;
			}
			return false;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
				case 0: return "name";
				case 1: return "onDomain";
				case 2: return "onEntity";
				case 3: return "onRelation";
				case 4: return "onComplete";
				case 5: return "onEntityEntity";
				case 6: return "onEnumEntity";
				case 7: return "onPrimitiveEntity";
				case 8: return "onOneEntityRelation";
				case 9: return "onOneEnumRelation";
				case 10: return "onOnePrimitiveRelation";
				case 11: return "onManyEntityRelation";
				case 12: return "onManyEnumRelation";
				case 13: return "onManyPrimitiveRelation";
				case 14: return "onOptionalEntityRelation";
				case 15: return "onOptionalEnumRelation";
				case 16: return "onOptionalPrimitiveRelation";
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
				case 4: return String.class;
				case 5: return String.class;
				case 6: return String.class;
				case 7: return String.class;
				case 8: return String.class;
				case 9: return String.class;
				case 10: return String.class;
				case 11: return String.class;
				case 12: return String.class;
				case 13: return String.class;
				case 14: return String.class;
				case 15: return String.class;
				case 16: return String.class;
			}
			return Object.class;
		}

		@Override
		public int findColumn(String columnName) {
			switch(columnName) {
				case "name": return 0;
				case "onDomain": return 1;
				case "onEntity": return 2;
				case "onRelation": return 3;
				case "onComplete": return 4;
				case "onEntityEntity": return 5;
				case "onEnumEntity": return 6;
				case "onPrimitiveEntity": return 7;
				case "onOneEntityRelation": return 8;
				case "onOneEnumRelation": return 9;
				case "onOnePrimitiveRelation": return 10;
				case "onManyEntityRelation": return 11;
				case "onManyEnumRelation": return 12;
				case "onManyPrimitiveRelation": return 13;
				case "onOptionalEntityRelation": return 14;
				case "onOptionalEnumRelation": return 15;
				case "onOptionalPrimitiveRelation": return 16;
			}
			return 0;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public int getColumnCount() {
			return 17;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0: return content.get(rowIndex).getName();
				case 1: return content.get(rowIndex).getOnDomain();
				case 2: return content.get(rowIndex).getOnEntity();
				case 3: return content.get(rowIndex).getOnRelation();
				case 4: return content.get(rowIndex).getOnComplete();
				case 5: return content.get(rowIndex).getOnEntityEntity();
				case 6: return content.get(rowIndex).getOnEnumEntity();
				case 7: return content.get(rowIndex).getOnPrimitiveEntity();
				case 8: return content.get(rowIndex).getOnOneEntityRelation();
				case 9: return content.get(rowIndex).getOnOneEnumRelation();
				case 10: return content.get(rowIndex).getOnOnePrimitiveRelation();
				case 11: return content.get(rowIndex).getOnManyEntityRelation();
				case 12: return content.get(rowIndex).getOnManyEnumRelation();
				case 13: return content.get(rowIndex).getOnManyPrimitiveRelation();
				case 14: return content.get(rowIndex).getOnOptionalEntityRelation();
				case 15: return content.get(rowIndex).getOnOptionalEnumRelation();
				case 16: return content.get(rowIndex).getOnOptionalPrimitiveRelation();
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
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 9: break;
				case 10: break;
				case 11: break;
				case 12: break;
				case 13: break;
				case 14: break;
				case 15: break;
				case 16: break;
			}
		}

		private nextgen.model.DomainVisitor getValueAt(int row) {
			return content.get(row).model;
		}
	}
}  