package nextgen.react.st;


public class StateValues {

	private java.lang.Object name;
	private java.lang.Object value;

	public StateValues() { }

	public StateValues(java.lang.Object name, java.lang.Object value) { 
		this.name = name;
		this.value = value;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public StateValues setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public java.lang.Object getValue() { 
		return value;
	}

	public StateValues setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}
}