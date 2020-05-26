package nextgen.maven;

import nextgen.maven.st.MavenGenerator;
import nextgen.maven.st.pom;
import org.junit.Test;

import static nextgen.maven.st.MavenFactory.newPom;

public class Tests {

    @Test
    public void testMavenProject() {

        final pom projectPom = newPom()
                .setName("Petty")
                .setVersion("1.0")
                .setArtifactId("Petty")
                .setGroupId("com.petty");

        final MavenGenerator mavenGenerator = new MavenGenerator();
        System.out.println(mavenGenerator.generate(projectPom));

//        final Project project = newProject()
//                .setName("PettyReal")
//                .setroot("/home/goe/projects/petty")
//                .setpom(newPom());


    }
}