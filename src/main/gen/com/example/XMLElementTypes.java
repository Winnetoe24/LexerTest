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
  IElementType DECLARATION_OPT = new XMLElementType("DECLARATION_OPT");
  IElementType ELEMENT = new XMLElementType("ELEMENT");
  IElementType ELEMENT_CONTENT = new XMLElementType("ELEMENT_CONTENT");
  IElementType ELEMENT_LIST = new XMLElementType("ELEMENT_LIST");
  IElementType ENCLOSED_TEXT = new XMLElementType("ENCLOSED_TEXT");
  IElementType XML_DOCUMENT = new XMLElementType("XML_DOCUMENT");

  IElementType ATTRIBUTE_LIST_2_0 = new XMLTokenType("attribute_list_2_0");
  IElementType ATTR_VALUE = new XMLTokenType("ATTR_VALUE");
  IElementType DECLARATION_OPT_1_0 = new XMLTokenType("declaration_opt_1_0");
  IElementType ELEMENT_CONTENT_2_0 = new XMLTokenType("element_content_2_0");
  IElementType ELEMENT_NAME = new XMLTokenType("ELEMENT_NAME");
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
      else if (type == ENCLOSED_TEXT) {
        return new XMLEnclosedTextImpl(node);
      }
      else if (type == XML_DOCUMENT) {
        return new XMLXmlDocumentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
