package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.domain.*;
import nextgen.templates.java.*;
import nextgen.templates.neo4j.*;
import nextgen.templates.vertx.JsonFactory;
import nextgen.templates.vertx.JsonWrapper;
import nextgen.templates.vertx.VertxST;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.JavaPatterns.writeEnum;
import static nextgen.templates.domain.RelationType.*;
import static nextgen.templates.java.JavaST.newArrayListType;
import static nextgen.templates.neo4j.Neo4JST.newDeleteNode;

public class DomainPatterns extends DomainST {

    public static Domain newDomain(String name) {
        return newDomain().setName(name);
    }

    public static Entity newEntity(String name) {
        return newEntity().setName(name);
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


    // DOMAIN TO BEANS:

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

        final PojoFactory factory = JavaST.newPojoFactory()
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

        final Bean entityClass = JavaST.newBean()
                .setPackage(packageDeclaration.getName())
                .setName(entityName);

        visited.put(entity, entityClass);

        entity.getRelations().forEach(o -> {

            switch (o.getType()) {

                case ENUM: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(dst.getName(), o.getName(), null);
                    entityClass.addAccessors(JavaST.newBoundedPrimitiveAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case ENUM_LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(JavaST.newListType().setType(dst.getName()), o.getName(), newArrayListType());
                    entityClass.addAccessors(JavaST.newBoundedListAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case EXT_REF: {
                    entityClass.addFields(getCanonicalName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(JavaST.newBoundedExternalReferenceAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case EXT_LIST: {
                    entityClass.addFields(JavaST.newListType().setType(getCanonicalName(o.getDst())), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newBoundedExternalListAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case PRIM_REF: {
                    entityClass.addFields(getSimpleName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(JavaST.newBoundedPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    if (o.getLexical(false)) entityClass.addLexical(o.getName());
                    break;
                }
                case PRIM_LIST: {
                    entityClass.addFields(JavaST.newListType().setType(getSimpleName(o.getDst())), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newBoundedListAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    break;
                }
                case REF: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(dst.getName(), o.getName(), null);
                    entityClass.addAccessors(JavaST.newBoundedReferenceAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

                    generateBean(root, packageDeclaration, dst, visited);
                    break;
                }
                case LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(JavaST.newListType().setType(dst.getName()), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newBoundedListReferenceAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

                    generateBean(root, packageDeclaration, dst, visited);
                    break;
                }
            }
        });

        STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName(), root);

    }

    // DOMAIN TO POJOs:
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

        final PojoFactory factory = JavaST.newPojoFactory()
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

        final Pojo entityClass = JavaST.newPojo()
                .setPackage(packageDeclaration.getName())
                .setName(entityName);

        visited.put(entity, entityClass);

        entity.getRelations().forEach(o -> {

            switch (o.getType()) {

                case ENUM: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(dst.getName(), o.getName(), null);
                    entityClass.addAccessors(JavaST.newPrimitiveAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case ENUM_LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(JavaST.newListType().setType(dst.getName()), o.getName(), newArrayListType());
                    entityClass.addAccessors(JavaST.newListAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case EXT_REF: {
                    entityClass.addFields(getCanonicalName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(JavaST.newReferenceAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case EXT_LIST: {
                    entityClass.addFields(JavaST.newListType().setType(getCanonicalName(o.getDst())), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newListAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case PRIM_REF: {
                    entityClass.addFields(getSimpleName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(JavaST.newPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    if (o.getLexical(false)) entityClass.addLexical(o.getName());
                    break;
                }
                case PRIM_LIST: {
                    entityClass.addFields(JavaST.newListType().setType(getSimpleName(o.getDst())), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newListAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    break;
                }
                case REF: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(dst.getName(), o.getName(), null);
                    entityClass.addAccessors(JavaST.newReferenceAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

                    generatePojo(root, packageDeclaration, dst, visited);
                    break;
                }
                case LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addFields(JavaST.newListType().setType(dst.getName()), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newListAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

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

    public static void writeNeo(File root, String packageName, Domain domain) {
        writeNeo(root, newPackageDeclaration(packageName), domain);
    }

    public static void writeNeo(File root, PackageDeclaration packageDeclaration, Domain domain) {

        final Map<Entity, NodeWrapper> visited = new LinkedHashMap<>();
        domain.getEntities().forEach(entity -> {

            if (entity.getIsEnum(false)) {
                writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
                return;
            }

            generateNeoWrapper(root, packageDeclaration, entity, visited);
        });

        // create incoming relations, AND neo-factory class

        final NeoFactory factory = Neo4JST.newNeoFactory()
                .setPackage(packageDeclaration.getName())
                .setName(domain.getName() + "NeoFactory");

        visited.forEach((key, value) -> {

            final NeoFactoryAccessors factoryAccessors = Neo4JST.newNeoFactoryAccessors()
                    .setName(key.getName());

            key.getRelations().forEach(o -> {
                switch (o.getType()) {
                    case ENUM: {
                        final Entity dst = asEntity(o.getDst());
                        factoryAccessors.addProperties(Neo4JST.newNeoFactoryPropertyAccessors()
                                .setEntity(key.getName())
                                .setPropertyName(o.getName())
                                .setPropertyType(dst.getName())
                                .setIsEnum(true));
                        break;
                    }

                    case PRIM_REF: {
                        factoryAccessors.addProperties(Neo4JST.newNeoFactoryPropertyAccessors()
                                .setEntity(key.getName())
                                .setPropertyName(o.getName())
                                .setPropertyType(getSimpleName(o.getDst())));
                        break;
                    }

                    case REF:
                    case LIST: {
                        final Entity dst = asEntity(o.getDst());
                        visited.get(dst).addAccessors(Neo4JST.newIncomingReferenceStream().setName(o.getName()).setType(key.getName()));
                        break;
                    }
                }
            });

            factory.addAccessors(factoryAccessors);

            STGenerator.writeJavaFile(value, packageDeclaration.getName(), value.getName().toString(), root);
        });

        STGenerator.writeJavaFile(factory, packageDeclaration.getName(), factory.getName().toString(), root);
    }

    private static void generateNeoWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, NodeWrapper> visited) {

        if (entity == null || visited.containsKey(entity)) {
            visited.get(entity);
            return;
        }

        final String entityName = entity.getName();

        final NodeWrapper entityClass = Neo4JST.newNodeWrapper()
                .setPackage(packageDeclaration.getName())
                .setName(entityName);

        visited.put(entity, entityClass);

        final NodeToJsonObject nodeToJsonObject = Neo4JST.newNodeToJsonObject();
        final DeleteNode deleteNode = newDeleteNode();

        entity.getRelations().forEach(o -> {

            switch (o.getType()) {

                case ENUM: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(Neo4JST.newEnumAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());

                    nodeToJsonObject.addProperties(o.getName());
                    break;
                }
                case ENUM_LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(Neo4JST.newEnumListAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());

                    nodeToJsonObject.addPrimitiveList(o.getName());
                    break;
                }
                case EXT_REF: {

                    entityClass.addExternalFields(getCanonicalName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(Neo4JST.newExternalAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case EXT_LIST: {

                    entityClass.addExternalFields(JavaST.newListType().setType(getCanonicalName(o.getDst())), o.getName(), JavaPatterns.newArrayListInstance());
                    entityClass.addAccessors(JavaST.newListAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case PRIM_REF: {
                    entityClass.addAccessors(Neo4JST.newPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    if (o.getLexical(false)) entityClass.addLexical(o.getName());

                    nodeToJsonObject.addProperties(o.getName());
                    break;
                }
                case PRIM_LIST: {
                    entityClass.addAccessors(Neo4JST.newListPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    nodeToJsonObject.addPrimitiveList(o.getName());
                    break;
                }
                case REF: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(Neo4JST.newReferenceAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    generateNeoWrapper(root, packageDeclaration, dst, visited);

                    nodeToJsonObject.addRefs(dst.getName(), o.getName());
                    deleteNode.addRefs(dst.getName(), o.getName());
                    break;
                }
                case LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(Neo4JST.newListReferenceAccessors().setClassName(entityName).setType(o.getSelf(false) ? entityName : dst.getName()).setName(o.getName()));
                    entityClass.addAccessors(Neo4JST.newIncomingReferenceStream().setName(o.getName()).setType(o.getSelf(false) ? entityName : dst.getName()));
                    generateNeoWrapper(root, packageDeclaration, dst, visited);

                    nodeToJsonObject.addRefList(o.getName());
                    deleteNode.addRefList(o.getName());
                    break;
                }
            }
        });

        entityClass.addMethods(nodeToJsonObject);
        entityClass.addMethods(deleteNode);

        STGenerator.writeJavaFile(entityClass, packageDeclaration.getName(), entityClass.getName().toString(), root);

    }

    // DOMAIN TO Vertx JsonObject wrappers:

    public static void writeJsonWrapper(File root, String packageName, Domain domain) {
        writeJsonWrapper(root, newPackageDeclaration(packageName), domain);
    }

    public static void writeJsonWrapper(File root, PackageDeclaration packageDeclaration, Domain domain) {
        writeJsonWrapper(root, packageDeclaration, domain, false);
    }

    public static void writeJsonWrapper(File root, PackageDeclaration packageDeclaration, Domain domain, boolean addNeoNodeMapper) {

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
            visited.get(entity);
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
                    entityClass.addAccessors(VertxST.newEnumAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case ENUM_LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(VertxST.newListEnumAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));
                    writeEnum(root, packageDeclaration, dst.getName(), dst.getEnumValues().toArray());
                    break;
                }
                case EXT_REF: {

                    entityClass.addExternalFields(getCanonicalName(o.getDst()), o.getName(), null);
                    entityClass.addAccessors(VertxST.newExternalAccessors().setClassName(entityName).setType(getCanonicalName(o.getDst())).setName(o.getName()));
                    break;
                }
                case EXT_LIST: {
                    break;
                }
                case PRIM_REF: {

                    entityClass.addAccessors(VertxST.newPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    if (o.getLexical(false)) entityClass.setLexical(o.getName());
                    break;
                }
                case PRIM_LIST: {

                    entityClass.addAccessors(VertxST.newListPrimitiveAccessors().setClassName(entityName).setType(getSimpleName(o.getDst())).setName(o.getName()));
                    break;
                }
                case REF: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(VertxST.newReferenceAccessors().setClassName(entityName).setType(dst.getName()).setName(o.getName()));

                    generateJsonWrapper(root, packageDeclaration, dst, visited);
                    break;
                }
                case LIST: {
                    final Entity dst = asEntity(o.getDst());
                    entityClass.addAccessors(VertxST.newListReferenceAccessors().setClassName(entityName).setType(o.getSelf(false) ? entityName : dst.getName()).setName(o.getName()));

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

//    private static Class<?> asClass(Object type) {
//        return (Class<?>) type;
//    }

    public static String newType(PackageDeclaration packageDeclaration, String name) {
        return packageDeclaration.getName() + "." + name;
    }
}