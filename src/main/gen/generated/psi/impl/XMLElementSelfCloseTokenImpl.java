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

public class XMLElementSelfCloseTokenImpl extends ASTWrapperPsiElement implements XMLElementSelfCloseToken {

  public XMLElementSelfCloseTokenImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XMLVisitor visitor) {
    visitor.visitElementSelfCloseToken(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XMLVisitor) accept((XMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public XMLAttributeList getAttributeList() {
    return findChildByClass(XMLAttributeList.class);
  }

  @Override
  @NotNull
  public PsiElement getElementName() {
    return findNotNullChildByType(ELEMENT_NAME);
  }

}
