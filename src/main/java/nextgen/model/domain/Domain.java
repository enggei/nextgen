package nextgen.model.domain;

import org.greenrobot.eventbus.*;

import java.util.UUID;

public class Domain {

	private final String uuid = UUID.randomUUID().toString();
	private final String instance = "." + uuid + ".Domain.";

	private String name = "";
	private java.util.Deque<DomainEntity> roots = new java.util.LinkedList<>();
	private java.util.Deque<DomainProperty> properties = new java.util.LinkedList<>();

	public Domain() {
		EventBus.getDefault().post(System.currentTimeMillis() + instance + "new");
	}

	public String getName() { return name; }

	public Domain setName(String name) { 
		this.name = name; 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "name.set." + name);
		return this;
	}

	public java.util.Deque<DomainEntity> getRoots() { return roots; }

	public Domain addRoots(DomainEntity element) { 
		this.roots.add(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "roots.add." + element);
		return this;
	}

	public Domain removeRoots(DomainEntity element) { 
		this.roots.remove(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "roots.del." + element);
		return this;
	}

	public java.util.Deque<DomainProperty> getProperties() { return properties; }

	public Domain addProperties(DomainProperty element) { 
		this.properties.add(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.add." + element);
		return this;
	}

	public Domain removeProperties(DomainProperty element) { 
		this.properties.remove(element); 
		EventBus.getDefault().post(System.currentTimeMillis() + instance +  "properties.del." + element);
		return this;
	}


	@Override
	public String toString() { return uuid; }
}