package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FormControlElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "72664cd7-76dd-4284-bd47-0b061bb642de";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public FormControlElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public FormControlElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public FormControlElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public FormControlElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormControlElementModel that = (FormControlElementModel) o;
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

	public FormControlElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public FormControlElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public FormControlElementModel removeClasses() {
		return removeArgument("classes");
	}

	public FormControlElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public FormControlElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public FormControlElementModel removeClassName() {
		return removeArgument("className");
	}

	public FormControlElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public FormControlElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public FormControlElementModel removeColor() {
		return removeArgument("color");
	}

	public FormControlElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public FormControlElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public FormControlElementModel removeComponent() {
		return removeArgument("component");
	}

	public FormControlElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public FormControlElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public FormControlElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public FormControlElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public FormControlElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public FormControlElementModel removeError() {
		return removeArgument("error");
	}

	public FormControlElementModel setFocused(String value) {
		return setFocused(db.newSTValue(value));
	}

	public FormControlElementModel setFocused(STValue value) {
		return set(value, "focused");
	}

	public STValue getFocused() {
		return get("focused");
	}

	public STArgument getFocusedArgument() {
		return getArgument("focused");
	}

	public FormControlElementModel removeFocused() {
		return removeArgument("focused");
	}

	public FormControlElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public FormControlElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public FormControlElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public FormControlElementModel setHiddenLabel(String value) {
		return setHiddenLabel(db.newSTValue(value));
	}

	public FormControlElementModel setHiddenLabel(STValue value) {
		return set(value, "hiddenLabel");
	}

	public STValue getHiddenLabel() {
		return get("hiddenLabel");
	}

	public STArgument getHiddenLabelArgument() {
		return getArgument("hiddenLabel");
	}

	public FormControlElementModel removeHiddenLabel() {
		return removeArgument("hiddenLabel");
	}

	public FormControlElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public FormControlElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public FormControlElementModel removeId() {
		return removeArgument("id");
	}

	public FormControlElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public FormControlElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public FormControlElementModel removeKey() {
		return removeArgument("key");
	}

	public FormControlElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public FormControlElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public FormControlElementModel removeMargin() {
		return removeArgument("margin");
	}

	public FormControlElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public FormControlElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public FormControlElementModel removeRequired() {
		return removeArgument("required");
	}

	public FormControlElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public FormControlElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public FormControlElementModel removeSize() {
		return removeArgument("size");
	}

	public FormControlElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public FormControlElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public FormControlElementModel removeStyle() {
		return removeArgument("style");
	}

	public FormControlElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public FormControlElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public FormControlElementModel removeVariant() {
		return removeArgument("variant");
	}

	public FormControlElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public FormControlElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public FormControlElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public FormControlElementModel addAttribute(FormControlElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public FormControlElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<FormControlElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new FormControlElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class FormControlElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public FormControlElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public FormControlElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public FormControlElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public FormControlElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public FormControlElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private FormControlElementModel_Attribute setKVValue(String name, STValue value) {

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

	private FormControlElementModel set(STValue value, String name) {
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

	private FormControlElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private FormControlElementModel add(STValue value, String name) {
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