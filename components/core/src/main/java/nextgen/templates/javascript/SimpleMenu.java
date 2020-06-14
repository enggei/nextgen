package nextgen.templates.javascript;

public class SimpleMenu {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _menuComponents = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _menuItems = new java.util.ArrayList<>();

	SimpleMenu(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SimpleMenu");
		for (Object o : _menuComponents) st.add("menuComponents", o);
		for (java.util.Map<String, Object> map : _menuItems) st.addAggr("menuItems.{name,to,target,element}", map.get("name"), map.get("to"), map.get("target"), map.get("element"));
		return st.render().trim();
	}


	public SimpleMenu addMenuComponents(Object value) {
		this._menuComponents.add(value);
		return this;
	}

	public SimpleMenu setMenuComponents(Object[] value) {
		this._menuComponents.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SimpleMenu setMenuComponents(java.util.Collection<Object> values) {
		this._menuComponents.addAll(values);
		return this;
	}

	public SimpleMenu removeMenuComponents(Object value) {
		this._menuComponents.remove(value);
		return this;
	}

	public SimpleMenu removeMenuComponents(int index) {
		this._menuComponents.remove(index);
		return this;
	}

	public java.util.List<Object> getMenuComponents() {
		return this._menuComponents;
	}

	public SimpleMenu addMenuItems(Object _name, Object _to, Object _target, Object _element) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("to", _to);
		map.put("target", _target);
		map.put("element", _element);
		this._menuItems.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getMenuItems() {
		return this._menuItems;
	}

	public SimpleMenu addMenuItems(SimpleMenu_MenuItems value) {
		return addMenuItems(value._name, value._to, value._target, value._element);
	}

	public java.util.stream.Stream<SimpleMenu_MenuItems> streamMenuItems() {
		return this._menuItems.stream().map(SimpleMenu_MenuItems::new);
	}

	public static final class SimpleMenu_MenuItems {

		Object _name;
		Object _to;
		Object _target;
		Object _element;

		public SimpleMenu_MenuItems(Object _name, Object _to, Object _target, Object _element) {
			this._name = _name;
			this._to = _to;
			this._target = _target;
			this._element = _element;
		}

		private SimpleMenu_MenuItems(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._to = (Object) map.get("to");
			this._target = (Object) map.get("target");
			this._element = (Object) map.get("element");
		}

		public Object getName() {
			return this._name;
		}

		public Object getTo() {
			return this._to;
		}

		public Object getTarget() {
			return this._target;
		}

		public Object getElement() {
			return this._element;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SimpleMenu that = (SimpleMenu) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SimpleMenu(menuItems,menuComponents) ::= <<import React from 'react';\n" + 
				"import Button from '@material-ui/core/Button';\n" + 
				"import Menu from '@material-ui/core/Menu';\n" + 
				"import MenuItem from '@material-ui/core/MenuItem';\n" + 
				"import MenuList from '@material-ui/core/MenuList';\n" + 
				"import IconButton from '@material-ui/core/IconButton';\n" + 
				"import MenuIcon from '@material-ui/icons/Menu';\n" + 
				"import { Link } from 'react-router-dom';\n" + 
				"\n" + 
				"const LoginLink = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref } to=\"/login\" { ...props } />\n" + 
				"));\n" + 
				"\n" + 
				"~menuItems:{it|\n" + 
				"const ~it.name~ = React.forwardRef( (props, ref) => (\n" + 
				"	<Link innerRef={ ref ~eom()~ to=\"/~it.to~\"~if(it.target)~ target=\"~it.target~\" ~endif~ { ...props ~eom()~ />\n" + 
				"));\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"export default function SimpleMenu(props) {\n" + 
				"\n" + 
				"  const [anchorEl, setAnchorEl] = React.useState(null);\n" + 
				"\n" + 
				"  function handleClick(event) {\n" + 
				"    setAnchorEl(event.currentTarget);\n" + 
				"  }\n" + 
				"\n" + 
				"  function handleClose() {\n" + 
				"    setAnchorEl(null);\n" + 
				"  }\n" + 
				"\n" + 
				"    if (!props.currentUser)  {\n" + 
				"        return (\n" + 
				"            <div>\n" + 
				"                <IconButton edge=\"start\" color=\"inherit\" aria-label=\"Menu\" onClick={handleClick}>\n" + 
				"                    <MenuIcon />\n" + 
				"                </IconButton>\n" + 
				"                <Menu id=\"simple-menu\" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose}>\n" + 
				"                    <MenuItem component={ LoginLink } onClick={handleClose}>Login</MenuItem>\n" + 
				"                </Menu>\n" + 
				"            </div>);\n" + 
				"    	}\n" + 
				"\n" + 
				"    else {\n" + 
				"         return (\n" + 
				"                <div>\n" + 
				"                    <IconButton edge=\"start\" color=\"inherit\" aria-label=\"Menu\" onClick={handleClick}>\n" + 
				"                        <MenuIcon />\n" + 
				"                    </IconButton>\n" + 
				"                    <Menu id=\"simple-menu\" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose}>\n" + 
				"                       ~menuItems:{it|~it.element~};separator=\"\\n\"~\n" + 
				"                       ~menuComponents:{it|~it~};separator=\"\\n\"~\n" + 
				"                    </Menu>\n" + 
				"                </div>);\n" + 
				"        }\n" + 
				"}>>";
}