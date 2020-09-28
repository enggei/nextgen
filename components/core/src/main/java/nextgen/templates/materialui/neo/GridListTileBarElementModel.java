package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class GridListTileBarElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "8c54923d-3de3-450c-8135-a72850fdff28";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public GridListTileBarElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public GridListTileBarElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public GridListTileBarElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public GridListTileBarElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GridListTileBarElementModel that = (GridListTileBarElementModel) o;
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

	public GridListTileBarElementModel setActionIcon(String value) {
		return setActionIcon(db.newSTValue(value));
	}

	public GridListTileBarElementModel setActionIcon(STValue value) {
		return set(value, "actionIcon");
	}

	public STValue getActionIcon() {
		return get("actionIcon");
	}

	public STArgument getActionIconArgument() {
		return getArgument("actionIcon");
	}

	public GridListTileBarElementModel removeActionIcon() {
		return removeArgument("actionIcon");
	}

	public GridListTileBarElementModel setActionPosition(String value) {
		return setActionPosition(db.newSTValue(value));
	}

	public GridListTileBarElementModel setActionPosition(STValue value) {
		return set(value, "actionPosition");
	}

	public STValue getActionPosition() {
		return get("actionPosition");
	}

	public STArgument getActionPositionArgument() {
		return getArgument("actionPosition");
	}

	public GridListTileBarElementModel removeActionPosition() {
		return removeArgument("actionPosition");
	}

	public GridListTileBarElementModel setClasses(String value) {
		return setClasses(db.newSTValue(value));
	}

	public GridListTileBarElementModel setClasses(STValue value) {
		return set(value, "classes");
	}

	public STValue getClasses() {
		return get("classes");
	}

	public STArgument getClassesArgument() {
		return getArgument("classes");
	}

	public GridListTileBarElementModel removeClasses() {
		return removeArgument("classes");
	}

	public GridListTileBarElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public GridListTileBarElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public GridListTileBarElementModel removeClassName() {
		return removeArgument("className");
	}

	public GridListTileBarElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public GridListTileBarElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public GridListTileBarElementModel removeId() {
		return removeArgument("id");
	}

	public GridListTileBarElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public GridListTileBarElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public GridListTileBarElementModel removeKey() {
		return removeArgument("key");
	}

	public GridListTileBarElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public GridListTileBarElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public GridListTileBarElementModel removeStyle() {
		return removeArgument("style");
	}

	public GridListTileBarElementModel setSubtitle(String value) {
		return setSubtitle(db.newSTValue(value));
	}

	public GridListTileBarElementModel setSubtitle(STValue value) {
		return set(value, "subtitle");
	}

	public STValue getSubtitle() {
		return get("subtitle");
	}

	public STArgument getSubtitleArgument() {
		return getArgument("subtitle");
	}

	public GridListTileBarElementModel removeSubtitle() {
		return removeArgument("subtitle");
	}

	public GridListTileBarElementModel setTitle(String value) {
		return setTitle(db.newSTValue(value));
	}

	public GridListTileBarElementModel setTitle(STValue value) {
		return set(value, "title");
	}

	public STValue getTitle() {
		return get("title");
	}

	public STArgument getTitleArgument() {
		return getArgument("title");
	}

	public GridListTileBarElementModel removeTitle() {
		return removeArgument("title");
	}

	public GridListTileBarElementModel setTitlePosition(String value) {
		return setTitlePosition(db.newSTValue(value));
	}

	public GridListTileBarElementModel setTitlePosition(STValue value) {
		return set(value, "titlePosition");
	}

	public STValue getTitlePosition() {
		return get("titlePosition");
	}

	public STArgument getTitlePositionArgument() {
		return getArgument("titlePosition");
	}

	public GridListTileBarElementModel removeTitlePosition() {
		return removeArgument("titlePosition");
	}


	public GridListTileBarElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public GridListTileBarElementModel addAttribute(GridListTileBarElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public GridListTileBarElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<GridListTileBarElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new GridListTileBarElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class GridListTileBarElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public GridListTileBarElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public GridListTileBarElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public GridListTileBarElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public GridListTileBarElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public GridListTileBarElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private GridListTileBarElementModel_Attribute setKVValue(String name, STValue value) {

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

	private GridListTileBarElementModel set(STValue value, String name) {
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

	private GridListTileBarElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private GridListTileBarElementModel add(STValue value, String name) {
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