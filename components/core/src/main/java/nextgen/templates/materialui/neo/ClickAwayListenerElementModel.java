package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ClickAwayListenerElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "cbe75db5-05d0-4403-897e-ae8370fc36f0";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ClickAwayListenerElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ClickAwayListenerElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ClickAwayListenerElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ClickAwayListenerElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClickAwayListenerElementModel that = (ClickAwayListenerElementModel) o;
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

	public ClickAwayListenerElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ClickAwayListenerElementModel removeClassName() {
		return removeArgument("className");
	}

	public ClickAwayListenerElementModel setDisableReactTree(String value) {
		return setDisableReactTree(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setDisableReactTree(STValue value) {
		return set(value, "disableReactTree");
	}

	public STValue getDisableReactTree() {
		return get("disableReactTree");
	}

	public STArgument getDisableReactTreeArgument() {
		return getArgument("disableReactTree");
	}

	public ClickAwayListenerElementModel removeDisableReactTree() {
		return removeArgument("disableReactTree");
	}

	public ClickAwayListenerElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ClickAwayListenerElementModel removeId() {
		return removeArgument("id");
	}

	public ClickAwayListenerElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ClickAwayListenerElementModel removeKey() {
		return removeArgument("key");
	}

	public ClickAwayListenerElementModel setMouseEvent(String value) {
		return setMouseEvent(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setMouseEvent(STValue value) {
		return set(value, "mouseEvent");
	}

	public STValue getMouseEvent() {
		return get("mouseEvent");
	}

	public STArgument getMouseEventArgument() {
		return getArgument("mouseEvent");
	}

	public ClickAwayListenerElementModel removeMouseEvent() {
		return removeArgument("mouseEvent");
	}

	public ClickAwayListenerElementModel setOnClickAway(String value) {
		return setOnClickAway(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setOnClickAway(STValue value) {
		return set(value, "onClickAway");
	}

	public STValue getOnClickAway() {
		return get("onClickAway");
	}

	public STArgument getOnClickAwayArgument() {
		return getArgument("onClickAway");
	}

	public ClickAwayListenerElementModel removeOnClickAway() {
		return removeArgument("onClickAway");
	}

	public ClickAwayListenerElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ClickAwayListenerElementModel removeStyle() {
		return removeArgument("style");
	}

	public ClickAwayListenerElementModel setTouchEvent(String value) {
		return setTouchEvent(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel setTouchEvent(STValue value) {
		return set(value, "touchEvent");
	}

	public STValue getTouchEvent() {
		return get("touchEvent");
	}

	public STArgument getTouchEventArgument() {
		return getArgument("touchEvent");
	}

	public ClickAwayListenerElementModel removeTouchEvent() {
		return removeArgument("touchEvent");
	}

	public ClickAwayListenerElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ClickAwayListenerElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ClickAwayListenerElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ClickAwayListenerElementModel addAttribute(ClickAwayListenerElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ClickAwayListenerElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ClickAwayListenerElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ClickAwayListenerElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ClickAwayListenerElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ClickAwayListenerElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ClickAwayListenerElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ClickAwayListenerElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ClickAwayListenerElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ClickAwayListenerElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ClickAwayListenerElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ClickAwayListenerElementModel set(STValue value, String name) {
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

	private ClickAwayListenerElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ClickAwayListenerElementModel add(STValue value, String name) {
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