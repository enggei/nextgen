package domain.neo;

public interface NeoFactory extends Neo {

	NeoFactory setname(String value);
	NeoFactory setpackageName(String value);
	NeoFactory setschema(NeoSchema value);

	NeoSchemaBuilder newNeoSchema(String name);

	interface NeoSchemaBuilder extends NeoSchema {
		NeoSchemaBuilder setname(String element);
		NeoSchemaBuilder addentities(NeoEntity element);
	}

	NeoEntityBuilder newNeoEntity(String name);

	interface NeoEntityBuilder extends NeoEntity {
		NeoEntityBuilder setname(String element);
		NeoEntityBuilder addproperties(NeoProperty element);
	}

	NeoPropertyBuilder newNeoProperty(String name, Quantifier quantifier, Type type);

	interface NeoPropertyBuilder extends NeoProperty {
		NeoPropertyBuilder setname(String element);
		NeoPropertyBuilder setquantifier(Quantifier element);
		NeoPropertyBuilder settype(Type element);
	}

}