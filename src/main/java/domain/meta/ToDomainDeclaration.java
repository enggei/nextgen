package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

import java.util.*;

public class ToDomainDeclaration extends TemplateDomainTransformer<DomainDeclaration> {

	final DomainDeclaration result = DomainST.newDomainDeclaration();

	final Stack<DomainEntityDeclaration> declarations = new Stack<>();
	String packageName;

	public ToDomainDeclaration(String packageName) {
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
		declarations.push(DomainST.newDomainEntityDeclaration().setName(entity.name()));
		entity.properties().forEach(metaProperty -> declarations.peek().addProperties(typeDeclaration(metaProperty), type(metaProperty), metaProperty.name(), quantifier(metaProperty)));
	}

	@Override
	protected DomainDeclaration onComplete() {
		while (!declarations.isEmpty()) result.addEntities(declarations.pop());
		System.out.println(result.toString());
		return result;
	}

	@Override
	protected Object quantifier(MetaDomain.MetaProperty metaProperty) {
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
	@Override
	protected Object typeDeclaration(MetaDomain.MetaProperty metaProperty) {
		final Optional<MetaDomain> typeDeclaration = metaProperty.typeDeclaration();
		if (typeDeclaration.isPresent()) return typeDeclaration.get().name();
		return typeDeclaration.orElse(null);
	}

}