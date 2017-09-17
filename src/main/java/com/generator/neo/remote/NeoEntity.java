package com.generator.neo.remote;

import org.neo4j.graphdb.Entity;

import java.util.UUID;

/**
 * Created by Ernst Sognnes on 11.07.17.
 */
public interface NeoEntity extends Entity {

   UUID getUUID();

   void merge(NeoEntity neoEntity);
}