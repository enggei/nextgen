package domain;

import domain.meta.*;
import nextgen.st.STGenerator;
import nextgen.templates.domain.*;

import java.util.*;

import static domain.meta.MetaDomain.Quantifier.*;

public class DomainProcessor {

   private static MetaDomain newMetaDomain() {

   	final MetaDomainFactory domain = new MetaDomainFactoryImpl();
   	domain.setname("MetaDomain");

   	final MetaDomainFactory Quantifier = newDomain("Quantifier")
   			.addproperties(enumerate(domain, "ONE"))
   			.addproperties(enumerate(domain, "MANY"))
   			.addproperties(enumerate(domain, "OPTIONAL"));

   	final MetaDomainFactory MetaProperty = newDomain("MetaProperty")
   			.addproperties(single(domain, "name", "String"))
   			.addproperties(optional(domain, "quantifier", "Quantifier", Quantifier))
   			.addproperties(optional(domain, "type", "String"))
   			.addproperties(optional(domain, "typeDeclaration", "MetaDomain"));

   	domain.addproperties(single(domain, "name", "String"));
   	domain.addproperties(many(domain, "properties", "MetaProperty", MetaProperty));

   	return domain;
   }

   private static MetaDomain nextgenDomain() {
      final MetaDomainFactory domain = new MetaDomainFactoryImpl()
            .setname("Nextgen");
      return domain
            .addproperties(many(domain, "projects", "STProject", newDomain("STProject")
                  .addproperties(single(domain, "name", "String"))
                  .addproperties(single(domain, "root", "String"))
                  .addproperties(many(domain, "models", "STModel", newDomain("STModel")
                        .addproperties(single(domain, "stTemplate", "STTemplate"))
                        .addproperties(many(domain, "files", "STFile", newDomain("STFile")
                              .addproperties(single(domain, "type", "STValue"))
                              .addproperties(single(domain, "packageName", "STValue"))
                              .addproperties(single(domain, "path", "STValue"))))
                        .addproperties(many(domain, "arguments", "STArgument", newDomain("STArgument")
                              .addproperties(single(domain, "stParameter", "STParameter"))
                              .addproperties(single(domain, "value", "STValue"))
                              .addproperties(many(domain, "keyValues", "STArgumentKV", newDomain("STArgumentKV")
                                    .addproperties(single(domain, "stParameterKey", "STParameterKey"))
                                    .addproperties(single(domain, "values", "STValue"))))))))
                  .addproperties(many(domain, "values", "STValue", newDomain("STValue")
                        .addproperties(single(domain, "type", "STValueType", newDomain("STValueType")
                              .addproperties(enumerate(domain, "STMODEL"))
                              .addproperties(enumerate(domain, "PRIMITIVE"))
                              .addproperties(enumerate(domain, "ENUM"))))
                        .addproperties(optional(domain, "value", "String"))
                        .addproperties(optional(domain, "stModel", "STModel"))
                        .addproperties(optional(domain, "stEnum", "STEnumValue"))))))
            .addproperties(many(domain, "groups", "STGroup", newDomain("STGroup")
                  .addproperties(single(domain, "name", "String"))
                  .addproperties(many(domain, "files", "STGroupFile", newDomain("STGroupFile")
                        .addproperties(single(domain, "packageName", "STValue"))
                        .addproperties(single(domain, "path", "STValue"))))
                  .addproperties(many(domain, "templates", "STTemplate", newDomain("STTemplate")
                        .addproperties(single(domain, "name", "String"))
                        .addproperties(single(domain, "text", "String"))
                        .addproperties(many(domain, "interfaces", "STInterface"))
                        .addproperties(many(domain, "parameter", "STParameter", newDomain("STParameter")
                              .addproperties(single(domain, "name", "String"))
                              .addproperties(single(domain, "type", "STParameterType", newDomain("STParameterType")
                                    .addproperties(enumerate(domain, "SINGLE"))
                                    .addproperties(enumerate(domain, "LIST"))
                                    .addproperties(enumerate(domain, "KVLIST"))))
                              .addproperties(many(domain, "keys", "STParameterKey", newDomain("STParameterKey")
                                    .addproperties(single(domain, "name", "String"))
                                    .addproperties(single(domain, "argumentType", "STInterface"))))
                              .addproperties(single(domain, "argumentType", "String"))))
                        .addproperties(many(domain, "children", "STTemplate"))))
                  .addproperties(many(domain, "interfaces", "STInterface", newDomain("STInterface")
                        .addproperties(single(domain, "name", "String"))))
                  .addproperties(many(domain, "enums", "STEnum", newDomain("STEnum")
                        .addproperties(single(domain, "name", "String"))
                        .addproperties(many(domain, "values", "STEnumValue", newDomain("STEnumValue")
                              .addproperties(single(domain, "name", "String"))
                              .addproperties(single(domain, "lexical", "String"))))))
                  .addproperties(many(domain, "actions", "STAction", newDomain("STAction")
                        .addproperties(single(domain, "name", "String"))
                        .addproperties(many(domain, "statements", "String"))
                        .addproperties(many(domain, "imports", "String"))
                        .addproperties(many(domain, "methods", "String"))))));
   }

