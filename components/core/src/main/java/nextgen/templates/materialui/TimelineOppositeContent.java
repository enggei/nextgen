package nextgen.templates.materialui;

public class TimelineOppositeContent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	TimelineOppositeContent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TimelineOppositeContent");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TimelineOppositeContent that = (TimelineOppositeContent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TimelineOppositeContent() ::= <<TimelineOppositeContent\n" + 
				"\n" + 
				"	TimelineOppositeContentImport\n" + 
				"\n" + 
				"	TimelineOppositeContentElement >>";
}  