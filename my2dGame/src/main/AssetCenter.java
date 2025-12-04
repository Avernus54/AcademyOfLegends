package main;

import Entity.NPC_Teacher;
import Object.OBJ_Boots;
import Object.OBJ_chest;
import Object.OBJ_door;
import Object.OBJ_key;
import monster.MON_worms;

public class AssetCenter {
	GamePanel gp;
	
	public AssetCenter(GamePanel gp) {
		this.gp = gp;
		
	}
	public void setObject() {
//		int mapNum=0;
//		gp.obj[mapNum][0] = new OBJ_key(gp);
//		gp.obj[mapNum][0].worldX = 12 * gp.tileSize;
//		gp.obj[mapNum][0].worldY = 12 * gp.tileSize;
//		
//		gp.obj[mapNum][1] = new OBJ_door(gp);
//		gp.obj[mapNum][1].worldX = 13 * gp.tileSize;
//		gp.obj[mapNum][1].worldY = 13 * gp.tileSize;
//		
//		gp.obj[mapNum][2] = new OBJ_chest(gp);
//		gp.obj[mapNum][2].worldX = 14 * gp.tileSize;
//		gp.obj[mapNum][2].worldY = 14 * gp.tileSize;
//		
//		gp.obj[mapNum][3] = new OBJ_Boots(gp);
//		gp.obj[mapNum][3].worldX = 25 * gp.tileSize;
//		gp.obj[mapNum][3].worldY = 12 * gp.tileSize;



	
	}
	public void setNPC() {
		int mapNum=0;
		gp.npc[0] = new NPC_Teacher(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
		
		gp.npc[1] = new NPC_Teacher(gp);
		gp.npc[1].worldX = gp.tileSize*8;
		gp.npc[1].worldY = gp.tileSize*12;
	}
	public void setMonster() {
		int mapNum=0;
		int i = 0;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*24;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*29;
		gp.monster[i].worldY = gp.tileSize*29;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*11;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*24;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*29;
		gp.monster[i].worldY = gp.tileSize*29;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*11;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*24;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*29;
		gp.monster[i].worldY = gp.tileSize*29;
		i++;
		gp.monster[i] = new MON_worms(gp);
		gp.monster[i].worldX = gp.tileSize*8;
		gp.monster[i].worldY = gp.tileSize*11;
	}
	

}
