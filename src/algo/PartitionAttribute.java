package algo;

import java.util.HashSet;
import java.util.Set;

import data.Attribute;
import data.Observation;
import data.Value;

public class PartitionAttribute {
	
	/*
	 * Partion function
	 */
	static <T> Set<Set<T>> powerSet(Set<T> set) {
        T[] element = (T[]) set.toArray();
        final int SET_LENGTH = 1 << element.length;
        Set<Set<T>> powerSet = new HashSet<>();
        for( int binarySet = 0; binarySet < SET_LENGTH; binarySet++ ) {
            Set<T> subset = new HashSet<>();
            for( int bit = 0; bit < element.length; bit++ ) {
                int mask = 1 << bit;
                if( (binarySet & mask) != 0 ) {
                    subset.add( element[bit] );
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
	
	/*
	 * Get All Attribute from data
	 */
	public static Set<Attribute> getAllAttribute(Set<Observation> data) {
		Set<Attribute> allAttribute = new HashSet<>();
		for (Observation observation : data) {
			allAttribute.add(observation.getAttribute()) ;
		     
		 }
		return allAttribute;
	}
	
	public static Set<PartitionAttributeWeight> weightPartition(Set<Observation> data,Set<Set<Attribute>> allPartition) {
		Set<PartitionAttributeWeight> pAW = new HashSet<>();
		
		for (Set<Attribute> partition : allPartition) {
			Set<Observation> data_partion = Observation.findValueWithSetOfAttribute(data,partition) ;
			/* Cal function F*/
			MajorityVote m = new MajorityVote();
			m.vote(data_partion) ;
			
			PartitionAttributeWeight p = new PartitionAttributeWeight();
			p.setPartition(partition);
			p.setWeight(m.getAccuracyMax());
			pAW.add(p);
	        //m.getAccuracyAvg();
		}
		
		return pAW ;
	}
	
	
	public static class PartitionAttributeWeight {
		Set<Attribute> partition = new HashSet<>() ;
		double weight = 0 ;
		
		public PartitionAttributeWeight(){
		}

		public Set<Attribute> getPartition() {
			return partition;
		}

		public void setPartition(Set<Attribute> partition) {
			this.partition = partition;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		
	}
	
}
