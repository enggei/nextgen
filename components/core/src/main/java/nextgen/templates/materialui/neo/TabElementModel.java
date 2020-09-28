package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TabElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "553dca30-b054-4a9d-905b-4c1fd0986bd7";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TabElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TabElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TabElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TabElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TabElementModel that = (TabElementModel) o;
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

	public TabElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TabElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TabElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TabElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TabElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TabElementModel removeClassName() {
		return removeArgument("className");
	}

	public TabElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public TabElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public TabElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public TabElementModel setDisableFocusRipple(String value) {
		return setDisableFocusRipple(db.newSTValue(value));
	}

	public TabElementModel setDisableFocusRipple(STValue value) {
		return set(value, "disableFocusRipple");
	}

	public STValue getDisableFocusRipple() {
		return get("disableFocusRipple");
	}

	public STArgument getDisableFocusRippleArgument() {
		return getArgument("disableFocusRipple");
	}

	public TabElementModel removeDisableFocusRipple() {
		return removeArgument("disableFocusRipple");
	}

	public TabElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public TabElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public TabElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public TabElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public TabElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public TabElementModel removeIcon() {
		return removeArgument("icon");
	}

	public TabElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TabElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TabElementModel removeId() {
		return removeArgument("id");
	}

	public TabElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TabElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TabElementModel removeKey() {
		return removeArgument("key");
	}

	public TabElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public TabElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public TabElementModel removeLabel() {
		return removeArgument("label");
	}

	public TabElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TabElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TabElementModel removeStyle() {
		return removeArgument("style");
	}

	public TabElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public TabElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public TabElementModel removeValue() {
		return removeArgument("value");
	}

	public TabElementModel setWrapped(String value) {
		return setWrapped(db.newSTValue(value));
	}

	public TabElementModel setWrapped(STValue value) {
		return set(value, "wrapped");
	}

	public STValue getWrapped() {
		return get("wrapped");
	}

	public STArgument getWrappedArgument() {
		return getArgument("wrapped");
	}

	public TabElementModel removeWrapped() {
		return removeArgument("wrapped");
	}

	public TabElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TabElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TabElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TabElementModel addAttribute(TabElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TabElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TabElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TabElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TabElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TabElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TabElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TabElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TabElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TabElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TabElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TabElementModel set(STValue value, String name) {
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

	private TabElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TabElementModel add(STValue value, String name) {
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