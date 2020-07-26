package nextgen.templates.html5;

public class Applet {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _align;
	private Object _alt;
	private Object _archive;
	private Object _code;
	private Object _codebase;
	private Object _height;
	private Object _hspace;
	private Object _name;
	private Object __object;
	private Object _vspace;
	private Object _width;
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

	Applet(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("applet");
		st.add("align", _align);
		st.add("alt", _alt);
		st.add("archive", _archive);
		st.add("code", _code);
		st.add("codebase", _codebase);
		st.add("height", _height);
		st.add("hspace", _hspace);
		st.add("name", _name);
		st.add("_object", __object);
		st.add("vspace", _vspace);
		st.add("width", _width);
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

	public Applet setAlign(Object value) {
		this._align = value;
		return this;
	}

	public Object getAlign() {
		return this._align;
	}

	public Object getAlign(Object defaultValue) {
		return this._align == null ? defaultValue : this._align;
	}

	public boolean hasAlign() {
		return this._align != null;
	}

	public Applet removeAlign() {
		this._align = null;
		return this;
	} 

	public Applet setAlt(Object value) {
		this._alt = value;
		return this;
	}

	public Object getAlt() {
		return this._alt;
	}

	public Object getAlt(Object defaultValue) {
		return this._alt == null ? defaultValue : this._alt;
	}

	public boolean hasAlt() {
		return this._alt != null;
	}

	public Applet removeAlt() {
		this._alt = null;
		return this;
	} 

	public Applet setArchive(Object value) {
		this._archive = value;
		return this;
	}

	public Object getArchive() {
		return this._archive;
	}

	public Object getArchive(Object defaultValue) {
		return this._archive == null ? defaultValue : this._archive;
	}

	public boolean hasArchive() {
		return this._archive != null;
	}

	public Applet removeArchive() {
		this._archive = null;
		return this;
	} 

	public Applet setCode(Object value) {
		this._code = value;
		return this;
	}

	public Object getCode() {
		return this._code;
	}

	public Object getCode(Object defaultValue) {
		return this._code == null ? defaultValue : this._code;
	}

	public boolean hasCode() {
		return this._code != null;
	}

	public Applet removeCode() {
		this._code = null;
		return this;
	} 

	public Applet setCodebase(Object value) {
		this._codebase = value;
		return this;
	}

	public Object getCodebase() {
		return this._codebase;
	}

	public Object getCodebase(Object defaultValue) {
		return this._codebase == null ? defaultValue : this._codebase;
	}

	public boolean hasCodebase() {
		return this._codebase != null;
	}

	public Applet removeCodebase() {
		this._codebase = null;
		return this;
	} 

	public Applet setHeight(Object value) {
		this._height = value;
		return this;
	}

	public Object getHeight() {
		return this._height;
	}

	public Object getHeight(Object defaultValue) {
		return this._height == null ? defaultValue : this._height;
	}

	public boolean hasHeight() {
		return this._height != null;
	}

	public Applet removeHeight() {
		this._height = null;
		return this;
	} 

	public Applet setHspace(Object value) {
		this._hspace = value;
		return this;
	}

	public Object getHspace() {
		return this._hspace;
	}

	public Object getHspace(Object defaultValue) {
		return this._hspace == null ? defaultValue : this._hspace;
	}

	public boolean hasHspace() {
		return this._hspace != null;
	}

	public Applet removeHspace() {
		this._hspace = null;
		return this;
	} 

	public Applet setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Applet removeName() {
		this._name = null;
		return this;
	} 

	public Applet set_object(Object value) {
		this.__object = value;
		return this;
	}

	public Object get_object() {
		return this.__object;
	}

	public Object get_object(Object defaultValue) {
		return this.__object == null ? defaultValue : this.__object;
	}

	public boolean has_object() {
		return this.__object != null;
	}

	public Applet remove_object() {
		this.__object = null;
		return this;
	} 

	public Applet setVspace(Object value) {
		this._vspace = value;
		return this;
	}

	public Object getVspace() {
		return this._vspace;
	}

	public Object getVspace(Object defaultValue) {
		return this._vspace == null ? defaultValue : this._vspace;
	}

	public boolean hasVspace() {
		return this._vspace != null;
	}

	public Applet removeVspace() {
		this._vspace = null;
		return this;
	} 

	public Applet setWidth(Object value) {
		this._width = value;
		return this;
	}

	public Object getWidth() {
		return this._width;
	}

	public Object getWidth(Object defaultValue) {
		return this._width == null ? defaultValue : this._width;
	}

	public boolean hasWidth() {
		return this._width != null;
	}

	public Applet removeWidth() {
		this._width = null;
		return this;
	} 

	public Applet setDatabind(Object value) {
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

	public Applet removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Applet setAccesskey(Object value) {
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

	public Applet removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Applet set_class(Object value) {
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

	public Applet remove_class() {
		this.__class = null;
		return this;
	} 

	public Applet setContenteditable(Object value) {
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

	public Applet removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Applet setContextmenu(Object value) {
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

	public Applet removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Applet setDir(Object value) {
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

	public Applet removeDir() {
		this._dir = null;
		return this;
	} 

	public Applet setDraggable(Object value) {
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

	public Applet removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Applet setDropzone(Object value) {
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

	public Applet removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Applet setHidden(Object value) {
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

	public Applet removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Applet setId(Object value) {
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

	public Applet removeId() {
		this._id = null;
		return this;
	} 

	public Applet setLang(Object value) {
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

	public Applet removeLang() {
		this._lang = null;
		return this;
	} 

	public Applet setSpellcheck(Object value) {
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

	public Applet removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Applet setStyle(Object value) {
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

	public Applet removeStyle() {
		this._style = null;
		return this;
	} 

	public Applet setTabindex(Object value) {
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

	public Applet removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Applet setTitle(Object value) {
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

	public Applet removeTitle() {
		this._title = null;
		return this;
	} 

	public Applet setTranslate(Object value) {
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

	public Applet removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Applet addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Applet setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Applet setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Applet removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Applet removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Applet addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Applet addData(Applet_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Applet_Data> streamData() {
		return this._data.stream().map(Applet_Data::new);
	}

	public static final class Applet_Data {

		Object _name;
		Object _value;

		public Applet_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Applet_Data(java.util.Map<String, Object> map) {
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
		Applet that = (Applet) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "applet(align,alt,archive,code,codebase,height,hspace,name,_object,vspace,width,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<applet~if(align)~ align=\"~align~\"~endif~~if(alt)~ alt=\"~alt~\"~endif~~if(archive)~ archive=\"~archive~\"~endif~~if(code)~ code=\"~code~\"~endif~~if(codebase)~ codebase=\"~codebase~\"~endif~~if(height)~ height=\"~height~\"~endif~~if(hspace)~ hspace=\"~hspace~\"~endif~~if(name)~ name=\"~name~\"~endif~~if(_object)~ object=\"~_object~\"~endif~~if(vspace)~ vspace=\"~vspace~\"~endif~~if(width)~ width=\"~width~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</applet >>";
}  