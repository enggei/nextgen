package nextgen.projects;

import io.vertx.core.json.JsonArray;
import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;


public class PettyProject {

    private final File root = new File("/home/goe/projects/petty");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

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
    public void generateScanDomain() {

        DomainPatterns.writePojo(javaMainSrc, scanDomainPackage, newDomain("Scan")
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

        DomainPatterns.writeJsonWrapper(javaMainSrc, rmScanDomainPackage, newDomain("RM")
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

        DomainPatterns.writeNeo(javaMainSrc, rmScanDomainPackage, newDomain("RM")
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

        DomainPatterns.writeNeo(javaMainSrc, domainPackage.getName(), domain);
    }

    @Test
    public void generateExportDomain() {

        DomainPatterns.writeJsonWrapper(javaMainSrc, exportDomain, newDomain("Export")
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

        DomainPatterns.writeNeo(javaMainSrc, webDomainPackage, newDomain("Server")
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

        DomainPatterns.writeJsonWrapper(javaMainSrc, webDomainPackage, newDomain("Server")
                .addEntities(serverDeploymentOptions));
    }

    @Test
    public void generateWebApi() {

        DomainPatterns.writeJsonWrapper(javaMainSrc, webApiPackage, newDomain("WebApi")
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