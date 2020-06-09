package nextgen.projects;

import io.vertx.core.json.JsonArray;
import nextgen.templates.DomainPatterns;
import nextgen.templates.MavenPatterns;
import nextgen.templates.NpmPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.maven.DependencyGroup;
import nextgen.templates.maven.Pom;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.MavenPatterns.*;
import static nextgen.templates.maven.MavenST.newBuild;
import static nextgen.templates.maven.MavenST.newDependencyGroup;
import static nextgen.templates.maven.MavenST.newFrontEndMavenPlugin;
import static nextgen.templates.maven.MavenST.newPom;
import static nextgen.templates.maven.MavenST.newProject;
import static nextgen.templates.maven.MavenST.newShadePlugin;
import static nextgen.templates.npm.NpmST.*;
import static nextgen.templates.npm.NpmST.newBabelrc;

public class PettyProject {

    private final File root = new File("/home/goe/projects/petty");

    private final File main = new File("src/main");
    private final File mainJava = new File(main, "java");
    private final File mainResources = new File(main, "resources");
    private final File mainWebapp = new File(main, "webapp");

    private final File targetStaticResources = new File("target/classes/static");

    private final PackageDeclaration corePackage = newPackageDeclaration("com.petty");
    private final PackageDeclaration exportPackage = newPackageDeclaration(corePackage, "export");
    private final PackageDeclaration exportDomain = newPackageDeclaration(exportPackage, "domain");
    private final PackageDeclaration reportPackage = newPackageDeclaration(corePackage, "reports");
    private final PackageDeclaration reportDomain = newPackageDeclaration(reportPackage, "domain");
    private final PackageDeclaration webPackage = newPackageDeclaration(corePackage, "web");
    private final PackageDeclaration webDomainPackage = newPackageDeclaration(webPackage, "domain");
    private final PackageDeclaration webApiPackage = newPackageDeclaration(webPackage, "api");
    private final PackageDeclaration domainPackage = newPackageDeclaration(corePackage, "domain");
    private final PackageDeclaration scanPackage = newPackageDeclaration(corePackage, "scan");
    private final PackageDeclaration scanDomainPackage = newPackageDeclaration(scanPackage, "domain");
    private final PackageDeclaration rmScanPackage = newPackageDeclaration(scanPackage, "rm");
    private final PackageDeclaration rmScanDomainPackage = newPackageDeclaration(rmScanPackage, "domain");

    private final String mainClass = "ServerApp";

