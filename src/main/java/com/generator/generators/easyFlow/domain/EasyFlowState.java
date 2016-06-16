package com.generator.generators.easyFlow.domain;

import com.generator.domain.DomainEntity;
import com.generator.generators.easyFlow.EasyFlowDomain;

import java.util.Map;

/**
 * goe on 1/2/15.
 */
public interface EasyFlowState extends DomainEntity<EasyFlowDomain.ENTITIES> {

    String getName();

    boolean isInitialState();

    Map<EasyFlowEvent, EasyFlowTransition> getTransitions();
}