package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.domain.*;
import nextgen.templates.java.Enum;
import nextgen.templates.java.*;
import nextgen.templates.javaneo4jembedded.*;
import nextgen.templates.vertx.JsonFactory;
import nextgen.templates.vertx.JsonWrapper;
import nextgen.templates.vertx.VertxST;

import java.io.File;
import java.util.*;

import static nextgen.templates.JavaPatterns.newClassOrInterfaceType;
import static nextgen.templates.domain.RelationType.*;
import static nextgen.templates.java.JavaST.*;

public class DomainPatterns extends DomainST {

   public static class DomainVisitor {

      private final Set<Entity> visited = new LinkedHashSet<>();

      public final void visit(Domain domain) {
         startDomain(domain);
         domain.getEntities().forEach(this::visit);
         endDomain(domain);
      }

      public final void visit(Entity entity) {

         if (visited.contains(entity)) return;
         visited.add(entity);

         startEntity(entity);
         entity.getRelations().forEach(relation -> visit(entity, relation));
         endEntity(entity);
      }

      public final void visit(Entity entity, Relation relation) {

         switch (relation.getType()) {
            case ENUM:
               onENUM(entity, relation);
               break;
            case EXT_REF:
               onEXT_REF(entity, relation);
               break;
            case EXT_LIST:
               onEXT_LIST(entity, relation);
               break;
            case PRIM_REF:
               onPRIM_REF(entity, relation);
               break;
            case PRIM_LIST:
               onPRIM_LIST(entity, relation);
               break;
            case REF:
               onREF(entity, relation);
               break;
            case LIST:
               onLIST(entity, relation);
               break;
            case ENUM_LIST:
               onENUM_LIST(entity, relation);
               break;
         }

         if (dstIsEntity(relation))
            visit((Entity) relation.getDst());
      }

      protected boolean dstIsEntity(Relation relation) {
         return relation.getDst() instanceof Entity;
      }

      protected Entity dstEntity(Relation relation) {
         return (Entity) relation.getDst();
      }

      protected void startDomain(Domain domain) {

      }

      protected void startEntity(Entity entity) {

      }

      protected void onENUM(Entity src, Relation relation) {

      }

      protected void onEXT_REF(Entity src, Relation relation) {

      }

      protected void onEXT_LIST(Entity src, Relation relation) {

      }

      protected void onPRIM_REF(Entity src, Relation relation) {

      }

      protected void onPRIM_LIST(Entity src, Relation relation) {

      }

      protected void onREF(Entity src, Relation relation) {

      }

      protected void onLIST(Entity src, Relation relation) {

      }

      protected void onENUM_LIST(Entity src, Relation relation) {

      }

      protected void endEntity(Entity src) {

      }

      protected void endDomain(Domain domain) {

      }
   }

   public static Domain newDomain(String name) {
      return newDomain().setName(name);
   }

   public static Entity newEntity(String name) {
      return newEntity().setName(name);
   }

   public static Entity newEntityWithUuid(String name) {
      return newEntity()
            .setName(name)
            .addRelations(DomainPatterns.newStringField("uuid"));
   }

   public static Entity newEnum(String name, String... values) {
      final Entity entity = newEntity().setIsEnum(true).setName(name);
      for (String value : values) entity.addEnumValues(value.trim());
      return entity;
   }

   public static Relation newRelation(RelationType relationType) {
      return newRelation().setType(relationType);
   }

   public static Relation newRelation(RelationType relationType, String name) {
      return newRelation(ENUM).setType(relationType).setName(name);
   }

   public static Relation newEnumField(String name, String enumName, String enumValues) {
      return newRelation(ENUM).setName(name).setDst(newEnum(enumName, enumValues));
   }

   public static Relation newEnumList(String name, String enumName, String enumValues) {
      return newRelation(ENUM_LIST).setName(name).setDst(newEnum(enumName, enumValues));
   }

   public static Relation newEnumField(String name, Entity enumEntity) {
      if (!enumEntity.getIsEnum(false))
         throw new IllegalArgumentException("entity " + enumEntity.getName() + " in relation " + name + " is not an enum-entity");
      return newRelation(ENUM, name).setDst(enumEntity);
   }

