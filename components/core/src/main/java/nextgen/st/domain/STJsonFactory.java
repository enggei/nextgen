package nextgen.st.domain;

public class STJsonFactory {

	public static io.vertx.core.json.JsonObject load(java.io.File file) throws java.io.IOException {
		if (!file.exists() || !file.isFile()) throw new IllegalArgumentException("could not read " + file.getAbsolutePath());
		return new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath())));
	}

	public static io.vertx.core.json.JsonObject load(java.io.InputStream inputStream) throws java.io.IOException {
		if (inputStream == null) throw new java.io.IOException("inputStream is null");
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		int read;
		byte[] data = new byte[2048];
		while ((read = inputStream.read(data, 0, data.length)) != -1)
			buffer.write(data, 0, read);
		inputStream.close();
		final byte[] content = buffer.toByteArray();
		buffer.close();
		return new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(content));
	}

	public static void save(io.vertx.core.json.JsonObject jsonObject, java.io.File file) throws java.io.IOException {

		if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())
			throw new IllegalStateException("could not create " + file.getParentFile().getAbsolutePath());

		if (!file.exists() && !file.createNewFile())
			throw new IllegalStateException("could not create " + file.getAbsolutePath());

		java.nio.file.Files.write(file.toPath(), jsonObject.toBuffer().getBytes());
	}

	public static STAppModel newSTAppModel() { 
		return new STAppModel();
	}

	public static STAppModel newSTAppModelNoUuid() { 
		return new STAppModel().removeUuid();
	}

	public static STAppModel newSTAppModel(io.vertx.core.json.JsonObject jsonObject) { 
		return new STAppModel(jsonObject);
	}

	public static STAppModel newSTAppModel(java.io.File file) throws java.io.IOException { 
		return new STAppModel(load(file));
	}

	public static STAppModel merge(STAppModel lhs, STAppModel rhs) {
		return newSTAppModel(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}


}