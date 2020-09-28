package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class RatingElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "86c3b61b-65c1-48bf-86bf-c93fadd3bd12";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public RatingElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public RatingElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public RatingElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public RatingElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RatingElementModel that = (RatingElementModel) o;
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

	public RatingElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public RatingElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public RatingElementModel removeClasses() {
		return removeArgument("classes");
	}

	public RatingElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public RatingElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public RatingElementModel removeClassName() {
		return removeArgument("className");
	}

	public RatingElementModel setDefaultValue(String value) {
		return setDefaultValue(db.newSTValue(value));
	}

	public RatingElementModel setDefaultValue(STValue value) {
		return set(value, "defaultValue");
	}

	public STValue getDefaultValue() {
		return get("defaultValue");
	}

	public STArgument getDefaultValueArgument() {
		return getArgument("defaultValue");
	}

	public RatingElementModel removeDefaultValue() {
		return removeArgument("defaultValue");
	}

	public RatingElementModel setDisabled(String value) {
		return setDisabled(db.newSTValue(value));
	}

	public RatingElementModel setDisabled(STValue value) {
		return set(value, "disabled");
	}

	public STValue getDisabled() {
		return get("disabled");
	}

	public STArgument getDisabledArgument() {
		return getArgument("disabled");
	}

	public RatingElementModel removeDisabled() {
		return removeArgument("disabled");
	}

	public RatingElementModel setEmptyIcon(String value) {
		return setEmptyIcon(db.newSTValue(value));
	}

	public RatingElementModel setEmptyIcon(STValue value) {
		return set(value, "emptyIcon");
	}

	public STValue getEmptyIcon() {
		return get("emptyIcon");
	}

	public STArgument getEmptyIconArgument() {
		return getArgument("emptyIcon");
	}

	public RatingElementModel removeEmptyIcon() {
		return removeArgument("emptyIcon");
	}

	public RatingElementModel setEmptyLabelText(String value) {
		return setEmptyLabelText(db.newSTValue(value));
	}

	public RatingElementModel setEmptyLabelText(STValue value) {
		return set(value, "emptyLabelText");
	}

	public STValue getEmptyLabelText() {
		return get("emptyLabelText");
	}

	public STArgument getEmptyLabelTextArgument() {
		return getArgument("emptyLabelText");
	}

	public RatingElementModel removeEmptyLabelText() {
		return removeArgument("emptyLabelText");
	}

	public RatingElementModel setGetLabelText(String value) {
		return setGetLabelText(db.newSTValue(value));
	}

	public RatingElementModel setGetLabelText(STValue value) {
		return set(value, "getLabelText");
	}

	public STValue getGetLabelText() {
		return get("getLabelText");
	}

	public STArgument getGetLabelTextArgument() {
		return getArgument("getLabelText");
	}

	public RatingElementModel removeGetLabelText() {
		return removeArgument("getLabelText");
	}

	public RatingElementModel setIcon(String value) {
		return setIcon(db.newSTValue(value));
	}

	public RatingElementModel setIcon(STValue value) {
		return set(value, "icon");
	}

	public STValue getIcon() {
		return get("icon");
	}

	public STArgument getIconArgument() {
		return getArgument("icon");
	}

	public RatingElementModel removeIcon() {
		return removeArgument("icon");
	}

	public RatingElementModel setIconContainerComponent(String value) {
		return setIconContainerComponent(db.newSTValue(value));
	}

	public RatingElementModel setIconContainerComponent(STValue value) {
		return set(value, "IconContainerComponent");
	}

	public STValue getIconContainerComponent() {
		return get("IconContainerComponent");
	}

	public STArgument getIconContainerComponentArgument() {
		return getArgument("IconContainerComponent");
	}

	public RatingElementModel removeIconContainerComponent() {
		return removeArgument("IconContainerComponent");
	}

	public RatingElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public RatingElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public RatingElementModel removeId() {
		return removeArgument("id");
	}

	public RatingElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public RatingElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public RatingElementModel removeKey() {
		return removeArgument("key");
	}

	public RatingElementModel setMax(String value) {
		return setMax(db.newSTValue(value));
	}

	public RatingElementModel setMax(STValue value) {
		return set(value, "max");
	}

	public STValue getMax() {
		return get("max");
	}

	public STArgument getMaxArgument() {
		return getArgument("max");
	}

	public RatingElementModel removeMax() {
		return removeArgument("max");
	}

	public RatingElementModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public RatingElementModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public RatingElementModel removeName() {
		return removeArgument("name");
	}

	public RatingElementModel setOnChange(String value) {
		return setOnChange(db.newSTValue(value));
	}

	public RatingElementModel setOnChange(STValue value) {
		return set(value, "onChange");
	}

	public STValue getOnChange() {
		return get("onChange");
	}

	public STArgument getOnChangeArgument() {
		return getArgument("onChange");
	}

	public RatingElementModel removeOnChange() {
		return removeArgument("onChange");
	}

	public RatingElementModel setOnChangeActive(String value) {
		return setOnChangeActive(db.newSTValue(value));
	}

	public RatingElementModel setOnChangeActive(STValue value) {
		return set(value, "onChangeActive");
	}

	public STValue getOnChangeActive() {
		return get("onChangeActive");
	}

	public STArgument getOnChangeActiveArgument() {
		return getArgument("onChangeActive");
	}

	public RatingElementModel removeOnChangeActive() {
		return removeArgument("onChangeActive");
	}

	public RatingElementModel setPrecision(String value) {
		return setPrecision(db.newSTValue(value));
	}

	public RatingElementModel setPrecision(STValue value) {
		return set(value, "precision");
	}

	public STValue getPrecision() {
		return get("precision");
	}

	public STArgument getPrecisionArgument() {
		return getArgument("precision");
	}

	public RatingElementModel removePrecision() {
		return removeArgument("precision");
	}

	public RatingElementModel setReadOnly(String value) {
		return setReadOnly(db.newSTValue(value));
	}

	public RatingElementModel setReadOnly(STValue value) {
		return set(value, "readOnly");
	}

	public STValue getReadOnly() {
		return get("readOnly");
	}

	public STArgument getReadOnlyArgument() {
		return getArgument("readOnly");
	}

	public RatingElementModel removeReadOnly() {
		return removeArgument("readOnly");
	}

	public RatingElementModel setSize(String value) {
		return setSize(db.newSTValue(value));
	}

	public RatingElementModel setSize(STValue value) {
		return set(value, "size");
	}

	public STValue getSize() {
		return get("size");
	}

	public STArgument getSizeArgument() {
		return getArgument("size");
	}

	public RatingElementModel removeSize() {
		return removeArgument("size");
	}

	public RatingElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public RatingElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public RatingElementModel removeStyle() {
		return removeArgument("style");
	}

	public RatingElementModel setValue(String value) {
		return setValue(db.newSTValue(value));
	}

	public RatingElementModel setValue(STValue value) {
		return set(value, "value");
	}

	public STValue getValue() {
		return get("value");
	}

	public STArgument getValueArgument() {
		return getArgument("value");
	}

	public RatingElementModel removeValue() {
		return removeArgument("value");
	}


	public RatingElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public RatingElementModel addAttribute(RatingElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public RatingElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<RatingElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new RatingElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class RatingElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public RatingElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public RatingElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public RatingElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public RatingElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public RatingElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private RatingElementModel_Attribute setKVValue(String name, STValue value) {

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

	private RatingElementModel set(STValue value, String name) {
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

	private RatingElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private RatingElementModel add(STValue value, String name) {
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