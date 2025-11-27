package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_heart extends SuperObject {
	GamePanel gp;
	public OBJ_heart(GamePanel gp) {
		this.gp = gp;
		name = "heart";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/halfheart.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/whiteheart.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/wholeheart.png"));
			image = uTool.scaleImage(image,gp.tileSize , gp.tileSize);
			image2 = uTool.scaleImage(image2,gp.tileSize , gp.tileSize);
			image3 = uTool.scaleImage(image3,gp.tileSize , gp.tileSize);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
