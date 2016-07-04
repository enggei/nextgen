package com.generator.generators.durandal;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'DurandalGroup.stg' file<br/>
 */
public final class DurandalGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public DurandalGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "durandal" + java.io.File.separator + "durandal.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(DurandalGroup.class.getResource("/com/generator/generators/durandal/durandal.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "durandal" + java.io.File.separator + "durandal.stg"));
   }

   public DurandalGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public DurandalGroup(java.io.File templateFile) {
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


   public CrudHtmlST newCrudHtml() {
      return new CrudHtmlST(stGroup);
   } 


   public CrudJSST newCrudJS() {
      return new CrudJSST(stGroup);
   } 


   public EditDialogHTMLST newEditDialogHTML() {
      return new EditDialogHTMLST(stGroup);
   } 


   public EditDialogJSST newEditDialogJS() {
      return new EditDialogJSST(stGroup);
   } 


   public NewDialogHTMLST newNewDialogHTML() {
      return new NewDialogHTMLST(stGroup);
   } 


   public NewDialogJSST newNewDialogJS() {
      return new NewDialogJSST(stGroup);
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


   public moduleHTMLST newmoduleHTML() {
      return new moduleHTMLST(stGroup);
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

    public final class CrudHtmlST {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private CrudHtmlST(STGroup group) {
   		template = group.getInstanceOf("CrudHtml");
   	}

      public CrudHtmlST addColumnsValue(Object name_) {
         columnsIsSet.set(true);
         template.addAggr("columns.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public CrudHtmlST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class CrudJSST {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean editableFieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private CrudJSST(STGroup group) {
   		template = group.getInstanceOf("CrudJS");
   	}

      public CrudJSST addColumnsValue(Object defaultValue_, Object name_) {
         columnsIsSet.set(true);
         template.addAggr("columns.{defaultValue, name}", ( (defaultValue_==null || defaultValue_.toString().length()==0) ? null : defaultValue_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public CrudJSST addEditableFieldsValue(Object defaultValue_, Object name_) {
         editableFieldsIsSet.set(true);
         template.addAggr("editableFields.{defaultValue, name}", ( (defaultValue_==null || defaultValue_.toString().length()==0) ? null : defaultValue_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public CrudJSST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class EditDialogHTMLST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private EditDialogHTMLST(STGroup group) {
   		template = group.getInstanceOf("EditDialogHTML");
   	}

      public EditDialogHTMLST addFieldsValue(Object label_, Object name_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{label, name}", ( (label_==null || label_.toString().length()==0) ? null : label_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public EditDialogHTMLST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class EditDialogJSST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private EditDialogJSST(STGroup group) {
   		template = group.getInstanceOf("EditDialogJS");
   	}

      public EditDialogJSST addFieldsValue(Object name_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public EditDialogJSST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class NewDialogHTMLST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewDialogHTMLST(STGroup group) {
   		template = group.getInstanceOf("NewDialogHTML");
   	}

      public NewDialogHTMLST addFieldsValue(Object label_, Object name_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{label, name}", ( (label_==null || label_.toString().length()==0) ? null : label_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public NewDialogHTMLST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class NewDialogJSST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewDialogJSST(STGroup group) {
   		template = group.getInstanceOf("NewDialogJS");
   	}

      public NewDialogJSST addFieldsValue(Object name_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public NewDialogJSST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class appHTMLST {

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

    public final class bugfix2ST {

      private final ST template;

      private bugfix2ST(STGroup group) {
   		template = group.getInstanceOf("bugfix2");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class mainJSST {

      private final AtomicBoolean appTitleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pathsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pluginsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean systemDebugIsSet = new AtomicBoolean(false);
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
       public mainJSST setSystemDebug(Object value) {
      	tryToSetStringProperty(template, value, systemDebugIsSet, "systemDebug");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class moduleHTMLST {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final ST template;

      private moduleHTMLST(STGroup group) {
   		template = group.getInstanceOf("moduleHTML");
   	}

      public moduleHTMLST addContentValue(Object value) {
      	tryToSetListProperty(template, value, contentIsSet, "content");
         return this;
      }
       public moduleHTMLST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class moduleJSST {

      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private moduleJSST(STGroup group) {
   		template = group.getInstanceOf("moduleJS");
   	}

      public moduleJSST addDependenciesValue(Object importName_, Object refName_) {
         dependenciesIsSet.set(true);
         template.addAggr("dependencies.{importName, refName}", ( (importName_==null || importName_.toString().length()==0) ? null : importName_), ( (refName_==null || refName_.toString().length()==0) ? null : refName_));
         return this;
      }
      public moduleJSST addReturnsValue(Object impl_, Object name_) {
         returnsIsSet.set(true);
         template.addAggr("returns.{impl, name}", ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public moduleJSST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class shellHTMLST {

      private final ST template;

      private shellHTMLST(STGroup group) {
   		template = group.getInstanceOf("shellHTML");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class shellJSST {

      private final AtomicBoolean routesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean unknownRoutePageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean unknownRoutePathIsSet = new AtomicBoolean(false);
      private final ST template;

      private shellJSST(STGroup group) {
   		template = group.getInstanceOf("shellJS");
   	}

      public shellJSST addRoutesValue(Object moduleId_, Object nav_, Object route_, Object title_) {
         routesIsSet.set(true);
         template.addAggr("routes.{moduleId, nav, route, title}", ( (moduleId_==null || moduleId_.toString().length()==0) ? null : moduleId_), ( (nav_==null || nav_.toString().length()==0) ? null : nav_), ( (route_==null || route_.toString().length()==0) ? null : route_), ( (title_==null || title_.toString().length()==0) ? null : title_));
         return this;
      }
       public shellJSST setUnknownRoutePage(Object value) {
      	tryToSetStringProperty(template, value, unknownRoutePageIsSet, "unknownRoutePage");   
         return this;
      } 
       public shellJSST setUnknownRoutePath(Object value) {
      	tryToSetStringProperty(template, value, unknownRoutePathIsSet, "unknownRoutePath");   
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