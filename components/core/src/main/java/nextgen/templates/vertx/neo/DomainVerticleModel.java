package nextgen.templates.vertx.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DomainVerticleModel {

	public static final String stGroupModelUuid = "68548572-6e3a-48dd-a96e-2d23030ba650";
	public static final String stTemplateUuid = "57405911-04a7-483b-97ac-497ecb3361da";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public DomainVerticleModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public DomainVerticleModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public DomainVerticleModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public DomainVerticleModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVerticleModel that = (DomainVerticleModel) o;
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

	public DomainVerticleModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public DomainVerticleModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STArgument getPackageNameArgument() {
		return getArgument("packageName");
	}

	public DomainVerticleModel removePackageName() {
		return removeArgument("packageName");
	}

	public DomainVerticleModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public DomainVerticleModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public DomainVerticleModel removeName() {
		return removeArgument("name");
	}

	public DomainVerticleModel setDomainFactory(String value) {
		return setDomainFactory(db.newSTValue(value));
	}

	public DomainVerticleModel setDomainFactory(STValue value) {
		return set(value, "domainFactory");
	}

	public STValue getDomainFactory() {
		return get("domainFactory");
	}

	public STArgument getDomainFactoryArgument() {
		return getArgument("domainFactory");
	}

	public DomainVerticleModel removeDomainFactory() {
		return removeArgument("domainFactory");
	}

	public DomainVerticleModel setDbPath(String value) {
		return setDbPath(db.newSTValue(value));
	}

	public DomainVerticleModel setDbPath(STValue value) {
		return set(value, "dbPath");
	}

	public STValue getDbPath() {
		return get("dbPath");
	}

	public STArgument getDbPathArgument() {
		return getArgument("dbPath");
	}

	public DomainVerticleModel removeDbPath() {
		return removeArgument("dbPath");
	}

	public DomainVerticleModel setAddress(String value) {
		return setAddress(db.newSTValue(value));
	}

	public DomainVerticleModel setAddress(STValue value) {
		return set(value, "address");
	}

	public STValue getAddress() {
		return get("address");
	}

	public STArgument getAddressArgument() {
		return getArgument("address");
	}

	public DomainVerticleModel removeAddress() {
		return removeArgument("address");
	}

	public DomainVerticleModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public DomainVerticleModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}

	public DomainVerticleModel addActions(String _name, String _declaration) {
		return addActions(db.newSTValue(_name), db.newSTValue(_declaration));
	}

	public DomainVerticleModel addActions(DomainVerticleModel_Actions value) {
		return addActions(value.getName(), value.getDeclaration());
	}

	public DomainVerticleModel addActions(STValue _name, STValue _declaration) {
		findParameter("actions")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_declaration, stParameter, kvs, "declaration");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<DomainVerticleModel_Actions> streamActions() {
		return findParameter("actions")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new DomainVerticleModel_Actions(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class DomainVerticleModel_Actions {

		STArgument stArgument;
		STParameter stParameter;

		public DomainVerticleModel_Actions(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public DomainVerticleModel_Actions setName(String value) {
			return setName(db.newSTValue(value));
		}

		public DomainVerticleModel_Actions setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public DomainVerticleModel_Actions setDeclaration(String value) {
			return setDeclaration(db.newSTValue(value));
		}

		public DomainVerticleModel_Actions setDeclaration(STValue value) {
			return setKVValue("declaration", value);
		}

		public STValue getDeclaration() {
			return getKVValue("declaration");
		}


		private DomainVerticleModel_Actions setKVValue(String name, STValue value) {

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

	private DomainVerticleModel set(STValue value, String name) {
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

	private DomainVerticleModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private DomainVerticleModel add(STValue value, String name) {
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