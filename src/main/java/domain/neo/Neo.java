package domain.neo;

public interface Neo {

	String name();
	String packageName();
	NeoSchema schema();

	interface NeoSchema {

		String name();
		java.util.stream.Stream<NeoEntity> entities();

	}

	interface NeoEntity {

		String name();
		java.util.stream.Stream<NeoProperty> properties();

	}

	interface NeoProperty {

		String name();
		Quantifier quantifier();
		Type type();

	}

	enum Quantifier {

		ONE,
		MANY

	}

	enum Type {

		PRIMITIVE,
		ENUM,
		REFERENCE

	}
}