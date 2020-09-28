package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ToggleButtonGroupElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "6211af5e-12c7-4928-98e0-26735dc04ce1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ToggleButtonGroupElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ToggleButtonGroupElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ToggleButtonGroupElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ToggleButtonGroupElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToggleButtonGroupElementModel that = (ToggleButtonGroupElementModel) o;
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

	public ToggleButtonGroupElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ToggleButtonGroupElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ToggleButtonGroupElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ToggleButtonGroupElementModel removeClassName() {
		return removeArgument("className");
	}

	public ToggleButtonGroupElementModel setExclusive(String value) {
		return setExclusive(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setExclusive(STValue value) {
		return set(value, "exclusive");
	}

	public STValue getExclusive() {
		return get("exclusive");
	}

	public STArgument getExclusiveArgument() {
		return getArgument("exclusive");
	}

	public ToggleButtonGroupElementModel removeExclusive() {
		return removeArgument("exclusive");
	}

	public ToggleButtonGroupElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ToggleButtonGroupElementModel removeId() {
		return removeArgument("id");
	}

	public ToggleButtonGroupElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ToggleButtonGroupElementModel removeKey() {
		return removeArgument("key");
	}

	public ToggleButtonGroupElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public ToggleButtonGroupElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public ToggleButtonGroupElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public ToggleButtonGroupElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public ToggleButtonGroupElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public ToggleButtonGroupElementModel removeSize() {
		return removeArgument("size");
	}

	public ToggleButtonGroupElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ToggleButtonGroupElementModel removeStyle() {
		return removeArgument("style");
	}

	public ToggleButtonGroupElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public ToggleButtonGroupElementModel removeValue() {
		return removeArgument("value");
	}

	public ToggleButtonGroupElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ToggleButtonGroupElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ToggleButtonGroupElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ToggleButtonGroupElementModel addAttribute(ToggleButtonGroupElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ToggleButtonGroupElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ToggleButtonGroupElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ToggleButtonGroupElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ToggleButtonGroupElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ToggleButtonGroupElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ToggleButtonGroupElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ToggleButtonGroupElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ToggleButtonGroupElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ToggleButtonGroupElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ToggleButtonGroupElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ToggleButtonGroupElementModel set(STValue value, String name) {
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

	private ToggleButtonGroupElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ToggleButtonGroupElementModel add(STValue value, String name) {
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