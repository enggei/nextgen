package nextgen.st.model;

public class STModelFactory {

	public static STModule newSTModule() { 
		return new STModule();
	}

	public static STModel newSTModel() { 
		return new STModel();
	}

	public static STArgument newSTArgument() { 
		return new STArgument();
	}

	public static STValue newSTValue() { 
		return new STValue();
	}

	public static STArgumentKV newSTArgumentKV() { 
		return new STArgumentKV();
	}

}