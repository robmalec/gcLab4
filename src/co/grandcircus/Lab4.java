package co.grandcircus;

import java.util.Scanner;

public class Lab4 {
	static int numColWidth = -1, sqColWidth = -1, cuColWidth = -1, minColWidth = 8;
	public static void main(String[] args) {
		Boolean done = false;
		final Scanner scn = new Scanner(System.in);
		int num = -1;
		int seanCounter = 0;
		
		do
		{
			try {
				System.out.println("Enter an integer:");
				String temp = scn.nextLine();
				num = Integer.parseInt(temp);
								
				//Finding width of columns
				numColWidth = getColWidth(num);
				sqColWidth = getColWidth((int)Math.pow((double)num, 2.0));
				cuColWidth = getColWidth((int)Math.pow((double)num, 3.0));
				
				//Printing out header
				String numLabel = "Number", sqLabel = "Squared", cuLabel = "Cubed";
				System.out.println(numLabel + getRemWhitespace(numLabel, numColWidth) + 
						sqLabel + getRemWhitespace(sqLabel, sqColWidth) +
						cuLabel + getRemWhitespace(cuLabel, cuColWidth));
				
				String equalsSigns = "";
				for (int i = 0; i < (numColWidth + sqColWidth + cuColWidth); i++) {
					equalsSigns += "=";
				}
				System.out.println(equalsSigns);

				//Calculating and printing numbers
				for (int i = 1; i <= num; i++) {
					calcAndPrintLine(i);
				}
				
				System.out.println("Continue? (y/n)");
				char resp = scn.next().charAt(0);
				if (resp == 'n') {
					done = true;
				}
				else if (resp != 'y') {
					throw new Exception();
				}
				scn.nextLine();
			}
			catch (Exception e){
				seanCounter++;
				yellAtSean(seanCounter);
				scn.nextLine();
			}
			int z = 0;
		} while (done == false);
		System.out.println("Goodbye.");
	}
	
	public static void yellAtSean(int seanCounter) {
		String whining = "";
		switch (seanCounter) {
		case 1:
			whining = "I'm sorry Sean, I'm afraid you can't do that.";
			break;
		case 2:
			whining = "Come on now.  Get your " + genRandChars(4) + " together.";
			break;
		case 3:
			whining = "Seriously?  You think this is funny or something?";
			break;
		default:
			whining = genRandChars((int)Math.pow(2.0, (double) seanCounter));
			for (int i = 0; i < seanCounter; i++) {
				whining += "!";
			}
			break;
		}
		System.out.println(whining);
	}
	
	public static String genRandChars(int length) {
		String retString = "";
		for (int i = 0; i < length; i++) {
			int thisChar = 33 + (int) (Math.random() * 14.0);
			retString += ((char) thisChar);
		}
		return retString;
	}
	
	public static void calcAndPrintLine(int num) {
		int squared = (int)Math.pow(num, 2.0), cubed = (int)Math.pow(num, 3.0);
		System.out.println(num + getRemWhitespace(num, numColWidth) + squared + getRemWhitespace(squared, sqColWidth) + cubed + getRemWhitespace(cubed, cuColWidth));
	}
	public static int getColWidth(int i)
	{
		int l = String.valueOf(i).length();
		if (l > minColWidth) {
			return l;
		}
		else {
			return minColWidth;
		}
	}
	public static String getRemWhitespace(int number, int width) {
		return getRemWhitespace(String.valueOf(number), width);
		/*int numSpaces = (width - String.valueOf(number).length());
		String spaces = "";
		for (int i = 0; i < numSpaces; i++)
		{
			spaces += " ";
		}
		return spaces;*/
	}
	public static String getRemWhitespace(String input, int width) {
		int numSpaces = (width - input.length());
		String spaces = "";
		for (int i = 0; i < numSpaces; i++) {
			spaces += " ";
		}
		return spaces;
	}
}
