/*
 [The "BSD licence"]
 Copyright (c) 2017 Ernst Sognnes
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
/*
   Derived from http://www.scala-lang.org/files/archive/spec/2.11/13-syntax-summary.html
 */

grammar Scala;

@parser::members {

    /**
     * Returns {@code true} iff on the current index of the parser's
     * token stream a token exists on the {@code HIDDEN} channel which
     * either is a line terminator, or is a multi line comment that
     * contains a line terminator.
     *
     * @return {@code true} iff on the current index of the parser's
     * token stream a token exists on the {@code HIDDEN} channel which
     * either is a line terminator, or is a multi line comment that
     * contains a line terminator.
     */
    private boolean lineTerminatorAhead() {
        // Get the token ahead of the current index.
        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
        Token ahead = _input.get(possibleIndexEosToken);
        if (ahead.getChannel() != Lexer.HIDDEN) {
            // We're only interested in tokens on the HIDDEN channel.
            return false;
        }

        if (ahead.getType() == TERMINATOR) {
            // There is definitely a line terminator ahead.
            return true;
        }

        if (ahead.getType() == WS) {
            // Get the token ahead of the current whitespaces.
            possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
            ahead = _input.get(possibleIndexEosToken);
        }

        // Get the token's text and type.
        String text = ahead.getText();
        int type = ahead.getType();

        // Check if the token is, or contains a line terminator.
        return (type == COMMENT && (text.contains("\r") || text.contains("\n"))) ||
                (type == TERMINATOR);
    }
}

@lexer::members {

    // The most recently produced token.
    private Token lastToken = null;

    /**
     * Return the next token from the character stream and records this last
     * token in case it resides on the default channel. This recorded token
     * is used to determine when the lexer could possibly match a regex
     * literal.
     *
     * @return the next token from the character stream.
     */
    @Override
    public Token nextToken() {

        // Get the next token.
        Token next = super.nextToken();

        if (next.getChannel() == Token.DEFAULT_CHANNEL) {
            // Keep track of the last token on the default channel.
            this.lastToken = next;
        }

        return next;
    }
}

// TEST TEST TEST
program
   : statements
   ;

statements
   : (statement eos)*
   ;

statement
//   : ('a' 'b' 'c')+
   : qualId+
   ;

qualId
   : ID ('.' ID)*
   ;

eos
    : ';'
    | EOF
    | {lineTerminatorAhead()}?
    | {_input.LT(1).getText().equals("}") }?
    ;

// LEXER
// ---------------------------------------------------

//UnicodeEscape ::= ‘\’ ‘u’ {‘u’} hexDigit hexDigit hexDigit hexDigit
UNICODE_ESCAPE
   : '\\u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
   ;

// letter           ::=  upper | lower // and Unicode categories Lo, Lt, Nl
fragment LETTER
   : UPPER
   | LETTER_LOWER_FIRST
   ;

fragment LETTER_LOWER_FIRST
   :
   | LOWER
   | UNICODE_CLASS_Lo
   | UNICODE_CLASS_Lt
   | UNICODE_CLASS_Nl
   ;

// digit            ::=  ‘0’ | … | ‘9’
fragment DIGIT
   : [0-9]
   ;

// paren            ::=  ‘(’ | ‘)’ | ‘[’ | ‘]’ | ‘{’ | ‘}’
fragment PAREN
   : [()[\]{}]
   ;

// delim            ::=  ‘`’ | ‘'’ | ‘"’ | ‘.’ | ‘;’ | ‘,’
fragment DELIM
   : [`'".;,]
   ;

// op       ::=  opchar {opchar}
fragment OP
   : OPCHAR+
   ;

// varid            ::=  lower idrest
fragment VARID
   : LOWER IDREST
   ;

/*plainid          ::=  upper idrest
                 |  varid
                 |  op
*/
fragment PLAINID
   : UPPER (LETTER_LOWER_FIRST | DIGIT)*
//   | VARID
//   | OP
   ;

/*id               ::=  plainid
                 |  ‘`’ { charNoBackQuoteOrNewline | UnicodeEscape | charEscapeSeq } ‘`’
*/
ID
//   : UPPER [a-zA-Z0-9]*
//   : [A-Z] [a-zA-Z0-9]*
   : PLAINID
//   | '`' (UNICODE_ESCAPE | CHAR_ESCAPE_SEQ | ~[`\n]) '`'
   ;

// idrest           ::=  {letter | digit} [‘_’ op]
fragment IDREST
   : (LETTER | DIGIT)* /*('_' OP)?*/
   ;

// opchar           ::= // printableChar not matched by (whiteSpace | upper | lower |
//                      // letter | digit | paren | delim | opchar | Unicode_Sm | Unicode_So)
fragment OPCHAR
   : ~([ \tA-Za-z0-9`'".;,])
   ;

fragment CHAR_ESCAPE_SEQ
   : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\')
   ;

// upper            ::=  ‘A’ | … | ‘Z’ | ‘$’ | ‘_’  // and Unicode category Lu
fragment UPPER
   : [A-Z\u0024\u005F]
   | UNICODE_CLASS_Lu
   ;

// lower            ::=  ‘a’ | … | ‘z’ // and Unicode category Ll
fragment LOWER
   : [a-z]
   | UNICODE_CLASS_Ll
   ;

// Unicode category Lu (ref: http://www.fileformat.info/info/unicode/category/Lu/list.htm)
fragment UNICODE_CLASS_Lu
   : [\u0041-\u005A]
   | [\u00C0-\u00D6]
   | [\u00D8-\u00DE]    // TODO: Add the rest of class Lu
   ;

// Unicode category Ll (ref: http://www.fileformat.info/info/unicode/category/Ll/list.htm)
fragment UNICODE_CLASS_Ll
   : [\u0061-\u007A]    // TODO: Add the rest of class Ll
   ;

// Unicode categories Lo (ref: http://www.fileformat.info/info/unicode/category/Lo/list.htm)
fragment UNICODE_CLASS_Lo
   :
   ;

// Unicode categories Lt (ref: http://www.fileformat.info/info/unicode/category/Lt/list.htm)
fragment UNICODE_CLASS_Lt
   : [\u01C5\u01C8\u01CB]   // TODO: Add the rest of class Lt
   ;

// Unicode categories Nl (ref: http://www.fileformat.info/info/unicode/category/Nl/list.htm)
fragment UNICODE_CLASS_Nl
   : [\u16EE-\u16F0]        // TODO: Add the rest of class Nl
   ;

// Unicode categories Sm (ref: http://www.fileformat.info/info/unicode/category/Sm/list.htm)
fragment UNICODE_CLASS_Sm
   : [\u002B\u003C-\u003E]  // TODO: Add the rest of class Sm
   ;

// Unicode categories So (ref: http://www.fileformat.info/info/unicode/category/So/list.htm)
fragment UNICODE_CLASS_So
   : [\u00A6\u00A9\u00AE]  // TODO: Add the rest of class So
   ;

// hexDigit      ::= ‘0’ | … | ‘9’ | ‘A’ | … | ‘F’ | ‘a’ | … | ‘f’
fragment HEX_DIGIT
   : [0-9a-fA-F]
   ;

//
// Whitespace and comments
//

WS  :  [ \t]+ -> channel(HIDDEN)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

TERMINATOR
	: [\r\n]+ -> channel(HIDDEN)
	;


LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
