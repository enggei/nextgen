package nextgen.templates.javascript;

public class LogoutForm {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	LogoutForm(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LogoutForm");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LogoutForm that = (LogoutForm) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LogoutForm() ::= <<// dependencies:\n" + 
				"import { withRouter } from 'react-router-dom';\n" + 
				"import React from 'react';\n" + 
				"import Button from '@material-ui/core/Button';\n" + 
				"import CssBaseline from '@material-ui/core/CssBaseline';\n" + 
				"import TextField from '@material-ui/core/TextField';\n" + 
				"import FormControlLabel from '@material-ui/core/FormControlLabel';\n" + 
				"import Checkbox from '@material-ui/core/Checkbox';\n" + 
				"import Grid from '@material-ui/core/Grid';\n" + 
				"import Box from '@material-ui/core/Box';\n" + 
				"import LockOutlinedIcon from '@material-ui/icons/LockOutlined';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import Container from '@material-ui/core/Container';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"import { withStyles } from '@material-ui/core/styles';\n" + 
				"\n" + 
				"const useStyles = theme => ({\n" + 
				"	'@global': {\n" + 
				"		body: {\n" + 
				"			backgroundColor: 'theme.palette.common.white'\n" + 
				"		}\n" + 
				"	},\n" + 
				"	paper: {\n" + 
				"		marginTop: 'theme.spacing(8)',\n" + 
				"		display: 'flex',\n" + 
				"		flexDirection: 'column',\n" + 
				"		alignItems: 'center'\n" + 
				"	},\n" + 
				"	x: {\n" + 
				"		marginTop: '10vh'\n" + 
				"	},\n" + 
				"	form: {\n" + 
				"		width: '100%',\n" + 
				"		marginTop: 'theme.spacing(1)'\n" + 
				"	},\n" + 
				"	submit: {\n" + 
				"		margin: 'theme.spacing(3, 0, 2)'\n" + 
				"	}\n" + 
				"});\n" + 
				"\n" + 
				"@withRouter\n" + 
				"@inject('authStore')\n" + 
				"@withStyles(useStyles)\n" + 
				"class LogoutForm extends React.Component {\n" + 
				"\n" + 
				"	constructor(){\n" + 
				"		super();\n" + 
				"		this.handleSubmitForm = this.handleSubmitForm.bind(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	handleSubmitForm = (e) => {\n" + 
				"		e.preventDefault();\n" + 
				"		this.props.authStore.logout().then(() => this.props.history.replace('/'));\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"		return ( \n" + 
				"			<Container className={ this.props.classes.x } maxWidth='xs' component=\"main\">\n" + 
				"				<CssBaseline />\n" + 
				"				<div className={ this.props.classes.paper }>\n" + 
				"					<Typography component='h1' variant='h5' />\n" + 
				"				</div>\n" + 
				"				<form className={ this.props.classes.form } noValidate onSubmit={ this.handleSubmitForm }>\n" + 
				"					<Button type='submit' fullWidth variant='contained' color='primary' className={ this.props.classes.submit }>\n" + 
				"						Logout\n" + 
				"					</Button>\n" + 
				"				</form>\n" + 
				"			</Container>\n" + 
				"		)\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (LogoutForm); >>";
} 