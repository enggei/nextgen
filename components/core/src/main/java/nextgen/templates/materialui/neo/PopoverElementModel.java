package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PopoverElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "c0cc6a62-db1d-4684-b195-9e6c9c390f6b";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public PopoverElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public PopoverElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public PopoverElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public PopoverElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PopoverElementModel that = (PopoverElementModel) o;
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

	public PopoverElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public PopoverElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public PopoverElementModel removeAction() {
		return removeArgument("action");
	}

	public PopoverElementModel setAnchorEl(String value) {
		return setAnchorEl(db.newSTValue(value));
	}

	public PopoverElementModel setAnchorEl(STValue value) {
		return set(value, "anchorEl");
	}

	public STValue getAnchorEl() {
		return get("anchorEl");
	}

	public STArgument getAnchorElArgument() {
		return getArgument("anchorEl");
	}

	public PopoverElementModel removeAnchorEl() {
		return removeArgument("anchorEl");
	}

	public PopoverElementModel setAnchorOrigin(String value) {
		return setAnchorOrigin(db.newSTValue(value));
	}

	public PopoverElementModel setAnchorOrigin(STValue value) {
		return set(value, "anchorOrigin");
	}

	public STValue getAnchorOrigin() {
		return get("anchorOrigin");
	}

	public STArgument getAnchorOriginArgument() {
		return getArgument("anchorOrigin");
	}

	public PopoverElementModel removeAnchorOrigin() {
		return removeArgument("anchorOrigin");
	}

	public PopoverElementModel setAnchorPosition(String value) {
		return setAnchorPosition(db.newSTValue(value));
	}

	public PopoverElementModel setAnchorPosition(STValue value) {
		return set(value, "anchorPosition");
	}

	public STValue getAnchorPosition() {
		return get("anchorPosition");
	}

	public STArgument getAnchorPositionArgument() {
		return getArgument("anchorPosition");
	}

	public PopoverElementModel removeAnchorPosition() {
		return removeArgument("anchorPosition");
	}

	public PopoverElementModel setAnchorReference(String value) {
		return setAnchorReference(db.newSTValue(value));
	}

	public PopoverElementModel setAnchorReference(STValue value) {
		return set(value, "anchorReference");
	}

	public STValue getAnchorReference() {
		return get("anchorReference");
	}

	public STArgument getAnchorReferenceArgument() {
		return getArgument("anchorReference");
	}

	public PopoverElementModel removeAnchorReference() {
		return removeArgument("anchorReference");
	}

	public PopoverElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public PopoverElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public PopoverElementModel removeClasses() {
		return removeArgument("classes");
	}

	public PopoverElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public PopoverElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public PopoverElementModel removeClassName() {
		return removeArgument("className");
	}

	public PopoverElementModel setContainer(String value) {
		return setContainer(db.newSTValue(value));
	}

	public PopoverElementModel setContainer(STValue value) {
		return set(value, "container");
	}

	public STValue getContainer() {
		return get("container");
	}

	public STArgument getContainerArgument() {
		return getArgument("container");
	}

	public PopoverElementModel removeContainer() {
		return removeArgument("container");
	}

	public PopoverElementModel setElevation(String value) {
		return setElevation(db.newSTValue(value));
	}

	public PopoverElementModel setElevation(STValue value) {
		return set(value, "elevation");
	}

	public STValue getElevation() {
		return get("elevation");
	}

	public STArgument getElevationArgument() {
		return getArgument("elevation");
	}

	public PopoverElementModel removeElevation() {
		return removeArgument("elevation");
	}

	public PopoverElementModel setGetContentAnchorEl(String value) {
		return setGetContentAnchorEl(db.newSTValue(value));
	}

	public PopoverElementModel setGetContentAnchorEl(STValue value) {
		return set(value, "getContentAnchorEl");
	}

	public STValue getGetContentAnchorEl() {
		return get("getContentAnchorEl");
	}

	public STArgument getGetContentAnchorElArgument() {
		return getArgument("getContentAnchorEl");
	}

	public PopoverElementModel removeGetContentAnchorEl() {
		return removeArgument("getContentAnchorEl");
	}

	public PopoverElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public PopoverElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public PopoverElementModel removeId() {
		return removeArgument("id");
	}

	public PopoverElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public PopoverElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public PopoverElementModel removeKey() {
		return removeArgument("key");
	}

	public PopoverElementModel setMarginThreshold(String value) {
		return setMarginThreshold(db.newSTValue(value));
	}

	public PopoverElementModel setMarginThreshold(STValue value) {
		return set(value, "marginThreshold");
	}

	public STValue getMarginThreshold() {
		return get("marginThreshold");
	}

	public STArgument getMarginThresholdArgument() {
		return getArgument("marginThreshold");
	}

	public PopoverElementModel removeMarginThreshold() {
		return removeArgument("marginThreshold");
	}

	public PopoverElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public PopoverElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public PopoverElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public PopoverElementModel setOnEnter(String value) {
		return setOnEnter(db.newSTValue(value));
	}

	public PopoverElementModel setOnEnter(STValue value) {
		return set(value, "onEnter");
	}

	public STValue getOnEnter() {
		return get("onEnter");
	}

	public STArgument getOnEnterArgument() {
		return getArgument("onEnter");
	}

	public PopoverElementModel removeOnEnter() {
		return removeArgument("onEnter");
	}

	public PopoverElementModel setOnEntered(String value) {
		return setOnEntered(db.newSTValue(value));
	}

	public PopoverElementModel setOnEntered(STValue value) {
		return set(value, "onEntered");
	}

	public STValue getOnEntered() {
		return get("onEntered");
	}

	public STArgument getOnEnteredArgument() {
		return getArgument("onEntered");
	}

	public PopoverElementModel removeOnEntered() {
		return removeArgument("onEntered");
	}

	public PopoverElementModel setOnEntering(String value) {
		return setOnEntering(db.newSTValue(value));
	}

	public PopoverElementModel setOnEntering(STValue value) {
		return set(value, "onEntering");
	}

	public STValue getOnEntering() {
		return get("onEntering");
	}

	public STArgument getOnEnteringArgument() {
		return getArgument("onEntering");
	}

	public PopoverElementModel removeOnEntering() {
		return removeArgument("onEntering");
	}

	public PopoverElementModel setOnExit(String value) {
		return setOnExit(db.newSTValue(value));
	}

	public PopoverElementModel setOnExit(STValue value) {
		return set(value, "onExit");
	}

	public STValue getOnExit() {
		return get("onExit");
	}

	public STArgument getOnExitArgument() {
		return getArgument("onExit");
	}

	public PopoverElementModel removeOnExit() {
		return removeArgument("onExit");
	}

	public PopoverElementModel setOnExited(String value) {
		return setOnExited(db.newSTValue(value));
	}

	public PopoverElementModel setOnExited(STValue value) {
		return set(value, "onExited");
	}

	public STValue getOnExited() {
		return get("onExited");
	}

	public STArgument getOnExitedArgument() {
		return getArgument("onExited");
	}

	public PopoverElementModel removeOnExited() {
		return removeArgument("onExited");
	}

	public PopoverElementModel setOnExiting(String value) {
		return setOnExiting(db.newSTValue(value));
	}

	public PopoverElementModel setOnExiting(STValue value) {
		return set(value, "onExiting");
	}

	public STValue getOnExiting() {
		return get("onExiting");
	}

	public STArgument getOnExitingArgument() {
		return getArgument("onExiting");
	}

	public PopoverElementModel removeOnExiting() {
		return removeArgument("onExiting");
	}

	public PopoverElementModel setPaperProps(String value) {
		return setPaperProps(db.newSTValue(value));
	}

	public PopoverElementModel setPaperProps(STValue value) {
		return set(value, "PaperProps");
	}

	public STValue getPaperProps() {
		return get("PaperProps");
	}

	public STArgument getPaperPropsArgument() {
		return getArgument("PaperProps");
	}

	public PopoverElementModel removePaperProps() {
		return removeArgument("PaperProps");
	}

	public PopoverElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public PopoverElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public PopoverElementModel removeStyle() {
		return removeArgument("style");
	}

	public PopoverElementModel setTransformOrigin(String value) {
		return setTransformOrigin(db.newSTValue(value));
	}

	public PopoverElementModel setTransformOrigin(STValue value) {
		return set(value, "transformOrigin");
	}

	public STValue getTransformOrigin() {
		return get("transformOrigin");
	}

	public STArgument getTransformOriginArgument() {
		return getArgument("transformOrigin");
	}

	public PopoverElementModel removeTransformOrigin() {
		return removeArgument("transformOrigin");
	}

	public PopoverElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public PopoverElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public PopoverElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public PopoverElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public PopoverElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public PopoverElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public PopoverElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public PopoverElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public PopoverElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public PopoverElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public PopoverElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public PopoverElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public PopoverElementModel addAttribute(PopoverElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public PopoverElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<PopoverElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new PopoverElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class PopoverElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public PopoverElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public PopoverElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public PopoverElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public PopoverElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public PopoverElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private PopoverElementModel_Attribute setKVValue(String name, STValue value) {

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

	private PopoverElementModel set(STValue value, String name) {
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

	private PopoverElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private PopoverElementModel add(STValue value, String name) {
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