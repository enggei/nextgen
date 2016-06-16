package com.generator.generators.templates.domain;

import com.generator.domain.BaseEntity;

import static com.generator.generators.templates.domain.TemplateEntities.TEMPLATEIMPORT;

/**
 * goe on 12/27/15.
 */
public class TemplateImport extends BaseEntity<TemplateEntities> {

    private String name;

    public TemplateImport(String name) {
        super(TEMPLATEIMPORT);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}