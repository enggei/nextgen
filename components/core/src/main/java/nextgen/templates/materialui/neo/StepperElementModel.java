package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class StepperElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "d531d707-8420-40e4-8ee0-e35a28823d83";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public StepperElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public StepperElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public StepperElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public StepperElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StepperElementModel that = (StepperElementModel) o;
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

	public StepperElementModel setActiveStep(String value) {
		return setActiveStep(db.newSTValue(value));
	}

	public StepperElementModel setActiveStep(STValue value) {
		return set(value, "activeStep");
	}

	public STValue getActiveStep() {
		return get("activeStep");
	}

	public STArgument getActiveStepArgument() {
		return getArgument("activeStep");
	}

	public StepperElementModel removeActiveStep() {
		return removeArgument("activeStep");
	}

	public StepperElementModel setAlternativeLabel(String value) {
		return setAlternativeLabel(db.newSTValue(value));
	}

	public StepperElementModel setAlternativeLabel(STValue value) {
		return set(value, "alternativeLabel");
	}

	public STValue getAlternativeLabel() {
		return get("alternativeLabel");
	}

	public STArgument getAlternativeLabelArgument() {
		return getArgument("alternativeLabel");
	}

	public StepperElementModel removeAlternativeLabel() {
		return removeArgument("alternativeLabel");
	}

	public StepperElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public StepperElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public StepperElementModel removeClasses() {
		return removeArgument("classes");
	}

	public StepperElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public StepperElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public StepperElementModel removeClassName() {
		return removeArgument("className");
	}

	public StepperElementModel setConnector(String value) {
		return setConnector(db.newSTValue(value));
	}

	public StepperElementModel setConnector(STValue value) {
		return set(value, "connector");
	}

	public STValue getConnector() {
		return get("connector");
	}

	public STArgument getConnectorArgument() {
		return getArgument("connector");
	}

	public StepperElementModel removeConnector() {
		return removeArgument("connector");
	}

	public StepperElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public StepperElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public StepperElementModel removeId() {
		return removeArgument("id");
	}

	public StepperElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public StepperElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public StepperElementModel removeKey() {
		return removeArgument("key");
	}

	public StepperElementModel setNonLinear(String value) {
		return setNonLinear(db.newSTValue(value));
	}

	public StepperElementModel setNonLinear(STValue value) {
		return set(value, "nonLinear");
	}

	public STValue getNonLinear() {
		return get("nonLinear");
	}

	public STArgument getNonLinearArgument() {
		return getArgument("nonLinear");
	}

	public StepperElementModel removeNonLinear() {
		return removeArgument("nonLinear");
	}

	public StepperElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public StepperElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public StepperElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public StepperElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public StepperElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public StepperElementModel removeStyle() {
		return removeArgument("style");
	}

	public StepperElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public StepperElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public StepperElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public StepperElementModel addAttribute(StepperElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public StepperElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<StepperElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new StepperElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class StepperElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public StepperElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public StepperElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public StepperElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public StepperElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public StepperElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private StepperElementModel_Attribute setKVValue(String name, STValue value) {

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

	private StepperElementModel set(STValue value, String name) {
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

	private StepperElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private StepperElementModel add(STValue value, String name) {
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