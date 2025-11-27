package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Object.OBJ_heart;
import Object.OBJ_key;
import Object.SuperObject;
//MYYYY

public class UserInterface {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40 , arial_80b;
	BufferedImage full_heart,half_heart,empty_heart;
	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	
	public UserInterface(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial",Font.PLAIN,30);
		arial_80b = new Font("Arial",Font.BOLD,30);
		OBJ_key key = new OBJ_key(gp);
		keyImage =  key.image;
		
		SuperObject heart = new OBJ_heart(gp);
		full_heart = heart.image3;
		half_heart = heart.image;
		empty_heart = heart.image2;
		
	}
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
	
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		//DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
	}
	public void drawPlayerLife() {
//		gp.player.life = 5;
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		//Draw blank heart
		while(i < gp.player.maxlife/2) {
			g2.drawImage(empty_heart,x,y,null);
			i++;
			x += gp.tileSize;
		}
		//Reset
		 x = gp.tileSize/2;
		 y = gp.tileSize/2;
		 i = 0;
		 //Draw Current life
		 while(i < gp.player.life) {
			 g2.drawImage(half_heart,x,y,null);
			 i++;
			 if(i < gp.player.life) {
				 g2.drawImage(full_heart,x,y,null);
			 }
			 i++;
			 x += gp.tileSize;
		 }
	}
	public void drawPauseScreen() {
		
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeigth/2;
		
		g2.drawString(text, x, y);
	}
	public void drawDialogueScreen() {
		//WINDOW
		int x = gp.tileSize *2;
		int y = gp.tileSize /2;
		int width = gp.screenWidth -(gp.tileSize*4);
		int height = gp.tileSize *3;
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString(currentDialogue, x, y);
	}
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0, 150);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+4, width-10, height-10, 25, 25);
		
	}
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
