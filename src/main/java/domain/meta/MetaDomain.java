package domain.meta;

public interface MetaDomain {

	String name();
	java.util.stream.Stream<MetaProperty> properties();

	interface MetaProperty {

		String name();
		java.util.Optional<Quantifier> quantifier();
		java.util.Optional<String> type();
		java.util.Optional<MetaDomain> typeDeclaration();

	}

	enum Quantifier {

		ONE,
		MANY,
		OPTIONAL

	}


}