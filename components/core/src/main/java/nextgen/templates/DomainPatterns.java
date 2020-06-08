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
        return newPrimitiveField().setName("generatorRoot").setType(String.class).setLexical(lexical);
    }

    public static ReferenceList newOneToMany(String name, Entity entity) {
        return newReferenceList().setName(name).setEntity(entity);
    }

    public static ReferenceField newOneToOne(String name, Entity entity) {
        return newOneToOne(name, entity, false);
    }

    public static ReferenceField newOneToOne(String name, Entity entity, boolean lexical) {
        return newReferenceField().setName(name).setEntity(entity).setLexical(lexical);
    }

    public static ReferenceField newEnumField(String name, Entity enumEntity) {
        return newReferenceField().setName(name).setEntity(enumEntity);
    }
}