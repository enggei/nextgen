package nextgen.maven.st;


public class MavenFactory {

	public static Packaging PackagingPOM() { 
		return Packaging.POM;
	}

	public static Packaging PackagingJAR() { 
		return Packaging.JAR;
	}

	public static Packaging PackagingWAR() { 
		return Packaging.WAR;
	}

	public static shadePlugin newShadePlugin() { 
		return new shadePlugin();
	}

	public static pom newPom() { 
		return new pom();
	}

	public static pomProperties newPomProperties() { 
		return new pomProperties();
	}

	public static propertyReference newPropertyReference() { 
		return new propertyReference();
	}

	public static plugin newPlugin() { 
		return new plugin();
	}

	public static pluginConfiguration newPluginConfiguration() { 
		return new pluginConfiguration();
	}

	public static build newBuild() { 
		return new build();
	}

	public static buildTestResources newBuildTestResources() { 
		return new buildTestResources();
	}

	public static dependency newDependency() { 
		return new dependency();
	}

	public static parent newParent() { 
		return new parent();
	}

	public static repository newRepository() { 
		return new repository();
	}

	public static execution newExecution() { 
		return new execution();
	}

	public static frontEndMavenPlugin newFrontEndMavenPlugin() { 
		return new frontEndMavenPlugin();
	}

	public static Project newProject() { 
		return new Project();
	}

	public static Module newModule() { 
		return new Module();
	}

	public static DependencyGroup newDependencyGroup() { 
		return new DependencyGroup();
	}
}