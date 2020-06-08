package nextgen.templates.npm;

public class NpmST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	Babelrc.st + "\n" + 
	Dependency.st + "\n" + 
	NpmProject.st + "\n" + 
	PackageJson.st + "\n" + 
	Script.st + "\n" + 
	WebpackConfig.st + "\n" ;

	public static org.stringtemplate.v4.STGroup defaultSTGroup() {
		org.stringtemplate.v4.STGroup stGroup = new org.stringtemplate.v4.STGroupString("NpmST", stg, '~', '~');
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

	private static org.stringtemplate.v4.STGroup stGroup = defaultSTGroup();

	public static void setSTGroup(final String stgFile) {
		stGroup = new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~');
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
	}

	public static Babelrc newBabelrc() {
		return new Babelrc(stGroup);
	} 

	public static Dependency newDependency() {
		return new Dependency(stGroup);
	} 

	public static NpmProject newNpmProject() {
		return new NpmProject(stGroup);
	} 

	public static PackageJson newPackageJson() {
		return new PackageJson(stGroup);
	} 

	public static Script newScript() {
		return new Script(stGroup);
	} 

	public static WebpackConfig newWebpackConfig() {
		return new WebpackConfig(stGroup);
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
				default:
					return o.toString();
			}
		}
	}
} 