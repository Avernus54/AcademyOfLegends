package main;

import Entity.NPC_Teacher;
import Object.OBJ_Axe;
import Object.OBJ_Blue_Shield;
import Object.OBJ_Boots;
import Object.OBJ_Potion;
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
		int i = 0;
		gp.obj[i] = new OBJ_key(gp);
		gp.obj[i].worldX = 12 * gp.tileSize;
		gp.obj[i].worldY = 12 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_door(gp);
		gp.obj[i].worldX = 13 * gp.tileSize;
		gp.obj[i].worldY = 13 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_chest(gp);
		gp.obj[i].worldX = 14 * gp.tileSize;
		gp.obj[i].worldY = 14 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_Boots(gp);
		gp.obj[i].worldX = 25 * gp.tileSize;
		gp.obj[i].worldY = 12 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = 13 * gp.tileSize;
		gp.obj[i].worldY = 15 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_Blue_Shield(gp);
		gp.obj[i].worldX = 13 * gp.tileSize;
		gp.obj[i].worldY = 14 * gp.tileSize;
		i++;
		gp.obj[i] = new OBJ_Potion(gp);
		gp.obj[i].worldX = 10 * gp.tileSize;
		gp.obj[i].worldY = 14 * gp.tileSize;
		i++;

	
	}
	public void setNPC() {
		int mapNum=0;
		int i = 0;
		gp.npc[i] = new NPC_Teacher(gp);
		gp.npc[i].worldX = gp.tileSize*21;
		gp.npc[i].worldY = gp.tileSize*21;
		i++;
		gp.npc[i] = new NPC_Teacher(gp);
		gp.npc[i].worldX = gp.tileSize*8;
		gp.npc[i].worldY = gp.tileSize*12;
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
