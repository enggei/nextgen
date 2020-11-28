package nextgen.templates.pettyreal;

public class NavigationBar {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _header;

	NavigationBar(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NavigationBar");
		st.add("header", _header);
		return st.render().trim();
	}

	public NavigationBar setHeader(Object value) {
		this._header = value;
		return this;
	}

	public Object getHeader() {
		return this._header;
	}

	public Object getHeader(Object defaultValue) {
		return this._header == null ? defaultValue : this._header;
	}

	public boolean hasHeader() {
		return this._header != null;
	}

	public NavigationBar removeHeader() {
		this._header = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NavigationBar that = (NavigationBar) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NavigationBar(header) ::= <<import React from 'react';\n" + 
				"import { Link } from 'react-router-dom';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"import AppBar from '@material-ui/core/AppBar';\n" + 
				"import Toolbar from '@material-ui/core/Toolbar';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import Button from '@material-ui/core/Button';\n" + 
				"import { withStyles } from '@material-ui/core/styles';\n" + 
				"\n" + 
				"import UserMenu from './UserMenu.js';\n" + 
				"\n" + 
				"const useStyles = theme => ({\n" + 
				"	news: {\n" + 
				"		flex: 1\n" + 
				"	}\n" + 
				"});\n" + 
				"\n" + 
				"const LoginLink = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref } to=\"/login\" { ...props } />\n" + 
				"));\n" + 
				"\n" + 
				"const LogoutLink = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref } to=\"/logout\" { ...props } />\n" + 
				"));\n" + 
				"\n" + 
				"const LoggedOutView = props => {\n" + 
				"	if (!props.currentUser)  {\n" + 
				"		return (<Button color=\"inherit\" component={ LoginLink }>\n" + 
				"			Login\n" + 
				"		</Button>);\n" + 
				"	}\n" + 
				"	return null;\n" + 
				"}\n" + 
				"\n" + 
				"const LoggedInView = props => {\n" + 
				"	if (props.currentUser)  {\n" + 
				"		return (<Button color=\"inherit\" component={ LogoutLink }>\n" + 
				"			Logout\n" + 
				"		</Button>);\n" + 
				"	}\n" + 
				"	return null;\n" + 
				"}\n" + 
				"\n" + 
				"@inject('userStore', 'appStore')\n" + 
				"@observer\n" + 
				"@withStyles(useStyles)\n" + 
				"class NavigationBar extends React.Component {\n" + 
				"\n" + 
				"	constructor(){\n" + 
				"		super();\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"		return ( \n" + 
				"			<div>\n" + 
				"				<AppBar color='primary' position='static'>\n" + 
				"					<Toolbar>\n" + 
				"						<UserMenu currentUser={ this.props.userStore.currentUser } />\n" + 
				"						<Typography variant=\"h6\" className={ this.props.classes.news }>~header~</Typography>\n" + 
				"						<LoggedOutView currentUser={ this.props.userStore.currentUser } />\n" + 
				"						<LoggedInView currentUser={ this.props.userStore.currentUser } />\n" + 
				"					</Toolbar>\n" + 
				"				</AppBar>\n" + 
				"			</div>\n" + 
				"		)\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (NavigationBar); >>";
}  