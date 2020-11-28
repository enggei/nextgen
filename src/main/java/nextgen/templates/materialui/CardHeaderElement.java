package nextgen.templates.materialui;

public class CardHeaderElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _avatar;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disableTypography;
	private Object _id;
	private Object _key;
	private Object _style;
	private Object _subheader;
	private Object _subheaderTypographyProps;
	private Object _title;
	private Object _titleTypographyProps;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	CardHeaderElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardHeaderElement");
		st.add("action", _action);
		st.add("avatar", _avatar);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disableTypography", _disableTypography);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		st.add("subheader", _subheader);
		st.add("subheaderTypographyProps", _subheaderTypographyProps);
		st.add("title", _title);
		st.add("titleTypographyProps", _titleTypographyProps);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public CardHeaderElement setAction(Object value) {
		this._action = value;
		return this;
	}

	public Object getAction() {
		return this._action;
	}

	public Object getAction(Object defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public CardHeaderElement removeAction() {
		this._action = null;
		return this;
	} 

	public CardHeaderElement setAvatar(Object value) {
		this._avatar = value;
		return this;
	}

	public Object getAvatar() {
		return this._avatar;
	}

	public Object getAvatar(Object defaultValue) {
		return this._avatar == null ? defaultValue : this._avatar;
	}

	public boolean hasAvatar() {
		return this._avatar != null;
	}

	public CardHeaderElement removeAvatar() {
		this._avatar = null;
		return this;
	} 

	public CardHeaderElement setClasses(Object value) {
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

	public CardHeaderElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CardHeaderElement setClassName(Object value) {
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

	public CardHeaderElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CardHeaderElement setComponent(Object value) {
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

	public CardHeaderElement removeComponent() {
		this._component = null;
		return this;
	} 

	public CardHeaderElement setDisableTypography(Object value) {
		this._disableTypography = value;
		return this;
	}

	public Object getDisableTypography() {
		return this._disableTypography;
	}

	public Object getDisableTypography(Object defaultValue) {
		return this._disableTypography == null ? defaultValue : this._disableTypography;
	}

	public boolean hasDisableTypography() {
		return this._disableTypography != null;
	}

	public CardHeaderElement removeDisableTypography() {
		this._disableTypography = null;
		return this;
	} 

	public CardHeaderElement setId(Object value) {
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

	public CardHeaderElement removeId() {
		this._id = null;
		return this;
	} 

	public CardHeaderElement setKey(Object value) {
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

	public CardHeaderElement removeKey() {
		this._key = null;
		return this;
	} 

	public CardHeaderElement setStyle(Object value) {
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

	public CardHeaderElement removeStyle() {
		this._style = null;
		return this;
	} 

	public CardHeaderElement setSubheader(Object value) {
		this._subheader = value;
		return this;
	}

	public Object getSubheader() {
		return this._subheader;
	}

	public Object getSubheader(Object defaultValue) {
		return this._subheader == null ? defaultValue : this._subheader;
	}

	public boolean hasSubheader() {
		return this._subheader != null;
	}

	public CardHeaderElement removeSubheader() {
		this._subheader = null;
		return this;
	} 

	public CardHeaderElement setSubheaderTypographyProps(Object value) {
		this._subheaderTypographyProps = value;
		return this;
	}

	public Object getSubheaderTypographyProps() {
		return this._subheaderTypographyProps;
	}

	public Object getSubheaderTypographyProps(Object defaultValue) {
		return this._subheaderTypographyProps == null ? defaultValue : this._subheaderTypographyProps;
	}

	public boolean hasSubheaderTypographyProps() {
		return this._subheaderTypographyProps != null;
	}

	public CardHeaderElement removeSubheaderTypographyProps() {
		this._subheaderTypographyProps = null;
		return this;
	} 

	public CardHeaderElement setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public CardHeaderElement removeTitle() {
		this._title = null;
		return this;
	} 

	public CardHeaderElement setTitleTypographyProps(Object value) {
		this._titleTypographyProps = value;
		return this;
	}

	public Object getTitleTypographyProps() {
		return this._titleTypographyProps;
	}

	public Object getTitleTypographyProps(Object defaultValue) {
		return this._titleTypographyProps == null ? defaultValue : this._titleTypographyProps;
	}

	public boolean hasTitleTypographyProps() {
		return this._titleTypographyProps != null;
	}

	public CardHeaderElement removeTitleTypographyProps() {
		this._titleTypographyProps = null;
		return this;
	} 


	public CardHeaderElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public CardHeaderElement addAttribute(CardHeaderElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<CardHeaderElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(CardHeaderElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(CardHeaderElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(CardHeaderElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class CardHeaderElement_Attribute {

		Object _name;
		Object _value;

		public CardHeaderElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private CardHeaderElement_Attribute(java.util.Map<String, Object> map) {
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
		CardHeaderElement that = (CardHeaderElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CardHeaderElement(action,avatar,classes,className,component,disableTypography,id,key,style,subheader,subheaderTypographyProps,title,titleTypographyProps,attribute) ::= <<<CardHeader~if(action)~\n" + 
				"	action=~action~~endif~~if(avatar)~\n" + 
				"	avatar=~avatar~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableTypography)~\n" + 
				"	disableTypography~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(subheader)~\n" + 
				"	subheader=~subheader~~endif~~if(subheaderTypographyProps)~\n" + 
				"	subheaderTypographyProps=~subheaderTypographyProps~~endif~~if(title)~\n" + 
				"	title=~title~~endif~~if(titleTypographyProps)~\n" + 
				"	titleTypographyProps=~titleTypographyProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  