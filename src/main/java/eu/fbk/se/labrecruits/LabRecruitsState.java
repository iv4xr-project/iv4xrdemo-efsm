package eu.fbk.se.labrecruits;

/**
 * 
 * A state has an id. We need to specify if the state represent a door and, if so, record the name of the door.
 * 
 * @author Davide Prandi
 * 
 */

import de.upb.testify.efsm.*;

public class LabRecruitsState implements Comparable<LabRecruitsState>{

	private final String id;
	private final Boolean hasDoor;
	private final String doorId;
	
	
	public LabRecruitsState(String id) {
		this.id = id;
		this.hasDoor = false;
		this.doorId = "";
	}
	
	public LabRecruitsState(String id, String doorId) {
		this.id = id;
		this.hasDoor = true;
		this.doorId = doorId;
	}
	
	
	public String getId() {
		return id;
	} 

	public Boolean hasDoor() {
		return hasDoor;
	}
	
	public String getDoorId() {
		return doorId;
	}
	
	
	@Override
	public String toString() {
		if (hasDoor) {
			return id + "(with " + doorId + ")";
		}else {
			return id;
		}
		
	}

	/**
	 * To check if comparable is correctly implemented
	 */
	@Override
	public int compareTo(LabRecruitsState o) {
		if (getId().compareTo(o.getId()) == 0){
			return getDoorId().compareTo(o.getDoorId());
		}
		return getId().compareTo(o.getId()) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LabRecruitsState) {
			LabRecruitsState other = (LabRecruitsState)obj;
			return (compareTo(other) == 0);
		}else {
			return false;
		}
	}
	
}
