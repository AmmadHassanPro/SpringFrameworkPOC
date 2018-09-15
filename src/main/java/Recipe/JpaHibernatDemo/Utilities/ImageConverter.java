package Recipe.JpaHibernatDemo.Utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;


import javax.imageio.ImageIO;

public class ImageConverter {
	
	
public byte[] ConvertToByteArray(String Url) {
	ByteArrayOutputStream baos =new ByteArrayOutputStream();
		if (Url == null || Url.isEmpty()) {
			
			return baos.toByteArray();
		}
		
		try {
			URL imageURL = new URL(Url);
			BufferedImage originalImage=ImageIO.read(imageURL);
			originalImage = scale(originalImage,600,400); // Adjusting Images height and width
			
			ImageIO.write(originalImage, "jpg", baos );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
		return baos.toByteArray();
		
		
	}





// This function will adjust the height and width of an image
public static BufferedImage scale(BufferedImage src, int w, int h)
{
    BufferedImage img = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
    for (x = 0; x < w; x++) {
        int newX = x * ww / w;
        for (y = 0; y < h; y++) {
            int col = src.getRGB(newX, ys[y]);
            img.setRGB(x, y, col);
        }
    }
    return img;
}



}
