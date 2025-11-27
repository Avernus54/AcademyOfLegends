package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
//myyy


public class OBJ_door extends SuperObject {
	GamePanel gp;
	public OBJ_door(GamePanel gp) {
		this.gp = gp;
		name = "door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/dorr.png"));
			uTool.scaleImage(image,gp.tileSize , gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
