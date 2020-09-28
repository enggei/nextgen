package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ExpansionPanelElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "3de3598c-1df1-437a-962a-487db5a21ad4";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ExpansionPanelElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ExpansionPanelElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ExpansionPanelElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ExpansionPanelElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpansionPanelElementModel that = (ExpansionPanelElementModel) o;
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

	public ExpansionPanelElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ExpansionPanelElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ExpansionPanelElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ExpansionPanelElementModel removeClassName() {
		return removeArgument("className");
	}

	public ExpansionPanelElementModel setDefaultExpanded(String value) {
		return setDefaultExpanded(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setDefaultExpanded(STValue value) {
		return set(value, "defaultExpanded");
	}

	public STValue getDefaultExpanded() {
		return get("defaultExpanded");
	}

	public STArgument getDefaultExpandedArgument() {
		return getArgument("defaultExpanded");
	}

	public ExpansionPanelElementModel removeDefaultExpanded() {
		return removeArgument("defaultExpanded");
	}

	public ExpansionPanelElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public ExpansionPanelElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public ExpansionPanelElementModel setExpanded(String value) {
		return setExpanded(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setExpanded(STValue value) {
		return set(value, "expanded");
	}

	public STValue getExpanded() {
		return get("expanded");
	}

	public STArgument getExpandedArgument() {
		return getArgument("expanded");
	}

	public ExpansionPanelElementModel removeExpanded() {
		return removeArgument("expanded");
	}

	public ExpansionPanelElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ExpansionPanelElementModel removeId() {
		return removeArgument("id");
	}

	public ExpansionPanelElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ExpansionPanelElementModel removeKey() {
		return removeArgument("key");
	}

	public ExpansionPanelElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public ExpansionPanelElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public ExpansionPanelElementModel setSquare(String value) {
		return setSquare(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setSquare(STValue value) {
		return set(value, "square");
	}

	public STValue getSquare() {
		return get("square");
	}

	public STArgument getSquareArgument() {
		return getArgument("square");
	}

	public ExpansionPanelElementModel removeSquare() {
		return removeArgument("square");
	}

	public ExpansionPanelElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ExpansionPanelElementModel removeStyle() {
		return removeArgument("style");
	}

	public ExpansionPanelElementModel setTransitionComponent(String value) {
		return setTransitionComponent(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setTransitionComponent(STValue value) {
		return set(value, "TransitionComponent");
	}

	public STValue getTransitionComponent() {
		return get("TransitionComponent");
	}

	public STArgument getTransitionComponentArgument() {
		return getArgument("TransitionComponent");
	}

	public ExpansionPanelElementModel removeTransitionComponent() {
		return removeArgument("TransitionComponent");
	}

	public ExpansionPanelElementModel setTransitionProps(String value) {
		return setTransitionProps(db.newSTValue(value));
	}

	public ExpansionPanelElementModel setTransitionProps(STValue value) {
		return set(value, "TransitionProps");
	}

	public STValue getTransitionProps() {
		return get("TransitionProps");
	}

	public STArgument getTransitionPropsArgument() {
		return getArgument("TransitionProps");
	}

	public ExpansionPanelElementModel removeTransitionProps() {
		return removeArgument("TransitionProps");
	}

	public ExpansionPanelElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ExpansionPanelElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ExpansionPanelElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ExpansionPanelElementModel addAttribute(ExpansionPanelElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ExpansionPanelElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ExpansionPanelElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ExpansionPanelElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ExpansionPanelElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ExpansionPanelElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ExpansionPanelElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ExpansionPanelElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ExpansionPanelElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ExpansionPanelElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ExpansionPanelElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ExpansionPanelElementModel set(STValue value, String name) {
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

	private ExpansionPanelElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ExpansionPanelElementModel add(STValue value, String name) {
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