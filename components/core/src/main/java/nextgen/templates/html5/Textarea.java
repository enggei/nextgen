package nextgen.templates.html5;

public class Textarea {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autofocus;
	private Object _cols;
	private Object _disabled;
	private Object _form;
	private Object _maxlength;
	private Object _name;
	private Object _placeholder;
	private Object _readonly;
	private Object _required;
	private Object _rows;
	private Object _wrap;
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

	Textarea(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("textarea");
		st.add("autofocus", _autofocus);
		st.add("cols", _cols);
		st.add("disabled", _disabled);
		st.add("form", _form);
		st.add("maxlength", _maxlength);
		st.add("name", _name);
		st.add("placeholder", _placeholder);
		st.add("readonly", _readonly);
		st.add("required", _required);
		st.add("rows", _rows);
		st.add("wrap", _wrap);
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

	public Textarea setAutofocus(Object value) {
		this._autofocus = value;
		return this;
	}

	public Object getAutofocus() {
		return this._autofocus;
	}

	public Object getAutofocus(Object defaultValue) {
		return this._autofocus == null ? defaultValue : this._autofocus;
	}

	public boolean hasAutofocus() {
		return this._autofocus != null;
	}

	public Textarea removeAutofocus() {
		this._autofocus = null;
		return this;
	} 

	public Textarea setCols(Object value) {
		this._cols = value;
		return this;
	}

	public Object getCols() {
		return this._cols;
	}

	public Object getCols(Object defaultValue) {
		return this._cols == null ? defaultValue : this._cols;
	}

	public boolean hasCols() {
		return this._cols != null;
	}

	public Textarea removeCols() {
		this._cols = null;
		return this;
	} 

	public Textarea setDisabled(Object value) {
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

	public Textarea removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public Textarea setForm(Object value) {
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

	public Textarea removeForm() {
		this._form = null;
		return this;
	} 

	public Textarea setMaxlength(Object value) {
		this._maxlength = value;
		return this;
	}

	public Object getMaxlength() {
		return this._maxlength;
	}

	public Object getMaxlength(Object defaultValue) {
		return this._maxlength == null ? defaultValue : this._maxlength;
	}

	public boolean hasMaxlength() {
		return this._maxlength != null;
	}

	public Textarea removeMaxlength() {
		this._maxlength = null;
		return this;
	} 

	public Textarea setName(Object value) {
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

	public Textarea removeName() {
		this._name = null;
		return this;
	} 

	public Textarea setPlaceholder(Object value) {
		this._placeholder = value;
		return this;
	}

	public Object getPlaceholder() {
		return this._placeholder;
	}

	public Object getPlaceholder(Object defaultValue) {
		return this._placeholder == null ? defaultValue : this._placeholder;
	}

	public boolean hasPlaceholder() {
		return this._placeholder != null;
	}

	public Textarea removePlaceholder() {
		this._placeholder = null;
		return this;
	} 

	public Textarea setReadonly(Object value) {
		this._readonly = value;
		return this;
	}

	public Object getReadonly() {
		return this._readonly;
	}

	public Object getReadonly(Object defaultValue) {
		return this._readonly == null ? defaultValue : this._readonly;
	}

	public boolean hasReadonly() {
		return this._readonly != null;
	}

	public Textarea removeReadonly() {
		this._readonly = null;
		return this;
	} 

	public Textarea setRequired(Object value) {
		this._required = value;
		return this;
	}

	public Object getRequired() {
		return this._required;
	}

	public Object getRequired(Object defaultValue) {
		return this._required == null ? defaultValue : this._required;
	}

	public boolean hasRequired() {
		return this._required != null;
	}

	public Textarea removeRequired() {
		this._required = null;
		return this;
	} 

	public Textarea setRows(Object value) {
		this._rows = value;
		return this;
	}

	public Object getRows() {
		return this._rows;
	}

	public Object getRows(Object defaultValue) {
		return this._rows == null ? defaultValue : this._rows;
	}

	public boolean hasRows() {
		return this._rows != null;
	}

	public Textarea removeRows() {
		this._rows = null;
		return this;
	} 

	public Textarea setWrap(Object value) {
		this._wrap = value;
		return this;
	}

	public Object getWrap() {
		return this._wrap;
	}

	public Object getWrap(Object defaultValue) {
		return this._wrap == null ? defaultValue : this._wrap;
	}

	public boolean hasWrap() {
		return this._wrap != null;
	}

	public Textarea removeWrap() {
		this._wrap = null;
		return this;
	} 

	public Textarea setDatabind(Object value) {
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

	public Textarea removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Textarea setAccesskey(Object value) {
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

	public Textarea removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Textarea set_class(Object value) {
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

	public Textarea remove_class() {
		this.__class = null;
		return this;
	} 

	public Textarea setContenteditable(Object value) {
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

	public Textarea removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Textarea setContextmenu(Object value) {
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

	public Textarea removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Textarea setDir(Object value) {
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

	public Textarea removeDir() {
		this._dir = null;
		return this;
	} 

	public Textarea setDraggable(Object value) {
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

	public Textarea removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Textarea setDropzone(Object value) {
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

	public Textarea removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Textarea setHidden(Object value) {
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

	public Textarea removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Textarea setId(Object value) {
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

	public Textarea removeId() {
		this._id = null;
		return this;
	} 

	public Textarea setLang(Object value) {
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

	public Textarea removeLang() {
		this._lang = null;
		return this;
	} 

	public Textarea setSpellcheck(Object value) {
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

	public Textarea removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Textarea setStyle(Object value) {
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

	public Textarea removeStyle() {
		this._style = null;
		return this;
	} 

	public Textarea setTabindex(Object value) {
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

	public Textarea removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Textarea setTitle(Object value) {
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

	public Textarea removeTitle() {
		this._title = null;
		return this;
	} 

	public Textarea setTranslate(Object value) {
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

	public Textarea removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Textarea addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Textarea setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Textarea setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Textarea removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Textarea removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Textarea addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Textarea addData(Textarea_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Textarea_Data> streamData() {
		return this._data.stream().map(Textarea_Data::new);
	}

	public static final class Textarea_Data {

		Object _name;
		Object _value;

		public Textarea_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Textarea_Data(java.util.Map<String, Object> map) {
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
		Textarea that = (Textarea) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "textarea(autofocus,cols,disabled,form,maxlength,name,placeholder,readonly,required,rows,wrap,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<textarea~if(autofocus)~ autofocus=\"~autofocus~\"~endif~~if(cols)~ cols=\"~cols~\"~endif~~if(disabled)~ disabled=\"~disabled~\"~endif~~if(form)~ form=\"~form~\"~endif~~if(maxlength)~ maxlength=\"~maxlength~\"~endif~~if(name)~ name=\"~name~\"~endif~~if(placeholder)~ placeholder=\"~placeholder~\"~endif~~if(readonly)~ readonly=\"~readonly~\"~endif~~if(required)~ required=\"~required~\"~endif~~if(rows)~ rows=\"~rows~\"~endif~~if(wrap)~ wrap=\"~wrap~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</textarea> >>";
}  