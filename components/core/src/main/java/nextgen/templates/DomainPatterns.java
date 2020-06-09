package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.domain.*;
import nextgen.templates.java.JavaST;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.java.Pojo;
import nextgen.templates.java.PojoFactory;
import nextgen.templates.neo4j.Neo4JST;
import nextgen.templates.neo4j.NeoFactory;
import nextgen.templates.neo4j.NeoFactoryAccessors;
import nextgen.templates.neo4j.NodeWrapper;
import nextgen.templates.vertx.JsonFactory;
import nextgen.templates.vertx.JsonWrapper;
import nextgen.templates.vertx.VertxST;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.JavaPatterns.writeEnum;
import static nextgen.templates.java.JavaST.newArrayList;
import static nextgen.templates.java.JavaST.newList;

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

    public static PrimitiveField newBooleanField(String name) {
        return newPrimitiveField().setName(name).setType(Boolean.class);
    }

    public static PrimitiveField newLongField(String name) {
        return newPrimitiveField().setName(name).setType(Long.class);
    }

    public static PrimitiveField newDoubleField(String name) {
        return newPrimitiveField().setName(name).setType(Double.class);
    }

    public static PrimitiveField newIntegerField(String name) {
        return newPrimitiveField().setName(name).setType(Integer.class);
    }

    public static PrimitiveField newStringField(String name) {
        return newStringField(name, false);
    }

    public static PrimitiveField newStringField(String name, boolean lexical) {
        return newPrimitiveField().setName(name).setType(String.class).setLexical(lexical);
    }

    public static ExternalReferenceField newOneToOneExternal(String name, Class<?> type) {
        return newExternalReferenceField().setName(name).setType(type);
    }

    public static ExternalReferenceList newOneToManyExternal(String name, Class<?> type) {
        return newExternalReferenceList().setName(name).setType(type);
    }

    public static ReferenceList newOneToMany(String name, Entity entity) {
        return newReferenceList().setName(name).setEntity(entity);
    }

    public static PrimitiveList newOneToManyString(String name) {
        return newPrimitiveList().setName(name).setType(String.class);
    }

    public static ReferenceList newOneToManySelf(String name) {
        return newReferenceList().setName(name).setSelf(Boolean.TRUE);
    }

    public static ReferenceField newOneToOne(String name, Entity entity) {
        return newOneToOne(name, entity, false);
    }

    public static ReferenceField newOneToOne(String name, Entity entity, boolean lexical) {
        return newReferenceField().setName(name).setEntity(entity).setLexical(lexical);
    }

    public static EnumField newEnumField(String name, Entity enumEntity) {
        return newEnumField().setName(name).setType(enumEntity);
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

        STGenerator.writeToFile(factory, packageDeclaration.getName(), factory.getName().toString(), "java", root);
    }

    private static Pojo generatePojo(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, Pojo> visited) {

        if (entity == null || visited.containsKey(entity)) return visited.get(entity);

        final Pojo entityClass = JavaST.newPojo()
                .setPackage(packageDeclaration.getName())
                .setName(entity.getName());

        visited.put(entity, entityClass);

        entity.getRelations().forEach(o -> {

            if (o instanceof PrimitiveField) {
                final PrimitiveField field = (PrimitiveField) o;
                entityClass.addAccessors(JavaST.newPrimitiveAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));
                entityClass.addFields(field.getType().getCanonicalName(), field.getName(), null);
                if (field.getLexical(false)) entityClass.addLexical(field.getName());

            } else if (o instanceof PrimitiveList) {
                final PrimitiveList field = (PrimitiveList) o;
                entityClass.addFields(newList().setType(field.getType().getCanonicalName()), field.getName(), null);
                entityClass.addAccessors(JavaST.newListAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof EnumField) {
                final EnumField field = (EnumField) o;
                entityClass.addFields(field.getType().getName(), field.getName(), null);
                entityClass.addAccessors(JavaST.newPrimitiveAccessors().setClassName(entity.getName()).setType(field.getType().getName()).setName(field.getName()));
                writeEnum(root, packageDeclaration, field.getType().getName(), field.getType().getEnumValues().toArray());

            } else if (o instanceof ReferenceField) {
                final ReferenceField field = (ReferenceField) o;
                final Entity fieldEntity = field.getEntity();
                entityClass.addFields(fieldEntity.getName(), field.getName(), null);
                entityClass.addAccessors(JavaST.newReferenceAccessors().setClassName(entity.getName()).setType(fieldEntity.getName()).setName(field.getName()));

                generatePojo(root, packageDeclaration, fieldEntity, visited);

            } else if (o instanceof ExternalReferenceField) {
                final ExternalReferenceField field = (ExternalReferenceField) o;
                entityClass.addFields(field.getType().getCanonicalName(), field.getName(), null);
                entityClass.addAccessors(JavaST.newReferenceAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof ExternalReferenceList) {
                final ExternalReferenceList field = (ExternalReferenceList) o;
                entityClass.addFields(newList().setType(field.getType().getCanonicalName()), field.getName(), JavaPatterns.newObjectCreationExpression().setType(newArrayList()));
                entityClass.addAccessors(JavaST.newListAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof ReferenceList) {
                final ReferenceList field = (ReferenceList) o;
                entityClass.addFields(newList().setType(field.getEntity().getName()), field.getName(), JavaPatterns.newObjectCreationExpression().setType(newArrayList()));
                entityClass.addAccessors(JavaST.newListAccessors().setClassName(entity.getName()).setType(field.getEntity().getName()).setName(field.getName()));

                generatePojo(root, packageDeclaration, field.getEntity(), visited);
            }
        });

        STGenerator.writeToFile(entityClass, packageDeclaration.getName(), entityClass.getName().toString(), "java", root);

        return entityClass;
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
                if (o instanceof PrimitiveField) {
                    final PrimitiveField field = (PrimitiveField) o;

                    factoryAccessors.addProperties(Neo4JST.newNeoFactoryPropertyAccessors()
                            .setEntity(key.getName())
                            .setPropertyName(field.getName())
                            .setPropertyType(field.getType().getSimpleName()));
                }
            });

            factory.addAccessors(factoryAccessors);

            key.getRelations().forEach(o -> {
                if (o instanceof ReferenceList) {
                    final ReferenceList field = (ReferenceList) o;
                    visited.get(field.getEntity()).addAccessors(Neo4JST.newIncomingReferenceStream()
                            .setName(field.getName())
                            .setType(key.getName()));

                } else if (o instanceof ReferenceField) {
                    final ReferenceField field = (ReferenceField) o;
                    visited.get(field.getEntity()).addAccessors(Neo4JST.newIncomingReferenceStream()
                            .setName(field.getName())
                            .setType(key.getName()));
                }
            });

            STGenerator.writeToFile(value, packageDeclaration.getName(), value.getName().toString(), "java", root);
        });

        STGenerator.writeToFile(factory, packageDeclaration.getName(), factory.getName().toString(), "java", root);
    }

    private static NodeWrapper generateNeoWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, NodeWrapper> visited) {

        if (entity == null || visited.containsKey(entity)) return visited.get(entity);

        final NodeWrapper entityClass = Neo4JST.newNodeWrapper()
                .setPackage(packageDeclaration.getName())
                .setName(entity.getName());

        visited.put(entity, entityClass);

        entity.getRelations().forEach(o -> {

            if (o instanceof PrimitiveField) {
                final PrimitiveField field = (PrimitiveField) o;
                entityClass.addAccessors(Neo4JST.newPrimitiveAccessors().setClassName(entity.getName()).setType(getType(field.getType().getCanonicalName())).setName(field.getName()));

                if (field.getLexical(false)) entityClass.addLexical(field.getName());

            } else if (o instanceof PrimitiveList) {
                final PrimitiveList field = (PrimitiveList) o;
                entityClass.addAccessors(Neo4JST.newListPrimitiveAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof EnumField) {
                final EnumField field = (EnumField) o;
                entityClass.addAccessors(Neo4JST.newEnumAccessors().setClassName(entity.getName()).setType(field.getType().getName()).setName(field.getName()));
                writeEnum(root, packageDeclaration, field.getType().getName(), field.getType().getEnumValues().toArray());

            } else if (o instanceof ReferenceField) {
                final ReferenceField field = (ReferenceField) o;
                final Entity fieldEntity = field.getEntity();
                entityClass.addAccessors(Neo4JST.newReferenceAccessors().setClassName(entity.getName()).setType(fieldEntity.getName()).setName(field.getName()));

                generateNeoWrapper(root, packageDeclaration, fieldEntity, visited);

            } else if (o instanceof ExternalReferenceField) {
                final ExternalReferenceField field = (ExternalReferenceField) o;
                entityClass.addExternalFields(field.getType().getCanonicalName(), field.getName(), null);
                entityClass.addAccessors(Neo4JST.newExternalAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof ReferenceList) {
                final ReferenceList field = (ReferenceList) o;

                entityClass.addAccessors(Neo4JST.newListReferenceAccessors()
                        .setClassName(entity.getName())
                        .setType(field.getSelf(false) ? entity.getName() : field.getEntity().getName())
                        .setName(field.getName()));

                entityClass.addAccessors(Neo4JST.newIncomingReferenceStream()
                        .setName(field.getName())
                        .setType(field.getSelf(false) ? entity.getName() : field.getEntity().getName()));

                generateNeoWrapper(root, packageDeclaration, field.getEntity(), visited);
            }
        });

        STGenerator.writeToFile(entityClass, packageDeclaration.getName(), entityClass.getName().toString(), "java", root);

        return entityClass;
    }

    // DOMAIN TO Vertx JsonObject wrappers:

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

        STGenerator.writeToFile(factory, packageDeclaration.getName(), factory.getName().toString(), "java", root);
    }

    private static JsonWrapper generateJsonWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Map<Entity, JsonWrapper> visited) {

        if (entity == null || visited.containsKey(entity)) return visited.get(entity);

        final JsonWrapper entityClass = VertxST.newJsonWrapper()
                .setPackage(packageDeclaration.getName())
                .setName(entity.getName());

        visited.put(entity, entityClass);

        entity.getRelations().forEach(o -> {

            if (o instanceof PrimitiveField) {
                final PrimitiveField field = (PrimitiveField) o;
                entityClass.addAccessors(VertxST.newPrimitiveAccessors().setClassName(entity.getName()).setType(getType(field.getType())).setName(field.getName()));

                if (field.getLexical(false)) entityClass.setLexical(field.getName());

            } else if (o instanceof PrimitiveList) {
                final PrimitiveList field = (PrimitiveList) o;
                entityClass.addAccessors(VertxST.newListPrimitiveAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof EnumField) {
                final EnumField field = (EnumField) o;
                entityClass.addAccessors(VertxST.newEnumAccessors().setClassName(entity.getName()).setType(field.getType().getName()).setName(field.getName()));
                writeEnum(root, packageDeclaration, field.getType().getName(), field.getType().getEnumValues().toArray());

            } else if (o instanceof ReferenceField) {
                final ReferenceField field = (ReferenceField) o;
                final Entity fieldEntity = field.getEntity();
                entityClass.addAccessors(VertxST.newReferenceAccessors().setClassName(entity.getName()).setType(fieldEntity.getName()).setName(field.getName()));

                generateJsonWrapper(root, packageDeclaration, fieldEntity, visited);

            } else if (o instanceof ExternalReferenceField) {
                final ExternalReferenceField field = (ExternalReferenceField) o;
                entityClass.addExternalFields(field.getType().getCanonicalName(), field.getName(), null);
                entityClass.addAccessors(VertxST.newExternalAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof ReferenceList) {
                final ReferenceList field = (ReferenceList) o;
                entityClass.addAccessors(VertxST.newListReferenceAccessors()
                        .setClassName(entity.getName())
                        .setType(field.getSelf(false) ? entity.getName() : field.getEntity().getName())
                        .setName(field.getName()));

                generateJsonWrapper(root, packageDeclaration, field.getEntity(), visited);
            }
        });

        STGenerator.writeToFile(entityClass, packageDeclaration.getName(), entityClass.getName().toString(), "java", root);
        return entityClass;
    }

    private static Object getType(Object type) {
        if (type instanceof Class<?>) return ((Class<?>) type).getSimpleName();
        return type;
    }
}