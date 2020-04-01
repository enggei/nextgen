package com.nextgen.core.template.st;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: geirove
 * Date: 27.11.12
 * <p>
 */
public class TemplateFile {

   private final Map<String, TemplateStatement> statements = new TreeMap<>();
   private String delimiter;

   TemplateFile(Map<String, TemplateStatement> statements, char delimiterStartChar) {
      this.statements.putAll(statements);
      this.delimiter = delimiterStartChar + "";
   }

   public List<TemplateStatement> getStatements() {
      return new ArrayList<>(statements.values());
   }

   TemplateStatement getTemplateStatement(String name) {
      return statements.get(name);
   }

   public String getDelimiter() {
      return delimiter;
   }
}