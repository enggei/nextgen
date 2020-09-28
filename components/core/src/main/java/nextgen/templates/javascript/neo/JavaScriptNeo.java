package nextgen.templates.javascript.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaScriptNeo {

	private final STModelDB db;

	public JavaScriptNeo(STModelDB db) {
		this.db = db;
	}

	public BlockStmtModel newBlockStmtModel() {
		return new BlockStmtModel(db);
	}

	public BlockStmtModel newBlockStmtModel(STModel stModel) {
		return new BlockStmtModel(db, stModel);
	}

	public BlockStmtModel newBlockStmtModel(Node node) {
		return new BlockStmtModel(db, node);
	}

	public Stream<BlockStmtModel> findAllBlockStmtModel() {
		return db.findAllSTModelByStTemplate(BlockStmtModel.stTemplateUuid)
				.map(stModel -> new BlockStmtModel(db, stModel));
	}

	public BlockStmtModel findBlockStmtModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BlockStmtModel(db, uuid) : new BlockStmtModel(db, stModel);
	}


	public DecoratorModel newDecoratorModel() {
		return new DecoratorModel(db);
	}

	public DecoratorModel newDecoratorModel(STModel stModel) {
		return new DecoratorModel(db, stModel);
	}

	public DecoratorModel newDecoratorModel(Node node) {
		return new DecoratorModel(db, node);
	}

	public Stream<DecoratorModel> findAllDecoratorModel() {
		return db.findAllSTModelByStTemplate(DecoratorModel.stTemplateUuid)
				.map(stModel -> new DecoratorModel(db, stModel));
	}

	public DecoratorModel findDecoratorModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DecoratorModel(db, uuid) : new DecoratorModel(db, stModel);
	}


	public JsonObjectModel newJsonObjectModel() {
		return new JsonObjectModel(db);
	}

	public JsonObjectModel newJsonObjectModel(STModel stModel) {
		return new JsonObjectModel(db, stModel);
	}

	public JsonObjectModel newJsonObjectModel(Node node) {
		return new JsonObjectModel(db, node);
	}

	public Stream<JsonObjectModel> findAllJsonObjectModel() {
		return db.findAllSTModelByStTemplate(JsonObjectModel.stTemplateUuid)
				.map(stModel -> new JsonObjectModel(db, stModel));
	}

	public JsonObjectModel findJsonObjectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new JsonObjectModel(db, uuid) : new JsonObjectModel(db, stModel);
	}


	public NameArrayModel newNameArrayModel() {
		return new NameArrayModel(db);
	}

	public NameArrayModel newNameArrayModel(STModel stModel) {
		return new NameArrayModel(db, stModel);
	}

	public NameArrayModel newNameArrayModel(Node node) {
		return new NameArrayModel(db, node);
	}

	public Stream<NameArrayModel> findAllNameArrayModel() {
		return db.findAllSTModelByStTemplate(NameArrayModel.stTemplateUuid)
				.map(stModel -> new NameArrayModel(db, stModel));
	}

	public NameArrayModel findNameArrayModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NameArrayModel(db, uuid) : new NameArrayModel(db, stModel);
	}


	public NameValueModel newNameValueModel() {
		return new NameValueModel(db);
	}

	public NameValueModel newNameValueModel(STModel stModel) {
		return new NameValueModel(db, stModel);
	}

	public NameValueModel newNameValueModel(Node node) {
		return new NameValueModel(db, node);
	}

	public Stream<NameValueModel> findAllNameValueModel() {
		return db.findAllSTModelByStTemplate(NameValueModel.stTemplateUuid)
				.map(stModel -> new NameValueModel(db, stModel));
	}

	public NameValueModel findNameValueModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NameValueModel(db, uuid) : new NameValueModel(db, stModel);
	}


	public FunctionsModel newFunctionsModel() {
		return new FunctionsModel(db);
	}

	public FunctionsModel newFunctionsModel(STModel stModel) {
		return new FunctionsModel(db, stModel);
	}

	public FunctionsModel newFunctionsModel(Node node) {
		return new FunctionsModel(db, node);
	}

	public Stream<FunctionsModel> findAllFunctionsModel() {
		return db.findAllSTModelByStTemplate(FunctionsModel.stTemplateUuid)
				.map(stModel -> new FunctionsModel(db, stModel));
	}

	public FunctionsModel findFunctionsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FunctionsModel(db, uuid) : new FunctionsModel(db, stModel);
	}


	public ArrowFunctionModel newArrowFunctionModel() {
		return new ArrowFunctionModel(db);
	}

	public ArrowFunctionModel newArrowFunctionModel(STModel stModel) {
		return new ArrowFunctionModel(db, stModel);
	}

	public ArrowFunctionModel newArrowFunctionModel(Node node) {
		return new ArrowFunctionModel(db, node);
	}

	public Stream<ArrowFunctionModel> findAllArrowFunctionModel() {
		return db.findAllSTModelByStTemplate(ArrowFunctionModel.stTemplateUuid)
				.map(stModel -> new ArrowFunctionModel(db, stModel));
	}

	public ArrowFunctionModel findArrowFunctionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ArrowFunctionModel(db, uuid) : new ArrowFunctionModel(db, stModel);
	}


	public FunctionModel newFunctionModel() {
		return new FunctionModel(db);
	}

	public FunctionModel newFunctionModel(STModel stModel) {
		return new FunctionModel(db, stModel);
	}

	public FunctionModel newFunctionModel(Node node) {
		return new FunctionModel(db, node);
	}

	public Stream<FunctionModel> findAllFunctionModel() {
		return db.findAllSTModelByStTemplate(FunctionModel.stTemplateUuid)
				.map(stModel -> new FunctionModel(db, stModel));
	}

	public FunctionModel findFunctionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FunctionModel(db, uuid) : new FunctionModel(db, stModel);
	}


	public FunctionExpressionModel newFunctionExpressionModel() {
		return new FunctionExpressionModel(db);
	}

	public FunctionExpressionModel newFunctionExpressionModel(STModel stModel) {
		return new FunctionExpressionModel(db, stModel);
	}

	public FunctionExpressionModel newFunctionExpressionModel(Node node) {
		return new FunctionExpressionModel(db, node);
	}

	public Stream<FunctionExpressionModel> findAllFunctionExpressionModel() {
		return db.findAllSTModelByStTemplate(FunctionExpressionModel.stTemplateUuid)
				.map(stModel -> new FunctionExpressionModel(db, stModel));
	}

	public FunctionExpressionModel findFunctionExpressionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FunctionExpressionModel(db, uuid) : new FunctionExpressionModel(db, stModel);
	}


	public FunctionCallModel newFunctionCallModel() {
		return new FunctionCallModel(db);
	}

	public FunctionCallModel newFunctionCallModel(STModel stModel) {
		return new FunctionCallModel(db, stModel);
	}

	public FunctionCallModel newFunctionCallModel(Node node) {
		return new FunctionCallModel(db, node);
	}

	public Stream<FunctionCallModel> findAllFunctionCallModel() {
		return db.findAllSTModelByStTemplate(FunctionCallModel.stTemplateUuid)
				.map(stModel -> new FunctionCallModel(db, stModel));
	}

	public FunctionCallModel findFunctionCallModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FunctionCallModel(db, uuid) : new FunctionCallModel(db, stModel);
	}


	public ReturnStmtModel newReturnStmtModel() {
		return new ReturnStmtModel(db);
	}

	public ReturnStmtModel newReturnStmtModel(STModel stModel) {
		return new ReturnStmtModel(db, stModel);
	}

	public ReturnStmtModel newReturnStmtModel(Node node) {
		return new ReturnStmtModel(db, node);
	}

	public Stream<ReturnStmtModel> findAllReturnStmtModel() {
		return db.findAllSTModelByStTemplate(ReturnStmtModel.stTemplateUuid)
				.map(stModel -> new ReturnStmtModel(db, stModel));
	}

	public ReturnStmtModel findReturnStmtModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReturnStmtModel(db, uuid) : new ReturnStmtModel(db, stModel);
	}


	public ReactModel newReactModel() {
		return new ReactModel(db);
	}

	public ReactModel newReactModel(STModel stModel) {
		return new ReactModel(db, stModel);
	}

	public ReactModel newReactModel(Node node) {
		return new ReactModel(db, node);
	}

	public Stream<ReactModel> findAllReactModel() {
		return db.findAllSTModelByStTemplate(ReactModel.stTemplateUuid)
				.map(stModel -> new ReactModel(db, stModel));
	}

	public ReactModel findReactModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReactModel(db, uuid) : new ReactModel(db, stModel);
	}


	public IndexJSModel newIndexJSModel() {
		return new IndexJSModel(db);
	}

	public IndexJSModel newIndexJSModel(STModel stModel) {
		return new IndexJSModel(db, stModel);
	}

	public IndexJSModel newIndexJSModel(Node node) {
		return new IndexJSModel(db, node);
	}

	public Stream<IndexJSModel> findAllIndexJSModel() {
		return db.findAllSTModelByStTemplate(IndexJSModel.stTemplateUuid)
				.map(stModel -> new IndexJSModel(db, stModel));
	}

	public IndexJSModel findIndexJSModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IndexJSModel(db, uuid) : new IndexJSModel(db, stModel);
	}


	public IndexHtmlModel newIndexHtmlModel() {
		return new IndexHtmlModel(db);
	}

	public IndexHtmlModel newIndexHtmlModel(STModel stModel) {
		return new IndexHtmlModel(db, stModel);
	}

	public IndexHtmlModel newIndexHtmlModel(Node node) {
		return new IndexHtmlModel(db, node);
	}

	public Stream<IndexHtmlModel> findAllIndexHtmlModel() {
		return db.findAllSTModelByStTemplate(IndexHtmlModel.stTemplateUuid)
				.map(stModel -> new IndexHtmlModel(db, stModel));
	}

	public IndexHtmlModel findIndexHtmlModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IndexHtmlModel(db, uuid) : new IndexHtmlModel(db, stModel);
	}


	public IndexCSSModel newIndexCSSModel() {
		return new IndexCSSModel(db);
	}

	public IndexCSSModel newIndexCSSModel(STModel stModel) {
		return new IndexCSSModel(db, stModel);
	}

	public IndexCSSModel newIndexCSSModel(Node node) {
		return new IndexCSSModel(db, node);
	}

	public Stream<IndexCSSModel> findAllIndexCSSModel() {
		return db.findAllSTModelByStTemplate(IndexCSSModel.stTemplateUuid)
				.map(stModel -> new IndexCSSModel(db, stModel));
	}

	public IndexCSSModel findIndexCSSModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IndexCSSModel(db, uuid) : new IndexCSSModel(db, stModel);
	}


	public ReactRouterModel newReactRouterModel() {
		return new ReactRouterModel(db);
	}

	public ReactRouterModel newReactRouterModel(STModel stModel) {
		return new ReactRouterModel(db, stModel);
	}

	public ReactRouterModel newReactRouterModel(Node node) {
		return new ReactRouterModel(db, node);
	}

	public Stream<ReactRouterModel> findAllReactRouterModel() {
		return db.findAllSTModelByStTemplate(ReactRouterModel.stTemplateUuid)
				.map(stModel -> new ReactRouterModel(db, stModel));
	}

	public ReactRouterModel findReactRouterModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReactRouterModel(db, uuid) : new ReactRouterModel(db, stModel);
	}


	public LinkModel newLinkModel() {
		return new LinkModel(db);
	}

	public LinkModel newLinkModel(STModel stModel) {
		return new LinkModel(db, stModel);
	}

	public LinkModel newLinkModel(Node node) {
		return new LinkModel(db, node);
	}

	public Stream<LinkModel> findAllLinkModel() {
		return db.findAllSTModelByStTemplate(LinkModel.stTemplateUuid)
				.map(stModel -> new LinkModel(db, stModel));
	}

	public LinkModel findLinkModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinkModel(db, uuid) : new LinkModel(db, stModel);
	}


	public ForwardRefModel newForwardRefModel() {
		return new ForwardRefModel(db);
	}

	public ForwardRefModel newForwardRefModel(STModel stModel) {
		return new ForwardRefModel(db, stModel);
	}

	public ForwardRefModel newForwardRefModel(Node node) {
		return new ForwardRefModel(db, node);
	}

	public Stream<ForwardRefModel> findAllForwardRefModel() {
		return db.findAllSTModelByStTemplate(ForwardRefModel.stTemplateUuid)
				.map(stModel -> new ForwardRefModel(db, stModel));
	}

	public ForwardRefModel findForwardRefModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ForwardRefModel(db, uuid) : new ForwardRefModel(db, stModel);
	}


	public WithRouterImportModel newWithRouterImportModel() {
		return new WithRouterImportModel(db);
	}

	public WithRouterImportModel newWithRouterImportModel(STModel stModel) {
		return new WithRouterImportModel(db, stModel);
	}

	public WithRouterImportModel newWithRouterImportModel(Node node) {
		return new WithRouterImportModel(db, node);
	}

	public Stream<WithRouterImportModel> findAllWithRouterImportModel() {
		return db.findAllSTModelByStTemplate(WithRouterImportModel.stTemplateUuid)
				.map(stModel -> new WithRouterImportModel(db, stModel));
	}

	public WithRouterImportModel findWithRouterImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new WithRouterImportModel(db, uuid) : new WithRouterImportModel(db, stModel);
	}


	public ReactRouterLinkImportModel newReactRouterLinkImportModel() {
		return new ReactRouterLinkImportModel(db);
	}

	public ReactRouterLinkImportModel newReactRouterLinkImportModel(STModel stModel) {
		return new ReactRouterLinkImportModel(db, stModel);
	}

	public ReactRouterLinkImportModel newReactRouterLinkImportModel(Node node) {
		return new ReactRouterLinkImportModel(db, node);
	}

	public Stream<ReactRouterLinkImportModel> findAllReactRouterLinkImportModel() {
		return db.findAllSTModelByStTemplate(ReactRouterLinkImportModel.stTemplateUuid)
				.map(stModel -> new ReactRouterLinkImportModel(db, stModel));
	}

	public ReactRouterLinkImportModel findReactRouterLinkImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReactRouterLinkImportModel(db, uuid) : new ReactRouterLinkImportModel(db, stModel);
	}


	public JSXModel newJSXModel() {
		return new JSXModel(db);
	}

	public JSXModel newJSXModel(STModel stModel) {
		return new JSXModel(db, stModel);
	}

	public JSXModel newJSXModel(Node node) {
		return new JSXModel(db, node);
	}

	public Stream<JSXModel> findAllJSXModel() {
		return db.findAllSTModelByStTemplate(JSXModel.stTemplateUuid)
				.map(stModel -> new JSXModel(db, stModel));
	}

	public JSXModel findJSXModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new JSXModel(db, uuid) : new JSXModel(db, stModel);
	}


	public FunctionalComponentModel newFunctionalComponentModel() {
		return new FunctionalComponentModel(db);
	}

	public FunctionalComponentModel newFunctionalComponentModel(STModel stModel) {
		return new FunctionalComponentModel(db, stModel);
	}

	public FunctionalComponentModel newFunctionalComponentModel(Node node) {
		return new FunctionalComponentModel(db, node);
	}

	public Stream<FunctionalComponentModel> findAllFunctionalComponentModel() {
		return db.findAllSTModelByStTemplate(FunctionalComponentModel.stTemplateUuid)
				.map(stModel -> new FunctionalComponentModel(db, stModel));
	}

	public FunctionalComponentModel findFunctionalComponentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FunctionalComponentModel(db, uuid) : new FunctionalComponentModel(db, stModel);
	}


	public DestructorPropModel newDestructorPropModel() {
		return new DestructorPropModel(db);
	}

	public DestructorPropModel newDestructorPropModel(STModel stModel) {
		return new DestructorPropModel(db, stModel);
	}

	public DestructorPropModel newDestructorPropModel(Node node) {
		return new DestructorPropModel(db, node);
	}

	public Stream<DestructorPropModel> findAllDestructorPropModel() {
		return db.findAllSTModelByStTemplate(DestructorPropModel.stTemplateUuid)
				.map(stModel -> new DestructorPropModel(db, stModel));
	}

	public DestructorPropModel findDestructorPropModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DestructorPropModel(db, uuid) : new DestructorPropModel(db, stModel);
	}


	public ReturnStatementModel newReturnStatementModel() {
		return new ReturnStatementModel(db);
	}

	public ReturnStatementModel newReturnStatementModel(STModel stModel) {
		return new ReturnStatementModel(db, stModel);
	}

	public ReturnStatementModel newReturnStatementModel(Node node) {
		return new ReturnStatementModel(db, node);
	}

	public Stream<ReturnStatementModel> findAllReturnStatementModel() {
		return db.findAllSTModelByStTemplate(ReturnStatementModel.stTemplateUuid)
				.map(stModel -> new ReturnStatementModel(db, stModel));
	}

	public ReturnStatementModel findReturnStatementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReturnStatementModel(db, uuid) : new ReturnStatementModel(db, stModel);
	}


	public PropModel newPropModel() {
		return new PropModel(db);
	}

	public PropModel newPropModel(STModel stModel) {
		return new PropModel(db, stModel);
	}

	public PropModel newPropModel(Node node) {
		return new PropModel(db, node);
	}

	public Stream<PropModel> findAllPropModel() {
		return db.findAllSTModelByStTemplate(PropModel.stTemplateUuid)
				.map(stModel -> new PropModel(db, stModel));
	}

	public PropModel findPropModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PropModel(db, uuid) : new PropModel(db, stModel);
	}


	public StateModel newStateModel() {
		return new StateModel(db);
	}

	public StateModel newStateModel(STModel stModel) {
		return new StateModel(db, stModel);
	}

	public StateModel newStateModel(Node node) {
		return new StateModel(db, node);
	}

	public Stream<StateModel> findAllStateModel() {
		return db.findAllSTModelByStTemplate(StateModel.stTemplateUuid)
				.map(stModel -> new StateModel(db, stModel));
	}

	public StateModel findStateModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StateModel(db, uuid) : new StateModel(db, stModel);
	}


	public ClassComponentModel newClassComponentModel() {
		return new ClassComponentModel(db);
	}

	public ClassComponentModel newClassComponentModel(STModel stModel) {
		return new ClassComponentModel(db, stModel);
	}

	public ClassComponentModel newClassComponentModel(Node node) {
		return new ClassComponentModel(db, node);
	}

	public Stream<ClassComponentModel> findAllClassComponentModel() {
		return db.findAllSTModelByStTemplate(ClassComponentModel.stTemplateUuid)
				.map(stModel -> new ClassComponentModel(db, stModel));
	}

	public ClassComponentModel findClassComponentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ClassComponentModel(db, uuid) : new ClassComponentModel(db, stModel);
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


	public MethodDeclarationModel newMethodDeclarationModel() {
		return new MethodDeclarationModel(db);
	}

	public MethodDeclarationModel newMethodDeclarationModel(STModel stModel) {
		return new MethodDeclarationModel(db, stModel);
	}

	public MethodDeclarationModel newMethodDeclarationModel(Node node) {
		return new MethodDeclarationModel(db, node);
	}

	public Stream<MethodDeclarationModel> findAllMethodDeclarationModel() {
		return db.findAllSTModelByStTemplate(MethodDeclarationModel.stTemplateUuid)
				.map(stModel -> new MethodDeclarationModel(db, stModel));
	}

	public MethodDeclarationModel findMethodDeclarationModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MethodDeclarationModel(db, uuid) : new MethodDeclarationModel(db, stModel);
	}


	public NamedImportModel newNamedImportModel() {
		return new NamedImportModel(db);
	}

	public NamedImportModel newNamedImportModel(STModel stModel) {
		return new NamedImportModel(db, stModel);
	}

	public NamedImportModel newNamedImportModel(Node node) {
		return new NamedImportModel(db, node);
	}

	public Stream<NamedImportModel> findAllNamedImportModel() {
		return db.findAllSTModelByStTemplate(NamedImportModel.stTemplateUuid)
				.map(stModel -> new NamedImportModel(db, stModel));
	}

	public NamedImportModel findNamedImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NamedImportModel(db, uuid) : new NamedImportModel(db, stModel);
	}


	public MapPropertyModel newMapPropertyModel() {
		return new MapPropertyModel(db);
	}

	public MapPropertyModel newMapPropertyModel(STModel stModel) {
		return new MapPropertyModel(db, stModel);
	}

	public MapPropertyModel newMapPropertyModel(Node node) {
		return new MapPropertyModel(db, node);
	}

	public Stream<MapPropertyModel> findAllMapPropertyModel() {
		return db.findAllSTModelByStTemplate(MapPropertyModel.stTemplateUuid)
				.map(stModel -> new MapPropertyModel(db, stModel));
	}

	public MapPropertyModel findMapPropertyModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MapPropertyModel(db, uuid) : new MapPropertyModel(db, stModel);
	}


	public ElementsModel newElementsModel() {
		return new ElementsModel(db);
	}

	public ElementsModel newElementsModel(STModel stModel) {
		return new ElementsModel(db, stModel);
	}

	public ElementsModel newElementsModel(Node node) {
		return new ElementsModel(db, node);
	}

	public Stream<ElementsModel> findAllElementsModel() {
		return db.findAllSTModelByStTemplate(ElementsModel.stTemplateUuid)
				.map(stModel -> new ElementsModel(db, stModel));
	}

	public ElementsModel findElementsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ElementsModel(db, uuid) : new ElementsModel(db, stModel);
	}


	public UlModel newUlModel() {
		return new UlModel(db);
	}

	public UlModel newUlModel(STModel stModel) {
		return new UlModel(db, stModel);
	}

	public UlModel newUlModel(Node node) {
		return new UlModel(db, node);
	}

	public Stream<UlModel> findAllUlModel() {
		return db.findAllSTModelByStTemplate(UlModel.stTemplateUuid)
				.map(stModel -> new UlModel(db, stModel));
	}

	public UlModel findUlModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new UlModel(db, uuid) : new UlModel(db, stModel);
	}


	public DivModel newDivModel() {
		return new DivModel(db);
	}

	public DivModel newDivModel(STModel stModel) {
		return new DivModel(db, stModel);
	}

	public DivModel newDivModel(Node node) {
		return new DivModel(db, node);
	}

	public Stream<DivModel> findAllDivModel() {
		return db.findAllSTModelByStTemplate(DivModel.stTemplateUuid)
				.map(stModel -> new DivModel(db, stModel));
	}

	public DivModel findDivModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DivModel(db, uuid) : new DivModel(db, stModel);
	}


	public FormModel newFormModel() {
		return new FormModel(db);
	}

	public FormModel newFormModel(STModel stModel) {
		return new FormModel(db, stModel);
	}

	public FormModel newFormModel(Node node) {
		return new FormModel(db, node);
	}

	public Stream<FormModel> findAllFormModel() {
		return db.findAllSTModelByStTemplate(FormModel.stTemplateUuid)
				.map(stModel -> new FormModel(db, stModel));
	}

	public FormModel findFormModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormModel(db, uuid) : new FormModel(db, stModel);
	}


	public ElementModel newElementModel() {
		return new ElementModel(db);
	}

	public ElementModel newElementModel(STModel stModel) {
		return new ElementModel(db, stModel);
	}

	public ElementModel newElementModel(Node node) {
		return new ElementModel(db, node);
	}

	public Stream<ElementModel> findAllElementModel() {
		return db.findAllSTModelByStTemplate(ElementModel.stTemplateUuid)
				.map(stModel -> new ElementModel(db, stModel));
	}

	public ElementModel findElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ElementModel(db, uuid) : new ElementModel(db, stModel);
	}


	public AppModel newAppModel() {
		return new AppModel(db);
	}

	public AppModel newAppModel(STModel stModel) {
		return new AppModel(db, stModel);
	}

	public AppModel newAppModel(Node node) {
		return new AppModel(db, node);
	}

	public Stream<AppModel> findAllAppModel() {
		return db.findAllSTModelByStTemplate(AppModel.stTemplateUuid)
				.map(stModel -> new AppModel(db, stModel));
	}

	public AppModel findAppModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AppModel(db, uuid) : new AppModel(db, stModel);
	}


	public ControlFlowModel newControlFlowModel() {
		return new ControlFlowModel(db);
	}

	public ControlFlowModel newControlFlowModel(STModel stModel) {
		return new ControlFlowModel(db, stModel);
	}

	public ControlFlowModel newControlFlowModel(Node node) {
		return new ControlFlowModel(db, node);
	}

	public Stream<ControlFlowModel> findAllControlFlowModel() {
		return db.findAllSTModelByStTemplate(ControlFlowModel.stTemplateUuid)
				.map(stModel -> new ControlFlowModel(db, stModel));
	}

	public ControlFlowModel findControlFlowModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ControlFlowModel(db, uuid) : new ControlFlowModel(db, stModel);
	}


	public IfModel newIfModel() {
		return new IfModel(db);
	}

	public IfModel newIfModel(STModel stModel) {
		return new IfModel(db, stModel);
	}

	public IfModel newIfModel(Node node) {
		return new IfModel(db, node);
	}

	public Stream<IfModel> findAllIfModel() {
		return db.findAllSTModelByStTemplate(IfModel.stTemplateUuid)
				.map(stModel -> new IfModel(db, stModel));
	}

	public IfModel findIfModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IfModel(db, uuid) : new IfModel(db, stModel);
	}


	public ConditionalModel newConditionalModel() {
		return new ConditionalModel(db);
	}

	public ConditionalModel newConditionalModel(STModel stModel) {
		return new ConditionalModel(db, stModel);
	}

	public ConditionalModel newConditionalModel(Node node) {
		return new ConditionalModel(db, node);
	}

	public Stream<ConditionalModel> findAllConditionalModel() {
		return db.findAllSTModelByStTemplate(ConditionalModel.stTemplateUuid)
				.map(stModel -> new ConditionalModel(db, stModel));
	}

	public ConditionalModel findConditionalModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ConditionalModel(db, uuid) : new ConditionalModel(db, stModel);
	}


	public SuperagentModel newSuperagentModel() {
		return new SuperagentModel(db);
	}

	public SuperagentModel newSuperagentModel(STModel stModel) {
		return new SuperagentModel(db, stModel);
	}

	public SuperagentModel newSuperagentModel(Node node) {
		return new SuperagentModel(db, node);
	}

	public Stream<SuperagentModel> findAllSuperagentModel() {
		return db.findAllSTModelByStTemplate(SuperagentModel.stTemplateUuid)
				.map(stModel -> new SuperagentModel(db, stModel));
	}

	public SuperagentModel findSuperagentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SuperagentModel(db, uuid) : new SuperagentModel(db, stModel);
	}


	public AgentEndpointModel newAgentEndpointModel() {
		return new AgentEndpointModel(db);
	}

	public AgentEndpointModel newAgentEndpointModel(STModel stModel) {
		return new AgentEndpointModel(db, stModel);
	}

	public AgentEndpointModel newAgentEndpointModel(Node node) {
		return new AgentEndpointModel(db, node);
	}

	public Stream<AgentEndpointModel> findAllAgentEndpointModel() {
		return db.findAllSTModelByStTemplate(AgentEndpointModel.stTemplateUuid)
				.map(stModel -> new AgentEndpointModel(db, stModel));
	}

	public AgentEndpointModel findAgentEndpointModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AgentEndpointModel(db, uuid) : new AgentEndpointModel(db, stModel);
	}


	public AgentDeclarationModel newAgentDeclarationModel() {
		return new AgentDeclarationModel(db);
	}

	public AgentDeclarationModel newAgentDeclarationModel(STModel stModel) {
		return new AgentDeclarationModel(db, stModel);
	}

	public AgentDeclarationModel newAgentDeclarationModel(Node node) {
		return new AgentDeclarationModel(db, node);
	}

	public Stream<AgentDeclarationModel> findAllAgentDeclarationModel() {
		return db.findAllSTModelByStTemplate(AgentDeclarationModel.stTemplateUuid)
				.map(stModel -> new AgentDeclarationModel(db, stModel));
	}

	public AgentDeclarationModel findAgentDeclarationModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AgentDeclarationModel(db, uuid) : new AgentDeclarationModel(db, stModel);
	}


	public AgentRequestModel newAgentRequestModel() {
		return new AgentRequestModel(db);
	}

	public AgentRequestModel newAgentRequestModel(STModel stModel) {
		return new AgentRequestModel(db, stModel);
	}

	public AgentRequestModel newAgentRequestModel(Node node) {
		return new AgentRequestModel(db, node);
	}

	public Stream<AgentRequestModel> findAllAgentRequestModel() {
		return db.findAllSTModelByStTemplate(AgentRequestModel.stTemplateUuid)
				.map(stModel -> new AgentRequestModel(db, stModel));
	}

	public AgentRequestModel findAgentRequestModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AgentRequestModel(db, uuid) : new AgentRequestModel(db, stModel);
	}


	public JsonArrayModel newJsonArrayModel() {
		return new JsonArrayModel(db);
	}

	public JsonArrayModel newJsonArrayModel(STModel stModel) {
		return new JsonArrayModel(db, stModel);
	}

	public JsonArrayModel newJsonArrayModel(Node node) {
		return new JsonArrayModel(db, node);
	}

	public Stream<JsonArrayModel> findAllJsonArrayModel() {
		return db.findAllSTModelByStTemplate(JsonArrayModel.stTemplateUuid)
				.map(stModel -> new JsonArrayModel(db, stModel));
	}

	public JsonArrayModel findJsonArrayModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new JsonArrayModel(db, uuid) : new JsonArrayModel(db, stModel);
	}


	public VariablesModel newVariablesModel() {
		return new VariablesModel(db);
	}

	public VariablesModel newVariablesModel(STModel stModel) {
		return new VariablesModel(db, stModel);
	}

	public VariablesModel newVariablesModel(Node node) {
		return new VariablesModel(db, node);
	}

	public Stream<VariablesModel> findAllVariablesModel() {
		return db.findAllSTModelByStTemplate(VariablesModel.stTemplateUuid)
				.map(stModel -> new VariablesModel(db, stModel));
	}

	public VariablesModel findVariablesModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new VariablesModel(db, uuid) : new VariablesModel(db, stModel);
	}


	public ConstVariableModel newConstVariableModel() {
		return new ConstVariableModel(db);
	}

	public ConstVariableModel newConstVariableModel(STModel stModel) {
		return new ConstVariableModel(db, stModel);
	}

	public ConstVariableModel newConstVariableModel(Node node) {
		return new ConstVariableModel(db, node);
	}

	public Stream<ConstVariableModel> findAllConstVariableModel() {
		return db.findAllSTModelByStTemplate(ConstVariableModel.stTemplateUuid)
				.map(stModel -> new ConstVariableModel(db, stModel));
	}

	public ConstVariableModel findConstVariableModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ConstVariableModel(db, uuid) : new ConstVariableModel(db, stModel);
	}


	public StatementModel newStatementModel() {
		return new StatementModel(db);
	}

	public StatementModel newStatementModel(STModel stModel) {
		return new StatementModel(db, stModel);
	}

	public StatementModel newStatementModel(Node node) {
		return new StatementModel(db, node);
	}

	public Stream<StatementModel> findAllStatementModel() {
		return db.findAllSTModelByStTemplate(StatementModel.stTemplateUuid)
				.map(stModel -> new StatementModel(db, stModel));
	}

	public StatementModel findStatementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StatementModel(db, uuid) : new StatementModel(db, stModel);
	}


	public Optional<BlockStmtModel> findBlockStmtModelByStmt(STValue value) {
		return Optional.ofNullable(db.find("stmt", value, BlockStmtModel.stTemplateUuid, BlockStmtModel::new));
	}

	public Optional<DecoratorModel> findDecoratorModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, DecoratorModel.stTemplateUuid, DecoratorModel::new));
	}

	public Optional<NameArrayModel> findNameArrayModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NameArrayModel.stTemplateUuid, NameArrayModel::new));
	}

	public Optional<NameValueModel> findNameValueModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NameValueModel.stTemplateUuid, NameValueModel::new));
	}

	public Optional<NameValueModel> findNameValueModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, NameValueModel.stTemplateUuid, NameValueModel::new));
	}

	public Optional<ArrowFunctionModel> findArrowFunctionModelByExpression(STValue value) {
		return Optional.ofNullable(db.find("expression", value, ArrowFunctionModel.stTemplateUuid, ArrowFunctionModel::new));
	}

	public Optional<FunctionModel> findFunctionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, FunctionModel.stTemplateUuid, FunctionModel::new));
	}

	public Optional<FunctionExpressionModel> findFunctionExpressionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, FunctionExpressionModel.stTemplateUuid, FunctionExpressionModel::new));
	}

	public Optional<FunctionExpressionModel> findFunctionExpressionModelByFunction(STValue value) {
		return Optional.ofNullable(db.find("function", value, FunctionExpressionModel.stTemplateUuid, FunctionExpressionModel::new));
	}

	public Optional<FunctionCallModel> findFunctionCallModelByScope(STValue value) {
		return Optional.ofNullable(db.find("scope", value, FunctionCallModel.stTemplateUuid, FunctionCallModel::new));
	}

	public Optional<FunctionCallModel> findFunctionCallModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, FunctionCallModel.stTemplateUuid, FunctionCallModel::new));
	}

	public Optional<ReturnStmtModel> findReturnStmtModelByReturnValue(STValue value) {
		return Optional.ofNullable(db.find("returnValue", value, ReturnStmtModel.stTemplateUuid, ReturnStmtModel::new));
	}

	public Optional<IndexHtmlModel> findIndexHtmlModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, IndexHtmlModel.stTemplateUuid, IndexHtmlModel::new));
	}

	public Optional<LinkModel> findLinkModelByTo(STValue value) {
		return Optional.ofNullable(db.find("to", value, LinkModel.stTemplateUuid, LinkModel::new));
	}

	public Optional<ForwardRefModel> findForwardRefModelByTo(STValue value) {
		return Optional.ofNullable(db.find("to", value, ForwardRefModel.stTemplateUuid, ForwardRefModel::new));
	}

	public Optional<ForwardRefModel> findForwardRefModelByTarget(STValue value) {
		return Optional.ofNullable(db.find("target", value, ForwardRefModel.stTemplateUuid, ForwardRefModel::new));
	}

	public Optional<FunctionalComponentModel> findFunctionalComponentModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, FunctionalComponentModel.stTemplateUuid, FunctionalComponentModel::new));
	}

	public Optional<FunctionalComponentModel> findFunctionalComponentModelByElement(STValue value) {
		return Optional.ofNullable(db.find("element", value, FunctionalComponentModel.stTemplateUuid, FunctionalComponentModel::new));
	}

	public Optional<DestructorPropModel> findDestructorPropModelByChild(STValue value) {
		return Optional.ofNullable(db.find("child", value, DestructorPropModel.stTemplateUuid, DestructorPropModel::new));
	}

	public Optional<ReturnStatementModel> findReturnStatementModelByCondition(STValue value) {
		return Optional.ofNullable(db.find("condition", value, ReturnStatementModel.stTemplateUuid, ReturnStatementModel::new));
	}

	public Optional<ReturnStatementModel> findReturnStatementModelByElement(STValue value) {
		return Optional.ofNullable(db.find("element", value, ReturnStatementModel.stTemplateUuid, ReturnStatementModel::new));
	}

	public Optional<PropModel> findPropModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PropModel.stTemplateUuid, PropModel::new));
	}

	public Optional<PropModel> findPropModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, PropModel.stTemplateUuid, PropModel::new));
	}

	public Optional<PropModel> findPropModelByStringValue(STValue value) {
		return Optional.ofNullable(db.find("stringValue", value, PropModel.stTemplateUuid, PropModel::new));
	}

	public Optional<PropModel> findPropModelByExpression(STValue value) {
		return Optional.ofNullable(db.find("expression", value, PropModel.stTemplateUuid, PropModel::new));
	}

	public Optional<ClassComponentModel> findClassComponentModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ClassComponentModel.stTemplateUuid, ClassComponentModel::new));
	}

	public Optional<ClassComponentModel> findClassComponentModelByRenderCondition(STValue value) {
		return Optional.ofNullable(db.find("renderCondition", value, ClassComponentModel.stTemplateUuid, ClassComponentModel::new));
	}

	public Optional<ClassComponentModel> findClassComponentModelByRenderTrue(STValue value) {
		return Optional.ofNullable(db.find("renderTrue", value, ClassComponentModel.stTemplateUuid, ClassComponentModel::new));
	}

	public Optional<ClassComponentModel> findClassComponentModelByRenderFalse(STValue value) {
		return Optional.ofNullable(db.find("renderFalse", value, ClassComponentModel.stTemplateUuid, ClassComponentModel::new));
	}

	public Optional<ClassComponentModel> findClassComponentModelByRenderElement(STValue value) {
		return Optional.ofNullable(db.find("renderElement", value, ClassComponentModel.stTemplateUuid, ClassComponentModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<DependencyModel> findDependencyModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, DependencyModel.stTemplateUuid, DependencyModel::new));
	}

	public Optional<MethodDeclarationModel> findMethodDeclarationModelByConst(STValue value) {
		return Optional.ofNullable(db.find("const", value, MethodDeclarationModel.stTemplateUuid, MethodDeclarationModel::new));
	}

	public Optional<MethodDeclarationModel> findMethodDeclarationModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, MethodDeclarationModel.stTemplateUuid, MethodDeclarationModel::new));
	}

	public Optional<MapPropertyModel> findMapPropertyModelByProperty(STValue value) {
		return Optional.ofNullable(db.find("property", value, MapPropertyModel.stTemplateUuid, MapPropertyModel::new));
	}

	public Optional<MapPropertyModel> findMapPropertyModelByForEach(STValue value) {
		return Optional.ofNullable(db.find("forEach", value, MapPropertyModel.stTemplateUuid, MapPropertyModel::new));
	}

	public Optional<UlModel> findUlModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, UlModel.stTemplateUuid, UlModel::new));
	}

	public Optional<DivModel> findDivModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DivModel.stTemplateUuid, DivModel::new));
	}

	public Optional<FormModel> findFormModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormModel.stTemplateUuid, FormModel::new));
	}

	public Optional<FormModel> findFormModelByOnSubmit(STValue value) {
		return Optional.ofNullable(db.find("onSubmit", value, FormModel.stTemplateUuid, FormModel::new));
	}

	public Optional<FormModel> findFormModelByNoValidate(STValue value) {
		return Optional.ofNullable(db.find("noValidate", value, FormModel.stTemplateUuid, FormModel::new));
	}

	public Optional<ElementModel> findElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ElementModel.stTemplateUuid, ElementModel::new));
	}

	public Optional<AppModel> findAppModelByTheme(STValue value) {
		return Optional.ofNullable(db.find("theme", value, AppModel.stTemplateUuid, AppModel::new));
	}

	public Optional<IfModel> findIfModelByCondition(STValue value) {
		return Optional.ofNullable(db.find("condition", value, IfModel.stTemplateUuid, IfModel::new));
	}

	public Optional<IfModel> findIfModelByThen(STValue value) {
		return Optional.ofNullable(db.find("then", value, IfModel.stTemplateUuid, IfModel::new));
	}

	public Optional<IfModel> findIfModelByOtherwise(STValue value) {
		return Optional.ofNullable(db.find("otherwise", value, IfModel.stTemplateUuid, IfModel::new));
	}

	public Optional<ConditionalModel> findConditionalModelByCondition(STValue value) {
		return Optional.ofNullable(db.find("condition", value, ConditionalModel.stTemplateUuid, ConditionalModel::new));
	}

	public Optional<ConditionalModel> findConditionalModelByThen(STValue value) {
		return Optional.ofNullable(db.find("then", value, ConditionalModel.stTemplateUuid, ConditionalModel::new));
	}

	public Optional<ConditionalModel> findConditionalModelByOtherwise(STValue value) {
		return Optional.ofNullable(db.find("otherwise", value, ConditionalModel.stTemplateUuid, ConditionalModel::new));
	}

	public Optional<AgentEndpointModel> findAgentEndpointModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, AgentEndpointModel.stTemplateUuid, AgentEndpointModel::new));
	}

	public Optional<AgentEndpointModel> findAgentEndpointModelByUrlParam(STValue value) {
		return Optional.ofNullable(db.find("urlParam", value, AgentEndpointModel.stTemplateUuid, AgentEndpointModel::new));
	}

	public Optional<AgentEndpointModel> findAgentEndpointModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, AgentEndpointModel.stTemplateUuid, AgentEndpointModel::new));
	}

	public Optional<AgentEndpointModel> findAgentEndpointModelByUrl(STValue value) {
		return Optional.ofNullable(db.find("url", value, AgentEndpointModel.stTemplateUuid, AgentEndpointModel::new));
	}

	public Optional<AgentDeclarationModel> findAgentDeclarationModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, AgentDeclarationModel.stTemplateUuid, AgentDeclarationModel::new));
	}

	public Optional<AgentRequestModel> findAgentRequestModelByEndpoint(STValue value) {
		return Optional.ofNullable(db.find("endpoint", value, AgentRequestModel.stTemplateUuid, AgentRequestModel::new));
	}

	public Optional<AgentRequestModel> findAgentRequestModelByMethod(STValue value) {
		return Optional.ofNullable(db.find("method", value, AgentRequestModel.stTemplateUuid, AgentRequestModel::new));
	}

	public Optional<AgentRequestModel> findAgentRequestModelByFinally(STValue value) {
		return Optional.ofNullable(db.find("finally", value, AgentRequestModel.stTemplateUuid, AgentRequestModel::new));
	}

	public Optional<ConstVariableModel> findConstVariableModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ConstVariableModel.stTemplateUuid, ConstVariableModel::new));
	}

	public Optional<ConstVariableModel> findConstVariableModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, ConstVariableModel.stTemplateUuid, ConstVariableModel::new));
	}

	public Optional<StatementModel> findStatementModelByExpression(STValue value) {
		return Optional.ofNullable(db.find("expression", value, StatementModel.stTemplateUuid, StatementModel::new));
	}
}