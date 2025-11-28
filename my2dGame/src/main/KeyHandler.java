package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    GamePanel gp;

    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        
       //Play State
        if(gp.gameState == gp.playState) {
        	  // W or UP ARROW
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upPressed = true;
            }

            // S or DOWN ARROW
            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }

            // A or LEFT ARROW
            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

            // D or RIGHT ARROW
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
            	
            	gp.gameState = gp.pauseState;

            }
            if (code == KeyEvent.VK_ENTER) {
            	enterPressed = true;
            }

                else if (gp.gameState == gp.pauseState) {
                	gp.gameState = gp.pauseState;
                }
            }
        
        //Pause State
        if(gp.gameState == gp.pauseState) {
        	
        }
        //Dialogue State
        else if(gp.gameState == gp.dialogueState) {
        	if(code == KeyEvent.VK_ENTER) {
        		gp.gameState = gp.playState;
        }
        }
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // W or UP ARROW
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }

        // S or DOWN ARROW
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        // A or LEFT ARROW
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        // D or RIGHT ARROW
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}
