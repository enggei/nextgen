package nextgen.templates.pettyreal;

public class UserStore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	UserStore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UserStore");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserStore that = (UserStore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UserStore() ::= <<import { observable, action,  reaction } from 'mobx';\n" + 
				"import agent from '../Agent';\n" + 
				"\n" + 
				"class UserStore {\n" + 
				"\n" + 
				"	@observable loading;\n" + 
				"	@observable errors = undefined;\n" + 
				"	@observable currentUser;\n" + 
				"	@observable updatingUser;\n" + 
				"	@observable updatingUserErrors;\n" + 
				"\n" + 
				"	constructor() {\n" + 
				"	}\n" + 
				"\n" + 
				"	@action pullUser() {\n" + 
				"		this.loading = true;\n" + 
				"		this.errors = undefined;\n" + 
				"		return agent.Auth.current().then(action(({ user }) => this.currentUser = user)).finally(action(() => this.loadingUser = false));\n" + 
				"	}\n" + 
				"\n" + 
				"	@action updateUser(newUser) {\n" + 
				"		this.updatingUser = true;\n" + 
				"		return agent.Auth.save(newUser).then(action(({ user }) => this.currentUser = user)).finally(action(() => this.updatingUser = false));\n" + 
				"	}\n" + 
				"\n" + 
				"	@action forgetUser() {\n" + 
				"		this.currentUser = undefined;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default new UserStore(); >>";
}  