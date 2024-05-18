// This is a generated file. Not intended for manual editing.
package com.example;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.brand.lexertest.XMLElementType;
import de.brand.lexertest.XMLTokenType;
import generated.psi.impl.*;

public interface XMLElementTypes {

  IElementType ATTRIBUTE = new XMLElementType("ATTRIBUTE");
  IElementType ATTRIBUTE_LIST = new XMLElementType("ATTRIBUTE_LIST");
  IElementType ATTRIBUTE_STRING = new XMLElementType("ATTRIBUTE_STRING");
  IElementType COMMENT = new XMLElementType("COMMENT");
  IElementType DECLARATION_OPT = new XMLElementType("DECLARATION_OPT");
  IElementType ELEMENT = new XMLElementType("ELEMENT");
  IElementType ELEMENT_CONTENT = new XMLElementType("ELEMENT_CONTENT");
  IElementType ELEMENT_END_TOKEN = new XMLElementType("ELEMENT_END_TOKEN");
  IElementType ELEMENT_LIST = new XMLElementType("ELEMENT_LIST");
  IElementType ELEMENT_SELF_CLOSE_TOKEN = new XMLElementType("ELEMENT_SELF_CLOSE_TOKEN");
  IElementType ELEMENT_START_TOKEN = new XMLElementType("ELEMENT_START_TOKEN");
  IElementType XML_DOCUMENT = new XMLElementType("XML_DOCUMENT");

  IElementType ATTRIBUTE_LIST_1_0 = new XMLTokenType("attribute_list_1_0");
  IElementType ATTRIBUTE_VALUE = new XMLTokenType("ATTRIBUTE_VALUE");
  IElementType COMMENT_END = new XMLTokenType("-->");
  IElementType COMMENT_START = new XMLTokenType("<!--");
  IElementType DECLARATION_OPT_1_0 = new XMLTokenType("declaration_opt_1_0");
  IElementType DOUBLE_QUOTE = new XMLTokenType("\"");
  IElementType ELEMENT_CONTENT_2_0 = new XMLTokenType("element_content_2_0");
  IElementType ELEMENT_NAME = new XMLTokenType("ELEMENT_NAME");
  IElementType ENCLOSED_TEXT_TOKEN = new XMLTokenType("ENCLOSED_TEXT_TOKEN");
  IElementType EQUALS = new XMLTokenType("=");
  IElementType TAG_CLOSE = new XMLTokenType(">");
  IElementType TAG_OPEN = new XMLTokenType("<");
  IElementType TAG_OPEN_CLOSE = new XMLTokenType("</");
  IElementType TAG_SELF_CLOSE = new XMLTokenType("/>");
  IElementType XML_DECL_END = new XMLTokenType("?>");
  IElementType XML_DECL_START = new XMLTokenType("<?xml");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new XMLAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_LIST) {
        return new XMLAttributeListImpl(node);
      }
      else if (type == ATTRIBUTE_STRING) {
        return new XMLAttributeStringImpl(node);
      }
      else if (type == COMMENT) {
        return new XMLCommentImpl(node);
      }
      else if (type == DECLARATION_OPT) {
        return new XMLDeclarationOptImpl(node);
      }
      else if (type == ELEMENT) {
        return new XMLElementImpl(node);
      }
      else if (type == ELEMENT_CONTENT) {
        return new XMLElementContentImpl(node);
      }
      else if (type == ELEMENT_END_TOKEN) {
        return new XMLElementEndTokenImpl(node);
      }
      else if (type == ELEMENT_LIST) {
        return new XMLElementListImpl(node);
      }
      else if (type == ELEMENT_SELF_CLOSE_TOKEN) {
        return new XMLElementSelfCloseTokenImpl(node);
      }
      else if (type == ELEMENT_START_TOKEN) {
        return new XMLElementStartTokenImpl(node);
      }
      else if (type == XML_DOCUMENT) {
        return new XMLXmlDocumentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
