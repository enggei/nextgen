package nextgen.st.parser;


public class Subtemplate {

	private AstNode ast;
	private final java.util.Set<String> args = new java.util.LinkedHashSet<>();
	private final java.util.Set<Expression> expressions = new java.util.LinkedHashSet<>();
	private final java.util.Map<String, String> props = new java.util.LinkedHashMap<>();
	private final java.util.UUID uuid;

	public AstNode getAst() {
		return ast;
	}

	public Boolean hasAst() {
		return ast != null;
	}

	public Subtemplate setAst(AstNode ast) {
		this.ast = ast;
		return this;
	}

	public java.util.Set<String> getArgs() {
		return args;
	}

	public Subtemplate addArgs(String args) {
		this.args.add(args);
		return this;
	}

	public java.util.Set<Expression> getExpressions() {
		return expressions;
	}

	public Subtemplate addExpressions(Expression expressions) {
		this.expressions.add(expressions);
		return this;
	}

	public java.util.Map<String, String> getProps() {
		return props;
	}

	public Subtemplate addProps(String key, String value) {
		this.props.put(key, value);
		return this;
	}

	public Subtemplate removeProps(String key) {
		this.props.remove(key);
		return this;
	}

	public Subtemplate() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Subtemplate(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Subtemplate other = (Subtemplate) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}