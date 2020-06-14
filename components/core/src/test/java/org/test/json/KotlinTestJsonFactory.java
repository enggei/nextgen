package org.test.json;

public class KotlinTestJsonFactory {

	public static void save(io.vertx.core.json.JsonObject jsonObject, java.io.File file) throws java.io.IOException {

		if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())
			throw new IllegalStateException("could not create " + file.getParentFile().getAbsolutePath());

		if (!file.exists() && !file.createNewFile())
			throw new IllegalStateException("could not create " + file.getAbsolutePath());

		java.nio.file.Files.write(file.toPath(), jsonObject.toBuffer().getBytes());
	}

	public static Country newCountry() { 
		return new Country();
	}

	public static Country newCountryNoUuid() { 
		return new Country().removeUuid();
	}

	public static Country newCountry(io.vertx.core.json.JsonObject jsonObject) { 
		return new Country(jsonObject);
	}

	public static Country newCountry(java.io.File file) throws java.io.IOException { 
		return new Country(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static Capitol newCapitol() { 
		return new Capitol();
	}

	public static Capitol newCapitolNoUuid() { 
		return new Capitol().removeUuid();
	}

	public static Capitol newCapitol(io.vertx.core.json.JsonObject jsonObject) { 
		return new Capitol(jsonObject);
	}

	public static Capitol newCapitol(java.io.File file) throws java.io.IOException { 
		return new Capitol(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static City newCity() { 
		return new City();
	}

	public static City newCityNoUuid() { 
		return new City().removeUuid();
	}

	public static City newCity(io.vertx.core.json.JsonObject jsonObject) { 
		return new City(jsonObject);
	}

	public static City newCity(java.io.File file) throws java.io.IOException { 
		return new City(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

}