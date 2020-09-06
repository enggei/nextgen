package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class STEntityModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "8f38f099-b784-4fbd-996f-8be16beb6d28";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public STEntityModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public STEntityModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public STEntityModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public STEntityModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public STEntityModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STEntityModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public STEntityModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STEntityModel setTemplate(String value) {
		return setTemplate(db.newSTValue(value));
	}

	public STEntityModel setTemplate(STValue value) {
		return set(value, "template");
	}

	public STValue getTemplate() {
		return get("template");
	}

	public STEntityModel setStString(String value) {
		return setStString(db.newSTValue(value));
	}

	public STEntityModel setStString(STValue value) {
		return set(value, "stString");
	}

	public STValue getStString() {
		return get("stString");
	}

	public STEntityModel addInterfaces(String value) {
		return addInterfaces(db.newSTValue(value));
	}

	public STEntityModel addInterfaces(STValue value) {
		return add(value, "interfaces");
	}

	public Stream<STValue> getInterfaces() {
		return stream("interfaces");
	}

	public STEntityModel addSingleAccessors(String value) {
		return addSingleAccessors(db.newSTValue(value));
	}

	public STEntityModel addSingleAccessors(STValue value) {
		return add(value, "singleAccessors");
	}

	public Stream<STValue> getSingleAccessors() {
		return stream("singleAccessors");
	}

	public STEntityModel addListAccessors(String value) {
		return addListAccessors(db.newSTValue(value));
	}

	public STEntityModel addListAccessors(STValue value) {
		return add(value, "listAccessors");
	}

	public Stream<STValue> getListAccessors() {
		return stream("listAccessors");
	}

	public STEntityModel addKvListAccessors(String value) {
		return addKvListAccessors(db.newSTValue(value));
	}

	public STEntityModel addKvListAccessors(STValue value) {
		return add(value, "kvListAccessors");
	}

	public Stream<STValue> getKvListAccessors() {
		return stream("kvListAccessors");
	}

	public STEntityModel addSingleFields(String _type, String _name) {
		return addSingleFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public STEntityModel addSingleFields(STEntityModel_SingleFields value) {
		return addSingleFields(value.getType(), value.getName());
	}

	public STEntityModel addSingleFields(STValue _type, STValue _name) {
		findParameter("singleFields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<STEntityModel_SingleFields> streamSingleFields() {
		return findParameter("singleFields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new STEntityModel_SingleFields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class STEntityModel_SingleFields {

		STArgument stArgument;
		STParameter stParameter;

		public STEntityModel_SingleFields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public STEntityModel_SingleFields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public STEntityModel_SingleFields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public STEntityModel_SingleFields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public STEntityModel_SingleFields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private STEntityModel_SingleFields setKVValue(String name, STValue value) {

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

	public STEntityModel addListFields(String _type, String _name) {
		return addListFields(db.newSTValue(_type), db.newSTValue(_name));
	}

	public STEntityModel addListFields(STEntityModel_ListFields value) {
		return addListFields(value.getType(), value.getName());
	}

	public STEntityModel addListFields(STValue _type, STValue _name) {
		findParameter("listFields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<STEntityModel_ListFields> streamListFields() {
		return findParameter("listFields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new STEntityModel_ListFields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class STEntityModel_ListFields {

		STArgument stArgument;
		STParameter stParameter;

		public STEntityModel_ListFields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public STEntityModel_ListFields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public STEntityModel_ListFields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public STEntityModel_ListFields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public STEntityModel_ListFields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private STEntityModel_ListFields setKVValue(String name, STValue value) {

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

	public STEntityModel addKvListFields(String _name, String _aggrSpec, String _aggrValues) {
		return addKvListFields(db.newSTValue(_name), db.newSTValue(_aggrSpec), db.newSTValue(_aggrValues));
	}

	public STEntityModel addKvListFields(STEntityModel_KvListFields value) {
		return addKvListFields(value.getName(), value.getAggrSpec(), value.getAggrValues());
	}

	public STEntityModel addKvListFields(STValue _name, STValue _aggrSpec, STValue _aggrValues) {
		findParameter("kvListFields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_aggrSpec, stParameter, kvs, "aggrSpec");
					addKV(_aggrValues, stParameter, kvs, "aggrValues");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<STEntityModel_KvListFields> streamKvListFields() {
		return findParameter("kvListFields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new STEntityModel_KvListFields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class STEntityModel_KvListFields {

		STArgument stArgument;
		STParameter stParameter;

		public STEntityModel_KvListFields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public STEntityModel_KvListFields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public STEntityModel_KvListFields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public STEntityModel_KvListFields setAggrSpec(String value) {
			return setAggrSpec(db.newSTValue(value));
		}

		public STEntityModel_KvListFields setAggrSpec(STValue value) {
			return setKVValue("aggrSpec", value);
		}

		public STValue getAggrSpec() {
			return getKVValue("aggrSpec");
		}


		public STEntityModel_KvListFields setAggrValues(String value) {
			return setAggrValues(db.newSTValue(value));
		}

		public STEntityModel_KvListFields setAggrValues(STValue value) {
			return setKVValue("aggrValues", value);
		}

		public STValue getAggrValues() {
			return getKVValue("aggrValues");
		}


		private STEntityModel_KvListFields setKVValue(String name, STValue value) {

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

	private STEntityModel set(STValue value, String name) {
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

	private STEntityModel add(STValue value, String name) {
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