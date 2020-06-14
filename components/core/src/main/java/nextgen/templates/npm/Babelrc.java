package nextgen.templates.npm;

public class Babelrc {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Babelrc(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("babelrc");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Babelrc that = (Babelrc) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "babelrc() ::= <<{\n" + 
				"	\"presets\": [\n" + 
				"		\"@babel/preset-env\", \n" + 
				"		\"@babel/preset-react\"\n" + 
				"	],\n" + 
				"	\"plugins\": [\n" + 
				"		[\"module:@babel/plugin-proposal-decorators\", { \"legacy\": true }],\n" + 
				"		[\"module:@babel/plugin-proposal-class-properties\", { \"loose\": true }]\n" + 
				"	]\n" + 
				"} >>";
} 