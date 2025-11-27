package main;

import Entity.NPC_Teacher;
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
		
//		gp.obj[0] = new OBJ_key(gp);
//		gp.obj[0].worldX = 21 * gp.tileSize;
//		gp.obj[0].worldY = 21 * gp.tileSize;
//		
//		gp.obj[1] = new OBJ_chest(gp);
//		gp.obj[1].worldX = 8 * gp.tileSize;
//		gp.obj[1].worldY = 11 * gp.tileSize;
//		
//		gp.obj[2] = new OBJ_Boots(gp);
//		gp.obj[2].worldX = 12 * gp.tileSize;
//		gp.obj[2].worldY = 21 * gp.tileSize;
//		
//		gp.obj[3] = new OBJ_door(gp);
//		gp.obj[3].worldX = 11 * gp.tileSize;
//		gp.obj[3].worldY = 12 * gp.tileSize;
//		
	}
	public void setNPC() {
		gp.npc[0] = new NPC_Teacher(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
	

}
