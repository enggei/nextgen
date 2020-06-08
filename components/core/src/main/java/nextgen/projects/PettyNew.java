package nextgen.projects;

import nextgen.templates.MavenPatterns;
import nextgen.templates.NpmPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.maven.DependencyGroup;
import nextgen.templates.maven.Pom;
import nextgen.templates.vertx.VertxST;
import org.junit.Test;

import java.io.File;

import static nextgen.projects.ProjectPatterns.*;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.MavenPatterns.*;
import static nextgen.templates.domain.DomainST.newDomain;
import static nextgen.templates.domain.DomainST.newEntity;
import static nextgen.templates.java.JavaST.*;
import static nextgen.templates.npm.NpmST.*;

public class PettyNew {

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

        final Domain scanDomain = newDomain()
                .setName("Scan")
                .addEntities(newEntity()
                        .setName("ScanRoot")
                        .addFields("path", "String", true)
//                .addRelations("dates", RelationType)
                );

        writePojo(javaMainSrc, newPojo()
                .setPackage(scanDomainPackage)
                .setName("ScanRoot")
                .addFields("String", "path", null)
                .addLexical("path")
                .addAccessors(newPrimitiveAccessors().setClassName("ScanRoot").setName("path").setType("String"))
                .addFields(newList().setType("ScanDate"), "dates", newNewInstance().setType(newArrayList()))
                .addAccessors(newListAccessors().setType("ScanDate").setName("dates").setClassName("ScanRoot")));

        writePojo(javaMainSrc, newPojo()
                .setPackage(scanDomainPackage)
                .setName("ScanDate")
                .addFields("String", "date", null)
                .addFields("String", "raw", null)
                .addFields("String", "parsed", null)
                .addAccessors(newPrimitiveAccessors().setClassName("ScanDate").setName("date").setType("String"))
                .addAccessors(newPrimitiveAccessors().setClassName("ScanDate").setName("raw").setType("String"))
                .addAccessors(newPrimitiveAccessors().setClassName("ScanDate").setName("parsed").setType("String"))
                .addLexical("date"));

        writePojo(javaMainSrc, newPojo()
                .setPackage(scanDomainPackage)
                .setName("HtmlFileGroup")
                .addFields("String", "name", null)
                .addFields(VertxST.newJsonArrayType(), "properties", null)
                .addFields(newList().setType(newFileType()), "htmlFiles", newNewInstance().setType(newArrayList()))
                .addAccessors(newPrimitiveAccessors().setClassName("HtmlFileGroup").setName("name").setType("String"))
                .addAccessors(newPrimitiveAccessors().setClassName("HtmlFileGroup").setName("properties").setType(VertxST.newJsonArrayType()))
                .addAccessors(newListAccessors().setClassName("HtmlFileGroup").setName("htmlFiles").setType(newFileType()))
        );

        writePojoFactory(javaMainSrc, newPojoFactory()
                .setName("ScanFactory")
                .setPackage(scanDomainPackage)
                .addEntities("ScanRoot")
                .addEntities("ScanDate")
                .addEntities("HtmlFileGroup"));

        writeJsonWrapper(javaMainSrc, VertxST.newJsonWrapper()
                .setPackage(rmScanDomainPackage)
                .setName("RMPageModel")
                .addAccessors(VertxST.newListReferenceAccessors().setClassName("RMPageModel").setName("properties").setType("RMPosting"))
                .addAccessors(VertxST.newListReferenceAccessors().setClassName("RMPageModel").setName("pagination").setType("RMPagination"))
        );

