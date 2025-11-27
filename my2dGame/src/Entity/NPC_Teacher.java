package Entity;


import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_Teacher extends Entity {

	public NPC_Teacher(GamePanel gp){
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getTeacherImage();
		setDialogue();
	}
	public void getTeacherImage() {
		try {
			up1 = ImageIO.read(getClass() .getResourceAsStream("/player/up(1).png"));
			up2 = ImageIO.read(getClass() .getResourceAsStream("/player/up(2).png"));
			down1 = ImageIO.read(getClass() .getResourceAsStream("/player/down(1).png"));
			down2 = ImageIO.read(getClass() .getResourceAsStream("/player/down(2).png"));
			right1 = ImageIO.read(getClass() .getResourceAsStream("/player/left(1).png"));
			right2 = ImageIO.read(getClass() .getResourceAsStream("/player/left(2).png"));
			left1 = ImageIO.read(getClass() .getResourceAsStream("/player/right(2).png"));
			left2 = ImageIO.read(getClass() .getResourceAsStream("/player/right(1).png"));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
}
public void setDialogue() {
		dialogues[0] = "Hello, pre.";
		dialogues[1] = "Nagkaon naka?";
		dialogues[2] = "Kaon na";
		dialogues[3] = "or kan on tka";
		dialogues[4] = "joke";
		dialogues[5] = "kinan anay ta";
		dialogues[6] = "Hello, pre.";
		dialogues[7] = "Hello, pre.";
		dialogues[8] = "Hello, pre.";
		dialogues[9] = "Hello, pre.";
		dialogues[10] = "Hello, pre.";
		
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
