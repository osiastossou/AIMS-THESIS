/**
 * 
 */
package data;

import java.util.Set;

/**
 * @author students
 *
 */
public class Object {

	/**
	 * 
	 */
	private int idObject;
	private String descriptionObject;
	private Set<Attribute> attributes;
	
	public Object() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Object(int idObject) {
		super();
		this.idObject = idObject;
	}
	
	
	public Object(int idObject, String descriptionObject) {
		super();
		this.idObject = idObject;
		this.descriptionObject = descriptionObject;
	}
	
	public Object(int idObject, Set<Attribute> attributes) {
		super();
		this.idObject = idObject;
		this.attributes = attributes;
	}

	public Object(int idObject, String descriptionObject, Set<Attribute> attributes) {
		super();
		this.idObject = idObject;
		this.descriptionObject = descriptionObject;
		this.attributes = attributes;
	}


	public int getIdObject() {
		return idObject;
	}



	public void setIdObject(int idObject) {
		this.idObject = idObject;
	}



	public String getDescriptionObject() {
		return descriptionObject;
	}



	public void setDescriptionObject(String descriptionObject) {
		this.descriptionObject = descriptionObject;
	}


	public Set<Attribute> getAttributes() {
		return attributes;
	}


	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

}
