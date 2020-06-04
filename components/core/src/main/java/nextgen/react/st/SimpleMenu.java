package nextgen.react.st;


public class SimpleMenu {

	private java.util.List<SimpleMenuMenuItems> menuItems = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> menuComponents = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<SimpleMenuMenuItems> getMenuItems() { 
		return menuItems;
	}

	public SimpleMenu addMenuItems(SimpleMenuMenuItems menuItems) { 
		this.menuItems.add(menuItems);
		return this;
	}

	public SimpleMenu removeMenuItems(SimpleMenuMenuItems menuItems) { 
		this.menuItems.remove(menuItems);
		return this;
	}

	public java.util.List<java.lang.Object> getMenuComponents() { 
		return menuComponents;
	}

	public SimpleMenu addMenuComponents(java.lang.Object menuComponents) { 
		this.menuComponents.add(menuComponents);
		return this;
	}

	public SimpleMenu removeMenuComponents(java.lang.Object menuComponents) { 
		this.menuComponents.remove(menuComponents);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SimpleMenu";
	}

	public SimpleMenu() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SimpleMenu(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SimpleMenu other = (SimpleMenu) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}