package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

import java.util.*;

public class ToFactoryTransformer extends TemplateDomainTransformer<nextgen.templates.domain.ToFactory> {

	final nextgen.templates.domain.ToFactory result = nextgen.templates.domain.DomainST.newToFactory();

	String packageName;

	public ToFactoryTransformer(String packageName) {
		this.packageName = packageName;
	}

	@Override
	protected void onDomain(MetaDomain domain) {
		result.setName(domain.name() + "Factory");
		result.setPackageName(packageName);
		result.setDomain(domain.name());
	}

	@Override
	protected void onProperty(MetaDomain.MetaProperty metaProperty) {
		result.addProperties(metaProperty.type().get(), name(metaProperty));
	}

	@Override
	protected void onEntity(MetaDomain entity) {
		if (isInterface(entity)) {
		   final FactoryEntity factoryEntity = DomainST.newFactoryEntity();
		   factoryEntity.setName(entity.name());
		   factoryEntity.setType(entity.name());

		   entity.properties()
		         .filter(metaProperty -> metaProperty.type().isPresent())
		         .forEach(metaProperty -> {
		            factoryEntity.addProperties(name(metaProperty), type(metaProperty));
		            if (MetaDomain.Quantifier.ONE.equals(quantifier(metaProperty))) factoryEntity.addRequiredProperties(metaProperty.name(), type(metaProperty));
		         });

		   result.addEntities(factoryEntity);
		}
	}

	@Override
	protected nextgen.templates.domain.ToFactory onComplete() {
		return result;
	}

	@Override
	protected Object name(MetaDomain.MetaProperty metaProperty) {
		if (metaProperty.quantifier().isEmpty()) return "set" + metaProperty.type().get();

		switch (metaProperty.quantifier().get()) {
			case MANY:
				return "add" + metaProperty.name();
			case OPTIONAL:
				return "set" + metaProperty.name();
			default:
				return "set" + metaProperty.name();
		}
	}
}