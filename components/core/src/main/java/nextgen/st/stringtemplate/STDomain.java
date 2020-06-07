package nextgen.st.stringtemplate;

public class STDomain {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _stgString;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();

	STDomain(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STDomain that = (STDomain) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STDomain");
		st.add("packageName" ,_packageName);
		st.add("name" ,_name);
		st.add("stgString" ,_stgString);
		for (Object o : _entities) st.add("entities", o);
		return st.render().trim();
	}

	public STDomain setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public STDomain removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STDomain setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STDomain removeName() {
		this._name = null;
		return this;
	} 

	public STDomain setStgString(Object value) {
		this._stgString = value;
		return this;
	}

	public Object getStgString() {
		return this._stgString;
	}

	public boolean hasStgString() {
		return this._stgString != null;
	}

	public STDomain removeStgString() {
		this._stgString = null;
		return this;
	} 
	public STDomain addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public STDomain removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public STDomain removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 

	static final String st = "STDomain(packageName,name,stgString,entities) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private static final String stg = ~stgString~;\n" + 
				"\n" + 
				"	public static org.stringtemplate.v4.STGroup defaultSTGroup() {\n" + 
				"		org.stringtemplate.v4.STGroup stGroup = new org.stringtemplate.v4.STGroupString(\"~name~\", stg, '\\~', '\\~');\n" + 
				"		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());\n" + 
				"		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {\n" + 
				"			@Override\n" + 
				"			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"compileTimeError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;\n" + 
				"				System.out.println(\"runTimeError \" + stMessage.self.getName() + \" \" + stRuntimeMessage.getSourceLocation());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"IOError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"internalError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"		});\n" + 
				"		return stGroup;\n" + 
				"	}\n" + 
				"	\n" + 
				"	private static org.stringtemplate.v4.STGroup stGroup = defaultSTGroup();\n" + 
				"\n" + 
				"	public static void setSTGroup(final String stgFile) {\n" + 
				"		stGroup = new org.stringtemplate.v4.STGroupFile(stgFile, '\\~', '\\~');\n" + 
				"		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());\n" + 
				"		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {\n" + 
				"			@Override\n" + 
				"			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"compileTimeError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;\n" + 
				"				System.out.println(\"runTimeError \" + stMessage.self.getName() + \" \" + stRuntimeMessage.getSourceLocation());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"IOError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {\n" + 
				"				System.out.println(\"internalError \" + stMessage.toString());\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	~entities:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public String toString(Object o, String formatString, java.util.Locale locale) {\n" + 
				"\n" + 
				"			final String text = o.toString();\n" + 
				"			if (formatString == null) return text;\n" + 
				"\n" + 
				"			final String s = text.length() > 1 ? text.substring(1) : \"\";\n" + 
				"			\n" + 
				"			switch (formatString) {\n" + 
				"				case \"capitalize\":\n" + 
				"					return Character.toUpperCase(text.charAt(0)) + s;\n" + 
				"				case \"toUpper\":\n" + 
				"					return text.toUpperCase();\n" + 
				"				case \"lowFirst\":\n" + 
				"					return Character.toLowerCase(text.charAt(0)) + s;\n" + 
				"				case \"toLower\":\n" + 
				"					return text.toLowerCase();\n" + 
				"				default:\n" + 
				"					return o.toString();\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"}>> ";
} 