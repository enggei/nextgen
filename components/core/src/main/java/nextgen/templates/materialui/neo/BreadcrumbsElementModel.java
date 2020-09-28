package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class BreadcrumbsElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "5e9d1aad-0201-467f-9d1d-1cea2c532dac";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public BreadcrumbsElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public BreadcrumbsElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public BreadcrumbsElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public BreadcrumbsElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BreadcrumbsElementModel that = (BreadcrumbsElementModel) o;
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

	public BreadcrumbsElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public BreadcrumbsElementModel removeClasses() {
		return removeArgument("classes");
	}

	public BreadcrumbsElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public BreadcrumbsElementModel removeClassName() {
		return removeArgument("className");
	}

	public BreadcrumbsElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public BreadcrumbsElementModel removeComponent() {
		return removeArgument("component");
	}

	public BreadcrumbsElementModel setExpandText(String value) {
		return setExpandText(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setExpandText(STValue value) {
		return set(value, "expandText");
	}

	public STValue getExpandText() {
		return get("expandText");
	}

	public STArgument getExpandTextArgument() {
		return getArgument("expandText");
	}

	public BreadcrumbsElementModel removeExpandText() {
		return removeArgument("expandText");
	}

	public BreadcrumbsElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public BreadcrumbsElementModel removeId() {
		return removeArgument("id");
	}

	public BreadcrumbsElementModel setItemsAfterCollapse(String value) {
		return setItemsAfterCollapse(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setItemsAfterCollapse(STValue value) {
		return set(value, "itemsAfterCollapse");
	}

	public STValue getItemsAfterCollapse() {
		return get("itemsAfterCollapse");
	}

	public STArgument getItemsAfterCollapseArgument() {
		return getArgument("itemsAfterCollapse");
	}

	public BreadcrumbsElementModel removeItemsAfterCollapse() {
		return removeArgument("itemsAfterCollapse");
	}

	public BreadcrumbsElementModel setItemsBeforeCollapse(String value) {
		return setItemsBeforeCollapse(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setItemsBeforeCollapse(STValue value) {
		return set(value, "itemsBeforeCollapse");
	}

	public STValue getItemsBeforeCollapse() {
		return get("itemsBeforeCollapse");
	}

	public STArgument getItemsBeforeCollapseArgument() {
		return getArgument("itemsBeforeCollapse");
	}

	public BreadcrumbsElementModel removeItemsBeforeCollapse() {
		return removeArgument("itemsBeforeCollapse");
	}

	public BreadcrumbsElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public BreadcrumbsElementModel removeKey() {
		return removeArgument("key");
	}

	public BreadcrumbsElementModel setMaxItems(String value) {
		return setMaxItems(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setMaxItems(STValue value) {
		return set(value, "maxItems");
	}

	public STValue getMaxItems() {
		return get("maxItems");
	}

	public STArgument getMaxItemsArgument() {
		return getArgument("maxItems");
	}

	public BreadcrumbsElementModel removeMaxItems() {
		return removeArgument("maxItems");
	}

	public BreadcrumbsElementModel setSeparator(String value) {
		return setSeparator(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setSeparator(STValue value) {
		return set(value, "separator");
	}

	public STValue getSeparator() {
		return get("separator");
	}

	public STArgument getSeparatorArgument() {
		return getArgument("separator");
	}

	public BreadcrumbsElementModel removeSeparator() {
		return removeArgument("separator");
	}

	public BreadcrumbsElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public BreadcrumbsElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public BreadcrumbsElementModel removeStyle() {
		return removeArgument("style");
	}

	public BreadcrumbsElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public BreadcrumbsElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public BreadcrumbsElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public BreadcrumbsElementModel addAttribute(BreadcrumbsElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public BreadcrumbsElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<BreadcrumbsElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new BreadcrumbsElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class BreadcrumbsElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public BreadcrumbsElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public BreadcrumbsElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public BreadcrumbsElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public BreadcrumbsElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public BreadcrumbsElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private BreadcrumbsElementModel_Attribute setKVValue(String name, STValue value) {

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

	private BreadcrumbsElementModel set(STValue value, String name) {
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

	private BreadcrumbsElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private BreadcrumbsElementModel add(STValue value, String name) {
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