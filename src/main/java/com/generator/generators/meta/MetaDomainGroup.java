package com.generator.generators.meta;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'meta.stg' file<br/>
 */
public final class MetaDomainGroup {
   // old meta
   private final STGroup stGroup;
   private final char delimiter;

	public MetaDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "meta" + java.io.File.separator + "meta.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(MetaDomainGroup.class.getResource("/com/generator/generators/meta/meta.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public MetaDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MetaDomainGroup(java.io.File templateFile) {
   	this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
	   this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
	   this.delimiter = stGroup.delimiterStartChar;
	}

   public STGroup getSTGroup() {
      return stGroup;
   }

   public char getDelimiter() {
      return delimiter;
   }

	public interface MetaDomainGroupTemplate {

	}


   public eomST neweom() {
      return new eomST(stGroup);
   } 


   public DomainClassST newDomainClass() {
      return new DomainClassST(stGroup);
   } 


   public EntityEditorST newEntityEditor() {
      return new EntityEditorST(stGroup);
   } 


   public EntityInterfaceST newEntityInterface() {
      return new EntityInterfaceST(stGroup);
   } 

   public final class eomST implements MetaDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class DomainClassST implements MetaDomainGroupTemplate {

      private final AtomicBoolean entitiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean domainNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private DomainClassST(STGroup group) {
   		template = group.getInstanceOf("DomainClass");
   	}

      public DomainClassST addEntitiesValue(Object name_, Object label_, Object color_, Object editor_) {
         entitiesIsSet.set(true);
         template.addAggr("entities.{name, label, color, editor}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (label_==null || label_.toString().length()==0) ? null : label_), ( (color_==null || color_.toString().length()==0) ? null : color_), ( (editor_==null || editor_.toString().length()==0) ? null : editor_));
         return this;
      }
      public DomainClassST addPropertiesValue(Object name_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public DomainClassST addRelationsValue(Object name_) {
         relationsIsSet.set(true);
         template.addAggr("relations.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public DomainClassST setDomainName(Object value) {
      	tryToSetStringProperty(template, value, domainNameIsSet, "domainName");   
         return this;
      } 
       public DomainClassST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class EntityEditorST implements MetaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private EntityEditorST(STGroup group) {
   		template = group.getInstanceOf("EntityEditor");
   	}

       public EntityEditorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public EntityEditorST addPropertiesValue(Object name_, Object component_, Object enums_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, component, enums}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (component_==null || component_.toString().length()==0) ? null : component_), ( (enums_==null || enums_.toString().length()==0) ? null : enums_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class EntityInterfaceST implements MetaDomainGroupTemplate {

      private final AtomicBoolean entityIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relationsIsSet = new AtomicBoolean(false);
      private final ST template;

      private EntityInterfaceST(STGroup group) {
   		template = group.getInstanceOf("EntityInterface");
   	}

       public EntityInterfaceST setEntity(Object value) {
      	tryToSetStringProperty(template, value, entityIsSet, "entity");   
         return this;
      } 
       public EntityInterfaceST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public EntityInterfaceST addPropertiesValue(Object name_, Object type_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public EntityInterfaceST addRelationsValue(Object name_, Object type_) {
         relationsIsSet.set(true);
         template.addAggr("relations.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
	}

	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (value == null || value.toString().length() == 0) return true;
		alreadySet.set(true);
		template.add(name, value);
		return false;
	}

	private enum FormatCode {
	      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
	   }

	   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

	      @Override
	      public String toString(Object o, String formatString, java.util.Locale locale) {

	         final String text = o.toString();

	         if (formatString == null) return text;

	         switch (FormatCode.valueOf(formatString)) {
	            case capitalize:
	               return capitalize(text);
	            case toUpper:
	               return toUpper(text);
	            case lowFirst:
	               return lowFirst(text);
	            case toLower:
	               return text.toLowerCase();
	            case humpToCap:
	               return humpToCap(text);
	            case camelHump:
	               return camelHump(text);
	            case splitCamelHump:
	               return splitCamelHump(text);
	            case singlify:
	               String s = toUpper(text).substring(0, 1) + text.substring(1);
	               if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
	               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
	               else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
	                  return s.substring(0, s.length() - 1);
	               return s;
	            case packageToPath:
	               return packageToPath((text));
	            default:
	               return o.toString();
	         }
	      }

	      private String capitalize(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String lowFirst(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String toUpper(String text) {
	         return text.toUpperCase();
	      }

	      private String humpToCap(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (int i = 0; i < chars.length; i++) {
	            char aChar = chars[i];
	            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
	               out.append("_");
	            }
	            first = false;
	            out.append(Character.toUpperCase(aChar));
	         }
	         return out.toString();
	      }

	      private String camelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean capitalize = true;
	         for (char aChar : chars) {
	            if (Character.isWhitespace(aChar)) {
	               capitalize = true;
	               continue;
	            }
	            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
	            capitalize = false;
	         }
	         return out.toString();
	      }

	      private String splitCamelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (char aChar : chars) {
	            if (Character.isUpperCase(aChar)) out.append(" ");
	            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
	            first = false;
	         }
	         return out.toString();
	      }

	      private String packageToPath(String packageName) {
	          return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
	      }
	   } 

	public String list(String delimiter, Object... elements) {
		final StringBuilder list = new StringBuilder();
		boolean first = true;
		for (Object element : elements) {
			if (!first) list.append(delimiter);
			list.append(element);
			first = false;
		}
		return list.toString() + delimiter;
	}
}