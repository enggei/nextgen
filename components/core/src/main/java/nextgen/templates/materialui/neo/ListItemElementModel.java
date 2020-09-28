package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ListItemElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "cb7eabfe-c082-4f17-82a6-f210b07cc1c3";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ListItemElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ListItemElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ListItemElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ListItemElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListItemElementModel that = (ListItemElementModel) o;
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

	public ListItemElementModel setAlignItems(String value) {
		return setAlignItems(db.newSTValue(value));
	}

	public ListItemElementModel setAlignItems(STValue value) {
		return set(value, "alignItems");
	}

	public STValue getAlignItems() {
		return get("alignItems");
	}

	public STArgument getAlignItemsArgument() {
		return getArgument("alignItems");
	}

	public ListItemElementModel removeAlignItems() {
		return removeArgument("alignItems");
	}

	public ListItemElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public ListItemElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public ListItemElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public ListItemElementModel setButton(String value) {
		return setButton(db.newSTValue(value));
	}

	public ListItemElementModel setButton(STValue value) {
		return set(value, "button");
	}

	public STValue getButton() {
		return get("button");
	}

	public STArgument getButtonArgument() {
		return getArgument("button");
	}

	public ListItemElementModel removeButton() {
		return removeArgument("button");
	}

	public ListItemElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ListItemElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ListItemElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ListItemElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ListItemElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ListItemElementModel removeClassName() {
		return removeArgument("className");
	}

	public ListItemElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ListItemElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ListItemElementModel removeComponent() {
		return removeArgument("component");
	}

	public ListItemElementModel setContainerComponent(String value) {
		return setContainerComponent(db.newSTValue(value));
	}

	public ListItemElementModel setContainerComponent(STValue value) {
		return set(value, "ContainerComponent");
	}

	public STValue getContainerComponent() {
		return get("ContainerComponent");
	}

	public STArgument getContainerComponentArgument() {
		return getArgument("ContainerComponent");
	}

	public ListItemElementModel removeContainerComponent() {
		return removeArgument("ContainerComponent");
	}

	public ListItemElementModel setContainerProps(String value) {
		return setContainerProps(db.newSTValue(value));
	}

	public ListItemElementModel setContainerProps(STValue value) {
		return set(value, "ContainerProps");
	}

	public STValue getContainerProps() {
		return get("ContainerProps");
	}

	public STArgument getContainerPropsArgument() {
		return getArgument("ContainerProps");
	}

	public ListItemElementModel removeContainerProps() {
		return removeArgument("ContainerProps");
	}

	public ListItemElementModel setDense(String value) {
		return setDense(db.newSTValue(value));
	}

	public ListItemElementModel setDense(STValue value) {
		return set(value, "dense");
	}

	public STValue getDense() {
		return get("dense");
	}

	public STArgument getDenseArgument() {
		return getArgument("dense");
	}

	public ListItemElementModel removeDense() {
		return removeArgument("dense");
	}

	public ListItemElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ListItemElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ListItemElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ListItemElementModel setDisableGutters(String value) {
		return setDisableGutters(db.newSTValue(value));
	}

	public ListItemElementModel setDisableGutters(STValue value) {
		return set(value, "disableGutters");
	}

	public STValue getDisableGutters() {
		return get("disableGutters");
	}

	public STArgument getDisableGuttersArgument() {
		return getArgument("disableGutters");
	}

	public ListItemElementModel removeDisableGutters() {
		return removeArgument("disableGutters");
	}

	public ListItemElementModel setDivider(String value) {
		return setDivider(db.newSTValue(value));
	}

	public ListItemElementModel setDivider(STValue value) {
		return set(value, "divider");
	}

	public STValue getDivider() {
		return get("divider");
	}

	public STArgument getDividerArgument() {
		return getArgument("divider");
	}

	public ListItemElementModel removeDivider() {
		return removeArgument("divider");
	}

	public ListItemElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ListItemElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ListItemElementModel removeId() {
		return removeArgument("id");
	}

	public ListItemElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ListItemElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ListItemElementModel removeKey() {
		return removeArgument("key");
	}

	public ListItemElementModel setSelected(String value) {
		return setSelected(db.newSTValue(value));
	}

	public ListItemElementModel setSelected(STValue value) {
		return set(value, "selected");
	}

	public STValue getSelected() {
		return get("selected");
	}

	public STArgument getSelectedArgument() {
		return getArgument("selected");
	}

	public ListItemElementModel removeSelected() {
		return removeArgument("selected");
	}

	public ListItemElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ListItemElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ListItemElementModel removeStyle() {
		return removeArgument("style");
	}

	public ListItemElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ListItemElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ListItemElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ListItemElementModel addAttribute(ListItemElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ListItemElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ListItemElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ListItemElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ListItemElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ListItemElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ListItemElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ListItemElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ListItemElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ListItemElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ListItemElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ListItemElementModel set(STValue value, String name) {
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

	private ListItemElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ListItemElementModel add(STValue value, String name) {
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