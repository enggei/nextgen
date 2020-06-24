package nextgen.templates.maven;

public class Antlr4 {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _version;
	private Object _sourceDirectory;
	private Object _outputDirectory;
	private Object _visitor;
	private Object _listener;
	private Object _goal;
	private java.util.List<Object> _grammars = new java.util.ArrayList<>();
	private java.util.List<Object> _includes = new java.util.ArrayList<>();
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();

	Antlr4(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("antlr4");
		st.add("version", _version);
		st.add("sourceDirectory", _sourceDirectory);
		st.add("outputDirectory", _outputDirectory);
		st.add("visitor", _visitor);
		st.add("listener", _listener);
		st.add("goal", _goal);
		for (Object o : _grammars) st.add("grammars", o);
		for (Object o : _includes) st.add("includes", o);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public Antlr4 setVersion(Object value) {
		this._version = value;
		return this;
	}

	public Object getVersion() {
		return this._version;
	}

	public Object getVersion(Object defaultValue) {
		return this._version == null ? defaultValue : this._version;
	}

	public boolean hasVersion() {
		return this._version != null;
	}

	public Antlr4 removeVersion() {
		this._version = null;
		return this;
	} 

	public Antlr4 setSourceDirectory(Object value) {
		this._sourceDirectory = value;
		return this;
	}

	public Object getSourceDirectory() {
		return this._sourceDirectory;
	}

	public Object getSourceDirectory(Object defaultValue) {
		return this._sourceDirectory == null ? defaultValue : this._sourceDirectory;
	}

	public boolean hasSourceDirectory() {
		return this._sourceDirectory != null;
	}

	public Antlr4 removeSourceDirectory() {
		this._sourceDirectory = null;
		return this;
	} 

	public Antlr4 setOutputDirectory(Object value) {
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

	public Antlr4 removeOutputDirectory() {
		this._outputDirectory = null;
		return this;
	} 

	public Antlr4 setVisitor(Object value) {
		this._visitor = value;
		return this;
	}

	public Object getVisitor() {
		return this._visitor;
	}

	public Object getVisitor(Object defaultValue) {
		return this._visitor == null ? defaultValue : this._visitor;
	}

	public boolean hasVisitor() {
		return this._visitor != null;
	}

	public Antlr4 removeVisitor() {
		this._visitor = null;
		return this;
	} 

	public Antlr4 setListener(Object value) {
		this._listener = value;
		return this;
	}

	public Object getListener() {
		return this._listener;
	}

	public Object getListener(Object defaultValue) {
		return this._listener == null ? defaultValue : this._listener;
	}

	public boolean hasListener() {
		return this._listener != null;
	}

	public Antlr4 removeListener() {
		this._listener = null;
		return this;
	} 

	public Antlr4 setGoal(Object value) {
		this._goal = value;
		return this;
	}

	public Object getGoal() {
		return this._goal;
	}

	public Object getGoal(Object defaultValue) {
		return this._goal == null ? defaultValue : this._goal;
	}

	public boolean hasGoal() {
		return this._goal != null;
	}

	public Antlr4 removeGoal() {
		this._goal = null;
		return this;
	} 

	public Antlr4 addGrammars(Object value) {
		this._grammars.add(value);
		return this;
	}

	public Antlr4 setGrammars(Object[] value) {
		this._grammars.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Antlr4 setGrammars(java.util.Collection<Object> values) {
		this._grammars.addAll(values);
		return this;
	}

	public Antlr4 removeGrammars(Object value) {
		this._grammars.remove(value);
		return this;
	}

	public Antlr4 removeGrammars(int index) {
		this._grammars.remove(index);
		return this;
	}

	public java.util.List<Object> getGrammars() {
		return this._grammars;
	} 

	public Antlr4 addIncludes(Object value) {
		this._includes.add(value);
		return this;
	}

	public Antlr4 setIncludes(Object[] value) {
		this._includes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Antlr4 setIncludes(java.util.Collection<Object> values) {
		this._includes.addAll(values);
		return this;
	}

	public Antlr4 removeIncludes(Object value) {
		this._includes.remove(value);
		return this;
	}

	public Antlr4 removeIncludes(int index) {
		this._includes.remove(index);
		return this;
	}

	public java.util.List<Object> getIncludes() {
		return this._includes;
	} 

	public Antlr4 addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public Antlr4 setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Antlr4 setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public Antlr4 removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public Antlr4 removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Antlr4 that = (Antlr4) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "antlr4(version,sourceDirectory,grammars,includes,arguments,outputDirectory,visitor,listener,goal) ::= <<<plugin>\n" + 
				"	<groupId>org.antlr</groupId>\n" + 
				"	<artifactId>antlr4-maven-plugin</artifactId>\n" + 
				"	<version>~if(version)~~version~~else~4.8-1~endif~</version>\n" + 
				"	<configuration>\n" + 
				"		<sourceDirectory>~sourceDirectory~</sourceDirectory>\n" + 
				"		~grammars:{it|<grammars>~it~.g4</grammars>};separator=\"\\n\"~\n" + 
				"		<includes>\n" + 
				"			~includes:{it|<include>~it~.g4</include>};separator=\"\\n\"~\n" + 
				"		</includes>		\n" + 
				"		<arguments>\n" + 
				"			~arguments:{it|<argument>~it~</argument>};separator=\"\\n\"~\n" + 
				"		</arguments>\n" + 
				"		<outputDirectory>~outputDirectory~</outputDirectory>\n" + 
				"		<visitor>~if(visitor)~true~else~false~endif~</visitor>\n" + 
				"		<listener>~if(listener)~true~else~false~endif~</listener>\n" + 
				"	</configuration>\n" + 
				"	<executions>\n" + 
				"		<execution>\n" + 
				"			<goals>\n" + 
				"				<goal>~if(goal)~~goal~~else~antlr4~endif~</goal>\n" + 
				"		</goals>\n" + 
				"		</execution>\n" + 
				"	</executions>\n" + 
				"</plugin> >>";
} 