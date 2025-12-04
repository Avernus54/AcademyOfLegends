//package main;
//
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//
//public class UtilityTool {
//	
//	public BufferedImage scaleImage(BufferedImage original,int width,int height) {
//		BufferedImage scaledImage = new BufferedImage(width,height,original.getType());
//		Graphics2D g2 = scaledImage.createGraphics();
//		g2.drawImage(original,0,0,width,height,null);
//		g2.dispose();
//		
//		return scaledImage;
//	}
//
//}
package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {

    public BufferedImage scaleImage(BufferedImage original, int width, int height) {
        if (original == null) {
            System.out.println("Error: Original image is null!");
            return null; // Prevent crash
        }

        int imageType = original.getType();
        if (imageType == 0) {
            imageType = BufferedImage.TYPE_INT_ARGB; // Safe default type
        }

        BufferedImage scaledImage = new BufferedImage(width, height, imageType);
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();

        return scaledImage;
    }
}
