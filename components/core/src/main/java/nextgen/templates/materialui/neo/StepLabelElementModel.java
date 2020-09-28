package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class StepLabelElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8e3209f5-cb7b-4189-aae9-ac0d08ae32db";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public StepLabelElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public StepLabelElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public StepLabelElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public StepLabelElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StepLabelElementModel that = (StepLabelElementModel) o;
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

	public StepLabelElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public StepLabelElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public StepLabelElementModel removeClasses() {
		return removeArgument("classes");
	}

	public StepLabelElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public StepLabelElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public StepLabelElementModel removeClassName() {
		return removeArgument("className");
	}

	public StepLabelElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public StepLabelElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public StepLabelElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public StepLabelElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public StepLabelElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public StepLabelElementModel removeError() {
		return removeArgument("error");
	}

	public StepLabelElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public StepLabelElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public StepLabelElementModel removeIcon() {
		return removeArgument("icon");
	}

	public StepLabelElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public StepLabelElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public StepLabelElementModel removeId() {
		return removeArgument("id");
	}

	public StepLabelElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public StepLabelElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public StepLabelElementModel removeKey() {
		return removeArgument("key");
	}

	public StepLabelElementModel setOptional(String value) {
		return setOptional(db.newSTValue(value));
	}

	public StepLabelElementModel setOptional(STValue value) {
		return set(value, "optional");
	}

	public STValue getOptional() {
		return get("optional");
	}

	public STArgument getOptionalArgument() {
		return getArgument("optional");
	}

	public StepLabelElementModel removeOptional() {
		return removeArgument("optional");
	}

	public StepLabelElementModel setStepIconComponent(String value) {
		return setStepIconComponent(db.newSTValue(value));
	}

	public StepLabelElementModel setStepIconComponent(STValue value) {
		return set(value, "StepIconComponent");
	}

	public STValue getStepIconComponent() {
		return get("StepIconComponent");
	}

	public STArgument getStepIconComponentArgument() {
		return getArgument("StepIconComponent");
	}

	public StepLabelElementModel removeStepIconComponent() {
		return removeArgument("StepIconComponent");
	}

	public StepLabelElementModel setStepIconProps(String value) {
		return setStepIconProps(db.newSTValue(value));
	}

	public StepLabelElementModel setStepIconProps(STValue value) {
		return set(value, "StepIconProps");
	}

	public STValue getStepIconProps() {
		return get("StepIconProps");
	}

	public STArgument getStepIconPropsArgument() {
		return getArgument("StepIconProps");
	}

	public StepLabelElementModel removeStepIconProps() {
		return removeArgument("StepIconProps");
	}

	public StepLabelElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public StepLabelElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public StepLabelElementModel removeStyle() {
		return removeArgument("style");
	}

	public StepLabelElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public StepLabelElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public StepLabelElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public StepLabelElementModel addAttribute(StepLabelElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public StepLabelElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<StepLabelElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new StepLabelElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class StepLabelElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public StepLabelElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public StepLabelElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public StepLabelElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public StepLabelElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public StepLabelElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private StepLabelElementModel_Attribute setKVValue(String name, STValue value) {

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

	private StepLabelElementModel set(STValue value, String name) {
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

	private StepLabelElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private StepLabelElementModel add(STValue value, String name) {
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