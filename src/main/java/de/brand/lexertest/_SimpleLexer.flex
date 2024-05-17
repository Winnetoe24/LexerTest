package de.brand.lexertest;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.sdk.language.psi.SimpleTypes.*;

%%

%{
  public _SimpleLexer() {
    this((java.io.Reader)null);
  }

  private StringBuilder textBuffer = new StringBuilder();
%}

%{

    /* User class code section */
    public void yyerror(String error) {
        System.err.println("Error: " + error);
    }

%}

%public
%class _SimpleLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%state COMMENT
%state ATTR_VALUE


/* Regular Expressions */
Whitespace      = [ \t\n\r\f]
Letter          = [a-zA-Z]
Digit           = [0-9]
NameStartChar   = [:_a-zA-Z]
NameChar        = [:_a-zA-Z0-9.-]
Name            = {NameStartChar}{NameChar}*

%%

/* Rules */

/* Ignore whitespace */
<YYINITIAL> {
    {Whitespace}+ { /* Ignore whitespace */ }
}

/* XML Declaration */
<YYINITIAL> {
    "<?xml"      { return symbol(sym.XML_DECL_START); }
    "?>"         { return symbol(sym.XML_DECL_END); }
}

/* XML Comments */
<YYINITIAL> {
    "<!--"       { yybegin(COMMENT); }
}

<COMMENT> {
    "-->"        { yybegin(YYINITIAL); return symbol(sym.COMMENT_END); }
    [^-]+        { /* Ignore comment content */ }
    "-"          { /* Ignore single '-' */ }
}

/* Tags */
<YYINITIAL> {
    "<"          { return symbol(sym.TAG_OPEN); }
    ">"          { return symbol(sym.TAG_CLOSE); }
    "</"         { return symbol(sym.TAG_OPEN_CLOSE); }
    "/>"         { return symbol(sym.TAG_SELF_CLOSE); }
}

/* Names (elements, attributes) */
<YYINITIAL> {
    {Name}       { return symbol(sym.NAME, yytext()); }
}

/* Attributes and their values */
<YYINITIAL> {
    "="          { return symbol(sym.EQUALS); }
    "\""         { yybegin(ATTR_VALUE); }
}

<ATTR_VALUE> {
    "\""         { yybegin(YYINITIAL); }
    [^\"]+       { return symbol(sym.ATTR_VALUE, yytext()); }
}

/* Text content */
<YYINITIAL> {
    {Letter}+    { return symbol(sym.TEXT, yytext()); }
    {Digit}+     { return symbol(sym.TEXT, yytext()); }
    [^<&]+       { return symbol(sym.TEXT, yytext()); }
}

/* End of file */
<<EOF>> {
    return symbol(sym.EOF);
}
