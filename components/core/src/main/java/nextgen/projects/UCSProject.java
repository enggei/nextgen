package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.*;

import static nextgen.domain.DomainPatterns.*;

public class UCSProject {

    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {
        DomainToPojos.generate(testRoot, "tmp.ucs.domain", ucsDomain());
        DomainToNeo4J.generate(testRoot, "tmp.ucs.domain.neo4j", ucsDomain());
        DomainToJson.generate(testRoot, "tmp.ucs.domain.json", ucsDomain());
    }

    public static Domain ucsDomain() {

        final EntityBuilder address = newEntityBuilder("Address")
                .addStringField("street")
                .addIntegerField("no")
                .addStringField("letter");

        return newDomainBuilder("UCS")
                .add(newEntityBuilder("World")
                        .addOneToManyRelation("regions", newEntityBuilder("Region")
                                .addStringField("name")
                                .addOneToManyRelation("countries", newEntityBuilder("Country")
                                        .addStringField("name")
                                        .addOneToManyRelation("cities", newEntityBuilder("City")
                                                .addStringField("name")
                                                .addOneToManyRelation("addresses", address)))))
                .add(newEntityBuilder("Exhibitor")
                        .addStringField("name")
                        .addOneToManyRelation("cinemas", newEntityBuilder("Cinema")
                                .addStringField("name")
                                .addOneToManyRelation("aliases",newString())
                                .addOneToOneRelation("address", address)
                                .addOneToManyRelation("screens", newEntityBuilder("Screen")
                                        .addStringField("name")
                                        .addOneToOneRelation("status", newEnumEntity("ScreenStatus", "OPEN,CLOSED"))
                                        .addOneToOneRelation("active", newBoolean())
                                        .addOneToManyRelation("seats", newEntityBuilder("Seat")
                                                .addIntegerField("no")
                                                .addOneToOneRelation("status", newEnumEntity("SeatStatus", "AVAILABLE,BROKEN"))))));
    }
}