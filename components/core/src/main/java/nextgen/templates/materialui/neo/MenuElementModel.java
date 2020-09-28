package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MenuElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "3105659d-e57d-4d76-ba7a-0374920e139c";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public MenuElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public MenuElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public MenuElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public MenuElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MenuElementModel that = (MenuElementModel) o;
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

	public MenuElementModel setAnchorEl(String value) {
		return setAnchorEl(db.newSTValue(value));
	}

	public MenuElementModel setAnchorEl(STValue value) {
		return set(value, "anchorEl");
	}

	public STValue getAnchorEl() {
		return get("anchorEl");
	}

	public STArgument getAnchorElArgument() {
		return getArgument("anchorEl");
	}

	public MenuElementModel removeAnchorEl() {
		return removeArgument("anchorEl");
	}

	public MenuElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public MenuElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public MenuElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public MenuElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public MenuElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public MenuElementModel removeClasses() {
		return removeArgument("classes");
	}

	public MenuElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public MenuElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public MenuElementModel removeClassName() {
		return removeArgument("className");
	}

	public MenuElementModel setDisableAutoFocusItem(String value) {
		return setDisableAutoFocusItem(db.newSTValue(value));
	}

	public MenuElementModel setDisableAutoFocusItem(STValue value) {
		return set(value, "disableAutoFocusItem");
	}

	public STValue getDisableAutoFocusItem() {
		return get("disableAutoFocusItem");
	}

	public STArgument getDisableAutoFocusItemArgument() {
		return getArgument("disableAutoFocusItem");
	}

	public MenuElementModel removeDisableAutoFocusItem() {
		return removeArgument("disableAutoFocusItem");
	}

	public MenuElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public MenuElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public MenuElementModel removeId() {
		return removeArgument("id");
	}

	public MenuElementModel setKeepMounted(String value) {
		return setKeepMounted(db.newSTValue(value));
	}

	public MenuElementModel setKeepMounted(STValue value) {
		return set(value, "keepMounted");
	}

	public STValue getKeepMounted() {
		return get("keepMounted");
	}

	public STArgument getKeepMountedArgument() {
		return getArgument("keepMounted");
	}

	public MenuElementModel removeKeepMounted() {
		return removeArgument("keepMounted");
	}

	public MenuElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public MenuElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public MenuElementModel removeKey() {
		return removeArgument("key");
	}

	public MenuElementModel setMenuListProps(String value) {
		return setMenuListProps(db.newSTValue(value));
	}

	public MenuElementModel setMenuListProps(STValue value) {
		return set(value, "MenuListProps");
	}

	public STValue getMenuListProps() {
		return get("MenuListProps");
	}

	public STArgument getMenuListPropsArgument() {
		return getArgument("MenuListProps");
	}

	public MenuElementModel removeMenuListProps() {
		return removeArgument("MenuListProps");
	}

	public MenuElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public MenuElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public MenuElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public MenuElementModel setOnEnter(String value) {
		return setOnEnter(db.newSTValue(value));
	}

	public MenuElementModel setOnEnter(STValue value) {
		return set(value, "onEnter");
	}

	public STValue getOnEnter() {
		return get("onEnter");
	}

	public STArgument getOnEnterArgument() {
		return getArgument("onEnter");
	}

	public MenuElementModel removeOnEnter() {
		return removeArgument("onEnter");
	}

	public MenuElementModel setOnEntered(String value) {
		return setOnEntered(db.newSTValue(value));
	}

	public MenuElementModel setOnEntered(STValue value) {
		return set(value, "onEntered");
	}

	public STValue getOnEntered() {
		return get("onEntered");
	}

	public STArgument getOnEnteredArgument() {
		return getArgument("onEntered");
	}

	public MenuElementModel removeOnEntered() {
		return removeArgument("onEntered");
	}

	public MenuElementModel setOnEntering(String value) {
		return setOnEntering(db.newSTValue(value));
	}

	public MenuElementModel setOnEntering(STValue value) {
		return set(value, "onEntering");
	}

	public STValue getOnEntering() {
		return get("onEntering");
	}

	public STArgument getOnEnteringArgument() {
		return getArgument("onEntering");
	}

	public MenuElementModel removeOnEntering() {
		return removeArgument("onEntering");
	}

	public MenuElementModel setOnExit(String value) {
		return setOnExit(db.newSTValue(value));
	}

	public MenuElementModel setOnExit(STValue value) {
		return set(value, "onExit");
	}

	public STValue getOnExit() {
		return get("onExit");
	}

	public STArgument getOnExitArgument() {
		return getArgument("onExit");
	}

	public MenuElementModel removeOnExit() {
		return removeArgument("onExit");
	}

	public MenuElementModel setOnExited(String value) {
		return setOnExited(db.newSTValue(value));
	}

	public MenuElementModel setOnExited(STValue value) {
		return set(value, "onExited");
	}

	public STValue getOnExited() {
		return get("onExited");
	}

	public STArgument getOnExitedArgument() {
		return getArgument("onExited");
	}

	public MenuElementModel removeOnExited() {
		return removeArgument("onExited");
	}

	public MenuElementModel setOnExiting(String value) {
		return setOnExiting(db.newSTValue(value));
	}

	public MenuElementModel setOnExiting(STValue value) {
		return set(value, "onExiting");
	}

	public STValue getOnExiting() {
		return get("onExiting");
	}

	public STArgument getOnExitingArgument() {
		return getArgument("onExiting");
	}

	public MenuElementModel removeOnExiting() {
		return removeArgument("onExiting");
	}

	public MenuElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public MenuElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public MenuElementModel removeOpen() {
		return removeArgument("open");
	}

	public MenuElementModel setPopoverClasses(String value) {
		return setPopoverClasses(db.newSTValue(value));
	}

	public MenuElementModel setPopoverClasses(STValue value) {
		return set(value, "PopoverClasses");
	}

	public STValue getPopoverClasses() {
		return get("PopoverClasses");
	}

	public STArgument getPopoverClassesArgument() {
		return getArgument("PopoverClasses");
	}

	public MenuElementModel removePopoverClasses() {
		return removeArgument("PopoverClasses");
	}

	public MenuElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public MenuElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public MenuElementModel removeStyle() {
		return removeArgument("style");
	}

	public MenuElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public MenuElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public MenuElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public MenuElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public MenuElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public MenuElementModel removeVariant() {
		return removeArgument("variant");
	}

	public MenuElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public MenuElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public MenuElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public MenuElementModel addAttribute(MenuElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public MenuElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MenuElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MenuElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MenuElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public MenuElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MenuElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MenuElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MenuElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public MenuElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private MenuElementModel_Attribute setKVValue(String name, STValue value) {

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

	private MenuElementModel set(STValue value, String name) {
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

	private MenuElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private MenuElementModel add(STValue value, String name) {
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