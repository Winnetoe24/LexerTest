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
  IElementType ATTR_VALUE = new XMLElementType("ATTR_VALUE");
  IElementType COMMENT_END = new XMLElementType("COMMENT_END");
  IElementType COMMENT_START = new XMLElementType("COMMENT_START");
  IElementType DECLARATION_OPT = new XMLElementType("DECLARATION_OPT");
  IElementType ELEMENT = new XMLElementType("ELEMENT");
  IElementType ELEMENT_CONTENT = new XMLElementType("ELEMENT_CONTENT");
  IElementType ELEMENT_LIST = new XMLElementType("ELEMENT_LIST");
  IElementType ELEMENT_NAME = new XMLElementType("ELEMENT_NAME");
  IElementType ENCLOSED_TEXT = new XMLElementType("ENCLOSED_TEXT");
  IElementType EQUALS = new XMLElementType("EQUALS");
  IElementType TAG_CLOSE = new XMLElementType("TAG_CLOSE");
  IElementType TAG_OPEN = new XMLElementType("TAG_OPEN");
  IElementType TAG_OPEN_CLOSE = new XMLElementType("TAG_OPEN_CLOSE");
  IElementType TAG_SELF_CLOSE = new XMLElementType("TAG_SELF_CLOSE");
  IElementType XML_DECL_END = new XMLElementType("XML_DECL_END");
  IElementType XML_DECL_START = new XMLElementType("XML_DECL_START");
  IElementType XML_DOCUMENT = new XMLElementType("XML_DOCUMENT");

  IElementType ATTRIBUTE_LIST_2_0 = new XMLTokenType("attribute_list_2_0");
  IElementType DECLARATION_OPT_1_0 = new XMLTokenType("declaration_opt_1_0");
  IElementType ELEMENT_CONTENT_2_0 = new XMLTokenType("element_content_2_0");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new XMLAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_LIST) {
        return new XMLAttributeListImpl(node);
      }
      else if (type == ATTR_VALUE) {
        return new XMLAttrValueImpl(node);
      }
      else if (type == COMMENT_END) {
        return new XMLCommentEndImpl(node);
      }
      else if (type == COMMENT_START) {
        return new XMLCommentStartImpl(node);
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
      else if (type == ELEMENT_LIST) {
        return new XMLElementListImpl(node);
      }
      else if (type == ELEMENT_NAME) {
        return new XMLElementNameImpl(node);
      }
      else if (type == ENCLOSED_TEXT) {
        return new XMLEnclosedTextImpl(node);
      }
      else if (type == EQUALS) {
        return new XMLEqualsImpl(node);
      }
      else if (type == TAG_CLOSE) {
        return new XMLTagCloseImpl(node);
      }
      else if (type == TAG_OPEN) {
        return new XMLTagOpenImpl(node);
      }
      else if (type == TAG_OPEN_CLOSE) {
        return new XMLTagOpenCloseImpl(node);
      }
      else if (type == TAG_SELF_CLOSE) {
        return new XMLTagSelfCloseImpl(node);
      }
      else if (type == XML_DECL_END) {
        return new XMLXmlDeclEndImpl(node);
      }
      else if (type == XML_DECL_START) {
        return new XMLXmlDeclStartImpl(node);
      }
      else if (type == XML_DOCUMENT) {
        return new XMLXmlDocumentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
