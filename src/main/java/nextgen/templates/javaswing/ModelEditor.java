package nextgen.templates.javaswing;

public class ModelEditor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _modelType;
	private Object _background;
	private Object _packageName;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _innerClasses = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();

	ModelEditor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ModelEditor");
		st.add("name", _name);
		st.add("modelType", _modelType);
		st.add("background", _background);
		st.add("packageName", _packageName);
		for (Object o : _statements) st.add("statements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _innerClasses) st.add("innerClasses", o);
		for (Object o : _imports) st.add("imports", o);
		return st.render().trim();
	}

	public ModelEditor setName(Object value) {
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

	public ModelEditor removeName() {
		this._name = null;
		return this;
	} 

	public ModelEditor setModelType(Object value) {
		this._modelType = value;
		return this;
	}

	public Object getModelType() {
		return this._modelType;
	}

	public Object getModelType(Object defaultValue) {
		return this._modelType == null ? defaultValue : this._modelType;
	}

	public boolean hasModelType() {
		return this._modelType != null;
	}

	public ModelEditor removeModelType() {
		this._modelType = null;
		return this;
	} 

	public ModelEditor setBackground(Object value) {
		this._background = value;
		return this;
	}

	public Object getBackground() {
		return this._background;
	}

	public Object getBackground(Object defaultValue) {
		return this._background == null ? defaultValue : this._background;
	}

	public boolean hasBackground() {
		return this._background != null;
	}

	public ModelEditor removeBackground() {
		this._background = null;
		return this;
	} 

	public ModelEditor setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public ModelEditor removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ModelEditor addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public ModelEditor setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModelEditor setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public ModelEditor removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public ModelEditor removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public ModelEditor addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public ModelEditor setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModelEditor setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public ModelEditor removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public ModelEditor removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public ModelEditor addInnerClasses(Object value) {
		this._innerClasses.add(value);
		return this;
	}

	public ModelEditor setInnerClasses(Object[] value) {
		this._innerClasses.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModelEditor setInnerClasses(java.util.Collection<Object> values) {
		this._innerClasses.addAll(values);
		return this;
	}

	public ModelEditor removeInnerClasses(Object value) {
		this._innerClasses.remove(value);
		return this;
	}

	public ModelEditor removeInnerClasses(int index) {
		this._innerClasses.remove(index);
		return this;
	}

	public java.util.List<Object> getInnerClasses() {
		return this._innerClasses;
	} 

	public ModelEditor addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public ModelEditor setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModelEditor setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public ModelEditor removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public ModelEditor removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModelEditor that = (ModelEditor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ModelEditor(statements,methods,innerClasses,imports,name,modelType,background,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.swing.SwingUtil;\n" + 
				"import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.KeyAdapter;\n" + 
				"import java.awt.event.KeyEvent;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends Editor<~modelType~> {\n" + 
				"\n" + 
				"   public ~name~(~modelType~ model) {\n" + 
				"      super(model, model.getName());\n" + 
				"      setBackground(java.awt.Color.~background~);\n" + 
				"      ~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"   ~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"   ~innerClasses:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  