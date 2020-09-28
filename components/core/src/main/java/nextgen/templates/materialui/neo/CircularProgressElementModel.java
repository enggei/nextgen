package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CircularProgressElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "c8492237-d66c-40a4-be74-0f92ba5d9ded";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CircularProgressElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CircularProgressElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CircularProgressElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public CircularProgressElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CircularProgressElementModel that = (CircularProgressElementModel) o;
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

	public CircularProgressElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public CircularProgressElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public CircularProgressElementModel removeClasses() {
		return removeArgument("classes");
	}

	public CircularProgressElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public CircularProgressElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public CircularProgressElementModel removeClassName() {
		return removeArgument("className");
	}

	public CircularProgressElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public CircularProgressElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public CircularProgressElementModel removeColor() {
		return removeArgument("color");
	}

	public CircularProgressElementModel setDisableShrink(String value) {
		return setDisableShrink(db.newSTValue(value));
	}

	public CircularProgressElementModel setDisableShrink(STValue value) {
		return set(value, "disableShrink");
	}

	public STValue getDisableShrink() {
		return get("disableShrink");
	}

	public STArgument getDisableShrinkArgument() {
		return getArgument("disableShrink");
	}

	public CircularProgressElementModel removeDisableShrink() {
		return removeArgument("disableShrink");
	}

	public CircularProgressElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public CircularProgressElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public CircularProgressElementModel removeId() {
		return removeArgument("id");
	}

	public CircularProgressElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public CircularProgressElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public CircularProgressElementModel removeKey() {
		return removeArgument("key");
	}

	public CircularProgressElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public CircularProgressElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public CircularProgressElementModel removeSize() {
		return removeArgument("size");
	}

	public CircularProgressElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public CircularProgressElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public CircularProgressElementModel removeStyle() {
		return removeArgument("style");
	}

	public CircularProgressElementModel setThickness(String value) {
		return setThickness(db.newSTValue(value));
	}

	public CircularProgressElementModel setThickness(STValue value) {
		return set(value, "thickness");
	}

	public STValue getThickness() {
		return get("thickness");
	}

	public STArgument getThicknessArgument() {
		return getArgument("thickness");
	}

	public CircularProgressElementModel removeThickness() {
		return removeArgument("thickness");
	}

	public CircularProgressElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public CircularProgressElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public CircularProgressElementModel removeValue() {
		return removeArgument("value");
	}

	public CircularProgressElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public CircularProgressElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public CircularProgressElementModel removeVariant() {
		return removeArgument("variant");
	}


	public CircularProgressElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public CircularProgressElementModel addAttribute(CircularProgressElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public CircularProgressElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CircularProgressElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CircularProgressElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CircularProgressElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public CircularProgressElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CircularProgressElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CircularProgressElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public CircularProgressElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public CircularProgressElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private CircularProgressElementModel_Attribute setKVValue(String name, STValue value) {

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

	private CircularProgressElementModel set(STValue value, String name) {
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

	private CircularProgressElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private CircularProgressElementModel add(STValue value, String name) {
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