package de.brand.lexertest;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class XMLTokenType extends IElementType {
    public XMLTokenType(@NonNls @NotNull String debugName) {
        super(debugName, SimpleLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "XMLTokenType." + super.toString();
    }

}
