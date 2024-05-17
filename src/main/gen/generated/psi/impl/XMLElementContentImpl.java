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

public class XMLElementContentImpl extends ASTWrapperPsiElement implements XMLElementContent {

  public XMLElementContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XMLVisitor visitor) {
    visitor.visitElementContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XMLVisitor) accept((XMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public XMLElementList getElementList() {
    return findChildByClass(XMLElementList.class);
  }

  @Override
  @Nullable
  public XMLText getText() {
    return findChildByClass(XMLText.class);
  }

}
