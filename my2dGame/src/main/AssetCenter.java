package main;

import Entity.NPC_Teacher;

public class AssetCenter {
	GamePanel gp;
	
	public AssetCenter(GamePanel gp) {
		this.gp = gp;
		
	}
	public void setObject() {
		
		
		
		
	}
	public void setNPC() {
		gp.npc[0] = new NPC_Teacher(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
	

}
