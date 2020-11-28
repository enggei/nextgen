package nextgen.templates.javaswing;

public class TransactionAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _appModelType;

	TransactionAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TransactionAction");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("appModelType", _appModelType);
		return st.render().trim();
	}

	public TransactionAction setPackageName(Object value) {
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

	public TransactionAction removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TransactionAction setName(Object value) {
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

	public TransactionAction removeName() {
		this._name = null;
		return this;
	} 

	public TransactionAction setAppModelType(Object value) {
		this._appModelType = value;
		return this;
	}

	public Object getAppModelType() {
		return this._appModelType;
	}

	public Object getAppModelType(Object defaultValue) {
		return this._appModelType == null ? defaultValue : this._appModelType;
	}

	public boolean hasAppModelType() {
		return this._appModelType != null;
	}

	public TransactionAction removeAppModelType() {
		this._appModelType = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TransactionAction that = (TransactionAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TransactionAction(packageName,name,appModelType) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.neo4j.graphdb.Transaction;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"\n" + 
				"public abstract class ~name~ extends AbstractAction {\n" + 
				"\n" + 
				"	~name~(String name) {\n" + 
				"		super(name);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void actionPerformed(ActionEvent actionEvent) {\n" + 
				"		~appModelType~.getInstance()\n" + 
				"				.getDomain()\n" + 
				"				.doInTransaction(transaction -> actionPerformed(actionEvent, transaction, ~appModelType~.getInstance()));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected abstract void actionPerformed(ActionEvent actionEvent, Transaction transaction, ~appModelType~ appModel);\n" + 
				"} >>";
}  