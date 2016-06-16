package com.generator.generators.easyFlow.domain;

import com.generator.domain.DomainEntity;
import com.generator.generators.easyFlow.EasyFlowDomain;

import java.util.List;
import java.util.Map;

/**
 * goe on 1/2/15.
 */
public interface EasyFlowFSM extends DomainEntity<EasyFlowDomain.ENTITIES> {

    String getName();   // HttpRequestFSM

    String getPackage();   // [package]

    String getExtends(); // if FSM extends any class

//    String getTemplateFile();   // [templateFile]

    String getTargetFile();   // [targetFile]

    String getContextName(); // RequestContext

    List<EasyFlowContextProperty> getContextProperties();  // fields in context

    Map<String, EasyFlowState> getStates();  // States

    Map<String, EasyFlowEvent> getEvents();  // Events
}