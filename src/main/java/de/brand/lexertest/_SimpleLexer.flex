/* XMLLexer.flex */
package com.example;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.example.XMLElementTypes.*;

%%

%class XMLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%public
%final
%state COMMENT
%state ATTR_VALUE


Whitespace      = [ \t\n\r\f]+
NameStartChar   = [:_a-zA-Z]
NameChar        = [:_a-zA-Z0-9.-]
Name            = {NameStartChar}{NameChar}*

%%

<YYINITIAL> {
    {Whitespace} { /* Skip whitespace */ }

    "<?xml"      { return XML_DECL_START; }
    "?>"         { return XML_DECL_END; }

//    "<!--"       { yybegin(COMMENT); return COMMENT_START; }
    "<"          { return TAG_OPEN; }
    ">"          { return TAG_CLOSE; }
    "</"         { return TAG_OPEN_CLOSE; }
    "/>"         { return TAG_SELF_CLOSE; }
    "="          { return EQUALS; }

    {Name}       { return NAME; }
    "\""         { yybegin(ATTR_VALUE); return DOUBLE_QUOTE; }
}

<COMMENT> {
//    "-->"        { yybegin(YYINITIAL); return COMMENT_END; }
    [^-]+        { /* Ignore comment content */ }
    "-"          { /* Ignore single '-' */ }
}

<ATTR_VALUE> {
    "\""         { yybegin(YYINITIAL); return DOUBLE_QUOTE; }
    [^\"]+       { return ATTR_VALUE; }
}

<YYINITIAL, ATTR_VALUE> {
    {Name}       { return NAME; }
    [^<&]+       { return TEXT; }
}

<<EOF>> {
    return null;
}
