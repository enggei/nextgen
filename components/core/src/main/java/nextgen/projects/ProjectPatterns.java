package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.domain.*;
import nextgen.templates.java.Enum;
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
        STGenerator.writeToFile(content, packageDeclaration.getName(), content.getName().toString(), "java", root);
    }

    public static void writeJsonWrapper(File root, Domain domain) {
        final PackageDeclaration packageDeclaration = JavaST.newPackageDeclaration().setName(domain.getPackageName());
        final Set<Entity> visited = new LinkedHashSet<>();
        domain.getEntities().forEach(entity -> writeEntityAsJsonWrapper(root, packageDeclaration, entity, visited));
    }

    public static void writeEntityAsJsonWrapper(File root, PackageDeclaration packageDeclaration, Entity entity, final Set<Entity> visited) {

        if (entity == null || visited.contains(entity)) return;
        visited.add(entity);

        if (entity.getIsEnum(false)) {
            writeEnum(root, packageDeclaration, entity.getName(), entity.getEnumValues().toArray());
            return;
        }

        final JsonWrapper jsonWrapper = VertxST.newJsonWrapper()
                .setPackage(packageDeclaration)
                .setName(entity.getName());

        entity.getRelations().forEach(o -> {

            if (o instanceof PrimitiveField) {
                final PrimitiveField field = (PrimitiveField) o;
                jsonWrapper.addAccessors(VertxST.newPrimitiveAccessors().setClassName(entity.getName()).setType(getType(field.getType())).setName(field.getName()));

                if (field.getLexical()) jsonWrapper.setLexical(field.getName());

            } else if (o instanceof PrimitiveList) {
                final PrimitiveList field = (PrimitiveList) o;
                jsonWrapper.addAccessors(VertxST.newListPrimitiveAccessors().setClassName(entity.getName()).setType(field.getType()).setName(field.getName()));

            } else if (o instanceof EnumField) {
                final EnumField field = (EnumField) o;
                jsonWrapper.addAccessors(VertxST.newEnumAccessors().setClassName(entity.getName()).setType(field.getType().getName()).setName(field.getName()));
                writeEntityAsJsonWrapper(root, packageDeclaration, field.getType(), visited);

            } else if (o instanceof ReferenceField) {
                final ReferenceField field = (ReferenceField) o;
                final Entity fieldEntity = field.getEntity();
                jsonWrapper.addAccessors(VertxST.newReferenceAccessors().setClassName(entity.getName()).setType(fieldEntity.getName()).setName(field.getName()));

                writeEntityAsJsonWrapper(root, packageDeclaration, fieldEntity, visited);

            } else if (o instanceof ExternalReferenceField) {
                final ExternalReferenceField field = (ExternalReferenceField) o;
                jsonWrapper.addExternalFields(field.getType().getCanonicalName(), field.getName(), null);
                jsonWrapper.addAccessors(VertxST.newExternalAccessors().setClassName(entity.getName()).setType(field.getType().getCanonicalName()).setName(field.getName()));

            } else if (o instanceof ReferenceList) {
                final ReferenceList field = (ReferenceList) o;
                jsonWrapper.addAccessors(VertxST.newListReferenceAccessors()
                        .setClassName(entity.getName())
                        .setType(field.getSelf(false) ? entity.getName() : field.getEntity().getName())
                        .setName(field.getName()));

                writeEntityAsJsonWrapper(root, packageDeclaration, field.getEntity(), visited);
            }
        });

        writeJsonWrapper(root, jsonWrapper);
    }

    private static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Object[] enumValues) {
        final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration);
        for (Object enumValue : enumValues)
            content.addEnumValues(enumValue);
        STGenerator.writeToFile(content, packageDeclaration.getName(), name, "java", root);
    }

    private static Object getType(Object type) {
        if (type instanceof Class<?>) return ((Class<?>) type).getSimpleName();
        return type;
    }

    public static void writePojo(File root, Pojo content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName(), content.getName().toString(), "java", root);
    }

    public static void writePojoFactory(File root, PojoFactory content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName(), content.getName().toString(), "java", root);
    }
}