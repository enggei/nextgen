package com.generator.neo.remote;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Ernst Sognnes on 16.07.17.
 */
public class NeoCache {

   private static final Map<UUID, NeoNode> nodeCache = new HashMap<>();
   private static final Map<UUID, NeoRelationship> relationshipCache = new HashMap<>();

   static void clear() {
      nodeCache.clear();
      relationshipCache.clear();
   }

   static boolean isCached(final NeoNode neoNode) {
      return neoNode != null && nodeCache.containsKey(neoNode.getUUID());
   }

   static boolean isCached(final NeoRelationship neoRelationship) {
      return neoRelationship != null && relationshipCache.containsKey(neoRelationship.getUUID());
   }

   static boolean isCachedNode(final UUID uuid) {
      return nodeCache.containsKey(uuid);
   }

   static boolean isCachedRelationship(final UUID uuid) {
      return relationshipCache.containsKey(uuid);
   }

   static NeoNode getCachedNode(final UUID uuid) {
      System.out.println("getCachedNode: " + uuid);
      return nodeCache.get(uuid);
   }

   static NeoRelationship getCachedRelationship(final UUID uuid) {
      System.out.println("getCachedRelationship: " + uuid);
      return relationshipCache.get(uuid);
   }

   static NeoNode updateCache(final NeoNode neoNode) {
      System.out.println("updateCache: " + (neoNode != null ? neoNode.toString() : "NULL"));
      if (neoNode == null) return null;

      final UUID uuid = neoNode.getUUID();

      if (!nodeCache.containsKey(uuid)) {
         nodeCache.put(uuid, neoNode);
         return neoNode;
      }

      NeoNode cached = nodeCache.get(uuid);
      if (cached != neoNode) cached.merge(neoNode);

      return cached;
   }

   static NeoRelationship updateCache(final NeoRelationship neoRelationship) {
      System.out.println("updateCache: " + (neoRelationship != null ? neoRelationship.toString() : "NULL"));
      if (neoRelationship == null) return null;

      final UUID uuid = neoRelationship.getUUID();

      if (!relationshipCache.containsKey(uuid)) {
         relationshipCache.put(uuid, neoRelationship);
         return neoRelationship;
      }

      NeoRelationship cached = relationshipCache.get(uuid);
      if (cached != neoRelationship) cached.merge(neoRelationship);

      return cached;
   }

   static NeoNode removeCache(final NeoNode neoNode) {
      System.out.println("removeCache: " + (neoNode != null ? neoNode.toString() : "NULL"));
      if (neoNode == null) return null;

      return nodeCache.remove(neoNode.getUUID());
   }

   static NeoRelationship removeCache(final NeoRelationship neoRelationship) {
      System.out.println("removeCache: " + (neoRelationship != null ? neoRelationship.toString() : "NULL"));
      if (neoRelationship == null) return null;

      return relationshipCache.remove(neoRelationship.getUUID());
   }

   static void invalidateCache() {
      nodeCache.clear();
      relationshipCache.clear();
   }
}