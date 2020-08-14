package nextgen.templates.javascript;

public class SignOut {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	SignOut(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SignOut");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SignOut that = (SignOut) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SignOut() ::= <<import React from 'react';\n" + 
				"import Avatar from '@material-ui/core/Avatar';\n" + 
				"import Button from '@material-ui/core/Button';\n" + 
				"import TextField from '@material-ui/core/TextField';\n" + 
				"import FormControlLabel from '@material-ui/core/FormControlLabel';\n" + 
				"import Checkbox from '@material-ui/core/Checkbox';\n" + 
				"import Link from '@material-ui/core/Link';\n" + 
				"import Grid from '@material-ui/core/Grid';\n" + 
				"import Box from '@material-ui/core/Box';\n" + 
				"import LockOutlinedIcon from '@material-ui/icons/LockOutlined';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import { makeStyles } from '@material-ui/core/styles';\n" + 
				"import Container from '@material-ui/core/Container';\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"	paper: {\n" + 
				"		marginTop: theme.spacing(8),\n" + 
				"		display: 'flex',\n" + 
				"		flexDirection: 'column',\n" + 
				"		alignItems: 'center',\n" + 
				"	},\n" + 
				"	form: {\n" + 
				"		width: '100%', // Fix IE 11 issue.\n" + 
				"		marginTop: theme.spacing(1),\n" + 
				"	},\n" + 
				"	submit: {\n" + 
				"		margin: theme.spacing(3, 0, 2),\n" + 
				"	},\n" + 
				"}));\n" + 
				"\n" + 
				"export default function SignOut(props) {\n" + 
				"\n" + 
				"	const classes = useStyles();\n" + 
				"	const { onSubmit } = props;\n" + 
				"\n" + 
				"	return (\n" + 
				"		<Container component=\"main\" maxWidth=\"xs\">\n" + 
				"			<div className={classes.paper}>\n" + 
				"				<form className={classes.form} noValidate onSubmit={ onSubmit }>					\n" + 
				"					<Button\n" + 
				"						type=\"submit\"\n" + 
				"						fullWidth\n" + 
				"						variant=\"contained\"\n" + 
				"						color=\"primary\"\n" + 
				"						className={classes.submit} >\n" + 
				"						Logout\n" + 
				"					</Button>\n" + 
				"				</form>\n" + 
				"			</div>\n" + 
				"		</Container>\n" + 
				"	);\n" + 
				"} >>";
}  