package nextgen.templates.domain;

public class TemplateTransformer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	TemplateTransformer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TemplateTransformer");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TemplateTransformer that = (TemplateTransformer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TemplateTransformer() ::= <<public static abstract class TemplateDomainTransformer<T> implements DomainTransformer<T> {\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public T transform(MetaDomain domain) {\n" + 
				"\n" + 
				"		onDomain(domain);\n" + 
				"\n" + 
				"		domain.properties()\n" + 
				"				.filter(metaProperty -> metaProperty.type().isPresent())\n" + 
				"				.forEach(this::onProperty);\n" + 
				"\n" + 
				"		final Set<MetaDomain> entities = getEntities(domain);\n" + 
				"		for (MetaDomain entity : entities) onEntity(entity);\n" + 
				"\n" + 
				"		return onComplete();\n" + 
				"	}\n" + 
				"\n" + 
				"	protected abstract void onDomain(MetaDomain domain);\n" + 
				"\n" + 
				"	protected abstract void onProperty(MetaDomain.MetaProperty metaProperty);\n" + 
				"\n" + 
				"	protected abstract void onEntity(MetaDomain entity);\n" + 
				"\n" + 
				"	protected abstract T onComplete();\n" + 
				"\n" + 
				"	protected boolean isInterface(MetaDomain entity) {\n" + 
				"		return entity.properties().anyMatch(metaProperty -> metaProperty.quantifier().isPresent());\n" + 
				"	}\n" + 
				"\n" + 
				"	protected Object quantifier(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		return metaProperty.quantifier().orElse(null);\n" + 
				"	}\n" + 
				"	\n" + 
				"	protected Object name(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		return metaProperty.name();\n" + 
				"	}\n" + 
				"	\n" + 
				"	protected Object type(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		return metaProperty.type().orElse(null);\n" + 
				"	}\n" + 
				"	\n" + 
				"	protected Object typeDeclaration(MetaDomain.MetaProperty metaProperty) {\n" + 
				"		return metaProperty.typeDeclaration().orElse(null);\n" + 
				"	}\n" + 
				"\n" + 
				"	Set<MetaDomain> getEntities(MetaDomain domain) {\n" + 
				"		final LinkedHashSet<MetaDomain> set = new LinkedHashSet<>();\n" + 
				"\n" + 
				"		domain.properties()\n" + 
				"				.filter(metaProperty -> metaProperty.typeDeclaration().isPresent())\n" + 
				"				.map(metaProperty -> metaProperty.typeDeclaration().get())\n" + 
				"				.forEach(metaDomain -> addEntity(metaDomain, set));\n" + 
				"\n" + 
				"		return set;\n" + 
				"	}\n" + 
				"\n" + 
				"	private void addEntity(MetaDomain domain, LinkedHashSet<MetaDomain> set) {\n" + 
				"		set.add(domain);\n" + 
				"		domain.properties()\n" + 
				"				.filter(metaProperty -> metaProperty.typeDeclaration().isPresent())\n" + 
				"				.map(metaProperty -> metaProperty.typeDeclaration().get())\n" + 
				"				.forEach(metaDomain -> addEntity(metaDomain, set));\n" + 
				"	}\n" + 
				"} >>";
}  