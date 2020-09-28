package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SliderElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "7c4de4c1-a7ac-4dfe-9e8c-b9cd6c948c8c";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SliderElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SliderElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SliderElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SliderElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SliderElementModel that = (SliderElementModel) o;
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

	public SliderElementModel setAriaLabel(String value) {
		return setAriaLabel(db.newSTValue(value));
	}

	public SliderElementModel setAriaLabel(STValue value) {
		return set(value, "ariaLabel");
	}

	public STValue getAriaLabel() {
		return get("ariaLabel");
	}

	public STArgument getAriaLabelArgument() {
		return getArgument("ariaLabel");
	}

	public SliderElementModel removeAriaLabel() {
		return removeArgument("ariaLabel");
	}

	public SliderElementModel setAriaLabelledby(String value) {
		return setAriaLabelledby(db.newSTValue(value));
	}

	public SliderElementModel setAriaLabelledby(STValue value) {
		return set(value, "ariaLabelledby");
	}

	public STValue getAriaLabelledby() {
		return get("ariaLabelledby");
	}

	public STArgument getAriaLabelledbyArgument() {
		return getArgument("ariaLabelledby");
	}

	public SliderElementModel removeAriaLabelledby() {
		return removeArgument("ariaLabelledby");
	}

	public SliderElementModel setAriaValuetext(String value) {
		return setAriaValuetext(db.newSTValue(value));
	}

	public SliderElementModel setAriaValuetext(STValue value) {
		return set(value, "ariaValuetext");
	}

	public STValue getAriaValuetext() {
		return get("ariaValuetext");
	}

	public STArgument getAriaValuetextArgument() {
		return getArgument("ariaValuetext");
	}

	public SliderElementModel removeAriaValuetext() {
		return removeArgument("ariaValuetext");
	}

	public SliderElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SliderElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SliderElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SliderElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SliderElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SliderElementModel removeClassName() {
		return removeArgument("className");
	}

	public SliderElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public SliderElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public SliderElementModel removeColor() {
		return removeArgument("color");
	}

	public SliderElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public SliderElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public SliderElementModel removeComponent() {
		return removeArgument("component");
	}

	public SliderElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public SliderElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public SliderElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public SliderElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public SliderElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public SliderElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public SliderElementModel setGetAriaLabel(String value) {
		return setGetAriaLabel(db.newSTValue(value));
	}

	public SliderElementModel setGetAriaLabel(STValue value) {
		return set(value, "getAriaLabel");
	}

	public STValue getGetAriaLabel() {
		return get("getAriaLabel");
	}

	public STArgument getGetAriaLabelArgument() {
		return getArgument("getAriaLabel");
	}

	public SliderElementModel removeGetAriaLabel() {
		return removeArgument("getAriaLabel");
	}

	public SliderElementModel setGetAriaValueText(String value) {
		return setGetAriaValueText(db.newSTValue(value));
	}

	public SliderElementModel setGetAriaValueText(STValue value) {
		return set(value, "getAriaValueText");
	}

	public STValue getGetAriaValueText() {
		return get("getAriaValueText");
	}

	public STArgument getGetAriaValueTextArgument() {
		return getArgument("getAriaValueText");
	}

	public SliderElementModel removeGetAriaValueText() {
		return removeArgument("getAriaValueText");
	}

	public SliderElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SliderElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SliderElementModel removeId() {
		return removeArgument("id");
	}

	public SliderElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SliderElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SliderElementModel removeKey() {
		return removeArgument("key");
	}

	public SliderElementModel setMarks(String value) {
		return setMarks(db.newSTValue(value));
	}

	public SliderElementModel setMarks(STValue value) {
		return set(value, "marks");
	}

	public STValue getMarks() {
		return get("marks");
	}

	public STArgument getMarksArgument() {
		return getArgument("marks");
	}

	public SliderElementModel removeMarks() {
		return removeArgument("marks");
	}

	public SliderElementModel setMax(String value) {
		return setMax(db.newSTValue(value));
	}

	public SliderElementModel setMax(STValue value) {
		return set(value, "max");
	}

	public STValue getMax() {
		return get("max");
	}

	public STArgument getMaxArgument() {
		return getArgument("max");
	}

	public SliderElementModel removeMax() {
		return removeArgument("max");
	}

	public SliderElementModel setMin(String value) {
		return setMin(db.newSTValue(value));
	}

	public SliderElementModel setMin(STValue value) {
		return set(value, "min");
	}

	public STValue getMin() {
		return get("min");
	}

	public STArgument getMinArgument() {
		return getArgument("min");
	}

	public SliderElementModel removeMin() {
		return removeArgument("min");
	}

	public SliderElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public SliderElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public SliderElementModel removeName() {
		return removeArgument("name");
	}

	public SliderElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public SliderElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public SliderElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public SliderElementModel setOnChangeCommitted(String value) {
		return setOnChangeCommitted(db.newSTValue(value));
	}

	public SliderElementModel setOnChangeCommitted(STValue value) {
		return set(value, "onChangeCommitted");
	}

	public STValue getOnChangeCommitted() {
		return get("onChangeCommitted");
	}

	public STArgument getOnChangeCommittedArgument() {
		return getArgument("onChangeCommitted");
	}

	public SliderElementModel removeOnChangeCommitted() {
		return removeArgument("onChangeCommitted");
	}

	public SliderElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public SliderElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public SliderElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public SliderElementModel setScale(String value) {
		return setScale(db.newSTValue(value));
	}

	public SliderElementModel setScale(STValue value) {
		return set(value, "scale");
	}

	public STValue getScale() {
		return get("scale");
	}

	public STArgument getScaleArgument() {
		return getArgument("scale");
	}

	public SliderElementModel removeScale() {
		return removeArgument("scale");
	}

	public SliderElementModel setStep(String value) {
		return setStep(db.newSTValue(value));
	}

	public SliderElementModel setStep(STValue value) {
		return set(value, "step");
	}

	public STValue getStep() {
		return get("step");
	}

	public STArgument getStepArgument() {
		return getArgument("step");
	}

	public SliderElementModel removeStep() {
		return removeArgument("step");
	}

	public SliderElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SliderElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SliderElementModel removeStyle() {
		return removeArgument("style");
	}

	public SliderElementModel setThumbComponent(String value) {
		return setThumbComponent(db.newSTValue(value));
	}

	public SliderElementModel setThumbComponent(STValue value) {
		return set(value, "ThumbComponent");
	}

	public STValue getThumbComponent() {
		return get("ThumbComponent");
	}

	public STArgument getThumbComponentArgument() {
		return getArgument("ThumbComponent");
	}

	public SliderElementModel removeThumbComponent() {
		return removeArgument("ThumbComponent");
	}

	public SliderElementModel setTrack(String value) {
		return setTrack(db.newSTValue(value));
	}

	public SliderElementModel setTrack(STValue value) {
		return set(value, "track");
	}

	public STValue getTrack() {
		return get("track");
	}

	public STArgument getTrackArgument() {
		return getArgument("track");
	}

	public SliderElementModel removeTrack() {
		return removeArgument("track");
	}

	public SliderElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public SliderElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public SliderElementModel removeValue() {
		return removeArgument("value");
	}

	public SliderElementModel setValueLabelComponent(String value) {
		return setValueLabelComponent(db.newSTValue(value));
	}

	public SliderElementModel setValueLabelComponent(STValue value) {
		return set(value, "ValueLabelComponent");
	}

	public STValue getValueLabelComponent() {
		return get("ValueLabelComponent");
	}

	public STArgument getValueLabelComponentArgument() {
		return getArgument("ValueLabelComponent");
	}

	public SliderElementModel removeValueLabelComponent() {
		return removeArgument("ValueLabelComponent");
	}

	public SliderElementModel setValueLabelDisplay(String value) {
		return setValueLabelDisplay(db.newSTValue(value));
	}

	public SliderElementModel setValueLabelDisplay(STValue value) {
		return set(value, "valueLabelDisplay");
	}

	public STValue getValueLabelDisplay() {
		return get("valueLabelDisplay");
	}

	public STArgument getValueLabelDisplayArgument() {
		return getArgument("valueLabelDisplay");
	}

	public SliderElementModel removeValueLabelDisplay() {
		return removeArgument("valueLabelDisplay");
	}

	public SliderElementModel setValueLabelFormat(String value) {
		return setValueLabelFormat(db.newSTValue(value));
	}

	public SliderElementModel setValueLabelFormat(STValue value) {
		return set(value, "valueLabelFormat");
	}

	public STValue getValueLabelFormat() {
		return get("valueLabelFormat");
	}

	public STArgument getValueLabelFormatArgument() {
		return getArgument("valueLabelFormat");
	}

	public SliderElementModel removeValueLabelFormat() {
		return removeArgument("valueLabelFormat");
	}


	public SliderElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SliderElementModel addAttribute(SliderElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SliderElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SliderElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SliderElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SliderElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SliderElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SliderElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SliderElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SliderElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SliderElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SliderElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SliderElementModel set(STValue value, String name) {
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

	private SliderElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SliderElementModel add(STValue value, String name) {
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