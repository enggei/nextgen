package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SpeedDialActionElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "6da735bb-db93-46b4-bf24-2d23dd66227c";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SpeedDialActionElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SpeedDialActionElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SpeedDialActionElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SpeedDialActionElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpeedDialActionElementModel that = (SpeedDialActionElementModel) o;
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

	public SpeedDialActionElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SpeedDialActionElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SpeedDialActionElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SpeedDialActionElementModel removeClassName() {
		return removeArgument("className");
	}

	public SpeedDialActionElementModel setDelay(String value) {
		return setDelay(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setDelay(STValue value) {
		return set(value, "delay");
	}

	public STValue getDelay() {
		return get("delay");
	}

	public STArgument getDelayArgument() {
		return getArgument("delay");
	}

	public SpeedDialActionElementModel removeDelay() {
		return removeArgument("delay");
	}

	public SpeedDialActionElementModel setFabProps(String value) {
		return setFabProps(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setFabProps(STValue value) {
		return set(value, "FabProps");
	}

	public STValue getFabProps() {
		return get("FabProps");
	}

	public STArgument getFabPropsArgument() {
		return getArgument("FabProps");
	}

	public SpeedDialActionElementModel removeFabProps() {
		return removeArgument("FabProps");
	}

	public SpeedDialActionElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public SpeedDialActionElementModel removeIcon() {
		return removeArgument("icon");
	}

	public SpeedDialActionElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SpeedDialActionElementModel removeId() {
		return removeArgument("id");
	}

	public SpeedDialActionElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SpeedDialActionElementModel removeKey() {
		return removeArgument("key");
	}

	public SpeedDialActionElementModel setOpen(String value) {
		return setOpen(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setOpen(STValue value) {
		return set(value, "open");
	}

	public STValue getOpen() {
		return get("open");
	}

	public STArgument getOpenArgument() {
		return getArgument("open");
	}

	public SpeedDialActionElementModel removeOpen() {
		return removeArgument("open");
	}

	public SpeedDialActionElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SpeedDialActionElementModel removeStyle() {
		return removeArgument("style");
	}

	public SpeedDialActionElementModel setTooltipClasses(String value) {
		return setTooltipClasses(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setTooltipClasses(STValue value) {
		return set(value, "TooltipClasses");
	}

	public STValue getTooltipClasses() {
		return get("TooltipClasses");
	}

	public STArgument getTooltipClassesArgument() {
		return getArgument("TooltipClasses");
	}

	public SpeedDialActionElementModel removeTooltipClasses() {
		return removeArgument("TooltipClasses");
	}

	public SpeedDialActionElementModel setTooltipOpen(String value) {
		return setTooltipOpen(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setTooltipOpen(STValue value) {
		return set(value, "tooltipOpen");
	}

	public STValue getTooltipOpen() {
		return get("tooltipOpen");
	}

	public STArgument getTooltipOpenArgument() {
		return getArgument("tooltipOpen");
	}

	public SpeedDialActionElementModel removeTooltipOpen() {
		return removeArgument("tooltipOpen");
	}

	public SpeedDialActionElementModel setTooltipPlacement(String value) {
		return setTooltipPlacement(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setTooltipPlacement(STValue value) {
		return set(value, "tooltipPlacement");
	}

	public STValue getTooltipPlacement() {
		return get("tooltipPlacement");
	}

	public STArgument getTooltipPlacementArgument() {
		return getArgument("tooltipPlacement");
	}

	public SpeedDialActionElementModel removeTooltipPlacement() {
		return removeArgument("tooltipPlacement");
	}

	public SpeedDialActionElementModel setTooltipTitle(String value) {
		return setTooltipTitle(db.newSTValue(value));
	}

	public SpeedDialActionElementModel setTooltipTitle(STValue value) {
		return set(value, "tooltipTitle");
	}

	public STValue getTooltipTitle() {
		return get("tooltipTitle");
	}

	public STArgument getTooltipTitleArgument() {
		return getArgument("tooltipTitle");
	}

	public SpeedDialActionElementModel removeTooltipTitle() {
		return removeArgument("tooltipTitle");
	}


	public SpeedDialActionElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SpeedDialActionElementModel addAttribute(SpeedDialActionElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SpeedDialActionElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SpeedDialActionElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SpeedDialActionElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SpeedDialActionElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SpeedDialActionElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SpeedDialActionElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SpeedDialActionElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SpeedDialActionElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SpeedDialActionElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SpeedDialActionElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SpeedDialActionElementModel set(STValue value, String name) {
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

	private SpeedDialActionElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SpeedDialActionElementModel add(STValue value, String name) {
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