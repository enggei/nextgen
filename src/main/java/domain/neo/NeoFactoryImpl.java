package domain.neo;

import domain.meta.*;

import static domain.DomainProcessor.*;

public class NeoFactoryImpl implements NeoFactory {

	 String name;
	 String packageName;
	 NeoSchema schema;

	public NeoFactoryImpl(String name, String packageName, NeoSchema schema) {
		this.name = name;
		this.packageName = packageName;
		this.schema = schema;
	}

	@Override
	public String name() { return name; }

	@Override
	public NeoFactory setname(String element) { name = element; return this; }

	@Override
	public String packageName() { return packageName; }

	@Override
	public NeoFactory setpackageName(String element) { packageName = element; return this; }

	@Override
	public NeoSchema schema() { return schema; }

	@Override
	public NeoFactory setschema(NeoSchema element) { schema = element; return this; }

	@Override 
	public NeoSchemaBuilder newNeoSchema(String name) { return new NeoSchemaBuilderImpl(name); }

	public static final class NeoSchemaBuilderImpl implements NeoSchemaBuilder {

		private String name;
		private final java.util.List<NeoEntity> entities =  new java.util.ArrayList<>();

		NeoSchemaBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public NeoSchemaBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.stream.Stream<NeoEntity> entities() { return entities.stream(); }

		@Override 
		public NeoSchemaBuilder addentities(NeoEntity element) { entities.add(element); return this; }

	}

	@Override 
	public NeoEntityBuilder newNeoEntity(String name) { return new NeoEntityBuilderImpl(name); }

	public static final class NeoEntityBuilderImpl implements NeoEntityBuilder {

		private String name;
		private final java.util.List<NeoProperty> properties =  new java.util.ArrayList<>();

		NeoEntityBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public NeoEntityBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.stream.Stream<NeoProperty> properties() { return properties.stream(); }

		@Override 
		public NeoEntityBuilder addproperties(NeoProperty element) { properties.add(element); return this; }

	}

	@Override 
	public NeoPropertyBuilder newNeoProperty(String name, Quantifier quantifier, Type type) { return new NeoPropertyBuilderImpl(name, quantifier, type); }

	public static final class NeoPropertyBuilderImpl implements NeoPropertyBuilder {

		private String name;
		private Quantifier quantifier;
		private Type type;

		NeoPropertyBuilderImpl(String name, Quantifier quantifier, Type type) {
			this.name = name;
			this.quantifier = quantifier;
			this.type = type;
		}

		@Override
		public String name() { return name; }

		@Override 
		public NeoPropertyBuilder setname(String element) { name = element; return this; }

		@Override
		public Quantifier quantifier() { return quantifier; }

		@Override 
		public NeoPropertyBuilder setquantifier(Quantifier element) { quantifier = element; return this; }

		@Override
		public Type type() { return type; }

		@Override 
		public NeoPropertyBuilder settype(Type element) { type = element; return this; }

	}

	public static MetaDomain newNeo() {

		final MetaDomainFactory domain = new MetaDomainFactoryImpl("Neo");

		final MetaDomainFactory Type = newDomain("Type")
				.addproperties(enumerate(domain, "PRIMITIVE"))
				.addproperties(enumerate(domain, "ENUM"))
				.addproperties(enumerate(domain, "REFERENCE"));

		final MetaDomainFactory Quantifier = newDomain("Quantifier")
				.addproperties(enumerate(domain, "ONE"))
				.addproperties(enumerate(domain, "MANY"));

		final MetaDomainFactory NeoProperty = newDomain("NeoProperty")
				.addproperties(single(domain, "name", "String"))
				.addproperties(single(domain, "quantifier", "Quantifier", Quantifier))
				.addproperties(single(domain, "type", "Type", Type));

		final MetaDomainFactory NeoEntity = newDomain("NeoEntity")
				.addproperties(single(domain, "name", "String"))
				.addproperties(many(domain, "properties", "NeoProperty", NeoProperty));

		final MetaDomainFactory NeoSchema = newDomain("NeoSchema")
				.addproperties(single(domain, "name", "String"))
				.addproperties(many(domain, "entities", "NeoEntity", NeoEntity));

		domain.addproperties(single(domain, "name", "String"));
		domain.addproperties(single(domain, "packageName", "String"));
		domain.addproperties(single(domain, "schema", "NeoSchema", NeoSchema));

		return domain;
	}
}