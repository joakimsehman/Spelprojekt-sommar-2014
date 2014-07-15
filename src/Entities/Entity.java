package Entities;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public abstract class Entity {

	private Vector3f location;
	private Spatial spatial;
	
	public Entity(Vector3f location, Vector3f scale, Vector3f rotation, Spatial spatial){
		this.location = new Vector3f(location);
		spatial.scale(scale.getX(), scale.getY(), scale.getZ());
		spatial.rotate(rotation.getX(), rotation.getY(), rotation.getZ());
		//spatial.setLocalTranslation(location);
		
		this.spatial = spatial;
	}

	
	public Spatial getSpatial(){
		return spatial;
	}
}
