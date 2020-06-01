package test;

import org.junit.Assert;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import tmp.ucs.domain.neo4j.*;

import java.util.stream.Collectors;

public class UCSTests {

    public static void main(String[] args) {

        final UCSNeoFactory ucs = new UCSNeoFactory("./ucs_db");

        ucs.doInTransaction(transaction -> {
            ucs.getDatabaseService().getAllRelationships().forEach(Relationship::delete);
            ucs.getDatabaseService().getAllNodes().forEach(Node::delete);
        });

        ucs.doInTransaction(transaction -> {
            final Address bergenStreet = ucs.newAddress().setStreet("Bergen Street").setNo(100).setLetter("a");
            final Address bergenAvenue = ucs.newAddress().setStreet("Bergen Avenue").setNo(52);
            final Address osloStreet = ucs.newAddress().setStreet("Oslo Street").setNo(99);

            ucs.newWorld()
                    .addRegions(ucs.newRegion().setName("Europe")
                            .addCountries(ucs.newCountry().setName("Norway")
                                    .addCities(ucs.newCity().setName("Bergen")
                                            .addAddresses(bergenStreet)
                                            .addAddresses(bergenAvenue))
                                    .addCities(ucs.newCity().setName("Oslo")
                                            .addAddresses(osloStreet))));

            final Exhibitor bergenKino = ucs.newExhibitor().setName("Bergen Kino");
            final Exhibitor osloCinematografer = ucs.newExhibitor().setName("Oslo Cinematografer");

            final Cinema konsertpaleet = ucs.newCinema()
                    .setName("Konsertpaleet")
                    .setAddress(bergenStreet)
                    .addScreens(ucs.newScreen().setName("KP 1").setActive(Boolean.TRUE).setStatus(ScreenStatus.OPEN)
                            .addSeats(ucs.newSeat().setNo(1).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(2).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(3).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(4).setStatus(SeatStatus.BROKEN))
                            .addSeats(ucs.newSeat().setNo(5).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(6).setStatus(SeatStatus.AVAILABLE)))
                    .addScreens(ucs.newScreen().setName("KP 2").setActive(Boolean.FALSE).setStatus(ScreenStatus.CLOSED)
                            .addSeats(ucs.newSeat().setNo(1).setStatus(SeatStatus.BROKEN))
                            .addSeats(ucs.newSeat().setNo(2).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(3).setStatus(SeatStatus.AVAILABLE)))
                    .addScreens(ucs.newScreen().setName("KP 3").setActive(Boolean.TRUE).setStatus(ScreenStatus.OPEN)
                            .addSeats(ucs.newSeat().setNo(1).setStatus(SeatStatus.AVAILABLE))
                            .addSeats(ucs.newSeat().setNo(2).setStatus(SeatStatus.BROKEN))
                            .addSeats(ucs.newSeat().setNo(3).setStatus(SeatStatus.AVAILABLE)));

            final Cinema magnusBarfot = ucs.newCinema()
                    .setName("Magnus Barfot")
                    .setAddress(bergenAvenue)
                    .addScreens(ucs.newScreen().setName("MB 1").setActive(Boolean.TRUE).setStatus(ScreenStatus.OPEN))
                    .addScreens(ucs.newScreen().setName("MB 2").setActive(Boolean.TRUE));

            bergenKino.addCinemas(konsertpaleet).addCinemas(magnusBarfot);

            final Cinema saga = ucs.newCinema()
                    .setName("Saga")
                    .setAddress(osloStreet)
                    .addScreens(ucs.newScreen().setName("Saga 1").setActive(Boolean.TRUE).setStatus(ScreenStatus.OPEN));

            osloCinematografer.addCinemas(saga);
        });

        ucs.doInTransaction(transaction -> {
            System.out.println("Init state:");
            print(ucs);

        });

        ucs.doInTransaction(transaction -> {
            System.out.println("Updating");

            System.out.println("Adding MB 3 to Magnus Barfot");
            ucs.findCinemaByName("Magnus Barfot").addScreens(ucs.newScreen().setName("MB 3"));

            System.out.println("Moving KP 1 to Saga");
            final Screen kp1 = ucs.findScreenByName("KP 1");
            ucs.findCinemaByName("Konsertpaleet").removeScreens(kp1);
            ucs.findCinemaByName("Saga").addScreens(kp1);

            System.out.println("Moving Konsertpaleet to Street X");
            ucs.findCinemaByName("Konsertpaleet").setAddress(ucs.newAddress().setStreet("Street X").setNo(88));

            System.out.println("Closing MB 2");
            ucs.findScreenByName("MB 2").setStatus(ScreenStatus.CLOSED);

            System.out.println("Adding alias name to Saga");
            ucs.findCinemaByName("Saga").addAliases("Saga Kinoer").addAliases("SA");
        });

        ucs.doInTransaction(transaction -> {
            System.out.println("After state:");

            print(ucs);

            Assert.assertEquals("Magnus Barfot should have 3 screens", 3, ucs.findCinemaByName("Magnus Barfot").getScreens().collect(Collectors.toSet()).size());
            Assert.assertEquals("Saga should have 2 screens", 2, ucs.findCinemaByName("Saga").getScreens().collect(Collectors.toSet()).size());
            Assert.assertEquals("Konsertpaleet should have 2 screens", 2, ucs.findCinemaByName("Konsertpaleet").getScreens().collect(Collectors.toSet()).size());
            Assert.assertTrue("KP 1 should be in Saga", ucs.findCinemaByName("Saga").getScreens().anyMatch(screen -> screen.getName().equals("KP 1")));
            Assert.assertTrue("KP 1 should not be in Konsertpaleet", ucs.findCinemaByName("Konsertpaleet").getScreens().noneMatch(screen -> screen.getName().equals("KP 1")));
            Assert.assertEquals("Konsertpaleet should be moved to Street X", ucs.findAddressByStreet("Street X"), ucs.findCinemaByName("Konsertpaleet").getAddress());
            //Assert.assertNull("Street a2 should have no cinemas", ucs.findAddressByStreet("Bergen Street"));
            Assert.assertEquals("MB 2 should be closed", ScreenStatus.CLOSED, ucs.findScreenByName("MB 2").getStatus());
        });
    }

