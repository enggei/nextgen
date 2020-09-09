package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PluginModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "f6b8a6ed-f3ff-4bed-9180-ea870f5b65c0";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public PluginModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public PluginModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public PluginModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public PluginModel(STModelDB db, String uuid) {
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

	public PluginModel setGroupId(String value) {
		return setGroupId(db.newSTValue(value));
	}

	public PluginModel setGroupId(STValue value) {
		return set(value, "groupId");
	}

	public STValue getGroupId() {
		return get("groupId");
	}

	public STArgument getGroupIdArgument() {
		return getArgument("groupId");
	}

	public PluginModel removeGroupId() {
		return removeArgument("groupId");
	}

	public PluginModel setArtifactId(String value) {
		return setArtifactId(db.newSTValue(value));
	}

	public PluginModel setArtifactId(STValue value) {
		return set(value, "artifactId");
	}

	public STValue getArtifactId() {
		return get("artifactId");
	}

	public STArgument getArtifactIdArgument() {
		return getArgument("artifactId");
	}

	public PluginModel removeArtifactId() {
		return removeArgument("artifactId");
	}

	public PluginModel setVersion(String value) {
		return setVersion(db.newSTValue(value));
	}

	public PluginModel setVersion(STValue value) {
		return set(value, "version");
	}

	public STValue getVersion() {
		return get("version");
	}

	public STArgument getVersionArgument() {
		return getArgument("version");
	}

	public PluginModel removeVersion() {
		return removeArgument("version");
	}

	public PluginModel addExecutions(String value) {
		return addExecutions(db.newSTValue(value));
	}

	public PluginModel addExecutions(STValue value) {
		return add(value, "executions");
	}

	public Stream<STValue> getExecutions() {
		return stream("executions");
	}

	public PluginModel addConfiguration(String _name, String _value) {
		return addConfiguration(db.newSTValue(_name), db.newSTValue(_value));
	}

	public PluginModel addConfiguration(PluginModel_Configuration value) {
		return addConfiguration(value.getName(), value.getValue());
	}

	public PluginModel addConfiguration(STValue _name, STValue _value) {
		findParameter("configuration")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_value, stParameter, kvs, "value");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<PluginModel_Configuration> streamConfiguration() {
		return findParameter("configuration")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new PluginModel_Configuration(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class PluginModel_Configuration {

		STArgument stArgument;
		STParameter stParameter;

		public PluginModel_Configuration(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public PluginModel_Configuration setName(String value) {
			return setName(db.newSTValue(value));
		}

		public PluginModel_Configuration setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public PluginModel_Configuration setValue(String value) {
			return setValue(db.newSTValue(value));
		}

		public PluginModel_Configuration setValue(STValue value) {
			return setKVValue("value", value);
		}

		public STValue getValue() {
			return getKVValue("value");
		}


		private PluginModel_Configuration setKVValue(String name, STValue value) {

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

	private PluginModel set(STValue value, String name) {
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

	private PluginModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private PluginModel add(STValue value, String name) {
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