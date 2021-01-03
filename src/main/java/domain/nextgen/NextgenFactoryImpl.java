package domain.nextgen;

public class NextgenFactoryImpl implements NextgenFactory {

	private final java.util.List<STProject> projects =  new java.util.ArrayList<>();
	private final java.util.List<STGroup> groups =  new java.util.ArrayList<>();

	@Override
	public java.util.stream.Stream<STProject> projects() { return projects.stream(); }

	@Override
	public NextgenFactory addprojects(STProject element) { projects.add(element); return this; }

	@Override
	public java.util.stream.Stream<STGroup> groups() { return groups.stream(); }

	@Override
	public NextgenFactory addgroups(STGroup element) { groups.add(element); return this; }

	@Override 
	public STProjectBuilder newSTProject(String name, String root) { return new STProjectBuilderImpl(name, root); }

	public class STProjectBuilderImpl implements STProjectBuilder {

		private String name;
		private String root;
		private final java.util.List<STModel> models =  new java.util.ArrayList<>();
		private final java.util.List<STValue> values =  new java.util.ArrayList<>();

		STProjectBuilderImpl(String name, String root) {
			this.name = name;
			this.root = root;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STProjectBuilder setname(String element) { name = element; return this; }

		@Override
		public String root() { return root; }

		@Override 
		public STProjectBuilder setroot(String element) { root = element; return this; }

		@Override
		public java.util.stream.Stream<STModel> models() { return models.stream(); }

		@Override 
		public STProjectBuilder addmodels(STModel element) { models.add(element); return this; }

		@Override
		public java.util.stream.Stream<STValue> values() { return values.stream(); }

		@Override 
		public STProjectBuilder addvalues(STValue element) { values.add(element); return this; }

	}

	@Override 
	public STModelBuilder newSTModel(STTemplate stTemplate) { return new STModelBuilderImpl(stTemplate); }

	public class STModelBuilderImpl implements STModelBuilder {

		private STTemplate stTemplate;
		private final java.util.List<STFile> files =  new java.util.ArrayList<>();
		private final java.util.List<STArgument> arguments =  new java.util.ArrayList<>();

		STModelBuilderImpl(STTemplate stTemplate) {
			this.stTemplate = stTemplate;
		}

		@Override
		public STTemplate stTemplate() { return stTemplate; }

		@Override 
		public STModelBuilder setstTemplate(STTemplate element) { stTemplate = element; return this; }

		@Override
		public java.util.stream.Stream<STFile> files() { return files.stream(); }

		@Override 
		public STModelBuilder addfiles(STFile element) { files.add(element); return this; }

		@Override
		public java.util.stream.Stream<STArgument> arguments() { return arguments.stream(); }

		@Override 
		public STModelBuilder addarguments(STArgument element) { arguments.add(element); return this; }

	}

	@Override 
	public STFileBuilder newSTFile(STValue type, STValue packageName, STValue path) { return new STFileBuilderImpl(type, packageName, path); }

	public class STFileBuilderImpl implements STFileBuilder {

		private STValue type;
		private STValue packageName;
		private STValue path;

		STFileBuilderImpl(STValue type, STValue packageName, STValue path) {
			this.type = type;
			this.packageName = packageName;
			this.path = path;
		}

		@Override
		public STValue type() { return type; }

		@Override 
		public STFileBuilder settype(STValue element) { type = element; return this; }

		@Override
		public STValue packageName() { return packageName; }

		@Override 
		public STFileBuilder setpackageName(STValue element) { packageName = element; return this; }

		@Override
		public STValue path() { return path; }

		@Override 
		public STFileBuilder setpath(STValue element) { path = element; return this; }

	}

	@Override 
	public STArgumentBuilder newSTArgument(STParameter stParameter, STValue value) { return new STArgumentBuilderImpl(stParameter, value); }

	public class STArgumentBuilderImpl implements STArgumentBuilder {

		private STParameter stParameter;
		private STValue value;
		private final java.util.List<STArgumentKV> keyValues =  new java.util.ArrayList<>();

		STArgumentBuilderImpl(STParameter stParameter, STValue value) {
			this.stParameter = stParameter;
			this.value = value;
		}

		@Override
		public STParameter stParameter() { return stParameter; }

		@Override 
		public STArgumentBuilder setstParameter(STParameter element) { stParameter = element; return this; }

		@Override
		public STValue value() { return value; }

		@Override 
		public STArgumentBuilder setvalue(STValue element) { value = element; return this; }

		@Override
		public java.util.stream.Stream<STArgumentKV> keyValues() { return keyValues.stream(); }

		@Override 
		public STArgumentBuilder addkeyValues(STArgumentKV element) { keyValues.add(element); return this; }

	}

	@Override 
	public STArgumentKVBuilder newSTArgumentKV(STParameterKey stParameterKey, STValue values) { return new STArgumentKVBuilderImpl(stParameterKey, values); }

