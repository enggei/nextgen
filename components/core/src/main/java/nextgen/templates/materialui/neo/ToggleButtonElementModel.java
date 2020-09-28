package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ToggleButtonElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "30739223-8204-4ee0-979a-4290f89ab6fc";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ToggleButtonElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ToggleButtonElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ToggleButtonElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ToggleButtonElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToggleButtonElementModel that = (ToggleButtonElementModel) o;
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

	public ToggleButtonElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ToggleButtonElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ToggleButtonElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ToggleButtonElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ToggleButtonElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ToggleButtonElementModel removeClassName() {
		return removeArgument("className");
	}

	public ToggleButtonElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ToggleButtonElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ToggleButtonElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ToggleButtonElementModel setDisableFocusRipple(String value) {
		return setDisableFocusRipple(db.newSTValue(value));
	}

	public ToggleButtonElementModel setDisableFocusRipple(STValue value) {
		return set(value, "disableFocusRipple");
	}

	public STValue getDisableFocusRipple() {
		return get("disableFocusRipple");
	}

	public STArgument getDisableFocusRippleArgument() {
		return getArgument("disableFocusRipple");
	}

	public ToggleButtonElementModel removeDisableFocusRipple() {
		return removeArgument("disableFocusRipple");
	}

	public ToggleButtonElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public ToggleButtonElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public ToggleButtonElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public ToggleButtonElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ToggleButtonElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ToggleButtonElementModel removeId() {
		return removeArgument("id");
	}

	public ToggleButtonElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ToggleButtonElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ToggleButtonElementModel removeKey() {
		return removeArgument("key");
	}

	public ToggleButtonElementModel setSelected(String value) {
		return setSelected(db.newSTValue(value));
	}

	public ToggleButtonElementModel setSelected(STValue value) {
		return set(value, "selected");
	}

	public STValue getSelected() {
		return get("selected");
	}

	public STArgument getSelectedArgument() {
		return getArgument("selected");
	}

	public ToggleButtonElementModel removeSelected() {
		return removeArgument("selected");
	}

	public ToggleButtonElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ToggleButtonElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ToggleButtonElementModel removeStyle() {
		return removeArgument("style");
	}

	public ToggleButtonElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public ToggleButtonElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public ToggleButtonElementModel removeValue() {
		return removeArgument("value");
	}

	public ToggleButtonElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ToggleButtonElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ToggleButtonElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ToggleButtonElementModel addAttribute(ToggleButtonElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ToggleButtonElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ToggleButtonElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ToggleButtonElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ToggleButtonElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ToggleButtonElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ToggleButtonElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ToggleButtonElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ToggleButtonElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ToggleButtonElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ToggleButtonElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ToggleButtonElementModel set(STValue value, String name) {
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

	private ToggleButtonElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ToggleButtonElementModel add(STValue value, String name) {
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