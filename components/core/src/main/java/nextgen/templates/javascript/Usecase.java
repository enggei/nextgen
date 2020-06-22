package nextgen.templates.javascript;

public class Usecase {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _description;
	private String _url;
	private String _action;
	private java.util.List<String> _successStatements = new java.util.ArrayList<>();
	private java.util.List<String> _failStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _domainStatements = new java.util.ArrayList<>();

	Usecase(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Usecase");
		st.add("name", _name);
		st.add("description", _description);
		st.add("url", _url);
		st.add("action", _action);
		for (Object o : _successStatements) st.add("successStatements", o);
		for (Object o : _failStatements) st.add("failStatements", o);
		for (Object o : _domainStatements) st.add("domainStatements", o);
		return st.render().trim();
	}

	public Usecase setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Usecase removeName() {
		this._name = null;
		return this;
	} 

	public Usecase setDescription(String value) {
		this._description = value;
		return this;
	}

	public String getDescription() {
		return this._description;
	}

	public String getDescription(String defaultValue) {
		return this._description == null ? defaultValue : this._description;
	}

	public boolean hasDescription() {
		return this._description != null;
	}

	public Usecase removeDescription() {
		this._description = null;
		return this;
	} 

	public Usecase setUrl(String value) {
		this._url = value;
		return this;
	}

	public String getUrl() {
		return this._url;
	}

	public String getUrl(String defaultValue) {
		return this._url == null ? defaultValue : this._url;
	}

	public boolean hasUrl() {
		return this._url != null;
	}

	public Usecase removeUrl() {
		this._url = null;
		return this;
	} 

	public Usecase setAction(String value) {
		this._action = value;
		return this;
	}

	public String getAction() {
		return this._action;
	}

	public String getAction(String defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public Usecase removeAction() {
		this._action = null;
		return this;
	} 

	public Usecase addSuccessStatements(String value) {
		this._successStatements.add(value);
		return this;
	}

	public Usecase setSuccessStatements(String[] value) {
		this._successStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Usecase setSuccessStatements(java.util.Collection<String> values) {
		this._successStatements.addAll(values);
		return this;
	}

	public Usecase removeSuccessStatements(String value) {
		this._successStatements.remove(value);
		return this;
	}

	public Usecase removeSuccessStatements(int index) {
		this._successStatements.remove(index);
		return this;
	}

	public java.util.List<String> getSuccessStatements() {
		return this._successStatements;
	} 

	public Usecase addFailStatements(String value) {
		this._failStatements.add(value);
		return this;
	}

	public Usecase setFailStatements(String[] value) {
		this._failStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Usecase setFailStatements(java.util.Collection<String> values) {
		this._failStatements.addAll(values);
		return this;
	}

	public Usecase removeFailStatements(String value) {
		this._failStatements.remove(value);
		return this;
	}

	public Usecase removeFailStatements(int index) {
		this._failStatements.remove(index);
		return this;
	}

	public java.util.List<String> getFailStatements() {
		return this._failStatements;
	} 

	public Usecase addDomainStatements(Object value) {
		this._domainStatements.add(value);
		return this;
	}

	public Usecase setDomainStatements(Object[] value) {
		this._domainStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Usecase setDomainStatements(java.util.Collection<Object> values) {
		this._domainStatements.addAll(values);
		return this;
	}

	public Usecase removeDomainStatements(Object value) {
		this._domainStatements.remove(value);
		return this;
	}

	public Usecase removeDomainStatements(int index) {
		this._domainStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getDomainStatements() {
		return this._domainStatements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usecase that = (Usecase) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Usecase(name,description,url,action,successStatements,failStatements,domainStatements) ::= <<~name~\n" + 
				"~description~\n" + 
				"\n" + 
				"~url~\n" + 
				"~action~\n" + 
				"\n" + 
				"~successStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"~failStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~domainStatements:{it|~it~};separator=\"\\n\"~ >>";
} 