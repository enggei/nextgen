package domain.nextgen;

public interface Nextgen {

	java.util.stream.Stream<STProject> projects();
	java.util.stream.Stream<STGroup> groups();

	interface STProject {

		String name();
		String root();
		java.util.stream.Stream<STModel> models();
		java.util.stream.Stream<STValue> values();

	}

	interface STModel {

		STTemplate stTemplate();
		java.util.stream.Stream<STFile> files();
		java.util.stream.Stream<STArgument> arguments();

	}

	interface STFile {

		STValue type();
		STValue packageName();
		STValue path();

	}

	interface STArgument {

		STParameter stParameter();
		STValue value();
		java.util.stream.Stream<STArgumentKV> keyValues();

	}

	interface STArgumentKV {

		STParameterKey stParameterKey();
		STValue values();

	}

	interface STValue {

		STValueType type();
		java.util.Optional<String> value();
		java.util.Optional<STModel> stModel();
		java.util.Optional<STEnumValue> stEnum();

	}

	enum STValueType {

		STMODEL,
		PRIMITIVE,
		ENUM

	}

	interface STGroup {

		String name();
		java.util.stream.Stream<STGroupFile> files();
		java.util.stream.Stream<STTemplate> templates();
		java.util.stream.Stream<STInterface> interfaces();
		java.util.stream.Stream<STEnum> enums();
		java.util.stream.Stream<STAction> actions();

	}

	interface STGroupFile {

		STValue packageName();
		STValue path();

	}

	interface STTemplate {

		String name();
		String text();
		java.util.stream.Stream<STInterface> interfaces();
		java.util.stream.Stream<STParameter> parameter();
		java.util.stream.Stream<STTemplate> children();

	}

	interface STParameter {

		String name();
		STParameterType type();
		java.util.stream.Stream<STParameterKey> keys();
		String argumentType();

	}

	enum STParameterType {

		SINGLE,
		LIST,
		KVLIST

	}

	interface STParameterKey {

		String name();
		STInterface argumentType();

	}

	interface STInterface {

		String name();

	}

	interface STEnum {

		String name();
		java.util.stream.Stream<STEnumValue> values();

	}

	interface STEnumValue {

		String name();
		String lexical();

	}

	interface STAction {

		String name();
		java.util.stream.Stream<String> statements();
		java.util.stream.Stream<String> imports();
		java.util.stream.Stream<String> methods();

	}
}