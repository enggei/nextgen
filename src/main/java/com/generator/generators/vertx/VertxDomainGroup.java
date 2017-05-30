package com.generator.generators.vertx;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Vertx.stg' file<br/>
 */
public final class VertxDomainGroup {
   // old Vertx
   private final STGroup stGroup;
   private final char delimiter;

	public VertxDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "Vertx" + java.io.File.separator + "Vertx.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(VertxDomainGroup.class.getResource("/com/generator/generators/vertx/Vertx.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public VertxDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public VertxDomainGroup(java.io.File templateFile) {
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

	public interface VertxDomainGroupTemplate {

	}

   public eomST neweom() {
      return new eomST(stGroup);
   }

   public gtST newgt() {
      return new gtST(stGroup);
   }

   public RouterVerticleST newRouterVerticle() {
      return new RouterVerticleST(stGroup);
   }

   public final class eomST implements VertxDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class gtST implements VertxDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class RouterVerticleST implements VertxDomainGroupTemplate {

      private final AtomicBoolean endpointsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexUriIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private RouterVerticleST(STGroup group) {
   		template = group.getInstanceOf("RouterVerticle");
   	}

      public RouterVerticleST addEndpointsValue(Object name_, Object uri_) {
         endpointsIsSet.set(true);
         template.addAggr("endpoints.{name, uri}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (uri_==null || uri_.toString().length()==0) ? null : uri_));
         return this;
      }
      public RouterVerticleST setIndexUri(Object value) {
      	tryToSetStringProperty(template, value, indexUriIsSet, "indexUri");   
         return this;
      }
      public RouterVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public RouterVerticleST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
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