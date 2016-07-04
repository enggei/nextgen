package com.generator.generators.javascript;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'JavascriptGroup.stg' file<br/>
 */
public final class JavascriptGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JavascriptGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "javascript" + java.io.File.separator + "javascript.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(JavascriptGroup.class.getResource("/com/generator/generators/javascript/javascript.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "javascript" + java.io.File.separator + "javascript.stg"));
   }

   public JavascriptGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JavascriptGroup(java.io.File templateFile) {
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


   public arrayST newarray() {
      return new arrayST(stGroup);
   } 


   public arrayLineST newarrayLine() {
      return new arrayLineST(stGroup);
   } 


   public fieldST newfield() {
      return new fieldST(stGroup);
   } 


   public functionST newfunction() {
      return new functionST(stGroup);
   } 


   public getElementByIdST newgetElementById() {
      return new getElementByIdST(stGroup);
   } 


   public ifStatementST newifStatement() {
      return new ifStatementST(stGroup);
   } 


   public listST newlist() {
      return new listST(stGroup);
   } 


   public logST newlog() {
      return new logST(stGroup);
   } 


   public logStringST newlogString() {
      return new logStringST(stGroup);
   } 


   public methodST newmethod() {
      return new methodST(stGroup);
   } 


   public objectST newobject() {
      return new objectST(stGroup);
   } 


   public quoteST newquote() {
      return new quoteST(stGroup);
   } 


   public returnStatementST newreturnStatement() {
      return new returnStatementST(stGroup);
   } 


   public scopeST newscope() {
      return new scopeST(stGroup);
   } 


   public thenST newthen() {
      return new thenST(stGroup);
   } 


   public varST newvar() {
      return new varST(stGroup);
   } 

    public final class arrayST {

      private final AtomicBoolean elementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private arrayST(STGroup group) {
   		template = group.getInstanceOf("array");
   	}

      public arrayST addElementsValue(Object value) {
      	tryToSetListProperty(template, value, elementsIsSet, "elements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class arrayLineST {

      private final AtomicBoolean elementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private arrayLineST(STGroup group) {
   		template = group.getInstanceOf("arrayLine");
   	}

      public arrayLineST addElementsValue(Object value) {
      	tryToSetListProperty(template, value, elementsIsSet, "elements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class fieldST {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private fieldST(STGroup group) {
   		template = group.getInstanceOf("field");
   	}

       public fieldST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public fieldST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class functionST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private functionST(STGroup group) {
   		template = group.getInstanceOf("function");
   	}

       public functionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public functionST addParametersValue(Object name_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public functionST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class getElementByIdST {

      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final ST template;

      private getElementByIdST(STGroup group) {
   		template = group.getInstanceOf("getElementById");
   	}

       public getElementByIdST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class ifStatementST {

      private final AtomicBoolean conditionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private ifStatementST(STGroup group) {
   		template = group.getInstanceOf("ifStatement");
   	}

       public ifStatementST setCondition(Object value) {
      	tryToSetStringProperty(template, value, conditionIsSet, "condition");   
         return this;
      } 
       public ifStatementST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class listST {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private listST(STGroup group) {
   		template = group.getInstanceOf("list");
   	}

      public listST addStatementsValue(Object statement_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{statement}", ( (statement_==null || statement_.toString().length()==0) ? null : statement_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class logST {

      private final AtomicBoolean entryIsSet = new AtomicBoolean(false);
      private final ST template;

      private logST(STGroup group) {
   		template = group.getInstanceOf("log");
   	}

       public logST setEntry(Object value) {
      	tryToSetStringProperty(template, value, entryIsSet, "entry");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class logStringST {

      private final AtomicBoolean stringIsSet = new AtomicBoolean(false);
      private final ST template;

      private logStringST(STGroup group) {
   		template = group.getInstanceOf("logString");
   	}

       public logStringST setString(Object value) {
      	tryToSetStringProperty(template, value, stringIsSet, "string");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class methodST {

      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodST(STGroup group) {
   		template = group.getInstanceOf("method");
   	}

       public methodST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
      public methodST addStatementsValue(Object statement_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{statement}", ( (statement_==null || statement_.toString().length()==0) ? null : statement_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class objectST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private objectST(STGroup group) {
   		template = group.getInstanceOf("object");
   	}

      public objectST addFieldsValue(Object value) {
      	tryToSetListProperty(template, value, fieldsIsSet, "fields");
         return this;
      }
       public objectST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class quoteST {

      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private quoteST(STGroup group) {
   		template = group.getInstanceOf("quote");
   	}

       public quoteST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class returnStatementST {

      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private returnStatementST(STGroup group) {
   		template = group.getInstanceOf("returnStatement");
   	}

       public returnStatementST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class scopeST {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private scopeST(STGroup group) {
   		template = group.getInstanceOf("scope");
   	}

      public scopeST addStatementsValue(Object statement_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{statement}", ( (statement_==null || statement_.toString().length()==0) ? null : statement_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class thenST {

      private final AtomicBoolean functionIsSet = new AtomicBoolean(false);
      private final ST template;

      private thenST(STGroup group) {
   		template = group.getInstanceOf("then");
   	}

       public thenST setFunction(Object value) {
      	tryToSetStringProperty(template, value, functionIsSet, "function");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class varST {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private varST(STGroup group) {
   		template = group.getInstanceOf("var");
   	}

       public varST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public varST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
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