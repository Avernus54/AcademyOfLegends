package tile;

import java.awt.image.BufferedImage;

public class Tile {

		public BufferedImage image;
		public BufferedImage[] animationFrames;

	    public int frameIndex = 0;
	    public int frameDelay = 20;
	    public int frameCounter = 0;

	    public boolean collision = false;
		
		 
		
}
