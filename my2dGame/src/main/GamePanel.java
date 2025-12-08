package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import Entity.Entity;
import Entity.Player;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int originalTitleSize = 16;
	final int scale = 3;
	public final int tileSize = originalTitleSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeigth = tileSize * maxScreenRow;
	
	
	//WWORLD SETTINGS
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
//	public final int maxMap = 10;
//	public int currentMap = 0;
	
	//FPS
	int FPS = 60;
	// answer dialogue
	public String answer1 = "";
	public String answer2 = "";
	public int choiceIndex = 0;   // Which answer is highlighted
	public int maxChoices = 0;
	public int currentNPC = -1;
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sounds soundeffects = new Sounds();
	Sounds Music = new Sounds();
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetCenter aSetter = new AssetCenter(this);
	public UserInterface ui = new UserInterface(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;
	
	//ang entity og ang object
	public Player player = new Player(this,keyH);
	public Entity obj[] = new Entity[10];
	public Entity npc[] =  new Entity[10];
	public Entity monster[] =  new Entity[20];
	public ArrayList<Entity> entityList = new ArrayList<>();
	public ArrayList<Entity> projectileList = new ArrayList<>();
	// GAME STATE
	public int gameState;
	public final int playState = 0;	
	public  final int pauseState = 1;
	public final int dialogueState = 2;
	public final int characterState = 3;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
//		playMusic(0);
		gameState = playState;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();;
	}
	@Override
	public void run() {
		
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			 
			 
			 
			 
			 update();
			 
			 
			 repaint();
			 
			 
			 
			 try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		
		if (gameState == playState) {
			player.update();
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					if(monster[i].alive == true && monster[i].dying == false) {
					monster[i].update();
					}
					if(monster[i].alive == false) {
						monster[i] = null;
						}
				
				}
			}
			for(int i = 0; i < projectileList.size(); i++) {
				if(projectileList.get(i) != null) {
					if(projectileList.get(i).alive == true) {
						projectileList.get(i).update();
					}
					if(projectileList.get(i).alive == false) {
						projectileList.remove(i);
						}
				
				}
			}
		}
		
		if (gameState == pauseState) {
			
		}

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		entityList.add(player);
		for(int i = 0; i < npc.length;i++) {
			if(npc[i] != null) {
				entityList.add(npc[i]);
			}
		}
		for(int i = 0; i < obj.length;i++) {
			if(obj[i] != null) {
				entityList.add(obj[i]);
			}
		}
		
		for(int i = 0; i < monster.length;i++) {
			if(monster[i] != null) {
				entityList.add(monster[i]);
			}
		}
		for(int i = 0; i < projectileList.size();i++) {
			if(projectileList.get(i) != null) {
				entityList.add(projectileList.get(i));
			}
		}
		
		Collections.sort(entityList, new Comparator<Entity>() {

			@Override
			public int compare(Entity e1, Entity e2) {
				// TODO Auto-generated method stub
				int result = Integer.compare(e1.worldY, e2.worldY);
				return result;
			}
			
		});
		
		for(int i = 0; i < entityList.size();i++) {
			entityList.get(i).draw(g2);
		}
		entityList.clear();
		
		
//		g2.setColor(Color.blue);
		
		//player.draw(g2);
		
		ui.draw(g2);
		
		g2.dispose();
	}
	
	public void playMusic(int i) {
		
		Music.setFile(i);
		Music.play();
		Music.loop();

	}
	public void stopMusic() {
		Music.stop();
	}
	public void playSE(int i) {
		soundeffects.setFile(i);
		soundeffects.play();
	}
	
}
