package nextgen.npm.st;


public class NpmGenerator {

	private final org.stringtemplate.v4.STGroup stGroup;

	public NpmGenerator() { 
		this(new org.stringtemplate.v4.STGroupFile("templates/Npm.stg"));
	}

	public NpmGenerator(java.io.File file) { 
		this(new org.stringtemplate.v4.STGroupFile(file.getAbsolutePath()));
	}

	public NpmGenerator(org.stringtemplate.v4.STGroup stGroup) { 
		this.stGroup = stGroup;
	}

	public java.lang.Object generate(script model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("script");
		st.add("name", generate(model.getName()));
		st.add("command", generate(model.getCommand()));
		return st.render();
	}

	public java.lang.Object generate(dependency model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependency");
		st.add("version", generate(model.getVersion()));
		st.add("name", generate(model.getName()));
		return st.render();
	}

	public java.lang.Object generate(WebpackConfig model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WebpackConfig");
		st.add("outputFilename", generate(model.getOutputFilename()));
		st.add("mainEntry", generate(model.getMainEntry()));
		return st.render();
	}

	public java.lang.Object generate(babelrc model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("babelrc");
		return st.render();
	}

	public java.lang.Object generate(packageJson model) { 
		if (model == null) return null;
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("packageJson");
		st.add("description", generate(model.getDescription()));
		st.add("bugsUrl", generate(model.getBugsUrl()));
		st.add("repositoryType", generate(model.getRepositoryType()));
		model.getDevDependencies().forEach((element) -> st.add("devDependencies", generate(element)));
		st.add("name", generate(model.getName()));
		model.getScripts().forEach((element) -> st.add("scripts", generate(element)));
		st.add("license", generate(model.getLicense()));
		st.add("author", generate(model.getAuthor()));
		model.getDependencies().forEach((element) -> st.add("dependencies", generate(element)));
		st.add("repositoryUrl", generate(model.getRepositoryUrl()));
		st.add("version", generate(model.getVersion()));
		st.add("homepage", generate(model.getHomepage()));
		st.add("main", generate(model.getMain()));
		return st.render();
	}

	public java.lang.Object generate(java.lang.Object model) { 
		if (model instanceof script) return generate((script) model);
		if (model instanceof dependency) return generate((dependency) model);
		if (model instanceof WebpackConfig) return generate((WebpackConfig) model);
		if (model instanceof babelrc) return generate((babelrc) model);
		if (model instanceof packageJson) return generate((packageJson) model);
		return model;
	}
}