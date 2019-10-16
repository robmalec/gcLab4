package co.grandcircus;

import java.util.Scanner;

public class Lab4 {
	static int numColWidth = -1, sqColWidth = -1, cuColWidth = -1, minColWidth = 8;
	public static void main(String[] args) {
		Boolean done = false;
		Scanner scn = new Scanner(System.in);
		int num = -1;
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
					done = false;
				}
				else if (resp != 'y') {
					throw new Exception();
				}
				
			}
			catch (Exception e)
			{
				System.out.println("I'm sorry Sean, I'm afraid you can't do that.");
				scn.nextLine();
			}
		} while (done == false);
	}
	public static void makeHeader() {
		
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
