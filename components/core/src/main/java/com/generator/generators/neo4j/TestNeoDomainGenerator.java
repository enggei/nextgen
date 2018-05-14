package com.generator.generators.neo4j;

import com.generator.util.GeneratedFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;

/**
 * Created 02.05.18.
 */
public class TestNeoDomainGenerator {

   public static void main(String[] args) throws IOException {

      final String domainName = "CinemaDomain";
      final String packageName = "com.generator.generators.neo4j";

      final NeoDomainGenerator generator = createDomain(domainName);

//      GeneratedFile.newJavaFile("/home/goe/projects/nextgen/components/core/src/main/java", packageName, domainName).write(generator.toDomain(packageName));
      GeneratedFile.newJavaFile("/home/goe/udc/bk-cloud/server/src/main/java", packageName, domainName + "Verticle").write(generator.toVerticle(packageName));

      final Map<String, Set<NeoDomainGenerator.Motif>> map = new TreeMap<>();
      for (Map.Entry<String, NeoDomainGenerator.Motif> entry : generator.getMotifs().entrySet()) {
         final Set<NeoDomainGenerator.Motif> motifs = map.computeIfAbsent(entry.getKey(), k -> new LinkedHashSet<>());
         motifs.add(entry.getValue());
      }

      for (Set<NeoDomainGenerator.Motif> motifs : map.values()) {
         System.out.println(motifs);

      }
   }

   @NotNull
   public static NeoDomainGenerator createDomain(String domainName) {
      NeoDomainGenerator generator = new NeoDomainGenerator(domainName, "Test domain of cinema-domain");

      final NeoDomainGenerator.NeoEntity exhibitor = new NeoDomainGenerator.NeoEntity("Exhibitor").
            add(new NeoDomainGenerator.NeoProperty("name", true, true, NeoDomainGenerator.NeoPropertyType.String));
      generator.add(exhibitor);

      final NeoDomainGenerator.NeoEntity site = new NeoDomainGenerator.NeoEntity("Site").
            add(new NeoDomainGenerator.NeoProperty("name", true, true, NeoDomainGenerator.NeoPropertyType.String));
      generator.add(site);

      final NeoDomainGenerator.NeoEntity screen = new NeoDomainGenerator.NeoEntity("Screen").
            add(new NeoDomainGenerator.NeoProperty("name", true, true, NeoDomainGenerator.NeoPropertyType.String)).
            add(new NeoDomainGenerator.NeoProperty("screenNo", false, true, NeoDomainGenerator.NeoPropertyType.Integer)).
            add(new NeoDomainGenerator.NeoProperty("isOpen", false, true, NeoDomainGenerator.NeoPropertyType.Boolean)).
            add(new NeoDomainGenerator.NeoProperty("registered", false, true, NeoDomainGenerator.NeoPropertyType.Long)).
            add(new NeoDomainGenerator.NeoProperty("screenType", true, true, NeoDomainGenerator.NeoPropertyType.Enum).
                  addEnumValue("_2D").
                  addEnumValue("_3D"));
      generator.add(screen);

      generator.add(new NeoDomainGenerator.NeoRelation("screens", "Site", "Screen", NeoDomainGenerator.Cardinality.ONE_TO_MANY));

      generator.add(new NeoDomainGenerator.NeoRelation("sites", "Exhibitor", "Site", NeoDomainGenerator.Cardinality.ONE_TO_MANY).
            add(new NeoDomainGenerator.NeoProperty("status", true, true, NeoDomainGenerator.NeoPropertyType.Enum).
                  addEnumValue("ACTIVE").
                  addEnumValue("CLOSED").
                  addEnumValue("RENOVATING")).
            add(new NeoDomainGenerator.NeoProperty("region", true, true, NeoDomainGenerator.NeoPropertyType.String)));


      generator.add(new NeoDomainGenerator.NeoFunction("parseSTG"));

      return generator;
   }
}