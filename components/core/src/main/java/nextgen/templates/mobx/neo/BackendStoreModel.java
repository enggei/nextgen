package nextgen.templates.mobx.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class BackendStoreModel {

	public static final String stGroupModelUuid = "7c268c0f-610b-427d-b42b-93cfe3e71a3e";
	public static final String stTemplateUuid = "0e361b02-09c8-4b21-8af1-336769f15076";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public BackendStoreModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public BackendStoreModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public BackendStoreModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public BackendStoreModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BackendStoreModel that = (BackendStoreModel) o;
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

	public BackendStoreModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public BackendStoreModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public BackendStoreModel removeName() {
		return removeArgument("name");
	}

	public BackendStoreModel addObservables(String value) {
		return addObservables(db.newSTValue(value));
	}

	public BackendStoreModel addObservables(STValue value) {
		return add(value, "observables");
	}

	public Stream<STValue> getObservables() {
		return stream("observables");
	}

	public BackendStoreModel addConstructorStatements(String value) {
		return addConstructorStatements(db.newSTValue(value));
	}

	public BackendStoreModel addConstructorStatements(STValue value) {
		return add(value, "constructorStatements");
	}

	public Stream<STValue> getConstructorStatements() {
		return stream("constructorStatements");
	}

	public BackendStoreModel addActions(String value) {
		return addActions(db.newSTValue(value));
	}

	public BackendStoreModel addActions(STValue value) {
		return add(value, "actions");
	}

	public Stream<STValue> getActions() {
		return stream("actions");
	}

	public BackendStoreModel addBackendActions(String value) {
		return addBackendActions(db.newSTValue(value));
	}

	public BackendStoreModel addBackendActions(STValue value) {
		return add(value, "backendActions");
	}

	public Stream<STValue> getBackendActions() {
		return stream("backendActions");
	}

	public BackendStoreModel addImports(String _ref, String _path) {
		return addImports(db.newSTValue(_ref), db.newSTValue(_path));
	}

	public BackendStoreModel addImports(BackendStoreModel_Imports value) {
		return addImports(value.getRef(), value.getPath());
	}

	public BackendStoreModel addImports(STValue _ref, STValue _path) {
		findParameter("imports")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_ref, stParameter, kvs, "ref");
					addKV(_path, stParameter, kvs, "path");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<BackendStoreModel_Imports> streamImports() {
		return findParameter("imports")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new BackendStoreModel_Imports(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class BackendStoreModel_Imports {

		STArgument stArgument;
		STParameter stParameter;

		public BackendStoreModel_Imports(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public BackendStoreModel_Imports setRef(String value) {
			return setRef(db.newSTValue(value));
		}

		public BackendStoreModel_Imports setRef(STValue value) {
			return setKVValue("ref", value);
		}

		public STValue getRef() {
			return getKVValue("ref");
		}


		public BackendStoreModel_Imports setPath(String value) {
			return setPath(db.newSTValue(value));
		}

		public BackendStoreModel_Imports setPath(STValue value) {
			return setKVValue("path", value);
		}

		public STValue getPath() {
			return getKVValue("path");
		}


		private BackendStoreModel_Imports setKVValue(String name, STValue value) {

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

	private BackendStoreModel set(STValue value, String name) {
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

	private BackendStoreModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private BackendStoreModel add(STValue value, String name) {
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