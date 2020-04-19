/**
 * 
 */
package data;

/**
 * @author students
 *
 */
public class Attribute {

	/**
	 * 
	 */
	private int idAttribute;
	private String descriptionAttribute;
	
	public Attribute() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Attribute(int idAttribute) {
		super();
		this.idAttribute = idAttribute;
	}
	
	
	public Attribute(int idAttribute, String descriptionAttribute) {
		super();
		this.idAttribute = idAttribute;
		this.descriptionAttribute = descriptionAttribute;
	}


	public int getIdAttribute() {
		return idAttribute;
	}


	public void setIdAttribute(int idAttribute) {
		this.idAttribute = idAttribute;
	}



	public String getDescriptionAttribute() {
		return descriptionAttribute;
	}



	public void setDescriptionAttribute(String descriptionAttribute) {
		this.descriptionAttribute = descriptionAttribute;
	}

}
