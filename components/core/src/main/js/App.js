import React, { Component } from 'react';
import { Switch, Route, withRouter } from 'react-router-dom';

import { Provider } from 'mobx-react';
import { inject, observer } from 'mobx-react';

import NavBar from './components/NavBar.js';
import LoginForm from './components/LoginForm.js';
import LogoutForm from './components/LogoutForm.js';
import RegisterForm from './components/RegisterForm.js';
import GraphCanvas from './components/GraphCanvas.js';
import Canvas from './components/graph/canvas.js';

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
						<span>{(new Date().getFullYear())}</span> Nextgen
					</footer>
				</div>
			);
	}
}

export default App;