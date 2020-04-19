package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import data.Attribute;
import data.Object;
import data.Source;
import data.Value;
import data.Observation;

public class FileAction {
	
	public void readFile() {
		try {
		      File myObj = new File("filename.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Erreur sur le chemin du fichier");
		    }
	}
	
	public void writeFile(String name,List<String> data) {
		try {
		      FileWriter myWriter = new FileWriter(name);
		      
		      for (String line : data) {
		    	  myWriter.write(line+"\n");
		      }
		      myWriter.close();
		      System.out.println("Successfully wrote to the file. Name of file : "+name);
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	
	/*
	 * This methode help us to get the data from a CSV file.
	 * The data in the CSV should be in the format :
	 * (idObservation,descriptionObservation,idObject,descriptionObject,idAttribue,descriptionAttrubute,idSource,descriptionSource)
	 * She return a liste of value.
	 */
	public Set<Observation> getData(String filename) {
		
		Set<Observation> data = new HashSet<>();
		
		/*-------------Test data from article 1 (Start) ------------*/
		Object o1 = new Object(1,"Test 1") ; 
		Attribute a1 =new Attribute(1,"Provide the set of prime numbers smaller than 10.");
		Attribute a2 =new Attribute(2,"What is the capital city of Romania?");
		
		Object o2 = new Object(2,"Test 2") ;
		Attribute a3 =new Attribute(3,"Give a natural numberxsatisfyingxmod 4=0.");
		Attribute a4 =new Attribute(4,"What is the largest country in the European Union?");
		
		Source s1 = new Source(1,"Student 1");
		Source s2 = new Source(2,"Student 2");
		Source s3 = new Source(3,"Student 3");
		
		Value v1 = new Value(1,"{2,3,5,7}");
		Value v2 = new Value(2,"Budapest");
		Value v3 = new Value(3,"{2,4,6,8}");
		Value v4 = new Value(4,"Bucharest");
		Value v5 = new Value(5,"Belgrade");
		Value v6 = new Value(6,"24");
		Value v7 = new Value(7,"Spain");
		Value v8 = new Value(8,"26");
		Value v9 = new Value(9,"France");
		Value v10 = new Value(10,"41");
		
		Observation ob1 = new Observation(1, s1,o1,a1,v1);
		data.add(ob1);
		
		Observation ob2 = new Observation(2, s1,o1,a2,v2);
		data.add(ob2);
		
		Observation ob3 = new Observation(3,s2,o1,a1,v3);
		data.add(ob3);
		
		Observation ob4 = new Observation(4, s2,o1,a2,v4);
		data.add(ob4);
		
		Observation ob5 = new Observation(5, s3,o1,a1,v1);
		data.add(ob5);
		
		Observation ob6 = new Observation(6,s3,o1,a2,v5);
		data.add(ob6);
		
		
		Observation ob7 = new Observation(7, s1,o2,a3,v6);
		data.add(ob7);
		
		Observation ob8 = new Observation(8, s1,o2,a4,v7);
		data.add(ob8);
		
		Observation ob9 = new Observation(9, s2,o2,a3,v8);
		data.add(ob9);
		
		Observation ob10 = new Observation(10, s2,o2,a4,v9);
		data.add(ob10);
		
		Observation ob11 = new Observation(11,s3,o2,a3,v10);
		data.add(ob11);
		
		Observation ob12 = new Observation(12, s3,o2,a4,v9);
		data.add(ob12);
		/*-------------Test data from article 1 (Start) ------------*/
		
		return data;
	}
}
