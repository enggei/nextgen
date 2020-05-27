package nextgen.domain.domain;


public class DomainFactory {

	public static Domain newDomain() { 
		return new Domain();
	}

	public static Entity newEntity() { 
		return new Entity();
	}

	public static Relation newRelation() { 
		return new Relation();
	}
}