package Entity;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Object.OBJ_Fireball;
import Object.OBJ_Shield;
import Object.OBJ_Sword_NORMAL;
import Object.OBJ_key;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity{

	KeyHandler keyH;
	
	public final int ScreenX;
	public final int ScreenY;	
	public boolean attackCancel = false;
	int standCounter = 0;
	public ArrayList<Entity> inventory = new ArrayList<>();
	public final int maxInventorySize = 20;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.keyH = keyH;
		
		ScreenX = gp.screenWidth/2 - (gp.tileSize/2);
		ScreenY = gp.screenHeigth/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 14;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
//		attackArea.width = 36;
//		attackArea.height = 36;
		
		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
		
	}
	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;

		
		speed = 4;
		direction = "down";
		
		//player status
		level = 1;
		maxlife = 6;
		life = maxlife;
		strength = 1;
		dexterity = 1;
		exp = 0;
		nextLevelExp = 5;
		coin = 0;
		currentWeapon = new OBJ_Sword_NORMAL(gp);
		currentShield = new OBJ_Shield(gp);
		attack = getAttack();
		defense = getDefense();
		projectile = new OBJ_Fireball(gp);
	}
	public void setItems() {
		inventory.add(currentWeapon);
		inventory.add(currentShield);
		inventory.add(new OBJ_key(gp));
		inventory.add(new OBJ_key(gp));
	}
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return attack = strength * currentWeapon.attackValue;
	}
	public int getDefense() {
		return defense = dexterity * currentShield.defenseValue;
		
	}
	
	public void getPlayerImage() {
		
			up1 = setup("/player/playerUp1",gp.tileSize,gp.tileSize);
			up2 = setup("/player/playerUp2",gp.tileSize,gp.tileSize);
			down1 = setup("/player/playerDown1",gp.tileSize,gp.tileSize);
			down2 = setup("/player/playerDown2",gp.tileSize,gp.tileSize);
			right1 = setup("/player/playerRight1",gp.tileSize,gp.tileSize);
			right2 = setup("/player/playerRight2",gp.tileSize,gp.tileSize);
			left1 = setup("/player/playerLeft1",gp.tileSize,gp.tileSize);
			left2 = setup("/player/playerLeft2",gp.tileSize,gp.tileSize);
			
			
			
		
		
	}
	public void getPlayerAttackImage() {
		
			
			if(currentWeapon.type == type_sword) {
				attackup1 = setup("/player/attackUp1",gp.tileSize,gp.tileSize*2);
				attackUp2 = setup("/player/attackUp2",gp.tileSize,gp.tileSize*2);
				attackDown1 = setup("/player/attackDown1",gp.tileSize,gp.tileSize*2);
				attackDown2 = setup("/player/attackDown2",gp.tileSize,gp.tileSize*2);
				attackRight1 = setup("/player/attackRight1",gp.tileSize*2,gp.tileSize);
				attackRight2 = setup("/player/attackRight2",gp.tileSize*2,gp.tileSize);
				attackLeft1 = setup("/player/attackLeft1",gp.tileSize*2,gp.tileSize);
				attackLeft2 = setup("/player/attackLeft2",gp.tileSize*2,gp.tileSize);
			}

			if(currentWeapon.type == type_axe) {
				attackup1 = setup("/player/attackUp1",gp.tileSize,gp.tileSize*2);
				attackUp2 = setup("/player/attackUp2",gp.tileSize,gp.tileSize*2);
				attackDown1 = setup("/player/attackDown1",gp.tileSize,gp.tileSize*2);
				attackDown2 = setup("/player/attackDown2",gp.tileSize,gp.tileSize*2);
				attackRight1 = setup("/player/attackRight1",gp.tileSize*2,gp.tileSize);
				attackRight2 = setup("/player/attackRight2",gp.tileSize*2,gp.tileSize);
				attackLeft1 = setup("/player/attackLeft1",gp.tileSize*2,gp.tileSize);
				attackLeft2 = setup("/player/attackLeft2",gp.tileSize*2,gp.tileSize);
			}
			
	
	}
	public void update() {
		if(attacking) {
			attacking();
		}
		
		else if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) {
		
		if(keyH.upPressed == true ) {
			direction = "up";					
		}else if(keyH.downPressed == true){
			direction = "down";			
		}else if(keyH.leftPressed == true) {
			direction = "left";			
		}else if(keyH.rightPressed == true) {
			direction = "right";						
		}
		
		// CHECK TILE COLLISION
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		//check object collision
		int objIndex = gp.cChecker.checkedObject(this, true);
		pickUpObject(objIndex);
		//CHECK NPC COLLISION
		int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		interactNPC(npcIndex);
		
		//check monster collision
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		contactMonster(monsterIndex);
		//Check Event
		gp.eHandler.checkEvent();
		
		//IF COLLISION IS FALSE, PLAYER CAN MOVE
		if(collisionOn == false && keyH.enterPressed == false ) {
			switch(direction) {
			case "up": worldY -= speed;break;
			case "down":worldY+=speed;break;
			case "left":worldX-= speed;break;
			case "right":worldX += speed;break;
			}
		}
		if(keyH.enterPressed == true && attackCancel == false) {
			gp.playSE(7);
			attacking = true;
			spriteCounter = 0;
			
		}
		
		attackCancel = false;
		gp.keyH.enterPressed = false;
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if (spriteNum == 1) {
				spriteNum =2;
			}
			else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
		if (gp.keyH.shotKeyPressed == true && projectile.alive == false) {
			
			projectile.set(worldX, worldY, direction ,true, this);
			
			gp.projectileList.add(projectile);
			
			gp.playSE(10);
			
		}
		// kailangan gawas jud nis if statement
		if(invisible == true) {
			invisibleCounter++;
			if(invisibleCounter > 60) {
				invisible = false;
				invisibleCounter = 0;
			}
		}
	}
	public void attacking() {
		
		spriteCounter++;
		
		if(spriteCounter <=5) {
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
			
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			
			
		switch(direction) {
		case "up": worldY -= attackArea.height;break;
		case "down": worldY += attackArea.height;break;
		case "left": worldX -= attackArea.width;break;
		case "right": worldX += attackArea.width;break;
		}
		//attacking becomes solidArea
		solidArea.width = attackArea.width;
		solidArea.height = attackArea.height;
		//check monster
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		damageMonster(monsterIndex);
		
		worldX = currentWorldX;
		worldY = currentWorldY;
		solidArea.width = solidAreaWidth;
		solidArea.height = solidAreaHeight;
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
		
	}
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String text;
			if (inventory.size() != maxInventorySize) {
				
				inventory.add(gp.obj[i]);
				gp.playSE(i);
				text = "Got a " + gp.obj[i].name + "!";
			}
			else {
				text = "you cannot carry any More!";
			}
			gp.ui.addMessage(text);
			gp.obj[i]=null;
		}
	}
	
	public void interactNPC (int i) {
	if (gp.keyH.enterPressed == true) {
		if(i != 999) {
			
			attackCancel = false;
			gp.gameState = gp.dialogueState;
			gp.npc[i].speak();
			}
	
		}
	int npcIndex = gp.cChecker.checkEntity(gp.player, gp.npc);

	if (npcIndex != 999) {
	    gp.currentNPC = npcIndex;
	    gp.gameState = gp.dialogueState;
	    gp.npc[npcIndex].speak();
	}

	}
		
		

	public void contactMonster(int i) {
		if(i != 999) {
			if(invisible == false && gp.monster[i].dying == false) {
				//gp.playSE(6);
				
					int damage = attack - gp.monster[i].attack - defense;
					if (damage < 0) {
						damage = 0;
					}
				life -=damage;
				invisible = true;
			}
			
		}
	}
	public void damageMonster(int i) {
		if (i != 999) {
			if (gp.monster[i].invisible == false) {
				int damage = attack - gp.monster[i].defense;
				if (damage < 0) {
					damage = 0;
				}
				
				
				gp.playSE(5);
				gp.monster[i].life -= damage;
				gp.ui.addMessage(damage + " damage");
				gp.monster[i].invisible= true;
				gp.monster[i].damageReaction();
				
				if (gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
					gp.ui.addMessage("killed the " + gp.monster[i].name + "!");
					gp.ui.addMessage("You Receive " + gp.monster[i].exp +" EXP!");
					exp += gp.monster[i].exp;
					checkLevelUp();
				}
				
			}
	}
	}
	public void checkLevelUp() {
		if(exp >= nextLevelExp) {
			
			level++;
			nextLevelExp = nextLevelExp*2;
			maxlife += 2;
			strength++;
			dexterity++;
			attack = getAttack();
			defense = getDefense();
			
			gp.playSE(3);
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "you are level" + level + "now!\n" + "you feel Stronger!";
		}
	}
	public void selectedItem() {
		
		int itemIndex = gp.ui.getItemIndexOnSlot();
		
		if (itemIndex < inventory.size()) {
			Entity selectedItem = inventory.get(itemIndex);
			
			if(selectedItem.type == type_sword || selectedItem.type == type_axe) {
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			if(selectedItem.type == type_shield) {
				currentShield = selectedItem;
				defense = getDefense();
			}
			if(selectedItem.type == type_consumable) {
				selectedItem.use(this);
				inventory.remove(itemIndex);
				
			}
		}
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.blue);
		
		//g2.fillRect( x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case"up":
			if (attacking == false) {
			if(spriteNum == 1) {image =  up1;}
			if(spriteNum == 2) {image = up2;}
			}
			if (attacking == true) {
				if(spriteNum == 1) {image =  attackup1;}
				if(spriteNum == 2) {image = attackUp2;}
				}
			break;
		case"down":
			if (attacking == false) {
			if(spriteNum == 1) {image =  down1;}
			if(spriteNum == 2) {image = down2;}
			}
			if (attacking == true) {
				if(spriteNum == 1) {image =  attackDown1;}
				if(spriteNum == 2) {image = attackDown2;}
				}
			break;
		case"left":
			if (attacking == false) {
			if(spriteNum == 1) {image =  left1;}
			if(spriteNum == 2) {image = left2;}
			}
			if (attacking == true) {
				if(spriteNum == 1) {image =  attackLeft1;}
				if(spriteNum == 2) {image = attackLeft2;}
				}
			break;
		case"right":
			if (attacking == false) {
			if(spriteNum == 1) {image =  right1;}
			if(spriteNum == 2) {image = right2;}
			}
			if (attacking == true) {
				if(spriteNum == 1) {image =  attackRight1;}
				if(spriteNum == 2) {image = attackRight2;}
				}
			break;
		}
		if(invisible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
		}
		g2.drawImage(image, ScreenX, ScreenY,gp.tileSize,gp.tileSize, null);
		//reset
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		
		
	}

	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
			BufferedImage image = null;
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream( imagePath + ".png"));
				image = uTool.scaleImage(image, width, height);
			
			
	}catch(IOException e) {
		e.printStackTrace();
	}
			return image;
}
	}

	
