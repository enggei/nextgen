package com.generator.generators.templatesVertx;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'templatesVertx.stg' file<br/>
 */
public final class TemplatesVertxDomainGroup {
   // old templatesVertx
   private final STGroup stGroup;
   private final char delimiter;

	public TemplatesVertxDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "templatesVertx" + java.io.File.separator + "templatesVertx.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(TemplatesVertxDomainGroup.class.getResource("/com/generator/generators/templatesVertx/templatesVertx.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public TemplatesVertxDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplatesVertxDomainGroup(java.io.File templateFile) {
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

	public interface TemplatesVertxDomainGroupTemplate {

	}


   public eomST neweom() {
      return new eomST(stGroup);
   } 


   public gtST newgt() {
      return new gtST(stGroup);
   } 


   public AddMessageST newAddMessage() {
      return new AddMessageST(stGroup);
   } 


   public ConsumeKeyValueListMessageST newConsumeKeyValueListMessage() {
      return new ConsumeKeyValueListMessageST(stGroup);
   } 


   public ConsumeListMessageST newConsumeListMessage() {
      return new ConsumeListMessageST(stGroup);
   } 


   public ConsumeStringMessageST newConsumeStringMessage() {
      return new ConsumeStringMessageST(stGroup);
   } 


   public GroupVerticleFactoryST newGroupVerticleFactory() {
      return new GroupVerticleFactoryST(stGroup);
   } 


   public SendMessageST newSendMessage() {
      return new SendMessageST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public deployVerticleST newdeployVerticle() {
      return new deployVerticleST(stGroup);
   } 


   public newVerticleInstanceST newnewVerticleInstance() {
      return new newVerticleInstanceST(stGroup);
   } 


   public verticleDeclarationST newverticleDeclaration() {
      return new verticleDeclarationST(stGroup);
   } 

   public final class eomST implements TemplatesVertxDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class gtST implements TemplatesVertxDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class AddMessageST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final ST template;

      private AddMessageST(STGroup group) {
   		template = group.getInstanceOf("AddMessage");
   	}

       public AddMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public AddMessageST addParametersValue(Object name_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ConsumeKeyValueListMessageST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private ConsumeKeyValueListMessageST(STGroup group) {
   		template = group.getInstanceOf("ConsumeKeyValueListMessage");
   	}

       public ConsumeKeyValueListMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public ConsumeKeyValueListMessageST addParametersValue(Object name_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public ConsumeKeyValueListMessageST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ConsumeListMessageST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private ConsumeListMessageST(STGroup group) {
   		template = group.getInstanceOf("ConsumeListMessage");
   	}

       public ConsumeListMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public ConsumeListMessageST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ConsumeStringMessageST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private ConsumeStringMessageST(STGroup group) {
   		template = group.getInstanceOf("ConsumeStringMessage");
   	}

       public ConsumeStringMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public ConsumeStringMessageST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class GroupVerticleFactoryST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean verticlesIsSet = new AtomicBoolean(false);
      private final ST template;

      private GroupVerticleFactoryST(STGroup group) {
   		template = group.getInstanceOf("GroupVerticleFactory");
   	}

       public GroupVerticleFactoryST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
       public GroupVerticleFactoryST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public GroupVerticleFactoryST addVerticlesValue(Object declaration_, Object name_, Object newInstance_) {
         verticlesIsSet.set(true);
         template.addAggr("verticles.{declaration, name, newInstance}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (newInstance_==null || newInstance_.toString().length()==0) ? null : newInstance_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class SendMessageST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private SendMessageST(STGroup group) {
   		template = group.getInstanceOf("SendMessage");
   	}

       public SendMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements TemplatesVertxDomainGroupTemplate {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class deployVerticleST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private deployVerticleST(STGroup group) {
   		template = group.getInstanceOf("deployVerticle");
   	}

       public deployVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public deployVerticleST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class newVerticleInstanceST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private newVerticleInstanceST(STGroup group) {
   		template = group.getInstanceOf("newVerticleInstance");
   	}

       public newVerticleInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class verticleDeclarationST implements TemplatesVertxDomainGroupTemplate {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messagesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private verticleDeclarationST(STGroup group) {
   		template = group.getInstanceOf("verticleDeclaration");
   	}

       public verticleDeclarationST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
      public verticleDeclarationST addMessagesValue(Object consume_, Object send_) {
         messagesIsSet.set(true);
         template.addAggr("messages.{consume, send}", ( (consume_==null || consume_.toString().length()==0) ? null : consume_), ( (send_==null || send_.toString().length()==0) ? null : send_));
         return this;
      }
       public verticleDeclarationST setName(Object value) {
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