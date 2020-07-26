package nextgen.templates.html5;

public class Area {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _alt;
	private Object _coords;
	private Object _download;
	private Object _href;
	private Object _hreflang;
	private Object _media;
	private Object _rel;
	private Object _shape;
	private Object _target;
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
	private java.util.List<java.util.Map<String, Object>> _data = new java.util.ArrayList<>();

	Area(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("area");
		st.add("alt", _alt);
		st.add("coords", _coords);
		st.add("download", _download);
		st.add("href", _href);
		st.add("hreflang", _hreflang);
		st.add("media", _media);
		st.add("rel", _rel);
		st.add("shape", _shape);
		st.add("target", _target);
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
		for (java.util.Map<String, Object> map : _data) st.addAggr("data.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public Area setAlt(Object value) {
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

	public Area removeAlt() {
		this._alt = null;
		return this;
	} 

	public Area setCoords(Object value) {
		this._coords = value;
		return this;
	}

	public Object getCoords() {
		return this._coords;
	}

	public Object getCoords(Object defaultValue) {
		return this._coords == null ? defaultValue : this._coords;
	}

	public boolean hasCoords() {
		return this._coords != null;
	}

	public Area removeCoords() {
		this._coords = null;
		return this;
	} 

	public Area setDownload(Object value) {
		this._download = value;
		return this;
	}

	public Object getDownload() {
		return this._download;
	}

	public Object getDownload(Object defaultValue) {
		return this._download == null ? defaultValue : this._download;
	}

	public boolean hasDownload() {
		return this._download != null;
	}

	public Area removeDownload() {
		this._download = null;
		return this;
	} 

	public Area setHref(Object value) {
		this._href = value;
		return this;
	}

	public Object getHref() {
		return this._href;
	}

	public Object getHref(Object defaultValue) {
		return this._href == null ? defaultValue : this._href;
	}

	public boolean hasHref() {
		return this._href != null;
	}

	public Area removeHref() {
		this._href = null;
		return this;
	} 

	public Area setHreflang(Object value) {
		this._hreflang = value;
		return this;
	}

	public Object getHreflang() {
		return this._hreflang;
	}

	public Object getHreflang(Object defaultValue) {
		return this._hreflang == null ? defaultValue : this._hreflang;
	}

	public boolean hasHreflang() {
		return this._hreflang != null;
	}

	public Area removeHreflang() {
		this._hreflang = null;
		return this;
	} 

	public Area setMedia(Object value) {
		this._media = value;
		return this;
	}

	public Object getMedia() {
		return this._media;
	}

	public Object getMedia(Object defaultValue) {
		return this._media == null ? defaultValue : this._media;
	}

	public boolean hasMedia() {
		return this._media != null;
	}

	public Area removeMedia() {
		this._media = null;
		return this;
	} 

	public Area setRel(Object value) {
		this._rel = value;
		return this;
	}

	public Object getRel() {
		return this._rel;
	}

	public Object getRel(Object defaultValue) {
		return this._rel == null ? defaultValue : this._rel;
	}

	public boolean hasRel() {
		return this._rel != null;
	}

	public Area removeRel() {
		this._rel = null;
		return this;
	} 

	public Area setShape(Object value) {
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

	public Area removeShape() {
		this._shape = null;
		return this;
	} 

	public Area setTarget(Object value) {
		this._target = value;
		return this;
	}

	public Object getTarget() {
		return this._target;
	}

	public Object getTarget(Object defaultValue) {
		return this._target == null ? defaultValue : this._target;
	}

	public boolean hasTarget() {
		return this._target != null;
	}

	public Area removeTarget() {
		this._target = null;
		return this;
	} 

	public Area setType(Object value) {
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

	public Area removeType() {
		this._type = null;
		return this;
	} 

	public Area setDatabind(Object value) {
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

	public Area removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Area setAccesskey(Object value) {
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

	public Area removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Area set_class(Object value) {
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

	public Area remove_class() {
		this.__class = null;
		return this;
	} 

	public Area setContenteditable(Object value) {
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

	public Area removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Area setContextmenu(Object value) {
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

	public Area removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Area setDir(Object value) {
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

	public Area removeDir() {
		this._dir = null;
		return this;
	} 

	public Area setDraggable(Object value) {
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

	public Area removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Area setDropzone(Object value) {
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

	public Area removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Area setHidden(Object value) {
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

	public Area removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Area setId(Object value) {
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

	public Area removeId() {
		this._id = null;
		return this;
	} 

	public Area setLang(Object value) {
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

	public Area removeLang() {
		this._lang = null;
		return this;
	} 

	public Area setSpellcheck(Object value) {
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

	public Area removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Area setStyle(Object value) {
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

	public Area removeStyle() {
		this._style = null;
		return this;
	} 

	public Area setTabindex(Object value) {
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

	public Area removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Area setTitle(Object value) {
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

	public Area removeTitle() {
		this._title = null;
		return this;
	} 

	public Area setTranslate(Object value) {
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

	public Area removeTranslate() {
		this._translate = null;
		return this;
	} 


	public Area addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Area addData(Area_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Area_Data> streamData() {
		return this._data.stream().map(Area_Data::new);
	}

	public static final class Area_Data {

		Object _name;
		Object _value;

		public Area_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Area_Data(java.util.Map<String, Object> map) {
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
		Area that = (Area) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "area(alt,coords,download,href,hreflang,media,rel,shape,target,type,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data) ::= <<<area~if(alt)~ alt=\"~alt~\"~endif~~if(coords)~ coords=\"~coords~\"~endif~~if(download)~ download=\"~download~\"~endif~~if(href)~ href=\"~href~\"~endif~~if(hreflang)~ hreflang=\"~hreflang~\"~endif~~if(media)~ media=\"~media~\"~endif~~if(rel)~ rel=\"~rel~\"~endif~~if(shape)~ shape=\"~shape~\"~endif~~if(target)~ target=\"~target~\"~endif~~if(type)~ type=\"~type~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~> >>";
}  