
/**
 * Amanda Silvera
 * JHU.605.421
 * PA2-Main
 * /

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class PA2main{

	public static Scanner scan1, scan2;
	
	
	public static void main(String[] args) throws IOException
	{
		Integer[] aElements = {1, 1, 1, 4, 5, 7};
		Integer[] bElements = {2, 2, 1, 8, 4, 9};
		Character[] xElements = {'a', 'b', 'c', 'd', 'e', 'f'};
		Character[] yElements = {'U', 'V', 'W', 'X', 'Y', 'Z'};
		Q2<Integer> IntAB = new Q2<Integer>();
		Q2<Character> CharAB = new Q2<Character>();
		
		IntAB.multiPush(aElements, bElements);
		CharAB.multiPush(xElements, yElements);
		
		scan1 = new Scanner(System.in);
		char Cin;
		//char Cobj;
		int menuInput, obj;// User menu selection
		boolean cont;
		if(IntAB.empty() == false){
		do{
			cont = false;
		System.out.println(   "(1) Push Integer onto Stack A\n"
							+ "(2) Push Integer onto Stack B\n"
							+ "(3) Pop Integer from Stack A\n"
							+ "(4) Pop Integer from Stack B\n"
							+ "(5) Transfer Integer from Stack\n"
							+ "(6) Print a Stack\n"
							+ "Please select from the following menu options and input the corresponding number: ") ;
							
		menuInput = scan1.nextInt();
		switch(menuInput){
		case 1:
			System.out.print("Element to push on Stack A: ");
			obj = scan1.nextInt();
			/*Cobj = scan1.next().charAt(0);*/
			IntAB.PushA(obj);
			//CharAB.PushA(Cobj);
			System.out.println("\n" + obj + " has been pushed on to Stack A." );
			scan1.reset();
			break;
		case 2:
			System.out.print("Element to push on Stack B: ");
			obj = scan1.nextInt();
			/*Cobj = scan1.next().charAt(0);*/
			IntAB.PushB(obj);
			//CharAB.PushB(Cobj);
			System.out.println("\n" + obj + " has been pushed on to Stack B." );
			scan1.reset();
			break;
		case 3:
			System.out.print("Number of Pops from A: ");
			obj = scan1.nextInt();
			System.out.println("\nThe following " + obj + " elements have been popped from Stack A." );
			IntAB.MultiPopA(obj);
			//CharAB.MultiPopA(Cobj);
			scan1.reset();
			break;
		case 4:
			System.out.print("Number of Pops from B: ");
			obj = scan1.nextInt();
			System.out.println("\nThe following " + obj + " elements have been popped from Stack B." );
			IntAB.MultiPopB(obj);
			//CharAB.MultiPopB(Cobj);
			scan1.reset();
			break;
		case 5:
			System.out.print("Select a pop Stack(A/B): ");
			Cin = scan1.next().charAt(0);
			scan1.reset();
			System.out.println("Select the number of elements to transfer: ");
			obj = scan1.nextInt();
			System.out.print("\n");
			IntAB.Transfer(Cin, obj);
			//CharAB.Transfer(Cin, obj);
			System.out.print("\n");
			printSelect(IntAB, Cin);
			//printSelect(CharAB, Cin);
			break;
		case 6:
			System.out.print("Select a stack to print(A/B): ");
			Cin = scan1.next().charAt(0);
			printSelect(IntAB, Cin);
			//printSelect(CharAB, Cin);
			break;
		default:
			System.out.println("Invalid Menu Selection\n");
			break;
		}
		scan1.reset();
		System.out.print("Would you like to make another menu selection?(Y/N): ");
		Cin = scan1.next().charAt(0);
		cont = userAnswer(Cin);
		}while(cont == true);
		IntAB.endQ2();
		scan1.close();
	/** Checks the users input for a Yes or No char
	 * and returns a boolean values or error message
	 * asking for a new input.
	 */}
	}
	public static void printSelect(Q2<Integer> ab, char c){
		if(c == 'A'){
			ab.printS(ab.getStackA());
		}else{
			if(c == 'B'){
				ab.printS(ab.getStackB());
			}else{
				System.out.println("Incorrect Selection\n");
			}
		}
	}
		public static boolean userAnswer(char a){
			scan2 = new Scanner(System.in);
			boolean b = false, isValid = false;
			do{
				if((a == 'Y') || (a == 'y')){
					b = true;
					isValid = true;
				}else{
					if((a == 'N') || (a =='n')){
						b = false;
						isValid = true;
					}else{
						System.out.println("Invalid Input, please select Y or N: ");
						a = scan2.next().charAt(0);
					}
				}
			}while(isValid == false);
			return b;
		}
}


