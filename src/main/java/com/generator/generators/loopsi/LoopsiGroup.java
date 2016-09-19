package com.generator.generators.loopsi;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'LoopsiGroup.stg' file<br/>
 */
public final class LoopsiGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public LoopsiGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "loopsi" + java.io.File.separator + "loopsi.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(LoopsiGroup.class.getResource("/com/generator/generators/loopsi/loopsi.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public LoopsiGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public LoopsiGroup(java.io.File templateFile) {
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

	public interface LoopsiGroupTemplate {

	}


   public GridEditorST newGridEditor() {
      return new GridEditorST(stGroup);
   } 


   public GridEditorHtmlST newGridEditorHtml() {
      return new GridEditorHtmlST(stGroup);
   } 


   public apiST newapi() {
      return new apiST(stGroup);
   } 


   public baseDomainVisitorST newbaseDomainVisitor() {
      return new baseDomainVisitorST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public convertPropertiesST newconvertProperties() {
      return new convertPropertiesST(stGroup);
   } 


   public mainMenuST newmainMenu() {
      return new mainMenuST(stGroup);
   } 


   public mainMenuHtmlST newmainMenuHtml() {
      return new mainMenuHtmlST(stGroup);
   } 


   public shellST newshell() {
      return new shellST(stGroup);
   } 

   public final class GridEditorST implements LoopsiGroupTemplate {

      private final AtomicBoolean enumDeclarationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private GridEditorST(STGroup group) {
   		template = group.getInstanceOf("GridEditor");
   	}

      public GridEditorST addEnumDeclarationsValue(Object declaration_) {
         enumDeclarationsIsSet.set(true);
         template.addAggr("enumDeclarations.{declaration}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_));
         return this;
      }
       public GridEditorST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      } 
       public GridEditorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public GridEditorST addPropertiesValue(Object defaultValue_, Object name_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{defaultValue, name}", ( (defaultValue_==null || defaultValue_.toString().length()==0) ? null : defaultValue_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class GridEditorHtmlST implements LoopsiGroupTemplate {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final ST template;

      private GridEditorHtmlST(STGroup group) {
   		template = group.getInstanceOf("GridEditorHtml");
   	}

      public GridEditorHtmlST addPropertiesValue(Object htmlComponent_, Object name_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{htmlComponent, name}", ( (htmlComponent_==null || htmlComponent_.toString().length()==0) ? null : htmlComponent_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public GridEditorHtmlST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class apiST implements LoopsiGroupTemplate {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messagesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private apiST(STGroup group) {
   		template = group.getInstanceOf("api");
   	}

       public apiST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public apiST addMessagesValue(Object impl_, Object name_) {
         messagesIsSet.set(true);
         template.addAggr("messages.{impl, name}", ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public apiST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public apiST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class baseDomainVisitorST implements LoopsiGroupTemplate {

      private final AtomicBoolean implIsSet = new AtomicBoolean(false);
      private final ST template;

      private baseDomainVisitorST(STGroup group) {
   		template = group.getInstanceOf("baseDomainVisitor");
   	}

       public baseDomainVisitorST setImpl(Object value) {
      	tryToSetStringProperty(template, value, implIsSet, "impl");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements LoopsiGroupTemplate {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class convertPropertiesST implements LoopsiGroupTemplate {

      private final ST template;

      private convertPropertiesST(STGroup group) {
   		template = group.getInstanceOf("convertProperties");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class mainMenuST implements LoopsiGroupTemplate {

      private final AtomicBoolean itemsIsSet = new AtomicBoolean(false);
      private final ST template;

      private mainMenuST(STGroup group) {
   		template = group.getInstanceOf("mainMenu");
   	}

      public mainMenuST addItemsValue(Object description_, Object name_, Object route_) {
         itemsIsSet.set(true);
         template.addAggr("items.{description, name, route}", ( (description_==null || description_.toString().length()==0) ? null : description_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (route_==null || route_.toString().length()==0) ? null : route_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class mainMenuHtmlST implements LoopsiGroupTemplate {

      private final ST template;

      private mainMenuHtmlST(STGroup group) {
   		template = group.getInstanceOf("mainMenuHtml");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class shellST implements LoopsiGroupTemplate {

      private final AtomicBoolean routesIsSet = new AtomicBoolean(false);
      private final ST template;

      private shellST(STGroup group) {
   		template = group.getInstanceOf("shell");
   	}

      public shellST addRoutesValue(Object moduleId_, Object nav_, Object route_, Object title_) {
         routesIsSet.set(true);
         template.addAggr("routes.{moduleId, nav, route, title}", ( (moduleId_==null || moduleId_.toString().length()==0) ? null : moduleId_), ( (nav_==null || nav_.toString().length()==0) ? null : nav_), ( (route_==null || route_.toString().length()==0) ? null : route_), ( (title_==null || title_.toString().length()==0) ? null : title_));
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