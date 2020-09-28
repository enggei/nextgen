package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class BottomNavigationActionElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "aff4df3d-599a-4d98-a3b4-205c9fc9aa54";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public BottomNavigationActionElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public BottomNavigationActionElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public BottomNavigationActionElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public BottomNavigationActionElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BottomNavigationActionElementModel that = (BottomNavigationActionElementModel) o;
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

	public BottomNavigationActionElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public BottomNavigationActionElementModel removeClasses() {
		return removeArgument("classes");
	}

	public BottomNavigationActionElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public BottomNavigationActionElementModel removeClassName() {
		return removeArgument("className");
	}

	public BottomNavigationActionElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public BottomNavigationActionElementModel removeIcon() {
		return removeArgument("icon");
	}

	public BottomNavigationActionElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public BottomNavigationActionElementModel removeId() {
		return removeArgument("id");
	}

	public BottomNavigationActionElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public BottomNavigationActionElementModel removeKey() {
		return removeArgument("key");
	}

	public BottomNavigationActionElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public BottomNavigationActionElementModel removeLabel() {
		return removeArgument("label");
	}

	public BottomNavigationActionElementModel setShowLabel(String value) {
		return setShowLabel(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setShowLabel(STValue value) {
		return set(value, "showLabel");
	}

	public STValue getShowLabel() {
		return get("showLabel");
	}

	public STArgument getShowLabelArgument() {
		return getArgument("showLabel");
	}

	public BottomNavigationActionElementModel removeShowLabel() {
		return removeArgument("showLabel");
	}

	public BottomNavigationActionElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public BottomNavigationActionElementModel removeStyle() {
		return removeArgument("style");
	}

	public BottomNavigationActionElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public BottomNavigationActionElementModel removeValue() {
		return removeArgument("value");
	}

	public BottomNavigationActionElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public BottomNavigationActionElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public BottomNavigationActionElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public BottomNavigationActionElementModel addAttribute(BottomNavigationActionElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public BottomNavigationActionElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<BottomNavigationActionElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new BottomNavigationActionElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class BottomNavigationActionElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public BottomNavigationActionElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public BottomNavigationActionElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public BottomNavigationActionElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public BottomNavigationActionElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public BottomNavigationActionElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private BottomNavigationActionElementModel_Attribute setKVValue(String name, STValue value) {

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

	private BottomNavigationActionElementModel set(STValue value, String name) {
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

	private BottomNavigationActionElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private BottomNavigationActionElementModel add(STValue value, String name) {
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