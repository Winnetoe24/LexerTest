package de.brand.lexertest;

import com.intellij.codeInspection.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import generated.psi.XMLAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class UniqueIdInspection extends LocalInspectionTool {

    @Nullable
    @Override
    public ProblemDescriptor @Nullable [] checkFile(@NotNull PsiFile file, @NotNull InspectionManager manager, boolean isOnTheFly) {
        Set<String> idValues = new HashSet<>();
        Set<XMLAttribute> duplicateElements = new HashSet<>();
        
        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(@NotNull PsiElement element) {
                super.visitElement(element);
                // Assuming `Attribute` is the PSI element representing your attribute
                if (element instanceof XMLAttribute attribute) {
                    if ("id".equals(attribute.getElementName().getText().trim())) {
                        String value = attribute.getAttributeString().getAttributeValue().getText().trim();
                        if (!idValues.add(value)) {
                            duplicateElements.add(attribute);
                        }
                    }
                }
            }
        });
        System.out.println("Duplicate elements: " + duplicateElements.size());

        // Report problems for duplicate elements
        return duplicateElements.stream()
                .map(element -> manager.createProblemDescriptor(element.getAttributeString().getAttributeValue(),
                        "Duplicate id value", (LocalQuickFix) null, ProblemHighlightType.ERROR, isOnTheFly))
                .toArray(ProblemDescriptor[]::new);
    }
}
