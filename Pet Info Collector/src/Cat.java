
public class Cat extends Pet{
	private boolean indoor;
	
	//default constructor
	public Cat() {}
	//constructor
	public Cat(String petName, int birthYear, boolean indoor) {
		super(petName, birthYear);
		this.setIndoor(indoor);
	}
	
	/*-----------------------------------------------------
	 * getIndoor
	 *     This method returns the boolean indoor.
	 * Parameters: none
	 ------------------------------------------------------*/
	public boolean getIndoor() {
		return indoor;
	}
	
	/*-----------------------------------------------------
	 * setIndoor
	 *     This method sets the boolean indoor.
	 * Parameters: indoor (boolean)
	 ------------------------------------------------------*/
	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}
	
	/*-----------------------------------------------------
	 * convertYears
	 *     This method converts the pet's age to human's.
	 * Parameters: none
	 ------------------------------------------------------*/
	public int convertYears() {
		int realAge = super.calcAge();
		int humanYears = 0;
		if(realAge == 1) {
			humanYears = 15;
		}else if(realAge == 2) {
			humanYears = 24;
		}else if(realAge > 2) {
			humanYears = (realAge - 2) * 4 + 24;
		}
		return humanYears;
	}
	
	/*-----------------------------------------------------
	 * speak
	 *     This method shows how cats speaks.
	 * Parameters: none
	 ------------------------------------------------------*/
	public String speak() {
		String speak;
		if(indoor) {
			speak = "meow-purr";
		}else {
			speak = "MEOW-hiss";
		}
		return speak;
	}
	
	/*-----------------------------------------------------
	 * toString
	 *     This method displays the info of cats.
	 ------------------------------------------------------*/
	public String toString() {
		StringBuilder output = new StringBuilder("Cat ");
		output.append(super.toString());
		if(indoor)
			output.append(", Indoor");
		else
			output.append(", Not Indoor");
		return output.toString();
	}	
}
