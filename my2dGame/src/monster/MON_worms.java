package monster;

import java.util.Random;

import Entity.Entity;
import main.GamePanel;

public class MON_worms extends Entity{
	public MON_worms(GamePanel gp) {
		super(gp);
		type = 2;
		name = "Green Worms";
		speed = 1;
		maxlife = 10;
		life = maxlife;
		attack = 5;
		defense = 0;
		exp = 2;
		
		solidArea.x = 3;
		solidArea.y = 10;
		solidArea.width = 29;
		solidArea.height = 25;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		up1 = setup("/monster/wormUp", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/wormUp2",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/wormDownt",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/wormDownt2",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/mutantworm",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/mutantwormUP",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/wormRight2",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/wormRight",gp.tileSize,gp.tileSize);
		
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
	public void damageReaction() {
		actionLockCounter = 0;
		direction = gp.player.direction;
	}

}
