package de.brand.lexertest;

import com.example.XMLElementTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey ELEMENT_NAME =
            createTextAttributesKey("SIMPLE_ELEMENT_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TAG_OPERATORS =
            createTextAttributesKey("SIMPLE_TAG_OPERATORS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] ELEMENT_NAME_KEYS = new TextAttributesKey[]{ELEMENT_NAME};
    private static final TextAttributesKey[] TAG_OPERATORS_KEYS = new TextAttributesKey[]{TAG_OPERATORS};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SimpleLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
//        System.out.println(tokenType);
        if (tokenType.equals(XMLElementTypes.ELEMENT_NAME)) {
            return ELEMENT_NAME_KEYS;
        }
        if (tokenType.equals(XMLElementTypes.TAG_OPEN)
                || tokenType.equals(XMLElementTypes.TAG_CLOSE)
                || tokenType.equals(XMLElementTypes.TAG_OPEN_CLOSE)
                || tokenType.equals(XMLElementTypes.TAG_SELF_CLOSE)
        ) {
            return TAG_OPERATORS_KEYS;
        }
        if (tokenType.equals(XMLElementTypes.ATTRIBUTE_VALUE) || tokenType.equals(XMLElementTypes.DOUBLE_QUOTE) || tokenType.equals(XMLElementTypes.ENCLOSED_TEXT_TOKEN)) {
            return VALUE_KEYS;
        }
        if (tokenType.equals(XMLElementTypes.COMMENT_START) || tokenType.equals(XMLElementTypes.COMMENT_END)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}