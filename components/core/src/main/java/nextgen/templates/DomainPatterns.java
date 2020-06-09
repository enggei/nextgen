package nextgen.templates;

import nextgen.templates.domain.*;

public class DomainPatterns extends DomainST {

    public static Domain newDomain(String name, String packageName) {
        return newDomain().setName(name).setPackageName(packageName);
    }

    public static Entity newEntity(String name) {
        return newEntity().setName(name);
    }

    public static Entity newEnum(String name, String... values) {
        final Entity entity = newEntity().setIsEnum(true).setName(name);
        for (String value : values) entity.addEnumValues(value.trim());
        return entity;
    }

    public static PrimitiveField newStringField(String name) {
        return newStringField(name, false);
    }

    public static PrimitiveField newStringField(String name, boolean lexical) {
        return newPrimitiveField().setName(name).setType(String.class).setLexical(lexical);
    }

    public static PrimitiveField newOneToOnePrimitive(String name, Class<?> type) {
        return newPrimitiveField().setName(name).setType(type);
    }

    public static ExternalReferenceField newOneToOneExternal(String name, Class<?> type) {
        return newExternalReferenceField().setName(name).setType(type);
    }

    public static ReferenceList newOneToMany(String name, Entity entity) {
        return newReferenceList().setName(name).setEntity(entity);
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
}