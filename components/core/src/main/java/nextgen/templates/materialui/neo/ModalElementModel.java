package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ModalElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8305c14d-8845-49f5-bba5-3b0ed5f589c7";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ModalElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ModalElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ModalElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ModalElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModalElementModel that = (ModalElementModel) o;
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

	public ModalElementModel setBackdropComponent(String value) {
		return setBackdropComponent(db.newSTValue(value));
	}

	public ModalElementModel setBackdropComponent(STValue value) {
		return set(value, "BackdropComponent");
	}

	public STValue getBackdropComponent() {
		return get("BackdropComponent");
	}

	public STArgument getBackdropComponentArgument() {
		return getArgument("BackdropComponent");
	}

	public ModalElementModel removeBackdropComponent() {
		return removeArgument("BackdropComponent");
	}

	public ModalElementModel setBackdropProps(String value) {
		return setBackdropProps(db.newSTValue(value));
	}

	public ModalElementModel setBackdropProps(STValue value) {
		return set(value, "BackdropProps");
	}

	public STValue getBackdropProps() {
		return get("BackdropProps");
	}

	public STArgument getBackdropPropsArgument() {
		return getArgument("BackdropProps");
	}

	public ModalElementModel removeBackdropProps() {
		return removeArgument("BackdropProps");
	}

	public ModalElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ModalElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ModalElementModel removeClassName() {
		return removeArgument("className");
	}

	public ModalElementModel setCloseAfterTransition(String value) {
		return setCloseAfterTransition(db.newSTValue(value));
	}

	public ModalElementModel setCloseAfterTransition(STValue value) {
		return set(value, "closeAfterTransition");
	}

	public STValue getCloseAfterTransition() {
		return get("closeAfterTransition");
	}

	public STArgument getCloseAfterTransitionArgument() {
		return getArgument("closeAfterTransition");
	}

	public ModalElementModel removeCloseAfterTransition() {
		return removeArgument("closeAfterTransition");
	}

	public ModalElementModel setContainer(String value) {
		return setContainer(db.newSTValue(value));
	}

	public ModalElementModel setContainer(STValue value) {
		return set(value, "container");
	}

	public STValue getContainer() {
		return get("container");
	}

	public STArgument getContainerArgument() {
		return getArgument("container");
	}

	public ModalElementModel removeContainer() {
		return removeArgument("container");
	}

	public ModalElementModel setDisableAutoFocus(String value) {
		return setDisableAutoFocus(db.newSTValue(value));
	}

	public ModalElementModel setDisableAutoFocus(STValue value) {
		return set(value, "disableAutoFocus");
	}

	public STValue getDisableAutoFocus() {
		return get("disableAutoFocus");
	}

	public STArgument getDisableAutoFocusArgument() {
		return getArgument("disableAutoFocus");
	}

	public ModalElementModel removeDisableAutoFocus() {
		return removeArgument("disableAutoFocus");
	}

	public ModalElementModel setDisableBackdropClick(String value) {
		return setDisableBackdropClick(db.newSTValue(value));
	}

	public ModalElementModel setDisableBackdropClick(STValue value) {
		return set(value, "disableBackdropClick");
	}

	public STValue getDisableBackdropClick() {
		return get("disableBackdropClick");
	}

	public STArgument getDisableBackdropClickArgument() {
		return getArgument("disableBackdropClick");
	}

	public ModalElementModel removeDisableBackdropClick() {
		return removeArgument("disableBackdropClick");
	}

	public ModalElementModel setDisableEnforceFocus(String value) {
		return setDisableEnforceFocus(db.newSTValue(value));
	}

	public ModalElementModel setDisableEnforceFocus(STValue value) {
		return set(value, "disableEnforceFocus");
	}

	public STValue getDisableEnforceFocus() {
		return get("disableEnforceFocus");
	}

	public STArgument getDisableEnforceFocusArgument() {
		return getArgument("disableEnforceFocus");
	}

	public ModalElementModel removeDisableEnforceFocus() {
		return removeArgument("disableEnforceFocus");
	}

	public ModalElementModel setDisableEscapeKeyDown(String value) {
		return setDisableEscapeKeyDown(db.newSTValue(value));
	}

	public ModalElementModel setDisableEscapeKeyDown(STValue value) {
		return set(value, "disableEscapeKeyDown");
	}

	public STValue getDisableEscapeKeyDown() {
		return get("disableEscapeKeyDown");
	}

	public STArgument getDisableEscapeKeyDownArgument() {
		return getArgument("disableEscapeKeyDown");
	}

	public ModalElementModel removeDisableEscapeKeyDown() {
		return removeArgument("disableEscapeKeyDown");
	}

	public ModalElementModel setDisablePortal(String value) {
		return setDisablePortal(db.newSTValue(value));
	}

	public ModalElementModel setDisablePortal(STValue value) {
		return set(value, "disablePortal");
	}

	public STValue getDisablePortal() {
		return get("disablePortal");
	}

	public STArgument getDisablePortalArgument() {
		return getArgument("disablePortal");
	}

	public ModalElementModel removeDisablePortal() {
		return removeArgument("disablePortal");
	}

	public ModalElementModel setDisableRestoreFocus(String value) {
		return setDisableRestoreFocus(db.newSTValue(value));
	}

	public ModalElementModel setDisableRestoreFocus(STValue value) {
		return set(value, "disableRestoreFocus");
	}

	public STValue getDisableRestoreFocus() {
		return get("disableRestoreFocus");
	}

	public STArgument getDisableRestoreFocusArgument() {
		return getArgument("disableRestoreFocus");
	}

	public ModalElementModel removeDisableRestoreFocus() {
		return removeArgument("disableRestoreFocus");
	}

	public ModalElementModel setDisableScrollLock(String value) {
		return setDisableScrollLock(db.newSTValue(value));
	}

	public ModalElementModel setDisableScrollLock(STValue value) {
		return set(value, "disableScrollLock");
	}

	public STValue getDisableScrollLock() {
		return get("disableScrollLock");
	}

	public STArgument getDisableScrollLockArgument() {
		return getArgument("disableScrollLock");
	}

	public ModalElementModel removeDisableScrollLock() {
		return removeArgument("disableScrollLock");
	}

	public ModalElementModel setHideBackdrop(String value) {
		return setHideBackdrop(db.newSTValue(value));
	}

	public ModalElementModel setHideBackdrop(STValue value) {
		return set(value, "hideBackdrop");
	}

	public STValue getHideBackdrop() {
		return get("hideBackdrop");
	}

	public STArgument getHideBackdropArgument() {
		return getArgument("hideBackdrop");
	}

	public ModalElementModel removeHideBackdrop() {
		return removeArgument("hideBackdrop");
	}

	public ModalElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ModalElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ModalElementModel removeId() {
		return removeArgument("id");
	}

	public ModalElementModel setKeepMounted(String value) {
		return setKeepMounted(db.newSTValue(value));
	}

	public ModalElementModel setKeepMounted(STValue value) {
		return set(value, "keepMounted");
	}

	public STValue getKeepMounted() {
		return get("keepMounted");
	}

	public STArgument getKeepMountedArgument() {
		return getArgument("keepMounted");
	}

	public ModalElementModel removeKeepMounted() {
		return removeArgument("keepMounted");
	}

	public ModalElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ModalElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ModalElementModel removeKey() {
		return removeArgument("key");
	}

	public ModalElementModel setOnBackdropClick(String value) {
		return setOnBackdropClick(db.newSTValue(value));
	}

	public ModalElementModel setOnBackdropClick(STValue value) {
		return set(value, "onBackdropClick");
	}

	public STValue getOnBackdropClick() {
		return get("onBackdropClick");
	}

	public STArgument getOnBackdropClickArgument() {
		return getArgument("onBackdropClick");
	}

	public ModalElementModel removeOnBackdropClick() {
		return removeArgument("onBackdropClick");
	}

	public ModalElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public ModalElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public ModalElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public ModalElementModel setOnEscapeKeyDown(String value) {
		return setOnEscapeKeyDown(db.newSTValue(value));
	}

	public ModalElementModel setOnEscapeKeyDown(STValue value) {
		return set(value, "onEscapeKeyDown");
	}

	public STValue getOnEscapeKeyDown() {
		return get("onEscapeKeyDown");
	}

	public STArgument getOnEscapeKeyDownArgument() {
		return getArgument("onEscapeKeyDown");
	}

	public ModalElementModel removeOnEscapeKeyDown() {
		return removeArgument("onEscapeKeyDown");
	}

	public ModalElementModel setOnRendered(String value) {
		return setOnRendered(db.newSTValue(value));
	}

	public ModalElementModel setOnRendered(STValue value) {
		return set(value, "onRendered");
	}

	public STValue getOnRendered() {
		return get("onRendered");
	}

	public STArgument getOnRenderedArgument() {
		return getArgument("onRendered");
	}

	public ModalElementModel removeOnRendered() {
		return removeArgument("onRendered");
	}

	public ModalElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ModalElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ModalElementModel removeStyle() {
		return removeArgument("style");
	}

	public ModalElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ModalElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ModalElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ModalElementModel addAttribute(ModalElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ModalElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ModalElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ModalElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ModalElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ModalElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ModalElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ModalElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ModalElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ModalElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ModalElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ModalElementModel set(STValue value, String name) {
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

	private ModalElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ModalElementModel add(STValue value, String name) {
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