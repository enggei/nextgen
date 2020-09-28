package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CardHeaderElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "813c729d-563f-4d0a-8589-267d16d06d45";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public CardHeaderElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public CardHeaderElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public CardHeaderElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public CardHeaderElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CardHeaderElementModel that = (CardHeaderElementModel) o;
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

	public CardHeaderElementModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public CardHeaderElementModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public CardHeaderElementModel removeAction() {
		return removeArgument("action");
	}

	public CardHeaderElementModel setAvatar(String value) {
		return setAvatar(db.newSTValue(value));
	}

	public CardHeaderElementModel setAvatar(STValue value) {
		return set(value, "avatar");
	}

	public STValue getAvatar() {
		return get("avatar");
	}

	public STArgument getAvatarArgument() {
		return getArgument("avatar");
	}

	public CardHeaderElementModel removeAvatar() {
		return removeArgument("avatar");
	}

	public CardHeaderElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public CardHeaderElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public CardHeaderElementModel removeClasses() {
		return removeArgument("classes");
	}

	public CardHeaderElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public CardHeaderElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public CardHeaderElementModel removeClassName() {
		return removeArgument("className");
	}

	public CardHeaderElementModel setComponent(String value) {
		return setComponent(db.newSTValue(value));
	}

	public CardHeaderElementModel setComponent(STValue value) {
		return set(value, "component");
	}

	public STValue getComponent() {
		return get("component");
	}

	public STArgument getComponentArgument() {
		return getArgument("component");
	}

	public CardHeaderElementModel removeComponent() {
		return removeArgument("component");
	}

	public CardHeaderElementModel setDisableTypography(String value) {
		return setDisableTypography(db.newSTValue(value));
	}

	public CardHeaderElementModel setDisableTypography(STValue value) {
		return set(value, "disableTypography");
	}

	public STValue getDisableTypography() {
		return get("disableTypography");
	}

	public STArgument getDisableTypographyArgument() {
		return getArgument("disableTypography");
	}

	public CardHeaderElementModel removeDisableTypography() {
		return removeArgument("disableTypography");
	}

	public CardHeaderElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public CardHeaderElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public CardHeaderElementModel removeId() {
		return removeArgument("id");
	}

	public CardHeaderElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public CardHeaderElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public CardHeaderElementModel removeKey() {
		return removeArgument("key");
	}

	public CardHeaderElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public CardHeaderElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public CardHeaderElementModel removeStyle() {
		return removeArgument("style");
	}

	public CardHeaderElementModel setSubheader(String value) {
		return setSubheader(db.newSTValue(value));
	}

	public CardHeaderElementModel setSubheader(STValue value) {
		return set(value, "subheader");
	}

	public STValue getSubheader() {
		return get("subheader");
	}

	public STArgument getSubheaderArgument() {
		return getArgument("subheader");
	}

	public CardHeaderElementModel removeSubheader() {
		return removeArgument("subheader");
	}

	public CardHeaderElementModel setSubheaderTypographyProps(String value) {
		return setSubheaderTypographyProps(db.newSTValue(value));
	}

	public CardHeaderElementModel setSubheaderTypographyProps(STValue value) {
		return set(value, "subheaderTypographyProps");
	}

	public STValue getSubheaderTypographyProps() {
		return get("subheaderTypographyProps");
	}

	public STArgument getSubheaderTypographyPropsArgument() {
		return getArgument("subheaderTypographyProps");
	}

	public CardHeaderElementModel removeSubheaderTypographyProps() {
		return removeArgument("subheaderTypographyProps");
	}

	public CardHeaderElementModel setTitle(String value) {
		return setTitle(db.newSTValue(value));
	}

	public CardHeaderElementModel setTitle(STValue value) {
		return set(value, "title");
	}

	public STValue getTitle() {
		return get("title");
	}

	public STArgument getTitleArgument() {
		return getArgument("title");
	}

	public CardHeaderElementModel removeTitle() {
		return removeArgument("title");
	}

	public CardHeaderElementModel setTitleTypographyProps(String value) {
		return setTitleTypographyProps(db.newSTValue(value));
	}

	public CardHeaderElementModel setTitleTypographyProps(STValue value) {
		return set(value, "titleTypographyProps");
	}

	public STValue getTitleTypographyProps() {
		return get("titleTypographyProps");
	}

	public STArgument getTitleTypographyPropsArgument() {
		return getArgument("titleTypographyProps");
	}

	public CardHeaderElementModel removeTitleTypographyProps() {
		return removeArgument("titleTypographyProps");
	}


	public CardHeaderElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public CardHeaderElementModel addAttribute(CardHeaderElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public CardHeaderElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<CardHeaderElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new CardHeaderElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class CardHeaderElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public CardHeaderElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public CardHeaderElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public CardHeaderElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public CardHeaderElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public CardHeaderElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private CardHeaderElementModel_Attribute setKVValue(String name, STValue value) {

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

	private CardHeaderElementModel set(STValue value, String name) {
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

	private CardHeaderElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private CardHeaderElementModel add(STValue value, String name) {
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