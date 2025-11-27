package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import Entity.Entity;
import Entity.Player;
import Object.SuperObject;
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
	
	//FPS
	int FPS = 60;
	
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
	public SuperObject obj[] = new SuperObject[10];
	public Entity npc [] =  new Entity[10];
	
	// GAME STATE
	public int gameState;
	public final int playState = 1;
	public  final int pauseState = 2;
	public final int dialogueState = 3;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		playMusic(0);
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
		}
		if (gameState == pauseState) {
			
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0;i < obj.length;i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		//NPC
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) {
				npc[i].draw(g2);
			}
		}
		
//		g2.setColor(Color.blue);
		
		player.draw(g2);
		
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
