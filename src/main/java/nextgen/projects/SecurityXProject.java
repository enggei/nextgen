package nextgen.projects;
//
//import nextgen.st.STGenerator;
//import nextgen.templates.*;
//import nextgen.templates.domain.Domain;
//import nextgen.templates.domain.Entity;
//import nextgen.templates.domain.Relation;
//import nextgen.templates.javascript.*;
//import nextgen.templates.materialui.MaterialUIComponent;
//import nextgen.templates.maven.DependencyScope;
//import nextgen.templates.maven.Pom;
//import nextgen.templates.mobx.BackendAction;
//import nextgen.templates.mobx.BackendStore;
//import nextgen.templates.mobx.Observable;
//import nextgen.templates.vertx.DomainVerticle;
//import nextgen.templates.vertx.VertxST;
//import nextgen.templates.vertx.WebVerticle;
//
//import java.io.File;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import static nextgen.templates.domain.DomainPatterns.newList;
//import static nextgen.templates.domain.DomainPatterns.writeJsonWrapper;
//import static nextgen.templates.domain.DomainPatterns.*;
//import static nextgen.templates.MaterialUIPatterns.*;
//import static nextgen.templates.maven.MavenPatterns.*;
//import static nextgen.templates.MobXPatterns.getName;
//import static nextgen.templates.VertxPatterns.*;
//import static nextgen.templates.WebappPatterns.*;
//import static nextgen.templates.javascript.JavaScriptST.newElement;
//import static nextgen.templates.javascript.JavaScriptST.newJsonObject;
//import static nextgen.utils.StringUtil.*;
//
//public class SecurityXProject {
//
//   final File root = new File("/home/goe/projects/securityx");
//
//   final File mainJava = new File(root, "src/main/java");
//   final File mainResources = new File(root, "src/main/resources");
//   final File testJava = new File(root, "src/test/java");
//
//   final File webRoot = new File("web");
//   final File mainWebapp = new File(root, "src/main/webapp");
//
//   private final nextgen.templates.java.PackageDeclaration corePackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration("com.securityx");
//   private final nextgen.templates.java.PackageDeclaration domainPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(corePackage, "domain");
//   private final nextgen.templates.java.PackageDeclaration mevadataPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(corePackage, "mevadata");
//   private final nextgen.templates.java.PackageDeclaration webPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(corePackage, "web");
//   private final nextgen.templates.java.PackageDeclaration webDomainPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(webPackage, "domain");
//   private final nextgen.templates.java.PackageDeclaration webApiPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(webPackage, "api");
//   private final nextgen.templates.java.PackageDeclaration webMessagesPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(webPackage, "messages");
//   private final nextgen.templates.java.PackageDeclaration utilsPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(corePackage, "utils");
//
//   final String version = "1.0.0";
//   final String appName = "S E C U R I T Y - X";
//
//   final Map<String, nextgen.templates.mobx.IStore> storeMap = new LinkedHashMap<>();
//   final Map<String, ClassComponent> pageMap = new LinkedHashMap<>();
//   final Map<String, MaterialUIComponent> componentMap = new LinkedHashMap<>();
//
//   final MaterialUIComponent userMenu = userMenu(componentMap);
//   final MaterialUIComponent loading = loading(componentMap);
//   final MaterialUIComponent loginMenu = loginMenu(componentMap);
//   final MaterialUIComponent navigationBar = navigationBar(componentMap, appName, userMenu, loginMenu);
//   final MaterialUIComponent copyright = copyright(componentMap, appName);
//   final MaterialUIComponent listErrors = listErrors(componentMap);
//
//   final DomainVerticle domainVerticle = newDomainVerticle()
//         .setPackageName(webPackage.getName())
//         .setName("NeoDomainVerticle")
//         .setDbPath("dbPath")
//         .setDomainFactory("com.securityx.domain.MonitorNeoFactory")
//         .setAddress("domain.db")
//         .addImports(JavaPatterns.newImportDeclaration(domainPackage.getName())
//               .setIsAsterisk(true))
//         .addImports(JavaPatterns.newImportDeclaration(webMessagesPackage.getName())
//               .setIsAsterisk(true))
//         .addImports(JavaPatterns.newImportDeclaration(webMessagesPackage.getName() + ".ResponsesJsonFactory")
//               .setIsAsterisk(true)
//               .setIsStatic(true));
//
//   final Domain messagesDomain = newDomain("Responses");
//
//   // domain
//   final Relation incidentResolutionStatus = newEnumField("status", "ResolutionStatus", "OPEN,DISMISSED,CLOSED");
//   final Relation incidentPriorityType = newEnumField("incidentPriority", "FeedIncidentPriority", "LOW,MEDIUM,HIGH");
//
//   Entity incidentResolution = newEntity("IncidentResolution")
//         .addRelations(newStringField("action"))
//         .addRelations(incidentResolutionStatus);
//   Entity incidentReport = newEntity("IncidentReport")
//         .addRelations(newEnumField("stage", "IncidentReportStage", "CREATED,SENT,ACKNOWLEDGED"))
//         .addRelations(newLongField("sent"))
//         .addRelations(newLongField("acknowledged"))
//         .addRelations(newRef("incidentResolution", incidentResolution));
//
//   final Relation nameField = newStringField("name");
//   final Relation idField = newStringField("id");
//   final Relation uuidField = newStringField("uuid");
//   final Relation incidentCreated = newLongField("created");
//   final Relation incidentStartTime = newLongField("startTime");
//   final Relation incidentTriggerTime = newLongField("triggerTime");
//   final Relation incidentEndTime = newLongField("endTime");
//   final Relation incidentCause = newStringField("cause");
//
//   final Entity incidentFeedData = newEntity("IncidentFeedData")
//         .addRelations(incidentStartTime)
//         .addRelations(incidentTriggerTime)
//         .addRelations(incidentEndTime)
//         .addRelations(incidentCause)
//         .addRelations(newStringField("filename"))
//         .addRelations(newLongField("startFrame"))
//         .addRelations(newLongField("endFrame"))
//         .addRelations(newOneToMany("localization", newEntity("FrameLocalization")
//               .addRelations(newLongField("frame"))
//               .addRelations(newStringField("hwxy"))));
//
//   Entity incident = newEntity("Incident")
//         .addRelations(uuidField)
//         .addRelations(incidentCreated)
//         .addRelations(incidentPriorityType)
//         .addRelations(newRef("reason", incidentFeedData))
//         .addRelations(newRef("incidentReport", incidentReport));
//
//   Entity cameraFeed = newEntity("CameraFeed")
//         .addRelations(nameField)
//         .addRelations(uuidField)
//         .addRelations(newStringField("feedUrl"))
//         .addRelations(newStringField("channel"))
//         .addRelations(newBooleanField("active"))
//         .addRelations(newLongField("started"))
//         .addRelations(newStringField("outputRoot"))
//         .addRelations(newStringField("encoding"))
//         .addRelations(newList("incidents", incident));
//   Entity cameraProduct = newEntity("CameraProduct")
//         .addRelations(newStringField("model"))
//         .addRelations(newStringField("documentation"));
//   Entity cameraSettings = newEntity("CameraSettings")
//         .addRelations(newStringField("ip"))
//         .addRelations(newStringField("username"))
//         .addRelations(newStringField("password"))
//         .addRelations(newStringField("protocol"));
//   Entity camera = newEntity("Camera")
//         .addRelations(idField)
//         .addRelations(nameField)
//         .addRelations(newRef("settings", cameraSettings))
//         .addRelations(newRef("product", cameraProduct))
//         .addRelations(newList("feeds", cameraFeed));
//   Entity server = newEntity("Server")
//         .addRelations(newStringField("localIp"))
//         .addRelations(newStringField("externalIp"))
//         .addRelations(newStringField("placement"));
//   Entity customer = newEntity("Customer")
//         .addRelations(newStringField("firstName"))
//         .addRelations(newStringField("lastName"))
//         .addRelations(newStringField("email"));
//   Entity site = newEntity("Site")
//         .addRelations(idField)
//         .addRelations(nameField)
//         .addRelations(newStringField("address"))
//         .addRelations(newRef("customer", customer))
//         .addRelations(newRef("server", server))
//         .addRelations(newList("cameras", camera));
//   Entity admin = newEntity("Admin")
//         .addRelations(newStringField("username"))
//         .addRelations(newStringField("password"))
//         .addRelations(newStringField("email"));
//   Domain monitor = newDomain("Monitor")
//         .addEntities(admin)
//         .addEntities(site);
//
//   // mevadata
//   Entity boundingBox = newEntity("BoundingBox")
//         .addRelations(newStringField("hwxy"));
//   Entity frameObject = newEntity("FrameObject")
//         .addRelations(newLongField("frame"))
//         .addRelations(newRef("boundingBox", boundingBox));
//   Entity activityObject = newEntity("ActivityObject")
//         .addRelations(newIntegerField("objectID"))
//         .addRelations(newStringField("objectType"))
//         .addRelations(newList("localization", frameObject));
//   Entity localization = newEntity("Localization")
//         .addRelations(newLongField("startFrame"))
//         .addRelations(newLongField("endFrame"));
//   Entity activity = newEntity("Activity")
//         .addRelations(newStringField("activity"))
//         .addRelations(newIntegerField("activityID"))
//         .addRelations(newRef("localization", localization))
//         .addRelations(newList("objects", activityObject));
//   Entity videoFeed = newEntity("VideoFeed")
//         .addRelations(newStringField("date"))
//         .addRelations(newStringField("startTime"))
//         .addRelations(newStringField("endTime"))
//         .addRelations(newStringField("file"))
//         .addRelations(newList("activities", activity));
//   Entity distortion = newEntity("Distortion")
//         .addRelations(newStringField("vector"));
//   Entity translation = newEntity("Translation")
//         .addRelations(newStringField("vector"));
//   Entity rotation = newEntity("Rotation")
//         .addRelations(newStringField("matrix"));
//   Entity intrinsic = newEntity("Intrinsic")
//         .addRelations(newStringField("matrix"));
//   Entity krtd = newEntity("KRTD")
//         .addRelations(newRef("intrinsic", intrinsic))
//         .addRelations(newRef("rotation", rotation))
//         .addRelations(newRef("translation", translation))
//         .addRelations(newRef("distortion", distortion));
//   Entity resolution = newEntity("Resolution")
//         .addRelations(newStringField("dimensions"));
//   Entity camera2 = newEntity("Camera")
//         .addRelations(newStringField("specFile"))
//         .addRelations(newLongField("id"))
//         .addRelations(newEnumField("sensorType", "SensorType", "EO,IR"))
//         .addRelations(newStringField("model"))
//         .addRelations(newRef("resolution", resolution))
//         .addRelations(newStringField("notes"));
//   Entity cameraLocation = newEntity("CameraLocation")
//         .addRelations(newStringField("description"))
//         .addRelations(newStringField("feedUrl"))
//         .addRelations(newStringField("location"))
//         .addRelations(newStringField("month"))
//         .addRelations(newEnumField("LocationType", "LocationType", "EXTERIOR,INTERIOR"))
//         .addRelations(newRef("camera", camera2))
//         .addRelations(newRef("krtd", krtd))
//         .addRelations(newList("feeds", videoFeed));
//   Entity site2 = newEntity("Site")
//         .addRelations(newStringField("name", true))
//         .addRelations(newList("cameraLocation", cameraLocation));
//   Entity bucketObject = newEntity("BucketObject")
//         .addRelations(newStringField("key"))
//         .addRelations(newStringField("eTag"))
//         .addRelations(newLongField("size"))
//         .addRelations(newLongField("lastModified"))
//         .addRelations(newStringField("storageClass"));
//   Entity bucket = newEntity("Bucket")
//         .addRelations(nameField)
//         .addRelations(newList("objects", bucketObject));
//   Entity repository = newEntity("Repository")
//         .addRelations(newStringField("root"))
//         .addRelations(newRef("bucket", bucket))
//         .addRelations(newRef("site", site2));
//   Domain mevadata = newDomain("Mevadata")
//         .addEntities(repository);
//
//   /**
//    * generateProjectFiles
//    */
//   @org.junit.Test
//   public void generateProjectFiles() {
//
//      final String mainClass = "ServerApp";
//
//      final Pom projectPom = newPom()
//            .setName("SecurityX")
//            .setGroupId("com.securityx")
//            .setArtifactId("Monitor")
//            .setVersion(version)
//            .addProperties(setMavenCompilerSource("1.8"))
//            .addProperties(setMavenCompilerTarget("1.8"))
//            .addProperties(setProjectBuildSourceEncoding("UTF-8"))
//            .addProperties(setProjectReportingOutputEncoding("UTF-8"))
//            .addDependencies(newDependency()
//                  .setArtifactId("jply")
//                  .setGroupId("org.smurn")
//                  .setVersion("0.2.0")
//                  .setScope(DependencyScope.Provided))
//            .addDependencies(newDependency()
//                  .setArtifactId("aws-java-sdk")
//                  .setGroupId("com.amazonaws")
//                  .setVersion("1.11.163")
//                  .setScope(DependencyScope.Provided))
//            .addDependencies(newDependency()
//                  .setArtifactId("neo4j")
//                  .setGroupId("org.neo4j")
//                  .setVersion("3.5.8"))
//            .addDependencies(newDependency()
//                  .setArtifactId("slf4j-log4j12")
//                  .setGroupId("org.slf4j")
//                  .setVersion("1.7.20"))
//            .addDependencies(newDependency()
//                  .setArtifactId("junit")
//                  .setGroupId("junit")
//                  .setVersion("4.12")
//                  .setScope(DependencyScope.Test))
//            .setBuild(newBuild()
//                  .addPlugin(newCopyPlugin()
//                        .setDirectory(mainWebapp.getPath())
//                        .setOutputDirectory(webRoot.getPath())
//                        .addInclude("favicon.ico")
//                        .addInclude("index.css")
//                        .addInclude("index.html")
//                        .addInclude("index.js")
//                        .addInclude("video-react.css"))
//                  .addPlugin(newFrontEndMavenPlugin()
//                        .setInstallDirectory("target")
//                        .setNodeVersion("8.9.0")
//                        .setPluginVersion("1.10.0"))
//                  .addPlugin(newShadePlugin()
//                        .setClassName(mainClass)
//                        .setPackageName(webPackage.getName())));
//
//      addDependencyGroup(projectPom, newDependencyGroup()
//            .setName("vertx")
//            .setGroupId("io.vertx")
//            .setVersion("3.8.3")
//            .addArtifacts("vertx-core")
//            .addArtifacts("vertx-web")
//            .addArtifacts("vertx-auth-jwt")
//            .addArtifacts("vertx-unit"));
//
//      generate(newProject()
//            .setName("SecurityX")
//            .setRoot(root.getAbsolutePath()), projectPom);
//
//      GitPatterns.write(root, GitPatterns.newGitignore()
//            .addExcludeDirs(".idea")
//            .addExcludeDirs("db")
//            .addExcludeDirs("dbs")
//            .addExcludeDirs("resources")
//            .addExcludeDirs("mevadata")
//            .addExcludeDirs("node_modules")
//            .addExcludeFiles("Monitor.iml")
//            .addExcludeDirs("target"));
//
//      NpmPatterns.generate(NpmPatterns.newNpmProject()
//            .setRoot(root.getAbsolutePath())
//            .setPackageJson(NpmPatterns.newPackageJson()
//                  .setName("securityx")
//                  .setVersion(version)
//                  .setDescription("SecurityX video monitoring")
//                  .setAuthor("GOE")
//                  .setLicense("ISC")
//                  .setMain("index.js")
//                  .addScripts(NpmPatterns.newScript().setName("deploy").setCommand("webpack --mode production"))
//                  .addScripts(NpmPatterns.newScript()
//                        .setName("server")
//                        .setCommand("webpack-dev-server --open --mode development"))
//                  .addScripts(NpmPatterns.newScript().setName("package").setCommand("webpack --mode development"))
//                  .addScripts(NpmPatterns.newScript().setName("develop")
//                        .setCommand("webpack --watch --progress --mode development"))
//                  .addDependencies(NpmPatterns.newDependency("react", "16.9.0"))
//                  .addDependencies(NpmPatterns.newDependency("react-dom", "16.9.0"))
//                  .addDependencies(NpmPatterns.newDependency("react-router-dom", "5.0.1"))
//                  .addDependencies(NpmPatterns.newDependency("@material-ui/core", "4.4.2"))
//                  .addDependencies(NpmPatterns.newDependency("@material-ui/icons", "4.4.2"))
//                  .addDependencies(NpmPatterns.newDependency("@material-ui/styles", "4.4.2"))
//                  .addDependencies(NpmPatterns.newDependency("material-table", "1.50.0"))
//                  .addDependencies(NpmPatterns.newDependency("victory", "33.1.1"))
//                  .addDependencies(NpmPatterns.newDependency("chart-race-react", "1.0.2"))
//                  .addDependencies(NpmPatterns.newDependency("mobx", "5.13.0"))
//                  .addDependencies(NpmPatterns.newDependency("mobx-react", "6.1.3"))
//                  .addDependencies(NpmPatterns.newDependency("superagent", "5.1.0"))
//                  .addDependencies(NpmPatterns.newDependency("superagent-promise", "1.1.0"))
//                  .addDependencies(NpmPatterns.newDependency("video-react", "0.14.1"))
//                  .addDevDependencies(NpmPatterns.newDependency("@babel/core", "7.1.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-class-properties", "7.5.5"))
//                  .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-decorators", "7.6.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("@babel/preset-env", "7.1.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("@babel/preset-react", "7.0.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("babel-loader", "8.0.2"))
//                  .addDevDependencies(NpmPatterns.newDependency("webpack", "4.19.1"))
//                  .addDevDependencies(NpmPatterns.newDependency("webpack-cli", "3.1.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("html-webpack-plugin", "3.2.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("css-loader", "3.2.0"))
//                  .addDevDependencies(NpmPatterns.newDependency("style-loader", "1.0.0")))
//            .setWebpackConfig(NpmPatterns.newWebpackConfig()
//                  .setMainEntry("/" + STGenerator.makeRelative(new File(mainWebapp, "index.js"), root).getPath())
//                  .setOutputFilename(new File(webRoot, "main.js")))
//            .setBabelrc(NpmPatterns.newBabelrc()));
//   }
//
//   @org.junit.Test
//   public void generateDomain() {
//      writeNeo(mainJava, domainPackage, monitor);
//      writeJsonWrapper(testJava, mevadataPackage, mevadata);
//   }
//
//   @org.junit.Test
//   public void generateApp() {
//
//      final Entity serverDeploymentOptions = generateServerDeploymentOptions();
//      final WebVerticle webVerticle = generateWebVerticle(serverDeploymentOptions);
//
//      final IndexJS indexJS = JavaScriptPatterns.newIndexJS();
//      final IndexHtml indexHtml = JavaScriptPatterns.newIndexHtml()
//            .setTitle(appName)
//            .addStylesheets("video-react.css");
//      final IndexCSS indexCSS = JavaScriptPatterns.newIndexCSS();
//
//      // https://in-your-saas.github.io/material-ui-theme-editor/
//      final App app = JavaScriptPatterns.newApp()
//            .setTheme("{\"palette\":{\"common\":{\"black\":\"#000\",\"white\":\"#fff\"},\"background\":{\"paper\":\"#fff\",\"default\":\"#fafafa\"},\"primary\":{\"light\":\"rgba(255, 255, 255, 1)\",\"main\":\"rgba(22, 22, 23, 1)\",\"dark\":\"rgba(74, 74, 74, 1)\",\"contrastText\":\"#fff\"},\"secondary\":{\"light\":\"#ff4081\",\"main\":\"rgba(245, 166, 35, 1)\",\"dark\":\"#c51162\",\"contrastText\":\"#fff\"},\"error\":{\"light\":\"#e57373\",\"main\":\"#f44336\",\"dark\":\"#d32f2f\",\"contrastText\":\"#fff\"},\"text\":{\"primary\":\"rgba(0, 0, 0, 0.87)\",\"secondary\":\"rgba(0, 0, 0, 0.54)\",\"disabled\":\"rgba(0, 0, 0, 0.38)\",\"hint\":\"rgba(0, 0, 0, 0.38)\"}}}");
//
//      final Superagent superagent = JavaScriptPatterns.newSuperagent();
//      final AgentDeclaration authEndpoint = addEndpoint("Auth", superagent)
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("currentUser", "user", "get"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("login", "login", "post")
//                  .addParameters("username")
//                  .addParameters("password"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("logout", "logout", "post")
//                  .addParameters("username"));
//
//      final nextgen.templates.mobx.Store appStore = appStore(appName, storeMap, indexJS, app);
//
//      // login
//      final nextgen.templates.mobx.Store userStore = userStore(storeMap, indexJS, app);
//      final nextgen.templates.mobx.Store authStore = authStore(storeMap, indexJS, app, appStore, userStore, authEndpoint);
//      final MaterialUIComponent loginForm = loginForm(componentMap);
//      final MaterialUIComponent logoutForm = logoutForm(componentMap);
//      final ClassComponent loginPage = loginPage(pageMap, authStore, loginForm, copyright, listErrors, "status");
//      final ClassComponent logoutPage = logoutPage(pageMap, authStore, logoutForm, copyright);
//      app.addRoutes(loginPage.getName(), loginPage.getName(), "/login", null);
//      app.addRoutes(logoutPage.getName(), logoutPage.getName(), "/logout", null);
//
//      final AgentDeclaration domainEndpoint = addEndpoint("Domain", superagent)
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("getSiteIncidents", "api/site/incidents/", "get")
//                  .setUrlParam("id"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("getSiteSettings", "api/site/settings/", "get")
//                  .setUrlParam("id"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("saveSiteSettings", "api/site/settings", "post")
//                  .addParameters("settings"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("getCamera", "api/camera", "get/")
//                  .setUrlParam("id"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("getCameraLiveFeed", "api/camera/liveFeed/", "get")
//                  .setUrlParam("id"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("getCameraSettings", "api/camera/settings/", "get")
//                  .setUrlParam("id"))
//            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("saveCameraSettings", "api/camera/settings", "post")
//                  .addParameters("settings"));
//
//      final BackendStore domainStore = newBackendStore("DomainStore", storeMap, indexJS, app);
//
//      // status
//      statusModule(webVerticle, app, domainEndpoint, domainStore);
//
//      // site
//      siteModule(webVerticle, app, domainEndpoint, domainStore);
//
//      // camera live-feed
//      final MaterialUIComponent cameraFeedComponent = cameraFeedComponent();
//      final ClassComponent cameraFeedPage = cameraFeedPage(cameraFeedComponent);
//      app.addRoutes(cameraFeedPage.getName(), cameraFeedPage.getName(), "/cameraFeed/:id", null);
//
//      // camera settings
//      final MaterialUIComponent cameraSettingsComponent = cameraSettingsComponent();
//      final ClassComponent cameraSettingsPage = cameraSettingsPage(cameraSettingsComponent);
//      app.addRoutes(cameraSettingsPage.getName(), cameraSettingsPage.getName(), "/cameraSettings/:id", null);
//
//      // camera incidents
//      incidentModule(webVerticle, app, domainEndpoint, domainStore);
//
//      STGenerator.writeJsFile(indexJS, null, "index", mainWebapp);
//      STGenerator.writeHtmlFile(indexHtml, null, "index", mainWebapp);
//      STGenerator.writeFile(indexCSS, null, "index.css", mainWebapp);
//      STGenerator.writeJsFile(app, null, "App", mainWebapp);
//      STGenerator.writeFile(superagent, null, "Agent.js", mainWebapp);
//
//      for (nextgen.templates.mobx.IStore store : storeMap.values())
//         STGenerator.writeJsFile(store, "stores", getName(store), mainWebapp);
//      for (ClassComponent classComponent : pageMap.values())
//         STGenerator.writeJsFile(classComponent, "pages", classComponent.getName(), mainWebapp);
//      for (MaterialUIComponent component : componentMap.values())
//         STGenerator.writeJsFile(component, "components", component.getName(), mainWebapp);
//
//      writeJsonWrapper(mainJava, webMessagesPackage, messagesDomain);
//
//      STGenerator.writeJavaFile(webVerticle, webVerticle.getPackageName().toString(), webVerticle.getName()
//            .toString(), mainJava);
//
//      STGenerator.writeJavaFile(domainVerticle, domainVerticle.getPackageName().toString(), domainVerticle.getName()
//            .toString(), mainJava);
//   }
//
//   public void incidentModule(WebVerticle webVerticle, App app, AgentDeclaration domainEndpoint, BackendStore domainStore) {
//      final String getCameraIncidents = "getCameraIncidents";
//      final AgentEndpoint getCameraIncidentsEndpoint = JavaScriptPatterns.newAgentEndpoint(getCameraIncidents, "api/camera/incidents/", "get")
//            .setUrlParam("id");
//      domainEndpoint.addAgentEndpoint(getCameraIncidentsEndpoint);
//
//      webVerticle.addRoutes("get", "api/camera/incidents/:id", "this::" + getCameraIncidents);
//      webVerticle.addHandlers(VertxST.newRouteHandler()
//            .setName(getCameraIncidents)
//            .addStatements(VertxST.newSendEventBusAction()
//                  .setActionName(getCameraIncidents)
//                  .addParams("id")));
//
//      messagesDomain.addEntities(newEntity("CameraIncidents")
//            .addRelations(newOneToOne("camera", newEntity("IncidentCamera")
//                  .addRelations(nameField)
//                  .addRelations(idField)))
//            .addRelations(newOneToMany("incidents", newEntity("CameraIncident")
//                  .addRelations(newStringField("created"))
//                  .addRelations(newStringField("startTime"))
//                  .addRelations(newStringField("endTime"))
//                  .addRelations(incidentPriorityType)
//                  .addRelations(incidentCause)
//                  .addRelations(incidentResolutionStatus)
//                  .addRelations(newStringField("feedUuid"))
//            )));
//
//      domainVerticle.addActions(getCameraIncidents, newDomainAction()
//            .setName(getCameraIncidents)
//            .addParams("String", "id")
//            .addStatements("final Camera camera = db.findCameraById(id);\n" +
//                  "final CameraIncidents cameraIncidents = newCameraIncidents()\n" +
//                  "\t\t.setCamera(newIncidentCamera()\n" +
//                  "\t\t\t\t.setId(camera.getId())\n" +
//                  "\t\t\t\t.setName(camera.getName()));\n" +
//                  "camera.getFeeds()\n" +
//                  "\t\t.forEach(cameraFeed -> cameraFeed.getIncidents()\n" +
//                  "\t\t\t\t.sorted(java.util.Comparator.comparingLong((java.util.function.ToLongFunction<Incident>) Incident::getCreated)\n" +
//                  "\t\t\t\t\t\t.thenComparingLong(i -> i.getReason().getStartTime()))\n" +
//                  "\t\t\t\t.forEach(incident -> {\n" +
//                  "\n" +
//                  "\t\t\t\t\tfinal IncidentFeedData reason = incident.getReason();\n" +
//                  "\t\t\t\t\tfinal IncidentReport incidentReport = incident.getIncidentReport();\n" +
//                  "\t\t\t\t\tfinal IncidentResolution resolution = incidentReport.getIncidentResolution();\n" +
//                  "\n" +
//                  "\t\t\t\t\tfinal CameraIncident cameraIncident = newCameraIncident()\n" +
//                  "\t\t\t\t\t\t\t.setCreated(new java.text.SimpleDateFormat(\"dd.MM.yyyy\").format(incident.getCreated()))\n" +
//                  "\t\t\t\t\t\t\t.setStartTime(new java.text.SimpleDateFormat(\"HH:mm:ss\").format(reason.getStartTime()))\n" +
//                  "\t\t\t\t\t\t\t.setEndTime(new java.text.SimpleDateFormat(\"HH:mm:ss\").format(reason.getEndTime()))\n" +
//                  "\t\t\t\t\t\t\t.setIncidentPriority(com.securityx.web.messages.FeedIncidentPriority.valueOf(incident.getIncidentPriority()\n" +
//                  "\t\t\t\t\t\t\t\t\t.name()))\n" +
//                  "\t\t\t\t\t\t\t.setCause(reason.getCause())\n" +
//                  "\t\t\t\t\t\t\t.setFeedUuid(reason.getFilename())\n" +
//                  "\t\t\t\t\t\t\t.setStatus(com.securityx.web.messages.ResolutionStatus.valueOf(resolution.getStatus()\n" +
//                  "\t\t\t\t\t\t\t\t\t.name()));\n" +
//                  "\n" +
//                  "\t\t\t\t\tcameraIncidents.addIncidents(cameraIncident);\n" +
//                  "\t\t\t\t}));\n" +
//                  "\n" +
//                  "message.reply(new JsonObject().put(\"data\", cameraIncidents.getJsonObject()));"));
//
//      final Observable currentCameraIncidentsObservable = MobXPatterns.newObservable("currentCameraIncidents", null);
//      final BackendAction loadCameraIncidentsAction = newBackendAction(domainEndpoint, currentCameraIncidentsObservable, getCameraIncidentsEndpoint
//            .getName())
//            .addParams("camera");
//
//      domainStore.addObservables(currentCameraIncidentsObservable)
//            .addActions(loadCameraIncidentsAction);
//
//      final MaterialUIComponent incidentRow = cameraIncidentRow();
//      final MaterialUIComponent cameraIncidentTable = cameraIncidentTable(incidentRow);
//      final ClassComponent cameraIncidentPage = cameraIncidentPage(domainStore, cameraIncidentTable)
//            .addConstructorStatements(JavaScriptPatterns.newStatement()
//                  .setExpression(load(domainStore, loadCameraIncidentsAction)
//                        .addParameters("this.props.match.params.id")))
//            .setRenderCondition(storeProp(domainStore, currentCameraIncidentsObservable))
//            .setRenderTrue(asElement(cameraIncidentTable)
//                  .addProps(JavaScriptPatterns.newProp("data", JavaScriptPatterns.newJsonObject(storeProp(domainStore, currentCameraIncidentsObservable)))));
//      app.addRoutes(cameraIncidentPage.getName(), cameraIncidentPage.getName(), "/cameraIncidents/:id", null);
//   }
//
//   public void siteModule(WebVerticle webVerticle, App app, AgentDeclaration domainEndpoint, BackendStore domainStore) {
//      final String getSite = "getSite";
//      final AgentEndpoint getSiteEndpoint = JavaScriptPatterns.newAgentEndpoint(getSite, "api/site/", "get")
//            .setUrlParam("id");
//      domainEndpoint.addAgentEndpoint(getSiteEndpoint);
//
//      webVerticle.addRoutes("get", "api/site/:id", "this::" + getSite);
//      webVerticle.addHandlers(VertxST.newRouteHandler()
//            .setName(getSite)
//            .addStatements(VertxST.newSendEventBusAction()
//                  .setActionName(getSite)
//                  .addParams("id")));
//
//      messagesDomain.addEntities(newEntity("SiteMessage")
//            .addRelations(nameField)
//            .addRelations(idField)
//            .addRelations(newOneToMany("cameraLocations", newEntity("CameraLocation")
//                  .addRelations(nameField)
//                  .addRelations(newLongField("incidents"))
//                  .addRelations(idField))));
//
//      domainVerticle.addActions(getSite, newDomainAction()
//            .setName(getSite)
//            .addParams("String", "id")
//            .addStatements("final com.securityx.domain.Site site = db.findSiteById(id);\n" +
//                  "if (site == null) {\n" +
//                  "   message.fail(ErrorCodes.DB_ERROR.ordinal(), \"No Site\");\n" +
//                  "   return;\n" +
//                  "}\n" +
//                  "final SiteMessage response = newSiteMessage().setName(site.getName()).setId(site.getId());\n" +
//                  "site.getCameras()\n" +
//                  "      .forEach(camera -> {\n" +
//                  "\n" +
//                  "         final CameraLocation cameraLocation = newCameraLocation()\n" +
//                  "               .setId(camera.getId())\n" +
//                  "               .setName(camera.getName());\n" +
//                  "\n" +
//                  "         final java.util.concurrent.atomic.AtomicLong incidents = new java.util.concurrent.atomic.AtomicLong(0);\n" +
//                  "         camera.getFeeds().forEach(cameraFeed -> incidents.addAndGet(cameraFeed.getIncidents().count()));\n" +
//                  "         cameraLocation.setIncidents(incidents.get());\n" +
//                  "         \n" +
//                  "         response.addCameraLocations(cameraLocation);\n" +
//                  "      });\n" +
//                  "message.reply(new JsonObject().put(\"data\", response.getJsonObject()));"));
//
//      final Observable currentSiteObservable = MobXPatterns.newObservable("currentSite", null);
//      final BackendAction loadSiteAction = newBackendAction(domainEndpoint, currentSiteObservable, getSiteEndpoint.getName())
//            .addParams("site");
//      domainStore.addObservables(currentSiteObservable)
//            .addActions(loadSiteAction);
//
//      final MaterialUIComponent cameraLocationCard = cameraLocationCard()
//            .addConst("{ cameraLocation }", "props")
//            .addConst("LiveLink", JavaScriptPatterns.newForwardRef()
//                  .setTo(JavaScriptPatterns.newJsonObject("'/cameraFeed/' + cameraLocation.id")))
//            .addConst("SettingsLink", JavaScriptPatterns.newForwardRef()
//                  .setTo(JavaScriptPatterns.newJsonObject("'/cameraSettings/' + cameraLocation.id")))
//            .addConst("EventsLink", JavaScriptPatterns.newForwardRef()
//                  .setTo(JavaScriptPatterns.newJsonObject("'/cameraIncidents/' + cameraLocation.id")));
//      final MaterialUIComponent siteComponent = siteComponent(cameraLocationCard)
//            .addConst("{ data }", "props");
//      final ClassComponent sitePage = sitePage(domainStore, siteComponent)
//            .addConstructorStatements(JavaScriptPatterns.newStatement()
//                  .setExpression(load(domainStore, loadSiteAction)
//                        .addParameters("this.props.match.params.id")))
//            .setRenderCondition(storeProp(domainStore, currentSiteObservable))
//            .setRenderTrue(asElement(siteComponent)
//                  .addProps(JavaScriptPatterns.newProp("data", JavaScriptPatterns.newJsonObject(storeProp(domainStore, currentSiteObservable)))));
//      app.addRoutes(sitePage.getName(), sitePage.getName(), "/site/:id", null);
//   }
//
//   public void statusModule(WebVerticle webVerticle, App app, AgentDeclaration domainEndpoint, BackendStore domainStore) {
//      final String getStatus = "getStatus";
//      final AgentEndpoint getStatusEndpoint = JavaScriptPatterns.newAgentEndpoint(getStatus, "api/status/", "get");
//      domainEndpoint.addAgentEndpoint(getStatusEndpoint);
//
//      webVerticle.addRoutes("get", "api/status", "this::" + getStatus);
//      webVerticle.addHandlers(VertxST.newRouteHandler()
//            .setName(getStatus)
//            .addStatements(newSendEventBusAction()
//                  .setActionName(getStatus)));
//
//      messagesDomain.addEntities(newEntity("Status")
//            .addRelations(newOneToMany("sites", newEntity("SiteStatus")
//                  .addRelations(nameField)
//                  .addRelations(idField)
//                  .addRelations(newIntegerField("ordinal"))
//                  .addRelations(newLongField("cameras")))));
//
//      domainVerticle.addActions(getStatus, newDomainAction()
//            .setName(getStatus)
//            .setStatements(new Object[]{
//                  "final Status response = newStatusNoUuid();",
//                  "final java.util.concurrent.atomic.AtomicInteger id = new java.util.concurrent.atomic.AtomicInteger(0);",
//                  "db.findAllSite().forEach(site -> response.addSites(newSiteStatusNoUuid().setId(site.getId()).setName(site.getName()).setOrdinal(id.incrementAndGet()).setCameras(site.getCameras().count())));",
//                  "message.reply(new JsonObject().put(\"data\", response.getJsonObject()));"
//            }));
//
//      final Observable statusObservable = MobXPatterns.newObservable("status", null);
//      final BackendAction loadStatusAction = newBackendAction(domainEndpoint, statusObservable, getStatusEndpoint.getName());
//      domainStore
//            .addObservables(statusObservable)
//            .addActions(loadStatusAction);
//
//      final MaterialUIComponent statusCard = statusCard();
//      final MaterialUIComponent statusComponent = statusComponent(statusCard)
//            .addConst("{ data }", "props");
//      final ClassComponent statusPage = statusPage(domainStore, statusComponent)
//            .addConstructorStatements(load(domainStore, loadStatusAction))
//            .setRenderCondition(storeProp(domainStore, statusObservable))
//            .setRenderTrue(asElement(statusComponent)
//                  .addProps(JavaScriptPatterns.newProp("data", JavaScriptPatterns.newJsonObject(storeProp(domainStore, statusObservable)))));
//      app.addRoutes(statusPage.getName(), statusPage.getName(), "/status", null);
//   }
//
//   public WebVerticle generateWebVerticle(Entity serverDeploymentOptions) {
//      return VertxST.newWebVerticle()
//            .setPackageName(webPackage.getName())
//            .setName("WebVerticle")
//            .addFields(webDomainPackage.getName() + "." + serverDeploymentOptions.getName(), "deploymentOptions", null)
//            .addFields("java.util.Map<String, com.securityx.web.api.UserSession>", "sessionMap", "new java.util.concurrent.ConcurrentHashMap<>()")
//            .setStartStatements(new Object[]{
//                  "deploymentOptions = new com.securityx.web.domain.ServerDeploymentOptions(config());",
//                  "final Optional<com.securityx.web.domain.SSLDeploymentSettings> ssl = Optional.ofNullable(deploymentOptions.getSsl());",
//                  "",
//                  "final JWTAuth auth = JWTAuth.create(vertx, new JWTAuthOptions()",
//                  "		.addPubSecKey(new io.vertx.ext.auth.PubSecKeyOptions()",
//                  "				.setAlgorithm(\"RS256\")",
//                  "				.setPublicKey(\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgFjRQaDPjnmFdfsl6mVbnD4NBbl8EcOrbwoKwrfx4vN0oy0WC47x4Grgsu9CQjTlfTrZmXRYnjeYX38ZD2NUnmlQgRghlEDzsxere6l6NGAIKEpKIOMre7NBNwqUEl97nIbr4zEgQ41w0JoP0suDuS3tvP9uJL18Jfr6lf38jaL6+4Nku3l+f2NihSldKkR8m+Gm6wZ5KI2xzbmjpULbqLTll4P3XG5E7QGTcY0w5oM6rbVRnrxrgaY2uQJqp6YsVU5aCghoEh5rEYPl7x1RfoMOXfgpOGVorytHFfK+3C26q+zLw/x3SAU5fzMP2o7bsL91jtQ6cuzf49u1EjqanQIDAQAB\")",
//                  "				.setSecretKey(\"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAWNFBoM+OeYV1+yXqZVucPg0FuXwRw6tvCgrCt/Hi83SjLRYLjvHgauCy70JCNOV9OtmZdFieN5hffxkPY1SeaVCBGCGUQPOzF6t7qXo0YAgoSkog4yt7s0E3CpQSX3uchuvjMSBDjXDQmg/Sy4O5Le28/24kvXwl+vqV/fyNovr7g2S7eX5/Y2KFKV0qRHyb4abrBnkojbHNuaOlQtuotOWXg/dcbkTtAZNxjTDmgzqttVGevGuBpja5AmqnpixVTloKCGgSHmsRg+XvHVF+gw5d+Ck4ZWivK0cV8r7cLbqr7MvD/HdIBTl/Mw/ajtuwv3WO1Dpy7N/j27USOpqdAgMBAAECggEALTieCiSR3N4+QtKJimvJ+mP2jKTM7SlnFsmP/wl2pYMn/nJdSRdFa8/cec9JJjCjBxucHbBbpOtruYH7n2tdHi93GPUap7S26MwXNIwDLb8EQMXkFnBUGtKO0MjeYRbZY846AKOHfaWxMR6HIrtoHu/qyuOouDM3Md6bOgvyVyisyVg1JWrINRD3MitUvinSFbXqyENai+qovc2ADrOjLgYVt2PuLURrwYVwTa2LfDIAVSqHuXj3t+QVmSq2AEp7hssHhMQqP5NJ0iSxQ9yeHlVLBqiPwy4ae7RDif71rmyj97MH1S21n+4Q3wOtZUE4DD0l4FIWFOQcmgWnF2M8VQKBgQC472izN0peW1OR35FuSJpyqMWiixiJIZp2KTd0tbP0rp3jVsnhX9umKCdt5ikXf3COzLUNkRQbi3F8vJH/ITj4z4jPNkYcfRBq4P7SoryFIWAq20aLe6LtxYO05QnhNN0neDYwPPbjq8ZmXFYddj3GKG6Fm08Nqj36Azw0HFmX+wKBgQCxqqoaloLPp2+LbpCjntEpHoNqg2erljVhFoJRY/4lbmsXnIQ7bHwrbMc8Izv/TsbgtF428vE3LHoW+jq/gX+vQbdTazR8nCTmtTK98qI1k28J04T88Mpa9p4Ztd2HITVA27ge2HUtG59YvVOAiJXOcLjF2bBdHyJWQrEp1KYcRwKBgDUliD9IunSXZlLbnx3Ee65L1lA6DRkLsSoX+jnuJgNBU1qMDIRaWfNMQtiQdmqsUxqWtclqUg8AaeLhBkv9rjPC4Jw8CrYRMvCkLFc4MVlJGCv4zDM1msMeKhWIZOh1msDHCTufqYwQR3oPOyhIXMRfxjNbSMKylBEPcPPA2faVAoGAMeOtnoezNeJbhTjH7toy+6vw1SEPJHSqipfKglZk0FgARIIT86fT+lGyZKW0PE3/tKuRZTa1G3wm0Hr1sj8H/suiUg9hjrg9+HbbR9FxUUAURxsZVfm7qO1lmeyix0ZA8PSB8E9yH/eIuF95qjcwcebfS9eEGbIbb0ONAiUPfBMCgYB6pvtvWVIeKNTVTsAu6IxQKAHBNSAt4+PNr/SRyKKHYRSK/rVzNoacORTPt7KFD76r68H6KXFH5SNoAG7/jG/XGW8FduS3mkDZbl8z0tSRzdWcTAzW6g+fZrpnjNpP4zKOePbxNkyFT29tuaGdLkrtAeChbkqu2UD0s77+EXkVKA==\")",
//                  "		));"
//            })
//            .addRoutes("post", "login", "routingContext -> login(routingContext, auth)")
//            .addRoutes("route", "api/*", "JWTAuthHandler.create(auth, \"/login\")")
//            .addRoutes("post", "logout", "this::logout")
//            .addRoutes("get", "user", "this::getUser")
//            .addHandlers(VertxST.newRouteHandler()
//                  .setName("login")
//                  .addParams("JWTAuth", "auth")
//                  .setStatements(new Object[]{
//                        "final com.securityx.web.api.LoginRequest loginRequest = com.securityx.web.api.WebApiJsonFactory.newLoginRequest(routingContext.getBodyAsJson());",
//                        "",
//                        "final Optional<com.securityx.web.domain.UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()",
//                        "		.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(loginRequest.getUsername()))",
//                        "		.findFirst();",
//                        "",
//                        "if (!userFound.isPresent()) {",
//                        "	sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");",
//                        "	return;",
//                        "}",
//                        "",
//                        "final boolean passwordMatch = com.securityx.utils.PasswordUtils.verifyUserPassword(loginRequest.getPassword(), userFound.get().getPassword(), userFound.get().getSalt());",
//                        "if (!passwordMatch) {",
//                        "	sendErrors(routingContext, BAD_REQUEST, \"User credentials not found\");",
//                        "	return;",
//                        "}",
//                        "",
//                        "final String token = auth.generateToken(",
//                        "		com.securityx.web.api.WebApiJsonFactory.newJWTPayload()",
//                        "			.setSub(userFound.get().getUsername())",
//                        "			.getJsonObject(),",
//                        "		new JWTOptions()",
//                        "			.setAlgorithm(\"RS256\")",
//                        "			.setExpiresInMinutes(deploymentOptions.getJwt().getExpiresInMinutes())",
//                        "			.setSubject(userFound.get().getUsername()));",
//                        "",
//                        "log.info(\"login user token \" + userFound.get().getToken());",
//                        "",
//                        "",
//                        "final com.securityx.web.api.UserSession userSession = com.securityx.web.api.WebApiJsonFactory.newUserSession()",
//                        "		.setToken(token)",
//                        "		.setUsername(userFound.get().getUsername());",
//                        "sessionMap.put(token, userSession);",
//                        "",
//                        "sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));"
//                  }))
//            .addHandlers(VertxST.newRouteHandler()
//                  .setName("logout")
//                  .setStatements(new Object[]{
//                        "final com.securityx.web.api.LogoutRequest request = com.securityx.web.api.WebApiJsonFactory.newLogoutRequest(routingContext.getBodyAsJson());",
//                        "		sessionMap.remove(request.getUsername());",
//                        "		sendResponse(routingContext, OK, new JsonObject());"
//                  }))
//            .addHandlers(VertxST.newRouteHandler()
//                  .setName("getUser")
//                  .setStatements(new Object[]{
//                        "final String authorization = routingContext.request().getHeader(\"Authorization\");",
//                        "final String token = authorization == null ? null : authorization.substring(7).trim();",
//                        "",
//                        "final com.securityx.web.api.UserSession userSession = sessionMap.get(token);",
//                        "",
//                        "if (userSession == null) {",
//                        "	sendErrors(routingContext, BAD_REQUEST, \"User session not found\");",
//                        "	return;",
//                        "}",
//                        "",
//                        "final Optional<com.securityx.web.domain.UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()",
//                        "		.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(userSession.getUsername()))",
//                        "		.findFirst();",
//                        "",
//                        "if (!userFound.isPresent()) {",
//                        "	sendErrors(routingContext, BAD_REQUEST, \"User session not found\");",
//                        "	return;",
//                        "}",
//                        "",
//                        "setUserMenus(userFound.get(), userSession);",
//                        "",
//                        "sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));"
//                  }))
//            .addMethods(JavaPatterns.newPrivateMethodDeclaration("setUserMenus")
//                  .addParameters(JavaPatterns.newParameter("com.securityx.web.domain.UserDeploymentSettings", "settings"))
//                  .addParameters(JavaPatterns.newParameter("com.securityx.web.api.UserSession", "session"))
//                  .setBlockStmt(JavaPatterns.newBlockStmt(new Object[] {
//                        "if (session.getMenus().count() != 0L) return;",
//                        "",
//                        "final AtomicInteger key = new AtomicInteger(0);",
//                        "",
//                        "session.addMenus(com.securityx.web.api.WebApiJsonFactory.newUserMenu()",
//                        "		.setLabel(\"Status\")",
//                        "		.setUrl(\"/status\")",
//                        "		.setKey(key.incrementAndGet()));",
//                        "session.addMenus(com.securityx.web.api.WebApiJsonFactory.newUserMenu()",
//                        "		.setLabel(\"Video\")",
//                        "		.setUrl(\"/video\")",
//                        "		.setKey(key.incrementAndGet()));",
//                        "settings.getAccess().forEach(userAccess -> session.addMenus(com.securityx.web.api.WebApiJsonFactory.newUserMenu().setKey(key.incrementAndGet()).setUrl(userAccess.getUrl()).setLabel(userAccess.getLabel())));"
//                  }))
//            );
//   }
//
//   public Entity generateServerDeploymentOptions() {
//
//      final Entity serverDeploymentOptions = newEntity("ServerDeploymentOptions")
//            .addRelations(newStringField("name", true))
//            .addRelations(newStringField("tcpHost"))
//            .addRelations(newStringField("tcpName"))
//            .addRelations(newIntegerField("port"))
//            .addRelations(newStringField("webRoot"))
//            .addRelations(newStringField("dbPath"))
//            .addRelations(newOneToMany("verticles", newEntity("VerticleDeploymentSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newStringField("className"))))
//            .addRelations(newOneToOne("botSettings", newEntity("BotDeploymentSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newStringField("botToken"))
//                  .addRelations(newBooleanField("start"))))
//            .addRelations(newOneToOne("ssl", newEntity("SSLDeploymentSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newStringField("key"))
//                  .addRelations(newStringField("cert"))))
//            .addRelations(newOneToOne("jwt", newEntity("JWTDeploymentSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newIntegerField("expiresInMinutes"))
//                  .addRelations(newOneToMany("users", newEntity("UserDeploymentSettings")
//                        .addRelations(newStringField("username", true))
//                        .addRelations(newStringField("token"))
//                        .addRelations(newStringField("password"))
//                        .addRelations(newStringField("salt"))
//                        .addRelations(newOneToMany("access", newEntity("UserAccess")
//                              .addRelations(newIntegerField("key"))
//                              .addRelations(newStringField("url"))
//                              .addRelations(newStringField("label"))))))));
//
//      writeJsonWrapper(mainJava, webDomainPackage, newDomain("Server")
//            .addEntities(serverDeploymentOptions));
//
//      return serverDeploymentOptions;
//   }
//
//   private Object storeProp(BackendStore store, Observable observable) {
//      return "this.props." + lowFirst(store.getName()) + "." + observable.getName();
//   }
//
//   private FunctionCall load(BackendStore store, BackendAction action) {
//      return JavaScriptPatterns.newFunctionCall(lowFirst(store.getName()) + "." + action.getName())
//            .setScope("this.props");
//   }
//
//   public BackendAction newBackendAction(AgentDeclaration agentDeclaration, Observable observable, String endpointMethod) {
//      return MobXPatterns.newBackendAction()
//            .setObservable(observable.getName())
//            .setName("load" + capitalize(observable.getName()))
//            .setEndpoint(agentDeclaration.getName())
//            .setMethod(endpointMethod);
//   }
//
//   /**
//    * generateServer
//    */
//   @org.junit.Test
//   public void generateServer() {
//
//      STGenerator.writeJavaFile(JavaPatterns.newPasswordUtils()
//            .setName("PasswordUtils")
//            .setPackageName(utilsPackage.getName()), utilsPackage, "PasswordUtils", mainJava);
//
//      STGenerator.writeToFile(Log4JPatterns.newProperties()
//            .setLogLevel("INFO")
//            .setRootAppender("stdout")
//            .addAppenders(Log4JPatterns.newConsoleAppender()
//                  .setName("stdout")
//                  .setThreshold("INFO")), "", "log4j", "properties", mainResources);
//
//
//      final Entity serverSettings = newEntity("ServerSettings")
//            .addRelations(newStringField("name", true))
//            .addRelations(newOneToOne("webVerticle", newEntity("WebVerticleSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newStringField("tcpHost"))
//                  .addRelations(newStringField("tcpName"))
//                  .addRelations(newIntegerField("port"))
//                  .addRelations(newStringField("webRoot"))
//                  .addRelations(newOneToOne("ssl", newEntity("SSLSettings")
//                        .addRelations(newStringField("name", true))
//                        .addRelations(newStringField("key"))
//                        .addRelations(newStringField("cert"))))
//                  .addRelations(newOneToOne("jwt", newEntity("JWTSettings")
//                        .addRelations(newStringField("name", true))
//                        .addRelations(newStringField("path"))
//                        .addRelations(newStringField("password"))
//                        .addRelations(newStringField("type"))
//                        .addRelations(newIntegerField("expiresInMinutes"))
//                        .addRelations(newOneToMany("users", newEntity("UserSettings")
//                              .addRelations(newStringField("username", true))
//                              .addRelations(newStringField("password"))
//                              .addRelations(newStringField("salt"))
//                              .addRelations(newOneToMany("access", newEntity("WebPageAccessSettings")
//                                    .addRelations(newStringField("url"))
//                                    .addRelations(newStringField("label"))))))))))
//            .addRelations(newOneToOne("dbVerticle", newEntity("NeoDomainVerticleSettings")
//                  .addRelations(newStringField("name", true))
//                  .addRelations(newStringField("path"))
//                  .addRelations(newStringField("address"))));
//
//      writeNeo(mainJava, webDomainPackage, newDomain("Server")
//            .addEntities(serverSettings));
//   }
//
//   /**
//    * generateWebApi
//    */
//   @org.junit.Test
//   public void generateWebApi() {
//      writeJsonWrapper(mainJava, webApiPackage, newDomain("WebApi")
//            .addEntities(newEntity("Response")
//                  .addRelations(newEnumField("status", newEnum("ResponseStatus", "FAIL,SUCCESS")))
//                  .addRelations(newEnumField("payloadType", newEnum("PayloadType", "STRING,JSONOBJECT,JSONARRAY")))
//                  .addRelations(newOneToOneExternal("payload", Object.class)))
//            .addEntities(newEntity("LoginRequest")
//                  .addRelations(newStringField("username"))
//                  .addRelations(newStringField("password")))
//            .addEntities(newEntity("LogoutRequest")
//                  .addRelations(newStringField("username")))
//            .addEntities(newEntity("JWTPayload")
//                  .addRelations(newStringField("sub")))
//            .addEntities(newEntity("UserSession")
//                  .addRelations(newStringField("token"))
//                  .addRelations(newStringField("username"))
//                  .addRelations(newOneToMany("menus", newEntity("UserMenu")
//                        .addRelations(newIntegerField("key"))
//                        .addRelations(newStringField("url"))
//                        .addRelations(newStringField("label"))))));
//   }
//
//   private MaterialUIComponent statusCard() {
//      return addComponent("StatusCard", componentMap)
//            .addImports("{ Link as RouterLink }", "react-router-dom")
//            .addComponentImports(newGridImport())
//            .addComponentImports(newPaperImport())
//            .addComponentImports(newLinkImport())
//            .addComponentImports(newButtonImport())
//            .addComponentImports(newTypographyImport())
//            .addStyleClasses(newStyleClass("paper")
//                  .addAttributes("height", 190)
//                  .addAttributes("width", 120)
//                  .addAttributes("padding", "theme.spacing(2)")
//                  .addAttributes("textAlign", "'center'")
//                  .addAttributes("color", "theme.palette.text.secondary"))
//            .addConst("{ site }", "props")
//            .addConst("SiteLink", JavaScriptPatterns.newForwardRef()
//                  .setTo(JavaScriptPatterns.newJsonObject("'/site/' + site.id")))
//            .setRenderElement(newGridElement()
//                  .setItem(true)
//                  .setXs(JavaScriptPatterns.newJsonObject("1"))
//                  .addChildren(newPaperElement()
//                        .setClassName(styleClass("paper"))
//                        .addChildren(newTypographyElement()
//                              .setVariant("h6")
//                              .addChildren(JavaScriptPatterns.newJsonObject("site.name")))
//                        .addChildren(newTypographyElement()
//                              .setVariant("subtitle2")
//                              .addChildren("Cameras : {site.cameras}"))
//                        .addChildren(newButtonElement()
//                              .setColor("primary")
//                              .setComponent(JavaScriptPatterns.newJsonObject("SiteLink"))
//                              .addAttribute("id", JavaScriptPatterns.newJsonObject("site.id"))
//                              .addChildren("Show"))));
//   }
//
//   private MaterialUIComponent statusComponent(MaterialUIComponent statusCard) {
//      return addComponent("Status", componentMap)
//            .addComponentImports(newGridImport())
//            .addComponentImports(newTypographyImport())
//            .addComponentImports(newDividerImport())
//            .addImports(statusCard.getName(), pageComponentPath(statusCard))
//            .addStyleClasses(newStyleClass("root")
//                  .addAttributes("flexGrow", "1")
//                  .addAttributes("padding", "20"))
//            .addStyleClasses(newStyleClass("innerGrid")
//                  .addAttributes("flexGrow", "1")
//                  .addAttributes("padding", "10"))
//            .addStyleClasses(newStyleClass("header")
//                  .addAttributes("color", "theme.palette.text.secondary")
//                  .addAttributes("textAlign", "'left'"))
//            .setRenderElement(newGridElement()
//                  .setContainer(true)
//                  .setClassName(styleClass("root"))
//                  .setJustify("flex-start")
//                  .setSpacing(JavaScriptPatterns.newJsonObject("3"))
//                  .addChildren(newGridElement()
//                        .setItem(true)
//                        .setXs(JavaScriptPatterns.newJsonObject("12"))
//                        .addChildren(newTypographyElement()
//                              .setClassName(styleClass("header"))
//                              .setVariant("h4")
//                              .addChildren("Sites")))
//                  .addChildren(newGridElement()
//                        .setXs(JavaScriptPatterns.newJsonObject("12"))
//                        .addChildren(newDividerElement()))
//                  .addChildren(newGridElement()
//                        .setContainer(true)
//                        .setXs(JavaScriptPatterns.newJsonObject("12"))
//                        .setClassName(styleClass("innerGrid"))
//                        .setJustify("flex-start")
//                        .setSpacing(JavaScriptPatterns.newJsonObject("2"))
//                        .addChildren(JavaScriptPatterns.newMapProperty()
//                              .setProperty("data.sites")
//                              .setForEach(newGridElement()
//                                    .setItem(true)
//                                    .setXs(JavaScriptPatterns.newJsonObject("1"))
//                                    .setKey("{ i }")
//                                    .addChildren(asElement(statusCard)
//                                          .addAttributes("site", "{ element }"))
//                              )))
//            );
//   }
//
//   private ClassComponent statusPage(nextgen.templates.mobx.IStore store, MaterialUIComponent status) {
//      return addPage("StatusPage", pageMap)
//            .addImports(status.getName(), pageComponentPath(status))
//            .addImports(loading.getName(), pageComponentPath(loading))
//            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(getName(store)))))
//            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
//            .setRenderFalse(asElement(loading));
//   }
//
//   private MaterialUIComponent siteComponent(MaterialUIComponent cameraLocationCard) {
//      return addComponent("Site", componentMap)
//            .addComponentImports(newGridImport())
//            .addComponentImports(newTypographyImport())
//            .addComponentImports(newDividerImport())
//            .addImports(cameraLocationCard.getName(), pageComponentPath(cameraLocationCard))
//            .addStyleClasses(newStyleClass("root")
//                  .addAttributes("flexGrow", "1")
//                  .addAttributes("padding", "20"))
//            .addStyleClasses(newStyleClass("innerGrid")
//                  .addAttributes("flexGrow", "1")
//                  .addAttributes("padding", "10"))
//            .addStyleClasses(newStyleClass("header")
//                  .addAttributes("color", "theme.palette.text.secondary")
//                  .addAttributes("textAlign", "'left'"))
//            .setRenderElement(newGridElement()
//                  .setContainer(true)
//                  .setClassName(styleClass("root"))
//                  .setJustify("flex-start")
//                  .setSpacing(JavaScriptPatterns.newJsonObject("3"))
//                  .addChildren(newGridElement()
//                        .setItem(true)
//                        .setXs(JavaScriptPatterns.newJsonObject("12"))
//                        .addChildren(newTypographyElement()
//                              .setClassName(styleClass("header"))
//                              .setVariant("h4")
//                              .addChildren(newJsonObject().addValues("data.name"))))
//                  .addChildren(newGridElement()
//                        .setXs(JavaScriptPatterns.newJsonObject("12"))
//                        .addChildren(newDividerElement()))
//                  .addChildren(newGridElement()
//                        .setContainer(true)
//                        .setClassName(styleClass("innerGrid"))
//                        .setJustify("flex-start")
//                        .setSpacing(JavaScriptPatterns.newJsonObject("2"))
//                        .addChildren(JavaScriptPatterns.newMapProperty()
//                              .setProperty("data.cameraLocations")
//                              .setForEach(newGridElement()
//                                    .setItem(true)
//                                    .setKey("{ i }")
//                                    .addChildren(asElement(cameraLocationCard)
//                                          .addAttributes("cameraLocation", "{ element }"))
//                              )))
//            );
//   }
//
//   private ClassComponent sitePage(nextgen.templates.mobx.IStore store, MaterialUIComponent site) {
//      return addPage("SitePage", pageMap)
//            .addImports(site.getName(), pageComponentPath(site))
//            .addImports(loading.getName(), pageComponentPath(loading))
//            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(getName(store)))))
//            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
//            .setRenderFalse(asElement(loading));
//   }
//
//   private MaterialUIComponent cameraIncidentRow() {
//      return addComponent("CameraIncidentRow", componentMap)
//            .addComponentImports(MaterialUIPatterns.newTableRowImport())
//            .addComponentImports(MaterialUIPatterns.newTableCellImport())
//            .addImports("{ Link as RouterLink }", "react-router-dom")
//            .addComponentImports(MaterialUIPatterns.newButtonImport())
//            .addConst(JavaScriptPatterns.newJsonObject("created", "startTime", "endTime", "cause", "status", "feedUuid"), "props.incident")
//            .addConst("FeedLink", JavaScriptPatterns.newForwardRef()
//                  .setTo(JavaScriptPatterns.newJsonObject("'/cameraFeed/' + feedUuid")))
//            .setRenderElement(MaterialUIPatterns.newTableRowElement()
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(JavaScriptPatterns.newJsonObject("created")))
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(JavaScriptPatterns.newJsonObject("startTime")))
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(JavaScriptPatterns.newJsonObject("endTime")))
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(JavaScriptPatterns.newJsonObject("cause")))
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(JavaScriptPatterns.newJsonObject("status")))
//                  .addChildren(MaterialUIPatterns.newTableCellElement()
//                        .addChildren(newButtonElement()
//                              .setColor("secondary")
//                              .setComponent(JavaScriptPatterns.newJsonObject("FeedLink"))
//                              .addChildren("Feed")))
//            );
//   }
//
//   private MaterialUIComponent cameraIncidentTable(MaterialUIComponent incidentRow) {
//      return addComponent("CameraIncidentTable", componentMap)
//            .addComponentImports(MaterialUIPatterns.newPaperImport())
//            .addComponentImports(MaterialUIPatterns.newTypographyImport())
//            .addComponentImports(MaterialUIPatterns.newTableImport())
//            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
//            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
//            .addComponentImports(MaterialUIPatterns.newTableRowImport())
//            .addComponentImports(MaterialUIPatterns.newTableCellImport())
//            .addImports(incidentRow.getName(), pageComponentPath(incidentRow))
//            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
//                  .addAttributes("padding", "theme.spacing(3, 2)"))
//            .addStyleClasses(newStyleClass("header")
//                  .addAttributes("color", "theme.palette.text.secondary")
//                  .addAttributes("textAlign", "'left'"))
//            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
//                  .addAttributes("width", sq("100%"))
//                  .addAttributes("height", sq("100%")))
//            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
//                  .addAttributes("minWidth", sq("650")))
//            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
//                  .addAttributes("fontWeight", sq("bold")))
//            .addStyleClasses(MaterialUIPatterns.newStyleClass("unchanged")
//                  .addAttributes("color", sq("black"))
//                  .addAttributes("fontWeight", sq("plain")))
//            .addConst(JavaScriptPatterns.newJsonObject("camera", "incidents"), "props.data")
//            .setRenderElement(JavaScriptPatterns.newDiv()
//                  .setClassName(MaterialUIPatterns.styleClass("root"))
//                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
//                        .addChildren(MaterialUIPatterns.newTypographyElement()
//                              .setClassName(styleClass("header"))
//                              .setVariant("h4")
//                              .addChildren(JavaScriptPatterns.newJsonObject("camera.name")))
//                        .addChildren(MaterialUIPatterns.newTableElement()
//                              .addChildren(MaterialUIPatterns.newTableHeadElement()
//                                    .addChildren(MaterialUIPatterns.newTableRowElement()
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(1))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("Created"))
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(2))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("Start Time"))
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(3))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("End Time"))
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(4))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("Description"))
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(5))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("Status"))
//                                          .addChildren(MaterialUIPatterns.newTableCellElement()
//                                                .setKey(dq(6))
//                                                .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
//                                                .addChildren("Link"))
//                                    ))
//                              .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newConditional()
//                                    .setCondition("incidents")
//                                    .setThen(MaterialUIPatterns.newTableBodyElement()
//                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
//                                                .setScope("incidents")
//                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", asElement(incidentRow)
//                                                      .addAttributes("key", JavaScriptPatterns.newJsonObject("i"))
//                                                      .addAttributes("incident", JavaScriptPatterns.newJsonObject("e"))
//                                                )))))
//                                    .setOtherwise("null")))
//                        )));
//   }
//
//   private ClassComponent cameraIncidentPage(BackendStore store, MaterialUIComponent cameraIncidentTable) {
//      return addPage("CameraIncidentPage", pageMap)
//            .addImports(cameraIncidentTable.getName(), pageComponentPath(cameraIncidentTable))
//            .addImports(loading.getName(), pageComponentPath(loading))
//            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(getName(store)))))
//            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
//            .setRenderFalse(asElement(loading));
//   }
//
//   private MaterialUIComponent cameraLocationCard() {
//      return addComponent("CameraLocationCard", componentMap)
//            .addImports("{ Link as RouterLink }", "react-router-dom")
//            .addComponentImports(newGridImport())
//            .addComponentImports(newPaperImport())
//            .addComponentImports(newLinkImport())
//            .addComponentImports(newButtonImport())
//            .addComponentImports(newTypographyImport())
//            .addStyleClasses(newStyleClass("paper")
//                  .addAttributes("height", 290)
//                  .addAttributes("width", 120)
//                  .addAttributes("padding", "theme.spacing(2)")
//                  .addAttributes("textAlign", "'center'")
//                  .addAttributes("color", "theme.palette.text.secondary"))
//            .setRenderElement(newGridElement()
//                  .setItem(true)
//                  .addChildren(newPaperElement()
//                        .setClassName(styleClass("paper"))
//                        .addChildren(newTypographyElement()
//                              .setVariant("h6")
//                              .addChildren(JavaScriptPatterns.newJsonObject("cameraLocation.name")))
//                        .addChildren(newButtonElement()
//                              .setColor("secondary")
//                              .setComponent(JavaScriptPatterns.newJsonObject("LiveLink"))
//                              .addAttribute("id", JavaScriptPatterns.newJsonObject("cameraLocation.id"))
//                              .addChildren("LIVE"))
//                        .addChildren(newButtonElement()
//                              .setColor("primary")
//                              .setComponent(JavaScriptPatterns.newJsonObject("EventsLink"))
//                              .addAttribute("id", JavaScriptPatterns.newJsonObject("cameraLocation.id"))
//                              .addChildren("Events (" + JavaScriptPatterns.newJsonObject("cameraLocation.incidents") + ")"))
//                        .addChildren(newButtonElement()
//                              .setColor("primary")
//                              .setComponent(JavaScriptPatterns.newJsonObject("SettingsLink"))
//                              .addAttribute("id", JavaScriptPatterns.newJsonObject("cameraLocation.id"))
//                              .addChildren("Settings"))));
//   }
//
//   private ClassComponent cameraFeedPage(MaterialUIComponent videoComponent) {
//      return addPage("CameraFeedPage", pageMap)
//            .addImports(videoComponent.getName(), "../components/" + videoComponent.getName())
//            .addFields("source")
//            .addConstructorStatements("this.source = this.props.match.params.id;")
//            .setRenderElement(newElement()
//                  .setName(videoComponent.getName())
//                  .addAttributes("src", JavaScriptPatterns.newJsonObject("this.source")));
//   }
//
//   private MaterialUIComponent cameraFeedComponent() {
//      return addComponent("CameraFeed", componentMap)
//            .addImports(JavaScriptPatterns.newJsonObject("Player"), "video-react")
//            .setRenderElement(newElement()
//                  .setName("Player")
//                  .addSingleAttributes("playsInline")
//                  .addAttributes("src", JavaScriptPatterns.newJsonObject(sq("/videos/") + " + " + "props.src")));
//   }
//
//   private ClassComponent cameraSettingsPage(MaterialUIComponent cameraSettingsComponent) {
//      return addPage("CameraSettingsPage", pageMap)
//            .addImports(cameraSettingsComponent.getName(), "../components/" + cameraSettingsComponent.getName())
//            .setRenderElement(newElement()
//                  .setName(cameraSettingsComponent.getName()));
//   }
//
//   private MaterialUIComponent cameraSettingsComponent() {
//      return addComponent("CameraSettings", componentMap)
//            .setRenderElement(dq("Settings"));
//   }
//
//   protected static void log(Object log) {
//      System.out.println(log);
//   }
//}