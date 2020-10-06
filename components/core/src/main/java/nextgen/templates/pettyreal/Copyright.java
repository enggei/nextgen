package nextgen.templates.pettyreal;

public class Copyright {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _companyName;

	Copyright(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Copyright");
		st.add("companyName", _companyName);
		return st.render().trim();
	}

	public Copyright setCompanyName(Object value) {
		this._companyName = value;
		return this;
	}

	public Object getCompanyName() {
		return this._companyName;
	}

	public Object getCompanyName(Object defaultValue) {
		return this._companyName == null ? defaultValue : this._companyName;
	}

	public boolean hasCompanyName() {
		return this._companyName != null;
	}

	public Copyright removeCompanyName() {
		this._companyName = null;
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

	static final String st = "Copyright(companyName) ::= <<import React from 'react';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import Link from '@material-ui/core/Link';\n" + 
				"\n" + 
				"export default function Copyright() {\n" + 
				"\n" + 
				"	return (\n" + 
				"		<Typography variant=\"body2\" color=\"textSecondary\" align=\"center\">\n" + 
				"			{'Copyright © ~companyName~ '}\n" + 
				"			{new Date().getFullYear()}\n" + 
				"		</Typography>\n" + 
				"	);\n" + 
				"} >>";
}  