package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DomainVisitorRunnerModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "e7ca4718-14cf-4410-b594-051d6a070270";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DomainVisitorRunnerModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DomainVisitorRunnerModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DomainVisitorRunnerModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public DomainVisitorRunnerModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public DomainVisitorRunnerModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public DomainVisitorRunnerModel setRootNode(String value) {
		return setRootNode(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setRootNode(STValue value) {
		return set(value, "rootNode");
	}

	public STValue getRootNode() {
		return get("rootNode");
	}

	public DomainVisitorRunnerModel setInitStatements(String value) {
		return setInitStatements(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setInitStatements(STValue value) {
		return set(value, "initStatements");
	}

	public STValue getInitStatements() {
		return get("initStatements");
	}

	public DomainVisitorRunnerModel setEndStatements(String value) {
		return setEndStatements(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setEndStatements(STValue value) {
		return set(value, "endStatements");
	}

	public STValue getEndStatements() {
		return get("endStatements");
	}

	public DomainVisitorRunnerModel setTemplatesDir(String value) {
		return setTemplatesDir(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setTemplatesDir(STValue value) {
		return set(value, "templatesDir");
	}

	public STValue getTemplatesDir() {
		return get("templatesDir");
	}

	public DomainVisitorRunnerModel setDbDir(String value) {
		return setDbDir(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setDbDir(STValue value) {
		return set(value, "dbDir");
	}

	public STValue getDbDir() {
		return get("dbDir");
	}

	public DomainVisitorRunnerModel setEntityUuid(String value) {
		return setEntityUuid(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel setEntityUuid(STValue value) {
		return set(value, "entityUuid");
	}

	public STValue getEntityUuid() {
		return get("entityUuid");
	}

	public DomainVisitorRunnerModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}

	public DomainVisitorRunnerModel addEntityVisitors(String value) {
		return addEntityVisitors(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel addEntityVisitors(STValue value) {
		return add(value, "entityVisitors");
	}

	public Stream<STValue> getEntityVisitors() {
		return stream("entityVisitors");
	}

	public DomainVisitorRunnerModel addRelationVisitors(String value) {
		return addRelationVisitors(db.newSTValue(value));
	}

	public DomainVisitorRunnerModel addRelationVisitors(STValue value) {
		return add(value, "relationVisitors");
	}

	public Stream<STValue> getRelationVisitors() {
		return stream("relationVisitors");
	}


	private DomainVisitorRunnerModel set(STValue value, String name) {
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

	private DomainVisitorRunnerModel add(STValue value, String name) {
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