package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MobileStepperElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "32d570eb-bb29-4028-9ad2-6c37c2de75c1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public MobileStepperElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public MobileStepperElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public MobileStepperElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public MobileStepperElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MobileStepperElementModel that = (MobileStepperElementModel) o;
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

	public MobileStepperElementModel setActiveStep(String value) {
		return setActiveStep(db.newSTValue(value));
	}

	public MobileStepperElementModel setActiveStep(STValue value) {
		return set(value, "activeStep");
	}

	public STValue getActiveStep() {
		return get("activeStep");
	}

	public STArgument getActiveStepArgument() {
		return getArgument("activeStep");
	}

	public MobileStepperElementModel removeActiveStep() {
		return removeArgument("activeStep");
	}

	public MobileStepperElementModel setBackButton(String value) {
		return setBackButton(db.newSTValue(value));
	}

	public MobileStepperElementModel setBackButton(STValue value) {
		return set(value, "backButton");
	}

	public STValue getBackButton() {
		return get("backButton");
	}

	public STArgument getBackButtonArgument() {
		return getArgument("backButton");
	}

	public MobileStepperElementModel removeBackButton() {
		return removeArgument("backButton");
	}

	public MobileStepperElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public MobileStepperElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public MobileStepperElementModel removeClasses() {
		return removeArgument("classes");
	}

	public MobileStepperElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public MobileStepperElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public MobileStepperElementModel removeClassName() {
		return removeArgument("className");
	}

	public MobileStepperElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public MobileStepperElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public MobileStepperElementModel removeId() {
		return removeArgument("id");
	}

	public MobileStepperElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public MobileStepperElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public MobileStepperElementModel removeKey() {
		return removeArgument("key");
	}

	public MobileStepperElementModel setLinearProgressProps(String value) {
		return setLinearProgressProps(db.newSTValue(value));
	}

	public MobileStepperElementModel setLinearProgressProps(STValue value) {
		return set(value, "LinearProgressProps");
	}

	public STValue getLinearProgressProps() {
		return get("LinearProgressProps");
	}

	public STArgument getLinearProgressPropsArgument() {
		return getArgument("LinearProgressProps");
	}

	public MobileStepperElementModel removeLinearProgressProps() {
		return removeArgument("LinearProgressProps");
	}

	public MobileStepperElementModel setNextButton(String value) {
		return setNextButton(db.newSTValue(value));
	}

	public MobileStepperElementModel setNextButton(STValue value) {
		return set(value, "nextButton");
	}

	public STValue getNextButton() {
		return get("nextButton");
	}

	public STArgument getNextButtonArgument() {
		return getArgument("nextButton");
	}

	public MobileStepperElementModel removeNextButton() {
		return removeArgument("nextButton");
	}

	public MobileStepperElementModel setPosition(String value) {
		return setPosition(db.newSTValue(value));
	}

	public MobileStepperElementModel setPosition(STValue value) {
		return set(value, "position");
	}

	public STValue getPosition() {
		return get("position");
	}

	public STArgument getPositionArgument() {
		return getArgument("position");
	}

	public MobileStepperElementModel removePosition() {
		return removeArgument("position");
	}

	public MobileStepperElementModel setSteps(String value) {
		return setSteps(db.newSTValue(value));
	}

	public MobileStepperElementModel setSteps(STValue value) {
		return set(value, "steps");
	}

	public STValue getSteps() {
		return get("steps");
	}

	public STArgument getStepsArgument() {
		return getArgument("steps");
	}

	public MobileStepperElementModel removeSteps() {
		return removeArgument("steps");
	}

	public MobileStepperElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public MobileStepperElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public MobileStepperElementModel removeStyle() {
		return removeArgument("style");
	}

	public MobileStepperElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public MobileStepperElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public MobileStepperElementModel removeVariant() {
		return removeArgument("variant");
	}


	public MobileStepperElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public MobileStepperElementModel addAttribute(MobileStepperElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public MobileStepperElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MobileStepperElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MobileStepperElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MobileStepperElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public MobileStepperElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MobileStepperElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MobileStepperElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MobileStepperElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public MobileStepperElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private MobileStepperElementModel_Attribute setKVValue(String name, STValue value) {

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

	private MobileStepperElementModel set(STValue value, String name) {
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

	private MobileStepperElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private MobileStepperElementModel add(STValue value, String name) {
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