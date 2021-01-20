package nextgen.model.domain;

import org.greenrobot.eventbus.*;

import java.util.UUID;

public class DomainEntity {

	private final String uuid = UUID.randomUUID().toString();
	private final String instance = "." + uuid + ".DomainEntity.";

	private String name = "";
	private java.util.Deque<DomainRelation> relations = new java.util.LinkedList<>();
	private java.util.Deque<DomainProperty> properties = new java.util.LinkedList<>();

	public DomainEntity() {
		EventBus.getDefault().post(System.currentTimeMillis() + instance + "new");
	}

	public String getName() { return name; }

	public DomainEntity setName(String name) { 
		this.name = name; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "name.set." + name);
		return this;
	}

	public java.util.Deque<DomainRelation> getRelations() { return relations; }

	public DomainEntity addRelations(DomainRelation element) { 
		this.relations.add(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "relations.add." + element);
		return this;
	}

	public DomainEntity removeRelations(DomainRelation element) { 
		this.relations.remove(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "relations.del." + element);
		return this;
	}

	public java.util.Deque<DomainProperty> getProperties() { return properties; }

	public DomainEntity addProperties(DomainProperty element) { 
		this.properties.add(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.add." + element);
		return this;
	}

	public DomainEntity removeProperties(DomainProperty element) { 
		this.properties.remove(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.del." + element);
		return this;
	}


	@Override
	public String toString() { return uuid; }
}