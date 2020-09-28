package nextgen.templates.javaneo4jembedded.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NodeWrapperModel {

	public static final String stGroupModelUuid = "78736754-0769-45f5-b4e4-eec7df6f03bc";
	public static final String stTemplateUuid = "bbe1e861-a07d-4516-ac58-76059fd89ed4";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public NodeWrapperModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public NodeWrapperModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public NodeWrapperModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public NodeWrapperModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeWrapperModel that = (NodeWrapperModel) o;
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

	public NodeWrapperModel setPackage(String value) {
		return setPackage(db.newSTValue(value));
	}

	public NodeWrapperModel setPackage(STValue value) {
		return set(value, "package");
	}

	public STValue getPackage() {
		return get("package");
	}

	public STArgument getPackageArgument() {
		return getArgument("package");
	}

	public NodeWrapperModel removePackage() {
		return removeArgument("package");
	}

	public NodeWrapperModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public NodeWrapperModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public NodeWrapperModel removeName() {
		return removeArgument("name");
	}

	public NodeWrapperModel addAccessors(String value) {
		return addAccessors(db.newSTValue(value));
	}

	public NodeWrapperModel addAccessors(STValue value) {
		return add(value, "accessors");
	}

	public Stream<STValue> getAccessors() {
		return stream("accessors");
	}

	public NodeWrapperModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public NodeWrapperModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public NodeWrapperModel addExternalFields(String _type, String _name, String _initializer) {
		return addExternalFields(db.newSTValue(_type), db.newSTValue(_name), db.newSTValue(_initializer));
	}

	public NodeWrapperModel addExternalFields(NodeWrapperModel_ExternalFields value) {
		return addExternalFields(value.getType(), value.getName(), value.getInitializer());
	}

	public NodeWrapperModel addExternalFields(STValue _type, STValue _name, STValue _initializer) {
		findParameter("externalFields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					addKV(_initializer, stParameter, kvs, "initializer");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<NodeWrapperModel_ExternalFields> streamExternalFields() {
		return findParameter("externalFields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new NodeWrapperModel_ExternalFields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class NodeWrapperModel_ExternalFields {

		STArgument stArgument;
		STParameter stParameter;

		public NodeWrapperModel_ExternalFields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public NodeWrapperModel_ExternalFields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public NodeWrapperModel_ExternalFields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public NodeWrapperModel_ExternalFields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public NodeWrapperModel_ExternalFields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public NodeWrapperModel_ExternalFields setInitializer(String value) {
			return setInitializer(db.newSTValue(value));
		}

		public NodeWrapperModel_ExternalFields setInitializer(STValue value) {
			return setKVValue("initializer", value);
		}

		public STValue getInitializer() {
			return getKVValue("initializer");
		}


		private NodeWrapperModel_ExternalFields setKVValue(String name, STValue value) {

			stParameter.getKeys()
					.filter(stParameterKey -> stParameterKey.getName().equals(name))
					.findAny()
					.ifPresent(stParameterKey -> {

						stArgument.getKeyValues()
								.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
								.findAny()
								.ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

						stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
					});

			return this;
		}

		private STValue getKVValue(String name) {
			final AtomicReference<STValue> value = new AtomicReference<>();
			stParameter.getKeys()
					.filter(param -> param.getName().equals(name))
					.findFirst().flatMap(stParameter -> stArgument.getKeyValues()
					.filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
					.findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

			return value.get();
		}
	}

	private NodeWrapperModel set(STValue value, String name) {
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

	private NodeWrapperModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private NodeWrapperModel add(STValue value, String name) {
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