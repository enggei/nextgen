package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ProjectModel {

	public static final String stGroupModelUuid = "942af5aa-e21e-4cf7-b989-7199bb89b8fd";
	public static final String stTemplateUuid = "2e6c8640-2fa7-47f0-8fa6-a66683ff7301";

	private final STModelDB db;
	private final STModel stModel;
	private final STTemplate stTemplate;

	public ProjectModel(STModelDB db) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
	}

	public ProjectModel(STModelDB db, STModel stModel) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = stModel;
	}

	public ProjectModel(STModelDB db, org.neo4j.graphdb.Node node) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.newSTModel(node);
	}

	public ProjectModel(STModelDB db, String uuid) {
		this.db = db;
		this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
		this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
	}

	public String getUuid() {
		return stModel.getUuid();
	}

	public STValue asSTValue () {
		return db.newSTValue(stModel);
	}

	public ProjectModel setPackageName(String value) {
		return setPackageName(db.newSTValue(value));
	}

	public ProjectModel setPackageName(STValue value) {
		return set(value, "packageName");
	}

	public STValue getPackageName() {
		return get("packageName");
	}

	public STArgument getPackageNameArgument() {
		return getArgument("packageName");
	}

	public ProjectModel removePackageName() {
		return removeArgument("packageName");
	}

	public ProjectModel setName(String value) {
		return setName(db.newSTValue(value));
	}

	public ProjectModel setName(STValue value) {
		return set(value, "name");
	}

	public STValue getName() {
		return get("name");
	}

	public STArgument getNameArgument() {
		return getArgument("name");
	}

	public ProjectModel removeName() {
		return removeArgument("name");
	}

	public ProjectModel setRoot(String value) {
		return setRoot(db.newSTValue(value));
	}

	public ProjectModel setRoot(STValue value) {
		return set(value, "root");
	}

	public STValue getRoot() {
		return get("root");
	}

	public STArgument getRootArgument() {
		return getArgument("root");
	}

	public ProjectModel removeRoot() {
		return removeArgument("root");
	}

	public ProjectModel addTemplates(String value) {
		return addTemplates(db.newSTValue(value));
	}

	public ProjectModel addTemplates(STValue value) {
		return add(value, "templates");
	}

	public Stream<STValue> getTemplates() {
		return stream("templates");
	}

	public ProjectModel addImports(String value) {
		return addImports(db.newSTValue(value));
	}

	public ProjectModel addImports(STValue value) {
		return add(value, "imports");
	}

	public Stream<STValue> getImports() {
		return stream("imports");
	}

	public ProjectModel addPackageDeclarations(String value) {
		return addPackageDeclarations(db.newSTValue(value));
	}

	public ProjectModel addPackageDeclarations(STValue value) {
		return add(value, "packageDeclarations");
	}

	public Stream<STValue> getPackageDeclarations() {
		return stream("packageDeclarations");
	}

	public ProjectModel addGenerators(String value) {
		return addGenerators(db.newSTValue(value));
	}

	public ProjectModel addGenerators(STValue value) {
		return add(value, "generators");
	}

	public Stream<STValue> getGenerators() {
		return stream("generators");
	}

	public ProjectModel addMethods(String value) {
		return addMethods(db.newSTValue(value));
	}

	public ProjectModel addMethods(STValue value) {
		return add(value, "methods");
	}

	public Stream<STValue> getMethods() {
		return stream("methods");
	}

	public ProjectModel addFiles(String _name, String _parent, String _path) {
		return addFiles(db.newSTValue(_name), db.newSTValue(_parent), db.newSTValue(_path));
	}

	public ProjectModel addFiles(ProjectModel_Files value) {
		return addFiles(value.getName(), value.getParent(), value.getPath());
	}

	public ProjectModel addFiles(STValue _name, STValue _parent, STValue _path) {
		findParameter("files")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_name, stParameter, kvs, "name");
					addKV(_parent, stParameter, kvs, "parent");
					addKV(_path, stParameter, kvs, "path");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ProjectModel_Files> streamFiles() {
		return findParameter("files")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ProjectModel_Files(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ProjectModel_Files {

		STArgument stArgument;
		STParameter stParameter;

		public ProjectModel_Files(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ProjectModel_Files setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ProjectModel_Files setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ProjectModel_Files setParent(String value) {
			return setParent(db.newSTValue(value));
		}

		public ProjectModel_Files setParent(STValue value) {
			return setKVValue("parent", value);
		}

		public STValue getParent() {
			return getKVValue("parent");
		}


		public ProjectModel_Files setPath(String value) {
			return setPath(db.newSTValue(value));
		}

		public ProjectModel_Files setPath(STValue value) {
			return setKVValue("path", value);
		}

		public STValue getPath() {
			return getKVValue("path");
		}


		private ProjectModel_Files setKVValue(String name, STValue value) {

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

	public ProjectModel addFields(String _type, String _name, String _init) {
		return addFields(db.newSTValue(_type), db.newSTValue(_name), db.newSTValue(_init));
	}

	public ProjectModel addFields(ProjectModel_Fields value) {
		return addFields(value.getType(), value.getName(), value.getInit());
	}

	public ProjectModel addFields(STValue _type, STValue _name, STValue _init) {
		findParameter("fields")
				.ifPresent(stParameter -> {
					final Collection<STArgumentKV> kvs = new ArrayList<>();
					addKV(_type, stParameter, kvs, "type");
					addKV(_name, stParameter, kvs, "name");
					addKV(_init, stParameter, kvs, "init");
					db.newSTArgument(stParameter, kvs);
				});

		return this;
	}

	public java.util.stream.Stream<ProjectModel_Fields> streamFields() {
		return findParameter("fields")
				.map(stParameter -> stModel.getArguments()
						.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
						.map(stArgument -> new ProjectModel_Fields(stArgument, stParameter)))
				.orElseGet(Stream::empty);
	}

	public final class ProjectModel_Fields {

		STArgument stArgument;
		STParameter stParameter;

		public ProjectModel_Fields(STArgument stArgument, STParameter stParameter) {
			this.stArgument = stArgument;
			this.stParameter = stParameter;
		}

		public ProjectModel_Fields setType(String value) {
			return setType(db.newSTValue(value));
		}

		public ProjectModel_Fields setType(STValue value) {
			return setKVValue("type", value);
		}

		public STValue getType() {
			return getKVValue("type");
		}


		public ProjectModel_Fields setName(String value) {
			return setName(db.newSTValue(value));
		}

		public ProjectModel_Fields setName(STValue value) {
			return setKVValue("name", value);
		}

		public STValue getName() {
			return getKVValue("name");
		}


		public ProjectModel_Fields setInit(String value) {
			return setInit(db.newSTValue(value));
		}

		public ProjectModel_Fields setInit(STValue value) {
			return setKVValue("init", value);
		}

		public STValue getInit() {
			return getKVValue("init");
		}


		private ProjectModel_Fields setKVValue(String name, STValue value) {

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

	private ProjectModel set(STValue value, String name) {
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

	private ProjectModel removeArgument(String name) {
		final STArgument stArgument = getArgument(name);
		if (stArgument != null) stModel.removeArguments(stArgument);
		return this;
	}

	private ProjectModel add(STValue value, String name) {
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