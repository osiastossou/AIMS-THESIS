/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algo.MajorityVote;
import algo.PartitionAttribute;
import data.Attribute;
import data.Observation;
import data.Source;
import data.Value;
import utils.FileAction;
import utils.Utils;

/**
 * @author students
 *
 */
public class MainCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        FileAction file = new FileAction();
        
        
        MajorityVote m = new MajorityVote();
        Set<Observation> data1 = file.getData("file.txt");
        
        Set<Value> value = m.vote(data1) ;
        
       // (idValue|descriptionValue|idObject|descriptionObject|idAttribue|descriptionAttrubute|idSource|descriptionSource)
        List<String> out_data = new ArrayList<>();
      String header = "idValue,descriptionValue,TruthProbabilityOfValue";
      out_data.add(header);
      System.out.println(header);
        for (Value line_value : value) {
        	String line = line_value.getIdValue()+","+
        			line_value.getDescriptionValue()+","
        			+line_value.getProbability();
        System.out.println(line);
        	out_data.add(line);
        	
        }
        
        
        for (Source source : m.getAccuracy()) {
        	String line = source.getIdSource()+","
        			+source.getTrustworthiness()+",";
        	System.out.println(line);
        }
        
        file.writeFile("value_probability.txt",out_data);
        
		/*
        for (Source source : m.getAccuracy()) {
        	String line = source.getIdSource()+","
        			+source.getTrustworthiness()+",";
        	System.out.println(line);
        }
        
        System.out.println(m.getAccuracyMax());
        System.out.println(m.getAccuracyAvg());
        System.out.println(m.getAccuracyApp());
        
        Set<Attribute> allAttribute = PartitionAttribute.getAllAttribute(data);
        System.out.println("Number of attribute = " + allAttribute.size());
        Set<Set<Attribute>> allPartitionsOfAttribute = Utils.getAllPartitionsOfSet(allAttribute);
        Set<PartitionAttribute.PartitionAttributeWeight> taux = PartitionAttribute.weightPartition(data,allPartitionsOfAttribute);
        
        for (Observation observation : data) {
        	System.out.println("Number of attribute = " + taux.size());
        }
        
        */
        
        
		
	}
	

}
