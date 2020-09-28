package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SkeletonElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "927cb9b1-6404-46d3-b95e-b326f0ca50f3";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SkeletonElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SkeletonElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SkeletonElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SkeletonElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SkeletonElementModel that = (SkeletonElementModel) o;
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

	public SkeletonElementModel setAnimation(String value) {
		return setAnimation(db.newSTValue(value));
	}

	public SkeletonElementModel setAnimation(STValue value) {
		return set(value, "animation");
	}

	public STValue getAnimation() {
		return get("animation");
	}

	public STArgument getAnimationArgument() {
		return getArgument("animation");
	}

	public SkeletonElementModel removeAnimation() {
		return removeArgument("animation");
	}

	public SkeletonElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public SkeletonElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public SkeletonElementModel removeClasses() {
		return removeArgument("classes");
	}

	public SkeletonElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public SkeletonElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public SkeletonElementModel removeClassName() {
		return removeArgument("className");
	}

	public SkeletonElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public SkeletonElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public SkeletonElementModel removeComponent() {
		return removeArgument("component");
	}

	public SkeletonElementModel setHeight(String value) {
		return setHeight(db.newSTValue(value));
	}

	public SkeletonElementModel setHeight(STValue value) {
		return set(value, "height");
	}

	public STValue getHeight() {
		return get("height");
	}

	public STArgument getHeightArgument() {
		return getArgument("height");
	}

	public SkeletonElementModel removeHeight() {
		return removeArgument("height");
	}

	public SkeletonElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public SkeletonElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public SkeletonElementModel removeId() {
		return removeArgument("id");
	}

	public SkeletonElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public SkeletonElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public SkeletonElementModel removeKey() {
		return removeArgument("key");
	}

	public SkeletonElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public SkeletonElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public SkeletonElementModel removeStyle() {
		return removeArgument("style");
	}

	public SkeletonElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public SkeletonElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public SkeletonElementModel removeVariant() {
		return removeArgument("variant");
	}

	public SkeletonElementModel setWidth(String value) {
		return setWidth(db.newSTValue(value));
	}

	public SkeletonElementModel setWidth(STValue value) {
		return set(value, "width");
	}

	public STValue getWidth() {
		return get("width");
	}

	public STArgument getWidthArgument() {
		return getArgument("width");
	}

	public SkeletonElementModel removeWidth() {
		return removeArgument("width");
	}

	public SkeletonElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public SkeletonElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public SkeletonElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public SkeletonElementModel addAttribute(SkeletonElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public SkeletonElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<SkeletonElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new SkeletonElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class SkeletonElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public SkeletonElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public SkeletonElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public SkeletonElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public SkeletonElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public SkeletonElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private SkeletonElementModel_Attribute setKVValue(String name, STValue value) {

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

	private SkeletonElementModel set(STValue value, String name) {
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

	private SkeletonElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SkeletonElementModel add(STValue value, String name) {
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