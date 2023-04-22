/*
 * Matthew Homan
 * CMIS 242 7382
 * March 27, 2023
 * Project 1
 */

public class Project1 {

	//findMinimum method to find and return minimum weight
	private static Weight findMinimum (Weight weight1, Weight weight2, Weight weight3) {
		
		//if-else statements to determine if weight1, weight2, or weight3 is smallest
		if ((weight1.lessThan(weight2)) && (weight1.lessThan(weight3))) {
            return weight1;
		} 
		else if ((weight2.lessThan(weight1)) && (weight2.lessThan(weight3))) {
            return weight2;
		}
        else {
            return weight3;
        }
	}
	
	//findMaximum method to find and return maximum weight
	private static Weight findMaximum (Weight weight1, Weight weight2, Weight weight3) {
		
		//if-else statements to determine if weight1, weight2, or weight3 is largest
		if ((!weight1.lessThan(weight2)) && (!weight1.lessThan(weight3))) {
            return weight1;
		}
        else if ((!weight2.lessThan(weight1)) && (!weight2.lessThan(weight3))) {
            return weight2;
        }
        else {
            return weight3;
        }
	}
	
	//findAverage method to find and return average weight
	private static Weight findAverage (Weight weight1, Weight weight2, Weight weight3) {
		
		//Initialize variables
		double average;
		int numOfObjects = 0;
		
		//Create averageWeight object
		Weight averageWeight = new Weight(0, 0);

		//Add all weights to averageWeight 
        averageWeight.addTo(weight1);
        numOfObjects++;
        averageWeight.addTo(weight2);
        numOfObjects++;
        averageWeight.addTo(weight3);
        numOfObjects++;

        //Calculate average which will return a value of ounces
        average = averageWeight.getPounds() / numOfObjects;
        
        //Prepare averageWeight to be normalized with new average
        averageWeight.setPounds(0);
        averageWeight.setOunces(average);
        
        //Create temp object 
        Weight temp = new Weight(0, 0);
        
        //Call addTo method with averageWeight object to force normalization
        averageWeight.addTo(temp);
        
        return averageWeight;
	}
	
	//main method
	public static void main(String[] args) {
		
		//Create objects
		Weight weight1 = new Weight(11, 3);
		Weight weight2 = new Weight(7, 20); 
		Weight weight3 = new Weight(14, 6);
		
		//Print proof of object creation
		System.out.println("Created weight1 with " + weight1.toString());
		System.out.println("Created weight2 with " + weight2.toString());
		System.out.println("Created weight3 with " + weight3.toString());
		
		//Call findMinimum
		Weight minimumWeight = findMinimum(weight1, weight2, weight3);
		System.out.println("\nThe minimum weight is " + minimumWeight.toString());
		
		//Call findMaximum
		Weight maximumWeight = findMaximum(weight1, weight2, weight3);
		System.out.println("\nThe maximum weight is " + maximumWeight.toString());
		
		//Call findAverage
		Weight averageWeight = findAverage(weight1, weight2, weight3);
		System.out.println("\nThe average weight is " + averageWeight.toString());
	}
}
