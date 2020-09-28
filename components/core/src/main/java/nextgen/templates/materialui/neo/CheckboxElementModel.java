package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CheckboxElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "e005c570-67a9-4388-9618-350ec37c72a1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CheckboxElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CheckboxElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CheckboxElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public CheckboxElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CheckboxElementModel that = (CheckboxElementModel) o;
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

	public CheckboxElementModel setChecked(String value) {
		return setChecked(db.newSTValue(value));
	}

	public CheckboxElementModel setChecked(STValue value) {
		return set(value, "checked");
	}

	public STValue getChecked() {
		return get("checked");
	}

	public STArgument getCheckedArgument() {
		return getArgument("checked");
	}

	public CheckboxElementModel removeChecked() {
		return removeArgument("checked");
	}

	public CheckboxElementModel setCheckedIcon(String value) {
		return setCheckedIcon(db.newSTValue(value));
	}

	public CheckboxElementModel setCheckedIcon(STValue value) {
		return set(value, "checkedIcon");
	}

	public STValue getCheckedIcon() {
		return get("checkedIcon");
	}

	public STArgument getCheckedIconArgument() {
		return getArgument("checkedIcon");
	}

	public CheckboxElementModel removeCheckedIcon() {
		return removeArgument("checkedIcon");
	}

	public CheckboxElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public CheckboxElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public CheckboxElementModel removeClasses() {
		return removeArgument("classes");
	}

	public CheckboxElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public CheckboxElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public CheckboxElementModel removeClassName() {
		return removeArgument("className");
	}

	public CheckboxElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public CheckboxElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public CheckboxElementModel removeColor() {
		return removeArgument("color");
	}

	public CheckboxElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public CheckboxElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public CheckboxElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public CheckboxElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public CheckboxElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public CheckboxElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public CheckboxElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public CheckboxElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public CheckboxElementModel removeIcon() {
		return removeArgument("icon");
	}

	public CheckboxElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public CheckboxElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public CheckboxElementModel removeId() {
		return removeArgument("id");
	}

	public CheckboxElementModel setIndeterminate(String value) {
		return setIndeterminate(db.newSTValue(value));
	}

	public CheckboxElementModel setIndeterminate(STValue value) {
		return set(value, "indeterminate");
	}

	public STValue getIndeterminate() {
		return get("indeterminate");
	}

	public STArgument getIndeterminateArgument() {
		return getArgument("indeterminate");
	}

	public CheckboxElementModel removeIndeterminate() {
		return removeArgument("indeterminate");
	}

	public CheckboxElementModel setIndeterminateIcon(String value) {
		return setIndeterminateIcon(db.newSTValue(value));
	}

	public CheckboxElementModel setIndeterminateIcon(STValue value) {
		return set(value, "indeterminateIcon");
	}

	public STValue getIndeterminateIcon() {
		return get("indeterminateIcon");
	}

	public STArgument getIndeterminateIconArgument() {
		return getArgument("indeterminateIcon");
	}

	public CheckboxElementModel removeIndeterminateIcon() {
		return removeArgument("indeterminateIcon");
	}

	public CheckboxElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public CheckboxElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public CheckboxElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public CheckboxElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public CheckboxElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public CheckboxElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public CheckboxElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public CheckboxElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public CheckboxElementModel removeKey() {
		return removeArgument("key");
	}

	public CheckboxElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public CheckboxElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public CheckboxElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public CheckboxElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public CheckboxElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public CheckboxElementModel removeRequired() {
		return removeArgument("required");
	}

	public CheckboxElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public CheckboxElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public CheckboxElementModel removeSize() {
		return removeArgument("size");
	}

	public CheckboxElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public CheckboxElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public CheckboxElementModel removeStyle() {
		return removeArgument("style");
	}

	public CheckboxElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public CheckboxElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public CheckboxElementModel removeValue() {
		return removeArgument("value");
	}


	public CheckboxElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public CheckboxElementModel addAttribute(CheckboxElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public CheckboxElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CheckboxElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CheckboxElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CheckboxElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public CheckboxElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CheckboxElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CheckboxElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public CheckboxElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public CheckboxElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private CheckboxElementModel_Attribute setKVValue(String name, STValue value) {

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

	private CheckboxElementModel set(STValue value, String name) {
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

	private CheckboxElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private CheckboxElementModel add(STValue value, String name) {
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