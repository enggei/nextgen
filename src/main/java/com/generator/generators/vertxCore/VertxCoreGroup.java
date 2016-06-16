 package com.generator.generators.vertxCore;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'VertxCoreGroup.stg' file<br/>
 */
public final class VertxCoreGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public VertxCoreGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "vertxCore" + java.io.File.separator + "vertxCore.stg"));
   }

   public VertxCoreGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public VertxCoreGroup(java.io.File templateFile) {
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


   public MessageHandlerVerticleST newMessageHandlerVerticle() {
      return new MessageHandlerVerticleST(stGroup);
   } 


   public blockingCodeST newblockingCode() {
      return new blockingCodeST(stGroup);
   } 


   public clientRequestST newclientRequest() {
      return new clientRequestST(stGroup);
   } 


   public deployVerticleProgrammaticallyST newdeployVerticleProgrammatically() {
      return new deployVerticleProgrammaticallyST(stGroup);
   } 


   public deployVerticleStartST newdeployVerticleStart() {
      return new deployVerticleStartST(stGroup);
   } 


   public ebConsumeST newebConsume() {
      return new ebConsumeST(stGroup);
   } 


   public ebPublishST newebPublish() {
      return new ebPublishST(stGroup);
   } 


   public getIntegerST newgetInteger() {
      return new getIntegerST(stGroup);
   } 


   public getJsonST newgetJson() {
      return new getJsonST(stGroup);
   } 


   public getStringST newgetString() {
      return new getStringST(stGroup);
   } 


   public httpClientST newhttpClient() {
      return new httpClientST(stGroup);
   } 


   public httpClientOptionsST newhttpClientOptions() {
      return new httpClientOptionsST(stGroup);
   } 


   public jsonST newjson() {
      return new jsonST(stGroup);
   } 


   public jsonFromStringST newjsonFromString() {
      return new jsonFromStringST(stGroup);
   } 


   public periodicTimerST newperiodicTimer() {
      return new periodicTimerST(stGroup);
   } 


   public runinContextST newruninContext() {
      return new runinContextST(stGroup);
   } 


   public verticleST newverticle() {
      return new verticleST(stGroup);
   } 


   public vertxST newvertx() {
      return new vertxST(stGroup);
   } 


   public vertxOptionsST newvertxOptions() {
      return new vertxOptionsST(stGroup);
   } 

    public final class MessageHandlerVerticleST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private MessageHandlerVerticleST(STGroup group) {
   		template = group.getInstanceOf("MessageHandlerVerticle");
   	}

       public MessageHandlerVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public MessageHandlerVerticleST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
       public MessageHandlerVerticleST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class blockingCodeST {

      private final AtomicBoolean resultIsSet = new AtomicBoolean(false);
      private final AtomicBoolean resultHandlerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private blockingCodeST(STGroup group) {
   		template = group.getInstanceOf("blockingCode");
   	}

       public blockingCodeST setResult(Object value) {
      	tryToSetStringProperty(template, value, resultIsSet, "result");   
         return this;
      } 
       public blockingCodeST setResultHandler(Object value) {
      	tryToSetStringProperty(template, value, resultHandlerIsSet, "resultHandler");   
         return this;
      } 
      public blockingCodeST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class clientRequestST {

      private final AtomicBoolean clientIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean handleBodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean handleResponseIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean httpMethodIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uriIsSet = new AtomicBoolean(false);
      private final ST template;

      private clientRequestST(STGroup group) {
   		template = group.getInstanceOf("clientRequest");
   	}

       public clientRequestST setClient(Object value) {
      	tryToSetStringProperty(template, value, clientIsSet, "client");   
         return this;
      } 
       public clientRequestST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      } 
       public clientRequestST setHandleBody(Object value) {
      	tryToSetStringProperty(template, value, handleBodyIsSet, "handleBody");   
         return this;
      } 
       public clientRequestST setHandleResponse(Object value) {
      	tryToSetStringProperty(template, value, handleResponseIsSet, "handleResponse");   
         return this;
      } 
      public clientRequestST addHeadersValue(Object name_, Object value_) {
         headersIsSet.set(true);
         template.addAggr("headers.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
       public clientRequestST setHttpMethod(Object value) {
      	tryToSetStringProperty(template, value, httpMethodIsSet, "httpMethod");   
         return this;
      } 
       public clientRequestST setUri(Object value) {
      	tryToSetStringProperty(template, value, uriIsSet, "uri");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class deployVerticleProgrammaticallyST {

      private final AtomicBoolean onFailIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onSuccessIsSet = new AtomicBoolean(false);
      private final AtomicBoolean optionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private deployVerticleProgrammaticallyST(STGroup group) {
   		template = group.getInstanceOf("deployVerticleProgrammatically");
   	}

       public deployVerticleProgrammaticallyST setOnFail(Object value) {
      	tryToSetStringProperty(template, value, onFailIsSet, "onFail");   
         return this;
      } 
       public deployVerticleProgrammaticallyST setOnSuccess(Object value) {
      	tryToSetStringProperty(template, value, onSuccessIsSet, "onSuccess");   
         return this;
      } 
       public deployVerticleProgrammaticallyST setOptions(Object value) {
      	tryToSetStringProperty(template, value, optionsIsSet, "options");   
         return this;
      } 
       public deployVerticleProgrammaticallyST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public deployVerticleProgrammaticallyST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class deployVerticleStartST {

      private final AtomicBoolean configIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onSuccessIsSet = new AtomicBoolean(false);
      private final ST template;

      private deployVerticleStartST(STGroup group) {
   		template = group.getInstanceOf("deployVerticleStart");
   	}

       public deployVerticleStartST setConfig(Object value) {
      	tryToSetStringProperty(template, value, configIsSet, "config");   
         return this;
      } 
       public deployVerticleStartST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public deployVerticleStartST setOnSuccess(Object value) {
      	tryToSetStringProperty(template, value, onSuccessIsSet, "onSuccess");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class ebConsumeST {

      private final AtomicBoolean addressIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onMessageIsSet = new AtomicBoolean(false);
      private final ST template;

      private ebConsumeST(STGroup group) {
   		template = group.getInstanceOf("ebConsume");
   	}

       public ebConsumeST setAddress(Object value) {
      	tryToSetStringProperty(template, value, addressIsSet, "address");   
         return this;
      } 
       public ebConsumeST setOnMessage(Object value) {
      	tryToSetStringProperty(template, value, onMessageIsSet, "onMessage");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class ebPublishST {

      private final AtomicBoolean addressIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private ebPublishST(STGroup group) {
   		template = group.getInstanceOf("ebPublish");
   	}

       public ebPublishST setAddress(Object value) {
      	tryToSetStringProperty(template, value, addressIsSet, "address");   
         return this;
      } 
       public ebPublishST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class getIntegerST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private getIntegerST(STGroup group) {
   		template = group.getInstanceOf("getInteger");
   	}

       public getIntegerST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public getIntegerST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class getJsonST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private getJsonST(STGroup group) {
   		template = group.getInstanceOf("getJson");
   	}

       public getJsonST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public getJsonST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public getJsonST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class getStringST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private getStringST(STGroup group) {
   		template = group.getInstanceOf("getString");
   	}

       public getStringST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public getStringST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class httpClientST {

      private final AtomicBoolean clientOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private httpClientST(STGroup group) {
   		template = group.getInstanceOf("httpClient");
   	}

       public httpClientST setClientOptions(Object value) {
      	tryToSetStringProperty(template, value, clientOptionsIsSet, "clientOptions");   
         return this;
      } 
       public httpClientST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class httpClientOptionsST {

      private final AtomicBoolean connectTimeoutIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultHostIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultPortIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idleTimeoutIsSet = new AtomicBoolean(false);
      private final AtomicBoolean keepAliveIsSet = new AtomicBoolean(false);
      private final AtomicBoolean keyStoreOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxPoolSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxWebsocketFrameSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pemKeyCertOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pemTrustOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pfxKeycertOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pfxTrustOptionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pipeliningIsSet = new AtomicBoolean(false);
      private final AtomicBoolean protocolVersionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean receiveBufferSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean reuseAddressIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sendBufferSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean soLingerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sslIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tcpKeepAliveIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tcpNoDelayIsSet = new AtomicBoolean(false);
      private final AtomicBoolean trafficClassIsSet = new AtomicBoolean(false);
      private final AtomicBoolean trustAllIsSet = new AtomicBoolean(false);
      private final AtomicBoolean trustStoreIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tryUseCompressionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean usePooledBuffersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean verifyHostIsSet = new AtomicBoolean(false);
      private final ST template;

      private httpClientOptionsST(STGroup group) {
   		template = group.getInstanceOf("httpClientOptions");
   	}

       public httpClientOptionsST setConnectTimeout(Object value) {
      	tryToSetStringProperty(template, value, connectTimeoutIsSet, "connectTimeout");   
         return this;
      } 
       public httpClientOptionsST setDefaultHost(Object value) {
      	tryToSetStringProperty(template, value, defaultHostIsSet, "defaultHost");   
         return this;
      } 
       public httpClientOptionsST setDefaultPort(Object value) {
      	tryToSetStringProperty(template, value, defaultPortIsSet, "defaultPort");   
         return this;
      } 
       public httpClientOptionsST setIdleTimeout(Object value) {
      	tryToSetStringProperty(template, value, idleTimeoutIsSet, "idleTimeout");   
         return this;
      } 
       public httpClientOptionsST setKeepAlive(Object value) {
      	tryToSetStringProperty(template, value, keepAliveIsSet, "keepAlive");   
         return this;
      } 
       public httpClientOptionsST setKeyStoreOptions(Object value) {
      	tryToSetStringProperty(template, value, keyStoreOptionsIsSet, "keyStoreOptions");   
         return this;
      } 
       public httpClientOptionsST setMaxPoolSize(Object value) {
      	tryToSetStringProperty(template, value, maxPoolSizeIsSet, "maxPoolSize");   
         return this;
      } 
       public httpClientOptionsST setMaxWebsocketFrameSize(Object value) {
      	tryToSetStringProperty(template, value, maxWebsocketFrameSizeIsSet, "maxWebsocketFrameSize");   
         return this;
      } 
       public httpClientOptionsST setPemKeyCertOptions(Object value) {
      	tryToSetStringProperty(template, value, pemKeyCertOptionsIsSet, "pemKeyCertOptions");   
         return this;
      } 
       public httpClientOptionsST setPemTrustOptions(Object value) {
      	tryToSetStringProperty(template, value, pemTrustOptionsIsSet, "pemTrustOptions");   
         return this;
      } 
       public httpClientOptionsST setPfxKeycertOptions(Object value) {
      	tryToSetStringProperty(template, value, pfxKeycertOptionsIsSet, "pfxKeycertOptions");   
         return this;
      } 
       public httpClientOptionsST setPfxTrustOptions(Object value) {
      	tryToSetStringProperty(template, value, pfxTrustOptionsIsSet, "pfxTrustOptions");   
         return this;
      } 
       public httpClientOptionsST setPipelining(Object value) {
      	tryToSetStringProperty(template, value, pipeliningIsSet, "pipelining");   
         return this;
      } 
       public httpClientOptionsST setProtocolVersion(Object value) {
      	tryToSetStringProperty(template, value, protocolVersionIsSet, "protocolVersion");   
         return this;
      } 
       public httpClientOptionsST setReceiveBufferSize(Object value) {
      	tryToSetStringProperty(template, value, receiveBufferSizeIsSet, "receiveBufferSize");   
         return this;
      } 
       public httpClientOptionsST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public httpClientOptionsST setReuseAddress(Object value) {
      	tryToSetStringProperty(template, value, reuseAddressIsSet, "reuseAddress");   
         return this;
      } 
       public httpClientOptionsST setSendBufferSize(Object value) {
      	tryToSetStringProperty(template, value, sendBufferSizeIsSet, "sendBufferSize");   
         return this;
      } 
       public httpClientOptionsST setSoLinger(Object value) {
      	tryToSetStringProperty(template, value, soLingerIsSet, "soLinger");   
         return this;
      } 
       public httpClientOptionsST setSsl(Object value) {
      	tryToSetStringProperty(template, value, sslIsSet, "ssl");   
         return this;
      } 
       public httpClientOptionsST setTcpKeepAlive(Object value) {
      	tryToSetStringProperty(template, value, tcpKeepAliveIsSet, "tcpKeepAlive");   
         return this;
      } 
       public httpClientOptionsST setTcpNoDelay(Object value) {
      	tryToSetStringProperty(template, value, tcpNoDelayIsSet, "tcpNoDelay");   
         return this;
      } 
       public httpClientOptionsST setTrafficClass(Object value) {
      	tryToSetStringProperty(template, value, trafficClassIsSet, "trafficClass");   
         return this;
      } 
       public httpClientOptionsST setTrustAll(Object value) {
      	tryToSetStringProperty(template, value, trustAllIsSet, "trustAll");   
         return this;
      } 
       public httpClientOptionsST setTrustStore(Object value) {
      	tryToSetStringProperty(template, value, trustStoreIsSet, "trustStore");   
         return this;
      } 
       public httpClientOptionsST setTryUseCompression(Object value) {
      	tryToSetStringProperty(template, value, tryUseCompressionIsSet, "tryUseCompression");   
         return this;
      } 
       public httpClientOptionsST setUsePooledBuffers(Object value) {
      	tryToSetStringProperty(template, value, usePooledBuffersIsSet, "usePooledBuffers");   
         return this;
      } 
       public httpClientOptionsST setVerifyHost(Object value) {
      	tryToSetStringProperty(template, value, verifyHostIsSet, "verifyHost");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class jsonST {

      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private jsonST(STGroup group) {
   		template = group.getInstanceOf("json");
   	}

       public jsonST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
      public jsonST addValuesValue(Object key_, Object value_) {
         valuesIsSet.set(true);
         template.addAggr("values.{key, value}", ( (key_==null || key_.toString().length()==0) ? null : key_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class jsonFromStringST {

      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stringIsSet = new AtomicBoolean(false);
      private final ST template;

      private jsonFromStringST(STGroup group) {
   		template = group.getInstanceOf("jsonFromString");
   	}

       public jsonFromStringST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public jsonFromStringST setString(Object value) {
      	tryToSetStringProperty(template, value, stringIsSet, "string");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class periodicTimerST {

      private final AtomicBoolean msIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private periodicTimerST(STGroup group) {
   		template = group.getInstanceOf("periodicTimer");
   	}

       public periodicTimerST setMs(Object value) {
      	tryToSetStringProperty(template, value, msIsSet, "ms");   
         return this;
      } 
       public periodicTimerST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
      public periodicTimerST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class runinContextST {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private runinContextST(STGroup group) {
   		template = group.getInstanceOf("runinContext");
   	}

      public runinContextST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class verticleST {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean startStatementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stopStatementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean verticlesIsSet = new AtomicBoolean(false);
      private final ST template;

      private verticleST(STGroup group) {
   		template = group.getInstanceOf("verticle");
   	}

      public verticleST addFieldsValue(Object value) {
      	tryToSetListProperty(template, value, fieldsIsSet, "fields");
         return this;
      }
      public verticleST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
       public verticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public verticleST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public verticleST addStartStatementsValue(Object value) {
      	tryToSetListProperty(template, value, startStatementsIsSet, "startStatements");
         return this;
      }
      public verticleST addStopStatementsValue(Object value) {
      	tryToSetListProperty(template, value, stopStatementsIsSet, "stopStatements");
         return this;
      }
      public verticleST addVerticlesValue(Object deploy_) {
         verticlesIsSet.set(true);
         template.addAggr("verticles.{deploy}", ( (deploy_==null || deploy_.toString().length()==0) ? null : deploy_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class vertxST {

      private final AtomicBoolean optionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private vertxST(STGroup group) {
   		template = group.getInstanceOf("vertx");
   	}

       public vertxST setOptions(Object value) {
      	tryToSetStringProperty(template, value, optionsIsSet, "options");   
         return this;
      } 
       public vertxST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class vertxOptionsST {

      private final AtomicBoolean blockedThreadCheckIntervalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterHostIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterManagerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterPingIntervalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterPingReplyIntervalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterPortIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterPublicHostIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusterPublicPortIsSet = new AtomicBoolean(false);
      private final AtomicBoolean clusteredIsSet = new AtomicBoolean(false);
      private final AtomicBoolean eventLoopPoolSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean haEnabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean haGroupIsSet = new AtomicBoolean(false);
      private final AtomicBoolean internalBlockingPoolSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxEventLoopExecuteTimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxWorkerExecuteTimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean metricsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean quorumSizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean warningExceptionTimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean workerPoolSizeIsSet = new AtomicBoolean(false);
      private final ST template;

      private vertxOptionsST(STGroup group) {
   		template = group.getInstanceOf("vertxOptions");
   	}

       public vertxOptionsST setBlockedThreadCheckInterval(Object value) {
      	tryToSetStringProperty(template, value, blockedThreadCheckIntervalIsSet, "blockedThreadCheckInterval");   
         return this;
      } 
       public vertxOptionsST setClusterHost(Object value) {
      	tryToSetStringProperty(template, value, clusterHostIsSet, "clusterHost");   
         return this;
      } 
       public vertxOptionsST setClusterManager(Object value) {
      	tryToSetStringProperty(template, value, clusterManagerIsSet, "clusterManager");   
         return this;
      } 
       public vertxOptionsST setClusterPingInterval(Object value) {
      	tryToSetStringProperty(template, value, clusterPingIntervalIsSet, "clusterPingInterval");   
         return this;
      } 
       public vertxOptionsST setClusterPingReplyInterval(Object value) {
      	tryToSetStringProperty(template, value, clusterPingReplyIntervalIsSet, "clusterPingReplyInterval");   
         return this;
      } 
       public vertxOptionsST setClusterPort(Object value) {
      	tryToSetStringProperty(template, value, clusterPortIsSet, "clusterPort");   
         return this;
      } 
       public vertxOptionsST setClusterPublicHost(Object value) {
      	tryToSetStringProperty(template, value, clusterPublicHostIsSet, "clusterPublicHost");   
         return this;
      } 
       public vertxOptionsST setClusterPublicPort(Object value) {
      	tryToSetStringProperty(template, value, clusterPublicPortIsSet, "clusterPublicPort");   
         return this;
      } 
       public vertxOptionsST setClustered(Object value) {
      	tryToSetStringProperty(template, value, clusteredIsSet, "clustered");   
         return this;
      } 
       public vertxOptionsST setEventLoopPoolSize(Object value) {
      	tryToSetStringProperty(template, value, eventLoopPoolSizeIsSet, "eventLoopPoolSize");   
         return this;
      } 
       public vertxOptionsST setHaEnabled(Object value) {
      	tryToSetStringProperty(template, value, haEnabledIsSet, "haEnabled");   
         return this;
      } 
       public vertxOptionsST setHaGroup(Object value) {
      	tryToSetStringProperty(template, value, haGroupIsSet, "haGroup");   
         return this;
      } 
       public vertxOptionsST setInternalBlockingPoolSize(Object value) {
      	tryToSetStringProperty(template, value, internalBlockingPoolSizeIsSet, "internalBlockingPoolSize");   
         return this;
      } 
       public vertxOptionsST setMaxEventLoopExecuteTime(Object value) {
      	tryToSetStringProperty(template, value, maxEventLoopExecuteTimeIsSet, "maxEventLoopExecuteTime");   
         return this;
      } 
       public vertxOptionsST setMaxWorkerExecuteTime(Object value) {
      	tryToSetStringProperty(template, value, maxWorkerExecuteTimeIsSet, "maxWorkerExecuteTime");   
         return this;
      } 
       public vertxOptionsST setMetrics(Object value) {
      	tryToSetStringProperty(template, value, metricsIsSet, "metrics");   
         return this;
      } 
       public vertxOptionsST setQuorumSize(Object value) {
      	tryToSetStringProperty(template, value, quorumSizeIsSet, "quorumSize");   
         return this;
      } 
       public vertxOptionsST setWarningExceptionTime(Object value) {
      	tryToSetStringProperty(template, value, warningExceptionTimeIsSet, "warningExceptionTime");   
         return this;
      } 
       public vertxOptionsST setWorkerPoolSize(Object value) {
      	tryToSetStringProperty(template, value, workerPoolSizeIsSet, "workerPoolSize");   
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