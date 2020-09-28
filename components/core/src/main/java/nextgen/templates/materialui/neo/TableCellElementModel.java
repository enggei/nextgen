package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TableCellElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "3215878c-b9f5-48ac-9e01-058438f9fe1f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TableCellElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TableCellElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TableCellElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TableCellElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TableCellElementModel that = (TableCellElementModel) o;
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

	public TableCellElementModel setAlign(String value) {
		return setAlign(db.newSTValue(value));
	}

	public TableCellElementModel setAlign(STValue value) {
		return set(value, "align");
	}

	public STValue getAlign() {
		return get("align");
	}

	public STArgument getAlignArgument() {
		return getArgument("align");
	}

	public TableCellElementModel removeAlign() {
		return removeArgument("align");
	}

	public TableCellElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TableCellElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TableCellElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TableCellElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TableCellElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TableCellElementModel removeClassName() {
		return removeArgument("className");
	}

	public TableCellElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public TableCellElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public TableCellElementModel removeComponent() {
		return removeArgument("component");
	}

	public TableCellElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TableCellElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TableCellElementModel removeId() {
		return removeArgument("id");
	}

	public TableCellElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TableCellElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TableCellElementModel removeKey() {
		return removeArgument("key");
	}

	public TableCellElementModel setPadding(String value) {
		return setPadding(db.newSTValue(value));
	}

	public TableCellElementModel setPadding(STValue value) {
		return set(value, "padding");
	}

	public STValue getPadding() {
		return get("padding");
	}

	public STArgument getPaddingArgument() {
		return getArgument("padding");
	}

	public TableCellElementModel removePadding() {
		return removeArgument("padding");
	}

	public TableCellElementModel setScope(String value) {
		return setScope(db.newSTValue(value));
	}

	public TableCellElementModel setScope(STValue value) {
		return set(value, "scope");
	}

	public STValue getScope() {
		return get("scope");
	}

	public STArgument getScopeArgument() {
		return getArgument("scope");
	}

	public TableCellElementModel removeScope() {
		return removeArgument("scope");
	}

	public TableCellElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public TableCellElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public TableCellElementModel removeSize() {
		return removeArgument("size");
	}

	public TableCellElementModel setSortDirection(String value) {
		return setSortDirection(db.newSTValue(value));
	}

	public TableCellElementModel setSortDirection(STValue value) {
		return set(value, "sortDirection");
	}

	public STValue getSortDirection() {
		return get("sortDirection");
	}

	public STArgument getSortDirectionArgument() {
		return getArgument("sortDirection");
	}

	public TableCellElementModel removeSortDirection() {
		return removeArgument("sortDirection");
	}

	public TableCellElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TableCellElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TableCellElementModel removeStyle() {
		return removeArgument("style");
	}

	public TableCellElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public TableCellElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public TableCellElementModel removeVariant() {
		return removeArgument("variant");
	}

	public TableCellElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TableCellElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TableCellElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TableCellElementModel addAttribute(TableCellElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TableCellElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TableCellElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TableCellElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TableCellElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TableCellElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TableCellElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TableCellElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TableCellElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TableCellElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TableCellElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TableCellElementModel set(STValue value, String name) {
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

	private TableCellElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TableCellElementModel add(STValue value, String name) {
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