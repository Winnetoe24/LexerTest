package de.brand.lexertest;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import generated.psi.XMLElement;

public class PSIUtils {

    public static PsiElement findParentElement(PsiElement psiElement) {
        PsiElement parent = psiElement.getParent();
        if (parent == null) {
            return null;
        }
        if (parent instanceof XMLElement) {
            return parent;
        }
        return findParentElement(parent);
    }
}
