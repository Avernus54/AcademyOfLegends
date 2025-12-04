package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Entity;
import main.GamePanel;
//myyy

public class OBJ_Boots extends Entity{
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		name = "Boots";
		down1 = setup("/objects/Boots",gp.tileSize,gp.tileSize);
	}
}
