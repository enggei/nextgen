import { observable, action } from 'mobx';
import agent from '../agent';
import userStore from './UserStore';
import appStore from './AppStore';

class AuthStore {

  @observable inProgress = false;
  @observable errors = undefined;

  @observable values = {
    username: 'test',
    password: 'test',
  };

  @action setUsername(username) {
    this.values.username = username;
  }

  @action setPassword(password) {
    this.values.password = password;
  }

   @action setOrganization(organization) {
    this.values.organization = organization;
  }

  @action reset() {
    this.values.username = '';
    this.values.password = '';
    this.errors = undefined;
  }

  @action login() {
    this.inProgress = true;
    this.errors = undefined;
    return agent.Auth.login(this.values.username, this.values.password)
      .then(({ user }) => appStore.setToken(user.token))
      .then(() => userStore.pullUser())
      .catch(action((err) => {
        this.errors = err.response && err.response.body && err.response.body.errors;
        throw err;
      }))
      .finally(action(() => { this.inProgress = false; }));
  }

 @action register() {
    this.inProgress = true;
    this.errors = undefined;
    return agent.Auth.register(this.values.username, this.values.password)
      .then(({ user }) => {
        console.info("user " + user);
        appStore.setToken(user.token);
        })
      .then(() => userStore.pullUser())
      .catch(action((err) => {
        console.info("errors " + err);
        this.errors = err.response && err.response.body && err.response.body.errors;
        throw err;
      }))
      .finally(action(() => { this.inProgress = false; }));
  }

  @action logout() {
    appStore.setToken(undefined);
    userStore.forgetUser();
    return Promise.resolve();
  }
}

export default new AuthStore();
