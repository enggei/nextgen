package com.generator.generators.templatesSwing;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'templatesSwing.stg' file<br/>
 */
public final class TemplatesSwingDomainGroup {
   // old templatesSwing
   private final STGroup stGroup;
   private final char delimiter;

	public TemplatesSwingDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "templatesSwing" + java.io.File.separator + "templatesSwing.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(TemplatesSwingDomainGroup.class.getResource("/com/generator/generators/templatesSwing/templatesSwing.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public TemplatesSwingDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplatesSwingDomainGroup(java.io.File templateFile) {
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

	public interface TemplatesSwingDomainGroupTemplate {

	}


   public eomST neweom() {
      return new eomST(stGroup);
   } 


   public gtST newgt() {
      return new gtST(stGroup);
   } 


   public CanvasActionStringPropertyST newCanvasActionStringProperty() {
      return new CanvasActionStringPropertyST(stGroup);
   } 


   public CanvasListenerST newCanvasListener() {
      return new CanvasListenerST(stGroup);
   } 


   public PNodeST newPNode() {
      return new PNodeST(stGroup);
   } 


   public TemplateCanvasST newTemplateCanvas() {
      return new TemplateCanvasST(stGroup);
   } 


   public TemplateGroupActionsST newTemplateGroupActions() {
      return new TemplateGroupActionsST(stGroup);
   } 


   public TemplatesSwingST newTemplatesSwing() {
      return new TemplatesSwingST(stGroup);
   } 


   public addListActionST newaddListAction() {
      return new addListActionST(stGroup);
   } 


   public addVerticleActionST newaddVerticleAction() {
      return new addVerticleActionST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public genericFixST newgenericFix() {
      return new genericFixST(stGroup);
   } 


   public newActionST newnewAction() {
      return new newActionST(stGroup);
   } 


   public setStringActionST newsetStringAction() {
      return new setStringActionST(stGroup);
   } 


   public statementActionsST newstatementActions() {
      return new statementActionsST(stGroup);
   } 


   public stringPropertyEditorST newstringPropertyEditor() {
      return new stringPropertyEditorST(stGroup);
   } 

   public final class eomST implements TemplatesSwingDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class gtST implements TemplatesSwingDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class CanvasActionStringPropertyST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private CanvasActionStringPropertyST(STGroup group) {
   		template = group.getInstanceOf("CanvasActionStringProperty");
   	}

       public CanvasActionStringPropertyST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public CanvasActionStringPropertyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class CanvasListenerST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private CanvasListenerST(STGroup group) {
   		template = group.getInstanceOf("CanvasListener");
   	}

       public CanvasListenerST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
      public CanvasListenerST addStatementsValue(Object canvasActions_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{canvasActions}", ( (canvasActions_==null || canvasActions_.toString().length()==0) ? null : canvasActions_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class PNodeST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private PNodeST(STGroup group) {
   		template = group.getInstanceOf("PNode");
   	}

       public PNodeST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateCanvasST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateCanvasST(STGroup group) {
   		template = group.getInstanceOf("TemplateCanvas");
   	}

       public TemplateCanvasST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public TemplateCanvasST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public TemplateCanvasST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public TemplateCanvasST addStatementsValue(Object name_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplateGroupActionsST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplateGroupActionsST(STGroup group) {
   		template = group.getInstanceOf("TemplateGroupActions");
   	}

       public TemplateGroupActionsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public TemplateGroupActionsST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class TemplatesSwingST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean canvasListenerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private TemplatesSwingST(STGroup group) {
   		template = group.getInstanceOf("TemplatesSwing");
   	}

       public TemplatesSwingST setCanvasListener(Object value) {
      	tryToSetStringProperty(template, value, canvasListenerIsSet, "canvasListener");   
         return this;
      } 
       public TemplatesSwingST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public TemplatesSwingST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public TemplatesSwingST addStatementsValue(Object name_, Object newAction_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{name, newAction}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (newAction_==null || newAction_.toString().length()==0) ? null : newAction_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class addListActionST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private addListActionST(STGroup group) {
   		template = group.getInstanceOf("addListAction");
   	}

       public addListActionST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public addListActionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public addListActionST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class addVerticleActionST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private addVerticleActionST(STGroup group) {
   		template = group.getInstanceOf("addVerticleAction");
   	}

       public addVerticleActionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public addVerticleActionST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements TemplatesSwingDomainGroupTemplate {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class genericFixST implements TemplatesSwingDomainGroupTemplate {

      private final ST template;

      private genericFixST(STGroup group) {
   		template = group.getInstanceOf("genericFix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class newActionST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private newActionST(STGroup group) {
   		template = group.getInstanceOf("newAction");
   	}

       public newActionST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public newActionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class setStringActionST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private setStringActionST(STGroup group) {
   		template = group.getInstanceOf("setStringAction");
   	}

       public setStringActionST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public setStringActionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public setStringActionST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class statementActionsST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean actionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private statementActionsST(STGroup group) {
   		template = group.getInstanceOf("statementActions");
   	}

      public statementActionsST addActionsValue(Object value) {
      	tryToSetListProperty(template, value, actionsIsSet, "actions");
         return this;
      }
       public statementActionsST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public statementActionsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class stringPropertyEditorST implements TemplatesSwingDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringPropertyEditorST(STGroup group) {
   		template = group.getInstanceOf("stringPropertyEditor");
   	}

       public stringPropertyEditorST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public stringPropertyEditorST setName(Object value) {
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