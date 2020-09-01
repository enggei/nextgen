package nextgen.templates.maven;

public class FrontEndMavenPlugin {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _pluginVersion;
	private Object _installDirectory;
	private Object _nodeVersion;

	FrontEndMavenPlugin(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("frontEndMavenPlugin");
		st.add("pluginVersion", _pluginVersion);
		st.add("installDirectory", _installDirectory);
		st.add("nodeVersion", _nodeVersion);
		return st.render().trim();
	}

	public FrontEndMavenPlugin setPluginVersion(Object value) {
		this._pluginVersion = value;
		return this;
	}

	public Object getPluginVersion() {
		return this._pluginVersion;
	}

	public Object getPluginVersion(Object defaultValue) {
		return this._pluginVersion == null ? defaultValue : this._pluginVersion;
	}

	public boolean hasPluginVersion() {
		return this._pluginVersion != null;
	}

	public FrontEndMavenPlugin removePluginVersion() {
		this._pluginVersion = null;
		return this;
	} 

	public FrontEndMavenPlugin setInstallDirectory(Object value) {
		this._installDirectory = value;
		return this;
	}

	public Object getInstallDirectory() {
		return this._installDirectory;
	}

	public Object getInstallDirectory(Object defaultValue) {
		return this._installDirectory == null ? defaultValue : this._installDirectory;
	}

	public boolean hasInstallDirectory() {
		return this._installDirectory != null;
	}

	public FrontEndMavenPlugin removeInstallDirectory() {
		this._installDirectory = null;
		return this;
	} 

	public FrontEndMavenPlugin setNodeVersion(Object value) {
		this._nodeVersion = value;
		return this;
	}

	public Object getNodeVersion() {
		return this._nodeVersion;
	}

	public Object getNodeVersion(Object defaultValue) {
		return this._nodeVersion == null ? defaultValue : this._nodeVersion;
	}

	public boolean hasNodeVersion() {
		return this._nodeVersion != null;
	}

	public FrontEndMavenPlugin removeNodeVersion() {
		this._nodeVersion = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FrontEndMavenPlugin that = (FrontEndMavenPlugin) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "frontEndMavenPlugin(pluginVersion,installDirectory,nodeVersion) ::= <<<!-- https://github.com/eirslett/frontend-maven-plugin -->\n" + 
				"<plugin>\n" + 
				"    <groupId>com.github.eirslett</groupId>\n" + 
				"    <artifactId>frontend-maven-plugin</artifactId>\n" + 
				"    <version>~if(pluginVersion)~~pluginVersion~~else~1.10.0~endif~</version>\n" + 
				"    <configuration>\n" + 
				"        <installDirectory>~if(installDirectory)~~installDirectory~~else~target~endif~</installDirectory>\n" + 
				"        <nodeVersion>v~nodeVersion~</nodeVersion>\n" + 
				"    </configuration>\n" + 
				"    <executions>\n" + 
				"        <execution>\n" + 
				"            <id>install node and npm</id>\n" + 
				"            <goals>\n" + 
				"                <goal>install-node-and-npm</goal>\n" + 
				"            </goals>\n" + 
				"        </execution>\n" + 
				"        <execution>\n" + 
				"            <id>npm install</id>\n" + 
				"            <goals>\n" + 
				"                <goal>npm</goal>\n" + 
				"            </goals>\n" + 
				"            <configuration>\n" + 
				"                <arguments>install</arguments>\n" + 
				"            </configuration>\n" + 
				"        </execution>\n" + 
				"        <execution>\n" + 
				"            <id>webpack build</id>\n" + 
				"            <goals>\n" + 
				"                <goal>webpack</goal>\n" + 
				"            </goals>\n" + 
				"        </execution>\n" + 
				"    </executions>\n" + 
				"</plugin~gt()~ >>";
}  