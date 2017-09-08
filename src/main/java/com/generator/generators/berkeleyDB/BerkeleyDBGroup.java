package com.generator.generators.berkeleyDB;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'berkeleyDB.stg' file<br/>
 */
public final class BerkeleyDBGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public BerkeleyDBGroup() {
		this(new STGroupString(stg));
   }

   public BerkeleyDBGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public BerkeleyDBGroup(java.io.File templateFile) {
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

	public interface BerkeleyDBGroupTemplate {

	}

   public secondaryIndexDefinitionST newsecondaryIndexDefinition() {
      return new secondaryIndexDefinitionST(stGroup);
   } 

   public secondaryIndexInitializationST newsecondaryIndexInitialization() {
      return new secondaryIndexInitializationST(stGroup);
   } 

   public secondaryIndexAccessorST newsecondaryIndexAccessor() {
      return new secondaryIndexAccessorST(stGroup);
   } 

   public secondaryIndexCloseST newsecondaryIndexClose() {
      return new secondaryIndexCloseST(stGroup);
   } 

   public secondaryIndexDeclarationST newsecondaryIndexDeclaration() {
      return new secondaryIndexDeclarationST(stGroup);
   } 

   public DBEntityST newDBEntity() {
      return new DBEntityST(stGroup);
   } 

   public BerkeleyDBST newBerkeleyDB() {
      return new BerkeleyDBST(stGroup);
   } 

   public ViewClassDeclST newViewClassDecl() {
      return new ViewClassDeclST(stGroup);
   } 

   public final class secondaryIndexDefinitionST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean entityIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private secondaryIndexDefinitionST(STGroup group) {
   		template = group.getInstanceOf("secondaryIndexDefinition");
   	}

      public secondaryIndexDefinitionST setEntity(Object value) {
      	tryToSetStringProperty(template, value, entityIsSet, "entity");   
         return this;
      } 
      public secondaryIndexDefinitionST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class secondaryIndexInitializationST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private secondaryIndexInitializationST(STGroup group) {
   		template = group.getInstanceOf("secondaryIndexInitialization");
   	}

      public secondaryIndexInitializationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class secondaryIndexAccessorST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean entityIsSet = new AtomicBoolean(false);
      private final ST template;

      private secondaryIndexAccessorST(STGroup group) {
   		template = group.getInstanceOf("secondaryIndexAccessor");
   	}

      public secondaryIndexAccessorST setEntity(Object value) {
      	tryToSetStringProperty(template, value, entityIsSet, "entity");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class secondaryIndexCloseST implements BerkeleyDBGroupTemplate {

      private final ST template;

      private secondaryIndexCloseST(STGroup group) {
   		template = group.getInstanceOf("secondaryIndexClose");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class secondaryIndexDeclarationST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private secondaryIndexDeclarationST(STGroup group) {
   		template = group.getInstanceOf("secondaryIndexDeclaration");
   	}

      public secondaryIndexDeclarationST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class DBEntityST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean primaryNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean primaryTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean secondaryKeysIsSet = new AtomicBoolean(false);
      private final ST template;

      private DBEntityST(STGroup group) {
   		template = group.getInstanceOf("DBEntity");
   	}

      public DBEntityST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public DBEntityST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public DBEntityST setPrimaryName(Object value) {
      	tryToSetStringProperty(template, value, primaryNameIsSet, "primaryName");   
         return this;
      } 
      public DBEntityST setPrimaryType(Object value) {
      	tryToSetStringProperty(template, value, primaryTypeIsSet, "primaryType");   
         return this;
      } 
      public DBEntityST addPropertiesValue(Object name_, Object type_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 
      public DBEntityST addSecondaryKeysValue(Object name_, Object relate_, Object relatedEntity_, Object type_) {
         secondaryKeysIsSet.set(true);
         template.addAggr("secondaryKeys.{name, relate, relatedEntity, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (relate_==null || relate_.toString().length()==0) ? null : relate_), ( (relatedEntity_==null || relatedEntity_.toString().length()==0) ? null : relatedEntity_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class BerkeleyDBST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean viewsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private BerkeleyDBST(STGroup group) {
   		template = group.getInstanceOf("BerkeleyDB");
   	}

      public BerkeleyDBST addViewsValue(Object classDecl_, Object name_) {
         viewsIsSet.set(true);
         template.addAggr("views.{classDecl, name}", ( (classDecl_==null || classDecl_.toString().length()==0) ? null : classDecl_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      } 
      public BerkeleyDBST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public BerkeleyDBST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class ViewClassDeclST implements BerkeleyDBGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean secondaryIndicesIsSet = new AtomicBoolean(false);
      private final ST template;

      private ViewClassDeclST(STGroup group) {
   		template = group.getInstanceOf("ViewClassDecl");
   	}

      public ViewClassDeclST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public ViewClassDeclST addSecondaryIndicesValue(Object accessor_, Object close_, Object declaration_, Object definition_, Object initalization_) {
         secondaryIndicesIsSet.set(true);
         template.addAggr("secondaryIndices.{accessor, close, declaration, definition, initalization}", ( (accessor_==null || accessor_.toString().length()==0) ? null : accessor_), ( (close_==null || close_.toString().length()==0) ? null : close_), ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_), ( (definition_==null || definition_.toString().length()==0) ? null : definition_), ( (initalization_==null || initalization_.toString().length()==0) ? null : initalization_));
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "BerkeleyDBGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("secondaryIndexDefinition(entity,name) ::= <<private final class ~name~ {\n" + 
	"\n" + 
	"    // secondary indices:\n" + 
	"    private SecondaryDatabase supplierByCityDb;\n" + 
	"    private static final String ~name;format=\"toUpper\"~_INDEX = \"Node_supplier_city_index\";\n" + 
	"    private final StoredMap<String, ~entity~> supplierByCityMap;\n" + 
	"\n" + 
	"    private ~name~(Environment env) {\n" + 
	"\n" + 
	"        // secondary indices:\n" + 
	"        SecondaryConfig secConfig = new SecondaryConfig();\n" + 
	"        secConfig.setTransactional(true);\n" + 
	"        secConfig.setAllowCreate(true);\n" + 
	"        secConfig.setSortedDuplicates(true);\n" + 
	"        secConfig.setKeyCreator(new SecondaryKeyCreator() {\n" + 
	"            @Override\n" + 
	"            public boolean createSecondaryKey(SecondaryDatabase secondaryDatabase, DatabaseEntry key, DatabaseEntry value, DatabaseEntry result) {\n" + 
	"                try {\n" + 
	"                    final ~entity~ nodeJob = ~entity~.newBuilder().mergeFrom(value.getData()).build();\n" + 
	"                    result.setData(nodeJob.getNode().getBytes());\n" + 
	"                } catch (InvalidProtocolBufferException e) {\n" + 
	"                    e.printStackTrace();\n" + 
	"                    return false;\n" + 
	"                }\n" + 
	"                return true;\n" + 
	"            }\n" + 
	"        });\n" + 
	"        supplierByCityDb = env.openSecondaryDatabase(null, ~name;format=\"toUpper\"~, database, secConfig);\n" + 
	"\n" + 
	"        supplierByCityMap =\n" + 
	"                new StoredMap<String, ~entity~>(supplierByCityDb, new EntryBinding<String>() {\n" + 
	"                    @Override\n" + 
	"                    public String entryToObject(DatabaseEntry databaseEntry) {\n" + 
	"                        return new String(databaseEntry.getData());\n" + 
	"                    }\n" + 
	"\n" + 
	"                    @Override\n" + 
	"                    public void objectToEntry(String key, DatabaseEntry databaseEntry) {\n" + 
	"                        databaseEntry.setData(key.getBytes());\n" + 
	"                    }\n" + 
	"                }, new EntryBinding<~entity~>() {\n" + 
	"                    @Override\n" + 
	"                    public ~entity~ entryToObject(DatabaseEntry databaseEntry) {\n" + 
	"                        try {\n" + 
	"                            return ~entity~.newBuilder().mergeFrom(databaseEntry.getData()).build();\n" + 
	"                        } catch (InvalidProtocolBufferException e) {\n" + 
	"                            log.error(\"InvalidProtocolBufferException for NodeJob {}\", e);\n" + 
	"                            return null;\n" + 
	"                        }\n" + 
	"                    }\n" + 
	"\n" + 
	"                    @Override\n" + 
	"                    public void objectToEntry(~entity~ nodeGroup, DatabaseEntry databaseEntry) {\n" + 
	"                        databaseEntry.setData(nodeGroup.toByteArray());\n" + 
	"                    }\n" + 
	"                }, true\n" + 
	"                );\n" + 
	"    }\n" + 
	"\n" + 
	"    public Set<~entity~> listNodeJobsByNode(String key) {\n" + 
	"        final Set<~entity~> set = new LinkedHashSet<~entity~>();\n" + 
	"        for (~entity~ nodeJob : supplierByCityMap.duplicates(key)) set.add(nodeJob);\n" + 
	"        return set;\n" + 
	"    }\n" + 
	"\n" + 
	"    public void close() {\n" + 
	"        supplierByCityIndex.close();\n" + 
	"    }\n" + 
	"} >>\n")
		.append("secondaryIndexInitialization(name) ::= <<supplierByCityIndex = new ~name~(env); >>\n")
		.append("secondaryIndexAccessor(entity) ::= <<public Set<~entity~> listNodeJobsByNode(String key) {\n" + 
	"     final Set<~entity~> set = new LinkedHashSet<~entity~>();\n" + 
	"     for (~entity~ nodeJob : supplierByCityMap.duplicates(key)) set.add(nodeJob);\n" + 
	"     return set;\n" + 
	"} >>\n")
		.append("secondaryIndexClose() ::= <<supplierByCityDb.close(); >>\n")
		.append("secondaryIndexDeclaration(name) ::= <<private final ~name~ supplierByCityIndex; >>\n")
		.append("DBEntity(name,packageName,primaryName,primaryType,properties,secondaryKeys) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"@com.sleepycat.persist.model.Entity\n" + 
	"public class ~name~ {\n" + 
	"\n" + 
	"	@com.sleepycat.persist.model.PrimaryKey\n" + 
	"	private ~primaryType~ ~primaryName~;\n" + 
	"\n" + 
	"	~properties:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
	"\n" + 
	"~secondaryKeys:{it|\n" + 
	"	@SecondaryKey(relate=~it.relate~,relatedEntity=~it.relatedEntity~.class)\n" + 
	"	~it.type~ ~it.name~;\n" + 
	"};separator=\"\\n\"~\n" + 
	"\n" + 
	"	public ~name~(~primaryType~ ~primaryName~~if(properties)~~properties:{it|~it.type~ ~it.name~};separator=\",\"~~endif~) {\n" + 
	"		this.~primaryName~ = ~primaryName~;~if(properties)~\n" + 
	"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"	}\n" + 
	"} >>\n")
		.append("BerkeleyDB(views,name,packageName) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"import com.sleepycat.bind.EntryBinding;\n" + 
	"import com.sleepycat.bind.serial.StoredClassCatalog;\n" + 
	"import com.sleepycat.collections.StoredMap;\n" + 
	"import com.sleepycat.collections.TransactionRunner;\n" + 
	"import com.sleepycat.collections.TransactionWorker;\n" + 
	"import com.sleepycat.je.*;\n" + 
	"import org.slf4j.Logger;\n" + 
	"import org.slf4j.LoggerFactory;\n" + 
	"\n" + 
	"import java.io.File;\n" + 
	"import java.util.LinkedHashSet;\n" + 
	"import java.util.List;\n" + 
	"import java.util.Map;\n" + 
	"import java.util.Set;\n" + 
	"\n" + 
	"/**\n" + 
	" * docs @ http://docs.oracle.com/cd/E17277_02/html/index.html\n" + 
	" */\n" + 
	"public class ~name~ {\n" + 
	"\n" + 
	"    private static final Logger log = LoggerFactory.getLogger(~name~.class);\n" + 
	"\n" + 
	"    private final Environment dbEnvironment;\n" + 
	"\n" + 
	"    private static final String CLASS_CATALOG = \"java_class_catalog\";\n" + 
	"    private final StoredClassCatalog javaCatalog;\n" + 
	"\n" + 
	"    protected final String directory;\n" + 
	"\n" + 
	"    // views\n" + 
	"    ~views:{it|private final ~it.name~View ~it.name;format=\"lowFirst\"~View;};separator=\"\\n\"~\n" + 
	"\n" + 
	"    public ~name~(String directory) {\n" + 
	"\n" + 
	"        this.directory = directory;\n" + 
	"        tryToCreateDirIfNotExists(new File(directory));\n" + 
	"\n" + 
	"        // check EnvironmentMutableConfig to be able to adjust some environment configurations during runtime (cache, flushing etc.)\n" + 
	"        final EnvironmentConfig envConfig = new EnvironmentConfig();\n" + 
	"        envConfig.setAllowCreate(true);\n" + 
	"        envConfig.setTransactional(true);\n" + 
	"        dbEnvironment = new Environment(new File(directory), envConfig);\n" + 
	"\n" + 
	"        // configuration for java catalog\n" + 
	"        final DatabaseConfig dbConfig = new DatabaseConfig();\n" + 
	"        dbConfig.setTransactional(true);\n" + 
	"        dbConfig.setAllowCreate(true);\n" + 
	"        final com.sleepycat.je.Database catalogDb = dbEnvironment.openDatabase(null, CLASS_CATALOG, dbConfig);\n" + 
	"        javaCatalog = new StoredClassCatalog(catalogDb);\n" + 
	"\n" + 
	"        // configurations for simple db's (transactional)\n" + 
	"        final DatabaseConfig simpleDBConfig = new DatabaseConfig();\n" + 
	"        simpleDBConfig.setAllowCreate(true);\n" + 
	"        simpleDBConfig.setTransactional(true);\n" + 
	"        simpleDBConfig.setSortedDuplicates(false);\n" + 
	"\n" + 
	"        // configurations for concurrent db's (non-transactional, deferred write)\n" + 
	"        final DatabaseConfig concurrentDBConfig = new DatabaseConfig();\n" + 
	"        concurrentDBConfig.setAllowCreate(true);\n" + 
	"        concurrentDBConfig.setDeferredWrite(true);    // reduce IO\n" + 
	"        concurrentDBConfig.setSortedDuplicates(false);\n" + 
	"\n" + 
	"        // adding views:\n" + 
	"        ~views:{it|this.~it.name;format=\"lowFirst\"~View = new ~it.name~View(dbEnvironment.openDatabase(null, \"~it.name~\", simpleDBConfig), dbEnvironment);};separator=\"\\n\"~\n" + 
	"\n" + 
	"        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {\n" + 
	"            @Override\n" + 
	"            public void run() {\n" + 
	"                log.warn(\"shutting down ~name~\");\n" + 
	"                ~views:{it|~it.name;format=\"lowFirst\"~View.close();};separator=\"\\n\"~\n" + 
	"                javaCatalog.close();\n" + 
	"                dbEnvironment.close();\n" + 
	"            }\n" + 
	"        }));\n" + 
	"    }\n" + 
	"\n" + 
	"~views:{it|\n" + 
	"		public ~it.name~View get~it.name~View() {\n" + 
	"			return ~it.name;format=\"lowFirst\"~View;\n" + 
	"	~eom()~};separator=\"\\n\"~\n" + 
	"   \n" + 
	"	~views:{it|~it.classDecl~};separator=\"\\n\\n\"~\n" + 
	"\n" + 
	"   private static File tryToCreateDirIfNotExists(File f) {\n" + 
	"   	if (!f.exists()) {\n" + 
	"      	if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())\n" + 
	"         	throw new RuntimeException(\"Could not create parent dirs for \" + f.getAbsolutePath());\n" + 
	"			if (!f.mkdir()) throw new RuntimeException(\"Could not create directory \" + f.getName());\n" + 
	"		}\n" + 
	"      return f;\n" + 
	"	}\n" + 
	"} >>\n")
		.append("ViewClassDecl(name,secondaryIndices) ::= <<public final class ~name~View {\n" + 
	"\n" + 
	"     private final com.sleepycat.je.Database database;\n" + 
	"     private final StoredMap<String, ~name~> map;\n" + 
	"\n" + 
	"     // secondary indices:\n" + 
	"     ~secondaryIndices:{it|~it.declaration~};separator=\"\\n\"~\n" + 
	"\n" + 
	"     private ~name~View(final com.sleepycat.je.Database database, final Environment env) {\n" + 
	"         this.database = database;\n" + 
	"         this.map = new StoredMap<String, ~name~>(database, new EntryBinding<String>() {\n" + 
	"             @Override\n" + 
	"             public String entryToObject(DatabaseEntry databaseEntry) {\n" + 
	"                 return new String(databaseEntry.getData());\n" + 
	"             }\n" + 
	"\n" + 
	"             @Override\n" + 
	"             public void objectToEntry(String key, DatabaseEntry databaseEntry) {\n" + 
	"                 databaseEntry.setData(key.getBytes());\n" + 
	"             }\n" + 
	"         }, new EntryBinding<~name~>() {\n" + 
	"             @Override\n" + 
	"             public ~name~ entryToObject(DatabaseEntry databaseEntry) {\n" + 
	"                 try {\n" + 
	"                     return ~name~.newBuilder().mergeFrom(databaseEntry.getData()).build();\n" + 
	"                 } catch (Throwable e) {\n" + 
	"                     log.error(\"Exception for ~name~ {}\", e);\n" + 
	"                     return null;\n" + 
	"                 }\n" + 
	"             }\n" + 
	"\n" + 
	"             @Override\n" + 
	"             public void objectToEntry(~name~ nodeGroup, DatabaseEntry databaseEntry) {\n" + 
	"                 databaseEntry.setData(nodeGroup.toByteArray());\n" + 
	"             }\n" + 
	"         }, true\n" + 
	"         );\n" + 
	"\n" + 
	"         // secondary indices:\n" + 
	"         ~secondaryIndices:{it|~it.initalization~};separator=\"\\n\"~\n" + 
	"     }\n" + 
	"\n" + 
	"     public void save~name~s(final List<~name~> elements) throws Exception {\n" + 
	"         final TransactionRunner runner = new TransactionRunner(database.getEnvironment());\n" + 
	"         runner.run(new TransactionWorker() {\n" + 
	"             @Override\n" + 
	"             public void doWork() throws Exception {\n" + 
	"                 for (~name~ entity : elements) {\n" + 
	"                     map.put(entity.getUuid(), entity);\n" + 
	"                 }\n" + 
	"             }\n" + 
	"         });\n" + 
	"     }\n" + 
	"\n" + 
	"     public void save~name~(final ~name~ entity) throws Exception {\n" + 
	"         final TransactionRunner runner = new TransactionRunner(database.getEnvironment());\n" + 
	"         runner.run(new TransactionWorker() {\n" + 
	"             @Override\n" + 
	"             public void doWork() throws Exception {\n" + 
	"                 map.put(entity.getUuid(), entity);\n" + 
	"             }\n" + 
	"         });\n" + 
	"     }\n" + 
	"\n" + 
	"     public void delete~name~(final String uuid) throws Exception {\n" + 
	"         final TransactionRunner runner = new TransactionRunner(database.getEnvironment());\n" + 
	"         runner.run(new TransactionWorker() {\n" + 
	"             @Override\n" + 
	"             public void doWork() throws Exception {\n" + 
	"                 map.remove(uuid);\n" + 
	"             }\n" + 
	"         });\n" + 
	"     }\n" + 
	"\n" + 
	"     public void delete~name~(final List<~name~> elements) throws Exception {\n" + 
	"         final TransactionRunner runner = new TransactionRunner(database.getEnvironment());\n" + 
	"         runner.run(new TransactionWorker() {\n" + 
	"             @Override\n" + 
	"             public void doWork() throws Exception {\n" + 
	"                 for (~name~ entity : elements)\n" + 
	"                     map.remove(entity.getUuid());\n" + 
	"             }\n" + 
	"         });\n" + 
	"   }\n" + 
	"\n" + 
	"   public Set<~name~> list~name~s() {\n" + 
	"      final Set<~name~> set = new LinkedHashSet<~name~>();\n" + 
	"      for (Map.Entry<String, ~name~> entry : map.entrySet()) {\n" + 
	"         if( entry.getValue() == null) continue;\n" + 
	"         set.add(entry.getValue());\n" + 
	"      }\n" + 
	"      return set;\n" + 
	"   }\n" + 
	"\n" + 
	"   ~secondaryIndices:{it|~it.accessor~};separator=\"\\n\"~\n" + 
	"   private void close() {\n" + 
	"       ~secondaryIndices:{it|~it.close~};separator=\"\\n\"~\n" + 
	"       database.close();\n" + 
	"   }\n" + 
	"\n" + 
	"   ~secondaryIndices:{it|~it.definition~};separator=\"\\n\"~\n" + 
	"\n" + 
	"} >>\n").toString();
} 