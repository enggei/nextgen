package nextgen.templates.html5;

public class Img {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _alt;
	private Object _crossorigin;
	private Object _height;
	private Boolean _ismap;
	private Object _longdesc;
	private Object _src;
	private Object _usemap;
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
	private java.util.List<java.util.Map<String, Object>> _data = new java.util.ArrayList<>();

	Img(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("img");
		st.add("alt", _alt);
		st.add("crossorigin", _crossorigin);
		st.add("height", _height);
		st.add("ismap", _ismap);
		st.add("longdesc", _longdesc);
		st.add("src", _src);
		st.add("usemap", _usemap);
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
		for (java.util.Map<String, Object> map : _data) st.addAggr("data.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public Img setAlt(Object value) {
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

	public Img removeAlt() {
		this._alt = null;
		return this;
	} 

	public Img setCrossorigin(Object value) {
		this._crossorigin = value;
		return this;
	}

	public Object getCrossorigin() {
		return this._crossorigin;
	}

	public Object getCrossorigin(Object defaultValue) {
		return this._crossorigin == null ? defaultValue : this._crossorigin;
	}

	public boolean hasCrossorigin() {
		return this._crossorigin != null;
	}

	public Img removeCrossorigin() {
		this._crossorigin = null;
		return this;
	} 

	public Img setHeight(Object value) {
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

	public Img removeHeight() {
		this._height = null;
		return this;
	} 

	public Img setIsmap(Boolean value) {
		this._ismap = value;
		return this;
	}

	public Boolean getIsmap() {
		return this._ismap;
	}

	public Boolean getIsmap(Boolean defaultValue) {
		return this._ismap == null ? defaultValue : this._ismap;
	}

	public boolean hasIsmap() {
		return this._ismap != null;
	}

	public Img removeIsmap() {
		this._ismap = null;
		return this;
	} 

	public Img setLongdesc(Object value) {
		this._longdesc = value;
		return this;
	}

	public Object getLongdesc() {
		return this._longdesc;
	}

	public Object getLongdesc(Object defaultValue) {
		return this._longdesc == null ? defaultValue : this._longdesc;
	}

	public boolean hasLongdesc() {
		return this._longdesc != null;
	}

	public Img removeLongdesc() {
		this._longdesc = null;
		return this;
	} 

	public Img setSrc(Object value) {
		this._src = value;
		return this;
	}

	public Object getSrc() {
		return this._src;
	}

	public Object getSrc(Object defaultValue) {
		return this._src == null ? defaultValue : this._src;
	}

	public boolean hasSrc() {
		return this._src != null;
	}

	public Img removeSrc() {
		this._src = null;
		return this;
	} 

	public Img setUsemap(Object value) {
		this._usemap = value;
		return this;
	}

	public Object getUsemap() {
		return this._usemap;
	}

	public Object getUsemap(Object defaultValue) {
		return this._usemap == null ? defaultValue : this._usemap;
	}

	public boolean hasUsemap() {
		return this._usemap != null;
	}

	public Img removeUsemap() {
		this._usemap = null;
		return this;
	} 

	public Img setWidth(Object value) {
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

	public Img removeWidth() {
		this._width = null;
		return this;
	} 

	public Img setDatabind(Object value) {
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

	public Img removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Img setAccesskey(Object value) {
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

	public Img removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Img set_class(Object value) {
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

	public Img remove_class() {
		this.__class = null;
		return this;
	} 

	public Img setContenteditable(Object value) {
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

	public Img removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Img setContextmenu(Object value) {
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

	public Img removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Img setDir(Object value) {
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

	public Img removeDir() {
		this._dir = null;
		return this;
	} 

	public Img setDraggable(Object value) {
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

	public Img removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Img setDropzone(Object value) {
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

	public Img removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Img setHidden(Object value) {
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

	public Img removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Img setId(Object value) {
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

	public Img removeId() {
		this._id = null;
		return this;
	} 

	public Img setLang(Object value) {
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

	public Img removeLang() {
		this._lang = null;
		return this;
	} 

	public Img setSpellcheck(Object value) {
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

	public Img removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Img setStyle(Object value) {
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

	public Img removeStyle() {
		this._style = null;
		return this;
	} 

	public Img setTabindex(Object value) {
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

	public Img removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Img setTitle(Object value) {
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

	public Img removeTitle() {
		this._title = null;
		return this;
	} 

	public Img setTranslate(Object value) {
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

	public Img removeTranslate() {
		this._translate = null;
		return this;
	} 


	public Img addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Img addData(Img_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Img_Data> streamData() {
		return this._data.stream().map(Img_Data::new);
	}

	public static final class Img_Data {

		Object _name;
		Object _value;

		public Img_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Img_Data(java.util.Map<String, Object> map) {
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
		Img that = (Img) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "img(alt,crossorigin,height,ismap,longdesc,src,usemap,width,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data) ::= <<<img~if(alt)~ alt=\"~alt~\"~endif~~if(crossorigin)~ crossorigin=\"~crossorigin~\"~endif~~if(height)~ height=\"~height~\"~endif~~if(ismap)~ ismap=\"~ismap~\"~endif~~if(longdesc)~ longdesc=\"~longdesc~\"~endif~~if(src)~ src=\"~src~\"~endif~~if(usemap)~ usemap=\"~usemap~\"~endif~~if(width)~ width=\"~width~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~> >>";
}  