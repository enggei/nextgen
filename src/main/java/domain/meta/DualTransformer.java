package domain.meta;

import nextgen.templates.domain.*;
import java.util.*;
import static domain.DomainProcessor.*;

public class DualTransformer extends TemplateDomainTransformer<List<TemplateDomainTransformer<?>>> {

	final List<TemplateDomainTransformer<?>> result = null;

	List<TemplateDomainTransformer<?>> set;

	public DualTransformer(List<TemplateDomainTransformer<?>> set) {
		this.set = set;
	}

	@Override
	public void onDomain(MetaDomain domain) {
		for (TemplateDomainTransformer<?> transformer : set) transformer.onDomain(domain);
	}

	@Override
	public void onProperty(MetaDomain.MetaProperty metaProperty) {
		for (TemplateDomainTransformer<?> transformer : set) transformer.onProperty(metaProperty);
	}

	@Override
	public void onEntity(MetaDomain entity) {
		for (TemplateDomainTransformer<?> transformer : set) transformer.onEntity(entity);
	}

	@Override
	public List<TemplateDomainTransformer<?>> onComplete() {
		return result;
	}

}