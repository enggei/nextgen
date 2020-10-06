package nextgen.templates.javaeasyflows;

public class RepeatFlow {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _repeat;
	private Object _times;
	private Object _until;

	RepeatFlow(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RepeatFlow");
		st.add("name", _name);
		st.add("repeat", _repeat);
		st.add("times", _times);
		st.add("until", _until);
		return st.render().trim();
	}

	public RepeatFlow setName(Object value) {
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

	public RepeatFlow removeName() {
		this._name = null;
		return this;
	} 

	public RepeatFlow setRepeat(Object value) {
		this._repeat = value;
		return this;
	}

	public Object getRepeat() {
		return this._repeat;
	}

	public Object getRepeat(Object defaultValue) {
		return this._repeat == null ? defaultValue : this._repeat;
	}

	public boolean hasRepeat() {
		return this._repeat != null;
	}

	public RepeatFlow removeRepeat() {
		this._repeat = null;
		return this;
	} 

	public RepeatFlow setTimes(Object value) {
		this._times = value;
		return this;
	}

	public Object getTimes() {
		return this._times;
	}

	public Object getTimes(Object defaultValue) {
		return this._times == null ? defaultValue : this._times;
	}

	public boolean hasTimes() {
		return this._times != null;
	}

	public RepeatFlow removeTimes() {
		this._times = null;
		return this;
	} 

	public RepeatFlow setUntil(Object value) {
		this._until = value;
		return this;
	}

	public Object getUntil() {
		return this._until;
	}

	public Object getUntil(Object defaultValue) {
		return this._until == null ? defaultValue : this._until;
	}

	public boolean hasUntil() {
		return this._until != null;
	}

	public RepeatFlow removeUntil() {
		this._until = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RepeatFlow that = (RepeatFlow) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RepeatFlow(name,repeat,times,until) ::= <<RepeatFlow.Builder.aNewRepeatFlow()\n" + 
				"		.named(\"~name~\")\n" + 
				"		.repeat(~repeat~)~if(times)~\n" + 
				"		.times(~times~)~endif~~if(until)~\n" + 
				"		.until(~until~)~endif~\n" + 
				"		.build() >>";
}  