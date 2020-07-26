package nextgen.templates.html5;

public class Menuitem {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _checked;
	private Object _command;
	private Object _default_;
	private Object _disabled;
	private Object _icon;
	private Object _label;
	private Object _radiogroup;
	private Object _type;
	private Object _databind;
	private Object _accesskey;
	private Object __class;
	private Object _contenteditable;
	private Object _contextmenu;
	private Object _dir;
	private Object _draggable;
	private Object _dropzone;
	private Object _hidden;
	private Object _id;
	private Object _lang;
	private Object _spellcheck;
	private Object _style;
	private Object _tabindex;
	private Object _title;
	private Object _translate;
	private java.util.List<Object> _content = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _data = new java.util.ArrayList<>();

	Menuitem(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("menuitem");
		st.add("checked", _checked);
		st.add("command", _command);
		st.add("default_", _default_);
		st.add("disabled", _disabled);
		st.add("icon", _icon);
		st.add("label", _label);
		st.add("radiogroup", _radiogroup);
		st.add("type", _type);
		st.add("databind", _databind);
		st.add("accesskey", _accesskey);
		st.add("_class", __class);
		st.add("contenteditable", _contenteditable);
		st.add("contextmenu", _contextmenu);
		st.add("dir", _dir);
		st.add("draggable", _draggable);
		st.add("dropzone", _dropzone);
		st.add("hidden", _hidden);
		st.add("id", _id);
		st.add("lang", _lang);
		st.add("spellcheck", _spellcheck);
		st.add("style", _style);
		st.add("tabindex", _tabindex);
		st.add("title", _title);
		st.add("translate", _translate);
		for (Object o : _content) st.add("content", o);
		for (java.util.Map<String, Object> map : _data) st.addAggr("data.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public Menuitem setChecked(Object value) {
		this._checked = value;
		return this;
	}

	public Object getChecked() {
		return this._checked;
	}

	public Object getChecked(Object defaultValue) {
		return this._checked == null ? defaultValue : this._checked;
	}

	public boolean hasChecked() {
		return this._checked != null;
	}

	public Menuitem removeChecked() {
		this._checked = null;
		return this;
	} 

	public Menuitem setCommand(Object value) {
		this._command = value;
		return this;
	}

	public Object getCommand() {
		return this._command;
	}

	public Object getCommand(Object defaultValue) {
		return this._command == null ? defaultValue : this._command;
	}

	public boolean hasCommand() {
		return this._command != null;
	}

	public Menuitem removeCommand() {
		this._command = null;
		return this;
	} 

	public Menuitem setDefault_(Object value) {
		this._default_ = value;
		return this;
	}

	public Object getDefault_() {
		return this._default_;
	}

	public Object getDefault_(Object defaultValue) {
		return this._default_ == null ? defaultValue : this._default_;
	}

	public boolean hasDefault_() {
		return this._default_ != null;
	}

	public Menuitem removeDefault_() {
		this._default_ = null;
		return this;
	} 

	public Menuitem setDisabled(Object value) {
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

	public Menuitem removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public Menuitem setIcon(Object value) {
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

	public Menuitem removeIcon() {
		this._icon = null;
		return this;
	} 

	public Menuitem setLabel(Object value) {
		this._label = value;
		return this;
	}

	public Object getLabel() {
		return this._label;
	}

	public Object getLabel(Object defaultValue) {
		return this._label == null ? defaultValue : this._label;
	}

	public boolean hasLabel() {
		return this._label != null;
	}

	public Menuitem removeLabel() {
		this._label = null;
		return this;
	} 

	public Menuitem setRadiogroup(Object value) {
		this._radiogroup = value;
		return this;
	}

	public Object getRadiogroup() {
		return this._radiogroup;
	}

	public Object getRadiogroup(Object defaultValue) {
		return this._radiogroup == null ? defaultValue : this._radiogroup;
	}

	public boolean hasRadiogroup() {
		return this._radiogroup != null;
	}

	public Menuitem removeRadiogroup() {
		this._radiogroup = null;
		return this;
	} 

	public Menuitem setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public Menuitem removeType() {
		this._type = null;
		return this;
	} 

	public Menuitem setDatabind(Object value) {
		this._databind = value;
		return this;
	}

	public Object getDatabind() {
		return this._databind;
	}

	public Object getDatabind(Object defaultValue) {
		return this._databind == null ? defaultValue : this._databind;
	}

	public boolean hasDatabind() {
		return this._databind != null;
	}

	public Menuitem removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Menuitem setAccesskey(Object value) {
		this._accesskey = value;
		return this;
	}

	public Object getAccesskey() {
		return this._accesskey;
	}

	public Object getAccesskey(Object defaultValue) {
		return this._accesskey == null ? defaultValue : this._accesskey;
	}

	public boolean hasAccesskey() {
		return this._accesskey != null;
	}

	public Menuitem removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Menuitem set_class(Object value) {
		this.__class = value;
		return this;
	}

	public Object get_class() {
		return this.__class;
	}

	public Object get_class(Object defaultValue) {
		return this.__class == null ? defaultValue : this.__class;
	}

	public boolean has_class() {
		return this.__class != null;
	}

	public Menuitem remove_class() {
		this.__class = null;
		return this;
	} 

	public Menuitem setContenteditable(Object value) {
		this._contenteditable = value;
		return this;
	}

	public Object getContenteditable() {
		return this._contenteditable;
	}

	public Object getContenteditable(Object defaultValue) {
		return this._contenteditable == null ? defaultValue : this._contenteditable;
	}

	public boolean hasContenteditable() {
		return this._contenteditable != null;
	}

	public Menuitem removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Menuitem setContextmenu(Object value) {
		this._contextmenu = value;
		return this;
	}

	public Object getContextmenu() {
		return this._contextmenu;
	}

	public Object getContextmenu(Object defaultValue) {
		return this._contextmenu == null ? defaultValue : this._contextmenu;
	}

	public boolean hasContextmenu() {
		return this._contextmenu != null;
	}

	public Menuitem removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Menuitem setDir(Object value) {
		this._dir = value;
		return this;
	}

	public Object getDir() {
		return this._dir;
	}

	public Object getDir(Object defaultValue) {
		return this._dir == null ? defaultValue : this._dir;
	}

	public boolean hasDir() {
		return this._dir != null;
	}

	public Menuitem removeDir() {
		this._dir = null;
		return this;
	} 

	public Menuitem setDraggable(Object value) {
		this._draggable = value;
		return this;
	}

	public Object getDraggable() {
		return this._draggable;
	}

	public Object getDraggable(Object defaultValue) {
		return this._draggable == null ? defaultValue : this._draggable;
	}

	public boolean hasDraggable() {
		return this._draggable != null;
	}

	public Menuitem removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Menuitem setDropzone(Object value) {
		this._dropzone = value;
		return this;
	}

	public Object getDropzone() {
		return this._dropzone;
	}

	public Object getDropzone(Object defaultValue) {
		return this._dropzone == null ? defaultValue : this._dropzone;
	}

	public boolean hasDropzone() {
		return this._dropzone != null;
	}

	public Menuitem removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Menuitem setHidden(Object value) {
		this._hidden = value;
		return this;
	}

	public Object getHidden() {
		return this._hidden;
	}

	public Object getHidden(Object defaultValue) {
		return this._hidden == null ? defaultValue : this._hidden;
	}

	public boolean hasHidden() {
		return this._hidden != null;
	}

	public Menuitem removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Menuitem setId(Object value) {
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

	public Menuitem removeId() {
		this._id = null;
		return this;
	} 

	public Menuitem setLang(Object value) {
		this._lang = value;
		return this;
	}

	public Object getLang() {
		return this._lang;
	}

	public Object getLang(Object defaultValue) {
		return this._lang == null ? defaultValue : this._lang;
	}

	public boolean hasLang() {
		return this._lang != null;
	}

	public Menuitem removeLang() {
		this._lang = null;
		return this;
	} 

	public Menuitem setSpellcheck(Object value) {
		this._spellcheck = value;
		return this;
	}

	public Object getSpellcheck() {
		return this._spellcheck;
	}

	public Object getSpellcheck(Object defaultValue) {
		return this._spellcheck == null ? defaultValue : this._spellcheck;
	}

	public boolean hasSpellcheck() {
		return this._spellcheck != null;
	}

	public Menuitem removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Menuitem setStyle(Object value) {
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

	public Menuitem removeStyle() {
		this._style = null;
		return this;
	} 

	public Menuitem setTabindex(Object value) {
		this._tabindex = value;
		return this;
	}

	public Object getTabindex() {
		return this._tabindex;
	}

	public Object getTabindex(Object defaultValue) {
		return this._tabindex == null ? defaultValue : this._tabindex;
	}

	public boolean hasTabindex() {
		return this._tabindex != null;
	}

	public Menuitem removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Menuitem setTitle(Object value) {
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

	public Menuitem removeTitle() {
		this._title = null;
		return this;
	} 

	public Menuitem setTranslate(Object value) {
		this._translate = value;
		return this;
	}

	public Object getTranslate() {
		return this._translate;
	}

	public Object getTranslate(Object defaultValue) {
		return this._translate == null ? defaultValue : this._translate;
	}

	public boolean hasTranslate() {
		return this._translate != null;
	}

	public Menuitem removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Menuitem addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Menuitem setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Menuitem setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Menuitem removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Menuitem removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Menuitem addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Menuitem addData(Menuitem_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Menuitem_Data> streamData() {
		return this._data.stream().map(Menuitem_Data::new);
	}

	public static final class Menuitem_Data {

		Object _name;
		Object _value;

		public Menuitem_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Menuitem_Data(java.util.Map<String, Object> map) {
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
		Menuitem that = (Menuitem) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "menuitem(checked,command,default_,disabled,icon,label,radiogroup,type,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<menuitem~if(checked)~ checked=\"~checked~\"~endif~~if(command)~ command=\"~command~\"~endif~~if(default_)~ default_=\"~default_~\"~endif~~if(disabled)~ disabled=\"~disabled~\"~endif~~if(icon)~ icon=\"~icon~\"~endif~~if(label)~ label=\"~label~\"~endif~~if(radiogroup)~ radiogroup=\"~radiogroup~\"~endif~~if(type)~ type=\"~type~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</menuitem> >>";
}  