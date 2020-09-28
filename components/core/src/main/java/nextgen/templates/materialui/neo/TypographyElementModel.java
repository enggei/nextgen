package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TypographyElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "d0862593-13a8-448f-8bab-8097304080be";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TypographyElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TypographyElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TypographyElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TypographyElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TypographyElementModel that = (TypographyElementModel) o;
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

	public TypographyElementModel setAlign(String value) {
		return setAlign(db.newSTValue(value));
	}

	public TypographyElementModel setAlign(STValue value) {
		return set(value, "align");
	}

	public STValue getAlign() {
		return get("align");
	}

	public STArgument getAlignArgument() {
		return getArgument("align");
	}

	public TypographyElementModel removeAlign() {
		return removeArgument("align");
	}

	public TypographyElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TypographyElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TypographyElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TypographyElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TypographyElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TypographyElementModel removeClassName() {
		return removeArgument("className");
	}

	public TypographyElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public TypographyElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public TypographyElementModel removeColor() {
		return removeArgument("color");
	}

	public TypographyElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public TypographyElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public TypographyElementModel removeComponent() {
		return removeArgument("component");
	}

	public TypographyElementModel setDisplay(String value) {
		return setDisplay(db.newSTValue(value));
	}

	public TypographyElementModel setDisplay(STValue value) {
		return set(value, "display");
	}

	public STValue getDisplay() {
		return get("display");
	}

	public STArgument getDisplayArgument() {
		return getArgument("display");
	}

	public TypographyElementModel removeDisplay() {
		return removeArgument("display");
	}

	public TypographyElementModel setGutterBottom(String value) {
		return setGutterBottom(db.newSTValue(value));
	}

	public TypographyElementModel setGutterBottom(STValue value) {
		return set(value, "gutterBottom");
	}

	public STValue getGutterBottom() {
		return get("gutterBottom");
	}

	public STArgument getGutterBottomArgument() {
		return getArgument("gutterBottom");
	}

	public TypographyElementModel removeGutterBottom() {
		return removeArgument("gutterBottom");
	}

	public TypographyElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TypographyElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TypographyElementModel removeId() {
		return removeArgument("id");
	}

	public TypographyElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TypographyElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TypographyElementModel removeKey() {
		return removeArgument("key");
	}

	public TypographyElementModel setNoWrap(String value) {
		return setNoWrap(db.newSTValue(value));
	}

	public TypographyElementModel setNoWrap(STValue value) {
		return set(value, "noWrap");
	}

	public STValue getNoWrap() {
		return get("noWrap");
	}

	public STArgument getNoWrapArgument() {
		return getArgument("noWrap");
	}

	public TypographyElementModel removeNoWrap() {
		return removeArgument("noWrap");
	}

	public TypographyElementModel setParagraph(String value) {
		return setParagraph(db.newSTValue(value));
	}

	public TypographyElementModel setParagraph(STValue value) {
		return set(value, "paragraph");
	}

	public STValue getParagraph() {
		return get("paragraph");
	}

	public STArgument getParagraphArgument() {
		return getArgument("paragraph");
	}

	public TypographyElementModel removeParagraph() {
		return removeArgument("paragraph");
	}

	public TypographyElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TypographyElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TypographyElementModel removeStyle() {
		return removeArgument("style");
	}

	public TypographyElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public TypographyElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public TypographyElementModel removeVariant() {
		return removeArgument("variant");
	}

	public TypographyElementModel setVariantMapping(String value) {
		return setVariantMapping(db.newSTValue(value));
	}

	public TypographyElementModel setVariantMapping(STValue value) {
		return set(value, "variantMapping");
	}

	public STValue getVariantMapping() {
		return get("variantMapping");
	}

	public STArgument getVariantMappingArgument() {
		return getArgument("variantMapping");
	}

	public TypographyElementModel removeVariantMapping() {
		return removeArgument("variantMapping");
	}

	public TypographyElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TypographyElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TypographyElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TypographyElementModel addAttribute(TypographyElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TypographyElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TypographyElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TypographyElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TypographyElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TypographyElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TypographyElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TypographyElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TypographyElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TypographyElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TypographyElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TypographyElementModel set(STValue value, String name) {
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

	private TypographyElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TypographyElementModel add(STValue value, String name) {
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