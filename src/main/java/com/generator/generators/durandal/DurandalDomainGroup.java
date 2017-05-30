package com.generator.generators.durandal;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'durandal.stg' file<br/>
 */
public final class DurandalDomainGroup {
   // old durandal
   private final STGroup stGroup;
   private final char delimiter;

	public DurandalDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "durandal" + java.io.File.separator + "durandal.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(DurandalDomainGroup.class.getResource("/com/generator/generators/durandal/durandal.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public DurandalDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public DurandalDomainGroup(java.io.File templateFile) {
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

	public interface DurandalDomainGroupTemplate {

	}

   public eomST neweom() {
      return new eomST(stGroup);
   }

   public gtST newgt() {
      return new gtST(stGroup);
   }

   public appHTMLST newappHTML() {
      return new appHTMLST(stGroup);
   }

   public bugfix2ST newbugfix2() {
      return new bugfix2ST(stGroup);
   }

   public mainJSST newmainJS() {
      return new mainJSST(stGroup);
   }

   public moduleJSST newmoduleJS() {
      return new moduleJSST(stGroup);
   }

   public shellHTMLST newshellHTML() {
      return new shellHTMLST(stGroup);
   }

   public shellJSST newshellJS() {
      return new shellJSST(stGroup);
   }

   public modelST newmodel() {
      return new modelST(stGroup);
   }

   public final class eomST implements DurandalDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class gtST implements DurandalDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class appHTMLST implements DurandalDomainGroupTemplate {

      private final AtomicBoolean appStylesheetPathIsSet = new AtomicBoolean(false);
      private final AtomicBoolean splashTitleIsSet = new AtomicBoolean(false);
      private final ST template;

      private appHTMLST(STGroup group) {
   		template = group.getInstanceOf("appHTML");
   	}

      public appHTMLST setAppStylesheetPath(Object value) {
      	tryToSetStringProperty(template, value, appStylesheetPathIsSet, "appStylesheetPath");   
         return this;
      }
      public appHTMLST setSplashTitle(Object value) {
      	tryToSetStringProperty(template, value, splashTitleIsSet, "splashTitle");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bugfix2ST implements DurandalDomainGroupTemplate {

      private final ST template;

      private bugfix2ST(STGroup group) {
   		template = group.getInstanceOf("bugfix2");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mainJSST implements DurandalDomainGroupTemplate {

      private final AtomicBoolean appTitleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pathsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pluginsIsSet = new AtomicBoolean(false);
      private final ST template;

      private mainJSST(STGroup group) {
   		template = group.getInstanceOf("mainJS");
   	}

      public mainJSST setAppTitle(Object value) {
      	tryToSetStringProperty(template, value, appTitleIsSet, "appTitle");   
         return this;
      }
      public mainJSST addPathsValue(Object name_, Object path_) {
         pathsIsSet.set(true);
         template.addAggr("paths.{name, path}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (path_==null || path_.toString().length()==0) ? null : path_));
         return this;
      }
      public mainJSST addPluginsValue(Object name_) {
         pluginsIsSet.set(true);
         template.addAggr("plugins.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class moduleJSST implements DurandalDomainGroupTemplate {

      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnValueIsSet = new AtomicBoolean(false);
      private final ST template;

      private moduleJSST(STGroup group) {
   		template = group.getInstanceOf("moduleJS");
   	}

      public moduleJSST addDependenciesValue(Object importName_, Object refName_) {
         dependenciesIsSet.set(true);
         template.addAggr("dependencies.{importName, refName}", ( (importName_==null || importName_.toString().length()==0) ? null : importName_), ( (refName_==null || refName_.toString().length()==0) ? null : refName_));
         return this;
      }
      public moduleJSST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }
      public moduleJSST setReturnValue(Object value) {
      	tryToSetStringProperty(template, value, returnValueIsSet, "returnValue");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class shellHTMLST implements DurandalDomainGroupTemplate {

      private final ST template;

      private shellHTMLST(STGroup group) {
   		template = group.getInstanceOf("shellHTML");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class shellJSST implements DurandalDomainGroupTemplate {

      private final AtomicBoolean routesIsSet = new AtomicBoolean(false);
      private final ST template;

      private shellJSST(STGroup group) {
   		template = group.getInstanceOf("shellJS");
   	}

      public shellJSST addRoutesValue(Object moduleId_, Object nav_, Object route_, Object title_) {
         routesIsSet.set(true);
         template.addAggr("routes.{moduleId, nav, route, title}", ( (moduleId_==null || moduleId_.toString().length()==0) ? null : moduleId_), ( (nav_==null || nav_.toString().length()==0) ? null : nav_), ( (route_==null || route_.toString().length()==0) ? null : route_), ( (title_==null || title_.toString().length()==0) ? null : title_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class modelST implements DurandalDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private modelST(STGroup group) {
   		template = group.getInstanceOf("model");
   	}

      public modelST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public modelST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
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