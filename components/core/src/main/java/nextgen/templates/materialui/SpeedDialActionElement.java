package nextgen.templates.materialui;

public class SpeedDialActionElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _delay;
	private Object _FabProps;
	private Object _icon;
	private Object _id;
	private Object _open;
	private Object _TooltipClasses;
	private Object _tooltipOpen;
	private Object _tooltipPlacement;
	private Object _tooltipTitle;

	SpeedDialActionElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SpeedDialActionElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("delay", _delay);
		st.add("FabProps", _FabProps);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("open", _open);
		st.add("TooltipClasses", _TooltipClasses);
		st.add("tooltipOpen", _tooltipOpen);
		st.add("tooltipPlacement", _tooltipPlacement);
		st.add("tooltipTitle", _tooltipTitle);
		return st.render().trim();
	}

	public SpeedDialActionElement setClasses(Object value) {
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

	public SpeedDialActionElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SpeedDialActionElement setClassName(Object value) {
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

	public SpeedDialActionElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SpeedDialActionElement setDelay(Object value) {
		this._delay = value;
		return this;
	}

	public Object getDelay() {
		return this._delay;
	}

	public Object getDelay(Object defaultValue) {
		return this._delay == null ? defaultValue : this._delay;
	}

	public boolean hasDelay() {
		return this._delay != null;
	}

	public SpeedDialActionElement removeDelay() {
		this._delay = null;
		return this;
	} 

	public SpeedDialActionElement setFabProps(Object value) {
		this._FabProps = value;
		return this;
	}

	public Object getFabProps() {
		return this._FabProps;
	}

	public Object getFabProps(Object defaultValue) {
		return this._FabProps == null ? defaultValue : this._FabProps;
	}

	public boolean hasFabProps() {
		return this._FabProps != null;
	}

	public SpeedDialActionElement removeFabProps() {
		this._FabProps = null;
		return this;
	} 

	public SpeedDialActionElement setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public SpeedDialActionElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public SpeedDialActionElement setId(Object value) {
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

	public SpeedDialActionElement removeId() {
		this._id = null;
		return this;
	} 

	public SpeedDialActionElement setOpen(Object value) {
		this._open = value;
		return this;
	}

	public Object getOpen() {
		return this._open;
	}

	public Object getOpen(Object defaultValue) {
		return this._open == null ? defaultValue : this._open;
	}

	public boolean hasOpen() {
		return this._open != null;
	}

	public SpeedDialActionElement removeOpen() {
		this._open = null;
		return this;
	} 

	public SpeedDialActionElement setTooltipClasses(Object value) {
		this._TooltipClasses = value;
		return this;
	}

	public Object getTooltipClasses() {
		return this._TooltipClasses;
	}

	public Object getTooltipClasses(Object defaultValue) {
		return this._TooltipClasses == null ? defaultValue : this._TooltipClasses;
	}

	public boolean hasTooltipClasses() {
		return this._TooltipClasses != null;
	}

	public SpeedDialActionElement removeTooltipClasses() {
		this._TooltipClasses = null;
		return this;
	} 

	public SpeedDialActionElement setTooltipOpen(Object value) {
		this._tooltipOpen = value;
		return this;
	}

	public Object getTooltipOpen() {
		return this._tooltipOpen;
	}

	public Object getTooltipOpen(Object defaultValue) {
		return this._tooltipOpen == null ? defaultValue : this._tooltipOpen;
	}

	public boolean hasTooltipOpen() {
		return this._tooltipOpen != null;
	}

	public SpeedDialActionElement removeTooltipOpen() {
		this._tooltipOpen = null;
		return this;
	} 

	public SpeedDialActionElement setTooltipPlacement(Object value) {
		this._tooltipPlacement = value;
		return this;
	}

	public Object getTooltipPlacement() {
		return this._tooltipPlacement;
	}

	public Object getTooltipPlacement(Object defaultValue) {
		return this._tooltipPlacement == null ? defaultValue : this._tooltipPlacement;
	}

	public boolean hasTooltipPlacement() {
		return this._tooltipPlacement != null;
	}

	public SpeedDialActionElement removeTooltipPlacement() {
		this._tooltipPlacement = null;
		return this;
	} 

	public SpeedDialActionElement setTooltipTitle(Object value) {
		this._tooltipTitle = value;
		return this;
	}

	public Object getTooltipTitle() {
		return this._tooltipTitle;
	}

	public Object getTooltipTitle(Object defaultValue) {
		return this._tooltipTitle == null ? defaultValue : this._tooltipTitle;
	}

	public boolean hasTooltipTitle() {
		return this._tooltipTitle != null;
	}

	public SpeedDialActionElement removeTooltipTitle() {
		this._tooltipTitle = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpeedDialActionElement that = (SpeedDialActionElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SpeedDialActionElement(classes,className,delay,FabProps,icon,id,open,TooltipClasses,tooltipOpen,tooltipPlacement,tooltipTitle) ::= <<<SpeedDialAction~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(delay)~\n" + 
				"	delay=~delay~~endif~~if(FabProps)~\n" + 
				"	FabProps=~FabProps~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(open)~\n" + 
				"	open~endif~~if(TooltipClasses)~\n" + 
				"	TooltipClasses=~TooltipClasses~~endif~~if(tooltipOpen)~\n" + 
				"	tooltipOpen~endif~~if(tooltipPlacement)~\n" + 
				"	tooltipPlacement=\"~tooltipPlacement~\"~endif~~if(tooltipTitle)~\n" + 
				"	tooltipTitle=~tooltipTitle~~endif~ /> >>";
}  