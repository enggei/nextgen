package domain.meta;

public interface MetaDomainFactory extends MetaDomain {

	MetaDomainFactory setname(String value);
	MetaDomainFactory addproperties(MetaProperty value);

	MetaPropertyBuilder newMetaProperty(String name);

	interface MetaPropertyBuilder extends MetaProperty {
		MetaPropertyBuilder setname(String element);
		MetaPropertyBuilder setquantifier(Quantifier element);
		MetaPropertyBuilder settype(String element);
		MetaPropertyBuilder settypeDeclaration(MetaDomain element);
	}

}