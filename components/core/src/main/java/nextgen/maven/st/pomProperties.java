package nextgen.maven.st;


public class pomProperties {

	private java.lang.Object name;
	private java.lang.Object value;

	public pomProperties() { }

	public pomProperties(java.lang.Object name, java.lang.Object value) { 
		this.name = name;
		this.value = value;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public pomProperties setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public java.lang.Object getValue() { 
		return value;
	}

	public pomProperties setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}
}