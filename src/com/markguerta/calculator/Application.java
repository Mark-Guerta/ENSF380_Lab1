/**
* <h1 > Application.java </h1 >
* <p>
* This class is designed for processing calculator functions in Java.
* It is part of Lab 1 Exercise C.
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
	// Calculator program
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args.length == 3) {
				// Displays the math operation from CLI.
				System.out.println(args[0] + args[1] + args[2]);
				// Converts values to doubles
				double a = Double.parseDouble(args[0]);
				double b = Double.parseDouble(args[2]);
				// Determines operation based on operation sign from args[1].
				if (args[1].equals("+"))
					System.out.println("The answer is " + add(a, b));
				else if (args[1].equals("-"))
					System.out.println("The answer is " + sub(a, b));
				else if (args[1].equals("*"))
					System.out.println("The answer is " + mul(a, b));
				else if (args[1].equals("/"))
					// Throws exceptions when dividing by zero.
					if (div(a, b) == 0)
						throw new IllegalArgumentException("The answer is undefined. Input a different expression.");
					else
						System.out.println("The answer is " + div(a, b));
				else
					// If the operation cannot be found
					throw new IllegalArgumentException("No valid operation found, check spacing or format of the expression.");
			}
			else {
				// Performs factorial operation
				// Check if factorial is present
				if (args[0].indexOf('!') >= 0) {
					// Displays expression
					System.out.println(args[0]);
					// Performs factorial function by removing '!' and converting the rest of the string to a double.
					System.out.println("The answer is " + factorial(Double.parseDouble(args[0].replace("!", ""))));
				}
				else
					// If the operation cannot be found
					throw new IllegalArgumentException("No valid operation found, check spacing or format of the expression.");

			}
		}
		else {
			// Provides user with instructions through prompts.
			// Scans for user input for variable x, y then math operation.
			// Converts number strings to doubles
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the first variable: ");
			double x = scanner.nextDouble();
			System.out.println("Enter the second variable (type 00 for no second variable when using factorial): ");
			// Determines if the second input is a number or not existing for factorial operation
			String check = scanner.next();
			// Converts number strings to doubles
			double y = Double.parseDouble(check);
			System.out.println("Enter an operation (add, sub, mul, div, factorial):");
			String operation = scanner.next();
			scanner.close();
			if (check.equals("00"))
				System.out.println(x + operation);
			else
				System.out.println(x + operation + check);
			
			// Based on the operation choose, the requested operation is performed:
			// Calls addition function
			if (operation.equals("add") && !(check.equals("00")))
				System.out.println("The answer is " + add(x, y));
			// Calls subtraction function
			else if (operation.equals("sub") && !(check.equals("00")))
				System.out.println("The answer is " + sub(x, y));
			// Calls multiplication function
			else if (operation.equals("mul") && !(check.equals("00")))
				System.out.println("The answer is " + mul(x, y));
			// Calls division function
			else if (operation.equals("div") && !(check.equals("00")))
				// If division by 0 occurs, an exception will be thrown.
				if (div(x, y) == 0)
					throw new IllegalArgumentException("The answer is undefined. Input a different expression.");
				else
					System.out.println("The answer is " + div(x, y));
			// Calls factorial function
			else if (operation.equals("factorial"))
				System.out.println("The answer is " + factorial(x));
			// Throws exception when the user does not input an existing function.
			else
				throw new IllegalArgumentException("Invalid Function. Please try again and choose from the operation list (add, sub, mul, div, factorial).");
		}
		
	}
	// Utilizes double parameters to calculate addition and returns a double sum.
	public static double add(double a, double b) {
		return a + b;
	}
	// Utilizes double parameters to calculate subtraction and returns a double difference.
	public static double sub(double c, double d) {
		return c - d;
	}
	// Utilizes double parameters to calculate multiplication and returns a double product.
	public static double mul(double e, double f) {
		return e * f;
	}
	// Utilizes double parameters to calculate division and returns a double quotient. Also checks for a zero divisor and issues an exception.
	public static double div(double g, double h) {
		if (h == 0)
			return 0;
		else
			return g/h;
	}
	// Utilizes a double parameter and returns a double factorial answer. Utilizes recursion to process the operation.
	public static double factorial(double n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
}
