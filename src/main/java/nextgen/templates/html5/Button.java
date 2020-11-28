package nextgen.templates.html5;

public class Button {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autofocus;
	private Object _disabled;
	private Object _form;
	private Object _formaction;
	private Object _formenctype;
	private Object _formmethod;
	private Object _formnovalidate;
	private Object _formtarget;
	private Object _name;
	private Object _type;
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

	Button(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("button");
		st.add("autofocus", _autofocus);
		st.add("disabled", _disabled);
		st.add("form", _form);
		st.add("formaction", _formaction);
		st.add("formenctype", _formenctype);
		st.add("formmethod", _formmethod);
		st.add("formnovalidate", _formnovalidate);
		st.add("formtarget", _formtarget);
		st.add("name", _name);
		st.add("type", _type);
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

	public Button setAutofocus(Object value) {
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

	public Button removeAutofocus() {
		this._autofocus = null;
		return this;
	} 

	public Button setDisabled(Object value) {
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

	public Button removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public Button setForm(Object value) {
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

	public Button removeForm() {
		this._form = null;
		return this;
	} 

	public Button setFormaction(Object value) {
		this._formaction = value;
		return this;
	}

	public Object getFormaction() {
		return this._formaction;
	}

	public Object getFormaction(Object defaultValue) {
		return this._formaction == null ? defaultValue : this._formaction;
	}

	public boolean hasFormaction() {
		return this._formaction != null;
	}

	public Button removeFormaction() {
		this._formaction = null;
		return this;
	} 

	public Button setFormenctype(Object value) {
		this._formenctype = value;
		return this;
	}

	public Object getFormenctype() {
		return this._formenctype;
	}

	public Object getFormenctype(Object defaultValue) {
		return this._formenctype == null ? defaultValue : this._formenctype;
	}

	public boolean hasFormenctype() {
		return this._formenctype != null;
	}

	public Button removeFormenctype() {
		this._formenctype = null;
		return this;
	} 

	public Button setFormmethod(Object value) {
		this._formmethod = value;
		return this;
	}

	public Object getFormmethod() {
		return this._formmethod;
	}

	public Object getFormmethod(Object defaultValue) {
		return this._formmethod == null ? defaultValue : this._formmethod;
	}

	public boolean hasFormmethod() {
		return this._formmethod != null;
	}

	public Button removeFormmethod() {
		this._formmethod = null;
		return this;
	} 

	public Button setFormnovalidate(Object value) {
		this._formnovalidate = value;
		return this;
	}

	public Object getFormnovalidate() {
		return this._formnovalidate;
	}

	public Object getFormnovalidate(Object defaultValue) {
		return this._formnovalidate == null ? defaultValue : this._formnovalidate;
	}

	public boolean hasFormnovalidate() {
		return this._formnovalidate != null;
	}

	public Button removeFormnovalidate() {
		this._formnovalidate = null;
		return this;
	} 

	public Button setFormtarget(Object value) {
		this._formtarget = value;
		return this;
	}

	public Object getFormtarget() {
		return this._formtarget;
	}

	public Object getFormtarget(Object defaultValue) {
		return this._formtarget == null ? defaultValue : this._formtarget;
	}

	public boolean hasFormtarget() {
		return this._formtarget != null;
	}

	public Button removeFormtarget() {
		this._formtarget = null;
		return this;
	} 

	public Button setName(Object value) {
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

	public Button removeName() {
		this._name = null;
		return this;
	} 

	public Button setType(Object value) {
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

	public Button removeType() {
		this._type = null;
		return this;
	} 

	public Button setValue(Object value) {
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

	public Button removeValue() {
		this._value = null;
		return this;
	} 

	public Button setDatabind(Object value) {
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

	public Button removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Button setAccesskey(Object value) {
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

	public Button removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Button set_class(Object value) {
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

	public Button remove_class() {
		this.__class = null;
		return this;
	} 

	public Button setContenteditable(Object value) {
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

	public Button removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Button setContextmenu(Object value) {
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

	public Button removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Button setDir(Object value) {
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

	public Button removeDir() {
		this._dir = null;
		return this;
	} 

	public Button setDraggable(Object value) {
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

	public Button removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Button setDropzone(Object value) {
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

	public Button removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Button setHidden(Object value) {
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

	public Button removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Button setId(Object value) {
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

	public Button removeId() {
		this._id = null;
		return this;
	} 

	public Button setLang(Object value) {
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

	public Button removeLang() {
		this._lang = null;
		return this;
	} 

	public Button setSpellcheck(Object value) {
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

	public Button removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Button setStyle(Object value) {
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

	public Button removeStyle() {
		this._style = null;
		return this;
	} 

	public Button setTabindex(Object value) {
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

	public Button removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Button setTitle(Object value) {
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

	public Button removeTitle() {
		this._title = null;
		return this;
	} 

	public Button setTranslate(Object value) {
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

	public Button removeTranslate() {
		this._translate = null;
		return this;
	} 

	public Button addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Button setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Button setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Button removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Button removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 

	public Button addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Button addData(Button_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Button_Data> streamData() {
		return this._data.stream().map(Button_Data::new);
	}

	public static final class Button_Data {

		Object _name;
		Object _value;

		public Button_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Button_Data(java.util.Map<String, Object> map) {
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
		Button that = (Button) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "button(autofocus,disabled,form,formaction,formenctype,formmethod,formnovalidate,formtarget,name,type,value,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data,content) ::= <<<button~if(autofocus)~ autofocus=\"~autofocus~\"~endif~~if(disabled)~ disabled=\"~disabled~\"~endif~~if(form)~ form=\"~form~\"~endif~~if(formaction)~ formaction=\"~formaction~\"~endif~~if(formenctype)~ formenctype=\"~formenctype~\"~endif~~if(formmethod)~ formmethod=\"~formmethod~\"~endif~~if(formnovalidate)~ formnovalidate=\"~formnovalidate~\"~endif~~if(formtarget)~ formtarget=\"~formtarget~\"~endif~~if(name)~ name=\"~name~\"~endif~~if(type)~ type=\"~type~\"~endif~~if(value)~ value=\"~value~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~>~if(content)~\n" + 
				"	~content:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~</button> >>";
}  