	private static MetaDomainFactory newDomain(String name) {
      return new MetaDomainFactoryImpl().setname(name);
   }

   private static MetaDomain.MetaProperty enumerate(MetaDomainFactory domain, String value) {
      return domain.newMetaProperty()
            .setname(value);
   }

   private static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {
      return domain.newMetaProperty()
            .setname(name)
            .setquantifier(MANY)
            .settype(type)
            .settypeDeclaration(typeDeclaration);
   }

   private static MetaDomainFactory.MetaPropertyBuilder many(MetaDomainFactory domain, String name, String type) {
      return many(domain, name, type, null);
   }

   private static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {
      return domain.newMetaProperty()
            .setname(name)
            .setquantifier(ONE)
            .settype(type)
            .settypeDeclaration(typeDeclaration);
   }

   private static MetaDomain.MetaProperty single(MetaDomainFactory domain, String name, String type) {
      return single(domain, name, type, null);
   }

   private static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type, MetaDomain typeDeclaration) {
      return domain.newMetaProperty()
            .setname(name)
            .setquantifier(OPTIONAL)
            .settype(type)
            .settypeDeclaration(typeDeclaration);
   }

   private static MetaDomain.MetaProperty optional(MetaDomainFactory domain, String name, String type) {
      return optional(domain, name, type, null);
   }

   interface DomainTransformer<T> {

      T transform(MetaDomain domain);
   }

   public static abstract class TemplateDomainTransformer<T> implements DomainTransformer<T> {

   	@Override
   	public T transform(MetaDomain domain) {

   		onDomain(domain);

   		domain.properties()
   				.filter(metaProperty -> metaProperty.type().isPresent())
   				.forEach(this::onProperty);

   		final Set<MetaDomain> entities = getEntities(domain);
   		for (MetaDomain entity : entities) onEntity(entity);

   		return onComplete();
   	}

   	protected abstract void onDomain(MetaDomain domain);

   	protected abstract void onProperty(MetaDomain.MetaProperty metaProperty);

   	protected abstract void onEntity(MetaDomain entity);

   	protected abstract T onComplete();

   	protected boolean isInterface(MetaDomain entity) {
   		return entity.properties().anyMatch(metaProperty -> metaProperty.quantifier().isPresent());
   	}

   	protected Object quantifier(MetaDomain.MetaProperty metaProperty) {
   		return metaProperty.quantifier().orElse(null);
   	}

   	protected Object name(MetaDomain.MetaProperty metaProperty) {
   		return metaProperty.name();
   	}

   	protected Object type(MetaDomain.MetaProperty metaProperty) {
   		return metaProperty.type().orElse(null);
   	}

   	protected Object typeDeclaration(MetaDomain.MetaProperty metaProperty) {
   		return metaProperty.typeDeclaration().orElse(null);
   	}

   	Set<MetaDomain> getEntities(MetaDomain domain) {
   		final LinkedHashSet<MetaDomain> set = new LinkedHashSet<>();

   		domain.properties()
   				.filter(metaProperty -> metaProperty.typeDeclaration().isPresent())
   				.map(metaProperty -> metaProperty.typeDeclaration().get())
   				.forEach(metaDomain -> addEntity(metaDomain, set));

   		return set;
   	}

   	private void addEntity(MetaDomain domain, LinkedHashSet<MetaDomain> set) {
   		set.add(domain);
   		domain.properties()
   				.filter(metaProperty -> metaProperty.typeDeclaration().isPresent())
   				.map(metaProperty -> metaProperty.typeDeclaration().get())
   				.forEach(metaDomain -> addEntity(metaDomain, set));
   	}
   }  

   public static void main(String[] args) {

		final String root = args.length <= 0 ? "./src/main/java" : args[0];
		final String packageName = args.length <= 1 ? "domain.nextgen" : args[1];

		final MetaDomain metaDomain = nextgenDomain();

		final ToInterfaces toInterfaces = new ToInterfacesTransformer(packageName).transform(metaDomain);
		STGenerator.writeJavaFile(toInterfaces, toInterfaces.getPackageName().toString(), toInterfaces.getName(), root);

		final ToFactory toFactory = new ToFactoryTransformer(packageName).transform(metaDomain);
		STGenerator.writeJavaFile(toFactory, toFactory.getPackageName().toString(), toFactory.getName(), root);

		final DefaultFactoryImpl defaultFactoryImpl = new ToDefaultFactoryImpl(packageName).transform(metaDomain);
		STGenerator.writeJavaFile(defaultFactoryImpl, defaultFactoryImpl.getPackageName().toString(), defaultFactoryImpl.getName(), root);

		final DomainDeclaration domainDeclaration = new ToDomainDeclaration(packageName).transform(metaDomain);
   }	
}