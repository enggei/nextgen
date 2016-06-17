grammar JSON;

@members {

public void objectStart() {}
public void objectEnd() {}

public void arrayStart() {}
public void arrayEnd() {}

public void pairStart(String string) {}
public void pairEnd() {}

public void elementStart() {}
public void elementEnd() {}

public void stringValue(String string) {}
public void numberValue(String string) {}
public void booleanValue(boolean value) {}
public void nullValue() {}

public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
	final ANTLRInputStream input = new ANTLRInputStream(reader);
	final JSONLexer lexer = new JSONLexer(input);
	return new CommonTokenStream(lexer);
}

private String trim(String text) {
    int iStart = text.startsWith("\"") ? 1 : 0;
    int iEnd = text.lastIndexOf("\"") == text.length() - 1 ? (text.length()-1) : text.length();
    return text.substring(iStart, iEnd);
}
}

json:    object
    |    array
    ;

object
    :   { objectStart(); } '{' pair (',' pair)* '}' { objectEnd(); }
    |   { objectStart(); } '{' '}' { objectEnd(); } // empty object
    ;
pair:   STRING { pairStart(trim($STRING.getText())); } ':' value { pairEnd(); };

array
    :   { arrayStart(); } '[' value (',' value )* ']' { arrayEnd(); }
    |   { arrayStart(); } '[' ']' { arrayEnd(); } // empty array
    ;

value
    :   STRING { stringValue(trim($STRING.getText())); }
    |   NUMBER { numberValue($NUMBER.getText()); }
    |   object  // recursion
    |   array   // recursion
    |   'true' { booleanValue(true); }
    |   'false'{ booleanValue(false); }
    |   'null' { nullValue(); }
    ;

STRING :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

NUMBER
    :   '-'? INT '.' INT EXP?   // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP            // 1e10 -3e4
    |   '-'? INT                // -3, 45
    ;
fragment INT :   '0' | [0-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]

WS  :   [ \t\n\r]+ -> skip ;