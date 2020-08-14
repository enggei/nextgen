package nextgen.templates.materialui;

public class GridListTileBarElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _actionIcon;
	private Object _actionPosition;
	private Object _classes;
	private Object _className;
	private Object _id;
	private Object _subtitle;
	private Object _title;
	private Object _titlePosition;

	GridListTileBarElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridListTileBarElement");
		st.add("actionIcon", _actionIcon);
		st.add("actionPosition", _actionPosition);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("id", _id);
		st.add("subtitle", _subtitle);
		st.add("title", _title);
		st.add("titlePosition", _titlePosition);
		return st.render().trim();
	}

	public GridListTileBarElement setActionIcon(Object value) {
		this._actionIcon = value;
		return this;
	}

	public Object getActionIcon() {
		return this._actionIcon;
	}

	public Object getActionIcon(Object defaultValue) {
		return this._actionIcon == null ? defaultValue : this._actionIcon;
	}

	public boolean hasActionIcon() {
		return this._actionIcon != null;
	}

	public GridListTileBarElement removeActionIcon() {
		this._actionIcon = null;
		return this;
	} 

	public GridListTileBarElement setActionPosition(Object value) {
		this._actionPosition = value;
		return this;
	}

	public Object getActionPosition() {
		return this._actionPosition;
	}

	public Object getActionPosition(Object defaultValue) {
		return this._actionPosition == null ? defaultValue : this._actionPosition;
	}

	public boolean hasActionPosition() {
		return this._actionPosition != null;
	}

	public GridListTileBarElement removeActionPosition() {
		this._actionPosition = null;
		return this;
	} 

	public GridListTileBarElement setClasses(Object value) {
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

	public GridListTileBarElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public GridListTileBarElement setClassName(Object value) {
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

	public GridListTileBarElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridListTileBarElement setId(Object value) {
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

	public GridListTileBarElement removeId() {
		this._id = null;
		return this;
	} 

	public GridListTileBarElement setSubtitle(Object value) {
		this._subtitle = value;
		return this;
	}

	public Object getSubtitle() {
		return this._subtitle;
	}

	public Object getSubtitle(Object defaultValue) {
		return this._subtitle == null ? defaultValue : this._subtitle;
	}

	public boolean hasSubtitle() {
		return this._subtitle != null;
	}

	public GridListTileBarElement removeSubtitle() {
		this._subtitle = null;
		return this;
	} 

	public GridListTileBarElement setTitle(Object value) {
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

	public GridListTileBarElement removeTitle() {
		this._title = null;
		return this;
	} 

	public GridListTileBarElement setTitlePosition(Object value) {
		this._titlePosition = value;
		return this;
	}

	public Object getTitlePosition() {
		return this._titlePosition;
	}

	public Object getTitlePosition(Object defaultValue) {
		return this._titlePosition == null ? defaultValue : this._titlePosition;
	}

	public boolean hasTitlePosition() {
		return this._titlePosition != null;
	}

	public GridListTileBarElement removeTitlePosition() {
		this._titlePosition = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GridListTileBarElement that = (GridListTileBarElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridListTileBarElement(actionIcon,actionPosition,classes,className,id,subtitle,title,titlePosition) ::= <<<GridListTileBar~if(actionIcon)~\n" + 
				"	actionIcon=~actionIcon~~endif~~if(actionPosition)~\n" + 
				"	actionPosition=\"~actionPosition~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(subtitle)~\n" + 
				"	subtitle=~subtitle~~endif~~if(title)~\n" + 
				"	title=~title~~endif~~if(titlePosition)~\n" + 
				"	titlePosition=\"~titlePosition~\"~endif~ /> >>";
}  