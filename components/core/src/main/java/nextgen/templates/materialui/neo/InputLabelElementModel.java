package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class InputLabelElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "6753f423-0d3c-4386-9acf-62a3aafb1226";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public InputLabelElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public InputLabelElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public InputLabelElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public InputLabelElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InputLabelElementModel that = (InputLabelElementModel) o;
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

	public InputLabelElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public InputLabelElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public InputLabelElementModel removeClasses() {
		return removeArgument("classes");
	}

	public InputLabelElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public InputLabelElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public InputLabelElementModel removeClassName() {
		return removeArgument("className");
	}

	public InputLabelElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public InputLabelElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public InputLabelElementModel removeColor() {
		return removeArgument("color");
	}

	public InputLabelElementModel setDisableAnimation(String value) {
		return setDisableAnimation(db.newSTValue(value));
	}

	public InputLabelElementModel setDisableAnimation(STValue value) {
		return set(value, "disableAnimation");
	}

	public STValue getDisableAnimation() {
		return get("disableAnimation");
	}

	public STArgument getDisableAnimationArgument() {
		return getArgument("disableAnimation");
	}

	public InputLabelElementModel removeDisableAnimation() {
		return removeArgument("disableAnimation");
	}

	public InputLabelElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public InputLabelElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public InputLabelElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public InputLabelElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public InputLabelElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public InputLabelElementModel removeError() {
		return removeArgument("error");
	}

	public InputLabelElementModel setFocused(String value) {
		return setFocused(db.newSTValue(value));
	}

	public InputLabelElementModel setFocused(STValue value) {
		return set(value, "focused");
	}

	public STValue getFocused() {
		return get("focused");
	}

	public STArgument getFocusedArgument() {
		return getArgument("focused");
	}

	public InputLabelElementModel removeFocused() {
		return removeArgument("focused");
	}

	public InputLabelElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public InputLabelElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public InputLabelElementModel removeId() {
		return removeArgument("id");
	}

	public InputLabelElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public InputLabelElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public InputLabelElementModel removeKey() {
		return removeArgument("key");
	}

	public InputLabelElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public InputLabelElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public InputLabelElementModel removeMargin() {
		return removeArgument("margin");
	}

	public InputLabelElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public InputLabelElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public InputLabelElementModel removeRequired() {
		return removeArgument("required");
	}

	public InputLabelElementModel setShrink(String value) {
		return setShrink(db.newSTValue(value));
	}

	public InputLabelElementModel setShrink(STValue value) {
		return set(value, "shrink");
	}

	public STValue getShrink() {
		return get("shrink");
	}

	public STArgument getShrinkArgument() {
		return getArgument("shrink");
	}

	public InputLabelElementModel removeShrink() {
		return removeArgument("shrink");
	}

	public InputLabelElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public InputLabelElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public InputLabelElementModel removeStyle() {
		return removeArgument("style");
	}

	public InputLabelElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public InputLabelElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public InputLabelElementModel removeVariant() {
		return removeArgument("variant");
	}

	public InputLabelElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public InputLabelElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public InputLabelElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public InputLabelElementModel addAttribute(InputLabelElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public InputLabelElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<InputLabelElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new InputLabelElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class InputLabelElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public InputLabelElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public InputLabelElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public InputLabelElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public InputLabelElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public InputLabelElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private InputLabelElementModel_Attribute setKVValue(String name, STValue value) {

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

	private InputLabelElementModel set(STValue value, String name) {
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

	private InputLabelElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private InputLabelElementModel add(STValue value, String name) {
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