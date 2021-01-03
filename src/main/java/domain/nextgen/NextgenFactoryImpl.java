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
	public STProjectBuilder newSTProject() { return new STProjectBuilderImpl(); }

	public class STProjectBuilderImpl implements STProjectBuilder {

		private String name;
		private String root;
		private final java.util.List<STModel> models =  new java.util.ArrayList<>();
		private final java.util.List<STValue> values =  new java.util.ArrayList<>();

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
	public STModelBuilder newSTModel() { return new STModelBuilderImpl(); }

	public class STModelBuilderImpl implements STModelBuilder {

		private STTemplate stTemplate;
		private final java.util.List<STFile> files =  new java.util.ArrayList<>();
		private final java.util.List<STArgument> arguments =  new java.util.ArrayList<>();

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
	public STFileBuilder newSTFile() { return new STFileBuilderImpl(); }

	public class STFileBuilderImpl implements STFileBuilder {

		private STValue type;
		private STValue packageName;
		private STValue path;

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
	public STArgumentBuilder newSTArgument() { return new STArgumentBuilderImpl(); }

	public class STArgumentBuilderImpl implements STArgumentBuilder {

		private STParameter stParameter;
		private STValue value;
		private final java.util.List<STArgumentKV> keyValues =  new java.util.ArrayList<>();

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
	public STArgumentKVBuilder newSTArgumentKV() { return new STArgumentKVBuilderImpl(); }

	public class STArgumentKVBuilderImpl implements STArgumentKVBuilder {

		private STParameterKey stParameterKey;
		private STValue values;

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
	public STValueBuilder newSTValue() { return new STValueBuilderImpl(); }

	public class STValueBuilderImpl implements STValueBuilder {

		private STValueType type;
		private String value;
		private STModel stModel;
		private STEnumValue stEnum;

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
	public STGroupBuilder newSTGroup() { return new STGroupBuilderImpl(); }

	public class STGroupBuilderImpl implements STGroupBuilder {

		private String name;
		private final java.util.List<STGroupFile> files =  new java.util.ArrayList<>();
		private final java.util.List<STTemplate> templates =  new java.util.ArrayList<>();
		private final java.util.List<STInterface> interfaces =  new java.util.ArrayList<>();
		private final java.util.List<STEnum> enums =  new java.util.ArrayList<>();
		private final java.util.List<STAction> actions =  new java.util.ArrayList<>();

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
	public STGroupFileBuilder newSTGroupFile() { return new STGroupFileBuilderImpl(); }

	public class STGroupFileBuilderImpl implements STGroupFileBuilder {

		private STValue packageName;
		private STValue path;

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
	public STTemplateBuilder newSTTemplate() { return new STTemplateBuilderImpl(); }

	public class STTemplateBuilderImpl implements STTemplateBuilder {

		private String name;
		private String text;
		private final java.util.List<STInterface> interfaces =  new java.util.ArrayList<>();
		private final java.util.List<STParameter> parameter =  new java.util.ArrayList<>();
		private final java.util.List<STTemplate> children =  new java.util.ArrayList<>();

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
	public STParameterBuilder newSTParameter() { return new STParameterBuilderImpl(); }

	public class STParameterBuilderImpl implements STParameterBuilder {

		private String name;
		private STParameterType type;
		private final java.util.List<STParameterKey> keys =  new java.util.ArrayList<>();
		private String argumentType;

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
	public STParameterKeyBuilder newSTParameterKey() { return new STParameterKeyBuilderImpl(); }

	public class STParameterKeyBuilderImpl implements STParameterKeyBuilder {

		private String name;
		private STInterface argumentType;

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
	public STInterfaceBuilder newSTInterface() { return new STInterfaceBuilderImpl(); }

	public class STInterfaceBuilderImpl implements STInterfaceBuilder {

		private String name;

		@Override
		public String name() { return name; }

		@Override 
		public STInterfaceBuilder setname(String element) { name = element; return this; }

	}

	@Override 
	public STEnumBuilder newSTEnum() { return new STEnumBuilderImpl(); }

	public class STEnumBuilderImpl implements STEnumBuilder {

		private String name;
		private final java.util.List<STEnumValue> values =  new java.util.ArrayList<>();

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
	public STEnumValueBuilder newSTEnumValue() { return new STEnumValueBuilderImpl(); }

	public class STEnumValueBuilderImpl implements STEnumValueBuilder {

		private String name;
		private String lexical;

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
	public STActionBuilder newSTAction() { return new STActionBuilderImpl(); }

	public class STActionBuilderImpl implements STActionBuilder {

		private String name;
		private final java.util.List<String> statements =  new java.util.ArrayList<>();
		private final java.util.List<String> imports =  new java.util.ArrayList<>();
		private final java.util.List<String> methods =  new java.util.ArrayList<>();

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