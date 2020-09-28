package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class BadgeElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "ef9a5ff5-2ae0-4299-8e13-98766500bb53";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public BadgeElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public BadgeElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public BadgeElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public BadgeElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BadgeElementModel that = (BadgeElementModel) o;
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

	public BadgeElementModel setAnchorOrigin(String value) {
		return setAnchorOrigin(db.newSTValue(value));
	}

	public BadgeElementModel setAnchorOrigin(STValue value) {
		return set(value, "anchorOrigin");
	}

	public STValue getAnchorOrigin() {
		return get("anchorOrigin");
	}

	public STArgument getAnchorOriginArgument() {
		return getArgument("anchorOrigin");
	}

	public BadgeElementModel removeAnchorOrigin() {
		return removeArgument("anchorOrigin");
	}

	public BadgeElementModel setBadgeContent(String value) {
		return setBadgeContent(db.newSTValue(value));
	}

	public BadgeElementModel setBadgeContent(STValue value) {
		return set(value, "badgeContent");
	}

	public STValue getBadgeContent() {
		return get("badgeContent");
	}

	public STArgument getBadgeContentArgument() {
		return getArgument("badgeContent");
	}

	public BadgeElementModel removeBadgeContent() {
		return removeArgument("badgeContent");
	}

	public BadgeElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public BadgeElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public BadgeElementModel removeClasses() {
		return removeArgument("classes");
	}

	public BadgeElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public BadgeElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public BadgeElementModel removeClassName() {
		return removeArgument("className");
	}

	public BadgeElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public BadgeElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public BadgeElementModel removeColor() {
		return removeArgument("color");
	}

	public BadgeElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public BadgeElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public BadgeElementModel removeComponent() {
		return removeArgument("component");
	}

	public BadgeElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public BadgeElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public BadgeElementModel removeId() {
		return removeArgument("id");
	}

	public BadgeElementModel setInvisible(String value) {
		return setInvisible(db.newSTValue(value));
	}

	public BadgeElementModel setInvisible(STValue value) {
		return set(value, "invisible");
	}

	public STValue getInvisible() {
		return get("invisible");
	}

	public STArgument getInvisibleArgument() {
		return getArgument("invisible");
	}

	public BadgeElementModel removeInvisible() {
		return removeArgument("invisible");
	}

	public BadgeElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public BadgeElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public BadgeElementModel removeKey() {
		return removeArgument("key");
	}

	public BadgeElementModel setMax(String value) {
		return setMax(db.newSTValue(value));
	}

	public BadgeElementModel setMax(STValue value) {
		return set(value, "max");
	}

	public STValue getMax() {
		return get("max");
	}

	public STArgument getMaxArgument() {
		return getArgument("max");
	}

	public BadgeElementModel removeMax() {
		return removeArgument("max");
	}

	public BadgeElementModel setOverlap(String value) {
		return setOverlap(db.newSTValue(value));
	}

	public BadgeElementModel setOverlap(STValue value) {
		return set(value, "overlap");
	}

	public STValue getOverlap() {
		return get("overlap");
	}

	public STArgument getOverlapArgument() {
		return getArgument("overlap");
	}

	public BadgeElementModel removeOverlap() {
		return removeArgument("overlap");
	}

	public BadgeElementModel setShowZero(String value) {
		return setShowZero(db.newSTValue(value));
	}

	public BadgeElementModel setShowZero(STValue value) {
		return set(value, "showZero");
	}

	public STValue getShowZero() {
		return get("showZero");
	}

	public STArgument getShowZeroArgument() {
		return getArgument("showZero");
	}

	public BadgeElementModel removeShowZero() {
		return removeArgument("showZero");
	}

	public BadgeElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public BadgeElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public BadgeElementModel removeStyle() {
		return removeArgument("style");
	}

	public BadgeElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public BadgeElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public BadgeElementModel removeVariant() {
		return removeArgument("variant");
	}

	public BadgeElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public BadgeElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public BadgeElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public BadgeElementModel addAttribute(BadgeElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public BadgeElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<BadgeElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new BadgeElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class BadgeElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public BadgeElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public BadgeElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public BadgeElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public BadgeElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public BadgeElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private BadgeElementModel_Attribute setKVValue(String name, STValue value) {

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

	private BadgeElementModel set(STValue value, String name) {
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

	private BadgeElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private BadgeElementModel add(STValue value, String name) {
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