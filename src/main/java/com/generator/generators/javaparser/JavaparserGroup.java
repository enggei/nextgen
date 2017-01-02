package com.generator.generators.javaparser;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'JavaparserGroup.stg' file<br/>
 */
public final class JavaparserGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JavaparserGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "javaparser" + java.io.File.separator + "javaparser.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(JavaparserGroup.class.getResource("/com/generator/generators/javaparser/javaparser.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public JavaparserGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JavaparserGroup(java.io.File templateFile) {
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

	public interface JavaparserGroupTemplate {

	}


   public JavaParserBuilderST newJavaParserBuilder() {
      return new JavaParserBuilderST(stGroup);
   } 


   public blockStmtST newblockStmt() {
      return new blockStmtST(stGroup);
   } 


   public classOrInterfaceDeclarationST newclassOrInterfaceDeclaration() {
      return new classOrInterfaceDeclarationST(stGroup);
   } 


   public constructorDeclarationST newconstructorDeclaration() {
      return new constructorDeclarationST(stGroup);
   } 


   public fieldAccessExprST newfieldAccessExpr() {
      return new fieldAccessExprST(stGroup);
   } 


   public methodCallExprST newmethodCallExpr() {
      return new methodCallExprST(stGroup);
   } 


   public methodDeclarationST newmethodDeclaration() {
      return new methodDeclarationST(stGroup);
   } 


   public nameExprST newnameExpr() {
      return new nameExprST(stGroup);
   } 


   public packageDeclarationST newpackageDeclaration() {
      return new packageDeclarationST(stGroup);
   } 


   public parameterST newparameter() {
      return new parameterST(stGroup);
   } 


   public qualifiedNameExprST newqualifiedNameExpr() {
      return new qualifiedNameExprST(stGroup);
   } 


   public stringLiteralExprST newstringLiteralExpr() {
      return new stringLiteralExprST(stGroup);
   } 

   public final class JavaParserBuilderST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private JavaParserBuilderST(STGroup group) {
   		template = group.getInstanceOf("JavaParserBuilder");
   	}

       public JavaParserBuilderST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public JavaParserBuilderST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public JavaParserBuilderST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class blockStmtST implements JavaparserGroupTemplate {

      private final ST template;

      private blockStmtST(STGroup group) {
   		template = group.getInstanceOf("blockStmt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class classOrInterfaceDeclarationST implements JavaparserGroupTemplate {

      private final AtomicBoolean classnameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean isInterfaceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private classOrInterfaceDeclarationST(STGroup group) {
   		template = group.getInstanceOf("classOrInterfaceDeclaration");
   	}

       public classOrInterfaceDeclarationST setClassname(Object value) {
      	tryToSetStringProperty(template, value, classnameIsSet, "classname");   
         return this;
      } 
       public classOrInterfaceDeclarationST setIsInterface(Object value) {
      	tryToSetStringProperty(template, value, isInterfaceIsSet, "isInterface");   
         return this;
      } 
       public classOrInterfaceDeclarationST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class constructorDeclarationST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private constructorDeclarationST(STGroup group) {
   		template = group.getInstanceOf("constructorDeclaration");
   	}

       public constructorDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public constructorDeclarationST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class fieldAccessExprST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private fieldAccessExprST(STGroup group) {
   		template = group.getInstanceOf("fieldAccessExpr");
   	}

       public fieldAccessExprST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public fieldAccessExprST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodCallExprST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodCallExprST(STGroup group) {
   		template = group.getInstanceOf("methodCallExpr");
   	}

       public methodCallExprST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public methodCallExprST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodDeclarationST implements JavaparserGroupTemplate {

      private final AtomicBoolean blockStmtIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodDeclarationST(STGroup group) {
   		template = group.getInstanceOf("methodDeclaration");
   	}

       public methodDeclarationST setBlockStmt(Object value) {
      	tryToSetStringProperty(template, value, blockStmtIsSet, "blockStmt");   
         return this;
      } 
       public methodDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public methodDeclarationST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
       public methodDeclarationST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class nameExprST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private nameExprST(STGroup group) {
   		template = group.getInstanceOf("nameExpr");
   	}

       public nameExprST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class packageDeclarationST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameExprIsSet = new AtomicBoolean(false);
      private final ST template;

      private packageDeclarationST(STGroup group) {
   		template = group.getInstanceOf("packageDeclaration");
   	}

       public packageDeclarationST setNameExpr(Object value) {
      	tryToSetStringProperty(template, value, nameExprIsSet, "nameExpr");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class parameterST implements JavaparserGroupTemplate {

      private final AtomicBoolean isVarArgsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean ordinalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private parameterST(STGroup group) {
   		template = group.getInstanceOf("parameter");
   	}

       public parameterST setIsVarArgs(Object value) {
      	tryToSetStringProperty(template, value, isVarArgsIsSet, "isVarArgs");   
         return this;
      } 
       public parameterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public parameterST setOrdinal(Object value) {
      	tryToSetStringProperty(template, value, ordinalIsSet, "ordinal");   
         return this;
      } 
       public parameterST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class qualifiedNameExprST implements JavaparserGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private qualifiedNameExprST(STGroup group) {
   		template = group.getInstanceOf("qualifiedNameExpr");
   	}

       public qualifiedNameExprST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public qualifiedNameExprST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class stringLiteralExprST implements JavaparserGroupTemplate {

      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringLiteralExprST(STGroup group) {
   		template = group.getInstanceOf("stringLiteralExpr");
   	}

       public stringLiteralExprST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
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