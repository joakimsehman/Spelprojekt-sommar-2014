package Entities;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public abstract class Character extends Entity{

	public Character(Vector3f location, Vector3f scale, Vector3f rotation, Spatial spatial) {
		super(location, scale, rotation, spatial);
	}

	
	
}
