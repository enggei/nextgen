package nextgen.templates.nextgen;

public class DomainVisitor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	DomainVisitor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVisitor");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVisitor that = (DomainVisitor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainVisitor() ::= <<final java.util.List<DomainEntity> entities = domain.getEntitiesSorted().collect(Collectors.toList());\n" + 
				"final java.util.List<DomainRelation> relations = domain.getRelationsSorted().collect(Collectors.toList());\n" + 
				"\n" + 
				"onDomain(domain.getName());\n" + 
				"\n" + 
				"for (DomainEntity entity : entities)\n" + 
				"	onEntity(entity);\n" + 
				"\n" + 
				"for (DomainRelation relation : relations)\n" + 
				"	onRelation(relation);\n" + 
				"\n" + 
				"onComplete(); >>";
}  