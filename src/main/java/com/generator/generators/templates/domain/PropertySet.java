package com.generator.generators.templates.domain;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.generator.generators.templates.domain.TemplateEntities.PROPERTYSET;

/**
 * User: geirove
 * Date: 27.01.13
 * <p>
 * //todo to referencing on the other Properties as well ...
 */
public final class PropertySet extends Property {

	private final List<Property> propertyList;
	private final PropertySet reference;

	public PropertySet(PropertySet reference) {
		super(PROPERTYSET);
		this.propertyList = null;
		this.reference = reference;
	}

	public PropertySet(List<Property> properties) {
		super(PROPERTYSET);
		this.propertyList = properties;
		this.reference = null;
	}

	public PropertySet(Property... properties) {
		super(PROPERTYSET);
		this.propertyList = new ArrayList<>();
		for (Property property : properties)
			this.propertyList.add(property);
		this.reference = null;
	}

	public PropertySet() {
		super(PROPERTYSET);
		this.propertyList = new ArrayList<>();
		this.reference = null;
	}

	public List<Property> getPropertyList() {
		if (reference != null)
			return new ArrayList<>(reference.getPropertyList());
		return propertyList;
	}

	public boolean removeProperty(UUID uuid) {

		if (reference != null) {
			return reference.removeProperty(uuid);
		}

		boolean removed = false;
		for (int i = propertyList.size() - 1; i >= 0; i--) {
			if (propertyList.get(i).getUuid().equals(uuid)) {
				propertyList.remove(i);
				removed = true;
			}
		}
		return removed;
	}

	public PropertySet add(Property property) {

		if (reference != null) {
			// not allowed
//         reference.add(property);
			return this;
		}

		if (this.propertyList.contains(property)) return this;
		propertyList.add(property);
		return this;
	}

	@Override
	public String getPropertyName() {
		return null;
	}

	@Override
	public void renameTemplateStatement(String oldName, String newName) {

		if (reference != null) {
			//reference.renameTemplateStatement(oldName, newName);
			return;
		}

		for (Property property : propertyList) {
			property.renameTemplateStatement(oldName, newName);
		}
	}

	@Override
	public Property copy() {
		return null;
	}

	//   public String getPropertyValue(String name) {
//
//      for (Property property : propertyList) {
//         if (name.equals(property.getPropertyName())) {
//            switch (property.getPropertyType()) {
//               case StringProperty:
//                  return ((StringProperty) property).getValue();
//            }
//         }
//      }
//      return null;
//   }

	public List<Property> copyElements() {
		final List<Property> copiedElements = new ArrayList<>();
		for (Property property : propertyList)
			copiedElements.add(property.copy());
		return copiedElements;
	}

	@Override
	public JsonObject toJson() {
		final JsonArray jsonArray = new JsonArray();
		for (Property property : propertyList)
			jsonArray.add(property.toJson());

		return newJson().
			put("propertyList", jsonArray);
	}
}