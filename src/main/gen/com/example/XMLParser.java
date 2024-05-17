// This is a generated file. Not intended for manual editing.
package com.example;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.example.XMLElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class XMLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // /"[^"
  public static boolean ATTR_VALUE(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ATTR_VALUE, true);
    return true;
  }

  /* ********************************************************** */
  // "-->"
  public static boolean COMMENT_END(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMMENT_END")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_END, "<comment end>");
    r = consumeToken(b, "-->");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<!--"
  public static boolean COMMENT_START(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMMENT_START")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_START, "<comment start>");
    r = consumeToken(b, "<!--");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // /
  public static boolean ELEMENT_NAME(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ELEMENT_NAME, true);
    return true;
  }

  /* ********************************************************** */
  // /
  public static boolean ENCLOSED_TEXT(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ENCLOSED_TEXT, true);
    return true;
  }

  /* ********************************************************** */
  // "="
  public static boolean EQUALS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EQUALS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUALS, "<equals>");
    r = consumeToken(b, "=");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ">"
  public static boolean TAG_CLOSE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_CLOSE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_CLOSE, "<tag close>");
    r = consumeToken(b, ">");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<"
  public static boolean TAG_OPEN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_OPEN")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_OPEN, "<tag open>");
    r = consumeToken(b, "<");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "</"
  public static boolean TAG_OPEN_CLOSE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_OPEN_CLOSE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_OPEN_CLOSE, "<tag open close>");
    r = consumeToken(b, "</");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "/>"
  public static boolean TAG_SELF_CLOSE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_SELF_CLOSE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_SELF_CLOSE, "<tag self close>");
    r = consumeToken(b, "/>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "?>"
  public static boolean XML_DECL_END(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XML_DECL_END")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XML_DECL_END, "<xml decl end>");
    r = consumeToken(b, "?>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<?xml"
  public static boolean XML_DECL_START(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XML_DECL_START")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XML_DECL_START, "<xml decl start>");
    r = consumeToken(b, "<?xml");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ELEMENT_NAME EQUALS ATTR_VALUE
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, "<attribute>");
    r = ELEMENT_NAME(b, l + 1);
    r = r && EQUALS(b, l + 1);
    r = r && ATTR_VALUE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // attribute
  //                  | attribute_list attribute
  //                  | /* empty */
  public static boolean attribute_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_LIST, "<attribute list>");
    r = attribute(b, l + 1);
    if (!r) r = attribute_list_1(b, l + 1);
    if (!r) r = consumeToken(b, ATTRIBUTE_LIST_2_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list attribute
  private static boolean attribute_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_list(b, l + 1);
    r = r && attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // XML_DECL_START attribute_list XML_DECL_END
  //                   | /* empty */
  public static boolean declaration_opt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_opt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION_OPT, "<declaration opt>");
    r = declaration_opt_0(b, l + 1);
    if (!r) r = consumeToken(b, DECLARATION_OPT_1_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // XML_DECL_START attribute_list XML_DECL_END
  private static boolean declaration_opt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_opt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = XML_DECL_START(b, l + 1);
    r = r && attribute_list(b, l + 1);
    r = r && XML_DECL_END(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_OPEN ELEMENT_NAME attribute_list TAG_CLOSE element_content TAG_OPEN_CLOSE ELEMENT_NAME TAG_CLOSE
  //           | TAG_OPEN ELEMENT_NAME attribute_list TAG_SELF_CLOSE
  public static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT, "<element>");
    r = element_0(b, l + 1);
    if (!r) r = element_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TAG_OPEN ELEMENT_NAME attribute_list TAG_CLOSE element_content TAG_OPEN_CLOSE ELEMENT_NAME TAG_CLOSE
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TAG_OPEN(b, l + 1);
    r = r && ELEMENT_NAME(b, l + 1);
    r = r && attribute_list(b, l + 1);
    r = r && TAG_CLOSE(b, l + 1);
    r = r && element_content(b, l + 1);
    r = r && TAG_OPEN_CLOSE(b, l + 1);
    r = r && ELEMENT_NAME(b, l + 1);
    r = r && TAG_CLOSE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TAG_OPEN ELEMENT_NAME attribute_list TAG_SELF_CLOSE
  private static boolean element_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TAG_OPEN(b, l + 1);
    r = r && ELEMENT_NAME(b, l + 1);
    r = r && attribute_list(b, l + 1);
    r = r && TAG_SELF_CLOSE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // element_list
  //                   | enclosed_text
  //                   | /* empty */
  public static boolean element_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_CONTENT, "<element content>");
    r = element_list(b, l + 1);
    if (!r) r = enclosed_text(b, l + 1);
    if (!r) r = consumeToken(b, ELEMENT_CONTENT_2_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // element
  //                | element_list element
  public static boolean element_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LIST, "<element list>");
    r = element(b, l + 1);
    if (!r) r = element_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // element_list element
  private static boolean element_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element_list(b, l + 1);
    r = r && element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENCLOSED_TEXT
  public static boolean enclosed_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enclosed_text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENCLOSED_TEXT, "<enclosed text>");
    r = ENCLOSED_TEXT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // xml_document
  static boolean root(PsiBuilder b, int l) {
    return xml_document(b, l + 1);
  }

  /* ********************************************************** */
  // declaration_opt element
  public static boolean xml_document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_document")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XML_DOCUMENT, "<xml document>");
    r = declaration_opt(b, l + 1);
    r = r && element(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
