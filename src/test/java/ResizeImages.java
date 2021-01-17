import java.io.*;

public class ResizeImages {

   public static void main(String[] args) throws IOException {

      // https://materialdesignicons.com/

      final File sourceDir = new File("resources/icons");
      final File destinationDir = new File("src/main/resources/icons");
      for (File png : java.util.Objects.requireNonNull(sourceDir.listFiles(java.io.File::isFile))) {

         String name = png.getName();
         final int startIndex = "alpha-".length();
         final int endIndex = name.indexOf("-", startIndex + 1);
         String letter = name.substring(startIndex, endIndex);
         switch (letter) {
            case "m":
               copy(png, destinationDir, "STModel");
               break;
            case "v":
               copy(png, destinationDir, "STValue");
               copy(png, destinationDir, "STEnumValue");
               copy(png, destinationDir, "DomainVisitor");
               break;
            case "e":
               copy(png, destinationDir, "STEnum");
               copy(png, destinationDir, "DomainEntity");
               break;
            case "a":
               copy(png, destinationDir, "STGroupAction");
               copy(png, destinationDir, "STArgument");
               break;
            case "r":
               copy(png, destinationDir, "DomainRelation");
               break;
            case "p":
               copy(png, destinationDir, "STProject");
               copy(png, destinationDir, "STParameter");
               break;
            case "d":
               copy(png, destinationDir, "Domain");
               break;
            case "g":
               copy(png, destinationDir, "STGroupModel");
               break;
            case "t":
               copy(png, destinationDir, "STTemplate");
               copy(png, destinationDir, "STValueType");
               copy(png, destinationDir, "STParameterType");
               copy(png, destinationDir, "DomainEntityType");
               copy(png, destinationDir, "DomainRelationType");
               break;
            case "i":
               copy(png, destinationDir, "STInterface");
               break;
            case "f":
               copy(png, destinationDir, "STGroupFile");
               copy(png, destinationDir, "STFile");
               break;
            case "k":
               copy(png, destinationDir, "STParameterKey");
               copy(png, destinationDir, "STArgumentKV");
               break;
            default:
               System.out.println("case \"" + letter + "\": break;");
         }
      }
   }

   private static void copy(java.io.File png, java.io.File destinationDir, String newName) throws java.io.IOException {

      java.nio.file.Path FROM = java.nio.file.Paths.get(png.getAbsolutePath());
      java.nio.file.Path TO = java.nio.file.Paths.get(new File(destinationDir, "nextgen.model." + newName + ".png").getPath());

      java.nio.file.CopyOption[] options = new java.nio.file.CopyOption[]{
            java.nio.file.StandardCopyOption.REPLACE_EXISTING,
            java.nio.file.StandardCopyOption.COPY_ATTRIBUTES
      };
      java.nio.file.Files.copy(FROM, TO, options);
   }
}