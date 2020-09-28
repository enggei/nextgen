package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DividerElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8a3916e2-24b4-48ec-b3ba-697a06aa1512";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DividerElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DividerElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DividerElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public DividerElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DividerElementModel that = (DividerElementModel) o;
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

	public DividerElementModel setAbsolute(String value) {
		return setAbsolute(db.newSTValue(value));
	}

	public DividerElementModel setAbsolute(STValue value) {
		return set(value, "absolute");
	}

	public STValue getAbsolute() {
		return get("absolute");
	}

	public STArgument getAbsoluteArgument() {
		return getArgument("absolute");
	}

	public DividerElementModel removeAbsolute() {
		return removeArgument("absolute");
	}

	public DividerElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public DividerElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public DividerElementModel removeClasses() {
		return removeArgument("classes");
	}

	public DividerElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public DividerElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public DividerElementModel removeClassName() {
		return removeArgument("className");
	}

	public DividerElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public DividerElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public DividerElementModel removeComponent() {
		return removeArgument("component");
	}

	public DividerElementModel setFlexItem(String value) {
		return setFlexItem(db.newSTValue(value));
	}

	public DividerElementModel setFlexItem(STValue value) {
		return set(value, "flexItem");
	}

	public STValue getFlexItem() {
		return get("flexItem");
	}

	public STArgument getFlexItemArgument() {
		return getArgument("flexItem");
	}

	public DividerElementModel removeFlexItem() {
		return removeArgument("flexItem");
	}

	public DividerElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public DividerElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public DividerElementModel removeId() {
		return removeArgument("id");
	}

	public DividerElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public DividerElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public DividerElementModel removeKey() {
		return removeArgument("key");
	}

	public DividerElementModel setLight(String value) {
		return setLight(db.newSTValue(value));
	}

	public DividerElementModel setLight(STValue value) {
		return set(value, "light");
	}

	public STValue getLight() {
		return get("light");
	}

	public STArgument getLightArgument() {
		return getArgument("light");
	}

	public DividerElementModel removeLight() {
		return removeArgument("light");
	}

	public DividerElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public DividerElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public DividerElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public DividerElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public DividerElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public DividerElementModel removeStyle() {
		return removeArgument("style");
	}

	public DividerElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public DividerElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public DividerElementModel removeVariant() {
		return removeArgument("variant");
	}


	public DividerElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public DividerElementModel addAttribute(DividerElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public DividerElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<DividerElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new DividerElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class DividerElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public DividerElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public DividerElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public DividerElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public DividerElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public DividerElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private DividerElementModel_Attribute setKVValue(String name, STValue value) {

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

	private DividerElementModel set(STValue value, String name) {
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

	private DividerElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private DividerElementModel add(STValue value, String name) {
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