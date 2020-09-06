package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class STDomainTestsModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "d164aa89-502b-4f40-8f32-2386299f4290";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public STDomainTestsModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public STDomainTestsModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public STDomainTestsModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public STDomainTestsModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public STDomainTestsModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STDomainTestsModel setDomainName(String value) {
		return setDomainName(db.newSTValue(value));
	}

	public STDomainTestsModel setDomainName(STValue value) {
		return set(value, "domainName");
	}

	public STValue getDomainName() {
		return get("domainName");
	}

	public STDomainTestsModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public STDomainTestsModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}


	public STDomainTestsModel addTestcases(String _name, String _impl) {
		return addTestcases(db.newSTValue(_name), db.newSTValue(_impl));
	}

	public STDomainTestsModel addTestcases(STDomainTestsModel_Testcases value) {
		return addTestcases(value.getName(), value.getImpl());
	}

	public STDomainTestsModel addTestcases(STValue _name, STValue _impl) {
		findParameter("testcases")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_impl, stParameter, kvs, "impl");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<STDomainTestsModel_Testcases> streamTestcases() {
		return findParameter("testcases")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new STDomainTestsModel_Testcases(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class STDomainTestsModel_Testcases {

		STArgument stArgument;
		STParameter stParameter;

		public STDomainTestsModel_Testcases(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public STDomainTestsModel_Testcases setName(String value) {
			return setName(db.newSTValue(value));
		}

		public STDomainTestsModel_Testcases setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public STDomainTestsModel_Testcases setImpl(String value) {
			return setImpl(db.newSTValue(value));
		}

		public STDomainTestsModel_Testcases setImpl(STValue value) {
			return setKVValue("impl", value);
		}

		public STValue getImpl() {
			return getKVValue("impl");
		}


		private STDomainTestsModel_Testcases setKVValue(String name, STValue value) {

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

	private STDomainTestsModel set(STValue value, String name) {
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

	private STDomainTestsModel add(STValue value, String name) {
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