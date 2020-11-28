package nextgen.templates.nextgen;

public class NewOpenRemovedEvents {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _type;

	NewOpenRemovedEvents(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NewOpenRemovedEvents");
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public NewOpenRemovedEvents setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public NewOpenRemovedEvents removeName() {
		this._name = null;
		return this;
	} 

	public NewOpenRemovedEvents setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public NewOpenRemovedEvents removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewOpenRemovedEvents that = (NewOpenRemovedEvents) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NewOpenRemovedEvents(name,type) ::= <<public static void postNew~name~(~type~ ~name;format=\"lowFirst\"~) {\n" + 
				"	log.info(\"post New~name~\");\n" + 
				"	org.greenrobot.eventbus.EventBus.getDefault().post(new New~name~(~name;format=\"lowFirst\"~));\n" + 
				"}\n" + 
				"\n" + 
				"public static void postRemoved~name~(java.lang.String uuid) {\n" + 
				"	log.info(\"post Removed~name~\");\n" + 
				"	org.greenrobot.eventbus.EventBus.getDefault().post(new Removed~name~(uuid));\n" + 
				"}\n" + 
				"\n" + 
				"public static void postOpen~name~(~type~ ~name;format=\"lowFirst\"~) {\n" + 
				"	log.info(\"post Open~name~\");\n" + 
				"	org.greenrobot.eventbus.EventBus.getDefault().post(new Open~name~(~name;format=\"lowFirst\"~));\n" + 
				"}\n" + 
				"\n" + 
				"public static class New~name~ {\n" + 
				"\n" + 
				"	public final ~type~ ~name;format=\"lowFirst\"~;\n" + 
				"\n" + 
				"	public New~name~(~type~ ~name;format=\"lowFirst\"~) {\n" + 
				"		this.~name;format=\"lowFirst\"~ = ~name;format=\"lowFirst\"~;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"public static class Removed~name~ {\n" + 
				"\n" + 
				"	public final java.lang.String uuid;\n" + 
				"\n" + 
				"	public Removed~name~(java.lang.String uuid) {\n" + 
				"		this.uuid = uuid;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"public static class Open~name~ {\n" + 
				"\n" + 
				"	public final ~type~ ~name;format=\"lowFirst\"~;\n" + 
				"\n" + 
				"	public Open~name~(~type~ ~name;format=\"lowFirst\"~) {\n" + 
				"		this.~name;format=\"lowFirst\"~ = ~name;format=\"lowFirst\"~;\n" + 
				"	}\n" + 
				"} >>";
}  