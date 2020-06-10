package tmp.ucs.domain;

public class UCSFactory {

	public static World newWorld() { 
		return new World();
	}

	public static Region newRegion() { 
		return new Region();
	}

	public static Country newCountry() { 
		return new Country();
	}

	public static City newCity() { 
		return new City();
	}

	public static Address newAddress() { 
		return new Address();
	}

	public static Exhibitor newExhibitor() { 
		return new Exhibitor();
	}

	public static Cinema newCinema() { 
		return new Cinema();
	}

	public static Screen newScreen() { 
		return new Screen();
	}

	public static Seat newSeat() { 
		return new Seat();
	}

}