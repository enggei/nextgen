package nextgen.domains.meta;

import nextgen.templates.stringtemplate.DomainVisitorRunner;
import nextgen.templates.stringtemplate.StringTemplateST;
import nextgen.templates.stringtemplate.VisitNodeMethod;
import nextgen.templates.stringtemplate.VisitRelationMethod;
import nextgen.templates.java.ImportDeclaration;
import nextgen.templates.java.PackageDeclaration;

import java.util.Collection;

public class DomainVisitorGenerator extends MetaDomainVisitor {

    private final DomainVisitor visitor;
    private final DomainVisitorRunner scriptRunner;

    public DomainVisitorGenerator(DomainVisitor visitor, DomainEntity domainEntity, PackageDeclaration packageDeclaration, Collection<ImportDeclaration> imports, String className, String templatesDir, String dbDir) {
        this.visitor = visitor;
        scriptRunner = StringTemplateST.newDomainVisitorRunner();
        scriptRunner.setPackageName(packageDeclaration.getName());
        scriptRunner.setName(className);
        scriptRunner.setTemplatesDir(templatesDir);
        scriptRunner.setDbDir(dbDir);
        scriptRunner.setEntityUuid(domainEntity.getUuid());
        for (Object anImport : imports)
            scriptRunner.addImports(anImport);
        scriptRunner.setInitStatements(visitor.getInitStatements());
        scriptRunner.setEndStatements(visitor.getEndStatements());
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

    public DomainVisitorRunner generate() {
        return scriptRunner;
    }
}