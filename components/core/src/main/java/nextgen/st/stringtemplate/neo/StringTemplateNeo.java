package nextgen.st.stringtemplate.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class StringTemplateNeo {

	private final STModelDB db;

	public StringTemplateNeo(STModelDB db) {
		this.db = db;
	}

	public STDomainModel newSTDomainModel() {
		return new STDomainModel(db);
	}

	public STDomainModel newSTDomainModel(STModel stModel) {
		return new STDomainModel(db, stModel);
	}

	public STDomainModel newSTDomainModel(Node node) {
		return new STDomainModel(db, node);
	}


	public NewEntityInstanceModel newNewEntityInstanceModel() {
		return new NewEntityInstanceModel(db);
	}

	public NewEntityInstanceModel newNewEntityInstanceModel(STModel stModel) {
		return new NewEntityInstanceModel(db, stModel);
	}

	public NewEntityInstanceModel newNewEntityInstanceModel(Node node) {
		return new NewEntityInstanceModel(db, node);
	}


	public StgStringModel newStgStringModel() {
		return new StgStringModel(db);
	}

	public StgStringModel newStgStringModel(STModel stModel) {
		return new StgStringModel(db, stModel);
	}

	public StgStringModel newStgStringModel(Node node) {
		return new StgStringModel(db, node);
	}


	public STDomainTestsModel newSTDomainTestsModel() {
		return new STDomainTestsModel(db);
	}

	public STDomainTestsModel newSTDomainTestsModel(STModel stModel) {
		return new STDomainTestsModel(db, stModel);
	}

	public STDomainTestsModel newSTDomainTestsModel(Node node) {
		return new STDomainTestsModel(db, node);
	}


	public TemplateTestMethodModel newTemplateTestMethodModel() {
		return new TemplateTestMethodModel(db);
	}

	public TemplateTestMethodModel newTemplateTestMethodModel(STModel stModel) {
		return new TemplateTestMethodModel(db, stModel);
	}

	public TemplateTestMethodModel newTemplateTestMethodModel(Node node) {
		return new TemplateTestMethodModel(db, node);
	}


	public STEntityModel newSTEntityModel() {
		return new STEntityModel(db);
	}

	public STEntityModel newSTEntityModel(STModel stModel) {
		return new STEntityModel(db, stModel);
	}

	public STEntityModel newSTEntityModel(Node node) {
		return new STEntityModel(db, node);
	}


	public EntityListAccessorsModel newEntityListAccessorsModel() {
		return new EntityListAccessorsModel(db);
	}

	public EntityListAccessorsModel newEntityListAccessorsModel(STModel stModel) {
		return new EntityListAccessorsModel(db, stModel);
	}

	public EntityListAccessorsModel newEntityListAccessorsModel(Node node) {
		return new EntityListAccessorsModel(db, node);
	}


	public EntityKVListAccessorsModel newEntityKVListAccessorsModel() {
		return new EntityKVListAccessorsModel(db);
	}

	public EntityKVListAccessorsModel newEntityKVListAccessorsModel(STModel stModel) {
		return new EntityKVListAccessorsModel(db, stModel);
	}

	public EntityKVListAccessorsModel newEntityKVListAccessorsModel(Node node) {
		return new EntityKVListAccessorsModel(db, node);
	}


	public EntitySingleAccessorsModel newEntitySingleAccessorsModel() {
		return new EntitySingleAccessorsModel(db);
	}

	public EntitySingleAccessorsModel newEntitySingleAccessorsModel(STModel stModel) {
		return new EntitySingleAccessorsModel(db, stModel);
	}

	public EntitySingleAccessorsModel newEntitySingleAccessorsModel(Node node) {
		return new EntitySingleAccessorsModel(db, node);
	}


	public STEnumModel newSTEnumModel() {
		return new STEnumModel(db);
	}

	public STEnumModel newSTEnumModel(STModel stModel) {
		return new STEnumModel(db, stModel);
	}

	public STEnumModel newSTEnumModel(Node node) {
		return new STEnumModel(db, node);
	}


	public STEnumValueModel newSTEnumValueModel() {
		return new STEnumValueModel(db);
	}

	public STEnumValueModel newSTEnumValueModel(STModel stModel) {
		return new STEnumValueModel(db, stModel);
	}

	public STEnumValueModel newSTEnumValueModel(Node node) {
		return new STEnumValueModel(db, node);
	}


	public STInterfaceModel newSTInterfaceModel() {
		return new STInterfaceModel(db);
	}

	public STInterfaceModel newSTInterfaceModel(STModel stModel) {
		return new STInterfaceModel(db, stModel);
	}

	public STInterfaceModel newSTInterfaceModel(Node node) {
		return new STInterfaceModel(db, node);
	}


	public ScriptRunnerModel newScriptRunnerModel() {
		return new ScriptRunnerModel(db);
	}

	public ScriptRunnerModel newScriptRunnerModel(STModel stModel) {
		return new ScriptRunnerModel(db, stModel);
	}

	public ScriptRunnerModel newScriptRunnerModel(Node node) {
		return new ScriptRunnerModel(db, node);
	}


	public DomainVisitorRunnerModel newDomainVisitorRunnerModel() {
		return new DomainVisitorRunnerModel(db);
	}

	public DomainVisitorRunnerModel newDomainVisitorRunnerModel(STModel stModel) {
		return new DomainVisitorRunnerModel(db, stModel);
	}

	public DomainVisitorRunnerModel newDomainVisitorRunnerModel(Node node) {
		return new DomainVisitorRunnerModel(db, node);
	}


	public VisitNodeMethodModel newVisitNodeMethodModel() {
		return new VisitNodeMethodModel(db);
	}

	public VisitNodeMethodModel newVisitNodeMethodModel(STModel stModel) {
		return new VisitNodeMethodModel(db, stModel);
	}

	public VisitNodeMethodModel newVisitNodeMethodModel(Node node) {
		return new VisitNodeMethodModel(db, node);
	}


	public VisitRelationMethodModel newVisitRelationMethodModel() {
		return new VisitRelationMethodModel(db);
	}

	public VisitRelationMethodModel newVisitRelationMethodModel(STModel stModel) {
		return new VisitRelationMethodModel(db, stModel);
	}

	public VisitRelationMethodModel newVisitRelationMethodModel(Node node) {
		return new VisitRelationMethodModel(db, node);
	}


	public NeoDomainModel newNeoDomainModel() {
		return new NeoDomainModel(db);
	}

	public NeoDomainModel newNeoDomainModel(STModel stModel) {
		return new NeoDomainModel(db, stModel);
	}

	public NeoDomainModel newNeoDomainModel(Node node) {
		return new NeoDomainModel(db, node);
	}


	public NeoEntityModel newNeoEntityModel() {
		return new NeoEntityModel(db);
	}

	public NeoEntityModel newNeoEntityModel(STModel stModel) {
		return new NeoEntityModel(db, stModel);
	}

	public NeoEntityModel newNeoEntityModel(Node node) {
		return new NeoEntityModel(db, node);
	}


	public SingleAccessorsModel newSingleAccessorsModel() {
		return new SingleAccessorsModel(db);
	}

	public SingleAccessorsModel newSingleAccessorsModel(STModel stModel) {
		return new SingleAccessorsModel(db, stModel);
	}

	public SingleAccessorsModel newSingleAccessorsModel(Node node) {
		return new SingleAccessorsModel(db, node);
	}


	public ListAccessorsModel newListAccessorsModel() {
		return new ListAccessorsModel(db);
	}

	public ListAccessorsModel newListAccessorsModel(STModel stModel) {
		return new ListAccessorsModel(db, stModel);
	}

	public ListAccessorsModel newListAccessorsModel(Node node) {
		return new ListAccessorsModel(db, node);
	}


	public KVAccessorsModel newKVAccessorsModel() {
		return new KVAccessorsModel(db);
	}

	public KVAccessorsModel newKVAccessorsModel(STModel stModel) {
		return new KVAccessorsModel(db, stModel);
	}

	public KVAccessorsModel newKVAccessorsModel(Node node) {
		return new KVAccessorsModel(db, node);
	}


	public FindByModel newFindByModel() {
		return new FindByModel(db);
	}

	public FindByModel newFindByModel(STModel stModel) {
		return new FindByModel(db, stModel);
	}

	public FindByModel newFindByModel(Node node) {
		return new FindByModel(db, node);
	}


	public Optional<STDomainModel> findSTDomainModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, STDomainModel.stTemplateUuid, STDomainModel::new));
	}

	public Optional<STDomainModel> findSTDomainModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STDomainModel.stTemplateUuid, STDomainModel::new));
	}

	public Optional<STDomainModel> findSTDomainModelByStgString(STValue value) {
		return Optional.ofNullable(find(db, "stgString", value, STDomainModel.stTemplateUuid, STDomainModel::new));
	}

	public Optional<NewEntityInstanceModel> findNewEntityInstanceModelByEntityName(STValue value) {
		return Optional.ofNullable(find(db, "entityName", value, NewEntityInstanceModel.stTemplateUuid, NewEntityInstanceModel::new));
	}

	public Optional<STDomainTestsModel> findSTDomainTestsModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, STDomainTestsModel.stTemplateUuid, STDomainTestsModel::new));
	}

	public Optional<STDomainTestsModel> findSTDomainTestsModelByDomainName(STValue value) {
		return Optional.ofNullable(find(db, "domainName", value, STDomainTestsModel.stTemplateUuid, STDomainTestsModel::new));
	}

	public Optional<STDomainTestsModel> findSTDomainTestsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STDomainTestsModel.stTemplateUuid, STDomainTestsModel::new));
	}

	public Optional<TemplateTestMethodModel> findTemplateTestMethodModelByTemplate(STValue value) {
		return Optional.ofNullable(find(db, "template", value, TemplateTestMethodModel.stTemplateUuid, TemplateTestMethodModel::new));
	}

	public Optional<STEntityModel> findSTEntityModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, STEntityModel.stTemplateUuid, STEntityModel::new));
	}

	public Optional<STEntityModel> findSTEntityModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STEntityModel.stTemplateUuid, STEntityModel::new));
	}

	public Optional<STEntityModel> findSTEntityModelByTemplate(STValue value) {
		return Optional.ofNullable(find(db, "template", value, STEntityModel.stTemplateUuid, STEntityModel::new));
	}

	public Optional<STEntityModel> findSTEntityModelByStString(STValue value) {
		return Optional.ofNullable(find(db, "stString", value, STEntityModel.stTemplateUuid, STEntityModel::new));
	}

	public Optional<EntityListAccessorsModel> findEntityListAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, EntityListAccessorsModel.stTemplateUuid, EntityListAccessorsModel::new));
	}

	public Optional<EntityListAccessorsModel> findEntityListAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, EntityListAccessorsModel.stTemplateUuid, EntityListAccessorsModel::new));
	}

	public Optional<EntityListAccessorsModel> findEntityListAccessorsModelByType(STValue value) {
		return Optional.ofNullable(find(db, "type", value, EntityListAccessorsModel.stTemplateUuid, EntityListAccessorsModel::new));
	}

	public Optional<EntityKVListAccessorsModel> findEntityKVListAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, EntityKVListAccessorsModel.stTemplateUuid, EntityKVListAccessorsModel::new));
	}

	public Optional<EntityKVListAccessorsModel> findEntityKVListAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, EntityKVListAccessorsModel.stTemplateUuid, EntityKVListAccessorsModel::new));
	}

	public Optional<EntitySingleAccessorsModel> findEntitySingleAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, EntitySingleAccessorsModel.stTemplateUuid, EntitySingleAccessorsModel::new));
	}

	public Optional<EntitySingleAccessorsModel> findEntitySingleAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, EntitySingleAccessorsModel.stTemplateUuid, EntitySingleAccessorsModel::new));
	}

	public Optional<EntitySingleAccessorsModel> findEntitySingleAccessorsModelByType(STValue value) {
		return Optional.ofNullable(find(db, "type", value, EntitySingleAccessorsModel.stTemplateUuid, EntitySingleAccessorsModel::new));
	}

	public Optional<STEnumModel> findSTEnumModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, STEnumModel.stTemplateUuid, STEnumModel::new));
	}

	public Optional<STEnumModel> findSTEnumModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STEnumModel.stTemplateUuid, STEnumModel::new));
	}

	public Optional<STEnumValueModel> findSTEnumValueModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STEnumValueModel.stTemplateUuid, STEnumValueModel::new));
	}

	public Optional<STEnumValueModel> findSTEnumValueModelByLexical(STValue value) {
		return Optional.ofNullable(find(db, "lexical", value, STEnumValueModel.stTemplateUuid, STEnumValueModel::new));
	}

	public Optional<STInterfaceModel> findSTInterfaceModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, STInterfaceModel.stTemplateUuid, STInterfaceModel::new));
	}

	public Optional<STInterfaceModel> findSTInterfaceModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, STInterfaceModel.stTemplateUuid, STInterfaceModel::new));
	}

	public Optional<ScriptRunnerModel> findScriptRunnerModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, ScriptRunnerModel.stTemplateUuid, ScriptRunnerModel::new));
	}

	public Optional<ScriptRunnerModel> findScriptRunnerModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, ScriptRunnerModel.stTemplateUuid, ScriptRunnerModel::new));
	}

	public Optional<ScriptRunnerModel> findScriptRunnerModelByScript(STValue value) {
		return Optional.ofNullable(find(db, "script", value, ScriptRunnerModel.stTemplateUuid, ScriptRunnerModel::new));
	}

	public Optional<ScriptRunnerModel> findScriptRunnerModelByTemplatesDir(STValue value) {
		return Optional.ofNullable(find(db, "templatesDir", value, ScriptRunnerModel.stTemplateUuid, ScriptRunnerModel::new));
	}

	public Optional<ScriptRunnerModel> findScriptRunnerModelByDbDir(STValue value) {
		return Optional.ofNullable(find(db, "dbDir", value, ScriptRunnerModel.stTemplateUuid, ScriptRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByPackageName(STValue value) {
		return Optional.ofNullable(find(db, "packageName", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByRootNode(STValue value) {
		return Optional.ofNullable(find(db, "rootNode", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByInitStatements(STValue value) {
		return Optional.ofNullable(find(db, "initStatements", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByEndStatements(STValue value) {
		return Optional.ofNullable(find(db, "endStatements", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByTemplatesDir(STValue value) {
		return Optional.ofNullable(find(db, "templatesDir", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByDbDir(STValue value) {
		return Optional.ofNullable(find(db, "dbDir", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<DomainVisitorRunnerModel> findDomainVisitorRunnerModelByEntityUuid(STValue value) {
		return Optional.ofNullable(find(db, "entityUuid", value, DomainVisitorRunnerModel.stTemplateUuid, DomainVisitorRunnerModel::new));
	}

	public Optional<VisitNodeMethodModel> findVisitNodeMethodModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, VisitNodeMethodModel.stTemplateUuid, VisitNodeMethodModel::new));
	}

	public Optional<VisitNodeMethodModel> findVisitNodeMethodModelByStatements(STValue value) {
		return Optional.ofNullable(find(db, "statements", value, VisitNodeMethodModel.stTemplateUuid, VisitNodeMethodModel::new));
	}

	public Optional<VisitRelationMethodModel> findVisitRelationMethodModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, VisitRelationMethodModel.stTemplateUuid, VisitRelationMethodModel::new));
	}

	public Optional<VisitRelationMethodModel> findVisitRelationMethodModelByStatements(STValue value) {
		return Optional.ofNullable(find(db, "statements", value, VisitRelationMethodModel.stTemplateUuid, VisitRelationMethodModel::new));
	}

	public Optional<NeoDomainModel> findNeoDomainModelByPackage(STValue value) {
		return Optional.ofNullable(find(db, "package", value, NeoDomainModel.stTemplateUuid, NeoDomainModel::new));
	}

	public Optional<NeoDomainModel> findNeoDomainModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, NeoDomainModel.stTemplateUuid, NeoDomainModel::new));
	}

	public Optional<NeoEntityModel> findNeoEntityModelByPackage(STValue value) {
		return Optional.ofNullable(find(db, "package", value, NeoEntityModel.stTemplateUuid, NeoEntityModel::new));
	}

	public Optional<NeoEntityModel> findNeoEntityModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, NeoEntityModel.stTemplateUuid, NeoEntityModel::new));
	}

	public Optional<NeoEntityModel> findNeoEntityModelByStGroupModel(STValue value) {
		return Optional.ofNullable(find(db, "stGroupModel", value, NeoEntityModel.stTemplateUuid, NeoEntityModel::new));
	}

	public Optional<NeoEntityModel> findNeoEntityModelByStTemplate(STValue value) {
		return Optional.ofNullable(find(db, "stTemplate", value, NeoEntityModel.stTemplateUuid, NeoEntityModel::new));
	}

	public Optional<SingleAccessorsModel> findSingleAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, SingleAccessorsModel.stTemplateUuid, SingleAccessorsModel::new));
	}

	public Optional<SingleAccessorsModel> findSingleAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, SingleAccessorsModel.stTemplateUuid, SingleAccessorsModel::new));
	}

	public Optional<ListAccessorsModel> findListAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, ListAccessorsModel.stTemplateUuid, ListAccessorsModel::new));
	}

	public Optional<ListAccessorsModel> findListAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, ListAccessorsModel.stTemplateUuid, ListAccessorsModel::new));
	}

	public Optional<KVAccessorsModel> findKVAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, KVAccessorsModel.stTemplateUuid, KVAccessorsModel::new));
	}

	public Optional<KVAccessorsModel> findKVAccessorsModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, KVAccessorsModel.stTemplateUuid, KVAccessorsModel::new));
	}

	public Optional<FindByModel> findFindByModelByEntity(STValue value) {
		return Optional.ofNullable(find(db, "entity", value, FindByModel.stTemplateUuid, FindByModel::new));
	}

	public Optional<FindByModel> findFindByModelByName(STValue value) {
		return Optional.ofNullable(find(db, "name", value, FindByModel.stTemplateUuid, FindByModel::new));
	}

	private static <T> T find(STModelDB db, String name, STValue value, String stTemplateUuid, Mapper<T> supplier) {
		final AtomicReference<T> found = new AtomicReference<>();
		db.findSTTemplateByUuid(stTemplateUuid)
				.getParameters()
				.filter(stParameter -> stParameter.getName().equals(name))
				.findFirst()
				.ifPresent(stParameter -> {
					db.findAllSTModelByStTemplate(stTemplateUuid)
							.filter(stModel -> found.get() == null)
							.forEach(stModel -> {
								stModel.getArguments()
										.filter(stArgument -> found.get() == null)
										.filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
										.map(STArgument::getValue)
										.filter(value::equals)
										.findFirst()
										.ifPresent(stValue -> found.set(supplier.get(db, stModel)));
							});
				});

		return found.get();
	}

	private interface Mapper<T> {

		T get(STModelDB db, STModel stModel);

	}
}