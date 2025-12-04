package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Entity;
import main.GamePanel;

public class OBJ_heart extends Entity {
	GamePanel gp;
	public OBJ_heart(GamePanel gp) {
		super(gp);
		name = "heart";
		image = setup("/objects/halfheart",gp.tileSize,gp.tileSize);
		image2 = setup("/objects/whiteheart",gp.tileSize,gp.tileSize);
		image3 = setup("/objects/wholeheart",gp.tileSize,gp.tileSize);
		
		
	}

}
