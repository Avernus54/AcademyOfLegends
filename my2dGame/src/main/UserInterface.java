package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
//MYYYY

public class UserInterface {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40 , arial_80b;
//	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	
	public UserInterface(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial",Font.PLAIN,40);
		arial_80b = new Font("Arial",Font.BOLD,60);
//		OBJ_key key = new OBJ_key();
//		keyImage =  key.image;
		
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
			
		}
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			
		}
		//DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			drawDialogueScreen();
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
