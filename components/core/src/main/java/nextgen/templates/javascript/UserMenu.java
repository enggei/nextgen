package nextgen.templates.javascript;

public class UserMenu {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	UserMenu(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UserMenu");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserMenu that = (UserMenu) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UserMenu() ::= <<import React from 'react';\n" + 
				"import { Link } from 'react-router-dom';\n" + 
				"\n" + 
				"import Button from '@material-ui/core/Button';\n" + 
				"import Menu from '@material-ui/core/Menu';\n" + 
				"import MenuItem from '@material-ui/core/MenuItem';\n" + 
				"import MenuList from '@material-ui/core/MenuList';\n" + 
				"import IconButton from '@material-ui/core/IconButton';\n" + 
				"import MenuIcon from '@material-ui/icons/Menu';\n" + 
				"\n" + 
				"const LoginLink = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref } to=\"/login\" { ...props } />\n" + 
				"));\n" + 
				"\n" + 
				"const LogoutLink = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref } to=\"/logout\" { ...props } />\n" + 
				"));\n" + 
				"\n" + 
				"export default function UserMenu(props) {\n" + 
				"\n" + 
				"	const [anchorEl, setAnchorEl] = React.useState(null);\n" + 
				"\n" + 
				"	function handleClick(event) {\n" + 
				"		setAnchorEl(event.currentTarget);\n" + 
				"	}\n" + 
				"	\n" + 
				"	function handleClose() {\n" + 
				"		setAnchorEl(null);\n" + 
				"	}\n" + 
				"\n" + 
				"	if (!props.currentUser)  {\n" + 
				"		return (\n" + 
				"			<div>\n" + 
				"				<IconButton edge=\"start\" color=\"inherit\" aria-label=\"Menu\" onClick={handleClick}>\n" + 
				"					<MenuIcon />\n" + 
				"				</IconButton>\n" + 
				"				<Menu id=\"simple-menu\" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose}>\n" + 
				"					<MenuItem component={ LoginLink } onClick={handleClose}>Login</MenuItem>\n" + 
				"				</Menu>\n" + 
				"			</div>);\n" + 
				"	} else {\n" + 
				"		return (\n" + 
				"			<div>\n" + 
				"				<IconButton edge=\"start\" color=\"inherit\" aria-label=\"Menu\" onClick={handleClick}>\n" + 
				"						<MenuIcon />\n" + 
				"				</IconButton>\n" + 
				"				<Menu id=\"simple-menu\" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose}>\n" + 
				"					{props.currentUser.menus.map((e, i) => (<MenuItem key={e.key} component={ React.forwardRef( (props, ref) => (<Link innerRef={ ref } to={e.url} { ...props } />)) } onClick={handleClose}> {e.label} </MenuItem>))}\n" + 
				"					<MenuItem component={ LogoutLink } onClick={handleClose}> Logout </MenuItem> \n" + 
				"				</Menu>\n" + 
				"			</div>);\n" + 
				"	}\n" + 
				"} >>";
}  