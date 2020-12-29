package nextgen.swing.forms.builder;
public class FormModel {

	private final java.util.UUID uuid;
	private java.util.List<Cell> cells = new java.util.ArrayList<>();
	private String[] components = {"NONE", "Label", "TextField", "Button", "TextArea", "Table", "List", "ToggleButton", "CheckBox", "RadioButton", "Panel", "ScrollPane", "TabbedPane", "Component" };
	private String[] panelWidths = {"600", "800", "1024", "1200"};
	private String[] panelHeights = {"480", "600", "768", "800", "1024", "1200"};
	private String[] extending = { "DebugPanel", "JPanel" };
	private String[] laf = { "NONE", "darcula" };
	private Object[] hAlignments = nextgen.templates.jgoodies.hAlignment.values();;
	private String[] counts = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private String[] sizes = {"pref", "4", "6", "8", "15", "30", "45", "75", "120", "240", "480", "600", "640", "724", "800", "1024"};
	private String[] growths = {"none", "grow", "grow(.1)", "grow(.2)", "grow(.3)", "grow(.5)", "grow(.6)"};
	private Object[] cAlignments = nextgen.templates.jgoodies.columnAlignment.values();
	private Object[] rAlignments = nextgen.templates.jgoodies.rowAlignment.values();
	private java.util.List<Column> columns = new java.util.ArrayList<>();
	private java.util.List<Row> rows = new java.util.ArrayList<>();
	private String name = "";
	private String packageName = "";
	private Object[] vAlignments = nextgen.templates.jgoodies.vAlignment.values();;
	private String[] componentPrefixes = {"", "lbl", "txt", "btn", "txtArea", "tbl", "lst", "tbtn", "chk", "rd", "p", "scr", "tb", "comp" };

