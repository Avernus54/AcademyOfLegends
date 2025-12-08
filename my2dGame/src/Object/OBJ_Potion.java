package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Potion extends Entity {

	int value = 5;
	
	public OBJ_Potion(GamePanel gp) {
		super(gp);
		
		type = type_consumable;
		name = "Potion";
		down1 = setup("/objects/potion_red",gp.tileSize,gp.tileSize);
		description = "[" + name +"] \nHeals your life by " + value + ".";
	
		
	}
	public void use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "you drink the " + name + "!\n"
				+ "your life has been recpvered by " + value + ".";
		entity.life += value;
		if(gp.player.life > gp.player.maxlife) {
			gp.player.life = gp.player.maxlife;
		}
		gp.playSE(2);
	}
}
