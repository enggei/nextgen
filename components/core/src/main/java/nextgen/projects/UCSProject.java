package nextgen.projects;

import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;

public class UCSProject {

    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {
        final Domain domain = ucsDomain();
        DomainPatterns.writeJsonWrapper(new File(testRoot), "tmp.ucs.domain.json", domain);
        DomainPatterns.writePojo(new File(testRoot), "tmp.ucs.domain", domain);
        DomainPatterns.writeNeo(new File(testRoot), "tmp.ucs.domain.neo4j", domain);
    }

    public static Domain ucsDomain() {

        final Entity address = newEntity("Address")
                .addRelations(newStringField("street"))
                .addRelations(newIntegerField("no"))
                .addRelations(newStringField("letter"));

        return newDomain("UCS")
                .addEntities(newEntity("World")
                        .addRelations(newOneToMany("regions", newEntity("Region")
                                .addRelations(newStringField("name"))
                                .addRelations(newOneToMany("countries", newEntity("Country")
                                        .addRelations(newStringField("name"))
                                        .addRelations(newOneToMany("cities", newEntity("City")
                                                .addRelations(newStringField("name"))
                                                .addRelations(newOneToMany("addresses", address)))))))))
                .addEntities(newEntity("Exhibitor")
                        .addRelations(newStringField("name"))
                        .addRelations(newOneToMany("cinemas", newEntity("Cinema")
                                .addRelations(newStringField("name"))
                                .addRelations(newOneToManyString("aliases"))
                                .addRelations(newOneToOne("address", address))
                                .addRelations(newOneToMany("screens", newEntity("Screen")
                                        .addRelations(newStringField("name"))
                                        .addRelations(newEnumField("status", newEnum("ScreenStatus", "OPEN,CLOSED")))
                                        .addRelations(newBooleanField("active"))
                                        .addRelations(newOneToMany("seats", newEntity("Seat")
                                                .addRelations(newIntegerField("no"))
                                                .addRelations(newEnumField("status", newEnum("SeatStatus", "AVAILABLE,BROKEN"))))))))));
    }
}