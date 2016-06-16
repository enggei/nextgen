

package com.generator.generators.templatesVertx;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'TemplatesVertxGroup.stg' file<br/>
 */
public final class TemplatesVertxGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TemplatesVertxGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "templatesVertx" + java.io.File.separator + "templatesVertx.stg"));
   }

   public TemplatesVertxGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplatesVertxGroup(java.io.File templateFile) {
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


   public GroupVerticleST newGroupVerticle() {
      return new GroupVerticleST(stGroup);
   } 


   public SendMessageST newSendMessage() {
      return new SendMessageST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 

    public final class AddMessageST {

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

    public final class ConsumeKeyValueListMessageST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class ConsumeListMessageST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private ConsumeListMessageST(STGroup group) {
   		template = group.getInstanceOf("ConsumeListMessage");
   	}

       public ConsumeListMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class ConsumeStringMessageST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private ConsumeStringMessageST(STGroup group) {
   		template = group.getInstanceOf("ConsumeStringMessage");
   	}

       public ConsumeStringMessageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class GroupVerticleST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupPackageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messagesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private GroupVerticleST(STGroup group) {
   		template = group.getInstanceOf("GroupVerticle");
   	}

       public GroupVerticleST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 

       public GroupVerticleST setGroupPackage(Object value) {
      	tryToSetStringProperty(template, value, groupPackageIsSet, "groupPackage");   
         return this;
      } 

      public GroupVerticleST addMessagesValue(Object consumeMessage_, Object sendToMessage_) {
         messagesIsSet.set(true);
         template.addAggr("messages.{consumeMessage, sendToMessage}", ( (consumeMessage_==null || consumeMessage_.toString().length()==0) ? null : consumeMessage_), ( (sendToMessage_==null || sendToMessage_.toString().length()==0) ? null : sendToMessage_));
         return this;
      }

       public GroupVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

       public GroupVerticleST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class SendMessageST {

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

    public final class bugfixST {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
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
   }   }     