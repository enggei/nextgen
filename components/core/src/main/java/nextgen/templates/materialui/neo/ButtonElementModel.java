package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ButtonElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "717e6a3b-51cd-470d-9cc3-de2e414f6482";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ButtonElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ButtonElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ButtonElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ButtonElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ButtonElementModel that = (ButtonElementModel) o;
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

	public ButtonElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ButtonElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ButtonElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ButtonElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ButtonElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ButtonElementModel removeClassName() {
		return removeArgument("className");
	}

	public ButtonElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public ButtonElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public ButtonElementModel removeColor() {
		return removeArgument("color");
	}

	public ButtonElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ButtonElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ButtonElementModel removeComponent() {
		return removeArgument("component");
	}

	public ButtonElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ButtonElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ButtonElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ButtonElementModel setDisableElevation(String value) {
		return setDisableElevation(db.newSTValue(value));
	}

	public ButtonElementModel setDisableElevation(STValue value) {
		return set(value, "disableElevation");
	}

	public STValue getDisableElevation() {
		return get("disableElevation");
	}

	public STArgument getDisableElevationArgument() {
		return getArgument("disableElevation");
	}

	public ButtonElementModel removeDisableElevation() {
		return removeArgument("disableElevation");
	}

	public ButtonElementModel setDisableFocusRipple(String value) {
		return setDisableFocusRipple(db.newSTValue(value));
	}

	public ButtonElementModel setDisableFocusRipple(STValue value) {
		return set(value, "disableFocusRipple");
	}

	public STValue getDisableFocusRipple() {
		return get("disableFocusRipple");
	}

	public STArgument getDisableFocusRippleArgument() {
		return getArgument("disableFocusRipple");
	}

	public ButtonElementModel removeDisableFocusRipple() {
		return removeArgument("disableFocusRipple");
	}

	public ButtonElementModel setDisableRipple(String value) {
		return setDisableRipple(db.newSTValue(value));
	}

	public ButtonElementModel setDisableRipple(STValue value) {
		return set(value, "disableRipple");
	}

	public STValue getDisableRipple() {
		return get("disableRipple");
	}

	public STArgument getDisableRippleArgument() {
		return getArgument("disableRipple");
	}

	public ButtonElementModel removeDisableRipple() {
		return removeArgument("disableRipple");
	}

	public ButtonElementModel setEndIcon(String value) {
		return setEndIcon(db.newSTValue(value));
	}

	public ButtonElementModel setEndIcon(STValue value) {
		return set(value, "endIcon");
	}

	public STValue getEndIcon() {
		return get("endIcon");
	}

	public STArgument getEndIconArgument() {
		return getArgument("endIcon");
	}

	public ButtonElementModel removeEndIcon() {
		return removeArgument("endIcon");
	}

	public ButtonElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public ButtonElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public ButtonElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public ButtonElementModel setHref(String value) {
		return setHref(db.newSTValue(value));
	}

	public ButtonElementModel setHref(STValue value) {
		return set(value, "href");
	}

	public STValue getHref() {
		return get("href");
	}

	public STArgument getHrefArgument() {
		return getArgument("href");
	}

	public ButtonElementModel removeHref() {
		return removeArgument("href");
	}

	public ButtonElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ButtonElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ButtonElementModel removeId() {
		return removeArgument("id");
	}

	public ButtonElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ButtonElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ButtonElementModel removeKey() {
		return removeArgument("key");
	}

	public ButtonElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public ButtonElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public ButtonElementModel removeSize() {
		return removeArgument("size");
	}

	public ButtonElementModel setStartIcon(String value) {
		return setStartIcon(db.newSTValue(value));
	}

	public ButtonElementModel setStartIcon(STValue value) {
		return set(value, "startIcon");
	}

	public STValue getStartIcon() {
		return get("startIcon");
	}

	public STArgument getStartIconArgument() {
		return getArgument("startIcon");
	}

	public ButtonElementModel removeStartIcon() {
		return removeArgument("startIcon");
	}

	public ButtonElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ButtonElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ButtonElementModel removeStyle() {
		return removeArgument("style");
	}

	public ButtonElementModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public ButtonElementModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public ButtonElementModel removeType() {
		return removeArgument("type");
	}

	public ButtonElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public ButtonElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public ButtonElementModel removeVariant() {
		return removeArgument("variant");
	}

	public ButtonElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ButtonElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ButtonElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ButtonElementModel addAttribute(ButtonElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ButtonElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ButtonElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ButtonElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ButtonElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ButtonElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ButtonElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ButtonElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ButtonElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ButtonElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ButtonElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ButtonElementModel set(STValue value, String name) {
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

	private ButtonElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ButtonElementModel add(STValue value, String name) {
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