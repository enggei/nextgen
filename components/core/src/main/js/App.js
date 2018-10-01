import React, { Component } from 'react';
import { Switch, Route, withRouter } from 'react-router-dom';

import { Provider } from 'mobx-react';
import { inject, observer } from 'mobx-react';

import NavBar from './components/NavBar.js';
import LoginForm from './components/authentication/LoginForm.js';
import LogoutForm from './components/authentication/LogoutForm.js';
import RegisterForm from './components/authentication/RegisterForm.js';

import GraphCanvas from './components/GraphCanvas.js';
import Canvas from './components/graph/Canvas.js';

@inject('userStore', 'appStore', 'authStore', 'graphStore', 'domainStore')
@withRouter
@observer
class App extends Component {

	componentWillMount() {
		if (!this.props.appStore.token) {
			this.props.appStore.setAppLoaded();
		}
	}

	componentDidMount() {
		if (this.props.appStore.token) {
			this.props.userStore.pullUser().finally(() => this.props.appStore.setAppLoaded());
		}
	}

	render() {

		if (this.props.appStore.appLoaded) {
			return (
				<div>
					<NavBar />
					<Switch>
						<Route path="/login" component={LoginForm} />
						<Route path="/logout" component={LogoutForm} />
						<Route path="/register" component={RegisterForm} />
						<Route path="/graph" component={GraphCanvas} />
						<Route path="/boxes" component={Canvas} />
					</Switch>
				</div>
			);
		}

		return (
			<div>
				<NavBar />
					<footer className="footer">
						&copy; Copyright <span>{(new Date().getFullYear())}</span> 
					</footer>
				</div>
			);
	}
}

export default App;