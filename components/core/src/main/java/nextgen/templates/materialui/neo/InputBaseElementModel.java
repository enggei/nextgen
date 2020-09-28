package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class InputBaseElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "e2931190-4ab5-4bc7-9264-6543caa7799d";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public InputBaseElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public InputBaseElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public InputBaseElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public InputBaseElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InputBaseElementModel that = (InputBaseElementModel) o;
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

	public InputBaseElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public InputBaseElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public InputBaseElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public InputBaseElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public InputBaseElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public InputBaseElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public InputBaseElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public InputBaseElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public InputBaseElementModel removeClasses() {
		return removeArgument("classes");
	}

	public InputBaseElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public InputBaseElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public InputBaseElementModel removeClassName() {
		return removeArgument("className");
	}

	public InputBaseElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public InputBaseElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public InputBaseElementModel removeColor() {
		return removeArgument("color");
	}

	public InputBaseElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public InputBaseElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public InputBaseElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public InputBaseElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public InputBaseElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public InputBaseElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public InputBaseElementModel setEndAdornment(String value) {
		return setEndAdornment(db.newSTValue(value));
	}

	public InputBaseElementModel setEndAdornment(STValue value) {
		return set(value, "endAdornment");
	}

	public STValue getEndAdornment() {
		return get("endAdornment");
	}

	public STArgument getEndAdornmentArgument() {
		return getArgument("endAdornment");
	}

	public InputBaseElementModel removeEndAdornment() {
		return removeArgument("endAdornment");
	}

	public InputBaseElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public InputBaseElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public InputBaseElementModel removeError() {
		return removeArgument("error");
	}

	public InputBaseElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public InputBaseElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public InputBaseElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public InputBaseElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public InputBaseElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public InputBaseElementModel removeId() {
		return removeArgument("id");
	}

	public InputBaseElementModel setInputComponent(String value) {
		return setInputComponent(db.newSTValue(value));
	}

	public InputBaseElementModel setInputComponent(STValue value) {
		return set(value, "inputComponent");
	}

	public STValue getInputComponent() {
		return get("inputComponent");
	}

	public STArgument getInputComponentArgument() {
		return getArgument("inputComponent");
	}

	public InputBaseElementModel removeInputComponent() {
		return removeArgument("inputComponent");
	}

	public InputBaseElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public InputBaseElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public InputBaseElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public InputBaseElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public InputBaseElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public InputBaseElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public InputBaseElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public InputBaseElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public InputBaseElementModel removeKey() {
		return removeArgument("key");
	}

	public InputBaseElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public InputBaseElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public InputBaseElementModel removeMargin() {
		return removeArgument("margin");
	}

	public InputBaseElementModel setMultiline(String value) {
		return setMultiline(db.newSTValue(value));
	}

	public InputBaseElementModel setMultiline(STValue value) {
		return set(value, "multiline");
	}

	public STValue getMultiline() {
		return get("multiline");
	}

	public STArgument getMultilineArgument() {
		return getArgument("multiline");
	}

	public InputBaseElementModel removeMultiline() {
		return removeArgument("multiline");
	}

	public InputBaseElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public InputBaseElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public InputBaseElementModel removeName() {
		return removeArgument("name");
	}

	public InputBaseElementModel setOnBlur(String value) {
		return setOnBlur(db.newSTValue(value));
	}

	public InputBaseElementModel setOnBlur(STValue value) {
		return set(value, "onBlur");
	}

	public STValue getOnBlur() {
		return get("onBlur");
	}

	public STArgument getOnBlurArgument() {
		return getArgument("onBlur");
	}

	public InputBaseElementModel removeOnBlur() {
		return removeArgument("onBlur");
	}

	public InputBaseElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public InputBaseElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public InputBaseElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public InputBaseElementModel setPlaceholder(String value) {
		return setPlaceholder(db.newSTValue(value));
	}

	public InputBaseElementModel setPlaceholder(STValue value) {
		return set(value, "placeholder");
	}

	public STValue getPlaceholder() {
		return get("placeholder");
	}

	public STArgument getPlaceholderArgument() {
		return getArgument("placeholder");
	}

	public InputBaseElementModel removePlaceholder() {
		return removeArgument("placeholder");
	}

	public InputBaseElementModel setReadOnly(String value) {
		return setReadOnly(db.newSTValue(value));
	}

	public InputBaseElementModel setReadOnly(STValue value) {
		return set(value, "readOnly");
	}

	public STValue getReadOnly() {
		return get("readOnly");
	}

	public STArgument getReadOnlyArgument() {
		return getArgument("readOnly");
	}

	public InputBaseElementModel removeReadOnly() {
		return removeArgument("readOnly");
	}

	public InputBaseElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public InputBaseElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public InputBaseElementModel removeRequired() {
		return removeArgument("required");
	}

	public InputBaseElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public InputBaseElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public InputBaseElementModel removeRows() {
		return removeArgument("rows");
	}

	public InputBaseElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public InputBaseElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public InputBaseElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public InputBaseElementModel setRowsMin(String value) {
		return setRowsMin(db.newSTValue(value));
	}

	public InputBaseElementModel setRowsMin(STValue value) {
		return set(value, "rowsMin");
	}

	public STValue getRowsMin() {
		return get("rowsMin");
	}

	public STArgument getRowsMinArgument() {
		return getArgument("rowsMin");
	}

	public InputBaseElementModel removeRowsMin() {
		return removeArgument("rowsMin");
	}

	public InputBaseElementModel setStartAdornment(String value) {
		return setStartAdornment(db.newSTValue(value));
	}

	public InputBaseElementModel setStartAdornment(STValue value) {
		return set(value, "startAdornment");
	}

	public STValue getStartAdornment() {
		return get("startAdornment");
	}

	public STArgument getStartAdornmentArgument() {
		return getArgument("startAdornment");
	}

	public InputBaseElementModel removeStartAdornment() {
		return removeArgument("startAdornment");
	}

	public InputBaseElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public InputBaseElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public InputBaseElementModel removeStyle() {
		return removeArgument("style");
	}

	public InputBaseElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public InputBaseElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public InputBaseElementModel removeType() {
		return removeArgument("type");
	}

	public InputBaseElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public InputBaseElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public InputBaseElementModel removeValue() {
		return removeArgument("value");
	}


	public InputBaseElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public InputBaseElementModel addAttribute(InputBaseElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public InputBaseElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<InputBaseElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new InputBaseElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class InputBaseElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public InputBaseElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public InputBaseElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public InputBaseElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public InputBaseElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public InputBaseElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private InputBaseElementModel_Attribute setKVValue(String name, STValue value) {

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

	private InputBaseElementModel set(STValue value, String name) {
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

	private InputBaseElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private InputBaseElementModel add(STValue value, String name) {
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