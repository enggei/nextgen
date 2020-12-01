package nextgen.model.parser;

public class STParserFactory {

	public static AstNode newAstNode() { 
		return new AstNode();
	}	

	public static ParseResult newParseResult() { 
		return new ParseResult();
	}	

	public static ParsedSTGroupModel newParsedSTGroupModel() { 
		return new ParsedSTGroupModel();
	}	

	public static ParsedSTTemplate newParsedSTTemplate() { 
		return new ParsedSTTemplate();
	}	

	public static ParsedSTParameter newParsedSTParameter() { 
		return new ParsedSTParameter();
	}	

	public static ParsedSTParameterKey newParsedSTParameterKey() { 
		return new ParsedSTParameterKey();
	}	

	public static ParserError newParserError() { 
		return new ParserError();
	}	

}