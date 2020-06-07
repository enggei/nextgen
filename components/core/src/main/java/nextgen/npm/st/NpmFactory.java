package nextgen.npm.st;


public class NpmFactory {

	public static script newScript() { 
		return new script();
	}

	public static dependency newDependency() { 
		return new dependency();
	}

	public static WebpackConfig newWebpackConfig() { 
		return new WebpackConfig();
	}

	public static babelrc newBabelrc() { 
		return new babelrc();
	}

	public static packageJson newPackageJson() { 
		return new packageJson();
	}

	public static NpmProject newNpmProject() { 
		return new NpmProject();
	}
}