package nextgen.maven.st;


public class pluginConfiguration {

	private java.lang.Object name;
	private java.lang.Object value;

	public pluginConfiguration() { }

	public pluginConfiguration(java.lang.Object name, java.lang.Object value) { 
		this.name = name;
		this.value = value;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public pluginConfiguration setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public java.lang.Object getValue() { 
		return value;
	}

	public pluginConfiguration setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}
}