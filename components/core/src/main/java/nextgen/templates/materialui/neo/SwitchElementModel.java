package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SwitchElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "e431642a-b534-44be-8b30-ff6c1d1042e0";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SwitchElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SwitchElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SwitchElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SwitchElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwitchElementModel that = (SwitchElementModel) o;
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

	public SwitchElementModel setChecked(String value) {
		return setChecked(db.newSTValue(value));
	}

	public SwitchElementModel setChecked(STValue value) {
		return set(value, "checked");
	}

	public STValue getChecked() {
		return get("checked");
	}

	public STArgument getCheckedArgument() {
		return getArgument("checked");
	}

	public SwitchElementModel removeChecked() {
		return removeArgument("checked");
	}

	public SwitchElementModel setCheckedIcon(String value) {
		return setCheckedIcon(db.newSTValue(value));
	}

	public SwitchElementModel setCheckedIcon(STValue value) {
		return set(value, "checkedIcon");
	}

	public STValue getCheckedIcon() {
		return get("checkedIcon");
	}

	public STArgument getCheckedIconArgument() {
		return getArgument("checkedIcon");
	}

	public SwitchElementModel removeCheckedIcon() {
		return removeArgument("checkedIcon");
	}

	public SwitchElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SwitchElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SwitchElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SwitchElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SwitchElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SwitchElementModel removeClassName() {
		return removeArgument("className");
	}

	public SwitchElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public SwitchElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public SwitchElementModel removeColor() {
		return removeArgument("color");
	}

	public SwitchElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public SwitchElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public SwitchElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public SwitchElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public SwitchElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public SwitchElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public SwitchElementModel setEdge(String value) {
		return setEdge(db.newSTValue(value));
	}

	public SwitchElementModel setEdge(STValue value) {
		return set(value, "edge");
	}

	public STValue getEdge() {
		return get("edge");
	}

	public STArgument getEdgeArgument() {
		return getArgument("edge");
	}

	public SwitchElementModel removeEdge() {
		return removeArgument("edge");
	}

	public SwitchElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public SwitchElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public SwitchElementModel removeIcon() {
		return removeArgument("icon");
	}

	public SwitchElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SwitchElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SwitchElementModel removeId() {
		return removeArgument("id");
	}

	public SwitchElementModel setInputProps(String value) {
		return setInputProps(db.newSTValue(value));
	}

	public SwitchElementModel setInputProps(STValue value) {
		return set(value, "inputProps");
	}

	public STValue getInputProps() {
		return get("inputProps");
	}

	public STArgument getInputPropsArgument() {
		return getArgument("inputProps");
	}

	public SwitchElementModel removeInputProps() {
		return removeArgument("inputProps");
	}

	public SwitchElementModel setInputRef(String value) {
		return setInputRef(db.newSTValue(value));
	}

	public SwitchElementModel setInputRef(STValue value) {
		return set(value, "inputRef");
	}

	public STValue getInputRef() {
		return get("inputRef");
	}

	public STArgument getInputRefArgument() {
		return getArgument("inputRef");
	}

	public SwitchElementModel removeInputRef() {
		return removeArgument("inputRef");
	}

	public SwitchElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SwitchElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SwitchElementModel removeKey() {
		return removeArgument("key");
	}

	public SwitchElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public SwitchElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public SwitchElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public SwitchElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public SwitchElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public SwitchElementModel removeRequired() {
		return removeArgument("required");
	}

	public SwitchElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public SwitchElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public SwitchElementModel removeSize() {
		return removeArgument("size");
	}

	public SwitchElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SwitchElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SwitchElementModel removeStyle() {
		return removeArgument("style");
	}

	public SwitchElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public SwitchElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public SwitchElementModel removeValue() {
		return removeArgument("value");
	}


	public SwitchElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SwitchElementModel addAttribute(SwitchElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SwitchElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SwitchElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SwitchElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SwitchElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SwitchElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SwitchElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SwitchElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SwitchElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SwitchElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SwitchElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SwitchElementModel set(STValue value, String name) {
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

	private SwitchElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SwitchElementModel add(STValue value, String name) {
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