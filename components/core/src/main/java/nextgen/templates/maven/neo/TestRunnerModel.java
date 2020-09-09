package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class TestRunnerModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "56ca8fd0-4b29-479b-bab3-9513c826fab6";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public TestRunnerModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public TestRunnerModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public TestRunnerModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public TestRunnerModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	public String getUuid() {
		return stModel.getUuid();
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public TestRunnerModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public TestRunnerModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STArgument getPackageNameArgument() {
		return getArgument("packageName");
	}

	public TestRunnerModel removePackageName() {
		return removeArgument("packageName");
	}

	public TestRunnerModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public TestRunnerModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public TestRunnerModel removeName() {
		return removeArgument("name");
	}

	public TestRunnerModel setProjectName(String value) {
		return setProjectName(db.newSTValue(value));
	}

	public TestRunnerModel setProjectName(STValue value) {
		return set(value, "projectName");
	}

	public STValue getProjectName() {
		return get("projectName");
	}

	public STArgument getProjectNameArgument() {
		return getArgument("projectName");
	}

	public TestRunnerModel removeProjectName() {
		return removeArgument("projectName");
	}


	public TestRunnerModel addGenerators(String _name, String _run) {
		return addGenerators(db.newSTValue(_name), db.newSTValue(_run));
	}

	public TestRunnerModel addGenerators(TestRunnerModel_Generators value) {
		return addGenerators(value.getName(), value.getRun());
	}

	public TestRunnerModel addGenerators(STValue _name, STValue _run) {
		findParameter("generators")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_run, stParameter, kvs, "run");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<TestRunnerModel_Generators> streamGenerators() {
		return findParameter("generators")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new TestRunnerModel_Generators(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class TestRunnerModel_Generators {

		STArgument stArgument;
		STParameter stParameter;

		public TestRunnerModel_Generators(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public TestRunnerModel_Generators setName(String value) {
			return setName(db.newSTValue(value));
		}

		public TestRunnerModel_Generators setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public TestRunnerModel_Generators setRun(String value) {
			return setRun(db.newSTValue(value));
		}

		public TestRunnerModel_Generators setRun(STValue value) {
			return setKVValue("run", value);
		}

		public STValue getRun() {
			return getKVValue("run");
		}


		private TestRunnerModel_Generators setKVValue(String name, STValue value) {

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

	private TestRunnerModel set(STValue value, String name) {
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

	private TestRunnerModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private TestRunnerModel add(STValue value, String name) {
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