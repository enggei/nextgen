package projects.nextgen;

import com.generator.generators.neo4j.Neo4jGroup;
import com.generator.generators.neo4j.NeoDomainGenerator;
import com.generator.generators.neo4j.NeoDomainVisitor;
import com.generator.util.GeneratedFile;
import com.generator.util.Triple;
import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

public class TmpExportTest {

    @Test
    public void testExport() {

        final Neo4jGroup group = new Neo4jGroup();

        final Neo4jGroup.ExportDatabaseST domainDB = group.newExportDatabase().setPackageName("projects.nextgen").setName("TemplateDomainDB");

        domainDB.addNodesValue(group.newexportNode().addLabelsValue("NeoEntity").setUuid("6c010ba7-e3f1-4199-b821-a483a1969b9e").addPropertiesValue("STGroup", "name"));
        domainDB.addRelationsValue(group.newexportRelation().setType("ENTITY_PROPERTIES").setSrcLabel("NeoEntity").setSrcUuid("6c010ba7-e3f1-4199-b821-a483a1969b9e").setDstLabel("NeoEntity").setDstUuid("6c010ba7-e3f1-4199-b821-a483a1969b9e").addPropertiesValue("cardinality", "ONE_TO_ONE"));

        System.out.println(domainDB);
    }

    String serverPackage = "com.nextgen.generators.";
    String clientPackage = "com.nextgen.swing.";
    String swingRoot = "/home/goe/projects/nextgen-server/swing/src/main/java";
    String serverRoot = "/home/goe/projects/nextgen-server/core/src/main/java";
    String facadeInterface = "com.nextgen.swing.";

    @Test
    public void testGenerate() {
        generate(new TemplateDB("/home/goe/projects/nextgen/components/core/src/main/java/projects/nextgen/.tmp/"));
//        generate(new VerticleDB("/home/goe/projects/nextgen/components/core/src/main/java/projects/nextgen/.tmp/"));
//        generate(new NeoDomainDB("/home/goe/projects/nextgen/components/core/src/main/java/projects/nextgen/.tmp/"));
    }

    private void generate(NeoDomainDB db) {
        try (Transaction tx = db.getDb().beginTx()) {
            db.merge();
            final Node neoDomain = db.getRoot();
            generateClasses("Domain", serverPackage + "domain", clientPackage + "domain", serverRoot, swingRoot, neoDomain, facadeInterface);
            tx.success();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        db.shutdown();
    }

    private void generate(TemplateDB db) {
        try (Transaction tx = db.getDb().beginTx()) {
            db.merge();
            final Node neoDomain = db.getRoot();
            generateClasses("Template", serverPackage + "template", clientPackage + "template", serverRoot, swingRoot, neoDomain, facadeInterface);
            tx.success();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        db.shutdown();
    }

    private void generate(VerticleDB db) {
        try (Transaction tx = db.getDb().beginTx()) {
            db.merge();
            final Node neoDomain = db.getRoot();
            generateClasses("Verticles", serverPackage + "verticles", clientPackage + "verticles", serverRoot, swingRoot, neoDomain, facadeInterface);
            tx.success();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        db.shutdown();
    }

    private void generateClasses(String name, String serverPackage, String clientPackage, String serverRoot, String swingRoot, Node neoDomain, String facadeInterface) throws IOException {
        final NeoDomainGenerator domain = new NeoDomainGenerator(name, "");

        new NeoDomainVisitor() {
            @Override
            protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {
                System.out.println(src.getLabel() + " -> " + neoRelation.getName()+ " -> " + dst.getLabel());
                domain.add(neoRelation);
            }

            @Override
            protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {
                domain.add(neoEntity);
            }

            @Override
            protected void visitNeoFunction(NeoDomainGenerator.NeoFunction neoFunction) {
                domain.add(neoFunction);
            }
        }.visit(neoDomain);

        final Triple<String, String, String> triple = domain.toVerticle(serverPackage, clientPackage,facadeInterface);
        final String domainDomain = domain.toDomain(serverPackage);

        GeneratedFile.newJavaFile(serverRoot, serverPackage, name).write(domainDomain);
        GeneratedFile.newJavaFile(serverRoot, serverPackage, name + "Verticle").write(triple.getFirst());
        GeneratedFile.newJavaFile(swingRoot, clientPackage, name + "VerticleFacade").write(triple.getSecond());
        GeneratedFile.newJavaFile(swingRoot, clientPackage, name + "PNodes").write(triple.getThird());
    }

}