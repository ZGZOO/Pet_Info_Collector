//Name of program:              Pets Info Printer
//Programmer's name:            Zhijie Xu
//Current Date:                 11/29/2017
//Computer system and compiler: MacOS Sierra and JDK8
//Description:                  This Java program prints out the info of the pets.
//Variable names:               1. petArray (class scope), the array of Pet objects
//							   2. numOfSDogs (class scope), the number of small sized dogs

import java.util.*;

public class PetsDriver {
	public static void main(String [] args) {
//		Pet [] petArray = new Pet[]{
//									new Dog("Doby Doberman", 2009, 7, 'L'),
//									new Cat("Calico Cat", 2006, true),
//									new Dog("banjo dog", 2008, 2, 'm'),
//									new Cat("FRAIDY CAT", 2010, false)};
		Pet[] petArray = makeArray();
		toSortArray(petArray);
		printer(petArray);
		int numOfSDogs = numOfSmallDogs(petArray);
		if(numOfSDogs >= 0)
			System.out.println("\n\nThere is/are " + numOfSDogs + " small dog(s)");
		else if(numOfSDogs == -1)
			System.out.println("\n\nNo Dogs in the list");	
	}
	
	/*-----------------------------------------------------
	 * makeArray
	 *     This method makes an array of Pet objects 
	 *     (contains Dog & Cat).
	 * Parameters: none
	 ------------------------------------------------------*/
	public static Pet[] makeArray(){
		System.out.print("Enter number of pets: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while(i < 1 || i > 10) {
			System.out.println("Enter only between 1 ~ 10. Thanks!");
			System.out.print("Enter number of pets: ");
			i = sc.nextInt();
		}
		Pet[] array = new Pet[i];
		int numOfPets = array.length;
		for(int m = 0; m < numOfPets; m++) {
			Pet somePets = readAndParseInput();
			if (somePets == null)
			{
				m--;
				continue;
			}
			array[m] = somePets;
		}
		return array;
	}
	
	/*-----------------------------------------------------
	 * readAndParseInput
	 *     This method reads into the info of the pets 
	 *     and parses it.
	 * Parameters: none
	 ------------------------------------------------------*/
	public static Pet readAndParseInput() {
		Pet somePet = null;

		System.out.print("Enter pet info, separated by commas: ");
		Scanner sc = new Scanner(System.in);
		String longInfo = sc.nextLine();
			
		StringTokenizer st = new StringTokenizer(longInfo, ",");
		String[] tokens = new String[st.countTokens()];
		for(int j = 0; st.hasMoreTokens(); j++) {
			tokens[j] = st.nextToken();
		}
			
		if(tokens[0].toUpperCase().equals("DOG")) {
			try {
				int year = Integer.parseInt(tokens[2]);
				int tricks = Integer.parseInt(tokens[3]);
				char size = tokens[4].charAt(0);
				somePet = new Dog(tokens[1], year, tricks, size);
			}
			catch(Exception e) {
				System.out.println("Dog info is wrong. Please enter again~");
				somePet = null;
			}	
		}else if(tokens[0].toUpperCase().equals("CAT")) {
			try {
				int year = Integer.parseInt(tokens[2]);
				boolean indoor = Boolean.parseBoolean(tokens[3]);
				somePet = new Cat(tokens[1], year, indoor);
			}
			catch(Exception e) {
				System.out.println("Cat info is wrong. Please enter again~");
				somePet = null;
			}
		}
		return somePet;
	}
	
