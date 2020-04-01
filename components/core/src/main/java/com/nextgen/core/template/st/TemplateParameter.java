package com.nextgen.core.template.st;

import com.nextgen.core.template.Template;

import java.util.Set;
import java.util.TreeSet;

/**
 * User: geirove
 * Date: 28.11.12
 */
public class TemplateParameter implements Comparable<TemplateParameter> {

   private final String propertyName;
   private final Template.ParameterType type;
   private final Set<String> kvNames = new TreeSet<>();

   TemplateParameter(String propertyName, Template.ParameterType domainEntityClass, Set<String> kvNames) {
      this.propertyName = propertyName;
      this.type = domainEntityClass;
      this.kvNames.addAll(kvNames);
   }

   public String getPropertyName() {
      return propertyName;
   }

   public Template.ParameterType getType() {
      return type;
   }

   public Set<String> getKvNames() {
      return kvNames;
   }

   @Override
   public int compareTo(TemplateParameter o) {
      return getPropertyName().compareToIgnoreCase(o.getPropertyName());
   }

   @Override
   public String toString() {
      final StringBuilder out = new StringBuilder(getPropertyName() + "(" + getType() + ")");

      if (getKvNames().size() > 0) {
         out.append(".{");
         boolean first = true;
         for (String declProp : getKvNames()) {
            if (!first) out.append(", ");
            out.append(declProp);
            first = false;
         }
         out.append("}");
      }
      return out.toString();

   }
}