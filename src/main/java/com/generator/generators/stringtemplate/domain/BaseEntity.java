package com.generator.generators.stringtemplate.domain;

import java.util.UUID;

/**
 * User: geirove
 * Date: 09.11.12
 */
public abstract class BaseEntity<T> implements DomainEntity<T> {

	protected UUID uuid;
	protected T type;

	protected BaseEntity(UUID uuid, T type) {
		this.uuid = uuid;
		this.type = type;
	}

	protected BaseEntity(T type) {
		this.uuid = UUID.randomUUID();
		this.type = type;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public T getDomainType() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseEntity that = (BaseEntity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return uuid.hashCode();
	}
}