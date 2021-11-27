import java.awt.Color;

/**
 * A gray scale image that shows how much blue is in each pixel of the image.
 * The lighter the color, the more blue.
 * 
 * @author Emma Grey
 * @version 11.27.2021
 */
public class BlueChannelFilter extends Filter
{
    /**
     * Constructor for objects of class BlueChannelFilter.
     * @param name The name of the filter.
     */
    public BlueChannelFilter(String name)
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
                int blueAmount = pixel.getBlue();
                image.setPixel(x,y,new Color(blueAmount, blueAmount, blueAmount));
            }
        }
    }
}