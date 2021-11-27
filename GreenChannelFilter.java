import java.awt.Color;

/**
 * A gray scale image that shows how much green is in each pixel of the image.
 * The lighter the color, the more green.
 * 
 * @author Emma Grey
 * @version 11.27.2021
 */
public class GreenChannelFilter extends Filter
{
    /**
     * Constructor for objects of class GreenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
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
                int greenAmount = pixel.getGreen();
                image.setPixel(x,y,new Color(greenAmount, greenAmount, greenAmount));
            }
        }
    }
}