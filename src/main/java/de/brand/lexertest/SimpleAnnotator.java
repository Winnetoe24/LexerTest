package de.brand.lexertest;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import generated.psi.*;
import org.jetbrains.annotations.NotNull;

public class SimpleAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

        if (element instanceof XMLElementStartToken) {
            annotateSameElementName(element, holder);
        }
        if (element instanceof XMLElement) {
            annotateParentElementRules((XMLElement) element, holder);
        }
        if (element instanceof XMLElementEndToken) {
            annotateSameElementName(element, holder);
        }
        if (element instanceof XMLElementSelfCloseToken) {
            annotateClassRules((XMLElementSelfCloseToken) element, holder);
        }
    }

    private static void annotateSameElementName(PsiElement tokenElement, @NotNull AnnotationHolder holder) {
        PsiElement element = tokenElement.getParent();
        if (!(element instanceof XMLElement)) {
            return;
        }
        if (((XMLElement) element).getElementSelfCloseToken() != null) {
            return;
        }

        XMLElementStartToken elementStartToken = ((XMLElement) element).getElementStartToken();
        XMLElementEndToken elementEndToken = ((XMLElement) element).getElementEndToken();
        if (elementStartToken == null || elementEndToken == null) {
            newAnnotationen(holder, HighlightSeverity.ERROR, "Element muss geschlossen werden", element);
        }

        assert elementStartToken != null;
        assert elementEndToken != null;
        if (!elementStartToken.getElementName().getText().trim().equals(elementEndToken.getElementName().getText().trim())) {
            newAnnotationen(holder, HighlightSeverity.ERROR, "Der Name des Start und Endtokens muss gleich sein.", tokenElement);
        }


    }

    private static void annotateParentElementRules(@NotNull XMLElement element, @NotNull AnnotationHolder holder) {
        PsiElement parentElement = PSIUtils.findParentElement(element);

        if (element.getElementStartToken() != null) {
            String elementName = element.getElementStartToken().getElementName().getText().trim();
            //Top Element
            if (parentElement == null) {
                if (!elementName.equals("modell")) {
                    newAnnotationen(holder, HighlightSeverity.ERROR, "Nur der Typ 'modell' ist auf der Obersten Ebene erlaubt.", element);
                }
            }
            // Subpackages
            else {
                if (!elementName.equals("subpackage")) {
                    newAnnotationen(holder, HighlightSeverity.ERROR, "Nur der Typ 'subpackage' ist hier erlaubt.", element);
                }
            }
        } else if (element.getElementSelfCloseToken() != null) {
            String elementName = element.getElementSelfCloseToken().getElementName().getText().trim();
            //Top Element Kann nicht sefl close sein
            if (parentElement == null) {
                newAnnotationen(holder, HighlightSeverity.ERROR, "Keine Self Closing Elemente als Top Element erlaubt!.", element);
            }
            // Subpackages
            else {
                if (!elementName.equals("class")) {
                    newAnnotationen(holder, HighlightSeverity.ERROR, "Nur der Typ 'class' ist hier erlaubt.", element);
                }
            }
        }


    }

    public static final int ID_INDEX = 0;
    public static final int NAME_INDEX = 1;

    private static void annotateClassRules(@NotNull XMLElementSelfCloseToken element, @NotNull AnnotationHolder holder) {
        XMLAttributeList attributeList = element.getAttributeList();
        if (attributeList == null) {
            newAnnotationen(holder, HighlightSeverity.WARNING, "Es sind keine Attribute vorhanden", element.getElementName());
            return;
        }
        boolean[] foundAttributes = new boolean[2];

        for (XMLAttribute xmlAttribute : attributeList.getAttributeList()) {
            String key = xmlAttribute.getElementName().getText().trim();
            switch (key) {
                case "id":
                    foundAttributes[ID_INDEX] = true;
                case "name":
                    foundAttributes[NAME_INDEX] = true;
            }
        }

        if (!foundAttributes[ID_INDEX]) {
            newAnnotationen(holder, HighlightSeverity.WARNING, "Es wurde keine ID vergeben.", attributeList);
        }
        if (!foundAttributes[NAME_INDEX]) {
            newAnnotationen(holder, HighlightSeverity.ERROR, "Es wurde kein Name vergeben.", attributeList);
        }


    }


    private static void newAnnotationen(@NotNull AnnotationHolder holder, @NotNull HighlightSeverity severity, @NotNull String message, PsiElement element) {
        holder.newAnnotation(severity, message)
                .range(element.getTextRange())
                .needsUpdateOnTyping(true)
                .create();
    }

}
