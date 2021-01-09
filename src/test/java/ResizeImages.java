import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImages {

   public static void main(String[] args) throws IOException {

      // https://materialdesignicons.com/
      final int d = 16;

      final File sourceDir = new File("resources/icons");

      final File[] pngs = sourceDir
            .listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".png") && !pathname.getName().endsWith(d + "x" + d + ".png"));

      final File destinationDir = new File("src/main/resources/icons");
      for (File png : pngs) {
         final BufferedImage src = ImageIO.read(png);
         ImageIO.write(toBufferedImage(src.getScaledInstance(d, d, Image.SCALE_SMOOTH)), "png", new File(destinationDir, png.getName().replaceAll(".png", d + "x" + d + ".png")));
      }
   }

   public static BufferedImage toBufferedImage(Image img) {

      if (img instanceof BufferedImage)
         return (BufferedImage) img;

      final BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

      final Graphics2D bGr = bimage.createGraphics();
      bGr.drawImage(img, 0, 0, null);
      bGr.dispose();

      return bimage;
   }
}
