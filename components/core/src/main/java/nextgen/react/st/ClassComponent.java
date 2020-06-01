package nextgen.react.st;


public class ClassComponent {

	private java.util.List<java.lang.Object> returnStatements = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> decorators = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> components = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> events = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> renderConstants = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> dependencies = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> state = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> methods = new java.util.ArrayList<>();
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getReturnStatements() { 
		return returnStatements;
	}

	public ClassComponent addReturnStatements(java.lang.Object returnStatements) { 
		this.returnStatements.add(returnStatements);
		return this;
	}

	public ClassComponent removeReturnStatements(java.lang.Object returnStatements) { 
		this.returnStatements.remove(returnStatements);
		return this;
	}

	public java.util.List<java.lang.Object> getDecorators() { 
		return decorators;
	}

	public ClassComponent addDecorators(java.lang.Object decorators) { 
		this.decorators.add(decorators);
		return this;
	}

	public ClassComponent removeDecorators(java.lang.Object decorators) { 
		this.decorators.remove(decorators);
		return this;
	}

	public java.util.List<java.lang.Object> getComponents() { 
		return components;
	}

	public ClassComponent addComponents(java.lang.Object components) { 
		this.components.add(components);
		return this;
	}

	public ClassComponent removeComponents(java.lang.Object components) { 
		this.components.remove(components);
		return this;
	}

	public java.util.List<java.lang.Object> getEvents() { 
		return events;
	}

	public ClassComponent addEvents(java.lang.Object events) { 
		this.events.add(events);
		return this;
	}

	public ClassComponent removeEvents(java.lang.Object events) { 
		this.events.remove(events);
		return this;
	}

	public java.util.List<java.lang.Object> getRenderConstants() { 
		return renderConstants;
	}

	public ClassComponent addRenderConstants(java.lang.Object renderConstants) { 
		this.renderConstants.add(renderConstants);
		return this;
	}

	public ClassComponent removeRenderConstants(java.lang.Object renderConstants) { 
		this.renderConstants.remove(renderConstants);
		return this;
	}

	public java.util.List<java.lang.Object> getDependencies() { 
		return dependencies;
	}

	public ClassComponent addDependencies(java.lang.Object dependencies) { 
		this.dependencies.add(dependencies);
		return this;
	}

	public ClassComponent removeDependencies(java.lang.Object dependencies) { 
		this.dependencies.remove(dependencies);
		return this;
	}

	public java.util.List<java.lang.Object> getState() { 
		return state;
	}

	public ClassComponent addState(java.lang.Object state) { 
		this.state.add(state);
		return this;
	}

	public ClassComponent removeState(java.lang.Object state) { 
		this.state.remove(state);
		return this;
	}

	public java.util.List<java.lang.Object> getMethods() { 
		return methods;
	}

	public ClassComponent addMethods(java.lang.Object methods) { 
		this.methods.add(methods);
		return this;
	}

	public ClassComponent removeMethods(java.lang.Object methods) { 
		this.methods.remove(methods);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public ClassComponent setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public ClassComponent removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ClassComponent";
	}

	public ClassComponent() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ClassComponent(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ClassComponent other = (ClassComponent) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}