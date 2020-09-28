package nextgen.templates.javascript.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class AgentEndpointModel {

	public static final String stGroupModelUuid = "3ff969ac-4b1c-43fb-968a-7c579bf6779b";
	public static final String stTemplateUuid = "6c458cfe-4e20-4668-b4fa-855460ef2fba";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public AgentEndpointModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public AgentEndpointModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public AgentEndpointModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public AgentEndpointModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AgentEndpointModel that = (AgentEndpointModel) o;
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

	public AgentEndpointModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public AgentEndpointModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public AgentEndpointModel removeName() {
		return removeArgument("name");
	}

	public AgentEndpointModel setUrlParam(String value) {
		return setUrlParam(db.newSTValue(value));
	}

	public AgentEndpointModel setUrlParam(STValue value) {
		return set(value, "urlParam");
	}

	public STValue getUrlParam() {
		return get("urlParam");
	}

	public STArgument getUrlParamArgument() {
		return getArgument("urlParam");
	}

	public AgentEndpointModel removeUrlParam() {
		return removeArgument("urlParam");
	}

	public AgentEndpointModel setAction(String value) {
		return setAction(db.newSTValue(value));
	}

	public AgentEndpointModel setAction(STValue value) {
		return set(value, "action");
	}

	public STValue getAction() {
		return get("action");
	}

	public STArgument getActionArgument() {
		return getArgument("action");
	}

	public AgentEndpointModel removeAction() {
		return removeArgument("action");
	}

	public AgentEndpointModel setUrl(String value) {
		return setUrl(db.newSTValue(value));
	}

	public AgentEndpointModel setUrl(STValue value) {
		return set(value, "url");
	}

	public STValue getUrl() {
		return get("url");
	}

	public STArgument getUrlArgument() {
		return getArgument("url");
	}

	public AgentEndpointModel removeUrl() {
		return removeArgument("url");
	}

	public AgentEndpointModel addParameters(String value) {
		return addParameters(db.newSTValue(value));
	}

	public AgentEndpointModel addParameters(STValue value) {
		return add(value, "parameters");
	}

	public Stream<STValue> getParameters() {
		return stream("parameters");
	}


	private AgentEndpointModel set(STValue value, String name) {
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

	private AgentEndpointModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private AgentEndpointModel add(STValue value, String name) {
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