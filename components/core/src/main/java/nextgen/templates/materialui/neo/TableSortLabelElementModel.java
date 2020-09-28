package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TableSortLabelElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "a12fa01e-bae5-42ce-a612-865398c70a12";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TableSortLabelElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TableSortLabelElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TableSortLabelElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TableSortLabelElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TableSortLabelElementModel that = (TableSortLabelElementModel) o;
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

	public TableSortLabelElementModel setActive(String value) {
		return setActive(db.newSTValue(value));
	}

	public TableSortLabelElementModel setActive(STValue value) {
		return set(value, "active");
	}

	public STValue getActive() {
		return get("active");
	}

	public STArgument getActiveArgument() {
		return getArgument("active");
	}

	public TableSortLabelElementModel removeActive() {
		return removeArgument("active");
	}

	public TableSortLabelElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TableSortLabelElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TableSortLabelElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TableSortLabelElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TableSortLabelElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TableSortLabelElementModel removeClassName() {
		return removeArgument("className");
	}

	public TableSortLabelElementModel setDirection(String value) {
		return setDirection(db.newSTValue(value));
	}

	public TableSortLabelElementModel setDirection(STValue value) {
		return set(value, "direction");
	}

	public STValue getDirection() {
		return get("direction");
	}

	public STArgument getDirectionArgument() {
		return getArgument("direction");
	}

	public TableSortLabelElementModel removeDirection() {
		return removeArgument("direction");
	}

	public TableSortLabelElementModel setHideSortIcon(String value) {
		return setHideSortIcon(db.newSTValue(value));
	}

	public TableSortLabelElementModel setHideSortIcon(STValue value) {
		return set(value, "hideSortIcon");
	}

	public STValue getHideSortIcon() {
		return get("hideSortIcon");
	}

	public STArgument getHideSortIconArgument() {
		return getArgument("hideSortIcon");
	}

	public TableSortLabelElementModel removeHideSortIcon() {
		return removeArgument("hideSortIcon");
	}

	public TableSortLabelElementModel setIconComponent(String value) {
		return setIconComponent(db.newSTValue(value));
	}

	public TableSortLabelElementModel setIconComponent(STValue value) {
		return set(value, "IconComponent");
	}

	public STValue getIconComponent() {
		return get("IconComponent");
	}

	public STArgument getIconComponentArgument() {
		return getArgument("IconComponent");
	}

	public TableSortLabelElementModel removeIconComponent() {
		return removeArgument("IconComponent");
	}

	public TableSortLabelElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TableSortLabelElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TableSortLabelElementModel removeId() {
		return removeArgument("id");
	}

	public TableSortLabelElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TableSortLabelElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TableSortLabelElementModel removeKey() {
		return removeArgument("key");
	}

	public TableSortLabelElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TableSortLabelElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TableSortLabelElementModel removeStyle() {
		return removeArgument("style");
	}

	public TableSortLabelElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TableSortLabelElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TableSortLabelElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TableSortLabelElementModel addAttribute(TableSortLabelElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TableSortLabelElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TableSortLabelElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TableSortLabelElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TableSortLabelElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TableSortLabelElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TableSortLabelElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TableSortLabelElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TableSortLabelElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TableSortLabelElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TableSortLabelElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TableSortLabelElementModel set(STValue value, String name) {
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

	private TableSortLabelElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TableSortLabelElementModel add(STValue value, String name) {
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