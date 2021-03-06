package gameStates;

import Main.Game;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class GameState extends AbstractAppState{

	private SimpleApplication app;
	private Spatial sceneModel;
	private boolean up, down, right, left;
	private Vector3f camLocation;
	private float camSpeed;
	
	public void initialize(AppStateManager stateManager, Application game){
		super.initialize(stateManager, game);
		this.app = (SimpleApplication)game;
		
		
		//Now init stuff that is independent of wether state is PAUSED or RUNNING
		camLocation = new Vector3f(0,60,0);
		camSpeed = 10.0f;
		//app.getFlyByCamera().setMoveSpeed(100);
		app.getFlyByCamera().setEnabled(false);
		app.getCamera().lookAtDirection(new Vector3f(0,-1,0), new Vector3f(0,60,0));
		app.getCamera().setLocation(camLocation);
		//app.getFlyByCamera().setDragToRotate(true);
		
		
		
		app.getInputManager().setCursorVisible(false);
		
		createTerrain();
		setUpLight();
		initKeys();
		
		up = false;
		down = false;
		right = false;
		left = false;
	}
	
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		if(enabled){
			//init stuff that is in use while this state is RUNNING
		}else{
			//take away everything not needed while this state is paused
		}
	}
	
	public void cleanup(){
		super.cleanup();
		// unregister all my listeners, detach all my nodes, etc...
	}
	
	public void update(float tpf){
		 System.out.println(app.getCamera().getDirection());
		
		if(up){
			camLocation.z = camLocation.getZ() + camSpeed*tpf;
		}
		if(down){
			camLocation.z = camLocation.getZ() - camSpeed*tpf;
		}
		if(left){
			camLocation.x = camLocation.getX() + camSpeed*tpf;
		}
		if(right){
			camLocation.x = camLocation.getX() - camSpeed*tpf;
		}
		app.getCamera().setLocation(camLocation);
	}
	
	
	private void createTerrain(){
		sceneModel = app.getAssetManager().loadModel("Scenes/town/main.scene");
		app.getRootNode().attachChild(sceneModel);
	}
	
	private void setUpLight() {
		// We add light so we see the scene
		AmbientLight al = new AmbientLight();
		al.setColor(ColorRGBA.White.mult(1.3f));
		app.getRootNode().addLight(al);

		DirectionalLight dl = new DirectionalLight();
		dl.setColor(ColorRGBA.White);
		dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
		app.getRootNode().addLight(dl);
	}
	
	private void initKeys(){
		app.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
		app.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
		app.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
		app.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
		
		app.getInputManager().addListener(actionListener, "Up", "Down", "Left", "Right");
	}
	
	
	private ActionListener actionListener = new ActionListener(){

		public void onAction(String name, boolean isPressed, float tpf) {
			if(name.equals("Up")){
				up = isPressed;
			}
			if(name.equals("Down")){
				down = isPressed;
			}
			if(name.equals("Left")){
				left = isPressed;
			}
			if(name.equals("Right")){
				right = isPressed;
			}
			
		}
		
	};
	
	
}
