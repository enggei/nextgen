package nextgen.projects;

import nextgen.st.STGenerator;

import static nextgen.templates.MobXPatterns.getName;
import static nextgen.utils.StringUtil.*;

import nextgen.templates.*;
import nextgen.templates.JavaPatterns;
import nextgen.templates.vertx.*;

import nextgen.templates.maven.*;

import nextgen.templates.npm.*;

import nextgen.templates.javascript.*;

import nextgen.templates.materialui.*;

import nextgen.templates.domain.*;

import nextgen.templates.java.*;

import static nextgen.templates.WebappPatterns.*;

import java.util.*;
import java.io.*;

public class PettyProject {

   final File root = new File("/home/goe/projects/petty");

   final File mainJava = new File(root, "src/main/java");
   final File mainResources = new File(root, "src/main/resources");
   final File testJava = new File(root, "src/test/java");
   final File testResources = new File(root, "src/test/resources");

   final File mainWebapp = new File(root, "src/main/webapp");
   final File targetStaticResources = new File(root, "target/classes/static");

   private final nextgen.templates.java.PackageDeclaration corePackage = nextgen.templates.JavaPatterns.newPackageDeclaration("com.petty");
   private final nextgen.templates.java.PackageDeclaration exportPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage
         .getName() + "." + "export");
   private final nextgen.templates.java.PackageDeclaration exportDomain = nextgen.templates.JavaPatterns.newPackageDeclaration(exportPackage
         .getName() + "." + "domain");
   private final nextgen.templates.java.PackageDeclaration reportPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage
         .getName() + "." + "reports");
   private final nextgen.templates.java.PackageDeclaration reportDomain = nextgen.templates.JavaPatterns.newPackageDeclaration(reportPackage
         .getName() + "." + "domain");
   private final nextgen.templates.java.PackageDeclaration webPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage
         .getName() + "." + "web");
   private final nextgen.templates.java.PackageDeclaration webDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(webPackage
         .getName() + "." + "domain");
   private final nextgen.templates.java.PackageDeclaration webApiPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(webPackage
         .getName() + "." + "api");
   private final nextgen.templates.java.PackageDeclaration domainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage
         .getName() + "." + "domain");
   private final nextgen.templates.java.PackageDeclaration scanPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage
         .getName() + "." + "scan");
   private final nextgen.templates.java.PackageDeclaration rmScanPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(scanPackage
         .getName() + "." + "rm");
   private final nextgen.templates.java.PackageDeclaration rmScanDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(rmScanPackage
         .getName() + "." + "domain");
   private final nextgen.templates.java.PackageDeclaration scanDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(scanPackage
         .getName() + "." + "domain");

   final String version = "1.5";

   /**
    * generateProjectFiles
    */
   @org.junit.Test
   public void generateProjectFiles() {
      final DependencyGroup vertxGroup = MavenPatterns.newDependencyGroup()
            .setName("vertx")
            .setGroupId("io.vertx")
            .setVersion("3.8.3")
            .addArtifacts("vertx-core")
            .addArtifacts("vertx-web")
            .addArtifacts("vertx-auth-jwt")
            .addArtifacts("vertx-unit");

      String mainClass = "ServerApp";
      final Pom projectPom = MavenPatterns.newPom()
            .setName("Petty")
            .setGroupId("petty")
            .setArtifactId("analytics")
            .setVersion(version)
            .addProperties(MavenPatterns.setMavenCompilerSource("1.8"))
            .addProperties(MavenPatterns.setMavenCompilerTarget("1.8"))
            .addProperties(MavenPatterns.setProjectBuildSourceEncoding("UTF-8"))
            .addProperties(MavenPatterns.setProjectReportingOutputEncoding("UTF-8"))
            .addDependencies(MavenPatterns.newDependency()
                  .setScope(DependencyScope.Compile)
                  .setArtifactId("cdt-java-client")
                  .setGroupId("com.github.kklisura.cdt")
                  .setVersion("2.1.0"))
            .addDependencies(MavenPatterns.newDependency()
                  .setScope(DependencyScope.Compile)
                  .setArtifactId("neo4j")
                  .setGroupId("org.neo4j")
                  .setVersion("3.5.8"))
            .addDependencies(MavenPatterns.newDependency()
                  .setArtifactId("slf4j-log4j12")
                  .setGroupId("org.slf4j")
                  .setVersion("1.7.20"))
            .addDependencies(MavenPatterns.newDependency()
                  .setScope(DependencyScope.Compile)
                  .setArtifactId("jsoup")
                  .setGroupId("org.jsoup")
                  .setVersion("1.12.1"))
            .addDependencies(MavenPatterns.newDependency()
                  .setScope(DependencyScope.Compile)
                  .setArtifactId("junit")
                  .setGroupId("junit")
                  .setVersion("4.12"))
            .addDependencies(MavenPatterns.newDependency()
                  .setArtifactId("java-telegram-bot-api")
                  .setGroupId("com.github.pengrad")
                  .setVersion("4.8.0"))
            .setBuild(MavenPatterns.newBuild()
                  .addPlugin(MavenPatterns.newCopyPlugin()
                        .setDirectory(mainWebapp.getPath())
                        .setOutputDirectory(STGenerator.makeRelative(targetStaticResources, root))
                        .addInclude("favicon.ico")
                        .addInclude("index.css")
                        .addInclude("index.html")
                        .addInclude("index.js"))
                  .addPlugin(MavenPatterns.newFrontEndMavenPlugin()
                        .setInstallDirectory("target")
                        .setNodeVersion("8.9.0")
                        .setPluginVersion("1.10.0"))
                  .addPlugin(MavenPatterns.newShadePlugin()
                        .setClassName(mainClass)
                        .setPackageName(webPackage.getName())));

      MavenPatterns.addDependencyGroup(projectPom, vertxGroup);

      MavenPatterns.generate(MavenPatterns.newProject()
            .setName("Petty")
            .setRoot(root.getAbsolutePath()), projectPom);

      NpmPatterns.generate(NpmPatterns.newNpmProject()
            .setRoot(root.getAbsolutePath())
            .setPackageJson(NpmPatterns.newPackageJson()
                  .setName("petty")
                  .setVersion("1.5.0")
                  .setDescription("Petty analytics core and web")
                  .setAuthor("GOE")
                  .setLicense("ISC")
                  .setMain("index.js")
                  .addScripts(NpmPatterns.newScript().setName("deploy").setCommand("webpack --mode production"))
                  .addScripts(NpmPatterns.newScript()
                        .setName("server")
                        .setCommand("webpack-dev-server --open --mode development"))
                  .addScripts(NpmPatterns.newScript().setName("package").setCommand("webpack --mode development"))
                  .addScripts(NpmPatterns.newScript()
                        .setName("develop")
                        .setCommand("webpack --watch --progress --mode development"))
                  .addDependencies(NpmPatterns.newDependency("react", "16.9.0"))
                  .addDependencies(NpmPatterns.newDependency("react-dom", "16.9.0"))
                  .addDependencies(NpmPatterns.newDependency("react-router-dom", "5.0.1"))
                  .addDependencies(NpmPatterns.newDependency("@material-ui/core", "4.4.2"))
                  .addDependencies(NpmPatterns.newDependency("@material-ui/icons", "4.4.2"))
                  .addDependencies(NpmPatterns.newDependency("@material-ui/styles", "4.4.2"))
                  .addDependencies(NpmPatterns.newDependency("material-table", "1.50.0"))
                  .addDependencies(NpmPatterns.newDependency("victory", "33.1.1"))
                  .addDependencies(NpmPatterns.newDependency("chart-race-react", "1.0.2"))
                  .addDependencies(NpmPatterns.newDependency("mobx", "5.13.0"))
                  .addDependencies(NpmPatterns.newDependency("mobx-react", "6.1.3"))
                  .addDependencies(NpmPatterns.newDependency("superagent", "5.1.0"))
                  .addDependencies(NpmPatterns.newDependency("superagent-promise", "1.1.0"))
                  .addDevDependencies(NpmPatterns.newDependency("@babel/core", "7.1.0"))
                  .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-class-properties", "7.5.5"))
                  .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-decorators", "7.6.0"))
                  .addDevDependencies(NpmPatterns.newDependency("@babel/preset-env", "7.1.0"))
                  .addDevDependencies(NpmPatterns.newDependency("@babel/preset-react", "7.0.0"))
                  .addDevDependencies(NpmPatterns.newDependency("babel-loader", "8.0.2"))
                  .addDevDependencies(NpmPatterns.newDependency("webpack", "4.19.1"))
                  .addDevDependencies(NpmPatterns.newDependency("webpack-cli", "3.1.0"))
                  .addDevDependencies(NpmPatterns.newDependency("html-webpack-plugin", "3.2.0"))
                  .addDevDependencies(NpmPatterns.newDependency("css-loader", "3.2.0"))
                  .addDevDependencies(NpmPatterns.newDependency("style-loader", "1.0.0")))
            .setWebpackConfig(NpmPatterns.newWebpackConfig()
                  .setMainEntry("/" + STGenerator.makeRelative(new File(mainWebapp, "index.js"), root))
                  .setOutputFilename(STGenerator.makeRelative(new File(targetStaticResources, "main.js"), root)))
            .setBabelrc(NpmPatterns.newBabelrc()));
   }

   /**
    * generateClient
    */
   @org.junit.Test
   public void generateClient() {

      final String appName = "PETTY Analytics";

      final Map<String, nextgen.templates.mobx.IStore> storeMap = new LinkedHashMap<>();
      final Map<String, ClassComponent> pageMap = new LinkedHashMap<>();
      final Map<String, MaterialUIComponent> componentMap = new LinkedHashMap<>();

      final IndexJS indexJS = JavaScriptPatterns.newIndexJS();
      final IndexHtml indexHtml = JavaScriptPatterns.newIndexHtml()
            .setTitle(appName);
      final IndexCSS indexCSS = JavaScriptPatterns.newIndexCSS();

      // https://in-your-saas.github.io/material-ui-theme-editor/
      final App app = JavaScriptPatterns.newApp()
            .setTheme("{\"palette\":{\"common\":{\"black\":\"#000\",\"white\":\"#fff\"},\"background\":{\"paper\":\"#fff\",\"default\":\"#fafafa\"},\"primary\":{\"light\":\"rgba(184, 233, 134, 1)\",\"main\":\"rgba(65, 117, 5, 1)\",\"dark\":\"rgba(155, 155, 155, 1)\",\"contrastText\":\"#fff\"},\"secondary\":{\"light\":\"rgba(22, 53, 216, 1)\",\"main\":\"rgba(37, 66, 216, 1)\",\"dark\":\"rgba(74, 74, 74, 1)\",\"contrastText\":\"#fff\"},\"error\":{\"light\":\"#e57373\",\"main\":\"#f44336\",\"dark\":\"#d32f2f\",\"contrastText\":\"#fff\"},\"text\":{\"primary\":\"rgba(0, 0, 0, 0.87)\",\"secondary\":\"rgba(0, 0, 0, 0.54)\",\"disabled\":\"rgba(0, 0, 0, 0.38)\",\"hint\":\"rgba(0, 0, 0, 0.38)\"}}}");

      final Superagent superagent = JavaScriptPatterns.newSuperagent();
      final AgentDeclaration authEndpoint = addEndpoint("Auth", superagent)
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("currentUser", "user", "get"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("login", "login", "post")
                  .addParameters("username")
                  .addParameters("password"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("save", "user", "put")
                  .addParameters("user"));
      final AgentDeclaration reportsEndpoint = addEndpoint("Reports", superagent)
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("trends", "api/currentTrends", "get"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("prime", "api/prime/", "get")
                  .setUrlParam("id"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("rent", "api/rent/", "get")
                  .setUrlParam("id"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("branch", "api/branch/", "get")
                  .setUrlParam("id"))
            .addAgentEndpoint(JavaScriptPatterns.newAgentEndpoint("agent", "api/agent/", "get")
                  .setUrlParam("id"));

      final nextgen.templates.mobx.Store appStore = appStore(appName, storeMap, indexJS, app);
      final nextgen.templates.mobx.Store userStore = userStore(storeMap, indexJS, app);
      final nextgen.templates.mobx.Store authStore = authStore(storeMap, indexJS, app, appStore, userStore, authEndpoint);
      final nextgen.templates.mobx.Store trendsReportStore = trendsReportStore(storeMap, indexJS, app, reportsEndpoint);
      final nextgen.templates.mobx.Store primeReportStore = primeReportStore(storeMap, indexJS, app, reportsEndpoint);
      final nextgen.templates.mobx.Store rentReportStore = rentReportStore(storeMap, indexJS, app, reportsEndpoint);
      final nextgen.templates.mobx.Store branchReportStore = branchReportStore(storeMap, indexJS, app, reportsEndpoint);
      final nextgen.templates.mobx.Store agentReportStore = agentReportStore(storeMap, indexJS, app, reportsEndpoint);

      final MaterialUIComponent copyright = copyright(componentMap, "Petty");
      final MaterialUIComponent loginMenu = loginMenu(componentMap);
      final MaterialUIComponent userMenu = userMenu(componentMap);
      final MaterialUIComponent listErrors = listErrors(componentMap);
      final MaterialUIComponent loading = loading(componentMap);
      final MaterialUIComponent navigationBar = navigationBar(componentMap, appName, userMenu, loginMenu);
      final MaterialUIComponent loginForm = loginForm(componentMap);
      final MaterialUIComponent logoutForm = logoutForm(componentMap);

      final MaterialUIComponent dashboardCard = dashboardCard(componentMap);
      final MaterialUIComponent dashboard = dashboardComponent(componentMap, dashboardCard);
      final MaterialUIComponent trends = trendsComponent(componentMap);
      final MaterialUIComponent primeReportComponent = primeReportComponent(componentMap);
      final MaterialUIComponent rentReportComponent = rentReportComponent(componentMap);
      final MaterialUIComponent branchReportComponent = branchReportComponent(componentMap);
      final MaterialUIComponent agentReportComponent = agentReportComponent(componentMap);

      final ClassComponent loginPage = loginPage(pageMap, authStore, loginForm, copyright, listErrors, "dashboard");
      final ClassComponent logoutPage = logoutPage(pageMap, authStore, logoutForm, copyright);
      final ClassComponent dashboardPage = dashboardPage(pageMap, userStore, dashboard, loading);
      final ClassComponent trendsPage = trendsPage(pageMap, trendsReportStore, trends, loading);
      final ClassComponent primePage = primePage(pageMap, primeReportStore, primeReportComponent, loading);
      final ClassComponent rentPage = rentPage(pageMap, rentReportStore, rentReportComponent, loading);
      final ClassComponent branchPage = branchPage(pageMap, branchReportStore, branchReportComponent, loading);
      final ClassComponent agentPage = agentPage(pageMap, agentReportStore, agentReportComponent, loading);
      final ClassComponent racechartPage = raceChartPage(pageMap, loading);

      app.addRoutes(loginPage.getName(), loginPage.getName(), "/login", null);
      app.addRoutes(logoutPage.getName(), logoutPage.getName(), "/logout", null);
      app.addRoutes(dashboardPage.getName(), dashboardPage.getName(), "/dashboard", null);
      app.addRoutes(trendsPage.getName(), trendsPage.getName(), "/currentTrends", null);
      app.addRoutes(primePage.getName(), primePage.getName(), "/primeReport/:id", JavaScriptPatterns.newJsonObject(JavaScriptPatterns
            .newArrowFunction("routeProps", asElement(primePage)
                  .addProps(JavaScriptPatterns.newProp("key", JavaScriptPatterns.newJsonObject("routeProps.match.params.id")))
                  .addProps(JavaScriptPatterns.newJsonObject("...routeProps")))));
      app.addRoutes(rentPage.getName(), rentPage.getName(), "/rentReport/:id", JavaScriptPatterns.newJsonObject(JavaScriptPatterns
            .newArrowFunction("routeProps", asElement(rentPage)
                  .addProps(JavaScriptPatterns.newProp("key", JavaScriptPatterns.newJsonObject("routeProps.match.params.id")))
                  .addProps(JavaScriptPatterns.newJsonObject("...routeProps")))));
      app.addRoutes(branchPage.getName(), branchPage.getName(), "/branch/:id", JavaScriptPatterns.newJsonObject(JavaScriptPatterns
            .newArrowFunction("routeProps", asElement(branchPage)
                  .addProps(JavaScriptPatterns.newProp("key", JavaScriptPatterns.newJsonObject("routeProps.match.params.id")))
                  .addProps(JavaScriptPatterns.newJsonObject("...routeProps")))));
      app.addRoutes(agentPage.getName(), agentPage.getName(), "/agentPage/:id", JavaScriptPatterns.newJsonObject(JavaScriptPatterns
            .newArrowFunction("routeProps", asElement(agentPage)
                  .addProps(JavaScriptPatterns.newProp("key", JavaScriptPatterns.newJsonObject("routeProps.match.params.id")))
                  .addProps(JavaScriptPatterns.newJsonObject("...routeProps")))));
      app.addRoutes(racechartPage.getName(), racechartPage.getName(), "/race", null);

      STGenerator.writeJsFile(indexJS, null, "index", mainWebapp);
      STGenerator.writeHtmlFile(indexHtml, null, "index", mainWebapp);
      STGenerator.writeFile(indexCSS, null, "index.css", mainWebapp);
      STGenerator.writeJsFile(app, null, "App", mainWebapp);
      STGenerator.writeFile(superagent, null, "Agent.js", mainWebapp);

      for (nextgen.templates.mobx.IStore store : storeMap.values())
         STGenerator.writeJsFile(store, "stores", getName(store), mainWebapp);
      for (ClassComponent classComponent : pageMap.values())
         STGenerator.writeJsFile(classComponent, "pages", classComponent.getName(), mainWebapp);
      for (MaterialUIComponent component : componentMap.values())
         STGenerator.writeJsFile(component, "components", component.getName(), mainWebapp);
   }

   /**
    * generateExportDomain
    */
   @org.junit.Test
   public void generateExportDomain() {
      DomainPatterns.writeJsonWrapper(mainJava, exportDomain, DomainPatterns.newDomain("Export")
            .addEntities(DomainPatterns.newEntity("AreaPostings")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newOneToMany("postings", DomainPatterns.newEntity("AreaPosting")
                        .addRelations(DomainPatterns.newLongField("id"))
                        .addRelations(DomainPatterns.newStringField("address"))
                        .addRelations(DomainPatterns.newDoubleField("lat"))
                        .addRelations(DomainPatterns.newDoubleField("lon"))
                        .addRelations(DomainPatterns.newStringField("image"))
                        .addRelations(DomainPatterns.newLongField("agent.branch.id"))
                        .addRelations(DomainPatterns.newStringField("agent.branch.displayName"))
                        .addRelations(DomainPatterns.newStringField("agent.branch.name"))
                  ))));
   }

   /**
    * generateReportDomain
    */
   @org.junit.Test
   public void generateReportDomain() {
      final Entity tableCellStyle = DomainPatterns.newEntity("TableCellStyle")
            .addRelations(DomainPatterns.newStringField("fontWeight"))
            .addRelations(DomainPatterns.newStringField("color"))
            .addRelations(DomainPatterns.newStringField("fontSize"));

      final Entity tableHeader = DomainPatterns.newEntity("TableHeader")
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newStringField("align"))
            .addRelations(DomainPatterns.newOneToOne("style", tableCellStyle));

      final Entity tableCell = DomainPatterns.newEntity("TableCell")
            .addRelations(DomainPatterns.newIntegerField("key"))
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newStringField("align"))
            .addRelations(DomainPatterns.newOneToOne("style", tableCellStyle));

      final Entity tableRow = DomainPatterns.newEntity("TableRow")
            .addRelations(DomainPatterns.newOneToMany("cells", tableCell));

      final Domain reportDomain = DomainPatterns.newDomain("Reports")
            .addEntities(DomainPatterns.newEntity("RentReport")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("date"))
                  .addRelations(DomainPatterns.newIntegerField("totalPostings"))
                  .addRelations(DomainPatterns.newIntegerField("totalAgents"))
                  .addRelations(DomainPatterns.newStringField("totalValue"))
                  .addRelations(DomainPatterns.newIntegerField("rank"))
                  .addRelations(DomainPatterns.newOneToMany("headers", tableHeader))
                  .addRelations(DomainPatterns.newOneToMany("rows", tableRow)))
            .addEntities(DomainPatterns.newEntity("BranchReport")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("date"))
                  .addRelations(DomainPatterns.newOneToMany("headers", tableHeader))
                  .addRelations(DomainPatterns.newOneToMany("rows", tableRow))
                  .addRelations(DomainPatterns.newOneToMany("listingsHeaders", tableHeader))
                  .addRelations(DomainPatterns.newOneToMany("listingsRows", tableRow)))
            .addEntities(DomainPatterns.newEntity("PrimeReport")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("date"))
                  .addRelations(DomainPatterns.newIntegerField("totalPostings"))
                  .addRelations(DomainPatterns.newIntegerField("totalAgents"))
                  .addRelations(DomainPatterns.newStringField("totalValue"))
                  .addRelations(DomainPatterns.newIntegerField("rank"))
                  .addRelations(DomainPatterns.newStringField("sectors"))
                  .addRelations(DomainPatterns.newOneToMany("headers", tableHeader))
                  .addRelations(DomainPatterns.newOneToMany("rows", tableRow)))
            .addEntities(DomainPatterns.newEntity("TrendsReport")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("date"))
                  .addRelations(DomainPatterns.newOneToMany("headers", tableHeader))
                  .addRelations(DomainPatterns.newOneToMany("rows", tableRow)));

      DomainPatterns.writeJsonWrapper(mainJava, this.reportDomain, reportDomain);
   }

   /**
    * generateNeoDomain
    */
   @org.junit.Test
   public void generateNeoDomain() {
      final Entity branch = DomainPatterns.newEntity("Branch")
            .addRelations(DomainPatterns.newLongField("id"))
            .addRelations(DomainPatterns.newBooleanField("isPetty"))
            .addRelations(DomainPatterns.newStringField("name", true));

      final Entity postcodeUnit = DomainPatterns.newEntity("PostcodeUnit")
            .addRelations(DomainPatterns.newStringField("name", true));

      final Entity postcodeSector = DomainPatterns.newEntity("PostcodeSector")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newOneToMany("units", postcodeUnit));

      final Entity propertyListing = DomainPatterns.newEntity("PropertyListing")
            .addRelations(DomainPatterns.newLongField("id"))
            .addRelations(DomainPatterns.newIntegerField("bedrooms"))
            .addRelations(DomainPatterns.newStringField("streetAddress"))
            .addRelations(DomainPatterns.newStringField("addedOrReduced"))
            .addRelations(DomainPatterns.newStringField("propertySubType"))
            .addRelations(DomainPatterns.newStringField("firstVisibleDate"))
            .addRelations(DomainPatterns.newStringField("propertyTypeFullDescription"))
            .addRelations(DomainPatterns.newStringField("listingUpdateReason"))
            .addRelations(DomainPatterns.newStringField("listingUpdateDate"))
            .addRelations(DomainPatterns.newStringField("image"))
            .addRelations(DomainPatterns.newDoubleField("latitude"))
            .addRelations(DomainPatterns.newDoubleField("longitude"))
            .addRelations(DomainPatterns.newIntegerField("price"))
            .addRelations(DomainPatterns.newOneToOne("branch", branch))
            .addRelations(DomainPatterns.newOneToOne("postcodeUnit", postcodeUnit));

      final Entity listingDate = DomainPatterns.newEntity("ListingDate")
            .addRelations(DomainPatterns.newStringField("date", true))
            //				.addRelations(DomainPatterns.newOneToMany("listings", propertyListing))
            .addRelations(DomainPatterns.newOneToMany("areas", DomainPatterns.newEntity("DateAreaListings")
                  .addRelations(DomainPatterns.newOneToOne("area", DomainPatterns.newEntity("Area")
                        .addRelations(DomainPatterns.newStringField("name", true))))
                  .addRelations(DomainPatterns.newOneToMany("listings", propertyListing))));

      final Domain domain = DomainPatterns.newDomain("Domain")
            .addEntities(DomainPatterns.newEntity("Agent")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newOneToMany("branches", branch)))
            .addEntities(listingDate)
            .addEntities(DomainPatterns.newEntity("Postcodes")
                  .addRelations(DomainPatterns.newStringField("country", true))
                  .addRelations(DomainPatterns.newOneToMany("areas", DomainPatterns.newEntity("PostcodeArea")
                        .addRelations(DomainPatterns.newStringField("name", true))
                        .addRelations(DomainPatterns.newOneToMany("districts", DomainPatterns.newEntity("PostcodeDistrict")
                              .addRelations(DomainPatterns.newStringField("name", true))
                              .addRelations(DomainPatterns.newOneToMany("sectors", postcodeSector)))))))
            .addEntities(DomainPatterns.newEntity("ReportArea")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newOneToMany("reportSectors", postcodeSector)));

      DomainPatterns.writeNeo(mainJava, domainPackage.getName(), domain);
   }

   /**
    * generateScanDomain
    */
   @org.junit.Test
   public void generateScanDomain() {
      DomainPatterns.writePojo(mainJava, scanDomainPackage, DomainPatterns.newDomain("Scan")
            .addEntities(DomainPatterns.newEntity("ScanRoot")
                  .addRelations(DomainPatterns.newStringField("path", true))
                  .addRelations(DomainPatterns.newOneToMany("dates", DomainPatterns.newEntity("ScanDate")
                        .addRelations(DomainPatterns.newStringField("date", true))
                        .addRelations(DomainPatterns.newStringField("csv"))
                        .addRelations(DomainPatterns.newStringField("raw"))
                        .addRelations(DomainPatterns.newStringField("parsed")))))
            .addEntities(DomainPatterns.newEntity("HtmlFileGroup")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newOneToOneExternal("properties", io.vertx.core.json.JsonArray.class))
                  .addRelations(DomainPatterns.newOneToManyExternal("htmlFiles", File.class))));

      DomainPatterns.writeJsonWrapper(mainJava, rmScanDomainPackage, DomainPatterns.newDomain("RM")
            .addEntities(DomainPatterns.newEntity("RMPageModel")
                  .addRelations(DomainPatterns.newOneToMany("properties", DomainPatterns.newEntity("RMPosting")
                        .addRelations(DomainPatterns.newLongField("id"))
                        .addRelations(DomainPatterns.newIntegerField("bedrooms"))
                        .addRelations(DomainPatterns.newStringField("displayAddress"))
                        .addRelations(DomainPatterns.newStringField("addedOrReduced"))
                        .addRelations(DomainPatterns.newStringField("propertySubType"))
                        .addRelations(DomainPatterns.newStringField("firstVisibleDate"))
                        .addRelations(DomainPatterns.newStringField("propertyTypeFullDescription"))
                        .addRelations(DomainPatterns.newOneToOne("listingUpdate", DomainPatterns.newEntity("RMListingUpdate")
                              .addRelations(DomainPatterns.newStringField("listingUpdateReason"))
                              .addRelations(DomainPatterns.newStringField("listingUpdateDate"))))
                        .addRelations(DomainPatterns.newOneToOne("location", DomainPatterns.newEntity("RMLocation")
                              .addRelations(DomainPatterns.newDoubleField("latitude"))
                              .addRelations(DomainPatterns.newDoubleField("longitude"))))
                        .addRelations(DomainPatterns.newOneToOne("price", DomainPatterns.newEntity("RMPrice")
                              .addRelations(DomainPatterns.newIntegerField("amount"))
                              .addRelations(DomainPatterns.newStringField("currencyCode"))))
                        .addRelations(DomainPatterns.newOneToOne("customer", DomainPatterns.newEntity("RMCustomer")
                              .addRelations(DomainPatterns.newLongField("branchId"))
                              .addRelations(DomainPatterns.newStringField("branchDisplayName"))
                              .addRelations(DomainPatterns.newStringField("branchName"))
                              .addRelations(DomainPatterns.newStringField("brandTradingName"))))))
                  .addRelations(DomainPatterns.newOneToOne("pagination", DomainPatterns.newEntity("RMPagination")
                        .addRelations(DomainPatterns.newStringField("total"))
                        .addRelations(DomainPatterns.newStringField("next"))
                        .addRelations(DomainPatterns.newStringField("page"))
                        .addRelations(DomainPatterns.newOneToMany("options", DomainPatterns.newEntity("RMPaginationOptions")
                              .addRelations(DomainPatterns.newStringField("value"))
                              .addRelations(DomainPatterns.newStringField("description"))))))));

      final Entity rmQuery = DomainPatterns.newEntity("RMUrl")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("path"))
            .addRelations(DomainPatterns.newStringField("preQuery"))
            .addRelations(DomainPatterns.newStringField("postQuery"));

      DomainPatterns.writeNeo(mainJava, rmScanDomainPackage, DomainPatterns.newDomain("RM")
            .addEntities(DomainPatterns.newEntity("RMConfig")
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("host"))
                  .addRelations(DomainPatterns.newStringField("protocol"))
                  .addRelations(DomainPatterns.newOneToOne("rentUrl", rmQuery))
                  .addRelations(DomainPatterns.newOneToOne("salesPostcodeUrl", rmQuery))
                  .addRelations(DomainPatterns.newOneToOne("salesBranchUrl", rmQuery))
                  .addRelations(DomainPatterns.newOneToMany("scans", DomainPatterns.newEntity("RMScan")
                        .addRelations(DomainPatterns.newStringField("name", true))
                        .addRelations(DomainPatterns.newEnumField("searchType", DomainPatterns.newEnum("RMSearchType", "RENT,SALES_POSTCODE,SALES_BRANCH")))
                        .addRelations(DomainPatterns.newStringField("locationIdentifier"))))));
   }

   /**
    * generateServer
    */
   @org.junit.Test
   public void generateServer() {
//		STGenerator.writeJavaFile(JavaPatterns.newPasswordUtils()
//						.setName("PasswordUtils")
//						.setPackageName(utilsPackage.getName()), utilsPackage, "PasswordUtils", mainJava);

      final Entity serverDeploymentOptions = DomainPatterns.newEntity("ServerDeploymentOptions")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("tcpHost"))
            .addRelations(DomainPatterns.newStringField("tcpName"))
            .addRelations(DomainPatterns.newIntegerField("port"))
            .addRelations(DomainPatterns.newStringField("webRoot"))
            .addRelations(DomainPatterns.newOneToMany("verticles", DomainPatterns.newEntity("VerticleDeploymentSettings")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newStringField("className"))))
            .addRelations(DomainPatterns.newOneToOne("botSettings", DomainPatterns.newEntity("BotDeploymentSettings")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newStringField("botToken"))
                  .addRelations(DomainPatterns.newBooleanField("start"))))
            .addRelations(DomainPatterns.newOneToOne("ssl", DomainPatterns.newEntity("SSLDeploymentSettings")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newStringField("key"))
                  .addRelations(DomainPatterns.newStringField("cert"))))
            .addRelations(DomainPatterns.newOneToOne("jwt", DomainPatterns.newEntity("JWTDeploymentSettings")
                  .addRelations(DomainPatterns.newStringField("name", true))
                  .addRelations(DomainPatterns.newIntegerField("expiresInMinutes"))
                  .addRelations(DomainPatterns.newOneToMany("users", DomainPatterns.newEntity("UserDeploymentSettings")
                        .addRelations(DomainPatterns.newStringField("username", true))
                        .addRelations(DomainPatterns.newStringField("token"))
                        .addRelations(DomainPatterns.newStringField("password"))
                        .addRelations(DomainPatterns.newStringField("salt"))
                        .addRelations(DomainPatterns.newOneToMany("access", DomainPatterns.newEntity("UserAccess")
                              .addRelations(DomainPatterns.newIntegerField("key"))
                              .addRelations(DomainPatterns.newStringField("url"))
                              .addRelations(DomainPatterns.newStringField("label"))))))));

      STGenerator.writeJavaFile(VertxPatterns.newServer()
            .setPackageName(webPackage.getName())
            .addImports(JavaPatterns.newImportDeclaration(webDomainPackage.getName()).setIsAsterisk(true))
            .setName("ServerApp")
            .addStartStatements("java.util.Optional.ofNullable(serverDeployment.getBotSettings())\n" +
                  "		.ifPresent(botDeploymentSettings -> {\n" +
                  "				if (botDeploymentSettings.getStart(false)) new com.petty.telegram.PettyBot(botDeploymentSettings);\n" +
                  "			});"), webPackage, "ServerApp", mainJava);

      WebVerticle webVerticle = VertxST.newWebVerticle()
            .setPackageName("com.petty.web")
            .addImports(JavaPatterns.newImportDeclaration(webApiPackage.getName()).setIsAsterisk(true))
            .addImports(JavaPatterns.newImportDeclaration(webDomainPackage.getName()).setIsAsterisk(true))
