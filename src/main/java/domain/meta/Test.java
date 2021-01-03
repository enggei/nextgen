package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

import java.util.*;

public class Test extends TemplateDomainTransformer<DomainDeclaration> {

	final DomainDeclaration result = DomainST.newDomainDeclaration();
	String packageName;
	Stack<DomainEntityDeclaration> declarations = new Stack<>();

	public Test(String packageName) {
		this.packageName = packageName;
	}

	@Override
	protected void onDomain(MetaDomain domain) {
		result.setName(domain.name());
	}

	@Override
	protected void onProperty(MetaDomain.MetaProperty metaProperty) {
		result.addProperties(quantifier(metaProperty), type(metaProperty), metaProperty.name(), typeDeclaration(metaProperty));
	}

	@Override
	protected void onEntity(MetaDomain entity) {
		final DomainEntityDeclaration entityDeclaration = DomainST.newDomainEntityDeclaration()
		            .setName(entity.name());

		declarations.push(entityDeclaration);

		entity.properties().forEach(metaProperty -> entityDeclaration.addProperties(typeDeclaration(metaProperty), type(metaProperty), metaProperty.name(), quantifier(metaProperty)));
	}

	@Override
	protected DomainDeclaration onComplete() {

		while(!declarations.isEmpty()) {
			result.addEntities(declarations.pop());
		}

		System.out.println(result.toString());
		return result;
	}

	private Object quantifier(MetaDomain.MetaProperty metaProperty) {
		final Optional<MetaDomain.Quantifier> quantifier = metaProperty.quantifier();
		if (quantifier.isPresent()) {
			switch (quantifier.get()) {
				case ONE:
					return metaProperty.type().isPresent() ? "single" : "enumerate";
				case MANY:
					return "many";
				case OPTIONAL:
					return "optional";
			}
		}
		return metaProperty.type().isPresent() ? null : "enumerate";
	}

	private Object type(MetaDomain.MetaProperty metaProperty) {
		final Optional<String> type = metaProperty.type();
		return type.orElse(null);
	}

	private Object typeDeclaration(MetaDomain.MetaProperty metaProperty) {
		final Optional<MetaDomain> typeDeclaration = metaProperty.typeDeclaration();
		if (typeDeclaration.isPresent()) return typeDeclaration.get().name();
		return typeDeclaration.orElse(null);
	}
}