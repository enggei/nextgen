package nextgen.templates.cypher;

public class CreateNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _labels = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	CreateNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CreateNode");
		for (Object o : _labels) st.add("labels", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}


	public CreateNode addLabels(Object value) {
		this._labels.add(value);
		return this;
	}

	public CreateNode setLabels(Object[] value) {
		this._labels.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CreateNode setLabels(java.util.Collection<Object> values) {
		this._labels.addAll(values);
		return this;
	}

	public CreateNode removeLabels(Object value) {
		this._labels.remove(value);
		return this;
	}

	public CreateNode removeLabels(int index) {
		this._labels.remove(index);
		return this;
	}

	public java.util.List<Object> getLabels() {
		return this._labels;
	} 

	public CreateNode addProperties(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public CreateNode addProperties(CreateNode_Properties value) {
		return addProperties(value._name, value._value);
	}

	public java.util.stream.Stream<CreateNode_Properties> streamProperties() {
		return this._properties.stream().map(CreateNode_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(CreateNode_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Value() {
		return streamProperties().map(CreateNode_Properties::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class CreateNode_Properties {

		Object _name;
		Object _value;

		public CreateNode_Properties(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private CreateNode_Properties(java.util.Map<String, Object> map) {
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
		CreateNode that = (CreateNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CreateNode(labels,properties) ::= <<CREATE (~if(labels)~n:~endif~~labels:{it|~it~};separator=\":\"~ ~if(properties)~{ ~properties:{it|~it.name~: ~it.value~};separator=\", \"~ }~endif~) >>";
}  