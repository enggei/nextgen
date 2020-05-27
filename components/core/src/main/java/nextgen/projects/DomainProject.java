package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Domain;

import static nextgen.domain.DomainPatterns.*;

public class DomainProject {

    private static final String mainRoot = "./components/core/src/main/java";
    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {

        final Domain domain = getDomain();

        DomainToPojos.generate(mainRoot, "nextgen.domain.domain", domain);

        DomainToPojos.generate(testRoot, "tmp.domain.domain", domain);
        DomainToNeo4J.generate(testRoot, "tmp.domain.domain.neo4j", domain);
        DomainToJson.generate(testRoot, "tmp.domain.domain.json", domain);
    }

    public static Domain getDomain() {

        final EntityBuilder entity = newEntityBuilder("Entity")
                .addOneToOneRelation("type", newEnumEntity("EntityType", "PRIMITIVE,REFERENCE,EXTERNAL,ENUM"))
                .addOneToManyRelation("enumValues", newString())
                .addStringField("name");

        final EntityBuilder relation = newEntityBuilder("Relation")
                .addStringField("name")
                .addOneToOneRelation("src", entity)
                .addOneToOneRelation("dst", entity)
                .addOneToOneRelation("type", newEnumEntity("RelationType", "OneToOne,OneToMany"));

        return newDomainBuilder("Domain")
                .add(newEntityBuilder("Domain")
                        .addStringField("name")
                        .addOneToManyRelation("entities", entity)
                        .addOneToManyRelation("relations", relation));
    }
}