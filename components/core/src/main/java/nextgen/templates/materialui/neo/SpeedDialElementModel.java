package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SpeedDialElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "188fb773-0eb2-4b2d-a01c-bf0af18fa680";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SpeedDialElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SpeedDialElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SpeedDialElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SpeedDialElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpeedDialElementModel that = (SpeedDialElementModel) o;
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

	public SpeedDialElementModel setAriaLabel(String value) {
		return setAriaLabel(db.newSTValue(value));
	}

	public SpeedDialElementModel setAriaLabel(STValue value) {
		return set(value, "ariaLabel");
	}

	public STValue getAriaLabel() {
		return get("ariaLabel");
	}

	public STArgument getAriaLabelArgument() {
		return getArgument("ariaLabel");
	}

	public SpeedDialElementModel removeAriaLabel() {
		return removeArgument("ariaLabel");
	}

	public SpeedDialElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SpeedDialElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SpeedDialElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SpeedDialElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SpeedDialElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SpeedDialElementModel removeClassName() {
		return removeArgument("className");
	}

	public SpeedDialElementModel setDirection(String value) {
		return setDirection(db.newSTValue(value));
	}

	public SpeedDialElementModel setDirection(STValue value) {
		return set(value, "direction");
	}

	public STValue getDirection() {
		return get("direction");
	}

	public STArgument getDirectionArgument() {
		return getArgument("direction");
	}

	public SpeedDialElementModel removeDirection() {
		return removeArgument("direction");
	}

	public SpeedDialElementModel setFabProps(String value) {
		return setFabProps(db.newSTValue(value));
	}

	public SpeedDialElementModel setFabProps(STValue value) {
		return set(value, "FabProps");
	}

	public STValue getFabProps() {
		return get("FabProps");
	}

	public STArgument getFabPropsArgument() {
		return getArgument("FabProps");
	}

	public SpeedDialElementModel removeFabProps() {
		return removeArgument("FabProps");
	}

	public SpeedDialElementModel setHidden(String value) {
		return setHidden(db.newSTValue(value));
	}

	public SpeedDialElementModel setHidden(STValue value) {
		return set(value, "hidden");
	}

	public STValue getHidden() {
		return get("hidden");
	}

	public STArgument getHiddenArgument() {
		return getArgument("hidden");
	}

	public SpeedDialElementModel removeHidden() {
		return removeArgument("hidden");
	}

	public SpeedDialElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public SpeedDialElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public SpeedDialElementModel removeIcon() {
		return removeArgument("icon");
	}

	public SpeedDialElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SpeedDialElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SpeedDialElementModel removeId() {
		return removeArgument("id");
	}

	public SpeedDialElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SpeedDialElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SpeedDialElementModel removeKey() {
		return removeArgument("key");
	}

	public SpeedDialElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public SpeedDialElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public SpeedDialElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public SpeedDialElementModel setOnOpen(String value) {
		return setOnOpen(db.newSTValue(value));
	}

	public SpeedDialElementModel setOnOpen(STValue value) {
		return set(value, "onOpen");
	}

	public STValue getOnOpen() {
		return get("onOpen");
	}

	public STArgument getOnOpenArgument() {
		return getArgument("onOpen");
	}

	public SpeedDialElementModel removeOnOpen() {
		return removeArgument("onOpen");
	}

	public SpeedDialElementModel setOpenIcon(String value) {
		return setOpenIcon(db.newSTValue(value));
	}

	public SpeedDialElementModel setOpenIcon(STValue value) {
		return set(value, "openIcon");
	}

	public STValue getOpenIcon() {
		return get("openIcon");
	}

	public STArgument getOpenIconArgument() {
		return getArgument("openIcon");
	}

	public SpeedDialElementModel removeOpenIcon() {
		return removeArgument("openIcon");
	}

	public SpeedDialElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SpeedDialElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SpeedDialElementModel removeStyle() {
		return removeArgument("style");
	}

	public SpeedDialElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public SpeedDialElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public SpeedDialElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public SpeedDialElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public SpeedDialElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public SpeedDialElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public SpeedDialElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public SpeedDialElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public SpeedDialElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public SpeedDialElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SpeedDialElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SpeedDialElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SpeedDialElementModel addAttribute(SpeedDialElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SpeedDialElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SpeedDialElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SpeedDialElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SpeedDialElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SpeedDialElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SpeedDialElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SpeedDialElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SpeedDialElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SpeedDialElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SpeedDialElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SpeedDialElementModel set(STValue value, String name) {
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

	private SpeedDialElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SpeedDialElementModel add(STValue value, String name) {
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