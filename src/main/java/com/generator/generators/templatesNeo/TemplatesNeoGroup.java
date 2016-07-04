package com.generator.generators.templatesNeo;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'TemplatesNeoGroup.stg' file<br/>
 */
public final class TemplatesNeoGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TemplatesNeoGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "templatesNeo" + java.io.File.separator + "templatesNeo.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(TemplatesNeoGroup.class.getResource("/com/generator/generators/templatesNeo/templatesNeo.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "templatesNeo" + java.io.File.separator + "templatesNeo.stg"));
   }

   public TemplatesNeoGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplatesNeoGroup(java.io.File templateFile) {
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


   public NeoGroupClassDeclarationST newNeoGroupClassDeclaration() {
      return new NeoGroupClassDeclarationST(stGroup);
   } 


   public bugfix2ST newbugfix2() {
      return new bugfix2ST(stGroup);
   } 


   public declarationST newdeclaration() {
      return new declarationST(stGroup);
   } 


   public endParensST newendParens() {
      return new endParensST(stGroup);
   } 


   public keyValueListSetterST newkeyValueListSetter() {
      return new keyValueListSetterST(stGroup);
   } 


   public listSetterST newlistSetter() {
      return new listSetterST(stGroup);
   } 


   public newInstanceST newnewInstance() {
      return new newInstanceST(stGroup);
   } 


   public stringSetterST newstringSetter() {
      return new stringSetterST(stGroup);
   } 

    public final class NeoGroupClassDeclarationST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private NeoGroupClassDeclarationST(STGroup group) {
   		template = group.getInstanceOf("NeoGroupClassDeclaration");
   	}

       public NeoGroupClassDeclarationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public NeoGroupClassDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public NeoGroupClassDeclarationST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public NeoGroupClassDeclarationST addStatementsValue(Object declaration_, Object newInstance_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{declaration, newInstance}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (newInstance_==null || newInstance_.toString().length()==0) ? null : newInstance_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class bugfix2ST {

      private final ST template;

      private bugfix2ST(STGroup group) {
   		template = group.getInstanceOf("bugfix2");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class declarationST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private declarationST(STGroup group) {
   		template = group.getInstanceOf("declaration");
   	}

       public declarationST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public declarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public declarationST addPropertiesValue(Object name_, Object setter_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, setter}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (setter_==null || setter_.toString().length()==0) ? null : setter_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class endParensST {

      private final ST template;

      private endParensST(STGroup group) {
   		template = group.getInstanceOf("endParens");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class keyValueListSetterST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean kvNamesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private keyValueListSetterST(STGroup group) {
   		template = group.getInstanceOf("keyValueListSetter");
   	}

       public keyValueListSetterST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
      public keyValueListSetterST addKvNamesValue(Object value) {
      	tryToSetListProperty(template, value, kvNamesIsSet, "kvNames");
         return this;
      }
       public keyValueListSetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public keyValueListSetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class listSetterST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private listSetterST(STGroup group) {
   		template = group.getInstanceOf("listSetter");
   	}

       public listSetterST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public listSetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public listSetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class newInstanceST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private newInstanceST(STGroup group) {
   		template = group.getInstanceOf("newInstance");
   	}

       public newInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class stringSetterST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringSetterST(STGroup group) {
   		template = group.getInstanceOf("stringSetter");
   	}

       public stringSetterST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public stringSetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public stringSetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
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