package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Shield extends Entity{
	public OBJ_Shield(GamePanel gp) {
		super(gp);
		type = type_shield;
		name = "Shield";
		down1 = setup("/objects/shield_wood",gp.tileSize, gp.tileSize);
		defenseValue = 1;
		description = "[" + name + "]\n made of wood";
	}
}
