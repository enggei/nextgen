package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CollapseElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "1c36491e-aef6-4eb6-9a5a-74c5b2625e27";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CollapseElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CollapseElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CollapseElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public CollapseElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CollapseElementModel that = (CollapseElementModel) o;
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

	public CollapseElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public CollapseElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public CollapseElementModel removeClasses() {
		return removeArgument("classes");
	}

	public CollapseElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public CollapseElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public CollapseElementModel removeClassName() {
		return removeArgument("className");
	}

	public CollapseElementModel setCollapsedHeight(String value) {
		return setCollapsedHeight(db.newSTValue(value));
	}

	public CollapseElementModel setCollapsedHeight(STValue value) {
		return set(value, "collapsedHeight");
	}

	public STValue getCollapsedHeight() {
		return get("collapsedHeight");
	}

	public STArgument getCollapsedHeightArgument() {
		return getArgument("collapsedHeight");
	}

	public CollapseElementModel removeCollapsedHeight() {
		return removeArgument("collapsedHeight");
	}

	public CollapseElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public CollapseElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public CollapseElementModel removeComponent() {
		return removeArgument("component");
	}

	public CollapseElementModel setDisableStrictModeCompat(String value) {
		return setDisableStrictModeCompat(db.newSTValue(value));
	}

	public CollapseElementModel setDisableStrictModeCompat(STValue value) {
		return set(value, "disableStrictModeCompat");
	}

	public STValue getDisableStrictModeCompat() {
		return get("disableStrictModeCompat");
	}

	public STArgument getDisableStrictModeCompatArgument() {
		return getArgument("disableStrictModeCompat");
	}

	public CollapseElementModel removeDisableStrictModeCompat() {
		return removeArgument("disableStrictModeCompat");
	}

	public CollapseElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public CollapseElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public CollapseElementModel removeId() {
		return removeArgument("id");
	}

	public CollapseElementModel setIn(String value) {
		return setIn(db.newSTValue(value));
	}

	public CollapseElementModel setIn(STValue value) {
		return set(value, "in");
	}

	public STValue getIn() {
		return get("in");
	}

	public STArgument getInArgument() {
		return getArgument("in");
	}

	public CollapseElementModel removeIn() {
		return removeArgument("in");
	}

	public CollapseElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public CollapseElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public CollapseElementModel removeKey() {
		return removeArgument("key");
	}

	public CollapseElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public CollapseElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public CollapseElementModel removeStyle() {
		return removeArgument("style");
	}

	public CollapseElementModel setTimeout(String value) {
		return setTimeout(db.newSTValue(value));
	}

	public CollapseElementModel setTimeout(STValue value) {
		return set(value, "timeout");
	}

	public STValue getTimeout() {
		return get("timeout");
	}

	public STArgument getTimeoutArgument() {
		return getArgument("timeout");
	}

	public CollapseElementModel removeTimeout() {
		return removeArgument("timeout");
	}

	public CollapseElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public CollapseElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public CollapseElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public CollapseElementModel addAttribute(CollapseElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public CollapseElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CollapseElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CollapseElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CollapseElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public CollapseElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CollapseElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CollapseElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public CollapseElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public CollapseElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private CollapseElementModel_Attribute setKVValue(String name, STValue value) {

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

	private CollapseElementModel set(STValue value, String name) {
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

	private CollapseElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private CollapseElementModel add(STValue value, String name) {
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