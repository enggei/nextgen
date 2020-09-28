package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SnackbarElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "c9ec2b04-d20d-40b0-b1a7-7262c9a2709d";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SnackbarElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SnackbarElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SnackbarElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SnackbarElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SnackbarElementModel that = (SnackbarElementModel) o;
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

	public SnackbarElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public SnackbarElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public SnackbarElementModel removeAction() {
		return removeArgument("action");
	}

	public SnackbarElementModel setAnchorOrigin(String value) {
		return setAnchorOrigin(db.newSTValue(value));
	}

	public SnackbarElementModel setAnchorOrigin(STValue value) {
		return set(value, "anchorOrigin");
	}

	public STValue getAnchorOrigin() {
		return get("anchorOrigin");
	}

	public STArgument getAnchorOriginArgument() {
		return getArgument("anchorOrigin");
	}

	public SnackbarElementModel removeAnchorOrigin() {
		return removeArgument("anchorOrigin");
	}

	public SnackbarElementModel setAutoHideDuration(String value) {
		return setAutoHideDuration(db.newSTValue(value));
	}

	public SnackbarElementModel setAutoHideDuration(STValue value) {
		return set(value, "autoHideDuration");
	}

	public STValue getAutoHideDuration() {
		return get("autoHideDuration");
	}

	public STArgument getAutoHideDurationArgument() {
		return getArgument("autoHideDuration");
	}

	public SnackbarElementModel removeAutoHideDuration() {
		return removeArgument("autoHideDuration");
	}

	public SnackbarElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SnackbarElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SnackbarElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SnackbarElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SnackbarElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SnackbarElementModel removeClassName() {
		return removeArgument("className");
	}

	public SnackbarElementModel setClickAwayListenerProps(String value) {
		return setClickAwayListenerProps(db.newSTValue(value));
	}

	public SnackbarElementModel setClickAwayListenerProps(STValue value) {
		return set(value, "ClickAwayListenerProps");
	}

	public STValue getClickAwayListenerProps() {
		return get("ClickAwayListenerProps");
	}

	public STArgument getClickAwayListenerPropsArgument() {
		return getArgument("ClickAwayListenerProps");
	}

	public SnackbarElementModel removeClickAwayListenerProps() {
		return removeArgument("ClickAwayListenerProps");
	}

	public SnackbarElementModel setContentProps(String value) {
		return setContentProps(db.newSTValue(value));
	}

	public SnackbarElementModel setContentProps(STValue value) {
		return set(value, "ContentProps");
	}

	public STValue getContentProps() {
		return get("ContentProps");
	}

	public STArgument getContentPropsArgument() {
		return getArgument("ContentProps");
	}

	public SnackbarElementModel removeContentProps() {
		return removeArgument("ContentProps");
	}

	public SnackbarElementModel setDisableWindowBlurListener(String value) {
		return setDisableWindowBlurListener(db.newSTValue(value));
	}

	public SnackbarElementModel setDisableWindowBlurListener(STValue value) {
		return set(value, "disableWindowBlurListener");
	}

	public STValue getDisableWindowBlurListener() {
		return get("disableWindowBlurListener");
	}

	public STArgument getDisableWindowBlurListenerArgument() {
		return getArgument("disableWindowBlurListener");
	}

	public SnackbarElementModel removeDisableWindowBlurListener() {
		return removeArgument("disableWindowBlurListener");
	}

	public SnackbarElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SnackbarElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SnackbarElementModel removeId() {
		return removeArgument("id");
	}

	public SnackbarElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SnackbarElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SnackbarElementModel removeKey() {
		return removeArgument("key");
	}

	public SnackbarElementModel setMessage(String value) {
		return setMessage(db.newSTValue(value));
	}

	public SnackbarElementModel setMessage(STValue value) {
		return set(value, "message");
	}

	public STValue getMessage() {
		return get("message");
	}

	public STArgument getMessageArgument() {
		return getArgument("message");
	}

	public SnackbarElementModel removeMessage() {
		return removeArgument("message");
	}

	public SnackbarElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public SnackbarElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public SnackbarElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public SnackbarElementModel setOnEnter(String value) {
		return setOnEnter(db.newSTValue(value));
	}

	public SnackbarElementModel setOnEnter(STValue value) {
		return set(value, "onEnter");
	}

	public STValue getOnEnter() {
		return get("onEnter");
	}

	public STArgument getOnEnterArgument() {
		return getArgument("onEnter");
	}

	public SnackbarElementModel removeOnEnter() {
		return removeArgument("onEnter");
	}

	public SnackbarElementModel setOnEntered(String value) {
		return setOnEntered(db.newSTValue(value));
	}

	public SnackbarElementModel setOnEntered(STValue value) {
		return set(value, "onEntered");
	}

	public STValue getOnEntered() {
		return get("onEntered");
	}

	public STArgument getOnEnteredArgument() {
		return getArgument("onEntered");
	}

	public SnackbarElementModel removeOnEntered() {
		return removeArgument("onEntered");
	}

	public SnackbarElementModel setOnEntering(String value) {
		return setOnEntering(db.newSTValue(value));
	}

	public SnackbarElementModel setOnEntering(STValue value) {
		return set(value, "onEntering");
	}

	public STValue getOnEntering() {
		return get("onEntering");
	}

	public STArgument getOnEnteringArgument() {
		return getArgument("onEntering");
	}

	public SnackbarElementModel removeOnEntering() {
		return removeArgument("onEntering");
	}

	public SnackbarElementModel setOnExit(String value) {
		return setOnExit(db.newSTValue(value));
	}

	public SnackbarElementModel setOnExit(STValue value) {
		return set(value, "onExit");
	}

	public STValue getOnExit() {
		return get("onExit");
	}

	public STArgument getOnExitArgument() {
		return getArgument("onExit");
	}

	public SnackbarElementModel removeOnExit() {
		return removeArgument("onExit");
	}

	public SnackbarElementModel setOnExited(String value) {
		return setOnExited(db.newSTValue(value));
	}

	public SnackbarElementModel setOnExited(STValue value) {
		return set(value, "onExited");
	}

	public STValue getOnExited() {
		return get("onExited");
	}

	public STArgument getOnExitedArgument() {
		return getArgument("onExited");
	}

	public SnackbarElementModel removeOnExited() {
		return removeArgument("onExited");
	}

	public SnackbarElementModel setOnExiting(String value) {
		return setOnExiting(db.newSTValue(value));
	}

	public SnackbarElementModel setOnExiting(STValue value) {
		return set(value, "onExiting");
	}

	public STValue getOnExiting() {
		return get("onExiting");
	}

	public STArgument getOnExitingArgument() {
		return getArgument("onExiting");
	}

	public SnackbarElementModel removeOnExiting() {
		return removeArgument("onExiting");
	}

	public SnackbarElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public SnackbarElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public SnackbarElementModel removeOpen() {
		return removeArgument("open");
	}

	public SnackbarElementModel setResumeHideDuration(String value) {
		return setResumeHideDuration(db.newSTValue(value));
	}

	public SnackbarElementModel setResumeHideDuration(STValue value) {
		return set(value, "resumeHideDuration");
	}

	public STValue getResumeHideDuration() {
		return get("resumeHideDuration");
	}

	public STArgument getResumeHideDurationArgument() {
		return getArgument("resumeHideDuration");
	}

	public SnackbarElementModel removeResumeHideDuration() {
		return removeArgument("resumeHideDuration");
	}

	public SnackbarElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SnackbarElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SnackbarElementModel removeStyle() {
		return removeArgument("style");
	}

	public SnackbarElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public SnackbarElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public SnackbarElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public SnackbarElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public SnackbarElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public SnackbarElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public SnackbarElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public SnackbarElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public SnackbarElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public SnackbarElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SnackbarElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SnackbarElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SnackbarElementModel addAttribute(SnackbarElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SnackbarElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SnackbarElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SnackbarElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SnackbarElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SnackbarElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SnackbarElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SnackbarElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SnackbarElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SnackbarElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SnackbarElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SnackbarElementModel set(STValue value, String name) {
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

	private SnackbarElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SnackbarElementModel add(STValue value, String name) {
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