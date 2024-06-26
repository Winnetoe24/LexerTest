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

public class XMLAttributeStringImpl extends ASTWrapperPsiElement implements XMLAttributeString {

  public XMLAttributeStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XMLVisitor visitor) {
    visitor.visitAttributeString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XMLVisitor) accept((XMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getAttributeValue() {
    return findNotNullChildByType(ATTRIBUTE_VALUE);
  }

}
