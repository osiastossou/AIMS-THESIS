/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.Attribute;

/**
 * @author students
 *
 */
public class Utils  {
	
	public static <T> Set<Set<T>> getAllPartitionsOfSet(Set<T> set) {
        T[] element = (T[]) set.toArray();
        final int SET_LENGTH = 1 << element.length;
        Set<Set<T>> powerSet = new HashSet<>();
        for( int binarySet = 0; binarySet < SET_LENGTH; binarySet++ ) {
            Set<T> subset = new HashSet<>();
            for( int bit = 0; bit < element.length; bit++ ) {
                int mask = 1 << bit;
                if( (binarySet & mask) != 0 ) {
                    subset.add(element[bit]);
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
	
}
