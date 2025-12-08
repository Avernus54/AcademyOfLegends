package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Blue_Shield extends Entity{
	public OBJ_Blue_Shield(GamePanel gp) {
		super(gp);
		type = type_shield;
		name = "Blue Shield";
		down1 = setup("/objects/shield_blue",gp.tileSize, gp.tileSize);
		defenseValue = 13;
		description = "[" + name + "]\n made of lapiz";
	}
}
