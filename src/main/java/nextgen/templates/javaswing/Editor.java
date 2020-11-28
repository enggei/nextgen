package nextgen.templates.javaswing;

public class Editor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	Editor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Editor");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public Editor setPackageName(Object value) {
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

	public Editor removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Editor setName(Object value) {
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

	public Editor removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Editor that = (Editor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Editor(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.DomainFacade;\n" + 
				"import nextgen.swing.AppModel;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"\n" + 
				"public class ~name~<T> extends JPanel {\n" + 
				"\n" + 
				"	protected final T model;\n" + 
				"	private String title;\n" + 
				"\n" + 
				"	public ~name~(T model, String title) {\n" + 
				"		super(new BorderLayout());\n" + 
				"		this.model = model;\n" + 
				"		this.title = title;\n" + 
				"		setBackground(java.awt.Color.BLACK);\n" + 
				"	}\n" + 
				"\n" + 
				"	public T getModel() {\n" + 
				"		return model;\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getTitle() {\n" + 
				"		return title;\n" + 
				"	}\n" + 
				"\n" + 
				"	public void setTitle(String title) {\n" + 
				"		this.title = title;\n" + 
				"	}\n" + 
				"\n" + 
				"	protected DomainFacade getDomain() {\n" + 
				"		return AppModel.getInstance().getDomain();\n" + 
				"	}\n" + 
				"} >>";
}  