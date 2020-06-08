package tmp.ucs.domain.neo4j;


public class UCSNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public UCSNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
	}

	public UCSNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
		this.db = db;
	}

	public org.neo4j.graphdb.GraphDatabaseService getDatabaseService() { 
		return this.db;
	}

	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action) { 
		doInTransaction(action, java.lang.Throwable::printStackTrace);
	}

	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action, java.util.function.Consumer<java.lang.Throwable> onException) { 
		try (org.neo4j.graphdb.Transaction tx = db.beginTx())  { 
			action.accept(tx);
			tx.success();
		} catch (java.lang.Throwable t)  { 
			onException.accept(t);
		}
	}

	public World newWorld() { 
		return newWorld(db.createNode(org.neo4j.graphdb.Label.label("World")));
	}

	public World newWorld(org.neo4j.graphdb.Node node) { 
		return new World(node);
	}

	public java.util.stream.Stream<World> findAllWorld() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("World")).stream().map(this::newWorld);
	}

	public Region newRegion() { 
		return newRegion(db.createNode(org.neo4j.graphdb.Label.label("Region")));
	}

	public Region newRegion(org.neo4j.graphdb.Node node) { 
		return new Region(node);
	}

	public java.util.stream.Stream<Region> findAllRegion() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Region")).stream().map(this::newRegion);
	}

	public Country newCountry() { 
		return newCountry(db.createNode(org.neo4j.graphdb.Label.label("Country")));
	}

	public Country newCountry(org.neo4j.graphdb.Node node) { 
		return new Country(node);
	}

	public java.util.stream.Stream<Country> findAllCountry() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Country")).stream().map(this::newCountry);
	}

	public City newCity() { 
		return newCity(db.createNode(org.neo4j.graphdb.Label.label("City")));
	}

	public City newCity(org.neo4j.graphdb.Node node) { 
		return new City(node);
	}

	public java.util.stream.Stream<City> findAllCity() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("City")).stream().map(this::newCity);
	}

	public Address newAddress() { 
		return newAddress(db.createNode(org.neo4j.graphdb.Label.label("Address")));
	}

	public Address newAddress(org.neo4j.graphdb.Node node) { 
		return new Address(node);
	}

	public java.util.stream.Stream<Address> findAllAddress() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Address")).stream().map(this::newAddress);
	}

	public Exhibitor newExhibitor() { 
		return newExhibitor(db.createNode(org.neo4j.graphdb.Label.label("Exhibitor")));
	}

	public Exhibitor newExhibitor(org.neo4j.graphdb.Node node) { 
		return new Exhibitor(node);
	}

	public java.util.stream.Stream<Exhibitor> findAllExhibitor() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Exhibitor")).stream().map(this::newExhibitor);
	}

	public Cinema newCinema() { 
		return newCinema(db.createNode(org.neo4j.graphdb.Label.label("Cinema")));
	}

	public Cinema newCinema(org.neo4j.graphdb.Node node) { 
		return new Cinema(node);
	}

	public java.util.stream.Stream<Cinema> findAllCinema() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Cinema")).stream().map(this::newCinema);
	}

	public Screen newScreen() { 
		return newScreen(db.createNode(org.neo4j.graphdb.Label.label("Screen")));
	}

	public Screen newScreen(org.neo4j.graphdb.Node node) { 
		return new Screen(node);
	}

	public java.util.stream.Stream<Screen> findAllScreen() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Screen")).stream().map(this::newScreen);
	}

	public Seat newSeat() { 
		return newSeat(db.createNode(org.neo4j.graphdb.Label.label("Seat")));
	}

	public Seat newSeat(org.neo4j.graphdb.Node node) { 
		return new Seat(node);
	}

	public java.util.stream.Stream<Seat> findAllSeat() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Seat")).stream().map(this::newSeat);
	}

	public Region findRegionByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Region"), "name", value);
		return node == null ? null : new Region(node);
	}

	public Region findOrCreateRegionByName(String value) { 
		final Region existing = findRegionByName(value);
		return existing == null ? newRegion().setName(value) : existing;
	}

	public java.util.stream.Stream<Region> findAllRegionByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Region"), "name", value).stream().map(this::newRegion);
	}

	public Country findCountryByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Country"), "name", value);
		return node == null ? null : new Country(node);
	}

	public Country findOrCreateCountryByName(String value) { 
		final Country existing = findCountryByName(value);
		return existing == null ? newCountry().setName(value) : existing;
	}

	public java.util.stream.Stream<Country> findAllCountryByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Country"), "name", value).stream().map(this::newCountry);
	}

	public City findCityByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("City"), "name", value);
		return node == null ? null : new City(node);
	}

	public City findOrCreateCityByName(String value) { 
		final City existing = findCityByName(value);
		return existing == null ? newCity().setName(value) : existing;
	}

	public java.util.stream.Stream<City> findAllCityByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("City"), "name", value).stream().map(this::newCity);
	}

	public Address findAddressByStreet(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Address"), "street", value);
		return node == null ? null : new Address(node);
	}

	public Address findOrCreateAddressByStreet(String value) { 
		final Address existing = findAddressByStreet(value);
		return existing == null ? newAddress().setStreet(value) : existing;
	}

	public java.util.stream.Stream<Address> findAllAddressByStreet(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Address"), "street", value).stream().map(this::newAddress);
	}

	public Address findAddressByNo(Integer value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Address"), "no", value);
		return node == null ? null : new Address(node);
	}

	public Address findOrCreateAddressByNo(Integer value) { 
		final Address existing = findAddressByNo(value);
		return existing == null ? newAddress().setNo(value) : existing;
	}

	public java.util.stream.Stream<Address> findAllAddressByNo(Integer value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Address"), "no", value).stream().map(this::newAddress);
	}

	public Address findAddressByLetter(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Address"), "letter", value);
		return node == null ? null : new Address(node);
	}

	public Address findOrCreateAddressByLetter(String value) { 
		final Address existing = findAddressByLetter(value);
		return existing == null ? newAddress().setLetter(value) : existing;
	}

	public java.util.stream.Stream<Address> findAllAddressByLetter(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Address"), "letter", value).stream().map(this::newAddress);
	}

	public Exhibitor findExhibitorByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Exhibitor"), "name", value);
		return node == null ? null : new Exhibitor(node);
	}

	public Exhibitor findOrCreateExhibitorByName(String value) { 
		final Exhibitor existing = findExhibitorByName(value);
		return existing == null ? newExhibitor().setName(value) : existing;
	}

	public java.util.stream.Stream<Exhibitor> findAllExhibitorByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Exhibitor"), "name", value).stream().map(this::newExhibitor);
	}

	public Cinema findCinemaByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Cinema"), "name", value);
		return node == null ? null : new Cinema(node);
	}

	public Cinema findOrCreateCinemaByName(String value) { 
		final Cinema existing = findCinemaByName(value);
		return existing == null ? newCinema().setName(value) : existing;
	}

	public java.util.stream.Stream<Cinema> findAllCinemaByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Cinema"), "name", value).stream().map(this::newCinema);
	}

	public Screen findScreenByName(String value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Screen"), "name", value);
		return node == null ? null : new Screen(node);
	}

	public Screen findOrCreateScreenByName(String value) { 
		final Screen existing = findScreenByName(value);
		return existing == null ? newScreen().setName(value) : existing;
	}

	public java.util.stream.Stream<Screen> findAllScreenByName(String value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Screen"), "name", value).stream().map(this::newScreen);
	}

	public Screen findScreenByStatus(ScreenStatus value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Screen"), "status", value.name());
		return node == null ? null : new Screen(node);
	}

	public java.util.stream.Stream<Screen> findAllScreenByStatus(ScreenStatus value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Screen"), "status", value.name()).stream().map(this::newScreen);
	}

	public Screen findScreenByActive(Boolean value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Screen"), "active", value);
		return node == null ? null : new Screen(node);
	}

	public Screen findOrCreateScreenByActive(Boolean value) { 
		final Screen existing = findScreenByActive(value);
		return existing == null ? newScreen().setActive(value) : existing;
	}

	public java.util.stream.Stream<Screen> findAllScreenByActive(Boolean value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Screen"), "active", value).stream().map(this::newScreen);
	}

	public Seat findSeatByNo(Integer value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Seat"), "no", value);
		return node == null ? null : new Seat(node);
	}

	public Seat findOrCreateSeatByNo(Integer value) { 
		final Seat existing = findSeatByNo(value);
		return existing == null ? newSeat().setNo(value) : existing;
	}

	public java.util.stream.Stream<Seat> findAllSeatByNo(Integer value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Seat"), "no", value).stream().map(this::newSeat);
	}

	public Seat findSeatByStatus(SeatStatus value) { 
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Seat"), "status", value.name());
		return node == null ? null : new Seat(node);
	}

	public java.util.stream.Stream<Seat> findAllSeatByStatus(SeatStatus value) { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Seat"), "status", value.name()).stream().map(this::newSeat);
	}
}