package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TextFieldElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "e9e9aff1-219a-4957-b9b2-a96ae031da01";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TextFieldElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TextFieldElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TextFieldElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TextFieldElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TextFieldElementModel that = (TextFieldElementModel) o;
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

	public TextFieldElementModel setAutoComplete(String value) {
		return setAutoComplete(db.newSTValue(value));
	}

	public TextFieldElementModel setAutoComplete(STValue value) {
		return set(value, "autoComplete");
	}

	public STValue getAutoComplete() {
		return get("autoComplete");
	}

	public STArgument getAutoCompleteArgument() {
		return getArgument("autoComplete");
	}

	public TextFieldElementModel removeAutoComplete() {
		return removeArgument("autoComplete");
	}

	public TextFieldElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public TextFieldElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public TextFieldElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public TextFieldElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TextFieldElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TextFieldElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TextFieldElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TextFieldElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TextFieldElementModel removeClassName() {
		return removeArgument("className");
	}

	public TextFieldElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public TextFieldElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public TextFieldElementModel removeColor() {
		return removeArgument("color");
	}

	public TextFieldElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public TextFieldElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public TextFieldElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public TextFieldElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public TextFieldElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public TextFieldElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public TextFieldElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public TextFieldElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public TextFieldElementModel removeError() {
		return removeArgument("error");
	}

	public TextFieldElementModel setFormHelperTextProps(String value) {
		return setFormHelperTextProps(db.newSTValue(value));
	}

	public TextFieldElementModel setFormHelperTextProps(STValue value) {
		return set(value, "FormHelperTextProps");
	}

	public STValue getFormHelperTextProps() {
		return get("FormHelperTextProps");
	}

	public STArgument getFormHelperTextPropsArgument() {
		return getArgument("FormHelperTextProps");
	}

	public TextFieldElementModel removeFormHelperTextProps() {
		return removeArgument("FormHelperTextProps");
	}

	public TextFieldElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public TextFieldElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public TextFieldElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public TextFieldElementModel setHelperText(String value) {
		return setHelperText(db.newSTValue(value));
	}

	public TextFieldElementModel setHelperText(STValue value) {
		return set(value, "helperText");
	}

	public STValue getHelperText() {
		return get("helperText");
	}

	public STArgument getHelperTextArgument() {
		return getArgument("helperText");
	}

	public TextFieldElementModel removeHelperText() {
		return removeArgument("helperText");
	}

	public TextFieldElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TextFieldElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TextFieldElementModel removeId() {
		return removeArgument("id");
	}

	public TextFieldElementModel setInputLabelProps(String value) {
		return setInputLabelProps(db.newSTValue(value));
	}

	public TextFieldElementModel setInputLabelProps(STValue value) {
		return set(value, "InputLabelProps");
	}

	public STValue getInputLabelProps() {
		return get("InputLabelProps");
	}

	public STArgument getInputLabelPropsArgument() {
		return getArgument("InputLabelProps");
	}

	public TextFieldElementModel removeInputLabelProps() {
		return removeArgument("InputLabelProps");
	}

	public TextFieldElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public TextFieldElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public TextFieldElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public TextFieldElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public TextFieldElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public TextFieldElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public TextFieldElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TextFieldElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TextFieldElementModel removeKey() {
		return removeArgument("key");
	}

	public TextFieldElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public TextFieldElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public TextFieldElementModel removeLabel() {
		return removeArgument("label");
	}

	public TextFieldElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public TextFieldElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public TextFieldElementModel removeMargin() {
		return removeArgument("margin");
	}

	public TextFieldElementModel setMultiline(String value) {
		return setMultiline(db.newSTValue(value));
	}

	public TextFieldElementModel setMultiline(STValue value) {
		return set(value, "multiline");
	}

	public STValue getMultiline() {
		return get("multiline");
	}

	public STArgument getMultilineArgument() {
		return getArgument("multiline");
	}

	public TextFieldElementModel removeMultiline() {
		return removeArgument("multiline");
	}

	public TextFieldElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public TextFieldElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public TextFieldElementModel removeName() {
		return removeArgument("name");
	}

	public TextFieldElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public TextFieldElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public TextFieldElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public TextFieldElementModel setPlaceholder(String value) {
		return setPlaceholder(db.newSTValue(value));
	}

	public TextFieldElementModel setPlaceholder(STValue value) {
		return set(value, "placeholder");
	}

	public STValue getPlaceholder() {
		return get("placeholder");
	}

	public STArgument getPlaceholderArgument() {
		return getArgument("placeholder");
	}

	public TextFieldElementModel removePlaceholder() {
		return removeArgument("placeholder");
	}

	public TextFieldElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public TextFieldElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public TextFieldElementModel removeRequired() {
		return removeArgument("required");
	}

	public TextFieldElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public TextFieldElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public TextFieldElementModel removeRows() {
		return removeArgument("rows");
	}

	public TextFieldElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public TextFieldElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public TextFieldElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public TextFieldElementModel setSelect(String value) {
		return setSelect(db.newSTValue(value));
	}

	public TextFieldElementModel setSelect(STValue value) {
		return set(value, "select");
	}

	public STValue getSelect() {
		return get("select");
	}

	public STArgument getSelectArgument() {
		return getArgument("select");
	}

	public TextFieldElementModel removeSelect() {
		return removeArgument("select");
	}

	public TextFieldElementModel setSelectProps(String value) {
		return setSelectProps(db.newSTValue(value));
	}

	public TextFieldElementModel setSelectProps(STValue value) {
		return set(value, "SelectProps");
	}

	public STValue getSelectProps() {
		return get("SelectProps");
	}

	public STArgument getSelectPropsArgument() {
		return getArgument("SelectProps");
	}

	public TextFieldElementModel removeSelectProps() {
		return removeArgument("SelectProps");
	}

	public TextFieldElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public TextFieldElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public TextFieldElementModel removeSize() {
		return removeArgument("size");
	}

	public TextFieldElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TextFieldElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TextFieldElementModel removeStyle() {
		return removeArgument("style");
	}

	public TextFieldElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public TextFieldElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public TextFieldElementModel removeType() {
		return removeArgument("type");
	}

	public TextFieldElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public TextFieldElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public TextFieldElementModel removeValue() {
		return removeArgument("value");
	}

	public TextFieldElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public TextFieldElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public TextFieldElementModel removeVariant() {
		return removeArgument("variant");
	}


	public TextFieldElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TextFieldElementModel addAttribute(TextFieldElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TextFieldElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TextFieldElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TextFieldElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TextFieldElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TextFieldElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TextFieldElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TextFieldElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TextFieldElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TextFieldElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TextFieldElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TextFieldElementModel set(STValue value, String name) {
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

	private TextFieldElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TextFieldElementModel add(STValue value, String name) {
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