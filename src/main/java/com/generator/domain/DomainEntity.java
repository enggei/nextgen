package com.generator.domain;

import java.util.UUID;

/**
 * User: goe
 * Date: 26.09.13
 */
public interface DomainEntity<T> {

   UUID getUuid();

	T getDomainType();
}