package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class InputAdornmentElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "aee04641-32ca-40f3-b43e-7e1835c50909";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public InputAdornmentElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public InputAdornmentElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public InputAdornmentElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public InputAdornmentElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InputAdornmentElementModel that = (InputAdornmentElementModel) o;
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

	public InputAdornmentElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public InputAdornmentElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public InputAdornmentElementModel removeClasses() {
		return removeArgument("classes");
	}

	public InputAdornmentElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public InputAdornmentElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public InputAdornmentElementModel removeClassName() {
		return removeArgument("className");
	}

	public InputAdornmentElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public InputAdornmentElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public InputAdornmentElementModel removeComponent() {
		return removeArgument("component");
	}

	public InputAdornmentElementModel setDisablePointerEvents(String value) {
		return setDisablePointerEvents(db.newSTValue(value));
	}

	public InputAdornmentElementModel setDisablePointerEvents(STValue value) {
		return set(value, "disablePointerEvents");
	}

	public STValue getDisablePointerEvents() {
		return get("disablePointerEvents");
	}

	public STArgument getDisablePointerEventsArgument() {
		return getArgument("disablePointerEvents");
	}

	public InputAdornmentElementModel removeDisablePointerEvents() {
		return removeArgument("disablePointerEvents");
	}

	public InputAdornmentElementModel setDisableTypography(String value) {
		return setDisableTypography(db.newSTValue(value));
	}

	public InputAdornmentElementModel setDisableTypography(STValue value) {
		return set(value, "disableTypography");
	}

	public STValue getDisableTypography() {
		return get("disableTypography");
	}

	public STArgument getDisableTypographyArgument() {
		return getArgument("disableTypography");
	}

	public InputAdornmentElementModel removeDisableTypography() {
		return removeArgument("disableTypography");
	}

	public InputAdornmentElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public InputAdornmentElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public InputAdornmentElementModel removeId() {
		return removeArgument("id");
	}

	public InputAdornmentElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public InputAdornmentElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public InputAdornmentElementModel removeKey() {
		return removeArgument("key");
	}

	public InputAdornmentElementModel setPosition(String value) {
		return setPosition(db.newSTValue(value));
	}

	public InputAdornmentElementModel setPosition(STValue value) {
		return set(value, "position");
	}

	public STValue getPosition() {
		return get("position");
	}

	public STArgument getPositionArgument() {
		return getArgument("position");
	}

	public InputAdornmentElementModel removePosition() {
		return removeArgument("position");
	}

	public InputAdornmentElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public InputAdornmentElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public InputAdornmentElementModel removeStyle() {
		return removeArgument("style");
	}

	public InputAdornmentElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public InputAdornmentElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public InputAdornmentElementModel removeVariant() {
		return removeArgument("variant");
	}

	public InputAdornmentElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public InputAdornmentElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public InputAdornmentElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public InputAdornmentElementModel addAttribute(InputAdornmentElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public InputAdornmentElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<InputAdornmentElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new InputAdornmentElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class InputAdornmentElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public InputAdornmentElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public InputAdornmentElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public InputAdornmentElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public InputAdornmentElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public InputAdornmentElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private InputAdornmentElementModel_Attribute setKVValue(String name, STValue value) {

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

	private InputAdornmentElementModel set(STValue value, String name) {
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

	private InputAdornmentElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private InputAdornmentElementModel add(STValue value, String name) {
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