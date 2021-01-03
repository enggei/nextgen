package domain.meta;

public class MetaDomainFactoryImpl implements MetaDomainFactory {

	private String name;
	private final java.util.List<MetaProperty> properties =  new java.util.ArrayList<>();

	@Override
	public String name() { return name; }

	@Override
	public MetaDomainFactory setname(String element) { name = element; return this; }

	@Override
	public java.util.stream.Stream<MetaProperty> properties() { return properties.stream(); }

	@Override
	public MetaDomainFactory addproperties(MetaProperty element) { properties.add(element); return this; }

	@Override 
	public MetaPropertyBuilder newMetaProperty() { return new MetaPropertyBuilderImpl(); }

	public class MetaPropertyBuilderImpl implements MetaPropertyBuilder {

		private String name;
		private Quantifier quantifier;
		private String type;
		private MetaDomain typeDeclaration;

		@Override
		public String name() { return name; }

		@Override 
		public MetaPropertyBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.Optional<Quantifier> quantifier() { return java.util.Optional.ofNullable(quantifier); }

		@Override 
		public MetaPropertyBuilder setquantifier(Quantifier element) { quantifier = element; return this; }

		@Override
		public java.util.Optional<String> type() { return java.util.Optional.ofNullable(type); }

		@Override 
		public MetaPropertyBuilder settype(String element) { type = element; return this; }

		@Override
		public java.util.Optional<MetaDomain> typeDeclaration() { return java.util.Optional.ofNullable(typeDeclaration); }

		@Override 
		public MetaPropertyBuilder settypeDeclaration(MetaDomain element) { typeDeclaration = element; return this; }

	}


}