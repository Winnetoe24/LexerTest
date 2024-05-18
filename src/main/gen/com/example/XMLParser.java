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
  // ELEMENT_NAME EQUALS attribute_string
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, ELEMENT_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELEMENT_NAME, EQUALS);
    r = r && attribute_string(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // attribute+
  //                  | /* empty */
  public static boolean attribute_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_LIST, "<attribute list>");
    r = attribute_list_0(b, l + 1);
    if (!r) r = consumeToken(b, ATTRIBUTE_LIST_1_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute+
  private static boolean attribute_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_list_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE ATTRIBUTE_VALUE DOUBLE_QUOTE
  public static boolean attribute_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_string")) return false;
    if (!nextTokenIs(b, DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOUBLE_QUOTE, ATTRIBUTE_VALUE, DOUBLE_QUOTE);
    exit_section_(b, m, ATTRIBUTE_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_START COMMENT_END
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMENT_START, COMMENT_END);
    exit_section_(b, m, COMMENT, r);
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
    r = consumeToken(b, XML_DECL_START);
    r = r && attribute_list(b, l + 1);
    r = r && consumeToken(b, XML_DECL_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // element_start_token element_content? element_end_token
  //           | element_self_close_token
  public static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    if (!nextTokenIs(b, TAG_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element_0(b, l + 1);
    if (!r) r = element_self_close_token(b, l + 1);
    exit_section_(b, m, ELEMENT, r);
    return r;
  }

  // element_start_token element_content? element_end_token
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element_start_token(b, l + 1);
    r = r && element_0_1(b, l + 1);
    r = r && element_end_token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // element_content?
  private static boolean element_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0_1")) return false;
    element_content(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // element_list+
  //                   | ENCLOSED_TEXT_TOKEN
  //                   | /* empty */
  public static boolean element_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_CONTENT, "<element content>");
    r = element_content_0(b, l + 1);
    if (!r) r = consumeToken(b, ENCLOSED_TEXT_TOKEN);
    if (!r) r = consumeToken(b, ELEMENT_CONTENT_2_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // element_list+
  private static boolean element_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_content_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element_list(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!element_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "element_content_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_OPEN_CLOSE ELEMENT_NAME TAG_CLOSE
  public static boolean element_end_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_end_token")) return false;
    if (!nextTokenIs(b, TAG_OPEN_CLOSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_OPEN_CLOSE, ELEMENT_NAME, TAG_CLOSE);
    exit_section_(b, m, ELEMENT_END_TOKEN, r);
    return r;
  }

  /* ********************************************************** */
  // element
  //                | comment
  public static boolean element_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_list")) return false;
    if (!nextTokenIs(b, "<element list>", COMMENT_START, TAG_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LIST, "<element list>");
    r = element(b, l + 1);
    if (!r) r = comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TAG_OPEN ELEMENT_NAME attribute_list? TAG_SELF_CLOSE
  public static boolean element_self_close_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_self_close_token")) return false;
    if (!nextTokenIs(b, TAG_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_OPEN, ELEMENT_NAME);
    r = r && element_self_close_token_2(b, l + 1);
    r = r && consumeToken(b, TAG_SELF_CLOSE);
    exit_section_(b, m, ELEMENT_SELF_CLOSE_TOKEN, r);
    return r;
  }

  // attribute_list?
  private static boolean element_self_close_token_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_self_close_token_2")) return false;
    attribute_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TAG_OPEN ELEMENT_NAME attribute_list? TAG_CLOSE
  public static boolean element_start_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_start_token")) return false;
    if (!nextTokenIs(b, TAG_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_OPEN, ELEMENT_NAME);
    r = r && element_start_token_2(b, l + 1);
    r = r && consumeToken(b, TAG_CLOSE);
    exit_section_(b, m, ELEMENT_START_TOKEN, r);
    return r;
  }

  // attribute_list?
  private static boolean element_start_token_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_start_token_2")) return false;
    attribute_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // xml_document
  static boolean root(PsiBuilder b, int l) {
    return xml_document(b, l + 1);
  }

  /* ********************************************************** */
  // declaration_opt? element
  public static boolean xml_document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_document")) return false;
    if (!nextTokenIs(b, "<xml document>", TAG_OPEN, XML_DECL_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XML_DOCUMENT, "<xml document>");
    r = xml_document_0(b, l + 1);
    r = r && element(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // declaration_opt?
  private static boolean xml_document_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_document_0")) return false;
    declaration_opt(b, l + 1);
    return true;
  }

}
