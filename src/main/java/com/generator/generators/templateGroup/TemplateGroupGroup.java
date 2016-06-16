 package com.generator.generators.templateGroup;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'TemplateGroupGroup.stg' file<br/>
 */
public final class TemplateGroupGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TemplateGroupGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "templateGroup" + java.io.File.separator + "TemplateGroup.stg"));
   }

   public TemplateGroupGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplateGroupGroup(java.io.File templateFile) {
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


   public AttributeRendererDeclarationST newAttributeRendererDeclaration() {
      return new AttributeRendererDeclarationST(stGroup);
   } 


   public GroupClassDeclarationST newGroupClassDeclaration() {
      return new GroupClassDeclarationST(stGroup);
   } 


   public NewGroupInstanceST newNewGroupInstance() {
      return new NewGroupInstanceST(stGroup);
   } 


   public NewStatementDeclarationST newNewStatementDeclaration() {
      return new NewStatementDeclarationST(stGroup);
   } 


   public NewStatementInstanceST newNewStatementInstance() {
      return new NewStatementInstanceST(stGroup);
   } 


   public StatementKeyValueListPropertySetterST newStatementKeyValueListPropertySetter() {
      return new StatementKeyValueListPropertySetterST(stGroup);
   } 


   public StatementListPropertySetterST newStatementListPropertySetter() {
      return new StatementListPropertySetterST(stGroup);
   } 


   public StatementStringPropertySetterST newStatementStringPropertySetter() {
      return new StatementStringPropertySetterST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 

    public final class AttributeRendererDeclarationST {

      private final ST template;

      private AttributeRendererDeclarationST(STGroup group) {
   		template = group.getInstanceOf("AttributeRendererDeclaration");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class GroupClassDeclarationST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private GroupClassDeclarationST(STGroup group) {
   		template = group.getInstanceOf("GroupClassDeclaration");
   	}

       public GroupClassDeclarationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public GroupClassDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public GroupClassDeclarationST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public GroupClassDeclarationST addStatementsValue(Object declaration_, Object newInstance_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{declaration, newInstance}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (newInstance_==null || newInstance_.toString().length()==0) ? null : newInstance_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class NewGroupInstanceST {

      private final AtomicBoolean filenameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewGroupInstanceST(STGroup group) {
   		template = group.getInstanceOf("NewGroupInstance");
   	}

       public NewGroupInstanceST setFilename(Object value) {
      	tryToSetStringProperty(template, value, filenameIsSet, "filename");   
         return this;
      } 
       public NewGroupInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class NewStatementDeclarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewStatementDeclarationST(STGroup group) {
   		template = group.getInstanceOf("NewStatementDeclaration");
   	}

       public NewStatementDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public NewStatementDeclarationST addPropertiesValue(Object name_, Object setter_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, setter}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (setter_==null || setter_.toString().length()==0) ? null : setter_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class NewStatementInstanceST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewStatementInstanceST(STGroup group) {
   		template = group.getInstanceOf("NewStatementInstance");
   	}

       public NewStatementInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class StatementKeyValueListPropertySetterST {

      private final AtomicBoolean kvNamesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementKeyValueListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementKeyValueListPropertySetter");
   	}

      public StatementKeyValueListPropertySetterST addKvNamesValue(Object value) {
      	tryToSetListProperty(template, value, kvNamesIsSet, "kvNames");
         return this;
      }
       public StatementKeyValueListPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementKeyValueListPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class StatementListPropertySetterST {

      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementListPropertySetter");
   	}

       public StatementListPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementListPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class StatementStringPropertySetterST {

      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementStringPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementStringPropertySetter");
   	}

       public StatementStringPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementStringPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class bugfixST {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
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
   } } 