   public static Relation newPrimitiveRef(String name, Class<?> dstType) {
      return newRelation(PRIM_REF, name).setDst(dstType);
   }

   public static Relation newPrimitiveList(String name, Class<?> dstType) {
      return newRelation(PRIM_LIST, name).setDst(dstType);
   }

   public static Relation newExternalRef(String name, Class<?> dstType) {
      return newRelation(EXT_REF, name).setDst(dstType);
   }

   public static Relation newExternalRef(String name, String dstType) {
      return newRelation(EXT_REF, name).setDst(dstType);
   }

   public static Relation newExternalList(String name, Class<?> dstType) {
      return newRelation(EXT_LIST, name).setDst(dstType);
   }

   public static Relation newRef(String name, Entity dstType) {
      return newRelation(REF, name).setDst(dstType);
   }

   public static Relation newList(String name, Entity dstType) {
      return newRelation(LIST, name).setDst(dstType);
   }

   public static Relation newBooleanField(String name) {
      return newPrimitiveRef(name, Boolean.class);
   }

   public static Relation newLongField(String name) {
      return newPrimitiveRef(name, Long.class);
   }

   public static Relation newDoubleField(String name) {
      return newPrimitiveRef(name, Double.class);
   }

   public static Relation newIntegerField(String name) {
      return newPrimitiveRef(name, Integer.class);
   }

   public static Relation newStringField(String name, boolean lexical) {
      return newPrimitiveRef(name, String.class).setLexical(lexical);
   }

   public static Relation newStringField(String name) {
      return newStringField(name, false);
   }

   public static Relation newOneToOneExternal(String name, Class<?> type) {
      return newExternalRef(name, type);
   }

   public static Relation newOneToOneExternal(String name, String type) {
      return newExternalRef(name, type);
   }

   public static Relation newOneToManyExternal(String name, Class<?> type) {
      return newExternalList(name, type);
   }

   public static Relation newOneToMany(String name, Entity entity) {
      return newList(name, entity);
   }

   public static Relation newOneToManyString(String name) {
      return newPrimitiveList(name, String.class);
   }

   public static Relation newOneToManySelf(String name) {
      return newRelation(LIST, name).setSelf(Boolean.TRUE);
   }

   public static Relation newOneToOne(String name, Entity entity) {
      return newRef(name, entity);
   }

   public static Relation newOneToOne(String name, Entity entity, boolean lexical) {
      return newRef(name, entity).setLexical(lexical);
   }

   public static ObjectCreationExpression newArrayListInstance() {
      return newObjectCreationExpression().setType(newClassOrInterfaceType("java.util", "ArrayList").setIsTyped(true));
   }

   private static PackageDeclaration newPackageDeclaration(String packageName) {
      return JavaST.newPackageDeclaration().setName(packageName);
   }

   // DOMAIN TO BEANS:

