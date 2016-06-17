grammar Protobuf;

@members {

public enum FieldRules { required, optional, repeated  }

public void packageName(String name) {}

public void option(String name, String value) {}
public void imports(String name) {}

public void newMessage(String name, String comment) { }
public void newExtension(String name) { }
public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue, String packedValue) { }
public void endMessage() { }

public void newExtensions(String min, String max) { }
public void endExtension() {}

public void newEnum(String name, String comment) { }
public void newEnumValue(String name, Integer ordinal, String comment) { }
public void endEnum() { }
public void end() { }

private String getDefaultValue(String text) {
    //'[' 'default' '=' (ID|INT|'-'|'"')+ ']'
    return text.substring(text.indexOf("=") + 1, text.length() - 1);
}

private String getPackedValue(String text) {
    //'[' 'packed' '=' ('true'|'false') ']'
    return text.substring(text.indexOf("=") + 1, text.length() - 1);
}

public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
	final ANTLRInputStream input = new ANTLRInputStream(reader);
	final ProtobufLexer lexer = new ProtobufLexer(input);
	return new CommonTokenStream(lexer);
}
}

file 	
	:	packageDecl? option* imports*  message+ { end(); }
	;

packageDecl :	'package' packageName { packageName($packageName.text); }';'	
	;

packageName 
	:	ID ('.' ID)*
	;

option 	:	'option' propertyName '=' ID { option($propertyName.text, $ID.getText()); } ';'
	;

imports	:	'import' '"' ID '"' { imports($ID.getText()); } ';'
	;

message	
	:	SL_COMMENT? 'message' ID { newMessage($ID.getText(), $SL_COMMENT!=null ? $SL_COMMENT.getText() : null); } '{' SL_COMMENT? messageContent+ '}' { endMessage(); }
	|	SL_COMMENT? 'enum' ID { newEnum($ID.getText(), $SL_COMMENT!=null ? $SL_COMMENT.getText() : null); } '{' SL_COMMENT? enumName+ '}' { endEnum(); }
	|	SL_COMMENT? 'extend' ID { newExtension($ID.getText()); } '{' SL_COMMENT? messageContent+ '}' { endExtension(); }
	;

enumName	
	:	ID '=' INT ';' SL_COMMENT? { newEnumValue($ID.getText(), Integer.valueOf($INT.getText()), $SL_COMMENT!=null ? $SL_COMMENT.getText() : null); }
	;

messageContent
	:	property
	|	extensions
	|	message
	;

property 
	:	FIELDRULE propertyType ID '=' INT (defaultValue|packedValue)? ';' SL_COMMENT? { newProperty(FieldRules.valueOf($FIELDRULE.getText()), $propertyType.text, $ID.getText(), Integer.valueOf($INT.getText()), $SL_COMMENT!=null ? $SL_COMMENT.getText() : null, $propertyType.text.contains(".") ? $propertyType.text.substring(0,$propertyType.text.lastIndexOf(".")) : null, $defaultValue.text==null ? null : getDefaultValue($defaultValue.text), $packedValue.text==null ? null : getPackedValue($packedValue.text) ); }
	;

defaultValue
	:	 '[' 'default' '=' (ID|INT|'-'|'"')+ ']'
	;
	
packedValue
	:	 '[' 'packed' '=' ('true'|'false') ']'
	;

extensions
	:	'extensions' INT 'to' extensionMax ';' { newExtensions($INT.getText(), $extensionMax.text); }
	;

propertyName 
	:	ID
	;

propertyType 
	:	ID INT?
	;

extensionMax
	:	INT
	|	'max'
	;

FIELDRULE
	:	'required'
	|	'optional'
	|	'repeated'
	;

INT : [0-9]+ ;

ID 	: [a-zA-Z'_''.'0-9]+ ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
	: '//' .*? '\n'
	;