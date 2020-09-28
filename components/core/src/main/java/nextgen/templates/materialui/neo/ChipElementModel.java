package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ChipElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "ab436957-a0dc-41b7-8b04-dc7bcc861db9";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ChipElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ChipElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ChipElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ChipElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChipElementModel that = (ChipElementModel) o;
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

	public ChipElementModel setAvatar(String value) {
		return setAvatar(db.newSTValue(value));
	}

	public ChipElementModel setAvatar(STValue value) {
		return set(value, "avatar");
	}

	public STValue getAvatar() {
		return get("avatar");
	}

	public STArgument getAvatarArgument() {
		return getArgument("avatar");
	}

	public ChipElementModel removeAvatar() {
		return removeArgument("avatar");
	}

	public ChipElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ChipElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ChipElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ChipElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ChipElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ChipElementModel removeClassName() {
		return removeArgument("className");
	}

	public ChipElementModel setClickable(String value) {
		return setClickable(db.newSTValue(value));
	}

	public ChipElementModel setClickable(STValue value) {
		return set(value, "clickable");
	}

	public STValue getClickable() {
		return get("clickable");
	}

	public STArgument getClickableArgument() {
		return getArgument("clickable");
	}

	public ChipElementModel removeClickable() {
		return removeArgument("clickable");
	}

	public ChipElementModel setColor(String value) {
		return setColor(db.newSTValue(value));
	}

	public ChipElementModel setColor(STValue value) {
		return set(value, "color");
	}

	public STValue getColor() {
		return get("color");
	}

	public STArgument getColorArgument() {
		return getArgument("color");
	}

	public ChipElementModel removeColor() {
		return removeArgument("color");
	}

	public ChipElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public ChipElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public ChipElementModel removeComponent() {
		return removeArgument("component");
	}

	public ChipElementModel setDeleteIcon(String value) {
		return setDeleteIcon(db.newSTValue(value));
	}

	public ChipElementModel setDeleteIcon(STValue value) {
		return set(value, "deleteIcon");
	}

	public STValue getDeleteIcon() {
		return get("deleteIcon");
	}

	public STArgument getDeleteIconArgument() {
		return getArgument("deleteIcon");
	}

	public ChipElementModel removeDeleteIcon() {
		return removeArgument("deleteIcon");
	}

	public ChipElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ChipElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ChipElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ChipElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public ChipElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public ChipElementModel removeIcon() {
		return removeArgument("icon");
	}

	public ChipElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ChipElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ChipElementModel removeId() {
		return removeArgument("id");
	}

	public ChipElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ChipElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ChipElementModel removeKey() {
		return removeArgument("key");
	}

	public ChipElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public ChipElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public ChipElementModel removeLabel() {
		return removeArgument("label");
	}

	public ChipElementModel setOnDelete(String value) {
		return setOnDelete(db.newSTValue(value));
	}

	public ChipElementModel setOnDelete(STValue value) {
		return set(value, "onDelete");
	}

	public STValue getOnDelete() {
		return get("onDelete");
	}

	public STArgument getOnDeleteArgument() {
		return getArgument("onDelete");
	}

	public ChipElementModel removeOnDelete() {
		return removeArgument("onDelete");
	}

	public ChipElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public ChipElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public ChipElementModel removeSize() {
		return removeArgument("size");
	}

	public ChipElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ChipElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ChipElementModel removeStyle() {
		return removeArgument("style");
	}

	public ChipElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public ChipElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public ChipElementModel removeVariant() {
		return removeArgument("variant");
	}

	public ChipElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ChipElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ChipElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ChipElementModel addAttribute(ChipElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ChipElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ChipElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ChipElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ChipElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ChipElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ChipElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ChipElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ChipElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ChipElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ChipElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ChipElementModel set(STValue value, String name) {
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

	private ChipElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ChipElementModel add(STValue value, String name) {
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