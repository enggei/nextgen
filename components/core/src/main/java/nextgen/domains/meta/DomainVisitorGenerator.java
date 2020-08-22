package nextgen.domains.meta;

import nextgen.st.stringtemplate.DomainVisitorRunner;
import nextgen.st.stringtemplate.StringTemplateST;
import nextgen.st.stringtemplate.VisitNodeMethod;
import nextgen.st.stringtemplate.VisitRelationMethod;

public class DomainVisitorGenerator extends MetaDomainVisitor {

    private final DomainVisitor visitor;
    private final DomainVisitorRunner scriptRunner;

    public DomainVisitorGenerator(DomainVisitor visitor, DomainVisitorRunner scriptRunner) {
        this.visitor = visitor;
        this.scriptRunner = scriptRunner;
        visitor.getIncomingVisitorsMetaDomain().forEach(this::visit);
    }

    @Override
    public void visitEntity(MetaEntity metaEntity) {
        super.visitEntity(metaEntity);

        if (scriptRunner.getRootNode() == null) scriptRunner.setRootNode(metaEntity.getName());

        final VisitNodeMethod method = StringTemplateST.newVisitNodeMethod().setName(metaEntity.getName());
        metaEntity.getPropertiesSorted().forEach(metaProperty -> method.addProperties(metaProperty.getName(), metaProperty.getDefaultValue()));
        metaEntity.getRelations().forEach(metaRelation -> method.addRelations(metaRelation.getName()));
        scriptRunner.addEntityVisitors(method);

        visitor.getEntityVisitors()
                .filter(entityVisitorMethod -> entityVisitorMethod.get_meta().equals(metaEntity))
                .findAny()
                .ifPresent(entityVisitorMethod -> method.setStatements(entityVisitorMethod.getStatements()));
    }

    @Override
    public void visitRelation(MetaRelation metaRelation) {
        super.visitRelation(metaRelation);

        final VisitRelationMethod method = StringTemplateST.newVisitRelationMethod().setName(metaRelation.getName());
        metaRelation.getPropertiesSorted().forEach(metaProperty -> method.addProperties(metaProperty.getName(), metaProperty.getDefaultValue()));
        metaRelation.getDst().forEach(metaEntity -> method.addDst(metaEntity.getName()));
        scriptRunner.addRelationVisitors(method);

        visitor.getRelationVisitors()
                .filter(relationVisitorMethod -> relationVisitorMethod.get_meta().equals(metaRelation))
                .findAny()
                .ifPresent(relationVisitorMethod -> method.setStatements(relationVisitorMethod.getStatements()));
    }

    public String generate() {
        return scriptRunner.toString();
    }
}