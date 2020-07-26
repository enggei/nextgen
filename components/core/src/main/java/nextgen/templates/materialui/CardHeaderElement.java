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
	private Object _subheader;
	private Object _subheaderTypographyProps;
	private Object _title;
	private Object _titleTypographyProps;

	CardHeaderElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
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
		st.add("subheader", _subheader);
		st.add("subheaderTypographyProps", _subheaderTypographyProps);
		st.add("title", _title);
		st.add("titleTypographyProps", _titleTypographyProps);
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

	static final String st = "CardHeaderElement(action,avatar,classes,className,component,disableTypography,subheader,subheaderTypographyProps,title,titleTypographyProps) ::= <<<CardHeader~if(action)~\n" + 
				"	action=~action~~endif~~if(avatar)~\n" + 
				"	avatar=~avatar~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableTypography)~\n" + 
				"	disableTypography~endif~~if(subheader)~\n" + 
				"	subheader=~subheader~~endif~~if(subheaderTypographyProps)~\n" + 
				"	subheaderTypographyProps=~subheaderTypographyProps~~endif~~if(title)~\n" + 
				"	title=~title~~endif~~if(titleTypographyProps)~\n" + 
				"	titleTypographyProps=~titleTypographyProps~~endif~ /> >>";
}  