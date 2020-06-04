package nextgen.maven.st;


public class MavenGenerator {

	private final org.stringtemplate.v4.STGroup stGroup;

	public MavenGenerator() { 
		this(new org.stringtemplate.v4.STGroupFile("templates/Maven.stg"));
	}

	public MavenGenerator(java.io.File file) { 
		this(new org.stringtemplate.v4.STGroupFile(file.getAbsolutePath()));
	}

	public MavenGenerator(org.stringtemplate.v4.STGroup stGroup) { 
		this.stGroup = stGroup;
	}

	public java.lang.Object generate(Packaging model) { 
		return model;
	}

	public java.lang.Object generate(shadePlugin model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("shadePlugin");
		st.add("className", generate(model.getClassName()));
		st.add("packageName", generate(model.getPackageName()));
		return st.render();
	}

	public java.lang.Object generate(pom model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("pom");
		model.getDependencies().forEach((element) -> st.add("dependencies", generate(element)));
		st.add("parent", generate(model.getParent()));
		st.add("groupId", generate(model.getGroupId()));
		model.getDistributionManagement().forEach((element) -> st.add("distributionManagement", generate(element)));
		st.add("artifactId", generate(model.getArtifactId()));
		model.getModules().forEach((element) -> st.add("modules", generate(element)));
		st.add("version", generate(model.getVersion()));
		st.add("name", generate(model.getName()));
		st.add("build", generate(model.getBuild()));
		st.add("packaging", generate(model.getPackaging()));
		model.getProperties().forEach((element) -> st.addAggr("properties.{name,value}", generate(element.getName()), generate(element.getValue())));
		model.getRepositories().forEach((element) -> st.add("repositories", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(propertyReference model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("propertyReference");
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(plugin model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("plugin");
		st.add("artifactId", generate(model.getArtifactId()));
		st.add("version", generate(model.getVersion()));
		model.getConfiguration().forEach((element) -> st.addAggr("configuration.{name,value}", generate(element.getName()), generate(element.getValue())));
		st.add("groupId", generate(model.getGroupId()));
		model.getExecutions().forEach((element) -> st.add("executions", generate(element)));
		return st.render();
	}

	public java.lang.Object generate(build model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("build");
		model.getPlugin().forEach((element) -> st.add("plugin", generate(element)));
		model.getTestResources().forEach((element) -> st.addAggr("testResources.{name,value}", generate(element.getName()), generate(element.getValue())));
		return st.render();
	}

	public java.lang.Object generate(dependency model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependency");
		st.add("version", generate(model.getVersion()));
		st.add("artifactId", generate(model.getArtifactId()));
		st.add("systemPath", generate(model.getSystemPath()));
		st.add("scope", generate(model.getScope()));
		st.add("groupId", generate(model.getGroupId()));
		return st.render();
	}

	public java.lang.Object generate(parent model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("parent");
		st.add("groupId", generate(model.getGroupId()));
		st.add("artifactId", generate(model.getArtifactId()));
		st.add("version", generate(model.getVersion()));
		return st.render();
	}

	public java.lang.Object generate(repository model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("repository");
		st.add("url", generate(model.getUrl()));
		st.add("id", generate(model.getId()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(execution model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("execution");
		return st.render();
	}

	public java.lang.Object generate(frontEndMavenPlugin model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("frontEndMavenPlugin");
		st.add("installDirectory", generate(model.getInstallDirectory()));
		st.add("nodeVersion", generate(model.getNodeVersion()));
		st.add("pluginVersion", generate(model.getPluginVersion()));
		return st.render();
	}

	public java.lang.Object generate(java.lang.Object model) { 
		if (model instanceof shadePlugin) return generate((shadePlugin) model);
		if (model instanceof pom) return generate((pom) model);
		if (model instanceof propertyReference) return generate((propertyReference) model);
		if (model instanceof plugin) return generate((plugin) model);
		if (model instanceof build) return generate((build) model);
		if (model instanceof dependency) return generate((dependency) model);
		if (model instanceof parent) return generate((parent) model);
		if (model instanceof repository) return generate((repository) model);
		if (model instanceof execution) return generate((execution) model);
		if (model instanceof frontEndMavenPlugin) return generate((frontEndMavenPlugin) model);
		return model;
	}
}