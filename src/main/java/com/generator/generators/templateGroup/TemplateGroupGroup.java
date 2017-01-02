package com.generator.generators.templateGroup;


import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'TemplateGroupGroup.stg' file<br/>
 */
public final class TemplateGroupGroup {
   // old TemplateGroup
   private final STGroup stGroup;
   private final char delimiter;

	public TemplateGroupGroup() {
		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "templateGroup" + java.io.File.separator + "TemplateGroup.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(TemplateGroupGroup.class.getResource("/com/generator/generators/project/project.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public TemplateGroupGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplateGroupGroup(java.io.File templateFile) {
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

	public interface TemplateGroupGroupTemplate {

	}


   public AttributeRendererDeclarationST newAttributeRendererDeclaration() {
      return new AttributeRendererDeclarationST(stGroup);
   } 


   public GroupClassDeclarationST newGroupClassDeclaration() {
      return new GroupClassDeclarationST(stGroup);
   } 


   public NewGroupInstanceST newNewGroupInstance() {
      return new NewGroupInstanceST(stGroup);
   } 


   public NewStatementDeclarationST newNewStatementDeclaration() {
      return new NewStatementDeclarationST(stGroup);
   } 


   public NewStatementInstanceST newNewStatementInstance() {
      return new NewStatementInstanceST(stGroup);
   } 


   public StatementKeyValueListPropertySetterST newStatementKeyValueListPropertySetter() {
      return new StatementKeyValueListPropertySetterST(stGroup);
   } 


   public StatementListPropertySetterST newStatementListPropertySetter() {
      return new StatementListPropertySetterST(stGroup);
   } 


   public StatementStringPropertySetterST newStatementStringPropertySetter() {
      return new StatementStringPropertySetterST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 

   public final class AttributeRendererDeclarationST implements TemplateGroupGroupTemplate {

      private final ST template;

      private AttributeRendererDeclarationST(STGroup group) {
   		template = group.getInstanceOf("AttributeRendererDeclaration");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class GroupClassDeclarationST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupStringIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private GroupClassDeclarationST(STGroup group) {
   		template = group.getInstanceOf("GroupClassDeclaration");
   	}

       public GroupClassDeclarationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public GroupClassDeclarationST setGroupString(Object value) {
      	tryToSetStringProperty(template, value, groupStringIsSet, "groupString");   
         return this;
      } 
       public GroupClassDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public GroupClassDeclarationST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public GroupClassDeclarationST addStatementsValue(Object declaration_, Object newInstance_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{declaration, newInstance}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (newInstance_==null || newInstance_.toString().length()==0) ? null : newInstance_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class NewGroupInstanceST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean filenameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewGroupInstanceST(STGroup group) {
   		template = group.getInstanceOf("NewGroupInstance");
   	}

       public NewGroupInstanceST setFilename(Object value) {
      	tryToSetStringProperty(template, value, filenameIsSet, "filename");   
         return this;
      } 
       public NewGroupInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class NewStatementDeclarationST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean groupnameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewStatementDeclarationST(STGroup group) {
   		template = group.getInstanceOf("NewStatementDeclaration");
   	}

       public NewStatementDeclarationST setGroupname(Object value) {
      	tryToSetStringProperty(template, value, groupnameIsSet, "groupname");   
         return this;
      } 
       public NewStatementDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public NewStatementDeclarationST addPropertiesValue(Object name_, Object setter_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, setter}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (setter_==null || setter_.toString().length()==0) ? null : setter_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class NewStatementInstanceST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NewStatementInstanceST(STGroup group) {
   		template = group.getInstanceOf("NewStatementInstance");
   	}

       public NewStatementInstanceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StatementKeyValueListPropertySetterST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean kvNamesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementKeyValueListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementKeyValueListPropertySetter");
   	}

      public StatementKeyValueListPropertySetterST addKvNamesValue(Object value) {
      	tryToSetListProperty(template, value, kvNamesIsSet, "kvNames");
         return this;
      }
       public StatementKeyValueListPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementKeyValueListPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StatementListPropertySetterST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementListPropertySetter");
   	}

       public StatementListPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementListPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class StatementStringPropertySetterST implements TemplateGroupGroupTemplate {

      private final AtomicBoolean propertyNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private StatementStringPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementStringPropertySetter");
   	}

       public StatementStringPropertySetterST setPropertyName(Object value) {
      	tryToSetStringProperty(template, value, propertyNameIsSet, "propertyName");   
         return this;
      } 
       public StatementStringPropertySetterST setStatementName(Object value) {
      	tryToSetStringProperty(template, value, statementNameIsSet, "statementName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements TemplateGroupGroupTemplate {

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

	public static final STGroup groupString = new org.stringtemplate.v4.STGroupString("easyFlow", "/* easyFlow aa407cd5-7e0c-4b25-9d63-52815c1d03f2*/\n" +
		"delimiters \"~\", \"~\"\n" +
		"\n" +
		"bugfix() ::= <<} >>\n" +
		"\n" +
		"declaration(name,state) ::= <<.whenEnter(~state~, new ContextHandler<~name~Context>() {\n" +
		"    @Override\n" +
		"    public void call(final ~name~Context context) throws Exception {\n" +
		"        //log.debug(\"~state;format=\"humpToCap\"~\");\n" +
		"        if (listener != null) listener.onEnter(\"~state~\", context);\n" +
		"        ~state;format=\"toLower\"~(context);\n" +
		"    }\n" +
		"}) >>\n" +
		"\n" +
		"easyFlow(extends,name,package,startState,superParams,events,transitions,properties,states) ::= <<~if(package)~package ~package~;\n" +
		"\n" +
		"~endif~import au.com.ds.ef.*;\n" +
		"import au.com.ds.ef.call.ContextHandler;\n" +
		"import au.com.ds.ef.call.ExecutionErrorHandler;\n" +
		"import au.com.ds.ef.err.ExecutionError;\n" +
		"\n" +
		"import org.slf4j.Logger;\n" +
		"import org.slf4j.LoggerFactory;\n" +
		"\n" +
		"import static au.com.ds.ef.FlowBuilder.*;\n" +
		"import static ~package~.~name~.States.*;\n" +
		"import static ~package~.~name~.Events.*;\n" +
		"\n" +
		"/**\n" +
		" * http://datasymphony.com.au/open-source/easyflow/\n" +
		" */\n" +
		"public abstract class ~name~ ~if(extends)~extends ~extends~ ~endif~{\n" +
		"\n" +
		"   protected static final Logger log = LoggerFactory.getLogger(~name~.class);\n" +
		"\n" +
		"   static class ~name~Context extends StatefulContext {\n" +
		"\t\t~properties:{it|~if(it.modifier)~~it.modifier~ ~endif~~it.type~ ~it.name~~if(it.value)~ = ~it.value~~endif~;~if(it.comment)~ //~it.comment~~endif~};separator=\"\\n\"~\n" +
		"\t}\n" +
		"\n" +
		"   enum States implements StateEnum {\n" +
		"   \t~states:{it|~it.name~};separator=\",\\n\"~\n" +
		"\t}\n" +
		"\n" +
		"\tenum Events implements EventEnum {\n" +
		"   \t~events:{it|~it.name~};separator=\",\\n\"~\n" +
		"\t}\n" +
		"\n" +
		"    /** ~name~Listener  **/\n" +
		"    public interface ~name~Listener {\n" +
		"        void onEnter(String state, ~name~Context context);\n" +
		"        void onError(ExecutionError error, StatefulContext context);\n" +
		"    }\n" +
		"\n" +
		"    private final EasyFlow<~name~Context> fsm;\n" +
		"    protected ~name~Listener listener;\n" +
		"\n" +
		"    public ~name~(~superParams:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" +
		"        super(~superParams:{it|~it.name~};separator=\", \"~);\n" +
		"\n" +
		"        // states and transitions:\n" +
		"        this.fsm = from(~startState~).transit(~transitions:{it|~it~};separator=\"\\n\"~);\n" +
		"\n" +
		"        // binding:\n" +
		"        this.fsm\n" +
		"            .executor(new SyncExecutor())\n" +
		"\t\t\t~states:{it|\n" +
		"\t.whenEnter(~it.name~, new ContextHandler<~name~Context>() {\n" +
		"   \t@Override\n" +
		"\t\tpublic void call(final ~name~Context context) throws Exception {\n" +
		"      \t//log.debug(\"~it.name;format=\"humpToCap\"~\");\n" +
		"      \tif (listener != null) listener.onEnter(\"~it.name~\", context);\n" +
		"        \thandle~it.name;format=\"capitalize\"~(context);\n" +
		"    \t~bugfix()~\n" +
		"\t~bugfix()~)};separator=\"\\n\"~\n" +
		"            .whenError(new ExecutionErrorHandler<StatefulContext>() {\n" +
		"                @Override\n" +
		"                public void call(ExecutionError error, StatefulContext context) {\n" +
		"                    log.info(\"ERROR\");\n" +
		"                    if (listener != null) listener.onError(error, context);\n" +
		"                    onERROR(error,context);\n" +
		"                    }\n" +
		"                });\n" +
		"    }\n" +
		"\n" +
		"    public void start(final ~name~Context context) {\n" +
		"        this.fsm.start(context);\n" +
		"    }\n" +
		"\n" +
		"    public void start(final ~name~Context context, ~name~Listener listener) {\n" +
		"        this.listener = listener;\n" +
		"        this.fsm.start(context);\n" +
		"    }\n" +
		"\n" +
		"    ~states:{it|protected abstract void handle~it.name;format=\"capitalize\"~(final ~name~Context context) throws Exception;};separator=\"\\n\"~\n" +
		"\n" +
		"    protected abstract void onERROR(final ExecutionError error, final StatefulContext context);\n" +
		"}>>\n" +
		"\n" +
		"dependency() ::= <<<dependency>\n" +
		"\t<groupId>au.com.datasymphony</groupId>\n" +
		"   <artifactId>EasyFlow</artifactId>\n" +
		"   <version>1.3</version>\n" +
		"</dependency> >>\n" +
		"\n" +
		"impl(name,state) ::= <<protected abstract void ~state;format=\"toLower\"~(final ~name~Context context) throws Exception;>>\n" +
		"\n" +
		"transit(event,state,transits,finalState) ::= <<on(~event~).~if(finalState)~finish~else~to~endif~(~state~)~if(transits)~.\n" +
		"\ttransit(~transits:{it|~it~};separator=\",\\n\"~\n" +
		"\t)~endif~>>", '~', '~');
} 