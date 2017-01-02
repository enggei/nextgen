package com.generator.generators.project;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'ProjectGroup.stg' file<br/>
 */
public final class ProjectGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public ProjectGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "project" + java.io.File.separator + "project.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(ProjectGroup.class.getResource("/com/generator/generators/project/project.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public ProjectGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public ProjectGroup(java.io.File templateFile) {
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

	public interface ProjectGroupTemplate {

	}


   public aspectST newaspect() {
      return new aspectST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public projectST newproject() {
      return new projectST(stGroup);
   } 


   public stringValueST newstringValue() {
      return new stringValueST(stGroup);
   } 


   public writeFileST newwriteFile() {
      return new writeFileST(stGroup);
   } 

   public final class aspectST implements ProjectGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tasksIsSet = new AtomicBoolean(false);
      private final ST template;

      private aspectST(STGroup group) {
   		template = group.getInstanceOf("aspect");
   	}

       public aspectST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public aspectST addTasksValue(Object value) {
      	tryToSetListProperty(template, value, tasksIsSet, "tasks");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements ProjectGroupTemplate {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class projectST implements ProjectGroupTemplate {

      private final AtomicBoolean aspectsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rootsIsSet = new AtomicBoolean(false);
      private final ST template;

      private projectST(STGroup group) {
   		template = group.getInstanceOf("project");
   	}

      public projectST addAspectsValue(Object value) {
      	tryToSetListProperty(template, value, aspectsIsSet, "aspects");
         return this;
      }
       public projectST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public projectST addGroupsValue(Object name_, Object packageName_, Object path_, Object reference_) {
         groupsIsSet.set(true);
         template.addAggr("groups.{name, packageName, path, reference}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (packageName_==null || packageName_.toString().length()==0) ? null : packageName_), ( (path_==null || path_.toString().length()==0) ? null : path_), ( (reference_==null || reference_.toString().length()==0) ? null : reference_));
         return this;
      }
       public projectST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public projectST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public projectST addRootsValue(Object path_, Object reference_) {
         rootsIsSet.set(true);
         template.addAggr("roots.{path, reference}", ( (path_==null || path_.toString().length()==0) ? null : path_), ( (reference_==null || reference_.toString().length()==0) ? null : reference_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class stringValueST implements ProjectGroupTemplate {

      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringValueST(STGroup group) {
   		template = group.getInstanceOf("stringValue");
   	}

       public stringValueST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class writeFileST implements ProjectGroupTemplate {

      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean filetypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private writeFileST(STGroup group) {
   		template = group.getInstanceOf("writeFile");
   	}

       public writeFileST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
       public writeFileST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      } 
       public writeFileST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      } 
       public writeFileST setFiletype(Object value) {
      	tryToSetStringProperty(template, value, filetypeIsSet, "filetype");   
         return this;
      } 
       public writeFileST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
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