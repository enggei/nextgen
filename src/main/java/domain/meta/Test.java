package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test extends TemplateDomainTransformer<DomainDeclaration> {

   final DomainDeclaration result = DomainST.newDomainDeclaration();
   String packageName;

   public Test(String packageName) {
      this.packageName = packageName;
   }

   @Override
   protected void onDomain(MetaDomain domain) {
      result.setName(domain.name());
   }

   @Override
   protected void onProperty(MetaDomain.MetaProperty metaProperty) {
      result.addProperties(metaProperty.quantifier().orElse(null), metaProperty.type().orElse(null), metaProperty.name(), metaProperty.typeDeclaration().orElse(null));
   }

   @Override
   protected void onEntity(MetaDomain entity) {
      result.addEntities(DomainST.newDomainEntityDeclaration()
            .setName(entity.name())
            .setProperties(entity.properties()
                  .map(metaProperty -> new DomainEntityDeclaration.DomainEntityDeclaration_Properties(metaProperty.typeDeclaration().orElse(null), metaProperty.type().orElse(null), metaProperty.name(), metaProperty.quantifier().orElse(null)))
                  .collect(Collectors.toList())));
   }

   @Override
   protected DomainDeclaration onComplete() {
      System.out.println(result.toString());
      return result;
   }

}