package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Entity;
import main.GamePanel;
//myyy

public class OBJ_Axe extends Entity{
	public OBJ_Axe(GamePanel gp) {
		super(gp);
		type = type_axe;
		name = "Stone Axe";
		down1 = setup("/objects/Axe",gp.tileSize,gp.tileSize);
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name +"]\n Axe is made by Stone";
		attackValue = 2;
	}
}
