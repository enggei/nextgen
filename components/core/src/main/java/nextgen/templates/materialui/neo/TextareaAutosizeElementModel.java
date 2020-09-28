package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TextareaAutosizeElementModel {

	public static final String stGroupModelUuid = "321c04de-dca6-45c6-bbff-ebdcf1e62d5d";
	public static final String stTemplateUuid = "70ca3c8f-2283-49fe-86f0-a0e36245de62";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TextareaAutosizeElementModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TextareaAutosizeElementModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TextareaAutosizeElementModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TextareaAutosizeElementModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TextareaAutosizeElementModel that = (TextareaAutosizeElementModel) o;
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

	public TextareaAutosizeElementModel setClassName(String value) {
		return setClassName(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setClassName(STValue value) {
		return set(value, "className");
	}

	public STValue getClassName() {
		return get("className");
	}

	public STArgument getClassNameArgument() {
		return getArgument("className");
	}

	public TextareaAutosizeElementModel removeClassName() {
		return removeArgument("className");
	}

	public TextareaAutosizeElementModel setId(String value) {
		return setId(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setId(STValue value) {
		return set(value, "id");
	}

	public STValue getId() {
		return get("id");
	}

	public STArgument getIdArgument() {
		return getArgument("id");
	}

	public TextareaAutosizeElementModel removeId() {
		return removeArgument("id");
	}

	public TextareaAutosizeElementModel setKey(String value) {
		return setKey(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setKey(STValue value) {
		return set(value, "key");
	}

	public STValue getKey() {
		return get("key");
	}

	public STArgument getKeyArgument() {
		return getArgument("key");
	}

	public TextareaAutosizeElementModel removeKey() {
		return removeArgument("key");
	}

	public TextareaAutosizeElementModel setRows(String value) {
		return setRows(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setRows(STValue value) {
		return set(value, "rows");
	}

	public STValue getRows() {
		return get("rows");
	}

	public STArgument getRowsArgument() {
		return getArgument("rows");
	}

	public TextareaAutosizeElementModel removeRows() {
		return removeArgument("rows");
	}

	public TextareaAutosizeElementModel setRowsMax(String value) {
		return setRowsMax(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setRowsMax(STValue value) {
		return set(value, "rowsMax");
	}

	public STValue getRowsMax() {
		return get("rowsMax");
	}

	public STArgument getRowsMaxArgument() {
		return getArgument("rowsMax");
	}

	public TextareaAutosizeElementModel removeRowsMax() {
		return removeArgument("rowsMax");
	}

	public TextareaAutosizeElementModel setRowsMin(String value) {
		return setRowsMin(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setRowsMin(STValue value) {
		return set(value, "rowsMin");
	}

	public STValue getRowsMin() {
		return get("rowsMin");
	}

	public STArgument getRowsMinArgument() {
		return getArgument("rowsMin");
	}

	public TextareaAutosizeElementModel removeRowsMin() {
		return removeArgument("rowsMin");
	}

	public TextareaAutosizeElementModel setStyle(String value) {
		return setStyle(db.newSTValue(value));
	}

	public TextareaAutosizeElementModel setStyle(STValue value) {
		return set(value, "style");
	}

	public STValue getStyle() {
		return get("style");
	}

	public STArgument getStyleArgument() {
		return getArgument("style");
	}

	public TextareaAutosizeElementModel removeStyle() {
		return removeArgument("style");
	}


	public TextareaAutosizeElementModel addAttribute(String _name, String _value) {
		return addAttribute(db.newSTValue(_name), db.newSTValue(_value));
	}

	public TextareaAutosizeElementModel addAttribute(TextareaAutosizeElementModel_Attribute value) {
		return addAttribute(value.getName(), value.getValue());
	}

	public TextareaAutosizeElementModel addAttribute(STValue _name, STValue _value) {
		findParameter("attribute")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TextareaAutosizeElementModel_Attribute> streamAttribute() {
		return findParameter("attribute")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TextareaAutosizeElementModel_Attribute(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TextareaAutosizeElementModel_Attribute {

		STArgument stArgument;
		STParameter stParameter;

		public TextareaAutosizeElementModel_Attribute(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TextareaAutosizeElementModel_Attribute setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TextareaAutosizeElementModel_Attribute setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TextareaAutosizeElementModel_Attribute setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public TextareaAutosizeElementModel_Attribute setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private TextareaAutosizeElementModel_Attribute setKVValue(String name, STValue value) {

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

	private TextareaAutosizeElementModel set(STValue value, String name) {
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

	private TextareaAutosizeElementModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TextareaAutosizeElementModel add(STValue value, String name) {
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