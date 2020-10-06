package nextgen.templates.javaswing;

public class App {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	App(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("App");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public App setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public App removePackageName() {
		this._packageName = null;
		return this;
	} 

	public App setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public App removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		App that = (App) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "App(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.DomainFacade;\n" + 
				"import nextgen.swing.components.navigation.Navigator;\n" + 
				"import nextgen.swing.components.workspace.Workspace;\n" + 
				"import nextgen.swing.config.AppConfig;\n" + 
				"import nextgen.swing.config.AppConfigJsonFactory;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.io.File;\n" + 
				"import java.io.IOException;\n" + 
				"\n" + 
				"public class ~name~ extends JFrame {\n" + 
				"\n" + 
				"   public ~name~(AppModel appModel) {\n" + 
				"      super(appModel.getTitle());\n" + 
				"\n" + 
				"      appModel.setFrame(this);\n" + 
				"\n" + 
				"      appModel.getDomain().doInTransaction(transaction -> {\n" + 
				"         final Navigator navigator = new Navigator();\n" + 
				"         final Workspace workspace = new Workspace();\n" + 
				"\n" + 
				"         final JPanel contentPanel = new JPanel(new BorderLayout());\n" + 
				"         contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));\n" + 
				"         contentPanel.add(navigator, BorderLayout.WEST);\n" + 
				"         contentPanel.add(workspace, BorderLayout.CENTER);\n" + 
				"         contentPanel.setPreferredSize(appModel.getAppSize());\n" + 
				"         add(contentPanel, BorderLayout.CENTER);\n" + 
				"      });\n" + 
				"\n" + 
				"      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n" + 
				"   }\n" + 
				"\n" + 
				"   public static void main(String[] args) throws IOException {\n" + 
				"      SwingUtil.show(new ~name~(loadConfig(args)));\n" + 
				"   }\n" + 
				"\n" + 
				"   private static AppModel loadConfig(String[] args) throws IOException {\n" + 
				"\n" + 
				"      com.formdev.flatlaf.FlatDarculaLaf.install();\n" + 
				"\n" + 
				"      if (args.length == 0) {\n" + 
				"         final DomainFacade domainFacade = new DomainFacade(\"./db\");\n" + 
				"         return AppModel.getInstance()\n" + 
				"               .setEditorFontSize(12)\n" + 
				"               .setAppSize(new Dimension(1600, 1200))\n" + 
				"               .setNavigatorSize(new Dimension(400, 1200))\n" + 
				"               .setWorkspaceSize(new Dimension(1200, 1200))\n" + 
				"               .setOutputPackage(\"nextgen.templates\")\n" + 
				"               .setOutputPath(\"./src/main/java\")\n" + 
				"               .setRootDir(\".\")\n" + 
				"               .setTitle(\"~name~\")\n" + 
				"               .setDomain(domainFacade);\n" + 
				"      }\n" + 
				"\n" + 
				"      final AppConfig appConfig = AppConfigJsonFactory.newAppConfig(new File(args[0]));\n" + 
				"      final DomainFacade domainFacade = new DomainFacade(appConfig.getDbDir());\n" + 
				"      return AppModel.getInstance()\n" + 
				"            .setEditorFontSize(appConfig.getEditorFontSize())\n" + 
				"            .setAppSize(new Dimension(appConfig.getAppWidth(), appConfig.getAppHeight()))\n" + 
				"            .setNavigatorSize(new Dimension(appConfig.getNavigatorWidth(), appConfig.getNavigatorHeight()))\n" + 
				"            .setWorkspaceSize(new Dimension(appConfig.getWorkspaceWidth(), appConfig.getWorkspaceHeight()))\n" + 
				"            .setOutputPackage(appConfig.getOutputPackage())\n" + 
				"            .setOutputPath(appConfig.getOutputPath())\n" + 
				"            .setRootDir(appConfig.getRootDir())\n" + 
				"            .setTitle(appConfig.getTitle())\n" + 
				"            .setDomain(domainFacade);\n" + 
				"   }\n" + 
				"} >>";
}  