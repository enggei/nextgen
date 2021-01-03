package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

public class InterfaceImpl extends TemplateDomainTransformer<DefaultFactoryImpl> {

	final DefaultFactoryImpl result = nextgen.templates.domain.DomainST.newDefaultFactoryImpl();
	String packageName;

	public InterfaceImpl(String packageName) {
		this.packageName = packageName;
	}

	@Override
	protected void onDomain(MetaDomain domain) {
		result.setPackageName(packageName);
		result.setName(domain.name() + "FactoryImpl");
		result.setFactory(domain.name() + "Factory");
	}

	@Override
	protected void onProperty(MetaDomain.MetaProperty metaProperty) {
		final String type = metaProperty.type().get();
		final String name = metaProperty.name();

		switch (metaProperty.quantifier().get()) {
		   case MANY:
		      final String manyInit = " new java.util.ArrayList<>()";
		      final String manygetter = name + ".stream()";
		      final String manyImpl = "java.util.List<" + type + ">";
		      final String manyAssign = name + ".add(element)";
		      final String manyMethodName = "add" + name;
		      final String manyType = "java.util.stream.Stream<" + type + ">";
		      result.addProperties(manyInit, manygetter, manyImpl, manyAssign, type, manyMethodName, name, manyType);
		      break;
		   case OPTIONAL:
		      final String optionalInit = null;
		      final String optionalGetter = "java.util.Optional.ofNullable(" + name + ")";
		      final String optionalImpl = type;
		      final String optionalAssign = name + " = element";
		      final String optionalMethodName = "set" + name;
		      final String optionalType = "java.util.Optional<" + type + ">";
		      result.addProperties(optionalInit, optionalGetter, optionalImpl, optionalAssign, type, optionalMethodName, name, optionalType);
		      break;
		   default:
		      final String oneInit = null;
		      final String onegetter = name;
		      final String oneImpl = type;
		      final String oneAssign = name + " = element";
		      final String oneMethodName = "set" + name;
		      final String oneType = type;
		      result.addProperties(oneInit, onegetter, oneImpl, oneAssign, type, oneMethodName, name, oneType);
		      break;
		}
	}

	@Override
	protected void onEntity(MetaDomain entity) {
		if (isInterface(entity)) {
		   final DefaultEntityImpl factoryEntity = DomainST.newDefaultEntityImpl();
		   factoryEntity.setName(entity.name());
		   factoryEntity.setType(entity.name());

		   entity.properties()
		         .filter(metaProperty -> metaProperty.type().isPresent())
		         .forEach(metaProperty -> addMetaProperty(factoryEntity, metaProperty));

		   result.addEntities(factoryEntity);
		}
	}

	@Override
	protected DefaultFactoryImpl onComplete() {
		return result;
	}

	private void addMetaProperty(DefaultEntityImpl result, MetaDomain.MetaProperty metaProperty) {

		final String type = metaProperty.type().get();
		final String name = metaProperty.name();

		switch (metaProperty.quantifier().get()) {
			case MANY:
				final String manyInit = " new java.util.ArrayList<>()";
				final String manygetter = name + ".stream()";
				final String manyImpl = "java.util.List<" + type + ">";
				final String manyAssign = name + ".add(element)";
				final String manyMethodName = "add" + name;
				final String manyType = "java.util.stream.Stream<" + type + ">";
				result.addProperties(manyInit, manygetter, manyAssign, manyImpl, type, name, manyType, manyMethodName);
				break;
			case OPTIONAL:
				final String optionalInit = null;
				final String optionalGetter = "java.util.Optional.ofNullable(" + name + ")";
				final String optionalImpl = type;
				final String optionalAssign = name + " = element";
				final String optionalMethodName = "set" + name;
				final String optionalType = "java.util.Optional<" + type + ">";
				result.addProperties(optionalInit, optionalGetter, optionalAssign, optionalImpl, type, name, optionalType, optionalMethodName);
				break;
			default:
				final String oneInit = null;
				final String onegetter = name;
				final String oneImpl = type;
				final String oneAssign = name + " = element";
				final String oneMethodName = "set" + name;
				final String oneType = type;
				result.addProperties(oneInit, onegetter, oneAssign, oneImpl, type, name, oneType, oneMethodName);
				break;
		}
	}
}