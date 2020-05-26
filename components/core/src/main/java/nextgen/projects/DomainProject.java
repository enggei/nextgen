package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.*;
import nextgen.domain.domain.Enum;

import static nextgen.domain.DomainPatterns.*;

public class DomainProject {

    private static final String mainRoot = "./components/core/src/main/java";
    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {

        final Domain domain = getDomain();

        DomainToPojos.generate(mainRoot, "nextgen.domain.domain", domain);

//        DomainToPojos.generate(testRoot, "tmp.domain.domain", domain);
//        DomainToNeo4J.generate(testRoot, "tmp.domain.domain.neo4j", domain);
        DomainToJson.generate(testRoot, "tmp.domain.domain.json", domain);
    }

    public static Domain getDomain() {

        final Enum propertyTypeEnum = newEnum("PropertyType", "STRING,INTEGER,DOUBLE,BOOLEAN,ENUM,LONG,EXTERNAL");
        final Enum relationTypeEnum = newEnum("RelationType", "OneToOne,OneToMany,ManyToOne,ManyToMany");

        final Property isPrimitive = newBooleanProperty("isPrimitive");
        final Property isExternal = newBooleanProperty("isExternal");
        final Property isEnumType = newBooleanProperty("isEnum");
        final Property propertyType = newEnumProperty("Type", propertyTypeEnum);
        final Property relationType = newEnumProperty("Type", relationTypeEnum);

        final Entity stringEntity = newPrimitiveEntity("String");
        final Entity booleanEntity = newPrimitiveEntity("Boolean");

        final Entity enumEntity = newEntity("Enum");

        final Entity entity = newEntity("Entity")
                .addProperties(isPrimitive)
                .addProperties(isEnumType)
                .addProperties(isExternal)
                .addProperties(propertyType);

        final Entity property = newEntity("Property")
                .addProperties(propertyType);

        final Entity relation = newEntity("Relation")
                .addProperties(relationType);

        final Entity domain = newEntity("Domain");

        final Relation enums = newOneToManyRelation("Enums", domain, enumEntity);
        final Relation entities = newOneToManyRelation("Entities", domain, entity);
        final Relation relations = newOneToManyRelation("Relations", domain, relation);
        final Relation properties = newOneToManyRelation("Properties", entity, property);
        final Relation enumType = newOneToOneRelation("EnumType", property, enumEntity);
        final Relation externalType = newOneToOneRelation("ExternalType", property, stringEntity);
        final Relation enumValues = newOneToManyRelation("Values", enumEntity, stringEntity);
        final Relation src = newOneToOneRelation("Src", relation, entity);
        final Relation dst = newOneToOneRelation("Dst", relation, entity);


        return newDomain()
                .setName("Domain")
                .addEnums(propertyTypeEnum)
                .addEnums(relationTypeEnum)
                .addEntities(domain)
                .addEntities(stringEntity)
                .addEntities(booleanEntity)
                .addEntities(enumEntity)
                .addEntities(entity)
                .addEntities(property)
                .addEntities(relation)
                .addRelations(newOneToOneRelation("name", entity, stringEntity))
                .addRelations(newOneToOneRelation("isPrimitive", entity, booleanEntity))
                .addRelations(newOneToOneRelation("isEnum", entity, booleanEntity))
                .addRelations(newOneToOneRelation("isExternal", entity, booleanEntity))
                .addRelations(newOneToOneRelation("name", enumEntity, stringEntity))
                .addRelations(newOneToOneRelation("name", property, stringEntity))
                .addRelations(newOneToOneRelation("name", relation, stringEntity))
                .addRelations(newOneToOneRelation("name", domain, stringEntity))
                .addRelations(enums)
                .addRelations(enumValues)
                .addRelations(entities)
                .addRelations(relations)
                .addRelations(properties)
                .addRelations(enumType)
                .addRelations(externalType)
                .addRelations(src)
                .addRelations(dst);
    }
}