package com.generator.generators.java.domain;

import com.generator.domain.DomainEntity;

/**
 * goe on 12/3/14.
 */
public interface MethodArgument extends DomainEntity<JavaEntities> {

    boolean isFinal();

    String getName();

    String getType();

}