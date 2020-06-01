package nextgen.projects;

import io.vertx.core.json.JsonArray;
import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Domain;
import nextgen.java.st.PackageDeclaration;
import nextgen.maven.MavenPatterns;
import nextgen.maven.st.DependencyGroup;
import nextgen.maven.st.MavenFactory;
import nextgen.maven.st.pom;
import nextgen.npm.NpmPatterns;
import org.junit.Test;

import java.io.File;

import static nextgen.domain.DomainPatterns.*;
import static nextgen.java.JavaPatterns.newPackageDeclaration;
import static nextgen.maven.MavenPatterns.*;
import static nextgen.npm.st.NpmFactory.*;

public class PettyProject {

    private final File root = new File("/home/goe/projects/petty");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

    private final PackageDeclaration corePackage = newPackageDeclaration("com.petty");
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

        final pom projectPom = MavenFactory.newPom()
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
                        .setMainEntry(new File("./src/main/webapp", "index.js").getPath())
                        .setOutputFilename(new File("./src/main/resources/static", "main.js")))
                .setBabelrc(newBabelrc()));
    }

    @Test
    public void generateScanDomain() {

        DomainToPojos.generate(javaMainSrc, scanDomainPackage, newDomainBuilder("Scan")
                .add(newEntityBuilder("ScanRoot")
                        .addStringField("path", true)
                        .addOneToManyRelation("dates", newEntityBuilder("ScanDate")
                                .addStringField("date", true)
                                .addOneToOneRelation("raw", newString())
                                .addOneToOneRelation("parsed", newString())))
                .add(newEntityBuilder("HtmlFileGroup")
                        .addStringField("name")
                        .addOneToOneRelation("properties", newExternalEntity(JsonArray.class))
                        .addOneToManyRelation("htmlFiles", newExternalEntity(File.class))));

        DomainToJson.generate(javaMainSrc, rmScanDomainPackage, newDomainBuilder("RM")
                .add(newEntityBuilder("RMPageModel")
                        .addOneToManyRelation("properties", newEntityBuilder("RMPosting")
                                .addLongField("id")
                                .addIntegerField("bedrooms")
                                .addStringField("displayAddress")
                                .addStringField("addedOrReduced")
                                .addStringField("propertySubType")
                                .addStringField("firstVisibleDate")
                                .addStringField("propertyTypeFullDescription")
                                .addOneToOneRelation("listingUpdate", newEntityBuilder("RMListingUpdate")
                                        .addStringField("listingUpdateReason")
                                        .addStringField("listingUpdateDate"))
                                .addOneToOneRelation("location", newEntityBuilder("RMLocation")
                                        .addDoubleField("latitude")
                                        .addDoubleField("longitude"))
                                .addOneToOneRelation("price", newEntityBuilder("RMPrice")
                                        .addIntegerField("amount")
                                        .addStringField("currencyCode"))
                                .addOneToOneRelation("customer", newEntityBuilder("RMCustomer")
                                        .addLongField("branchId")
                                        .addStringField("branchDisplayName")
                                        .addStringField("branchName")
                                        .addStringField("brandTradingName")))
                        .addOneToOneRelation("pagination", newEntityBuilder("RMPagination")
                                .addStringField("total")
                                .addStringField("next")
                                .addStringField("page")
                                .addOneToManyRelation("options", newEntityBuilder("RMPaginationOptions")
                                        .addStringField("value")
                                        .addStringField("description")))));

        final EntityBuilder rmQuery = newEntityBuilder("RMUrl")
                .addStringField("name")
                .addStringField("path")
                .addStringField("preQuery")
                .addStringField("postQuery");

        DomainToNeo4J.generate(javaMainSrc, rmScanDomainPackage, newDomainBuilder("RM")
                .add(newEntityBuilder("RMConfig")
                        .addStringField("name")
                        .addStringField("host")
                        .addStringField("protocol")
                        .addOneToOneRelation("rentUrl", rmQuery)
                        .addOneToOneRelation("salesPostcodeUrl", rmQuery)
                        .addOneToOneRelation("salesBranchUrl", rmQuery)
                        .addOneToManyRelation("scans", newEntityBuilder("RMScan")
                                .addStringField("name", true)
                                .addOneToOneRelation("searchType", newEnumEntity("RMSearchType", "RENT,SALES_POSTCODE,SALES_BRANCH"))
                                .addStringField("locationIdentifier"))));
    }

    @Test
    public void generateNeoDomain() {

        final EntityBuilder branch = newEntityBuilder("Branch")
                .addLongField("id")
                .addBooleanField("isPetty")
                .addStringField("name");

        final EntityBuilder agent = newEntityBuilder("Agent")
                .addStringField("name")
                .addOneToManyRelation("branches", branch);

        final EntityBuilder postcode = newEntityBuilder("Postcode")
                .addStringField("code");

        final EntityBuilder area = newEntityBuilder("Area")
                .addStringField("name", true)
                .addOneToManyRelation("postcodes", postcode);

        final EntityBuilder propertyListing = newEntityBuilder("PropertyListing")
                .addLongField("id")
                .addIntegerField("bedrooms")
                .addStringField("streetAddress")
                .addStringField("addedOrReduced")
                .addStringField("propertySubType")
                .addStringField("firstVisibleDate")
                .addStringField("propertyTypeFullDescription")
                .addStringField("listingUpdateReason")
                .addStringField("listingUpdateDate")
                .addDoubleField("latitude")
                .addDoubleField("longitude")
                .addIntegerField("price")
                .addOneToOneRelation("branch", branch);

        final EntityBuilder dateArea = newEntityBuilder("DateAreaListings")
                .addOneToOneRelation("area", area)
                .addOneToManyRelation("listings", propertyListing);

        final EntityBuilder listingDate = newEntityBuilder("ListingDate")
                .addStringField("date", true)
                .addOneToManyRelation("areas", dateArea);

        final Domain domain = newDomainBuilder("Domain")
                .add(agent)
                .add(listingDate)
                .add(newEntityBuilder("Postcodes")
                        .addStringField("country")
                        .addOneToManyRelation("areas", newEntityBuilder("PostcodeArea")
                                .addStringField("name")
                                .addOneToManyRelation("districts", newEntityBuilder("PostcodeDistrict")
                                        .addStringField("name")
                                        .addOneToManyRelation("sectors", newEntityBuilder("PostcodeSector")
                                                .addStringField("name")
                                                .addOneToManyRelation("units", newEntityBuilder("PostcodeUnit")
                                                        .addStringField("name"))))));

        DomainToNeo4J.generate(javaMainSrc, domainPackage, domain);
    }

    @Test
    public void generateServer() {

        final EntityBuilder serverSettings = newEntityBuilder("ServerSettings")
                .addStringField("name", true)
                .addStringField("tcpHost")
                .addStringField("tcpName")
                .addIntegerField("port")
                .addStringField("webRoot")
                .addOneToManyRelation("verticles", newEntityBuilder("VerticleSettings")
                        .addStringField("name", true)
                        .addStringField("className"))
                .addOneToOneRelation("botSettings", newEntityBuilder("BotSettings")
                        .addStringField("name", true)
                        .addStringField("botToken")
                        .addBooleanField("start"))
                .addOneToOneRelation("ssl", newEntityBuilder("SSLSettings")
                        .addStringField("name", true)
                        .addStringField("key")
                        .addStringField("cert"))
                .addOneToOneRelation("jwt", newEntityBuilder("JWTSettings")
                        .addStringField("name", true)
                        .addStringField("path")
                        .addStringField("password")
                        .addStringField("type")
                        .addIntegerField("expiresInMinutes")
                        .addOneToManyRelation("users", newEntityBuilder("UserSettings")
                                .addStringField("username", true)
                                .addStringField("password")
                                .addStringField("salt")));

        DomainToNeo4J.generate(javaMainSrc, webDomainPackage, newDomainBuilder("Server")
                .add(serverSettings));


        final EntityBuilder serverDeploymentOptions = newEntityBuilder("ServerDeploymentOptions")
                .addStringField("name", true)
                .addStringField("tcpHost")
                .addStringField("tcpName")
                .addIntegerField("port")
                .addStringField("webRoot")
                .addOneToManyRelation("verticles", newEntityBuilder("VerticleDeploymentSettings")
                        .addStringField("name", true)
                        .addStringField("className"))
                .addOneToOneRelation("botSettings", newEntityBuilder("BotDeploymentSettings")
                        .addStringField("name", true)
                        .addStringField("botToken")
                        .addBooleanField("start"))
                .addOneToOneRelation("ssl", newEntityBuilder("SSLDeploymentSettings")
                        .addStringField("name", true)
                        .addStringField("key")
                        .addStringField("cert"))
                .addOneToOneRelation("jwt", newEntityBuilder("JWTDeploymentSettings")
                        .addStringField("name", true)
                        .addStringField("path")
                        .addStringField("password")
                        .addStringField("type")
                        .addIntegerField("expiresInMinutes")
                        .addOneToManyRelation("users", newEntityBuilder("UserDeploymentSettings")
                                .addStringField("username", true)
                                .addStringField("token")
                                .addStringField("password")
                                .addStringField("salt")));

        DomainToJson.generate(javaMainSrc, webDomainPackage, newDomainBuilder("Server")
                .add(serverDeploymentOptions));
    }

    @Test
    public void generateWebApi() {

        DomainToJson.generate(javaMainSrc, webApiPackage, newDomainBuilder("WebApi")
                .add(newEntityBuilder("Response")
                        .addEnumField("status", "ResponseStatus", "FAIL,SUCCESS")
                        .addEnumField("payloadType", "PayloadType", "STRING,JSONOBJECT,JSONARRAY")
                        .addOneToOneRelation("payload", newExternalEntity(Object.class)))
                .add(newEntityBuilder("LoginRequest")
                        .addStringField("username")
                        .addStringField("password"))
                .add(newEntityBuilder("JWTPayload")
                        .addStringField("sub"))
                .add(newEntityBuilder("UserSession")
                        .addStringField("token")
                        .addStringField("username")
                        .addOneToManyRelation("menus", newEntityBuilder("UserMenu")
                                .addIntegerField("key")
                                .addStringField("url")
                                .addStringField("label"))));
    }

    @Test
    public void tmpImportDependencies() {
        MavenPatterns.printDependenciesAsFluent(new File("/home/goe/property/RealProperty/pom.xml"));
    }

    @Test
    public void generateReportingDomain() {

//        DomainToPojos.generate(javaMainSrc, reportDomain, newDomainBuilder("Reports")
//                .addEntities(newEntityBuilder("Trends")
//                        .addStringField("name", true)
//                        .addOneToOneRelation("today", )));

    }
}