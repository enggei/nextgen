package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NeoDomainModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "f42e249c-c3c6-4fd3-8afa-1e8dd8db89a5";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public NeoDomainModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public NeoDomainModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public NeoDomainModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public NeoDomainModel setPackage(String value) {
		return setPackage(db.newSTValue(value));
	}

	public NeoDomainModel setPackage(STValue value) {
		return set(value, "package");
	}

	public STValue getPackage() {
		return get("package");
	}

	public NeoDomainModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public NeoDomainModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public NeoDomainModel addFinders(String value) {
		return addFinders(db.newSTValue(value));
	}

	public NeoDomainModel addFinders(STValue value) {
		return add(value, "finders");
	}

	public Stream<STValue> getFinders() {
		return stream("finders");
	}

	public NeoDomainModel addEntities(String _name) {
		return addEntities(db.newSTValue(_name));
	}

	public NeoDomainModel addEntities(NeoDomainModel_Entities value) {
		return addEntities(value.getName());
	}

	public NeoDomainModel addEntities(STValue _name) {
		findParameter("entities")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<NeoDomainModel_Entities> streamEntities() {
		return findParameter("entities")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new NeoDomainModel_Entities(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class NeoDomainModel_Entities {

		STArgument stArgument;
		STParameter stParameter;

		public NeoDomainModel_Entities(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public NeoDomainModel_Entities setName(String value) {
			return setName(db.newSTValue(value));
		}

		public NeoDomainModel_Entities setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private NeoDomainModel_Entities setKVValue(String name, STValue value) {

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

	private NeoDomainModel set(STValue value, String name) {
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

	private NeoDomainModel add(STValue value, String name) {
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