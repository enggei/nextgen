package com.generator.generators.easyFlow.domain;

import com.generator.domain.DomainEntity;
import com.generator.generators.easyFlow.EasyFlowDomain;

/**
 * goe on 1/6/15.
 */
public interface EasyFlowContextProperty extends DomainEntity<EasyFlowDomain.ENTITIES> {

    String getName();

    String getModifier();

    String getType();

    String getInitializer();

}