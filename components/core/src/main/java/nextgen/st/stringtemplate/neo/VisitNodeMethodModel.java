package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class VisitNodeMethodModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "4c1f71a4-c5b7-4aa4-911e-228049a52dca";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public VisitNodeMethodModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public VisitNodeMethodModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public VisitNodeMethodModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public VisitNodeMethodModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public VisitNodeMethodModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public VisitNodeMethodModel setStatements(String value) {
		return setStatements(db.newSTValue(value));
	}

	public VisitNodeMethodModel setStatements(STValue value) {
		return set(value, "statements");
	}

	public STValue getStatements() {
		return get("statements");
	}


	public VisitNodeMethodModel addProperties(String _name, String _defaultValue) {
		return addProperties(db.newSTValue(_name), db.newSTValue(_defaultValue));
	}

	public VisitNodeMethodModel addProperties(VisitNodeMethodModel_Properties value) {
		return addProperties(value.getName(), value.getDefaultValue());
	}

	public VisitNodeMethodModel addProperties(STValue _name, STValue _defaultValue) {
		findParameter("properties")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_defaultValue, stParameter, kvs, "defaultValue");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<VisitNodeMethodModel_Properties> streamProperties() {
		return findParameter("properties")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new VisitNodeMethodModel_Properties(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class VisitNodeMethodModel_Properties {

		STArgument stArgument;
		STParameter stParameter;

		public VisitNodeMethodModel_Properties(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public VisitNodeMethodModel_Properties setName(String value) {
			return setName(db.newSTValue(value));
		}

		public VisitNodeMethodModel_Properties setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public VisitNodeMethodModel_Properties setDefaultValue(String value) {
			return setDefaultValue(db.newSTValue(value));
		}

		public VisitNodeMethodModel_Properties setDefaultValue(STValue value) {
			return setKVValue("defaultValue", value);
		}

		public STValue getDefaultValue() {
			return getKVValue("defaultValue");
		}


		private VisitNodeMethodModel_Properties setKVValue(String name, STValue value) {

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

	public VisitNodeMethodModel addRelations(String _name) {
		return addRelations(db.newSTValue(_name));
	}

	public VisitNodeMethodModel addRelations(VisitNodeMethodModel_Relations value) {
		return addRelations(value.getName());
	}

	public VisitNodeMethodModel addRelations(STValue _name) {
		findParameter("relations")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<VisitNodeMethodModel_Relations> streamRelations() {
		return findParameter("relations")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new VisitNodeMethodModel_Relations(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class VisitNodeMethodModel_Relations {

		STArgument stArgument;
		STParameter stParameter;

		public VisitNodeMethodModel_Relations(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public VisitNodeMethodModel_Relations setName(String value) {
			return setName(db.newSTValue(value));
		}

		public VisitNodeMethodModel_Relations setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		private VisitNodeMethodModel_Relations setKVValue(String name, STValue value) {

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

	private VisitNodeMethodModel set(STValue value, String name) {
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

	private VisitNodeMethodModel add(STValue value, String name) {
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