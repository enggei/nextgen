package nextgen.templates.javascript;

public class ListErrors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	ListErrors(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListErrors");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListErrors that = (ListErrors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListErrors() ::= <<import React from 'react';\n" + 
				"import { withStyles } from '@material-ui/core/styles';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"\n" + 
				"const useStyles = theme => ({\n" + 
				"	errors: {\n" + 
				"		color: 'red'\n" + 
				"	},\n" + 
				"\n" + 
				"});\n" + 
				"\n" + 
				"@withStyles(useStyles)\n" + 
				"class ListErrors extends React.Component {\n" + 
				"\n" + 
				"	render() {\n" + 
				"\n" + 
				"		const errors = this.props.errors;\n" + 
				"\n" + 
				"		if (errors) \n" + 
				"			return (\n" + 
				"				<ul className={ this.props.classes.errors }> { Object.keys(errors).map(key => { return (<li key={key}><Typography>{errors[key]}</Typography></li>);}) }\n" + 
				"				</ul>\n" + 
				"			);\n" + 
				"\n" + 
				"		return null;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default ListErrors; >>";
}  