    @Test
    public void generateProjectFiles() {

        final DependencyGroup vertxGroup = newDependencyGroup()
                .setName("vertx")
                .setGroupId("io.vertx")
                .setVersion("3.8.3")
                .addArtifacts("vertx-core")
                .addArtifacts("vertx-web")
                .addArtifacts("vertx-auth-jwt")
                .addArtifacts("vertx-unit");

        final Pom projectPom = newPom()
                .setName("Petty")
                .setGroupId("petty")
                .setArtifactId("analytics")
                .setVersion("1.5")
                .addProperties(setMavenCompilerSource("1.8"))
                .addProperties(setMavenCompilerTarget("1.8"))
                .addProperties(setProjectBuildSourceEncoding("UTF-8"))
                .addProperties(setProjectReportingOutputEncoding("UTF-8"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("cdt-java-client").setGroupId("com.github.kklisura.cdt").setVersion("2.1.0"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("neo4j").setGroupId("org.neo4j").setVersion("3.5.8"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("slf4j-log4j12").setGroupId("org.slf4j").setVersion("1.7.20"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("jsoup").setGroupId("org.jsoup").setVersion("1.12.1"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("junit").setGroupId("junit").setVersion("4.12"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("java-telegram-bot-api").setGroupId("com.github.pengrad").setVersion("4.8.0"))
                .setBuild(newBuild()
                        .addPlugin(newCopyPlugin()
                                .setDirectory(mainWebapp.getPath())
                                .setOutputDirectory(targetStaticResources.getPath())
                                .addInclude("favicon.ico")
                                .addInclude("index.css")
                                .addInclude("index.html")
                                .addInclude("index.js"))
                        .addPlugin(newFrontEndMavenPlugin()
                                .setInstallDirectory("target")
                                .setNodeVersion("8.9.0")
                                .setPluginVersion("1.10.0"))
                        .addPlugin(newShadePlugin()
                                .setClassName(mainClass)
                                .setPackageName(webPackage)));

        MavenPatterns.addDependencyGroup(projectPom, vertxGroup);

        generate(newProject()
                .setName("Petty")
                .setRoot(root.getAbsolutePath())
                .setPom(projectPom));

        NpmPatterns.generate(newNpmProject()
                .setRoot(root.getAbsolutePath())
                .setPackageJson(newPackageJson()
                        .setName("petty")
                        .setVersion("1.5.0")
                        .setDescription("Petty analytics core and web")
                        .setAuthor("GOE")
                        .setLicense("ISC")
                        .setMain("index.js")
                        .addScripts(newScript().setName("deploy").setCommand("webpack --mode production"))
                        .addScripts(newScript().setName("server").setCommand("webpack-dev-server --open --mode development"))
                        .addScripts(newScript().setName("package").setCommand("webpack --mode development"))
                        .addScripts(newScript().setName("develop").setCommand("webpack --watch --progress --mode development"))
                        .addDependencies(NpmPatterns.newDependency("react", "16.9.0"))
                        .addDependencies(NpmPatterns.newDependency("react-dom", "16.9.0"))
                        .addDependencies(NpmPatterns.newDependency("react-router-dom", "5.0.1"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/core", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/icons", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/styles", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("material-table", "1.50.0"))
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
                        .addDevDependencies(NpmPatterns.newDependency("html-webpack-plugin", "3.2.0")))
                .setWebpackConfig(newWebpackConfig()
                        .setMainEntry(new File(mainWebapp, "index.js").getPath())
                        .setOutputFilename(new File(targetStaticResources, "main.js")))
                .setBabelrc(newBabelrc()));
    }

    @Test
    public void generateScanDomain() {

        DomainPatterns.writePojo(mainJava, scanDomainPackage, newDomain("Scan")
                .addEntities(newEntity("ScanRoot")
                        .addRelations(newStringField("path", true))
                        .addRelations(newOneToMany("dates", newEntity("ScanDate")
                                .addRelations(newStringField("date", true))
                                .addRelations(newStringField("raw"))
                                .addRelations(newStringField("parsed")))))
                .addEntities(newEntity("HtmlFileGroup")
                        .addRelations(newStringField("name"))
                        .addRelations(newOneToOneExternal("properties", JsonArray.class))
                        .addRelations(newOneToManyExternal("htmlFiles", File.class))));

        DomainPatterns.writeJsonWrapper(mainJava, rmScanDomainPackage, newDomain("RM")
                .addEntities(newEntity("RMPageModel")
                        .addRelations(newOneToMany("properties", newEntity("RMPosting")
                                .addRelations(newLongField("id"))
                                .addRelations(newIntegerField("bedrooms"))
                                .addRelations(newStringField("displayAddress"))
                                .addRelations(newStringField("addedOrReduced"))
                                .addRelations(newStringField("propertySubType"))
                                .addRelations(newStringField("firstVisibleDate"))
                                .addRelations(newStringField("propertyTypeFullDescription"))
                                .addRelations(newOneToOne("listingUpdate", newEntity("RMListingUpdate")
                                        .addRelations(newStringField("listingUpdateReason"))
                                        .addRelations(newStringField("listingUpdateDate"))))
                                .addRelations(newOneToOne("location", newEntity("RMLocation")
                                        .addRelations(newDoubleField("latitude"))
                                        .addRelations(newDoubleField("longitude"))))
                                .addRelations(newOneToOne("price", newEntity("RMPrice")
                                        .addRelations(newIntegerField("amount"))
                                        .addRelations(newStringField("currencyCode"))))
                                .addRelations(newOneToOne("customer", newEntity("RMCustomer")
                                        .addRelations(newLongField("branchId"))
                                        .addRelations(newStringField("branchDisplayName"))
                                        .addRelations(newStringField("branchName"))
                                        .addRelations(newStringField("brandTradingName"))))))
                        .addRelations(newOneToOne("pagination", newEntity("RMPagination")
                                .addRelations(newStringField("total"))
                                .addRelations(newStringField("next"))
                                .addRelations(newStringField("page"))
                                .addRelations(newOneToMany("options", newEntity("RMPaginationOptions")
                                        .addRelations(newStringField("value"))
                                        .addRelations(newStringField("description"))))))));

        final Entity rmQuery = newEntity("RMUrl")
                .addRelations(newStringField("name"))
                .addRelations(newStringField("path"))
                .addRelations(newStringField("preQuery"))
                .addRelations(newStringField("postQuery"));

        DomainPatterns.writeNeo(mainJava, rmScanDomainPackage, newDomain("RM")
                .addEntities(newEntity("RMConfig")
                        .addRelations(newStringField("name"))
                        .addRelations(newStringField("host"))
                        .addRelations(newStringField("protocol"))
                        .addRelations(newOneToOne("rentUrl", rmQuery))
                        .addRelations(newOneToOne("salesPostcodeUrl", rmQuery))
                        .addRelations(newOneToOne("salesBranchUrl", rmQuery))
                        .addRelations(newOneToMany("scans", newEntity("RMScan")
                                .addRelations(newStringField("name", true))
                                .addRelations(newEnumField("searchType", newEnum("RMSearchType", "RENT,SALES_POSTCODE,SALES_BRANCH")))
                                .addRelations(newStringField("locationIdentifier"))))));
    }

    @Test
    public void generateNeoDomain() {

        final Entity branch = newEntity("Branch")
                .addRelations(newLongField("id"))
                .addRelations(newBooleanField("isPetty"))
                .addRelations(newStringField("name", true));

        final Domain domain = newDomain("Domain")
                .addEntities(newEntity("Agent")
                        .addRelations(newStringField("name", true))
                        .addRelations(newOneToMany("branches", branch)))
                .addEntities(newEntity("ListingDate")
                        .addRelations(newStringField("date", true))
                        .addRelations(newOneToMany("areas", newEntity("DateAreaListings")
                                .addRelations(newOneToOne("area", newEntity("Area")
                                        .addRelations(newStringField("name", true))
                                        .addRelations(newOneToMany("postcodes", newEntity("Postcode")
                                                .addRelations(newStringField("code", true))))))
                                .addRelations(newOneToMany("listings", newEntity("PropertyListing")
                                        .addRelations(newLongField("id"))
                                        .addRelations(newIntegerField("bedrooms"))
                                        .addRelations(newStringField("streetAddress"))
                                        .addRelations(newStringField("addedOrReduced"))
                                        .addRelations(newStringField("propertySubType"))
                                        .addRelations(newStringField("firstVisibleDate"))
                                        .addRelations(newStringField("propertyTypeFullDescription"))
                                        .addRelations(newStringField("listingUpdateReason"))
                                        .addRelations(newStringField("listingUpdateDate"))
                                        .addRelations(newStringField("image"))
                                        .addRelations(newDoubleField("latitude"))
                                        .addRelations(newDoubleField("longitude"))
                                        .addRelations(newIntegerField("price"))
                                        .addRelations(newOneToOne("branch", branch)))))))
                .addEntities(newEntity("Postcodes")
                        .addRelations(newStringField("country", true))
                        .addRelations(newOneToMany("areas", newEntity("PostcodeArea")
                                .addRelations(newStringField("name", true))
                                .addRelations(newOneToMany("districts", newEntity("PostcodeDistrict")
                                        .addRelations(newStringField("name", true))
                                        .addRelations(newOneToMany("sectors", newEntity("PostcodeSector")
                                                .addRelations(newStringField("name", true))
                                                .addRelations(newOneToMany("units", newEntity("PostcodeUnit")
                                                        .addRelations(newStringField("name", true)))))))))));

        DomainPatterns.writeNeo(mainJava, domainPackage.getName(), domain);
    }

    @Test
    public void generateExportDomain() {

        DomainPatterns.writeJsonWrapper(mainJava, exportDomain, newDomain("Export")
                .addEntities(newEntity("AreaPostings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newOneToMany("postings", newEntity("AreaPosting")
                                .addRelations(newLongField("id"))
                                .addRelations(newStringField("address"))
                                .addRelations(newDoubleField("lat"))
                                .addRelations(newDoubleField("lon"))
                                .addRelations(newStringField("image"))
                                .addRelations(newLongField("agent.branch.id"))
                                .addRelations(newStringField("agent.branch.displayName"))
                                .addRelations(newStringField("agent.branch.name"))
                        ))));
    }

    @Test
    public void generateServer() {

        final Entity serverSettings = newEntity("ServerSettings")
                .addRelations(newStringField("name", true))
                .addRelations(newStringField("tcpHost"))
                .addRelations(newStringField("tcpName"))
                .addRelations(newIntegerField("port"))
                .addRelations(newStringField("webRoot"))
                .addRelations(newOneToMany("verticles", newEntity("VerticleSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("className"))))
                .addRelations(newOneToOne("botSettings", newEntity("BotSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("botToken"))
                        .addRelations(newBooleanField("start"))))
                .addRelations(newOneToOne("ssl", newEntity("SSLSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("key"))
                        .addRelations(newStringField("cert"))))
                .addRelations(newOneToOne("jwt", newEntity("JWTSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("path"))
                        .addRelations(newStringField("password"))
                        .addRelations(newStringField("type"))
                        .addRelations(newIntegerField("expiresInMinutes"))
                        .addRelations(newOneToMany("users", newEntity("UserSettings")
                                .addRelations(newStringField("username", true))
                                .addRelations(newStringField("password"))
                                .addRelations(newStringField("salt"))))));

        DomainPatterns.writeNeo(mainJava, webDomainPackage, newDomain("Server")
                .addEntities(serverSettings));


        final Entity serverDeploymentOptions = newEntity("ServerDeploymentOptions")
                .addRelations(newStringField("name", true))
                .addRelations(newStringField("tcpHost"))
                .addRelations(newStringField("tcpName"))
                .addRelations(newIntegerField("port"))
                .addRelations(newStringField("webRoot"))
                .addRelations(newOneToMany("verticles", newEntity("VerticleDeploymentSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("className"))))
                .addRelations(newOneToOne("botSettings", newEntity("BotDeploymentSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("botToken"))
                        .addRelations(newBooleanField("start"))))
                .addRelations(newOneToOne("ssl", newEntity("SSLDeploymentSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("key"))
                        .addRelations(newStringField("cert"))))
                .addRelations(newOneToOne("jwt", newEntity("JWTDeploymentSettings")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("path"))
                        .addRelations(newStringField("password"))
                        .addRelations(newStringField("type"))
                        .addRelations(newIntegerField("expiresInMinutes"))
                        .addRelations(newOneToMany("users", newEntity("UserDeploymentSettings")
                                .addRelations(newStringField("username", true))
                                .addRelations(newStringField("token"))
                                .addRelations(newStringField("password"))
                                .addRelations(newStringField("salt"))))));

        DomainPatterns.writeJsonWrapper(mainJava, webDomainPackage, newDomain("Server")
                .addEntities(serverDeploymentOptions));
    }

    @Test
    public void generateWebApi() {

        DomainPatterns.writeJsonWrapper(mainJava, webApiPackage, newDomain("WebApi")
                .addEntities(newEntity("Response")
                        .addRelations(newEnumField("status", newEnum("ResponseStatus", "FAIL,SUCCESS")))
                        .addRelations(newEnumField("payloadType", newEnum("PayloadType", "STRING,JSONOBJECT,JSONARRAY")))
                        .addRelations(newOneToOneExternal("payload", Object.class)))
                .addEntities(newEntity("LoginRequest")
                        .addRelations(newStringField("username"))
                        .addRelations(newStringField("password")))
                .addEntities(newEntity("JWTPayload")
                        .addRelations(newStringField("sub")))
                .addEntities(newEntity("UserSession")
                        .addRelations(newStringField("token"))
                        .addRelations(newStringField("username"))
                        .addRelations(newOneToMany("menus", newEntity("UserMenu")
                                .addRelations(newIntegerField("key"))
                                .addRelations(newStringField("url"))
                                .addRelations(newStringField("label"))))));
    }

    @Test
    public void tmpImportDependencies() {
//        MavenPatterns.printDependenciesAsFluent(new File("/home/goe/property/RealProperty/pom.xml"));
    }

    @Test
    public void generateReportingDomain() {

//        DomainToPojos.generate(javaMainSrc, reportDomain, newDomain("Reports")
//                .addEntities(newEntity("Trends")
//                        .addRelations(newStringField("name", true))
//                        .addRelations(oneToOne("today", )));

    }
}