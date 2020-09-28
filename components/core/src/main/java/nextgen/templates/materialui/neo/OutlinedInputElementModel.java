package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class OutlinedInputElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8a748bd1-150d-43b4-96a0-7ca246d01e68";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public OutlinedInputElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public OutlinedInputElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public OutlinedInputElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public OutlinedInputElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OutlinedInputElementModel that = (OutlinedInputElementModel) o;
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

	public OutlinedInputElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public OutlinedInputElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public OutlinedInputElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public OutlinedInputElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public OutlinedInputElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public OutlinedInputElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public OutlinedInputElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public OutlinedInputElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public OutlinedInputElementModel removeClasses() {
		return removeArgument("classes");
	}

	public OutlinedInputElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public OutlinedInputElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public OutlinedInputElementModel removeClassName() {
		return removeArgument("className");
	}

	public OutlinedInputElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public OutlinedInputElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public OutlinedInputElementModel removeColor() {
		return removeArgument("color");
	}

	public OutlinedInputElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public OutlinedInputElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public OutlinedInputElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public OutlinedInputElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public OutlinedInputElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public OutlinedInputElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public OutlinedInputElementModel setEndAdornment(String value) {
		return setEndAdornment(db.newSTValue(value));
	}

	public OutlinedInputElementModel setEndAdornment(STValue value) {
		return set(value, "endAdornment");
	}

	public STValue getEndAdornment() {
		return get("endAdornment");
	}

	public STArgument getEndAdornmentArgument() {
		return getArgument("endAdornment");
	}

	public OutlinedInputElementModel removeEndAdornment() {
		return removeArgument("endAdornment");
	}

	public OutlinedInputElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public OutlinedInputElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public OutlinedInputElementModel removeError() {
		return removeArgument("error");
	}

	public OutlinedInputElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public OutlinedInputElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public OutlinedInputElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public OutlinedInputElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public OutlinedInputElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public OutlinedInputElementModel removeId() {
		return removeArgument("id");
	}

	public OutlinedInputElementModel setInputComponent(String value) {
		return setInputComponent(db.newSTValue(value));
	}

	public OutlinedInputElementModel setInputComponent(STValue value) {
		return set(value, "inputComponent");
	}

	public STValue getInputComponent() {
		return get("inputComponent");
	}

	public STArgument getInputComponentArgument() {
		return getArgument("inputComponent");
	}

	public OutlinedInputElementModel removeInputComponent() {
		return removeArgument("inputComponent");
	}

	public OutlinedInputElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public OutlinedInputElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public OutlinedInputElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public OutlinedInputElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public OutlinedInputElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public OutlinedInputElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public OutlinedInputElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public OutlinedInputElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public OutlinedInputElementModel removeKey() {
		return removeArgument("key");
	}

	public OutlinedInputElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public OutlinedInputElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public OutlinedInputElementModel removeLabel() {
		return removeArgument("label");
	}

	public OutlinedInputElementModel setLabelWidth(String value) {
		return setLabelWidth(db.newSTValue(value));
	}

	public OutlinedInputElementModel setLabelWidth(STValue value) {
		return set(value, "labelWidth");
	}

	public STValue getLabelWidth() {
		return get("labelWidth");
	}

	public STArgument getLabelWidthArgument() {
		return getArgument("labelWidth");
	}

	public OutlinedInputElementModel removeLabelWidth() {
		return removeArgument("labelWidth");
	}

	public OutlinedInputElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public OutlinedInputElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public OutlinedInputElementModel removeMargin() {
		return removeArgument("margin");
	}

	public OutlinedInputElementModel setMultiline(String value) {
		return setMultiline(db.newSTValue(value));
	}

	public OutlinedInputElementModel setMultiline(STValue value) {
		return set(value, "multiline");
	}

	public STValue getMultiline() {
		return get("multiline");
	}

	public STArgument getMultilineArgument() {
		return getArgument("multiline");
	}

	public OutlinedInputElementModel removeMultiline() {
		return removeArgument("multiline");
	}

	public OutlinedInputElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public OutlinedInputElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public OutlinedInputElementModel removeName() {
		return removeArgument("name");
	}

	public OutlinedInputElementModel setNotched(String value) {
		return setNotched(db.newSTValue(value));
	}

	public OutlinedInputElementModel setNotched(STValue value) {
		return set(value, "notched");
	}

	public STValue getNotched() {
		return get("notched");
	}

	public STArgument getNotchedArgument() {
		return getArgument("notched");
	}

	public OutlinedInputElementModel removeNotched() {
		return removeArgument("notched");
	}

	public OutlinedInputElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public OutlinedInputElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public OutlinedInputElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public OutlinedInputElementModel setPlaceholder(String value) {
		return setPlaceholder(db.newSTValue(value));
	}

	public OutlinedInputElementModel setPlaceholder(STValue value) {
		return set(value, "placeholder");
	}

	public STValue getPlaceholder() {
		return get("placeholder");
	}

	public STArgument getPlaceholderArgument() {
		return getArgument("placeholder");
	}

	public OutlinedInputElementModel removePlaceholder() {
		return removeArgument("placeholder");
	}

	public OutlinedInputElementModel setReadOnly(String value) {
		return setReadOnly(db.newSTValue(value));
	}

	public OutlinedInputElementModel setReadOnly(STValue value) {
		return set(value, "readOnly");
	}

	public STValue getReadOnly() {
		return get("readOnly");
	}

	public STArgument getReadOnlyArgument() {
		return getArgument("readOnly");
	}

	public OutlinedInputElementModel removeReadOnly() {
		return removeArgument("readOnly");
	}

	public OutlinedInputElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public OutlinedInputElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public OutlinedInputElementModel removeRequired() {
		return removeArgument("required");
	}

	public OutlinedInputElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public OutlinedInputElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public OutlinedInputElementModel removeRows() {
		return removeArgument("rows");
	}

	public OutlinedInputElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public OutlinedInputElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public OutlinedInputElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public OutlinedInputElementModel setStartAdornment(String value) {
		return setStartAdornment(db.newSTValue(value));
	}

	public OutlinedInputElementModel setStartAdornment(STValue value) {
		return set(value, "startAdornment");
	}

	public STValue getStartAdornment() {
		return get("startAdornment");
	}

	public STArgument getStartAdornmentArgument() {
		return getArgument("startAdornment");
	}

	public OutlinedInputElementModel removeStartAdornment() {
		return removeArgument("startAdornment");
	}

	public OutlinedInputElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public OutlinedInputElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public OutlinedInputElementModel removeStyle() {
		return removeArgument("style");
	}

	public OutlinedInputElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public OutlinedInputElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public OutlinedInputElementModel removeType() {
		return removeArgument("type");
	}

	public OutlinedInputElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public OutlinedInputElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public OutlinedInputElementModel removeValue() {
		return removeArgument("value");
	}


	public OutlinedInputElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public OutlinedInputElementModel addAttribute(OutlinedInputElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public OutlinedInputElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<OutlinedInputElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new OutlinedInputElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class OutlinedInputElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public OutlinedInputElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public OutlinedInputElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public OutlinedInputElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public OutlinedInputElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public OutlinedInputElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private OutlinedInputElementModel_Attribute setKVValue(String name, STValue value) {

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

	private OutlinedInputElementModel set(STValue value, String name) {
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

	private OutlinedInputElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private OutlinedInputElementModel add(STValue value, String name) {
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