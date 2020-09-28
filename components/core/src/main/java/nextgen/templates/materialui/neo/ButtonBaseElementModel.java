package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ButtonBaseElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8287c321-c54b-42ea-9a48-25ddd8ffd9e6";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ButtonBaseElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ButtonBaseElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ButtonBaseElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ButtonBaseElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ButtonBaseElementModel that = (ButtonBaseElementModel) o;
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

	public ButtonBaseElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public ButtonBaseElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public ButtonBaseElementModel removeAction() {
		return removeArgument("action");
	}

	public ButtonBaseElementModel setCenterRipple(String value) {
		return setCenterRipple(db.newSTValue(value));
	}

	public ButtonBaseElementModel setCenterRipple(STValue value) {
		return set(value, "centerRipple");
	}

	public STValue getCenterRipple() {
		return get("centerRipple");
	}

	public STArgument getCenterRippleArgument() {
		return getArgument("centerRipple");
	}

	public ButtonBaseElementModel removeCenterRipple() {
		return removeArgument("centerRipple");
	}

	public ButtonBaseElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ButtonBaseElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ButtonBaseElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ButtonBaseElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ButtonBaseElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ButtonBaseElementModel removeClassName() {
		return removeArgument("className");
	}

	public ButtonBaseElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ButtonBaseElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ButtonBaseElementModel removeComponent() {
		return removeArgument("component");
	}

	public ButtonBaseElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ButtonBaseElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ButtonBaseElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ButtonBaseElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public ButtonBaseElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public ButtonBaseElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public ButtonBaseElementModel setDisableTouchRipple(String value) {
		return setDisableTouchRipple(db.newSTValue(value));
	}

	public ButtonBaseElementModel setDisableTouchRipple(STValue value) {
		return set(value, "disableTouchRipple");
	}

	public STValue getDisableTouchRipple() {
		return get("disableTouchRipple");
	}

	public STArgument getDisableTouchRippleArgument() {
		return getArgument("disableTouchRipple");
	}

	public ButtonBaseElementModel removeDisableTouchRipple() {
		return removeArgument("disableTouchRipple");
	}

	public ButtonBaseElementModel setFocusRipple(String value) {
		return setFocusRipple(db.newSTValue(value));
	}

	public ButtonBaseElementModel setFocusRipple(STValue value) {
		return set(value, "focusRipple");
	}

	public STValue getFocusRipple() {
		return get("focusRipple");
	}

	public STArgument getFocusRippleArgument() {
		return getArgument("focusRipple");
	}

	public ButtonBaseElementModel removeFocusRipple() {
		return removeArgument("focusRipple");
	}

	public ButtonBaseElementModel setFocusVisibleClassName(String value) {
		return setFocusVisibleClassName(db.newSTValue(value));
	}

	public ButtonBaseElementModel setFocusVisibleClassName(STValue value) {
		return set(value, "focusVisibleClassName");
	}

	public STValue getFocusVisibleClassName() {
		return get("focusVisibleClassName");
	}

	public STArgument getFocusVisibleClassNameArgument() {
		return getArgument("focusVisibleClassName");
	}

	public ButtonBaseElementModel removeFocusVisibleClassName() {
		return removeArgument("focusVisibleClassName");
	}

	public ButtonBaseElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ButtonBaseElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ButtonBaseElementModel removeId() {
		return removeArgument("id");
	}

	public ButtonBaseElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ButtonBaseElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ButtonBaseElementModel removeKey() {
		return removeArgument("key");
	}

	public ButtonBaseElementModel setOnFocusVisible(String value) {
		return setOnFocusVisible(db.newSTValue(value));
	}

	public ButtonBaseElementModel setOnFocusVisible(STValue value) {
		return set(value, "onFocusVisible");
	}

	public STValue getOnFocusVisible() {
		return get("onFocusVisible");
	}

	public STArgument getOnFocusVisibleArgument() {
		return getArgument("onFocusVisible");
	}

	public ButtonBaseElementModel removeOnFocusVisible() {
		return removeArgument("onFocusVisible");
	}

	public ButtonBaseElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ButtonBaseElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ButtonBaseElementModel removeStyle() {
		return removeArgument("style");
	}

	public ButtonBaseElementModel setTouchRippleProps(String value) {
		return setTouchRippleProps(db.newSTValue(value));
	}

	public ButtonBaseElementModel setTouchRippleProps(STValue value) {
		return set(value, "TouchRippleProps");
	}

	public STValue getTouchRippleProps() {
		return get("TouchRippleProps");
	}

	public STArgument getTouchRipplePropsArgument() {
		return getArgument("TouchRippleProps");
	}

	public ButtonBaseElementModel removeTouchRippleProps() {
		return removeArgument("TouchRippleProps");
	}

	public ButtonBaseElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ButtonBaseElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ButtonBaseElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ButtonBaseElementModel addAttribute(ButtonBaseElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ButtonBaseElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ButtonBaseElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ButtonBaseElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ButtonBaseElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ButtonBaseElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ButtonBaseElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ButtonBaseElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ButtonBaseElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ButtonBaseElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ButtonBaseElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ButtonBaseElementModel set(STValue value, String name) {
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

	private ButtonBaseElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ButtonBaseElementModel add(STValue value, String name) {
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