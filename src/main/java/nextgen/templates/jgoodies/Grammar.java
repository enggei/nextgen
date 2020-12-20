package nextgen.templates.jgoodies;

public class Grammar {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Grammar(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("grammar");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grammar that = (Grammar) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "grammar() ::= <<columnSpecs ::= columnSpec+ \n" + 
				"rowSpecs ::= rowSpec+\n" + 
				"\n" + 
				"columnSpec ::= [columnAlignment:] size [:resizeBehavior]\n" + 
				"rowSpec ::= [rowAlignment :] size [:resizeBehavior]\n" + 
				"columnAlignment ::= LEFT | CENTER | RIGHT | FILL | L | C | R | F\n" + 
				"rowAlignment ::= TOP | CENTER | BOTTOM | FILL | T | C | B | F\n" + 
				"size ::= constantSize | componentSize | boundedSize\n" + 
				"componentSize ::= MIN | PREF | DEFAULT | M | P | D\n" + 
				"constantSize ::= {integer}integerUnit | {double}doubleUnit\n" + 
				"integerUnit ::= PX | PT | DLU\n" + 
				"doubleUnit ::= IN | MM | CM\n" + 
				"boundedSize ::= MIN(constantSize;componentSize) | MAX(constantSize;componentSize)\n" + 
				"resizeBehavior ::= NONE | GROW | GROW({double) | G({double})\n" + 
				"\n" + 
				"\n" + 
				"constraints ::= column, row [, colSpan, rowSpan][, hAlign, vAlign]\n" + 
				"column ::= {an integer}\n" + 
				"row ::= {an integer}\n" + 
				"colSpan ::= {an integer}\n" + 
				"rowSpan ::= {an integer}\n" + 
				"hAlign ::= LEFT | CENTER | RIGHT | DEFAULT | FILL | L | C | R | D | F\n" + 
				"vAlign ::= TOP | CENTER | BOTTOM | DEFAULT | FILL | T | C | B | D | F >>";
}  