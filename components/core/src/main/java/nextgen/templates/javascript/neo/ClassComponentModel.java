package nextgen.templates.javascript.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ClassComponentModel {

	public static final String stGroupModelUuid = "3ff969ac-4b1c-43fb-968a-7c579bf6779b";
	public static final String stTemplateUuid = "9752d4ad-2141-445a-9a80-3a79072db167";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ClassComponentModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ClassComponentModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ClassComponentModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ClassComponentModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassComponentModel that = (ClassComponentModel) o;
		return stModel.equals(that.stModel);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(stModel);
	}

	public String getUuid() {
		return stModel.getUuid();
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public ClassComponentModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public ClassComponentModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public ClassComponentModel removeName() {
		return removeArgument("name");
	}

	public ClassComponentModel setRenderCondition(String value) {
		return setRenderCondition(db.newSTValue(value));
	}

	public ClassComponentModel setRenderCondition(STValue value) {
		return set(value, "renderCondition");
	}

	public STValue getRenderCondition() {
		return get("renderCondition");
	}

	public STArgument getRenderConditionArgument() {
		return getArgument("renderCondition");
	}

	public ClassComponentModel removeRenderCondition() {
		return removeArgument("renderCondition");
	}

	public ClassComponentModel setRenderTrue(String value) {
		return setRenderTrue(db.newSTValue(value));
	}

	public ClassComponentModel setRenderTrue(STValue value) {
		return set(value, "renderTrue");
	}

	public STValue getRenderTrue() {
		return get("renderTrue");
	}

	public STArgument getRenderTrueArgument() {
		return getArgument("renderTrue");
	}

	public ClassComponentModel removeRenderTrue() {
		return removeArgument("renderTrue");
	}

	public ClassComponentModel setRenderFalse(String value) {
		return setRenderFalse(db.newSTValue(value));
	}

	public ClassComponentModel setRenderFalse(STValue value) {
		return set(value, "renderFalse");
	}

	public STValue getRenderFalse() {
		return get("renderFalse");
	}

	public STArgument getRenderFalseArgument() {
		return getArgument("renderFalse");
	}

	public ClassComponentModel removeRenderFalse() {
		return removeArgument("renderFalse");
	}

	public ClassComponentModel setRenderElement(String value) {
		return setRenderElement(db.newSTValue(value));
	}

	public ClassComponentModel setRenderElement(STValue value) {
		return set(value, "renderElement");
	}

	public STValue getRenderElement() {
		return get("renderElement");
	}

	public STArgument getRenderElementArgument() {
		return getArgument("renderElement");
	}

	public ClassComponentModel removeRenderElement() {
		return removeArgument("renderElement");
	}

	public ClassComponentModel addComponentImports(String value) {
		return addComponentImports(db.newSTValue(value));
	}

	public ClassComponentModel addComponentImports(STValue value) {
		return add(value, "componentImports");
	}

	public Stream<STValue> getComponentImports() {
		return stream("componentImports");
	}

	public ClassComponentModel addDependencies(String value) {
		return addDependencies(db.newSTValue(value));
	}

	public ClassComponentModel addDependencies(STValue value) {
		return add(value, "dependencies");
	}

	public Stream<STValue> getDependencies() {
		return stream("dependencies");
	}

	public ClassComponentModel addConstDeclarations(String value) {
		return addConstDeclarations(db.newSTValue(value));
	}

	public ClassComponentModel addConstDeclarations(STValue value) {
		return add(value, "constDeclarations");
	}

	public Stream<STValue> getConstDeclarations() {
		return stream("constDeclarations");
	}

	public ClassComponentModel addDecorators(String value) {
		return addDecorators(db.newSTValue(value));
	}

	public ClassComponentModel addDecorators(STValue value) {
		return add(value, "decorators");
	}

	public Stream<STValue> getDecorators() {
		return stream("decorators");
	}

	public ClassComponentModel addState(String value) {
		return addState(db.newSTValue(value));
	}

	public ClassComponentModel addState(STValue value) {
		return add(value, "state");
	}

	public Stream<STValue> getState() {
		return stream("state");
	}

	public ClassComponentModel addConstructorStatements(String value) {
		return addConstructorStatements(db.newSTValue(value));
	}

	public ClassComponentModel addConstructorStatements(STValue value) {
		return add(value, "constructorStatements");
	}

	public Stream<STValue> getConstructorStatements() {
		return stream("constructorStatements");
	}

	public ClassComponentModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public ClassComponentModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public ClassComponentModel addImports(String _ref, String _path) {
		return addImports(db.newSTValue(_ref), db.newSTValue(_path));
	}

	public ClassComponentModel addImports(ClassComponentModel_Imports value) {
		return addImports(value.getRef(), value.getPath());
	}

	public ClassComponentModel addImports(STValue _ref, STValue _path) {
		findParameter("imports")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_ref, stParameter, kvs, "ref");
					addKV(_path, stParameter, kvs, "path");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ClassComponentModel_Imports> streamImports() {
		return findParameter("imports")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ClassComponentModel_Imports(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ClassComponentModel_Imports {

		STArgument stArgument;
		STParameter stParameter;

		public ClassComponentModel_Imports(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ClassComponentModel_Imports setRef(String value) {
			return setRef(db.newSTValue(value));
		}

		public ClassComponentModel_Imports setRef(STValue value) {
			return setKVValue("ref", value);
		}

		public STValue getRef() {
			return getKVValue("ref");
		}


		public ClassComponentModel_Imports setPath(String value) {
			return setPath(db.newSTValue(value));
		}

		public ClassComponentModel_Imports setPath(STValue value) {
			return setKVValue("path", value);
		}

		public STValue getPath() {
			return getKVValue("path");
		}


		private ClassComponentModel_Imports setKVValue(String name, STValue value) {

			stParameter.getKeys()
					.filter(stParameterKey -> stParameterKey.getName().equals(name))
					.findAny()
					.ifPresent(stParameterKey -> {

						stArgument.getKeyValues()
								.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
								.findAny()
								.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

						stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
					});

			return this;
		}

		private STValue getKVValue(String name) {
			final AtomicReference<STValue> value = new AtomicReference<>();
			stParameter.getKeys()
					.filter(param -> param.getName().equals(name))
					.findFirst().flatMap(stParameter -> stArgument.getKeyValues()
					.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
					.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

			return value.get();
		}
	}

	public ClassComponentModel addFields(String _name) {
		return addFields(db.newSTValue(_name));
	}

	public ClassComponentModel addFields(ClassComponentModel_Fields value) {
		return addFields(value.getName());
	}

	public ClassComponentModel addFields(STValue _name) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ClassComponentModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ClassComponentModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ClassComponentModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public ClassComponentModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ClassComponentModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ClassComponentModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private ClassComponentModel_Fields setKVValue(String name, STValue value) {

			stParameter.getKeys()
					.filter(stParameterKey -> stParameterKey.getName().equals(name))
					.findAny()
					.ifPresent(stParameterKey -> {

						stArgument.getKeyValues()
								.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
								.findAny()
								.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

						stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
					});

			return this;
		}

		private STValue getKVValue(String name) {
			final AtomicReference<STValue> value = new AtomicReference<>();
			stParameter.getKeys()
					.filter(param -> param.getName().equals(name))
					.findFirst().flatMap(stParameter -> stArgument.getKeyValues()
					.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
					.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

			return value.get();
		}
	}

	public ClassComponentModel addEvents(String _methodName, String _declaration) {
		return addEvents(db.newSTValue(_methodName), db.newSTValue(_declaration));
	}

	public ClassComponentModel addEvents(ClassComponentModel_Events value) {
		return addEvents(value.getMethodName(), value.getDeclaration());
	}

	public ClassComponentModel addEvents(STValue _methodName, STValue _declaration) {
		findParameter("events")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_methodName, stParameter, kvs, "methodName");
					addKV(_declaration, stParameter, kvs, "declaration");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ClassComponentModel_Events> streamEvents() {
		return findParameter("events")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ClassComponentModel_Events(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ClassComponentModel_Events {

		STArgument stArgument;
		STParameter stParameter;

		public ClassComponentModel_Events(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ClassComponentModel_Events setMethodName(String value) {
			return setMethodName(db.newSTValue(value));
		}

		public ClassComponentModel_Events setMethodName(STValue value) {
			return setKVValue("methodName", value);
		}

		public STValue getMethodName() {
			return getKVValue("methodName");
		}


		public ClassComponentModel_Events setDeclaration(String value) {
			return setDeclaration(db.newSTValue(value));
		}

		public ClassComponentModel_Events setDeclaration(STValue value) {
			return setKVValue("declaration", value);
		}

		public STValue getDeclaration() {
			return getKVValue("declaration");
		}


		private ClassComponentModel_Events setKVValue(String name, STValue value) {

			stParameter.getKeys()
					.filter(stParameterKey -> stParameterKey.getName().equals(name))
					.findAny()
					.ifPresent(stParameterKey -> {

						stArgument.getKeyValues()
								.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
								.findAny()
								.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

						stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
					});

			return this;
		}

		private STValue getKVValue(String name) {
			final AtomicReference<STValue> value = new AtomicReference<>();
			stParameter.getKeys()
					.filter(param -> param.getName().equals(name))
					.findFirst().flatMap(stParameter -> stArgument.getKeyValues()
					.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
					.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

			return value.get();
		}
	}

	private ClassComponentModel set(STValue value, String name) {
		findParameter(name)
				.ifPresent(stParameter -> {

					stModel.getArguments()
							.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
							.findAny()
							.ifPresent(stModel::removeArguments);

					stModel.addArguments(db.newSTArgument(stParameter, value));
				});
		return this;
	}

	private STValue get(String name) {
		final AtomicReference<STValue> value = new AtomicReference<>();
		findParameter(name).flatMap(stParameter -> stModel.getArguments()
				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
				.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));
		return value.get();
	}

	private STArgument getArgument(String name) {
		final AtomicReference<STArgument> value = new AtomicReference<>();
		findParameter(name).flatMap(stParameter -> stModel.getArguments()
				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
				.findAny()).ifPresent(value::set);
		return value.get();
	}

	private ClassComponentModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ClassComponentModel add(STValue value, String name) {
		findParameter(name)
				.ifPresent(stParameter -> stModel.addArguments(db.newSTArgument(stParameter, value)));
		return this;
	}

	private Stream<STValue> stream(String name) {
		return findParameter(name)
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(STArgument::getValue)).orElseGet(Stream::empty);
	}

	private Optional<STParameter> findParameter(String name) {
		return stTemplate.getParameters()
				.filter(param -> param.getName().equals(name))
				.findFirst();
	}

	private void addKV(STValue _type, STParameter stParameter, Collection<STArgumentKV> kvs, String type) {
		stParameter.getKeys()
				.filter(stParameterKey -> stParameterKey.getName().equals(type))
				.findFirst()
				.ifPresent(stParameterKey -> kvs.add(db.newSTArgumentKV(stParameterKey, _type)));
	}
}