        writeJsonWrapper(javaMainSrc, VertxST.newJsonWrapper()
                .setPackage(rmScanDomainPackage)
                .setName("RMPosting")
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("id").setType("Long"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("bedrooms").setType("Integer"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("displayAddress").setType("String"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("addedOrReduced").setType("String"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("propertySubType").setType("String"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("firstVisibleDate").setType("String"))
                .addAccessors(VertxST.newPrimitiveAccessors().setClassName("RMPosting").setName("propertyTypeFullDescription").setType("String"))
                .addAccessors(VertxST.newReferenceAccessors().setClassName("RMPosting").setName("listingUpdate").setType("RMListingUpdate"))
                .addAccessors(VertxST.newReferenceAccessors().setClassName("RMPosting").setName("location").setType("RMLocation"))
                .addAccessors(VertxST.newReferenceAccessors().setClassName("RMPosting").setName("price").setType("RMPrice"))
                .addAccessors(VertxST.newReferenceAccessors().setClassName("RMPosting").setName("customer").setType("RMCustomer"))
                .addAccessors(VertxST.newReferenceAccessors().setClassName("RMPageModel").setName("listingUpdate").setType("RMListingUpdate"))
        );

//
//        DomainToJson.generate(javaMainSrc, rmScanDomainPackage, newDomainBuilder("RM")
//                .add(newEntityBuilder("RMPageModel")
//                        .addOneToManyRelation("properties", newEntityBuilder("RMPosting")
//                                .addLongField("id")
//                                .addIntegerField("bedrooms")
//                                .addStringField("displayAddress")
//                                .addStringField("addedOrReduced")
//                                .addStringField("propertySubType")
//                                .addStringField("firstVisibleDate")
//                                .addStringField("propertyTypeFullDescription")
//                                .addOneToOneRelation("listingUpdate", newEntityBuilder("RMListingUpdate")
//                                        .addStringField("listingUpdateReason")
//                                        .addStringField("listingUpdateDate"))
//                                .addOneToOneRelation("location", newEntityBuilder("RMLocation")
//                                        .addDoubleField("latitude")
//                                        .addDoubleField("longitude"))
//                                .addOneToOneRelation("price", newEntityBuilder("RMPrice")
//                                        .addIntegerField("amount")
//                                        .addStringField("currencyCode"))
//                                .addOneToOneRelation("customer", newEntityBuilder("RMCustomer")
//                                        .addLongField("branchId")
//                                        .addStringField("branchDisplayName")
//                                        .addStringField("branchName")
//                                        .addStringField("brandTradingName")))
//                        .addOneToOneRelation("pagination", newEntityBuilder("RMPagination")
//                                .addStringField("total")
//                                .addStringField("next")
//                                .addStringField("page")
//                                .addOneToManyRelation("options", newEntityBuilder("RMPaginationOptions")
//                                        .addStringField("value")
//                                        .addStringField("description")))));
//
//        final EntityBuilder rmQuery = newEntityBuilder("RMUrl")
//                .addStringField("name")
//                .addStringField("path")
//                .addStringField("preQuery")
//                .addStringField("postQuery");
//
//        DomainToNeo4J.generate(javaMainSrc, rmScanDomainPackage, newDomainBuilder("RM")
//                .add(newEntityBuilder("RMConfig")
//                        .addStringField("name")
//                        .addStringField("host")
//                        .addStringField("protocol")
//                        .addOneToOneRelation("rentUrl", rmQuery)
//                        .addOneToOneRelation("salesPostcodeUrl", rmQuery)
//                        .addOneToOneRelation("salesBranchUrl", rmQuery)
//                        .addOneToManyRelation("scans", newEntityBuilder("RMScan")
//                                .addStringField("name", true)
//                                .addOneToOneRelation("searchType", newEnumEntity("RMSearchType", "RENT,SALES_POSTCODE,SALES_BRANCH"))
//                                .addStringField("locationIdentifier"))));
    }

    @Test
    public void generateNeoDomain() {

//        final EntityBuilder branch = newEntityBuilder("Branch")
//                .addLongField("id")
//                .addBooleanField("isPetty")
//                .addStringField("name");
//
//        final EntityBuilder agent = newEntityBuilder("Agent")
//                .addStringField("name")
//                .addOneToManyRelation("branches", branch);
//
//        final EntityBuilder postcode = newEntityBuilder("Postcode")
//                .addStringField("code");
//
//        final EntityBuilder area = newEntityBuilder("Area")
//                .addStringField("name", true)
//                .addOneToManyRelation("postcodes", postcode);
//
//        final EntityBuilder propertyListing = newEntityBuilder("PropertyListing")
//                .addLongField("id")
//                .addIntegerField("bedrooms")
//                .addStringField("streetAddress")
//                .addStringField("addedOrReduced")
//                .addStringField("propertySubType")
//                .addStringField("firstVisibleDate")
//                .addStringField("propertyTypeFullDescription")
//                .addStringField("listingUpdateReason")
//                .addStringField("listingUpdateDate")
//                .addDoubleField("latitude")
//                .addDoubleField("longitude")
//                .addIntegerField("price")
//                .addOneToOneRelation("branch", branch);
//
//        final EntityBuilder dateArea = newEntityBuilder("DateAreaListings")
//                .addOneToOneRelation("area", area)
//                .addOneToManyRelation("listings", propertyListing);
//
//        final EntityBuilder listingDate = newEntityBuilder("ListingDate")
//                .addStringField("date", true)
//                .addOneToManyRelation("areas", dateArea);
//
//        final Domain domain = newDomainBuilder("Domain")
//                .add(agent)
//                .add(listingDate)
//                .add(newEntityBuilder("Postcodes")
//                        .addStringField("country")
//                        .addOneToManyRelation("areas", newEntityBuilder("PostcodeArea")
//                                .addStringField("name")
//                                .addOneToManyRelation("districts", newEntityBuilder("PostcodeDistrict")
//                                        .addStringField("name")
//                                        .addOneToManyRelation("sectors", newEntityBuilder("PostcodeSector")
//                                                .addStringField("name")
//                                                .addOneToManyRelation("units", newEntityBuilder("PostcodeUnit")
//                                                        .addStringField("name"))))));
//
//        DomainToNeo4J.generate(javaMainSrc, domainPackage, domain);
    }

    @Test
    public void generateServer() {

//        final EntityBuilder serverSettings = newEntityBuilder("ServerSettings")
//                .addStringField("name", true)
//                .addStringField("tcpHost")
//                .addStringField("tcpName")
//                .addIntegerField("port")
//                .addStringField("webRoot")
//                .addOneToManyRelation("verticles", newEntityBuilder("VerticleSettings")
//                        .addStringField("name", true)
//                        .addStringField("className"))
//                .addOneToOneRelation("botSettings", newEntityBuilder("BotSettings")
//                        .addStringField("name", true)
//                        .addStringField("botToken")
//                        .addBooleanField("start"))
//                .addOneToOneRelation("ssl", newEntityBuilder("SSLSettings")
//                        .addStringField("name", true)
//                        .addStringField("key")
//                        .addStringField("cert"))
//                .addOneToOneRelation("jwt", newEntityBuilder("JWTSettings")
//                        .addStringField("name", true)
//                        .addStringField("path")
//                        .addStringField("password")
//                        .addStringField("type")
//                        .addIntegerField("expiresInMinutes")
//                        .addOneToManyRelation("users", newEntityBuilder("UserSettings")
//                                .addStringField("username", true)
//                                .addStringField("password")
//                                .addStringField("salt")));
//
//        DomainToNeo4J.generate(javaMainSrc, webDomainPackage, newDomainBuilder("Server")
//                .add(serverSettings));
//
//
//        final EntityBuilder serverDeploymentOptions = newEntityBuilder("ServerDeploymentOptions")
//                .addStringField("name", true)
//                .addStringField("tcpHost")
//                .addStringField("tcpName")
//                .addIntegerField("port")
//                .addStringField("webRoot")
//                .addOneToManyRelation("verticles", newEntityBuilder("VerticleDeploymentSettings")
//                        .addStringField("name", true)
//                        .addStringField("className"))
//                .addOneToOneRelation("botSettings", newEntityBuilder("BotDeploymentSettings")
//                        .addStringField("name", true)
//                        .addStringField("botToken")
//                        .addBooleanField("start"))
//                .addOneToOneRelation("ssl", newEntityBuilder("SSLDeploymentSettings")
//                        .addStringField("name", true)
//                        .addStringField("key")
//                        .addStringField("cert"))
//                .addOneToOneRelation("jwt", newEntityBuilder("JWTDeploymentSettings")
//                        .addStringField("name", true)
//                        .addStringField("path")
//                        .addStringField("password")
//                        .addStringField("type")
//                        .addIntegerField("expiresInMinutes")
//                        .addOneToManyRelation("users", newEntityBuilder("UserDeploymentSettings")
//                                .addStringField("username", true)
//                                .addStringField("token")
//                                .addStringField("password")
//                                .addStringField("salt")));
//
//        DomainToJson.generate(javaMainSrc, webDomainPackage, newDomainBuilder("Server")
//                .add(serverDeploymentOptions));
    }

    @Test
    public void generateWebApi() {

//        DomainToJson.generate(javaMainSrc, webApiPackage, newDomainBuilder("WebApi")
//                .add(newEntityBuilder("Response")
//                        .addEnumField("status", "ResponseStatus", "FAIL,SUCCESS")
//                        .addEnumField("payloadType", "PayloadType", "STRING,JSONOBJECT,JSONARRAY")
//                        .addOneToOneRelation("payload", newExternalEntity(Object.class)))
//                .add(newEntityBuilder("LoginRequest")
//                        .addStringField("username")
//                        .addStringField("password"))
//                .add(newEntityBuilder("JWTPayload")
//                        .addStringField("sub"))
//                .add(newEntityBuilder("UserSession")
//                        .addStringField("token")
//                        .addStringField("username")
//                        .addOneToManyRelation("menus", newEntityBuilder("UserMenu")
//                                .addIntegerField("key")
//                                .addStringField("url")
//                                .addStringField("label"))));
    }


    @Test
    public void generateReportingDomain() {

//        DomainToPojos.generate(javaMainSrc, reportDomain, newDomainBuilder("Reports")
//                .addEntities(newEntityBuilder("Trends")
//                        .addStringField("name", true)
//                        .addOneToOneRelation("today", )));

    }
}