package com.generator.generators.vertxRest;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'VertxRestGroup.stg' file<br/>
 */
public final class VertxRestGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public VertxRestGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "vertxRest" + java.io.File.separator + "vertxRest.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(VertxRestGroup.class.getResource("/com/generator/generators/vertxRest/vertxRest.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "vertxRest" + java.io.File.separator + "vertxRest.stg"));
   }

   public VertxRestGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public VertxRestGroup(java.io.File templateFile) {
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


   public APIST newAPI() {
      return new APIST(stGroup);
   } 


   public endMethodFixST newendMethodFix() {
      return new endMethodFixST(stGroup);
   } 


   public validatingNeoHandlerST newvalidatingNeoHandler() {
      return new validatingNeoHandlerST(stGroup);
   } 

    public final class APIST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean endpointsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean entitiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean visitorsIsSet = new AtomicBoolean(false);
      private final ST template;

      private APIST(STGroup group) {
   		template = group.getInstanceOf("API");
   	}

       public APIST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public APIST addEndpointsValue(Object value) {
      	tryToSetListProperty(template, value, endpointsIsSet, "endpoints");
         return this;
      }
      public APIST addEntitiesValue(Object name_) {
         entitiesIsSet.set(true);
         template.addAggr("entities.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public APIST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public APIST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public APIST addPropertiesValue(Object name_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public APIST addVisitorsValue(Object impl_, Object name_) {
         visitorsIsSet.set(true);
         template.addAggr("visitors.{impl, name}", ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class endMethodFixST {

      private final ST template;

      private endMethodFixST(STGroup group) {
   		template = group.getInstanceOf("endMethodFix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class validatingNeoHandlerST {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean apiNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriIsSet = new AtomicBoolean(false);
      private final AtomicBoolean validationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean visitorIsSet = new AtomicBoolean(false);
      private final ST template;

      private validatingNeoHandlerST(STGroup group) {
   		template = group.getInstanceOf("validatingNeoHandler");
   	}

       public validatingNeoHandlerST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public validatingNeoHandlerST setApiName(Object value) {
      	tryToSetStringProperty(template, value, apiNameIsSet, "apiName");   
         return this;
      } 
       public validatingNeoHandlerST setUri(Object value) {
      	tryToSetStringProperty(template, value, uriIsSet, "uri");   
         return this;
      } 
      public validatingNeoHandlerST addValidationsValue(Object property_, Object validationType_) {
         validationsIsSet.set(true);
         template.addAggr("validations.{property, validationType}", ( (property_==null || property_.toString().length()==0) ? null : property_), ( (validationType_==null || validationType_.toString().length()==0) ? null : validationType_));
         return this;
      }
       public validatingNeoHandlerST setVisitor(Object value) {
      	tryToSetStringProperty(template, value, visitorIsSet, "visitor");   
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