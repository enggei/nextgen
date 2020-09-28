package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NativeSelectElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "57c97e5a-5758-41ea-8974-81fd2d07fab1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public NativeSelectElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public NativeSelectElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public NativeSelectElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public NativeSelectElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NativeSelectElementModel that = (NativeSelectElementModel) o;
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

	public NativeSelectElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public NativeSelectElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public NativeSelectElementModel removeClasses() {
		return removeArgument("classes");
	}

	public NativeSelectElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public NativeSelectElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public NativeSelectElementModel removeClassName() {
		return removeArgument("className");
	}

	public NativeSelectElementModel setIconComponent(String value) {
		return setIconComponent(db.newSTValue(value));
	}

	public NativeSelectElementModel setIconComponent(STValue value) {
		return set(value, "IconComponent");
	}

	public STValue getIconComponent() {
		return get("IconComponent");
	}

	public STArgument getIconComponentArgument() {
		return getArgument("IconComponent");
	}

	public NativeSelectElementModel removeIconComponent() {
		return removeArgument("IconComponent");
	}

	public NativeSelectElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public NativeSelectElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public NativeSelectElementModel removeId() {
		return removeArgument("id");
	}

	public NativeSelectElementModel setInput(String value) {
		return setInput(db.newSTValue(value));
	}

	public NativeSelectElementModel setInput(STValue value) {
		return set(value, "input");
	}

	public STValue getInput() {
		return get("input");
	}

	public STArgument getInputArgument() {
		return getArgument("input");
	}

	public NativeSelectElementModel removeInput() {
		return removeArgument("input");
	}

	public NativeSelectElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public NativeSelectElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public NativeSelectElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public NativeSelectElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public NativeSelectElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public NativeSelectElementModel removeKey() {
		return removeArgument("key");
	}

	public NativeSelectElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public NativeSelectElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public NativeSelectElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public NativeSelectElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public NativeSelectElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public NativeSelectElementModel removeStyle() {
		return removeArgument("style");
	}

	public NativeSelectElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public NativeSelectElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public NativeSelectElementModel removeValue() {
		return removeArgument("value");
	}

	public NativeSelectElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public NativeSelectElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public NativeSelectElementModel removeVariant() {
		return removeArgument("variant");
	}

	public NativeSelectElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public NativeSelectElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public NativeSelectElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public NativeSelectElementModel addAttribute(NativeSelectElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public NativeSelectElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<NativeSelectElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new NativeSelectElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class NativeSelectElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public NativeSelectElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public NativeSelectElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public NativeSelectElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public NativeSelectElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public NativeSelectElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private NativeSelectElementModel_Attribute setKVValue(String name, STValue value) {

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

	private NativeSelectElementModel set(STValue value, String name) {
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

	private NativeSelectElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private NativeSelectElementModel add(STValue value, String name) {
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