package nextgen.swing;

public final class AppModel {

	private static AppModel INSTANCE;
	private nextgen.swing.STWorkspace _workspace;
	private String _title;
	private java.awt.Dimension _appSize;
	private java.awt.Dimension _navigatorSize;
	private java.awt.Dimension _workspaceSize;
	private String _rootDir;
	private String _dbDir;
	private String _outputPackage;
	private String _outputPath;
	private String _templateDir;
	private String _stDelimiter;
	private Integer _fontSize;
	private String _fontName;
	private javax.swing.JFrame _frame;
	private nextgen.swing.STAppPresentationModel _sTAppPresentationModel;

	private AppModel() {		  
	}

	public static synchronized AppModel getInstance() {
		if (INSTANCE == null) INSTANCE = new AppModel();
		return INSTANCE;
	}

	public nextgen.swing.STWorkspace getWorkspace() {
		return _workspace;
	}

	public AppModel setWorkspace(nextgen.swing.STWorkspace value) {
		this._workspace = value;
		return this;
	}

	public String getTitle() {
		return _title;
	}

	public AppModel setTitle(String value) {
		this._title = value;
		return this;
	}

	public java.awt.Dimension getAppSize() {
		return _appSize;
	}

	public AppModel setAppSize(java.awt.Dimension value) {
		this._appSize = value;
		return this;
	}

	public java.awt.Dimension getNavigatorSize() {
		return _navigatorSize;
	}

	public AppModel setNavigatorSize(java.awt.Dimension value) {
		this._navigatorSize = value;
		return this;
	}

	public java.awt.Dimension getWorkspaceSize() {
		return _workspaceSize;
	}

	public AppModel setWorkspaceSize(java.awt.Dimension value) {
		this._workspaceSize = value;
		return this;
	}

	public String getRootDir() {
		return _rootDir;
	}

	public AppModel setRootDir(String value) {
		this._rootDir = value;
		return this;
	}

	public String getDbDir() {
		return _dbDir;
	}

	public AppModel setDbDir(String value) {
		this._dbDir = value;
		return this;
	}

	public String getOutputPackage() {
		return _outputPackage;
	}

	public AppModel setOutputPackage(String value) {
		this._outputPackage = value;
		return this;
	}

	public String getOutputPath() {
		return _outputPath;
	}

	public AppModel setOutputPath(String value) {
		this._outputPath = value;
		return this;
	}

	public String getTemplateDir() {
		return _templateDir;
	}

	public AppModel setTemplateDir(String value) {
		this._templateDir = value;
		return this;
	}

	public String getStDelimiter() {
		return _stDelimiter;
	}

	public AppModel setStDelimiter(String value) {
		this._stDelimiter = value;
		return this;
	}

	public Integer getFontSize() {
		return _fontSize;
	}

	public AppModel setFontSize(Integer value) {
		this._fontSize = value;
		return this;
	}

	public String getFontName() {
		return _fontName;
	}

	public AppModel setFontName(String value) {
		this._fontName = value;
		return this;
	}

	public javax.swing.JFrame getFrame() {
		return _frame;
	}

	public AppModel setFrame(javax.swing.JFrame value) {
		this._frame = value;
		return this;
	}

	public nextgen.swing.STAppPresentationModel getSTAppPresentationModel() {
		return _sTAppPresentationModel;
	}

	public AppModel setSTAppPresentationModel(nextgen.swing.STAppPresentationModel value) {
		this._sTAppPresentationModel = value;
		return this;
	}


}