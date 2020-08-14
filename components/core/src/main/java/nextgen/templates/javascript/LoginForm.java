package nextgen.templates.javascript;

public class LoginForm {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	LoginForm(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LoginForm");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoginForm that = (LoginForm) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LoginForm() ::= <<import { withRouter } from 'react-router-dom';\n" + 
				"import React from 'react';\n" + 
				"\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"import SignIn from '../components/SignIn.js';\n" + 
				"\n" + 
				"@withRouter\n" + 
				"@inject('authStore')\n" + 
				"@observer\n" + 
				"class LoginForm extends React.Component {\n" + 
				"\n" + 
				"	constructor(){\n" + 
				"		super();\n" + 
				"		this.handleSubmitForm = this.handleSubmitForm.bind(this);\n" + 
				"		this.handleUsernameChange = this.handleUsernameChange.bind(this);\n" + 
				"		this.handlePasswordChange = this.handlePasswordChange.bind(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	handleSubmitForm = (e) => {\n" + 
				"		e.preventDefault();\n" + 
				"		this.props.authStore.login().then(() => this.props.history.replace('/')).catch(e => {});\n" + 
				"	}\n" + 
				"\n" + 
				"	handleUsernameChange = (e) => {\n" + 
				"		this.props.authStore.setUsername(e.target.value);\n" + 
				"	}\n" + 
				"\n" + 
				"	handlePasswordChange = (e) => {\n" + 
				"		this.props.authStore.setPassword(e.target.value);\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"		return (<SignIn authStore={ this.props.authStore } onSubmit={ this.handleSubmitForm } />);\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (LoginForm); >>";
}  