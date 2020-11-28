package nextgen.templates.html5;

public class Link {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _crossorigin;
	private Object _href;
	private Object _hreflang;
	private Object _media;
	private Object _rel;
	private Object _sizes;
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

	Link(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("link");
		st.add("crossorigin", _crossorigin);
		st.add("href", _href);
		st.add("hreflang", _hreflang);
		st.add("media", _media);
		st.add("rel", _rel);
		st.add("sizes", _sizes);
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

	public Link setCrossorigin(Object value) {
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

	public Link removeCrossorigin() {
		this._crossorigin = null;
		return this;
	} 

	public Link setHref(Object value) {
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

	public Link removeHref() {
		this._href = null;
		return this;
	} 

	public Link setHreflang(Object value) {
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

	public Link removeHreflang() {
		this._hreflang = null;
		return this;
	} 

	public Link setMedia(Object value) {
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

	public Link removeMedia() {
		this._media = null;
		return this;
	} 

	public Link setRel(Object value) {
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

	public Link removeRel() {
		this._rel = null;
		return this;
	} 

	public Link setSizes(Object value) {
		this._sizes = value;
		return this;
	}

	public Object getSizes() {
		return this._sizes;
	}

	public Object getSizes(Object defaultValue) {
		return this._sizes == null ? defaultValue : this._sizes;
	}

	public boolean hasSizes() {
		return this._sizes != null;
	}

	public Link removeSizes() {
		this._sizes = null;
		return this;
	} 

	public Link setType(Object value) {
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

	public Link removeType() {
		this._type = null;
		return this;
	} 

	public Link setDatabind(Object value) {
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

	public Link removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Link setAccesskey(Object value) {
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

	public Link removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Link set_class(Object value) {
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

	public Link remove_class() {
		this.__class = null;
		return this;
	} 

	public Link setContenteditable(Object value) {
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

	public Link removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Link setContextmenu(Object value) {
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

	public Link removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Link setDir(Object value) {
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

	public Link removeDir() {
		this._dir = null;
		return this;
	} 

	public Link setDraggable(Object value) {
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

	public Link removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Link setDropzone(Object value) {
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

	public Link removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Link setHidden(Object value) {
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

	public Link removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Link setId(Object value) {
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

	public Link removeId() {
		this._id = null;
		return this;
	} 

	public Link setLang(Object value) {
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

	public Link removeLang() {
		this._lang = null;
		return this;
	} 

	public Link setSpellcheck(Object value) {
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

	public Link removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Link setStyle(Object value) {
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

	public Link removeStyle() {
		this._style = null;
		return this;
	} 

	public Link setTabindex(Object value) {
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

	public Link removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Link setTitle(Object value) {
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

	public Link removeTitle() {
		this._title = null;
		return this;
	} 

	public Link setTranslate(Object value) {
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

	public Link removeTranslate() {
		this._translate = null;
		return this;
	} 


	public Link addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Link addData(Link_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Link_Data> streamData() {
		return this._data.stream().map(Link_Data::new);
	}

	public static final class Link_Data {

		Object _name;
		Object _value;

		public Link_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Link_Data(java.util.Map<String, Object> map) {
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
		Link that = (Link) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "link(crossorigin,href,hreflang,media,rel,sizes,type,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data) ::= <<<link~if(crossorigin)~ crossorigin=\"~crossorigin~\"~endif~~if(href)~ href=\"~href~\"~endif~~if(hreflang)~ hreflang=\"~hreflang~\"~endif~~if(media)~ media=\"~media~\"~endif~~if(rel)~ rel=\"~rel~\"~endif~~if(sizes)~ sizes=\"~sizes~\"~endif~~if(type)~ type=\"~type~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~> >>";
}  