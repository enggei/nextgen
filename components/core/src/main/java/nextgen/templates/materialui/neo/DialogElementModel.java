package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DialogElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "0890704b-06f8-4e8b-8c43-205ece67086c";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DialogElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DialogElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DialogElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public DialogElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DialogElementModel that = (DialogElementModel) o;
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

	public DialogElementModel setAriaDescribedby(String value) {
		return setAriaDescribedby(db.newSTValue(value));
	}

	public DialogElementModel setAriaDescribedby(STValue value) {
		return set(value, "ariaDescribedby");
	}

	public STValue getAriaDescribedby() {
		return get("ariaDescribedby");
	}

	public STArgument getAriaDescribedbyArgument() {
		return getArgument("ariaDescribedby");
	}

	public DialogElementModel removeAriaDescribedby() {
		return removeArgument("ariaDescribedby");
	}

	public DialogElementModel setAriaLabelledby(String value) {
		return setAriaLabelledby(db.newSTValue(value));
	}

	public DialogElementModel setAriaLabelledby(STValue value) {
		return set(value, "ariaLabelledby");
	}

	public STValue getAriaLabelledby() {
		return get("ariaLabelledby");
	}

	public STArgument getAriaLabelledbyArgument() {
		return getArgument("ariaLabelledby");
	}

	public DialogElementModel removeAriaLabelledby() {
		return removeArgument("ariaLabelledby");
	}

	public DialogElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public DialogElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public DialogElementModel removeClasses() {
		return removeArgument("classes");
	}

	public DialogElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public DialogElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public DialogElementModel removeClassName() {
		return removeArgument("className");
	}

	public DialogElementModel setDisableBackdropClick(String value) {
		return setDisableBackdropClick(db.newSTValue(value));
	}

	public DialogElementModel setDisableBackdropClick(STValue value) {
		return set(value, "disableBackdropClick");
	}

	public STValue getDisableBackdropClick() {
		return get("disableBackdropClick");
	}

	public STArgument getDisableBackdropClickArgument() {
		return getArgument("disableBackdropClick");
	}

	public DialogElementModel removeDisableBackdropClick() {
		return removeArgument("disableBackdropClick");
	}

	public DialogElementModel setDisableEscapeKeyDown(String value) {
		return setDisableEscapeKeyDown(db.newSTValue(value));
	}

	public DialogElementModel setDisableEscapeKeyDown(STValue value) {
		return set(value, "disableEscapeKeyDown");
	}

	public STValue getDisableEscapeKeyDown() {
		return get("disableEscapeKeyDown");
	}

	public STArgument getDisableEscapeKeyDownArgument() {
		return getArgument("disableEscapeKeyDown");
	}

	public DialogElementModel removeDisableEscapeKeyDown() {
		return removeArgument("disableEscapeKeyDown");
	}

	public DialogElementModel setFullScreen(String value) {
		return setFullScreen(db.newSTValue(value));
	}

	public DialogElementModel setFullScreen(STValue value) {
		return set(value, "fullScreen");
	}

	public STValue getFullScreen() {
		return get("fullScreen");
	}

	public STArgument getFullScreenArgument() {
		return getArgument("fullScreen");
	}

	public DialogElementModel removeFullScreen() {
		return removeArgument("fullScreen");
	}

	public DialogElementModel setFullWidth(String value) {
		return setFullWidth(db.newSTValue(value));
	}

	public DialogElementModel setFullWidth(STValue value) {
		return set(value, "fullWidth");
	}

	public STValue getFullWidth() {
		return get("fullWidth");
	}

	public STArgument getFullWidthArgument() {
		return getArgument("fullWidth");
	}

	public DialogElementModel removeFullWidth() {
		return removeArgument("fullWidth");
	}

	public DialogElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public DialogElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public DialogElementModel removeId() {
		return removeArgument("id");
	}

	public DialogElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public DialogElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public DialogElementModel removeKey() {
		return removeArgument("key");
	}

	public DialogElementModel setMaxWidth(String value) {
		return setMaxWidth(db.newSTValue(value));
	}

	public DialogElementModel setMaxWidth(STValue value) {
		return set(value, "maxWidth");
	}

	public STValue getMaxWidth() {
		return get("maxWidth");
	}

	public STArgument getMaxWidthArgument() {
		return getArgument("maxWidth");
	}

	public DialogElementModel removeMaxWidth() {
		return removeArgument("maxWidth");
	}

	public DialogElementModel setOnBackdropClick(String value) {
		return setOnBackdropClick(db.newSTValue(value));
	}

	public DialogElementModel setOnBackdropClick(STValue value) {
		return set(value, "onBackdropClick");
	}

	public STValue getOnBackdropClick() {
		return get("onBackdropClick");
	}

	public STArgument getOnBackdropClickArgument() {
		return getArgument("onBackdropClick");
	}

	public DialogElementModel removeOnBackdropClick() {
		return removeArgument("onBackdropClick");
	}

	public DialogElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public DialogElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public DialogElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public DialogElementModel setOnEnter(String value) {
		return setOnEnter(db.newSTValue(value));
	}

	public DialogElementModel setOnEnter(STValue value) {
		return set(value, "onEnter");
	}

	public STValue getOnEnter() {
		return get("onEnter");
	}

	public STArgument getOnEnterArgument() {
		return getArgument("onEnter");
	}

	public DialogElementModel removeOnEnter() {
		return removeArgument("onEnter");
	}

	public DialogElementModel setOnEntered(String value) {
		return setOnEntered(db.newSTValue(value));
	}

	public DialogElementModel setOnEntered(STValue value) {
		return set(value, "onEntered");
	}

	public STValue getOnEntered() {
		return get("onEntered");
	}

	public STArgument getOnEnteredArgument() {
		return getArgument("onEntered");
	}

	public DialogElementModel removeOnEntered() {
		return removeArgument("onEntered");
	}

	public DialogElementModel setOnEntering(String value) {
		return setOnEntering(db.newSTValue(value));
	}

	public DialogElementModel setOnEntering(STValue value) {
		return set(value, "onEntering");
	}

	public STValue getOnEntering() {
		return get("onEntering");
	}

	public STArgument getOnEnteringArgument() {
		return getArgument("onEntering");
	}

	public DialogElementModel removeOnEntering() {
		return removeArgument("onEntering");
	}

	public DialogElementModel setOnEscapeKeyDown(String value) {
		return setOnEscapeKeyDown(db.newSTValue(value));
	}

	public DialogElementModel setOnEscapeKeyDown(STValue value) {
		return set(value, "onEscapeKeyDown");
	}

	public STValue getOnEscapeKeyDown() {
		return get("onEscapeKeyDown");
	}

	public STArgument getOnEscapeKeyDownArgument() {
		return getArgument("onEscapeKeyDown");
	}

	public DialogElementModel removeOnEscapeKeyDown() {
		return removeArgument("onEscapeKeyDown");
	}

	public DialogElementModel setOnExit(String value) {
		return setOnExit(db.newSTValue(value));
	}

	public DialogElementModel setOnExit(STValue value) {
		return set(value, "onExit");
	}

	public STValue getOnExit() {
		return get("onExit");
	}

	public STArgument getOnExitArgument() {
		return getArgument("onExit");
	}

	public DialogElementModel removeOnExit() {
		return removeArgument("onExit");
	}

	public DialogElementModel setOnExited(String value) {
		return setOnExited(db.newSTValue(value));
	}

	public DialogElementModel setOnExited(STValue value) {
		return set(value, "onExited");
	}

	public STValue getOnExited() {
		return get("onExited");
	}

	public STArgument getOnExitedArgument() {
		return getArgument("onExited");
	}

	public DialogElementModel removeOnExited() {
		return removeArgument("onExited");
	}

	public DialogElementModel setOnExiting(String value) {
		return setOnExiting(db.newSTValue(value));
	}

	public DialogElementModel setOnExiting(STValue value) {
		return set(value, "onExiting");
	}

	public STValue getOnExiting() {
		return get("onExiting");
	}

	public STArgument getOnExitingArgument() {
		return getArgument("onExiting");
	}

	public DialogElementModel removeOnExiting() {
		return removeArgument("onExiting");
	}

	public DialogElementModel setPaperComponent(String value) {
		return setPaperComponent(db.newSTValue(value));
	}

	public DialogElementModel setPaperComponent(STValue value) {
		return set(value, "PaperComponent");
	}

	public STValue getPaperComponent() {
		return get("PaperComponent");
	}

	public STArgument getPaperComponentArgument() {
		return getArgument("PaperComponent");
	}

	public DialogElementModel removePaperComponent() {
		return removeArgument("PaperComponent");
	}

	public DialogElementModel setPaperProps(String value) {
		return setPaperProps(db.newSTValue(value));
	}

	public DialogElementModel setPaperProps(STValue value) {
		return set(value, "PaperProps");
	}

	public STValue getPaperProps() {
		return get("PaperProps");
	}

	public STArgument getPaperPropsArgument() {
		return getArgument("PaperProps");
	}

	public DialogElementModel removePaperProps() {
		return removeArgument("PaperProps");
	}

	public DialogElementModel setScroll(String value) {
		return setScroll(db.newSTValue(value));
	}

	public DialogElementModel setScroll(STValue value) {
		return set(value, "scroll");
	}

	public STValue getScroll() {
		return get("scroll");
	}

	public STArgument getScrollArgument() {
		return getArgument("scroll");
	}

	public DialogElementModel removeScroll() {
		return removeArgument("scroll");
	}

	public DialogElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public DialogElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public DialogElementModel removeStyle() {
		return removeArgument("style");
	}

	public DialogElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public DialogElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public DialogElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public DialogElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public DialogElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public DialogElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public DialogElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public DialogElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public DialogElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public DialogElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public DialogElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public DialogElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public DialogElementModel addAttribute(DialogElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public DialogElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<DialogElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new DialogElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class DialogElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public DialogElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public DialogElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public DialogElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public DialogElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public DialogElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private DialogElementModel_Attribute setKVValue(String name, STValue value) {

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

	private DialogElementModel set(STValue value, String name) {
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

	private DialogElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private DialogElementModel add(STValue value, String name) {
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