package nextgen.templates.vertx.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class JsonWrapperModel {

	public static final String stGroupModelUuid = "68548572-6e3a-48dd-a96e-2d23030ba650";
	public static final String stTemplateUuid = "4a756317-c8b7-44c4-a677-68c57d064ab6";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public JsonWrapperModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public JsonWrapperModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public JsonWrapperModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public JsonWrapperModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonWrapperModel that = (JsonWrapperModel) o;
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

	public JsonWrapperModel setPackage(String value) {
		return setPackage(db.newSTValue(value));
	}

	public JsonWrapperModel setPackage(STValue value) {
		return set(value, "package");
	}

	public STValue getPackage() {
		return get("package");
	}

	public STArgument getPackageArgument() {
		return getArgument("package");
	}

	public JsonWrapperModel removePackage() {
		return removeArgument("package");
	}

	public JsonWrapperModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public JsonWrapperModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public JsonWrapperModel removeName() {
		return removeArgument("name");
	}

	public JsonWrapperModel setNeoNodeMapper(String value) {
		return setNeoNodeMapper(db.newSTValue(value));
	}

	public JsonWrapperModel setNeoNodeMapper(STValue value) {
		return set(value, "neoNodeMapper");
	}

	public STValue getNeoNodeMapper() {
		return get("neoNodeMapper");
	}

	public STArgument getNeoNodeMapperArgument() {
		return getArgument("neoNodeMapper");
	}

	public JsonWrapperModel removeNeoNodeMapper() {
		return removeArgument("neoNodeMapper");
	}

	public JsonWrapperModel setLexical(String value) {
		return setLexical(db.newSTValue(value));
	}

	public JsonWrapperModel setLexical(STValue value) {
		return set(value, "lexical");
	}

	public STValue getLexical() {
		return get("lexical");
	}

	public STArgument getLexicalArgument() {
		return getArgument("lexical");
	}

	public JsonWrapperModel removeLexical() {
		return removeArgument("lexical");
	}

	public JsonWrapperModel addAccessors(String value) {
		return addAccessors(db.newSTValue(value));
	}

	public JsonWrapperModel addAccessors(STValue value) {
		return add(value, "accessors");
	}

	public Stream<STValue> getAccessors() {
		return stream("accessors");
	}

	public JsonWrapperModel addExternalFields(String _type, String _name, String _initializer) {
		return addExternalFields(db.newSTValue(_type), db.newSTValue(_name), db.newSTValue(_initializer));
	}

	public JsonWrapperModel addExternalFields(JsonWrapperModel_ExternalFields value) {
		return addExternalFields(value.getType(), value.getName(), value.getInitializer());
	}

	public JsonWrapperModel addExternalFields(STValue _type, STValue _name, STValue _initializer) {
		findParameter("externalFields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					addKV(_initializer, stParameter, kvs, "initializer");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<JsonWrapperModel_ExternalFields> streamExternalFields() {
		return findParameter("externalFields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new JsonWrapperModel_ExternalFields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class JsonWrapperModel_ExternalFields {

		STArgument stArgument;
		STParameter stParameter;

		public JsonWrapperModel_ExternalFields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public JsonWrapperModel_ExternalFields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public JsonWrapperModel_ExternalFields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public JsonWrapperModel_ExternalFields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public JsonWrapperModel_ExternalFields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public JsonWrapperModel_ExternalFields setInitializer(String value) {
			return setInitializer(db.newSTValue(value));
		}

		public JsonWrapperModel_ExternalFields setInitializer(STValue value) {
			return setKVValue("initializer", value);
		}

		public STValue getInitializer() {
			return getKVValue("initializer");
		}


		private JsonWrapperModel_ExternalFields setKVValue(String name, STValue value) {

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

	private JsonWrapperModel set(STValue value, String name) {
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

	private JsonWrapperModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private JsonWrapperModel add(STValue value, String name) {
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