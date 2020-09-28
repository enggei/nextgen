package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TreeViewElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "03bf8934-b403-47ff-af77-a7e1abcf4783";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TreeViewElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TreeViewElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TreeViewElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TreeViewElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeViewElementModel that = (TreeViewElementModel) o;
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

	public TreeViewElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TreeViewElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TreeViewElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TreeViewElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TreeViewElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TreeViewElementModel removeClassName() {
		return removeArgument("className");
	}

	public TreeViewElementModel setDefaultCollapseIcon(String value) {
		return setDefaultCollapseIcon(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultCollapseIcon(STValue value) {
		return set(value, "defaultCollapseIcon");
	}

	public STValue getDefaultCollapseIcon() {
		return get("defaultCollapseIcon");
	}

	public STArgument getDefaultCollapseIconArgument() {
		return getArgument("defaultCollapseIcon");
	}

	public TreeViewElementModel removeDefaultCollapseIcon() {
		return removeArgument("defaultCollapseIcon");
	}

	public TreeViewElementModel setDefaultEndIcon(String value) {
		return setDefaultEndIcon(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultEndIcon(STValue value) {
		return set(value, "defaultEndIcon");
	}

	public STValue getDefaultEndIcon() {
		return get("defaultEndIcon");
	}

	public STArgument getDefaultEndIconArgument() {
		return getArgument("defaultEndIcon");
	}

	public TreeViewElementModel removeDefaultEndIcon() {
		return removeArgument("defaultEndIcon");
	}

	public TreeViewElementModel setDefaultExpanded(String value) {
		return setDefaultExpanded(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultExpanded(STValue value) {
		return set(value, "defaultExpanded");
	}

	public STValue getDefaultExpanded() {
		return get("defaultExpanded");
	}

	public STArgument getDefaultExpandedArgument() {
		return getArgument("defaultExpanded");
	}

	public TreeViewElementModel removeDefaultExpanded() {
		return removeArgument("defaultExpanded");
	}

	public TreeViewElementModel setDefaultExpandIcon(String value) {
		return setDefaultExpandIcon(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultExpandIcon(STValue value) {
		return set(value, "defaultExpandIcon");
	}

	public STValue getDefaultExpandIcon() {
		return get("defaultExpandIcon");
	}

	public STArgument getDefaultExpandIconArgument() {
		return getArgument("defaultExpandIcon");
	}

	public TreeViewElementModel removeDefaultExpandIcon() {
		return removeArgument("defaultExpandIcon");
	}

	public TreeViewElementModel setDefaultParentIcon(String value) {
		return setDefaultParentIcon(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultParentIcon(STValue value) {
		return set(value, "defaultParentIcon");
	}

	public STValue getDefaultParentIcon() {
		return get("defaultParentIcon");
	}

	public STArgument getDefaultParentIconArgument() {
		return getArgument("defaultParentIcon");
	}

	public TreeViewElementModel removeDefaultParentIcon() {
		return removeArgument("defaultParentIcon");
	}

	public TreeViewElementModel setDefaultSelected(String value) {
		return setDefaultSelected(db.newSTValue(value));
	}

	public TreeViewElementModel setDefaultSelected(STValue value) {
		return set(value, "defaultSelected");
	}

	public STValue getDefaultSelected() {
		return get("defaultSelected");
	}

	public STArgument getDefaultSelectedArgument() {
		return getArgument("defaultSelected");
	}

	public TreeViewElementModel removeDefaultSelected() {
		return removeArgument("defaultSelected");
	}

	public TreeViewElementModel setDisableSelection(String value) {
		return setDisableSelection(db.newSTValue(value));
	}

	public TreeViewElementModel setDisableSelection(STValue value) {
		return set(value, "disableSelection");
	}

	public STValue getDisableSelection() {
		return get("disableSelection");
	}

	public STArgument getDisableSelectionArgument() {
		return getArgument("disableSelection");
	}

	public TreeViewElementModel removeDisableSelection() {
		return removeArgument("disableSelection");
	}

	public TreeViewElementModel setExpanded(String value) {
		return setExpanded(db.newSTValue(value));
	}

	public TreeViewElementModel setExpanded(STValue value) {
		return set(value, "expanded");
	}

	public STValue getExpanded() {
		return get("expanded");
	}

	public STArgument getExpandedArgument() {
		return getArgument("expanded");
	}

	public TreeViewElementModel removeExpanded() {
		return removeArgument("expanded");
	}

	public TreeViewElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TreeViewElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TreeViewElementModel removeId() {
		return removeArgument("id");
	}

	public TreeViewElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TreeViewElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TreeViewElementModel removeKey() {
		return removeArgument("key");
	}

	public TreeViewElementModel setMultiSelect(String value) {
		return setMultiSelect(db.newSTValue(value));
	}

	public TreeViewElementModel setMultiSelect(STValue value) {
		return set(value, "multiSelect");
	}

	public STValue getMultiSelect() {
		return get("multiSelect");
	}

	public STArgument getMultiSelectArgument() {
		return getArgument("multiSelect");
	}

	public TreeViewElementModel removeMultiSelect() {
		return removeArgument("multiSelect");
	}

	public TreeViewElementModel setOnNodeSelect(String value) {
		return setOnNodeSelect(db.newSTValue(value));
	}

	public TreeViewElementModel setOnNodeSelect(STValue value) {
		return set(value, "onNodeSelect");
	}

	public STValue getOnNodeSelect() {
		return get("onNodeSelect");
	}

	public STArgument getOnNodeSelectArgument() {
		return getArgument("onNodeSelect");
	}

	public TreeViewElementModel removeOnNodeSelect() {
		return removeArgument("onNodeSelect");
	}

	public TreeViewElementModel setOnNodeToggle(String value) {
		return setOnNodeToggle(db.newSTValue(value));
	}

	public TreeViewElementModel setOnNodeToggle(STValue value) {
		return set(value, "onNodeToggle");
	}

	public STValue getOnNodeToggle() {
		return get("onNodeToggle");
	}

	public STArgument getOnNodeToggleArgument() {
		return getArgument("onNodeToggle");
	}

	public TreeViewElementModel removeOnNodeToggle() {
		return removeArgument("onNodeToggle");
	}

	public TreeViewElementModel setSelected(String value) {
		return setSelected(db.newSTValue(value));
	}

	public TreeViewElementModel setSelected(STValue value) {
		return set(value, "selected");
	}

	public STValue getSelected() {
		return get("selected");
	}

	public STArgument getSelectedArgument() {
		return getArgument("selected");
	}

	public TreeViewElementModel removeSelected() {
		return removeArgument("selected");
	}

	public TreeViewElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TreeViewElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TreeViewElementModel removeStyle() {
		return removeArgument("style");
	}

	public TreeViewElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TreeViewElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TreeViewElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TreeViewElementModel addAttribute(TreeViewElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TreeViewElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TreeViewElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TreeViewElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TreeViewElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TreeViewElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TreeViewElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TreeViewElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TreeViewElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TreeViewElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TreeViewElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TreeViewElementModel set(STValue value, String name) {
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

	private TreeViewElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TreeViewElementModel add(STValue value, String name) {
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