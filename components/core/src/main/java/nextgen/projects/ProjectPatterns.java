package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.JavaST;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.java.Pojo;
import nextgen.templates.java.PojoFactory;
import nextgen.templates.vertx.JsonWrapper;
import nextgen.templates.vertx.VertxST;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProjectPatterns {

    public static void writeJsonWrapper(File root, JsonWrapper content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName().toString(), content.getName().toString(), "java", root);
    }

    static final Set<String> primitiveFields = new LinkedHashSet<String>() {{
        add("string");
        add("long");
        add("int");
        add("integer");
        add("boolean");
        add("float");
    }};

    public static void writeJsonWrapper(File root, Domain domain) {
        final PackageDeclaration packageDeclaration = JavaST.newPackageDeclaration().setName(domain.getPackageName());

        domain.getEntities().forEach(entity -> writeEntityAsJsonWrapper(root, packageDeclaration, entity));
    }

    public static void writeEntityAsJsonWrapper(File root, PackageDeclaration packageDeclaration, Entity entity) {

        final JsonWrapper jsonWrapper = VertxST.newJsonWrapper()
                .setPackage(packageDeclaration)
                .setName(entity.getName());

        entity.streamFields().forEach(entity_fields -> {

            final Object type = entity_fields.getType();
            if (type instanceof Entity) {
                jsonWrapper.addAccessors(VertxST.newReferenceAccessors().setClassName(entity.getName()).setName(entity_fields.getName()).setType(((Entity) type).getName()));
                writeEntityAsJsonWrapper(root, packageDeclaration, (Entity) type);
            } else
                jsonWrapper.addAccessors(VertxST.newPrimitiveAccessors().setClassName(entity.getName()).setName(entity_fields.getName()).setType(type));

        });

        entity.streamRelations().forEach(entity_relations -> {

            if (entity_relations.getTarget() instanceof Entity) {
                jsonWrapper.addAccessors(VertxST.newListReferenceAccessors().setClassName(entity.getName()).setName(entity_relations.getName()).setType(entity_relations.getTarget()));
                writeEntityAsJsonWrapper(root, packageDeclaration, (Entity) entity_relations.getTarget());
            } else
                jsonWrapper.addAccessors(VertxST.newListPrimitiveAccessors().setClassName(entity.getName()).setName(entity_relations.getName()).setType(entity_relations.getTarget()));
        });

        writeJsonWrapper(root, jsonWrapper);
    }

    public static void writePojo(File root, Pojo content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName().toString(), content.getName().toString(), "java", root);
    }

    public static void writePojoFactory(File root, PojoFactory content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName().toString(), content.getName().toString(), "java", root);
    }
}