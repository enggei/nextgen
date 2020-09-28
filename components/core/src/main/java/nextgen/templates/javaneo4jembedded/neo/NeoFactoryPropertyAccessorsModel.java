package nextgen.templates.javaneo4jembedded.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NeoFactoryPropertyAccessorsModel {

	public static final String stGroupModelUuid = "78736754-0769-45f5-b4e4-eec7df6f03bc";
	public static final String stTemplateUuid = "eca7a261-a0f4-40ed-be82-eb6f1c931658";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public NeoFactoryPropertyAccessorsModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public NeoFactoryPropertyAccessorsModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public NeoFactoryPropertyAccessorsModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public NeoFactoryPropertyAccessorsModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoFactoryPropertyAccessorsModel that = (NeoFactoryPropertyAccessorsModel) o;
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

	public NeoFactoryPropertyAccessorsModel setEntity(String value) {
		return setEntity(db.newSTValue(value));
	}

	public NeoFactoryPropertyAccessorsModel setEntity(STValue value) {
		return set(value, "entity");
	}

	public STValue getEntity() {
		return get("entity");
	}

	public STArgument getEntityArgument() {
		return getArgument("entity");
	}

	public NeoFactoryPropertyAccessorsModel removeEntity() {
		return removeArgument("entity");
	}

	public NeoFactoryPropertyAccessorsModel setPropertyName(String value) {
		return setPropertyName(db.newSTValue(value));
	}

	public NeoFactoryPropertyAccessorsModel setPropertyName(STValue value) {
		return set(value, "propertyName");
	}

	public STValue getPropertyName() {
		return get("propertyName");
	}

	public STArgument getPropertyNameArgument() {
		return getArgument("propertyName");
	}

	public NeoFactoryPropertyAccessorsModel removePropertyName() {
		return removeArgument("propertyName");
	}

	public NeoFactoryPropertyAccessorsModel setPropertyType(String value) {
		return setPropertyType(db.newSTValue(value));
	}

	public NeoFactoryPropertyAccessorsModel setPropertyType(STValue value) {
		return set(value, "propertyType");
	}

	public STValue getPropertyType() {
		return get("propertyType");
	}

	public STArgument getPropertyTypeArgument() {
		return getArgument("propertyType");
	}

	public NeoFactoryPropertyAccessorsModel removePropertyType() {
		return removeArgument("propertyType");
	}

	public NeoFactoryPropertyAccessorsModel setIsEnum(String value) {
		return setIsEnum(db.newSTValue(value));
	}

	public NeoFactoryPropertyAccessorsModel setIsEnum(STValue value) {
		return set(value, "isEnum");
	}

	public STValue getIsEnum() {
		return get("isEnum");
	}

	public STArgument getIsEnumArgument() {
		return getArgument("isEnum");
	}

	public NeoFactoryPropertyAccessorsModel removeIsEnum() {
		return removeArgument("isEnum");
	}



	private NeoFactoryPropertyAccessorsModel set(STValue value, String name) {
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

	private NeoFactoryPropertyAccessorsModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private NeoFactoryPropertyAccessorsModel add(STValue value, String name) {
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