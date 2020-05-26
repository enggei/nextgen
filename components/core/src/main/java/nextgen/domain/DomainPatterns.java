package nextgen.domain;

import nextgen.domain.domain.Enum;
import nextgen.domain.domain.*;
import nextgen.java.st.ClassOrInterfaceDeclaration;
import nextgen.java.st.ClassOrInterfaceType;

import static com.generator.util.StringUtil.lowFirst;
import static nextgen.java.JavaPatterns.newClassOrInterfaceType;
import static nextgen.java.st.JavaFactory.*;

public class DomainPatterns extends DomainFactory {

    public static Domain newDomain(String name) {
        return newDomain().setName(name);
    }

    public static Enum newEnum(String name, String values) {

        final Enum anEnum = newEnum().setName(name);

        for (String value : values.split("[ ,]"))
            anEnum.addValues(value.trim());

        return anEnum;
    }

    public static Entity newEntity(String name) {
        return newEntity().setName(name).setIsPrimitive(Boolean.FALSE).setIsExternal(Boolean.FALSE).setIsEnum(Boolean.FALSE);
    }

    public static Entity newPrimitiveEntity(String name) {
        return newEntity().setName(name).setIsEnum(Boolean.FALSE).setIsPrimitive(Boolean.TRUE).setIsExternal(Boolean.FALSE);
    }

    public static Entity newEnumEntity(String name) {
        return newEntity().setName(name).setIsEnum(Boolean.TRUE).setIsPrimitive(Boolean.FALSE).setIsExternal(Boolean.FALSE);
    }

    public static Relation newOneToOneRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.OneToOne);
    }

    public static Relation newOneToManyRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.OneToMany);
    }

    public static Relation newManyToOneRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.ManyToOne);
    }

    public static Relation newManyToManyRelation(String name, Entity src, Entity dst) {
        return newRelation().setName(name).setSrc(src).setDst(dst).setType(RelationType.ManyToMany);
    }

    public static Property newStringProperty(String name) {
        return newProperty().setName(name).setType(PropertyType.STRING);
    }

    public static Property newIntegerProperty(String name) {
        return newProperty().setName(name).setType(PropertyType.INTEGER);
    }

    public static Property newExternalProperty(String name, String type) {
        return newProperty()
                .setName(name)
                .setType(PropertyType.EXTERNAL)
                .setExternalType(type);
    }

    public static Property newEnumProperty(String name, Enum enumType) {
        return newProperty()
                .setName(name)
                .setType(PropertyType.ENUM)
                .setEnumType(enumType);
    }

    public static Property newBooleanProperty(String name) {
        return newProperty().setName(name).setType(PropertyType.BOOLEAN);
    }

    public static boolean isPrimitive(Entity dst) {
        return Boolean.TRUE.equals(dst.getIsPrimitive());
    }

    public static boolean isEnum(Entity dst) {
        return Boolean.TRUE.equals(dst.getIsEnum());
    }

    public static boolean isExternal(Entity entity) {
        return Boolean.TRUE.equals(entity.getIsExternal());
    }

    public static boolean isExternal(Property property) {
        return PropertyType.EXTERNAL.equals(property.getType());
    }

    public static boolean isEnumProperty(Property property) {
        return PropertyType.ENUM.equals(property.getType());
    }

    public static String variableName(Property property) {
        return lowFirst(property.getName());
    }

    public static String variableName(ClassOrInterfaceDeclaration property) {
        return lowFirst(property.getName());
    }

    public static String variableName(Relation relation) {
        return lowFirst(relation.getName());
    }

    public static String variableName(Entity entity) {
        return lowFirst(entity.getName());
    }

    public static ClassOrInterfaceType asJavaType(Entity entity) {
        return newClassOrInterfaceType(entity.getName());
    }

    public static ClassOrInterfaceType asJavaType(Property property) {
        switch (property.getType()) {
            case STRING:
                return StringType;
            case INTEGER:
                return IntegerType;
            case DOUBLE:
                return DoubleType;
            case BOOLEAN:
                return BooleanType;
            case ENUM:
                return newClassOrInterfaceType(property.getEnumType().getName());
            case LONG:
                return LongType;
            case EXTERNAL:
                return newClassOrInterfaceType(property.getExternalType());
            default:
                return ObjectType;
        }
    }
}