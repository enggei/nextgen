package nextgen.templates.nextgen;

public class DomainVisitorInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _onComplete = new java.util.ArrayList<>();
	private java.util.List<Object> _onRelation = new java.util.ArrayList<>();
	private java.util.List<Object> _onEntity = new java.util.ArrayList<>();
	private java.util.List<Object> _onDomain = new java.util.ArrayList<>();

	DomainVisitorInterface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVisitorInterface");
		for (Object o : _onComplete) st.add("onComplete", o);
		for (Object o : _onRelation) st.add("onRelation", o);
		for (Object o : _onEntity) st.add("onEntity", o);
		for (Object o : _onDomain) st.add("onDomain", o);
		return st.render().trim();
	}


	public DomainVisitorInterface addOnComplete(Object value) {
		this._onComplete.add(value);
		return this;
	}

	public DomainVisitorInterface setOnComplete(Object[] value) {
		this._onComplete.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnComplete(java.util.Collection<Object> values) {
		this._onComplete.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnComplete(Object value) {
		this._onComplete.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnComplete(int index) {
		this._onComplete.remove(index);
		return this;
	}

	public java.util.List<Object> getOnComplete() {
		return this._onComplete;
	} 

	public DomainVisitorInterface addOnRelation(Object value) {
		this._onRelation.add(value);
		return this;
	}

	public DomainVisitorInterface setOnRelation(Object[] value) {
		this._onRelation.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnRelation(java.util.Collection<Object> values) {
		this._onRelation.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnRelation(Object value) {
		this._onRelation.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnRelation(int index) {
		this._onRelation.remove(index);
		return this;
	}

	public java.util.List<Object> getOnRelation() {
		return this._onRelation;
	} 

	public DomainVisitorInterface addOnEntity(Object value) {
		this._onEntity.add(value);
		return this;
	}

	public DomainVisitorInterface setOnEntity(Object[] value) {
		this._onEntity.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnEntity(java.util.Collection<Object> values) {
		this._onEntity.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnEntity(Object value) {
		this._onEntity.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnEntity(int index) {
		this._onEntity.remove(index);
		return this;
	}

	public java.util.List<Object> getOnEntity() {
		return this._onEntity;
	} 

	public DomainVisitorInterface addOnDomain(Object value) {
		this._onDomain.add(value);
		return this;
	}

	public DomainVisitorInterface setOnDomain(Object[] value) {
		this._onDomain.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorInterface setOnDomain(java.util.Collection<Object> values) {
		this._onDomain.addAll(values);
		return this;
	}

	public DomainVisitorInterface removeOnDomain(Object value) {
		this._onDomain.remove(value);
		return this;
	}

	public DomainVisitorInterface removeOnDomain(int index) {
		this._onDomain.remove(index);
		return this;
	}

	public java.util.List<Object> getOnDomain() {
		return this._onDomain;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVisitorInterface that = (DomainVisitorInterface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainVisitorInterface(onComplete,onRelation,onEntity,onDomain) ::= <<public void onDomain(String name) {\n" + 
				"	System.out.println(\"on domain \" + name);\n" + 
				"	~onDomain:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onEntity(DomainEntity entity) {\n" + 
				"	System.out.println(\"\\ton entity \" + entity.getName());\n" + 
				"	~onEntity:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onRelation(DomainRelation relation) {\n" + 
				"	System.out.println(\"\\ton relation \" + relation.getName() + \" \" + relation.getSrc().getName() + \" \" + relation.getType() + \" \" + relation.getDst().getName());\n" + 
				"	~onRelation:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"public void onComplete() {\n" + 
				"	System.out.println();\n" + 
				"	~onComplete:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  