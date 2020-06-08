package nextgen.projects;

import io.vertx.core.json.JsonArray;
import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Domain;
import nextgen.java.st.PackageDeclaration;
import org.junit.Test;

import java.io.File;

import static nextgen.domain.DomainPatterns.*;
import static nextgen.java.JavaPatterns.newPackageDeclaration;

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
//        MavenPatterns.printDependenciesAsFluent(new File("/home/goe/property/RealProperty/pom.xml"));
    }

    @Test
    public void generateReportingDomain() {

//        DomainToPojos.generate(javaMainSrc, reportDomain, newDomainBuilder("Reports")
//                .addEntities(newEntityBuilder("Trends")
//                        .addStringField("name", true)
//                        .addOneToOneRelation("today", )));

    }
}