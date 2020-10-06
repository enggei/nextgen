package nextgen.templates;

import nextgen.templates.projects.JavaProjectPackage;
import nextgen.templates.projects.ProjectsST;

public class ProjectsPatterns extends ProjectsST {

   public static JavaProjectPackage newJavaProjectPackage(String name) {
      return newJavaProjectPackage()
            .setName(name);
   }
}