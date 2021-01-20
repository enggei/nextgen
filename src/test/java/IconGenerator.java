import java.io.*;

public class IconGenerator {

   public static void main(String[] args) throws IOException {

      // https://materialdesignicons.com/

      String[] domain = new String[]{
            "#feebe2","#fcc5c0","#fa9fb5","#f768a1","#c51b8a","#7a0177"
      };
      String[] templates = new String[]{
            "#a6cee3","#1f78b4","#b2df8a","#33a02c","#fb9a99","#e31a1c","#fdbf6f","#ff7f00","#cab2d6","#6a3d9a"
      };
      String[] models = new String[]{
            "#f1eef6", "#d0d1e6", "#a6bddb", "#74a9cf", "#3690c0", "#0570b0", "#034e7b"
      };
      String[] other = new String[]{"#d53e4f", "#fc8d59", "#fee08b", "#e6f598", "#99d594", "#3288bd"};

      final File destinationDir = new File("src/main/resources/icons");

      int i = 0;
      makeEntityIcon(destinationDir, "STGroupModel", templates[i++]);
      makeEntityIcon(destinationDir, "STGroupAction", templates[i++]);
      makeEntityIcon(destinationDir, "STInterface", templates[i++]);
      makeEntityIcon(destinationDir, "STGroupFile", templates[i++]);
      makeEntityIcon(destinationDir, "STEnum", templates[i++]);
      makeEntityIcon(destinationDir, "STEnumValue", templates[i++]);
      makeEntityIcon(destinationDir, "STTemplate", templates[i++]);
      makeEntityIcon(destinationDir, "STParameter", templates[i++]);
      makeEntityIcon(destinationDir, "STParameterType", templates[i++]);
      makeEntityIcon(destinationDir, "STParameterKey", templates[i++]);

      i = 0;
      makeEntityIcon(destinationDir, "STValueType", models[i++]);
      makeEntityIcon(destinationDir, "STValue", models[i++]);
      makeEntityIcon(destinationDir, "STArgumentKV", models[i++]);
      makeEntityIcon(destinationDir, "STArgument", models[i++]);
      makeEntityIcon(destinationDir, "STFile", models[i++]);
      makeEntityIcon(destinationDir, "STModel", models[i++]);
      makeEntityIcon(destinationDir, "STProject", models[i++]);

      i = 0;
      makeEntityIcon(destinationDir, "DomainRelationType", domain[i++]);
      makeEntityIcon(destinationDir, "DomainEntityType", domain[i++]);
      makeEntityIcon(destinationDir, "DomainRelation", domain[i++]);
      makeEntityIcon(destinationDir, "DomainEntity", domain[i++]);
      makeEntityIcon(destinationDir, "DomainVisitor", domain[i++]);
      makeEntityIcon(destinationDir, "Domain", domain[i++]);

      makePlainIcon(destinationDir, "cb-get", other[1]);
      makePlainIcon(destinationDir, "cb-set", other[4]);

   }

   private static void makePlainIcon(java.io.File destinationDir, String newName, String color) {

      final String fullName = newName + ".png";
      final int width = 16;
      final int height = width;
      final java.io.File targetFile = new java.io.File(destinationDir, fullName);
      final java.awt.GradientPaint paint = new java.awt.GradientPaint(0, 0, java.awt.Color.decode(color), 0, height, java.awt.Color.decode(color));

      drawImage(width, height, paint, targetFile);

   }

   private static void makeEntityIcon(java.io.File destinationDir, String newName, String color) {

      final String fullName = "nextgen.model." + newName + ".png";
      final int width = 16;
      final int height = width;
      final java.io.File targetFile = new java.io.File(destinationDir, fullName);
      final java.awt.GradientPaint paint = new java.awt.GradientPaint(0, 0, java.awt.Color.decode(color), 0, height, java.awt.Color.decode(color));

      drawImage(width, height, paint, targetFile);
   }

   public static void drawImage(int width, int height, java.awt.GradientPaint gp, File targetFile) {

      java.awt.image.BufferedImage bim = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
      java.awt.Graphics2D g2 = bim.createGraphics();
      g2.setPaint(gp);

      java.awt.RenderingHints qualityHints = new java.awt.RenderingHints(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
      qualityHints.put(java.awt.RenderingHints.KEY_RENDERING, java.awt.RenderingHints.VALUE_RENDER_QUALITY);
      g2.setRenderingHints(qualityHints);
      g2.fillRoundRect(0, 0, width, height, width / 4, height / 4);
      g2.dispose();

      // Throws IOException
      try {
         javax.imageio.ImageIO.write(bim, "PNG", targetFile);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}