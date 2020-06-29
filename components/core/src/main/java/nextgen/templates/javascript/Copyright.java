package nextgen.templates.javascript;

public class Copyright {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;

	Copyright(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Copyright");
		st.add("name", _name);
		return st.render().trim();
	}

	public Copyright setName(Object value) {
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

	public Copyright removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Copyright that = (Copyright) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Copyright(name) ::= <<import React from 'react';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import Link from '@material-ui/core/Link';\n" + 
				"\n" + 
				"export default function Copyright() {\n" + 
				"\n" + 
				"	return (\n" + 
				"		<Typography variant=\"body2\" color=\"textSecondary\" align=\"center\">\n" + 
				"			{'Copyright © ~name~ '}\n" + 
				"			{new Date().getFullYear()}\n" + 
				"		</Typography>\n" + 
				"	);\n" + 
				"} >>";
}  