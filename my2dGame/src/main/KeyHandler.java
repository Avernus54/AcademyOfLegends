package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
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
        	  playState(code);
            }
        
        //Pause State
        else if(gp.gameState == gp.pauseState) {
        	pauseState(code);
        }
        //Dialogue State
        else if(gp.gameState == gp.dialogueState) {
        	pauseState(code);
        }
        else if(gp.gameState == gp.characterState) {
        	characterState(code);
        }

    }

    
    
    public void playState(int code) {
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
        if (code == KeyEvent.VK_I) {
        	
        	gp.gameState = gp.characterState;
        }
      
        if (code == KeyEvent.VK_SPACE) {
        	enterPressed = true;
        }
        if (code == KeyEvent.VK_F) {
        	shotKeyPressed = true;
        }

            
    }
    public void pauseState(int code) {
    	if(code == KeyEvent.VK_P) {
    		gp.gameState = gp.playState;
    	}
    }
    public void dialogueState(int code) {
    	if (code == KeyEvent.VK_SPACE) {
    		gp.gameState = gp.playState;
    	}
    	}
    public void characterState(int code) {
    	if (code == KeyEvent.VK_I) {
    		gp.gameState = gp.playState;
    	}
    	if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
    		
    		if(gp.ui.slotRow != 0) {
    			gp.ui.slotRow--;
        		gp.playSE(9);
    		}
    	}
    	if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
    		if(gp.ui.slotCol != 0) {
    			gp.ui.slotCol--;
        		gp.playSE(9);
    		}
    	}
    	if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
    		if(gp.ui.slotRow != 4) {
    			gp.ui.slotRow++;
        		gp.playSE(9);
    		}
    	}
    	if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
    		if(gp.ui.slotCol != 4) {
    			gp.ui.slotCol++;
        		gp.playSE(9);
    		}
    		
    	}
    	if(code == KeyEvent.VK_ENTER) {
    		gp.player.selectedItem();
    	}
 }
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
        if (code == KeyEvent.VK_F) {
        	shotKeyPressed = false;
        }
    }
}
