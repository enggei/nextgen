package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class EntityKVListAccessorsModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "fc61d6f5-bac5-43ea-92fc-ac9c397cc389";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public EntityKVListAccessorsModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public EntityKVListAccessorsModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public EntityKVListAccessorsModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public EntityKVListAccessorsModel setEntity(String value) {
		return setEntity(db.newSTValue(value));
	}

	public EntityKVListAccessorsModel setEntity(STValue value) {
		return set(value, "entity");
	}

	public STValue getEntity() {
		return get("entity");
	}

	public EntityKVListAccessorsModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public EntityKVListAccessorsModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}


	public EntityKVListAccessorsModel addKeys(String _type, String _name) {
		return addKeys(db.newSTValue(_type), db.newSTValue(_name));
	}

	public EntityKVListAccessorsModel addKeys(EntityKVListAccessorsModel_Keys value) {
		return addKeys(value.getType(), value.getName());
	}

	public EntityKVListAccessorsModel addKeys(STValue _type, STValue _name) {
		findParameter("keys")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<EntityKVListAccessorsModel_Keys> streamKeys() {
		return findParameter("keys")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new EntityKVListAccessorsModel_Keys(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class EntityKVListAccessorsModel_Keys {

		STArgument stArgument;
		STParameter stParameter;

		public EntityKVListAccessorsModel_Keys(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public EntityKVListAccessorsModel_Keys setType(String value) {
			return setType(db.newSTValue(value));
		}

		public EntityKVListAccessorsModel_Keys setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public EntityKVListAccessorsModel_Keys setName(String value) {
			return setName(db.newSTValue(value));
		}

		public EntityKVListAccessorsModel_Keys setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private EntityKVListAccessorsModel_Keys setKVValue(String name, STValue value) {

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

	private EntityKVListAccessorsModel set(STValue value, String name) {
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

	private EntityKVListAccessorsModel add(STValue value, String name) {
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