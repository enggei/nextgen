package nextgen.npm.st;


public class NpmProject {

	private java.lang.String root;
	private packageJson packageJson;
	private WebpackConfig webpackConfig;
	private babelrc babelrc;
	private final java.util.UUID uuid;

	public java.lang.String getRoot() { 
		return root;
	}

	public java.lang.Boolean hasRoot() { 
		return root != null;
	}

	public NpmProject setRoot(java.lang.String root) { 
		this.root = root;
		return this;
	}

	public packageJson getPackageJson() { 
		return packageJson;
	}

	public java.lang.Boolean hasPackageJson() { 
		return packageJson != null;
	}

	public NpmProject setPackageJson(packageJson packageJson) { 
		this.packageJson = packageJson;
		return this;
	}

	public WebpackConfig getWebpackConfig() { 
		return webpackConfig;
	}

	public java.lang.Boolean hasWebpackConfig() { 
		return webpackConfig != null;
	}

	public NpmProject setWebpackConfig(WebpackConfig webpackConfig) { 
		this.webpackConfig = webpackConfig;
		return this;
	}

	public babelrc getBabelrc() { 
		return babelrc;
	}

	public java.lang.Boolean hasBabelrc() { 
		return babelrc != null;
	}

	public NpmProject setBabelrc(babelrc babelrc) { 
		this.babelrc = babelrc;
		return this;
	}

	public NpmProject() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public NpmProject(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final NpmProject other = (NpmProject) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}