import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImages {

    public static void main(String[] args) throws IOException {

        // https://materialdesignicons.com/

        final File[] pngs = new File("components/core/src/main/resources/icons")
                .listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".png") && !pathname.getName().endsWith("16x16.png"));

        for (File png : pngs) {
            final BufferedImage src = ImageIO.read(png);
            ImageIO.write(toBufferedImage(src.getScaledInstance(16, 16, Image.SCALE_SMOOTH)), "png", new File(png.getParent(), png.getName().replaceAll(".png", "16x16.png")));
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
