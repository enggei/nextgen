package com.generator.generators.templates;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'TemplatesGroup.stg' file<br/>
 */
public final class TemplatesGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TemplatesGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "templates" + java.io.File.separator + "templates.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(TemplatesGroup.class.getResource("/com/generator/generators/templates/templates.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public TemplatesGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplatesGroup(java.io.File templateFile) {
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

	public interface TemplatesGroupTemplate {

	}


   public BooleanTemplateParameterST newBooleanTemplateParameter() {
      return new BooleanTemplateParameterST(stGroup);
   } 


   public KeyValueListTemplateParameterST newKeyValueListTemplateParameter() {
      return new KeyValueListTemplateParameterST(stGroup);
   } 


   public ListTemplateParameterST newListTemplateParameter() {
      return new ListTemplateParameterST(stGroup);
   } 


   public StatementST newStatement() {
      return new StatementST(stGroup);
   } 


   public StatementTemplateParameterST newStatementTemplateParameter() {
      return new StatementTemplateParameterST(stGroup);
   } 


   public StringTemplateParameterST newStringTemplateParameter() {
      return new StringTemplateParameterST(stGroup);
   } 


   public TemplateGroupST newTemplateGroup() {
      return new TemplateGroupST(stGroup);
   } 


   public TemplateGroupVisitorST newTemplateGroupVisitor() {
      return new TemplateGroupVisitorST(stGroup);
   } 


   public TemplateImportST newTemplateImport() {
      return new TemplateImportST(stGroup);
   } 


   public TemplateStatementST newTemplateStatement() {
      return new TemplateStatementST(stGroup);
   } 

   public final class BooleanTemplateParameterST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private BooleanTemplateParameterST(STGroup group) {
   		template = group.getInstanceOf("BooleanTemplateParameter");
   	}

       public BooleanTemplateParameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class KeyValueListTemplateParameterST implements TemplatesGroupTemplate {

      private final AtomicBoolean kvNamesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private KeyValueListTemplateParameterST(STGroup group) {
   		template = group.getInstanceOf("KeyValueListTemplateParameter");
   	}

      public KeyValueListTemplateParameterST addKvNamesValue(Object value) {
      	tryToSetListProperty(template, value, kvNamesIsSet, "kvNames");
         return this;
      }
       public KeyValueListTemplateParameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ListTemplateParameterST implements TemplatesGroupTemplate {

      private final AtomicBoolean elementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private ListTemplateParameterST(STGroup group) {
   		template = group.getInstanceOf("ListTemplateParameter");
   	}

      public ListTemplateParameterST addElementsValue(Object type_) {
         elementsIsSet.set(true);
         template.addAggr("elements.{type}", ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
       public ListTemplateParameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StatementST implements TemplatesGroupTemplate {

      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean templateStatementIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementST(STGroup group) {
   		template = group.getInstanceOf("Statement");
   	}

      public StatementST addParametersValue(Object templateParameter_, Object value_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{templateParameter, value}", ( (templateParameter_==null || templateParameter_.toString().length()==0) ? null : templateParameter_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
       public StatementST setTemplateStatement(Object value) {
      	tryToSetStringProperty(template, value, templateStatementIsSet, "templateStatement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StatementTemplateParameterST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementTemplateParameterST(STGroup group) {
   		template = group.getInstanceOf("StatementTemplateParameter");
   	}

       public StatementTemplateParameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StringTemplateParameterST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private StringTemplateParameterST(STGroup group) {
   		template = group.getInstanceOf("StringTemplateParameter");
   	}

       public StringTemplateParameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public StringTemplateParameterST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateGroupST implements TemplatesGroupTemplate {

      private final AtomicBoolean delimiterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean templateStatementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateGroupST(STGroup group) {
   		template = group.getInstanceOf("TemplateGroup");
   	}

       public TemplateGroupST setDelimiter(Object value) {
      	tryToSetStringProperty(template, value, delimiterIsSet, "delimiter");   
         return this;
      } 
      public TemplateGroupST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
       public TemplateGroupST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public TemplateGroupST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public TemplateGroupST addTemplateStatementsValue(Object value) {
      	tryToSetListProperty(template, value, templateStatementsIsSet, "templateStatements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateGroupVisitorST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onBooleanTemplateParameterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onKeyValueListTemplateParameterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onListTemplateParameterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onStatementTemplateParameterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onStringTemplateParameterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onTemplateGroupIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onTemplateGroupEndIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onTemplateStatementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onTemplateStatementEndIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnPropertyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnTypeIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateGroupVisitorST(STGroup group) {
   		template = group.getInstanceOf("TemplateGroupVisitor");
   	}

       public TemplateGroupVisitorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public TemplateGroupVisitorST addOnBooleanTemplateParameterValue(Object declaration_, Object statements_) {
         onBooleanTemplateParameterIsSet.set(true);
         template.addAggr("onBooleanTemplateParameter.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnKeyValueListTemplateParameterValue(Object declaration_, Object statements_) {
         onKeyValueListTemplateParameterIsSet.set(true);
         template.addAggr("onKeyValueListTemplateParameter.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnListTemplateParameterValue(Object declaration_, Object statements_) {
         onListTemplateParameterIsSet.set(true);
         template.addAggr("onListTemplateParameter.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnStatementTemplateParameterValue(Object declaration_, Object statements_) {
         onStatementTemplateParameterIsSet.set(true);
         template.addAggr("onStatementTemplateParameter.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnStringTemplateParameterValue(Object declaration_, Object statements_) {
         onStringTemplateParameterIsSet.set(true);
         template.addAggr("onStringTemplateParameter.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnTemplateGroupValue(Object declaration_, Object statements_) {
         onTemplateGroupIsSet.set(true);
         template.addAggr("onTemplateGroup.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnTemplateGroupEndValue(Object declaration_, Object statements_) {
         onTemplateGroupEndIsSet.set(true);
         template.addAggr("onTemplateGroupEnd.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnTemplateStatementValue(Object declaration_, Object statements_) {
         onTemplateStatementIsSet.set(true);
         template.addAggr("onTemplateStatement.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
      public TemplateGroupVisitorST addOnTemplateStatementEndValue(Object declaration_, Object statements_) {
         onTemplateStatementEndIsSet.set(true);
         template.addAggr("onTemplateStatementEnd.{declaration, statements}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (statements_==null || statements_.toString().length()==0) ? null : statements_));
         return this;
      }
       public TemplateGroupVisitorST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
       public TemplateGroupVisitorST setReturnProperty(Object value) {
      	tryToSetStringProperty(template, value, returnPropertyIsSet, "returnProperty");   
         return this;
      } 
       public TemplateGroupVisitorST setReturnType(Object value) {
      	tryToSetStringProperty(template, value, returnTypeIsSet, "returnType");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateImportST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateImportST(STGroup group) {
   		template = group.getInstanceOf("TemplateImport");
   	}

       public TemplateImportST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateStatementST implements TemplatesGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean templateParametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean textIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateStatementST(STGroup group) {
   		template = group.getInstanceOf("TemplateStatement");
   	}

       public TemplateStatementST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public TemplateStatementST addTemplateParametersValue(Object value) {
      	tryToSetListProperty(template, value, templateParametersIsSet, "templateParameters");
         return this;
      }
       public TemplateStatementST setText(Object value) {
      	tryToSetStringProperty(template, value, textIsSet, "text");   
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