package com.generator.generators.raml;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'RamlGroup.stg' file<br/>
 */
public final class RamlGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public RamlGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "raml" + java.io.File.separator + "raml.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(RamlGroup.class.getResource("/com/generator/generators/raml/raml.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "raml" + java.io.File.separator + "raml.stg"));
   }

   public RamlGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public RamlGroup(java.io.File templateFile) {
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


   public booleanParamST newbooleanParam() {
      return new booleanParamST(stGroup);
   } 


   public dateParamST newdateParam() {
      return new dateParamST(stGroup);
   } 


   public deleteActionST newdeleteAction() {
      return new deleteActionST(stGroup);
   } 


   public endpointST newendpoint() {
      return new endpointST(stGroup);
   } 


   public errorResponseST newerrorResponse() {
      return new errorResponseST(stGroup);
   } 


   public fileST newfile() {
      return new fileST(stGroup);
   } 


   public fileParamST newfileParam() {
      return new fileParamST(stGroup);
   } 


   public formBodyST newformBody() {
      return new formBodyST(stGroup);
   } 


   public getActionST newgetAction() {
      return new getActionST(stGroup);
   } 


   public integerParamST newintegerParam() {
      return new integerParamST(stGroup);
   } 


   public jsonResponseST newjsonResponse() {
      return new jsonResponseST(stGroup);
   } 


   public mulitpartFormBodyST newmulitpartFormBody() {
      return new mulitpartFormBodyST(stGroup);
   } 


   public numberParamST newnumberParam() {
      return new numberParamST(stGroup);
   } 


   public postActionST newpostAction() {
      return new postActionST(stGroup);
   } 


   public putActionST newputAction() {
      return new putActionST(stGroup);
   } 


   public stringParamST newstringParam() {
      return new stringParamST(stGroup);
   } 


   public uriParameterST newuriParameter() {
      return new uriParameterST(stGroup);
   } 

    public final class booleanParamST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private booleanParamST(STGroup group) {
   		template = group.getInstanceOf("booleanParam");
   	}

       public booleanParamST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public booleanParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
       public booleanParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public booleanParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class dateParamST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean exampleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean patternIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private dateParamST(STGroup group) {
   		template = group.getInstanceOf("dateParam");
   	}

       public dateParamST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public dateParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
       public dateParamST setExample(Object value) {
      	tryToSetStringProperty(template, value, exampleIsSet, "example");   
         return this;
      } 
       public dateParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public dateParamST setPattern(Object value) {
      	tryToSetStringProperty(template, value, patternIsSet, "pattern");   
         return this;
      } 
       public dateParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class deleteActionST {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private deleteActionST(STGroup group) {
   		template = group.getInstanceOf("deleteAction");
   	}

       public deleteActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public deleteActionST addResponsesValue(Object value) {
      	tryToSetListProperty(template, value, responsesIsSet, "responses");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class endpointST {

      private final AtomicBoolean actionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriIsSet = new AtomicBoolean(false);
      private final ST template;

      private endpointST(STGroup group) {
   		template = group.getInstanceOf("endpoint");
   	}

      public endpointST addActionsValue(Object value) {
      	tryToSetListProperty(template, value, actionsIsSet, "actions");
         return this;
      }
       public endpointST setUri(Object value) {
      	tryToSetStringProperty(template, value, uriIsSet, "uri");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class errorResponseST {

      private final AtomicBoolean codeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final ST template;

      private errorResponseST(STGroup group) {
   		template = group.getInstanceOf("errorResponse");
   	}

       public errorResponseST setCode(Object value) {
      	tryToSetStringProperty(template, value, codeIsSet, "code");   
         return this;
      } 
       public errorResponseST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class fileST {

      private final AtomicBoolean baseUriIsSet = new AtomicBoolean(false);
      private final AtomicBoolean endpointsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean httpIsSet = new AtomicBoolean(false);
      private final AtomicBoolean httpsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private fileST(STGroup group) {
   		template = group.getInstanceOf("file");
   	}

       public fileST setBaseUri(Object value) {
      	tryToSetStringProperty(template, value, baseUriIsSet, "baseUri");   
         return this;
      } 
      public fileST addEndpointsValue(Object value) {
      	tryToSetListProperty(template, value, endpointsIsSet, "endpoints");
         return this;
      }
       public fileST setHttp(Object value) {
      	tryToSetStringProperty(template, value, httpIsSet, "http");   
         return this;
      } 
       public fileST setHttps(Object value) {
      	tryToSetStringProperty(template, value, httpsIsSet, "https");   
         return this;
      } 
       public fileST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      } 
       public fileST setVersion(Object value) {
      	tryToSetStringProperty(template, value, versionIsSet, "version");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class fileParamST {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private fileParamST(STGroup group) {
   		template = group.getInstanceOf("fileParam");
   	}

       public fileParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
       public fileParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public fileParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class formBodyST {

      private final AtomicBoolean formParamsIsSet = new AtomicBoolean(false);
      private final ST template;

      private formBodyST(STGroup group) {
   		template = group.getInstanceOf("formBody");
   	}

      public formBodyST addFormParamsValue(Object value) {
      	tryToSetListProperty(template, value, formParamsIsSet, "formParams");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class getActionST {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private getActionST(STGroup group) {
   		template = group.getInstanceOf("getAction");
   	}

       public getActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public getActionST addResponsesValue(Object value) {
      	tryToSetListProperty(template, value, responsesIsSet, "responses");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class integerParamST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean exampleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maximumIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minimumIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean repeatIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private integerParamST(STGroup group) {
   		template = group.getInstanceOf("integerParam");
   	}

       public integerParamST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public integerParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
       public integerParamST setExample(Object value) {
      	tryToSetStringProperty(template, value, exampleIsSet, "example");   
         return this;
      } 
       public integerParamST setMaximum(Object value) {
      	tryToSetStringProperty(template, value, maximumIsSet, "maximum");   
         return this;
      } 
       public integerParamST setMinimum(Object value) {
      	tryToSetStringProperty(template, value, minimumIsSet, "minimum");   
         return this;
      } 
       public integerParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public integerParamST setRepeat(Object value) {
      	tryToSetStringProperty(template, value, repeatIsSet, "repeat");   
         return this;
      } 
       public integerParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class jsonResponseST {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final AtomicBoolean schemaDescriptionIsSet = new AtomicBoolean(false);
      private final ST template;

      private jsonResponseST(STGroup group) {
   		template = group.getInstanceOf("jsonResponse");
   	}

      public jsonResponseST addPropertiesValue(Object name_, Object type_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public jsonResponseST addRequiredValue(Object value) {
      	tryToSetListProperty(template, value, requiredIsSet, "required");
         return this;
      }
       public jsonResponseST setSchemaDescription(Object value) {
      	tryToSetStringProperty(template, value, schemaDescriptionIsSet, "schemaDescription");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class mulitpartFormBodyST {

      private final AtomicBoolean formParamsIsSet = new AtomicBoolean(false);
      private final ST template;

      private mulitpartFormBodyST(STGroup group) {
   		template = group.getInstanceOf("mulitpartFormBody");
   	}

      public mulitpartFormBodyST addFormParamsValue(Object value) {
      	tryToSetListProperty(template, value, formParamsIsSet, "formParams");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class numberParamST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean exampleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maximumIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minimumIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean repeatIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private numberParamST(STGroup group) {
   		template = group.getInstanceOf("numberParam");
   	}

       public numberParamST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public numberParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
       public numberParamST setExample(Object value) {
      	tryToSetStringProperty(template, value, exampleIsSet, "example");   
         return this;
      } 
       public numberParamST setMaximum(Object value) {
      	tryToSetStringProperty(template, value, maximumIsSet, "maximum");   
         return this;
      } 
       public numberParamST setMinimum(Object value) {
      	tryToSetStringProperty(template, value, minimumIsSet, "minimum");   
         return this;
      } 
       public numberParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public numberParamST setRepeat(Object value) {
      	tryToSetStringProperty(template, value, repeatIsSet, "repeat");   
         return this;
      } 
       public numberParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class postActionST {

      private final AtomicBoolean bodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private postActionST(STGroup group) {
   		template = group.getInstanceOf("postAction");
   	}

       public postActionST setBody(Object value) {
      	tryToSetStringProperty(template, value, bodyIsSet, "body");   
         return this;
      } 
       public postActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public postActionST addResponsesValue(Object value) {
      	tryToSetListProperty(template, value, responsesIsSet, "responses");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class putActionST {

      private final AtomicBoolean bodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private putActionST(STGroup group) {
   		template = group.getInstanceOf("putAction");
   	}

       public putActionST setBody(Object value) {
      	tryToSetStringProperty(template, value, bodyIsSet, "body");   
         return this;
      } 
       public putActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public putActionST addResponsesValue(Object value) {
      	tryToSetListProperty(template, value, responsesIsSet, "responses");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class stringParamST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean enumsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean exampleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxLengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minLengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean patternIsSet = new AtomicBoolean(false);
      private final AtomicBoolean repeatIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringParamST(STGroup group) {
   		template = group.getInstanceOf("stringParam");
   	}

       public stringParamST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public stringParamST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      } 
      public stringParamST addEnumsValue(Object value) {
      	tryToSetListProperty(template, value, enumsIsSet, "enums");
         return this;
      }
       public stringParamST setExample(Object value) {
      	tryToSetStringProperty(template, value, exampleIsSet, "example");   
         return this;
      } 
       public stringParamST setMaxLength(Object value) {
      	tryToSetStringProperty(template, value, maxLengthIsSet, "maxLength");   
         return this;
      } 
       public stringParamST setMinLength(Object value) {
      	tryToSetStringProperty(template, value, minLengthIsSet, "minLength");   
         return this;
      } 
       public stringParamST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public stringParamST setPattern(Object value) {
      	tryToSetStringProperty(template, value, patternIsSet, "pattern");   
         return this;
      } 
       public stringParamST setRepeat(Object value) {
      	tryToSetStringProperty(template, value, repeatIsSet, "repeat");   
         return this;
      } 
       public stringParamST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class uriParameterST {

      private final AtomicBoolean actionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private uriParameterST(STGroup group) {
   		template = group.getInstanceOf("uriParameter");
   	}

      public uriParameterST addActionsValue(Object value) {
      	tryToSetListProperty(template, value, actionsIsSet, "actions");
         return this;
      }
       public uriParameterST setName(Object value) {
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