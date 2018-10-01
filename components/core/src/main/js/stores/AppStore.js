import { observable, action, reaction } from 'mobx';
import agent from '../agent';

class AppStore {

	@observable appName = 'N E X T G E N';
	@observable token = window.localStorage.getItem('jwt');
	@observable appLoaded = false;

	constructor() {
		reaction(
			() => this.token,
			token => {
				if (token) {
					window.localStorage.setItem('jwt', token);
				} else {
					window.localStorage.removeItem('jwt');
				}
			}
		);
	}

	@action setToken(token) {
		this.token = token;
	}

	@action setAppLoaded() {
		this.appLoaded = true;
	}
}

export default new AppStore();