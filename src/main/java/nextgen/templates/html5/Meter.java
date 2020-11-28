package nextgen.templates.html5;

public class Meter {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _form;
	private Object _high;
	private Object _low;
	private Object _max;
	private Object _min;
	private Object _optimum;
	private Object _value;
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

	Meter(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("meter");
		st.add("form", _form);
		st.add("high", _high);
		st.add("low", _low);
		st.add("max", _max);
		st.add("min", _min);
		st.add("optimum", _optimum);
		st.add("value", _value);
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

	public Meter setForm(Object value) {
		this._form = value;
		return this;
	}

	public Object getForm() {
		return this._form;
	}

	public Object getForm(Object defaultValue) {
		return this._form == null ? defaultValue : this._form;
	}

	public boolean hasForm() {
		return this._form != null;
	}

	public Meter removeForm() {
		this._form = null;
		return this;
	} 

	public Meter setHigh(Object value) {
		this._high = value;
		return this;
	}

	public Object getHigh() {
		return this._high;
	}

	public Object getHigh(Object defaultValue) {
		return this._high == null ? defaultValue : this._high;
	}

	public boolean hasHigh() {
		return this._high != null;
	}

	public Meter removeHigh() {
		this._high = null;
		return this;
	} 

	public Meter setLow(Object value) {
		this._low = value;
		return this;
	}

	public Object getLow() {
		return this._low;
	}

	public Object getLow(Object defaultValue) {
		return this._low == null ? defaultValue : this._low;
	}

	public boolean hasLow() {
		return this._low != null;
	}

	public Meter removeLow() {
		this._low = null;
		return this;
	} 

	public Meter setMax(Object value) {
		this._max = value;
		return this;
	}

	public Object getMax() {
		return this._max;
	}

	public Object getMax(Object defaultValue) {
		return this._max == null ? defaultValue : this._max;
	}

	public boolean hasMax() {
		return this._max != null;
	}

	public Meter removeMax() {
		this._max = null;
		return this;
	} 

	public Meter setMin(Object value) {
		this._min = value;
		return this;
	}

	public Object getMin() {
		return this._min;
	}

	public Object getMin(Object defaultValue) {
		return this._min == null ? defaultValue : this._min;
	}

	public boolean hasMin() {
		return this._min != null;
	}

	public Meter removeMin() {
		this._min = null;
		return this;
	} 

	public Meter setOptimum(Object value) {
		this._optimum = value;
		return this;
	}

	public Object getOptimum() {
		return this._optimum;
	}

	public Object getOptimum(Object defaultValue) {
		return this._optimum == null ? defaultValue : this._optimum;
	}

	public boolean hasOptimum() {
		return this._optimum != null;
	}

	public Meter removeOptimum() {
		this._optimum = null;
		return this;
	} 

	public Meter setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public Meter removeValue() {
		this._value = null;
		return this;
	} 

	public Meter setDatabind(Object value) {
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

	public Meter removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Meter setAccesskey(Object value) {
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

	public Meter removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Meter set_class(Object value) {
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

	public Meter remove_class() {
		this.__class = null;
		return this;
	} 

	public Meter setContenteditable(Object value) {
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

	public Meter removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Meter setContextmenu(Object value) {
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

	public Meter removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Meter setDir(Object value) {
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

	public Meter removeDir() {
		this._dir = null;
		return this;
	} 

	public Meter setDraggable(Object value) {
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

	public Meter removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Meter setDropzone(Object value) {
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

	public Meter removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Meter setHidden(Object value) {
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

	public Meter removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Meter setId(Object value) {
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

	public Meter removeId() {
		this._id = null;
		return this;
	} 

	public Meter setLang(Object value) {
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

	public Meter removeLang() {
		this._lang = null;
		return this;
	} 

	public Meter setSpellcheck(Object value) {
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

	public Meter removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Meter setStyle(Object value) {
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

	public Meter removeStyle() {
		this._style = null;
		return this;
	} 

	public Meter setTabindex(Object value) {
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

	public Meter removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Meter setTitle(Object value) {
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

	public Meter removeTitle() {
		this._title = null;
		return this;
	} 

	public Meter setTranslate(Object value) {
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

	public Meter removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Meter addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Meter setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Meter setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Meter removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Meter removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Meter addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Meter addData(Meter_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Meter_Data> streamData() {
		return this._data.stream().map(Meter_Data::new);
	}

	public static final class Meter_Data {

		Object _name;
		Object _value;

		public Meter_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Meter_Data(java.util.Map<String, Object> map) {
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
		Meter that = (Meter) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "meter(form,high,low,max,min,optimum,value,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<meter~if(form)~ form=\"~form~\"~endif~~if(high)~ high=\"~high~\"~endif~~if(low)~ low=\"~low~\"~endif~~if(max)~ max=\"~max~\"~endif~~if(min)~ min=\"~min~\"~endif~~if(optimum)~ optimum=\"~optimum~\"~endif~~if(value)~ value=\"~value~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</meter> >>";
}  