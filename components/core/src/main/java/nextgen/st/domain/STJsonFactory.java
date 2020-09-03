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

	public static STGDirectory newSTGDirectory() { 
		return new STGDirectory();
	}

	public static STGDirectory newSTGDirectoryNoUuid() { 
		return new STGDirectory().removeUuid();
	}

	public static STGDirectory newSTGDirectory(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGDirectory(jsonObject);
	}

	public static STGDirectory newSTGDirectory(java.io.File file) throws java.io.IOException { 
		return new STGDirectory(load(file));
	}

	public static STGDirectory merge(STGDirectory lhs, STGDirectory rhs) {
		return newSTGDirectory(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STGroupModel newSTGroupModel() { 
		return new STGroupModel();
	}

	public static STGroupModel newSTGroupModelNoUuid() { 
		return new STGroupModel().removeUuid();
	}

	public static STGroupModel newSTGroupModel(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGroupModel(jsonObject);
	}

	public static STGroupModel newSTGroupModel(java.io.File file) throws java.io.IOException { 
		return new STGroupModel(load(file));
	}

	public static STGroupModel merge(STGroupModel lhs, STGroupModel rhs) {
		return newSTGroupModel(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STTemplate newSTTemplate() { 
		return new STTemplate();
	}

	public static STTemplate newSTTemplateNoUuid() { 
		return new STTemplate().removeUuid();
	}

	public static STTemplate newSTTemplate(io.vertx.core.json.JsonObject jsonObject) { 
		return new STTemplate(jsonObject);
	}

	public static STTemplate newSTTemplate(java.io.File file) throws java.io.IOException { 
		return new STTemplate(load(file));
	}

	public static STTemplate merge(STTemplate lhs, STTemplate rhs) {
		return newSTTemplate(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STParameter newSTParameter() { 
		return new STParameter();
	}

	public static STParameter newSTParameterNoUuid() { 
		return new STParameter().removeUuid();
	}

	public static STParameter newSTParameter(io.vertx.core.json.JsonObject jsonObject) { 
		return new STParameter(jsonObject);
	}

	public static STParameter newSTParameter(java.io.File file) throws java.io.IOException { 
		return new STParameter(load(file));
	}

	public static STParameter merge(STParameter lhs, STParameter rhs) {
		return newSTParameter(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STParameterKey newSTParameterKey() { 
		return new STParameterKey();
	}

	public static STParameterKey newSTParameterKeyNoUuid() { 
		return new STParameterKey().removeUuid();
	}

	public static STParameterKey newSTParameterKey(io.vertx.core.json.JsonObject jsonObject) { 
		return new STParameterKey(jsonObject);
	}

	public static STParameterKey newSTParameterKey(java.io.File file) throws java.io.IOException { 
		return new STParameterKey(load(file));
	}

	public static STParameterKey merge(STParameterKey lhs, STParameterKey rhs) {
		return newSTParameterKey(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STInterface newSTInterface() { 
		return new STInterface();
	}

	public static STInterface newSTInterfaceNoUuid() { 
		return new STInterface().removeUuid();
	}

	public static STInterface newSTInterface(io.vertx.core.json.JsonObject jsonObject) { 
		return new STInterface(jsonObject);
	}

	public static STInterface newSTInterface(java.io.File file) throws java.io.IOException { 
		return new STInterface(load(file));
	}

	public static STInterface merge(STInterface lhs, STInterface rhs) {
		return newSTInterface(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STEnum newSTEnum() { 
		return new STEnum();
	}

	public static STEnum newSTEnumNoUuid() { 
		return new STEnum().removeUuid();
	}

	public static STEnum newSTEnum(io.vertx.core.json.JsonObject jsonObject) { 
		return new STEnum(jsonObject);
	}

	public static STEnum newSTEnum(java.io.File file) throws java.io.IOException { 
		return new STEnum(load(file));
	}

	public static STEnum merge(STEnum lhs, STEnum rhs) {
		return newSTEnum(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STEnumValue newSTEnumValue() { 
		return new STEnumValue();
	}

	public static STEnumValue newSTEnumValueNoUuid() { 
		return new STEnumValue().removeUuid();
	}

	public static STEnumValue newSTEnumValue(io.vertx.core.json.JsonObject jsonObject) { 
		return new STEnumValue(jsonObject);
	}

	public static STEnumValue newSTEnumValue(java.io.File file) throws java.io.IOException { 
		return new STEnumValue(load(file));
	}

	public static STEnumValue merge(STEnumValue lhs, STEnumValue rhs) {
		return newSTEnumValue(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STGParseResult newSTGParseResult() { 
		return new STGParseResult();
	}

	public static STGParseResult newSTGParseResultNoUuid() { 
		return new STGParseResult().removeUuid();
	}

	public static STGParseResult newSTGParseResult(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGParseResult(jsonObject);
	}

	public static STGParseResult newSTGParseResult(java.io.File file) throws java.io.IOException { 
		return new STGParseResult(load(file));
	}

	public static STGParseResult merge(STGParseResult lhs, STGParseResult rhs) {
		return newSTGParseResult(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

	public static STGError newSTGError() { 
		return new STGError();
	}

	public static STGError newSTGErrorNoUuid() { 
		return new STGError().removeUuid();
	}

	public static STGError newSTGError(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGError(jsonObject);
	}

	public static STGError newSTGError(java.io.File file) throws java.io.IOException { 
		return new STGError(load(file));
	}

	public static STGError merge(STGError lhs, STGError rhs) {
		return newSTGError(lhs.getJsonObject().mergeIn(rhs.getJsonObject()));
	}

}