package nextgen.domain.domain;


public class DomainFactory {

	public static Domain newDomain() { 
		return new Domain();
	}

	public static Enum newEnum() { 
		return new Enum();
	}

	public static Entity newEntity() { 
		return new Entity();
	}

	public static Property newProperty() { 
		return new Property();
	}

	public static Relation newRelation() { 
		return new Relation();
	}
}