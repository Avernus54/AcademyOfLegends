package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Object.OBJ_heart;
import Object.OBJ_key;
import Entity.Entity;
//MYYYY

public class UserInterface {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40 , arial_80b;
	BufferedImage full_heart,half_heart,empty_heart;
	BufferedImage keyImage;
	public boolean messageOn = false;
//	public String message = "";
//	int messageCounter = 0;
	ArrayList<String> message = new ArrayList<>();
	ArrayList<Integer> messageCounter = new ArrayList<>();
	public int slotCol = 0;
	public int slotRow = 0;
	
	public int choiceIndex = 0;     // current selected choice
	public String[] choices;        // choices displayed for the current NPC
	public int maxChoices = 0;      // number of choices available

	public boolean gameFinished = false;
	public String currentDialogue = "";
	
	public UserInterface(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial",Font.PLAIN,30);
		arial_80b = new Font("Arial",Font.BOLD,30);
		OBJ_key key = new OBJ_key(gp);
		keyImage =  key.image;
		
		Entity heart = new OBJ_heart(gp);
		full_heart = heart.image3;
		half_heart = heart.image;
		empty_heart = heart.image2;
		
	}
	public void addMessage(String text) {
		
	message.add(text);
	messageCounter.add(0);
		
	}
	
	public void draw(Graphics2D g2) {
	
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
			drawMessage();
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
		//characte state
		if(gp.gameState == gp.characterState) {
			
			drawCharacterScreen();
			drawInventory();
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
	public void drawMessage() {
		int messageX = gp.tileSize;
		int messageY = gp.tileSize *4;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 26f));
		
		for(int i = 0; i < message.size(); i++) {
			if (message.get(i) != null) {
				
				g2.setColor(Color.black);
				g2.drawString(message.get(i), messageX+2, messageY+2);
				g2.setColor(Color.white);
				g2.drawString(message.get(i), messageX, messageY);
				
				int counter = messageCounter.get(i) + 1;
				messageCounter.set(i,counter);
				messageY +=50;
				
				if (messageCounter.get(i) > 100) {
					message.remove(i);
					messageCounter.remove(i);
				}
			}
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
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize *3;
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
	

	    
	}
	public void drawCharacterScreen() {
		

		final int frameX = gp.tileSize;
		final int frameY= gp.tileSize;
		final int frameWidth = gp.tileSize * 5;
		final int frameHeight = gp.tileSize *10;
		drawSubWindow(frameX,frameY,frameWidth,frameHeight);
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(30F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 36;
		
		
		g2.drawString("Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Life", textX, textY);
		textY += lineHeight;
		g2.drawString("Strength", textX, textY);
		textY += lineHeight;
		g2.drawString("Dexterity", textX, textY);
		textY += lineHeight;
		g2.drawString("Attack", textX, textY);
		textY += lineHeight;
		g2.drawString("Defense", textX, textY);
		textY += lineHeight;
		g2.drawString("Exp", textX, textY);
		textY += lineHeight;
		g2.drawString("Next Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Coin", textX, textY);
		textY += lineHeight + 20;
		g2.drawString("Weapon", textX, textY);
		textY += lineHeight + 15;
		g2.drawString("Shield", textX, textY);
		textY += lineHeight;
		
		//values
		int tailX = (frameX + frameWidth) - 30;
		//reset textY
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.life +"/" + gp.player.maxlife);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.strength);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.dexterity);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.attack);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.defense);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.exp);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		value = String.valueOf(gp.player.coin);
		textX = getXforAlignRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		g2.drawImage(gp.player.currentWeapon.down1,tailX - gp.tileSize, textY- 14, null);
		textY += gp.tileSize;
		g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY- 14, null);
		
		
	}
	public void drawInventory() {
		//frame
		int frameX = gp.tileSize*9;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize*6;
		int frameHeight = gp.tileSize*5;
		drawSubWindow(frameX,frameY,frameWidth,frameHeight);
		
		//slot
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = gp.tileSize+3;
		
		//draw player items
		for(int i = 0; i < gp.player.inventory.size(); i++) {
			
			
			
			//equip cursor
			if(gp.player.inventory.get(i) == gp.player.currentWeapon || 
					gp.player.inventory.get(i) == gp.player.currentShield) {
				g2.setColor(new Color(240,190,90));
				g2.fillRoundRect(slotX, slotY, gp.tileSize,gp.tileSize,10,10 );
				
			}
			
			
			g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY,null);
			
			
			
			slotX += slotSize;
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY += slotSize;
			}
		}
		//cursor
		int cursorX = slotXstart + (slotSize * slotCol);
		int cursorY = slotYstart + (slotSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		//drawcursor
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10 ,10);
		
		//description item 
		int dFrameX = frameX;
		int dFrameY = frameY + frameHeight;
		int dFrameWidth = frameWidth ;
		int dFrameHeight = gp.tileSize*3;
		
		//Draw desc text
		int textX = dFrameX + 20;
		int textY = dFrameY + gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(28f));
		
		int itemIndex = getItemIndexOnSlot();
		
		if(itemIndex < gp.player.inventory.size()) {
			
			drawSubWindow(dFrameX, dFrameY,dFrameWidth,dFrameHeight);
			
			for(String line: gp.player.inventory.get(itemIndex).description.split("\n")) {
				g2.drawString(line,textX, textY);
				textY += 32;
			
			
			}
			
		}
		
				
	}
	public int getItemIndexOnSlot() {
		int itemIndex = slotCol + (slotRow*5);
		return itemIndex;
	}
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0, 210);
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
	public int getXforAlignRightText(String text, int tailX) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - length;
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
