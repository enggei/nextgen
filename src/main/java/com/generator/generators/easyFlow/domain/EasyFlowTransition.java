package com.generator.generators.easyFlow.domain;

/**
 * goe on 1/2/15.
 */
public interface EasyFlowTransition {

    public EasyFlowState getStart();

    public EasyFlowState getEnd();

    public EasyFlowEvent getEvent();

    public boolean isEndState();

}