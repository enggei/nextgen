package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MaterialUIComponentModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "ab527ab8-4881-4daf-80ec-048e6129c8ec";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public MaterialUIComponentModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public MaterialUIComponentModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public MaterialUIComponentModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public MaterialUIComponentModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MaterialUIComponentModel that = (MaterialUIComponentModel) o;
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

	public MaterialUIComponentModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public MaterialUIComponentModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public MaterialUIComponentModel removeName() {
		return removeArgument("name");
	}

	public MaterialUIComponentModel setRenderCondition(String value) {
		return setRenderCondition(db.newSTValue(value));
	}

	public MaterialUIComponentModel setRenderCondition(STValue value) {
		return set(value, "renderCondition");
	}

	public STValue getRenderCondition() {
		return get("renderCondition");
	}

	public STArgument getRenderConditionArgument() {
		return getArgument("renderCondition");
	}

	public MaterialUIComponentModel removeRenderCondition() {
		return removeArgument("renderCondition");
	}

	public MaterialUIComponentModel setRenderTrue(String value) {
		return setRenderTrue(db.newSTValue(value));
	}

	public MaterialUIComponentModel setRenderTrue(STValue value) {
		return set(value, "renderTrue");
	}

	public STValue getRenderTrue() {
		return get("renderTrue");
	}

	public STArgument getRenderTrueArgument() {
		return getArgument("renderTrue");
	}

	public MaterialUIComponentModel removeRenderTrue() {
		return removeArgument("renderTrue");
	}

	public MaterialUIComponentModel setRenderFalse(String value) {
		return setRenderFalse(db.newSTValue(value));
	}

	public MaterialUIComponentModel setRenderFalse(STValue value) {
		return set(value, "renderFalse");
	}

	public STValue getRenderFalse() {
		return get("renderFalse");
	}

	public STArgument getRenderFalseArgument() {
		return getArgument("renderFalse");
	}

	public MaterialUIComponentModel removeRenderFalse() {
		return removeArgument("renderFalse");
	}

	public MaterialUIComponentModel setRenderElement(String value) {
		return setRenderElement(db.newSTValue(value));
	}

	public MaterialUIComponentModel setRenderElement(STValue value) {
		return set(value, "renderElement");
	}

	public STValue getRenderElement() {
		return get("renderElement");
	}

	public STArgument getRenderElementArgument() {
		return getArgument("renderElement");
	}

	public MaterialUIComponentModel removeRenderElement() {
		return removeArgument("renderElement");
	}

	public MaterialUIComponentModel addStyleClasses(String value) {
		return addStyleClasses(db.newSTValue(value));
	}

	public MaterialUIComponentModel addStyleClasses(STValue value) {
		return add(value, "styleClasses");
	}

	public Stream<STValue> getStyleClasses() {
		return stream("styleClasses");
	}

	public MaterialUIComponentModel addComponentImports(String value) {
		return addComponentImports(db.newSTValue(value));
	}

	public MaterialUIComponentModel addComponentImports(STValue value) {
		return add(value, "componentImports");
	}

	public Stream<STValue> getComponentImports() {
		return stream("componentImports");
	}

	public MaterialUIComponentModel addFunctions(String value) {
		return addFunctions(db.newSTValue(value));
	}

	public MaterialUIComponentModel addFunctions(STValue value) {
		return add(value, "functions");
	}

	public Stream<STValue> getFunctions() {
		return stream("functions");
	}

	public MaterialUIComponentModel addImports(String _name, String _path) {
		return addImports(db.newSTValue(_name), db.newSTValue(_path));
	}

	public MaterialUIComponentModel addImports(MaterialUIComponentModel_Imports value) {
		return addImports(value.getName(), value.getPath());
	}

	public MaterialUIComponentModel addImports(STValue _name, STValue _path) {
		findParameter("imports")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_path, stParameter, kvs, "path");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MaterialUIComponentModel_Imports> streamImports() {
		return findParameter("imports")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MaterialUIComponentModel_Imports(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MaterialUIComponentModel_Imports {

		STArgument stArgument;
		STParameter stParameter;

		public MaterialUIComponentModel_Imports(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MaterialUIComponentModel_Imports setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MaterialUIComponentModel_Imports setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MaterialUIComponentModel_Imports setPath(String value) {
			return setPath(db.newSTValue(value));
		}

		public MaterialUIComponentModel_Imports setPath(STValue value) {
			return setKVValue("path", value);
		}

		public STValue getPath() {
			return getKVValue("path");
		}


		private MaterialUIComponentModel_Imports setKVValue(String name, STValue value) {

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

	public MaterialUIComponentModel addConst(String _name, String _declaration) {
		return addConst(db.newSTValue(_name), db.newSTValue(_declaration));
	}

	public MaterialUIComponentModel addConst(MaterialUIComponentModel_Const value) {
		return addConst(value.getName(), value.getDeclaration());
	}

	public MaterialUIComponentModel addConst(STValue _name, STValue _declaration) {
		findParameter("const")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_declaration, stParameter, kvs, "declaration");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MaterialUIComponentModel_Const> streamConst() {
		return findParameter("const")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MaterialUIComponentModel_Const(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MaterialUIComponentModel_Const {

		STArgument stArgument;
		STParameter stParameter;

		public MaterialUIComponentModel_Const(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MaterialUIComponentModel_Const setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MaterialUIComponentModel_Const setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MaterialUIComponentModel_Const setDeclaration(String value) {
			return setDeclaration(db.newSTValue(value));
		}

		public MaterialUIComponentModel_Const setDeclaration(STValue value) {
			return setKVValue("declaration", value);
		}

		public STValue getDeclaration() {
			return getKVValue("declaration");
		}


		private MaterialUIComponentModel_Const setKVValue(String name, STValue value) {

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

	private MaterialUIComponentModel set(STValue value, String name) {
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

	private MaterialUIComponentModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private MaterialUIComponentModel add(STValue value, String name) {
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