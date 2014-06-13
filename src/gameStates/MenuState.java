package gameStates;

import Main.Game;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;

public class MenuState extends AbstractAppState{
	
	private SimpleApplication app;
	
	public void initialize(AppStateManager stateManager, Game game){
		super.initialize(stateManager, game);
		this.app = (SimpleApplication)game;
		
		
		//Now init stuff that is independent of wether state is PAUSED or RUNNING
		
	}
	
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		if(enabled){
			//init stuff that is in use while this state is RUNNING
		}
	}
	
	public void cleanup(){
		super.cleanup();
		// unregister all my listeners, detach all my nodes, etc...
	}
	
	public void update(float tpf){
		//do the following while the game is RUNNING
	}
}
