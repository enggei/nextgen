package nextgen.domains.meta;

import java.util.LinkedHashSet;
import java.util.Set;

public class MetaDomainVisitor {

    private final Set<MetaEntity> visitedEntities = new LinkedHashSet<>();
    private final Set<MetaRelation> visitedRelations = new LinkedHashSet<>();

    public void visit(MetaDomain metaDomain) {
        metaDomain.getRoots().forEach(this::visit);
    }

    public Set<MetaEntity> getVisitedEntities() {
        return visitedEntities;
    }

    public Set<MetaRelation> getVisitedRelations() {
        return visitedRelations;
    }

    private void visit(MetaEntity metaEntity) {

        if (visitedEntities.contains(metaEntity)) return;
        visitedEntities.add(metaEntity);

        visitEntity(metaEntity);
        metaEntity.getRelations().forEach(this::visit);
    }

    private void visit(MetaRelation metaRelation) {

        if (visitedRelations.contains(metaRelation)) return;
        visitedRelations.add(metaRelation);

        visitRelation(metaRelation);
        metaRelation.getDst().forEach(this::visit);
    }

    public void visitEntity(MetaEntity metaEntity) {

    }

    public void visitRelation(MetaRelation metaRelation) {
    }

}