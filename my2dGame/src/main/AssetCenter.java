package main;

import Object.OBJ_Boots;
import Object.OBJ_chest;
import Object.OBJ_door;
import Object.OBJ_key;

public class AssetCenter {
	GamePanel gp;
	
	public AssetCenter(GamePanel gp) {
		this.gp = gp;
		
	}
	public void setObject() {
		gp.obj[2] = new OBJ_Boots();
		gp.obj[2].worldX = 26 * gp.tileSize;
		gp.obj[2].worldY = 45 * gp.tileSize;
		
		gp.obj[3] = new OBJ_key();
		gp.obj[3].worldX = 36 * gp.tileSize;
		gp.obj[3].worldY = 30 * gp.tileSize;
		
		gp.obj[4] = new OBJ_chest();
		gp.obj[4].worldX = 44 * gp.tileSize;
		gp.obj[4].worldY = 14 * gp.tileSize;
		
		gp.obj[5] = new OBJ_door();
		gp.obj[5].worldX = 19 * gp.tileSize;
		gp.obj[5].worldY = 11 * gp.tileSize;
		
		
		
		
		
	}

}