   public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Object[] enumValues) {
      final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration.getName());
      for (Object enumValue : enumValues)
         content.addEnumValues(enumValue);
      STGenerator.writeJavaFile(content, packageDeclaration.getName(), name, root);
   }

   public static void writeBean(File root, String packageName, Domain domain) {
      writeBean(root, newPackageDeclaration(packageName), domain);
   }

   public static void writeBean(File root, PackageDeclaration packageDeclaration, Domain domain) {

      final Map<Entity, Bean> visited = new LinkedHashMap<>();
      domain.getEntities().forEach(entity -> {

         if (entity.getIsEnum(false)) {
            writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
            return;
         }

         generateBean(root, packageDeclaration, entity, visited);
      });

      final PojoFactory factory = newPojoFactory()
            .setPackage(packageDeclaration.getName())
            .setName(domain.getName() + "Factory");

      visited.forEach((entity, pojo) -> factory.addEntities(entity.getName()));

      STGenerator.writeJavaFile(factory, packageDeclaration.getName(), factory.getName().toString(), root);
   }

   private static void generateBean(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, Bean> visited) {

      if (entity == null || visited.containsKey(entity)) {
         visited.get(entity);
         return;
      }

      final String entityName = entity.getName();

      final BeanListener beanListener = newBeanListener()
            .setName(entityName);

      final Bean entityClass = newBean()
            .setPackage(packageDeclaration.getName())
            .setName(entityName)
            .setBeanListener(beanListener)
            .setEqha(entity.getEqha());

      visited.put(entity, entityClass);

      entity.getRelations().forEach(o -> {

         switch (o.getType()) {

            case ENUM: {
               final Entity dst = asEntity(o.getDst());

               final String type = dst.getName();
               final String name = o.getName();

               entityClass.addFields(type, name, null);
               entityClass.addAccessors(newBoundedPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(type)
                     .setName(name));

               beanListener.addSingleProperties(name, type);

               if (o.getLexical(false)) entityClass.addLexical(name);

               writeEnum(root, packageDeclaration, type, dst.getEnumValues().toArray());

               break;
            }
            case ENUM_LIST: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(dst.getName()), o.getName(), newArrayListInstance());
               entityClass.addAccessors(newBoundedListAccessors().setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               beanListener.addListProperties(o.getName(), dst.getName());
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
               break;
            }
            case EXT_REF: {
               entityClass.addFields(getCanonicalName(o.getDst()), o.getName(), null);
               entityClass.addAccessors(newBoundedExternalReferenceAccessors().setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               beanListener.addSingleProperties(o.getName(), getCanonicalName(o.getDst()));
               if (o.getLexical(false)) entityClass.addLexical(o.getName());
               break;
            }
            case EXT_LIST: {
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(getCanonicalName(o.getDst())), o
                     .getName(), newArrayListInstance());
               entityClass.addAccessors(newBoundedExternalListAccessors().setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               beanListener.addListProperties(o.getName(), getCanonicalName(o.getDst()));
               break;
            }
            case PRIM_REF: {

               final String type = getSimpleName(o.getDst());
               final String name = o.getName();

               entityClass.addFields(type, name, null);
               entityClass.addAccessors(newBoundedPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(type)
                     .setName(name));

               if (o.getLexical(false)) entityClass.addLexical(name);

               beanListener.addSingleProperties(name, type);

               break;
            }
            case PRIM_LIST: {

               final String type = getSimpleName(o.getDst());
               final String name = o.getName();

               entityClass.addFields(newClassOrInterfaceType("java.util", "List")
                     .addTypeArguments(type), name, newArrayListInstance());
               entityClass.addAccessors(newBoundedListAccessors()
                     .setClassName(entityName)
                     .setType(type)
                     .setName(name));

               beanListener.addListProperties(name, type);

               break;
            }
            case REF: {

               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;

               final String type = dst.getName();
               final String name = o.getName();

               entityClass.addFields(type, name, null);

               entityClass.addAccessors(newBoundedReferenceAccessors()
                     .setClassName(entityName)
                     .setType(type)
                     .setName(name));

               beanListener.addSingleProperties(name, type);

               if (o.getLexical(false)) entityClass.addLexical(name);

               generateBean(root, packageDeclaration, dst, visited);
               break;
            }
            case LIST: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;

               final String type = dst.getName();
               final String name = o.getName();

               entityClass.addFields(newClassOrInterfaceType("java.util", "List")
                     .addTypeArguments(type), name, newArrayListInstance());

               entityClass.addAccessors(newBoundedListReferenceAccessors().setClassName(entityName)
                     .setType(type)
                     .setName(name));

               beanListener.addListProperties(name, type);

               generateBean(root, packageDeclaration, dst, visited);
               break;
            }
         }
      });

      STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName(), root);

   }

   // DOMAIN TO POJOs:
   public static void writePojo(String root, String packageName, Domain domain) {
      writePojo(new File(root), newPackageDeclaration(packageName), domain);
   }

   public static void writePojo(File root, String packageName, Domain domain) {
      writePojo(root, newPackageDeclaration(packageName), domain);
   }

   public static void writePojo(File root, PackageDeclaration packageDeclaration, Domain domain) {

      final Map<Entity, Pojo> visited = new LinkedHashMap<>();
      domain.getEntities().forEach(entity -> {

         if (entity.getIsEnum(false)) {
            writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
            return;
         }

         generatePojo(root, packageDeclaration, entity, visited);
      });

      final PojoFactory factory = newPojoFactory()
            .setPackage(packageDeclaration.getName())
            .setName(domain.getName() + "Factory");

      visited.forEach((entity, pojo) -> factory.addEntities(entity.getName()));

      STGenerator.writeJavaFile(factory, packageDeclaration.getName(), factory.getName().toString(), root);
   }

   private static void generatePojo(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, Pojo> visited) {

      if (entity == null || visited.containsKey(entity)) {
         visited.get(entity);
         return;
      }

      final String entityName = entity.getName();

      final Pojo entityClass = newPojo()
            .setPackage(packageDeclaration.getName())
            .setName(entityName);

      visited.put(entity, entityClass);

      entity.getRelations().forEach(o -> {

         switch (o.getType()) {

            case ENUM: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addFields(dst.getName(), o.getName(), null);
               entityClass.addAccessors(newPrimitiveAccessors().setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
               break;
            }
            case ENUM_LIST: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(dst.getName()), o.getName(), newArrayListInstance());
               entityClass.addAccessors(newListAccessors().setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
               break;
            }
            case EXT_REF: {
               entityClass.addFields(getCanonicalName(o.getDst()), o.getName(), null);
               entityClass.addAccessors(newReferenceAccessors().setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case EXT_LIST: {
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(getCanonicalName(o.getDst())), o
                     .getName(), newArrayListInstance());
               entityClass.addAccessors(newListAccessors().setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case PRIM_REF: {
               entityClass.addFields(getSimpleName(o.getDst()), o.getName(), null);
               entityClass.addAccessors(newPrimitiveAccessors().setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               if (o.getLexical(false)) entityClass.addLexical(o.getName());
               break;
            }
            case PRIM_LIST: {
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(getSimpleName(o.getDst())), o
                     .getName(), newArrayListInstance());
               entityClass.addAccessors(newListAccessors().setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case REF: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;
               entityClass.addFields(dst.getName(), o.getName(), null);
               entityClass.addAccessors(newReferenceAccessors().setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));

               generatePojo(root, packageDeclaration, dst, visited);
               break;
            }
            case LIST: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;
               entityClass.addFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(dst.getName()), o.getName(), newArrayListInstance());
               entityClass.addAccessors(newListAccessors().setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));

               generatePojo(root, packageDeclaration, dst, visited);
               break;
            }
         }
      });

      STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName(), root);

   }

   private static String getCanonicalName(Object dst) {
      return dst instanceof Class ? ((Class) dst).getCanonicalName() : dst.toString();
   }

   private static String getSimpleName(Object dst) {
      return dst instanceof Class ? ((Class) dst).getSimpleName() : dst.toString();
   }

   // DOMAIN TO NEO4J wrappers:

   public static void writeNeo(String root, String packageName, Domain domain) {
      writeNeo(new File(root), newPackageDeclaration(packageName), domain);
   }

   public static void writeNeo(File root, String packageName, Domain domain) {
      writeNeo(root, newPackageDeclaration(packageName), domain);
   }

   public static void writeNeo(File root, PackageDeclaration packageDeclaration, Domain domain) {
      writeNeo(root, packageDeclaration, domain, false);
   }

   public static void writeNeo(File root, PackageDeclaration packageDeclaration, Domain domain, boolean useUuid) {

      final Map<Entity, NodeWrapper> visited = new LinkedHashMap<>();
      domain.getEntities().forEach(entity -> {

         if (entity.getIsEnum(false)) {
            writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
            return;
         }

         generateNeoWrapper(root, packageDeclaration, entity, visited, useUuid);
      });

      // create neo-factory class

      final NeoFactory factory = JavaNeo4JEmbeddedST.newNeoFactory()
            .setPackage(packageDeclaration.getName())
            .setName(domain.getName() + "NeoFactory");

      visited.forEach((key, value) -> {

         final NeoFactoryAccessors factoryAccessors = JavaNeo4JEmbeddedST.newNeoFactoryAccessors()
               .setName(key.getName());

         key.getRelations().forEach(o -> {
            switch (o.getType()) {
               case ENUM: {
                  final Entity dst = asEntity(o.getDst());
                  factoryAccessors.addProperties(JavaNeo4JEmbeddedST.newNeoFactoryPropertyAccessors()
                        .setEntity(key.getName())
                        .setPropertyName(o.getName())
                        .setPropertyType(dst.getName())
                        .setIsEnum(true));
                  break;
               }

               case PRIM_REF: {
                  factoryAccessors.addProperties(JavaNeo4JEmbeddedST.newNeoFactoryPropertyAccessors()
                        .setEntity(key.getName())
                        .setPropertyName(o.getName())
                        .setPropertyType(getSimpleName(o.getDst())));
                  break;
               }
            }
         });

         factory.addAccessors(factoryAccessors);

         STGenerator.writeJavaFile(value, packageDeclaration.getName(), value.getName().toString(), root);
      });

      STGenerator.writeJavaFile(factory, packageDeclaration.getName(), factory.getName().toString(), root);
   }

   private static NodeWrapper generateNeoWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, NodeWrapper> visited, boolean useUuid) {

      if (entity == null || visited.containsKey(entity)) {
         visited.get(entity);
         return visited.get(entity);
      }

      final String entityName = entity.getName();

      final NodeWrapper entityClass = JavaNeo4JEmbeddedST.newNodeWrapper()
            .setPackage(packageDeclaration.getName())
            .setName(entityName)
            .setUseUuid(useUuid);

      visited.put(entity, entityClass);

      final NodeToJsonObject nodeToJsonObject = JavaNeo4JEmbeddedST.newNodeToJsonObject();
      final DeleteNode deleteNode = JavaNeo4JEmbeddedST.newDeleteNode();

      entity.getRelations().forEach(o -> {

         switch (o.getType()) {

            case ENUM: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addAccessors(JavaNeo4JEmbeddedST.newEnumAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());

               nodeToJsonObject.addProperties(o.getName());
               break;
            }
            case ENUM_LIST: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addAccessors(JavaNeo4JEmbeddedST.newEnumListAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());

               nodeToJsonObject.addPrimitiveList(o.getName());
               break;
            }
            case EXT_REF: {

               entityClass.addExternalFields(getCanonicalName(o.getDst()), o.getName(), null);
               entityClass.addAccessors(JavaNeo4JEmbeddedST.newExternalAccessors()
                     .setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case EXT_LIST: {

               entityClass.addExternalFields(newClassOrInterfaceType("java.util", "List").addTypeArguments(getCanonicalName(o
                     .getDst())), o.getName(), newArrayListInstance());
               entityClass.addAccessors(newListAccessors().setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case PRIM_REF: {
               entityClass.addAccessors(JavaNeo4JEmbeddedST.newPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               //if (o.getLexical(false)) entityClass.addLexical(o.getName());

               nodeToJsonObject.addProperties(o.getName());
               break;
            }
            case PRIM_LIST: {
               entityClass.addAccessors(JavaNeo4JEmbeddedST.newListPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               nodeToJsonObject.addPrimitiveList(o.getName());
               break;
            }
            case REF: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;

               entityClass.addAccessors(JavaNeo4JEmbeddedST.newReferenceAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));

               final NodeWrapper nodeWrapper = generateNeoWrapper(root, packageDeclaration, dst, visited, useUuid);
               nodeWrapper.addAccessors(JavaNeo4JEmbeddedST.newIncomingReferenceStream()
                     .setName(o.getName())
                     .setType(o.getSelf(false) ? entityName : entityClass.getName()));

               nodeToJsonObject.addRefs(dst.getName(), o.getName());
               break;
            }
            case LIST: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;

               entityClass.addAccessors(JavaNeo4JEmbeddedST.newListReferenceAccessors()
                     .setClassName(entityName)
                     .setType(o.getSelf(false) ? entityName : dst.getName())
                     .setName(o.getName()));

               final NodeWrapper nodeWrapper = generateNeoWrapper(root, packageDeclaration, dst, visited, useUuid);
               nodeWrapper.addAccessors(JavaNeo4JEmbeddedST.newIncomingReferenceStream()
                     .setName(o.getName())
                     .setType(o.getSelf(false) ? entityName : entityClass.getName()));

               nodeToJsonObject.addRefList(o.getName());
               break;
            }
         }
      });

      entityClass.addMethods(nodeToJsonObject);
      entityClass.addMethods(deleteNode);

      //STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName().toString(), root);
      return entityClass;
   }

   // DOMAIN TO Vertx JsonObject wrappers:

   public static void writeJsonWrapper(String root, String packageName, Domain domain) {
      writeJsonWrapper(new File(root), packageName, domain);
   }

   public static void writeJsonWrapper(File root, String packageName, Domain domain) {
      writeJsonWrapper(root, newPackageDeclaration(packageName), domain);
   }

   public static void writeJsonWrapper(File root, PackageDeclaration packageDeclaration, Domain domain) {

      final Map<Entity, JsonWrapper> visited = new LinkedHashMap<>();
      domain.getEntities().forEach(entity -> {

         if (entity.getIsEnum(false)) {
            writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
            return;
         }

         generateJsonWrapper(root, packageDeclaration, entity, visited);
      });

      final JsonFactory factory = VertxST.newJsonFactory()
            .setPackage(packageDeclaration.getName())
            .setName(domain.getName() + "JsonFactory");

      visited.forEach((entity, jsonWrapper) -> factory.addEntities(entity.getName()));

      STGenerator.writeJavaFile(factory, packageDeclaration.getName(), factory.getName().toString(), root);
   }

   private static void generateJsonWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, JsonWrapper> visited) {

      if (entity == null || visited.containsKey(entity)) {
         return;
      }

      final String entityName = entity.getName();
      final JsonWrapper entityClass = VertxST.newJsonWrapper()
            .setPackage(packageDeclaration.getName())
            .setName(entityName);

      visited.put(entity, entityClass);

      entity.getRelations().forEach(o -> {

         switch (o.getType()) {

            case ENUM: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addAccessors(VertxST.newEnumAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));

               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
               break;
            }
            case ENUM_LIST: {
               final Entity dst = asEntity(o.getDst());
               entityClass.addAccessors(VertxST.newListEnumAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));
               writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
               break;
            }
            case EXT_REF: {

               entityClass.addExternalFields(getCanonicalName(o.getDst()), o.getName(), null);
               entityClass.addAccessors(VertxST.newExternalAccessors()
                     .setClassName(entityName)
                     .setType(getCanonicalName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case EXT_LIST: {


               break;
            }
            case PRIM_REF: {

               entityClass.addAccessors(VertxST.newPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               if (o.getLexical(false)) entityClass.setLexical(o.getName());
               break;
            }
            case PRIM_LIST: {

               entityClass.addAccessors(VertxST.newListPrimitiveAccessors()
                     .setClassName(entityName)
                     .setType(getSimpleName(o.getDst()))
                     .setName(o.getName()));
               break;
            }
            case REF: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;
               entityClass.addAccessors(VertxST.newReferenceAccessors()
                     .setClassName(entityName)
                     .setType(dst.getName())
                     .setName(o.getName()));

               generateJsonWrapper(root, packageDeclaration, dst, visited);
               break;
            }
            case LIST: {
               Entity dst = asEntity(o.getDst());
               if (dst == null && o.getSelf(false)) dst = entity;
               entityClass.addAccessors(VertxST.newListReferenceAccessors()
                     .setClassName(entityName)
                     .setType(o.getSelf(false) ? entityName : dst.getName())
                     .setName(o.getName()));

               generateJsonWrapper(root, packageDeclaration, dst, visited);
               break;
            }
         }
      });

      STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName(), root);
   }

   private static Entity asEntity(Object type) {
      return (Entity) type;
   }
}