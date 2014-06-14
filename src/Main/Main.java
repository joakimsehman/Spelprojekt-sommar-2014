package Main;

import com.jme3.system.AppSettings;

public class Main {
	
	public static void main(String[] args){
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1600, 900);
		settings.setTitle("MutateWars or something :D");
		// .. other settings?
		
		Game game = new Game();
		game.setSettings(settings);
		game.start();
	}
}
