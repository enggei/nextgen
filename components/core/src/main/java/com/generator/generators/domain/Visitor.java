package com.generator.generators.domain;

import org.neo4j.graphdb.Node;

/**
 * Created 30.10.17.
 */
public interface Visitor<T> {

   void visit(Node node);

   T getResult();

}