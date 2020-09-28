package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ButtonGroupElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "9886a31c-84a7-4955-a77f-15d1f1398b53";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ButtonGroupElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ButtonGroupElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ButtonGroupElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ButtonGroupElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ButtonGroupElementModel that = (ButtonGroupElementModel) o;
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

	public ButtonGroupElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ButtonGroupElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ButtonGroupElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ButtonGroupElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ButtonGroupElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ButtonGroupElementModel removeClassName() {
		return removeArgument("className");
	}

	public ButtonGroupElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public ButtonGroupElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public ButtonGroupElementModel removeColor() {
		return removeArgument("color");
	}

	public ButtonGroupElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ButtonGroupElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ButtonGroupElementModel removeComponent() {
		return removeArgument("component");
	}

	public ButtonGroupElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ButtonGroupElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ButtonGroupElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ButtonGroupElementModel setDisableElevation(String value) {
		return setDisableElevation(db.newSTValue(value));
	}

	public ButtonGroupElementModel setDisableElevation(STValue value) {
		return set(value, "disableElevation");
	}

	public STValue getDisableElevation() {
		return get("disableElevation");
	}

	public STArgument getDisableElevationArgument() {
		return getArgument("disableElevation");
	}

	public ButtonGroupElementModel removeDisableElevation() {
		return removeArgument("disableElevation");
	}

	public ButtonGroupElementModel setDisableFocusRipple(String value) {
		return setDisableFocusRipple(db.newSTValue(value));
	}

	public ButtonGroupElementModel setDisableFocusRipple(STValue value) {
		return set(value, "disableFocusRipple");
	}

	public STValue getDisableFocusRipple() {
		return get("disableFocusRipple");
	}

	public STArgument getDisableFocusRippleArgument() {
		return getArgument("disableFocusRipple");
	}

	public ButtonGroupElementModel removeDisableFocusRipple() {
		return removeArgument("disableFocusRipple");
	}

	public ButtonGroupElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public ButtonGroupElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public ButtonGroupElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public ButtonGroupElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public ButtonGroupElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public ButtonGroupElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public ButtonGroupElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ButtonGroupElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ButtonGroupElementModel removeId() {
		return removeArgument("id");
	}

	public ButtonGroupElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ButtonGroupElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ButtonGroupElementModel removeKey() {
		return removeArgument("key");
	}

	public ButtonGroupElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public ButtonGroupElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public ButtonGroupElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public ButtonGroupElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public ButtonGroupElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public ButtonGroupElementModel removeSize() {
		return removeArgument("size");
	}

	public ButtonGroupElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ButtonGroupElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ButtonGroupElementModel removeStyle() {
		return removeArgument("style");
	}

	public ButtonGroupElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public ButtonGroupElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public ButtonGroupElementModel removeVariant() {
		return removeArgument("variant");
	}

	public ButtonGroupElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ButtonGroupElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ButtonGroupElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ButtonGroupElementModel addAttribute(ButtonGroupElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ButtonGroupElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ButtonGroupElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ButtonGroupElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ButtonGroupElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ButtonGroupElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ButtonGroupElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ButtonGroupElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ButtonGroupElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ButtonGroupElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ButtonGroupElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ButtonGroupElementModel set(STValue value, String name) {
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

	private ButtonGroupElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ButtonGroupElementModel add(STValue value, String name) {
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