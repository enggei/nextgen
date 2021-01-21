import java.io.File;

public class IconGenerator {

   public static void main(String[] args) {

      final String fileColor = "#d95f0e";
      final String projectColor = "#35978f";
      final String clipboardGetColor = "#e41a1c";
      final String clipboardSetColor = "#4daf4a";

      String[] domain = new String[]{
            "#fcfbfd", "#efedf5", "#dadaeb", "#bcbddc", "#9e9ac8", "#807dba", "#6a51a3", "#54278f", "#3f007d"
      };
      String[] templates = new String[]{
            "#f7fbff", "#deebf7", "#c6dbef", "#9ecae1", "#6baed6", "#4292c6", "#2171b5", "#08519c", "#08306b"
      };
      String[] templatesSecondary = new String[]{
            "#fcfbfd", "#efedf5", "#dadaeb", "#bcbddc", "#9e9ac8", "#807dba", "#6a51a3", "#54278f", "#3f007d"
      };
      String[] models = new String[]{
            "#f7fcf5", "#e5f5e0", "#c7e9c0", "#a1d99b", "#74c476", "#41ab5d", "#238b45", "#006d2c", "#00441b"
      };

      final File destinationDir = new File("src/main/resources/icons");

      makeEntityIcon(destinationDir, "STGroupFile", fileColor);
      makeEntityIcon(destinationDir, "STFile", fileColor);
      makeEntityIcon(destinationDir, "STProject", projectColor);

      makeIcon(destinationDir, "cb-get", "G", clipboardGetColor);
      makeIcon(destinationDir, "cb-set", "S", clipboardSetColor);

      int i = templates.length - 1;
      makeEntityIcon(destinationDir, "STGroupModel", templates[i--]);
      makeEntityIcon(destinationDir, "STTemplate", templates[i--]);
      makeEntityIcon(destinationDir, "STParameter", templates[i--]);
      makeEntityIcon(destinationDir, "STParameterKey", templates[i--]);
      makeEntityIcon(destinationDir, "STParameterType", templates[i--]);

      i = templatesSecondary.length - 1;
      makeEntityIcon(destinationDir, "STGroupAction", templatesSecondary[i--]);
      makeEntityIcon(destinationDir, "STInterface", templatesSecondary[i--]);
      makeEntityIcon(destinationDir, "STEnum", templatesSecondary[i--]);
      makeEntityIcon(destinationDir, "STEnumValue", templatesSecondary[i--]);

      i = models.length - 1;
      makeEntityIcon(destinationDir, "STModel", models[i--]);
      makeEntityIcon(destinationDir, "STArgument", models[i--]);
      makeEntityIcon(destinationDir, "STArgumentKV", models[i--]);
      makeEntityIcon(destinationDir, "STValue", models[i--]);
      makeEntityIcon(destinationDir, "STValueType", models[i--]);

      i = domain.length - 1;
      makeEntityIcon(destinationDir, "Domain", domain[i--]);
      makeEntityIcon(destinationDir, "DomainEntity", domain[i--]);
      makeEntityIcon(destinationDir, "DomainRelation", domain[i--]);
      makeEntityIcon(destinationDir, "DomainVisitor", domain[i--]);
      makeEntityIcon(destinationDir, "DomainRelationType", domain[i--]);
      makeEntityIcon(destinationDir, "DomainEntityType", domain[i--]);
   }

   private static void makeIcon(java.io.File destinationDir, String filename, String letter, String color) {

      final int width = 16;
      final int height = 16;
      final java.io.File targetFile = new java.io.File(destinationDir, filename + ".png");
      final java.awt.Paint paint = java.awt.Color.decode(color);

      draw(width, height, paint, letter.substring(0, 1), targetFile);
   }

   private static void makeEntityIcon(java.io.File destinationDir, String newName, String color) {

      final String name = newName.startsWith("ST") ? newName.substring(2) : newName;

      final int width = 16;
      final int height = 16;
      final java.io.File targetFile = new java.io.File(destinationDir, "nextgen.model." + newName + ".png");
      final java.awt.Paint paint = java.awt.Color.decode(color);

      if (name.contains("File")) draw(width, height, paint, "F", targetFile);
      else if (name.startsWith("Domain") && !newName.equals("Domain")) draw(width, height, paint, newName.substring(6, 7), targetFile);
      else if (name.endsWith("Action") && !newName.equals("Domain")) draw(width, height, paint, "A", targetFile);
      else draw(width, height, paint, newName.substring(0, 1), targetFile);
   }

   public static void draw(int width, int height, java.awt.Paint gp, String letters, java.io.File targetFile) {

      java.awt.image.BufferedImage bim = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);

      java.awt.Graphics2D g2 = bim.createGraphics();
      g2.setPaint(gp);
      g2.fillRoundRect(0, 0, width, height, width / 4, height / 4);
      g2.setColor(java.awt.Color.WHITE);
      g2.setFont(g2.getFont().deriveFont(java.awt.Font.PLAIN, 10));
      drawCenteredString(letters, width, height, g2);
      g2.dispose();

      try {
         javax.imageio.ImageIO.write(bim, "PNG", targetFile);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static void drawCenteredString(String s, int w, int h, java.awt.Graphics2D g) {
      java.awt.FontMetrics fm = g.getFontMetrics();
      int x = (w - fm.stringWidth(s)) / 2;
      int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
      g.drawString(s, x, y);
   }
}