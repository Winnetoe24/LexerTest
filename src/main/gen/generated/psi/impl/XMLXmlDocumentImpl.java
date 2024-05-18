// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.XMLElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class XMLXmlDocumentImpl extends ASTWrapperPsiElement implements XMLXmlDocument {

  public XMLXmlDocumentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XMLVisitor visitor) {
    visitor.visitXmlDocument(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XMLVisitor) accept((XMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public XMLDeclarationOpt getDeclarationOpt() {
    return findChildByClass(XMLDeclarationOpt.class);
  }

  @Override
  @NotNull
  public XMLElement getElement() {
    return findNotNullChildByClass(XMLElement.class);
  }

}
