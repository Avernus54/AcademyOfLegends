package Entity;



import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public final int ScreenX;
	public final int ScreenY;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		ScreenX = gp.screenWidth/2 - (gp.tileSize/2);
		ScreenY = gp.screenHeigth/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 12;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass() .getResourceAsStream("/player/up.gif"));
			up2 = ImageIO.read(getClass() .getResourceAsStream("/player/up.gif"));
			down1 = ImageIO.read(getClass() .getResourceAsStream("/player/down.gif"));
			down2 = ImageIO.read(getClass() .getResourceAsStream("/player/down.gif"));
			right1 = ImageIO.read(getClass() .getResourceAsStream("/player/right.gif"));
			right2 = ImageIO.read(getClass() .getResourceAsStream("/player/right.gif"));
			left1 = ImageIO.read(getClass() .getResourceAsStream("/player/left.gif"));
			left2 = ImageIO.read(getClass() .getResourceAsStream("/player/left.gif"));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
		
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
		
		//IF COLLISION IS FALSE, PLAYER CAN MOVE
		if(collisionOn == false) {
			switch(direction) {
			case "up": worldY -= speed;break;
			case "down":worldY+=speed;break;
			case "left":worldX-= speed;break;
			case "right":worldX += speed;break;
			}
		}
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
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.blue);
		
		//g2.fillRect( x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case"up":
			if(spriteNum == 1) {
				image =  up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			
			break;
		case"down":
			if(spriteNum == 1) {
				image =  down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case"left":
			if(spriteNum == 1) {
				image =  left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case"right":
			if(spriteNum == 1) {
				image =  right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, ScreenX, ScreenY, gp.tileSize,gp.tileSize, null);
	}
}
