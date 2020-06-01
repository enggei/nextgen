package nextgen.st.parser;


public class Expression {

	private AstNode ast;
	private final java.util.Set<MethodCall> methodCalls = new java.util.LinkedHashSet<>();
	private Subtemplate subTemplate;
	private String options;
	private final java.util.Map<String, String> props = new java.util.LinkedHashMap<>();
	private String name;
	private final java.util.UUID uuid;

	public AstNode getAst() {
		return ast;
	}

	public Boolean hasAst() {
		return ast != null;
	}

	public Expression setAst(AstNode ast) {
		this.ast = ast;
		return this;
	}

	public java.util.Set<MethodCall> getMethodCalls() {
		return methodCalls;
	}

	public Expression addMethodCalls(MethodCall methodCalls) {
		this.methodCalls.add(methodCalls);
		return this;
	}

	public Subtemplate getSubTemplate() {
		return subTemplate;
	}

	public Boolean hasSubTemplate() {
		return subTemplate != null;
	}

	public Expression setSubTemplate(Subtemplate subTemplate) {
		this.subTemplate = subTemplate;
		return this;
	}

	public String getOptions() {
		return options;
	}

	public Boolean hasOptions() {
		return options != null;
	}

	public Expression setOptions(String options) {
		this.options = options;
		return this;
	}

	public java.util.Map<String, String> getProps() {
		return props;
	}

	public Expression addProps(String key, String value) {
		this.props.put(key, value);
		return this;
	}

	public Expression removeProps(String key) {
		this.props.remove(key);
		return this;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public Boolean hasName() {
		return name != null;
	}

	public Expression setName(String name) {
		this.name = name;
		return this;
	}

	public Expression() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Expression(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Expression other = (Expression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}