    private static void print(UCSNeoFactory ucs) {

        ucs.findAllWorld().forEach(world -> {
            world.getRegions().forEach(region -> {
                System.out.println(region.getName());
                region.getCountries().forEach(country -> {
                    System.out.println("\t" + country.getName());
                    country.getCities().forEach(city -> {
                        System.out.println("\t\t" + city.getName());
                        city.getAddresses().forEach(address -> {
                            System.out.println("\t\t\t" + address.getStreet());
                        });
                    });
                });
            });
        });

        ucs.findAllExhibitor().forEach(exhibitor -> {
            System.out.println(exhibitor.getName());

            exhibitor.getCinemas().forEach(cinema -> {
                System.out.print("\t\t" + cinema.getName() + " " + cinema.getAddress().getStreet() + " aliases:");
                cinema.getAliases().forEach(stringNode -> System.out.print(" '" + stringNode + "'"));
                System.out.println();
                cinema.getScreens().forEach(screen -> {
                    System.out.println("\t\t\t" + screen.getName() + " (" + screen.getSeats().count() + ")" + (screen.getActive(false) ? " ACTIVE " : " ") + (screen.getStatus(ScreenStatus.CLOSED)));
                    screen.getSeats().forEach(seat -> System.out.println("\t\t\t\tSeat #" + seat.getNo() + " " + seat.getStatus()));
                });
            });
        });

        for (ScreenStatus screenStatus : ScreenStatus.values()) {
            System.out.println("Screen status " + screenStatus.name());
            ucs.findAllScreenByStatus(screenStatus).forEach(screen -> System.out.println("\t" + screen.getName()));
        }
    }
}