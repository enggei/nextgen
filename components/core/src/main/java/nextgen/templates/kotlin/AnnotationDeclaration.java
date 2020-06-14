package nextgen.templates.kotlin;

public class AnnotationDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _annotations = new java.util.ArrayList<>();

	AnnotationDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationDeclaration");
		for (java.util.Map<String, Object> map : _annotations) st.addAggr("annotations.{name,params}", map.get("name"), map.get("params"));
		return st.render().trim();
	}



	public AnnotationDeclaration addAnnotations(Object _name, Object _params) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("params", _params);
		this._annotations.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAnnotations() {
		return this._annotations;
	}

	public AnnotationDeclaration addAnnotations(AnnotationDeclaration_Annotations value) {
		return addAnnotations(value._name, value._params);
	}

	public java.util.stream.Stream<AnnotationDeclaration_Annotations> streamAnnotations() {
		return this._annotations.stream().map(AnnotationDeclaration_Annotations::new);
	}

	public static final class AnnotationDeclaration_Annotations {

		Object _name;
		Object _params;

		public AnnotationDeclaration_Annotations(Object _name, Object _params) {
			this._name = _name;
			this._params = _params;
		}

		private AnnotationDeclaration_Annotations(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._params = (Object) map.get("params");
		}

		public Object getName() {
			return this._name;
		}

		public Object getParams() {
			return this._params;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnnotationDeclaration that = (AnnotationDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AnnotationDeclaration(annotations) ::= <<~annotations:{it|@~it.name~(~it.params~)};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~ >>";
} 