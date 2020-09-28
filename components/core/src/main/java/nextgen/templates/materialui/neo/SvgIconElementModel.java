package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SvgIconElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "cf5242ba-a260-4258-a859-792075656ead";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SvgIconElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SvgIconElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SvgIconElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SvgIconElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SvgIconElementModel that = (SvgIconElementModel) o;
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

	public SvgIconElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SvgIconElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SvgIconElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SvgIconElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SvgIconElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SvgIconElementModel removeClassName() {
		return removeArgument("className");
	}

	public SvgIconElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public SvgIconElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public SvgIconElementModel removeColor() {
		return removeArgument("color");
	}

	public SvgIconElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public SvgIconElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public SvgIconElementModel removeComponent() {
		return removeArgument("component");
	}

	public SvgIconElementModel setFontSize(String value) {
		return setFontSize(db.newSTValue(value));
	}

	public SvgIconElementModel setFontSize(STValue value) {
		return set(value, "fontSize");
	}

	public STValue getFontSize() {
		return get("fontSize");
	}

	public STArgument getFontSizeArgument() {
		return getArgument("fontSize");
	}

	public SvgIconElementModel removeFontSize() {
		return removeArgument("fontSize");
	}

	public SvgIconElementModel setHtmlColor(String value) {
		return setHtmlColor(db.newSTValue(value));
	}

	public SvgIconElementModel setHtmlColor(STValue value) {
		return set(value, "htmlColor");
	}

	public STValue getHtmlColor() {
		return get("htmlColor");
	}

	public STArgument getHtmlColorArgument() {
		return getArgument("htmlColor");
	}

	public SvgIconElementModel removeHtmlColor() {
		return removeArgument("htmlColor");
	}

	public SvgIconElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SvgIconElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SvgIconElementModel removeId() {
		return removeArgument("id");
	}

	public SvgIconElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SvgIconElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SvgIconElementModel removeKey() {
		return removeArgument("key");
	}

	public SvgIconElementModel setShapeRendering(String value) {
		return setShapeRendering(db.newSTValue(value));
	}

	public SvgIconElementModel setShapeRendering(STValue value) {
		return set(value, "shapeRendering");
	}

	public STValue getShapeRendering() {
		return get("shapeRendering");
	}

	public STArgument getShapeRenderingArgument() {
		return getArgument("shapeRendering");
	}

	public SvgIconElementModel removeShapeRendering() {
		return removeArgument("shapeRendering");
	}

	public SvgIconElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SvgIconElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SvgIconElementModel removeStyle() {
		return removeArgument("style");
	}

	public SvgIconElementModel setTitleAccess(String value) {
		return setTitleAccess(db.newSTValue(value));
	}

	public SvgIconElementModel setTitleAccess(STValue value) {
		return set(value, "titleAccess");
	}

	public STValue getTitleAccess() {
		return get("titleAccess");
	}

	public STArgument getTitleAccessArgument() {
		return getArgument("titleAccess");
	}

	public SvgIconElementModel removeTitleAccess() {
		return removeArgument("titleAccess");
	}

	public SvgIconElementModel setViewBox(String value) {
		return setViewBox(db.newSTValue(value));
	}

	public SvgIconElementModel setViewBox(STValue value) {
		return set(value, "viewBox");
	}

	public STValue getViewBox() {
		return get("viewBox");
	}

	public STArgument getViewBoxArgument() {
		return getArgument("viewBox");
	}

	public SvgIconElementModel removeViewBox() {
		return removeArgument("viewBox");
	}

	public SvgIconElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SvgIconElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SvgIconElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SvgIconElementModel addAttribute(SvgIconElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SvgIconElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SvgIconElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SvgIconElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SvgIconElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SvgIconElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SvgIconElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SvgIconElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SvgIconElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SvgIconElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SvgIconElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SvgIconElementModel set(STValue value, String name) {
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

	private SvgIconElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SvgIconElementModel add(STValue value, String name) {
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