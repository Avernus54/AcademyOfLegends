package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
//myyy
public class OBJ_chest extends SuperObject{
	GamePanel gp;
	public OBJ_chest(GamePanel gp) {
		this.gp = gp;
		name = "chest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/treasureChest.png"));
			uTool.scaleImage(image,gp.tileSize , gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