	/*--------------------------------------------------------
	 * toSortArray
	 *     This method sorts the array by name alphabetically.
	 * Parameters: array (Pet[])
	 ---------------------------------------------------------*/
	public static void toSortArray(Pet[] array) {
		boolean flag = true;
		Pet temp;
		while(flag) {
			flag = false;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].getName().compareToIgnoreCase(array[i+1].getName()) > 0) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					flag = true;
				}
			}
		}	
	}
	
	/*-----------------------------------------------------
	 * printer
	 *     This method prints the whole info of the pets.
	 * Parameters: array (Pet[])
	 ------------------------------------------------------*/
	public static void printer(Pet[] array) {
		System.out.print("\n");
		for(Pet myPets : array) {
			System.out.println(myPets.toString());
			System.out.println("    Human Years = " + myPets.convertYears() 
												    + ", Says " + myPets.speak());
		}
	}
	
	/*-----------------------------------------------------
	 * numOfSmallDogs
	 *     This method returns the number of the small
	 *     sized dogs.
	 * Parameters: array (Pet[])
	 ------------------------------------------------------*/
	public static int numOfSmallDogs(Pet[] array) {
		int num = 0;
		int hasDog = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] instanceof Dog) {
				++hasDog;
				Dog doggy = (Dog)array[i];
				if(doggy.getSize() == 'S') 
					++num;
			}
		}
		if(hasDog == 0) {
			num = -1;
		}
		return num;
	}	
}

/* 
Enter number of pets: 11
Enter only between 1 ~ 10. Thanks!
Enter number of pets: 0
Enter only between 1 ~ 10. Thanks!
Enter number of pets: 2
Enter pet info, separated by commas: cat,Wild Cat,2016,false
Enter pet info, separated by commas: cat,bubu,ttr,true
Cat info is wrong. Please enter again~
Enter pet info, separated by commas: CAT,kissy kitten,2017,true

Cat Pet: name=kissy kitten, birth year=2017, Indoor
    Human Years = 0, Says meow-purr
Cat Pet: name=Wild Cat, birth year=2016, Not Indoor
    Human Years = 15, Says MEOW-hiss


No Dogs in the list
*/
/* 
Enter number of pets: 3
Enter pet info, separated by commas: Dog,Tuffy Terrier,2017,ttr,S
Dog info is wrong. Please enter again~
Enter pet info, separated by commas: Dog,Tuffy Terrier,2017,ttr,S
Dog info is wrong. Please enter again~
Enter pet info, separated by commas: Dog,Tuffy Terrier,2017,4,S
Enter pet info, separated by commas: Cat,PURR Kitten,2015,true
Enter pet info, separated by commas: Cat,Zip Cat,2014,false

Cat Pet: name=PURR Kitten, birth year=2015, Indoor
    Human Years = 24, Says meow-purr
Dog Pet: name=Tuffy Terrier, birth year=2017, # tricks=4, size=S
    Human Years = 0, Says Woof Woof Woof Woof 
Cat Pet: name=Zip Cat, birth year=2014, Not Indoor
    Human Years = 28, Says MEOW-hiss


There is/are 1 small dog(s)
*/
/*
Enter number of pets: 6
Enter pet info, separated by commas: Dog,Tuffy Terrier,2017,4,S
Enter pet info, separated by commas: Cat,PURR Kitten,2015,true
Enter pet info, separated by commas: Dog,Sparky Dalmatian,2016,6,M
Enter pet info, separated by commas: Cat,Zip Cat,2014,false
Enter pet info, separated by commas: Cat,amber tabby,2009,true
Enter pet info, separated by commas: Dog,tiny chihuahua,2015,8,s

Cat Pet: name=amber tabby, birth year=2009, Indoor
    Human Years = 48, Says meow-purr
Cat Pet: name=PURR Kitten, birth year=2015, Indoor
    Human Years = 24, Says meow-purr
Dog Pet: name=Sparky Dalmatian, birth year=2016, # tricks=6, size=M
    Human Years = 12, Says Woof Woof Woof Woof Woof Woof 
Dog Pet: name=tiny chihuahua, birth year=2015, # tricks=8, size=S
    Human Years = 24, Says Woof Woof Woof Woof Woof Woof Woof Woof 
Dog Pet: name=Tuffy Terrier, birth year=2017, # tricks=4, size=S
    Human Years = 0, Says Woof Woof Woof Woof 
Cat Pet: name=Zip Cat, birth year=2014, Not Indoor
    Human Years = 28, Says MEOW-hiss


There is/are 2 small dog(s)
*/