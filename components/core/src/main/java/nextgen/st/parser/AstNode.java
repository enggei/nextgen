package nextgen.st.parser;


public class AstNode {

	private org.antlr.runtime.tree.Tree ast;
	private AstNodeType type;
	private AstNode parent;
	private final java.util.List<AstNode> children = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public org.antlr.runtime.tree.Tree getAst() { 
		return ast;
	}

	public Boolean hasAst() {
		return ast != null;
	}

	public AstNode setAst(org.antlr.runtime.tree.Tree ast) {
		this.ast = ast;
		return this;
	}

	public AstNodeType getType() {
		return type;
	}

	public Boolean hasType() {
		return type != null;
	}

	public AstNode setType(AstNodeType type) {
		this.type = type;
		return this;
	}

	public AstNode getParent() {
		return parent;
	}

	public Boolean hasParent() {
		return parent != null;
	}

	public AstNode setParent(AstNode parent) {
		this.parent = parent;
		return this;
	}

	public java.util.List<AstNode> getChildren() {
		return children;
	}

	public AstNode addChildren(AstNode children) {
		this.children.add(children);
		return this;
	}

	public AstNode() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public AstNode(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AstNode other = (AstNode) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}