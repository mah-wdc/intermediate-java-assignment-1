/*
 * Matthew Homan
 * CMIS 242 7382
 * March 27, 2023
 * Project 1
 */

//Weight Class for all Weight Objects
public class Weight {

	//Initialize variables
	private final int OUNCES_IN_A_POUND = 16;
	private int pounds;
	private double ounces;

	//Constructor
	public Weight (int pounds, double ounces) {

		this.pounds = pounds;
		this.ounces = ounces;

		//Call normalize to ensure there are not more ounces than 15
		normalize();
	}

	//getPounds method which calls toOunces in order to be able to perform necessary math
	public double getPounds() {
		double convertedOunces = 0;
		convertedOunces = toOunces();
		return convertedOunces;
	}

	//Normal getters and setters for other variables
	public void setPounds(int pounds) {
		this.pounds = pounds;
	}

	public double getOunces() {
		return ounces;
	}

	public void setOunces(double ounces) {
		this.ounces = ounces;
	}

	//toOunces which converts pounds to ounces
	private double toOunces () {
		return (pounds * OUNCES_IN_A_POUND) + ounces;
	}
	
	//normalize method to ensure there are not more ounces than 15
	private void normalize () {
		//do-while loop to reduce ounces to under 16 while adding to pounds
		do {
			if (ounces >= OUNCES_IN_A_POUND) {
				pounds++;
				ounces = ounces - OUNCES_IN_A_POUND;
			} 
		} while (ounces >= OUNCES_IN_A_POUND);	
	}
	
	//lessThan method to find the smallest weight
	public boolean lessThan (Weight weight) {
		
		//if-else statements to compare two objects' pounds and then ounces
        if (this.pounds < weight.pounds) {
            return true;
        }
        else if (this.pounds > weight.pounds) {
            return false;
        }
        else {
            if (this.ounces < weight.ounces) {
                return true;
            }
            else {
                return false;
            }
        }
	}
	
	//addTo method to sum multiple weights
	public void addTo (Weight weight) {

		this.pounds = this.pounds + weight.pounds;
        this.ounces = this.ounces + weight.ounces;
  
        //normalize is added here to change averageWeight into a normalized figure for output
        normalize();
		
	}
	
	//toString method for printing pounds and ounces
	public String toString () {

		return pounds + " pounds and " + String.format("%.2f", ounces) + " ounces.";

	}
}
