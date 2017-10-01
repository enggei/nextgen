package com.generator.generators.antlr;

import com.generator.app.App;
import com.generator.generators.antlr.bnfTest.BnfTest;
import com.generator.generators.antlr.bnfTest.GrammarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created 30.09.17.
 */
public class GrammarEditor extends JPanel {

   public GrammarEditor(App app) {
      super(new BorderLayout());

      // todo testing: refactor this to open any .g4 file
      final JTabbedPane testTab = new JTabbedPane();
      testTab.add("SymbolsTest", new GrammarPanel(BnfTest.symbolsTest(), app));
//      testTab.add("CSV", new GrammarPanel(BnfTest.testCSVGrammar(), app));

      add(testTab, BorderLayout.CENTER);
   }
}