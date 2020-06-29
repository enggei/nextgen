package nextgen.templates.javascript;

public class SignIn {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	SignIn(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SignIn");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SignIn that = (SignIn) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SignIn() ::= <<import React from 'react';\n" + 
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
				"import ListErrors from '../components/ListErrors.js';\n" + 
				"import Copyright from '../components/Copyright.js';\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"	paper: {\n" + 
				"		marginTop: theme.spacing(8),\n" + 
				"		display: 'flex',\n" + 
				"		flexDirection: 'column',\n" + 
				"		alignItems: 'center',\n" + 
				"	},\n" + 
				"		avatar: {\n" + 
				"		margin: theme.spacing(1),\n" + 
				"		backgroundColor: theme.palette.secondary.main,\n" + 
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
				"export default function SignIn(props) {\n" + 
				"\n" + 
				"	const classes = useStyles();\n" + 
				"	const { values, errors, inProgress } = props.authStore;\n" + 
				"	const { onSubmit } = props;\n" + 
				"\n" + 
				"	return (\n" + 
				"\n" + 
				"		<Container component=\"main\" maxWidth=\"xs\">\n" + 
				"			<ListErrors errors={errors} />\n" + 
				"			<div className={classes.paper}>\n" + 
				"				<Avatar className={classes.avatar}>\n" + 
				"					<LockOutlinedIcon />\n" + 
				"				</Avatar>\n" + 
				"				<Typography component=\"h1\" variant=\"h5\">\n" + 
				"					Log in\n" + 
				"				</Typography>\n" + 
				"				<form className={ classes.form } onSubmit={ onSubmit } noValidate>\n" + 
				"					<TextField\n" + 
				"						value={ values.username }\n" + 
				"						variant=\"outlined\"\n" + 
				"						margin=\"normal\"\n" + 
				"						required\n" + 
				"						fullWidth\n" + 
				"						id=\"email\"\n" + 
				"						label=\"Email Address\"\n" + 
				"						name=\"email\"\n" + 
				"						autoComplete=\"email\"\n" + 
				"						autoFocus />\n" + 
				"					<TextField\n" + 
				"						value={ values.password }\n" + 
				"						variant=\"outlined\"\n" + 
				"						margin=\"normal\"\n" + 
				"						required\n" + 
				"						fullWidth\n" + 
				"						name=\"password\"\n" + 
				"						label=\"Password\"\n" + 
				"						type=\"password\"\n" + 
				"						id=\"password\"\n" + 
				"						autoComplete=\"current-password\" />\n" + 
				"					<Button\n" + 
				"						className={classes.submit}\n" + 
				"						type=\"submit\"\n" + 
				"						fullWidth\n" + 
				"						variant=\"contained\"\n" + 
				"						color=\"primary\">\n" + 
				"						Log in\n" + 
				"					</Button>\n" + 
				"				</form>\n" + 
				"			</div>\n" + 
				"			<Box mt={8}>\n" + 
				"				<Copyright />\n" + 
				"			</Box>\n" + 
				"		</Container>\n" + 
				"	);\n" + 
				"} >>";
}  