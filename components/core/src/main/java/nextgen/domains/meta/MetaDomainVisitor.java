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

        beforeEntity(metaEntity);
        metaEntity.getRelations().forEach(this::visit);
        afterEntity(metaEntity);
    }

    private void visit(MetaRelation metaRelation) {

        if (visitedRelations.contains(metaRelation)) return;
        visitedRelations.add(metaRelation);

        beforeRelation(metaRelation);
        metaRelation.getDst().forEach(this::visit);
        afterRelation(metaRelation);
    }

    public void beforeEntity(MetaEntity metaEntity) {
        System.out.println("before metaEntity " + metaEntity.getName());
    }

    public void afterEntity(MetaEntity metaEntity) {
        System.out.println("after metaEntity " + metaEntity.getName());
    }

    public void beforeRelation(MetaRelation metaRelation) {
        System.out.println("before metaRelation" + metaRelation.getName());
    }

    public void afterRelation(MetaRelation metaRelation) {
        System.out.println("after metaRelation" + metaRelation.getName());
    }
}