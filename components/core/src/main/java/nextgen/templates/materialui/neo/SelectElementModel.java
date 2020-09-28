package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SelectElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "3014138e-da70-4f54-82e2-8453b57dd48d";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SelectElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SelectElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SelectElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SelectElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SelectElementModel that = (SelectElementModel) o;
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

	public SelectElementModel setAutoWidth(String value) {
		return setAutoWidth(db.newSTValue(value));
	}

	public SelectElementModel setAutoWidth(STValue value) {
		return set(value, "autoWidth");
	}

	public STValue getAutoWidth() {
		return get("autoWidth");
	}

	public STArgument getAutoWidthArgument() {
		return getArgument("autoWidth");
	}

	public SelectElementModel removeAutoWidth() {
		return removeArgument("autoWidth");
	}

	public SelectElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SelectElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SelectElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SelectElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SelectElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SelectElementModel removeClassName() {
		return removeArgument("className");
	}

	public SelectElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public SelectElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public SelectElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public SelectElementModel setDisplayEmpty(String value) {
		return setDisplayEmpty(db.newSTValue(value));
	}

	public SelectElementModel setDisplayEmpty(STValue value) {
		return set(value, "displayEmpty");
	}

	public STValue getDisplayEmpty() {
		return get("displayEmpty");
	}

	public STArgument getDisplayEmptyArgument() {
		return getArgument("displayEmpty");
	}

	public SelectElementModel removeDisplayEmpty() {
		return removeArgument("displayEmpty");
	}

	public SelectElementModel setIconComponent(String value) {
		return setIconComponent(db.newSTValue(value));
	}

	public SelectElementModel setIconComponent(STValue value) {
		return set(value, "IconComponent");
	}

	public STValue getIconComponent() {
		return get("IconComponent");
	}

	public STArgument getIconComponentArgument() {
		return getArgument("IconComponent");
	}

	public SelectElementModel removeIconComponent() {
		return removeArgument("IconComponent");
	}

	public SelectElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SelectElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SelectElementModel removeId() {
		return removeArgument("id");
	}

	public SelectElementModel setInput(String value) {
		return setInput(db.newSTValue(value));
	}

	public SelectElementModel setInput(STValue value) {
		return set(value, "input");
	}

	public STValue getInput() {
		return get("input");
	}

	public STArgument getInputArgument() {
		return getArgument("input");
	}

	public SelectElementModel removeInput() {
		return removeArgument("input");
	}

	public SelectElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public SelectElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public SelectElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public SelectElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SelectElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SelectElementModel removeKey() {
		return removeArgument("key");
	}

	public SelectElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public SelectElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public SelectElementModel removeLabel() {
		return removeArgument("label");
	}

	public SelectElementModel setLabelId(String value) {
		return setLabelId(db.newSTValue(value));
	}

	public SelectElementModel setLabelId(STValue value) {
		return set(value, "labelId");
	}

	public STValue getLabelId() {
		return get("labelId");
	}

	public STArgument getLabelIdArgument() {
		return getArgument("labelId");
	}

	public SelectElementModel removeLabelId() {
		return removeArgument("labelId");
	}

	public SelectElementModel setLabelWidth(String value) {
		return setLabelWidth(db.newSTValue(value));
	}

	public SelectElementModel setLabelWidth(STValue value) {
		return set(value, "labelWidth");
	}

	public STValue getLabelWidth() {
		return get("labelWidth");
	}

	public STArgument getLabelWidthArgument() {
		return getArgument("labelWidth");
	}

	public SelectElementModel removeLabelWidth() {
		return removeArgument("labelWidth");
	}

	public SelectElementModel setMenuProps(String value) {
		return setMenuProps(db.newSTValue(value));
	}

	public SelectElementModel setMenuProps(STValue value) {
		return set(value, "MenuProps");
	}

	public STValue getMenuProps() {
		return get("MenuProps");
	}

	public STArgument getMenuPropsArgument() {
		return getArgument("MenuProps");
	}

	public SelectElementModel removeMenuProps() {
		return removeArgument("MenuProps");
	}

	public SelectElementModel setMultiple(String value) {
		return setMultiple(db.newSTValue(value));
	}

	public SelectElementModel setMultiple(STValue value) {
		return set(value, "multiple");
	}

	public STValue getMultiple() {
		return get("multiple");
	}

	public STArgument getMultipleArgument() {
		return getArgument("multiple");
	}

	public SelectElementModel removeMultiple() {
		return removeArgument("multiple");
	}

	public SelectElementModel setNative(String value) {
		return setNative(db.newSTValue(value));
	}

	public SelectElementModel setNative(STValue value) {
		return set(value, "native");
	}

	public STValue getNative() {
		return get("native");
	}

	public STArgument getNativeArgument() {
		return getArgument("native");
	}

	public SelectElementModel removeNative() {
		return removeArgument("native");
	}

	public SelectElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public SelectElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public SelectElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public SelectElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public SelectElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public SelectElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public SelectElementModel setOnOpen(String value) {
		return setOnOpen(db.newSTValue(value));
	}

	public SelectElementModel setOnOpen(STValue value) {
		return set(value, "onOpen");
	}

	public STValue getOnOpen() {
		return get("onOpen");
	}

	public STArgument getOnOpenArgument() {
		return getArgument("onOpen");
	}

	public SelectElementModel removeOnOpen() {
		return removeArgument("onOpen");
	}

	public SelectElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public SelectElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public SelectElementModel removeOpen() {
		return removeArgument("open");
	}

	public SelectElementModel setRenderValue(String value) {
		return setRenderValue(db.newSTValue(value));
	}

	public SelectElementModel setRenderValue(STValue value) {
		return set(value, "renderValue");
	}

	public STValue getRenderValue() {
		return get("renderValue");
	}

	public STArgument getRenderValueArgument() {
		return getArgument("renderValue");
	}

	public SelectElementModel removeRenderValue() {
		return removeArgument("renderValue");
	}

	public SelectElementModel setSelectDisplayProps(String value) {
		return setSelectDisplayProps(db.newSTValue(value));
	}

	public SelectElementModel setSelectDisplayProps(STValue value) {
		return set(value, "SelectDisplayProps");
	}

	public STValue getSelectDisplayProps() {
		return get("SelectDisplayProps");
	}

	public STArgument getSelectDisplayPropsArgument() {
		return getArgument("SelectDisplayProps");
	}

	public SelectElementModel removeSelectDisplayProps() {
		return removeArgument("SelectDisplayProps");
	}

	public SelectElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SelectElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SelectElementModel removeStyle() {
		return removeArgument("style");
	}

	public SelectElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public SelectElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public SelectElementModel removeValue() {
		return removeArgument("value");
	}

	public SelectElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public SelectElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public SelectElementModel removeVariant() {
		return removeArgument("variant");
	}

	public SelectElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SelectElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SelectElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SelectElementModel addAttribute(SelectElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SelectElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SelectElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SelectElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SelectElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SelectElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SelectElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SelectElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SelectElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SelectElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SelectElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SelectElementModel set(STValue value, String name) {
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

	private SelectElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SelectElementModel add(STValue value, String name) {
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