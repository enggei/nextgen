 package com.generator.generators.protobuf;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'ProtobufGroup.stg' file<br/>
 */
public final class ProtobufGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public ProtobufGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "protobuf" + java.io.File.separator + "Protobuf.stg"));
   }

   public ProtobufGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public ProtobufGroup(java.io.File templateFile) {
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


   public enumST newenum() {
      return new enumST(stGroup);
   } 


   public extendST newextend() {
      return new extendST(stGroup);
   } 


   public extensionsST newextensions() {
      return new extensionsST(stGroup);
   } 


   public groupMessagesModelST newgroupMessagesModel() {
      return new groupMessagesModelST(stGroup);
   } 


   public messageST newmessage() {
      return new messageST(stGroup);
   } 


   public messageFieldST newmessageField() {
      return new messageFieldST(stGroup);
   } 


   public protobufPackageST newprotobufPackage() {
      return new protobufPackageST(stGroup);
   } 

    public final class enumST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private enumST(STGroup group) {
   		template = group.getInstanceOf("enum");
   	}

       public enumST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
       public enumST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public enumST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class extendST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private extendST(STGroup group) {
   		template = group.getInstanceOf("extend");
   	}

       public extendST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
       public extendST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public extendST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class extensionsST {

      private final AtomicBoolean maxIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minIsSet = new AtomicBoolean(false);
      private final ST template;

      private extensionsST(STGroup group) {
   		template = group.getInstanceOf("extensions");
   	}

       public extensionsST setMax(Object value) {
      	tryToSetStringProperty(template, value, maxIsSet, "max");   
         return this;
      } 
       public extensionsST setMin(Object value) {
      	tryToSetStringProperty(template, value, minIsSet, "min");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class groupMessagesModelST {

      private final AtomicBoolean groupNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messagesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private groupMessagesModelST(STGroup group) {
   		template = group.getInstanceOf("groupMessagesModel");
   	}

       public groupMessagesModelST setGroupName(Object value) {
      	tryToSetStringProperty(template, value, groupNameIsSet, "groupName");   
         return this;
      } 
      public groupMessagesModelST addMessagesValue(Object name_) {
         messagesIsSet.set(true);
         template.addAggr("messages.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public groupMessagesModelST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class messageST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private messageST(STGroup group) {
   		template = group.getInstanceOf("message");
   	}

       public messageST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
       public messageST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public messageST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class messageFieldST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean fieldConstraintIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean ordinalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packedValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private messageFieldST(STGroup group) {
   		template = group.getInstanceOf("messageField");
   	}

       public messageFieldST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
       public messageFieldST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public messageFieldST setFieldConstraint(Object value) {
      	tryToSetStringProperty(template, value, fieldConstraintIsSet, "fieldConstraint");   
         return this;
      } 
       public messageFieldST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public messageFieldST setOrdinal(Object value) {
      	tryToSetStringProperty(template, value, ordinalIsSet, "ordinal");   
         return this;
      } 
       public messageFieldST setPackedValue(Object value) {
      	tryToSetStringProperty(template, value, packedValueIsSet, "packedValue");   
         return this;
      } 
       public messageFieldST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class protobufPackageST {

      private final AtomicBoolean deliverablesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean optionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private protobufPackageST(STGroup group) {
   		template = group.getInstanceOf("protobufPackage");
   	}

      public protobufPackageST addDeliverablesValue(Object value) {
      	tryToSetListProperty(template, value, deliverablesIsSet, "deliverables");
         return this;
      }
      public protobufPackageST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
      public protobufPackageST addOptionsValue(Object name_, Object value_) {
         optionsIsSet.set(true);
         template.addAggr("options.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
       public protobufPackageST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
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
   } } 