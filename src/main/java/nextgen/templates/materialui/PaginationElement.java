package nextgen.templates.materialui;

public class PaginationElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _boundaryCount;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _count;
	private Object _defaultPage;
	private Object _disabled;
	private Object _getItemAriaLabel;
	private Object _hideNextButton;
	private Object _hidePrevButton;
	private Object _id;
	private Object _key;
	private Object _onChange;
	private Object _page;
	private Object _renderItem;
	private Object _shape;
	private Object _showFirstButton;
	private Object _showLastButton;
	private Object _siblingCount;
	private Object _size;
	private Object _style;
	private Object _variant;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	PaginationElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PaginationElement");
		st.add("boundaryCount", _boundaryCount);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("count", _count);
		st.add("defaultPage", _defaultPage);
		st.add("disabled", _disabled);
		st.add("getItemAriaLabel", _getItemAriaLabel);
		st.add("hideNextButton", _hideNextButton);
		st.add("hidePrevButton", _hidePrevButton);
		st.add("id", _id);
		st.add("key", _key);
		st.add("onChange", _onChange);
		st.add("page", _page);
		st.add("renderItem", _renderItem);
		st.add("shape", _shape);
		st.add("showFirstButton", _showFirstButton);
		st.add("showLastButton", _showLastButton);
		st.add("siblingCount", _siblingCount);
		st.add("size", _size);
		st.add("style", _style);
		st.add("variant", _variant);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public PaginationElement setBoundaryCount(Object value) {
		this._boundaryCount = value;
		return this;
	}

	public Object getBoundaryCount() {
		return this._boundaryCount;
	}

	public Object getBoundaryCount(Object defaultValue) {
		return this._boundaryCount == null ? defaultValue : this._boundaryCount;
	}

	public boolean hasBoundaryCount() {
		return this._boundaryCount != null;
	}

	public PaginationElement removeBoundaryCount() {
		this._boundaryCount = null;
		return this;
	} 

	public PaginationElement setClasses(Object value) {
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

	public PaginationElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public PaginationElement setClassName(Object value) {
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

	public PaginationElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PaginationElement setColor(Object value) {
		this._color = value;
		return this;
	}

	public Object getColor() {
		return this._color;
	}

	public Object getColor(Object defaultValue) {
		return this._color == null ? defaultValue : this._color;
	}

	public boolean hasColor() {
		return this._color != null;
	}

	public PaginationElement removeColor() {
		this._color = null;
		return this;
	} 

	public PaginationElement setCount(Object value) {
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

	public PaginationElement removeCount() {
		this._count = null;
		return this;
	} 

	public PaginationElement setDefaultPage(Object value) {
		this._defaultPage = value;
		return this;
	}

	public Object getDefaultPage() {
		return this._defaultPage;
	}

	public Object getDefaultPage(Object defaultValue) {
		return this._defaultPage == null ? defaultValue : this._defaultPage;
	}

	public boolean hasDefaultPage() {
		return this._defaultPage != null;
	}

	public PaginationElement removeDefaultPage() {
		this._defaultPage = null;
		return this;
	} 

	public PaginationElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public PaginationElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public PaginationElement setGetItemAriaLabel(Object value) {
		this._getItemAriaLabel = value;
		return this;
	}

	public Object getGetItemAriaLabel() {
		return this._getItemAriaLabel;
	}

	public Object getGetItemAriaLabel(Object defaultValue) {
		return this._getItemAriaLabel == null ? defaultValue : this._getItemAriaLabel;
	}

	public boolean hasGetItemAriaLabel() {
		return this._getItemAriaLabel != null;
	}

	public PaginationElement removeGetItemAriaLabel() {
		this._getItemAriaLabel = null;
		return this;
	} 

	public PaginationElement setHideNextButton(Object value) {
		this._hideNextButton = value;
		return this;
	}

	public Object getHideNextButton() {
		return this._hideNextButton;
	}

	public Object getHideNextButton(Object defaultValue) {
		return this._hideNextButton == null ? defaultValue : this._hideNextButton;
	}

	public boolean hasHideNextButton() {
		return this._hideNextButton != null;
	}

	public PaginationElement removeHideNextButton() {
		this._hideNextButton = null;
		return this;
	} 

	public PaginationElement setHidePrevButton(Object value) {
		this._hidePrevButton = value;
		return this;
	}

	public Object getHidePrevButton() {
		return this._hidePrevButton;
	}

	public Object getHidePrevButton(Object defaultValue) {
		return this._hidePrevButton == null ? defaultValue : this._hidePrevButton;
	}

	public boolean hasHidePrevButton() {
		return this._hidePrevButton != null;
	}

	public PaginationElement removeHidePrevButton() {
		this._hidePrevButton = null;
		return this;
	} 

	public PaginationElement setId(Object value) {
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

	public PaginationElement removeId() {
		this._id = null;
		return this;
	} 

	public PaginationElement setKey(Object value) {
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

	public PaginationElement removeKey() {
		this._key = null;
		return this;
	} 

	public PaginationElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public PaginationElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public PaginationElement setPage(Object value) {
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

	public PaginationElement removePage() {
		this._page = null;
		return this;
	} 

	public PaginationElement setRenderItem(Object value) {
		this._renderItem = value;
		return this;
	}

	public Object getRenderItem() {
		return this._renderItem;
	}

	public Object getRenderItem(Object defaultValue) {
		return this._renderItem == null ? defaultValue : this._renderItem;
	}

	public boolean hasRenderItem() {
		return this._renderItem != null;
	}

	public PaginationElement removeRenderItem() {
		this._renderItem = null;
		return this;
	} 

	public PaginationElement setShape(Object value) {
		this._shape = value;
		return this;
	}

	public Object getShape() {
		return this._shape;
	}

	public Object getShape(Object defaultValue) {
		return this._shape == null ? defaultValue : this._shape;
	}

	public boolean hasShape() {
		return this._shape != null;
	}

	public PaginationElement removeShape() {
		this._shape = null;
		return this;
	} 

	public PaginationElement setShowFirstButton(Object value) {
		this._showFirstButton = value;
		return this;
	}

	public Object getShowFirstButton() {
		return this._showFirstButton;
	}

	public Object getShowFirstButton(Object defaultValue) {
		return this._showFirstButton == null ? defaultValue : this._showFirstButton;
	}

	public boolean hasShowFirstButton() {
		return this._showFirstButton != null;
	}

	public PaginationElement removeShowFirstButton() {
		this._showFirstButton = null;
		return this;
	} 

	public PaginationElement setShowLastButton(Object value) {
		this._showLastButton = value;
		return this;
	}

	public Object getShowLastButton() {
		return this._showLastButton;
	}

	public Object getShowLastButton(Object defaultValue) {
		return this._showLastButton == null ? defaultValue : this._showLastButton;
	}

	public boolean hasShowLastButton() {
		return this._showLastButton != null;
	}

	public PaginationElement removeShowLastButton() {
		this._showLastButton = null;
		return this;
	} 

	public PaginationElement setSiblingCount(Object value) {
		this._siblingCount = value;
		return this;
	}

	public Object getSiblingCount() {
		return this._siblingCount;
	}

	public Object getSiblingCount(Object defaultValue) {
		return this._siblingCount == null ? defaultValue : this._siblingCount;
	}

	public boolean hasSiblingCount() {
		return this._siblingCount != null;
	}

	public PaginationElement removeSiblingCount() {
		this._siblingCount = null;
		return this;
	} 

	public PaginationElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public PaginationElement removeSize() {
		this._size = null;
		return this;
	} 

	public PaginationElement setStyle(Object value) {
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

	public PaginationElement removeStyle() {
		this._style = null;
		return this;
	} 

	public PaginationElement setVariant(Object value) {
		this._variant = value;
		return this;
	}

	public Object getVariant() {
		return this._variant;
	}

	public Object getVariant(Object defaultValue) {
		return this._variant == null ? defaultValue : this._variant;
	}

	public boolean hasVariant() {
		return this._variant != null;
	}

	public PaginationElement removeVariant() {
		this._variant = null;
		return this;
	} 


	public PaginationElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public PaginationElement addAttribute(PaginationElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<PaginationElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(PaginationElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(PaginationElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(PaginationElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class PaginationElement_Attribute {

		Object _name;
		Object _value;

		public PaginationElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private PaginationElement_Attribute(java.util.Map<String, Object> map) {
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
		PaginationElement that = (PaginationElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PaginationElement(boundaryCount,classes,className,color,count,defaultPage,disabled,getItemAriaLabel,hideNextButton,hidePrevButton,id,key,onChange,page,renderItem,shape,showFirstButton,showLastButton,siblingCount,size,style,variant,attribute) ::= <<<Pagination~if(boundaryCount)~\n" + 
				"	boundaryCount=~boundaryCount~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(count)~\n" + 
				"	count=~count~~endif~~if(defaultPage)~\n" + 
				"	defaultPage=~defaultPage~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(getItemAriaLabel)~\n" + 
				"	getItemAriaLabel=~getItemAriaLabel~~endif~~if(hideNextButton)~\n" + 
				"	hideNextButton~endif~~if(hidePrevButton)~\n" + 
				"	hidePrevButton~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(page)~\n" + 
				"	page=~page~~endif~~if(renderItem)~\n" + 
				"	renderItem=~renderItem~~endif~~if(shape)~\n" + 
				"	shape=~shape~~endif~~if(showFirstButton)~\n" + 
				"	showFirstButton~endif~~if(showLastButton)~\n" + 
				"	showLastButton~endif~~if(siblingCount)~\n" + 
				"	siblingCount=~siblingCount~~endif~~if(size)~\n" + 
				"	size=~size~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  