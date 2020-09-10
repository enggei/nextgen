package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class FrontEndMavenPluginModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "6c40ef07-6e2d-4fbe-89e3-49248b434503";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public FrontEndMavenPluginModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public FrontEndMavenPluginModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public FrontEndMavenPluginModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public FrontEndMavenPluginModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FrontEndMavenPluginModel that = (FrontEndMavenPluginModel) o;
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

	public FrontEndMavenPluginModel setPluginVersion(String value) {
		return setPluginVersion(db.newSTValue(value));
	}

	public FrontEndMavenPluginModel setPluginVersion(STValue value) {
		return set(value, "pluginVersion");
	}

	public STValue getPluginVersion() {
		return get("pluginVersion");
	}

	public STArgument getPluginVersionArgument() {
		return getArgument("pluginVersion");
	}

	public FrontEndMavenPluginModel removePluginVersion() {
		return removeArgument("pluginVersion");
	}

	public FrontEndMavenPluginModel setInstallDirectory(String value) {
		return setInstallDirectory(db.newSTValue(value));
	}

	public FrontEndMavenPluginModel setInstallDirectory(STValue value) {
		return set(value, "installDirectory");
	}

	public STValue getInstallDirectory() {
		return get("installDirectory");
	}

	public STArgument getInstallDirectoryArgument() {
		return getArgument("installDirectory");
	}

	public FrontEndMavenPluginModel removeInstallDirectory() {
		return removeArgument("installDirectory");
	}

	public FrontEndMavenPluginModel setNodeVersion(String value) {
		return setNodeVersion(db.newSTValue(value));
	}

	public FrontEndMavenPluginModel setNodeVersion(STValue value) {
		return set(value, "nodeVersion");
	}

	public STValue getNodeVersion() {
		return get("nodeVersion");
	}

	public STArgument getNodeVersionArgument() {
		return getArgument("nodeVersion");
	}

	public FrontEndMavenPluginModel removeNodeVersion() {
		return removeArgument("nodeVersion");
	}



	private FrontEndMavenPluginModel set(STValue value, String name) {
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

	private FrontEndMavenPluginModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private FrontEndMavenPluginModel add(STValue value, String name) {
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