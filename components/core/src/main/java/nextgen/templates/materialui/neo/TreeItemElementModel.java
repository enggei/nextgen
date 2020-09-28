package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TreeItemElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "f196be82-b3fd-4c15-ac09-62b2f38b6a5e";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TreeItemElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TreeItemElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TreeItemElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TreeItemElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeItemElementModel that = (TreeItemElementModel) o;
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

	public TreeItemElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TreeItemElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TreeItemElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TreeItemElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TreeItemElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TreeItemElementModel removeClassName() {
		return removeArgument("className");
	}

	public TreeItemElementModel setCollapseIcon(String value) {
		return setCollapseIcon(db.newSTValue(value));
	}

	public TreeItemElementModel setCollapseIcon(STValue value) {
		return set(value, "collapseIcon");
	}

	public STValue getCollapseIcon() {
		return get("collapseIcon");
	}

	public STArgument getCollapseIconArgument() {
		return getArgument("collapseIcon");
	}

	public TreeItemElementModel removeCollapseIcon() {
		return removeArgument("collapseIcon");
	}

	public TreeItemElementModel setEndIcon(String value) {
		return setEndIcon(db.newSTValue(value));
	}

	public TreeItemElementModel setEndIcon(STValue value) {
		return set(value, "endIcon");
	}

	public STValue getEndIcon() {
		return get("endIcon");
	}

	public STArgument getEndIconArgument() {
		return getArgument("endIcon");
	}

	public TreeItemElementModel removeEndIcon() {
		return removeArgument("endIcon");
	}

	public TreeItemElementModel setExpandIcon(String value) {
		return setExpandIcon(db.newSTValue(value));
	}

	public TreeItemElementModel setExpandIcon(STValue value) {
		return set(value, "expandIcon");
	}

	public STValue getExpandIcon() {
		return get("expandIcon");
	}

	public STArgument getExpandIconArgument() {
		return getArgument("expandIcon");
	}

	public TreeItemElementModel removeExpandIcon() {
		return removeArgument("expandIcon");
	}

	public TreeItemElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public TreeItemElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public TreeItemElementModel removeIcon() {
		return removeArgument("icon");
	}

	public TreeItemElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TreeItemElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TreeItemElementModel removeId() {
		return removeArgument("id");
	}

	public TreeItemElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TreeItemElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TreeItemElementModel removeKey() {
		return removeArgument("key");
	}

	public TreeItemElementModel setLabel(String value) {
		return setLabel(db.newSTValue(value));
	}

	public TreeItemElementModel setLabel(STValue value) {
		return set(value, "label");
	}

	public STValue getLabel() {
		return get("label");
	}

	public STArgument getLabelArgument() {
		return getArgument("label");
	}

	public TreeItemElementModel removeLabel() {
		return removeArgument("label");
	}

	public TreeItemElementModel setNodeId(String value) {
		return setNodeId(db.newSTValue(value));
	}

	public TreeItemElementModel setNodeId(STValue value) {
		return set(value, "nodeId");
	}

	public STValue getNodeId() {
		return get("nodeId");
	}

	public STArgument getNodeIdArgument() {
		return getArgument("nodeId");
	}

	public TreeItemElementModel removeNodeId() {
		return removeArgument("nodeId");
	}

	public TreeItemElementModel setOnIconClick(String value) {
		return setOnIconClick(db.newSTValue(value));
	}

	public TreeItemElementModel setOnIconClick(STValue value) {
		return set(value, "onIconClick");
	}

	public STValue getOnIconClick() {
		return get("onIconClick");
	}

	public STArgument getOnIconClickArgument() {
		return getArgument("onIconClick");
	}

	public TreeItemElementModel removeOnIconClick() {
		return removeArgument("onIconClick");
	}

	public TreeItemElementModel setOnLabelClick(String value) {
		return setOnLabelClick(db.newSTValue(value));
	}

	public TreeItemElementModel setOnLabelClick(STValue value) {
		return set(value, "onLabelClick");
	}

	public STValue getOnLabelClick() {
		return get("onLabelClick");
	}

	public STArgument getOnLabelClickArgument() {
		return getArgument("onLabelClick");
	}

	public TreeItemElementModel removeOnLabelClick() {
		return removeArgument("onLabelClick");
	}

	public TreeItemElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TreeItemElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TreeItemElementModel removeStyle() {
		return removeArgument("style");
	}

	public TreeItemElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public TreeItemElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public TreeItemElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public TreeItemElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public TreeItemElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public TreeItemElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public TreeItemElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TreeItemElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TreeItemElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TreeItemElementModel addAttribute(TreeItemElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TreeItemElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TreeItemElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TreeItemElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TreeItemElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TreeItemElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TreeItemElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TreeItemElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TreeItemElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TreeItemElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TreeItemElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TreeItemElementModel set(STValue value, String name) {
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

	private TreeItemElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TreeItemElementModel add(STValue value, String name) {
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