package com.generator.generators.stringtemplate.domain;

import java.util.*;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.TEMPLATESTATEMENT;

/**
 * User: geirove
 * Date: 27.11.12
 */
public class TemplateStatement {

   private String name;
   private String text;
   private char delimiter;
   private TemplateStatementType type;
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

   public TemplateStatement(String name, TemplateStatementType type, List<TemplateParameter> parameters, String text, char delimiter) {
//      super(TEMPLATESTATEMENT);
      validateName(name);
      this.name = name;
      this.type = type;
      this.text = text;
      this.delimiter = delimiter;
      for (TemplateParameter parameter : parameters) {
         try {
            validateName(parameter.getPropertyName());
         } catch (Exception e) {
            throw new IllegalArgumentException("Parameter '" + parameter.getPropertyName() + "' not valid: " + e.getMessage());
         }
         this.parameters.put(parameter.getPropertyName(), parameter);
      }
   }

   private TemplateStatement(UUID uuid, String name, TemplateStatementType type, List<TemplateParameter> parameters, String text, char delimiter) {
//      super(uuid, TEMPLATESTATEMENT);
      validateName(name);
      this.name = name;
      this.type = type;
      this.text = text;
      this.delimiter = delimiter;
      for (TemplateParameter parameter : parameters) {
         validateName(parameter.getPropertyName());
         this.parameters.put(parameter.getPropertyName(), parameter);
      }
   }

   TemplateStatement(TemplateStatement statement) {
//      super(TEMPLATESTATEMENT);
      validateName(statement.getName());
      this.name = statement.getName();
      this.type = statement.getStatementType();
      this.text = statement.getText();
      this.delimiter = statement.getDelimiter();
      for (TemplateParameter parameter : statement.getParameters()) {
         validateName(parameter.getPropertyName());
         this.parameters.put(parameter.getPropertyName(), new TemplateParameter(parameter));
      }
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   private TemplateStatementType getStatementType() {
      return type;
   }

   public void setType(TemplateStatementType type) {
      this.type = type;
   }

   public char getDelimiter() {
      return delimiter;
   }

   public List<TemplateParameter> getParameters() {
      return new ArrayList<>(this.parameters.values());
   }

   public void setParameters(List<TemplateParameter> parameters) {
      this.parameters.clear();
      for (TemplateParameter parameter : parameters) {
         validateName(parameter.getPropertyName());
         this.parameters.put(parameter.getPropertyName(), parameter);
      }
   }

   public String getText() {
      return text.trim();
   }

   private Set<String> getParameterNames() {
      return Collections.unmodifiableSet(parameters.keySet());
   }

   private void validateName(String name) {
      if (TEMPLATESTATEMENT_KEYWORDS.contains(name))
         throw new IllegalArgumentException("'" + name + "' is a reserved word.");
   }

   @Override
   public String toString() {
      return getHeaderStringFor() + "\n" + formatTemplateMethod() + getStartTagFor(getStatementType()) + getText() + getEndTagFor(getStatementType());
   }

   private String getHeaderStringFor() {
      final StringBuilder documentation = new StringBuilder("/** ");
      for (TemplateParameter templateParameter : getParameters()) {
         documentation.append(templateParameter.getPropertyName()).append(",");
         documentation.append(templateParameter.getDomainEntityType().name());
         for (String kvName : templateParameter.getKvNames()) {
            documentation.append(",");
            documentation.append(kvName);
         }
         documentation.append(";");
      }

      documentation.append(" **/");
      return documentation.toString();
   }

   private StringBuilder formatTemplateMethod() {
      final StringBuilder head = new StringBuilder();
      head.append(getName()).append((TemplateStatementType.METHOD.equals(getStatementType()) || TemplateStatementType.SINGLE.equals(getStatementType())) ? "(" : "");
      boolean first = true;
      for (String propertyEntry : getParameterNames()) {
         if (!first) head.append(",");
         first = false;
         head.append(propertyEntry);
      }
      head.append((TemplateStatementType.METHOD.equals(getStatementType()) || TemplateStatementType.SINGLE.equals(getStatementType())) ? ") " : " ");
      return head;
   }

   private String getEndTagFor(TemplateStatementType type) {
      switch (type) {
         case METHOD:
            return "\n>>";
         case MAP:
            return "]";
         case SINGLE:
            return "\"";
      }
      throw new IllegalArgumentException("unsupported type: " + type);
   }

   private String getStartTagFor(TemplateStatementType type) {
      switch (type) {
         case METHOD:
            return "::= <<";
         case MAP:
            return "::= [";
         case SINGLE:
            return "::= \"";
      }
      throw new IllegalArgumentException("unsupported type: " + type);
   }

//   public TemplateStatement copy() {
//      final List<TemplateParameter> copiedParameters = new ArrayList<>(this.parameters.size());
//      for (Map.Entry<String, TemplateParameter> parameterEntry : this.parameters.entrySet())
//         copiedParameters.add(parameterEntry.getValue().copy());
//      return new TemplateStatement(this.uuid, this.name, this.type, copiedParameters, this.text, this.delimiter);
//   }
}