package nextgen.model.parser;

public class AstNode {

	private final java.util.UUID uuid;
	private org.antlr.runtime.tree.Tree _ast;
	private java.util.List<AstNode> _children = new java.util.ArrayList<>();
	private AstNodeType _type;
	private AstNode _parent;

	public AstNode() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public AstNode(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public org.antlr.runtime.tree.Tree getAst() {
		return this._ast;
	}

	public AstNode setAst(org.antlr.runtime.tree.Tree value) {
		this._ast = value;
		return this;
	}

	public AstNode removeAst() {
		this._ast = null;
		return this;
	}

	public java.util.List<AstNode> getChildren() {
		return this._children;
	}

	public AstNode addChildren(AstNode value) {
		this._children.add(value);
		return this;
	}

	public AstNode removeChildren(AstNode value) {
		this._children.remove(value);
		return this;
	}

	public AstNodeType getType() {
		return this._type;
	}

	public AstNode setType(AstNodeType value) {
		this._type = value;
		return this;
	}

	public AstNode getParent() {
		return this._parent;
	}

	public AstNode setParent(AstNode value) {
		this._parent = value;
		return this;
	}

	public AstNode removeParent() {
		this._parent = null;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AstNode that = (AstNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}