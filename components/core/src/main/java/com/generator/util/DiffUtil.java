package com.generator.util;

import com.github.difflib.DiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.Delta;
import com.github.difflib.patch.Patch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * Created 19.10.17.
 */
public class DiffUtil {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DiffUtil.class);
   public static void main(String[] args) throws IOException, DiffException {
//      List<String> original = Arrays.asList("one", "two", "three");
//      List<String> revised  = Arrays.asList("one", "two", "thr5e");

      //build simple lists of the lines of the two testfiles
      List<String> original = Files.readAllLines(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/util/CompilerUtil.java").toPath());
      List<String> revised = Files.readAllLines(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/util/CompilerUtil.java").toPath());

//compute the patch: this is the diffutils part
      Patch<String> patch = DiffUtils.diff(original, revised);

//simple output the computed patch to console
      for (Delta<String> delta : patch.getDeltas()) {
         System.out.println(delta);
      }
   }
}
