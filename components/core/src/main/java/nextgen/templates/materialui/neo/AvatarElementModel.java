package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AvatarElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "c0a3075e-d946-4053-9566-ffd6966f95a3";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AvatarElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AvatarElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AvatarElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AvatarElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AvatarElementModel that = (AvatarElementModel) o;
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

	public AvatarElementModel setAlt(String value) {
		return setAlt(db.newSTValue(value));
	}

	public AvatarElementModel setAlt(STValue value) {
		return set(value, "alt");
	}

	public STValue getAlt() {
		return get("alt");
	}

	public STArgument getAltArgument() {
		return getArgument("alt");
	}

	public AvatarElementModel removeAlt() {
		return removeArgument("alt");
	}

	public AvatarElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public AvatarElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public AvatarElementModel removeClasses() {
		return removeArgument("classes");
	}

	public AvatarElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public AvatarElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public AvatarElementModel removeClassName() {
		return removeArgument("className");
	}

	public AvatarElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public AvatarElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public AvatarElementModel removeComponent() {
		return removeArgument("component");
	}

	public AvatarElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public AvatarElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public AvatarElementModel removeId() {
		return removeArgument("id");
	}

	public AvatarElementModel setImgProps(String value) {
		return setImgProps(db.newSTValue(value));
	}

	public AvatarElementModel setImgProps(STValue value) {
		return set(value, "imgProps");
	}

	public STValue getImgProps() {
		return get("imgProps");
	}

	public STArgument getImgPropsArgument() {
		return getArgument("imgProps");
	}

	public AvatarElementModel removeImgProps() {
		return removeArgument("imgProps");
	}

	public AvatarElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public AvatarElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public AvatarElementModel removeKey() {
		return removeArgument("key");
	}

	public AvatarElementModel setSizes(String value) {
		return setSizes(db.newSTValue(value));
	}

	public AvatarElementModel setSizes(STValue value) {
		return set(value, "sizes");
	}

	public STValue getSizes() {
		return get("sizes");
	}

	public STArgument getSizesArgument() {
		return getArgument("sizes");
	}

	public AvatarElementModel removeSizes() {
		return removeArgument("sizes");
	}

	public AvatarElementModel setSrc(String value) {
		return setSrc(db.newSTValue(value));
	}

	public AvatarElementModel setSrc(STValue value) {
		return set(value, "src");
	}

	public STValue getSrc() {
		return get("src");
	}

	public STArgument getSrcArgument() {
		return getArgument("src");
	}

	public AvatarElementModel removeSrc() {
		return removeArgument("src");
	}

	public AvatarElementModel setSrcSet(String value) {
		return setSrcSet(db.newSTValue(value));
	}

	public AvatarElementModel setSrcSet(STValue value) {
		return set(value, "srcSet");
	}

	public STValue getSrcSet() {
		return get("srcSet");
	}

	public STArgument getSrcSetArgument() {
		return getArgument("srcSet");
	}

	public AvatarElementModel removeSrcSet() {
		return removeArgument("srcSet");
	}

	public AvatarElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public AvatarElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public AvatarElementModel removeStyle() {
		return removeArgument("style");
	}

	public AvatarElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public AvatarElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public AvatarElementModel removeVariant() {
		return removeArgument("variant");
	}

	public AvatarElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public AvatarElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public AvatarElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public AvatarElementModel addAttribute(AvatarElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public AvatarElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<AvatarElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new AvatarElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class AvatarElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public AvatarElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public AvatarElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public AvatarElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public AvatarElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public AvatarElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private AvatarElementModel_Attribute setKVValue(String name, STValue value) {

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

	private AvatarElementModel set(STValue value, String name) {
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

	private AvatarElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AvatarElementModel add(STValue value, String name) {
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