package com.generator.generators.java.domain;

import java.util.Collection;

/**
 * User: goe
 * Date: 23.09.13
 */
public interface JavaEnum extends CompileUnit {

    Collection<EnumValue> getValues();

}