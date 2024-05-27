/* XMLLexer.flex */
package com.example;

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
%state BEGINN_START_TAG
%state START_TAG
%state END_TAG
%state ATTR_VALUE



Whitespace      = [ \t\n\r\f]+
NameStartChar   = [:_a-zA-Z]
NameChar        = [:_a-zA-Z0-9.-]
Name            = {NameStartChar}{NameChar}*

%%

<YYINITIAL> {
    {Whitespace} { return WHITESPACE; }

    "<?xml"      { return XML_DECL_START; }
    "?>"         { return XML_DECL_END; }

    "<!--"       { yybegin(COMMENT); return COMMENT_START; }
    "<"          { yybegin(BEGINN_START_TAG); return TAG_OPEN; }
    "</"         { yybegin(END_TAG); return TAG_OPEN_CLOSE; }
    [^<&]+     { return ENCLOSED_TEXT_TOKEN; }

}

<BEGINN_START_TAG> {
    {Whitespace} { return WHITESPACE; }
    {Name}       { yybegin(START_TAG); return ELEMENT_NAME; }
}

<START_TAG> {
    {Whitespace} { return WHITESPACE; }
    {Name}       { return ELEMENT_NAME; }
    "="          { return EQUALS; }
    "\""         { yybegin(ATTR_VALUE); return DOUBLE_QUOTE; }
}

<BEGINN_START_TAG, START_TAG> {
    {Whitespace} { return WHITESPACE; }
    ">"          { yybegin(YYINITIAL); return TAG_CLOSE; }
    "/>"         { yybegin(YYINITIAL); return TAG_SELF_CLOSE; }
    [^]         {  /* Your default action. */ yybegin(YYINITIAL); }

}



<END_TAG> {
    {Whitespace} { return WHITESPACE; }
    {Name}       { return ELEMENT_NAME; }
    ">"          { yybegin(YYINITIAL); return TAG_CLOSE; }
    [^]          {  /* Your default action. */ yybegin(YYINITIAL); }
}


<COMMENT> {
    "-->"        { yybegin(YYINITIAL); return COMMENT_END; }
    [^-]+        { /* Ignore comment content */ }
    "-"          { /* Ignore single '-' */ }
}

<ATTR_VALUE> {
    "\""         { yybegin(START_TAG); return DOUBLE_QUOTE; }
    [^\"]+       { return ATTRIBUTE_VALUE; }
}
//
//<YYINITIAL> {
// //   {Name}               { return ELEMENT_NAME; }
////    ((\\.)|[^<&\"])+     { return ENCLOSED_TEXT_TOKEN; }
//}

<<EOF>> {
    return null;
}
