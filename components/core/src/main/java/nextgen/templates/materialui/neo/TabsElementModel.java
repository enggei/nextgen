package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TabsElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "e58e96d7-c232-42b7-830a-3c315e7cf400";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TabsElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TabsElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TabsElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TabsElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TabsElementModel that = (TabsElementModel) o;
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

	public TabsElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public TabsElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public TabsElementModel removeAction() {
		return removeArgument("action");
	}

	public TabsElementModel setAriaLabel(String value) {
		return setAriaLabel(db.newSTValue(value));
	}

	public TabsElementModel setAriaLabel(STValue value) {
		return set(value, "ariaLabel");
	}

	public STValue getAriaLabel() {
		return get("ariaLabel");
	}

	public STArgument getAriaLabelArgument() {
		return getArgument("ariaLabel");
	}

	public TabsElementModel removeAriaLabel() {
		return removeArgument("ariaLabel");
	}

	public TabsElementModel setAriaLabelledby(String value) {
		return setAriaLabelledby(db.newSTValue(value));
	}

	public TabsElementModel setAriaLabelledby(STValue value) {
		return set(value, "ariaLabelledby");
	}

	public STValue getAriaLabelledby() {
		return get("ariaLabelledby");
	}

	public STArgument getAriaLabelledbyArgument() {
		return getArgument("ariaLabelledby");
	}

	public TabsElementModel removeAriaLabelledby() {
		return removeArgument("ariaLabelledby");
	}

	public TabsElementModel setCentered(String value) {
		return setCentered(db.newSTValue(value));
	}

	public TabsElementModel setCentered(STValue value) {
		return set(value, "centered");
	}

	public STValue getCentered() {
		return get("centered");
	}

	public STArgument getCenteredArgument() {
		return getArgument("centered");
	}

	public TabsElementModel removeCentered() {
		return removeArgument("centered");
	}

	public TabsElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public TabsElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public TabsElementModel removeClasses() {
		return removeArgument("classes");
	}

	public TabsElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TabsElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TabsElementModel removeClassName() {
		return removeArgument("className");
	}

	public TabsElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public TabsElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public TabsElementModel removeComponent() {
		return removeArgument("component");
	}

	public TabsElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TabsElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TabsElementModel removeId() {
		return removeArgument("id");
	}

	public TabsElementModel setIndicatorColor(String value) {
		return setIndicatorColor(db.newSTValue(value));
	}

	public TabsElementModel setIndicatorColor(STValue value) {
		return set(value, "indicatorColor");
	}

	public STValue getIndicatorColor() {
		return get("indicatorColor");
	}

	public STArgument getIndicatorColorArgument() {
		return getArgument("indicatorColor");
	}

	public TabsElementModel removeIndicatorColor() {
		return removeArgument("indicatorColor");
	}

	public TabsElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TabsElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TabsElementModel removeKey() {
		return removeArgument("key");
	}

	public TabsElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public TabsElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public TabsElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public TabsElementModel setOrientation(String value) {
		return setOrientation(db.newSTValue(value));
	}

	public TabsElementModel setOrientation(STValue value) {
		return set(value, "orientation");
	}

	public STValue getOrientation() {
		return get("orientation");
	}

	public STArgument getOrientationArgument() {
		return getArgument("orientation");
	}

	public TabsElementModel removeOrientation() {
		return removeArgument("orientation");
	}

	public TabsElementModel setScrollButtonComponent(String value) {
		return setScrollButtonComponent(db.newSTValue(value));
	}

	public TabsElementModel setScrollButtonComponent(STValue value) {
		return set(value, "ScrollButtonComponent");
	}

	public STValue getScrollButtonComponent() {
		return get("ScrollButtonComponent");
	}

	public STArgument getScrollButtonComponentArgument() {
		return getArgument("ScrollButtonComponent");
	}

	public TabsElementModel removeScrollButtonComponent() {
		return removeArgument("ScrollButtonComponent");
	}

	public TabsElementModel setScrollButtons(String value) {
		return setScrollButtons(db.newSTValue(value));
	}

	public TabsElementModel setScrollButtons(STValue value) {
		return set(value, "scrollButtons");
	}

	public STValue getScrollButtons() {
		return get("scrollButtons");
	}

	public STArgument getScrollButtonsArgument() {
		return getArgument("scrollButtons");
	}

	public TabsElementModel removeScrollButtons() {
		return removeArgument("scrollButtons");
	}

	public TabsElementModel setSelectionFollowsFocus(String value) {
		return setSelectionFollowsFocus(db.newSTValue(value));
	}

	public TabsElementModel setSelectionFollowsFocus(STValue value) {
		return set(value, "selectionFollowsFocus");
	}

	public STValue getSelectionFollowsFocus() {
		return get("selectionFollowsFocus");
	}

	public STArgument getSelectionFollowsFocusArgument() {
		return getArgument("selectionFollowsFocus");
	}

	public TabsElementModel removeSelectionFollowsFocus() {
		return removeArgument("selectionFollowsFocus");
	}

	public TabsElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TabsElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TabsElementModel removeStyle() {
		return removeArgument("style");
	}

	public TabsElementModel setTabIndicatorProps(String value) {
		return setTabIndicatorProps(db.newSTValue(value));
	}

	public TabsElementModel setTabIndicatorProps(STValue value) {
		return set(value, "TabIndicatorProps");
	}

	public STValue getTabIndicatorProps() {
		return get("TabIndicatorProps");
	}

	public STArgument getTabIndicatorPropsArgument() {
		return getArgument("TabIndicatorProps");
	}

	public TabsElementModel removeTabIndicatorProps() {
		return removeArgument("TabIndicatorProps");
	}

	public TabsElementModel setTabScrollButtonProps(String value) {
		return setTabScrollButtonProps(db.newSTValue(value));
	}

	public TabsElementModel setTabScrollButtonProps(STValue value) {
		return set(value, "TabScrollButtonProps");
	}

	public STValue getTabScrollButtonProps() {
		return get("TabScrollButtonProps");
	}

	public STArgument getTabScrollButtonPropsArgument() {
		return getArgument("TabScrollButtonProps");
	}

	public TabsElementModel removeTabScrollButtonProps() {
		return removeArgument("TabScrollButtonProps");
	}

	public TabsElementModel setTextColor(String value) {
		return setTextColor(db.newSTValue(value));
	}

	public TabsElementModel setTextColor(STValue value) {
		return set(value, "textColor");
	}

	public STValue getTextColor() {
		return get("textColor");
	}

	public STArgument getTextColorArgument() {
		return getArgument("textColor");
	}

	public TabsElementModel removeTextColor() {
		return removeArgument("textColor");
	}

	public TabsElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public TabsElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public TabsElementModel removeValue() {
		return removeArgument("value");
	}

	public TabsElementModel setVariant(String value) {
		return setVariant(db.newSTValue(value));
	}

	public TabsElementModel setVariant(STValue value) {
		return set(value, "variant");
	}

	public STValue getVariant() {
		return get("variant");
	}

	public STArgument getVariantArgument() {
		return getArgument("variant");
	}

	public TabsElementModel removeVariant() {
		return removeArgument("variant");
	}

	public TabsElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public TabsElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public TabsElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TabsElementModel addAttribute(TabsElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TabsElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TabsElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TabsElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TabsElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TabsElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TabsElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TabsElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TabsElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TabsElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TabsElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TabsElementModel set(STValue value, String name) {
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

	private TabsElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TabsElementModel add(STValue value, String name) {
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