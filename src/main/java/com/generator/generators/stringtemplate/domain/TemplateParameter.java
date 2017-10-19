package com.generator.generators.stringtemplate.domain;

import java.util.Set;
import java.util.TreeSet;

/**
 * User: geirove
 * Date: 28.11.12
 */
public class TemplateParameter implements Comparable<TemplateParameter> {

   protected final String propertyName;
   private final TemplateEntities domainEntityType;
   private final Set<String> kvNames = new TreeSet<>();

   public TemplateParameter(String propertyName, TemplateEntities domainEntityClass, Set<String> kvNames) {
      this.propertyName = propertyName;
      this.domainEntityType = domainEntityClass;
      this.kvNames.addAll(kvNames);
   }

   TemplateParameter(TemplateParameter parameter) {
      this.propertyName = parameter.getPropertyName();
      this.domainEntityType = parameter.getDomainEntityType();
      this.kvNames.addAll(parameter.getKvNames());
   }

   public String getPropertyName() {
      return propertyName;
   }

   public TemplateEntities getDomainEntityType() {
      return kvNames.isEmpty() ? domainEntityType : TemplateEntities.KEYVALUELISTPROPERTY;
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
		final StringBuilder out = new StringBuilder(getPropertyName() + "(" + getDomainEntityType() + ")");

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