package domain.meta;

import nextgen.templates.domain.*;
import java.util.*;
import static domain.DomainProcessor.*;

public class ToFactoryTransformer extends TemplateDomainTransformer<nextgen.templates.domain.ToFactory> {

	final nextgen.templates.domain.ToFactory result = nextgen.templates.domain.DomainST.newToFactory();

	String packageName;

	public ToFactoryTransformer(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public void onDomain(MetaDomain domain) {
		result.setName(domain.name() + "Factory");
		result.setPackageName(packageName);
		result.setDomain(domain.name());
	}

	@Override
	public void onProperty(MetaDomain.MetaProperty metaProperty) {
		result.addProperties(metaProperty.type().get(), name(metaProperty));
	}

	@Override
	public void onEntity(MetaDomain entity) {
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
	public nextgen.templates.domain.ToFactory onComplete() {
		return result;
	}

	@Override
	public Object name(MetaDomain.MetaProperty metaProperty) {
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