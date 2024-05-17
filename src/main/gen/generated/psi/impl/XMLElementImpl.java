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

public class XMLElementImpl extends ASTWrapperPsiElement implements XMLElement {

  public XMLElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XMLVisitor visitor) {
    visitor.visitElement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XMLVisitor) accept((XMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<XMLElementName> getElementNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, XMLElementName.class);
  }

  @Override
  @NotNull
  public List<XMLTagClose> getTagCloseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, XMLTagClose.class);
  }

  @Override
  @NotNull
  public XMLTagOpen getTagOpen() {
    return findNotNullChildByClass(XMLTagOpen.class);
  }

  @Override
  @Nullable
  public XMLTagOpenClose getTagOpenClose() {
    return findChildByClass(XMLTagOpenClose.class);
  }

  @Override
  @Nullable
  public XMLTagSelfClose getTagSelfClose() {
    return findChildByClass(XMLTagSelfClose.class);
  }

  @Override
  @NotNull
  public XMLAttributeList getAttributeList() {
    return findNotNullChildByClass(XMLAttributeList.class);
  }

  @Override
  @Nullable
  public XMLElementContent getElementContent() {
    return findChildByClass(XMLElementContent.class);
  }

}
