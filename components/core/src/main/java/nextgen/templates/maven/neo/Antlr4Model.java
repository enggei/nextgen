package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Antlr4Model {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "7056b832-a8a9-47ab-a195-73a14a458efc";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public Antlr4Model(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public Antlr4Model(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public Antlr4Model(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public Antlr4Model(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Antlr4Model that = (Antlr4Model) o;
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

	public Antlr4Model setVersion(String value) {
		return setVersion(db.newSTValue(value));
	}

	public Antlr4Model setVersion(STValue value) {
		return set(value, "version");
	}

	public STValue getVersion() {
		return get("version");
	}

	public STArgument getVersionArgument() {
		return getArgument("version");
	}

	public Antlr4Model removeVersion() {
		return removeArgument("version");
	}

	public Antlr4Model setSourceDirectory(String value) {
		return setSourceDirectory(db.newSTValue(value));
	}

	public Antlr4Model setSourceDirectory(STValue value) {
		return set(value, "sourceDirectory");
	}

	public STValue getSourceDirectory() {
		return get("sourceDirectory");
	}

	public STArgument getSourceDirectoryArgument() {
		return getArgument("sourceDirectory");
	}

	public Antlr4Model removeSourceDirectory() {
		return removeArgument("sourceDirectory");
	}

	public Antlr4Model setOutputDirectory(String value) {
		return setOutputDirectory(db.newSTValue(value));
	}

	public Antlr4Model setOutputDirectory(STValue value) {
		return set(value, "outputDirectory");
	}

	public STValue getOutputDirectory() {
		return get("outputDirectory");
	}

	public STArgument getOutputDirectoryArgument() {
		return getArgument("outputDirectory");
	}

	public Antlr4Model removeOutputDirectory() {
		return removeArgument("outputDirectory");
	}

	public Antlr4Model setVisitor(String value) {
		return setVisitor(db.newSTValue(value));
	}

	public Antlr4Model setVisitor(STValue value) {
		return set(value, "visitor");
	}

	public STValue getVisitor() {
		return get("visitor");
	}

	public STArgument getVisitorArgument() {
		return getArgument("visitor");
	}

	public Antlr4Model removeVisitor() {
		return removeArgument("visitor");
	}

	public Antlr4Model setListener(String value) {
		return setListener(db.newSTValue(value));
	}

	public Antlr4Model setListener(STValue value) {
		return set(value, "listener");
	}

	public STValue getListener() {
		return get("listener");
	}

	public STArgument getListenerArgument() {
		return getArgument("listener");
	}

	public Antlr4Model removeListener() {
		return removeArgument("listener");
	}

	public Antlr4Model setGoal(String value) {
		return setGoal(db.newSTValue(value));
	}

	public Antlr4Model setGoal(STValue value) {
		return set(value, "goal");
	}

	public STValue getGoal() {
		return get("goal");
	}

	public STArgument getGoalArgument() {
		return getArgument("goal");
	}

	public Antlr4Model removeGoal() {
		return removeArgument("goal");
	}

	public Antlr4Model addGrammars(String value) {
		return addGrammars(db.newSTValue(value));
	}

	public Antlr4Model addGrammars(STValue value) {
		return add(value, "grammars");
	}

	public Stream<STValue> getGrammars() {
		return stream("grammars");
	}

	public Antlr4Model addIncludes(String value) {
		return addIncludes(db.newSTValue(value));
	}

	public Antlr4Model addIncludes(STValue value) {
		return add(value, "includes");
	}

	public Stream<STValue> getIncludes() {
		return stream("includes");
	}

	public Antlr4Model addArguments(String value) {
		return addArguments(db.newSTValue(value));
	}

	public Antlr4Model addArguments(STValue value) {
		return add(value, "arguments");
	}

	public Stream<STValue> getArguments() {
		return stream("arguments");
	}


	private Antlr4Model set(STValue value, String name) {
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

	private Antlr4Model removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private Antlr4Model add(STValue value, String name) {
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