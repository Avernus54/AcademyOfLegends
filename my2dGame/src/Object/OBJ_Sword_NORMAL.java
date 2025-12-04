package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Sword_NORMAL extends Entity {
	public OBJ_Sword_NORMAL(GamePanel gp) {
		super(gp);
		name = "SWORD";
		down1 = setup("/objects/sword_normal",gp.tileSize, gp.tileSize);
		attackValue = 4;
	}
}
