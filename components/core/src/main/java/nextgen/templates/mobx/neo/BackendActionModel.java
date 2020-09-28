package nextgen.templates.mobx.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class BackendActionModel {

	public static final String stGroupModelUuid = "7c268c0f-610b-427d-b42b-93cfe3e71a3e";
	public static final String stTemplateUuid = "671a98db-06fe-42bb-b7f5-306d83616d9f";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public BackendActionModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public BackendActionModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public BackendActionModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public BackendActionModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BackendActionModel that = (BackendActionModel) o;
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

	public BackendActionModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public BackendActionModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public BackendActionModel removeName() {
		return removeArgument("name");
	}

	public BackendActionModel setEndpoint(String value) {
		return setEndpoint(db.newSTValue(value));
	}

	public BackendActionModel setEndpoint(STValue value) {
		return set(value, "endpoint");
	}

	public STValue getEndpoint() {
		return get("endpoint");
	}

	public STArgument getEndpointArgument() {
		return getArgument("endpoint");
	}

	public BackendActionModel removeEndpoint() {
		return removeArgument("endpoint");
	}

	public BackendActionModel setMethod(String value) {
		return setMethod(db.newSTValue(value));
	}

	public BackendActionModel setMethod(STValue value) {
		return set(value, "method");
	}

	public STValue getMethod() {
		return get("method");
	}

	public STArgument getMethodArgument() {
		return getArgument("method");
	}

	public BackendActionModel removeMethod() {
		return removeArgument("method");
	}

	public BackendActionModel setObservable(String value) {
		return setObservable(db.newSTValue(value));
	}

	public BackendActionModel setObservable(STValue value) {
		return set(value, "observable");
	}

	public STValue getObservable() {
		return get("observable");
	}

	public STArgument getObservableArgument() {
		return getArgument("observable");
	}

	public BackendActionModel removeObservable() {
		return removeArgument("observable");
	}

	public BackendActionModel addParams(String value) {
		return addParams(db.newSTValue(value));
	}

	public BackendActionModel addParams(STValue value) {
		return add(value, "params");
	}

	public Stream<STValue> getParams() {
		return stream("params");
	}


	private BackendActionModel set(STValue value, String name) {
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

	private BackendActionModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private BackendActionModel add(STValue value, String name) {
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