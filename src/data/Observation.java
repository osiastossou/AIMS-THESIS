package data;

import java.util.HashSet;
import java.util.Set;

public class Observation {
	
	private int idObservation;
	private Source source;
	private Object oject;
	private Attribute attribute;
	private Value value;
	
	

	public Observation() {
		// TODO Auto-generated constructor stub
	}

	


	public Observation(int idObservation, Source source, Object oject, Attribute attribute,
			Value value) {
		super();
		this.idObservation = idObservation;
		this.source = source;
		this.oject = oject;
		this.attribute = attribute;
		this.value = value;
	}




	public int getIdObservation() {
		return idObservation;
	}



	public void setIdObservation(int idObservation) {
		this.idObservation = idObservation;
	}

	public Source getSource() {
		return source;
	}



	public void setSource(Source source) {
		this.source = source;
	}



	public Object getOject() {
		return oject;
	}



	public void setOject(Object oject) {
		this.oject = oject;
	}



	public Attribute getAttribute() {
		return attribute;
	}



	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}



	public Value getValue() {
		return value;
	}



	public void setValue(Value value) {
		this.value = value;
	}
	
	
	/*
	 * Find all the value given set of attribute.
	 */
	public static Set<Observation> findValueWithSetOfAttribute(Set<Observation> data,Set<Attribute> attributes) {
		 
		 Set<Observation> data_select = new HashSet<>();
		  for (Observation observation : data) {
		     if (attributes.contains(observation.getAttribute())) {
		    	 data_select.add(observation) ;
		     }
		 }
		 return data_select;
	}
	
	
	

}
