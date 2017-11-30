
public class Dog extends Pet{
	private int numOfTricks;
	private char size;
	
	//default constructor
	public Dog() {}
	//constructor
	public Dog(String petName, int birthYear, int numOfTricks, char size) {
		super(petName, birthYear);
		this.setTricksNum(numOfTricks);
		this.setSize(size);
	}
	
	/*-----------------------------------------------------
	 * getTricksNum
	 *     This method gets the number of the tricks the dog 
	 *     can do.
	 * Parameters: none
	 ------------------------------------------------------*/
	public int getTricksNum() {
		return numOfTricks;
	}
	
	/*-----------------------------------------------------
	 * getSize
	 *     This method gets the size of the dog.
	 * Parameters: none
	 ------------------------------------------------------*/
	public char getSize() {
		return size;
	}
	
	/*-----------------------------------------------------
	 * setTricksNum
	 *     This method sets the number of the tricks.
	 * Parameters: numOfTricks (int)
	 ------------------------------------------------------*/
	public void setTricksNum(int numOfTricks) {
		this.numOfTricks = numOfTricks;
	}
	
	/*-----------------------------------------------------
	 * setSize
	 *     This method sets the size of the dog.
	 * Parameters: size (char)
	 ------------------------------------------------------*/
	public void setSize(char size) {
		if(Character.toUpperCase(size) != 'S' 
				&& Character.toUpperCase(size) != 'M' 
				&& Character.toUpperCase(size) != 'L') {
			this.size = 'M';
		}else {
			this.size = Character.toUpperCase(size);
		}
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
			humanYears = 12;
		}else if(realAge == 2) {
			humanYears = 24;
		}else if(realAge > 2) {
			humanYears = (realAge - 2) * 5 + 24;
		}
		return humanYears;
	}
	
	/*-----------------------------------------------------
	 * speak
	 *     This method shows how dogs speaks.
	 * Parameters: none
	 ------------------------------------------------------*/
	public String speak() {
		String speak = "Woof";
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < this.numOfTricks; i++) {
			result.append(speak);
			result.append(" ");
		}
		return result.toString();	
	}
	
	/*-----------------------------------------------------
	 * toString
	 *     This method displays the info of dogs.
	 ------------------------------------------------------*/
	public String toString() {
		StringBuilder output = new StringBuilder("Dog ");
		output.append(super.toString());
		output.append(", # tricks=");
		output.append(getTricksNum());
		output.append(", size=");
		output.append(getSize());
		return output.toString();
	}
}
