package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FormControlLabelElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "dfb73eec-60c0-40cd-a4d3-2f4b98020718";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public FormControlLabelElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public FormControlLabelElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public FormControlLabelElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public FormControlLabelElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormControlLabelElementModel that = (FormControlLabelElementModel) o;
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

	public FormControlLabelElementModel setChecked(String value) {
		return setChecked(db.newSTValue(value));
	}

	public FormControlLabelElementModel setChecked(STValue value) {
		return set(value, "checked");
	}

	public STValue getChecked() {
		return get("checked");
	}

	public STArgument getCheckedArgument() {
		return getArgument("checked");
	}

	public FormControlLabelElementModel removeChecked() {
		return removeArgument("checked");
	}

	public FormControlLabelElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public FormControlLabelElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public FormControlLabelElementModel removeClasses() {
		return removeArgument("classes");
	}

	public FormControlLabelElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public FormControlLabelElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public FormControlLabelElementModel removeClassName() {
		return removeArgument("className");
	}

	public FormControlLabelElementModel setControl(String value) {
		return setControl(db.newSTValue(value));
	}

	public FormControlLabelElementModel setControl(STValue value) {
		return set(value, "control");
	}

	public STValue getControl() {
		return get("control");
	}

	public STArgument getControlArgument() {
		return getArgument("control");
	}

	public FormControlLabelElementModel removeControl() {
		return removeArgument("control");
	}

	public FormControlLabelElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public FormControlLabelElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public FormControlLabelElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public FormControlLabelElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public FormControlLabelElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public FormControlLabelElementModel removeId() {
		return removeArgument("id");
	}

	public FormControlLabelElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public FormControlLabelElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public FormControlLabelElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public FormControlLabelElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public FormControlLabelElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public FormControlLabelElementModel removeKey() {
		return removeArgument("key");
	}

	public FormControlLabelElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public FormControlLabelElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public FormControlLabelElementModel removeLabel() {
		return removeArgument("label");
	}

	public FormControlLabelElementModel setLabelPlacement(String value) {
		return setLabelPlacement(db.newSTValue(value));
	}

	public FormControlLabelElementModel setLabelPlacement(STValue value) {
		return set(value, "labelPlacement");
	}

	public STValue getLabelPlacement() {
		return get("labelPlacement");
	}

	public STArgument getLabelPlacementArgument() {
		return getArgument("labelPlacement");
	}

	public FormControlLabelElementModel removeLabelPlacement() {
		return removeArgument("labelPlacement");
	}

	public FormControlLabelElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public FormControlLabelElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public FormControlLabelElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public FormControlLabelElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public FormControlLabelElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public FormControlLabelElementModel removeStyle() {
		return removeArgument("style");
	}

	public FormControlLabelElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public FormControlLabelElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public FormControlLabelElementModel removeValue() {
		return removeArgument("value");
	}


	public FormControlLabelElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public FormControlLabelElementModel addAttribute(FormControlLabelElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public FormControlLabelElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<FormControlLabelElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new FormControlLabelElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class FormControlLabelElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public FormControlLabelElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public FormControlLabelElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public FormControlLabelElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public FormControlLabelElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public FormControlLabelElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private FormControlLabelElementModel_Attribute setKVValue(String name, STValue value) {

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

	private FormControlLabelElementModel set(STValue value, String name) {
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

	private FormControlLabelElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private FormControlLabelElementModel add(STValue value, String name) {
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