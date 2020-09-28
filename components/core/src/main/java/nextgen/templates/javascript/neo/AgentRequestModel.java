package nextgen.templates.javascript.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AgentRequestModel {

	public static final String stGroupModelUuid = "3ff969ac-4b1c-43fb-968a-7c579bf6779b";
	public static final String stTemplateUuid = "11411a9d-db8a-4c28-9b71-3b135e55e198";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AgentRequestModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AgentRequestModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AgentRequestModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AgentRequestModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AgentRequestModel that = (AgentRequestModel) o;
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

	public AgentRequestModel setEndpoint(String value) {
		return setEndpoint(db.newSTValue(value));
	}

	public AgentRequestModel setEndpoint(STValue value) {
		return set(value, "endpoint");
	}

	public STValue getEndpoint() {
		return get("endpoint");
	}

	public STArgument getEndpointArgument() {
		return getArgument("endpoint");
	}

	public AgentRequestModel removeEndpoint() {
		return removeArgument("endpoint");
	}

	public AgentRequestModel setMethod(String value) {
		return setMethod(db.newSTValue(value));
	}

	public AgentRequestModel setMethod(STValue value) {
		return set(value, "method");
	}

	public STValue getMethod() {
		return get("method");
	}

	public STArgument getMethodArgument() {
		return getArgument("method");
	}

	public AgentRequestModel removeMethod() {
		return removeArgument("method");
	}

	public AgentRequestModel setFinally(String value) {
		return setFinally(db.newSTValue(value));
	}

	public AgentRequestModel setFinally(STValue value) {
		return set(value, "finally");
	}

	public STValue getFinally() {
		return get("finally");
	}

	public STArgument getFinallyArgument() {
		return getArgument("finally");
	}

	public AgentRequestModel removeFinally() {
		return removeArgument("finally");
	}

	public AgentRequestModel addParams(String value) {
		return addParams(db.newSTValue(value));
	}

	public AgentRequestModel addParams(STValue value) {
		return add(value, "params");
	}

	public Stream<STValue> getParams() {
		return stream("params");
	}

	public AgentRequestModel addThen(String value) {
		return addThen(db.newSTValue(value));
	}

	public AgentRequestModel addThen(STValue value) {
		return add(value, "then");
	}

	public Stream<STValue> getThen() {
		return stream("then");
	}


	private AgentRequestModel set(STValue value, String name) {
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

	private AgentRequestModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AgentRequestModel add(STValue value, String name) {
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