package Object;


import Entity.Entity;
import main.GamePanel;
//myyy


public class OBJ_door extends Entity {
	
	public OBJ_door(GamePanel gp) {
		super(gp);
		name = "door";
		down1 = setup("/objects/dorr",gp.tileSize,gp.tileSize);
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 14;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
}
