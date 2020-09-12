package nextgen.templates.log4j;

public class FileinfoAppender {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _file;
	private Object _maxFileSize;
	private Object _maxBackupIndex;
	private Object _layout;
	private Object _threshold;
	private Object _elseINFO;

	FileinfoAppender(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("fileinfoAppender");
		st.add("file", _file);
		st.add("maxFileSize", _maxFileSize);
		st.add("maxBackupIndex", _maxBackupIndex);
		st.add("layout", _layout);
		st.add("threshold", _threshold);
		st.add("elseINFO", _elseINFO);
		return st.render().trim();
	}

	public FileinfoAppender setFile(Object value) {
		this._file = value;
		return this;
	}

	public Object getFile() {
		return this._file;
	}

	public Object getFile(Object defaultValue) {
		return this._file == null ? defaultValue : this._file;
	}

	public boolean hasFile() {
		return this._file != null;
	}

	public FileinfoAppender removeFile() {
		this._file = null;
		return this;
	} 

	public FileinfoAppender setMaxFileSize(Object value) {
		this._maxFileSize = value;
		return this;
	}

	public Object getMaxFileSize() {
		return this._maxFileSize;
	}

	public Object getMaxFileSize(Object defaultValue) {
		return this._maxFileSize == null ? defaultValue : this._maxFileSize;
	}

	public boolean hasMaxFileSize() {
		return this._maxFileSize != null;
	}

	public FileinfoAppender removeMaxFileSize() {
		this._maxFileSize = null;
		return this;
	} 

	public FileinfoAppender setMaxBackupIndex(Object value) {
		this._maxBackupIndex = value;
		return this;
	}

	public Object getMaxBackupIndex() {
		return this._maxBackupIndex;
	}

	public Object getMaxBackupIndex(Object defaultValue) {
		return this._maxBackupIndex == null ? defaultValue : this._maxBackupIndex;
	}

	public boolean hasMaxBackupIndex() {
		return this._maxBackupIndex != null;
	}

	public FileinfoAppender removeMaxBackupIndex() {
		this._maxBackupIndex = null;
		return this;
	} 

	public FileinfoAppender setLayout(Object value) {
		this._layout = value;
		return this;
	}

	public Object getLayout() {
		return this._layout;
	}

	public Object getLayout(Object defaultValue) {
		return this._layout == null ? defaultValue : this._layout;
	}

	public boolean hasLayout() {
		return this._layout != null;
	}

	public FileinfoAppender removeLayout() {
		this._layout = null;
		return this;
	} 

	public FileinfoAppender setThreshold(Object value) {
		this._threshold = value;
		return this;
	}

	public Object getThreshold() {
		return this._threshold;
	}

	public Object getThreshold(Object defaultValue) {
		return this._threshold == null ? defaultValue : this._threshold;
	}

	public boolean hasThreshold() {
		return this._threshold != null;
	}

	public FileinfoAppender removeThreshold() {
		this._threshold = null;
		return this;
	} 

	public FileinfoAppender setElseINFO(Object value) {
		this._elseINFO = value;
		return this;
	}

	public Object getElseINFO() {
		return this._elseINFO;
	}

	public Object getElseINFO(Object defaultValue) {
		return this._elseINFO == null ? defaultValue : this._elseINFO;
	}

	public boolean hasElseINFO() {
		return this._elseINFO != null;
	}

	public FileinfoAppender removeElseINFO() {
		this._elseINFO = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FileinfoAppender that = (FileinfoAppender) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "fileinfoAppender(file,maxFileSize,maxBackupIndex,layout,threshold,elseINFO) ::= <<log4j.appender.fileinfo = org.apache.log4j.RollingFileAppender\n" + 
				"log4j.appender.fileinfo.file = ~if(file)~~file~~else~./logs/app.log~endif~\n" + 
				"log4j.appender.fileinfo.MaxFileSize = ~if(maxFileSize)~~maxFileSize~~else~20MB~endif~\n" + 
				"log4j.appender.fileinfo.MaxBackupIndex = ~if(maxBackupIndex)~~maxBackupIndex~~else~100~endif~\n" + 
				"log4j.appender.fileinfo.layout = ~if(layout)~~layout~~else~org.apache.log4j.PatternLayout~endif~\n" + 
				"log4j.appender.fileinfo.layout.ConversionPattern = %d{ISO8601} - %-5p- %c - %m%n\n" + 
				"log4j.appender.fileinfo.Threshold = ~if(threshold)~~threshold~~elseINFO~~endif~ >>";
}  