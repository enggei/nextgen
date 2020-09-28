package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PopperElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "3fafb5ce-316c-4955-9626-c372df7fe25f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public PopperElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public PopperElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public PopperElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public PopperElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PopperElementModel that = (PopperElementModel) o;
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

	public PopperElementModel setAnchorEl(String value) {
		return setAnchorEl(db.newSTValue(value));
	}

	public PopperElementModel setAnchorEl(STValue value) {
		return set(value, "anchorEl");
	}

	public STValue getAnchorEl() {
		return get("anchorEl");
	}

	public STArgument getAnchorElArgument() {
		return getArgument("anchorEl");
	}

	public PopperElementModel removeAnchorEl() {
		return removeArgument("anchorEl");
	}

	public PopperElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public PopperElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public PopperElementModel removeClassName() {
		return removeArgument("className");
	}

	public PopperElementModel setContainer(String value) {
		return setContainer(db.newSTValue(value));
	}

	public PopperElementModel setContainer(STValue value) {
		return set(value, "container");
	}

	public STValue getContainer() {
		return get("container");
	}

	public STArgument getContainerArgument() {
		return getArgument("container");
	}

	public PopperElementModel removeContainer() {
		return removeArgument("container");
	}

	public PopperElementModel setDisablePortal(String value) {
		return setDisablePortal(db.newSTValue(value));
	}

	public PopperElementModel setDisablePortal(STValue value) {
		return set(value, "disablePortal");
	}

	public STValue getDisablePortal() {
		return get("disablePortal");
	}

	public STArgument getDisablePortalArgument() {
		return getArgument("disablePortal");
	}

	public PopperElementModel removeDisablePortal() {
		return removeArgument("disablePortal");
	}

	public PopperElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public PopperElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public PopperElementModel removeId() {
		return removeArgument("id");
	}

	public PopperElementModel setKeepMounted(String value) {
		return setKeepMounted(db.newSTValue(value));
	}

	public PopperElementModel setKeepMounted(STValue value) {
		return set(value, "keepMounted");
	}

	public STValue getKeepMounted() {
		return get("keepMounted");
	}

	public STArgument getKeepMountedArgument() {
		return getArgument("keepMounted");
	}

	public PopperElementModel removeKeepMounted() {
		return removeArgument("keepMounted");
	}

	public PopperElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public PopperElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public PopperElementModel removeKey() {
		return removeArgument("key");
	}

	public PopperElementModel setModifiers(String value) {
		return setModifiers(db.newSTValue(value));
	}

	public PopperElementModel setModifiers(STValue value) {
		return set(value, "modifiers");
	}

	public STValue getModifiers() {
		return get("modifiers");
	}

	public STArgument getModifiersArgument() {
		return getArgument("modifiers");
	}

	public PopperElementModel removeModifiers() {
		return removeArgument("modifiers");
	}

	public PopperElementModel setPlacement(String value) {
		return setPlacement(db.newSTValue(value));
	}

	public PopperElementModel setPlacement(STValue value) {
		return set(value, "placement");
	}

	public STValue getPlacement() {
		return get("placement");
	}

	public STArgument getPlacementArgument() {
		return getArgument("placement");
	}

	public PopperElementModel removePlacement() {
		return removeArgument("placement");
	}

	public PopperElementModel setPopperOptions(String value) {
		return setPopperOptions(db.newSTValue(value));
	}

	public PopperElementModel setPopperOptions(STValue value) {
		return set(value, "popperOptions");
	}

	public STValue getPopperOptions() {
		return get("popperOptions");
	}

	public STArgument getPopperOptionsArgument() {
		return getArgument("popperOptions");
	}

	public PopperElementModel removePopperOptions() {
		return removeArgument("popperOptions");
	}

	public PopperElementModel setPopperRef(String value) {
		return setPopperRef(db.newSTValue(value));
	}

	public PopperElementModel setPopperRef(STValue value) {
		return set(value, "popperRef");
	}

	public STValue getPopperRef() {
		return get("popperRef");
	}

	public STArgument getPopperRefArgument() {
		return getArgument("popperRef");
	}

	public PopperElementModel removePopperRef() {
		return removeArgument("popperRef");
	}

	public PopperElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public PopperElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public PopperElementModel removeStyle() {
		return removeArgument("style");
	}

	public PopperElementModel setTransition(String value) {
		return setTransition(db.newSTValue(value));
	}

	public PopperElementModel setTransition(STValue value) {
		return set(value, "transition");
	}

	public STValue getTransition() {
		return get("transition");
	}

	public STArgument getTransitionArgument() {
		return getArgument("transition");
	}

	public PopperElementModel removeTransition() {
		return removeArgument("transition");
	}

	public PopperElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public PopperElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public PopperElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public PopperElementModel addAttribute(PopperElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public PopperElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<PopperElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new PopperElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class PopperElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public PopperElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public PopperElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public PopperElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public PopperElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public PopperElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private PopperElementModel_Attribute setKVValue(String name, STValue value) {

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

	private PopperElementModel set(STValue value, String name) {
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

	private PopperElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private PopperElementModel add(STValue value, String name) {
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