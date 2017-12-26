package com.generator.util;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

import java.util.Arrays;
import java.util.List;

/**
 * Created 19.10.17.
 */
public class DiffUtil {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DiffUtil.class);
   public static void main(String[] args) {
      List<String> original = Arrays.asList("one", "two", "three");
      List<String> revised  = Arrays.asList("one", "two", "thr5e");

      // Compute diff. Get the Patch object. Patch is the container for computed deltas.
      Patch<String> patch = DiffUtils.diff(original, revised);

      for (Delta<String> delta: patch.getDeltas()) {
         log.info(delta);
      }
   }
}
