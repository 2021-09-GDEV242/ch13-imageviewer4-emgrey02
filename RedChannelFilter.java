import java.awt.Color;

/**
 * A gray scale image that shows how much red is in each pixel of the image.
 * The lighter the color, the more red.
 * 
 * @author Emma Grey
 * @version 11.27.2021
 */
public class RedChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public RedChannelFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int redAmount = pixel.getRed();
                image.setPixel(x,y,new Color(redAmount, redAmount, redAmount));
            }
        }
    }
}
