package domain.meta;

import domain.DomainProcessor.*;
import nextgen.templates.domain.*;

public class Test extends TemplateDomainTransformer<StringBuilder> {

	final StringBuilder result = new StringBuilder();
	String packageName;

	public Test(String packageName) {
		this.packageName = packageName;
	}

	@Override
	protected void onDomain(MetaDomain domain) {
		result.append(domain.name());
	}

	@Override
	protected void onProperty(MetaDomain.MetaProperty metaProperty) {
	}

	@Override
	protected void onEntity(MetaDomain entity) {
	}

	@Override
	protected StringBuilder onComplete() {

		System.out.println(result.toString());
		return result;
	}

}