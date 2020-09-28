package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SwipeableDrawerElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "4d4f12cf-5a59-47ac-985e-5ab9758feae1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SwipeableDrawerElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SwipeableDrawerElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SwipeableDrawerElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SwipeableDrawerElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwipeableDrawerElementModel that = (SwipeableDrawerElementModel) o;
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

	public SwipeableDrawerElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SwipeableDrawerElementModel removeClassName() {
		return removeArgument("className");
	}

	public SwipeableDrawerElementModel setDisableBackdropTransition(String value) {
		return setDisableBackdropTransition(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setDisableBackdropTransition(STValue value) {
		return set(value, "disableBackdropTransition");
	}

	public STValue getDisableBackdropTransition() {
		return get("disableBackdropTransition");
	}

	public STArgument getDisableBackdropTransitionArgument() {
		return getArgument("disableBackdropTransition");
	}

	public SwipeableDrawerElementModel removeDisableBackdropTransition() {
		return removeArgument("disableBackdropTransition");
	}

	public SwipeableDrawerElementModel setDisableDiscovery(String value) {
		return setDisableDiscovery(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setDisableDiscovery(STValue value) {
		return set(value, "disableDiscovery");
	}

	public STValue getDisableDiscovery() {
		return get("disableDiscovery");
	}

	public STArgument getDisableDiscoveryArgument() {
		return getArgument("disableDiscovery");
	}

	public SwipeableDrawerElementModel removeDisableDiscovery() {
		return removeArgument("disableDiscovery");
	}

	public SwipeableDrawerElementModel setDisableSwipeToOpen(String value) {
		return setDisableSwipeToOpen(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setDisableSwipeToOpen(STValue value) {
		return set(value, "disableSwipeToOpen");
	}

	public STValue getDisableSwipeToOpen() {
		return get("disableSwipeToOpen");
	}

	public STArgument getDisableSwipeToOpenArgument() {
		return getArgument("disableSwipeToOpen");
	}

	public SwipeableDrawerElementModel removeDisableSwipeToOpen() {
		return removeArgument("disableSwipeToOpen");
	}

	public SwipeableDrawerElementModel setHysteresis(String value) {
		return setHysteresis(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setHysteresis(STValue value) {
		return set(value, "hysteresis");
	}

	public STValue getHysteresis() {
		return get("hysteresis");
	}

	public STArgument getHysteresisArgument() {
		return getArgument("hysteresis");
	}

	public SwipeableDrawerElementModel removeHysteresis() {
		return removeArgument("hysteresis");
	}

	public SwipeableDrawerElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SwipeableDrawerElementModel removeId() {
		return removeArgument("id");
	}

	public SwipeableDrawerElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SwipeableDrawerElementModel removeKey() {
		return removeArgument("key");
	}

	public SwipeableDrawerElementModel setMinFlingVelocity(String value) {
		return setMinFlingVelocity(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setMinFlingVelocity(STValue value) {
		return set(value, "minFlingVelocity");
	}

	public STValue getMinFlingVelocity() {
		return get("minFlingVelocity");
	}

	public STArgument getMinFlingVelocityArgument() {
		return getArgument("minFlingVelocity");
	}

	public SwipeableDrawerElementModel removeMinFlingVelocity() {
		return removeArgument("minFlingVelocity");
	}

	public SwipeableDrawerElementModel setOnClose(String value) {
		return setOnClose(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setOnClose(STValue value) {
		return set(value, "onClose");
	}

	public STValue getOnClose() {
		return get("onClose");
	}

	public STArgument getOnCloseArgument() {
		return getArgument("onClose");
	}

	public SwipeableDrawerElementModel removeOnClose() {
		return removeArgument("onClose");
	}

	public SwipeableDrawerElementModel setOnOpen(String value) {
		return setOnOpen(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setOnOpen(STValue value) {
		return set(value, "onOpen");
	}

	public STValue getOnOpen() {
		return get("onOpen");
	}

	public STArgument getOnOpenArgument() {
		return getArgument("onOpen");
	}

	public SwipeableDrawerElementModel removeOnOpen() {
		return removeArgument("onOpen");
	}

	public SwipeableDrawerElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SwipeableDrawerElementModel removeStyle() {
		return removeArgument("style");
	}

	public SwipeableDrawerElementModel setSwipeAreaProps(String value) {
		return setSwipeAreaProps(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setSwipeAreaProps(STValue value) {
		return set(value, "SwipeAreaProps");
	}

	public STValue getSwipeAreaProps() {
		return get("SwipeAreaProps");
	}

	public STArgument getSwipeAreaPropsArgument() {
		return getArgument("SwipeAreaProps");
	}

	public SwipeableDrawerElementModel removeSwipeAreaProps() {
		return removeArgument("SwipeAreaProps");
	}

	public SwipeableDrawerElementModel setSwipeAreaWidth(String value) {
		return setSwipeAreaWidth(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setSwipeAreaWidth(STValue value) {
		return set(value, "swipeAreaWidth");
	}

	public STValue getSwipeAreaWidth() {
		return get("swipeAreaWidth");
	}

	public STArgument getSwipeAreaWidthArgument() {
		return getArgument("swipeAreaWidth");
	}

	public SwipeableDrawerElementModel removeSwipeAreaWidth() {
		return removeArgument("swipeAreaWidth");
	}

	public SwipeableDrawerElementModel setTransitionDuration(String value) {
		return setTransitionDuration(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel setTransitionDuration(STValue value) {
		return set(value, "transitionDuration");
	}

	public STValue getTransitionDuration() {
		return get("transitionDuration");
	}

	public STArgument getTransitionDurationArgument() {
		return getArgument("transitionDuration");
	}

	public SwipeableDrawerElementModel removeTransitionDuration() {
		return removeArgument("transitionDuration");
	}

	public SwipeableDrawerElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SwipeableDrawerElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SwipeableDrawerElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SwipeableDrawerElementModel addAttribute(SwipeableDrawerElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SwipeableDrawerElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SwipeableDrawerElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SwipeableDrawerElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SwipeableDrawerElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SwipeableDrawerElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SwipeableDrawerElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SwipeableDrawerElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SwipeableDrawerElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SwipeableDrawerElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SwipeableDrawerElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SwipeableDrawerElementModel set(STValue value, String name) {
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

	private SwipeableDrawerElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SwipeableDrawerElementModel add(STValue value, String name) {
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