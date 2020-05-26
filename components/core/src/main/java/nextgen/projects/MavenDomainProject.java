package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Relation;

import static nextgen.domain.DomainPatterns.*;

public class MavenDomainProject {

    private static final String mainRoot = "./components/core/src/main/java";
    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {

        final Domain domain = getDomain();

        DomainToPojos.generate(mainRoot, "nextgen.maven.domain", domain);
    }

    public static Domain getDomain() {

        final Entity project = newEntity("Project")
//                .addProperties(newStringProperty("Name"))
//                .addProperties(newStringProperty("root"))
                ;

        final Entity pom = newEntity("Pom");

        final Entity module = newEntity("Module")
//                .addProperties(newStringProperty("Name"))
                ;

        final Relation projectModule = newOneToManyRelation("modules", project, module);
        final Relation projectPom = newOneToOneRelation("pom", project, pom);
        final Relation modulePom = newOneToOneRelation("pom", module, pom);

        return newDomain("Maven")
                .addEntities(project)
                .addEntities(module)
//                .addEntities(pom)
//                .addRelations(projectPom)
                .addRelations(projectModule)
//                .addRelations(modulePom)
                ;
    }
}