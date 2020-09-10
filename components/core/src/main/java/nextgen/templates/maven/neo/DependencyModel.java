package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DependencyModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "68f2245d-08e1-42db-aafa-7245a5eda5b0";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DependencyModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DependencyModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DependencyModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public DependencyModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DependencyModel that = (DependencyModel) o;
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

	public DependencyModel setGroupId(String value) {
		return setGroupId(db.newSTValue(value));
	}

	public DependencyModel setGroupId(STValue value) {
		return set(value, "groupId");
	}

	public STValue getGroupId() {
		return get("groupId");
	}

	public STArgument getGroupIdArgument() {
		return getArgument("groupId");
	}

	public DependencyModel removeGroupId() {
		return removeArgument("groupId");
	}

	public DependencyModel setArtifactId(String value) {
		return setArtifactId(db.newSTValue(value));
	}

	public DependencyModel setArtifactId(STValue value) {
		return set(value, "artifactId");
	}

	public STValue getArtifactId() {
		return get("artifactId");
	}

	public STArgument getArtifactIdArgument() {
		return getArgument("artifactId");
	}

	public DependencyModel removeArtifactId() {
		return removeArgument("artifactId");
	}

	public DependencyModel setVersion(String value) {
		return setVersion(db.newSTValue(value));
	}

	public DependencyModel setVersion(STValue value) {
		return set(value, "version");
	}

	public STValue getVersion() {
		return get("version");
	}

	public STArgument getVersionArgument() {
		return getArgument("version");
	}

	public DependencyModel removeVersion() {
		return removeArgument("version");
	}

	public DependencyModel setScope(String value) {
		return setScope(db.newSTValue(value));
	}

	public DependencyModel setScope(STValue value) {
		return set(value, "scope");
	}

	public STValue getScope() {
		return get("scope");
	}

	public STArgument getScopeArgument() {
		return getArgument("scope");
	}

	public DependencyModel removeScope() {
		return removeArgument("scope");
	}

	public DependencyModel setSystemPath(String value) {
		return setSystemPath(db.newSTValue(value));
	}

	public DependencyModel setSystemPath(STValue value) {
		return set(value, "systemPath");
	}

	public STValue getSystemPath() {
		return get("systemPath");
	}

	public STArgument getSystemPathArgument() {
		return getArgument("systemPath");
	}

	public DependencyModel removeSystemPath() {
		return removeArgument("systemPath");
	}

	public DependencyModel setClassifier(String value) {
		return setClassifier(db.newSTValue(value));
	}

	public DependencyModel setClassifier(STValue value) {
		return set(value, "classifier");
	}

	public STValue getClassifier() {
		return get("classifier");
	}

	public STArgument getClassifierArgument() {
		return getArgument("classifier");
	}

	public DependencyModel removeClassifier() {
		return removeArgument("classifier");
	}

	public DependencyModel setType(String value) {
		return setType(db.newSTValue(value));
	}

	public DependencyModel setType(STValue value) {
		return set(value, "type");
	}

	public STValue getType() {
		return get("type");
	}

	public STArgument getTypeArgument() {
		return getArgument("type");
	}

	public DependencyModel removeType() {
		return removeArgument("type");
	}



	private DependencyModel set(STValue value, String name) {
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

	private DependencyModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private DependencyModel add(STValue value, String name) {
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