 package com.generator.generators.easyFlow;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'EasyFlowGroup.stg' file<br/>
 */
public final class EasyFlowGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public EasyFlowGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "easyFlow" + java.io.File.separator + "easyFlow.stg"));
   }

   public EasyFlowGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public EasyFlowGroup(java.io.File templateFile) {
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


   public declarationST newdeclaration() {
      return new declarationST(stGroup);
   } 


   public easyFlowST neweasyFlow() {
      return new easyFlowST(stGroup);
   } 


   public eventsST newevents() {
      return new eventsST(stGroup);
   } 


   public implST newimpl() {
      return new implST(stGroup);
   } 


   public mvnST newmvn() {
      return new mvnST(stGroup);
   } 


   public stateDeclarationST newstateDeclaration() {
      return new stateDeclarationST(stGroup);
   } 


   public statefulContextST newstatefulContext() {
      return new statefulContextST(stGroup);
   } 


   public statesST newstates() {
      return new statesST(stGroup);
   } 


   public transitST newtransit() {
      return new transitST(stGroup);
   } 

    public final class declarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
      private final ST template;

      private declarationST(STGroup group) {
   		template = group.getInstanceOf("declaration");
   	}

       public declarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public declarationST setState(Object value) {
      	tryToSetStringProperty(template, value, stateIsSet, "state");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class easyFlowST {

      private final AtomicBoolean bindingsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextIsSet = new AtomicBoolean(false);
      private final AtomicBoolean eventsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean superParamsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean transitIsSet = new AtomicBoolean(false);
      private final ST template;

      private easyFlowST(STGroup group) {
   		template = group.getInstanceOf("easyFlow");
   	}

      public easyFlowST addBindingsValue(Object declaration_, Object impl_) {
         bindingsIsSet.set(true);
         template.addAggr("bindings.{declaration, impl}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (impl_==null || impl_.toString().length()==0) ? null : impl_));
         return this;
      }
       public easyFlowST setContext(Object value) {
      	tryToSetStringProperty(template, value, contextIsSet, "context");   
         return this;
      } 
       public easyFlowST setEvents(Object value) {
      	tryToSetStringProperty(template, value, eventsIsSet, "events");   
         return this;
      } 
       public easyFlowST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
       public easyFlowST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public easyFlowST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public easyFlowST setStates(Object value) {
      	tryToSetStringProperty(template, value, statesIsSet, "states");   
         return this;
      } 
      public easyFlowST addSuperParamsValue(Object name_, Object type_) {
         superParamsIsSet.set(true);
         template.addAggr("superParams.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
       public easyFlowST setTransit(Object value) {
      	tryToSetStringProperty(template, value, transitIsSet, "transit");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class eventsST {

      private final AtomicBoolean eventsIsSet = new AtomicBoolean(false);
      private final ST template;

      private eventsST(STGroup group) {
   		template = group.getInstanceOf("events");
   	}

      public eventsST addEventsValue(Object value) {
      	tryToSetListProperty(template, value, eventsIsSet, "events");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class implST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
      private final ST template;

      private implST(STGroup group) {
   		template = group.getInstanceOf("impl");
   	}

       public implST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public implST setState(Object value) {
      	tryToSetStringProperty(template, value, stateIsSet, "state");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class mvnST {

      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class stateDeclarationST {

      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private stateDeclarationST(STGroup group) {
   		template = group.getInstanceOf("stateDeclaration");
   	}

       public stateDeclarationST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
       public stateDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class statefulContextST {

      private final AtomicBoolean contextGenericIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private statefulContextST(STGroup group) {
   		template = group.getInstanceOf("statefulContext");
   	}

       public statefulContextST setContextGeneric(Object value) {
      	tryToSetStringProperty(template, value, contextGenericIsSet, "contextGeneric");   
         return this;
      } 
       public statefulContextST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public statefulContextST addPropertiesValue(Object comment_, Object modifier_, Object name_, Object type_, Object value_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{comment, modifier, name, type, value}", ( (comment_==null || comment_.toString().length()==0) ? null : comment_), ( (modifier_==null || modifier_.toString().length()==0) ? null : modifier_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class statesST {

      private final AtomicBoolean statesIsSet = new AtomicBoolean(false);
      private final ST template;

      private statesST(STGroup group) {
   		template = group.getInstanceOf("states");
   	}

      public statesST addStatesValue(Object value) {
      	tryToSetListProperty(template, value, statesIsSet, "states");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class transitST {

      private final AtomicBoolean eventIsSet = new AtomicBoolean(false);
      private final AtomicBoolean isFinishIsSet = new AtomicBoolean(false);
      private final AtomicBoolean isInitIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean transitsIsSet = new AtomicBoolean(false);
      private final ST template;

      private transitST(STGroup group) {
   		template = group.getInstanceOf("transit");
   	}

       public transitST setEvent(Object value) {
      	tryToSetStringProperty(template, value, eventIsSet, "event");   
         return this;
      } 
       public transitST setIsFinish(Object value) {
      	tryToSetStringProperty(template, value, isFinishIsSet, "isFinish");   
         return this;
      } 
       public transitST setIsInit(Object value) {
      	tryToSetStringProperty(template, value, isInitIsSet, "isInit");   
         return this;
      } 
       public transitST setState(Object value) {
      	tryToSetStringProperty(template, value, stateIsSet, "state");   
         return this;
      } 
      public transitST addTransitsValue(Object value) {
      	tryToSetListProperty(template, value, transitsIsSet, "transits");
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