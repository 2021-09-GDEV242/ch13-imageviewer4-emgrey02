
import java.awt.Color;

/**
 * A filter that makes the image look like the classic Andy Worhol image, 
 * except that the three other images are flipped according to their 
 * placement.
 * 
 * @author Emma Grey
 * @version 11.27.2021
 */
public class FlippedWarholFilter extends Filter
{
    /**
     * Constructor for objects of class FlippedWarholFilter.
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight()/2;
        int width = image.getWidth()/2;
        OFImage original = new OFImage(image);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = original.getPixel(x * 2, y * 2);
                image.setPixel(x,y,pixel);
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = width; x < width * 2; x++) {
                Color pixel = original.getPixel((width - (x - width)) * 2 - 1, y * 2);
                int redAmount = pixel.getRed();
                image.setPixel(x,y, new Color(redAmount, 0, 0));
            }
        }
        for(int y = height; y < height * 2; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = original.getPixel(x * 2, (height - (y - height)) * 2 - 1);
                int greenAmount = pixel.getGreen();
                image.setPixel(x,y, new Color(0, greenAmount, 0));
            }
        }
        for(int y = height; y < height * 2; y++) {
            for(int x = width; x < width * 2; x++) {
                Color pixel = original.getPixel((width - (x - width)) * 2 - 1, (height - (y - height)) * 2 - 1);
                int blueAmount = pixel.getBlue();
                image.setPixel(x,y, new Color(0, 0, blueAmount));
            }
        }
    }
}