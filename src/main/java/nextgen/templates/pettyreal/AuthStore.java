package nextgen.templates.pettyreal;

public class AuthStore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	AuthStore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AuthStore");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AuthStore that = (AuthStore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AuthStore() ::= <<import { observable, action,  reaction } from 'mobx';\n" + 
				"import agent from '../Agent';\n" + 
				"import userStore from './UserStore';\n" + 
				"import appStore from './AppStore';\n" + 
				"\n" + 
				"class AuthStore {\n" + 
				"\n" + 
				"	@observable inProgress = false;\n" + 
				"	@observable errors = undefined;\n" + 
				"	@observable values = { username: 'geirove', password: 'geirove' };\n" + 
				"\n" + 
				"	constructor() {\n" + 
				"	}\n" + 
				"\n" + 
				"	@action setUsername(username) {\n" + 
				"		this.values.username = username;\n" + 
				"	}\n" + 
				"\n" + 
				"	@action setPassword(password) {\n" + 
				"		this.values.password = password;\n" + 
				"	}\n" + 
				"\n" + 
				"	@action reset() {\n" + 
				"		this.values.username = '';\n" + 
				"		this.values.password = '';\n" + 
				"		this.errors = undefined;\n" + 
				"	}\n" + 
				"\n" + 
				"	@action login() {\n" + 
				"		this.inProgress = true;;\n" + 
				"		this.errors = undefined;\n" + 
				"		return agent.Auth.login(this.values.username, this.values.password)\n" + 
				"				.then(({ user }) => appStore.setToken(user.token))\n" + 
				"				.then(() => userStore.pullUser())\n" + 
				"				.catch(action((err) => {\n" + 
				"					this.errors = err.response && err.response.body && err.response.body.errors;\n" + 
				"					throw err;\n" + 
				"				}))\n" + 
				"				.finally(action(() => this.inProgress = false));\n" + 
				"	}\n" + 
				"\n" + 
				"	@action logout() {\n" + 
				"		appStore.setToken(undefined)\n" + 
				"		userStore.forgetUser();\n" + 
				"		return Promise.resolve();\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default new AuthStore(); >>";
}  