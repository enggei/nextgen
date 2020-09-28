package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MenuListElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "76f08b8d-d5d9-4673-abcc-7b5d8c382782";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public MenuListElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public MenuListElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public MenuListElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public MenuListElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MenuListElementModel that = (MenuListElementModel) o;
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

	public MenuListElementModel setAutoFocus(String value) {
		return setAutoFocus(db.newSTValue(value));
	}

	public MenuListElementModel setAutoFocus(STValue value) {
		return set(value, "autoFocus");
	}

	public STValue getAutoFocus() {
		return get("autoFocus");
	}

	public STArgument getAutoFocusArgument() {
		return getArgument("autoFocus");
	}

	public MenuListElementModel removeAutoFocus() {
		return removeArgument("autoFocus");
	}

	public MenuListElementModel setAutoFocusItem(String value) {
		return setAutoFocusItem(db.newSTValue(value));
	}

	public MenuListElementModel setAutoFocusItem(STValue value) {
		return set(value, "autoFocusItem");
	}

	public STValue getAutoFocusItem() {
		return get("autoFocusItem");
	}

	public STArgument getAutoFocusItemArgument() {
		return getArgument("autoFocusItem");
	}

	public MenuListElementModel removeAutoFocusItem() {
		return removeArgument("autoFocusItem");
	}

	public MenuListElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public MenuListElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public MenuListElementModel removeClassName() {
		return removeArgument("className");
	}

	public MenuListElementModel setDisabledItemsFocusable(String value) {
		return setDisabledItemsFocusable(db.newSTValue(value));
	}

	public MenuListElementModel setDisabledItemsFocusable(STValue value) {
		return set(value, "disabledItemsFocusable");
	}

	public STValue getDisabledItemsFocusable() {
		return get("disabledItemsFocusable");
	}

	public STArgument getDisabledItemsFocusableArgument() {
		return getArgument("disabledItemsFocusable");
	}

	public MenuListElementModel removeDisabledItemsFocusable() {
		return removeArgument("disabledItemsFocusable");
	}

	public MenuListElementModel setDisableListWrap(String value) {
		return setDisableListWrap(db.newSTValue(value));
	}

	public MenuListElementModel setDisableListWrap(STValue value) {
		return set(value, "disableListWrap");
	}

	public STValue getDisableListWrap() {
		return get("disableListWrap");
	}

	public STArgument getDisableListWrapArgument() {
		return getArgument("disableListWrap");
	}

	public MenuListElementModel removeDisableListWrap() {
		return removeArgument("disableListWrap");
	}

	public MenuListElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public MenuListElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public MenuListElementModel removeId() {
		return removeArgument("id");
	}

	public MenuListElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public MenuListElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public MenuListElementModel removeKey() {
		return removeArgument("key");
	}

	public MenuListElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public MenuListElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public MenuListElementModel removeStyle() {
		return removeArgument("style");
	}

	public MenuListElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public MenuListElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public MenuListElementModel removeVariant() {
		return removeArgument("variant");
	}

	public MenuListElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public MenuListElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public MenuListElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public MenuListElementModel addAttribute(MenuListElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public MenuListElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<MenuListElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new MenuListElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class MenuListElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public MenuListElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public MenuListElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public MenuListElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public MenuListElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public MenuListElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private MenuListElementModel_Attribute setKVValue(String name, STValue value) {

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

	private MenuListElementModel set(STValue value, String name) {
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

	private MenuListElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private MenuListElementModel add(STValue value, String name) {
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