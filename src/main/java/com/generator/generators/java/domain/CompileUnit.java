package com.generator.generators.java.domain;

import com.generator.domain.DomainEntity;

import java.util.Map;

/**
 * User: goe
 * Date: 24.09.13
 */
public interface CompileUnit extends DomainEntity<JavaEntities> {

    String getPackage();

    String getName();

    Map<String,JavaInterface> getImplements();
}