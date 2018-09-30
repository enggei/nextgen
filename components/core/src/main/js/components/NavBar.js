import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { inject, observer } from 'mobx-react';
import { Navbar, Nav, NavItem, MenuItem, NavDropdown, FormGroup, FormControl, Button } from 'react-bootstrap';
import { LinkContainer } from "react-router-bootstrap";

const LoggedOutView = props => {

	if (!props.currentUser) {
		return (
            <Nav pullRight>
                <Navbar.Text>
                     <LinkContainer to="/login">
                       <NavItem>Login</NavItem>
                     </LinkContainer>
                </Navbar.Text>
            </Nav>
		);
	}

	return null;
};

const LoggedInView = props => {

	if (props.currentUser) {
		return (
            <Nav pullRight>

                <NavDropdown eventKey={3} title="Actions" id="basic-nav-dropdown">

                     <LinkContainer to="/graph">
                        <MenuItem eventKey={3.9}><i className="fa fa-sign-in" /> Graph </MenuItem>
                    </LinkContainer>

                    <LinkContainer to="/logout">
                        <MenuItem eventKey={3.9}><i className="fa fa-sign-in" /> Sign out</MenuItem>
                    </LinkContainer>

                </NavDropdown>
                <Navbar.Text pullRight>
                      <span> {props.currentUser.username} </span>
                </Navbar.Text>
            </Nav>
		);
	}

	return null;
};

@inject('userStore', 'appStore')
@observer
class NavBar extends Component {

	render() {
		return (

           <Navbar>
             <Navbar.Header>
               <Navbar.Brand>
                 <a href="#home">N E X T G E N</a>
               </Navbar.Brand>
               <Navbar.Toggle />
             </Navbar.Header>
             <Navbar.Collapse>
               <LoggedOutView currentUser={this.props.userStore.currentUser} />
               <LoggedInView currentUser={this.props.userStore.currentUser} />
             </Navbar.Collapse>
           </Navbar>
		);
	}
}

export default NavBar;