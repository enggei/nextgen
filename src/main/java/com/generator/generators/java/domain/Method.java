package com.generator.generators.java.domain;

import com.generator.domain.DomainEntity;

import java.util.Collection;

/**
 * User: goe
 * Date: 23.09.13
 */
public interface Method extends DomainEntity<JavaEntities> {

   String getName();

   String getReturnValue();

   Collection<MethodArgument> getArguments();

   String methodBody();

}