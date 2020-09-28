package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TooltipElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "255a2832-57c8-47bc-bc0e-431530f4b175";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TooltipElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TooltipElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TooltipElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TooltipElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TooltipElementModel that = (TooltipElementModel) o;
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

	public TooltipElementModel setArrow(String value) {
		return setArrow(db.newSTValue(value));
	}

	public TooltipElementModel setArrow(STValue value) {
		return set(value, "arrow");
	}

	public STValue getArrow() {
		return get("arrow");
	}

	public STArgument getArrowArgument() {
		return getArgument("arrow");
	}

	public TooltipElementModel removeArrow() {
		return removeArgument("arrow");
	}

	public TooltipElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TooltipElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TooltipElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TooltipElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TooltipElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TooltipElementModel removeClassName() {
		return removeArgument("className");
	}

	public TooltipElementModel setDisableFocusListener(String value) {
		return setDisableFocusListener(db.newSTValue(value));
	}

	public TooltipElementModel setDisableFocusListener(STValue value) {
		return set(value, "disableFocusListener");
	}

	public STValue getDisableFocusListener() {
		return get("disableFocusListener");
	}

	public STArgument getDisableFocusListenerArgument() {
		return getArgument("disableFocusListener");
	}

	public TooltipElementModel removeDisableFocusListener() {
		return removeArgument("disableFocusListener");
	}

	public TooltipElementModel setDisableHoverListener(String value) {
		return setDisableHoverListener(db.newSTValue(value));
	}

	public TooltipElementModel setDisableHoverListener(STValue value) {
		return set(value, "disableHoverListener");
	}

	public STValue getDisableHoverListener() {
		return get("disableHoverListener");
	}

	public STArgument getDisableHoverListenerArgument() {
		return getArgument("disableHoverListener");
	}

	public TooltipElementModel removeDisableHoverListener() {
		return removeArgument("disableHoverListener");
	}

	public TooltipElementModel setDisableTouchListener(String value) {
		return setDisableTouchListener(db.newSTValue(value));
	}

	public TooltipElementModel setDisableTouchListener(STValue value) {
		return set(value, "disableTouchListener");
	}

	public STValue getDisableTouchListener() {
		return get("disableTouchListener");
	}

	public STArgument getDisableTouchListenerArgument() {
		return getArgument("disableTouchListener");
	}

	public TooltipElementModel removeDisableTouchListener() {
		return removeArgument("disableTouchListener");
	}

	public TooltipElementModel setEnterDelay(String value) {
		return setEnterDelay(db.newSTValue(value));
	}

	public TooltipElementModel setEnterDelay(STValue value) {
		return set(value, "enterDelay");
	}

	public STValue getEnterDelay() {
		return get("enterDelay");
	}

	public STArgument getEnterDelayArgument() {
		return getArgument("enterDelay");
	}

	public TooltipElementModel removeEnterDelay() {
		return removeArgument("enterDelay");
	}

	public TooltipElementModel setEnterNextDelay(String value) {
		return setEnterNextDelay(db.newSTValue(value));
	}

	public TooltipElementModel setEnterNextDelay(STValue value) {
		return set(value, "enterNextDelay");
	}

	public STValue getEnterNextDelay() {
		return get("enterNextDelay");
	}

	public STArgument getEnterNextDelayArgument() {
		return getArgument("enterNextDelay");
	}

	public TooltipElementModel removeEnterNextDelay() {
		return removeArgument("enterNextDelay");
	}

	public TooltipElementModel setEnterTouchDelay(String value) {
		return setEnterTouchDelay(db.newSTValue(value));
	}

	public TooltipElementModel setEnterTouchDelay(STValue value) {
		return set(value, "enterTouchDelay");
	}

	public STValue getEnterTouchDelay() {
		return get("enterTouchDelay");
	}

	public STArgument getEnterTouchDelayArgument() {
		return getArgument("enterTouchDelay");
	}

	public TooltipElementModel removeEnterTouchDelay() {
		return removeArgument("enterTouchDelay");
	}

	public TooltipElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TooltipElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TooltipElementModel removeId() {
		return removeArgument("id");
	}

	public TooltipElementModel setInteractive(String value) {
		return setInteractive(db.newSTValue(value));
	}

	public TooltipElementModel setInteractive(STValue value) {
		return set(value, "interactive");
	}

	public STValue getInteractive() {
		return get("interactive");
	}

	public STArgument getInteractiveArgument() {
		return getArgument("interactive");
	}

	public TooltipElementModel removeInteractive() {
		return removeArgument("interactive");
	}

	public TooltipElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TooltipElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TooltipElementModel removeKey() {
		return removeArgument("key");
	}

	public TooltipElementModel setLeaveDelay(String value) {
		return setLeaveDelay(db.newSTValue(value));
	}

	public TooltipElementModel setLeaveDelay(STValue value) {
		return set(value, "leaveDelay");
	}

	public STValue getLeaveDelay() {
		return get("leaveDelay");
	}

	public STArgument getLeaveDelayArgument() {
		return getArgument("leaveDelay");
	}

	public TooltipElementModel removeLeaveDelay() {
		return removeArgument("leaveDelay");
	}

	public TooltipElementModel setLeaveTouchDelay(String value) {
		return setLeaveTouchDelay(db.newSTValue(value));
	}

	public TooltipElementModel setLeaveTouchDelay(STValue value) {
		return set(value, "leaveTouchDelay");
	}

	public STValue getLeaveTouchDelay() {
		return get("leaveTouchDelay");
	}

	public STArgument getLeaveTouchDelayArgument() {
		return getArgument("leaveTouchDelay");
	}

	public TooltipElementModel removeLeaveTouchDelay() {
		return removeArgument("leaveTouchDelay");
	}

	public TooltipElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public TooltipElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public TooltipElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public TooltipElementModel setOnOpen(String value) {
		return setOnOpen(db.newSTValue(value));
	}

	public TooltipElementModel setOnOpen(STValue value) {
		return set(value, "onOpen");
	}

	public STValue getOnOpen() {
		return get("onOpen");
	}

	public STArgument getOnOpenArgument() {
		return getArgument("onOpen");
	}

	public TooltipElementModel removeOnOpen() {
		return removeArgument("onOpen");
	}

	public TooltipElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public TooltipElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public TooltipElementModel removeOpen() {
		return removeArgument("open");
	}

	public TooltipElementModel setPlacement(String value) {
		return setPlacement(db.newSTValue(value));
	}

	public TooltipElementModel setPlacement(STValue value) {
		return set(value, "placement");
	}

	public STValue getPlacement() {
		return get("placement");
	}

	public STArgument getPlacementArgument() {
		return getArgument("placement");
	}

	public TooltipElementModel removePlacement() {
		return removeArgument("placement");
	}

	public TooltipElementModel setPopperComponent(String value) {
		return setPopperComponent(db.newSTValue(value));
	}

	public TooltipElementModel setPopperComponent(STValue value) {
		return set(value, "PopperComponent");
	}

	public STValue getPopperComponent() {
		return get("PopperComponent");
	}

	public STArgument getPopperComponentArgument() {
		return getArgument("PopperComponent");
	}

	public TooltipElementModel removePopperComponent() {
		return removeArgument("PopperComponent");
	}

	public TooltipElementModel setPopperProps(String value) {
		return setPopperProps(db.newSTValue(value));
	}

	public TooltipElementModel setPopperProps(STValue value) {
		return set(value, "PopperProps");
	}

	public STValue getPopperProps() {
		return get("PopperProps");
	}

	public STArgument getPopperPropsArgument() {
		return getArgument("PopperProps");
	}

	public TooltipElementModel removePopperProps() {
		return removeArgument("PopperProps");
	}

	public TooltipElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TooltipElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TooltipElementModel removeStyle() {
		return removeArgument("style");
	}

	public TooltipElementModel setTitle(String value) {
		return setTitle(db.newSTValue(value));
	}

	public TooltipElementModel setTitle(STValue value) {
		return set(value, "title");
	}

	public STValue getTitle() {
		return get("title");
	}

	public STArgument getTitleArgument() {
		return getArgument("title");
	}

	public TooltipElementModel removeTitle() {
		return removeArgument("title");
	}

	public TooltipElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public TooltipElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public TooltipElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public TooltipElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public TooltipElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public TooltipElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public TooltipElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TooltipElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TooltipElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TooltipElementModel addAttribute(TooltipElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TooltipElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TooltipElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TooltipElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TooltipElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TooltipElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TooltipElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TooltipElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TooltipElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TooltipElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TooltipElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TooltipElementModel set(STValue value, String name) {
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

	private TooltipElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TooltipElementModel add(STValue value, String name) {
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