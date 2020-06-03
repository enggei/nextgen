package nextgen.st.parser;


public class STParserFactory {

	public static AstNodeType AstNodeTypeExpression() { 
		return AstNodeType.Expression;
	}

	public static AstNodeType AstNodeTypeName() { 
		return AstNodeType.Name;
	}

	public static AstNodeType AstNodeTypeProp() { 
		return AstNodeType.Prop;
	}

	public static AstNodeType AstNodeTypeArgs() {
		return AstNodeType.Args;
	}

	public static AstNodeType AstNodeTypeIf() { 
		return AstNodeType.If;
	}

	public static AstNodeType AstNodeTypeSubtemplate() { 
		return AstNodeType.Subtemplate;
	}

	public static AstNode newAstNode() { 
		return new AstNode();
	}

}