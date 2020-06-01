package nextgen.domain;

import nextgen.domain.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.generator.util.StringUtil.capitalize;
import static com.generator.util.StringUtil.lowFirst;

public class DomainPatterns extends DomainFactory {

    public static abstract class DomainVisitor {

        public DomainVisitor(Domain domain) {
            visit(domain);
        }

        private void visit(Domain domain) {
            System.out.println("visit " + domain.getName());
            start(domain);
            visitEntities(domain);
            visitRelations(domain);
            end();
        }

        protected abstract void start(Domain domain);

        public void visitEntities(Domain domain) {
            domain.getEntities().forEach(entity -> {
                System.out.println("\tvisit " + debug(entity));
                switch (entity.getType()) {
                    case PRIMITIVE:
                        onPrimitive(entity);
                        break;
                    case REFERENCE:
                        onReference(entity);
                        break;
                    case EXTERNAL:
                        onExternal(entity);
                        break;
                    case ENUM:
                        onEnum(entity);
                        break;
                }
            });
        }

        protected abstract void onPrimitive(Entity entity);

        protected abstract void onReference(Entity entity);

        protected abstract void onExternal(Entity entity);

        protected abstract void onEnum(Entity entity);

        public void visitRelations(Domain domain) {
            domain.getRelations().forEach(relation -> {
                System.out.println("\tvisit " + debug(relation.getSrc()) + " -> " + relation.getName() + " (" + relation.getType() + ") -> " + debug(relation.getDst()));

                switch (relation.getType()) {
                    case OneToOne:
                        visitOneToOne(relation);
                        break;
                    case OneToMany:
                        visitOneToMany(relation);
                        break;
                }
            });
        }

        protected abstract void visitOneToOne(Relation relation);

        protected abstract void visitOneToMany(Relation relation);

        protected abstract void end();

        private String debug(Entity entity) {
            return entity.getName() + " (" + entity.getType() + ")";
        }
    }

    public static DomainBuilder newDomainBuilder(String name) {
        return new DomainBuilder(name);
    }

    public static EntityBuilder newEntityBuilder(String name) {
        return new EntityBuilder(name, EntityType.REFERENCE);
    }

    public static class DomainBuilder extends Domain {

        public DomainBuilder(String name) {
            setName(name);
        }

        @Override
        public DomainBuilder setExtendsClass(String className) {
            super.setExtendsClass(className);
            return this;
        }

        public DomainBuilder setExtendsClass(Class<?> aClass) {
            this.setExtendsClass(aClass.getCanonicalName());
            return this;
        }

        public DomainBuilder add(Entity entity) {

            switch (entity.getType()) {

                case REFERENCE:
                case ENUM:

                    final Optional<Entity> existing = getEntities().stream()
                            .filter(entity1 -> entity1.getType().equals(EntityType.ENUM) || entity.getType().equals(EntityType.REFERENCE))
                            .filter(entity1 -> entity1.equals(entity))
                            .findAny();

                    if (!existing.isPresent()) addEntities(entity);
                    break;
            }

            if (entity instanceof EntityBuilder) {
                for (Relation relation : ((EntityBuilder) entity).relations) {
                    final Optional<Relation> existingRelation = getRelations().stream()
                            .filter(relation1 -> relation1.equals(relation))
                            .findAny();
                    if (!existingRelation.isPresent()) addRelations(relation);

                    add(relation.getDst());
                }
            }

            return this;
        }
    }

    public static class EntityBuilder extends Entity {

        private final List<Relation> relations = new ArrayList<>();

        public EntityBuilder(String name, EntityType entityType) {
            setName(name);
            setType(entityType);
        }

        public EntityBuilder addExternalField(String name, Class<?> className) {
            relations.add(newOneToOneRelation(name, this, newExternalEntity(className)));
            return this;
        }

        public EntityBuilder addExternalField(String name, String className) {
            relations.add(newOneToOneRelation(name, this, newExternalEntity(className)));
            return this;
        }

        public EntityBuilder addLongField(String name) {
            relations.add(newOneToOneRelation(name, this, newLong()));
            return this;
        }

        public EntityBuilder addDoubleField(String name) {
            relations.add(newOneToOneRelation(name, this, newDouble()));
            return this;
        }

        public EntityBuilder addStringField(String name) {
            relations.add(newOneToOneRelation(name, this, newString()));
            return this;
        }

        public EntityBuilder addStringField(String name, boolean lexical) {
            relations.add(newOneToOneRelation(name, this, newString()).setLexical(lexical));
            return this;
        }

        public EntityBuilder addBooleanField(String name) {
            relations.add(newOneToOneRelation(name, this, newBoolean()));
            return this;
        }

        public EntityBuilder addIntegerField(String name) {
            relations.add(newOneToOneRelation(name, this, newInteger()));
            return this;
        }

        public EntityBuilder addEnumField(String name, String enumName, String enumValues) {
            relations.add(newOneToOneRelation(name, this, newEnumEntity(enumName, enumValues)));
            return this;
        }

        public EntityBuilder addOneToOneRelation(String name, Entity dst) {
            relations.add(newOneToOneRelation(name, this, dst));
            return this;
        }

        public EntityBuilder addOneToManyRelation(String name, Entity dst) {
            relations.add(newOneToManyRelation(name, this, dst));
            return this;
        }
    }

    public static Entity newPrimitiveEntity(String name) {
        return newEntity().setType(EntityType.PRIMITIVE).setName(name);
    }

    public static Entity newExternalEntity(String name) {
        return newEntity().setType(EntityType.EXTERNAL).setName(name);
    }

    public static Entity newExternalEntity(Class<?> aClass) {
        return newExternalEntity(aClass.getCanonicalName());
    }

    public static Entity newString() {
        return newPrimitiveEntity("String");
    }

    public static Entity newDouble() {
        return newPrimitiveEntity("Double");
    }

    public static Entity newLong() {
        return newPrimitiveEntity("Long");
    }

    public static Entity newInteger() {
        return newPrimitiveEntity("Integer");
    }

    public static Entity newBoolean() {
        return newPrimitiveEntity("Boolean");
    }

    public static Entity newEnumEntity(String name, String values) {
        final Entity entity = newEntity().setType(EntityType.ENUM).setName(name);
        for (String s : values.split("[, ]"))
            entity.addEnumValues(s.trim());
        return entity;
    }

    public static Relation newOneToOneRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.OneToOne);
    }

    public static Relation newOneToManyRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.OneToMany);
    }

    public static String variableName(Entity entity) {
        return lowFirst(entity.getName());
    }

    public static String variableName(Relation relation) {
        return lowFirst(relation.getName());
    }

    public static String getterName(Entity entity) {
        return "get" + capitalize(entity.getName());
    }

    public static String getterName(Relation relation) {
        return "get" + capitalize(relation.getName());
    }

    public static String setterName(Relation relation) {
        return "set" + capitalize(relation.getName());
    }

    public static String adderName(Relation relation) {
        return "add" + capitalize(relation.getName());
    }

    public static String removeName(Relation relation) {
        return "remove" + capitalize(relation.getName());
    }

    public static boolean isLexical(Relation relation) {
        return Boolean.TRUE.equals(relation.getLexical()) || (relation.getName().equals("name") && relation.getDst().getName().equals("String"));
    }
}