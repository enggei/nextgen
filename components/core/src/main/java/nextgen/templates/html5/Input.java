package nextgen.templates.html5;

public class Input {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _accept;
	private Object _alt;
	private Object _autocomplete;
	private Object _autofocus;
	private Object _checked;
	private Object _disabled;
	private Object _form;
	private Object _formaction;
	private Object _formenctype;
	private Object _formmethod;
	private Object _formnovalidate;
	private Object _formtarget;
	private Object _height;
	private Object _list;
	private Object _max;
	private Object _maxlength;
	private Object _min;
	private Object _multiple;
	private Object _name;
	private Object _pattern;
	private Object _placeholder;
	private Object _readonly;
	private Object _required;
	private Object _size;
	private Object _src;
	private Object _step;
	private Object _type;
	private Object _value;
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

	Input(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("input");
		st.add("accept", _accept);
		st.add("alt", _alt);
		st.add("autocomplete", _autocomplete);
		st.add("autofocus", _autofocus);
		st.add("checked", _checked);
		st.add("disabled", _disabled);
		st.add("form", _form);
		st.add("formaction", _formaction);
		st.add("formenctype", _formenctype);
		st.add("formmethod", _formmethod);
		st.add("formnovalidate", _formnovalidate);
		st.add("formtarget", _formtarget);
		st.add("height", _height);
		st.add("list", _list);
		st.add("max", _max);
		st.add("maxlength", _maxlength);
		st.add("min", _min);
		st.add("multiple", _multiple);
		st.add("name", _name);
		st.add("pattern", _pattern);
		st.add("placeholder", _placeholder);
		st.add("readonly", _readonly);
		st.add("required", _required);
		st.add("size", _size);
		st.add("src", _src);
		st.add("step", _step);
		st.add("type", _type);
		st.add("value", _value);
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

	public Input setAccept(Object value) {
		this._accept = value;
		return this;
	}

	public Object getAccept() {
		return this._accept;
	}

	public Object getAccept(Object defaultValue) {
		return this._accept == null ? defaultValue : this._accept;
	}

	public boolean hasAccept() {
		return this._accept != null;
	}

	public Input removeAccept() {
		this._accept = null;
		return this;
	} 

	public Input setAlt(Object value) {
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

	public Input removeAlt() {
		this._alt = null;
		return this;
	} 

	public Input setAutocomplete(Object value) {
		this._autocomplete = value;
		return this;
	}

	public Object getAutocomplete() {
		return this._autocomplete;
	}

	public Object getAutocomplete(Object defaultValue) {
		return this._autocomplete == null ? defaultValue : this._autocomplete;
	}

	public boolean hasAutocomplete() {
		return this._autocomplete != null;
	}

	public Input removeAutocomplete() {
		this._autocomplete = null;
		return this;
	} 

	public Input setAutofocus(Object value) {
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

	public Input removeAutofocus() {
		this._autofocus = null;
		return this;
	} 

	public Input setChecked(Object value) {
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

	public Input removeChecked() {
		this._checked = null;
		return this;
	} 

	public Input setDisabled(Object value) {
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

	public Input removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public Input setForm(Object value) {
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

	public Input removeForm() {
		this._form = null;
		return this;
	} 

	public Input setFormaction(Object value) {
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

	public Input removeFormaction() {
		this._formaction = null;
		return this;
	} 

	public Input setFormenctype(Object value) {
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

	public Input removeFormenctype() {
		this._formenctype = null;
		return this;
	} 

	public Input setFormmethod(Object value) {
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

	public Input removeFormmethod() {
		this._formmethod = null;
		return this;
	} 

	public Input setFormnovalidate(Object value) {
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

	public Input removeFormnovalidate() {
		this._formnovalidate = null;
		return this;
	} 

	public Input setFormtarget(Object value) {
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

	public Input removeFormtarget() {
		this._formtarget = null;
		return this;
	} 

	public Input setHeight(Object value) {
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

	public Input removeHeight() {
		this._height = null;
		return this;
	} 

	public Input setList(Object value) {
		this._list = value;
		return this;
	}

	public Object getList() {
		return this._list;
	}

	public Object getList(Object defaultValue) {
		return this._list == null ? defaultValue : this._list;
	}

	public boolean hasList() {
		return this._list != null;
	}

	public Input removeList() {
		this._list = null;
		return this;
	} 

	public Input setMax(Object value) {
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

	public Input removeMax() {
		this._max = null;
		return this;
	} 

	public Input setMaxlength(Object value) {
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

	public Input removeMaxlength() {
		this._maxlength = null;
		return this;
	} 

	public Input setMin(Object value) {
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

	public Input removeMin() {
		this._min = null;
		return this;
	} 

	public Input setMultiple(Object value) {
		this._multiple = value;
		return this;
	}

	public Object getMultiple() {
		return this._multiple;
	}

	public Object getMultiple(Object defaultValue) {
		return this._multiple == null ? defaultValue : this._multiple;
	}

	public boolean hasMultiple() {
		return this._multiple != null;
	}

	public Input removeMultiple() {
		this._multiple = null;
		return this;
	} 

	public Input setName(Object value) {
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

	public Input removeName() {
		this._name = null;
		return this;
	} 

	public Input setPattern(Object value) {
		this._pattern = value;
		return this;
	}

	public Object getPattern() {
		return this._pattern;
	}

	public Object getPattern(Object defaultValue) {
		return this._pattern == null ? defaultValue : this._pattern;
	}

	public boolean hasPattern() {
		return this._pattern != null;
	}

	public Input removePattern() {
		this._pattern = null;
		return this;
	} 

	public Input setPlaceholder(Object value) {
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

	public Input removePlaceholder() {
		this._placeholder = null;
		return this;
	} 

	public Input setReadonly(Object value) {
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

	public Input removeReadonly() {
		this._readonly = null;
		return this;
	} 

	public Input setRequired(Object value) {
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

	public Input removeRequired() {
		this._required = null;
		return this;
	} 

	public Input setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public Input removeSize() {
		this._size = null;
		return this;
	} 

	public Input setSrc(Object value) {
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

	public Input removeSrc() {
		this._src = null;
		return this;
	} 

	public Input setStep(Object value) {
		this._step = value;
		return this;
	}

	public Object getStep() {
		return this._step;
	}

	public Object getStep(Object defaultValue) {
		return this._step == null ? defaultValue : this._step;
	}

	public boolean hasStep() {
		return this._step != null;
	}

	public Input removeStep() {
		this._step = null;
		return this;
	} 

	public Input setType(Object value) {
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

	public Input removeType() {
		this._type = null;
		return this;
	} 

	public Input setValue(Object value) {
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

	public Input removeValue() {
		this._value = null;
		return this;
	} 

	public Input setWidth(Object value) {
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

	public Input removeWidth() {
		this._width = null;
		return this;
	} 

	public Input setDatabind(Object value) {
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

	public Input removeDatabind() {
		this._databind = null;
		return this;
	} 

	public Input setAccesskey(Object value) {
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

	public Input removeAccesskey() {
		this._accesskey = null;
		return this;
	} 

	public Input set_class(Object value) {
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

	public Input remove_class() {
		this.__class = null;
		return this;
	} 

	public Input setContenteditable(Object value) {
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

	public Input removeContenteditable() {
		this._contenteditable = null;
		return this;
	} 

	public Input setContextmenu(Object value) {
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

	public Input removeContextmenu() {
		this._contextmenu = null;
		return this;
	} 

	public Input setDir(Object value) {
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

	public Input removeDir() {
		this._dir = null;
		return this;
	} 

	public Input setDraggable(Object value) {
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

	public Input removeDraggable() {
		this._draggable = null;
		return this;
	} 

	public Input setDropzone(Object value) {
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

	public Input removeDropzone() {
		this._dropzone = null;
		return this;
	} 

	public Input setHidden(Object value) {
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

	public Input removeHidden() {
		this._hidden = null;
		return this;
	} 

	public Input setId(Object value) {
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

	public Input removeId() {
		this._id = null;
		return this;
	} 

	public Input setLang(Object value) {
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

	public Input removeLang() {
		this._lang = null;
		return this;
	} 

	public Input setSpellcheck(Object value) {
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

	public Input removeSpellcheck() {
		this._spellcheck = null;
		return this;
	} 

	public Input setStyle(Object value) {
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

	public Input removeStyle() {
		this._style = null;
		return this;
	} 

	public Input setTabindex(Object value) {
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

	public Input removeTabindex() {
		this._tabindex = null;
		return this;
	} 

	public Input setTitle(Object value) {
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

	public Input removeTitle() {
		this._title = null;
		return this;
	} 

	public Input setTranslate(Object value) {
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

	public Input removeTranslate() {
		this._translate = null;
		return this;
	} 


	public Input addData(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._data.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getData() {
		return this._data;
	}

	public Input addData(Input_Data value) {
		return addData(value._name, value._value);
	}

	public java.util.stream.Stream<Input_Data> streamData() {
		return this._data.stream().map(Input_Data::new);
	}

	public static final class Input_Data {

		Object _name;
		Object _value;

		public Input_Data(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Input_Data(java.util.Map<String, Object> map) {
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
		Input that = (Input) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "input(accept,alt,autocomplete,autofocus,checked,disabled,form,formaction,formenctype,formmethod,formnovalidate,formtarget,height,list,max,maxlength,min,multiple,name,pattern,placeholder,readonly,required,size,src,step,type,value,width,databind,accesskey,_class,contenteditable,contextmenu,dir,draggable,dropzone,hidden,id,lang,spellcheck,style,tabindex,title,translate,data) ::= <<<input~if(accept)~ accept=\"~accept~\"~endif~~if(alt)~ alt=\"~alt~\"~endif~~if(autocomplete)~ autocomplete=\"~autocomplete~\"~endif~~if(autofocus)~ autofocus=\"~autofocus~\"~endif~~if(checked)~ checked=\"~checked~\"~endif~~if(disabled)~ disabled=\"~disabled~\"~endif~~if(form)~ form=\"~form~\"~endif~~if(formaction)~ formaction=\"~formaction~\"~endif~~if(formenctype)~ formenctype=\"~formenctype~\"~endif~~if(formmethod)~ formmethod=\"~formmethod~\"~endif~~if(formnovalidate)~ formnovalidate=\"~formnovalidate~\"~endif~~if(formtarget)~ formtarget=\"~formtarget~\"~endif~~if(height)~ height=\"~height~\"~endif~~if(list)~ list=\"~list~\"~endif~~if(max)~ max=\"~max~\"~endif~~if(maxlength)~ maxlength=\"~maxlength~\"~endif~~if(min)~ min=\"~min~\"~endif~~if(multiple)~ multiple=\"~multiple~\"~endif~~if(name)~ name=\"~name~\"~endif~~if(pattern)~ pattern=\"~pattern~\"~endif~~if(placeholder)~ placeholder=\"~placeholder~\"~endif~~if(readonly)~ readonly=\"~readonly~\"~endif~~if(required)~ required=\"~required~\"~endif~~if(size)~ size=\"~size~\"~endif~~if(src)~ src=\"~src~\"~endif~~if(step)~ step=\"~step~\"~endif~~if(type)~ type=\"~type~\"~endif~~if(value)~ value=\"~value~\"~endif~~if(width)~ width=\"~width~\"~endif~~if(databind)~ data-bind=\"~databind~\"~endif~~if(accesskey)~ accesskey=\"~accesskey~\"~endif~~if(_class)~ class=\"~_class~\"~endif~~if(contenteditable)~ contenteditable=\"~contenteditable~\"~endif~~if(contextmenu)~ contextmenu=\"~contextmenu~\"~endif~~if(dir)~ dir=\"~dir~\"~endif~~if(draggable)~ draggable=\"~draggable~\"~endif~~if(dropzone)~ dropzone=\"~dropzone~\"~endif~~if(hidden)~ hidden=\"~hidden~\"~endif~~if(id)~ id=\"~id~\"~endif~~if(lang)~ lang=\"~lang~\"~endif~~if(spellcheck)~ spellcheck=\"~spellcheck~\"~endif~~if(style)~ style=\"~style~\"~endif~~if(tabindex)~ tabindex=\"~tabindex~\"~endif~~if(title)~ title=\"~title~\"~endif~~if(translate)~ translate=\"~translate~\"~endif~~if(data)~ ~data:{it|~it.name~=\"~it.value~\"};separator=\" \"~~endif~> >>";
}  