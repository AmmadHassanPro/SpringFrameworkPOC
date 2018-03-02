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
			ImageIO.write(originalImage, "jpg", baos );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return baos.toByteArray();
		
		
	}

}
