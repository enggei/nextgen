package nextgen.templates.maven;

public class MavenST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(DependencyManagement.st + "\n")
	.append(Antlr4.st + "\n")
	.append(Antlr4Simple.st + "\n")
	.append(CopyPlugin.st + "\n")
	.append(FrontEndMavenPlugin.st + "\n")
	.append(NpmScript.st + "\n")
	.append(Plugin.st + "\n")
	.append(ShadePlugin.st + "\n")
	.append(Pom.st + "\n")
	.append(Build.st + "\n")
	.append(Dependency.st + "\n")
	.append(DependencyGroup.st + "\n")
	.append(Execution.st + "\n")
	.append(Parent.st + "\n")
	.append(Properties.st + "\n")
	.append(MavenCompilerSource.st + "\n")
	.append(MavenCompilerTarget.st + "\n")
	.append(ProjectBuildSourceEncoding.st + "\n")
	.append(ProjectReportingOutputEncoding.st + "\n")
	.append(PropertyReference.st + "\n")
	.append(Repository.st + "\n")
	.append(Project.st + "\n")
	.append(ProjectGenerator.st + "\n")
	.append(ProjectPackage.st + "\n")
	.append(TestRunner.st + "\n")
	.toString()  ;

	public static org.stringtemplate.v4.STGroup decorate(final org.stringtemplate.v4.STGroup stGroup) {
		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());
		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {
			@Override
			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("compileTimeError " + stMessage.toString());
			}

			@Override
			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;
				System.out.println("runTimeError " + stMessage.self.getName() + " " + stRuntimeMessage.getSourceLocation());
			}

			@Override
			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("IOError " + stMessage.toString());
			}

			@Override
			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("internalError " + stMessage.toString());
			}
		});

		return stGroup;
	}

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("MavenST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static DependencyManagement newDependencyManagement() {
		return new DependencyManagement(stGroup);
	}  

	public static Antlr4 newAntlr4() {
		return new Antlr4(stGroup);
	}  

	public static Antlr4Simple newAntlr4Simple() {
		return new Antlr4Simple(stGroup);
	}  

	public static CopyPlugin newCopyPlugin() {
		return new CopyPlugin(stGroup);
	}  

	public static FrontEndMavenPlugin newFrontEndMavenPlugin() {
		return new FrontEndMavenPlugin(stGroup);
	}  

	public static NpmScript newNpmScript() {
		return new NpmScript(stGroup);
	}  

	public static Plugin newPlugin() {
		return new Plugin(stGroup);
	}  

	public static ShadePlugin newShadePlugin() {
		return new ShadePlugin(stGroup);
	}  

	public static Pom newPom() {
		return new Pom(stGroup);
	}  

	public static Build newBuild() {
		return new Build(stGroup);
	}  

	public static Dependency newDependency() {
		return new Dependency(stGroup);
	}  

	public static DependencyGroup newDependencyGroup() {
		return new DependencyGroup(stGroup);
	}  

	public static Execution newExecution() {
		return new Execution(stGroup);
	}  

	public static Parent newParent() {
		return new Parent(stGroup);
	}  

	public static Properties newProperties() {
		return new Properties(stGroup);
	}  

	public static MavenCompilerSource newMavenCompilerSource() {
		return new MavenCompilerSource(stGroup);
	}  

	public static MavenCompilerTarget newMavenCompilerTarget() {
		return new MavenCompilerTarget(stGroup);
	}  

	public static ProjectBuildSourceEncoding newProjectBuildSourceEncoding() {
		return new ProjectBuildSourceEncoding(stGroup);
	}  

	public static ProjectReportingOutputEncoding newProjectReportingOutputEncoding() {
		return new ProjectReportingOutputEncoding(stGroup);
	}  

	public static PropertyReference newPropertyReference() {
		return new PropertyReference(stGroup);
	}  

	public static Repository newRepository() {
		return new Repository(stGroup);
	}  

	public static Project newProject() {
		return new Project(stGroup);
	}  

	public static ProjectGenerator newProjectGenerator() {
		return new ProjectGenerator(stGroup);
	}  

	public static ProjectPackage newProjectPackage() {
		return new ProjectPackage(stGroup);
	}  

	public static TestRunner newTestRunner() {
		return new TestRunner(stGroup);
	}  

	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();
			if (formatString == null) return text;

			final String s = text.length() > 1 ? text.substring(1) : "";

			switch (formatString) {
				case "capitalize":
					return Character.toUpperCase(text.charAt(0)) + s;
				case "toUpper":
					return text.toUpperCase();
				case "lowFirst":
					return Character.toLowerCase(text.charAt(0)) + s;
				case "toLower":
					return text.toLowerCase();
				case "dotToCap":
					final StringBuilder formatted = new StringBuilder();
					final char[] chars = o.toString().toCharArray();
					for (int i = 0; i < chars.length; i++)
            		if (chars[i] != '.')
							formatted.append(i == 0 || chars[i - 1] == '.' ? Character.toUpperCase(chars[i]) : chars[i]);
					return formatted.toString().trim();
				default:
					return o.toString();
			}
		}
	}
}  