package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MenuItemElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "a57f8c47-3d02-428e-8125-a915f17730fc";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public MenuItemElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public MenuItemElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public MenuItemElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public MenuItemElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MenuItemElementModel that = (MenuItemElementModel) o;
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

	public MenuItemElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public MenuItemElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public MenuItemElementModel removeClasses() {
		return removeArgument("classes");
	}

	public MenuItemElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public MenuItemElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public MenuItemElementModel removeClassName() {
		return removeArgument("className");
	}

	public MenuItemElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public MenuItemElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public MenuItemElementModel removeComponent() {
		return removeArgument("component");
	}

	public MenuItemElementModel setDense(String value) {
		return setDense(db.newSTValue(value));
	}

	public MenuItemElementModel setDense(STValue value) {
		return set(value, "dense");
	}

	public STValue getDense() {
		return get("dense");
	}

	public STArgument getDenseArgument() {
		return getArgument("dense");
	}

	public MenuItemElementModel removeDense() {
		return removeArgument("dense");
	}

	public MenuItemElementModel setDisableGutters(String value) {
		return setDisableGutters(db.newSTValue(value));
	}

	public MenuItemElementModel setDisableGutters(STValue value) {
		return set(value, "disableGutters");
	}

	public STValue getDisableGutters() {
		return get("disableGutters");
	}

	public STArgument getDisableGuttersArgument() {
		return getArgument("disableGutters");
	}

	public MenuItemElementModel removeDisableGutters() {
		return removeArgument("disableGutters");
	}

	public MenuItemElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public MenuItemElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public MenuItemElementModel removeId() {
		return removeArgument("id");
	}

	public MenuItemElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public MenuItemElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public MenuItemElementModel removeKey() {
		return removeArgument("key");
	}

	public MenuItemElementModel setListItemClasses(String value) {
		return setListItemClasses(db.newSTValue(value));
	}

	public MenuItemElementModel setListItemClasses(STValue value) {
		return set(value, "ListItemClasses");
	}

	public STValue getListItemClasses() {
		return get("ListItemClasses");
	}

	public STArgument getListItemClassesArgument() {
		return getArgument("ListItemClasses");
	}

	public MenuItemElementModel removeListItemClasses() {
		return removeArgument("ListItemClasses");
	}

	public MenuItemElementModel setOnClick(String value) {
		return setOnClick(db.newSTValue(value));
	}

	public MenuItemElementModel setOnClick(STValue value) {
		return set(value, "onClick");
	}

	public STValue getOnClick() {
		return get("onClick");
	}

	public STArgument getOnClickArgument() {
		return getArgument("onClick");
	}

	public MenuItemElementModel removeOnClick() {
		return removeArgument("onClick");
	}

	public MenuItemElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public MenuItemElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public MenuItemElementModel removeStyle() {
		return removeArgument("style");
	}

	public MenuItemElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public MenuItemElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public MenuItemElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public MenuItemElementModel addAttribute(MenuItemElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public MenuItemElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MenuItemElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MenuItemElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MenuItemElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public MenuItemElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MenuItemElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MenuItemElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MenuItemElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public MenuItemElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private MenuItemElementModel_Attribute setKVValue(String name, STValue value) {

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

	private MenuItemElementModel set(STValue value, String name) {
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

	private MenuItemElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private MenuItemElementModel add(STValue value, String name) {
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