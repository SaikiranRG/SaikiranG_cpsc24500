package jtax;
import java.util.Scanner;

public class JLIncomeTaxCalculator {
	
	/*CPSC 24500-001- Object-Oriented Programming
	 * Assignment 2 - IncomeTax Calculator
	 * This program calculates the Income tax for the employee income based on below
	 * Tax Slabs - 0 to 4000 J$ - Tax free
	 * 10% tax on next $1500
	 * 20% tax on next J$28000
	 * 40% on the remaining amount
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int incomeTax = 0;
		//Get Employee Name & salary in J$
		
		System.out.print("Enter the Employee Full Name: ");
		String empName = sc.nextLine();	
		
		System.out.print("Enter the Employee Income in Javean Dollar(J$):");
		double empIncome = sc.nextDouble();
		//Precise the income to discard the fraction values 
		int income = (int) empIncome;
		
		//calculate Income tax
		 if(income < 0)
		 {
			 System.out.println("Invalid input, income should be zero or more");
		 }
		 else
		 {
			// System.out.print("Calculate");
			
			 if (income > 4000) {
		            int taxableIncome = income - 4000;

		            if (taxableIncome > 1500) {
		            	incomeTax += 1500 * 0.10; // Tax for the first 1500
		                taxableIncome -= 1500;

		                if (taxableIncome > 28000) 
		                {
		                	incomeTax += 28000 * 0.20; // Tax for the next 28000
		                    taxableIncome -= 28000;
		                    incomeTax += taxableIncome * 0.40; // Tax for the remaining
		                }
		                else {
		                	incomeTax += taxableIncome * 0.20; // Tax for the amount between 1500 to 28000
		                }
		            } else {
		            	incomeTax += taxableIncome * 0.10; // Tax for the income between 4000 to 5500
		            }
			 }
			 
			 System.out.printf("Employee %s with Income %.2f has to pay the Incometax of J$%d ",empName, empIncome, incomeTax);
			 }
		 
		
	}
}
