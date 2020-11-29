package nextgen.projects;
//
//import nextgen.templates.maven.*;
//import nextgen.templates.maven.MavenPatterns;
//
//import nextgen.templates.npm.*;
//import nextgen.templates.NpmPatterns;
//
//
//
//import java.io.File;
//
//public class DemoProject {
//
//	final File root = new File("/home/goe/projects/demo");
//	final File mainJava = new File(root, "src/main/java");
//	final File mainResources = new File(root, "src/main/resources");
//	final File testJava = new File(root, "src/test/java");
//	final File testResources = new File(root, "src/test/resources");
//	final File webapp = new File(root, "src/main/webapp");
//	final File indexJS = new File(webapp, "index.js");
//	final File staticWeb = new File(mainResources, "static");
//	final File mainJS = new File(staticWeb, "main.js");
//
//	private final nextgen.templates.java.PackageDeclaration corePackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration("com.demo");
//	private final JavaType ServerType = new JavaType(corePackage, "Server");
//
//	private final nextgen.templates.java.PackageDeclaration webPackage = nextgen.templates.java.JavaPatterns.newPackageDeclaration(corePackage.getName() + "." + "web");
//
//	final String mainClass = "Hello";
//
//	/**
//	 * generateProjectFiles
//	 * Generate project files (pom, npm)
//	 */
//	@org.junit.Test
//	public void generateProjectFiles() {
//		System.out.println("success");
//		final DependencyGroup vertxGroup = MavenPatterns.newDependencyGroup()
//									.setName("vertx")
//									.setGroupId("io.vertx")
//									.setVersion("3.8.3")
//									.addArtifacts("vertx-core")
//									.addArtifacts("vertx-web")
//									.addArtifacts("vertx-auth-jwt")
//									.addArtifacts("vertx-unit");
//		final Pom projectPom = MavenPatterns.newPom()
//									.setName("Demo")
//									.setGroupId("nextgen")
//									.setArtifactId("generator")
//									.setVersion("1.5")
//									.addProperties(MavenPatterns.setMavenCompilerSource("1.8"))
//									.addProperties(MavenPatterns.setMavenCompilerTarget("1.8"))
//									.addProperties(MavenPatterns.setProjectBuildSourceEncoding("UTF-8"))
//									.addProperties(MavenPatterns.setProjectReportingOutputEncoding("UTF-8"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("cdt-java-client").setGroupId("com.github.kklisura.cdt").setVersion("2.1.0"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("neo4j").setGroupId("org.neo4j").setVersion("3.5.8"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("slf4j-log4j12").setGroupId("org.slf4j").setVersion("1.7.20"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("jsoup").setGroupId("org.jsoup").setVersion("1.12.1"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("junit").setGroupId("junit").setVersion("4.12"))
//									.addDependencies(MavenPatterns.newDependency().setArtifactId("java-telegram-bot-api").setGroupId("com.github.pengrad").setVersion("4.8.0"))
//									.setBuild(MavenPatterns.newBuild()
//												.addPlugin(MavenPatterns.newFrontEndMavenPlugin()
//														.setInstallDirectory("target")
//														.setNodeVersion("8.9.0")
//														.setPluginVersion("1.10.0"))
//												.addPlugin(MavenPatterns.newShadePlugin()
//														.setClassName(mainClass)
//														.setPackageName(webPackage)));
//		MavenPatterns.addDependencyGroup(projectPom, vertxGroup);
//		MavenPatterns.generate(MavenPatterns.newProject()
//							.setName("Demo")
//							.setRoot(root.getAbsolutePath()), projectPom);
//		NpmPatterns.generate(NpmPatterns.newNpmProject()
//				.setRoot(root.getAbsolutePath())
//				.setPackageJson(NpmPatterns.newPackageJson()
//						.setName("demo")
//						.setVersion("1.0.0")
//						.setDescription("Demo Nextgen")
//						.setAuthor("GOE")
//						.setLicense("ISC")
//						.setMain("index.js")
//						.addScripts(NpmPatterns.newScript().setName("deploy").setCommand("webpack --mode production"))
//						.addScripts(NpmPatterns.newScript()
//								.setName("server")
//								.setCommand("webpack-dev-server --open --mode development"))
//						.addScripts(NpmPatterns.newScript().setName("package").setCommand("webpack --mode development"))
//						.addScripts(NpmPatterns.newScript()
//								.setName("develop")
//								.setCommand("webpack --watch --progress --mode development"))
//						.addDependencies(NpmPatterns.newDependency("react", "16.9.0"))
//						.addDependencies(NpmPatterns.newDependency("react-dom", "16.9.0"))
//						.addDependencies(NpmPatterns.newDependency("react-router-dom", "5.0.1"))
//						.addDependencies(NpmPatterns.newDependency("@material-ui/core", "4.4.2"))
//						.addDependencies(NpmPatterns.newDependency("@material-ui/icons", "4.4.2"))
//						.addDependencies(NpmPatterns.newDependency("@material-ui/styles", "4.4.2"))
//						.addDependencies(NpmPatterns.newDependency("material-table", "1.50.0"))
//						.addDependencies(NpmPatterns.newDependency("mobx", "5.13.0"))
//						.addDependencies(NpmPatterns.newDependency("mobx-react", "6.1.3"))
//						.addDependencies(NpmPatterns.newDependency("superagent", "5.1.0"))
//						.addDependencies(NpmPatterns.newDependency("superagent-promise", "1.1.0"))
//						.addDevDependencies(NpmPatterns.newDependency("@babel/core", "7.1.0"))
//						.addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-class-properties", "7.5.5"))
//						.addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-decorators", "7.6.0"))
//						.addDevDependencies(NpmPatterns.newDependency("@babel/preset-env", "7.1.0"))
//						.addDevDependencies(NpmPatterns.newDependency("@babel/preset-react", "7.0.0"))
//						.addDevDependencies(NpmPatterns.newDependency("babel-loader", "8.0.2"))
//						.addDevDependencies(NpmPatterns.newDependency("webpack", "4.19.1"))
//						.addDevDependencies(NpmPatterns.newDependency("webpack-cli", "3.1.0"))
//						.addDevDependencies(NpmPatterns.newDependency("html-webpack-plugin", "3.2.0")))
//				.setWebpackConfig(NpmPatterns.newWebpackConfig()
//						.setMainEntry(indexJS.getPath())
//						.setOutputFilename(mainJS))
//				.setBabelrc(NpmPatterns.newBabelrc()));
//	}
//
//	protected static void log(Object log) {
//		System.out.println(log);
//	}
//
//	class JavaType {
//
//		final nextgen.templates.java.ClassOrInterfaceType type;
//
//		JavaType(String packageDeclaration, String name) {
//			this.type = nextgen.templates.java.JavaST.newClassOrInterfaceType()
//					.setScope(packageDeclaration)
//					.addNames(name);
//		}
//
//		JavaType(nextgen.templates.java.PackageDeclaration packageDeclaration, String name) {
//			this(packageDeclaration.getName(), name);
//		}
//	}
//}