package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PaginationElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "9286d3c8-9ff5-42e9-b1e0-63f9cb835d89";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public PaginationElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public PaginationElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public PaginationElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public PaginationElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PaginationElementModel that = (PaginationElementModel) o;
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

	public PaginationElementModel setBoundaryCount(String value) {
		return setBoundaryCount(db.newSTValue(value));
	}

	public PaginationElementModel setBoundaryCount(STValue value) {
		return set(value, "boundaryCount");
	}

	public STValue getBoundaryCount() {
		return get("boundaryCount");
	}

	public STArgument getBoundaryCountArgument() {
		return getArgument("boundaryCount");
	}

	public PaginationElementModel removeBoundaryCount() {
		return removeArgument("boundaryCount");
	}

	public PaginationElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public PaginationElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public PaginationElementModel removeClasses() {
		return removeArgument("classes");
	}

	public PaginationElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public PaginationElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public PaginationElementModel removeClassName() {
		return removeArgument("className");
	}

	public PaginationElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public PaginationElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public PaginationElementModel removeColor() {
		return removeArgument("color");
	}

	public PaginationElementModel setCount(String value) {
		return setCount(db.newSTValue(value));
	}

	public PaginationElementModel setCount(STValue value) {
		return set(value, "count");
	}

	public STValue getCount() {
		return get("count");
	}

	public STArgument getCountArgument() {
		return getArgument("count");
	}

	public PaginationElementModel removeCount() {
		return removeArgument("count");
	}

	public PaginationElementModel setDefaultPage(String value) {
		return setDefaultPage(db.newSTValue(value));
	}

	public PaginationElementModel setDefaultPage(STValue value) {
		return set(value, "defaultPage");
	}

	public STValue getDefaultPage() {
		return get("defaultPage");
	}

	public STArgument getDefaultPageArgument() {
		return getArgument("defaultPage");
	}

	public PaginationElementModel removeDefaultPage() {
		return removeArgument("defaultPage");
	}

	public PaginationElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public PaginationElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public PaginationElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public PaginationElementModel setGetItemAriaLabel(String value) {
		return setGetItemAriaLabel(db.newSTValue(value));
	}

	public PaginationElementModel setGetItemAriaLabel(STValue value) {
		return set(value, "getItemAriaLabel");
	}

	public STValue getGetItemAriaLabel() {
		return get("getItemAriaLabel");
	}

	public STArgument getGetItemAriaLabelArgument() {
		return getArgument("getItemAriaLabel");
	}

	public PaginationElementModel removeGetItemAriaLabel() {
		return removeArgument("getItemAriaLabel");
	}

	public PaginationElementModel setHideNextButton(String value) {
		return setHideNextButton(db.newSTValue(value));
	}

	public PaginationElementModel setHideNextButton(STValue value) {
		return set(value, "hideNextButton");
	}

	public STValue getHideNextButton() {
		return get("hideNextButton");
	}

	public STArgument getHideNextButtonArgument() {
		return getArgument("hideNextButton");
	}

	public PaginationElementModel removeHideNextButton() {
		return removeArgument("hideNextButton");
	}

	public PaginationElementModel setHidePrevButton(String value) {
		return setHidePrevButton(db.newSTValue(value));
	}

	public PaginationElementModel setHidePrevButton(STValue value) {
		return set(value, "hidePrevButton");
	}

	public STValue getHidePrevButton() {
		return get("hidePrevButton");
	}

	public STArgument getHidePrevButtonArgument() {
		return getArgument("hidePrevButton");
	}

	public PaginationElementModel removeHidePrevButton() {
		return removeArgument("hidePrevButton");
	}

	public PaginationElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public PaginationElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public PaginationElementModel removeId() {
		return removeArgument("id");
	}

	public PaginationElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public PaginationElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public PaginationElementModel removeKey() {
		return removeArgument("key");
	}

	public PaginationElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public PaginationElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public PaginationElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public PaginationElementModel setPage(String value) {
		return setPage(db.newSTValue(value));
	}

	public PaginationElementModel setPage(STValue value) {
		return set(value, "page");
	}

	public STValue getPage() {
		return get("page");
	}

	public STArgument getPageArgument() {
		return getArgument("page");
	}

	public PaginationElementModel removePage() {
		return removeArgument("page");
	}

	public PaginationElementModel setRenderItem(String value) {
		return setRenderItem(db.newSTValue(value));
	}

	public PaginationElementModel setRenderItem(STValue value) {
		return set(value, "renderItem");
	}

	public STValue getRenderItem() {
		return get("renderItem");
	}

	public STArgument getRenderItemArgument() {
		return getArgument("renderItem");
	}

	public PaginationElementModel removeRenderItem() {
		return removeArgument("renderItem");
	}

	public PaginationElementModel setShape(String value) {
		return setShape(db.newSTValue(value));
	}

	public PaginationElementModel setShape(STValue value) {
		return set(value, "shape");
	}

	public STValue getShape() {
		return get("shape");
	}

	public STArgument getShapeArgument() {
		return getArgument("shape");
	}

	public PaginationElementModel removeShape() {
		return removeArgument("shape");
	}

	public PaginationElementModel setShowFirstButton(String value) {
		return setShowFirstButton(db.newSTValue(value));
	}

	public PaginationElementModel setShowFirstButton(STValue value) {
		return set(value, "showFirstButton");
	}

	public STValue getShowFirstButton() {
		return get("showFirstButton");
	}

	public STArgument getShowFirstButtonArgument() {
		return getArgument("showFirstButton");
	}

	public PaginationElementModel removeShowFirstButton() {
		return removeArgument("showFirstButton");
	}

	public PaginationElementModel setShowLastButton(String value) {
		return setShowLastButton(db.newSTValue(value));
	}

	public PaginationElementModel setShowLastButton(STValue value) {
		return set(value, "showLastButton");
	}

	public STValue getShowLastButton() {
		return get("showLastButton");
	}

	public STArgument getShowLastButtonArgument() {
		return getArgument("showLastButton");
	}

	public PaginationElementModel removeShowLastButton() {
		return removeArgument("showLastButton");
	}

	public PaginationElementModel setSiblingCount(String value) {
		return setSiblingCount(db.newSTValue(value));
	}

	public PaginationElementModel setSiblingCount(STValue value) {
		return set(value, "siblingCount");
	}

	public STValue getSiblingCount() {
		return get("siblingCount");
	}

	public STArgument getSiblingCountArgument() {
		return getArgument("siblingCount");
	}

	public PaginationElementModel removeSiblingCount() {
		return removeArgument("siblingCount");
	}

	public PaginationElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public PaginationElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public PaginationElementModel removeSize() {
		return removeArgument("size");
	}

	public PaginationElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public PaginationElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public PaginationElementModel removeStyle() {
		return removeArgument("style");
	}

	public PaginationElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public PaginationElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public PaginationElementModel removeVariant() {
		return removeArgument("variant");
	}


	public PaginationElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public PaginationElementModel addAttribute(PaginationElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public PaginationElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<PaginationElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new PaginationElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class PaginationElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public PaginationElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public PaginationElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public PaginationElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public PaginationElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public PaginationElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private PaginationElementModel_Attribute setKVValue(String name, STValue value) {

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

	private PaginationElementModel set(STValue value, String name) {
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

	private PaginationElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private PaginationElementModel add(STValue value, String name) {
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