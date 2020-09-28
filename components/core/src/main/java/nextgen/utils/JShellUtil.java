package nextgen.utils;

import jdk.jshell.JShell;
import jdk.jshell.execution.LocalExecutionControlProvider;

public class JShellUtil {

   public static JShell newLocalShell() {
      return JShell.builder()
            .executionEngine(new LocalExecutionControlProvider(), null)
            .build();
   }
}