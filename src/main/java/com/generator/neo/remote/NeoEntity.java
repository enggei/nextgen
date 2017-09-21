package com.generator.neo.remote;

import org.neo4j.graphdb.Entity;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Ernst Sognnes on 11.07.17.
 */
public interface NeoEntity extends Entity {

/*
   interface NeoEntityDiff {
      Iterable<String> EMPTY_LABELS = new LinkedHashSet<>();

      default Iterable<String> labels() {
         return EMPTY_LABELS;
      }

      Map<String, Object> properties();
   }
*/

   UUID getUUID();

   void merge(NeoEntity other);
}