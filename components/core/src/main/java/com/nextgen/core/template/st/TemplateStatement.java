package com.nextgen.core.template.st;

import java.util.*;

/**
 * User: geirove
 * Date: 27.11.12
 */
public class TemplateStatement {

   private String name;
   private String text;
   private final Map<String, TemplateParameter> parameters = new LinkedHashMap<>();

   private static final Set<String> TEMPLATESTATEMENT_KEYWORDS = Collections.unmodifiableSet(new TreeSet<String>() {{
      add("true");
      add("false");
      add("import");
      add("default");
      add("key");
      add("group");
      add("implements");
      add("first");
      add("last");
      add("rest");
      add("trunc");
      add("strip");
      add("trim");
      add("length");
      add("strlen");
      add("reverse");
      add("if");
      add("else");
      add("elseif");
      add("endif");
      add("delimiters");
   }});

   TemplateStatement(String name, List<TemplateParameter> parameters, String text) {
      validateName(name);
      this.name = name;
      this.text = text;
      for (TemplateParameter parameter : parameters) {
         try {
            validateName(parameter.getPropertyName());
         } catch (Exception e) {
            throw new IllegalArgumentException("Parameter '" + parameter.getPropertyName() + "' not valid: " + e.getMessage());
         }
         this.parameters.put(parameter.getPropertyName(), parameter);
      }
   }

   public String getName() {
      return name;
   }

   public List<TemplateParameter> getParameters() {
      return new ArrayList<>(this.parameters.values());
   }

   public String getText() {
      return text.trim();
   }

   private void validateName(String name) {
      if (TEMPLATESTATEMENT_KEYWORDS.contains(name))
         throw new IllegalArgumentException("'" + name + "' is a reserved word.");
   }
}