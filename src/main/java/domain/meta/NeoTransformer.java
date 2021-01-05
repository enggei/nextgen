package domain.meta;

import nextgen.templates.domain.*;
import nextgen.templates.javaneo4jembedded.*;

import java.util.*;

import static domain.DomainProcessor.*;

public class NeoTransformer extends TemplateDomainTransformer<nextgen.templates.javaneo4jembedded.NeoFactory> {

   final nextgen.templates.javaneo4jembedded.NeoFactory result = nextgen.templates.javaneo4jembedded.JavaNeo4JEmbeddedST.newNeoFactory();

   String packageName;

   public NeoTransformer(String packageName) {
      this.packageName = packageName;
   }

   @Override
   public void onDomain(MetaDomain domain) {
      result.setPackage(packageName);
      result.setName(domain.name() + "DB");
   }

   @Override
   public void onProperty(MetaDomain.MetaProperty metaProperty) {

      final NeoFactoryAccessors neoFactoryAccessors = JavaNeo4JEmbeddedST.newNeoFactoryAccessors()
            .setName(metaProperty.name())
            .addProperties(JavaNeo4JEmbeddedST.newNeoFactoryPropertyAccessors()
                  .setEntity(result.getName())
                  .setPropertyName(metaProperty.name()));

      result.addAccessors(neoFactoryAccessors);


   }

   @Override
   public void onEntity(MetaDomain entity) {
   }

   @Override
   public nextgen.templates.javaneo4jembedded.NeoFactory onComplete() {
      System.out.println(result);
      return result;
   }

}