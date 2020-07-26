package nextgen.templates.materialui;

public class TextareaAutosize {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	TextareaAutosize(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TextareaAutosize");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TextareaAutosize that = (TextareaAutosize) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TextareaAutosize() ::= <<TextareaAutosize\n" + 
				"\n" + 
				"	TextareaAutosizeImport\n" + 
				"\n" + 
				"	TextareaAutosizeElement >>";
}  