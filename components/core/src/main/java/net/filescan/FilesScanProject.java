package net.filescan;

import nextgen.templates.domain.Entity;
import org.junit.Test;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.DomainPatterns.newDomain;

public class FilesScanProject extends FilesScan {

    @Test
    public void generateDomain() {

        final Entity stModelNeo = newEntity("Harddrive")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newOneToMany("directories", newEntity("Directory")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("name"))
                        .addRelations(newOneToMany("files", newEntity("File")
                                .addRelations(newStringField("uuid"))
                                .addRelations(newStringField("name"))
                                .addRelations(newStringField("type"))
                                .addRelations(newLongField("lastModified"))))));

        writeNeo(mainJava, domain.getName(), newDomain("Filescan")
                .addEntities(stModelNeo));
    }

}