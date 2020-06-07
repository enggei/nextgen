package nextgen.templates.maven;

public class ShadePlugin {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _className;

	ShadePlugin(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShadePlugin that = (ShadePlugin) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("shadePlugin");
		st.add("packageName", _packageName);
		st.add("className", _className);
		return st.render().trim();
	}

	public ShadePlugin setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public ShadePlugin removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ShadePlugin setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public ShadePlugin removeClassName() {
		this._className = null;
		return this;
	} 

	static final String st = "shadePlugin(packageName,className) ::= <<<!--fat-jar plugin for single-file server package-->\n" + 
				"<plugin>\n" + 
				"	<groupId>org.apache.maven.plugins</groupId>\n" + 
				"	<artifactId>maven-shade-plugin</artifactId>\n" + 
				"	<version>2.4.3</version>\n" + 
				"	<executions>\n" + 
				"		<execution>\n" + 
				"			<phase>package</phase>\n" + 
				"			<goals>\n" + 
				"				<goal>shade</goal>\n" + 
				"			</goals>\n" + 
				"			<configuration>\n" + 
				"				<filters>\n" + 
				"					<filter>\n" + 
				"						<artifact>*:*</artifact>\n" + 
				"						<excludes>\n" + 
				"							<exclude>META-INF/*.SF</exclude>\n" + 
				"							<exclude>META-INF/*.DSA</exclude>\n" + 
				"							<exclude>META-INF/*.RSA</exclude>\n" + 
				"						</excludes>\n" + 
				"					</filter>\n" + 
				"				</filters>\n" + 
				"				<transformers>\n" + 
				"					<transformer implementation=\"org.apache.maven.plugins.shade.resource.ServicesResourceTransformer\"/>\n" + 
				"					<transformer implementation=\"org.apache.maven.plugins.shade.resource.ManifestResourceTransformer\">\n" + 
				"						<manifestEntries>\n" + 
				"							<Main-Class>io.vertx.core.Launcher</Main-Class>\n" + 
				"							<Main-Verticle>~packageName~.~className~</Main-Verticle>\n" + 
				"						</manifestEntries>\n" + 
				"					</transformer>\n" + 
				"				</transformers>\n" + 
				"				<artifactSet/>\n" + 
				"				<outputFile>target/${project.artifactId}-${project.version}-fat.jar</outputFile>\n" + 
				"			</configuration>\n" + 
				"		</execution>\n" + 
				"	</executions>\n" + 
				"</plugin> >> ";
} 