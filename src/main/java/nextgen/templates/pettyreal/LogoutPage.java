package nextgen.templates.pettyreal;

public class LogoutPage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	LogoutPage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LogoutPage");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LogoutPage that = (LogoutPage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LogoutPage() ::= <<import { withRouter } from 'react-router-dom';\n" + 
				"import React from 'react';\n" + 
				"\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"import LogoutForm from '../components/LogoutForm';\n" + 
				"\n" + 
				"@withRouter\n" + 
				"@inject('authStore')\n" + 
				"@observer\n" + 
				"class LogoutPage extends React.Component {\n" + 
				"\n" + 
				"	constructor(){\n" + 
				"		super();\n" + 
				"		this.handleSubmitForm = this.handleSubmitForm.bind(this);\n" + 
				"	}\n" + 
				"\n" + 
				"	handleSubmitForm = (e) => {\n" + 
				"		e.preventDefault();\n" + 
				"		this.props.authStore.logout().then(() => this.props.history.replace('/')).catch(e => {});\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"		return (<LogoutForm authStore={ this.props.authStore } onSubmit={ this.handleSubmitForm } />);\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (LogoutPage); >>";
}  