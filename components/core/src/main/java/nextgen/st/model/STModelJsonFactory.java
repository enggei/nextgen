package nextgen.st.model;

public class STModelJsonFactory {

	public static void save(io.vertx.core.json.JsonObject jsonObject, java.io.File file) throws java.io.IOException {

		if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())
			throw new IllegalStateException("could not create " + file.getParentFile().getAbsolutePath());

		if (!file.exists() && !file.createNewFile())
			throw new IllegalStateException("could not create " + file.getAbsolutePath());

		java.nio.file.Files.write(file.toPath(), jsonObject.toBuffer().getBytes());
	}

	public static STModule newSTModule() { 
		return new STModule();
	}

	public static STModule newSTModuleNoUuid() { 
		return new STModule().removeUuid();
	}

	public static STModule newSTModule(io.vertx.core.json.JsonObject jsonObject) { 
		return new STModule(jsonObject);
	}

	public static STModule newSTModule(java.io.File file) throws java.io.IOException { 
		return new STModule(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static STModel newSTModel() { 
		return new STModel();
	}

	public static STModel newSTModelNoUuid() { 
		return new STModel().removeUuid();
	}

	public static STModel newSTModel(io.vertx.core.json.JsonObject jsonObject) { 
		return new STModel(jsonObject);
	}

	public static STModel newSTModel(java.io.File file) throws java.io.IOException { 
		return new STModel(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static STArgument newSTArgument() { 
		return new STArgument();
	}

	public static STArgument newSTArgumentNoUuid() { 
		return new STArgument().removeUuid();
	}

	public static STArgument newSTArgument(io.vertx.core.json.JsonObject jsonObject) { 
		return new STArgument(jsonObject);
	}

	public static STArgument newSTArgument(java.io.File file) throws java.io.IOException { 
		return new STArgument(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static STValue newSTValue() { 
		return new STValue();
	}

	public static STValue newSTValueNoUuid() { 
		return new STValue().removeUuid();
	}

	public static STValue newSTValue(io.vertx.core.json.JsonObject jsonObject) { 
		return new STValue(jsonObject);
	}

	public static STValue newSTValue(java.io.File file) throws java.io.IOException { 
		return new STValue(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public static STArgumentKV newSTArgumentKV() { 
		return new STArgumentKV();
	}

	public static STArgumentKV newSTArgumentKVNoUuid() { 
		return new STArgumentKV().removeUuid();
	}

	public static STArgumentKV newSTArgumentKV(io.vertx.core.json.JsonObject jsonObject) { 
		return new STArgumentKV(jsonObject);
	}

	public static STArgumentKV newSTArgumentKV(java.io.File file) throws java.io.IOException { 
		return new STArgumentKV(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

}