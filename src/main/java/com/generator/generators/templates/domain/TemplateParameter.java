package com.generator.generators.templates.domain;

import java.util.*;

import static com.generator.generators.templates.domain.TemplateEntities.TEMPLATEPARAMETER;

/**
 * User: geirove
 * Date: 28.11.12
 * //todo add TemplateParameter instead of kvNames
 */
public class TemplateParameter extends BaseEntity<TemplateEntities> implements Comparable<TemplateParameter> {

   protected final String propertyName;
   private final TemplateEntities domainEntityType;
   private final Set<String> kvNames = new TreeSet<>();
   private final Set<TemplateParameter> kvParameters = new TreeSet<>(); // use this to create kv- instances

   public TemplateParameter(UUID uuid, String propertyName, TemplateEntities domainEntityClass, String... kvNames) {
      super(uuid, TEMPLATEPARAMETER);
      this.propertyName = propertyName;
      this.domainEntityType = domainEntityClass;
      this.kvNames.addAll(Arrays.asList(kvNames));
   }

   public TemplateParameter(String propertyName, TemplateEntities domainEntityClass, String... kvNames) {
      super(UUID.randomUUID(), TEMPLATEPARAMETER);
      this.propertyName = propertyName;
      this.domainEntityType = domainEntityClass;
      this.kvNames.addAll(Arrays.asList(kvNames));
   }

   public TemplateParameter(String propertyName, TemplateEntities domainEntityClass, Set<String> kvNames) {
      super(UUID.randomUUID(), TEMPLATEPARAMETER);
      this.propertyName = propertyName;
      this.domainEntityType = domainEntityClass;
      this.kvNames.addAll(kvNames);
   }

   public TemplateParameter(TemplateParameter parameter) {
      super(TEMPLATEPARAMETER);
      this.propertyName = parameter.getPropertyName();
      this.domainEntityType = parameter.getDomainEntityType();
      for (String names : parameter.getKvNames())
         this.kvNames.add(names);
   }

   public TemplateParameter(String params) {
      super(TEMPLATEPARAMETER);
      final List<String> p = Arrays.asList(params.split(","));
      this.uuid = UUID.randomUUID();
      this.propertyName = p.get(0);
      this.domainEntityType = TemplateEntities.valueOf(p.get(1));
      this.kvNames.addAll(p.subList(2, p.size()));
   }

   public TemplateParameter(Property property) {
      super(TEMPLATEPARAMETER);
      this.propertyName = property.getPropertyName();
      this.domainEntityType = property.getDomainType();
      if (TemplateEntities.KEYVALUELISTPROPERTY.equals(this.domainEntityType)) {
         final KeyValueListProperty keyValueListProperty = (KeyValueListProperty) property;
         for (List<Property> propertyList : keyValueListProperty.getElements()) {
            for (Property prop : propertyList) {
               kvNames.add(prop.getPropertyName());
            }
         }
      }
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

   public TemplateParameter mergeKvNames(Set<String> kvNames) {
      for (String kvName : kvNames) this.kvNames.add(kvName);
      return this;
   }

   public Property asProperty() {
      if (TemplateEntities.STRINGPROPERTY.equals(domainEntityType)) return new StringProperty(UUID.randomUUID(), getPropertyName(), null);
      else if (TemplateEntities.STATEMENTPROPERTY.equals(domainEntityType)) return new StatementProperty(UUID.randomUUID(), getPropertyName());
      else if (TemplateEntities.LISTPROPERTY.equals(domainEntityType)) return new ListProperty(UUID.randomUUID(), getPropertyName());
      else if (TemplateEntities.KEYVALUELISTPROPERTY.equals(domainEntityType)) return new KeyValueListProperty(UUID.randomUUID(), getPropertyName());
      else if (TemplateEntities.BOOLEANPROPERTY.equals(domainEntityType)) return new BooleanProperty(UUID.randomUUID(), getPropertyName(), false);
      throw new IllegalStateException("Unknown property type '" + domainEntityType + "'");
   }

   public String kvNamesAsString() {
      if (kvNames == null || kvNames.size() == 0) return "";

      final StringBuilder kvParams = new StringBuilder();
      boolean first = true;
      for (String s : getKvNames()) {
         if (!first) kvParams.append(",");
         kvParams.append(s);
         first = false;
      }
      return kvParams.toString();
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

   public PropertySet getKvNamesAsPropertySet(String value) {
      final PropertySet propertySet = new PropertySet();
      for (String kvName : getKvNames())
         propertySet.add(new StringProperty(kvName, value));
      return propertySet;
   }

   public TemplateParameter copy() {
      return new TemplateParameter(this.uuid, this.propertyName, this.domainEntityType, this.kvNames.toArray(new String[this.kvNames.size()]));
   }

    public void addKvName(String name) {
        this.kvNames.add(name);
    }
}