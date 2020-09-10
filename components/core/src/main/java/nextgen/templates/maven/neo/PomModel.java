package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PomModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "7a760f05-7071-4259-a27b-8abfbf1d6ce1";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public PomModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public PomModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public PomModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public PomModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PomModel that = (PomModel) o;
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

	public PomModel setParent(String value) {
		return setParent(db.newSTValue(value));
	}

	public PomModel setParent(STValue value) {
		return set(value, "parent");
	}

	public STValue getParent() {
		return get("parent");
	}

	public STArgument getParentArgument() {
		return getArgument("parent");
	}

	public PomModel removeParent() {
		return removeArgument("parent");
	}

	public PomModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public PomModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public PomModel removeName() {
		return removeArgument("name");
	}

	public PomModel setGroupId(String value) {
		return setGroupId(db.newSTValue(value));
	}

	public PomModel setGroupId(STValue value) {
		return set(value, "groupId");
	}

	public STValue getGroupId() {
		return get("groupId");
	}

	public STArgument getGroupIdArgument() {
		return getArgument("groupId");
	}

	public PomModel removeGroupId() {
		return removeArgument("groupId");
	}

	public PomModel setArtifactId(String value) {
		return setArtifactId(db.newSTValue(value));
	}

	public PomModel setArtifactId(STValue value) {
		return set(value, "artifactId");
	}

	public STValue getArtifactId() {
		return get("artifactId");
	}

	public STArgument getArtifactIdArgument() {
		return getArgument("artifactId");
	}

	public PomModel removeArtifactId() {
		return removeArgument("artifactId");
	}

	public PomModel setVersion(String value) {
		return setVersion(db.newSTValue(value));
	}

	public PomModel setVersion(STValue value) {
		return set(value, "version");
	}

	public STValue getVersion() {
		return get("version");
	}

	public STArgument getVersionArgument() {
		return getArgument("version");
	}

	public PomModel removeVersion() {
		return removeArgument("version");
	}

	public PomModel setPackaging(String value) {
		return setPackaging(db.newSTValue(value));
	}

	public PomModel setPackaging(STValue value) {
		return set(value, "packaging");
	}

	public STValue getPackaging() {
		return get("packaging");
	}

	public STArgument getPackagingArgument() {
		return getArgument("packaging");
	}

	public PomModel removePackaging() {
		return removeArgument("packaging");
	}

	public PomModel setBuild(String value) {
		return setBuild(db.newSTValue(value));
	}

	public PomModel setBuild(STValue value) {
		return set(value, "build");
	}

	public STValue getBuild() {
		return get("build");
	}

	public STArgument getBuildArgument() {
		return getArgument("build");
	}

	public PomModel removeBuild() {
		return removeArgument("build");
	}

	public PomModel setDependencyManagement(String value) {
		return setDependencyManagement(db.newSTValue(value));
	}

	public PomModel setDependencyManagement(STValue value) {
		return set(value, "dependencyManagement");
	}

	public STValue getDependencyManagement() {
		return get("dependencyManagement");
	}

	public STArgument getDependencyManagementArgument() {
		return getArgument("dependencyManagement");
	}

	public PomModel removeDependencyManagement() {
		return removeArgument("dependencyManagement");
	}

	public PomModel addModules(String value) {
		return addModules(db.newSTValue(value));
	}

	public PomModel addModules(STValue value) {
		return add(value, "modules");
	}

	public Stream<STValue> getModules() {
		return stream("modules");
	}

	public PomModel addProperties(String value) {
		return addProperties(db.newSTValue(value));
	}

	public PomModel addProperties(STValue value) {
		return add(value, "properties");
	}

	public Stream<STValue> getProperties() {
		return stream("properties");
	}

	public PomModel addDependencies(String value) {
		return addDependencies(db.newSTValue(value));
	}

	public PomModel addDependencies(STValue value) {
		return add(value, "dependencies");
	}

	public Stream<STValue> getDependencies() {
		return stream("dependencies");
	}

	public PomModel addDistributionManagement(String value) {
		return addDistributionManagement(db.newSTValue(value));
	}

	public PomModel addDistributionManagement(STValue value) {
		return add(value, "distributionManagement");
	}

	public Stream<STValue> getDistributionManagement() {
		return stream("distributionManagement");
	}

	public PomModel addRepositories(String value) {
		return addRepositories(db.newSTValue(value));
	}

	public PomModel addRepositories(STValue value) {
		return add(value, "repositories");
	}

	public Stream<STValue> getRepositories() {
		return stream("repositories");
	}


	private PomModel set(STValue value, String name) {
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

	private PomModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private PomModel add(STValue value, String name) {
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