package com.generator.generators.stringtemplate.domain;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.TEMPLATEIMPORT;

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