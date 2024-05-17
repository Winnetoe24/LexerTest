package de.brand.lexertest;

import com.example.XMLElementTypes;
import com.intellij.psi.tree.TokenSet;

public interface SimpleTokenSets {

  TokenSet IDENTIFIERS = TokenSet.create( XMLElementTypes.ATTRIBUTE , XMLElementTypes.ATTRIBUTE_LIST , XMLElementTypes.DECLARATION_OPT , XMLElementTypes.ELEMENT , XMLElementTypes.ELEMENT_CONTENT , XMLElementTypes.ELEMENT_LIST , XMLElementTypes.ENCLOSED_TEXT , XMLElementTypes.XML_DOCUMENT , XMLElementTypes.DOUBLE_QUOTE , XMLElementTypes.ATTRIBUTE_LIST_2_0 , XMLElementTypes.ATTR_VALUE , XMLElementTypes.DECLARATION_OPT_1_0 , XMLElementTypes.ELEMENT_CONTENT_2_0 , XMLElementTypes.ELEMENT_NAME , XMLElementTypes.EQUALS , XMLElementTypes.TAG_CLOSE , XMLElementTypes.TAG_OPEN , XMLElementTypes.TAG_OPEN_CLOSE , XMLElementTypes.TAG_SELF_CLOSE , XMLElementTypes.XML_DECL_END , XMLElementTypes.XML_DECL_START);

  TokenSet COMMENTS = TokenSet.create();

}