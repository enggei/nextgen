 package com.generator.generators.generatorDomain;

 import org.stringtemplate.v4.ST;
 import org.stringtemplate.v4.STGroup;

 import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'GeneratorDomainGroup.stg' file<br/>
 */
public final class GeneratorDomainGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public GeneratorDomainGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "generatorDomain" + java.io.File.separator + "generatorDomain.stg"));
   }

   public GeneratorDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public GeneratorDomainGroup(java.io.File templateFile) {
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


   public addEntityST newaddEntity() {
      return new addEntityST(stGroup);
   } 


   public addRelationST newaddRelation() {
      return new addRelationST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public defaultValueInitializationST newdefaultValueInitialization() {
      return new defaultValueInitializationST(stGroup);
   } 


   public defaultValuesST newdefaultValues() {
      return new defaultValuesST(stGroup);
   } 


   public defaultValuesAccessorST newdefaultValuesAccessor() {
      return new defaultValuesAccessorST(stGroup);
   } 


   public domainST newdomain() {
      return new domainST(stGroup);
   } 


   public editorST neweditor() {
      return new editorST(stGroup);
   } 


   public entityDeclarationST newentityDeclaration() {
      return new entityDeclarationST(stGroup);
   } 


   public entityEditorImplementationST newentityEditorImplementation() {
      return new entityEditorImplementationST(stGroup);
   } 


   public entityGraphNodeDeclarationST newentityGraphNodeDeclaration() {
      return new entityGraphNodeDeclarationST(stGroup);
   } 


   public entityGraphNodeImplementationST newentityGraphNodeImplementation() {
      return new entityGraphNodeImplementationST(stGroup);
   } 


   public entityRightClickST newentityRightClick() {
      return new entityRightClickST(stGroup);
   } 


   public graphEditorDeclarationST newgraphEditorDeclaration() {
      return new graphEditorDeclarationST(stGroup);
   } 


   public graphRelationDeclarationST newgraphRelationDeclaration() {
      return new graphRelationDeclarationST(stGroup);
   } 


   public graphRelationImplST newgraphRelationImpl() {
      return new graphRelationImplST(stGroup);
   } 


   public propertyInstantiationST newpropertyInstantiation() {
      return new propertyInstantiationST(stGroup);
   } 


   public propertyInstantiationLegalValuesST newpropertyInstantiationLegalValues() {
      return new propertyInstantiationLegalValuesST(stGroup);
   } 


   public relationDeclarationST newrelationDeclaration() {
      return new relationDeclarationST(stGroup);
   } 


   public termCaseST newtermCase() {
      return new termCaseST(stGroup);
   } 


   public termImplST newtermImpl() {
      return new termImplST(stGroup);
   } 


   public visitorST newvisitor() {
      return new visitorST(stGroup);
   } 

    public final class addEntityST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private addEntityST(STGroup group) {
   		template = group.getInstanceOf("addEntity");
   	}

       public addEntityST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public addEntityST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class addRelationST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dstIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final ST template;

      private addRelationST(STGroup group) {
   		template = group.getInstanceOf("addRelation");
   	}

       public addRelationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public addRelationST setDst(Object value) {
      	tryToSetStringProperty(template, value, dstIsSet, "dst");   
         return this;
      } 
       public addRelationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public addRelationST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }
       public addRelationST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
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

    public final class defaultValueInitializationST {

      private final AtomicBoolean keyValuesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean uuidIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueKeyIsSet = new AtomicBoolean(false);
      private final ST template;

      private defaultValueInitializationST(STGroup group) {
   		template = group.getInstanceOf("defaultValueInitialization");
   	}

      public defaultValueInitializationST addKeyValuesValue(Object name_, Object value_) {
         keyValuesIsSet.set(true);
         template.addAggr("keyValues.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
       public defaultValueInitializationST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 
       public defaultValueInitializationST setUuid(Object value) {
      	tryToSetStringProperty(template, value, uuidIsSet, "uuid");   
         return this;
      } 
       public defaultValueInitializationST setValueKey(Object value) {
      	tryToSetStringProperty(template, value, valueKeyIsSet, "valueKey");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class defaultValuesST {

      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private defaultValuesST(STGroup group) {
   		template = group.getInstanceOf("defaultValues");
   	}

      public defaultValuesST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class defaultValuesAccessorST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private defaultValuesAccessorST(STGroup group) {
   		template = group.getInstanceOf("defaultValuesAccessor");
   	}

       public defaultValuesAccessorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class domainST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean entitiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rootIsSet = new AtomicBoolean(false);
      private final ST template;

      private domainST(STGroup group) {
   		template = group.getInstanceOf("domain");
   	}

       public domainST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public domainST addEntitiesValue(Object add_, Object declaration_, Object defaultValueAccessor_, Object defaultValues_, Object name_) {
         entitiesIsSet.set(true);
         template.addAggr("entities.{add, declaration, defaultValueAccessor, defaultValues, name}", ( (add_==null || add_.toString().length()==0) ? null : add_), ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (defaultValueAccessor_==null || defaultValueAccessor_.toString().length()==0) ? null : defaultValueAccessor_), ( (defaultValues_==null || defaultValues_.toString().length()==0) ? null : defaultValues_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public domainST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public domainST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public domainST addRelationsValue(Object add_, Object declaration_, Object name_) {
         relationsIsSet.set(true);
         template.addAggr("relations.{add, declaration, name}", ( (add_==null || add_.toString().length()==0) ? null : add_), ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
       public domainST setRoot(Object value) {
      	tryToSetStringProperty(template, value, rootIsSet, "root");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class editorST {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean entitiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relationsIsSet = new AtomicBoolean(false);
      private final ST template;

      private editorST(STGroup group) {
   		template = group.getInstanceOf("editor");
   	}

       public editorST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public editorST addEntitiesValue(Object graphEditorDeclaration_, Object graphEditorImpl_, Object graphNodeDeclaration_, Object graphNodeImpl_, Object name_, Object onRightClick_) {
         entitiesIsSet.set(true);
         template.addAggr("entities.{graphEditorDeclaration, graphEditorImpl, graphNodeDeclaration, graphNodeImpl, name, onRightClick}", ( (graphEditorDeclaration_==null || graphEditorDeclaration_.toString().length()==0) ? null : graphEditorDeclaration_), ( (graphEditorImpl_==null || graphEditorImpl_.toString().length()==0) ? null : graphEditorImpl_), ( (graphNodeDeclaration_==null || graphNodeDeclaration_.toString().length()==0) ? null : graphNodeDeclaration_), ( (graphNodeImpl_==null || graphNodeImpl_.toString().length()==0) ? null : graphNodeImpl_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (onRightClick_==null || onRightClick_.toString().length()==0) ? null : onRightClick_));
         return this;
      }
       public editorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public editorST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public editorST addRelationsValue(Object graphRelationDeclaration_, Object graphRelationImpl_, Object name_) {
         relationsIsSet.set(true);
         template.addAggr("relations.{graphRelationDeclaration, graphRelationImpl, name}", ( (graphRelationDeclaration_==null || graphRelationDeclaration_.toString().length()==0) ? null : graphRelationDeclaration_), ( (graphRelationImpl_==null || graphRelationImpl_.toString().length()==0) ? null : graphRelationImpl_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class entityDeclarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityDeclarationST(STGroup group) {
   		template = group.getInstanceOf("entityDeclaration");
   	}

       public entityDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public entityDeclarationST addPropertiesValue(Object instantiation_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{instantiation}", ( (instantiation_==null || instantiation_.toString().length()==0) ? null : instantiation_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class entityEditorImplementationST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityEditorImplementationST(STGroup group) {
   		template = group.getInstanceOf("entityEditorImplementation");
   	}

       public entityEditorImplementationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public entityEditorImplementationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class entityGraphNodeDeclarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityGraphNodeDeclarationST(STGroup group) {
   		template = group.getInstanceOf("entityGraphNodeDeclaration");
   	}

       public entityGraphNodeDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class entityGraphNodeImplementationST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean gBackgroundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean gLabelColorIsSet = new AtomicBoolean(false);
      private final AtomicBoolean gSelBackgroundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean gSelLabelColorIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityGraphNodeImplementationST(STGroup group) {
   		template = group.getInstanceOf("entityGraphNodeImplementation");
   	}

       public entityGraphNodeImplementationST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public entityGraphNodeImplementationST setGBackground(Object value) {
      	tryToSetStringProperty(template, value, gBackgroundIsSet, "gBackground");   
         return this;
      } 
       public entityGraphNodeImplementationST setGLabelColor(Object value) {
      	tryToSetStringProperty(template, value, gLabelColorIsSet, "gLabelColor");   
         return this;
      } 
       public entityGraphNodeImplementationST setGSelBackground(Object value) {
      	tryToSetStringProperty(template, value, gSelBackgroundIsSet, "gSelBackground");   
         return this;
      } 
       public entityGraphNodeImplementationST setGSelLabelColor(Object value) {
      	tryToSetStringProperty(template, value, gSelLabelColorIsSet, "gSelLabelColor");   
         return this;
      } 
       public entityGraphNodeImplementationST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      } 
       public entityGraphNodeImplementationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public entityGraphNodeImplementationST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class entityRightClickST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityRightClickST(STGroup group) {
   		template = group.getInstanceOf("entityRightClick");
   	}

       public entityRightClickST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public entityRightClickST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class graphEditorDeclarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private graphEditorDeclarationST(STGroup group) {
   		template = group.getInstanceOf("graphEditorDeclaration");
   	}

       public graphEditorDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class graphRelationDeclarationST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private graphRelationDeclarationST(STGroup group) {
   		template = group.getInstanceOf("graphRelationDeclaration");
   	}

       public graphRelationDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class graphRelationImplST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private graphRelationImplST(STGroup group) {
   		template = group.getInstanceOf("graphRelationImpl");
   	}

       public graphRelationImplST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public graphRelationImplST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class propertyInstantiationST {

      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private propertyInstantiationST(STGroup group) {
   		template = group.getInstanceOf("propertyInstantiation");
   	}

       public propertyInstantiationST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
       public propertyInstantiationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public propertyInstantiationST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class propertyInstantiationLegalValuesST {

      private final AtomicBoolean legalValuesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private propertyInstantiationLegalValuesST(STGroup group) {
   		template = group.getInstanceOf("propertyInstantiationLegalValues");
   	}

      public propertyInstantiationLegalValuesST addLegalValuesValue(Object value) {
      	tryToSetListProperty(template, value, legalValuesIsSet, "legalValues");
         return this;
      }
       public propertyInstantiationLegalValuesST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public propertyInstantiationLegalValuesST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class relationDeclarationST {

      private final AtomicBoolean cardinalityIsSet = new AtomicBoolean(false);
      private final AtomicBoolean destinationIsSet = new AtomicBoolean(false);
      private final AtomicBoolean directionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sourceIsSet = new AtomicBoolean(false);
      private final ST template;

      private relationDeclarationST(STGroup group) {
   		template = group.getInstanceOf("relationDeclaration");
   	}

       public relationDeclarationST setCardinality(Object value) {
      	tryToSetStringProperty(template, value, cardinalityIsSet, "cardinality");   
         return this;
      } 
      public relationDeclarationST addDestinationValue(Object value) {
      	tryToSetListProperty(template, value, destinationIsSet, "destination");
         return this;
      }
       public relationDeclarationST setDirection(Object value) {
      	tryToSetStringProperty(template, value, directionIsSet, "direction");   
         return this;
      } 
       public relationDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public relationDeclarationST addPropertiesValue(Object instantiation_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{instantiation}", ( (instantiation_==null || instantiation_.toString().length()==0) ? null : instantiation_));
         return this;
      }
      public relationDeclarationST addSourceValue(Object value) {
      	tryToSetListProperty(template, value, sourceIsSet, "source");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class termCaseST {

      private final AtomicBoolean termIsSet = new AtomicBoolean(false);
      private final ST template;

      private termCaseST(STGroup group) {
   		template = group.getInstanceOf("termCase");
   	}

       public termCaseST setTerm(Object value) {
      	tryToSetStringProperty(template, value, termIsSet, "term");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class termImplST {

      private final AtomicBoolean termIsSet = new AtomicBoolean(false);
      private final ST template;

      private termImplST(STGroup group) {
   		template = group.getInstanceOf("termImpl");
   	}

       public termImplST setTerm(Object value) {
      	tryToSetStringProperty(template, value, termIsSet, "term");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class visitorST {

      private final AtomicBoolean domainIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean termsIsSet = new AtomicBoolean(false);
      private final ST template;

      private visitorST(STGroup group) {
   		template = group.getInstanceOf("visitor");
   	}

       public visitorST setDomain(Object value) {
      	tryToSetStringProperty(template, value, domainIsSet, "domain");   
         return this;
      } 
       public visitorST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public visitorST addTermsValue(Object case_, Object impl_) {
         termsIsSet.set(true);
         template.addAggr("terms.{case, impl}", ( (case_==null || case_.toString().length()==0) ? null : case_), ( (impl_==null || impl_.toString().length()==0) ? null : impl_));
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