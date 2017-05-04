package com.generator.generators.java;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'java.stg' file<br/>
 */
public final class JavaDomainGroup {
   // old java
   private final STGroup stGroup;
   private final char delimiter;

	public JavaDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "java" + java.io.File.separator + "java.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(JavaDomainGroup.class.getResource("/com/generator/generators/java/java.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public JavaDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JavaDomainGroup(java.io.File templateFile) {
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

	public interface JavaDomainGroupTemplate {

	}


   public javaclassST newjavaclass() {
      return new javaclassST(stGroup);
   } 


   public parametersST newparameters() {
      return new parametersST(stGroup);
   } 


   public eomST neweom() {
      return new eomST(stGroup);
   } 


   public gtST newgt() {
      return new gtST(stGroup);
   } 


   public RelationST newRelation() {
      return new RelationST(stGroup);
   } 


   public accessorsST newaccessors() {
      return new accessorsST(stGroup);
   } 


   public assST newass() {
      return new assST(stGroup);
   } 


   public assignST newassign() {
      return new assignST(stGroup);
   } 


   public bugfixST newbugfix() {
      return new bugfixST(stGroup);
   } 


   public caST newca() {
      return new caST(stGroup);
   } 


   public classST newclass() {
      return new classST(stGroup);
   } 


   public classCommentST newclassComment() {
      return new classCommentST(stGroup);
   } 


   public classDeclarationST newclassDeclaration() {
      return new classDeclarationST(stGroup);
   } 


   public comparableST newcomparable() {
      return new comparableST(stGroup);
   } 


   public constructorST newconstructor() {
      return new constructorST(stGroup);
   } 


   public declareST newdeclare() {
      return new declareST(stGroup);
   } 


   public dwST newdw() {
      return new dwST(stGroup);
   } 


   public emptyconstructorST newemptyconstructor() {
      return new emptyconstructorST(stGroup);
   } 


   public enumST newenum() {
      return new enumST(stGroup);
   } 


   public equalityST newequality() {
      return new equalityST(stGroup);
   } 


   public filearrayST newfilearray() {
      return new filearrayST(stGroup);
   } 


   public flST newfl() {
      return new flST(stGroup);
   } 


   public forCST newforC() {
      return new forCST(stGroup);
   } 


   public formatUtilST newformatUtil() {
      return new formatUtilST(stGroup);
   } 


   public getterST newgetter() {
      return new getterST(stGroup);
   } 


   public getterInterfaceST newgetterInterface() {
      return new getterInterfaceST(stGroup);
   } 


   public ifStatementST newifStatement() {
      return new ifStatementST(stGroup);
   } 


   public importsST newimports() {
      return new importsST(stGroup);
   } 


   public instantiateST newinstantiate() {
      return new instantiateST(stGroup);
   } 


   public interfaceST newinterface() {
      return new interfaceST(stGroup);
   } 


   public interfaceDeclarationST newinterfaceDeclaration() {
      return new interfaceDeclarationST(stGroup);
   } 


   public interfaceMethodST newinterfaceMethod() {
      return new interfaceMethodST(stGroup);
   } 


   public itST newit() {
      return new itST(stGroup);
   } 


   public lexicalST newlexical() {
      return new lexicalST(stGroup);
   } 


   public listAccessorsST newlistAccessors() {
      return new listAccessorsST(stGroup);
   } 


   public loginfoST newloginfo() {
      return new loginfoST(stGroup);
   } 


   public loginfoStringST newloginfoString() {
      return new loginfoStringST(stGroup);
   } 


   public mainMethodST newmainMethod() {
      return new mainMethodST(stGroup);
   } 


   public mapAccessorsST newmapAccessors() {
      return new mapAccessorsST(stGroup);
   } 


   public methodST newmethod() {
      return new methodST(stGroup);
   } 


   public methodEndST newmethodEnd() {
      return new methodEndST(stGroup);
   } 


   public methodHeaderST newmethodHeader() {
      return new methodHeaderST(stGroup);
   } 


   public methodParamsST newmethodParams() {
      return new methodParamsST(stGroup);
   } 


   public methodsST newmethods() {
      return new methodsST(stGroup);
   } 


   public newVariableST newnewVariable() {
      return new newVariableST(stGroup);
   } 


   public packageST newpackage() {
      return new packageST(stGroup);
   } 


   public pojoST newpojo() {
      return new pojoST(stGroup);
   } 


   public prST newpr() {
      return new prST(stGroup);
   } 


   public propertiesDeclarationST newpropertiesDeclaration() {
      return new propertiesDeclarationST(stGroup);
   } 


   public returnST newreturn() {
      return new returnST(stGroup);
   } 


   public runMethodST newrunMethod() {
      return new runMethodST(stGroup);
   } 


   public scopeST newscope() {
      return new scopeST(stGroup);
   } 


   public sendEmailST newsendEmail() {
      return new sendEmailST(stGroup);
   } 


   public setAccessorsST newsetAccessors() {
      return new setAccessorsST(stGroup);
   } 


   public setterST newsetter() {
      return new setterST(stGroup);
   } 


   public statementST newstatement() {
      return new statementST(stGroup);
   } 


   public statementsST newstatements() {
      return new statementsST(stGroup);
   } 


   public staticInstantiateST newstaticInstantiate() {
      return new staticInstantiateST(stGroup);
   } 


   public stringST newstring() {
      return new stringST(stGroup);
   } 


   public stringarrayST newstringarray() {
      return new stringarrayST(stGroup);
   } 


   public switchST newswitch() {
      return new switchST(stGroup);
   } 


   public systemPrintlnST newsystemPrintln() {
      return new systemPrintlnST(stGroup);
   } 


   public systemPrintlnStringST newsystemPrintlnString() {
      return new systemPrintlnStringST(stGroup);
   } 


   public todoST newtodo() {
      return new todoST(stGroup);
   } 


   public tryCatchST newtryCatch() {
      return new tryCatchST(stGroup);
   } 


   public varST newvar() {
      return new varST(stGroup);
   } 


   public wdST newwd() {
      return new wdST(stGroup);
   } 

   public final class javaclassST implements JavaDomainGroupTemplate {

      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean constructorsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private javaclassST(STGroup group) {
   		template = group.getInstanceOf("javaclass");
   	}

      public javaclassST addFieldsValue(Object name_, Object scope_, Object type_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{name, scope, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public javaclassST addMethodsValue(Object name_, Object returnValue_, Object scope_, Object parameters_) {
         methodsIsSet.set(true);
         template.addAggr("methods.{name, returnValue, scope, parameters}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (returnValue_==null || returnValue_.toString().length()==0) ? null : returnValue_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (parameters_==null || parameters_.toString().length()==0) ? null : parameters_));
         return this;
      }
       public javaclassST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public javaclassST addConstructorsValue(Object parameters_) {
         constructorsIsSet.set(true);
         template.addAggr("constructors.{parameters}", ( (parameters_==null || parameters_.toString().length()==0) ? null : parameters_));
         return this;
      }
       public javaclassST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public javaclassST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class parametersST implements JavaDomainGroupTemplate {

      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final ST template;

      private parametersST(STGroup group) {
   		template = group.getInstanceOf("parameters");
   	}

      public parametersST addParametersValue(Object name_, Object type_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class eomST implements JavaDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class gtST implements JavaDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class RelationST implements JavaDomainGroupTemplate {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean destinationIsSet = new AtomicBoolean(false);
      private final AtomicBoolean eqhaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lexicalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sourceIsSet = new AtomicBoolean(false);
      private final ST template;

      private RelationST(STGroup group) {
   		template = group.getInstanceOf("Relation");
   	}

       public RelationST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
       public RelationST setDestination(Object value) {
      	tryToSetStringProperty(template, value, destinationIsSet, "destination");   
         return this;
      } 
      public RelationST addEqhaValue(Object value) {
      	tryToSetListProperty(template, value, eqhaIsSet, "eqha");
         return this;
      }
      public RelationST addFieldsValue(Object comment_, Object jsonName_, Object name_, Object type_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{comment, jsonName, name, type}", ( (comment_==null || comment_.toString().length()==0) ? null : comment_), ( (jsonName_==null || jsonName_.toString().length()==0) ? null : jsonName_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public RelationST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
      public RelationST addLexicalValue(Object value) {
      	tryToSetListProperty(template, value, lexicalIsSet, "lexical");
         return this;
      }
       public RelationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public RelationST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public RelationST setSource(Object value) {
      	tryToSetStringProperty(template, value, sourceIsSet, "source");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class accessorsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private accessorsST(STGroup group) {
   		template = group.getInstanceOf("accessors");
   	}

      public accessorsST addPropertiesValue(Object elementType_, Object impl_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object mutable_, Object name_, Object type_, Object valueType_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{elementType, impl, isList, isMap, isSet, keyType, mutable, name, type, valueType}", ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (mutable_==null || mutable_.toString().length()==0) ? null : mutable_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class assST implements JavaDomainGroupTemplate {

      private final AtomicBoolean sourceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final ST template;

      private assST(STGroup group) {
   		template = group.getInstanceOf("ass");
   	}

       public assST setSource(Object value) {
      	tryToSetStringProperty(template, value, sourceIsSet, "source");   
         return this;
      } 
       public assST setTarget(Object value) {
      	tryToSetStringProperty(template, value, targetIsSet, "target");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class assignST implements JavaDomainGroupTemplate {

      private final AtomicBoolean mutableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private assignST(STGroup group) {
   		template = group.getInstanceOf("assign");
   	}

       public assignST setMutable(Object value) {
      	tryToSetStringProperty(template, value, mutableIsSet, "mutable");   
         return this;
      } 
       public assignST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public assignST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfixST implements JavaDomainGroupTemplate {

      private final ST template;

      private bugfixST(STGroup group) {
   		template = group.getInstanceOf("bugfix");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class caST implements JavaDomainGroupTemplate {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean finallyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean predicateIsSet = new AtomicBoolean(false);
      private final ST template;

      private caST(STGroup group) {
   		template = group.getInstanceOf("ca");
   	}

       public caST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public caST setFinally(Object value) {
      	tryToSetStringProperty(template, value, finallyIsSet, "finally");   
         return this;
      } 
       public caST setPredicate(Object value) {
      	tryToSetStringProperty(template, value, predicateIsSet, "predicate");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class classST implements JavaDomainGroupTemplate {

      private final AtomicBoolean abstractIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean comparableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean equalityIsSet = new AtomicBoolean(false);
      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean finalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean implementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean innerClassesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lexicalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean testIsSet = new AtomicBoolean(false);
      private final ST template;

      private classST(STGroup group) {
   		template = group.getInstanceOf("class");
   	}

       public classST setAbstract(Object value) {
      	tryToSetStringProperty(template, value, abstractIsSet, "abstract");   
         return this;
      } 
       public classST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
       public classST setComparable(Object value) {
      	tryToSetStringProperty(template, value, comparableIsSet, "comparable");   
         return this;
      } 
       public classST setEquality(Object value) {
      	tryToSetStringProperty(template, value, equalityIsSet, "equality");   
         return this;
      } 
       public classST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
       public classST setFinal(Object value) {
      	tryToSetStringProperty(template, value, finalIsSet, "final");   
         return this;
      } 
      public classST addImplementValue(Object value) {
      	tryToSetListProperty(template, value, implementIsSet, "implement");
         return this;
      }
      public classST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
      public classST addInnerClassesValue(Object value) {
      	tryToSetListProperty(template, value, innerClassesIsSet, "innerClasses");
         return this;
      }
       public classST setLexical(Object value) {
      	tryToSetStringProperty(template, value, lexicalIsSet, "lexical");   
         return this;
      } 
      public classST addMethodsValue(Object value) {
      	tryToSetListProperty(template, value, methodsIsSet, "methods");
         return this;
      }
       public classST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public classST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public classST addPropertiesValue(Object elementType_, Object final_, Object impl_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object mutable_, Object name_, Object scope_, Object type_, Object valueType_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{elementType, final, impl, isList, isMap, isSet, keyType, mutable, name, scope, type, valueType}", ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (final_==null || final_.toString().length()==0) ? null : final_), ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (mutable_==null || mutable_.toString().length()==0) ? null : mutable_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }
       public classST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
       public classST setTest(Object value) {
      	tryToSetStringProperty(template, value, testIsSet, "test");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class classCommentST implements JavaDomainGroupTemplate {

      private final AtomicBoolean textIsSet = new AtomicBoolean(false);
      private final ST template;

      private classCommentST(STGroup group) {
   		template = group.getInstanceOf("classComment");
   	}

       public classCommentST setText(Object value) {
      	tryToSetStringProperty(template, value, textIsSet, "text");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class classDeclarationST implements JavaDomainGroupTemplate {

      private final AtomicBoolean abstractIsSet = new AtomicBoolean(false);
      private final AtomicBoolean comparableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean finalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean implementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private classDeclarationST(STGroup group) {
   		template = group.getInstanceOf("classDeclaration");
   	}

       public classDeclarationST setAbstract(Object value) {
      	tryToSetStringProperty(template, value, abstractIsSet, "abstract");   
         return this;
      } 
       public classDeclarationST setComparable(Object value) {
      	tryToSetStringProperty(template, value, comparableIsSet, "comparable");   
         return this;
      } 
       public classDeclarationST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
       public classDeclarationST setFinal(Object value) {
      	tryToSetStringProperty(template, value, finalIsSet, "final");   
         return this;
      } 
      public classDeclarationST addImplementValue(Object value) {
      	tryToSetListProperty(template, value, implementIsSet, "implement");
         return this;
      }
       public classDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public classDeclarationST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class comparableST implements JavaDomainGroupTemplate {

      private final AtomicBoolean comparableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private comparableST(STGroup group) {
   		template = group.getInstanceOf("comparable");
   	}

       public comparableST setComparable(Object value) {
      	tryToSetStringProperty(template, value, comparableIsSet, "comparable");   
         return this;
      } 
       public comparableST setProperty(Object value) {
      	tryToSetStringProperty(template, value, propertyIsSet, "property");   
         return this;
      } 
       public comparableST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class constructorST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private constructorST(STGroup group) {
   		template = group.getInstanceOf("constructor");
   	}

       public constructorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public constructorST addPropertiesValue(Object mutable_, Object name_, Object type_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{mutable, name, type}", ( (mutable_==null || mutable_.toString().length()==0) ? null : mutable_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class declareST implements JavaDomainGroupTemplate {

      private final AtomicBoolean immutableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private declareST(STGroup group) {
   		template = group.getInstanceOf("declare");
   	}

       public declareST setImmutable(Object value) {
      	tryToSetStringProperty(template, value, immutableIsSet, "immutable");   
         return this;
      } 
       public declareST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public declareST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
       public declareST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class dwST implements JavaDomainGroupTemplate {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean predicateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dwST(STGroup group) {
   		template = group.getInstanceOf("dw");
   	}

       public dwST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public dwST setPredicate(Object value) {
      	tryToSetStringProperty(template, value, predicateIsSet, "predicate");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class emptyconstructorST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private emptyconstructorST(STGroup group) {
   		template = group.getInstanceOf("emptyconstructor");
   	}

       public emptyconstructorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class enumST implements JavaDomainGroupTemplate {

      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private enumST(STGroup group) {
   		template = group.getInstanceOf("enum");
   	}

       public enumST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
       public enumST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public enumST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
       public enumST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
      public enumST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class equalityST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private equalityST(STGroup group) {
   		template = group.getInstanceOf("equality");
   	}

       public equalityST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public equalityST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class filearrayST implements JavaDomainGroupTemplate {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private filearrayST(STGroup group) {
   		template = group.getInstanceOf("filearray");
   	}

       public filearrayST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public filearrayST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class flST implements JavaDomainGroupTemplate {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean predicateIsSet = new AtomicBoolean(false);
      private final ST template;

      private flST(STGroup group) {
   		template = group.getInstanceOf("fl");
   	}

       public flST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public flST setPredicate(Object value) {
      	tryToSetStringProperty(template, value, predicateIsSet, "predicate");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class forCST implements JavaDomainGroupTemplate {

      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sourceIsSet = new AtomicBoolean(false);
      private final ST template;

      private forCST(STGroup group) {
   		template = group.getInstanceOf("forC");
   	}

       public forCST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public forCST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
       public forCST setSource(Object value) {
      	tryToSetStringProperty(template, value, sourceIsSet, "source");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class formatUtilST implements JavaDomainGroupTemplate {

      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private formatUtilST(STGroup group) {
   		template = group.getInstanceOf("formatUtil");
   	}

       public formatUtilST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class getterST implements JavaDomainGroupTemplate {

      private final AtomicBoolean mutableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private getterST(STGroup group) {
   		template = group.getInstanceOf("getter");
   	}

       public getterST setMutable(Object value) {
      	tryToSetStringProperty(template, value, mutableIsSet, "mutable");   
         return this;
      } 
       public getterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public getterST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class getterInterfaceST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private getterInterfaceST(STGroup group) {
   		template = group.getInstanceOf("getterInterface");
   	}

       public getterInterfaceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public getterInterfaceST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ifStatementST implements JavaDomainGroupTemplate {

      private final AtomicBoolean conditionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private ifStatementST(STGroup group) {
   		template = group.getInstanceOf("ifStatement");
   	}

       public ifStatementST setCondition(Object value) {
      	tryToSetStringProperty(template, value, conditionIsSet, "condition");   
         return this;
      } 
       public ifStatementST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class importsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final ST template;

      private importsST(STGroup group) {
   		template = group.getInstanceOf("imports");
   	}

      public importsST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class instantiateST implements JavaDomainGroupTemplate {

      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private instantiateST(STGroup group) {
   		template = group.getInstanceOf("instantiate");
   	}

      public instantiateST addParamsValue(Object annotation_, Object elementType_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object type_, Object valueType_) {
         paramsIsSet.set(true);
         template.addAggr("params.{annotation, elementType, isList, isMap, isSet, keyType, name, type, valueType}", ( (annotation_==null || annotation_.toString().length()==0) ? null : annotation_), ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }
       public instantiateST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class interfaceST implements JavaDomainGroupTemplate {

      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private interfaceST(STGroup group) {
   		template = group.getInstanceOf("interface");
   	}

       public interfaceST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
       public interfaceST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
      public interfaceST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
      public interfaceST addMethodsValue(Object value) {
      	tryToSetListProperty(template, value, methodsIsSet, "methods");
         return this;
      }
       public interfaceST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public interfaceST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class interfaceDeclarationST implements JavaDomainGroupTemplate {

      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final ST template;

      private interfaceDeclarationST(STGroup group) {
   		template = group.getInstanceOf("interfaceDeclaration");
   	}

       public interfaceDeclarationST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
       public interfaceDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public interfaceDeclarationST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class interfaceMethodST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private interfaceMethodST(STGroup group) {
   		template = group.getInstanceOf("interfaceMethod");
   	}

       public interfaceMethodST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public interfaceMethodST addParamsValue(Object annotation_, Object elementType_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object type_, Object valueType_) {
         paramsIsSet.set(true);
         template.addAggr("params.{annotation, elementType, isList, isMap, isSet, keyType, name, type, valueType}", ( (annotation_==null || annotation_.toString().length()==0) ? null : annotation_), ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }
       public interfaceMethodST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
       public interfaceMethodST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class itST implements JavaDomainGroupTemplate {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean iteratorIsSet = new AtomicBoolean(false);
      private final ST template;

      private itST(STGroup group) {
   		template = group.getInstanceOf("it");
   	}

       public itST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public itST setIterator(Object value) {
      	tryToSetStringProperty(template, value, iteratorIsSet, "iterator");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class lexicalST implements JavaDomainGroupTemplate {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private lexicalST(STGroup group) {
   		template = group.getInstanceOf("lexical");
   	}

      public lexicalST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class listAccessorsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean elementTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private listAccessorsST(STGroup group) {
   		template = group.getInstanceOf("listAccessors");
   	}

       public listAccessorsST setElementType(Object value) {
      	tryToSetStringProperty(template, value, elementTypeIsSet, "elementType");   
         return this;
      } 
       public listAccessorsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public listAccessorsST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class loginfoST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private loginfoST(STGroup group) {
   		template = group.getInstanceOf("loginfo");
   	}

       public loginfoST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class loginfoStringST implements JavaDomainGroupTemplate {

      private final AtomicBoolean stringIsSet = new AtomicBoolean(false);
      private final ST template;

      private loginfoStringST(STGroup group) {
   		template = group.getInstanceOf("loginfoString");
   	}

       public loginfoStringST setString(Object value) {
      	tryToSetStringProperty(template, value, stringIsSet, "string");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class mainMethodST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private mainMethodST(STGroup group) {
   		template = group.getInstanceOf("mainMethod");
   	}

      public mainMethodST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class mapAccessorsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean keyTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueTypeIsSet = new AtomicBoolean(false);
      private final ST template;

      private mapAccessorsST(STGroup group) {
   		template = group.getInstanceOf("mapAccessors");
   	}

       public mapAccessorsST setKeyType(Object value) {
      	tryToSetStringProperty(template, value, keyTypeIsSet, "keyType");   
         return this;
      } 
       public mapAccessorsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public mapAccessorsST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 
       public mapAccessorsST setValueType(Object value) {
      	tryToSetStringProperty(template, value, valueTypeIsSet, "valueType");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodST implements JavaDomainGroupTemplate {

      private final AtomicBoolean annotationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnValIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodST(STGroup group) {
   		template = group.getInstanceOf("method");
   	}

      public methodST addAnnotationsValue(Object value) {
      	tryToSetListProperty(template, value, annotationsIsSet, "annotations");
         return this;
      }
       public methodST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public methodST addParamsValue(Object annotation_, Object elementType_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object type_, Object valueType_) {
         paramsIsSet.set(true);
         template.addAggr("params.{annotation, elementType, isList, isMap, isSet, keyType, name, type, valueType}", ( (annotation_==null || annotation_.toString().length()==0) ? null : annotation_), ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }
       public methodST setReturnVal(Object value) {
      	tryToSetStringProperty(template, value, returnValIsSet, "returnVal");   
         return this;
      } 
       public methodST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
      public methodST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodEndST implements JavaDomainGroupTemplate {

      private final ST template;

      private methodEndST(STGroup group) {
   		template = group.getInstanceOf("methodEnd");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodHeaderST implements JavaDomainGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnValueIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodHeaderST(STGroup group) {
   		template = group.getInstanceOf("methodHeader");
   	}

       public methodHeaderST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public methodHeaderST addParamsValue(Object name_, Object type_) {
         paramsIsSet.set(true);
         template.addAggr("params.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
       public methodHeaderST setReturnValue(Object value) {
      	tryToSetStringProperty(template, value, returnValueIsSet, "returnValue");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodParamsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodParamsST(STGroup group) {
   		template = group.getInstanceOf("methodParams");
   	}

      public methodParamsST addParamsValue(Object annotation_, Object elementType_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object type_, Object valueType_) {
         paramsIsSet.set(true);
         template.addAggr("params.{annotation, elementType, isList, isMap, isSet, keyType, name, type, valueType}", ( (annotation_==null || annotation_.toString().length()==0) ? null : annotation_), ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodsST(STGroup group) {
   		template = group.getInstanceOf("methods");
   	}

      public methodsST addMethodsValue(Object value) {
      	tryToSetListProperty(template, value, methodsIsSet, "methods");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class newVariableST implements JavaDomainGroupTemplate {

      private final AtomicBoolean declarationIsSet = new AtomicBoolean(false);
      private final AtomicBoolean instantiateIsSet = new AtomicBoolean(false);
      private final ST template;

      private newVariableST(STGroup group) {
   		template = group.getInstanceOf("newVariable");
   	}

       public newVariableST setDeclaration(Object value) {
      	tryToSetStringProperty(template, value, declarationIsSet, "declaration");   
         return this;
      } 
       public newVariableST setInstantiate(Object value) {
      	tryToSetStringProperty(template, value, instantiateIsSet, "instantiate");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class packageST implements JavaDomainGroupTemplate {

      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private packageST(STGroup group) {
   		template = group.getInstanceOf("package");
   	}

       public packageST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class pojoST implements JavaDomainGroupTemplate {

      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean eqhaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean fieldsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean importsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lexicalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final ST template;

      private pojoST(STGroup group) {
   		template = group.getInstanceOf("pojo");
   	}

       public pojoST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public pojoST addEqhaValue(Object value) {
      	tryToSetListProperty(template, value, eqhaIsSet, "eqha");
         return this;
      }
      public pojoST addFieldsValue(Object comment_, Object jsonName_, Object name_, Object type_) {
         fieldsIsSet.set(true);
         template.addAggr("fields.{comment, jsonName, name, type}", ( (comment_==null || comment_.toString().length()==0) ? null : comment_), ( (jsonName_==null || jsonName_.toString().length()==0) ? null : jsonName_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      }
      public pojoST addImportsValue(Object value) {
      	tryToSetListProperty(template, value, importsIsSet, "imports");
         return this;
      }
      public pojoST addLexicalValue(Object value) {
      	tryToSetListProperty(template, value, lexicalIsSet, "lexical");
         return this;
      }
       public pojoST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public pojoST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class prST implements JavaDomainGroupTemplate {

      private final AtomicBoolean predicateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private prST(STGroup group) {
   		template = group.getInstanceOf("pr");
   	}

       public prST setPredicate(Object value) {
      	tryToSetStringProperty(template, value, predicateIsSet, "predicate");   
         return this;
      } 
       public prST setValues(Object value) {
      	tryToSetStringProperty(template, value, valuesIsSet, "values");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class propertiesDeclarationST implements JavaDomainGroupTemplate {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private propertiesDeclarationST(STGroup group) {
   		template = group.getInstanceOf("propertiesDeclaration");
   	}

      public propertiesDeclarationST addPropertiesValue(Object elementType_, Object final_, Object impl_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object scope_, Object type_, Object valueType_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{elementType, final, impl, isList, isMap, isSet, keyType, name, scope, type, valueType}", ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (final_==null || final_.toString().length()==0) ? null : final_), ( (impl_==null || impl_.toString().length()==0) ? null : impl_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class returnST implements JavaDomainGroupTemplate {

      private final AtomicBoolean stringValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private returnST(STGroup group) {
   		template = group.getInstanceOf("return");
   	}

       public returnST setStringValue(Object value) {
      	tryToSetStringProperty(template, value, stringValueIsSet, "stringValue");   
         return this;
      } 
       public returnST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class runMethodST implements JavaDomainGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private runMethodST(STGroup group) {
   		template = group.getInstanceOf("runMethod");
   	}

       public runMethodST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class scopeST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private scopeST(STGroup group) {
   		template = group.getInstanceOf("scope");
   	}

      public scopeST addStatementsValue(Object statement_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{statement}", ( (statement_==null || statement_.toString().length()==0) ? null : statement_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class sendEmailST implements JavaDomainGroupTemplate {

      private final AtomicBoolean attachmentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean fromIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hostIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messageBodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean recipientsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean subjectIsSet = new AtomicBoolean(false);
      private final ST template;

      private sendEmailST(STGroup group) {
   		template = group.getInstanceOf("sendEmail");
   	}

      public sendEmailST addAttachmentsValue(Object filename_) {
         attachmentsIsSet.set(true);
         template.addAggr("attachments.{filename}", ( (filename_==null || filename_.toString().length()==0) ? null : filename_));
         return this;
      }
       public sendEmailST setFrom(Object value) {
      	tryToSetStringProperty(template, value, fromIsSet, "from");   
         return this;
      } 
       public sendEmailST setHost(Object value) {
      	tryToSetStringProperty(template, value, hostIsSet, "host");   
         return this;
      } 
       public sendEmailST setMessageBody(Object value) {
      	tryToSetStringProperty(template, value, messageBodyIsSet, "messageBody");   
         return this;
      } 
      public sendEmailST addRecipientsValue(Object email_) {
         recipientsIsSet.set(true);
         template.addAggr("recipients.{email}", ( (email_==null || email_.toString().length()==0) ? null : email_));
         return this;
      }
       public sendEmailST setSubject(Object value) {
      	tryToSetStringProperty(template, value, subjectIsSet, "subject");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class setAccessorsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean elementTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private setAccessorsST(STGroup group) {
   		template = group.getInstanceOf("setAccessors");
   	}

       public setAccessorsST setElementType(Object value) {
      	tryToSetStringProperty(template, value, elementTypeIsSet, "elementType");   
         return this;
      } 
       public setAccessorsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public setAccessorsST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class setterST implements JavaDomainGroupTemplate {

      private final AtomicBoolean mutableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private setterST(STGroup group) {
   		template = group.getInstanceOf("setter");
   	}

       public setterST setMutable(Object value) {
      	tryToSetStringProperty(template, value, mutableIsSet, "mutable");   
         return this;
      } 
       public setterST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public setterST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class statementST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private statementST(STGroup group) {
   		template = group.getInstanceOf("statement");
   	}

       public statementST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class statementsST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private statementsST(STGroup group) {
   		template = group.getInstanceOf("statements");
   	}

      public statementsST addStatementsValue(Object statement_) {
         statementsIsSet.set(true);
         template.addAggr("statements.{statement}", ( (statement_==null || statement_.toString().length()==0) ? null : statement_));
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class staticInstantiateST implements JavaDomainGroupTemplate {

      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private staticInstantiateST(STGroup group) {
   		template = group.getInstanceOf("staticInstantiate");
   	}

      public staticInstantiateST addParamsValue(Object annotation_, Object elementType_, Object isList_, Object isMap_, Object isSet_, Object keyType_, Object name_, Object type_, Object valueType_) {
         paramsIsSet.set(true);
         template.addAggr("params.{annotation, elementType, isList, isMap, isSet, keyType, name, type, valueType}", ( (annotation_==null || annotation_.toString().length()==0) ? null : annotation_), ( (elementType_==null || elementType_.toString().length()==0) ? null : elementType_), ( (isList_==null || isList_.toString().length()==0) ? null : isList_), ( (isMap_==null || isMap_.toString().length()==0) ? null : isMap_), ( (isSet_==null || isSet_.toString().length()==0) ? null : isSet_), ( (keyType_==null || keyType_.toString().length()==0) ? null : keyType_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (valueType_==null || valueType_.toString().length()==0) ? null : valueType_));
         return this;
      }
       public staticInstantiateST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class stringST implements JavaDomainGroupTemplate {

      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringST(STGroup group) {
   		template = group.getInstanceOf("string");
   	}

       public stringST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class stringarrayST implements JavaDomainGroupTemplate {

      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringarrayST(STGroup group) {
   		template = group.getInstanceOf("stringarray");
   	}

      public stringarrayST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class switchST implements JavaDomainGroupTemplate {

      private final AtomicBoolean casesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
      private final ST template;

      private switchST(STGroup group) {
   		template = group.getInstanceOf("switch");
   	}

      public switchST addCasesValue(Object case_, Object stmt_) {
         casesIsSet.set(true);
         template.addAggr("cases.{case, stmt}", ( (case_==null || case_.toString().length()==0) ? null : case_), ( (stmt_==null || stmt_.toString().length()==0) ? null : stmt_));
         return this;
      }
       public switchST setState(Object value) {
      	tryToSetStringProperty(template, value, stateIsSet, "state");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class systemPrintlnST implements JavaDomainGroupTemplate {

      private final AtomicBoolean statementIsSet = new AtomicBoolean(false);
      private final ST template;

      private systemPrintlnST(STGroup group) {
   		template = group.getInstanceOf("systemPrintln");
   	}

       public systemPrintlnST setStatement(Object value) {
      	tryToSetStringProperty(template, value, statementIsSet, "statement");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class systemPrintlnStringST implements JavaDomainGroupTemplate {

      private final AtomicBoolean stringIsSet = new AtomicBoolean(false);
      private final ST template;

      private systemPrintlnStringST(STGroup group) {
   		template = group.getInstanceOf("systemPrintlnString");
   	}

       public systemPrintlnStringST setString(Object value) {
      	tryToSetStringProperty(template, value, stringIsSet, "string");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class todoST implements JavaDomainGroupTemplate {

      private final AtomicBoolean textIsSet = new AtomicBoolean(false);
      private final ST template;

      private todoST(STGroup group) {
   		template = group.getInstanceOf("todo");
   	}

       public todoST setText(Object value) {
      	tryToSetStringProperty(template, value, textIsSet, "text");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class tryCatchST implements JavaDomainGroupTemplate {

      private final AtomicBoolean handleExceptionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private tryCatchST(STGroup group) {
   		template = group.getInstanceOf("tryCatch");
   	}

       public tryCatchST setHandleException(Object value) {
      	tryToSetStringProperty(template, value, handleExceptionIsSet, "handleException");   
         return this;
      } 
      public tryCatchST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class varST implements JavaDomainGroupTemplate {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private varST(STGroup group) {
   		template = group.getInstanceOf("var");
   	}

       public varST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public varST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 
       public varST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class wdST implements JavaDomainGroupTemplate {

      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean predicateIsSet = new AtomicBoolean(false);
      private final ST template;

      private wdST(STGroup group) {
   		template = group.getInstanceOf("wd");
   	}

       public wdST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      } 
       public wdST setPredicate(Object value) {
      	tryToSetStringProperty(template, value, predicateIsSet, "predicate");   
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