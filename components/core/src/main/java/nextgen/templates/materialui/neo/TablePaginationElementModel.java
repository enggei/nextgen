package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TablePaginationElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "0251ed3d-f039-4a2a-b3db-bfa516ff0acf";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TablePaginationElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TablePaginationElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TablePaginationElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TablePaginationElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TablePaginationElementModel that = (TablePaginationElementModel) o;
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

	public TablePaginationElementModel setActionsComponent(String value) {
		return setActionsComponent(db.newSTValue(value));
	}

	public TablePaginationElementModel setActionsComponent(STValue value) {
		return set(value, "ActionsComponent");
	}

	public STValue getActionsComponent() {
		return get("ActionsComponent");
	}

	public STArgument getActionsComponentArgument() {
		return getArgument("ActionsComponent");
	}

	public TablePaginationElementModel removeActionsComponent() {
		return removeArgument("ActionsComponent");
	}

	public TablePaginationElementModel setBackIconButtonProps(String value) {
		return setBackIconButtonProps(db.newSTValue(value));
	}

	public TablePaginationElementModel setBackIconButtonProps(STValue value) {
		return set(value, "backIconButtonProps");
	}

	public STValue getBackIconButtonProps() {
		return get("backIconButtonProps");
	}

	public STArgument getBackIconButtonPropsArgument() {
		return getArgument("backIconButtonProps");
	}

	public TablePaginationElementModel removeBackIconButtonProps() {
		return removeArgument("backIconButtonProps");
	}

	public TablePaginationElementModel setBackIconButtonText(String value) {
		return setBackIconButtonText(db.newSTValue(value));
	}

	public TablePaginationElementModel setBackIconButtonText(STValue value) {
		return set(value, "backIconButtonText");
	}

	public STValue getBackIconButtonText() {
		return get("backIconButtonText");
	}

	public STArgument getBackIconButtonTextArgument() {
		return getArgument("backIconButtonText");
	}

	public TablePaginationElementModel removeBackIconButtonText() {
		return removeArgument("backIconButtonText");
	}

	public TablePaginationElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TablePaginationElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TablePaginationElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TablePaginationElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TablePaginationElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TablePaginationElementModel removeClassName() {
		return removeArgument("className");
	}

	public TablePaginationElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public TablePaginationElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public TablePaginationElementModel removeComponent() {
		return removeArgument("component");
	}

	public TablePaginationElementModel setCount(String value) {
		return setCount(db.newSTValue(value));
	}

	public TablePaginationElementModel setCount(STValue value) {
		return set(value, "count");
	}

	public STValue getCount() {
		return get("count");
	}

	public STArgument getCountArgument() {
		return getArgument("count");
	}

	public TablePaginationElementModel removeCount() {
		return removeArgument("count");
	}

	public TablePaginationElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TablePaginationElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TablePaginationElementModel removeId() {
		return removeArgument("id");
	}

	public TablePaginationElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TablePaginationElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TablePaginationElementModel removeKey() {
		return removeArgument("key");
	}

	public TablePaginationElementModel setLabelDisplayedRows(String value) {
		return setLabelDisplayedRows(db.newSTValue(value));
	}

	public TablePaginationElementModel setLabelDisplayedRows(STValue value) {
		return set(value, "labelDisplayedRows");
	}

	public STValue getLabelDisplayedRows() {
		return get("labelDisplayedRows");
	}

	public STArgument getLabelDisplayedRowsArgument() {
		return getArgument("labelDisplayedRows");
	}

	public TablePaginationElementModel removeLabelDisplayedRows() {
		return removeArgument("labelDisplayedRows");
	}

	public TablePaginationElementModel setLabelRowsPerPage(String value) {
		return setLabelRowsPerPage(db.newSTValue(value));
	}

	public TablePaginationElementModel setLabelRowsPerPage(STValue value) {
		return set(value, "labelRowsPerPage");
	}

	public STValue getLabelRowsPerPage() {
		return get("labelRowsPerPage");
	}

	public STArgument getLabelRowsPerPageArgument() {
		return getArgument("labelRowsPerPage");
	}

	public TablePaginationElementModel removeLabelRowsPerPage() {
		return removeArgument("labelRowsPerPage");
	}

	public TablePaginationElementModel setNextIconButtonProps(String value) {
		return setNextIconButtonProps(db.newSTValue(value));
	}

	public TablePaginationElementModel setNextIconButtonProps(STValue value) {
		return set(value, "nextIconButtonProps");
	}

	public STValue getNextIconButtonProps() {
		return get("nextIconButtonProps");
	}

	public STArgument getNextIconButtonPropsArgument() {
		return getArgument("nextIconButtonProps");
	}

	public TablePaginationElementModel removeNextIconButtonProps() {
		return removeArgument("nextIconButtonProps");
	}

	public TablePaginationElementModel setNextIconButtonText(String value) {
		return setNextIconButtonText(db.newSTValue(value));
	}

	public TablePaginationElementModel setNextIconButtonText(STValue value) {
		return set(value, "nextIconButtonText");
	}

	public STValue getNextIconButtonText() {
		return get("nextIconButtonText");
	}

	public STArgument getNextIconButtonTextArgument() {
		return getArgument("nextIconButtonText");
	}

	public TablePaginationElementModel removeNextIconButtonText() {
		return removeArgument("nextIconButtonText");
	}

	public TablePaginationElementModel setOnChangePage(String value) {
		return setOnChangePage(db.newSTValue(value));
	}

	public TablePaginationElementModel setOnChangePage(STValue value) {
		return set(value, "onChangePage");
	}

	public STValue getOnChangePage() {
		return get("onChangePage");
	}

	public STArgument getOnChangePageArgument() {
		return getArgument("onChangePage");
	}

	public TablePaginationElementModel removeOnChangePage() {
		return removeArgument("onChangePage");
	}

	public TablePaginationElementModel setOnChangeRowsPerPage(String value) {
		return setOnChangeRowsPerPage(db.newSTValue(value));
	}

	public TablePaginationElementModel setOnChangeRowsPerPage(STValue value) {
		return set(value, "onChangeRowsPerPage");
	}

	public STValue getOnChangeRowsPerPage() {
		return get("onChangeRowsPerPage");
	}

	public STArgument getOnChangeRowsPerPageArgument() {
		return getArgument("onChangeRowsPerPage");
	}

	public TablePaginationElementModel removeOnChangeRowsPerPage() {
		return removeArgument("onChangeRowsPerPage");
	}

	public TablePaginationElementModel setPage(String value) {
		return setPage(db.newSTValue(value));
	}

	public TablePaginationElementModel setPage(STValue value) {
		return set(value, "page");
	}

	public STValue getPage() {
		return get("page");
	}

	public STArgument getPageArgument() {
		return getArgument("page");
	}

	public TablePaginationElementModel removePage() {
		return removeArgument("page");
	}

	public TablePaginationElementModel setRowsPerPage(String value) {
		return setRowsPerPage(db.newSTValue(value));
	}

	public TablePaginationElementModel setRowsPerPage(STValue value) {
		return set(value, "rowsPerPage");
	}

	public STValue getRowsPerPage() {
		return get("rowsPerPage");
	}

	public STArgument getRowsPerPageArgument() {
		return getArgument("rowsPerPage");
	}

	public TablePaginationElementModel removeRowsPerPage() {
		return removeArgument("rowsPerPage");
	}

	public TablePaginationElementModel setRowsPerPageOptions(String value) {
		return setRowsPerPageOptions(db.newSTValue(value));
	}

	public TablePaginationElementModel setRowsPerPageOptions(STValue value) {
		return set(value, "rowsPerPageOptions");
	}

	public STValue getRowsPerPageOptions() {
		return get("rowsPerPageOptions");
	}

	public STArgument getRowsPerPageOptionsArgument() {
		return getArgument("rowsPerPageOptions");
	}

	public TablePaginationElementModel removeRowsPerPageOptions() {
		return removeArgument("rowsPerPageOptions");
	}

	public TablePaginationElementModel setSelectProps(String value) {
		return setSelectProps(db.newSTValue(value));
	}

	public TablePaginationElementModel setSelectProps(STValue value) {
		return set(value, "SelectProps");
	}

	public STValue getSelectProps() {
		return get("SelectProps");
	}

	public STArgument getSelectPropsArgument() {
		return getArgument("SelectProps");
	}

	public TablePaginationElementModel removeSelectProps() {
		return removeArgument("SelectProps");
	}

	public TablePaginationElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TablePaginationElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TablePaginationElementModel removeStyle() {
		return removeArgument("style");
	}


	public TablePaginationElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TablePaginationElementModel addAttribute(TablePaginationElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TablePaginationElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TablePaginationElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TablePaginationElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TablePaginationElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TablePaginationElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TablePaginationElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TablePaginationElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TablePaginationElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TablePaginationElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TablePaginationElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TablePaginationElementModel set(STValue value, String name) {
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

	private TablePaginationElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TablePaginationElementModel add(STValue value, String name) {
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