package nextgen.templates.html5;

public class Video {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoplay;
	private Object _controls;
	private Object _height;
	private Object _loop;
	private Object _muted;
	private Object _poster;
	private Object _preload;
	private Object _src;
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

	Video(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("video");
		st.add("autoplay", _autoplay);
		st.add("controls", _controls);
		st.add("height", _height);
		st.add("loop", _loop);
		st.add("muted", _muted);
		st.add("poster", _poster);
		st.add("preload", _preload);
		st.add("src", _src);
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

	public Video setAutoplay(Object value) {
		this._autoplay = value;
		return this;
	}

	public Object getAutoplay() {
		return this._autoplay;
	}

	public Object getAutoplay(Object defaultValue) {
		return this._autoplay == null ? defaultValue : this._autoplay;
	}

	public boolean hasAutoplay() {
		return this._autoplay != null;
	}

	public Video removeAutoplay() {
		this._autoplay = null;
		return this;
	} 

	public Video setControls(Object value) {
		this._controls = value;
		return this;
	}

	public Object getControls() {
		return this._controls;
	}

	public Object getControls(Object defaultValue) {
		return this._controls == null ? defaultValue : this._controls;
	}

	public boolean hasControls() {
		return this._controls != null;
	}

	public Video removeControls() {
		this._controls = null;
		return this;
	} 

	public Video setHeight(Object value) {
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

	public Video removeHeight() {
		this._height = null;
		return this;
	} 

	public Video setLoop(Object value) {
		this._loop = value;
		return this;
	}

	public Object getLoop() {
		return this._loop;
	}

	public Object getLoop(Object defaultValue) {
		return this._loop == null ? defaultValue : this._loop;
	}

	public boolean hasLoop() {
		return this._loop != null;
	}

	public Video removeLoop() {
		this._loop = null;
		return this;
	} 

	public Video setMuted(Object value) {
		this._muted = value;
		return this;
	}

	public Object getMuted() {
		return this._muted;
	}

	public Object getMuted(Object defaultValue) {
		return this._muted == null ? defaultValue : this._muted;
	}

	public boolean hasMuted() {
		return this._muted != null;
	}

	public Video removeMuted() {
		this._muted = null;
		return this;
	} 

	public Video setPoster(Object value) {
		this._poster = value;
		return this;
	}

	public Object getPoster() {
		return this._poster;
	}

	public Object getPoster(Object defaultValue) {
		return this._poster == null ? defaultValue : this._poster;
	}

	public boolean hasPoster() {
		return this._poster != null;
	}

	public Video removePoster() {
		this._poster = null;
		return this;
	} 

	public Video setPreload(Object value) {
		this._preload = value;
		return this;
	}

	public Object getPreload() {
		return this._preload;
	}

	public Object getPreload(Object defaultValue) {
		return this._preload == null ? defaultValue : this._preload;
	}

	public boolean hasPreload() {
		return this._preload != null;
	}

	public Video removePreload() {
		this._preload = null;
		return this;
	} 

	public Video setSrc(Object value) {
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

	public Video removeSrc() {
		this._src = null;
		return this;
	} 

	public Video setWidth(Object value) {
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

	public Video removeWidth() {
		this._width = null;
		return this;
	} 

	public Video setDatabind(Object value) {
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

	public Video removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Video setAccesskey(Object value) {
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

	public Video removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Video set_class(Object value) {
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

	public Video remove_class() {
		this.__class = null;
		return this;
	} 

	public Video setContenteditable(Object value) {
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

	public Video removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Video setContextmenu(Object value) {
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

	public Video removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Video setDir(Object value) {
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

	public Video removeDir() {
		this._dir = null;
		return this;
	} 

	public Video setDraggable(Object value) {
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

	public Video removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Video setDropzone(Object value) {
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

	public Video removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Video setHidden(Object value) {
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

	public Video removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Video setId(Object value) {
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

	public Video removeId() {
		this._id = null;
		return this;
	} 

	public Video setLang(Object value) {
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

	public Video removeLang() {
		this._lang = null;
		return this;
	} 

	public Video setSpellcheck(Object value) {
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

	public Video removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Video setStyle(Object value) {
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

	public Video removeStyle() {
		this._style = null;
		return this;
	} 

	public Video setTabindex(Object value) {
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

	public Video removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Video setTitle(Object value) {
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

	public Video removeTitle() {
		this._title = null;
		return this;
	} 

	public Video setTranslate(Object value) {
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

	public Video removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Video addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Video setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Video setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Video removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Video removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Video addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Video addData(Video_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Video_Data> streamData() {
		return this._data.stream().map(Video_Data::new);
	}

	public static final class Video_Data {

		Object _name;
		Object _value;

		public Video_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Video_Data(java.util.Map<String, Object> map) {
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
		Video that = (Video) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "video(autoplay,controls,height,loop,muted,poster,preload,src,width,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<video~if(autoplay)~ autoplay=\"~autoplay~\"~endif~~if(controls)~ controls=\"~controls~\"~endif~~if(height)~ height=\"~height~\"~endif~~if(loop)~ loop=\"~loop~\"~endif~~if(muted)~ muted=\"~muted~\"~endif~~if(poster)~ poster=\"~poster~\"~endif~~if(preload)~ preload=\"~preload~\"~endif~~if(src)~ src=\"~src~\"~endif~~if(width)~ width=\"~width~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</video> >>";
}  