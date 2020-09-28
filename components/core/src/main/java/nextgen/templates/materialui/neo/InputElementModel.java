package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class InputElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "921c2e8f-2947-436c-8064-a41150742a23";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public InputElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public InputElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public InputElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public InputElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InputElementModel that = (InputElementModel) o;
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

	public InputElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public InputElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public InputElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public InputElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public InputElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public InputElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public InputElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public InputElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public InputElementModel removeClasses() {
		return removeArgument("classes");
	}

	public InputElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public InputElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public InputElementModel removeClassName() {
		return removeArgument("className");
	}

	public InputElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public InputElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public InputElementModel removeColor() {
		return removeArgument("color");
	}

	public InputElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public InputElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public InputElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public InputElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public InputElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public InputElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public InputElementModel setDisableUnderline(String value) {
		return setDisableUnderline(db.newSTValue(value));
	}

	public InputElementModel setDisableUnderline(STValue value) {
		return set(value, "disableUnderline");
	}

	public STValue getDisableUnderline() {
		return get("disableUnderline");
	}

	public STArgument getDisableUnderlineArgument() {
		return getArgument("disableUnderline");
	}

	public InputElementModel removeDisableUnderline() {
		return removeArgument("disableUnderline");
	}

	public InputElementModel setEndAdornment(String value) {
		return setEndAdornment(db.newSTValue(value));
	}

	public InputElementModel setEndAdornment(STValue value) {
		return set(value, "endAdornment");
	}

	public STValue getEndAdornment() {
		return get("endAdornment");
	}

	public STArgument getEndAdornmentArgument() {
		return getArgument("endAdornment");
	}

	public InputElementModel removeEndAdornment() {
		return removeArgument("endAdornment");
	}

	public InputElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public InputElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public InputElementModel removeError() {
		return removeArgument("error");
	}

	public InputElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public InputElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public InputElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public InputElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public InputElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public InputElementModel removeId() {
		return removeArgument("id");
	}

	public InputElementModel setInputComponent(String value) {
		return setInputComponent(db.newSTValue(value));
	}

	public InputElementModel setInputComponent(STValue value) {
		return set(value, "inputComponent");
	}

	public STValue getInputComponent() {
		return get("inputComponent");
	}

	public STArgument getInputComponentArgument() {
		return getArgument("inputComponent");
	}

	public InputElementModel removeInputComponent() {
		return removeArgument("inputComponent");
	}

	public InputElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public InputElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public InputElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public InputElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public InputElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public InputElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public InputElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public InputElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public InputElementModel removeKey() {
		return removeArgument("key");
	}

	public InputElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public InputElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public InputElementModel removeMargin() {
		return removeArgument("margin");
	}

	public InputElementModel setMultiline(String value) {
		return setMultiline(db.newSTValue(value));
	}

	public InputElementModel setMultiline(STValue value) {
		return set(value, "multiline");
	}

	public STValue getMultiline() {
		return get("multiline");
	}

	public STArgument getMultilineArgument() {
		return getArgument("multiline");
	}

	public InputElementModel removeMultiline() {
		return removeArgument("multiline");
	}

	public InputElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public InputElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public InputElementModel removeName() {
		return removeArgument("name");
	}

	public InputElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public InputElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public InputElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public InputElementModel setPlaceholder(String value) {
		return setPlaceholder(db.newSTValue(value));
	}

	public InputElementModel setPlaceholder(STValue value) {
		return set(value, "placeholder");
	}

	public STValue getPlaceholder() {
		return get("placeholder");
	}

	public STArgument getPlaceholderArgument() {
		return getArgument("placeholder");
	}

	public InputElementModel removePlaceholder() {
		return removeArgument("placeholder");
	}

	public InputElementModel setReadOnly(String value) {
		return setReadOnly(db.newSTValue(value));
	}

	public InputElementModel setReadOnly(STValue value) {
		return set(value, "readOnly");
	}

	public STValue getReadOnly() {
		return get("readOnly");
	}

	public STArgument getReadOnlyArgument() {
		return getArgument("readOnly");
	}

	public InputElementModel removeReadOnly() {
		return removeArgument("readOnly");
	}

	public InputElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public InputElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public InputElementModel removeRequired() {
		return removeArgument("required");
	}

	public InputElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public InputElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public InputElementModel removeRows() {
		return removeArgument("rows");
	}

	public InputElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public InputElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public InputElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public InputElementModel setStartAdornment(String value) {
		return setStartAdornment(db.newSTValue(value));
	}

	public InputElementModel setStartAdornment(STValue value) {
		return set(value, "startAdornment");
	}

	public STValue getStartAdornment() {
		return get("startAdornment");
	}

	public STArgument getStartAdornmentArgument() {
		return getArgument("startAdornment");
	}

	public InputElementModel removeStartAdornment() {
		return removeArgument("startAdornment");
	}

	public InputElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public InputElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public InputElementModel removeStyle() {
		return removeArgument("style");
	}

	public InputElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public InputElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public InputElementModel removeType() {
		return removeArgument("type");
	}

	public InputElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public InputElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public InputElementModel removeValue() {
		return removeArgument("value");
	}


	public InputElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public InputElementModel addAttribute(InputElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public InputElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<InputElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new InputElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class InputElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public InputElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public InputElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public InputElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public InputElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public InputElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private InputElementModel_Attribute setKVValue(String name, STValue value) {

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

	private InputElementModel set(STValue value, String name) {
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

	private InputElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private InputElementModel add(STValue value, String name) {
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