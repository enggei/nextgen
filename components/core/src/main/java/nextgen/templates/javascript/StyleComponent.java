package nextgen.templates.javascript;

public class StyleComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _elements = new java.util.ArrayList<>();

	StyleComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StyleComponent");
		for (Object o : _elements) st.add("elements", o);
		return st.render().trim();
	}


	public StyleComponent addElements(Object value) {
		this._elements.add(value);
		return this;
	}

	public StyleComponent removeElements(Object value) {
		this._elements.remove(value);
		return this;
	}

	public StyleComponent removeElements(int index) {
		this._elements.remove(index);
		return this;
	}

	public java.util.List<Object> getElements() {
		return this._elements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StyleComponent that = (StyleComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StyleComponent(elements) ::= <<const useStyles = theme => ({\n" + 
				"	~elements:{it|~it~};separator=\",\\n\"~\n" + 
				"	});>> ";
}  