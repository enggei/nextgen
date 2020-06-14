package org.test.neo4j;

public class KotlinTestNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public KotlinTestNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public KotlinTestNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
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

	public Country newCountry() { 
		return newCountry(db.createNode(org.neo4j.graphdb.Label.label("Country")));
	}

	public Country newCountry(org.neo4j.graphdb.Node node) { 
		return new Country(node);
	}

	public java.util.stream.Stream<Country> findAllCountry() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Country")).stream().map(this::newCountry);
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

	public Country findCountryById(Long value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Country"), "id", value);
		return node == null ? null : new Country(node);
	}

	public Country findOrCreateCountryById(Long value) {
		final Country existing = findCountryById(value);
		return existing == null ? newCountry().setId(value) : existing;
	}

	public java.util.stream.Stream<Country> findAllCountryById(Long value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("Country"), "id", value).stream().map(this::newCountry);
	}

	public Capitol newCapitol() { 
		return newCapitol(db.createNode(org.neo4j.graphdb.Label.label("Capitol")));
	}

	public Capitol newCapitol(org.neo4j.graphdb.Node node) { 
		return new Capitol(node);
	}

	public java.util.stream.Stream<Capitol> findAllCapitol() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("Capitol")).stream().map(this::newCapitol);
	}

	public Capitol findCapitolByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Capitol"), "name", value);
		return node == null ? null : new Capitol(node);
	}

	public Capitol findOrCreateCapitolByName(String value) {
		final Capitol existing = findCapitolByName(value);
		return existing == null ? newCapitol().setName(value) : existing;
	}

	public java.util.stream.Stream<Capitol> findAllCapitolByName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("Capitol"), "name", value).stream().map(this::newCapitol);
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

	public City findCityByPopulation(Long value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("City"), "population", value);
		return node == null ? null : new City(node);
	}

	public City findOrCreateCityByPopulation(Long value) {
		final City existing = findCityByPopulation(value);
		return existing == null ? newCity().setPopulation(value) : existing;
	}

	public java.util.stream.Stream<City> findAllCityByPopulation(Long value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("City"), "population", value).stream().map(this::newCity);
	}
}