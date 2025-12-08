package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Sword_NORMAL extends Entity {
	public OBJ_Sword_NORMAL(GamePanel gp) {
		super(gp);
		type = type_sword;
		name = "SWORD";
		down1 = setup("/objects/sword_normal",gp.tileSize, gp.tileSize);
		attackValue = 4;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name +"]\n Nice Sword";
		
	}
}
