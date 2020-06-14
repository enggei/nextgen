package org.test;

public class KotlinTestFactory {

	public static Country newCountry() { 
		return new Country();
	}

	public static Capitol newCapitol() { 
		return new Capitol();
	}

	public static City newCity() { 
		return new City();
	}

}