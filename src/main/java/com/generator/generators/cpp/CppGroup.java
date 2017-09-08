package com.generator.generators.cpp;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'cpp.stg' file<br/>
 */
public final class CppGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public CppGroup() {
		this(new STGroupString(stg));
   }

   public CppGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public CppGroup(java.io.File templateFile) {
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

	public interface CppGroupTemplate {

	}

   public HeaderFileST newHeaderFile() {
      return new HeaderFileST(stGroup);
   }

   public MemberST newMember() {
      return new MemberST(stGroup);
   }

   public NamespaceST newNamespace() {
      return new NamespaceST(stGroup);
   }

   public StructST newStruct() {
      return new StructST(stGroup);
   }

   public TypeST newType() {
      return new TypeST(stGroup);
   }

   public ClassST newClass() {
      return new ClassST(stGroup);
   }

   public MethodST newMethod() {
      return new MethodST(stGroup);
   }

   public TypedefST newTypedef() {
      return new TypedefST(stGroup);
   }

   public final class HeaderFileST implements CppGroupTemplate {

      private final AtomicBoolean entryIsSet = new AtomicBoolean(false);
      private final AtomicBoolean includesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean namespaceIsSet = new AtomicBoolean(false);
      private final ST template;

      private HeaderFileST(STGroup group) {
   		template = group.getInstanceOf("HeaderFile");
   	}

      public HeaderFileST addEntryValue(Object value) {
      	tryToSetListProperty(template, value, entryIsSet, "entry");
         return this;
      }
      public HeaderFileST addIncludesValue(Object name_, Object system_) {
         includesIsSet.set(true);
         template.addAggr("includes.{name, system}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (system_==null || system_.toString().length()==0) ? null : system_));
         return this;
      }
      public HeaderFileST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public HeaderFileST addNamespaceValue(Object value) {
      	tryToSetListProperty(template, value, namespaceIsSet, "namespace");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class MemberST implements CppGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean staticIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private MemberST(STGroup group) {
   		template = group.getInstanceOf("Member");
   	}

      public MemberST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public MemberST setStatic(Object value) {
      	tryToSetStringProperty(template, value, staticIsSet, "static");   
         return this;
      }
      public MemberST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class NamespaceST implements CppGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NamespaceST(STGroup group) {
   		template = group.getInstanceOf("Namespace");
   	}

      public NamespaceST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public NamespaceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class StructST implements CppGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean privateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean protectedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean publicIsSet = new AtomicBoolean(false);
      private final ST template;

      private StructST(STGroup group) {
   		template = group.getInstanceOf("Struct");
   	}

      public StructST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public StructST addPrivateValue(Object value) {
      	tryToSetListProperty(template, value, privateIsSet, "private");
         return this;
      }
      public StructST addProtectedValue(Object value) {
      	tryToSetListProperty(template, value, protectedIsSet, "protected");
         return this;
      }
      public StructST addPublicValue(Object value) {
      	tryToSetListProperty(template, value, publicIsSet, "public");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class TypeST implements CppGroupTemplate {

      private final AtomicBoolean constIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean namespaceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pointerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private TypeST(STGroup group) {
   		template = group.getInstanceOf("Type");
   	}

      public TypeST setConst(Object value) {
      	tryToSetStringProperty(template, value, constIsSet, "const");   
         return this;
      }
      public TypeST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public TypeST setNamespace(Object value) {
      	tryToSetStringProperty(template, value, namespaceIsSet, "namespace");   
         return this;
      }
      public TypeST setPointer(Object value) {
      	tryToSetStringProperty(template, value, pointerIsSet, "pointer");   
         return this;
      }
      public TypeST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ClassST implements CppGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean privateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean protectedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean publicIsSet = new AtomicBoolean(false);
      private final ST template;

      private ClassST(STGroup group) {
   		template = group.getInstanceOf("Class");
   	}

      public ClassST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public ClassST addPrivateValue(Object value) {
      	tryToSetListProperty(template, value, privateIsSet, "private");
         return this;
      }
      public ClassST addProtectedValue(Object value) {
      	tryToSetListProperty(template, value, protectedIsSet, "protected");
         return this;
      }
      public ClassST addPublicValue(Object value) {
      	tryToSetListProperty(template, value, publicIsSet, "public");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class MethodST implements CppGroupTemplate {

      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean staticIsSet = new AtomicBoolean(false);
      private final AtomicBoolean constIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private MethodST(STGroup group) {
   		template = group.getInstanceOf("Method");
   	}

      public MethodST addParametersValue(Object name_, Object type_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public MethodST setReturnType(Object value) {
      	tryToSetStringProperty(template, value, returnTypeIsSet, "returnType");   
         return this;
      }
      public MethodST setStatic(Object value) {
      	tryToSetStringProperty(template, value, staticIsSet, "static");   
         return this;
      }
      public MethodST setConst(Object value) {
      	tryToSetStringProperty(template, value, constIsSet, "const");   
         return this;
      }
      public MethodST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class TypedefST implements CppGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private TypedefST(STGroup group) {
   		template = group.getInstanceOf("Typedef");
   	}

      public TypedefST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public TypedefST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
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

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "CppGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = "delimiters \"~\", \"~\"\n" + 
	"\n" + 
	"eom() ::= <<}>>\n" + 
	"\n" + 
	"gt() ::= <<> >>\n" + 
	"\n" + 
	"HeaderFile(entry,includes,name,namespace) ::= <<#ifndef __~name;format=\"toUpper\"~_HPP__\n" + 
	"#define __~name;format=\"toUpper\"~_HPP__\n" + 
	"~if(includes)~~includes:{it|#include ~if(it.system)~<~else~\"~endif~~it.name~~if(it.system)~>~else~\"~endif~};separator=\"\\n\"~~endif~\n" + 
	"~if(namespace)~namespace ~namespace:{it|~it;format=\"lowFirst\"~ {};separator=\"\\n\"~~endif~\n" + 
	"~entry:{it|~entry~}~\n" + 
	"~if(namespace)~~namespace:{it|\\} // namespace ~it;format=\"lowFirst\"~};separator=\"\\n\"~~endif~\n" + 
	"#endif // __~name;format=\"toUpper\"~_HPP__\n" + 
	">>\n" + 
	"\n" + 
	"Member(name,static,type) ::= <<~if(static)~static ~endif~~if(type)~~type~~else~void~endif~ ~name;format=\"lowFirst\"~;\n" + 
	">>\n" + 
	"\n" + 
	"Namespace(content,name) ::= <<namespace ~name~ {\n" + 
	"~content~\n" + 
	"} // namespace ~name~\n" + 
	">>\n" + 
	"\n" + 
	"Struct(name,private,protected,public) ::= <<struct ~name;format=\"capitalize\"~ {\n" + 
	"~if(public)~public:\n" + 
	"~public:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"\n" + 
	"~if(protected)~protected:\n" + 
	"~protected:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"\n" + 
	"~if(private)~private:\n" + 
	"~private:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"}\n" + 
	">>\n" + 
	"\n" + 
	"Type(const,name,namespace,pointer,reference) ::= <<~if(const)~const ~endif~~if(namespace)~~namespace~::~endif~~name;format=\"lowFirst\"~~if(pointer)~*~endif~~if(reference)~&~endif~\n" + 
	">>\n" + 
	"\n" + 
	"Class(name,private,protected,public) ::= <<class ~name;format=\"capitalize\"~ {\n" + 
	"~if(public)~public:\n" + 
	"~public:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"\n" + 
	"~if(protected)~protected:\n" + 
	"~protected:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"\n" + 
	"~if(private)~private:\n" + 
	"~private:{it|~it~}; separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"}; // class ~name;format=\"capitalize\"~\n" + 
	">>\n" + 
	"\n" + 
	"Method(parameters,returnType,static,const,name) ::= <<~if(static)~static ~endif~~if(returnType)~~returnType~~else~void~endif~ ~name;format=\"lowFirst\"~(~parameters:{it|~it.type~ ~it.name;format=\"lowFirst\"~}; separator=\", \"~)~if(const)~ const~endif~;\n" + 
	">>\n" + 
	"\n" + 
	"Typedef(name,type) ::= <<typedef ~type~ ~name~;\n" + 
	">>\n" + 
	"\n" + 
	"";
}