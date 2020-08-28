package nextgen.projects;

import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import org.junit.Test;

import static nextgen.templates.DomainPatterns.*;

public class NextgenProject extends BaseNextgenProject {

    @Test
    public void generateMetaDomain() {
        DomainPatterns.writeNeo(root, "nextgen.domains.meta", metaDomain());
    }

    private Domain metaDomain() {

        // meta
        final Entity metaProperty = newEntity("MetaProperty")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newStringField("type"))
                .addRelations(newStringField("defaultValue"));

        final Entity metaEntity = newEntity("MetaEntity")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newOneToMany("properties", metaProperty));

        final Entity metaRelation = newEntity("MetaRelation")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newEnumField("cardinality", "Cardinality", "ONE_TO_ONE,ONE_TO_MANY"))
                .addRelations(newOneToMany("dst", metaEntity))
                .addRelations(newOneToMany("properties", metaProperty));

        metaEntity.addRelations(newOneToMany("relations", metaRelation));

        final Entity domainVisitor = newEntity("DomainVisitor")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newOneToMany("fields", newEntity("VisitorField")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("name"))
                        .addRelations(newStringField("type"))))
                .addRelations(newOneToMany("entityVisitors", newEntity("EntityVisitorMethod")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newRef("_meta", metaEntity))
                        .addRelations(newStringField("statements"))))
                .addRelations(newOneToMany("relationVisitors", newEntity("RelationVisitorMethod")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newRef("_meta", metaRelation))
                        .addRelations(newStringField("statements"))));

        final Entity metaDomain = newEntity("MetaDomain")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newOneToMany("roots", metaEntity))
                .addRelations(newOneToMany("properties", metaProperty))
                .addRelations(newOneToMany("visitors", domainVisitor));

        // models
        final Entity domainEntity = newEntity("DomainEntity")
                .addRelations(newStringField("uuid"))
                .addRelations(newRef("_meta", metaEntity));

        return newDomain("MetaDomain")
                .addEntities(metaDomain)
                .addEntities(domainEntity)
                .addEntities(domainVisitor);
    }
}