	public class STArgumentKVBuilderImpl implements STArgumentKVBuilder {

		private STParameterKey stParameterKey;
		private STValue values;

		STArgumentKVBuilderImpl(STParameterKey stParameterKey, STValue values) {
			this.stParameterKey = stParameterKey;
			this.values = values;
		}

		@Override
		public STParameterKey stParameterKey() { return stParameterKey; }

		@Override 
		public STArgumentKVBuilder setstParameterKey(STParameterKey element) { stParameterKey = element; return this; }

		@Override
		public STValue values() { return values; }

		@Override 
		public STArgumentKVBuilder setvalues(STValue element) { values = element; return this; }

	}

	@Override 
	public STValueBuilder newSTValue(STValueType type) { return new STValueBuilderImpl(type); }

	public class STValueBuilderImpl implements STValueBuilder {

		private STValueType type;
		private String value;
		private STModel stModel;
		private STEnumValue stEnum;

		STValueBuilderImpl(STValueType type) {
			this.type = type;
		}

		@Override
		public STValueType type() { return type; }

		@Override 
		public STValueBuilder settype(STValueType element) { type = element; return this; }

		@Override
		public java.util.Optional<String> value() { return java.util.Optional.ofNullable(value); }

		@Override 
		public STValueBuilder setvalue(String element) { value = element; return this; }

		@Override
		public java.util.Optional<STModel> stModel() { return java.util.Optional.ofNullable(stModel); }

		@Override 
		public STValueBuilder setstModel(STModel element) { stModel = element; return this; }

		@Override
		public java.util.Optional<STEnumValue> stEnum() { return java.util.Optional.ofNullable(stEnum); }

		@Override 
		public STValueBuilder setstEnum(STEnumValue element) { stEnum = element; return this; }

	}

	@Override 
	public STGroupBuilder newSTGroup(String name) { return new STGroupBuilderImpl(name); }

	public class STGroupBuilderImpl implements STGroupBuilder {

		private String name;
		private final java.util.List<STGroupFile> files =  new java.util.ArrayList<>();
		private final java.util.List<STTemplate> templates =  new java.util.ArrayList<>();
		private final java.util.List<STInterface> interfaces =  new java.util.ArrayList<>();
		private final java.util.List<STEnum> enums =  new java.util.ArrayList<>();
		private final java.util.List<STAction> actions =  new java.util.ArrayList<>();

		STGroupBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STGroupBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.stream.Stream<STGroupFile> files() { return files.stream(); }

		@Override 
		public STGroupBuilder addfiles(STGroupFile element) { files.add(element); return this; }

		@Override
		public java.util.stream.Stream<STTemplate> templates() { return templates.stream(); }

		@Override 
		public STGroupBuilder addtemplates(STTemplate element) { templates.add(element); return this; }

		@Override
		public java.util.stream.Stream<STInterface> interfaces() { return interfaces.stream(); }

		@Override 
		public STGroupBuilder addinterfaces(STInterface element) { interfaces.add(element); return this; }

		@Override
		public java.util.stream.Stream<STEnum> enums() { return enums.stream(); }

		@Override 
		public STGroupBuilder addenums(STEnum element) { enums.add(element); return this; }

		@Override
		public java.util.stream.Stream<STAction> actions() { return actions.stream(); }

		@Override 
		public STGroupBuilder addactions(STAction element) { actions.add(element); return this; }

	}

	@Override 
	public STGroupFileBuilder newSTGroupFile(STValue packageName, STValue path) { return new STGroupFileBuilderImpl(packageName, path); }

	public class STGroupFileBuilderImpl implements STGroupFileBuilder {

		private STValue packageName;
		private STValue path;

		STGroupFileBuilderImpl(STValue packageName, STValue path) {
			this.packageName = packageName;
			this.path = path;
		}

		@Override
		public STValue packageName() { return packageName; }

		@Override 
		public STGroupFileBuilder setpackageName(STValue element) { packageName = element; return this; }

		@Override
		public STValue path() { return path; }

		@Override 
		public STGroupFileBuilder setpath(STValue element) { path = element; return this; }

	}

	@Override 
	public STTemplateBuilder newSTTemplate(String name, String text) { return new STTemplateBuilderImpl(name, text); }

	public class STTemplateBuilderImpl implements STTemplateBuilder {

		private String name;
		private String text;
		private final java.util.List<STInterface> interfaces =  new java.util.ArrayList<>();
		private final java.util.List<STParameter> parameter =  new java.util.ArrayList<>();
		private final java.util.List<STTemplate> children =  new java.util.ArrayList<>();

