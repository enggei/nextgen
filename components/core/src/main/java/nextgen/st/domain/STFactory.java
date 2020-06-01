package nextgen.st.domain;


public class STFactory {

	public static STGDirectory newSTGDirectory() { 
		return new STGDirectory();
	}

	public static STGroupModel newSTGroupModel() { 
		return new STGroupModel();
	}

	public static STTemplate newSTTemplate() { 
		return new STTemplate();
	}

	public static STParameter newSTParameter() { 
		return new STParameter();
	}

	public static STParameterKey newSTParameterKey() { 
		return new STParameterKey();
	}

	public static STGParseResult newSTGParseResult() { 
		return new STGParseResult();
	}

	public static STGError newSTGError() { 
		return new STGError();
	}
}