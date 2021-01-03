package domain.nextgen;

public interface NextgenFactory extends Nextgen {

	NextgenFactory addprojects(STProject value);
	NextgenFactory addgroups(STGroup value);

	STProjectBuilder newSTProject(String name, String root);

	interface STProjectBuilder extends STProject {
		STProjectBuilder setname(String element);
		STProjectBuilder setroot(String element);
		STProjectBuilder addmodels(STModel element);
		STProjectBuilder addvalues(STValue element);
	}

	STModelBuilder newSTModel(STTemplate stTemplate);

	interface STModelBuilder extends STModel {
		STModelBuilder setstTemplate(STTemplate element);
		STModelBuilder addfiles(STFile element);
		STModelBuilder addarguments(STArgument element);
	}

	STFileBuilder newSTFile(STValue type, STValue packageName, STValue path);

	interface STFileBuilder extends STFile {
		STFileBuilder settype(STValue element);
		STFileBuilder setpackageName(STValue element);
		STFileBuilder setpath(STValue element);
	}

	STArgumentBuilder newSTArgument(STParameter stParameter, STValue value);

	interface STArgumentBuilder extends STArgument {
		STArgumentBuilder setstParameter(STParameter element);
		STArgumentBuilder setvalue(STValue element);
		STArgumentBuilder addkeyValues(STArgumentKV element);
	}

	STArgumentKVBuilder newSTArgumentKV(STParameterKey stParameterKey, STValue values);

	interface STArgumentKVBuilder extends STArgumentKV {
		STArgumentKVBuilder setstParameterKey(STParameterKey element);
		STArgumentKVBuilder setvalues(STValue element);
	}

	STValueBuilder newSTValue(STValueType type);

	interface STValueBuilder extends STValue {
		STValueBuilder settype(STValueType element);
		STValueBuilder setvalue(String element);
		STValueBuilder setstModel(STModel element);
		STValueBuilder setstEnum(STEnumValue element);
	}

	STGroupBuilder newSTGroup(String name);

	interface STGroupBuilder extends STGroup {
		STGroupBuilder setname(String element);
		STGroupBuilder addfiles(STGroupFile element);
		STGroupBuilder addtemplates(STTemplate element);
		STGroupBuilder addinterfaces(STInterface element);
		STGroupBuilder addenums(STEnum element);
		STGroupBuilder addactions(STAction element);
	}

	STGroupFileBuilder newSTGroupFile(STValue packageName, STValue path);

	interface STGroupFileBuilder extends STGroupFile {
		STGroupFileBuilder setpackageName(STValue element);
		STGroupFileBuilder setpath(STValue element);
	}

	STTemplateBuilder newSTTemplate(String name, String text);

	interface STTemplateBuilder extends STTemplate {
		STTemplateBuilder setname(String element);
		STTemplateBuilder settext(String element);
		STTemplateBuilder addinterfaces(STInterface element);
		STTemplateBuilder addparameter(STParameter element);
		STTemplateBuilder addchildren(STTemplate element);
	}

	STParameterBuilder newSTParameter(String name, STParameterType type, String argumentType);

	interface STParameterBuilder extends STParameter {
		STParameterBuilder setname(String element);
		STParameterBuilder settype(STParameterType element);
		STParameterBuilder addkeys(STParameterKey element);
		STParameterBuilder setargumentType(String element);
	}

	STParameterKeyBuilder newSTParameterKey(String name, STInterface argumentType);

	interface STParameterKeyBuilder extends STParameterKey {
		STParameterKeyBuilder setname(String element);
		STParameterKeyBuilder setargumentType(STInterface element);
	}

	STInterfaceBuilder newSTInterface(String name);

	interface STInterfaceBuilder extends STInterface {
		STInterfaceBuilder setname(String element);
	}

	STEnumBuilder newSTEnum(String name);

	interface STEnumBuilder extends STEnum {
		STEnumBuilder setname(String element);
		STEnumBuilder addvalues(STEnumValue element);
	}

	STEnumValueBuilder newSTEnumValue(String name, String lexical);

	interface STEnumValueBuilder extends STEnumValue {
		STEnumValueBuilder setname(String element);
		STEnumValueBuilder setlexical(String element);
	}

	STActionBuilder newSTAction(String name);

	interface STActionBuilder extends STAction {
		STActionBuilder setname(String element);
		STActionBuilder addstatements(String element);
		STActionBuilder addimports(String element);
		STActionBuilder addmethods(String element);
	}

}