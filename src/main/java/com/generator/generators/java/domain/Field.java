package com.generator.generators.java.domain;

import com.generator.domain.DomainEntity;

/**
 * User: goe
 * Date: 23.09.13
 */
public interface Field extends DomainEntity<JavaEntities> {

   String getName();

   String getType();

   String getInitializer();

}