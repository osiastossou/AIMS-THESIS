/**
 * 
 */
package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.Observation;
import data.Source;
import data.Value;
import data.Observation;
import utils.FileAction;

/**
 * @author students
 *
 */
public class MajorityVote {

	/**
	 * 
	 */
	private Set<Source> accuracy = new HashSet<>(); 
	private double accuracyMax = 0 ;
	private double accuracyAvg = 0 ;
	private double accuracyApp = 0 ;
	
	
	
	public Set<Source> getAccuracy() {
		
		return accuracy;
	}

	public void setAccuracy(Set<Source> accuracy) {
		this.accuracy = accuracy;
	}

	public double getAccuracyMax() {
		return accuracyMax;
	}

	public void setAccuracyMax(double accuracyMax) {
		this.accuracyMax = accuracyMax;
	}

	public double getAccuracyAvg() {
		return accuracyAvg;
	}

	public void setAccuracyAvg(double accuracyAvg) {
		this.accuracyAvg = accuracyAvg;
	}

	public double getAccuracyApp() {
		return accuracyApp;
	}

	public void setAccuracyApp(double accuracyApp) {
		this.accuracyApp = accuracyApp;
	}

	public MajorityVote() {
		// TODO Auto-generated constructor stub
		FileAction file = new FileAction();
        
		Set<Observation> data = file.getData("file.txt");
		
		
	}
	
	public Set<Value> vote(Set<Observation> data){
		
		Set<Observation> data_out = new HashSet<>();
		double accuracyMax = 0 ;
		double accuracyAvg = 0 ;
		
		Set<Value> all_value = findAllValue(data) ;
		
		for (Value value : all_value) {
			
			// Compute probability of v
			Set<Source> sourcesValue = findSetOfSourceGivenValue(data,value.getDescriptionValue()) ; // ??
			double probability = 0 ;
			for (Source source : sourcesValue) {
				Set<Value> valueMadeBySource = findValueWithIdSource(data,source.getIdSource());
				probability = probability + source.getTrustworthiness()/valueMadeBySource.size(); 
			}
			value.setOldTrustProbability(value.getProbability()); // Set the old 
			value.setTrustProbability(Math.sqrt(probability));
			
			// Mise à jours des probabilité des values data (mettre apres dans l	 classe observation
			for (Observation line_data : data) {
				if (value.getIdValue()==line_data.getValue().getIdValue()) {
					line_data.getValue().setTrustProbability(value.getProbability());
				}
			}
			
		
			// Compute Ws
			for (Source source : sourcesValue) {
				double weigth_source = 0 ;
				Set<Value> valueMadeBySource = findValueWithIdSource(data,source.getIdSource());
				for (Value line_value : valueMadeBySource) {
					Set<Source> sourcesMadeThisValue = findSetOfSourceGivenValue(data,line_value.getDescriptionValue()) ;
					// ....
					double autre = 0 ;
					for (Source line_source : sourcesMadeThisValue) {
						double nberOfValueBySourcevalueMadeBySource = findValueWithIdSource(data,line_source.getIdSource()).size();
						autre = autre + (line_source.getTrustworthiness()/nberOfValueBySourcevalueMadeBySource);
					}
					weigth_source = weigth_source + line_value.getProbability()
					*(source.getTrustworthiness()/valueMadeBySource.size())/autre;
					//System.out.println(autre);
				}
				
				source.setOldTrustworthiness(source.getTrustworthiness());
				source.setTrustworthiness(weigth_source);
				
				// Mise à jours des probabilité des source data (mettre apres dans la classe observation
				for (Observation line_data : data) {
					if (source.getIdSource()==line_data.getSource().getIdSource()) {
						line_data.getSource().setTrustworthiness(source.getTrustworthiness());
					}
				}
			}
			
		 }
		
		Set<Source> all_source = findAllSources(data);
		this.setAccuracy(all_source);
		
		/*for (Source source : this.accuracy) {
			accuracyAvg = accuracyAvg + source.getTrustworthiness();
		}
		
		
		this.accuracyMax = accuracyMax;
		this.accuracyAvg = accuracyAvg/this.accuracy.size();*/
		
		return all_value;
		
	}
	
	
	public double score(Set<Observation> data,String type){
		/*
		 * max
		 * avg
		 * app *after*
		 * oracle
		 */
		
		Set<Value> vote = this.vote(data);
		double out = 0 ;
		/*if(type == "max") {
			
			for (Observation observation : vote) {
				if(out < observation.getSource().getTrustworthiness()) {
					out = observation.getSource().getTrustworthiness();
				}
				out = out + observation.getSource().getTrustworthiness();
			}
		}else {
			for (Observation observation : vote) {
				
			}
		}*/
		
		return out;
	}
	
	/*
	 * Find all the observation given one attribute id.
	 */
	public static Set<Observation> findObservationWithIdAttribute(Set<Observation> data,int id) {
		 
		 Set<Observation> data_select = new HashSet<>();
		  for (Observation observation : data) {
		     if (observation.getAttribute().getIdAttribute()==id) {
		    	 data_select.add(observation) ;
		     }
		 }
		 return data_select;
	}
	
	/*
	 * Find all set of source given a value. S_v
	 */
	public static Set<Source> findSetOfSourceGivenValue(Set<Observation> data,String observation){
		
		Set<Source> source = new HashSet<>();
		  for (Observation observation_line : data) {
		     if (observation_line.getValue().getDescriptionValue()==observation) {
		    	 source.add(observation_line.getSource()) ;
		    	 
		     }
		 }
		
		return source;
		
	}
	
	/*
	 * Find all value on observation
	 */
	public static Set<Value> findAllValue(Set<Observation> data) {
		 
		 Set<Value> data_select = new HashSet<>();
		  for (Observation observation : data) {
		    	 data_select.add(observation.getValue()) ;
		 }
		 return data_select;
	}
	
	/*
	 * Find all source on observation
	 */
	public static Set<Source> findAllSources(Set<Observation> data) {
		 
		 Set<Source> data_select = new HashSet<>();
		  for (Observation observation : data) {
		    	 data_select.add(observation.getSource()) ;
		 }
		 return data_select;
	}
	
	
	
	/*
	 * Find all observation given one source id. V_s
	 */
	public static Set<Value> findValueWithIdSource(Set<Observation> data,int id) {
		 
		 Set<Value> data_select = new HashSet<>();
		  for (Observation observation : data) {
		     if (observation.getSource().getIdSource()==id) {
		    	 data_select.add(observation.getValue()) ;
		     }
		 }
		 return data_select;
	}
	
	

}
