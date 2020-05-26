package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Enum;
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

        final Enum screenStatusEnum = newEnum("ScreenStatus", "OPEN,CLOSED");

        final Property name = newStringProperty("Name");
        final Property string = newStringProperty("Value");
        final Property active = newBooleanProperty("Active");
        final Property seatNo = newIntegerProperty("No");
        final Property seatCount = newIntegerProperty("SeatCount");
        final Property screenStatus = newEnumProperty("Status", screenStatusEnum);

        final Entity stringEntity = newEntity("StringNode")
                .addProperties(string);

        final Entity exhibitor = newEntity("Exhibitor")
                .addProperties(name);

        final Entity city = newEntity("City")
                .addProperties(name);

        final Entity address = newEntity("Address")
                .addProperties(string);

        final Entity cinema = newEntity("Cinema")
                .addProperties(name);

        final Entity screen = newEntity("Screen")
                .addProperties(name)
                .addProperties(seatCount)
                .addProperties(active)
                .addProperties(screenStatus);

        final Entity seat = newEntity("Seat")
                .addProperties(seatNo)
                .addProperties(active);

        final Relation exhibitor_presence_city = newManyToManyRelation("Presence", exhibitor, city);
        final Relation cinema_location_address = newOneToOneRelation("Location", cinema, address);
        final Relation exhibitor_owner_cinema = newManyToOneRelation("Owner", cinema, exhibitor);
        final Relation cinema_screens_screen = newOneToManyRelation("Screens", cinema, screen);
        final Relation screen_seats_seat = newOneToManyRelation("Seats", screen, seat);
        final Relation cinema_names_name = newOneToManyRelation("Names", cinema, stringEntity);

        return newDomain()
                .setName("UCS")
                .addEntities(city)
                .addEntities(address)
                .addEntities(exhibitor)
                .addEntities(cinema)
                .addEntities(stringEntity)
                .addEntities(screen)
                .addEnums(screenStatusEnum)
                .addEntities(seat)
                .addRelations(cinema_location_address)
                .addRelations(cinema_names_name)
                .addRelations(exhibitor_presence_city)
                .addRelations(exhibitor_owner_cinema)
                .addRelations(cinema_screens_screen)
                .addRelations(screen_seats_seat);
    }
}