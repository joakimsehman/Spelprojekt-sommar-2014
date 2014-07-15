package Main;

import com.jme3.system.AppSettings;

public class Main {
	
	public static void main(String[] args){
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1920,1080);
		settings.setTitle("MutateWars or something :D");
		
		// .. other settings?
		
		Game game = new Game();
		game.setShowSettings(false);
		game.setSettings(settings);
		game.start();
	}
}
