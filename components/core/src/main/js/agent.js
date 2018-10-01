import superagentPromise from 'superagent-promise';
import _superagent from 'superagent';
import appStore from './stores/AppStore';
import authStore from './stores/AuthStore';

const superagent = superagentPromise(_superagent, global.Promise);

const API_ROOT = 'https://localhost:8080';

const encode = encodeURIComponent;

const handleErrors = err => {
	if (err && err.response && err.response.status === 401) {
		authStore.logout();
	}
	return err;
};

const responseBody = res => res.body;

const tokenPlugin = req => {
	if (appStore.token) {
		req.set('Authorization', `Bearer ${appStore.token}`);
	}
};

const requests = {
	del: url =>
		superagent
			.del(`${API_ROOT}${url}`)
			.use(tokenPlugin)
			.end(handleErrors)
			.then(responseBody),
	get: url =>
		superagent
			.get(`${API_ROOT}${url}`)
			.use(tokenPlugin)
			.end(handleErrors)
			.then(responseBody),
	put: (url, body) =>
		superagent
			.put(`${API_ROOT}${url}`, body)
			.use(tokenPlugin)
			.end(handleErrors)
			.then(responseBody),
	post: (url, body) =>
		superagent
			.post(`${API_ROOT}${url}`, body)
			.use(tokenPlugin)
			.end(handleErrors)
			.then(responseBody)
};

const Auth = { 
	current: () => requests.get('/user'),
	login: (username, password) => requests.post('/login', { username, password }),
	register: (username, password, organization) => requests.post('/register', { username, password, organization }),
	save: (user) => requests.put('/user', { user })	
}

const Graph = { 
	last: () => requests.get('/api/graph/last')	
}


export default {
	Auth,
	Graph
};