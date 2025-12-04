package Object;


import Entity.Entity;
import main.GamePanel;
//myyy
public class OBJ_chest extends Entity{
	
	public OBJ_chest(GamePanel gp) {
		super(gp);
		name = "chest";
		down1 = setup("/objects/treasureChest",gp.tileSize,gp.tileSize);
		
	}
}
