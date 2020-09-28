package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FilledInputElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "6250b9eb-4714-4624-8720-a9ff38c42d13";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public FilledInputElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public FilledInputElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public FilledInputElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public FilledInputElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FilledInputElementModel that = (FilledInputElementModel) o;
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

	public FilledInputElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public FilledInputElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public FilledInputElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public FilledInputElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public FilledInputElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public FilledInputElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public FilledInputElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public FilledInputElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public FilledInputElementModel removeClasses() {
		return removeArgument("classes");
	}

	public FilledInputElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public FilledInputElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public FilledInputElementModel removeClassName() {
		return removeArgument("className");
	}

	public FilledInputElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public FilledInputElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public FilledInputElementModel removeColor() {
		return removeArgument("color");
	}

	public FilledInputElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public FilledInputElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public FilledInputElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public FilledInputElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public FilledInputElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public FilledInputElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public FilledInputElementModel setDisableUnderline(String value) {
		return setDisableUnderline(db.newSTValue(value));
	}

	public FilledInputElementModel setDisableUnderline(STValue value) {
		return set(value, "disableUnderline");
	}

	public STValue getDisableUnderline() {
		return get("disableUnderline");
	}

	public STArgument getDisableUnderlineArgument() {
		return getArgument("disableUnderline");
	}

	public FilledInputElementModel removeDisableUnderline() {
		return removeArgument("disableUnderline");
	}

	public FilledInputElementModel setEndAdornment(String value) {
		return setEndAdornment(db.newSTValue(value));
	}

	public FilledInputElementModel setEndAdornment(STValue value) {
		return set(value, "endAdornment");
	}

	public STValue getEndAdornment() {
		return get("endAdornment");
	}

	public STArgument getEndAdornmentArgument() {
		return getArgument("endAdornment");
	}

	public FilledInputElementModel removeEndAdornment() {
		return removeArgument("endAdornment");
	}

	public FilledInputElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public FilledInputElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public FilledInputElementModel removeError() {
		return removeArgument("error");
	}

	public FilledInputElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public FilledInputElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public FilledInputElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public FilledInputElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public FilledInputElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public FilledInputElementModel removeId() {
		return removeArgument("id");
	}

	public FilledInputElementModel setInputComponent(String value) {
		return setInputComponent(db.newSTValue(value));
	}

	public FilledInputElementModel setInputComponent(STValue value) {
		return set(value, "inputComponent");
	}

	public STValue getInputComponent() {
		return get("inputComponent");
	}

	public STArgument getInputComponentArgument() {
		return getArgument("inputComponent");
	}

	public FilledInputElementModel removeInputComponent() {
		return removeArgument("inputComponent");
	}

	public FilledInputElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public FilledInputElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public FilledInputElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public FilledInputElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public FilledInputElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public FilledInputElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public FilledInputElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public FilledInputElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public FilledInputElementModel removeKey() {
		return removeArgument("key");
	}

	public FilledInputElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public FilledInputElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public FilledInputElementModel removeMargin() {
		return removeArgument("margin");
	}

	public FilledInputElementModel setMultiline(String value) {
		return setMultiline(db.newSTValue(value));
	}

	public FilledInputElementModel setMultiline(STValue value) {
		return set(value, "multiline");
	}

	public STValue getMultiline() {
		return get("multiline");
	}

	public STArgument getMultilineArgument() {
		return getArgument("multiline");
	}

	public FilledInputElementModel removeMultiline() {
		return removeArgument("multiline");
	}

	public FilledInputElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public FilledInputElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public FilledInputElementModel removeName() {
		return removeArgument("name");
	}

	public FilledInputElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public FilledInputElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public FilledInputElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public FilledInputElementModel setPlaceholder(String value) {
		return setPlaceholder(db.newSTValue(value));
	}

	public FilledInputElementModel setPlaceholder(STValue value) {
		return set(value, "placeholder");
	}

	public STValue getPlaceholder() {
		return get("placeholder");
	}

	public STArgument getPlaceholderArgument() {
		return getArgument("placeholder");
	}

	public FilledInputElementModel removePlaceholder() {
		return removeArgument("placeholder");
	}

	public FilledInputElementModel setReadOnly(String value) {
		return setReadOnly(db.newSTValue(value));
	}

	public FilledInputElementModel setReadOnly(STValue value) {
		return set(value, "readOnly");
	}

	public STValue getReadOnly() {
		return get("readOnly");
	}

	public STArgument getReadOnlyArgument() {
		return getArgument("readOnly");
	}

	public FilledInputElementModel removeReadOnly() {
		return removeArgument("readOnly");
	}

	public FilledInputElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public FilledInputElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public FilledInputElementModel removeRequired() {
		return removeArgument("required");
	}

	public FilledInputElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public FilledInputElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public FilledInputElementModel removeRows() {
		return removeArgument("rows");
	}

	public FilledInputElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public FilledInputElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public FilledInputElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public FilledInputElementModel setStartAdornment(String value) {
		return setStartAdornment(db.newSTValue(value));
	}

	public FilledInputElementModel setStartAdornment(STValue value) {
		return set(value, "startAdornment");
	}

	public STValue getStartAdornment() {
		return get("startAdornment");
	}

	public STArgument getStartAdornmentArgument() {
		return getArgument("startAdornment");
	}

	public FilledInputElementModel removeStartAdornment() {
		return removeArgument("startAdornment");
	}

	public FilledInputElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public FilledInputElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public FilledInputElementModel removeStyle() {
		return removeArgument("style");
	}

	public FilledInputElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public FilledInputElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public FilledInputElementModel removeType() {
		return removeArgument("type");
	}

	public FilledInputElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public FilledInputElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public FilledInputElementModel removeValue() {
		return removeArgument("value");
	}


	public FilledInputElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public FilledInputElementModel addAttribute(FilledInputElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public FilledInputElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<FilledInputElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new FilledInputElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class FilledInputElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public FilledInputElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public FilledInputElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public FilledInputElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public FilledInputElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public FilledInputElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private FilledInputElementModel_Attribute setKVValue(String name, STValue value) {

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

	private FilledInputElementModel set(STValue value, String name) {
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

	private FilledInputElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private FilledInputElementModel add(STValue value, String name) {
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