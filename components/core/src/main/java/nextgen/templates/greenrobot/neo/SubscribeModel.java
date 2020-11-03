package nextgen.templates.greenrobot.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class SubscribeModel {

	public static final String stGroupModelUuid = "fd17be4e-a3b6-4b52-a001-b0b3257b6f21";
	public static final String stTemplateUuid = "cd296481-8ea7-40f4-bb63-e85017f87f13";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public SubscribeModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public SubscribeModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public SubscribeModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public SubscribeModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SubscribeModel that = (SubscribeModel) o;
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

	public SubscribeModel setThreadMode(String value) {
		return setThreadMode(db.newSTValue(value));
	}

	public SubscribeModel setThreadMode(STValue value) {
		return set(value, "threadMode");
	}

	public STValue getThreadMode() {
		return get("threadMode");
	}

	public STArgument getThreadModeArgument() {
		return getArgument("threadMode");
	}

	public SubscribeModel removeThreadMode() {
		return removeArgument("threadMode");
	}

	public SubscribeModel setEventName(String value) {
		return setEventName(db.newSTValue(value));
	}

	public SubscribeModel setEventName(STValue value) {
		return set(value, "eventName");
	}

	public STValue getEventName() {
		return get("eventName");
	}

	public STArgument getEventNameArgument() {
		return getArgument("eventName");
	}

	public SubscribeModel removeEventName() {
		return removeArgument("eventName");
	}

	public SubscribeModel setEventType(String value) {
		return setEventType(db.newSTValue(value));
	}

	public SubscribeModel setEventType(STValue value) {
		return set(value, "eventType");
	}

	public STValue getEventType() {
		return get("eventType");
	}

	public STArgument getEventTypeArgument() {
		return getArgument("eventType");
	}

	public SubscribeModel removeEventType() {
		return removeArgument("eventType");
	}

	public SubscribeModel addStatements(String value) {
		return addStatements(db.newSTValue(value));
	}

	public SubscribeModel addStatements(STValue value) {
		return add(value, "statements");
	}

	public Stream<STValue> getStatements() {
		return stream("statements");
	}


	private SubscribeModel set(STValue value, String name) {
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

	private SubscribeModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private SubscribeModel add(STValue value, String name) {
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