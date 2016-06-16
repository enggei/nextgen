package com.generator.generators.easyFlow.domain;

import com.generator.domain.DomainEntity;
import com.generator.generators.easyFlow.EasyFlowDomain;

/**
 * goe on 1/2/15.
 */
public interface EasyFlowEvent extends DomainEntity<EasyFlowDomain.ENTITIES> {

    String getName();

}