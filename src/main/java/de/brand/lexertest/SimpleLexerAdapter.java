package de.brand.lexertest;

import com.example.XMLLexer;
import com.intellij.lexer.FlexAdapter;

public class SimpleLexerAdapter extends FlexAdapter {

  public SimpleLexerAdapter() {
    super(new XMLLexer(null));
  }

}