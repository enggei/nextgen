package nextgen.templates.maven.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class MavenNeo {

	private final STModelDB db;

	public MavenNeo(STModelDB db) {
		this.db = db;
	}

	public PomModel newPomModel() {
		return new PomModel(db);
	}

	public PomModel newPomModel(STModel stModel) {
		return new PomModel(db, stModel);
	}

	public PomModel newPomModel(Node node) {
		return new PomModel(db, node);
	}

	public Stream<PomModel> findAllPomModel() {
		return db.findAllSTModelByStTemplate(PomModel.stTemplateUuid)
				.map(stModel -> new PomModel(db, stModel));
	}

	public PomModel findPomModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PomModel(db, uuid) : new PomModel(db, stModel);
	}


	public BuildModel newBuildModel() {
		return new BuildModel(db);
	}

	public BuildModel newBuildModel(STModel stModel) {
		return new BuildModel(db, stModel);
	}

	public BuildModel newBuildModel(Node node) {
		return new BuildModel(db, node);
	}

	public Stream<BuildModel> findAllBuildModel() {
		return db.findAllSTModelByStTemplate(BuildModel.stTemplateUuid)
				.map(stModel -> new BuildModel(db, stModel));
	}

	public BuildModel findBuildModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BuildModel(db, uuid) : new BuildModel(db, stModel);
	}


	public ParentModel newParentModel() {
		return new ParentModel(db);
	}

	public ParentModel newParentModel(STModel stModel) {
		return new ParentModel(db, stModel);
	}

	public ParentModel newParentModel(Node node) {
		return new ParentModel(db, node);
	}

	public Stream<ParentModel> findAllParentModel() {
		return db.findAllSTModelByStTemplate(ParentModel.stTemplateUuid)
				.map(stModel -> new ParentModel(db, stModel));
	}

	public ParentModel findParentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ParentModel(db, uuid) : new ParentModel(db, stModel);
	}


	public PropertiesModel newPropertiesModel() {
		return new PropertiesModel(db);
	}

	public PropertiesModel newPropertiesModel(STModel stModel) {
		return new PropertiesModel(db, stModel);
	}

	public PropertiesModel newPropertiesModel(Node node) {
		return new PropertiesModel(db, node);
	}

	public Stream<PropertiesModel> findAllPropertiesModel() {
		return db.findAllSTModelByStTemplate(PropertiesModel.stTemplateUuid)
				.map(stModel -> new PropertiesModel(db, stModel));
	}

	public PropertiesModel findPropertiesModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PropertiesModel(db, uuid) : new PropertiesModel(db, stModel);
	}


	public MavenCompilerSourceModel newMavenCompilerSourceModel() {
		return new MavenCompilerSourceModel(db);
	}

	public MavenCompilerSourceModel newMavenCompilerSourceModel(STModel stModel) {
		return new MavenCompilerSourceModel(db, stModel);
	}

	public MavenCompilerSourceModel newMavenCompilerSourceModel(Node node) {
		return new MavenCompilerSourceModel(db, node);
	}

	public Stream<MavenCompilerSourceModel> findAllMavenCompilerSourceModel() {
		return db.findAllSTModelByStTemplate(MavenCompilerSourceModel.stTemplateUuid)
				.map(stModel -> new MavenCompilerSourceModel(db, stModel));
	}

	public MavenCompilerSourceModel findMavenCompilerSourceModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MavenCompilerSourceModel(db, uuid) : new MavenCompilerSourceModel(db, stModel);
	}


	public ProjectBuildSourceEncodingModel newProjectBuildSourceEncodingModel() {
		return new ProjectBuildSourceEncodingModel(db);
	}

	public ProjectBuildSourceEncodingModel newProjectBuildSourceEncodingModel(STModel stModel) {
		return new ProjectBuildSourceEncodingModel(db, stModel);
	}

	public ProjectBuildSourceEncodingModel newProjectBuildSourceEncodingModel(Node node) {
		return new ProjectBuildSourceEncodingModel(db, node);
	}

	public Stream<ProjectBuildSourceEncodingModel> findAllProjectBuildSourceEncodingModel() {
		return db.findAllSTModelByStTemplate(ProjectBuildSourceEncodingModel.stTemplateUuid)
				.map(stModel -> new ProjectBuildSourceEncodingModel(db, stModel));
	}

	public ProjectBuildSourceEncodingModel findProjectBuildSourceEncodingModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ProjectBuildSourceEncodingModel(db, uuid) : new ProjectBuildSourceEncodingModel(db, stModel);
	}


	public MavenCompilerTargetModel newMavenCompilerTargetModel() {
		return new MavenCompilerTargetModel(db);
	}

	public MavenCompilerTargetModel newMavenCompilerTargetModel(STModel stModel) {
		return new MavenCompilerTargetModel(db, stModel);
	}

	public MavenCompilerTargetModel newMavenCompilerTargetModel(Node node) {
		return new MavenCompilerTargetModel(db, node);
	}

	public Stream<MavenCompilerTargetModel> findAllMavenCompilerTargetModel() {
		return db.findAllSTModelByStTemplate(MavenCompilerTargetModel.stTemplateUuid)
				.map(stModel -> new MavenCompilerTargetModel(db, stModel));
	}

	public MavenCompilerTargetModel findMavenCompilerTargetModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MavenCompilerTargetModel(db, uuid) : new MavenCompilerTargetModel(db, stModel);
	}


	public ProjectReportingOutputEncodingModel newProjectReportingOutputEncodingModel() {
		return new ProjectReportingOutputEncodingModel(db);
	}

	public ProjectReportingOutputEncodingModel newProjectReportingOutputEncodingModel(STModel stModel) {
		return new ProjectReportingOutputEncodingModel(db, stModel);
	}

	public ProjectReportingOutputEncodingModel newProjectReportingOutputEncodingModel(Node node) {
		return new ProjectReportingOutputEncodingModel(db, node);
	}

	public Stream<ProjectReportingOutputEncodingModel> findAllProjectReportingOutputEncodingModel() {
		return db.findAllSTModelByStTemplate(ProjectReportingOutputEncodingModel.stTemplateUuid)
				.map(stModel -> new ProjectReportingOutputEncodingModel(db, stModel));
	}

	public ProjectReportingOutputEncodingModel findProjectReportingOutputEncodingModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ProjectReportingOutputEncodingModel(db, uuid) : new ProjectReportingOutputEncodingModel(db, stModel);
	}


	public PropertyReferenceModel newPropertyReferenceModel() {
		return new PropertyReferenceModel(db);
	}

	public PropertyReferenceModel newPropertyReferenceModel(STModel stModel) {
		return new PropertyReferenceModel(db, stModel);
	}

	public PropertyReferenceModel newPropertyReferenceModel(Node node) {
		return new PropertyReferenceModel(db, node);
	}

	public Stream<PropertyReferenceModel> findAllPropertyReferenceModel() {
		return db.findAllSTModelByStTemplate(PropertyReferenceModel.stTemplateUuid)
				.map(stModel -> new PropertyReferenceModel(db, stModel));
	}

	public PropertyReferenceModel findPropertyReferenceModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PropertyReferenceModel(db, uuid) : new PropertyReferenceModel(db, stModel);
	}


	public DependencyModel newDependencyModel() {
		return new DependencyModel(db);
	}

	public DependencyModel newDependencyModel(STModel stModel) {
		return new DependencyModel(db, stModel);
	}

	public DependencyModel newDependencyModel(Node node) {
		return new DependencyModel(db, node);
	}

	public Stream<DependencyModel> findAllDependencyModel() {
		return db.findAllSTModelByStTemplate(DependencyModel.stTemplateUuid)
				.map(stModel -> new DependencyModel(db, stModel));
	}

	public DependencyModel findDependencyModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DependencyModel(db, uuid) : new DependencyModel(db, stModel);
	}


	public RepositoryModel newRepositoryModel() {
		return new RepositoryModel(db);
	}

	public RepositoryModel newRepositoryModel(STModel stModel) {
		return new RepositoryModel(db, stModel);
	}

	public RepositoryModel newRepositoryModel(Node node) {
		return new RepositoryModel(db, node);
	}

	public Stream<RepositoryModel> findAllRepositoryModel() {
		return db.findAllSTModelByStTemplate(RepositoryModel.stTemplateUuid)
				.map(stModel -> new RepositoryModel(db, stModel));
	}

	public RepositoryModel findRepositoryModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RepositoryModel(db, uuid) : new RepositoryModel(db, stModel);
	}


	public ExecutionModel newExecutionModel() {
		return new ExecutionModel(db);
	}

	public ExecutionModel newExecutionModel(STModel stModel) {
		return new ExecutionModel(db, stModel);
	}

	public ExecutionModel newExecutionModel(Node node) {
		return new ExecutionModel(db, node);
	}

	public Stream<ExecutionModel> findAllExecutionModel() {
		return db.findAllSTModelByStTemplate(ExecutionModel.stTemplateUuid)
				.map(stModel -> new ExecutionModel(db, stModel));
	}

	public ExecutionModel findExecutionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExecutionModel(db, uuid) : new ExecutionModel(db, stModel);
	}


	public DependencyGroupModel newDependencyGroupModel() {
		return new DependencyGroupModel(db);
	}

	public DependencyGroupModel newDependencyGroupModel(STModel stModel) {
		return new DependencyGroupModel(db, stModel);
	}

	public DependencyGroupModel newDependencyGroupModel(Node node) {
		return new DependencyGroupModel(db, node);
	}

	public Stream<DependencyGroupModel> findAllDependencyGroupModel() {
		return db.findAllSTModelByStTemplate(DependencyGroupModel.stTemplateUuid)
				.map(stModel -> new DependencyGroupModel(db, stModel));
	}

	public DependencyGroupModel findDependencyGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DependencyGroupModel(db, uuid) : new DependencyGroupModel(db, stModel);
	}


	public PluginsModel newPluginsModel() {
		return new PluginsModel(db);
	}

	public PluginsModel newPluginsModel(STModel stModel) {
		return new PluginsModel(db, stModel);
	}

	public PluginsModel newPluginsModel(Node node) {
		return new PluginsModel(db, node);
	}

	public Stream<PluginsModel> findAllPluginsModel() {
		return db.findAllSTModelByStTemplate(PluginsModel.stTemplateUuid)
				.map(stModel -> new PluginsModel(db, stModel));
	}

	public PluginsModel findPluginsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PluginsModel(db, uuid) : new PluginsModel(db, stModel);
	}


	public FrontEndMavenPluginModel newFrontEndMavenPluginModel() {
		return new FrontEndMavenPluginModel(db);
	}

	public FrontEndMavenPluginModel newFrontEndMavenPluginModel(STModel stModel) {
		return new FrontEndMavenPluginModel(db, stModel);
	}

	public FrontEndMavenPluginModel newFrontEndMavenPluginModel(Node node) {
		return new FrontEndMavenPluginModel(db, node);
	}

	public Stream<FrontEndMavenPluginModel> findAllFrontEndMavenPluginModel() {
		return db.findAllSTModelByStTemplate(FrontEndMavenPluginModel.stTemplateUuid)
				.map(stModel -> new FrontEndMavenPluginModel(db, stModel));
	}

	public FrontEndMavenPluginModel findFrontEndMavenPluginModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FrontEndMavenPluginModel(db, uuid) : new FrontEndMavenPluginModel(db, stModel);
	}


	public NpmScriptModel newNpmScriptModel() {
		return new NpmScriptModel(db);
	}

	public NpmScriptModel newNpmScriptModel(STModel stModel) {
		return new NpmScriptModel(db, stModel);
	}

	public NpmScriptModel newNpmScriptModel(Node node) {
		return new NpmScriptModel(db, node);
	}

	public Stream<NpmScriptModel> findAllNpmScriptModel() {
		return db.findAllSTModelByStTemplate(NpmScriptModel.stTemplateUuid)
				.map(stModel -> new NpmScriptModel(db, stModel));
	}

	public NpmScriptModel findNpmScriptModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NpmScriptModel(db, uuid) : new NpmScriptModel(db, stModel);
	}


	public ShadePluginModel newShadePluginModel() {
		return new ShadePluginModel(db);
	}

	public ShadePluginModel newShadePluginModel(STModel stModel) {
		return new ShadePluginModel(db, stModel);
	}

	public ShadePluginModel newShadePluginModel(Node node) {
		return new ShadePluginModel(db, node);
	}

	public Stream<ShadePluginModel> findAllShadePluginModel() {
		return db.findAllSTModelByStTemplate(ShadePluginModel.stTemplateUuid)
				.map(stModel -> new ShadePluginModel(db, stModel));
	}

	public ShadePluginModel findShadePluginModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ShadePluginModel(db, uuid) : new ShadePluginModel(db, stModel);
	}


	public PluginModel newPluginModel() {
		return new PluginModel(db);
	}

	public PluginModel newPluginModel(STModel stModel) {
		return new PluginModel(db, stModel);
	}

	public PluginModel newPluginModel(Node node) {
		return new PluginModel(db, node);
	}

	public Stream<PluginModel> findAllPluginModel() {
		return db.findAllSTModelByStTemplate(PluginModel.stTemplateUuid)
				.map(stModel -> new PluginModel(db, stModel));
	}

	public PluginModel findPluginModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PluginModel(db, uuid) : new PluginModel(db, stModel);
	}


	public CopyPluginModel newCopyPluginModel() {
		return new CopyPluginModel(db);
	}

	public CopyPluginModel newCopyPluginModel(STModel stModel) {
		return new CopyPluginModel(db, stModel);
	}

	public CopyPluginModel newCopyPluginModel(Node node) {
		return new CopyPluginModel(db, node);
	}

	public Stream<CopyPluginModel> findAllCopyPluginModel() {
		return db.findAllSTModelByStTemplate(CopyPluginModel.stTemplateUuid)
				.map(stModel -> new CopyPluginModel(db, stModel));
	}

	public CopyPluginModel findCopyPluginModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CopyPluginModel(db, uuid) : new CopyPluginModel(db, stModel);
	}


	public Antlr4Model newAntlr4Model() {
		return new Antlr4Model(db);
	}

	public Antlr4Model newAntlr4Model(STModel stModel) {
		return new Antlr4Model(db, stModel);
	}

	public Antlr4Model newAntlr4Model(Node node) {
		return new Antlr4Model(db, node);
	}

	public Stream<Antlr4Model> findAllAntlr4Model() {
		return db.findAllSTModelByStTemplate(Antlr4Model.stTemplateUuid)
				.map(stModel -> new Antlr4Model(db, stModel));
	}

	public Antlr4Model findAntlr4Model(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new Antlr4Model(db, uuid) : new Antlr4Model(db, stModel);
	}


	public Antlr4SimpleModel newAntlr4SimpleModel() {
		return new Antlr4SimpleModel(db);
	}

	public Antlr4SimpleModel newAntlr4SimpleModel(STModel stModel) {
		return new Antlr4SimpleModel(db, stModel);
	}

	public Antlr4SimpleModel newAntlr4SimpleModel(Node node) {
		return new Antlr4SimpleModel(db, node);
	}

	public Stream<Antlr4SimpleModel> findAllAntlr4SimpleModel() {
		return db.findAllSTModelByStTemplate(Antlr4SimpleModel.stTemplateUuid)
				.map(stModel -> new Antlr4SimpleModel(db, stModel));
	}

	public Antlr4SimpleModel findAntlr4SimpleModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new Antlr4SimpleModel(db, uuid) : new Antlr4SimpleModel(db, stModel);
	}


	public DependencyManagementModel newDependencyManagementModel() {
		return new DependencyManagementModel(db);
	}

	public DependencyManagementModel newDependencyManagementModel(STModel stModel) {
		return new DependencyManagementModel(db, stModel);
	}

	public DependencyManagementModel newDependencyManagementModel(Node node) {
		return new DependencyManagementModel(db, node);
	}

	public Stream<DependencyManagementModel> findAllDependencyManagementModel() {
		return db.findAllSTModelByStTemplate(DependencyManagementModel.stTemplateUuid)
				.map(stModel -> new DependencyManagementModel(db, stModel));
	}

	public DependencyManagementModel findDependencyManagementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DependencyManagementModel(db, uuid) : new DependencyManagementModel(db, stModel);
	}


	public MavenPatternsModel newMavenPatternsModel() {
		return new MavenPatternsModel(db);
	}

	public MavenPatternsModel newMavenPatternsModel(STModel stModel) {
		return new MavenPatternsModel(db, stModel);
	}

	public MavenPatternsModel newMavenPatternsModel(Node node) {
		return new MavenPatternsModel(db, node);
	}

	public Stream<MavenPatternsModel> findAllMavenPatternsModel() {
		return db.findAllSTModelByStTemplate(MavenPatternsModel.stTemplateUuid)
				.map(stModel -> new MavenPatternsModel(db, stModel));
	}

	public MavenPatternsModel findMavenPatternsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MavenPatternsModel(db, uuid) : new MavenPatternsModel(db, stModel);
	}


	public ProjectModel newProjectModel() {
		return new ProjectModel(db);
	}

	public ProjectModel newProjectModel(STModel stModel) {
		return new ProjectModel(db, stModel);
	}

	public ProjectModel newProjectModel(Node node) {
		return new ProjectModel(db, node);
	}

	public Stream<ProjectModel> findAllProjectModel() {
		return db.findAllSTModelByStTemplate(ProjectModel.stTemplateUuid)
				.map(stModel -> new ProjectModel(db, stModel));
	}

	public ProjectModel findProjectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ProjectModel(db, uuid) : new ProjectModel(db, stModel);
	}


	public ProjectGeneratorModel newProjectGeneratorModel() {
		return new ProjectGeneratorModel(db);
	}

	public ProjectGeneratorModel newProjectGeneratorModel(STModel stModel) {
		return new ProjectGeneratorModel(db, stModel);
	}

	public ProjectGeneratorModel newProjectGeneratorModel(Node node) {
		return new ProjectGeneratorModel(db, node);
	}

	public Stream<ProjectGeneratorModel> findAllProjectGeneratorModel() {
		return db.findAllSTModelByStTemplate(ProjectGeneratorModel.stTemplateUuid)
				.map(stModel -> new ProjectGeneratorModel(db, stModel));
	}

	public ProjectGeneratorModel findProjectGeneratorModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ProjectGeneratorModel(db, uuid) : new ProjectGeneratorModel(db, stModel);
	}


	public ProjectPackageModel newProjectPackageModel() {
		return new ProjectPackageModel(db);
	}

	public ProjectPackageModel newProjectPackageModel(STModel stModel) {
		return new ProjectPackageModel(db, stModel);
	}

	public ProjectPackageModel newProjectPackageModel(Node node) {
		return new ProjectPackageModel(db, node);
	}

	public Stream<ProjectPackageModel> findAllProjectPackageModel() {
		return db.findAllSTModelByStTemplate(ProjectPackageModel.stTemplateUuid)
				.map(stModel -> new ProjectPackageModel(db, stModel));
	}

	public ProjectPackageModel findProjectPackageModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ProjectPackageModel(db, uuid) : new ProjectPackageModel(db, stModel);
	}


	public TestRunnerModel newTestRunnerModel() {
		return new TestRunnerModel(db);
	}

	public TestRunnerModel newTestRunnerModel(STModel stModel) {
		return new TestRunnerModel(db, stModel);
	}

	public TestRunnerModel newTestRunnerModel(Node node) {
		return new TestRunnerModel(db, node);
	}

	public Stream<TestRunnerModel> findAllTestRunnerModel() {
		return db.findAllSTModelByStTemplate(TestRunnerModel.stTemplateUuid)
				.map(stModel -> new TestRunnerModel(db, stModel));
	}

	public TestRunnerModel findTestRunnerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TestRunnerModel(db, uuid) : new TestRunnerModel(db, stModel);
	}


	public Optional<PomModel> findPomModelByParent(STValue value) {
		return Optional.ofNullable(db.find("parent", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByGroupId(STValue value) {
		return Optional.ofNullable(db.find("groupId", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByArtifactId(STValue value) {
		return Optional.ofNullable(db.find("artifactId", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByPackaging(STValue value) {
		return Optional.ofNullable(db.find("packaging", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByBuild(STValue value) {
		return Optional.ofNullable(db.find("build", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<PomModel> findPomModelByDependencyManagement(STValue value) {
		return Optional.ofNullable(db.find("dependencyManagement", value, PomModel.stTemplateUuid, PomModel::new));
	}

	public Optional<ParentModel> findParentModelByArtifactId(STValue value) {
		return Optional.ofNullable(db.find("artifactId", value, ParentModel.stTemplateUuid, ParentModel::new));
	}

	public Optional<ParentModel> findParentModelByGroupId(STValue value) {
		return Optional.ofNullable(db.find("groupId", value, ParentModel.stTemplateUuid, ParentModel::new));
	}

	public Optional<ParentModel> findParentModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, ParentModel.stTemplateUuid, ParentModel::new));
	}

	public Optional<PropertiesModel> findPropertiesModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PropertiesModel.stTemplateUuid, PropertiesModel::new));
	}

	public Optional<PropertiesModel> findPropertiesModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, PropertiesModel.stTemplateUuid, PropertiesModel::new));
	}

	public Optional<MavenCompilerSourceModel> findMavenCompilerSourceModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, MavenCompilerSourceModel.stTemplateUuid, MavenCompilerSourceModel::new));
	}

	public Optional<ProjectBuildSourceEncodingModel> findProjectBuildSourceEncodingModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, ProjectBuildSourceEncodingModel.stTemplateUuid, ProjectBuildSourceEncodingModel::new));
	}

	public Optional<MavenCompilerTargetModel> findMavenCompilerTargetModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, MavenCompilerTargetModel.stTemplateUuid, MavenCompilerTargetModel::new));
	}

	public Optional<ProjectReportingOutputEncodingModel> findProjectReportingOutputEncodingModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, ProjectReportingOutputEncodingModel.stTemplateUuid, ProjectReportingOutputEncodingModel::new));
	}

	public Optional<PropertyReferenceModel> findPropertyReferenceModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PropertyReferenceModel.stTemplateUuid, PropertyReferenceModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByGroupId(STValue value) {
		return Optional.ofNullable(db.find("groupId", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByArtifactId(STValue value) {
		return Optional.ofNullable(db.find("artifactId", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByScope(STValue value) {
		return Optional.ofNullable(db.find("scope", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelBySystemPath(STValue value) {
		return Optional.ofNullable(db.find("systemPath", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByClassifier(STValue value) {
		return Optional.ofNullable(db.find("classifier", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<RepositoryModel> findRepositoryModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, RepositoryModel.stTemplateUuid, RepositoryModel::new));
	}

	public Optional<RepositoryModel> findRepositoryModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, RepositoryModel.stTemplateUuid, RepositoryModel::new));
	}

	public Optional<RepositoryModel> findRepositoryModelByUrl(STValue value) {
		return Optional.ofNullable(db.find("url", value, RepositoryModel.stTemplateUuid, RepositoryModel::new));
	}

	public Optional<DependencyGroupModel> findDependencyGroupModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, DependencyGroupModel.stTemplateUuid, DependencyGroupModel::new));
	}

	public Optional<DependencyGroupModel> findDependencyGroupModelByGroupId(STValue value) {
		return Optional.ofNullable(db.find("groupId", value, DependencyGroupModel.stTemplateUuid, DependencyGroupModel::new));
	}

	public Optional<DependencyGroupModel> findDependencyGroupModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, DependencyGroupModel.stTemplateUuid, DependencyGroupModel::new));
	}

	public Optional<FrontEndMavenPluginModel> findFrontEndMavenPluginModelByPluginVersion(STValue value) {
		return Optional.ofNullable(db.find("pluginVersion", value, FrontEndMavenPluginModel.stTemplateUuid, FrontEndMavenPluginModel::new));
	}

	public Optional<FrontEndMavenPluginModel> findFrontEndMavenPluginModelByInstallDirectory(STValue value) {
		return Optional.ofNullable(db.find("installDirectory", value, FrontEndMavenPluginModel.stTemplateUuid, FrontEndMavenPluginModel::new));
	}

	public Optional<FrontEndMavenPluginModel> findFrontEndMavenPluginModelByNodeVersion(STValue value) {
		return Optional.ofNullable(db.find("nodeVersion", value, FrontEndMavenPluginModel.stTemplateUuid, FrontEndMavenPluginModel::new));
	}

	public Optional<ShadePluginModel> findShadePluginModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, ShadePluginModel.stTemplateUuid, ShadePluginModel::new));
	}

	public Optional<ShadePluginModel> findShadePluginModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ShadePluginModel.stTemplateUuid, ShadePluginModel::new));
	}

	public Optional<PluginModel> findPluginModelByGroupId(STValue value) {
		return Optional.ofNullable(db.find("groupId", value, PluginModel.stTemplateUuid, PluginModel::new));
	}

	public Optional<PluginModel> findPluginModelByArtifactId(STValue value) {
		return Optional.ofNullable(db.find("artifactId", value, PluginModel.stTemplateUuid, PluginModel::new));
	}

	public Optional<PluginModel> findPluginModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, PluginModel.stTemplateUuid, PluginModel::new));
	}

	public Optional<CopyPluginModel> findCopyPluginModelByOutputDirectory(STValue value) {
		return Optional.ofNullable(db.find("outputDirectory", value, CopyPluginModel.stTemplateUuid, CopyPluginModel::new));
	}

	public Optional<CopyPluginModel> findCopyPluginModelByDirectory(STValue value) {
		return Optional.ofNullable(db.find("directory", value, CopyPluginModel.stTemplateUuid, CopyPluginModel::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelByVersion(STValue value) {
		return Optional.ofNullable(db.find("version", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelBySourceDirectory(STValue value) {
		return Optional.ofNullable(db.find("sourceDirectory", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelByOutputDirectory(STValue value) {
		return Optional.ofNullable(db.find("outputDirectory", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelByVisitor(STValue value) {
		return Optional.ofNullable(db.find("visitor", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelByListener(STValue value) {
		return Optional.ofNullable(db.find("listener", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<Antlr4Model> findAntlr4ModelByGoal(STValue value) {
		return Optional.ofNullable(db.find("goal", value, Antlr4Model.stTemplateUuid, Antlr4Model::new));
	}

	public Optional<ProjectModel> findProjectModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, ProjectModel.stTemplateUuid, ProjectModel::new));
	}

	public Optional<ProjectModel> findProjectModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ProjectModel.stTemplateUuid, ProjectModel::new));
	}

	public Optional<ProjectModel> findProjectModelByRoot(STValue value) {
		return Optional.ofNullable(db.find("root", value, ProjectModel.stTemplateUuid, ProjectModel::new));
	}

	public Optional<ProjectGeneratorModel> findProjectGeneratorModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ProjectGeneratorModel.stTemplateUuid, ProjectGeneratorModel::new));
	}

	public Optional<ProjectGeneratorModel> findProjectGeneratorModelByDescription(STValue value) {
		return Optional.ofNullable(db.find("description", value, ProjectGeneratorModel.stTemplateUuid, ProjectGeneratorModel::new));
	}

	public Optional<ProjectPackageModel> findProjectPackageModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ProjectPackageModel.stTemplateUuid, ProjectPackageModel::new));
	}

	public Optional<ProjectPackageModel> findProjectPackageModelByParentPackage(STValue value) {
		return Optional.ofNullable(db.find("parentPackage", value, ProjectPackageModel.stTemplateUuid, ProjectPackageModel::new));
	}

	public Optional<ProjectPackageModel> findProjectPackageModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, ProjectPackageModel.stTemplateUuid, ProjectPackageModel::new));
	}

	public Optional<TestRunnerModel> findTestRunnerModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, TestRunnerModel.stTemplateUuid, TestRunnerModel::new));
	}

	public Optional<TestRunnerModel> findTestRunnerModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, TestRunnerModel.stTemplateUuid, TestRunnerModel::new));
	}

	public Optional<TestRunnerModel> findTestRunnerModelByProjectName(STValue value) {
		return Optional.ofNullable(db.find("projectName", value, TestRunnerModel.stTemplateUuid, TestRunnerModel::new));
	}
}