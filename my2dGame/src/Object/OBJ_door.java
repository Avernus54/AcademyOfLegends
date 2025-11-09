package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_door extends SuperObject {
	
	public OBJ_door() {
		name = "door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/dorr.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
