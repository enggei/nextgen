package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NeoEntityModel {

	public static final String stGroupModelUuid = "22979c7d-7514-4e8f-8b11-77b4f3d6b7d0";
   public static final String stTemplateUuid = "7a6aa696-d7a3-4606-9a06-e113274ca0fe";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public NeoEntityModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public NeoEntityModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public NeoEntityModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public NeoEntityModel setPackage(String value) {
		return setPackage(db.newSTValue(value));
	}

	public NeoEntityModel setPackage(STValue value) {
		return set(value, "package");
	}

	public STValue getPackage() {
		return get("package");
	}

	public NeoEntityModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public NeoEntityModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public NeoEntityModel setStGroupModel(String value) {
		return setStGroupModel(db.newSTValue(value));
	}

	public NeoEntityModel setStGroupModel(STValue value) {
		return set(value, "stGroupModel");
	}

	public STValue getStGroupModel() {
		return get("stGroupModel");
	}

	public NeoEntityModel setStTemplate(String value) {
		return setStTemplate(db.newSTValue(value));
	}

	public NeoEntityModel setStTemplate(STValue value) {
		return set(value, "stTemplate");
	}

	public STValue getStTemplate() {
		return get("stTemplate");
	}

	public NeoEntityModel addSingleAccessors(String value) {
		return addSingleAccessors(db.newSTValue(value));
	}

	public NeoEntityModel addSingleAccessors(STValue value) {
		return add(value, "singleAccessors");
	}

	public Stream<STValue> getSingleAccessors() {
		return stream("singleAccessors");
	}

	public NeoEntityModel addListAccessors(String value) {
		return addListAccessors(db.newSTValue(value));
	}

	public NeoEntityModel addListAccessors(STValue value) {
		return add(value, "listAccessors");
	}

	public Stream<STValue> getListAccessors() {
		return stream("listAccessors");
	}

	public NeoEntityModel addKvAccessors(String value) {
		return addKvAccessors(db.newSTValue(value));
	}

	public NeoEntityModel addKvAccessors(STValue value) {
		return add(value, "kvAccessors");
	}

	public Stream<STValue> getKvAccessors() {
		return stream("kvAccessors");
	}


	private NeoEntityModel set(STValue value, String name) {
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

	private NeoEntityModel add(STValue value, String name) {
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