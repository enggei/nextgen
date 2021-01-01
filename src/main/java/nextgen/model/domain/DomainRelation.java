package nextgen.model.domain;

import org.greenrobot.eventbus.*;

import java.util.UUID;

public class DomainRelation {

	private final String uuid = UUID.randomUUID().toString();
	private final String instance = "." + uuid + ".DomainRelation.";

	private String name = "";
	private java.util.Deque<DomainProperty> properties = new java.util.LinkedList<>();
	private DomainEntity entity;

	public DomainRelation() {
		EventBus.getDefault().post(System.currentTimeMillis() + instance + "new");
	}

	public String getName() { return name; }

	public DomainRelation setName(String name) { 
		this.name = name; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "name.set." + name);
		return this;
	}

	public java.util.Deque<DomainProperty> getProperties() { return properties; }

	public DomainRelation addProperties(DomainProperty element) { 
		this.properties.add(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.add." + element);
		return this;
	}

	public DomainRelation removeProperties(DomainProperty element) { 
		this.properties.remove(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.del." + element);
		return this;
	}

	public DomainEntity getEntity() { return entity; }

	public DomainRelation setEntity(DomainEntity entity) { 
		this.entity = entity; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "entity.set." + entity);
		return this;
	}


	@Override
	public String toString() { return uuid; }
}