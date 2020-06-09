package nextgen.st.domain;

public class STJsonFactory {

	public static STAppModel newSTAppModel() { 
		return new STAppModel();
	}

	public static STAppModel newSTAppModel(io.vertx.core.json.JsonObject jsonObject) { 
		return new STAppModel(jsonObject);
	}

	public static STGDirectory newSTGDirectory() { 
		return new STGDirectory();
	}

	public static STGDirectory newSTGDirectory(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGDirectory(jsonObject);
	}

	public static STGroupModel newSTGroupModel() { 
		return new STGroupModel();
	}

	public static STGroupModel newSTGroupModel(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGroupModel(jsonObject);
	}

	public static STTemplate newSTTemplate() { 
		return new STTemplate();
	}

	public static STTemplate newSTTemplate(io.vertx.core.json.JsonObject jsonObject) { 
		return new STTemplate(jsonObject);
	}

	public static STParameter newSTParameter() { 
		return new STParameter();
	}

	public static STParameter newSTParameter(io.vertx.core.json.JsonObject jsonObject) { 
		return new STParameter(jsonObject);
	}

	public static STParameterKey newSTParameterKey() { 
		return new STParameterKey();
	}

	public static STParameterKey newSTParameterKey(io.vertx.core.json.JsonObject jsonObject) { 
		return new STParameterKey(jsonObject);
	}

	public static STEnum newSTEnum() { 
		return new STEnum();
	}

	public static STEnum newSTEnum(io.vertx.core.json.JsonObject jsonObject) { 
		return new STEnum(jsonObject);
	}

	public static STEnumValue newSTEnumValue() { 
		return new STEnumValue();
	}

	public static STEnumValue newSTEnumValue(io.vertx.core.json.JsonObject jsonObject) { 
		return new STEnumValue(jsonObject);
	}

	public static STGParseResult newSTGParseResult() { 
		return new STGParseResult();
	}

	public static STGParseResult newSTGParseResult(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGParseResult(jsonObject);
	}

	public static STGError newSTGError() { 
		return new STGError();
	}

	public static STGError newSTGError(io.vertx.core.json.JsonObject jsonObject) { 
		return new STGError(jsonObject);
	}

}