package nextgen.npm.st;


public class WebpackConfig {

	private java.lang.Object outputFilename;
	private java.lang.Object mainEntry;
	private final java.util.UUID uuid;

	public java.lang.Object getOutputFilename() { 
		return outputFilename;
	}

	public WebpackConfig setOutputFilename(java.lang.Object outputFilename) { 
		this.outputFilename = outputFilename;
		return this;
	}

	public WebpackConfig removeOutputFilename() { 
		this.outputFilename = null;
		return this;
	}

	public java.lang.Object getMainEntry() { 
		return mainEntry;
	}

	public WebpackConfig setMainEntry(java.lang.Object mainEntry) { 
		this.mainEntry = mainEntry;
		return this;
	}

	public WebpackConfig removeMainEntry() { 
		this.mainEntry = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "WebpackConfig";
	}

	public WebpackConfig() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public WebpackConfig(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebpackConfig other = (WebpackConfig) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}