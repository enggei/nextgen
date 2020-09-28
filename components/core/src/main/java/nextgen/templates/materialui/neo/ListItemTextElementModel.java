package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ListItemTextElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8a1982aa-fb57-45de-9b71-62af8f9b6b5f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ListItemTextElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ListItemTextElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ListItemTextElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ListItemTextElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListItemTextElementModel that = (ListItemTextElementModel) o;
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

	public ListItemTextElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public ListItemTextElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public ListItemTextElementModel removeClasses() {
		return removeArgument("classes");
	}

	public ListItemTextElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public ListItemTextElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public ListItemTextElementModel removeClassName() {
		return removeArgument("className");
	}

	public ListItemTextElementModel setDisableTypography(String value) {
		return setDisableTypography(db.newSTValue(value));
	}

	public ListItemTextElementModel setDisableTypography(STValue value) {
		return set(value, "disableTypography");
	}

	public STValue getDisableTypography() {
		return get("disableTypography");
	}

	public STArgument getDisableTypographyArgument() {
		return getArgument("disableTypography");
	}

	public ListItemTextElementModel removeDisableTypography() {
		return removeArgument("disableTypography");
	}

	public ListItemTextElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public ListItemTextElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public ListItemTextElementModel removeId() {
		return removeArgument("id");
	}

	public ListItemTextElementModel setInset(String value) {
		return setInset(db.newSTValue(value));
	}

	public ListItemTextElementModel setInset(STValue value) {
		return set(value, "inset");
	}

	public STValue getInset() {
		return get("inset");
	}

	public STArgument getInsetArgument() {
		return getArgument("inset");
	}

	public ListItemTextElementModel removeInset() {
		return removeArgument("inset");
	}

	public ListItemTextElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public ListItemTextElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public ListItemTextElementModel removeKey() {
		return removeArgument("key");
	}

	public ListItemTextElementModel setPrimary(String value) {
		return setPrimary(db.newSTValue(value));
	}

	public ListItemTextElementModel setPrimary(STValue value) {
		return set(value, "primary");
	}

	public STValue getPrimary() {
		return get("primary");
	}

	public STArgument getPrimaryArgument() {
		return getArgument("primary");
	}

	public ListItemTextElementModel removePrimary() {
		return removeArgument("primary");
	}

	public ListItemTextElementModel setPrimaryTypographyProps(String value) {
		return setPrimaryTypographyProps(db.newSTValue(value));
	}

	public ListItemTextElementModel setPrimaryTypographyProps(STValue value) {
		return set(value, "primaryTypographyProps");
	}

	public STValue getPrimaryTypographyProps() {
		return get("primaryTypographyProps");
	}

	public STArgument getPrimaryTypographyPropsArgument() {
		return getArgument("primaryTypographyProps");
	}

	public ListItemTextElementModel removePrimaryTypographyProps() {
		return removeArgument("primaryTypographyProps");
	}

	public ListItemTextElementModel setSecondary(String value) {
		return setSecondary(db.newSTValue(value));
	}

	public ListItemTextElementModel setSecondary(STValue value) {
		return set(value, "secondary");
	}

	public STValue getSecondary() {
		return get("secondary");
	}

	public STArgument getSecondaryArgument() {
		return getArgument("secondary");
	}

	public ListItemTextElementModel removeSecondary() {
		return removeArgument("secondary");
	}

	public ListItemTextElementModel setSecondaryTypographyProps(String value) {
		return setSecondaryTypographyProps(db.newSTValue(value));
	}

	public ListItemTextElementModel setSecondaryTypographyProps(STValue value) {
		return set(value, "secondaryTypographyProps");
	}

	public STValue getSecondaryTypographyProps() {
		return get("secondaryTypographyProps");
	}

	public STArgument getSecondaryTypographyPropsArgument() {
		return getArgument("secondaryTypographyProps");
	}

	public ListItemTextElementModel removeSecondaryTypographyProps() {
		return removeArgument("secondaryTypographyProps");
	}

	public ListItemTextElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public ListItemTextElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public ListItemTextElementModel removeStyle() {
		return removeArgument("style");
	}

	public ListItemTextElementModel addChildren(String value) {
		return addChildren(db.newSTValue(value));
	}

	public ListItemTextElementModel addChildren(STValue value) {
		return add(value, "children");
	}

	public Stream<STValue> getChildren() {
		return stream("children");
	}

	public ListItemTextElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public ListItemTextElementModel addAttribute(ListItemTextElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public ListItemTextElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ListItemTextElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ListItemTextElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ListItemTextElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public ListItemTextElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ListItemTextElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ListItemTextElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ListItemTextElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public ListItemTextElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private ListItemTextElementModel_Attribute setKVValue(String name, STValue value) {

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

	private ListItemTextElementModel set(STValue value, String name) {
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

	private ListItemTextElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ListItemTextElementModel add(STValue value, String name) {
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