package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class RadioElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "17d476e5-397f-410c-8148-447fc0dec46f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public RadioElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public RadioElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public RadioElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public RadioElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RadioElementModel that = (RadioElementModel) o;
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

	public RadioElementModel setChecked(String value) {
		return setChecked(db.newSTValue(value));
	}

	public RadioElementModel setChecked(STValue value) {
		return set(value, "checked");
	}

	public STValue getChecked() {
		return get("checked");
	}

	public STArgument getCheckedArgument() {
		return getArgument("checked");
	}

	public RadioElementModel removeChecked() {
		return removeArgument("checked");
	}

	public RadioElementModel setCheckedIcon(String value) {
		return setCheckedIcon(db.newSTValue(value));
	}

	public RadioElementModel setCheckedIcon(STValue value) {
		return set(value, "checkedIcon");
	}

	public STValue getCheckedIcon() {
		return get("checkedIcon");
	}

	public STArgument getCheckedIconArgument() {
		return getArgument("checkedIcon");
	}

	public RadioElementModel removeCheckedIcon() {
		return removeArgument("checkedIcon");
	}

	public RadioElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public RadioElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public RadioElementModel removeClasses() {
		return removeArgument("classes");
	}

	public RadioElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public RadioElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public RadioElementModel removeClassName() {
		return removeArgument("className");
	}

	public RadioElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public RadioElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public RadioElementModel removeColor() {
		return removeArgument("color");
	}

	public RadioElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public RadioElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public RadioElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public RadioElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public RadioElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public RadioElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public RadioElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public RadioElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public RadioElementModel removeIcon() {
		return removeArgument("icon");
	}

	public RadioElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public RadioElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public RadioElementModel removeId() {
		return removeArgument("id");
	}

	public RadioElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public RadioElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public RadioElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public RadioElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public RadioElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public RadioElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public RadioElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public RadioElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public RadioElementModel removeKey() {
		return removeArgument("key");
	}

	public RadioElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public RadioElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public RadioElementModel removeName() {
		return removeArgument("name");
	}

	public RadioElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public RadioElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public RadioElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public RadioElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public RadioElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public RadioElementModel removeRequired() {
		return removeArgument("required");
	}

	public RadioElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public RadioElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public RadioElementModel removeSize() {
		return removeArgument("size");
	}

	public RadioElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public RadioElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public RadioElementModel removeStyle() {
		return removeArgument("style");
	}

	public RadioElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public RadioElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public RadioElementModel removeValue() {
		return removeArgument("value");
	}


	public RadioElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public RadioElementModel addAttribute(RadioElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public RadioElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<RadioElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new RadioElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class RadioElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public RadioElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public RadioElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public RadioElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public RadioElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public RadioElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private RadioElementModel_Attribute setKVValue(String name, STValue value) {

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

	private RadioElementModel set(STValue value, String name) {
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

	private RadioElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private RadioElementModel add(STValue value, String name) {
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