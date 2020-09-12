package nextgen.templates.log4j;

public class ConsoleAppender {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _threshold;

	ConsoleAppender(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("consoleAppender");
		st.add("name", _name);
		st.add("threshold", _threshold);
		return st.render().trim();
	}

	public ConsoleAppender setName(Object value) {
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

	public ConsoleAppender removeName() {
		this._name = null;
		return this;
	} 

	public ConsoleAppender setThreshold(Object value) {
		this._threshold = value;
		return this;
	}

	public Object getThreshold() {
		return this._threshold;
	}

	public Object getThreshold(Object defaultValue) {
		return this._threshold == null ? defaultValue : this._threshold;
	}

	public boolean hasThreshold() {
		return this._threshold != null;
	}

	public ConsoleAppender removeThreshold() {
		this._threshold = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConsoleAppender that = (ConsoleAppender) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "consoleAppender(name,threshold) ::= <<log4j.appender.~name~ = org.apache.log4j.ConsoleAppender\n" + 
				"log4j.appender.~name~.Target = System.out\n" + 
				"log4j.appender.~name~.layout = org.apache.log4j.PatternLayout\n" + 
				"log4j.appender.~name~.layout.ConversionPattern = %d{ISO8601} - %-5p- %c - %m%n\n" + 
				"log4j.appender.~name~.Threshold = ~if(threshold)~~threshold~~else~DEBUG~endif~ >>";
}  