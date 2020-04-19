/**
 * 
 */
package data;

/**
 * @author students
 *
 */
public class Source {

	/**
	 * 
	 */
	private int idSource;
	private String descriptionSource;
	private double trustworthiness = 1;
	private double oldTrustworthiness = 1;
	
	public Source() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Source(int idSource) {
		super();
		this.idSource = idSource;
	}
	
	
	public Source(int idSource, String descriptionSource) {
		super();
		this.idSource = idSource;
		this.descriptionSource = descriptionSource;
	}


	public int getIdSource() {
		return idSource;
	}



	public void setIdSource(int idSource) {
		this.idSource = idSource;
	}



	public String getDescriptionSource() {
		return descriptionSource;
	}


	public void setDescriptionSource(String descriptionSource) {
		this.descriptionSource = descriptionSource;
	}


	public double getTrustworthiness() {
		return trustworthiness;
	}


	public void setTrustworthiness(double trustworthiness) {
		this.trustworthiness = trustworthiness;
	}


	public double getOldTrustworthiness() {
		return oldTrustworthiness;
	}


	public void setOldTrustworthiness(double oldTrustworthiness) {
		this.oldTrustworthiness = oldTrustworthiness;
	}


}
