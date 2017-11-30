import java.util.*;

public abstract class Pet {
	protected String name = "No Name";
	protected int birthyear = 2010;
	
	//default constructor
	protected Pet() {}
	//constructor
	protected Pet(String petName, int birthYear) {
		this.setName(petName);
		this.setBirthyear(birthYear);
	}
	
	/*-----------------------------------------------------
	 * getName
	 *     This method returns the name.
	 * Parameters: none.
	 ------------------------------------------------------*/
	public String getName() {
		return name;
	}
	
	/*-----------------------------------------------------
	 * getBirthyear
	 *     This method returns birthyear.
	 * Parameters: none. 
	 ------------------------------------------------------*/
	public int getBirthyear() {
		return birthyear;
	}
	
	/*-----------------------------------------------------
	 * setName
	 *     This method sets the name.
	 * Parameters: name (String)
	 ------------------------------------------------------*/
	public void setName(String name) {
		if(name != null && name.length() > 0)
			this.name = name;
	}
	
	/*-----------------------------------------------------
	 * setBirthyear
	 *     This method sets the birthyear.
	 * Parameters: birthyear (int)
	 ------------------------------------------------------*/
	public void setBirthyear(int birthyear) {
		if(birthyear >= 1990 && birthyear <= 2017)
			this.birthyear = birthyear;
	}
	
	/*-----------------------------------------------------
	 * calcAge
	 *     This method calculates the age of the pet.
	 * Parameters: none
	 ------------------------------------------------------*/
	public int calcAge() {
		Calendar calendar = new GregorianCalendar();
		int currentyear = calendar.get(Calendar.YEAR);
		return currentyear - birthyear;
	}
	
	/*-----------------------------------------------------
	 * convertYears
	 *     This ABSTRACT method will convert the pet's age 
	 *     to human's.
	 ------------------------------------------------------*/
	public abstract int convertYears();
	
	/*-----------------------------------------------------
	 * speak
	 *     This ABSTRACT method will show how the pet speaks 
	 ------------------------------------------------------*/
	public abstract String speak();
	
	/*-----------------------------------------------------
	 * toString
	 *     This method displays the info of the pets.
	 ------------------------------------------------------*/
	@Override 
	public String toString() {
		StringBuilder output = new StringBuilder("Pet: name=");
		output.append(getName());
		output.append(", birth year=");
		output.append(getBirthyear());
		return output.toString();
	}	
}
