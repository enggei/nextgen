package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class GridElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8641dc8d-bed7-4c33-b505-80318b33fe98";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public GridElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public GridElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public GridElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public GridElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GridElementModel that = (GridElementModel) o;
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

	public GridElementModel setAlignContent(String value) {
		return setAlignContent(db.newSTValue(value));
	}

	public GridElementModel setAlignContent(STValue value) {
		return set(value, "alignContent");
	}

	public STValue getAlignContent() {
		return get("alignContent");
	}

	public STArgument getAlignContentArgument() {
		return getArgument("alignContent");
	}

	public GridElementModel removeAlignContent() {
		return removeArgument("alignContent");
	}

	public GridElementModel setAlignItems(String value) {
		return setAlignItems(db.newSTValue(value));
	}

	public GridElementModel setAlignItems(STValue value) {
		return set(value, "alignItems");
	}

	public STValue getAlignItems() {
		return get("alignItems");
	}

	public STArgument getAlignItemsArgument() {
		return getArgument("alignItems");
	}

	public GridElementModel removeAlignItems() {
		return removeArgument("alignItems");
	}

	public GridElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public GridElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public GridElementModel removeClasses() {
		return removeArgument("classes");
	}

	public GridElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public GridElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public GridElementModel removeClassName() {
		return removeArgument("className");
	}

	public GridElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public GridElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public GridElementModel removeComponent() {
		return removeArgument("component");
	}

	public GridElementModel setContainer(String value) {
		return setContainer(db.newSTValue(value));
	}

	public GridElementModel setContainer(STValue value) {
		return set(value, "container");
	}

	public STValue getContainer() {
		return get("container");
	}

	public STArgument getContainerArgument() {
		return getArgument("container");
	}

	public GridElementModel removeContainer() {
		return removeArgument("container");
	}

	public GridElementModel setDirection(String value) {
		return setDirection(db.newSTValue(value));
	}

	public GridElementModel setDirection(STValue value) {
		return set(value, "direction");
	}

	public STValue getDirection() {
		return get("direction");
	}

	public STArgument getDirectionArgument() {
		return getArgument("direction");
	}

	public GridElementModel removeDirection() {
		return removeArgument("direction");
	}

	public GridElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public GridElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public GridElementModel removeId() {
		return removeArgument("id");
	}

	public GridElementModel setItem(String value) {
		return setItem(db.newSTValue(value));
	}

	public GridElementModel setItem(STValue value) {
		return set(value, "item");
	}

	public STValue getItem() {
		return get("item");
	}

	public STArgument getItemArgument() {
		return getArgument("item");
	}

	public GridElementModel removeItem() {
		return removeArgument("item");
	}

	public GridElementModel setJustify(String value) {
		return setJustify(db.newSTValue(value));
	}

	public GridElementModel setJustify(STValue value) {
		return set(value, "justify");
	}

	public STValue getJustify() {
		return get("justify");
	}

	public STArgument getJustifyArgument() {
		return getArgument("justify");
	}

	public GridElementModel removeJustify() {
		return removeArgument("justify");
	}

	public GridElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public GridElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public GridElementModel removeKey() {
		return removeArgument("key");
	}

	public GridElementModel setLg(String value) {
		return setLg(db.newSTValue(value));
	}

	public GridElementModel setLg(STValue value) {
		return set(value, "lg");
	}

	public STValue getLg() {
		return get("lg");
	}

	public STArgument getLgArgument() {
		return getArgument("lg");
	}

	public GridElementModel removeLg() {
		return removeArgument("lg");
	}

	public GridElementModel setMd(String value) {
		return setMd(db.newSTValue(value));
	}

	public GridElementModel setMd(STValue value) {
		return set(value, "md");
	}

	public STValue getMd() {
		return get("md");
	}

	public STArgument getMdArgument() {
		return getArgument("md");
	}

	public GridElementModel removeMd() {
		return removeArgument("md");
	}

	public GridElementModel setSm(String value) {
		return setSm(db.newSTValue(value));
	}

	public GridElementModel setSm(STValue value) {
		return set(value, "sm");
	}

	public STValue getSm() {
		return get("sm");
	}

	public STArgument getSmArgument() {
		return getArgument("sm");
	}

	public GridElementModel removeSm() {
		return removeArgument("sm");
	}

	public GridElementModel setSpacing(String value) {
		return setSpacing(db.newSTValue(value));
	}

	public GridElementModel setSpacing(STValue value) {
		return set(value, "spacing");
	}

	public STValue getSpacing() {
		return get("spacing");
	}

	public STArgument getSpacingArgument() {
		return getArgument("spacing");
	}

	public GridElementModel removeSpacing() {
		return removeArgument("spacing");
	}

	public GridElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public GridElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public GridElementModel removeStyle() {
		return removeArgument("style");
	}

	public GridElementModel setWrap(String value) {
		return setWrap(db.newSTValue(value));
	}

	public GridElementModel setWrap(STValue value) {
		return set(value, "wrap");
	}

	public STValue getWrap() {
		return get("wrap");
	}

	public STArgument getWrapArgument() {
		return getArgument("wrap");
	}

	public GridElementModel removeWrap() {
		return removeArgument("wrap");
	}

	public GridElementModel setXl(String value) {
		return setXl(db.newSTValue(value));
	}

	public GridElementModel setXl(STValue value) {
		return set(value, "xl");
	}

	public STValue getXl() {
		return get("xl");
	}

	public STArgument getXlArgument() {
		return getArgument("xl");
	}

	public GridElementModel removeXl() {
		return removeArgument("xl");
	}

	public GridElementModel setXs(String value) {
		return setXs(db.newSTValue(value));
	}

	public GridElementModel setXs(STValue value) {
		return set(value, "xs");
	}

	public STValue getXs() {
		return get("xs");
	}

	public STArgument getXsArgument() {
		return getArgument("xs");
	}

	public GridElementModel removeXs() {
		return removeArgument("xs");
	}

	public GridElementModel setZeroMinWidth(String value) {
		return setZeroMinWidth(db.newSTValue(value));
	}

	public GridElementModel setZeroMinWidth(STValue value) {
		return set(value, "zeroMinWidth");
	}

	public STValue getZeroMinWidth() {
		return get("zeroMinWidth");
	}

	public STArgument getZeroMinWidthArgument() {
		return getArgument("zeroMinWidth");
	}

	public GridElementModel removeZeroMinWidth() {
		return removeArgument("zeroMinWidth");
	}

	public GridElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public GridElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public GridElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public GridElementModel addAttribute(GridElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public GridElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<GridElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new GridElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class GridElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public GridElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public GridElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public GridElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public GridElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public GridElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private GridElementModel_Attribute setKVValue(String name, STValue value) {

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

	private GridElementModel set(STValue value, String name) {
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

	private GridElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private GridElementModel add(STValue value, String name) {
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