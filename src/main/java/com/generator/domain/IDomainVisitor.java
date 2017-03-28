package com.generator.domain;

import org.neo4j.graphdb.Node;

/**
 * Created 24.03.17.
 */
public interface IDomainVisitor {

   <T> T visit(Node node);

}
