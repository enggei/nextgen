package tmp.ucs.domain.json;

public class UCSJsonFactory {

	public static World newWorld() { 
		return new World();
	}

	public static World newWorld(io.vertx.core.json.JsonObject jsonObject) { 
		return new World(jsonObject);
	}

	public static Region newRegion() { 
		return new Region();
	}

	public static Region newRegion(io.vertx.core.json.JsonObject jsonObject) { 
		return new Region(jsonObject);
	}

	public static Country newCountry() { 
		return new Country();
	}

	public static Country newCountry(io.vertx.core.json.JsonObject jsonObject) { 
		return new Country(jsonObject);
	}

	public static City newCity() { 
		return new City();
	}

	public static City newCity(io.vertx.core.json.JsonObject jsonObject) { 
		return new City(jsonObject);
	}

	public static Address newAddress() { 
		return new Address();
	}

	public static Address newAddress(io.vertx.core.json.JsonObject jsonObject) { 
		return new Address(jsonObject);
	}

	public static Exhibitor newExhibitor() { 
		return new Exhibitor();
	}

	public static Exhibitor newExhibitor(io.vertx.core.json.JsonObject jsonObject) { 
		return new Exhibitor(jsonObject);
	}

	public static Cinema newCinema() { 
		return new Cinema();
	}

	public static Cinema newCinema(io.vertx.core.json.JsonObject jsonObject) { 
		return new Cinema(jsonObject);
	}

	public static Screen newScreen() { 
		return new Screen();
	}

	public static Screen newScreen(io.vertx.core.json.JsonObject jsonObject) { 
		return new Screen(jsonObject);
	}

	public static Seat newSeat() { 
		return new Seat();
	}

	public static Seat newSeat(io.vertx.core.json.JsonObject jsonObject) { 
		return new Seat(jsonObject);
	}

}