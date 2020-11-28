package nextgen.templates.materialui;

public class TablePaginationElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _ActionsComponent;
	private Object _backIconButtonProps;
	private Object _backIconButtonText;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _count;
	private Object _id;
	private Object _key;
	private Object _labelDisplayedRows;
	private Object _labelRowsPerPage;
	private Object _nextIconButtonProps;
	private Object _nextIconButtonText;
	private Object _onChangePage;
	private Object _onChangeRowsPerPage;
	private Object _page;
	private Object _rowsPerPage;
	private Object _rowsPerPageOptions;
	private Object _SelectProps;
	private Object _style;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TablePaginationElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TablePaginationElement");
		st.add("ActionsComponent", _ActionsComponent);
		st.add("backIconButtonProps", _backIconButtonProps);
		st.add("backIconButtonText", _backIconButtonText);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("count", _count);
		st.add("id", _id);
		st.add("key", _key);
		st.add("labelDisplayedRows", _labelDisplayedRows);
		st.add("labelRowsPerPage", _labelRowsPerPage);
		st.add("nextIconButtonProps", _nextIconButtonProps);
		st.add("nextIconButtonText", _nextIconButtonText);
		st.add("onChangePage", _onChangePage);
		st.add("onChangeRowsPerPage", _onChangeRowsPerPage);
		st.add("page", _page);
		st.add("rowsPerPage", _rowsPerPage);
		st.add("rowsPerPageOptions", _rowsPerPageOptions);
		st.add("SelectProps", _SelectProps);
		st.add("style", _style);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TablePaginationElement setActionsComponent(Object value) {
		this._ActionsComponent = value;
		return this;
	}

	public Object getActionsComponent() {
		return this._ActionsComponent;
	}

	public Object getActionsComponent(Object defaultValue) {
		return this._ActionsComponent == null ? defaultValue : this._ActionsComponent;
	}

	public boolean hasActionsComponent() {
		return this._ActionsComponent != null;
	}

	public TablePaginationElement removeActionsComponent() {
		this._ActionsComponent = null;
		return this;
	} 

	public TablePaginationElement setBackIconButtonProps(Object value) {
		this._backIconButtonProps = value;
		return this;
	}

	public Object getBackIconButtonProps() {
		return this._backIconButtonProps;
	}

	public Object getBackIconButtonProps(Object defaultValue) {
		return this._backIconButtonProps == null ? defaultValue : this._backIconButtonProps;
	}

	public boolean hasBackIconButtonProps() {
		return this._backIconButtonProps != null;
	}

	public TablePaginationElement removeBackIconButtonProps() {
		this._backIconButtonProps = null;
		return this;
	} 

	public TablePaginationElement setBackIconButtonText(Object value) {
		this._backIconButtonText = value;
		return this;
	}

	public Object getBackIconButtonText() {
		return this._backIconButtonText;
	}

	public Object getBackIconButtonText(Object defaultValue) {
		return this._backIconButtonText == null ? defaultValue : this._backIconButtonText;
	}

	public boolean hasBackIconButtonText() {
		return this._backIconButtonText != null;
	}

	public TablePaginationElement removeBackIconButtonText() {
		this._backIconButtonText = null;
		return this;
	} 

	public TablePaginationElement setClasses(Object value) {
		this._classes = value;
		return this;
	}

	public Object getClasses() {
		return this._classes;
	}

	public Object getClasses(Object defaultValue) {
		return this._classes == null ? defaultValue : this._classes;
	}

	public boolean hasClasses() {
		return this._classes != null;
	}

	public TablePaginationElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TablePaginationElement setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public TablePaginationElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TablePaginationElement setComponent(Object value) {
		this._component = value;
		return this;
	}

	public Object getComponent() {
		return this._component;
	}

	public Object getComponent(Object defaultValue) {
		return this._component == null ? defaultValue : this._component;
	}

	public boolean hasComponent() {
		return this._component != null;
	}

	public TablePaginationElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TablePaginationElement setCount(Object value) {
		this._count = value;
		return this;
	}

	public Object getCount() {
		return this._count;
	}

	public Object getCount(Object defaultValue) {
		return this._count == null ? defaultValue : this._count;
	}

	public boolean hasCount() {
		return this._count != null;
	}

	public TablePaginationElement removeCount() {
		this._count = null;
		return this;
	} 

	public TablePaginationElement setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public TablePaginationElement removeId() {
		this._id = null;
		return this;
	} 

	public TablePaginationElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public TablePaginationElement removeKey() {
		this._key = null;
		return this;
	} 

	public TablePaginationElement setLabelDisplayedRows(Object value) {
		this._labelDisplayedRows = value;
		return this;
	}

	public Object getLabelDisplayedRows() {
		return this._labelDisplayedRows;
	}

	public Object getLabelDisplayedRows(Object defaultValue) {
		return this._labelDisplayedRows == null ? defaultValue : this._labelDisplayedRows;
	}

	public boolean hasLabelDisplayedRows() {
		return this._labelDisplayedRows != null;
	}

	public TablePaginationElement removeLabelDisplayedRows() {
		this._labelDisplayedRows = null;
		return this;
	} 

	public TablePaginationElement setLabelRowsPerPage(Object value) {
		this._labelRowsPerPage = value;
		return this;
	}

	public Object getLabelRowsPerPage() {
		return this._labelRowsPerPage;
	}

	public Object getLabelRowsPerPage(Object defaultValue) {
		return this._labelRowsPerPage == null ? defaultValue : this._labelRowsPerPage;
	}

	public boolean hasLabelRowsPerPage() {
		return this._labelRowsPerPage != null;
	}

	public TablePaginationElement removeLabelRowsPerPage() {
		this._labelRowsPerPage = null;
		return this;
	} 

	public TablePaginationElement setNextIconButtonProps(Object value) {
		this._nextIconButtonProps = value;
		return this;
	}

	public Object getNextIconButtonProps() {
		return this._nextIconButtonProps;
	}

	public Object getNextIconButtonProps(Object defaultValue) {
		return this._nextIconButtonProps == null ? defaultValue : this._nextIconButtonProps;
	}

	public boolean hasNextIconButtonProps() {
		return this._nextIconButtonProps != null;
	}

	public TablePaginationElement removeNextIconButtonProps() {
		this._nextIconButtonProps = null;
		return this;
	} 

	public TablePaginationElement setNextIconButtonText(Object value) {
		this._nextIconButtonText = value;
		return this;
	}

	public Object getNextIconButtonText() {
		return this._nextIconButtonText;
	}

	public Object getNextIconButtonText(Object defaultValue) {
		return this._nextIconButtonText == null ? defaultValue : this._nextIconButtonText;
	}

	public boolean hasNextIconButtonText() {
		return this._nextIconButtonText != null;
	}

	public TablePaginationElement removeNextIconButtonText() {
		this._nextIconButtonText = null;
		return this;
	} 

	public TablePaginationElement setOnChangePage(Object value) {
		this._onChangePage = value;
		return this;
	}

	public Object getOnChangePage() {
		return this._onChangePage;
	}

	public Object getOnChangePage(Object defaultValue) {
		return this._onChangePage == null ? defaultValue : this._onChangePage;
	}

	public boolean hasOnChangePage() {
		return this._onChangePage != null;
	}

	public TablePaginationElement removeOnChangePage() {
		this._onChangePage = null;
		return this;
	} 

	public TablePaginationElement setOnChangeRowsPerPage(Object value) {
		this._onChangeRowsPerPage = value;
		return this;
	}

	public Object getOnChangeRowsPerPage() {
		return this._onChangeRowsPerPage;
	}

	public Object getOnChangeRowsPerPage(Object defaultValue) {
		return this._onChangeRowsPerPage == null ? defaultValue : this._onChangeRowsPerPage;
	}

	public boolean hasOnChangeRowsPerPage() {
		return this._onChangeRowsPerPage != null;
	}

	public TablePaginationElement removeOnChangeRowsPerPage() {
		this._onChangeRowsPerPage = null;
		return this;
	} 

	public TablePaginationElement setPage(Object value) {
		this._page = value;
		return this;
	}

	public Object getPage() {
		return this._page;
	}

	public Object getPage(Object defaultValue) {
		return this._page == null ? defaultValue : this._page;
	}

	public boolean hasPage() {
		return this._page != null;
	}

	public TablePaginationElement removePage() {
		this._page = null;
		return this;
	} 

	public TablePaginationElement setRowsPerPage(Object value) {
		this._rowsPerPage = value;
		return this;
	}

	public Object getRowsPerPage() {
		return this._rowsPerPage;
	}

	public Object getRowsPerPage(Object defaultValue) {
		return this._rowsPerPage == null ? defaultValue : this._rowsPerPage;
	}

	public boolean hasRowsPerPage() {
		return this._rowsPerPage != null;
	}

	public TablePaginationElement removeRowsPerPage() {
		this._rowsPerPage = null;
		return this;
	} 

	public TablePaginationElement setRowsPerPageOptions(Object value) {
		this._rowsPerPageOptions = value;
		return this;
	}

	public Object getRowsPerPageOptions() {
		return this._rowsPerPageOptions;
	}

	public Object getRowsPerPageOptions(Object defaultValue) {
		return this._rowsPerPageOptions == null ? defaultValue : this._rowsPerPageOptions;
	}

	public boolean hasRowsPerPageOptions() {
		return this._rowsPerPageOptions != null;
	}

	public TablePaginationElement removeRowsPerPageOptions() {
		this._rowsPerPageOptions = null;
		return this;
	} 

	public TablePaginationElement setSelectProps(Object value) {
		this._SelectProps = value;
		return this;
	}

	public Object getSelectProps() {
		return this._SelectProps;
	}

	public Object getSelectProps(Object defaultValue) {
		return this._SelectProps == null ? defaultValue : this._SelectProps;
	}

	public boolean hasSelectProps() {
		return this._SelectProps != null;
	}

	public TablePaginationElement removeSelectProps() {
		this._SelectProps = null;
		return this;
	} 

	public TablePaginationElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public TablePaginationElement removeStyle() {
		this._style = null;
		return this;
	} 


	public TablePaginationElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TablePaginationElement addAttribute(TablePaginationElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TablePaginationElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TablePaginationElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TablePaginationElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TablePaginationElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TablePaginationElement_Attribute {

		Object _name;
		Object _value;

		public TablePaginationElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TablePaginationElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TablePaginationElement that = (TablePaginationElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TablePaginationElement(ActionsComponent,backIconButtonProps,backIconButtonText,classes,className,component,count,id,key,labelDisplayedRows,labelRowsPerPage,nextIconButtonProps,nextIconButtonText,onChangePage,onChangeRowsPerPage,page,rowsPerPage,rowsPerPageOptions,SelectProps,style,attribute) ::= <<<TablePagination~if(ActionsComponent)~\n" + 
				"	ActionsComponent=~ActionsComponent~~endif~~if(backIconButtonProps)~\n" + 
				"	backIconButtonProps=~backIconButtonProps~~endif~~if(backIconButtonText)~\n" + 
				"	backIconButtonText=\"~backIconButtonText~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~\n" + 
				"	count=~count~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(labelDisplayedRows)~\n" + 
				"	labelDisplayedRows=~labelDisplayedRows~~endif~~if(labelRowsPerPage)~\n" + 
				"	labelRowsPerPage=~labelRowsPerPage~~endif~~if(nextIconButtonProps)~\n" + 
				"	nextIconButtonProps=~nextIconButtonProps~~endif~~if(nextIconButtonText)~\n" + 
				"	nextIconButtonText=\"~nextIconButtonText~\"~endif~\n" + 
				"	onChangePage=~onChangePage~~if(onChangeRowsPerPage)~\n" + 
				"	onChangeRowsPerPage=~onChangeRowsPerPage~~endif~\n" + 
				"	page=~page~\n" + 
				"	rowsPerPage=~rowsPerPage~~if(rowsPerPageOptions)~\n" + 
				"	rowsPerPageOptions=~rowsPerPageOptions~~endif~~if(SelectProps)~\n" + 
				"	SelectProps=~SelectProps~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  