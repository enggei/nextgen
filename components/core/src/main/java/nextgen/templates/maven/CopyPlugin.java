package nextgen.templates.maven;

public class CopyPlugin {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _outputDirectory;
	private Object _directory;
	private java.util.List<Object> _include = new java.util.ArrayList<>();

	CopyPlugin(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("copyPlugin");
		st.add("outputDirectory", _outputDirectory);
		st.add("directory", _directory);
		for (Object o : _include) st.add("include", o);
		return st.render().trim();
	}

	public CopyPlugin setOutputDirectory(Object value) {
		this._outputDirectory = value;
		return this;
	}

	public Object getOutputDirectory() {
		return this._outputDirectory;
	}

	public Object getOutputDirectory(Object defaultValue) {
		return this._outputDirectory == null ? defaultValue : this._outputDirectory;
	}

	public boolean hasOutputDirectory() {
		return this._outputDirectory != null;
	}

	public CopyPlugin removeOutputDirectory() {
		this._outputDirectory = null;
		return this;
	} 

	public CopyPlugin setDirectory(Object value) {
		this._directory = value;
		return this;
	}

	public Object getDirectory() {
		return this._directory;
	}

	public Object getDirectory(Object defaultValue) {
		return this._directory == null ? defaultValue : this._directory;
	}

	public boolean hasDirectory() {
		return this._directory != null;
	}

	public CopyPlugin removeDirectory() {
		this._directory = null;
		return this;
	} 

	public CopyPlugin addInclude(Object value) {
		this._include.add(value);
		return this;
	}

	public CopyPlugin setInclude(Object[] value) {
		this._include.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CopyPlugin setInclude(java.util.Collection<Object> values) {
		this._include.addAll(values);
		return this;
	}

	public CopyPlugin removeInclude(Object value) {
		this._include.remove(value);
		return this;
	}

	public CopyPlugin removeInclude(int index) {
		this._include.remove(index);
		return this;
	}

	public java.util.List<Object> getInclude() {
		return this._include;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CopyPlugin that = (CopyPlugin) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "copyPlugin(outputDirectory,directory,include) ::= <<<!-- https://maven.apache.org/plugins/maven-resources-plugin/ -->\n" + 
				"<plugin>\n" + 
				"	<artifactId>maven-resources-plugin</artifactId>\n" + 
				"	<version>3.2.0</version>\n" + 
				"	<executions>\n" + 
				"		<execution>\n" + 
				"			<id>copy-resources</id>\n" + 
				"			<phase>validate</phase>\n" + 
				"			<goals>\n" + 
				"				<goal>copy-resources</goal>\n" + 
				"			</goals>\n" + 
				"			<configuration>\n" + 
				"				<outputDirectory>~outputDirectory~</outputDirectory>\n" + 
				"				<resources>			 \n" + 
				"					<resource>\n" + 
				"						<directory>~directory~</directory>\n" + 
				"						<includes>\n" + 
				"							~include:{it|<include>~it~</include>};separator=\"\\n\"~\n" + 
				"						</includes>\n" + 
				"					</resource>\n" + 
				"				</resources>				  \n" + 
				"			</configuration>				\n" + 
				"		</execution>\n" + 
				"	</executions>\n" + 
				"</plugin> >>";
}  