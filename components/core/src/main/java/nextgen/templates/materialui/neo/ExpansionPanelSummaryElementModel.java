package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ExpansionPanelSummaryElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "f8d23b77-fee6-4f30-b5dc-4450f0e4bf2a";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ExpansionPanelSummaryElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ExpansionPanelSummaryElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ExpansionPanelSummaryElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ExpansionPanelSummaryElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpansionPanelSummaryElementModel that = (ExpansionPanelSummaryElementModel) o;
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

	public ExpansionPanelSummaryElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ExpansionPanelSummaryElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ExpansionPanelSummaryElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ExpansionPanelSummaryElementModel removeClassName() {
		return removeArgument("className");
	}

	public ExpansionPanelSummaryElementModel setExpandIcon(String value) {
		return setExpandIcon(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setExpandIcon(STValue value) {
		return set(value, "expandIcon");
	}

	public STValue getExpandIcon() {
		return get("expandIcon");
	}

	public STArgument getExpandIconArgument() {
		return getArgument("expandIcon");
	}

	public ExpansionPanelSummaryElementModel removeExpandIcon() {
		return removeArgument("expandIcon");
	}

	public ExpansionPanelSummaryElementModel setIconButtonProps(String value) {
		return setIconButtonProps(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setIconButtonProps(STValue value) {
		return set(value, "IconButtonProps");
	}

	public STValue getIconButtonProps() {
		return get("IconButtonProps");
	}

	public STArgument getIconButtonPropsArgument() {
		return getArgument("IconButtonProps");
	}

	public ExpansionPanelSummaryElementModel removeIconButtonProps() {
		return removeArgument("IconButtonProps");
	}

	public ExpansionPanelSummaryElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ExpansionPanelSummaryElementModel removeId() {
		return removeArgument("id");
	}

	public ExpansionPanelSummaryElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ExpansionPanelSummaryElementModel removeKey() {
		return removeArgument("key");
	}

	public ExpansionPanelSummaryElementModel setOnFocusVisible(String value) {
		return setOnFocusVisible(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setOnFocusVisible(STValue value) {
		return set(value, "onFocusVisible");
	}

	public STValue getOnFocusVisible() {
		return get("onFocusVisible");
	}

	public STArgument getOnFocusVisibleArgument() {
		return getArgument("onFocusVisible");
	}

	public ExpansionPanelSummaryElementModel removeOnFocusVisible() {
		return removeArgument("onFocusVisible");
	}

	public ExpansionPanelSummaryElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ExpansionPanelSummaryElementModel removeStyle() {
		return removeArgument("style");
	}

	public ExpansionPanelSummaryElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ExpansionPanelSummaryElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ExpansionPanelSummaryElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ExpansionPanelSummaryElementModel addAttribute(ExpansionPanelSummaryElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ExpansionPanelSummaryElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ExpansionPanelSummaryElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ExpansionPanelSummaryElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ExpansionPanelSummaryElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ExpansionPanelSummaryElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ExpansionPanelSummaryElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ExpansionPanelSummaryElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ExpansionPanelSummaryElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ExpansionPanelSummaryElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ExpansionPanelSummaryElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ExpansionPanelSummaryElementModel set(STValue value, String name) {
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

	private ExpansionPanelSummaryElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ExpansionPanelSummaryElementModel add(STValue value, String name) {
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