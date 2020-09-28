package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ListSubheaderElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "b6131062-aaad-4193-b0cd-6e0cffb47da4";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ListSubheaderElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ListSubheaderElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ListSubheaderElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ListSubheaderElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListSubheaderElementModel that = (ListSubheaderElementModel) o;
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

	public ListSubheaderElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ListSubheaderElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ListSubheaderElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ListSubheaderElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ListSubheaderElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ListSubheaderElementModel removeClassName() {
		return removeArgument("className");
	}

	public ListSubheaderElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public ListSubheaderElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public ListSubheaderElementModel removeColor() {
		return removeArgument("color");
	}

	public ListSubheaderElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ListSubheaderElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ListSubheaderElementModel removeComponent() {
		return removeArgument("component");
	}

	public ListSubheaderElementModel setDisableGutters(String value) {
		return setDisableGutters(db.newSTValue(value));
	}

	public ListSubheaderElementModel setDisableGutters(STValue value) {
		return set(value, "disableGutters");
	}

	public STValue getDisableGutters() {
		return get("disableGutters");
	}

	public STArgument getDisableGuttersArgument() {
		return getArgument("disableGutters");
	}

	public ListSubheaderElementModel removeDisableGutters() {
		return removeArgument("disableGutters");
	}

	public ListSubheaderElementModel setDisableSticky(String value) {
		return setDisableSticky(db.newSTValue(value));
	}

	public ListSubheaderElementModel setDisableSticky(STValue value) {
		return set(value, "disableSticky");
	}

	public STValue getDisableSticky() {
		return get("disableSticky");
	}

	public STArgument getDisableStickyArgument() {
		return getArgument("disableSticky");
	}

	public ListSubheaderElementModel removeDisableSticky() {
		return removeArgument("disableSticky");
	}

	public ListSubheaderElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ListSubheaderElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ListSubheaderElementModel removeId() {
		return removeArgument("id");
	}

	public ListSubheaderElementModel setInset(String value) {
		return setInset(db.newSTValue(value));
	}

	public ListSubheaderElementModel setInset(STValue value) {
		return set(value, "inset");
	}

	public STValue getInset() {
		return get("inset");
	}

	public STArgument getInsetArgument() {
		return getArgument("inset");
	}

	public ListSubheaderElementModel removeInset() {
		return removeArgument("inset");
	}

	public ListSubheaderElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ListSubheaderElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ListSubheaderElementModel removeKey() {
		return removeArgument("key");
	}

	public ListSubheaderElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ListSubheaderElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ListSubheaderElementModel removeStyle() {
		return removeArgument("style");
	}

	public ListSubheaderElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ListSubheaderElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ListSubheaderElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ListSubheaderElementModel addAttribute(ListSubheaderElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ListSubheaderElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ListSubheaderElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ListSubheaderElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ListSubheaderElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ListSubheaderElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ListSubheaderElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ListSubheaderElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ListSubheaderElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ListSubheaderElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ListSubheaderElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ListSubheaderElementModel set(STValue value, String name) {
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

	private ListSubheaderElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ListSubheaderElementModel add(STValue value, String name) {
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