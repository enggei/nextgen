package com.generator.generators.raml;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'raml.stg' file<br/>
 */
public final class RamlGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public RamlGroup() {
		this(new STGroupString(stg));
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

	public interface RamlGroupTemplate {

	}

   public numberParamST newnumberParam() {
      return new numberParamST(stGroup);
   }

   public binaryResponseST newbinaryResponse() {
      return new binaryResponseST(stGroup);
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

   public headerST newheader() {
      return new headerST(stGroup);
   }

   public headerParamsST newheaderParams() {
      return new headerParamsST(stGroup);
   }

   public integerParamST newintegerParam() {
      return new integerParamST(stGroup);
   }

   public jsonResponseST newjsonResponse() {
      return new jsonResponseST(stGroup);
   }

   public postActionST newpostAction() {
      return new postActionST(stGroup);
   }

   public putActionST newputAction() {
      return new putActionST(stGroup);
   }

   public queryParamsST newqueryParams() {
      return new queryParamsST(stGroup);
   }

   public stringParamST newstringParam() {
      return new stringParamST(stGroup);
   }

   public uriParamsST newuriParams() {
      return new uriParamsST(stGroup);
   }

   public final class numberParamST implements RamlGroupTemplate {

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

   public final class binaryResponseST implements RamlGroupTemplate {

      private final AtomicBoolean contentTypeIsSet = new AtomicBoolean(false);
      private final ST template;

      private binaryResponseST(STGroup group) {
   		template = group.getInstanceOf("binaryResponse");
   	}

      public binaryResponseST setContentType(Object value) {
      	tryToSetStringProperty(template, value, contentTypeIsSet, "contentType");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class booleanParamST implements RamlGroupTemplate {

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

   public final class dateParamST implements RamlGroupTemplate {

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

   public final class deleteActionST implements RamlGroupTemplate {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean queryIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private deleteActionST(STGroup group) {
   		template = group.getInstanceOf("deleteAction");
   	}

      public deleteActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      }
      public deleteActionST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public deleteActionST setQuery(Object value) {
      	tryToSetStringProperty(template, value, queryIsSet, "query");   
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

   public final class endpointST implements RamlGroupTemplate {

      private final AtomicBoolean actionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriParamsIsSet = new AtomicBoolean(false);
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
      public endpointST setUriParams(Object value) {
      	tryToSetStringProperty(template, value, uriParamsIsSet, "uriParams");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class errorResponseST implements RamlGroupTemplate {

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

   public final class fileST implements RamlGroupTemplate {

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

   public final class fileParamST implements RamlGroupTemplate {

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

   public final class formBodyST implements RamlGroupTemplate {

      private final AtomicBoolean formParamsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean multipartIsSet = new AtomicBoolean(false);
      private final ST template;

      private formBodyST(STGroup group) {
   		template = group.getInstanceOf("formBody");
   	}

      public formBodyST addFormParamsValue(Object value) {
      	tryToSetListProperty(template, value, formParamsIsSet, "formParams");
         return this;
      }
      public formBodyST setMultipart(Object value) {
      	tryToSetStringProperty(template, value, multipartIsSet, "multipart");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class getActionST implements RamlGroupTemplate {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean queryIsSet = new AtomicBoolean(false);
      private final AtomicBoolean responsesIsSet = new AtomicBoolean(false);
      private final ST template;

      private getActionST(STGroup group) {
   		template = group.getInstanceOf("getAction");
   	}

      public getActionST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      }
      public getActionST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public getActionST setQuery(Object value) {
      	tryToSetStringProperty(template, value, queryIsSet, "query");   
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

   public final class headerST implements RamlGroupTemplate {

      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean enumsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean exampleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private headerST(STGroup group) {
   		template = group.getInstanceOf("header");
   	}

      public headerST setDescription(Object value) {
      	tryToSetStringProperty(template, value, descriptionIsSet, "description");   
         return this;
      }
      public headerST addEnumsValue(Object value) {
      	tryToSetListProperty(template, value, enumsIsSet, "enums");
         return this;
      }
      public headerST setExample(Object value) {
      	tryToSetStringProperty(template, value, exampleIsSet, "example");   
         return this;
      }
      public headerST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public headerST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class headerParamsST implements RamlGroupTemplate {

      private final AtomicBoolean headerParamsIsSet = new AtomicBoolean(false);
      private final ST template;

      private headerParamsST(STGroup group) {
   		template = group.getInstanceOf("headerParams");
   	}

      public headerParamsST addHeaderParamsValue(Object value) {
      	tryToSetListProperty(template, value, headerParamsIsSet, "headerParams");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class integerParamST implements RamlGroupTemplate {

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

   public final class jsonResponseST implements RamlGroupTemplate {

      private final AtomicBoolean schemaDescriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final ST template;

      private jsonResponseST(STGroup group) {
   		template = group.getInstanceOf("jsonResponse");
   	}

      public jsonResponseST setSchemaDescription(Object value) {
      	tryToSetStringProperty(template, value, schemaDescriptionIsSet, "schemaDescription");   
         return this;
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class postActionST implements RamlGroupTemplate {

      private final AtomicBoolean bodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean queryIsSet = new AtomicBoolean(false);
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
      public postActionST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public postActionST setQuery(Object value) {
      	tryToSetStringProperty(template, value, queryIsSet, "query");   
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

   public final class putActionST implements RamlGroupTemplate {

      private final AtomicBoolean bodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean descriptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean queryIsSet = new AtomicBoolean(false);
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
      public putActionST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public putActionST setQuery(Object value) {
      	tryToSetStringProperty(template, value, queryIsSet, "query");   
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

   public final class queryParamsST implements RamlGroupTemplate {

      private final AtomicBoolean queryParamsIsSet = new AtomicBoolean(false);
      private final ST template;

      private queryParamsST(STGroup group) {
   		template = group.getInstanceOf("queryParams");
   	}

      public queryParamsST addQueryParamsValue(Object value) {
      	tryToSetListProperty(template, value, queryParamsIsSet, "queryParams");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class stringParamST implements RamlGroupTemplate {

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

   public final class uriParamsST implements RamlGroupTemplate {

      private final AtomicBoolean uriParamsIsSet = new AtomicBoolean(false);
      private final ST template;

      private uriParamsST(STGroup group) {
   		template = group.getInstanceOf("uriParams");
   	}

      public uriParamsST addUriParamsValue(Object value) {
      	tryToSetListProperty(template, value, uriParamsIsSet, "uriParams");
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

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "RamlGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("numberParam(defaultValue,description,example,maximum,minimum,name,repeat,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: number\n" + 
	"  ~if(minimum)~minimum: ~minimum~~else~# no minimum ~endif~\n" + 
	"  ~if(maximum)~maximum: ~maximum~~else~# no maximum ~endif~\n" + 
	"  ~if(example)~example: ~example~~else~# no example ~endif~\n" + 
	"  ~if(repeat)~repeat: ~repeat~~else~# no repeat ~endif~\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~\n" + 
	"  ~if(defaultValue)~default: ~defaultValue~~else~# no default ~endif~ >>\n")
		.append("binaryResponse(contentType) ::= <<200:\n" + 
	"  body:\n" + 
	"    ~contentType~: >>\n")
		.append("booleanParam(defaultValue,description,name,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: boolean\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~\n" + 
	"  ~if(defaultValue)~default: ~defaultValue~~else~# no default ~endif~ >>\n")
		.append("dateParam(defaultValue,description,example,name,pattern,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: date\n" + 
	"  ~if(pattern)~pattern: ~pattern~~else~# no pattern~endif~\n" + 
	"  ~if(example)~example: ~example~~else~# no date example ~endif~\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~\n" + 
	"  ~if(defaultValue)~default: ~defaultValue~~else~# no default ~endif~ >>\n")
		.append("deleteAction(description,headers,query,responses) ::= <<delete:\n" + 
	"  description: ~description~\n" + 
	"  ~query~\n" + 
	"  ~headers~\n" + 
	"  responses:\n" + 
	"    ~responses:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("endpoint(actions,uri,uriParams) ::= <<~uri~:\n" + 
	"  ~if(uriParams)~~uriParams~~endif~\n" + 
	"  ~actions:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("errorResponse(code,description) ::= <<~code~:\n" + 
	"  body:\n" + 
	"    application/json:\n" + 
	"      schema: |\n" + 
	"        { \"$schema\": \"http://json-schema.org/schema\",\n" + 
	"          \"type\": \"object\",\n" + 
	"          \"description\": \"~description~\",\n" + 
	"          \"properties\": {\n" + 
	"            \"STATUS\":  { \"type\": \"integer\" },\n" + 
	"            \"TYPE\":  { \"type\": \"string\" },\n" + 
	"            \"MESSAGE\":  { \"type\": \"string\" },\n" + 
	"            \"DETAILS\":  { \"type\": \"array\" }\n" + 
	"          },\n" + 
	"          \"required\": [ \"STATUS\",\"TYPE\" ]\n" + 
	"        } >>\n")
		.append("file(baseUri,endpoints,http,https,title,version) ::= <<#%RAML 0.8\n" + 
	"title: ~title~\n" + 
	"baseUri: ~baseUri~\n" + 
	"version: ~version~\n" + 
	"protocols: [~if(http)~ HTTP~endif~~if(https)~~if(http)~,~endif~HTTPS~endif~ ]\n" + 
	"~endpoints:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("fileParam(description,name,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: file\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~ >>\n")
		.append("formBody(formParams,multipart) ::= <<body:\n" + 
	"  ~if(multipart)~multipart/form-data~else~application/x-www-form-urlencoded~endif~:\n" + 
	"    formParameters:\n" + 
	"      ~formParams:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("getAction(description,headers,query,responses) ::= <<get:\n" + 
	"  description: ~description~\n" + 
	"  ~query~\n" + 
	"  ~headers~\n" + 
	"  responses:\n" + 
	"    ~responses:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("header(description,enums,example,name,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  ~if(enums)~enum: [~enums:{it|~it~};separator=\", \"~]~else~# no enums~endif~\n" + 
	"  ~if(example)~example: ~example~~else~# no example ~endif~\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~ >>\n")
		.append("headerParams(headerParams) ::= <<headers:\n" + 
	"  ~headerParams:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("integerParam(defaultValue,description,example,maximum,minimum,name,repeat,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: integer\n" + 
	"  ~if(minimum)~minimum: ~minimum~~else~# no minimum ~endif~\n" + 
	"  ~if(maximum)~maximum: ~maximum~~else~# no maximum ~endif~\n" + 
	"  ~if(example)~example: ~example~~else~# no example ~endif~\n" + 
	"  ~if(repeat)~repeat: ~repeat~~else~# no repeat ~endif~\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~\n" + 
	"  ~if(defaultValue)~default: ~defaultValue~~else~# no default ~endif~ >>\n")
		.append("jsonResponse(schemaDescription,properties,required) ::= <<200:\n" + 
	"  body:\n" + 
	"    application/json:\n" + 
	"      schema: |\n" + 
	"        { \"$schema\": \"http://json-schema.org/schema\",\n" + 
	"          \"type\": \"object\",\n" + 
	"          \"description\": \"~schemaDescription~\",\n" + 
	"          \"properties\": {\n" + 
	"            ~properties:{it|\"~it.name~\": { \"type\": \"~it.type~\" \\}};separator=\",\\n\"~\n" + 
	"          },\n" + 
	"          \"required\": [ ~required:{it|\"~it~\"};separator=\", \"~ ]\n" + 
	"        } >>\n")
		.append("postAction(body,description,headers,query,responses) ::= <<post:\n" + 
	"  description: ~description~\n" + 
	"  ~query~\n" + 
	"  ~headers~\n" + 
	"  ~body~\n" + 
	"  responses:\n" + 
	"      ~responses:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("putAction(body,description,headers,query,responses) ::= <<put:\n" + 
	"  description: ~description~\n" + 
	"  ~query~\n" + 
	"  ~headers~\n" + 
	"  ~body~\n" + 
	"  responses:\n" + 
	"      ~responses:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("queryParams(queryParams) ::= <<queryParameters:\n" + 
	"  ~queryParams:{it|~it~};separator=\"\\n\"~ >>\n")
		.append("stringParam(defaultValue,description,enums,example,maxLength,minLength,name,pattern,repeat,required) ::= <<~name~:\n" + 
	"  description: ~description~\n" + 
	"  type: string\n" + 
	"  ~if(enums)~enum: [~enums:{it|~it~};separator=\", \"~]~else~# no enums~endif~\n" + 
	"  ~if(pattern)~pattern: ~pattern~~else~# no pattern~endif~\n" + 
	"  ~if(minLength)~minLength: ~minLength~~else~# no min length~endif~\n" + 
	"  ~if(maxLength)~maxLength: ~maxLength~~else~# no max length~endif~\n" + 
	"  ~if(example)~example: ~example~~else~# no example ~endif~\n" + 
	"  ~if(repeat)~repeat: ~repeat~~else~# no repeat ~endif~\n" + 
	"  ~if(required)~required: true~else~# not required ~endif~\n" + 
	"  ~if(defaultValue)~default: ~defaultValue~~else~# no default ~endif~ >>\n")
		.append("uriParams(uriParams) ::= <<uriParameters:\n" + 
	"  ~uriParams:{it|~it~};separator=\"\\n\"~ >>\n").toString();
}