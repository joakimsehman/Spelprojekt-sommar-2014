package Main;

import gameStates.GameState;
import gameStates.MenuState;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.jme3.app.SimpleApplication;

public class Game extends SimpleApplication{
	
	private GameState gameState;
	private MenuState menuState;
	
	
	public Game(){
		
	}
	
	public void simpleInitApp() {
		gameState = new GameState();
		getStateManager().attach(gameState);
		setDisplayStatView(true);
		
	}

	
	public void toggleToFullscreen(){
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode[] modes = device.getDisplayModes();
		int i = 0;
		settings.setResolution(modes[i].getWidth(), modes[i].getHeight());
		settings.setFrequency(modes[i].getRefreshRate());
		settings.setBitsPerPixel(modes[i].getBitDepth());
		settings.setFullscreen(device.isFullScreenSupported());
		this.setSettings(settings);
		this.restart();
	}
}
