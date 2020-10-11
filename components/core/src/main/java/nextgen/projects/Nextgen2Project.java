package nextgen.projects;

import nextgen.templates.*;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.domain.Relation;
import nextgen.templates.domain.RelationType;
import nextgen.templates.greenrobot.Event;
import nextgen.templates.greenrobot.EventManager;
import nextgen.templates.greenrobot.Subscribe;
import nextgen.templates.java.ClassOrInterfaceType;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.java.Singleton;
import nextgen.templates.javaswing.*;
import nextgen.templates.maven.MavenST;
import nextgen.templates.maven.Pom;
import nextgen.templates.nextgen.Canvas;
import nextgen.templates.nextgen.CanvasNode;
import nextgen.templates.nextgen.DomainFacade;
import nextgen.templates.nextgen.STTemplateEditor;
import nextgen.utils.StringUtil;

import java.io.File;
import java.util.*;

import static nextgen.projects.Nextgen2Project.EntityEventTypes.*;
import static nextgen.st.STGenerator.*;
import static nextgen.templates.DomainPatterns.newEnum;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.GreenRobotPatterns.newPostEventMethod;
import static nextgen.templates.JavaPatterns.*;
import static nextgen.templates.javaswing.JavaSwingST.newGetTreeNodeAction;
import static nextgen.templates.maven.MavenST.newDependency;
import static nextgen.utils.StringUtil.lowFirst;

public class Nextgen2Project {

   final File root = new File("/home/goe/projects/nextgen2");

   final File mainJava = new File(root, "src/main/java");
   final File mainResources = new File(root, "src/main/resources");

   final String nextgenPackageName = "nextgen";
   final String domainPackageName = "domain";
   final String swingPackageName = "swing";
   final String swingConfigPackageName = "config";
   final String swingComponentsPackageName = "components";
   final String swingActionsPackageName = "actions";
   final String eventsPackageName = "events";
   final String navigationPackageName = "navigation";
   final String editorsPackageName = "editors";
   final String canvasPackageName = "canvas";
   final String workspacePackageName = "workspace";
   final String stParserPackageName = "stParser";

   final PackageDeclaration nextgenPackage = JavaPatterns.newPackageDeclaration(nextgenPackageName);
   final PackageDeclaration domainPackage = JavaPatterns.newPackageDeclaration(nextgenPackage, domainPackageName);
   final PackageDeclaration swingPackage = JavaPatterns.newPackageDeclaration(nextgenPackage, swingPackageName);
   final PackageDeclaration swingConfigPackage = JavaPatterns.newPackageDeclaration(swingPackage, swingConfigPackageName);
   final PackageDeclaration componentsPackage = JavaPatterns.newPackageDeclaration(swingPackage, swingComponentsPackageName);
   final PackageDeclaration eventsPackage = JavaPatterns.newPackageDeclaration(nextgenPackage, eventsPackageName);
   final PackageDeclaration actionsPackage = JavaPatterns.newPackageDeclaration(swingPackage, swingActionsPackageName);
   final PackageDeclaration navigationPackage = getPackageDeclaration(componentsPackage, navigationPackageName);
   final PackageDeclaration editorsPackage = getPackageDeclaration(componentsPackage, editorsPackageName);
   final PackageDeclaration canvasPackage = getPackageDeclaration(componentsPackage, canvasPackageName);
   final PackageDeclaration workspacePackage = getPackageDeclaration(componentsPackage, workspacePackageName);
   final PackageDeclaration stParserPackage = getPackageDeclaration(nextgenPackage, stParserPackageName);

   final String domainNeoFactoryName = "DomainNeoFactory";
   final String domainFacadeName = "DomainFacade";
   final String appModelName = "AppModel";
   final String baseEditorName = "Editor";
   final String stTemplateTextEditorName = "STTemplateTextEditor";
   final String eventManagerName = "DomainEvents";
   final String projectCanvasName = "ProjectCanvas";
   final String transactionActionName = "TransactionAction";
   final String navigatorName = "Navigator";
   final String navigatorTreeName = "NavigatorTree";
   final String navigatorRootNodeName = "NavigatorRootNode";
   final String navigationTreeModelName = "NavigatorTreeModel";
   final String templatesRootNodeName = "TemplatesTreeNode";
   final String navigatorTreeNodeName = "NavigatorTreeNode";
   final String projectsRootNodeName = "ProjectsTreeNode";
   final String workspaceName = "Workspace";
   final String swingUtilName = "SwingUtil";
   final String buttonTabName = "ButtonTab";
   final String tabPanelName = "TabPanel";

   final String stringType = "String";
   final String awtDimensionType = "java.awt.Dimension";
   final String integerType = "Integer";
   final String jFrameType = "javax.swing.JFrame";

   final JTabbedPane tabbedPane = JavaSwingPatterns.newJTabbedPane()
         .setPackageName(workspacePackage.getName())
         .setName(tabPanelName);

   final Editor editor = JavaSwingPatterns.newEditor()
         .setPackageName(editorsPackage.getName())
         .setName(baseEditorName);

   final EventManager eventManager = GreenRobotPatterns.newEventManager()
         .setPackage(eventsPackage.getName())
         .setName(eventManagerName)
         .addImports(newImportDeclaration(domainPackage.getName()).setIsAsterisk(true));

   final JPanel workspace = JavaSwingPatterns.newJPanel()
         .setPackageName(workspacePackage.getName())
         .setName(workspaceName);

   final BaseTreeNode baseTreeNode = JavaSwingPatterns.newBaseTreeNode()
         .setPackageName(navigationPackage.getName())
         .setName(navigatorTreeNodeName);

   final DomainFacade domainFacade = NextgenPatterns.newDomainFacade()
         .setName(domainFacadeName)
         .setPackageName(nextgenPackage.getName());

   final JPanel navigator = JavaSwingPatterns.newJPanel()
         .setPackageName(navigationPackage.getName())
         .setName(navigatorName);

   enum EntityEventTypes {
      NEW, UPDATE, DELETE, SELECT
   }

   final Map<Entity, Map<EntityEventTypes, Event>> entityEventMap = new LinkedHashMap<>();
   final Map<Entity, TreeNode> entityTreeNodeMap = new LinkedHashMap<>();
   final Map<Entity, ModelEditor> entityEditorMap = new LinkedHashMap<>();
   final Set<EntityAction> entityActions = new LinkedHashSet<>();
   final Map<Entity, String> entityVariableNameMap = new LinkedHashMap<>();

   final Map<Object, ClassOrInterfaceType> typesMap = new LinkedHashMap<>();

   @org.junit.Test
   public void generateDomain() {

      typesMap.put(baseEditorName, newClassOrInterfaceType(editor.getPackageName(), editor.getName()));
      typesMap.put(eventManagerName, newClassOrInterfaceType(eventManager.getPackage(), eventManager.getName()));
      typesMap.put(workspaceName, newClassOrInterfaceType(workspace.getPackageName(), workspace.getName()));
      typesMap.put(tabPanelName, newClassOrInterfaceType(tabbedPane.getPackageName(), tabbedPane.getName()));
      typesMap.put(navigatorTreeNodeName, newClassOrInterfaceType(baseTreeNode.getPackageName(), baseTreeNode.getName()));
      typesMap.put(domainNeoFactoryName, newClassOrInterfaceType(domainPackage, domainNeoFactoryName));
      typesMap.put(domainFacadeName, newClassOrInterfaceType(nextgenPackage, domainFacadeName));
      typesMap.put(navigatorName, newClassOrInterfaceType(navigator.getPackageName(), navigator.getName()));

      // ST
      final Entity stParameterType = newEnum("STParameterType", "SINGLE,LIST,KVLIST");

      final Entity stParameterKey = newEntityWithUuid("STParameterKey")
            .addRelations(newStringField("name"))
            .addRelations(newStringField("argumentType"));

      final Entity stParameter = newEntityWithUuid("STParameter")
            .addRelations(newStringField("name", true))
            .addRelations(newEnumField("type", stParameterType))
            .addRelations(newOneToMany("keys", stParameterKey))
            .addRelations(newStringField("argumentType"));

      final Entity stTemplate = newEntityWithUuid("STTemplate")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("text"))
            .addRelations(newOneToManyString("implements"))
            .addRelations(newOneToMany("parameters", stParameter))
            .addRelations(newOneToManySelf("children"));

      final Entity stInterface = newEntityWithUuid("STInterface")
            .addRelations(newStringField("name"));

