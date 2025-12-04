package Entity;


import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_Teacher extends Entity {

	public NPC_Teacher(GamePanel gp){
		super(gp);
		
		direction = "down";
		speed = 1;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 14;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 29;
		solidArea.height = 29;
		
		getTeacherImage();
		setDialogue();
	}
	public void getTeacherImage() {
	
			up1 = setup("/npc/girlDown1",gp.tileSize,gp.tileSize);
			up2 = setup("/npc/girlDown2",gp.tileSize,gp.tileSize);
			down1 = setup("/npc/girlUp1",gp.tileSize,gp.tileSize);
			down2 = setup("/npc/girlUp2",gp.tileSize,gp.tileSize);
			right1 = setup("/npc/girlRight1",gp.tileSize,gp.tileSize);
			right2 = setup("/npc/girlRight2",gp.tileSize,gp.tileSize);
			left1 = setup("/npc/girlLeft1",gp.tileSize,gp.tileSize);
			left2 = setup("/npc/girlLeft2",gp.tileSize,gp.tileSize);
			
			
			
		
	
}
public void setDialogue() {
		dialogues[0] = "Hello, pre.";
		dialogues[1] = "Nagkaon naka?";
		dialogues[2] = "Kaon na";
		dialogues[3] = "or kan on tka";
		dialogues[4] = "joke";
		dialogues[5] = "kinan anay ta";
		
	}
	public void setAction() {
		
		actionLockCounter ++;
	
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1; // pick up a number from 1 to 100
			
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction ="left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			actionLockCounter = 0;
		}
		
	}
	public void speak() {
		if (dialogues[dialogueIndex] == null){
			dialogueIndex = 0;
			
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch(gp.player.direction) {
		case"up":
			direction = "down";
			break;
		case"down":
			direction = "up";
			break;
		case"left":
			direction = "right";
			break;
		case"right":
			direction = "left";
			break;
		}
	}
}