	public FormModel() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public FormModel(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public FormModel(FormModel source) {
		this();
		setCells(source.cells.stream().map(Cell::new).collect(java.util.stream.Collectors.toList()));
		this.components = source.components;
		this.panelWidths = source.panelWidths;
		this.panelHeights = source.panelHeights;
		this.extending = source.extending;
		this.laf = source.laf;
		this.hAlignments = source.hAlignments;
		this.counts = source.counts;
		this.sizes = source.sizes;
		this.growths = source.growths;
		this.cAlignments = source.cAlignments;
		this.rAlignments = source.rAlignments;
		setColumns(source.columns.stream().map(Column::new).collect(java.util.stream.Collectors.toList()));
		setRows(source.rows.stream().map(Row::new).collect(java.util.stream.Collectors.toList()));
		this.name = source.name;
		this.packageName = source.packageName;
		this.vAlignments = source.vAlignments;
		this.componentPrefixes = source.componentPrefixes;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public FormModel setCells(java.util.List<Cell> value) {
		this.cells = value;
		return this;
	}

	public java.util.List<Cell> cells() {
		return cells;
	}


	public FormModel setComponents(String[] value) {
		this.components = value;
		return this;
	}

	public String[] components() {
		return components;
	}


	public FormModel setPanelWidths(String[] value) {
		this.panelWidths = value;
		return this;
	}

	public String[] panelWidths() {
		return panelWidths;
	}


	public FormModel setPanelHeights(String[] value) {
		this.panelHeights = value;
		return this;
	}

	public String[] panelHeights() {
		return panelHeights;
	}


	public FormModel setExtending(String[] value) {
		this.extending = value;
		return this;
	}

	public String[] extending() {
		return extending;
	}


	public FormModel setLaf(String[] value) {
		this.laf = value;
		return this;
	}

	public String[] laf() {
		return laf;
	}


	public FormModel setHAlignments(Object[] value) {
		this.hAlignments = value;
		return this;
	}

	public Object[] hAlignments() {
		return hAlignments;
	}


	public FormModel setCounts(String[] value) {
		this.counts = value;
		return this;
	}

	public String[] counts() {
		return counts;
	}


	public FormModel setSizes(String[] value) {
		this.sizes = value;
		return this;
	}

	public String[] sizes() {
		return sizes;
	}


	public FormModel setGrowths(String[] value) {
		this.growths = value;
		return this;
	}

	public String[] growths() {
		return growths;
	}


	public FormModel setCAlignments(Object[] value) {
		this.cAlignments = value;
		return this;
	}

	public Object[] cAlignments() {
		return cAlignments;
	}


	public FormModel setRAlignments(Object[] value) {
		this.rAlignments = value;
		return this;
	}

	public Object[] rAlignments() {
		return rAlignments;
	}


	public FormModel setColumns(java.util.List<Column> value) {
		this.columns = value;
		return this;
	}

	public java.util.List<Column> columns() {
		return columns;
	}


	public FormModel setRows(java.util.List<Row> value) {
		this.rows = value;
		return this;
	}

	public java.util.List<Row> rows() {
		return rows;
	}


	public FormModel setName(String value) {
		this.name = value;
		return this;
	}

	public String name() {
		return name;
	}


	public FormModel setPackageName(String value) {
		this.packageName = value;
		return this;
	}

	public String packageName() {
		return packageName;
	}


	public FormModel setVAlignments(Object[] value) {
		this.vAlignments = value;
		return this;
	}

	public Object[] vAlignments() {
		return vAlignments;
	}


	public FormModel setComponentPrefixes(String[] value) {
		this.componentPrefixes = value;
		return this;
	}

	public String[] componentPrefixes() {
		return componentPrefixes;
	}


	public static  class Cell {

		private final java.util.UUID uuid;
		private int x;
		private int y;
		private String name;
		private int width = 1;
		private int height = 1;
		private nextgen.templates.jgoodies.hAlignment hAlign;
		private nextgen.templates.jgoodies.vAlignment vAlign;
		private String component;

		public Cell() {
			this.uuid = java.util.UUID.randomUUID();
		}

		public Cell(java.util.UUID uuid) {
			this.uuid = uuid;
		}

		public Cell(Cell source) {
			this();
			this.x = source.x;
			this.y = source.y;
			this.name = source.name;
			this.width = source.width;
			this.height = source.height;
			this.hAlign = source.hAlign;
			this.vAlign = source.vAlign;
			this.component = source.component;
		}

		public java.util.UUID getUuid() {
			return this.uuid;
		}	

		public Cell setX(int value) {
			this.x = value;
			return this;
		}

		public int x() {
			return x;
		}


		public Cell setY(int value) {
			this.y = value;
			return this;
		}

		public int y() {
			return y;
		}


		public Cell setName(String value) {
			this.name = value;
			return this;
		}

		public String name() {
			return name;
		}


		public Cell setWidth(int value) {
			this.width = value;
			return this;
		}

		public int width() {
			return width;
		}


		public Cell setHeight(int value) {
			this.height = value;
			return this;
		}

		public int height() {
			return height;
		}


		public Cell setHAlign(nextgen.templates.jgoodies.hAlignment value) {
			this.hAlign = value;
			return this;
		}

		public nextgen.templates.jgoodies.hAlignment hAlign() {
			return hAlign;
		}


		public Cell setVAlign(nextgen.templates.jgoodies.vAlignment value) {
			this.vAlign = value;
			return this;
		}

		public nextgen.templates.jgoodies.vAlignment vAlign() {
			return vAlign;
		}


		public Cell setComponent(String value) {
			this.component = value;
			return this;
		}

		public String component() {
			return component;
		}



		@Override
		public String toString() {
			return x + " " + y + " " + component + " " + name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Cell that = (Cell) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return java.util.Objects.hash(uuid);
		}
	}

	public static  class Column {

		private final java.util.UUID uuid;
		private nextgen.templates.jgoodies.columnAlignment columnAlignment;
		private String size;
		private String grow;
		private int x;
		private int y;

		public Column() {
			this.uuid = java.util.UUID.randomUUID();
		}

		public Column(java.util.UUID uuid) {
			this.uuid = uuid;
		}

		public Column(Column source) {
			this();
			this.columnAlignment = source.columnAlignment;
			this.size = source.size;
			this.grow = source.grow;
			this.x = source.x;
			this.y = source.y;
		}

		public java.util.UUID getUuid() {
			return this.uuid;
		}	

		public Column setColumnAlignment(nextgen.templates.jgoodies.columnAlignment value) {
			this.columnAlignment = value;
			return this;
		}

		public nextgen.templates.jgoodies.columnAlignment columnAlignment() {
			return columnAlignment;
		}


		public Column setSize(String value) {
			this.size = value;
			return this;
		}

		public String size() {
			return size;
		}


		public Column setGrow(String value) {
			this.grow = value;
			return this;
		}

		public String grow() {
			return grow;
		}


		public Column setX(int value) {
			this.x = value;
			return this;
		}

		public int x() {
			return x;
		}


		public Column setY(int value) {
			this.y = value;
			return this;
		}

		public int y() {
			return y;
		}



		@Override
		public String toString() {
			return x + " " + y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Column that = (Column) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return java.util.Objects.hash(uuid);
		}
	}

	public static  class Row {

		private final java.util.UUID uuid;
		private nextgen.templates.jgoodies.rowAlignment rowAlignment;
		private String size;
		private String grow;
		private int x;
		private int y;

		public Row() {
			this.uuid = java.util.UUID.randomUUID();
		}

		public Row(java.util.UUID uuid) {
			this.uuid = uuid;
		}

		public Row(Row source) {
			this();
			this.rowAlignment = source.rowAlignment;
			this.size = source.size;
			this.grow = source.grow;
			this.x = source.x;
			this.y = source.y;
		}

		public java.util.UUID getUuid() {
			return this.uuid;
		}	

		public Row setRowAlignment(nextgen.templates.jgoodies.rowAlignment value) {
			this.rowAlignment = value;
			return this;
		}

		public nextgen.templates.jgoodies.rowAlignment rowAlignment() {
			return rowAlignment;
		}


		public Row setSize(String value) {
			this.size = value;
			return this;
		}

		public String size() {
			return size;
		}


		public Row setGrow(String value) {
			this.grow = value;
			return this;
		}

		public String grow() {
			return grow;
		}


		public Row setX(int value) {
			this.x = value;
			return this;
		}

		public int x() {
			return x;
		}


		public Row setY(int value) {
			this.y = value;
			return this;
		}

		public int y() {
			return y;
		}



		@Override
		public String toString() {
			return x + " " + y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Row that = (Row) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return java.util.Objects.hash(uuid);
		}
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormModel that = (FormModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}