      final Entity stEnumValue = newEntityWithUuid("STEnumValue")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("lexical"));

      final Entity stEnum = newEntityWithUuid("STEnum")
            .addRelations(newStringField("name", true))
            .addRelations(newOneToMany("values", stEnumValue));

      final Entity stGroupModel = newEntityWithUuid("STGroupModel")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("delimiter"))
            .addRelations(newStringField("icon"))
            .addRelations(newStringField("tags"))
            .addRelations(newOneToMany("templates", stTemplate))
            .addRelations(newOneToMany("interfaces", stInterface))
            .addRelations(newOneToMany("enums", stEnum));


      // ST models
      final Entity stValueType = newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM");

      final Entity stValue = newEntityWithUuid("STValue")
            .setEqha("uuid")
            .addRelations(newStringField("value"))
            .addRelations(newEnumField("type", stValueType));

      final Entity stArgumentKV = newEntityWithUuid("STArgumentKV")
            .setEqha("uuid")
            .addRelations(newOneToOne("parameterKey", stParameterKey))
            .addRelations(newOneToOne("value", stValue));

      final Entity stArgument = newEntityWithUuid("STArgument")
            .setEqha("uuid")
            .addRelations(newOneToOne("parameter", stParameter))
            .addRelations(newOneToOne("value", stValue))
            .addRelations(newOneToMany("keyValues", stArgumentKV));

      final Entity stModel = newEntityWithUuid("STModel")
            .setEqha("uuid")
            .addRelations(newStringField("name"))
            .addRelations(newOneToOne("template", stTemplate))
            .addRelations(newOneToMany("arguments", stArgument));

      stValue.addRelations(newOneToOne("stModel", stModel));

      // Workflows
      final Entity workInput = DomainPatterns.newEntityWithUuid("WorkInput")
            .addRelations(DomainPatterns.newStringField("type"))
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity workStatement = DomainPatterns.newEntityWithUuid("WorkStatement")
            .addRelations(DomainPatterns.newStringField("statement"));

      final Entity workInstance = DomainPatterns.newEntityWithUuid("WorkInstance")
            .addRelations(DomainPatterns.newEnumField("type", "WorkType", "WORK,CONDITIONAL,SEQUENTIAL,PARALLEL,REPEAT"));

      final Entity work = DomainPatterns.newEntityWithUuid("Work")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("package"))
            .addRelations(DomainPatterns.newOneToMany("inputs", workInput))
            .addRelations(DomainPatterns.newOneToMany("statements", workStatement));
      workInstance.addRelations(DomainPatterns.newOneToOne("work", work));

      final Entity conditionalFlow = DomainPatterns.newEntityWithUuid("ConditionalFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToOne("then", workInstance))
            .addRelations(DomainPatterns.newOneToOne("otherwise", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("conditional", conditionalFlow));

      final Entity sequentialFlow = DomainPatterns.newEntityWithUuid("SequentialFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToMany("then", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("sequential", sequentialFlow));

      final Entity parallelFlow = DomainPatterns.newEntityWithUuid("ParallelFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("execute", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("parallel", parallelFlow));

      final Entity repeatFlow = DomainPatterns.newEntityWithUuid("RepeatFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("repeat", workInstance))
            .addRelations(DomainPatterns.newIntegerField("times"))
            .addRelations(DomainPatterns.newEnumField("until", "UntilPredicate", "ALWAYS_TRUE,ALWAYS_FALSE,COMPLETED,FAILED"));
      workInstance.addRelations(DomainPatterns.newOneToOne("repeat", repeatFlow));

      // Projects
      final Entity project = newEntityWithUuid("Project")
            .setEqha("uuid")
            .addRelations(newStringField("root", true))
            .addRelations(newStringField("name", true))
            .addRelations(newOneToMany("models", stModel))
            .addRelations(newOneToMany("work", work))
            .addRelations(newOneToMany("flows", workInstance));


      final Domain domain = newDomain("Domain")
            .addEntities(stGroupModel)
            .addEntities(stModel)
            .addEntities(project);

      // ST Parsing
      final Entity stgErrorType = newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL");

      final Entity stgError = newEntity("STGError")
            .addRelations(newEnumField("type", stgErrorType))
            .addRelations(newStringField("message"))
            .addRelations(newIntegerField("line"))
            .addRelations(newIntegerField("charPosition"));

      final Entity parsedParameterKey = newEntity("ParsedParameterKey")
            .addRelations(newStringField("name"))
            .addRelations(newStringField("argumentType"));

      final Entity parsedParameter = newEntity("ParsedParameter")
            .addRelations(newStringField("name", true))
            .addRelations(newEnumField("type", stParameterType))
            .addRelations(newOneToMany("keys", parsedParameterKey))
            .addRelations(newStringField("argumentType"));

      final Entity parsedSTTemplate = newEntity("ParsedSTTemplate")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("text"))
            .addRelations(newOneToMany("parameters", parsedParameter));

      final Entity parsedSTGroup = newEntity("ParsedSTGroup")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("delimiter"))
            .addRelations(newOneToMany("templates", parsedSTTemplate));

      final Entity stgParseResult = newEntity("STGParseResult")
            .addRelations(newOneToOne("parsed", parsedSTGroup))
            .addRelations(newOneToMany("errors", stgError));

      final Entity astNode = newEntity("AstNode")
            .addRelations(newOneToOneExternal("ast", "org.antlr.runtime.tree.Tree"))
            .addRelations(newOneToManySelf("children"))
            .addRelations(newEnumField("type", "AstNodeType", "ST, Expression, Name, Prop, Args, If, Else, ElseIf, Assign, Include, Subtemplate"));
      astNode.addRelations(newOneToOne("parent", astNode));

      final Domain parserDomain = newDomain("STParser")
            .addEntities(stgParseResult)
            .addEntities(astNode);

      new DomainVisitor() {

         @Override
         protected void startEntity(Entity entity) {

            entityEventMap.putIfAbsent(entity, new LinkedHashMap<>());
            typesMap.put(entity, newClassOrInterfaceType(domainPackage, entity.getName()));
            entityVariableNameMap.put(entity, lowFirst(entity.getName()));

            final Map<EntityEventTypes, Event> eventMap = entityEventMap.get(entity);
            eventMap.put(NEW, newEntityEvent(entity, "New"));
            eventMap.put(UPDATE, newEntityEvent(entity, "Updated"));
            eventMap.put(DELETE, GreenRobotPatterns
                  .newStaticEvent("Deleted" + StringUtil.capitalize(entity.getName()))
                  .addFields(stringType, "model"));
            eventMap.put(SELECT, newEntityEvent(entity, "Selected"));

            eventManager.addEvents(eventMap.get(NEW), newPostEventMethod(eventMap.get(NEW)));
            eventManager.addEvents(eventMap.get(UPDATE), newPostEventMethod(eventMap.get(UPDATE)));
            eventManager.addEvents(eventMap.get(DELETE), newPostEventMethod(eventMap.get(DELETE)));
            eventManager.addEvents(eventMap.get(SELECT), newPostEventMethod(eventMap.get(SELECT)));

            if (!entity.getIsEnum(false)) {
               findNameProperty(entity)
                     .ifPresent(relation -> {

                        // entity tree-node
                        entityTreeNodeMap.put(entity, newTreeNode(navigationPackage, baseTreeNode, entity.getName() + "TreeNode")
                              .setType(typesMap.get(entity))
                              .setUuidExpression("model.getUuid()")
                              .addConstructorStatements("setLabel(model.getName());")
                              .addSelectedStatements(GreenRobotPatterns
                                    .newCallPostEventMethod(eventMap.get(SELECT), typesMap.get(eventManagerName))
                                    .addArguments("getModel()")));

                        // entity editor
                        entityEditorMap.put(entity, newModelEditor(editorsPackage, entity)
                              .setBackground("BLACK"));
                        typesMap.put(entityEditorMap.get(entity), newClassOrInterfaceType(editorsPackage, entityEditorMap
                              .get(entity)
                              .getName()
                        ));

                        // add SELECT-event subscribe to workspace
                        workspace.addMethods(newSubscribe(entity, SELECT)
                              .setStatements(new Object[]{
                                    "SwingUtilities.invokeLater(() -> AppModel.getInstance().getDomain().doInTransaction(transaction -> {",
                                    "	final java.util.Optional<Editor<?>> existing = tab.getEditor(event.model);",
                                    "	if (existing.isPresent()) {",
                                    "		tab.setSelectedComponent(existing.get());",
                                    "	} else {",
                                    "		final Editor<?> editor = new " + entityEditorMap.get(entity)
                                          .getName() + "(event.model);",
                                    "		tab.add(editor.getTitle(), editor);",
                                    "		tab.setSelectedComponent(editor);",
                                    "	}",
                                    "}));"
                              }));
                     });
            }
         }

         private Optional<Relation> findNameProperty(Entity entity) {
            return entity.getRelations()
                  .stream()
                  .filter(relation -> relation.getType().equals(RelationType.PRIM_REF))
                  .filter(relation -> relation.getName().equalsIgnoreCase("name"))
                  .findFirst();
         }

         private Event newEntityEvent(Entity entity, String eventType) {
            return GreenRobotPatterns
                  .newStaticEvent(eventType + StringUtil.capitalize(entity.getName()))
                  .addFields(typesMap.get(entity), "model");
         }
      }.visit(domain);

      domainFacade
            .addImports(newImportDeclaration(domainPackage))
            .addImports(newImportDeclaration(stParserPackage))
            .setFactory(typesMap.get(domainNeoFactoryName));

      // Swing Appmodel
      final Singleton appModel = JavaPatterns.newSingleton(appModelName, swingPackage)
            .addFields(stringType, "title", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "title", appModelName))
            .addFields(awtDimensionType, "appSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "appSize", appModelName))
            .addFields(awtDimensionType, "navigatorSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "navigatorSize", appModelName))
            .addFields(awtDimensionType, "workspaceSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "workspaceSize", appModelName))
            .addFields(stringType, "rootDir", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "rootDir", appModelName))
            .addFields(stringType, "outputPackage", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "outputPackage", appModelName))
            .addFields(stringType, "outputPath", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "outputPath", appModelName))
            .addFields(stringType, "stDelimiter", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "stDelimiter", appModelName))
            .addFields(integerType, "editorFontSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(integerType, "editorFontSize", appModelName))
            .addFields(jFrameType, "frame", null)
            .addAccessors(JavaPatterns.newReferenceAccessors(jFrameType, "frame", appModelName))
            .addFields(typesMap.get(domainFacadeName), "domain", null)
            .addAccessors(JavaPatterns.newReferenceAccessors(typesMap.get(domainFacadeName), "domain", appModelName));
      typesMap.put(appModelName, newClassOrInterfaceType(swingPackage, appModelName));

      navigator
            .setConstructorStatements(new Object[]{
                  "final NavigatorRootNode rootNode = new NavigatorRootNode(\"Navigator\");",
                  "final NavigatorTreeModel treeModel = new NavigatorTreeModel(rootNode);",
                  "final NavigatorTree tree = new NavigatorTree(treeModel);",
                  "final JScrollPane scrollPane = new JScrollPane(tree);",
                  "add(scrollPane, BorderLayout.CENTER);",
                  "setPreferredSize(nextgen.swing.AppModel.getInstance().getNavigatorSize());"
            });


      tabbedPane
            .addImports(newImportDeclaration(editorsPackage, editor.getName().toString()))
            .addMethods(JavaPatterns.newPublicMethodDeclaration("getEditor")
                  .setType("Optional<Editor<?>>")
                  .addTypeParameters("T")
                  .addParameters(newParameter("T", "model"))
                  .setBlockStmt(newBlockStmt(new Object[]{
                        "return find(component -> component instanceof Editor<?> && ((Editor<?>)component).getModel().equals(model));"
                  })));

      workspace
            .addImports(newImportDeclaration(swingPackage, appModelName))
            .addImports(newImportDeclaration(editorsPackage))
            .addFields(tabbedPane.getName(), "tab", "new TabPanel()")
            .setConstructorStatements(new Object[]{
                  "add(tab, BorderLayout.CENTER);",
                  "setPreferredSize(nextgen.swing.AppModel.getInstance().getWorkspaceSize());",
                  GreenRobotPatterns.newRegister()
            });

      final ButtonTab buttonTab = JavaSwingPatterns.newButtonTab()
            .setPackageName(workspacePackage.getName())
            .setName(buttonTabName);
      typesMap.put(buttonTabName, newClassOrInterfaceType(buttonTab.getPackageName(), buttonTab.getName()));


      final SwingUtil swingUtil = JavaSwingPatterns.newSwingUtil()
            .setPackageName(swingPackage.getName())
            .setName(swingUtilName);
      typesMap.put(swingUtilName, newClassOrInterfaceType(swingUtil.getPackageName(), swingUtil.getName()));

      final TreeModel treeModel = JavaSwingPatterns.newTreeModel();


      entityTreeNodeMap.get(work)
            .addActions(newAction(newEntityAction("RunWork")
                  .setTitle("Run")
                  .addFields(typesMap.get(work), "work")
                  .setStatements(new Object[]{
                        "final org.jeasy.flows.workflow.WorkFlow workflow = org.jeasy.flows.workflow.SequentialFlow.Builder",
                        "		.aNewSequentialFlow()",
                        "		.execute(appModel.getDomain().newInstance(work))",
                        "		.build();",
                        "",
                        "final org.jeasy.flows.work.WorkContext workContext = new org.jeasy.flows.work.WorkContext();",
                        "final org.jeasy.flows.engine.WorkFlowEngine workFlowEngine = org.jeasy.flows.engine.WorkFlowEngineBuilder.aNewWorkFlowEngine()",
                        "		.build();",
                        "final org.jeasy.flows.work.WorkReport workReport = workFlowEngine.run(workflow, workContext);",
                        "",
                        "final org.jeasy.flows.work.WorkContext reportWorkContext = workReport.getWorkContext();",
                  }))
                  .addArguments("getModel()"));

      final STTemplateEditor stTemplateEditor = NextgenPatterns.newSTTemplateEditor()
            .setPackageName(editorsPackage.getName())
            .setName(stTemplateTextEditorName);

      addEditors(work, sequentialFlow, stTemplate);

      final Canvas projectCanvas = NextgenPatterns.newCanvas()
            .setPackageName(canvasPackage.getName())
            .setName(projectCanvasName)
            .addFields(typesMap.get(project), lowFirst(project.getName()))
            .addCanvasNodes(newCanvasNode(work))
            .addCanvasNodes(newCanvasNode(sequentialFlow))
            .addCanvasNodes(newCanvasNode(conditionalFlow))
            .addCanvasNodes(newCanvasNode(parallelFlow))
            .addCanvasNodes(newCanvasNode(repeatFlow));
      typesMap.put(projectCanvasName, newClassOrInterfaceType(projectCanvas.getPackageName(), projectCanvas.getName()));

      final Event newSTChildTemplateEvent = GreenRobotPatterns
            .newStaticEvent("NewChildTemplate")
            .addFields(typesMap.get(stTemplate), "model");
      eventManager.addEvents(newSTChildTemplateEvent, newPostEventMethod(newSTChildTemplateEvent));

      // Config
      final Entity config = newEntity("AppConfig")
            .addRelations(newStringField("title"))
            .addRelations(newIntegerField("appWidth"))
            .addRelations(newIntegerField("appHeight"))
            .addRelations(newIntegerField("navigatorWidth"))
            .addRelations(newIntegerField("navigatorHeight"))
            .addRelations(newIntegerField("workspaceWidth"))
            .addRelations(newIntegerField("workspaceHeight"))
            .addRelations(newIntegerField("editorWidth"))
            .addRelations(newIntegerField("editorHeight"))
            .addRelations(newStringField("rootDir"))
            .addRelations(newStringField("dbDir"))
            .addRelations(newStringField("outputPackage"))
            .addRelations(newStringField("outputPath"))
            .addRelations(newIntegerField("editorFontSize"));
      typesMap.put(config, newClassOrInterfaceType(swingConfigPackage, config.getName()));

      final TransactionAction transactionAction = JavaSwingPatterns.newTransactionAction()
            .setPackageName(actionsPackage.getName())
            .setName(transactionActionName)
            .setAppModelType(typesMap.get(appModelName));
      typesMap.put(config, newClassOrInterfaceType(transactionAction.getPackageName(), transactionAction.getName()));

      treeModel
            .setPackageName(navigationPackage.getName())
            .setName(navigationTreeModelName)
            .addImports(newImportDeclaration(domainPackage))
            .setNodeType(baseTreeNode.getName())
            .addConstructorStatements(GreenRobotPatterns.newRegister())
            .addMethods(newSubscribe(stGroupModel, NEW)
                  .setStatements(new Object[]{
                        "find(TemplatesTreeNode.class)",
                        "		.ifPresent(navigatorTreeNode -> addNodeInSortedOrder(navigatorTreeNode, new STGroupModelTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(stTemplate, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingTemplatesSTGroupModel()",
                        "		.findFirst()",
                        "		.flatMap(stGroupModel -> find(STGroupModelTreeNode.class, navigatorTreeNode -> navigatorTreeNode.getModel()",
                        "				.equals(stGroupModel)))",
                        "		.ifPresent(stGroupModelTreeNode -> addNodeInSortedOrder(stGroupModelTreeNode, new STTemplateTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(newSTChildTemplateEvent)
                  .setStatements(new Object[]{
                        "event.model.getIncomingChildrenSTTemplate()",
                        "		.findFirst()",
                        "		.flatMap(stTemplate -> find(STTemplateTreeNode.class, navigatorTreeNode -> navigatorTreeNode.getModel()",
                        "				.equals(stTemplate)))",
                        "		.ifPresent(stTemplateTreeNode -> addNodeInSortedOrder(stTemplateTreeNode, new STTemplateTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(project, NEW)
                  .setStatements(new Object[]{
                        "find(ProjectsTreeNode.class)",
                        "		.ifPresent(navigatorTreeNode -> addNodeInSortedOrder(navigatorTreeNode, new ProjectTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(work, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingWorkProject()",
                        "		.findFirst()",
                        "		.flatMap(project -> find(ProjectTreeNode.class, projectTreeNode -> projectTreeNode.getModel()",
                        "				.equals(project)))",
                        "		.ifPresent(projectTreeNode -> addNodeInSortedOrder(projectTreeNode, new WorkTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(sequentialFlow, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingSequentialWorkInstance()",
                        "		.findFirst()",
                        "		.flatMap(workInstance -> workInstance.getIncomingFlowsProject()",
                        "				.findFirst()",
                        "				.flatMap(project -> find(ProjectTreeNode.class, projectTreeNode -> projectTreeNode.getModel()",
                        "						.equals(project))))",
                        "		.ifPresent(projectTreeNode -> addNodeInSortedOrder(projectTreeNode, new SequentialFlowTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(conditionalFlow, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingConditionalWorkInstance()",
                        "		.findFirst()",
                        "		.flatMap(workInstance -> workInstance.getIncomingFlowsProject()",
                        "				.findFirst()",
                        "				.flatMap(project -> find(ProjectTreeNode.class, projectTreeNode -> projectTreeNode.getModel()",
                        "						.equals(project))))",
                        "		.ifPresent(projectTreeNode -> addNodeInSortedOrder(projectTreeNode, new ConditionalFlowTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(parallelFlow, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingParallelWorkInstance()",
                        "		.findFirst()",
                        "		.flatMap(workInstance -> workInstance.getIncomingFlowsProject()",
                        "				.findFirst()",
                        "				.flatMap(project -> find(ProjectTreeNode.class, projectTreeNode -> projectTreeNode.getModel()",
                        "						.equals(project))))",
                        "		.ifPresent(projectTreeNode -> addNodeInSortedOrder(projectTreeNode, new ParallelFlowTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(repeatFlow, NEW)
                  .setStatements(new Object[]{
                        "event.model.getIncomingRepeatWorkInstance()",
                        "		.findFirst()",
                        "		.flatMap(workInstance -> workInstance.getIncomingFlowsProject()",
                        "				.findFirst()",
                        "				.flatMap(project -> find(ProjectTreeNode.class, projectTreeNode -> projectTreeNode.getModel()",
                        "						.equals(project))))",
                        "		.ifPresent(projectTreeNode -> addNodeInSortedOrder(projectTreeNode, new RepeatFlowTreeNode(event.model)));"
                  }))
            .addMethods(newSubscribe(stGroupModel, DELETE)
                  .setStatements(new Object[]{
                        "find(STGroupModelTreeNode.class, navigatorTreeNode -> (navigatorTreeNode.getUuid().equals(event.model)))",
                        "		.ifPresent(this::removeNodeFromParent);"
                  }))
            .addMethods(newSubscribe(stTemplate, DELETE)
                  .setStatements(new Object[]{
                        "find(STTemplateTreeNode.class, navigatorTreeNode -> (navigatorTreeNode.getUuid().equals(event.model)))",
                        "		.ifPresent(this::removeNodeFromParent);"
                  }))
            .addMethods(newSubscribe(project, DELETE)
                  .setStatements(new Object[]{
                        "find(ProjectTreeNode.class, navigatorTreeNode -> (navigatorTreeNode.getUuid().equals(event.model)))",
                        "		.ifPresent(this::removeNodeFromParent);"
                  }));

      final JTree treeNavigator = JavaSwingPatterns.newJTree()
            .setPackageName(navigationPackage.getName())
            .setName(navigatorTreeName)
            .setNodeType(baseTreeNode.getName())
            .setTreeModel(treeModel.getName());
      typesMap.put(navigatorTreeName, newClassOrInterfaceType(treeNavigator.getPackageName(), treeNavigator.getName()));

      final TreeNode navigatorRootNode = newTreeNode(navigationPackage, baseTreeNode, navigatorRootNodeName)
            .setType(stringType)
            .addConstructorStatements("setLabel(model);")
            .addConstructorStatements("add(new TemplatesTreeNode(\"Templates\"));")
            .addConstructorStatements("add(new ProjectsTreeNode(\"Projects\"));");

      final TreeNode templatesRootNode = newTreeNode(navigationPackage, baseTreeNode, templatesRootNodeName)
            .setType(stringType)
            .addConstructorStatements("setLabel(model);")
            .addConstructorStatements(typesMap.get(appModelName) + ".getInstance().getDomain().getAllSTGroups().forEach(stGroup -> add(new STGroupModelTreeNode(stGroup)));")
            .addActions(newAction(newEntityAction("NewSTGroup")
                  .setTitle("New STGroup")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	if (appModel.getDomain().findAllSTGroupModelByName(name).findAny().isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewSTGroupModel(appModel.getDomain()",
                        "			.newSTGroupModel(name, appModel.getStDelimiter()));",
                        "}"
                  })));

      entityTreeNodeMap.get(stGroupModel)
            .addConstructorStatements(typesMap.get(domainFacadeName) + ".getTemplates(model).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
            .addActions(newAction(newEntityAction("NewSTTemplate")
                  .addFields(typesMap.get(stGroupModel), "stGroup")
                  .setTitle("New Template")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	if (nextgen.DomainFacade.aggregateTemplates(stGroup)",
                        "			.stream()",
                        "			.anyMatch(stTemplate -> stTemplate.getName().equalsIgnoreCase(name))) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewSTTemplate(appModel.getDomain().newSTTemplate(name, stGroup));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("DeleteSTGroup")
                  .addFields(typesMap.get(stGroupModel), "stGroup")
                  .setTitle("Delete")
                  .setStatements(new Object[]{
                        "final boolean confirm = SwingUtil.showConfirmDialog(appModel.getFrame(), \"Delete \" + stGroup.getName());",
                        "if (!confirm) return;",
                        "",
                        "final java.util.List<STTemplate> stTemplates = nextgen.DomainFacade.aggregateTemplates(stGroup);",
                        "",
                        "for (STTemplate stTemplate : stTemplates) {",
                        "	if (stTemplate.getIncomingTemplateSTModel().findFirst().isPresent()) {",
                        "		SwingUtil.showMessage(\"There are models dependent on \" + stTemplate.getName() + \".\\nCannot delete group.\", appModel",
                        "				.getFrame());",
                        "		return;",
                        "	}",
                        "}",
                        "",
                        "for (STTemplate stTemplate : stTemplates) {",
                        "	stTemplate.getParameters().forEach(STParameter::delete);",
                        "	stTemplate.delete();",
                        "}",
                        "",
                        "final String uuid = stGroup.getUuid();",
                        "stGroup.delete();",
                        "nextgen.events.DomainEvents.postDeletedSTGroupModel(uuid);"
                  }))
                  .addArguments("getModel()"));

      entityTreeNodeMap.get(stTemplate)
            .addImports(newImportDeclaration(nextgenPackage, "DomainFacade"))
            .addConstructorStatements(typesMap.get(domainFacadeName) + ".getTemplates(model).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
            .addActions(newAction(newEntityAction("NewChildTemplate")
                  .addFields(typesMap.get(stTemplate), "stTemplate")
                  .setTitle("New Child Template")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "	if (nextgen.DomainFacade.aggregateTemplates(stTemplate.getIncomingTemplatesSTGroupModel())",
                        "			.stream()",
                        "			.anyMatch(stTemplate -> stTemplate.getName().equalsIgnoreCase(name))) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewChildTemplate(appModel.getDomain().newSTTemplate(name, stTemplate));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("DeleteSTTemplate")
                  .setTitle("Delete")
                  .addFields(typesMap.get(stTemplate), "stTemplate")
                  .setStatements(new Object[]{
                        "final boolean confirm = SwingUtil.showConfirmDialog(appModel.getFrame(), \"Delete \" + stTemplate.getName());",
                        "if (!confirm) return;",
                        "",
                        "if (stTemplate.getIncomingTemplateSTModel().findFirst().isPresent()) {",
                        "	SwingUtil.showMessage(\"There are models dependent on \" + stTemplate.getName() + \".\\nCannot delete template.\", appModel",
                        "			.getFrame());",
                        "	return;",
                        "}",
                        "",
                        "final String uuid = stTemplate.getUuid();",
                        "stTemplate.getParameters().forEach(STParameter::delete);",
                        "stTemplate.delete();",
                        "nextgen.events.DomainEvents.postDeletedSTTemplate(uuid);"
                  }))
                  .addArguments("getModel()"));


      final TreeNode projectsRootNode = newTreeNode(navigationPackage, baseTreeNode, projectsRootNodeName)
            .setType(stringType)
            .addConstructorStatements("setLabel(\"Projects\");")
            .addConstructorStatements(typesMap.get(appModelName) + ".getInstance().getDomain().getAllProjects().forEach(project -> add(new ProjectTreeNode(project)));")
            .addActions(newAction(newEntityAction("NewProject")
                  .setTitle("New Project")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	if (appModel.getDomain().findAllProjectByName(name).findAny().isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewProject(appModel.getDomain()",
                        "			.newProject().setName(name));",
                        "}"
                  })));

      entityTreeNodeMap.get(project)
            .setConstructorStatements(new Object[]{
                  "model.getModels().forEach(stModel -> add(new STModelTreeNode(stModel)));",
                  "model.getWork().forEach(work -> add(new WorkTreeNode(work)));",
                  "",
                  "model.getFlows().forEach(workInstance -> {",
                  "	switch (workInstance.getType()) {",
                  "		case CONDITIONAL:",
                  "			add(new ConditionalFlowTreeNode(workInstance.getConditional()));",
                  "			break;",
                  "		case SEQUENTIAL:",
                  "			add(new SequentialFlowTreeNode(workInstance.getSequential()));",
                  "			break;",
                  "		case PARALLEL:",
                  "			add(new ParallelFlowTreeNode(workInstance.getParallel()));",
                  "			break;",
                  "		case REPEAT:",
                  "			add(new RepeatFlowTreeNode(workInstance.getRepeat()));",
                  "			break;",
                  "	}",
                  "});"
            })
            .addActions(newAction(newEntityAction("NewSTModel")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New STModel")
                  .setStatements(new Object[]{
                        "SwingUtil.showDialog(new SelectPanel(), appModel.getFrame(), \"New STModel\", new SwingUtil.ConfirmAction() {",
                        "	@Override",
                        "	public void verifyAndCommit() throws Exception {",
                        "",
                        "	}",
                        "});"
                  })
                  .addMembers(JavaSwingPatterns.newJPanel("SelectPanel")
                        .setInnerClass(true)))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("NewWork")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New Work")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	final java.util.Optional<Work> existing = project.getWork()",
                        "			.filter(work -> work.getName().equalsIgnoreCase(name))",
                        "			.findFirst();",
                        "",
                        "	if (existing.isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewWork(appModel.getDomain().newWork(name, project));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("NewSequentialWorkFlow")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New Sequential Flow")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	final java.util.Optional<SequentialFlow> existing = project.getFlows()",
                        "			.filter(workInstance -> workInstance.getType().equals(WorkType.SEQUENTIAL))",
                        "			.map(WorkInstance::getSequential)",
                        "			.filter(flow -> flow.getName().equalsIgnoreCase(name))",
                        "			.findFirst();",
                        "",
                        "	if (existing.isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewSequentialFlow(appModel.getDomain().newSequentialFlow(name, project));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("NewConditionalWorkFlow")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New Conditional Flow")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	final java.util.Optional<ConditionalFlow> existing = project.getFlows()",
                        "			.filter(workInstance -> workInstance.getType().equals(WorkType.CONDITIONAL))",
                        "			.map(WorkInstance::getConditional)",
                        "			.filter(flow -> flow.getName().equalsIgnoreCase(name))",
                        "			.findFirst();",
                        "",
                        "	if (existing.isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewConditionalFlow(appModel.getDomain().newConditionalFlow(name, project));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("NewParallelWorkFlow")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New Parallel Flow")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	final java.util.Optional<ParallelFlow> existing = project.getFlows()",
                        "			.filter(workInstance -> workInstance.getType().equals(WorkType.PARALLEL))",
                        "			.map(WorkInstance::getParallel)",
                        "			.filter(flow -> flow.getName().equalsIgnoreCase(name))",
                        "			.findFirst();",
                        "",
                        "	if (existing.isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewParallelFlow(appModel.getDomain().newParallelFlow(name, project));",
                        "}"
                  }))
                  .addArguments("getModel()"))
            .addActions(newAction(newEntityAction("NewRepeatWorkFlow")
                  .addFields(typesMap.get(project), "project")
                  .setTitle("New Repeat Flow")
                  .setStatements(new Object[]{
                        "final String name = SwingUtil.showInputDialog(\"Name\", appModel.getFrame());",
                        "if (name != null && name.length() != 0) {",
                        "",
                        "	final java.util.Optional<RepeatFlow> existing = project.getFlows()",
                        "			.filter(workInstance -> workInstance.getType().equals(WorkType.REPEAT))",
                        "			.map(WorkInstance::getRepeat)",
                        "			.filter(flow -> flow.getName().equalsIgnoreCase(name))",
                        "			.findFirst();",
                        "",
                        "	if (existing.isPresent()) {",
                        "		SwingUtil.showMessage(name + \" is already in use\", appModel.getFrame());",
                        "		return;",
                        "	}",
                        "",
                        "	nextgen.events.DomainEvents.postNewRepeatFlow(appModel.getDomain().newRepeatFlow(name, project));",
                        "}"
                  }))
                  .addArguments("getModel()"));


      final App app = JavaSwingPatterns.newApp()
            .setPackageName(swingPackage.getName())
            .setName("STApp");

      writeJsonWrapper(mainJava, swingConfigPackage, newDomain("AppConfig").addEntities(config));
      writeNeo(mainJava, domainPackage, domain, true);
      writePojo(mainJava, stParserPackage, parserDomain);

      writeJavaFile(domainFacade, nextgenPackage, domainFacade.getName(), mainJava);
      writeJavaFile(appModel, swingPackage, appModelName, mainJava);
      writeJavaFile(swingUtil, swingPackage, swingUtil.getName(), mainJava);
      writeJavaFile(app, swingPackage, app.getName(), mainJava);
      writeJavaFile(eventManager, eventsPackage, eventManager.getName(), mainJava);
      writeJavaFile(projectCanvas, canvasPackage, projectCanvas.getName(), mainJava);
      writeJavaFile(navigator, navigationPackage, navigator.getName().toString(), mainJava);
      writeJavaFile(treeModel, navigationPackage, treeModel.getName().toString(), mainJava);
      writeJavaFile(treeNavigator, navigationPackage, treeNavigator.getName().toString(), mainJava);
      writeJavaFile(baseTreeNode, navigationPackage, baseTreeNode.getName().toString(), mainJava);
      writeJavaFile(navigatorRootNode, navigationPackage, navigatorRootNode.getName().toString(), mainJava);
      writeJavaFile(templatesRootNode, navigationPackage, templatesRootNode.getName().toString(), mainJava);
      writeJavaFile(projectsRootNode, navigationPackage, projectsRootNode.getName().toString(), mainJava);
      writeJavaFile(transactionAction, actionsPackage, transactionAction.getName().toString(), mainJava);
      writeJavaFile(editor, editorsPackage, editor.getName(), mainJava);
      writeJavaFile(stTemplateEditor, editorsPackage, stTemplateEditor.getName(), mainJava);
      writeJavaFile(workspace, workspacePackage, workspace.getName().toString(), mainJava);
      writeJavaFile(tabbedPane, workspacePackage, tabbedPane.getName().toString(), mainJava);
      writeJavaFile(buttonTab, workspacePackage, buttonTab.getName().toString(), mainJava);

      entityTreeNodeMap.values()
            .forEach(treeNode -> writeJavaFile(treeNode, navigationPackage, treeNode.getName().toString(), mainJava));

      for (EntityAction entityAction : entityActions)
         writeJavaFile(entityAction, actionsPackage, entityAction.getName().toString(), mainJava);

      entityEditorMap.values()
            .forEach(modelEditor -> writeJavaFile(modelEditor, editorsPackage, modelEditor.getName()
                  .toString(), mainJava));

      writeJavaFile(stParserClass, stParserPackage, "STParser", mainJava);
   }

   public void addEditors(Entity work, Entity sequentialFlow, Entity stTemplate) {

      entityEditorMap.get(work)
            .setStatements(new Object[]{
                  "final JTextField txtName = SwingUtil.newTextField();",
                  "final RSyntaxTextArea txtInputs = SwingUtil.newRSyntaxTextArea(10, 80);",
                  "final RSyntaxTextArea txtStatements = SwingUtil.newRSyntaxTextArea(30, 80);",
                  "",
                  "txtName.setText(model.getName());",
                  "model.getInputs().forEach(workInput -> {",
                  "	txtInputs.append(workInput.getType() + \" \" + workInput.getName());",
                  "	txtInputs.append(\"\\n\");",
                  "});",
                  "",
                  "model.getStatements().forEach(workStatement -> {",
                  "	txtStatements.append(workStatement.getStatement());",
                  "	txtStatements.append(\"\\n\");",
                  "});",
                  "",
                  "final JPanel centerPanel = new JPanel(new BorderLayout());",
                  "centerPanel.add(SwingUtil.newRTextScrollPane(txtInputs), BorderLayout.NORTH);",
                  "centerPanel.add(SwingUtil.newRTextScrollPane(txtStatements), BorderLayout.CENTER);",
                  "add(txtName, BorderLayout.NORTH);",
                  "add(centerPanel, BorderLayout.CENTER);",
                  "",
                  "txtName.addActionListener(actionEvent ->",
                  "		getDomain().doInTransaction(transaction -> {",
                  "			model.setName(txtName.getText().trim());",
                  "			nextgen.events.DomainEvents.postUpdatedWork(model);",
                  "		}));",
                  "",
                  "txtInputs.addKeyListener(new InputsKeyListener(txtInputs));",
                  "txtStatements.addKeyListener(new StatementsKeyListener(txtStatements));"
            })
            .addInnerClasses("   private class InputsKeyListener extends KeyAdapter {\n" +
                  "\n" +
                  "      private final RSyntaxTextArea textArea;\n" +
                  "\n" +
                  "      public InputsKeyListener(RSyntaxTextArea textArea) {\n" +
                  "         this.textArea = textArea;\n" +
                  "      }\n" +
                  "\n" +
                  "      @Override\n" +
                  "      public void keyPressed(KeyEvent keyEvent) {\n" +
                  "         if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {\n" +
                  "            commitInputs();\n" +
                  "         }\n" +
                  "      }\n" +
                  "\n" +
                  "      private void commitInputs() {\n" +
                  "         getDomain().doInTransaction(transaction -> {\n" +
                  "\n" +
                  "            model.getInputs().forEach(nextgen.domain.WorkInput::delete);\n" +
                  "\n" +
                  "            final String trim = textArea.getText().trim();\n" +
                  "            for (String s : trim.split(\"\\n\")) {\n" +
                  "               if (s.trim().length() == 0) continue;\n" +
                  "               final int space = s.indexOf(\" \");\n" +
                  "               final String type = s.substring(0, space);\n" +
                  "               final String name = s.substring(space + 1);\n" +
                  "               model.addInputs(getDomain().newWorkInput()\n" +
                  "                     .setType(type)\n" +
                  "                     .setName(name));\n" +
                  "            }\n" +
                  "         });\n" +
                  "      }\n" +
                  "   }")
            .addInnerClasses("   private class StatementsKeyListener extends KeyAdapter {\n" +
                  "\n" +
                  "      private final RSyntaxTextArea textArea;\n" +
                  "\n" +
                  "      public StatementsKeyListener(RSyntaxTextArea textArea) {\n" +
                  "         this.textArea = textArea;\n" +
                  "      }\n" +
                  "\n" +
                  "      @Override\n" +
                  "      public void keyPressed(KeyEvent keyEvent) {\n" +
                  "         if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {\n" +
                  "            commitStatements();\n" +
                  "         }\n" +
                  "      }\n" +
                  "\n" +
                  "      private void commitStatements() {\n" +
                  "         getDomain().doInTransaction(transaction -> {\n" +
                  "\n" +
                  "            model.getStatements().forEach(nextgen.domain.WorkStatement::delete);\n" +
                  "\n" +
                  "            final String trim = textArea.getText().trim();\n" +
                  "            for (String s : trim.split(\"\\n\")) {\n" +
                  "               if (s.trim().length() == 0) continue;\n" +
                  "               model.addStatements(getDomain().newWorkStatement()\n" +
                  "                     .setStatement(s.trim()));\n" +
                  "            }\n" +
                  "         });\n" +
                  "      }\n" +
                  "   }");

      entityEditorMap.get(sequentialFlow)
            .setStatements(new Object[]{
                  "final JTextField txtName = SwingUtil.newTextField();",
                  "txtName.setText(model.getName());",
                  "",
                  "add(txtName, BorderLayout.NORTH);",
                  "txtName.addActionListener(actionEvent ->",
                  "		getDomain().doInTransaction(transaction -> {",
                  "			model.setName(txtName.getText().trim());",
                  "			nextgen.events.DomainEvents.postUpdatedSequentialFlow(model);",
                  "		}));"
            });

      entityEditorMap.get(stTemplate)
            .addStatements("add(new STTemplateTextEditor(model), BorderLayout.CENTER);");


   }

   private TreeNode newTreeNode(PackageDeclaration packageDeclaration, BaseTreeNode baseTreeNode, String name) {
      final TreeNode treeNode = JavaSwingPatterns.newTreeNode(packageDeclaration, baseTreeNode)
            .setName(name);
      typesMap.put(name, newClassOrInterfaceType(navigationPackage, treeNode.getName()));
      return treeNode;
   }

   private Subscribe newSubscribe(Entity entity, EntityEventTypes eventType) {
      return GreenRobotPatterns.newSubscribe(entityEventMap.get(entity).get(eventType), typesMap.get(eventManagerName));
   }

   private Subscribe newSubscribe(Event event) {
      return GreenRobotPatterns.newSubscribe(event, typesMap.get(eventManagerName));
   }

   public CanvasNode newCanvasNode(Entity entity) {
      return NextgenPatterns.newCanvasNode()
            .setName(entity.getName() + "Node")
            .setModelType(typesMap.get(entity));
   }

   private ModelEditor newModelEditor(PackageDeclaration packageDeclaration, Entity entity) {
      return JavaSwingPatterns.newModelEditor()
            .setPackageName(packageDeclaration.getName())
            .setName(entity.getName() + "Editor")
            .setModelType(newClassOrInterfaceType(domainPackage, entity.getName()));
   }

   private GetTreeNodeAction newAction(EntityAction entityAction) {
      return newGetTreeNodeAction()
            .setName(entityAction.getPackageName() + "." + entityAction.getName());
   }

   private EntityAction newEntityAction(String name) {
      final EntityAction entityAction = JavaSwingPatterns.newEntityAction(actionsPackage, name + "Action", typesMap.get(appModelName)
            .toString())
            .addImports(newImportDeclaration(domainPackage));
      entityActions.add(entityAction);
      return entityAction;
   }

   @org.junit.Test
   public void generateProjectFiles() {

      GitPatterns.write(root, GitPatterns.newGitignore()
            .addExcludeDirs(".idea")
            .addExcludeDirs("target")
            .addExcludeDirs("db")
            .addExcludeFiles("*.class")
            .addExcludeFiles("*.jar")
            .addExcludeFiles("hs_err_pid*")
            .addExcludeFiles("*.iml")
            .addExcludeFiles(".idea")
            .addExcludeFiles(".vertx")
            .addExcludeFiles("*.log*")
      );

      Pom projectPom = MavenST.newPom()
            .setGroupId("nextgen")
            .setVersion("1.0")
            .setName("Nextgen")
            .setArtifactId("nextgen")
            .addProperties(MavenPatterns.newMavenCompilerSource().setValue("9"))
            .addProperties(MavenPatterns.newMavenCompilerTarget().setValue("9"))
            .addProperties(MavenPatterns.setProjectBuildSourceEncoding("UTF-8"))
            .addProperties(MavenPatterns.setProjectReportingOutputEncoding("UTF-8"))
            .addProperties(MavenPatterns.newPomProperties("antlr.version", "4.7"))
            .addProperties(MavenPatterns.newPomProperties("vertx.version", "3.8.3"))
            .addProperties(MavenPatterns.newPomProperties("junit.version", "4.12"))
            .addProperties(MavenPatterns.newPomProperties("piccolo2d.version", "3.0"))
            .addProperties(MavenPatterns.newPomProperties("jgoodies.version", "1.9.0"))
            .addProperties(MavenPatterns.newPomProperties("greenrobot.version", "3.2.0"))
            .addProperties(MavenPatterns.newPomProperties("neo4j.version", "3.4.0"))
            .addDependencies(newDependency()
                  .setArtifactId("slf4j-log4j12")
                  .setGroupId("org.slf4j")
                  .setVersion("1.7.20"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.greenrobot")
                  .setArtifactId("eventbus")
                  .setVersion("${greenrobot.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.fifesoft")
                  .setArtifactId("rsyntaxtextarea")
                  .setVersion("3.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("net.openhft")
                  .setArtifactId("compiler")
                  .setVersion("2.3.1"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.formdev")
                  .setArtifactId("flatlaf")
                  .setVersion("0.40"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.antlr")
                  .setArtifactId("antlr4")
                  .setVersion("${antlr.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.jgoodies")
                  .setArtifactId("jgoodies-forms")
                  .setVersion("${jgoodies.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-core")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-extras")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.abego.treelayout")
                  .setArtifactId("org.abego.treelayout.core")
                  .setVersion("1.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("io.vertx")
                  .setArtifactId("vertx-core")
                  .setVersion("${vertx.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.jeasy")
                  .setArtifactId("easy-flows")
                  .setVersion("0.2"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.neo4j")
                  .setArtifactId("neo4j")
                  .setVersion("${neo4j.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("junit")
                  .setArtifactId("junit")
                  .setVersion("${junit.version}"));

      MavenPatterns.generate(MavenPatterns.newProject()
            .setName("Nextgen")
            .setRoot(root.getAbsolutePath()), projectPom);

      writeToFile(Log4JPatterns.newProperties()
            .setLogLevel("INFO")
            .setRootAppender("stdout")
            .addAppenders(Log4JPatterns.newConsoleAppender()
                  .setName("stdout")
                  .setThreshold("INFO")), "", "log4j", "properties", mainResources);
   }

   private PackageDeclaration getPackageDeclaration(PackageDeclaration parent, String packageName) {
      return JavaPatterns.newPackageDeclaration(parent, packageName.toLowerCase());
   }

   private static final String stParserClass = "package nextgen.stparser;\n" +
         "\n" +
         "import org.antlr.runtime.tree.Tree;\n" +
         "import org.stringtemplate.v4.ST;\n" +
         "import org.stringtemplate.v4.STErrorListener;\n" +
         "import org.stringtemplate.v4.STGroup;\n" +
         "import org.stringtemplate.v4.STGroupString;\n" +
         "import org.stringtemplate.v4.misc.STCompiletimeMessage;\n" +
         "import org.stringtemplate.v4.misc.STMessage;\n" +
         "\n" +
         "import java.util.*;\n" +
         "\n" +
         "public class STParser {\n" +
         "\n" +
         "   public static STGParseResult parseTemplate(String text) {\n" +
         "      final STGParseResult parseResult = new STGParseResult();\n" +
         "\n" +
         "      final STGroup templateGroup = newTemplateGroup();\n" +
         "      final STGroupString stGroup = new STGroupString(\"tmp\", templateGroup.getInstanceOf(\"STGroupTemplate\")\n" +
         "            .add(\"delimiter\", '~')\n" +
         "            .add(\"templates\", templateGroup.getInstanceOf(\"STTemplate\")\n" +
         "                  .add(\"name\", \"tmp\")\n" +
         "                  .add(\"content\", text)).render(), '~', '~');\n" +
         "\n" +
         "      stGroup.setListener(new STErrorListener() {\n" +
         "         @Override\n" +
         "         public void compileTimeError(STMessage stMessage) {\n" +
         "\n" +
         "            final STGError stgError = new STGError()\n" +
         "                  .setType(STGErrorType.COMPILE)\n" +
         "                  .setMessage(stMessage.toString());\n" +
         "\n" +
         "            if (stMessage instanceof STCompiletimeMessage) {\n" +
         "               final STCompiletimeMessage message = (STCompiletimeMessage) stMessage;\n" +
         "               parseResult.addErrors(stgError\n" +
         "                     .setLine(message.token.getLine())\n" +
         "                     .setCharPosition(message.token.getCharPositionInLine()));\n" +
         "            }\n" +
         "\n" +
         "            parseResult.addErrors(stgError);\n" +
         "         }\n" +
         "\n" +
         "         @Override\n" +
         "         public void runTimeError(STMessage stMessage) {\n" +
         "            parseResult.addErrors(new STGError().setType(STGErrorType.RUNTIME));\n" +
         "         }\n" +
         "\n" +
         "         @Override\n" +
         "         public void IOError(STMessage stMessage) {\n" +
         "            parseResult.addErrors(new STGError().setType(STGErrorType.IO));\n" +
         "         }\n" +
         "\n" +
         "         @Override\n" +
         "         public void internalError(STMessage stMessage) {\n" +
         "            parseResult.addErrors(new STGError().setType(STGErrorType.INTERNAL));\n" +
         "         }\n" +
         "      });\n" +
         "\n" +
         "      if (parseResult.getErrors().isEmpty()) {\n" +
         "\n" +
         "         final ParsedSTGroup parsedSTGroup = new ParsedSTGroup();\n" +
         "         parsedSTGroup.setName(\"Tmp\");\n" +
         "         parsedSTGroup.setDelimiter(\"~\");\n" +
         "\n" +
         "         stGroup.getTemplateNames()\n" +
         "               .stream()\n" +
         "               .map(stGroup::getInstanceOf)\n" +
         "               .filter(stTemplate -> !(stTemplate.getName().equals(\"/eom\") || stTemplate.getName().equals(\"/gt\")))\n" +
         "               .filter(st -> !st.isAnonSubtemplate())\n" +
         "               .filter(st -> st.impl.ast != null)\n" +
         "               .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
         "               .forEach(st -> {\n" +
         "\n" +
         "                  final TemplateVisitor visitor = new TemplateVisitor();\n" +
         "                  visitor.visit(st);\n" +
         "\n" +
         "                  final ParsedSTTemplate stTemplate = new ParsedSTTemplate()\n" +
         "                        .setName(st.getName().substring(1))\n" +
         "                        .setText(st.impl.template);\n" +
         "\n" +
         "                  final Map<String, ParsedParameter> stParameterMap = new LinkedHashMap<>();\n" +
         "                  visitor.astNodeStack.peek()\n" +
         "                        .getChildren()\n" +
         "                        .forEach(astNode -> addParameters(stParameterMap, astNode, new Stack<>()));\n" +
         "                  stParameterMap.values().forEach(stTemplate::addParameters);\n" +
         "\n" +
         "                  parsedSTGroup.addTemplates(stTemplate);\n" +
         "               });\n" +
         "\n         parseResult.setParsed(parsedSTGroup);" +
         "\n" +
         "      }\n" +
         "\n" +
         "      return parseResult;\n" +
         "   }\n" +
         "\n" +
         "   private static STGroup newTemplateGroup() {\n" +
         "\n" +
         "      final String stg = \"delimiters \\\"~\\\", \\\"~\\\"\" +\n" +
         "            \"\\n\\ngt() ::= \\\">\\\"\" +\n" +
         "            \"\\n\\neot() ::= <<~gt()~~gt()~>>\" +\n" +
         "            \"\\n\\nSTGroupTemplate(delimiter,templates) ::= <<delimiters \\\"~delimiter~\\\",\\\"~delimiter~\\\"\" +\n" +
         "            \"\\n\\n~templates:{it|~it~};separator=\\\"\\\\n\\\\n\\\"~\" +\n" +
         "            \"\\n\\neom() ::= \\\"}\\\"\" +\n" +
         "            \"\\n\\ngt() ::= \\\">\\\"\" +\n" +
         "            \"\\n\\n>>\" +\n" +
         "            \"\\n\\nSTTemplate(content,name,params) ::= <<~name~(~params:{it|~it~};separator=\\\",\\\"~) ::= <<~content~ ~eot()~>>\";\n" +
         "\n" +
         "      return new NamedSTGroup(\"TemplateTemplate\", stg, \"~\");\n" +
         "   }\n" +
         "\n" +
         "   private static final class NamedSTGroup extends STGroupString {\n" +
         "\n" +
         "      public NamedSTGroup(String sourceName, String text, String delimiter) {\n" +
         "         super(sourceName, text, delimiter.charAt(0), delimiter.charAt(0));\n" +
         "      }\n" +
         "\n" +
         "      @Override\n" +
         "      public String getName() {\n" +
         "         return sourceName;\n" +
         "      }\n" +
         "   }\n" +
         "\n" +
         "   private static void addParameters(Map<String, ParsedParameter> stParameterMap, AstNode astNode, Stack<ParsedParameter> stParameters) {\n" +
         "\n" +
         "      switch (astNode.getType()) {\n" +
         "         case Expression:\n" +
         "\n" +
         "            final String expressionName = astNode.getChildren().get(0).getAst().toString();\n" +
         "\n" +
         "            final boolean inSubtemplate = astNode.getParent().getType().equals(nextgen.stparser.AstNodeType.Subtemplate);\n" +
         "            if (inSubtemplate && expressionName.equals(astNode.getParent().getChildren().get(0).getAst().getChild(0).toString())) {\n" +
         "               for (AstNode child : astNode.getChildren())\n" +
         "                  addParameters(stParameterMap, child, stParameters);\n" +
         "            } else {\n" +
         "\n" +
         "               if (astNode.getChildren().get(0).getType().equals(nextgen.stparser.AstNodeType.Name)) {\n" +
         "\n" +
         "                  stParameterMap.putIfAbsent(expressionName, newParsedParameter(expressionName));\n" +
         "                  stParameters.push(stParameterMap.get(expressionName));\n" +
         "\n" +
         "                  for (AstNode child : astNode.getChildren())\n" +
         "                     addParameters(stParameterMap, child, stParameters);\n" +
         "\n" +
         "                  stParameters.pop();\n" +
         "               } else {\n" +
         "                  for (AstNode child : astNode.getChildren())\n" +
         "                     addParameters(stParameterMap, child, stParameters);\n" +
         "               }\n" +
         "            }\n" +
         "            break;\n" +
         "\n" +
         "         case Prop:\n" +
         "            stParameters.peek().setType(STParameterType.KVLIST);\n" +
         "\n" +
         "            final ParsedParameterKey parameterKey = new ParsedParameterKey()\n" +
         "                  .setName(astNode.getChildren().get(1).getAst().toString())\n" +
         "                  .setArgumentType(\"Object\");\n" +
         "\n" +
         "            final Optional<ParsedParameterKey> exists = stParameters.peek().getKeys()\n" +
         "                  .stream()\n" +
         "                  .filter(stParameterKey -> stParameterKey.getName().equals(parameterKey.getName()))\n" +
         "                  .findFirst();\n" +
         "\n" +
         "            if (!exists.isPresent())\n" +
         "               stParameters.peek().addKeys(parameterKey);\n" +
         "            break;\n" +
         "\n" +
         "         case ElseIf:\n" +
         "         case If:\n" +
         "\n" +
         "            final AstNode condition = astNode.getChildren().get(0);\n" +
         "            if (condition.getType().equals(nextgen.stparser.AstNodeType.Prop)) {\n" +
         "\n" +
         "               for (AstNode child : astNode.getChildren())\n" +
         "                  addParameters(stParameterMap, child, stParameters);\n" +
         "\n" +
         "            } else {\n" +
         "               final String ifName = condition.getAst().toString();\n" +
         "               stParameterMap.putIfAbsent(ifName, newParsedParameter(ifName));\n" +
         "\n" +
         "               stParameters.push(stParameterMap.get(ifName));\n" +
         "               for (AstNode child : astNode.getChildren())\n" +
         "                  addParameters(stParameterMap, child, stParameters);\n" +
         "               stParameters.pop();\n" +
         "            }\n" +
         "\n" +
         "            break;\n" +
         "\n" +
         "         case Else:\n" +
         "            for (AstNode child : astNode.getChildren())\n" +
         "               addParameters(stParameterMap, child, stParameters);\n" +
         "            break;\n" +
         "\n" +
         "         case Assign:\n" +
         "\n" +
         "            final AstNode assignment = astNode.getChildren().get(1);\n" +
         "            if (assignment.getType().equals(nextgen.stparser.AstNodeType.Name)) {\n" +
         "               final String assignName = assignment.getAst().toString();\n" +
         "               stParameterMap.putIfAbsent(assignName, newParsedParameter(assignName));\n" +
         "            }\n" +
         "\n" +
         "            for (AstNode child : astNode.getChildren())\n" +
         "               addParameters(stParameterMap, child, stParameters);\n" +
         "\n" +
         "            break;\n" +
         "\n" +
         "         case Include:\n" +
         "            final List<AstNode> children = astNode.getChildren();\n" +
         "            for (int i = 1; i < children.size(); i++) {\n" +
         "               AstNode child = children.get(i);\n" +
         "               if (child.getType().equals(nextgen.stparser.AstNodeType.Name)) {\n" +
         "                  final String assignName = child.getAst().toString();\n" +
         "                  stParameterMap.putIfAbsent(assignName, newParsedParameter(assignName));\n" +
         "               } else\n" +
         "                  addParameters(stParameterMap, child, stParameters);\n" +
         "            }\n" +
         "\n" +
         "            break;\n" +
         "\n" +
         "         case Subtemplate:\n" +
         "            if (!stParameters.isEmpty()) stParameters.peek().setType(STParameterType.LIST);\n" +
         "            for (AstNode child : astNode.getChildren())\n" +
         "               addParameters(stParameterMap, child, stParameters);\n" +
         "            break;\n" +
         "      }\n" +
         "   }\n" +
         "\n" +
         "   private static ParsedParameter newParsedParameter(String name) {\n" +
         "      return new ParsedParameter()\n" +
         "            .setName(name)\n" +
         "            .setType(STParameterType.SINGLE)\n" +
         "            .setArgumentType((name != null && name.startsWith(\"is\")) ? \"Boolean\" : \"Object\");\n" +
         "   }\n" +
         "\n" +
         "\n" +
         "   static final class TemplateVisitor {\n" +
         "\n" +
         "      private static final int EXPR = 41;\n" +
         "      private static final int NAME = 25;\n" +
         "      private static final int SUBTEMPLATE = 55;\n" +
         "      private static final int ARGS = 38;\n" +
         "      private static final int PROP = 52;\n" +
         "      private static final int INCLUDE = 42;\n" +
         "      private static final int IF = 4;\n" +
         "      private static final int ELSE = 5;\n" +
         "      private static final int ELSEIF = 6;\n" +
         "      private static final int ASSIGN = 12;\n" +
         "\n" +
         "      private final Stack<AstNode> astNodeStack = new Stack<>();\n" +
         "\n" +
         "      public void visit(ST st) {\n" +
         "         astNodeStack.push(STParserFactory.newAstNode().setType(nextgen.stparser.AstNodeType.ST));\n" +
         "         visit(st.impl.ast);\n" +
         "      }\n" +
         "\n" +
         "      private void visit(Tree ast) {\n" +
         "         switch (ast.getType()) {\n" +
         "            case ARGS:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Args);\n" +
         "               break;\n" +
         "\n" +
         "            case NAME:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Name);\n" +
         "               break;\n" +
         "\n" +
         "            case PROP:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Prop);\n" +
         "               break;\n" +
         "\n" +
         "            case EXPR:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Expression);\n" +
         "               break;\n" +
         "\n" +
         "            case SUBTEMPLATE:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Subtemplate);\n" +
         "               break;\n" +
         "\n" +
         "            case INCLUDE:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Include);\n" +
         "               break;\n" +
         "\n" +
         "            case IF:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.If);\n" +
         "               break;\n" +
         "\n" +
         "            case ELSE:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Else);\n" +
         "               break;\n" +
         "\n" +
         "            case ELSEIF:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.ElseIf);\n" +
         "               break;\n" +
         "\n" +
         "            case ASSIGN:\n" +
         "               pushAstNode(ast, nextgen.stparser.AstNodeType.Assign);\n" +
         "               break;\n" +
         "\n" +
         "            case 51:\n" +
         "            case 22:\n" +
         "               break;\n" +
         "\n" +
         "            case 0:\n" +
         "            case 26:\n" +
         "            case 31:\n" +
         "            case 32:\n" +
         "            case 47:\n" +
         "            case 49:\n" +
         "//               for (int i = 0; i < ast.getChildCount(); i++)\n" +
         "//                  visit(ast.getChild(i));\n" +
         "//               break;\n" +
         "\n" +
         "            default:\n" +
         "               for (int i = 0; i < ast.getChildCount(); i++)\n" +
         "                  visit(ast.getChild(i));\n" +
         "               break;\n" +
         "         }\n" +
         "      }\n" +
         "\n" +
         "      private void pushAstNode(Tree ast, AstNodeType astNodeType) {\n" +
         "\n" +
         "         newAstNode(astNodeType, ast);\n" +
         "\n" +
         "         for (int i = 0; i < ast.getChildCount(); i++)\n" +
         "            visit(ast.getChild(i));\n" +
         "\n" +
         "         astNodeStack.pop();\n" +
         "      }\n" +
         "\n" +
         "      private void newAstNode(AstNodeType astNodeType, Tree ast) {\n" +
         "\n" +
         "         final AstNode astNode = STParserFactory.newAstNode().setType(astNodeType).setAst(ast);\n" +
         "\n" +
         "         if (!astNodeStack.isEmpty()) {\n" +
         "            astNodeStack.peek().addChildren(astNode);\n" +
         "            astNode.setParent(astNodeStack.peek());\n" +
         "         }\n" +
         "\n" +
         "         astNodeStack.push(astNode);\n" +
         "      }\n" +
         "   }\n" +
         "}";

}