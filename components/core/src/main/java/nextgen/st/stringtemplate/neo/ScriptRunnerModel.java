package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ScriptRunnerModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "06ee0aa9-0256-4eec-bd46-ba8d8348fa97";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ScriptRunnerModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ScriptRunnerModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ScriptRunnerModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public ScriptRunnerModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public ScriptRunnerModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public ScriptRunnerModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public ScriptRunnerModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public ScriptRunnerModel setScript(String value) {
		return setScript(db.newSTValue(value));
	}

	public ScriptRunnerModel setScript(STValue value) {
		return set(value, "script");
	}

	public STValue getScript() {
		return get("script");
	}

	public ScriptRunnerModel setTemplatesDir(String value) {
		return setTemplatesDir(db.newSTValue(value));
	}

	public ScriptRunnerModel setTemplatesDir(STValue value) {
		return set(value, "templatesDir");
	}

	public STValue getTemplatesDir() {
		return get("templatesDir");
	}

	public ScriptRunnerModel setDbDir(String value) {
		return setDbDir(db.newSTValue(value));
	}

	public ScriptRunnerModel setDbDir(STValue value) {
		return set(value, "dbDir");
	}

	public STValue getDbDir() {
		return get("dbDir");
	}

	public ScriptRunnerModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public ScriptRunnerModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}


	private ScriptRunnerModel set(STValue value, String name) {
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

	private ScriptRunnerModel add(STValue value, String name) {
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