package de.brand.lexertest;

import com.example.XMLElementTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import generated.psi.impl.XMLElementImpl;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


final class SimpleCompletionContributor extends CompletionContributor {

  SimpleCompletionContributor() {
    extend(CompletionType.BASIC, PlatformPatterns.psiElement(XMLElementTypes.ELEMENT_NAME),
        new CompletionProvider<>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
                                     @NotNull ProcessingContext context,
                                     @NotNull CompletionResultSet resultSet) {
//            resultSet.addElement(LookupElementBuilder.createWithSmartPointer("package"));
            resultSet.addElement(LookupElementBuilder.create("subpackage"));
          }
        }
    );
    extend(CompletionType.BASIC, PlatformPatterns.psiElement(XMLElementTypes.ATTRIBUTE_LIST),
        new CompletionProvider<>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
                                     @NotNull ProcessingContext context,
                                     @NotNull CompletionResultSet resultSet) {
//              PlatformPatterns.psiElement(XMLElementTypes.ELEMENT).
//              if (parameters.getPosition().getParent() instanceof XMLElementTypes) {}
            resultSet.addElement(LookupElementBuilder.create("id=\""+ UUID.randomUUID().toString()+"\""));
          }
        }
    );
  }

}