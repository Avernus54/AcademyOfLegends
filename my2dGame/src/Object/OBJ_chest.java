package Object;

import java.io.IOException;

import javax.imageio.ImageIO;
//myyy
public class OBJ_chest extends SuperObject{
	
	public OBJ_chest() {
		name = "chest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/treasureChest.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
