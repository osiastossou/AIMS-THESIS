/**
 * 
 */
package data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author students
 *
 */
public class Value {

	/**
	 * 
	 */
	private int idValue;
	private String descriptionValue;
	private double trustProbability = 0;
	private double oldTrustProbability = 0;
	
	public Value() {
		
	}
	
	public Value(int idValue) {
		super();
		this.idValue = idValue;
	}
	
	public Value(int idValue, String descriptionValue) {
		super();
		this.idValue = idValue;
		this.descriptionValue = descriptionValue;
	}
	

	public int getIdValue() {
		return idValue;
	}


	public void setIdValue(int idValue) {
		this.idValue = idValue;
	}


	public String getDescriptionValue() {
		return descriptionValue;
	}


	public void setDescriptionValue(String descriptionValue) {
		this.descriptionValue = descriptionValue;
	}


	public double getProbability() {
		return trustProbability;
	}


	public void setTrustProbability(double trustProbability) {
		this.trustProbability = trustProbability;
	}


	public double getOldTrustProbability() {
		return oldTrustProbability;
	}


	public void setOldTrustProbability(double oldTrustProbability) {
		this.oldTrustProbability = oldTrustProbability;
	}

}
