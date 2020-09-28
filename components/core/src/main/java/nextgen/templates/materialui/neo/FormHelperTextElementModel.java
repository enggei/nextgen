package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FormHelperTextElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "1014ed82-7af4-460f-bddd-ca20dd9d9e83";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public FormHelperTextElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public FormHelperTextElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public FormHelperTextElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public FormHelperTextElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormHelperTextElementModel that = (FormHelperTextElementModel) o;
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

	public FormHelperTextElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public FormHelperTextElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public FormHelperTextElementModel removeClasses() {
		return removeArgument("classes");
	}

	public FormHelperTextElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public FormHelperTextElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public FormHelperTextElementModel removeClassName() {
		return removeArgument("className");
	}

	public FormHelperTextElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public FormHelperTextElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public FormHelperTextElementModel removeComponent() {
		return removeArgument("component");
	}

	public FormHelperTextElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public FormHelperTextElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public FormHelperTextElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public FormHelperTextElementModel setError(String value) {
		return setError(db.newSTValue(value));
	}

	public FormHelperTextElementModel setError(STValue value) {
		return set(value, "error");
	}

	public STValue getError() {
		return get("error");
	}

	public STArgument getErrorArgument() {
		return getArgument("error");
	}

	public FormHelperTextElementModel removeError() {
		return removeArgument("error");
	}

	public FormHelperTextElementModel setFilled(String value) {
		return setFilled(db.newSTValue(value));
	}

	public FormHelperTextElementModel setFilled(STValue value) {
		return set(value, "filled");
	}

	public STValue getFilled() {
		return get("filled");
	}

	public STArgument getFilledArgument() {
		return getArgument("filled");
	}

	public FormHelperTextElementModel removeFilled() {
		return removeArgument("filled");
	}

	public FormHelperTextElementModel setFocused(String value) {
		return setFocused(db.newSTValue(value));
	}

	public FormHelperTextElementModel setFocused(STValue value) {
		return set(value, "focused");
	}

	public STValue getFocused() {
		return get("focused");
	}

	public STArgument getFocusedArgument() {
		return getArgument("focused");
	}

	public FormHelperTextElementModel removeFocused() {
		return removeArgument("focused");
	}

	public FormHelperTextElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public FormHelperTextElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public FormHelperTextElementModel removeId() {
		return removeArgument("id");
	}

	public FormHelperTextElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public FormHelperTextElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public FormHelperTextElementModel removeKey() {
		return removeArgument("key");
	}

	public FormHelperTextElementModel setMargin(String value) {
		return setMargin(db.newSTValue(value));
	}

	public FormHelperTextElementModel setMargin(STValue value) {
		return set(value, "margin");
	}

	public STValue getMargin() {
		return get("margin");
	}

	public STArgument getMarginArgument() {
		return getArgument("margin");
	}

	public FormHelperTextElementModel removeMargin() {
		return removeArgument("margin");
	}

	public FormHelperTextElementModel setRequired(String value) {
		return setRequired(db.newSTValue(value));
	}

	public FormHelperTextElementModel setRequired(STValue value) {
		return set(value, "required");
	}

	public STValue getRequired() {
		return get("required");
	}

	public STArgument getRequiredArgument() {
		return getArgument("required");
	}

	public FormHelperTextElementModel removeRequired() {
		return removeArgument("required");
	}

	public FormHelperTextElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public FormHelperTextElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public FormHelperTextElementModel removeStyle() {
		return removeArgument("style");
	}

	public FormHelperTextElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public FormHelperTextElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public FormHelperTextElementModel removeVariant() {
		return removeArgument("variant");
	}

	public FormHelperTextElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public FormHelperTextElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public FormHelperTextElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public FormHelperTextElementModel addAttribute(FormHelperTextElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public FormHelperTextElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<FormHelperTextElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new FormHelperTextElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class FormHelperTextElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public FormHelperTextElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public FormHelperTextElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public FormHelperTextElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public FormHelperTextElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public FormHelperTextElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private FormHelperTextElementModel_Attribute setKVValue(String name, STValue value) {

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

	private FormHelperTextElementModel set(STValue value, String name) {
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

	private FormHelperTextElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private FormHelperTextElementModel add(STValue value, String name) {
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