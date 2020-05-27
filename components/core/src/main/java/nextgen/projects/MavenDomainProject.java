package nextgen.projects;

import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Domain;

import static nextgen.domain.DomainPatterns.*;

public class MavenDomainProject {

    private static final String mainRoot = "./components/core/src/main/java";
    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {

        final Domain domain = getDomain();

        DomainToPojos.generate(testRoot, "tmp.maven.domain", domain);
    }

    public static Domain getDomain() {
        return newDomainBuilder("Maven")
                .add(newEntityBuilder("Project")
                        .addStringField("name")
                        .addStringField("root")
                        .addOneToOneRelation("pom", newExternalEntity(nextgen.maven.st.pom.class))
                        .addOneToManyRelation("modules", newEntityBuilder("Module")
                                .addStringField("name")));
    }
}