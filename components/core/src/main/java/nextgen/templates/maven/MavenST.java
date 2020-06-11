package nextgen.templates.maven;

public class MavenST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	Build.st + "\n" + 
	Dependency.st + "\n" + 
	DependencyGroup.st + "\n" + 
	Module.st + "\n" + 
	Project.st + "\n" + 
	Execution.st + "\n" + 
	Parent.st + "\n" + 
	CopyPlugin.st + "\n" + 
	FrontEndMavenPlugin.st + "\n" + 
	Plugin.st + "\n" + 
	ShadePlugin.st + "\n" + 
	Pom.st + "\n" + 
	PropertyReference.st + "\n" + 
	Repository.st + "\n" ;

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

	public static Build newBuild() {
		return new Build(stGroup);
	} 

	public static Dependency newDependency() {
		return new Dependency(stGroup);
	} 

	public static DependencyGroup newDependencyGroup() {
		return new DependencyGroup(stGroup);
	} 

	public static Module newModule() {
		return new Module(stGroup);
	} 

	public static Project newProject() {
		return new Project(stGroup);
	} 

	public static Execution newExecution() {
		return new Execution(stGroup);
	} 

	public static Parent newParent() {
		return new Parent(stGroup);
	} 

	public static CopyPlugin newCopyPlugin() {
		return new CopyPlugin(stGroup);
	} 

	public static FrontEndMavenPlugin newFrontEndMavenPlugin() {
		return new FrontEndMavenPlugin(stGroup);
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

	public static PropertyReference newPropertyReference() {
		return new PropertyReference(stGroup);
	} 

	public static Repository newRepository() {
		return new Repository(stGroup);
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