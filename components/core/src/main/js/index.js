import ReactDOM from 'react-dom';
import promiseFinally from 'promise.prototype.finally';
import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { useStrict } from 'mobx';
import { Provider } from 'mobx-react';

import App from './App';

// todo remove these defaults, and use builder to add these:
import appStore from './stores/AppStore';
import authStore from './stores/AuthStore';
import userStore from './stores/UserStore';

import graphStore from './stores/GraphStore';
import domainStore from './stores/DomainStore';

import './index.css';
import './css/app.css';

const stores = {
	appStore,
	authStore,
	userStore,
	graphStore,
	domainStore
};

ReactDOM.render((
	<Provider {...stores}>
		<BrowserRouter>
			<App />
		</BrowserRouter>
	</Provider>
), document.getElementById('root'));