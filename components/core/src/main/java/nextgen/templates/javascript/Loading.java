package nextgen.templates.javascript;

public class Loading {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Loading(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Loading");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Loading that = (Loading) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Loading() ::= <<import React from 'react';\n" + 
				"\n" + 
				"const style  = {\n" + 
				"	borderRadius: '50%',\n" + 
				"	width: '20px',\n" + 
				"	height: '20px',\n" + 
				"	margin: '10px auto',\n" + 
				"	position: 'relative',\n" + 
				"	borderTop: '3px solid rgba(0, 0, 0, 0.1)',\n" + 
				"	borderRight: '3px solid rgba(0, 0, 0, 0.1)',\n" + 
				"	borderBottom: '3px solid rgba(0, 0, 0, 0.1)',\n" + 
				"	borderLeft: '3px solid #818a91',\n" + 
				"	transform: 'translateZ(0)',\n" + 
				"	animation: 'loading-spinner 0.5s infinite linear'\n" + 
				"};\n" + 
				"\n" + 
				"export default class Loading extends React.Component {\n" + 
				"	\n" + 
				"	render() {\n" + 
				"	\n" + 
				"		return (\n" + 
				"			<div className=\"loading-spinner\" style={style}>\n" + 
				"				<style>\n" + 
				"				{`\n" + 
				"					@keyframes loading-spinner {\n" + 
				"						0% { transform : rotate(0deg); }\n" + 
				"						100% { transform : rotate(360deg); }\n" + 
				"					}\n" + 
				"				`}\n" + 
				"				</style>\n" + 
				"			</div>\n" + 
				"		);\n" + 
				"	}\n" + 
				"} >>";
} 