//				.addImports(JavaPatterns.newImportDeclaration(utilsPackage.getName()).setIsAsterisk(true))
            .setName("WebVerticle")
            .addFields("ServerDeploymentOptions", "deploymentOptions", null)
            .addFields("java.util.Map<String, UserSession>", "sessionMap", "new java.util.concurrent.ConcurrentHashMap<>()")
            .addStartStatements("deploymentOptions = new ServerDeploymentOptions(config());\n" +
                  "final Optional<SSLDeploymentSettings> ssl = Optional.ofNullable(deploymentOptions.getSsl());\n" +
                  "\n" +
                  "final JWTAuth auth = JWTAuth.create(vertx, new JWTAuthOptions()\n" +
                  "		.addPubSecKey(new io.vertx.ext.auth.PubSecKeyOptions()\n" +
                  "				.setAlgorithm(\"RS256\")\n" +
                  "				.setPublicKey(\"" + loadSecurityKey(new File(root, "realProperty_public_jwt.pem")) + "\")\n" +
                  "				.setSecretKey(\"" + loadSecurityKey(new File(root, "realProperty_jwt.pem")) + "\")\n" +
                  "		));")
            .addRoutes("post", "login", "routingContext -> login(routingContext, auth)")
            .addRoutes("route", "api/*", "JWTAuthHandler.create(auth, \"/login\")")
            .addRoutes("get", "user", "this::getUser")
            .addRoutes("get", "images/:name", "this::getImage")
            .addRoutes("get", "api/currentTrends", "this::onCurrentTrends")
            .addRoutes("get", "api/prime/:id", "this::getPrime")
            .addRoutes("get", "api/rent/:id", "this::getRent")
            .addRoutes("get", "api/branch/:id", "this::getBranch")
            .addRoutes("get", "api/agent/:id", "this::getAgent")
            .addRoutes("get", "report/current", "this::getReport")
            .addHandlers(VertxST.newRouteHandler()
                  .setName("login")
                  .addParams("JWTAuth", "auth")
                  .addStatements("final LoginRequest loginRequest = WebApiJsonFactory.newLoginRequest(routingContext.getBodyAsJson());\n" +
                        "\n" +
                        "final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" +
                        "		.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(loginRequest.getUsername()))\n" +
                        "		.findFirst();\n" +
                        "\n" +
                        "if (!userFound.isPresent()) {\n" +
                        "	WebUtils.sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");\n" +
                        "	return;\n" +
                        "}\n" +
                        "\n" +
                        "final boolean passwordMatch = PasswordUtils.verifyUserPassword(loginRequest.getPassword(), userFound.get().getPassword(), userFound.get().getSalt());\n" +
                        "if (!passwordMatch) {\n" +
                        "	WebUtils.sendErrors(routingContext, BAD_REQUEST, \"User credentials not found\");\n" +
                        "	return;\n" +
                        "}\n" +
                        "\n" +
                        "final String token = auth.generateToken(\n" +
                        "		WebApiJsonFactory.newJWTPayload()\n" +
                        "			.setSub(userFound.get().getUsername())\n" +
                        "			.getJsonObject(),\n" +
                        "		new JWTOptions()\n" +
                        "			.setAlgorithm(\"RS256\")\n" +
                        "			.setExpiresInMinutes(deploymentOptions.getJwt().getExpiresInMinutes())\n" +
                        "			.setSubject(userFound.get().getUsername()));\n" +
                        "\n" +
                        "log.info(\"login user token \" + userFound.get().getToken());\n" +
                        "\n" +
                        "\n" +
                        "final UserSession userSession = WebApiJsonFactory.newUserSession()\n" +
                        "		.setToken(token)\n" +
                        "		.setUsername(userFound.get().getUsername());\n" +
                        "sessionMap.put(token, userSession);\n" +
                        "\n" +
                        "WebUtils.sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("getUser")
                  .addStatements("final String authorization = routingContext.request().getHeader(\"Authorization\");\n" +
                        "final String token = authorization == null ? null : authorization.substring(7).trim();\n" +
                        "\n" +
                        "final UserSession userSession = sessionMap.get(token);\n" +
                        "\n" +
                        "if (userSession == null) {\n" +
                        "	WebUtils.sendErrors(routingContext, BAD_REQUEST, \"User session not found\");\n" +
                        "	return;\n" +
                        "}\n" +
                        "\n" +
                        "final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" +
                        "		.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(userSession.getUsername()))\n" +
                        "		.findFirst();\n" +
                        "\n" +
                        "if (!userFound.isPresent()) {\n" +
                        "	WebUtils.sendErrors(routingContext, BAD_REQUEST, \"User session not found\");\n" +
                        "	return;\n" +
                        "}\n" +
                        "\n" +
                        "setUserMenus(userFound.get(), userSession);\n" +
                        "\n" +
                        "WebUtils.sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));"))
            .addHandlers(VertxST.newRouteHandler().setName("getImage").addStatements("routingContext.response()\n" +
                  "		.putHeader(\"Content-Type\", \"image/jpg\")\n" +
                  "		.sendFile(new File(\".\", routingContext.pathParam(\"name\")).getAbsolutePath());"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("getPrime")
                  .addStatements("final String id = routingContext.request().getParam(\"id\");\n" +
                        "log.info(\"handle getPrime \" + id);\n" +
                        "\n" +
                        "WebUtils.sendJsonFile(routingContext, \"./data/prime_\" + id + \".json\");"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("getRent")
                  .addStatements("final String id = routingContext.request().getParam(\"id\");\n" +
                        "log.info(\"handle getRent \" + id);\n" +
                        "\n" +
                        "WebUtils.sendJsonFile(routingContext, \"./data/rent_\" + id + \".json\");"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("getBranch")
                  .addStatements("final String id = routingContext.request().getParam(\"id\");\n" +
                        "log.info(\"handle getBranch \" + id);\n" +
                        "\n" +
                        "WebUtils.sendJsonFile(routingContext, \"./data/branch_\" + id + \".json\");"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("getAgent")
                  .addStatements("final String id = routingContext.request().getParam(\"id\");\n" +
                        "log.info(\"handle getAgent \" + id);\n" +
                        "\n" +
                        "WebUtils.sendJsonFile(routingContext, \"./data/agent_\" + id + \".json\");"))
            .addHandlers(VertxST.newRouteHandler()
                  .setName("onCurrentTrends")
                  .addStatements("log.info(\"handle onCurrentTrends\");\n" +
                        "WebUtils.sendJsonFile(routingContext, \"./data/currentTrends.json\");"))
            .addHandlers(VertxST.newRouteHandler().setName("getReport").addStatements("routingContext.response()\n" +
                  "		.putHeader(\"Content-Type\", \"application/pdf\")\n" +
                  "		.setStatusCode(HttpResponseStatus.OK.code())\n" +
                  "		.sendFile(\"./data/report.pdf\");"))
            .addMethods("private void setUserMenus(UserDeploymentSettings settings, UserSession session) {\n" +
                  "\n" +
                  "	if (session.getMenus().count() != 0L) return;\n" +
                  "\n" +
                  "	final AtomicInteger key = new AtomicInteger(0);\n" +
                  "\n" +
                  "	session.addMenus(WebApiJsonFactory.newUserMenu()\n" +
                  "			.setLabel(\"Trends\")\n" +
                  "			.setUrl(\"/currentTrends\")\n" +
                  "			.setKey(key.incrementAndGet()));\n" +
                  "\n" +
                  "	for (String prime : new String[]{\n" +
                  "			\"Barnoldswick\",\n" +
                  "			\"Barrowford\",\n" +
                  "			\"Burnley\",\n" +
                  "			\"Buxton\",\n" +
                  "			\"Chester\",\n" +
                  "			\"Clitheroe\",\n" +
                  "			\"Colne\",\n" +
                  "			\"Crewe\",\n" +
                  "			\"Knutsford\",\n" +
                  "			\"Nantwich\",\n" +
                  "			\"Northwich\",\n" +
                  "			\"Skipton\",\n" +
                  "			\"Tarporley\"}) {\n" +
                  "		session.addMenus(WebApiJsonFactory.newUserMenu()\n" +
                  "				.setLabel(\"Prime \" + prime)\n" +
                  "				.setUrl(\"/primeReport/\" + prime)\n" +
                  "				.setKey(key.incrementAndGet()));\n" +
                  "	}\n" +
                  "	for (String rent : new String[]{\n" +
                  "			\"Barnoldswick\",\n" +
                  "			\"Barrowford\",\n" +
                  "			\"Burnley\",\n" +
                  "			\"Buxton\",\n" +
                  "			\"Chester\",\n" +
                  "			\"Colne\",\n" +
                  "			\"Crewe\",\n" +
                  "			\"Knutsford\",\n" +
                  "			\"Nantwich\",\n" +
                  "			\"Northwich\",\n" +
                  "			\"Tarporley\"}) {\n" +
                  "		session.addMenus(WebApiJsonFactory.newUserMenu()\n" +
                  "				.setLabel(\"Rent \" + rent)\n" +
                  "				.setUrl(\"/rentReport/\" + rent)\n" +
                  "				.setKey(key.incrementAndGet()));\n" +
                  "	}\n" +
                  "\n" +
                  "	for (String branch : new String[]{\n" +
                  "			\"Barnoldswick\",\n" +
                  "			\"Barrowford\",\n" +
                  "			\"Burnley\",\n" +
                  "			\"Buxton\",\n" +
                  "			\"Chester\",\n" +
                  "			\"Colne\",\n" +
                  "			\"Crewe\",\n" +
                  "			\"Knutsford\",\n" +
                  "			\"Nantwich\",\n" +
                  "			\"Northwich\",\n" +
                  "			\"Tarporley\"}) {\n" +
                  "		session.addMenus(WebApiJsonFactory.newUserMenu()\n" +
                  "				.setLabel(\"Branch \" + branch)\n" +
                  "				.setUrl(\"/branch/\" + branch)\n" +
                  "				.setKey(key.incrementAndGet()));\n" +
                  "	}\n" +
                  "\n" +
                  "	settings.getAccess().forEach(userAccess -> session.addMenus(WebApiJsonFactory.newUserMenu().setKey(key.incrementAndGet()).setUrl(userAccess.getUrl()).setLabel(userAccess.getLabel())));\n" +
                  "}");

      DomainPatterns.writeJsonWrapper(mainJava, webDomainPackage, DomainPatterns.newDomain("Server")
            .addEntities(serverDeploymentOptions));

      STGenerator.writeJavaFile(webVerticle, webVerticle.getPackageName().toString(), webVerticle.getName()
            .toString(), mainJava);
   }

   /**
    * generateTestClasses
    */
   @org.junit.Test
   public void generateTestClasses() {
      DomainPatterns.writePojo(testJava, corePackage, DomainPatterns.newDomain("Tests")
            .addEntities(DomainPatterns.newEntity("ScanDateDelta")
                  .addRelations(DomainPatterns.newStringField("firstDate"))
                  .addRelations(DomainPatterns.newStringField("secondDate"))
                  .addRelations(DomainPatterns.newOneToManyString("firstFiles"))
                  .addRelations(DomainPatterns.newOneToManyString("secondFiles"))));
   }

   /**
    * generateWebApi
    */
   @org.junit.Test
   public void generateWebApi() {
      DomainPatterns.writeJsonWrapper(mainJava, webApiPackage, DomainPatterns.newDomain("WebApi")
            .addEntities(DomainPatterns.newEntity("Response")
                  .addRelations(DomainPatterns.newEnumField("status", DomainPatterns.newEnum("ResponseStatus", "FAIL,SUCCESS")))
                  .addRelations(DomainPatterns.newEnumField("payloadType", DomainPatterns.newEnum("PayloadType", "STRING,JSONOBJECT,JSONARRAY")))
                  .addRelations(DomainPatterns.newOneToOneExternal("payload", Object.class)))
            .addEntities(DomainPatterns.newEntity("LoginRequest")
                  .addRelations(DomainPatterns.newStringField("username"))
                  .addRelations(DomainPatterns.newStringField("password")))
            .addEntities(DomainPatterns.newEntity("JWTPayload")
                  .addRelations(DomainPatterns.newStringField("sub")))
            .addEntities(DomainPatterns.newEntity("UserSession")
                  .addRelations(DomainPatterns.newStringField("token"))
                  .addRelations(DomainPatterns.newStringField("username"))
                  .addRelations(DomainPatterns.newOneToMany("menus", DomainPatterns.newEntity("UserMenu")
                        .addRelations(DomainPatterns.newIntegerField("key"))
                        .addRelations(DomainPatterns.newStringField("url"))
                        .addRelations(DomainPatterns.newStringField("label"))))));
   }

   private ClassComponent primePage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store primeReportStore, MaterialUIComponent primeReportComponent, MaterialUIComponent loading) {
      return addPage("PrimeReportPage", pageMap)
            .addImports(primeReportComponent.getName(), pageComponentPath(primeReportComponent))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject")
                  .addParameters(sq(lowFirst(primeReportStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .addConstructorStatements("const { match: { params } } = this.props;")
            .addConstructorStatements("this.props.primeReportStore.load(params.id);")
            .setRenderCondition("this.props.primeReportStore.data")
            .setRenderTrue(asElement(primeReportComponent)
                  .addProps(JavaScriptPatterns.newProp("data", " { this.props.primeReportStore.data }")))
            .setRenderFalse(asElement(loading));
   }

   private MaterialUIComponent primeReportComponent(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("PrimeReport", componentMap)
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newTableImport())
            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
            .addComponentImports(MaterialUIPatterns.newTableRowImport())
            .addComponentImports(MaterialUIPatterns.newTableCellImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("padding", "theme.spacing(3, 2)"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("width", sq("100%"))
                  .addAttributes("height", sq("100%")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
                  .addAttributes("minWidth", sq("650")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("petty")
                  .addAttributes("color", sq("red"))
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("unchanged")
                  .addAttributes("color", sq("black"))
                  .addAttributes("fontWeight", sq("plain")))
            .addConst(JavaScriptPatterns.newJsonObject("name", "date", "totalAgents", "totalPostings", "totalValue", "rank", "sectors", "headers", "rows"), "props.data")
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("name")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("date")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total postings ' + totalPostings")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total agents ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total value ' + totalValue")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Ranking ' + rank + ' of ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Sectors ' + sectors")))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("headers")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("rows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text"))))))))))))));
   }

   private nextgen.templates.mobx.Store primeReportStore(Map<String, nextgen.templates.mobx.IStore> storeMap, IndexJS indexJS, App app, AgentDeclaration reportsEndpoint) {
      return addStore("PrimeReportStore", storeMap, indexJS, app)
            .addObservables(MobXPatterns.newObservable("data", null))
            .addObservables(MobXPatterns.newObservable("errors", null))
            .addObservables(MobXPatterns.newObservable("inProgress", "false"))
            .addActions(MobXPatterns.newAction("load")
                  .addParams("id")
                  .addStatements(JavaScriptPatterns.debug("id"))
                  .addStatements("this.inProgress = true;")
                  .addStatements(JavaScriptPatterns.newAgentRequest(reportsEndpoint.getName(), "prime")
                        .addParams("id")
                        .addThen(JavaScriptPatterns.newArrowFunction(JavaScriptPatterns.newJsonObject("data"), "this.setData(data)"))
                        .setFinally(JavaScriptPatterns.newFunctionCall("action")
                              .addParameters(JavaScriptPatterns.newArrowFunction("this.inProgress = false")))))
            .addActions(MobXPatterns.newAction("setData")
                  .addParams("data")
                  .addStatements("this.data = data;"))
            .addActions(MobXPatterns.newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"));
   }

   private ClassComponent rentPage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store mobXStore, MaterialUIComponent uiComponent, MaterialUIComponent loading) {
      return addPage("RentReportPage", pageMap)
            .addImports(uiComponent.getName(), pageComponentPath(uiComponent))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(mobXStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .addConstructorStatements("const { match: { params } } = this.props;")
            .addConstructorStatements("this.props.rentReportStore.load(params.id);")
            .setRenderCondition("this.props.rentReportStore.data")
            .setRenderTrue(asElement(uiComponent)
                  .addProps(JavaScriptPatterns.newProp("data", " { this.props.rentReportStore.data }")))
            .setRenderFalse(asElement(loading));
   }

   private MaterialUIComponent rentReportComponent(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("RentReport", componentMap)
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newTableImport())
            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
            .addComponentImports(MaterialUIPatterns.newTableRowImport())
            .addComponentImports(MaterialUIPatterns.newTableCellImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("padding", "theme.spacing(3, 2)"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("width", sq("100%"))
                  .addAttributes("height", sq("100%")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
                  .addAttributes("minWidth", sq("650")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("petty")
                  .addAttributes("color", sq("red"))
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("unchanged")
                  .addAttributes("color", sq("black"))
                  .addAttributes("fontWeight", sq("plain")))
            .addConst(JavaScriptPatterns.newJsonObject("name", "date", "totalAgents", "totalPostings", "totalValue", "rank", "headers", "rows"), "props.data")
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("name")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("date")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total postings ' + totalPostings")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total agents ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total value ' + totalValue")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Ranking ' + rank + ' of ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("headers")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("rows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text"))))))))))))));
   }

   private nextgen.templates.mobx.Store rentReportStore(Map<String, nextgen.templates.mobx.IStore> storeMap, IndexJS indexJS, App app, AgentDeclaration reportsEndpoint) {
      return addStore("RentReportStore", storeMap, indexJS, app)
            .addObservables(MobXPatterns.newObservable("data", null))
            .addObservables(MobXPatterns.newObservable("errors", null))
            .addObservables(MobXPatterns.newObservable("inProgress", "false"))
            .addActions(MobXPatterns.newAction("load")
                  .addParams("id")
                  .addStatements(JavaScriptPatterns.debug("id"))
                  .addStatements("this.inProgress = true;")
                  .addStatements(JavaScriptPatterns.newAgentRequest(reportsEndpoint.getName(), "rent")
                        .addParams("id")
                        .addThen(JavaScriptPatterns.newArrowFunction(JavaScriptPatterns.newJsonObject("data"), "this.setData(data)"))
                        .setFinally(JavaScriptPatterns.newFunctionCall("action")
                              .addParameters(JavaScriptPatterns.newArrowFunction("this.inProgress = false")))))
            .addActions(MobXPatterns.newAction("setData")
                  .addParams("data")
                  .addStatements("this.data = data;"))
            .addActions(MobXPatterns.newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"));
   }

   private MaterialUIComponent trendsComponent(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("Trends", componentMap)
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newTableImport())
            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
            .addComponentImports(MaterialUIPatterns.newTableRowImport())
            .addComponentImports(MaterialUIPatterns.newTableCellImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("padding", "theme.spacing(3, 2)"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("width", sq("100%"))
                  .addAttributes("height", sq("100%")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
                  .addAttributes("minWidth", sq("650")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
                  .addAttributes("fontWeight", sq("bold")))
            .addConst(JavaScriptPatterns.newJsonObject("name", "date", "headers", "rows"), "props.data")
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h4")
                              .addChildren(JavaScriptPatterns.newJsonObject("name")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h4")
                              .addChildren(JavaScriptPatterns.newJsonObject("date")))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("headers")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("rows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text")))))))))))))
            );
   }

   private ClassComponent trendsPage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store trendsReportStore, MaterialUIComponent trendsComponent, MaterialUIComponent loading) {
      return addPage("TrendsPage", pageMap)
            .addImports(trendsComponent.getName(), pageComponentPath(trendsComponent))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject")
                  .addParameters(sq(lowFirst(trendsReportStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .addConstructorStatements("this.props.trendsReportStore.load();")
            .setRenderCondition("this.props.trendsReportStore.data")
            .setRenderTrue(asElement(trendsComponent)
                  .addProps(JavaScriptPatterns.newProp("data", " { this.props.trendsReportStore.data }")))
            .setRenderFalse(asElement(loading));
   }

   private nextgen.templates.mobx.Store trendsReportStore(Map<String, nextgen.templates.mobx.IStore> storeMap, IndexJS indexJS, App app, AgentDeclaration reportsEndpoint) {
      return addStore("TrendsReportStore", storeMap, indexJS, app)
            .addObservables(MobXPatterns.newObservable("data", null))
            .addObservables(MobXPatterns.newObservable("errors", null))
            .addObservables(MobXPatterns.newObservable("inProgress", "false"))
            .addActions(MobXPatterns.newAction("load")
                  .addStatements("this.inProgress = true;")
                  .addStatements(JavaScriptPatterns.newAgentRequest(reportsEndpoint.getName(), "trends")
                        .addThen(JavaScriptPatterns.newArrowFunction(JavaScriptPatterns.newJsonObject("data"), "this.setData(data)"))
                        .setFinally(JavaScriptPatterns.newFunctionCall("action")
                              .addParameters(JavaScriptPatterns.newArrowFunction("this.inProgress = false")))))
            .addActions(MobXPatterns.newAction("setData")
                  .addParams("data")
                  .addStatements("this.data = data;"))
            .addActions(MobXPatterns.newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"));
   }

   private MaterialUIComponent dashboardCard(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("DashboardCard", componentMap)
            .addImports("{ Link as RouterLink }", "react-router-dom")
            .addComponentImports(MaterialUIPatterns.newGridImport())
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newLinkImport())
            .addComponentImports(MaterialUIPatterns.newButtonImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("height", 190)
                  .addAttributes("width", 120)
                  .addAttributes("padding", "theme.spacing(2)")
                  .addAttributes("textAlign", "'center'")
                  .addAttributes("color", "theme.palette.text.secondary"))
            .addConst("{ label, url }", "props")
            .addConst("LinkComponent", JavaScriptPatterns.newForwardRef()
                  .setTo(JavaScriptPatterns.newJsonObject("url")))
            .setRenderElement(MaterialUIPatterns.newGridElement()
                  .setItem(true)
                  .addChildren(MaterialUIPatterns.newPaperElement()
                        .setClassName(MaterialUIPatterns.styleClass("paper"))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("label")))
                        .addChildren(MaterialUIPatterns.newButtonElement()
                              .setColor("primary")
                              .setComponent(JavaScriptPatterns.newJsonObject("LinkComponent"))
                              .addChildren("Open"))));
   }

   private MaterialUIComponent dashboardComponent(Map<String, MaterialUIComponent> componentMap, MaterialUIComponent dashboardCard) {
      return addComponent("Dashboard", componentMap)
            .addComponentImports(MaterialUIPatterns.newGridImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newDividerImport())
            .addImports(dashboardCard.getName(), pageComponentPath(dashboardCard))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("flexGrow", "1")
                  .addAttributes("padding", "20"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("innerGrid")
                  .addAttributes("flexGrow", "1")
                  .addAttributes("padding", "10"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("header")
                  .addAttributes("color", "theme.palette.text.secondary")
                  .addAttributes("textAlign", "'left'"))
            .addConst("{ pages }", "props")
            .setRenderElement(MaterialUIPatterns.newGridElement()
                  .setContainer(true)
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .setJustify("start")
                  .setSpacing(3)
                  .addChildren(MaterialUIPatterns.newGridElement()
                        .setItem(true)
                        .setXs("12")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setClassName(MaterialUIPatterns.styleClass("header"))
                              .setVariant("h4")
                              .addChildren("Pages")))
                  .addChildren(MaterialUIPatterns.newGridElement()
                        .setXs("12")
                        .addChildren(MaterialUIPatterns.newDividerElement()))
                  .addChildren(MaterialUIPatterns.newGridElement()
                        .setContainer(true)
                        .setClassName(MaterialUIPatterns.styleClass("innerGrid"))
                        .setJustify("start")
                        .setSpacing("2")
                        .addChildren(JavaScriptPatterns.newMapProperty()
                              .setProperty("pages")
                              .setForEach(MaterialUIPatterns.newGridElement()
                                    .setItem(true)
                                    .addAttribute("key", "{element.key}")
                                    .addChildren(asElement(dashboardCard)
                                          .addAttributes("label", "{ element.label }")
                                          .addAttributes("url", "{ element.url }"))
                              ))));
   }

   private ClassComponent dashboardPage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store dashboardStore, MaterialUIComponent dashboard, MaterialUIComponent loading) {
      return addPage("DashboardPage", pageMap)
            .addImports(dashboard.getName(), pageComponentPath(dashboard))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject")
                  .addParameters(sq(lowFirst(dashboardStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .setRenderElement(asElement(dashboard)
                  .addProps(JavaScriptPatterns.newProp("pages", " { this.props.userStore.currentUser.menus }")));
   }

   private ClassComponent raceChartPage(Map<String, ClassComponent> pageMap, MaterialUIComponent loading) {
      return addPage("RaceChart", pageMap)
            .addImports(loading.getName(), pageComponentPath(loading))
            .addImports("BarChart", "chart-race-react")
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("data", "data = ['apple', 'banana', 'orange'].reduce((res, item) => ({...res, ...{[item]: Array(20).fill(0).map(_ => Math.floor(20 * Math.random()))}}), {})"))
            .addConstDeclarations(JavaScriptPatterns.newMethodDeclaration("randomColor")
                  .setConst(true)
                  .addStatements("return `rgb(${255 * Math.random()}, ${255 * Math.random()}, ${255})`;"))
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("len", "data[Object.keys(data)[0]].length"))
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("keys", "Object.keys(data)"))
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("colors", "keys.reduce((res, item) => ({ \n" +
                  "    ...res, \n" +
                  "    ...{ [item]: randomColor() } \n" +
                  "}), {})"))
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("labels", "keys.reduce((res, item, idx) => {\n" +
                  "  return{\n" +
                  "  ...res, \n" +
                  "  ...{[item]: (\n" +
                  "    <div style={{textAlign:\"center\",}}>\n" +
                  "      <div>{item}</div>\n" +
                  "    </div>\n" +
                  "    )}\n" +
                  "}}, {})"))
            .addConstDeclarations(JavaScriptPatterns.newConstVariable("time", "Array(20).fill(0).map((itm, idx) => idx + 1)"))
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .addAttributes("style", JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                        .newNameValue("width", dq("500px")))))
                  .addChildren(JavaScriptPatterns.newElement("BarChart")
                        .addAttributes("start", JavaScriptPatterns.newJsonObject("true"))
                        .addAttributes("data", JavaScriptPatterns.newJsonObject("data"))
                        .addAttributes("timeline", JavaScriptPatterns.newJsonObject("time"))
                        .addAttributes("labels", JavaScriptPatterns.newJsonObject("labels"))
                        .addAttributes("colors", JavaScriptPatterns.newJsonObject("colors"))
                        .addAttributes("len", JavaScriptPatterns.newJsonObject("len"))
                        .addAttributes("timeout", JavaScriptPatterns.newJsonObject("400"))
                        .addAttributes("delay", JavaScriptPatterns.newJsonObject("100"))
                        .addAttributes("timelineStyle", JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newJsonObject()
                              .addValues(JavaScriptPatterns.newNameValue("textAlign", dq("center")))
                              .addValues(JavaScriptPatterns.newNameValue("fontSize", dq("50px")))
                              .addValues(JavaScriptPatterns.newNameValue("color", dq("rgb(148, 148, 148)")))
                              .addValues(JavaScriptPatterns.newNameValue("marginBottom", dq("100px")))))
                        .addAttributes("textBoxStyle", JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newJsonObject()
                              .addValues(JavaScriptPatterns.newNameValue("textAlign", dq("right")))
                              .addValues(JavaScriptPatterns.newNameValue("fontSize", dq("30px")))
                              .addValues(JavaScriptPatterns.newNameValue("color", dq("rgb(133, 131, 131)")))))
                        .addAttributes("barStyle", JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newJsonObject()
                              .addValues(JavaScriptPatterns.newNameValue("height", dq("60px")))
                              .addValues(JavaScriptPatterns.newNameValue("marginTop", dq("10px")))
                              .addValues(JavaScriptPatterns.newNameValue("borderRadius", dq("10px")))))
                        .addAttributes("width", JavaScriptPatterns.newJsonObject("[15, 75, 10]"))
                        .addAttributes("maxItems", JavaScriptPatterns.newJsonObject("5"))
                  ));
   }

   private ClassComponent agentPage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store mobXStore, MaterialUIComponent uiComponent, MaterialUIComponent loading) {
      return addPage("AgentPage", pageMap)
            .addImports(uiComponent.getName(), pageComponentPath(uiComponent))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(mobXStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .addConstructorStatements("const { match: { params } } = this.props;")
            .addConstructorStatements("this.props.agentReportStore.load(params.id);")
            .setRenderCondition("this.props.agentReportStore.data")
            .setRenderTrue(asElement(uiComponent)
                  .addProps(JavaScriptPatterns.newProp("data", " { this.props.agentReportStore.data }")))
            .setRenderFalse(asElement(loading));
   }

   private MaterialUIComponent agentReportComponent(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("AgentReport", componentMap)
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newTableImport())
            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
            .addComponentImports(MaterialUIPatterns.newTableRowImport())
            .addComponentImports(MaterialUIPatterns.newTableCellImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("padding", "theme.spacing(3, 2)"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("width", sq("100%"))
                  .addAttributes("height", sq("100%")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
                  .addAttributes("minWidth", sq("650")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("petty")
                  .addAttributes("color", sq("red"))
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("unchanged")
                  .addAttributes("color", sq("black"))
                  .addAttributes("fontWeight", sq("plain")))
            .addConst(JavaScriptPatterns.newJsonObject("name", "date", "totalAgents", "totalPostings", "totalValue", "rank", "headers", "rows"), "props.data")
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("name")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("date")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total postings ' + totalPostings")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total agents ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Total value ' + totalValue")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h6")
                              .addChildren(JavaScriptPatterns.newJsonObject("'Ranking ' + rank + ' of ' + totalAgents")))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("headers")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("rows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text"))))))))))))));
   }

   private nextgen.templates.mobx.Store agentReportStore(Map<String, nextgen.templates.mobx.IStore> storeMap, IndexJS indexJS, App app, AgentDeclaration reportsEndpoint) {
      return addStore("AgentReportStore", storeMap, indexJS, app)
            .addObservables(MobXPatterns.newObservable("data", null))
            .addObservables(MobXPatterns.newObservable("errors", null))
            .addObservables(MobXPatterns.newObservable("inProgress", "false"))
            .addActions(MobXPatterns.newAction("load")
                  .addParams("id")
                  .addStatements(JavaScriptPatterns.debug("id"))
                  .addStatements("this.inProgress = true;")
                  .addStatements(JavaScriptPatterns.newAgentRequest(reportsEndpoint.getName(), "agent")
                        .addParams("id")
                        .addThen(JavaScriptPatterns.newArrowFunction(JavaScriptPatterns.newJsonObject("data"), "this.setData(data)"))
                        .setFinally(JavaScriptPatterns.newFunctionCall("action")
                              .addParameters(JavaScriptPatterns.newArrowFunction("this.inProgress = false")))))
            .addActions(MobXPatterns.newAction("setData")
                  .addParams("data")
                  .addStatements("this.data = data;"))
            .addActions(MobXPatterns.newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"));
   }

   private ClassComponent branchPage(Map<String, ClassComponent> pageMap, nextgen.templates.mobx.Store mobXStore, MaterialUIComponent uiComponent, MaterialUIComponent loading) {
      return addPage("BranchPage", pageMap)
            .addImports(uiComponent.getName(), pageComponentPath(uiComponent))
            .addImports(loading.getName(), pageComponentPath(loading))
            .addDecorators(JavaScriptPatterns.newDecorator("inject").addParameters(sq(lowFirst(mobXStore.getName()))))
            .addDecorators(JavaScriptPatterns.newDecorator("observer"))
            .addConstructorStatements("const { match: { params } } = this.props;")
            .addConstructorStatements("this.props.branchReportStore.load(params.id);")
            .setRenderCondition("this.props.branchReportStore.data")
            .setRenderTrue(asElement(uiComponent)
                  .addProps(JavaScriptPatterns.newProp("data", " { this.props.branchReportStore.data }")))
            .setRenderFalse(asElement(loading));
   }

   private MaterialUIComponent branchReportComponent(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("BranchReport", componentMap)
            .addComponentImports(MaterialUIPatterns.newPaperImport())
            .addComponentImports(MaterialUIPatterns.newTypographyImport())
            .addComponentImports(MaterialUIPatterns.newTableImport())
            .addComponentImports(MaterialUIPatterns.newTableBodyImport())
            .addComponentImports(MaterialUIPatterns.newTableHeadImport())
            .addComponentImports(MaterialUIPatterns.newTableRowImport())
            .addComponentImports(MaterialUIPatterns.newTableCellImport())
            .addStyleClasses(MaterialUIPatterns.newStyleClass("paper")
                  .addAttributes("padding", "theme.spacing(3, 2)"))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("root")
                  .addAttributes("width", sq("100%"))
                  .addAttributes("height", sq("100%")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("table")
                  .addAttributes("minWidth", sq("650")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("tableHeader")
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("petty")
                  .addAttributes("color", sq("red"))
                  .addAttributes("fontWeight", sq("bold")))
            .addStyleClasses(MaterialUIPatterns.newStyleClass("unchanged")
                  .addAttributes("color", sq("black"))
                  .addAttributes("fontWeight", sq("plain")))
            .addConst(JavaScriptPatterns.newJsonObject("name", "date", "headers", "rows", "listingsHeaders", "listingsRows"), "props.data")
            .setRenderElement(JavaScriptPatterns.newDiv()
                  .setClassName(MaterialUIPatterns.styleClass("root"))
                  .addChildren(MaterialUIPatterns.newPaperElement("paper")
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("name")))
                        .addChildren(MaterialUIPatterns.newTypographyElement()
                              .setVariant("h3")
                              .addChildren(JavaScriptPatterns.newJsonObject("date")))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("headers")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("rows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text"))))))))))))
                        .addChildren(MaterialUIPatterns.newTableElement()
                              .addChildren(MaterialUIPatterns.newTableHeadElement()
                                    .addChildren(MaterialUIPatterns.newTableRowElement()
                                          .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                .setScope("listingsHeaders")
                                                .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns
                                                      .newTableCellElement()
                                                      .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                      .addAttribute("align", JavaScriptPatterns.newJsonObject("e.align"))
                                                      .setClassName(MaterialUIPatterns.styleClass("tableHeader"))
                                                      .addChildren(JavaScriptPatterns.newJsonObject("e.text"))))))))
                              .addChildren(MaterialUIPatterns.newTableBodyElement()
                                    .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                          .setScope("listingsRows")
                                          .addParameters(JavaScriptPatterns.newArrowFunction("e,i", MaterialUIPatterns.newTableRowElement()
                                                .setKey(JavaScriptPatterns.newJsonObject("i"))
                                                .addChildren(JavaScriptPatterns.newJsonObject(JavaScriptPatterns.newFunctionCall("map")
                                                      .setScope("e.cells")
                                                      .addParameters(JavaScriptPatterns.newArrowFunction("d,j", MaterialUIPatterns
                                                            .newTableCellElement()
                                                            .setKey(JavaScriptPatterns.newJsonObject("d.key"))
                                                            .addAttribute("align", JavaScriptPatterns.newJsonObject("d.align"))
                                                            .setStyle(JavaScriptPatterns.newJsonObject(JavaScriptPatterns
                                                                  .newJsonObject(
                                                                        JavaScriptPatterns.newNameValue("fontWeight", "d.style.fontWeight"),
                                                                        JavaScriptPatterns.newNameValue("color", "d.style.color"),
                                                                        JavaScriptPatterns.newNameValue("fontSize", "d.style.fontSize")
                                                                  )))
                                                            .addChildren(JavaScriptPatterns.newJsonObject("d.text"))))))))))))));
   }

   private nextgen.templates.mobx.Store branchReportStore(Map<String, nextgen.templates.mobx.IStore> storeMap, IndexJS indexJS, App app, AgentDeclaration reportsEndpoint) {
      return addStore("BranchReportStore", storeMap, indexJS, app)
            .addObservables(MobXPatterns.newObservable("data", null))
            .addObservables(MobXPatterns.newObservable("errors", null))
            .addObservables(MobXPatterns.newObservable("inProgress", "false"))
            .addActions(MobXPatterns.newAction("load")
                  .addParams("id")
                  .addStatements(JavaScriptPatterns.debug("id"))
                  .addStatements("this.inProgress = true;")
                  .addStatements(JavaScriptPatterns.newAgentRequest(reportsEndpoint.getName(), "branch")
                        .addParams("id")
                        .addThen(JavaScriptPatterns.newArrowFunction(JavaScriptPatterns.newJsonObject("data"), "this.setData(data)"))
                        .setFinally(JavaScriptPatterns.newFunctionCall("action")
                              .addParameters(JavaScriptPatterns.newArrowFunction("this.inProgress = false")))))
            .addActions(MobXPatterns.newAction("setData")
                  .addParams("data")
                  .addStatements("this.data = data;"))
            .addActions(MobXPatterns.newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"));
   }

   protected static void log(Object log) {
      System.out.println(log);
   }

   class JavaType {

      final nextgen.templates.java.ClassOrInterfaceType type;

      JavaType(String packageDeclaration, String name) {
         this.type = nextgen.templates.java.JavaST.newClassOrInterfaceType()
               .setScope(packageDeclaration)
               .addNames(name);
      }

      JavaType(nextgen.templates.java.PackageDeclaration packageDeclaration, String name) {
         this(packageDeclaration.getName(), name);
      }
   }
}