package com.generator.generators.spring;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'SpringDAO.stg' file<br/>
 */
public final class SpringDAOGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public SpringDAOGroup() {
		this(new STGroupString(stg));
   }

   public SpringDAOGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public SpringDAOGroup(java.io.File templateFile) {
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

	public interface SpringDAOGroupTemplate {

	}

   public DaoImplST newDaoImpl() {
      return new DaoImplST(stGroup);
   }

   public DaoST newDao() {
      return new DaoST(stGroup);
   }

   public final class DaoImplST implements SpringDAOGroupTemplate {

      private Object _name;
      private Object _package;
      private Object _implement;

      private final ST template;

      private DaoImplST(STGroup group) {
   		template = group.getInstanceOf("DaoImpl");
   	}

      public DaoImplST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public DaoImplST setPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._package == null) {
            this._package = value;
         	template.add("package", value);
         }

      	return this;
      }

      public String getPackage() {
      	return (String) this._package;
      }

      public DaoImplST setImplement(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._implement == null) {
            this._implement = value;
         	template.add("implement", value);
         }

      	return this;
      }

      public String getImplement() {
      	return (String) this._implement;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DaoST implements SpringDAOGroupTemplate {

      private Object _package;
      private Object _name;

      private final ST template;

      private DaoST(STGroup group) {
   		template = group.getInstanceOf("Dao");
   	}

      public DaoST setPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._package == null) {
            this._package = value;
         	template.add("package", value);
         }

      	return this;
      }

      public String getPackage() {
      	return (String) this._package;
      }

      public DaoST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "SpringDAOGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("DaoImpl(name,package,implement) ::= <<package ~package~;\n" + 
		"\n" + 
		"import org.springframework.beans.factory.annotation.Autowired;\n" + 
		"import org.springframework.jdbc.core.JdbcTemplate;\n" + 
		"import org.springframework.stereotype.Repository;\n" + 
		"\n" + 
		"import javax.sql.DataSource;\n" + 
		"\n" + 
		"@Repository\n" + 
		"public class ~name~ implements ~implement~ {\n" + 
		"\n" + 
		"	@Autowired\n" + 
		"   private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;\n" + 
		"\n" + 
		"   @Autowired\n" + 
		"   public void init(DataSource dataSource) {\n" + 
		"       this.jdbcTemplate = new JdbcTemplate(dataSource);\n" + 
		"   }\n" + 
		"\n" + 
		"\n" + 
		"\n" + 
		"}>>\n")
			.append("Dao(package,name) ::= <<package ~package~;\n" + 
		"\n" + 
		"import org.springframework.beans.factory.annotation.Autowired;\n" + 
		"import org.springframework.jdbc.core.JdbcTemplate;\n" + 
		"import org.springframework.stereotype.Repository;\n" + 
		"\n" + 
		"import javax.sql.DataSource;\n" + 
		"\n" + 
		"public interface ~name~  {\n" + 
		"\n" + 
		"\n" + 
		"\n" + 
		"}>>\n")
		.toString();
}