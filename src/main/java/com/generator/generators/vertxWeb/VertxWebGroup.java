 package com.generator.generators.vertxWeb;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'VertxWebGroup.stg' file<br/>
 */
public final class VertxWebGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public VertxWebGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "vertxWeb" + java.io.File.separator + "vertxWeb.stg"));
   }

   public VertxWebGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public VertxWebGroup(java.io.File templateFile) {
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


   public eventBusClientST neweventBusClient() {
      return new eventBusClientST(stGroup);
   } 


   public routeHandlerST newrouteHandler() {
      return new routeHandlerST(stGroup);
   } 


   public serverVerticleST newserverVerticle() {
      return new serverVerticleST(stGroup);
   } 


   public socksJSBridgeST newsocksJSBridge() {
      return new socksJSBridgeST(stGroup);
   } 


   public socksJSHandlerST newsocksJSHandler() {
      return new socksJSHandlerST(stGroup);
   } 


   public staticWebVerticleST newstaticWebVerticle() {
      return new staticWebVerticleST(stGroup);
   } 

    public final class eventBusClientST {

      private final AtomicBoolean addressIsSet = new AtomicBoolean(false);
      private final AtomicBoolean handlerStatementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriIsSet = new AtomicBoolean(false);
      private final ST template;

      private eventBusClientST(STGroup group) {
   		template = group.getInstanceOf("eventBusClient");
   	}

       public eventBusClientST setAddress(Object value) {
      	tryToSetStringProperty(template, value, addressIsSet, "address");   
         return this;
      } 
      public eventBusClientST addHandlerStatementsValue(Object value) {
      	tryToSetListProperty(template, value, handlerStatementsIsSet, "handlerStatements");
         return this;
      }
       public eventBusClientST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public eventBusClientST setUri(Object value) {
      	tryToSetStringProperty(template, value, uriIsSet, "uri");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class routeHandlerST {

      private final AtomicBoolean handleIsSet = new AtomicBoolean(false);
      private final ST template;

      private routeHandlerST(STGroup group) {
   		template = group.getInstanceOf("routeHandler");
   	}

       public routeHandlerST setHandle(Object value) {
      	tryToSetStringProperty(template, value, handleIsSet, "handle");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class serverVerticleST {

      private final AtomicBoolean bodyHandlerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean portIsSet = new AtomicBoolean(false);
      private final AtomicBoolean routesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sockjsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean staticRootIsSet = new AtomicBoolean(false);
      private final AtomicBoolean verticlesIsSet = new AtomicBoolean(false);
      private final ST template;

      private serverVerticleST(STGroup group) {
   		template = group.getInstanceOf("serverVerticle");
   	}

       public serverVerticleST setBodyHandler(Object value) {
      	tryToSetStringProperty(template, value, bodyHandlerIsSet, "bodyHandler");   
         return this;
      } 
      public serverVerticleST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
       public serverVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public serverVerticleST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public serverVerticleST setPort(Object value) {
      	tryToSetStringProperty(template, value, portIsSet, "port");   
         return this;
      } 
      public serverVerticleST addRoutesValue(Object action_, Object handler_, Object route_) {
         routesIsSet.set(true);
         template.addAggr("routes.{action, handler, route}", ( (action_==null || action_.toString().length()==0) ? null : action_), ( (handler_==null || handler_.toString().length()==0) ? null : handler_), ( (route_==null || route_.toString().length()==0) ? null : route_));
         return this;
      }
       public serverVerticleST setSockjs(Object value) {
      	tryToSetStringProperty(template, value, sockjsIsSet, "sockjs");   
         return this;
      } 
       public serverVerticleST setStaticRoot(Object value) {
      	tryToSetStringProperty(template, value, staticRootIsSet, "staticRoot");   
         return this;
      } 
      public serverVerticleST addVerticlesValue(Object deploy_) {
         verticlesIsSet.set(true);
         template.addAggr("verticles.{deploy}", ( (deploy_==null || deploy_.toString().length()==0) ? null : deploy_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class socksJSBridgeST {

      private final AtomicBoolean inboundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean outboundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean routeIsSet = new AtomicBoolean(false);
      private final ST template;

      private socksJSBridgeST(STGroup group) {
   		template = group.getInstanceOf("socksJSBridge");
   	}

      public socksJSBridgeST addInboundValue(Object value) {
      	tryToSetListProperty(template, value, inboundIsSet, "inbound");
         return this;
      }
      public socksJSBridgeST addOutboundValue(Object value) {
      	tryToSetListProperty(template, value, outboundIsSet, "outbound");
         return this;
      }
       public socksJSBridgeST setRoute(Object value) {
      	tryToSetStringProperty(template, value, routeIsSet, "route");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class socksJSHandlerST {

      private final AtomicBoolean routeIsSet = new AtomicBoolean(false);
      private final ST template;

      private socksJSHandlerST(STGroup group) {
   		template = group.getInstanceOf("socksJSHandler");
   	}

       public socksJSHandlerST setRoute(Object value) {
      	tryToSetStringProperty(template, value, routeIsSet, "route");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class staticWebVerticleST {

      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean portIsSet = new AtomicBoolean(false);
      private final AtomicBoolean staticRootIsSet = new AtomicBoolean(false);
      private final ST template;

      private staticWebVerticleST(STGroup group) {
   		template = group.getInstanceOf("staticWebVerticle");
   	}

      public staticWebVerticleST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
       public staticWebVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public staticWebVerticleST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public staticWebVerticleST setPort(Object value) {
      	tryToSetStringProperty(template, value, portIsSet, "port");   
         return this;
      } 
       public staticWebVerticleST setStaticRoot(Object value) {
      	tryToSetStringProperty(template, value, staticRootIsSet, "staticRoot");   
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