		STTemplateBuilderImpl(String name, String text) {
			this.name = name;
			this.text = text;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STTemplateBuilder setname(String element) { name = element; return this; }

		@Override
		public String text() { return text; }

		@Override 
		public STTemplateBuilder settext(String element) { text = element; return this; }

		@Override
		public java.util.stream.Stream<STInterface> interfaces() { return interfaces.stream(); }

		@Override 
		public STTemplateBuilder addinterfaces(STInterface element) { interfaces.add(element); return this; }

		@Override
		public java.util.stream.Stream<STParameter> parameter() { return parameter.stream(); }

		@Override 
		public STTemplateBuilder addparameter(STParameter element) { parameter.add(element); return this; }

		@Override
		public java.util.stream.Stream<STTemplate> children() { return children.stream(); }

		@Override 
		public STTemplateBuilder addchildren(STTemplate element) { children.add(element); return this; }

	}

	@Override 
	public STParameterBuilder newSTParameter(String name, STParameterType type, String argumentType) { return new STParameterBuilderImpl(name, type, argumentType); }

	public class STParameterBuilderImpl implements STParameterBuilder {

		private String name;
		private STParameterType type;
		private final java.util.List<STParameterKey> keys =  new java.util.ArrayList<>();
		private String argumentType;

		STParameterBuilderImpl(String name, STParameterType type, String argumentType) {
			this.name = name;
			this.type = type;
			this.argumentType = argumentType;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STParameterBuilder setname(String element) { name = element; return this; }

		@Override
		public STParameterType type() { return type; }

		@Override 
		public STParameterBuilder settype(STParameterType element) { type = element; return this; }

		@Override
		public java.util.stream.Stream<STParameterKey> keys() { return keys.stream(); }

		@Override 
		public STParameterBuilder addkeys(STParameterKey element) { keys.add(element); return this; }

		@Override
		public String argumentType() { return argumentType; }

		@Override 
		public STParameterBuilder setargumentType(String element) { argumentType = element; return this; }

	}

	@Override 
	public STParameterKeyBuilder newSTParameterKey(String name, STInterface argumentType) { return new STParameterKeyBuilderImpl(name, argumentType); }

	public class STParameterKeyBuilderImpl implements STParameterKeyBuilder {

		private String name;
		private STInterface argumentType;

		STParameterKeyBuilderImpl(String name, STInterface argumentType) {
			this.name = name;
			this.argumentType = argumentType;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STParameterKeyBuilder setname(String element) { name = element; return this; }

		@Override
		public STInterface argumentType() { return argumentType; }

		@Override 
		public STParameterKeyBuilder setargumentType(STInterface element) { argumentType = element; return this; }

	}

	@Override 
	public STInterfaceBuilder newSTInterface(String name) { return new STInterfaceBuilderImpl(name); }

	public class STInterfaceBuilderImpl implements STInterfaceBuilder {

		private String name;

		STInterfaceBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STInterfaceBuilder setname(String element) { name = element; return this; }

	}

	@Override 
	public STEnumBuilder newSTEnum(String name) { return new STEnumBuilderImpl(name); }

	public class STEnumBuilderImpl implements STEnumBuilder {

		private String name;
		private final java.util.List<STEnumValue> values =  new java.util.ArrayList<>();

		STEnumBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STEnumBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.stream.Stream<STEnumValue> values() { return values.stream(); }

		@Override 
		public STEnumBuilder addvalues(STEnumValue element) { values.add(element); return this; }

	}

	@Override 
	public STEnumValueBuilder newSTEnumValue(String name, String lexical) { return new STEnumValueBuilderImpl(name, lexical); }

	public class STEnumValueBuilderImpl implements STEnumValueBuilder {

		private String name;
		private String lexical;

		STEnumValueBuilderImpl(String name, String lexical) {
			this.name = name;
			this.lexical = lexical;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STEnumValueBuilder setname(String element) { name = element; return this; }

		@Override
		public String lexical() { return lexical; }

		@Override 
		public STEnumValueBuilder setlexical(String element) { lexical = element; return this; }

	}

	@Override 
	public STActionBuilder newSTAction(String name) { return new STActionBuilderImpl(name); }

	public class STActionBuilderImpl implements STActionBuilder {

		private String name;
		private final java.util.List<String> statements =  new java.util.ArrayList<>();
		private final java.util.List<String> imports =  new java.util.ArrayList<>();
		private final java.util.List<String> methods =  new java.util.ArrayList<>();

		STActionBuilderImpl(String name) {
			this.name = name;
		}

		@Override
		public String name() { return name; }

		@Override 
		public STActionBuilder setname(String element) { name = element; return this; }

		@Override
		public java.util.stream.Stream<String> statements() { return statements.stream(); }

		@Override 
		public STActionBuilder addstatements(String element) { statements.add(element); return this; }

		@Override
		public java.util.stream.Stream<String> imports() { return imports.stream(); }

		@Override 
		public STActionBuilder addimports(String element) { imports.add(element); return this; }

		@Override
		public java.util.stream.Stream<String> methods() { return methods.stream(); }

		@Override 
		public STActionBuilder addmethods(String element) { methods.add(element); return this; }

	}
}