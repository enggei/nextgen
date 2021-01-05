package domain.meta;

import nextgen.templates.domain.*;
import java.util.*;
import static domain.DomainProcessor.*;

public class ToInterfacesTransformer extends TemplateDomainTransformer<ToInterfaces> {

	final ToInterfaces result = DomainST.newToInterfaces();

	String packageName;

	public ToInterfacesTransformer(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public void onDomain(MetaDomain domain) {
		result.setName(domain.name());
		result.setPackageName(packageName);
	}

	@Override
	public void onProperty(MetaDomain.MetaProperty metaProperty) {
		result.addProperties(getType(metaProperty), metaProperty.name());
	}

	@Override
	public void onEntity(MetaDomain entity) {
		if (isInterface(entity)) {

			final ToInterface factoryEntity = DomainST.newToInterface();
			factoryEntity.setName(entity.name());
			entity.properties().forEach(metaProperty -> factoryEntity.addProperties(metaProperty.name(), getType(metaProperty)));
			result.addDomains(factoryEntity);

		} else {

			final ToEnum toEnum = DomainST.newToEnum();
			toEnum.setName(entity.name());
			entity.properties().forEach(metaProperty -> toEnum.addProperties(metaProperty.name()));
			result.addDomains(toEnum);

		}
	}

	@Override
	public ToInterfaces onComplete() {
		return result;
	}

	private Object getType(MetaDomain.MetaProperty metaProperty) {

	   if (metaProperty.quantifier().isEmpty()) return metaProperty.type().get();

	   switch (metaProperty.quantifier().get()) {
	      case MANY:
	         return "java.util.stream.Stream<" + metaProperty.type().get() + ">";
	      case OPTIONAL:
	         return "java.util.Optional<" + metaProperty.type().get() + ">";
	      default:
	         return metaProperty.type().get();
	   }
	}
}