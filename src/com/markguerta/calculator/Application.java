/**
* <h1 > Application.java </h1 >
* <p>
* This class is designed for displaying "Hello, World!" in Java.
* It is part of Lab 1 Exercise A 2.6.
* </p>
*
* <p><b> Submission Date :</b> June 2, 2024 </p>
*
* @author Mark Guerta
* @version 1.0
*/
package com.markguerta.calculator;
import java.util.Scanner;
public class Application {
	public static void main(String[] args) {
		if (args.length > 0) {
			
		}
		else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter operation (e.g. add, sub, mul, div, factorial):");
			String operation = scanner.next();
			double x = Double.parseDouble(args[0]);
			double y = 0;
			if (args.length == 1)
				 y = Double.parseDouble(args[1]);
			if (operation == "add")
				System.out.println("The answer is " + add(x, y));
			else if (operation == "sub")
				System.out.println("The answer is " + sub(x, y));
			else if (operation == "mul")
				System.out.println("The answer is " + mul(x, y));
			else if (operation == "div")
				if (div(x,y) == 0)
					System.out.println("The answer is undefined");
				else
					System.out.println("The answer is " + div(x, y));
			else if (operation == "factorial")
				System.out.println("The answer is " + factorial(x));
			scanner.close();
		}
		
	}
	
	public static double add(double a, double b) {
		return a + b;
	}
	
	public static double sub(double c, double d) {
		return c - d;
	}
	
	public static double mul(double e, double f) {
		return e * f;
	}
	
	public static double div(double g, double h) {
		if (h == 0)
			return 0;
		else
			return g/h;
	}
	
	public static double factorial(double n) {
		if (n <= 1)
			return 1;
		else {
			return n * factorial(n - 1);
		}
	}
	
}
